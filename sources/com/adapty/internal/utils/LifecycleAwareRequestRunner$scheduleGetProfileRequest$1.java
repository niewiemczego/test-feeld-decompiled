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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.utils.LifecycleAwareRequestRunner$scheduleGetProfileRequest$1", f = "LifecycleAwareRequestRunner.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: LifecycleAwareRequestRunner.kt */
final class LifecycleAwareRequestRunner$scheduleGetProfileRequest$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $initialDelayMillis;
    int label;
    final /* synthetic */ LifecycleAwareRequestRunner this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LifecycleAwareRequestRunner$scheduleGetProfileRequest$1(LifecycleAwareRequestRunner lifecycleAwareRequestRunner, long j, Continuation<? super LifecycleAwareRequestRunner$scheduleGetProfileRequest$1> continuation) {
        super(2, continuation);
        this.this$0 = lifecycleAwareRequestRunner;
        this.$initialDelayMillis = j;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new LifecycleAwareRequestRunner$scheduleGetProfileRequest$1(this.this$0, this.$initialDelayMillis, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((LifecycleAwareRequestRunner$scheduleGetProfileRequest$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LifecycleAwareRequestRunner lifecycleAwareRequestRunner = this.this$0;
            long j = this.$initialDelayMillis;
            final LifecycleAwareRequestRunner lifecycleAwareRequestRunner2 = this.this$0;
            this.label = 1;
            if (LifecycleAwareRequestRunner.runPeriodically$default(lifecycleAwareRequestRunner, j, 0, new Function0<Flow<?>>() {
                public final Flow<?> invoke() {
                    return lifecycleAwareRequestRunner2.profileInteractor.getProfile(-1);
                }
            }, this, 2, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
