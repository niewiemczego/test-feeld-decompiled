package com.adapty.internal.data.cloud;

import com.adapty.errors.AdaptyError;
import com.adapty.utils.ErrorCallback;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H@"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventRecorder$trackEvent$1$2$2", f = "AnalyticsEventRecorder.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsEventRecorder.kt */
final class AnalyticsEventRecorder$trackEvent$1$2$2 extends SuspendLambda implements Function2<Unit, Continuation<? super Unit>, Object> {
    final /* synthetic */ ErrorCallback $completion;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventRecorder$trackEvent$1$2$2(ErrorCallback errorCallback, Continuation<? super AnalyticsEventRecorder$trackEvent$1$2$2> continuation) {
        super(2, continuation);
        this.$completion = errorCallback;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsEventRecorder$trackEvent$1$2$2(this.$completion, continuation);
    }

    public final Object invoke(Unit unit, Continuation<? super Unit> continuation) {
        return ((AnalyticsEventRecorder$trackEvent$1$2$2) create(unit, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            this.$completion.onResult((AdaptyError) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
