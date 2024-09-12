package kotlinx.coroutines;

import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.scheduling.Task;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u000f\b!\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00060\u0002j\u0002`\u0003B\u000f\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0010¢\u0006\u0002\b\u0011J\u0019\u0010\u0012\u001a\u0004\u0018\u00010\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0002\b\u0014J\u001f\u0010\u0015\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u000eH\u0010¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u0018\u001a\u00020\f2\b\u0010\u0019\u001a\u0004\u0018\u00010\u00102\b\u0010\u001a\u001a\u0004\u0018\u00010\u0010H\u0000¢\u0006\u0002\b\u001bJ\u0006\u0010\u001c\u001a\u00020\fJ\u000f\u0010\u001d\u001a\u0004\u0018\u00010\u000eH ¢\u0006\u0002\b\u001eR\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\bX \u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lkotlinx/coroutines/DispatchedTask;", "T", "Lkotlinx/coroutines/scheduling/Task;", "Lkotlinx/coroutines/SchedulerTask;", "resumeMode", "", "(I)V", "delegate", "Lkotlin/coroutines/Continuation;", "getDelegate$kotlinx_coroutines_core", "()Lkotlin/coroutines/Continuation;", "cancelCompletedResult", "", "takenState", "", "cause", "", "cancelCompletedResult$kotlinx_coroutines_core", "getExceptionalResult", "state", "getExceptionalResult$kotlinx_coroutines_core", "getSuccessfulResult", "getSuccessfulResult$kotlinx_coroutines_core", "(Ljava/lang/Object;)Ljava/lang/Object;", "handleFatalException", "exception", "finallyException", "handleFatalException$kotlinx_coroutines_core", "run", "takeState", "takeState$kotlinx_coroutines_core", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: DispatchedTask.kt */
public abstract class DispatchedTask<T> extends Task {
    public int resumeMode;

    public void cancelCompletedResult$kotlinx_coroutines_core(Object obj, Throwable th) {
    }

    public abstract Continuation<T> getDelegate$kotlinx_coroutines_core();

    public <T> T getSuccessfulResult$kotlinx_coroutines_core(Object obj) {
        return obj;
    }

    public abstract Object takeState$kotlinx_coroutines_core();

    public DispatchedTask(int i) {
        this.resumeMode = i;
    }

    public Throwable getExceptionalResult$kotlinx_coroutines_core(Object obj) {
        CompletedExceptionally completedExceptionally = obj instanceof CompletedExceptionally ? (CompletedExceptionally) obj : null;
        if (completedExceptionally != null) {
            return completedExceptionally.cause;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b9, code lost:
        if (r4.clearThreadContext() != false) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e7, code lost:
        if (r4.clearThreadContext() != false) goto L_0x00e9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r10 = this;
            boolean r0 = kotlinx.coroutines.DebugKt.getASSERTIONS_ENABLED()
            if (r0 == 0) goto L_0x0017
            int r0 = r10.resumeMode
            r1 = -1
            if (r0 == r1) goto L_0x000d
            r0 = 1
            goto L_0x000e
        L_0x000d:
            r0 = 0
        L_0x000e:
            if (r0 == 0) goto L_0x0011
            goto L_0x0017
        L_0x0011:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            r0.<init>()
            throw r0
        L_0x0017:
            kotlinx.coroutines.scheduling.TaskContext r0 = r10.taskContext
            kotlin.coroutines.Continuation r1 = r10.getDelegate$kotlinx_coroutines_core()     // Catch:{ all -> 0x00ed }
            java.lang.String r2 = "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTask>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)     // Catch:{ all -> 0x00ed }
            kotlinx.coroutines.internal.DispatchedContinuation r1 = (kotlinx.coroutines.internal.DispatchedContinuation) r1     // Catch:{ all -> 0x00ed }
            kotlin.coroutines.Continuation<T> r2 = r1.continuation     // Catch:{ all -> 0x00ed }
            java.lang.Object r1 = r1.countOrElement     // Catch:{ all -> 0x00ed }
            kotlin.coroutines.CoroutineContext r3 = r2.getContext()     // Catch:{ all -> 0x00ed }
            java.lang.Object r1 = kotlinx.coroutines.internal.ThreadContextKt.updateThreadContext(r3, r1)     // Catch:{ all -> 0x00ed }
            kotlinx.coroutines.internal.Symbol r4 = kotlinx.coroutines.internal.ThreadContextKt.NO_THREAD_ELEMENTS     // Catch:{ all -> 0x00ed }
            r5 = 0
            if (r1 == r4) goto L_0x003a
            kotlinx.coroutines.UndispatchedCoroutine r4 = kotlinx.coroutines.CoroutineContextKt.updateUndispatchedCompletion(r2, r3, r1)     // Catch:{ all -> 0x00ed }
            goto L_0x003b
        L_0x003a:
            r4 = r5
        L_0x003b:
            kotlin.coroutines.CoroutineContext r6 = r2.getContext()     // Catch:{ all -> 0x00e0 }
            java.lang.Object r7 = r10.takeState$kotlinx_coroutines_core()     // Catch:{ all -> 0x00e0 }
            java.lang.Throwable r8 = r10.getExceptionalResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x00e0 }
            if (r8 != 0) goto L_0x005c
            int r9 = r10.resumeMode     // Catch:{ all -> 0x00e0 }
            boolean r9 = kotlinx.coroutines.DispatchedTaskKt.isCancellableMode(r9)     // Catch:{ all -> 0x00e0 }
            if (r9 == 0) goto L_0x005c
            kotlinx.coroutines.Job$Key r9 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00e0 }
            kotlin.coroutines.CoroutineContext$Key r9 = (kotlin.coroutines.CoroutineContext.Key) r9     // Catch:{ all -> 0x00e0 }
            kotlin.coroutines.CoroutineContext$Element r6 = r6.get(r9)     // Catch:{ all -> 0x00e0 }
            kotlinx.coroutines.Job r6 = (kotlinx.coroutines.Job) r6     // Catch:{ all -> 0x00e0 }
            goto L_0x005d
        L_0x005c:
            r6 = r5
        L_0x005d:
            if (r6 == 0) goto L_0x0094
            boolean r9 = r6.isActive()     // Catch:{ all -> 0x00e0 }
            if (r9 != 0) goto L_0x0094
            java.util.concurrent.CancellationException r6 = r6.getCancellationException()     // Catch:{ all -> 0x00e0 }
            r8 = r6
            java.lang.Throwable r8 = (java.lang.Throwable) r8     // Catch:{ all -> 0x00e0 }
            r10.cancelCompletedResult$kotlinx_coroutines_core(r7, r8)     // Catch:{ all -> 0x00e0 }
            kotlin.Result$Companion r7 = kotlin.Result.Companion     // Catch:{ all -> 0x00e0 }
            boolean r7 = kotlinx.coroutines.DebugKt.getRECOVER_STACK_TRACES()     // Catch:{ all -> 0x00e0 }
            if (r7 == 0) goto L_0x0086
            boolean r7 = r2 instanceof kotlin.coroutines.jvm.internal.CoroutineStackFrame     // Catch:{ all -> 0x00e0 }
            if (r7 != 0) goto L_0x007c
            goto L_0x0086
        L_0x007c:
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00e0 }
            r7 = r2
            kotlin.coroutines.jvm.internal.CoroutineStackFrame r7 = (kotlin.coroutines.jvm.internal.CoroutineStackFrame) r7     // Catch:{ all -> 0x00e0 }
            java.lang.Throwable r6 = kotlinx.coroutines.internal.StackTraceRecoveryKt.recoverFromStackFrame(r6, r7)     // Catch:{ all -> 0x00e0 }
            goto L_0x0088
        L_0x0086:
            java.lang.Throwable r6 = (java.lang.Throwable) r6     // Catch:{ all -> 0x00e0 }
        L_0x0088:
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r6)     // Catch:{ all -> 0x00e0 }
            java.lang.Object r6 = kotlin.Result.m983constructorimpl(r6)     // Catch:{ all -> 0x00e0 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00e0 }
            goto L_0x00b1
        L_0x0094:
            if (r8 == 0) goto L_0x00a4
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00e0 }
            java.lang.Object r6 = kotlin.ResultKt.createFailure(r8)     // Catch:{ all -> 0x00e0 }
            java.lang.Object r6 = kotlin.Result.m983constructorimpl(r6)     // Catch:{ all -> 0x00e0 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00e0 }
            goto L_0x00b1
        L_0x00a4:
            kotlin.Result$Companion r6 = kotlin.Result.Companion     // Catch:{ all -> 0x00e0 }
            java.lang.Object r6 = r10.getSuccessfulResult$kotlinx_coroutines_core(r7)     // Catch:{ all -> 0x00e0 }
            java.lang.Object r6 = kotlin.Result.m983constructorimpl(r6)     // Catch:{ all -> 0x00e0 }
            r2.resumeWith(r6)     // Catch:{ all -> 0x00e0 }
        L_0x00b1:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00e0 }
            if (r4 == 0) goto L_0x00bb
            boolean r2 = r4.clearThreadContext()     // Catch:{ all -> 0x00ed }
            if (r2 == 0) goto L_0x00be
        L_0x00bb:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x00ed }
        L_0x00be:
            kotlin.Result$Companion r1 = kotlin.Result.Companion     // Catch:{ all -> 0x00cd }
            r1 = r10
            kotlinx.coroutines.DispatchedTask r1 = (kotlinx.coroutines.DispatchedTask) r1     // Catch:{ all -> 0x00cd }
            r0.afterTask()     // Catch:{ all -> 0x00cd }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00cd }
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)     // Catch:{ all -> 0x00cd }
            goto L_0x00d8
        L_0x00cd:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)
        L_0x00d8:
            java.lang.Throwable r0 = kotlin.Result.m986exceptionOrNullimpl(r0)
            r10.handleFatalException$kotlinx_coroutines_core(r5, r0)
            goto L_0x010c
        L_0x00e0:
            r2 = move-exception
            if (r4 == 0) goto L_0x00e9
            boolean r4 = r4.clearThreadContext()     // Catch:{ all -> 0x00ed }
            if (r4 == 0) goto L_0x00ec
        L_0x00e9:
            kotlinx.coroutines.internal.ThreadContextKt.restoreThreadContext(r3, r1)     // Catch:{ all -> 0x00ed }
        L_0x00ec:
            throw r2     // Catch:{ all -> 0x00ed }
        L_0x00ed:
            r1 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x00fa }
            r0.afterTask()     // Catch:{ all -> 0x00fa }
            kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x00fa }
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)     // Catch:{ all -> 0x00fa }
            goto L_0x0105
        L_0x00fa:
            r0 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m983constructorimpl(r0)
        L_0x0105:
            java.lang.Throwable r0 = kotlin.Result.m986exceptionOrNullimpl(r0)
            r10.handleFatalException$kotlinx_coroutines_core(r1, r0)
        L_0x010c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.DispatchedTask.run():void");
    }

    public final void handleFatalException$kotlinx_coroutines_core(Throwable th, Throwable th2) {
        if (th != null || th2 != null) {
            if (!(th == null || th2 == null)) {
                ExceptionsKt.addSuppressed(th, th2);
            }
            if (th == null) {
                th = th2;
            }
            Intrinsics.checkNotNull(th);
            CoroutineExceptionHandlerKt.handleCoroutineException(getDelegate$kotlinx_coroutines_core().getContext(), new CoroutinesInternalError("Fatal exception in coroutines machinery for " + this + ". Please read KDoc to 'handleFatalException' method and report this incident to maintainers", th));
        }
    }
}
