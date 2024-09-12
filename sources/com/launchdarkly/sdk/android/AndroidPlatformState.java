package com.launchdarkly.sdk.android;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.android.PlatformState;
import com.reactnativecommunity.netinfo.BroadcastReceiverConnectivityReceiver;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicBoolean;

final class AndroidPlatformState implements PlatformState {
    private final Application application;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<PlatformState.ConnectivityChangeListener> connectivityChangeListeners = new CopyOnWriteArrayList<>();
    private final ConnectivityReceiver connectivityReceiver;
    /* access modifiers changed from: private */
    public final AtomicBoolean foreground;
    /* access modifiers changed from: private */
    public final CopyOnWriteArrayList<PlatformState.ForegroundChangeListener> foregroundChangeListeners = new CopyOnWriteArrayList<>();
    private final Application.ActivityLifecycleCallbacks lifecycleCallbacks;
    /* access modifiers changed from: private */
    public final LDLogger logger;
    /* access modifiers changed from: private */
    public volatile boolean paused;
    /* access modifiers changed from: private */
    public final TaskExecutor taskExecutor;

    interface TestApplicationForegroundStateOverride {
        boolean isTestFixtureInitiallyInForeground();
    }

    public AndroidPlatformState(Application application2, TaskExecutor taskExecutor2, LDLogger lDLogger) {
        boolean z = false;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.foreground = atomicBoolean;
        this.paused = true;
        this.application = application2;
        this.taskExecutor = taskExecutor2;
        this.logger = lDLogger;
        ConnectivityReceiver connectivityReceiver2 = new ConnectivityReceiver();
        this.connectivityReceiver = connectivityReceiver2;
        application2.registerReceiver(connectivityReceiver2, new IntentFilter(BroadcastReceiverConnectivityReceiver.CONNECTIVITY_ACTION));
        if (application2 instanceof TestApplicationForegroundStateOverride) {
            atomicBoolean.set(((TestApplicationForegroundStateOverride) application2).isTestFixtureInitiallyInForeground());
        } else {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            atomicBoolean.set((runningAppProcessInfo.importance == 100 || runningAppProcessInfo.importance == 200) ? true : z);
        }
        ActivityCallbacks activityCallbacks = new ActivityCallbacks();
        this.lifecycleCallbacks = activityCallbacks;
        application2.registerActivityLifecycleCallbacks(activityCallbacks);
    }

    public boolean isNetworkAvailable() {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.application.getSystemService("connectivity");
            if (Build.VERSION.SDK_INT >= 23) {
                Network activeNetwork = connectivityManager.getActiveNetwork();
                if (activeNetwork == null) {
                    return false;
                }
                NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork);
                if (networkCapabilities != null) {
                    if (networkCapabilities.hasTransport(1) || networkCapabilities.hasTransport(0) || networkCapabilities.hasTransport(3) || networkCapabilities.hasTransport(2)) {
                        return true;
                    }
                    if (networkCapabilities.hasTransport(4)) {
                        return true;
                    }
                }
                return false;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                return false;
            }
            return true;
        } catch (SecurityException unused) {
            return true;
        }
    }

    public void addConnectivityChangeListener(PlatformState.ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListeners.add(connectivityChangeListener);
    }

    public void removeConnectivityChangeListener(PlatformState.ConnectivityChangeListener connectivityChangeListener) {
        this.connectivityChangeListeners.remove(connectivityChangeListener);
    }

    public boolean isForeground() {
        return this.foreground.get();
    }

    public void addForegroundChangeListener(PlatformState.ForegroundChangeListener foregroundChangeListener) {
        this.foregroundChangeListeners.add(foregroundChangeListener);
    }

    public void removeForegroundChangeListener(PlatformState.ForegroundChangeListener foregroundChangeListener) {
        this.foregroundChangeListeners.remove(foregroundChangeListener);
    }

    public File getCacheDir() {
        return this.application.getCacheDir();
    }

    public void close() {
        this.connectivityChangeListeners.clear();
        this.foregroundChangeListeners.clear();
        this.application.unregisterReceiver(this.connectivityReceiver);
        this.application.unregisterActivityLifecycleCallbacks(this.lifecycleCallbacks);
    }

    private final class ConnectivityReceiver extends BroadcastReceiver {
        static final String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";
        private boolean knownState;
        private boolean lastState;

        private ConnectivityReceiver() {
            this.knownState = false;
            this.lastState = false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
            r3 = com.launchdarkly.sdk.android.AndroidPlatformState.access$200(r1.this$0).iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0032, code lost:
            if (r3.hasNext() == false) goto L_0x003e;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
            ((com.launchdarkly.sdk.android.PlatformState.ConnectivityChangeListener) r3.next()).onConnectivityChanged(r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onReceive(android.content.Context r2, android.content.Intent r3) {
            /*
                r1 = this;
                java.lang.String r2 = "android.net.conn.CONNECTIVITY_CHANGE"
                java.lang.String r3 = r3.getAction()
                boolean r2 = r2.equals(r3)
                if (r2 != 0) goto L_0x000d
                return
            L_0x000d:
                monitor-enter(r1)
                com.launchdarkly.sdk.android.AndroidPlatformState r2 = com.launchdarkly.sdk.android.AndroidPlatformState.this     // Catch:{ all -> 0x003f }
                boolean r2 = r2.isNetworkAvailable()     // Catch:{ all -> 0x003f }
                boolean r3 = r1.knownState     // Catch:{ all -> 0x003f }
                if (r3 == 0) goto L_0x001e
                boolean r3 = r1.lastState     // Catch:{ all -> 0x003f }
                if (r3 != r2) goto L_0x001e
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                return
            L_0x001e:
                r3 = 1
                r1.knownState = r3     // Catch:{ all -> 0x003f }
                r1.lastState = r2     // Catch:{ all -> 0x003f }
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                com.launchdarkly.sdk.android.AndroidPlatformState r3 = com.launchdarkly.sdk.android.AndroidPlatformState.this
                java.util.concurrent.CopyOnWriteArrayList r3 = r3.connectivityChangeListeners
                java.util.Iterator r3 = r3.iterator()
            L_0x002e:
                boolean r0 = r3.hasNext()
                if (r0 == 0) goto L_0x003e
                java.lang.Object r0 = r3.next()
                com.launchdarkly.sdk.android.PlatformState$ConnectivityChangeListener r0 = (com.launchdarkly.sdk.android.PlatformState.ConnectivityChangeListener) r0
                r0.onConnectivityChanged(r2)
                goto L_0x002e
            L_0x003e:
                return
            L_0x003f:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x003f }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.AndroidPlatformState.ConnectivityReceiver.onReceive(android.content.Context, android.content.Intent):void");
        }
    }

    private final class ActivityCallbacks implements Application.ActivityLifecycleCallbacks {
        private static final int WAIT_AFTER_PAUSED_MILLIS = 500;
        private volatile ScheduledFuture<?> deferredOnPauseTask;

        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        public void onActivityDestroyed(Activity activity) {
        }

        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public void onActivityStarted(Activity activity) {
        }

        public void onActivityStopped(Activity activity) {
        }

        private ActivityCallbacks() {
            this.deferredOnPauseTask = null;
        }

        public void onActivityResumed(Activity activity) {
            boolean unused = AndroidPlatformState.this.paused = false;
            if (AndroidPlatformState.this.foreground.getAndSet(true)) {
                AndroidPlatformState.this.logger.debug("activity resumed while already in foreground");
                return;
            }
            AndroidPlatformState.this.logger.debug("activity resumed, we are now in foreground");
            AndroidPlatformState.this.taskExecutor.scheduleTask(new AndroidPlatformState$ActivityCallbacks$$ExternalSyntheticLambda1(this), 0);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onActivityResumed$0$com-launchdarkly-sdk-android-AndroidPlatformState$ActivityCallbacks  reason: not valid java name */
        public /* synthetic */ void m446lambda$onActivityResumed$0$comlaunchdarklysdkandroidAndroidPlatformState$ActivityCallbacks() {
            Iterator it = AndroidPlatformState.this.foregroundChangeListeners.iterator();
            while (it.hasNext()) {
                ((PlatformState.ForegroundChangeListener) it.next()).onForegroundChanged(true);
            }
        }

        public void onActivityPaused(Activity activity) {
            if (AndroidPlatformState.this.foreground.get()) {
                boolean unused = AndroidPlatformState.this.paused = true;
                if (this.deferredOnPauseTask != null) {
                    this.deferredOnPauseTask.cancel(false);
                }
                AndroidPlatformState.this.logger.debug("activity paused; waiting to see if another activity resumes");
                this.deferredOnPauseTask = AndroidPlatformState.this.taskExecutor.scheduleTask(new AndroidPlatformState$ActivityCallbacks$$ExternalSyntheticLambda0(this), 500);
            }
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$onActivityPaused$1$com-launchdarkly-sdk-android-AndroidPlatformState$ActivityCallbacks  reason: not valid java name */
        public /* synthetic */ void m445lambda$onActivityPaused$1$comlaunchdarklysdkandroidAndroidPlatformState$ActivityCallbacks() {
            if (AndroidPlatformState.this.paused && AndroidPlatformState.this.foreground.getAndSet(false)) {
                AndroidPlatformState.this.logger.debug("went background");
                Iterator it = AndroidPlatformState.this.foregroundChangeListeners.iterator();
                while (it.hasNext()) {
                    ((PlatformState.ForegroundChangeListener) it.next()).onForegroundChanged(false);
                }
            }
        }
    }
}
