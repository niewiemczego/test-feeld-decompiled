package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0005H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$3", f = "LifecycleAwareRequestRunner.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LifecycleAwareRequestRunner.kt */
final class LifecycleAwareRequestRunner$runPeriodically$3 extends SuspendLambda implements Function3<FlowCollector<? super Object>, Throwable, Continuation<? super Unit>, Object> {
    int label;

    LifecycleAwareRequestRunner$runPeriodically$3(Continuation<? super LifecycleAwareRequestRunner$runPeriodically$3> continuation) {
        super(3, continuation);
    }

    public final Object invoke(FlowCollector<Object> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        return new LifecycleAwareRequestRunner$runPeriodically$3(continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
