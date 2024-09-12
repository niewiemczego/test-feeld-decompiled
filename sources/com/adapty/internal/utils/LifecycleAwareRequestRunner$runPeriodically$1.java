package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlinx.coroutines.flow.Flow;

@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.LifecycleAwareRequestRunner", f = "LifecycleAwareRequestRunner.kt", i = {0, 0, 0}, l = {94, 101}, m = "runPeriodically", n = {"this", "call", "delayMillis"}, s = {"L$0", "L$1", "J$0"})
/* compiled from: LifecycleAwareRequestRunner.kt */
final class LifecycleAwareRequestRunner$runPeriodically$1 extends ContinuationImpl {
    long J$0;
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LifecycleAwareRequestRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleAwareRequestRunner$runPeriodically$1(LifecycleAwareRequestRunner lifecycleAwareRequestRunner, Continuation<? super LifecycleAwareRequestRunner$runPeriodically$1> continuation) {
        super(continuation);
        this.this$0 = lifecycleAwareRequestRunner;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.runPeriodically(0, 0, (Function0<? extends Flow<?>>) null, this);
    }
}
