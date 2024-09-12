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

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H@"}, d2 = {"<anonymous>", "", "event", "Lcom/adapty/internal/data/models/AnalyticsEvent;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsManager$trackSystemEvent$1", f = "AnalyticsManager.kt", i = {}, l = {21}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsManager.kt */
final class AnalyticsManager$trackSystemEvent$1 extends SuspendLambda implements Function2<AnalyticsEvent, Continuation<? super Unit>, Object> {
    /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnalyticsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsManager$trackSystemEvent$1(AnalyticsManager analyticsManager, Continuation<? super AnalyticsManager$trackSystemEvent$1> continuation) {
        super(2, continuation);
        this.this$0 = analyticsManager;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnalyticsManager$trackSystemEvent$1 analyticsManager$trackSystemEvent$1 = new AnalyticsManager$trackSystemEvent$1(this.this$0, continuation);
        analyticsManager$trackSystemEvent$1.L$0 = obj;
        return analyticsManager$trackSystemEvent$1;
    }

    public final Object invoke(AnalyticsEvent analyticsEvent, Continuation<? super Unit> continuation) {
        return ((AnalyticsManager$trackSystemEvent$1) create(analyticsEvent, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            AnalyticsEventQueueDispatcher access$getEventQueueDispatcher$p = this.this$0.eventQueueDispatcher;
            this.label = 1;
            if (access$getEventQueueDispatcher$p.addToQueue((AnalyticsEvent) this.L$0, this) == coroutine_suspended) {
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
