package com.adapty.internal.utils;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H@"}, d2 = {"<anonymous>", "", "it", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$2", f = "LifecycleAwareRequestRunner.kt", i = {}, l = {97, 98}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LifecycleAwareRequestRunner.kt */
final class LifecycleAwareRequestRunner$runPeriodically$2 extends SuspendLambda implements Function2<Object, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function0<Flow<?>> $call;
    final /* synthetic */ long $delayMillis;
    int label;
    final /* synthetic */ LifecycleAwareRequestRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleAwareRequestRunner$runPeriodically$2(long j, LifecycleAwareRequestRunner lifecycleAwareRequestRunner, Function0<? extends Flow<?>> function0, Continuation<? super LifecycleAwareRequestRunner$runPeriodically$2> continuation) {
        super(2, continuation);
        this.$delayMillis = j;
        this.this$0 = lifecycleAwareRequestRunner;
        this.$call = function0;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LifecycleAwareRequestRunner$runPeriodically$2(this.$delayMillis, this.this$0, this.$call, continuation);
    }

    public final Object invoke(Object obj, Continuation<? super Unit> continuation) {
        return ((LifecycleAwareRequestRunner$runPeriodically$2) create(obj, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            if (DelayKt.delay(this.$delayMillis, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.label = 2;
        if (this.this$0.runPeriodically(0, this.$delayMillis, this.$call, this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        return Unit.INSTANCE;
    }
}
