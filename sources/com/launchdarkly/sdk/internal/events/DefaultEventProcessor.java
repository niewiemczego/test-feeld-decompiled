package com.launchdarkly.sdk.internal.events;

import com.google.gson.Gson;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.internal.events.Event;
import com.launchdarkly.sdk.internal.events.EventSender;
import com.launchdarkly.sdk.internal.events.EventSummarizer;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public final class DefaultEventProcessor implements Closeable, EventProcessor {
    private static final int INITIAL_OUTPUT_BUFFER_SIZE = 2000;
    /* access modifiers changed from: private */
    public static final Gson gson = new Gson();
    private final AtomicBoolean closed;
    private ScheduledFuture<?> contextKeysFlushTask;
    private final AtomicBoolean diagnosticInitSent = new AtomicBoolean(false);
    private ScheduledFuture<?> eventFlushTask;
    private final EventsConfiguration eventsConfig;
    private final AtomicBoolean inBackground;
    private final BlockingQueue<EventProcessorMessage> inbox;
    private volatile boolean inputCapacityExceeded;
    private final LDLogger logger;
    private final AtomicBoolean offline;
    private ScheduledFuture<?> periodicDiagnosticEventTask;
    private final ScheduledExecutorService scheduler;
    private final Object stateLock;

    private interface EventResponseListener {
        void handleResponse(EventSender.Result result);
    }

    private enum MessageType {
        EVENT,
        FLUSH,
        FLUSH_USERS,
        DIAGNOSTIC_INIT,
        DIAGNOSTIC_STATS,
        SYNC,
        SHUTDOWN
    }

    public DefaultEventProcessor(EventsConfiguration eventsConfiguration, ScheduledExecutorService scheduledExecutorService, int i, LDLogger lDLogger) {
        EventsConfiguration eventsConfiguration2 = eventsConfiguration;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.closed = atomicBoolean;
        this.stateLock = new Object();
        this.inputCapacityExceeded = false;
        this.eventsConfig = eventsConfiguration2;
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(eventsConfiguration2.capacity);
        this.inbox = arrayBlockingQueue;
        this.scheduler = scheduledExecutorService;
        this.logger = lDLogger;
        AtomicBoolean atomicBoolean2 = new AtomicBoolean(eventsConfiguration2.initiallyInBackground);
        this.inBackground = atomicBoolean2;
        AtomicBoolean atomicBoolean3 = new AtomicBoolean(eventsConfiguration2.initiallyOffline);
        this.offline = atomicBoolean3;
        new EventDispatcher(eventsConfiguration, scheduledExecutorService, i, arrayBlockingQueue, atomicBoolean2, atomicBoolean3, atomicBoolean, lDLogger);
        updateScheduledTasks(eventsConfiguration2.initiallyInBackground, eventsConfiguration2.initiallyOffline);
        if (eventsConfiguration2.contextDeduplicator != null && eventsConfiguration2.contextDeduplicator.getFlushInterval() != null) {
            this.contextKeysFlushTask = enableOrDisableTask(true, (ScheduledFuture<?>) null, eventsConfiguration2.contextDeduplicator.getFlushInterval().longValue(), MessageType.FLUSH_USERS);
        }
    }

    public void sendEvent(Event event) {
        if (!this.closed.get()) {
            postMessageAsync(MessageType.EVENT, event);
        }
    }

    public void flushAsync() {
        if (!this.closed.get()) {
            postMessageAsync(MessageType.FLUSH, (Event) null);
        }
    }

    public void flushBlocking() {
        if (!this.closed.get()) {
            postMessageAndWait(MessageType.FLUSH, (Event) null);
        }
    }

    public void setInBackground(boolean z) {
        synchronized (this.stateLock) {
            if (this.inBackground.getAndSet(z) != z) {
                updateScheduledTasks(z, this.offline.get());
            }
        }
    }

    public void setOffline(boolean z) {
        synchronized (this.stateLock) {
            if (this.offline.getAndSet(z) != z) {
                updateScheduledTasks(this.inBackground.get(), z);
            }
        }
    }

    public void close() throws IOException {
        if (this.closed.compareAndSet(false, true)) {
            synchronized (this.stateLock) {
                this.eventFlushTask = enableOrDisableTask(false, this.eventFlushTask, 0, (MessageType) null);
                this.contextKeysFlushTask = enableOrDisableTask(false, this.contextKeysFlushTask, 0, (MessageType) null);
                this.periodicDiagnosticEventTask = enableOrDisableTask(false, this.periodicDiagnosticEventTask, 0, (MessageType) null);
            }
            postMessageAsync(MessageType.FLUSH, (Event) null);
            postMessageAndWait(MessageType.SHUTDOWN, (Event) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void updateScheduledTasks(boolean z, boolean z2) {
        this.eventFlushTask = enableOrDisableTask(!z2, this.eventFlushTask, this.eventsConfig.flushIntervalMillis, MessageType.FLUSH);
        this.periodicDiagnosticEventTask = enableOrDisableTask(!z2 && !z && this.eventsConfig.diagnosticStore != null, this.periodicDiagnosticEventTask, this.eventsConfig.diagnosticRecordingIntervalMillis, MessageType.DIAGNOSTIC_STATS);
        if (!z && !z2 && !this.diagnosticInitSent.get() && this.eventsConfig.diagnosticStore != null) {
            postMessageAsync(MessageType.DIAGNOSTIC_INIT, (Event) null);
        }
    }

    /* access modifiers changed from: package-private */
    public ScheduledFuture<?> enableOrDisableTask(boolean z, ScheduledFuture<?> scheduledFuture, long j, MessageType messageType) {
        if (!z) {
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            return null;
        } else if (scheduledFuture != null) {
            return scheduledFuture;
        } else {
            return this.scheduler.scheduleAtFixedRate(postMessageRunnable(messageType, (Event) null), j, j, TimeUnit.MILLISECONDS);
        }
    }

    /* access modifiers changed from: package-private */
    public void waitUntilInactive() throws IOException {
        postMessageAndWait(MessageType.SYNC, (Event) null);
    }

    /* access modifiers changed from: package-private */
    public void postDiagnostic() {
        postMessageAsync(MessageType.DIAGNOSTIC_STATS, (Event) null);
    }

    /* access modifiers changed from: private */
    public void postMessageAsync(MessageType messageType, Event event) {
        postToChannel(new EventProcessorMessage(messageType, event, false));
    }

    private void postMessageAndWait(MessageType messageType, Event event) {
        EventProcessorMessage eventProcessorMessage = new EventProcessorMessage(messageType, event, true);
        if (postToChannel(eventProcessorMessage)) {
            eventProcessorMessage.waitForCompletion();
        }
    }

    private Runnable postMessageRunnable(final MessageType messageType, final Event event) {
        return new Runnable() {
            public void run() {
                DefaultEventProcessor.this.postMessageAsync(messageType, event);
            }
        };
    }

    private boolean postToChannel(EventProcessorMessage eventProcessorMessage) {
        if (this.inbox.offer(eventProcessorMessage)) {
            return true;
        }
        boolean z = this.inputCapacityExceeded;
        this.inputCapacityExceeded = true;
        if (z) {
            return false;
        }
        this.logger.warn("Events are being produced faster than they can be processed; some events will be dropped");
        return false;
    }

    private static final class EventProcessorMessage {
        /* access modifiers changed from: private */
        public final Event event;
        private final Semaphore reply;
        /* access modifiers changed from: private */
        public final MessageType type;

        private EventProcessorMessage(MessageType messageType, Event event2, boolean z) {
            this.type = messageType;
            this.event = event2;
            this.reply = z ? new Semaphore(0) : null;
        }

        /* access modifiers changed from: package-private */
        public void completed() {
            Semaphore semaphore = this.reply;
            if (semaphore != null) {
                semaphore.release();
            }
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Can't wrap try/catch for region: R(4:3|4|6|5) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0005 */
        /* JADX WARNING: Removed duplicated region for block: B:3:0x0005 A[LOOP:0: B:3:0x0005->B:4:?, LOOP_START, SYNTHETIC, Splitter:B:3:0x0005] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void waitForCompletion() {
            /*
                r1 = this;
                java.util.concurrent.Semaphore r0 = r1.reply
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.util.concurrent.Semaphore r0 = r1.reply     // Catch:{ InterruptedException -> 0x0005 }
                r0.acquire()     // Catch:{ InterruptedException -> 0x0005 }
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventProcessorMessage.waitForCompletion():void");
        }
    }

    static final class EventDispatcher {
        private static final int MESSAGE_BATCH_SIZE = 50;
        private final AtomicInteger busyFlushWorkersCount;
        private final AtomicBoolean closed;
        private final EventContextDeduplicator contextDeduplicator;
        private long deduplicatedUsers;
        final DiagnosticStore diagnosticStore;
        /* access modifiers changed from: private */
        public final AtomicBoolean didSendInitEvent;
        private final AtomicBoolean disabled;
        final EventsConfiguration eventsConfig;
        private final List<SendEventsTask> flushWorkers;
        private final AtomicBoolean inBackground;
        private final BlockingQueue<EventProcessorMessage> inbox;
        private final AtomicLong lastKnownPastTime;
        /* access modifiers changed from: private */
        public final LDLogger logger;
        private final AtomicBoolean offline;
        private final ExecutorService sharedExecutor;

        private EventDispatcher(EventsConfiguration eventsConfiguration, ExecutorService executorService, int i, BlockingQueue<EventProcessorMessage> blockingQueue, AtomicBoolean atomicBoolean, AtomicBoolean atomicBoolean2, AtomicBoolean atomicBoolean3, LDLogger lDLogger) {
            EventsConfiguration eventsConfiguration2 = eventsConfiguration;
            final BlockingQueue<EventProcessorMessage> blockingQueue2 = blockingQueue;
            LDLogger lDLogger2 = lDLogger;
            this.lastKnownPastTime = new AtomicLong(0);
            this.disabled = new AtomicBoolean(false);
            this.didSendInitEvent = new AtomicBoolean(false);
            this.deduplicatedUsers = 0;
            this.eventsConfig = eventsConfiguration2;
            this.inbox = blockingQueue2;
            this.inBackground = atomicBoolean;
            this.offline = atomicBoolean2;
            this.closed = atomicBoolean3;
            this.sharedExecutor = executorService;
            this.diagnosticStore = eventsConfiguration2.diagnosticStore;
            this.busyFlushWorkersCount = new AtomicInteger(0);
            this.logger = lDLogger2;
            final int i2 = i;
            AnonymousClass1 r10 = new ThreadFactory() {
                public Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable);
                    thread.setDaemon(true);
                    thread.setName(String.format("LaunchDarkly-event-delivery-%d", new Object[]{Long.valueOf(thread.getId())}));
                    thread.setPriority(i2);
                    return thread;
                }
            };
            final ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(1);
            final EventBuffer eventBuffer = new EventBuffer(eventsConfiguration2.capacity, lDLogger2);
            this.contextDeduplicator = eventsConfiguration2.contextDeduplicator;
            Thread newThread = r10.newThread(new Thread() {
                public void run() {
                    EventDispatcher.this.runMainLoop(blockingQueue2, eventBuffer, arrayBlockingQueue);
                }
            });
            newThread.setDaemon(true);
            newThread.setUncaughtExceptionHandler(new DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda0(this));
            newThread.start();
            this.flushWorkers = new ArrayList();
            DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1 defaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1 = new DefaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1(this);
            for (int i3 = 0; i3 < eventsConfiguration2.eventSendingThreadPoolSize; i3++) {
                this.flushWorkers.add(new SendEventsTask(eventsConfiguration, defaultEventProcessor$EventDispatcher$$ExternalSyntheticLambda1, arrayBlockingQueue, this.busyFlushWorkersCount, r10, lDLogger));
            }
        }

        /* access modifiers changed from: private */
        public void onUncaughtException(Thread thread, Throwable th) {
            this.logger.error("Event processor thread was terminated by an unrecoverable error. No more analytics events will be sent. {} {}", LogValues.exceptionSummary(th), LogValues.exceptionTrace(th));
            this.closed.set(true);
            ArrayList<EventProcessorMessage> arrayList = new ArrayList<>();
            this.inbox.drainTo(arrayList);
            for (EventProcessorMessage completed : arrayList) {
                completed.completed();
            }
        }

        /* access modifiers changed from: private */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:1|2|(4:5|6|30|3)|35|33) */
        /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a0, code lost:
            r5.logger.error("Unexpected error in event processor: {}", (java.lang.Object) r1.toString());
            r5.logger.debug(r1.toString(), (java.lang.Object) r1);
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:1:0x0007 */
        /* JADX WARNING: Removed duplicated region for block: B:1:0x0007 A[LOOP:0: B:1:0x0007->B:33:0x0007, LOOP_START, SYNTHETIC, Splitter:B:1:0x0007] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void runMainLoop(java.util.concurrent.BlockingQueue<com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventProcessorMessage> r6, com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventBuffer r7, java.util.concurrent.BlockingQueue<com.launchdarkly.sdk.internal.events.DefaultEventProcessor.FlushPayload> r8) {
            /*
                r5 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r1 = 50
                r0.<init>(r1)
            L_0x0007:
                r0.clear()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                java.lang.Object r1 = r6.take()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$EventProcessorMessage r1 = (com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventProcessorMessage) r1     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r0.add(r1)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r1 = 49
                r6.drainTo(r0, r1)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                java.util.Iterator r1 = r0.iterator()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
            L_0x001c:
                boolean r2 = r1.hasNext()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r2 == 0) goto L_0x0007
                java.lang.Object r2 = r1.next()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$EventProcessorMessage r2 = (com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventProcessorMessage) r2     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                int[] r3 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.AnonymousClass2.$SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r4 = r2.type     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                int r4 = r4.ordinal()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r3 = r3[r4]     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                switch(r3) {
                    case 1: goto L_0x0093;
                    case 2: goto L_0x0087;
                    case 3: goto L_0x007f;
                    case 4: goto L_0x0057;
                    case 5: goto L_0x0043;
                    case 6: goto L_0x003f;
                    case 7: goto L_0x0038;
                    default: goto L_0x0037;
                }     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
            L_0x0037:
                goto L_0x009a
            L_0x0038:
                r5.doShutdown()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r2.completed()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                return
            L_0x003f:
                r5.waitUntilAllFlushWorkersInactive()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x009a
            L_0x0043:
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.offline     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.inBackground     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                r5.sendAndResetDiagnostics(r7)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x009a
            L_0x0057:
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.offline     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.inBackground     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.didSendInitEvent     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                java.util.concurrent.ExecutorService r3 = r5.sharedExecutor     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                com.launchdarkly.sdk.internal.events.DiagnosticStore r4 = r5.diagnosticStore     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                com.launchdarkly.sdk.internal.events.DiagnosticEvent r4 = r4.getInitEvent()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                java.lang.Runnable r4 = r5.createSendDiagnosticTask(r4)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r3.submit(r4)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x009a
            L_0x007f:
                com.launchdarkly.sdk.internal.events.EventContextDeduplicator r3 = r5.contextDeduplicator     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 == 0) goto L_0x009a
                r3.flush()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x009a
            L_0x0087:
                java.util.concurrent.atomic.AtomicBoolean r3 = r5.offline     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                boolean r3 = r3.get()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                if (r3 != 0) goto L_0x009a
                r5.triggerFlush(r7, r8)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x009a
            L_0x0093:
                com.launchdarkly.sdk.internal.events.Event r3 = r2.event     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                r5.processEvent(r3, r7)     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
            L_0x009a:
                r2.completed()     // Catch:{ InterruptedException -> 0x0007, Exception -> 0x009f }
                goto L_0x001c
            L_0x009f:
                r1 = move-exception
                com.launchdarkly.logging.LDLogger r2 = r5.logger
                java.lang.String r3 = r1.toString()
                java.lang.String r4 = "Unexpected error in event processor: {}"
                r2.error((java.lang.String) r4, (java.lang.Object) r3)
                com.launchdarkly.logging.LDLogger r2 = r5.logger
                java.lang.String r3 = r1.toString()
                r2.debug((java.lang.String) r3, (java.lang.Object) r1)
                goto L_0x0007
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventDispatcher.runMainLoop(java.util.concurrent.BlockingQueue, com.launchdarkly.sdk.internal.events.DefaultEventProcessor$EventBuffer, java.util.concurrent.BlockingQueue):void");
        }

        private void sendAndResetDiagnostics(EventBuffer eventBuffer) {
            if (!this.disabled.get()) {
                DiagnosticEvent createEventAndReset = this.diagnosticStore.createEventAndReset(eventBuffer.getAndClearDroppedCount(), this.deduplicatedUsers);
                this.deduplicatedUsers = 0;
                this.sharedExecutor.submit(createSendDiagnosticTask(createEventAndReset));
            }
        }

        private void doShutdown() {
            waitUntilAllFlushWorkersInactive();
            this.disabled.set(true);
            for (SendEventsTask stop : this.flushWorkers) {
                stop.stop();
            }
            try {
                this.eventsConfig.eventSender.close();
            } catch (IOException e) {
                this.logger.error("Unexpected error when closing event sender: {}", LogValues.exceptionSummary(e));
                this.logger.debug(LogValues.exceptionTrace(e));
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(4:0|1|2|15) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0014, code lost:
            r1 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            throw r1;
         */
        /* JADX WARNING: Missing exception handler attribute for start block: B:0:0x0000 */
        /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:15:0x0000, LOOP_START, MTH_ENTER_BLOCK, SYNTHETIC, Splitter:B:0:0x0000] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private void waitUntilAllFlushWorkersInactive() {
            /*
                r2 = this;
            L_0x0000:
                java.util.concurrent.atomic.AtomicInteger r0 = r2.busyFlushWorkersCount     // Catch:{ InterruptedException -> 0x0000 }
                monitor-enter(r0)     // Catch:{ InterruptedException -> 0x0000 }
                java.util.concurrent.atomic.AtomicInteger r1 = r2.busyFlushWorkersCount     // Catch:{ all -> 0x0014 }
                int r1 = r1.get()     // Catch:{ all -> 0x0014 }
                if (r1 != 0) goto L_0x000d
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                return
            L_0x000d:
                java.util.concurrent.atomic.AtomicInteger r1 = r2.busyFlushWorkersCount     // Catch:{ all -> 0x0014 }
                r1.wait()     // Catch:{ all -> 0x0014 }
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                goto L_0x0000
            L_0x0014:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0014 }
                throw r1     // Catch:{ InterruptedException -> 0x0000 }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.internal.events.DefaultEventProcessor.EventDispatcher.waitUntilAllFlushWorkersInactive():void");
        }

        private void processEvent(Event event, EventBuffer eventBuffer) {
            LDContext context;
            boolean z;
            EventContextDeduplicator eventContextDeduplicator;
            if (!this.disabled.get() && (context = event.getContext()) != null) {
                boolean z2 = false;
                Event.FeatureRequest featureRequest = null;
                boolean z3 = event instanceof Event.FeatureRequest;
                if (z3) {
                    Event.FeatureRequest featureRequest2 = (Event.FeatureRequest) event;
                    eventBuffer.addToSummary(featureRequest2);
                    z = featureRequest2.isTrackEvents();
                    if (shouldDebugEvent(featureRequest2)) {
                        featureRequest = featureRequest2.toDebugEvent();
                    }
                } else {
                    z = true;
                }
                if (!(context == null || context.getFullyQualifiedKey() == null)) {
                    if (z3 || (event instanceof Event.Custom)) {
                        EventContextDeduplicator eventContextDeduplicator2 = this.contextDeduplicator;
                        if (eventContextDeduplicator2 != null && !(z2 = eventContextDeduplicator2.processContext(context))) {
                            this.deduplicatedUsers++;
                        }
                    } else if ((event instanceof Event.Identify) && (eventContextDeduplicator = this.contextDeduplicator) != null) {
                        eventContextDeduplicator.processContext(context);
                    }
                }
                if (z2) {
                    eventBuffer.add(new Event.Index(event.getCreationDate(), event.getContext()));
                }
                if (z) {
                    eventBuffer.add(event);
                }
                if (featureRequest != null) {
                    eventBuffer.add(featureRequest);
                }
            }
        }

        private boolean shouldDebugEvent(Event.FeatureRequest featureRequest) {
            Long debugEventsUntilDate = featureRequest.getDebugEventsUntilDate();
            if (debugEventsUntilDate == null) {
                return false;
            }
            long longValue = debugEventsUntilDate.longValue();
            if (longValue <= 0 || longValue <= this.lastKnownPastTime.get() || longValue <= System.currentTimeMillis()) {
                return false;
            }
            return true;
        }

        private void triggerFlush(EventBuffer eventBuffer, BlockingQueue<FlushPayload> blockingQueue) {
            if (!this.disabled.get() && !eventBuffer.isEmpty()) {
                FlushPayload payload = eventBuffer.getPayload();
                if (this.diagnosticStore != null) {
                    this.diagnosticStore.recordEventsInBatch(payload.events.length + (payload.summary.isEmpty() ^ true ? 1 : 0));
                }
                this.busyFlushWorkersCount.incrementAndGet();
                if (blockingQueue.offer(payload)) {
                    eventBuffer.clear();
                    return;
                }
                this.logger.debug("Skipped flushing because all workers are busy");
                eventBuffer.summarizer.restoreTo(payload.summary);
                synchronized (this.busyFlushWorkersCount) {
                    this.busyFlushWorkersCount.decrementAndGet();
                    this.busyFlushWorkersCount.notify();
                }
            }
        }

        /* access modifiers changed from: private */
        public void handleResponse(EventSender.Result result) {
            if (result.getTimeFromServer() != null) {
                this.lastKnownPastTime.set(result.getTimeFromServer().getTime());
            }
            if (result.isMustShutDown()) {
                this.disabled.set(true);
            }
        }

        private Runnable createSendDiagnosticTask(final DiagnosticEvent diagnosticEvent) {
            return new Runnable() {
                public void run() {
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2000);
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, Charset.forName("UTF-8")), 2000);
                        DefaultEventProcessor.gson.toJson((Object) diagnosticEvent.value, (Appendable) bufferedWriter);
                        bufferedWriter.flush();
                        EventDispatcher.this.handleResponse(EventDispatcher.this.eventsConfig.eventSender.sendDiagnosticEvent(byteArrayOutputStream.toByteArray(), EventDispatcher.this.eventsConfig.eventsUri));
                        if (diagnosticEvent.initEvent) {
                            EventDispatcher.this.didSendInitEvent.set(true);
                        }
                    } catch (Exception e) {
                        EventDispatcher.this.logger.error("Unexpected error in event processor: {}", (Object) e.toString());
                        EventDispatcher.this.logger.debug(e.toString(), (Object) e);
                    }
                }
            };
        }
    }

    /* renamed from: com.launchdarkly.sdk.internal.events.DefaultEventProcessor$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|(3:13|14|16)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|16) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType[] r0 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType = r0
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.EVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.FLUSH     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.FLUSH_USERS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.DIAGNOSTIC_INIT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.DIAGNOSTIC_STATS     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.SYNC     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$internal$events$DefaultEventProcessor$MessageType     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.launchdarkly.sdk.internal.events.DefaultEventProcessor$MessageType r1 = com.launchdarkly.sdk.internal.events.DefaultEventProcessor.MessageType.SHUTDOWN     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.internal.events.DefaultEventProcessor.AnonymousClass2.<clinit>():void");
        }
    }

    private static final class EventBuffer {
        private final int capacity;
        private boolean capacityExceeded = false;
        private long droppedEventCount = 0;
        final List<Event> events = new ArrayList();
        private final LDLogger logger;
        final EventSummarizer summarizer = new EventSummarizer();

        EventBuffer(int i, LDLogger lDLogger) {
            this.capacity = i;
            this.logger = lDLogger;
        }

        /* access modifiers changed from: package-private */
        public void add(Event event) {
            if (this.events.size() >= this.capacity) {
                if (!this.capacityExceeded) {
                    this.capacityExceeded = true;
                    this.logger.warn("Exceeded event queue capacity. Increase capacity to avoid dropping events.");
                }
                this.droppedEventCount++;
                return;
            }
            this.capacityExceeded = false;
            this.events.add(event);
        }

        /* access modifiers changed from: package-private */
        public void addToSummary(Event.FeatureRequest featureRequest) {
            this.summarizer.summarizeEvent(featureRequest.getCreationDate(), featureRequest.getKey(), featureRequest.getVersion(), featureRequest.getVariation(), featureRequest.getValue(), featureRequest.getDefaultVal(), featureRequest.getContext());
        }

        /* access modifiers changed from: package-private */
        public boolean isEmpty() {
            return this.events.isEmpty() && this.summarizer.isEmpty();
        }

        /* access modifiers changed from: package-private */
        public long getAndClearDroppedCount() {
            long j = this.droppedEventCount;
            this.droppedEventCount = 0;
            return j;
        }

        /* access modifiers changed from: package-private */
        public FlushPayload getPayload() {
            List<Event> list = this.events;
            return new FlushPayload((Event[]) list.toArray(new Event[list.size()]), this.summarizer.getSummaryAndReset());
        }

        /* access modifiers changed from: package-private */
        public void clear() {
            this.events.clear();
            this.summarizer.clear();
        }
    }

    private static final class FlushPayload {
        final Event[] events;
        final EventSummarizer.EventSummary summary;

        FlushPayload(Event[] eventArr, EventSummarizer.EventSummary eventSummary) {
            this.events = eventArr;
            this.summary = eventSummary;
        }
    }

    private static final class SendEventsTask implements Runnable {
        private final AtomicInteger activeFlushWorkersCount;
        private final EventsConfiguration eventsConfig;
        private final EventOutputFormatter formatter;
        private final LDLogger logger;
        private final BlockingQueue<FlushPayload> payloadQueue;
        private final EventResponseListener responseListener;
        private final AtomicBoolean stopping = new AtomicBoolean(false);
        private final Thread thread;

        SendEventsTask(EventsConfiguration eventsConfiguration, EventResponseListener eventResponseListener, BlockingQueue<FlushPayload> blockingQueue, AtomicInteger atomicInteger, ThreadFactory threadFactory, LDLogger lDLogger) {
            this.eventsConfig = eventsConfiguration;
            this.formatter = new EventOutputFormatter(eventsConfiguration);
            this.responseListener = eventResponseListener;
            this.payloadQueue = blockingQueue;
            this.activeFlushWorkersCount = atomicInteger;
            this.logger = lDLogger;
            Thread newThread = threadFactory.newThread(this);
            this.thread = newThread;
            newThread.setDaemon(true);
            newThread.start();
        }

        public void run() {
            while (!this.stopping.get()) {
                try {
                    FlushPayload take = this.payloadQueue.take();
                    try {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(2000);
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, Charset.forName("UTF-8")), 2000);
                        int writeOutputEvents = this.formatter.writeOutputEvents(take.events, take.summary, bufferedWriter);
                        bufferedWriter.flush();
                        this.responseListener.handleResponse(this.eventsConfig.eventSender.sendAnalyticsEvents(byteArrayOutputStream.toByteArray(), writeOutputEvents, this.eventsConfig.eventsUri));
                    } catch (Exception e) {
                        this.logger.error("Unexpected error in event processor: {}", LogValues.exceptionSummary(e));
                        this.logger.debug(LogValues.exceptionTrace(e));
                    }
                    synchronized (this.activeFlushWorkersCount) {
                        this.activeFlushWorkersCount.decrementAndGet();
                        this.activeFlushWorkersCount.notifyAll();
                    }
                } catch (InterruptedException unused) {
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void stop() {
            this.stopping.set(true);
            this.thread.interrupt();
        }
    }
}
