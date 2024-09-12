package zendesk.android.internal.di;

import dagger.Subcomponent;
import kotlin.Metadata;
import zendesk.android.Zendesk;
import zendesk.android.internal.frontendevents.di.FrontendEventsModule;
import zendesk.android.internal.proactivemessaging.di.ProactiveMessagingModule;
import zendesk.android.messaging.Messaging;
import zendesk.conversationkit.android.ConversationKit;

@Subcomponent(modules = {ZendeskInitializedModule.class, ProactiveMessagingModule.class, FrontendEventsModule.class})
@ZendeskInitializedComponentScope
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\bJ\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&¨\u0006\t"}, d2 = {"Lzendesk/android/internal/di/ZendeskInitializedComponent;", "", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messaging", "Lzendesk/android/messaging/Messaging;", "zendesk", "Lzendesk/android/Zendesk;", "Builder", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskInitializedComponent.kt */
public interface ZendeskInitializedComponent {

    @Subcomponent.Builder
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0006H&¨\u0006\u0007"}, d2 = {"Lzendesk/android/internal/di/ZendeskInitializedComponent$Builder;", "", "build", "Lzendesk/android/internal/di/ZendeskInitializedComponent;", "zendeskInitializedModule", "module", "Lzendesk/android/internal/di/ZendeskInitializedModule;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskInitializedComponent.kt */
    public interface Builder {
        ZendeskInitializedComponent build();

        Builder zendeskInitializedModule(ZendeskInitializedModule zendeskInitializedModule);
    }

    ConversationKit conversationKit();

    Messaging messaging();

    Zendesk zendesk();
}
