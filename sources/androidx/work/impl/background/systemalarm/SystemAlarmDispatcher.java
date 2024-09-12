package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import android.os.PowerManager;
import android.text.TextUtils;
import androidx.work.Logger;
import androidx.work.impl.ExecutionListener;
import androidx.work.impl.Processor;
import androidx.work.impl.StartStopTokens;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.model.WorkGenerationalId;
import androidx.work.impl.utils.WakeLocks;
import androidx.work.impl.utils.WorkTimer;
import androidx.work.impl.utils.taskexecutor.SerialExecutor;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

public class SystemAlarmDispatcher implements ExecutionListener {
    private static final int DEFAULT_START_ID = 0;
    private static final String KEY_START_ID = "KEY_START_ID";
    private static final String PROCESS_COMMAND_TAG = "ProcessCommand";
    static final String TAG = Logger.tagWithPrefix("SystemAlarmDispatcher");
    final CommandHandler mCommandHandler;
    private CommandsCompletedListener mCompletedListener;
    final Context mContext;
    Intent mCurrentIntent;
    final List<Intent> mIntents;
    private final Processor mProcessor;
    private StartStopTokens mStartStopTokens;
    final TaskExecutor mTaskExecutor;
    private final WorkManagerImpl mWorkManager;
    private final WorkTimer mWorkTimer;

    interface CommandsCompletedListener {
        void onAllCommandsCompleted();
    }

    SystemAlarmDispatcher(Context context) {
        this(context, (Processor) null, (WorkManagerImpl) null);
    }

    SystemAlarmDispatcher(Context context, Processor processor, WorkManagerImpl workManagerImpl) {
        Context applicationContext = context.getApplicationContext();
        this.mContext = applicationContext;
        this.mStartStopTokens = new StartStopTokens();
        this.mCommandHandler = new CommandHandler(applicationContext, this.mStartStopTokens);
        workManagerImpl = workManagerImpl == null ? WorkManagerImpl.getInstance(context) : workManagerImpl;
        this.mWorkManager = workManagerImpl;
        this.mWorkTimer = new WorkTimer(workManagerImpl.getConfiguration().getRunnableScheduler());
        processor = processor == null ? workManagerImpl.getProcessor() : processor;
        this.mProcessor = processor;
        this.mTaskExecutor = workManagerImpl.getWorkTaskExecutor();
        processor.addExecutionListener(this);
        this.mIntents = new ArrayList();
        this.mCurrentIntent = null;
    }

    /* access modifiers changed from: package-private */
    public void onDestroy() {
        Logger.get().debug(TAG, "Destroying SystemAlarmDispatcher");
        this.mProcessor.removeExecutionListener(this);
        this.mCompletedListener = null;
    }

    public void onExecuted(WorkGenerationalId workGenerationalId, boolean z) {
        this.mTaskExecutor.getMainThreadExecutor().execute(new AddRunnable(this, CommandHandler.createExecutionCompletedIntent(this.mContext, workGenerationalId, z), 0));
    }

    public boolean add(Intent intent, int i) {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Adding command " + intent + " (" + i + ")");
        assertMainThread();
        String action = intent.getAction();
        boolean z = false;
        if (TextUtils.isEmpty(action)) {
            Logger.get().warning(str, "Unknown command. Ignoring");
            return false;
        } else if ("ACTION_CONSTRAINTS_CHANGED".equals(action) && hasIntentWithAction("ACTION_CONSTRAINTS_CHANGED")) {
            return false;
        } else {
            intent.putExtra(KEY_START_ID, i);
            synchronized (this.mIntents) {
                if (!this.mIntents.isEmpty()) {
                    z = true;
                }
                this.mIntents.add(intent);
                if (!z) {
                    processCommand();
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public void setCompletedListener(CommandsCompletedListener commandsCompletedListener) {
        if (this.mCompletedListener != null) {
            Logger.get().error(TAG, "A completion listener for SystemAlarmDispatcher already exists.");
        } else {
            this.mCompletedListener = commandsCompletedListener;
        }
    }

    /* access modifiers changed from: package-private */
    public Processor getProcessor() {
        return this.mProcessor;
    }

    /* access modifiers changed from: package-private */
    public WorkTimer getWorkTimer() {
        return this.mWorkTimer;
    }

    /* access modifiers changed from: package-private */
    public WorkManagerImpl getWorkManager() {
        return this.mWorkManager;
    }

    /* access modifiers changed from: package-private */
    public TaskExecutor getTaskExecutor() {
        return this.mTaskExecutor;
    }

    /* access modifiers changed from: package-private */
    public void dequeueAndCheckForCompletion() {
        Logger logger = Logger.get();
        String str = TAG;
        logger.debug(str, "Checking if commands are complete.");
        assertMainThread();
        synchronized (this.mIntents) {
            if (this.mCurrentIntent != null) {
                Logger.get().debug(str, "Removing command " + this.mCurrentIntent);
                if (this.mIntents.remove(0).equals(this.mCurrentIntent)) {
                    this.mCurrentIntent = null;
                } else {
                    throw new IllegalStateException("Dequeue-d command is not the first.");
                }
            }
            SerialExecutor serialTaskExecutor = this.mTaskExecutor.getSerialTaskExecutor();
            if (!this.mCommandHandler.hasPendingCommands() && this.mIntents.isEmpty() && !serialTaskExecutor.hasPendingTasks()) {
                Logger.get().debug(str, "No more commands & intents.");
                CommandsCompletedListener commandsCompletedListener = this.mCompletedListener;
                if (commandsCompletedListener != null) {
                    commandsCompletedListener.onAllCommandsCompleted();
                }
            } else if (!this.mIntents.isEmpty()) {
                processCommand();
            }
        }
    }

    private void processCommand() {
        assertMainThread();
        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(this.mContext, PROCESS_COMMAND_TAG);
        try {
            newWakeLock.acquire();
            this.mWorkManager.getWorkTaskExecutor().executeOnTaskThread(new Runnable() {
                public void run() {
                    DequeueAndCheckForCompletion dequeueAndCheckForCompletion;
                    Executor executor;
                    synchronized (SystemAlarmDispatcher.this.mIntents) {
                        SystemAlarmDispatcher systemAlarmDispatcher = SystemAlarmDispatcher.this;
                        systemAlarmDispatcher.mCurrentIntent = systemAlarmDispatcher.mIntents.get(0);
                    }
                    if (SystemAlarmDispatcher.this.mCurrentIntent != null) {
                        String action = SystemAlarmDispatcher.this.mCurrentIntent.getAction();
                        int intExtra = SystemAlarmDispatcher.this.mCurrentIntent.getIntExtra(SystemAlarmDispatcher.KEY_START_ID, 0);
                        Logger.get().debug(SystemAlarmDispatcher.TAG, "Processing command " + SystemAlarmDispatcher.this.mCurrentIntent + ", " + intExtra);
                        PowerManager.WakeLock newWakeLock = WakeLocks.newWakeLock(SystemAlarmDispatcher.this.mContext, action + " (" + intExtra + ")");
                        try {
                            Logger.get().debug(SystemAlarmDispatcher.TAG, "Acquiring operation wake lock (" + action + ") " + newWakeLock);
                            newWakeLock.acquire();
                            SystemAlarmDispatcher.this.mCommandHandler.onHandleIntent(SystemAlarmDispatcher.this.mCurrentIntent, intExtra, SystemAlarmDispatcher.this);
                            Logger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + action + ") " + newWakeLock);
                            newWakeLock.release();
                            executor = SystemAlarmDispatcher.this.mTaskExecutor.getMainThreadExecutor();
                            dequeueAndCheckForCompletion = new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this);
                        } catch (Throwable th) {
                            Logger.get().debug(SystemAlarmDispatcher.TAG, "Releasing operation wake lock (" + action + ") " + newWakeLock);
                            newWakeLock.release();
                            SystemAlarmDispatcher.this.mTaskExecutor.getMainThreadExecutor().execute(new DequeueAndCheckForCompletion(SystemAlarmDispatcher.this));
                            throw th;
                        }
                        executor.execute(dequeueAndCheckForCompletion);
                    }
                }
            });
        } finally {
            newWakeLock.release();
        }
    }

    private boolean hasIntentWithAction(String str) {
        assertMainThread();
        synchronized (this.mIntents) {
            for (Intent action : this.mIntents) {
                if (str.equals(action.getAction())) {
                    return true;
                }
            }
            return false;
        }
    }

    private void assertMainThread() {
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Needs to be invoked on the main thread.");
        }
    }

    static class DequeueAndCheckForCompletion implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;

        DequeueAndCheckForCompletion(SystemAlarmDispatcher systemAlarmDispatcher) {
            this.mDispatcher = systemAlarmDispatcher;
        }

        public void run() {
            this.mDispatcher.dequeueAndCheckForCompletion();
        }
    }

    static class AddRunnable implements Runnable {
        private final SystemAlarmDispatcher mDispatcher;
        private final Intent mIntent;
        private final int mStartId;

        AddRunnable(SystemAlarmDispatcher systemAlarmDispatcher, Intent intent, int i) {
            this.mDispatcher = systemAlarmDispatcher;
            this.mIntent = intent;
            this.mStartId = i;
        }

        public void run() {
            this.mDispatcher.add(this.mIntent, this.mStartId);
        }
    }
}
