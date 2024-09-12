package kotlinx.coroutines.internal;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.DispatchedTask;
import kotlinx.coroutines.EventLoop;
import kotlinx.coroutines.ThreadLocalEventLoop;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a;\u0010\u0003\u001a\u00020\u0004*\u0006\u0012\u0002\b\u00030\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\b\u001aU\u0010\u000e\u001a\u00020\r\"\u0004\b\u0000\u0010\u000f*\b\u0012\u0004\u0012\u0002H\u000f0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u000f0\u00122%\b\u0002\u0010\u0013\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r\u0018\u00010\u0014H\u0007ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a\u0012\u0010\u001a\u001a\u00020\u0004*\b\u0012\u0004\u0012\u00020\r0\u0005H\u0000\"\u0010\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"REUSABLE_CLAIMED", "Lkotlinx/coroutines/internal/Symbol;", "UNDEFINED", "executeUnconfined", "", "Lkotlinx/coroutines/internal/DispatchedContinuation;", "contState", "", "mode", "", "doYield", "block", "Lkotlin/Function0;", "", "resumeCancellableWith", "T", "Lkotlin/coroutines/Continuation;", "result", "Lkotlin/Result;", "onCancellation", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "cause", "(Lkotlin/coroutines/Continuation;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "yieldUndispatched", "kotlinx-coroutines-core"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* compiled from: DispatchedContinuation.kt */
public final class DispatchedContinuationKt {
    public static final Symbol REUSABLE_CLAIMED = new Symbol("REUSABLE_CLAIMED");
    /* access modifiers changed from: private */
    public static final Symbol UNDEFINED = new Symbol("UNDEFINED");

    public static /* synthetic */ void resumeCancellableWith$default(Continuation continuation, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = null;
        }
        resumeCancellableWith(continuation, obj, function1);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (r9.clearThreadContext() != false) goto L_0x00a6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> void resumeCancellableWith(kotlin.coroutines.Continuation<? super T> r7, java.lang.Object r8, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r9) {
        /*
            boolean r0 = r7 instanceof kotlinx.coroutines.internal.DispatchedContinuation
            if (r0 == 0) goto L_0x00cb
            kotlinx.coroutines.internal.DispatchedContinuation r7 = (kotlinx.coroutines.internal.DispatchedContinuation) r7
            java.lang.Object r9 = kotlinx.coroutines.CompletionStateKt.toState((java.lang.Object) r8, (kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>) r9)
            kotlinx.coroutines.CoroutineDispatcher r0 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r1 = r7.getContext()
            boolean r0 = r0.isDispatchNeeded(r1)
            r1 = 1
            if (r0 == 0) goto L_0x0028
            r7._state = r9
            r7.resumeMode = r1
            kotlinx.coroutines.CoroutineDispatcher r8 = r7.dispatcher
            kotlin.coroutines.CoroutineContext r9 = r7.getContext()
            java.lang.Runnable r7 = (java.lang.Runnable) r7
            r8.dispatch(r9, r7)
            goto L_0x00ce
        L_0x0028:
            boolean r0 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            kotlinx.coroutines.ThreadLocalEventLoop r0 = kotlinx.coroutines.ThreadLocalEventLoop.INSTANCE
            kotlinx.coroutines.EventLoop r0 = r0.getEventLoop$kotlinx_coroutines_core()
            boolean r2 = r0.isUnconfinedLoopActive()
            if (r2 == 0) goto L_0x0043
            r7._state = r9
            r7.resumeMode = r1
            kotlinx.coroutines.DispatchedTask r7 = (kotlinx.coroutines.DispatchedTask) r7
            r0.dispatchUnconfined(r7)
            goto L_0x00ce
        L_0x0043:
            r2 = r7
            kotlinx.coroutines.DispatchedTask r2 = (kotlinx.coroutines.DispatchedTask) r2
            r0.incrementUseCount(r1)
            r3 = 0
            kotlin.coroutines.CoroutineContext r4 = r7.getContext()     // Catch:{ all -> 0x00be }
            kotlinx.coroutines.Job$Key r5 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00be }
            kotlin.coroutines.CoroutineContext$Key r5 = (kotlin.coroutines.CoroutineContext.Key) r5     // Catch:{ all -> 0x00be }
            kotlin.coroutines.CoroutineContext$Element r4 = r4.get(r5)     // Catch:{ all -> 0x00be }
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4     // Catch:{ all -> 0x00be }
            if (r4 == 0) goto L_0x007e
            boolean r5 = r4.isActive()     // Catch:{ all -> 0x00be }
            if (r5 != 0) goto L_0x007e
            java.util.concurrent.CancellationException r4 = r4.getCancellationException()     // Catch:{ all -> 0x00be }
            r5 = r4
            java.lang.Throwable r5 = (java.lang.Throwable) r5     // Catch:{ all -> 0x00be }
            r7.cancelCompletedResult$kotlinx_coroutines_core(r9, r5)     // Catch:{ all -> 0x00be }
            r9 = r7
            kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9     // Catch:{ all -> 0x00be }
            kotlin.Result$Companion r5 = kotlin.Result.Companion     // Catch:{ all -> 0x00be }
            java.lang.Throwable r4 = (java.lang.Throwable) r4     // Catch:{ all -> 0x00be }
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)     // Catch:{ all -> 0x00be }
            java.lang.Object r4 = kotlin.Result.m983constructorimpl(r4)     // Catch:{ all -> 0x00be }
            r9.resumeWith(r4)     // Catch:{ all -> 0x00be }
            r9 = r1
            goto L_0x007f
        L_0x007e:
            r9 = 0
        L_0x007f:
            if (r9 != 0) goto L_0x00b7
            kotlin.coroutines.Continuation<T> r9 = r7.continuation     // Catch:{ all -> 0x00be }
            java.lang.Object r4 = r7.countOrElement     // Catch:{ all -> 0x00be }
            kotlin.coroutines.CoroutineContext r5 = r9.getContext()     // Catch:{ all -> 0x00be }
            java.lang.Object r4 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r5, r4)     // Catch:{ all -> 0x00be }
            kotlinx.coroutines.internal.Symbol r6 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch:{ all -> 0x00be }
            if (r4 == r6) goto L_0x0096
            kotlinx.coroutines.UndispatchedCoroutine r9 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r9, r5, r4)     // Catch:{ all -> 0x00be }
            goto L_0x0097
        L_0x0096:
            r9 = r3
        L_0x0097:
            kotlin.coroutines.Continuation<T> r7 = r7.continuation     // Catch:{ all -> 0x00aa }
            r7.resumeWith(r8)     // Catch:{ all -> 0x00aa }
            kotlin.Unit r7 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00aa }
            if (r9 == 0) goto L_0x00a6
            boolean r7 = r9.clearThreadContext()     // Catch:{ all -> 0x00be }
            if (r7 == 0) goto L_0x00b7
        L_0x00a6:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch:{ all -> 0x00be }
            goto L_0x00b7
        L_0x00aa:
            r7 = move-exception
            if (r9 == 0) goto L_0x00b3
            boolean r8 = r9.clearThreadContext()     // Catch:{ all -> 0x00be }
            if (r8 == 0) goto L_0x00b6
        L_0x00b3:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r5, r4)     // Catch:{ all -> 0x00be }
        L_0x00b6:
            throw r7     // Catch:{ all -> 0x00be }
        L_0x00b7:
            boolean r7 = r0.processUnconfinedEvent()     // Catch:{ all -> 0x00be }
            if (r7 != 0) goto L_0x00b7
            goto L_0x00c2
        L_0x00be:
            r7 = move-exception
            r2.handleFatalException$kotlinx_coroutines_core(r7, r3)     // Catch:{ all -> 0x00c6 }
        L_0x00c2:
            r0.decrementUseCount(r1)
            goto L_0x00ce
        L_0x00c6:
            r7 = move-exception
            r0.decrementUseCount(r1)
            throw r7
        L_0x00cb:
            r7.resumeWith(r8)
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.DispatchedContinuationKt.resumeCancellableWith(kotlin.coroutines.Continuation, java.lang.Object, kotlin.jvm.functions.Function1):void");
    }

    public static final boolean yieldUndispatched(DispatchedContinuation<? super Unit> dispatchedContinuation) {
        Unit unit = Unit.INSTANCE;
        boolean assertions_enabled = DebugKt.getASSERTIONS_ENABLED();
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = unit;
            dispatchedContinuation.resumeMode = 1;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedTask dispatchedTask = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            dispatchedContinuation.run();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
        } catch (Throwable th) {
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        return false;
    }

    private static final boolean executeUnconfined(DispatchedContinuation<?> dispatchedContinuation, Object obj, int i, boolean z, Function0<Unit> function0) {
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedTask dispatchedTask = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }

    static /* synthetic */ boolean executeUnconfined$default(DispatchedContinuation dispatchedContinuation, Object obj, int i, boolean z, Function0 function0, int i2, Object obj2) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        if (DebugKt.getASSERTIONS_ENABLED()) {
            if (!(i != -1)) {
                throw new AssertionError();
            }
        }
        EventLoop eventLoop$kotlinx_coroutines_core = ThreadLocalEventLoop.INSTANCE.getEventLoop$kotlinx_coroutines_core();
        if (z && eventLoop$kotlinx_coroutines_core.isUnconfinedQueueEmpty()) {
            return false;
        }
        if (eventLoop$kotlinx_coroutines_core.isUnconfinedLoopActive()) {
            dispatchedContinuation._state = obj;
            dispatchedContinuation.resumeMode = i;
            eventLoop$kotlinx_coroutines_core.dispatchUnconfined(dispatchedContinuation);
            return true;
        }
        DispatchedTask dispatchedTask = dispatchedContinuation;
        eventLoop$kotlinx_coroutines_core.incrementUseCount(true);
        try {
            function0.invoke();
            do {
            } while (eventLoop$kotlinx_coroutines_core.processUnconfinedEvent());
            InlineMarker.finallyStart(1);
        } catch (Throwable th) {
            InlineMarker.finallyStart(1);
            eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
            InlineMarker.finallyEnd(1);
            throw th;
        }
        eventLoop$kotlinx_coroutines_core.decrementUseCount(true);
        InlineMarker.finallyEnd(1);
        return false;
    }
}
