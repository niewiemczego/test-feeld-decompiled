package com.launchdarkly.eventsource;

import com.launchdarkly.logging.LDLogger;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

final class AsyncEventHandler implements EventHandler {
    private final EventHandler eventSourceHandler;
    private final Executor executor;
    private final LDLogger logger;
    final Semaphore semaphore;

    AsyncEventHandler(Executor executor2, EventHandler eventHandler, LDLogger lDLogger, Semaphore semaphore2) {
        this.executor = executor2;
        this.eventSourceHandler = eventHandler;
        this.logger = lDLogger;
        this.semaphore = semaphore2;
    }

    public void onOpen() {
        execute(new AsyncEventHandler$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onOpen$0$com-launchdarkly-eventsource-AsyncEventHandler  reason: not valid java name */
    public /* synthetic */ void m610lambda$onOpen$0$comlaunchdarklyeventsourceAsyncEventHandler() {
        try {
            this.eventSourceHandler.onOpen();
        } catch (Exception e) {
            handleUnexpectedError(e);
        }
    }

    public void onClosed() {
        execute(new AsyncEventHandler$$ExternalSyntheticLambda5(this));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onClosed$1$com-launchdarkly-eventsource-AsyncEventHandler  reason: not valid java name */
    public /* synthetic */ void m606lambda$onClosed$1$comlaunchdarklyeventsourceAsyncEventHandler() {
        try {
            this.eventSourceHandler.onClosed();
        } catch (Exception e) {
            handleUnexpectedError(e);
        }
    }

    public void onComment(String str) {
        execute(new AsyncEventHandler$$ExternalSyntheticLambda3(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onComment$2$com-launchdarkly-eventsource-AsyncEventHandler  reason: not valid java name */
    public /* synthetic */ void m607lambda$onComment$2$comlaunchdarklyeventsourceAsyncEventHandler(String str) {
        try {
            this.eventSourceHandler.onComment(str);
        } catch (Exception e) {
            handleUnexpectedError(e);
        }
    }

    public void onMessage(String str, MessageEvent messageEvent) {
        execute(new AsyncEventHandler$$ExternalSyntheticLambda4(this, str, messageEvent));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$onMessage$3$com-launchdarkly-eventsource-AsyncEventHandler  reason: not valid java name */
    public /* synthetic */ void m609lambda$onMessage$3$comlaunchdarklyeventsourceAsyncEventHandler(String str, MessageEvent messageEvent) {
        try {
            this.eventSourceHandler.onMessage(str, messageEvent);
        } catch (Exception e) {
            handleUnexpectedError(e);
        } catch (Throwable th) {
            messageEvent.close();
            throw th;
        }
        messageEvent.close();
    }

    public void onError(Throwable th) {
        execute(new AsyncEventHandler$$ExternalSyntheticLambda2(this, th));
    }

    private void handleUnexpectedError(Throwable th) {
        this.logger.warn("Caught unexpected error from EventHandler: " + th.toString());
        this.logger.debug("Stack trace: {}", (Object) new LazyStackTrace(th));
        m608lambda$onError$4$comlaunchdarklyeventsourceAsyncEventHandler(th);
    }

    /* access modifiers changed from: private */
    /* renamed from: onErrorInternal */
    public void m608lambda$onError$4$comlaunchdarklyeventsourceAsyncEventHandler(Throwable th) {
        try {
            this.eventSourceHandler.onError(th);
        } catch (Throwable th2) {
            this.logger.warn("Caught unexpected error from EventHandler.onError(): " + th2.toString());
            this.logger.debug("Stack trace: {}", (Object) new LazyStackTrace(th));
        }
    }

    private void execute(Runnable runnable) {
        acquire();
        try {
            this.executor.execute(new AsyncEventHandler$$ExternalSyntheticLambda1(this, runnable));
        } catch (Exception e) {
            release();
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$execute$5$com-launchdarkly-eventsource-AsyncEventHandler  reason: not valid java name */
    public /* synthetic */ void m605lambda$execute$5$comlaunchdarklyeventsourceAsyncEventHandler(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            release();
        }
    }

    private void acquire() {
        Semaphore semaphore2 = this.semaphore;
        if (semaphore2 != null) {
            try {
                semaphore2.acquire();
            } catch (InterruptedException e) {
                throw new RejectedExecutionException("Thread interrupted while waiting for event thread semaphore", e);
            }
        }
    }

    private void release() {
        Semaphore semaphore2 = this.semaphore;
        if (semaphore2 != null) {
            semaphore2.release();
        }
    }
}
