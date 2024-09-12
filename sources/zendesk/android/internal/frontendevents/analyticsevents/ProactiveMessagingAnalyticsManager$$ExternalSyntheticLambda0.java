package zendesk.android.internal.frontendevents.analyticsevents;

import zendesk.conversationkit.android.ConversationKitEvent;
import zendesk.conversationkit.android.ConversationKitEventListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProactiveMessagingAnalyticsManager$$ExternalSyntheticLambda0 implements ConversationKitEventListener {
    public final /* synthetic */ ProactiveMessagingAnalyticsManager f$0;

    public /* synthetic */ ProactiveMessagingAnalyticsManager$$ExternalSyntheticLambda0(ProactiveMessagingAnalyticsManager proactiveMessagingAnalyticsManager) {
        this.f$0 = proactiveMessagingAnalyticsManager;
    }

    public final void onEvent(ConversationKitEvent conversationKitEvent) {
        ProactiveMessagingAnalyticsManager.m2751subscribe$lambda0(this.f$0, conversationKitEvent);
    }
}
