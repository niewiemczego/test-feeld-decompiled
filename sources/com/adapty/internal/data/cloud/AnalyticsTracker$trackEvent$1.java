package com.adapty.internal.data.cloud;

import com.adapty.internal.data.models.AnalyticsEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "it", "Lcom/adapty/internal/data/models/AnalyticsEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsTracker$trackEvent$1", f = "AnalyticsTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsTracker.kt */
final class AnalyticsTracker$trackEvent$1 extends SuspendLambda implements Function2<AnalyticsEvent, Continuation<? super Unit>, Object> {
    int label;

    AnalyticsTracker$trackEvent$1(Continuation<? super AnalyticsTracker$trackEvent$1> continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AnalyticsTracker$trackEvent$1(continuation);
    }

    public final Object invoke(AnalyticsEvent analyticsEvent, Continuation<? super Unit> continuation) {
        return ((AnalyticsTracker$trackEvent$1) create(analyticsEvent, continuation)).invokeSuspend(Unit.INSTANCE);
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
