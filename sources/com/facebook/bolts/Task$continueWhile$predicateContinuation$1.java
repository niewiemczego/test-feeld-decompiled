package com.facebook.bolts;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00030\u0001J\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/facebook/bolts/Task$continueWhile$predicateContinuation$1", "Lcom/facebook/bolts/Continuation;", "Ljava/lang/Void;", "Lcom/facebook/bolts/Task;", "then", "task", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Task.kt */
public final class Task$continueWhile$predicateContinuation$1 implements Continuation<Void, Task<Void>> {
    final /* synthetic */ Continuation<Void, Task<Void>> $continuation;
    final /* synthetic */ CancellationToken $ct;
    final /* synthetic */ Executor $executor;
    final /* synthetic */ Callable<Boolean> $predicate;

    Task$continueWhile$predicateContinuation$1(CancellationToken cancellationToken, Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor) {
        this.$ct = cancellationToken;
        this.$predicate = callable;
        this.$continuation = continuation;
        this.$executor = executor;
    }

    public Task<Void> then(Task<Void> task) throws Exception {
        Intrinsics.checkNotNullParameter(task, "task");
        CancellationToken cancellationToken = this.$ct;
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Task.Companion.cancelled();
        }
        Boolean call = this.$predicate.call();
        Intrinsics.checkNotNullExpressionValue(call, "predicate.call()");
        if (call.booleanValue()) {
            return Task.Companion.forResult(null).onSuccessTask(this.$continuation, this.$executor).onSuccessTask(this, this.$executor);
        }
        return Task.Companion.forResult(null);
    }
}
