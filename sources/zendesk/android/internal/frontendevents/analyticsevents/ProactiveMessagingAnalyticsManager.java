package zendesk.android.internal.frontendevents.analyticsevents;

import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import zendesk.android.internal.di.ZendeskInitializedComponentScope;
import zendesk.android.internal.frontendevents.FrontendEventsRepository;
import zendesk.android.internal.frontendevents.analyticsevents.model.ProactiveCampaignAnalyticsAction;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.model.ProactiveMessageStatus;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u001f\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/android/internal/frontendevents/analyticsevents/ProactiveMessagingAnalyticsManager;", "", "frontendEventsRepository", "Lzendesk/android/internal/frontendevents/FrontendEventsRepository;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "(Lzendesk/android/internal/frontendevents/FrontendEventsRepository;Lkotlinx/coroutines/CoroutineScope;Lzendesk/conversationkit/android/ConversationKit;)V", "visitorId", "", "subscribe", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@ZendeskInitializedComponentScope
/* compiled from: ProactiveMessagingAnalyticsManager.kt */
public final class ProactiveMessagingAnalyticsManager {
    private final ConversationKit conversationKit;
    private final CoroutineScope coroutineScope;
    /* access modifiers changed from: private */
    public final FrontendEventsRepository frontendEventsRepository;
    /* access modifiers changed from: private */
    public final String visitorId;

    @Inject
    public ProactiveMessagingAnalyticsManager(FrontendEventsRepository frontendEventsRepository2, CoroutineScope coroutineScope2, ConversationKit conversationKit2) {
        Intrinsics.checkNotNullParameter(frontendEventsRepository2, "frontendEventsRepository");
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
        this.frontendEventsRepository = frontendEventsRepository2;
        this.coroutineScope = coroutineScope2;
        this.conversationKit = conversationKit2;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.visitorId = uuid;
    }

    public final void subscribe() {
        this.conversationKit.addEventListener(new ProactiveMessagingAnalyticsManager$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribe$lambda-0  reason: not valid java name */
    public static final void m2751subscribe$lambda0(ProactiveMessagingAnalyticsManager proactiveMessagingAnalyticsManager, ConversationKitEvent conversationKitEvent) {
        Triple triple;
        Intrinsics.checkNotNullParameter(proactiveMessagingAnalyticsManager, "this$0");
        Intrinsics.checkNotNullParameter(conversationKitEvent, "event");
        if (conversationKitEvent instanceof ConversationKitEvent.ProactiveMessageStatusChanged) {
            ProactiveMessageStatus status = ((ConversationKitEvent.ProactiveMessageStatusChanged) conversationKitEvent).getStatus();
            if (status instanceof ProactiveMessageStatus.NotificationHasBeenDisplayed) {
                ProactiveMessageStatus.NotificationHasBeenDisplayed notificationHasBeenDisplayed = (ProactiveMessageStatus.NotificationHasBeenDisplayed) status;
                triple = new Triple(ProactiveCampaignAnalyticsAction.SENT, notificationHasBeenDisplayed.getProactiveMessage().getCampaignId(), Integer.valueOf(notificationHasBeenDisplayed.getProactiveMessage().getCampaignVersion()));
            } else if (status instanceof ProactiveMessageStatus.ConversationHasBeenRepliedTo) {
                ProactiveMessageStatus.ConversationHasBeenRepliedTo conversationHasBeenRepliedTo = (ProactiveMessageStatus.ConversationHasBeenRepliedTo) status;
                triple = new Triple(ProactiveCampaignAnalyticsAction.REPLIED_TO, conversationHasBeenRepliedTo.getProactiveMessage().getCampaignId(), Integer.valueOf(conversationHasBeenRepliedTo.getProactiveMessage().getCampaignVersion()));
            } else if (status instanceof ProactiveMessageStatus.NotificationHasBeenClicked) {
                ProactiveMessageStatus.NotificationHasBeenClicked notificationHasBeenClicked = (ProactiveMessageStatus.NotificationHasBeenClicked) status;
                triple = new Triple(ProactiveCampaignAnalyticsAction.OPENED, notificationHasBeenClicked.getProactiveMessage().getCampaignId(), Integer.valueOf(notificationHasBeenClicked.getProactiveMessage().getCampaignVersion()));
            } else {
                triple = null;
            }
            if (triple != null) {
                String str = (String) triple.component2();
                int intValue = ((Number) triple.component3()).intValue();
                CoroutineScope coroutineScope2 = proactiveMessagingAnalyticsManager.coroutineScope;
                Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope2, (CoroutineContext) null, (CoroutineStart) null, new ProactiveMessagingAnalyticsManager$subscribe$1$1(proactiveMessagingAnalyticsManager, str, (ProactiveCampaignAnalyticsAction) triple.component1(), intValue, (Continuation<? super ProactiveMessagingAnalyticsManager$subscribe$1$1>) null), 3, (Object) null);
            }
        }
    }
}
