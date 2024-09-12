package com.adapty.internal.data.cloud;

import com.adapty.internal.utils.UtilsKt;
import com.adapty.utils.ErrorCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "e", ""}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1$2$1", f = "AnalyticsEventRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsEventRecorder.kt */
final class AnalyticsEventRecorder$trackEvent$1$2$1 extends SuspendLambda implements Function3<FlowCollector<? super Unit>, Throwable, Continuation<? super Unit>, Object> {
    final /* synthetic */ ErrorCallback $completion;
    /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventRecorder$trackEvent$1$2$1(ErrorCallback errorCallback, Continuation<? super AnalyticsEventRecorder$trackEvent$1$2$1> continuation) {
        super(3, continuation);
        this.$completion = errorCallback;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Throwable th, Continuation<? super Unit> continuation) {
        AnalyticsEventRecorder$trackEvent$1$2$1 analyticsEventRecorder$trackEvent$1$2$1 = new AnalyticsEventRecorder$trackEvent$1$2$1(this.$completion, continuation);
        analyticsEventRecorder$trackEvent$1$2$1.L$0 = th;
        return analyticsEventRecorder$trackEvent$1$2$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$completion.onResult(UtilsKt.asAdaptyError((Throwable) this.L$0));
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
