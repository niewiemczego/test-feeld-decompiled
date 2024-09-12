package zendesk.android.internal.frontendevents.analyticsevents;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.internal.extension.DateTimeExt;
import zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsAction;
import zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsDTO;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.android.internal.frontendevents.analyticsevents.ProactiveMessagingAnalyticsManager$subscribe$1$1", f = "ProactiveMessagingAnalyticsManager.kt", i = {}, l = {58}, m = "invokeSuspend", n = {}, s = {})
/* compiled from: ProactiveMessagingAnalyticsManager.kt */
final class ProactiveMessagingAnalyticsManager$subscribe$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ ProactiveCampaignAnalyticsAction $action;
    final /* synthetic */ String $campaignId;
    final /* synthetic */ int $campaignVersion;
    int label;
    final /* synthetic */ ProactiveMessagingAnalyticsManager this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProactiveMessagingAnalyticsManager$subscribe$1$1(ProactiveMessagingAnalyticsManager proactiveMessagingAnalyticsManager, String str, ProactiveCampaignAnalyticsAction proactiveCampaignAnalyticsAction, int i, Continuation<? super ProactiveMessagingAnalyticsManager$subscribe$1$1> continuation) {
        super(2, continuation);
        this.this$0 = proactiveMessagingAnalyticsManager;
        this.$campaignId = str;
        this.$action = proactiveCampaignAnalyticsAction;
        this.$campaignVersion = i;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProactiveMessagingAnalyticsManager$subscribe$1$1(this.this$0, this.$campaignId, this.$action, this.$campaignVersion, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProactiveMessagingAnalyticsManager$subscribe$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            ProactiveCampaignAnalyticsDTO proactiveCampaignAnalyticsDTO = new ProactiveCampaignAnalyticsDTO(this.$campaignId, this.$action, DateTimeExt.INSTANCE.currentIso8601UtcTimestamp(), this.$campaignVersion, this.this$0.visitorId);
            this.label = 1;
            if (this.this$0.frontendEventsRepository.sendProactiveMessagingAnalyticsEvent(proactiveCampaignAnalyticsDTO, this) == coroutine_suspended) {
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
