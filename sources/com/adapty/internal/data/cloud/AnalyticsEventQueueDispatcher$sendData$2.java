package com.adapty.internal.data.cloud;

import com.adapty.internal.data.cloud.Response;
import com.adapty.internal.data.models.AnalyticsEvent;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.adapty.internal.data.cloud.AnalyticsEventQueueDispatcher$sendData$2", f = "AnalyticsEventQueueDispatcher.kt", i = {}, l = {105, 115}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: AnalyticsEventQueueDispatcher.kt */
final class AnalyticsEventQueueDispatcher$sendData$2 extends SuspendLambda implements Function2<FlowCollector<? super Unit>, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<AnalyticsEvent> $filteredEvents;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AnalyticsEventQueueDispatcher this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AnalyticsEventQueueDispatcher$sendData$2(List<AnalyticsEvent> list, AnalyticsEventQueueDispatcher analyticsEventQueueDispatcher, Continuation<? super AnalyticsEventQueueDispatcher$sendData$2> continuation) {
        super(2, continuation);
        this.$filteredEvents = list;
        this.this$0 = analyticsEventQueueDispatcher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        AnalyticsEventQueueDispatcher$sendData$2 analyticsEventQueueDispatcher$sendData$2 = new AnalyticsEventQueueDispatcher$sendData$2(this.$filteredEvents, this.this$0, continuation);
        analyticsEventQueueDispatcher$sendData$2.L$0 = obj;
        return analyticsEventQueueDispatcher$sendData$2;
    }

    public final Object invoke(FlowCollector<? super Unit> flowCollector, Continuation<? super Unit> continuation) {
        return ((AnalyticsEventQueueDispatcher$sendData$2) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            if (this.$filteredEvents.isEmpty()) {
                this.label = 1;
                if (flowCollector.emit(Unit.INSTANCE, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Response newCall = this.this$0.httpClient.newCall(this.this$0.requestFactory.sendAnalyticsEventsRequest(this.$filteredEvents), Unit.class);
                if (newCall instanceof Response.Success) {
                    this.label = 2;
                    if (flowCollector.emit(Unit.INSTANCE, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else if (newCall instanceof Response.Error) {
                    throw ((Response.Error) newCall).getError();
                }
                return Unit.INSTANCE;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else if (i == 2) {
            ResultKt.throwOnFailure(obj);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
