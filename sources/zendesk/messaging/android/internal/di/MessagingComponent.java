package zendesk.messaging.android.internal.di;

import dagger.BindsInstance;
import dagger.Component;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.ZendeskCredentials;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;
import zendesk.messaging.android.internal.conversationscreen.di.ConversationActivityComponent;
import zendesk.messaging.android.internal.conversationscreen.di.ImageViewerComponent;

@Component
@MessagingScope
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\ba\u0018\u00002\u00020\u0001:\u0001\u0006J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/di/MessagingComponent;", "", "conversationActivityComponent", "Lzendesk/messaging/android/internal/conversationscreen/di/ConversationActivityComponent$Factory;", "imageViewerActivityComponent", "Lzendesk/messaging/android/internal/conversationscreen/di/ImageViewerComponent$Factory;", "Factory", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingComponent.kt */
public interface MessagingComponent {

    @Component.Factory
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J^\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2$\b\u0001\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b2\b\b\u0001\u0010\u000f\u001a\u00020\u0010H&ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/di/MessagingComponent$Factory;", "", "create", "Lzendesk/messaging/android/internal/di/MessagingComponent;", "zendeskCredentials", "Lzendesk/android/ZendeskCredentials;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "dispatchEvent", "Lkotlin/Function2;", "Lzendesk/android/events/ZendeskEvent;", "Lkotlin/coroutines/Continuation;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "(Lzendesk/android/ZendeskCredentials;Lzendesk/android/messaging/model/MessagingSettings;Lzendesk/conversationkit/android/ConversationKit;Lkotlin/jvm/functions/Function2;Lkotlinx/coroutines/CoroutineScope;)Lzendesk/messaging/android/internal/di/MessagingComponent;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagingComponent.kt */
    public interface Factory {
        MessagingComponent create(@BindsInstance ZendeskCredentials zendeskCredentials, @BindsInstance MessagingSettings messagingSettings, @BindsInstance ConversationKit conversationKit, @BindsInstance Function2<? super ZendeskEvent, ? super Continuation<? super Unit>, ? extends Object> function2, @BindsInstance CoroutineScope coroutineScope);
    }

    ConversationActivityComponent.Factory conversationActivityComponent();

    ImageViewerComponent.Factory imageViewerActivityComponent();
}
