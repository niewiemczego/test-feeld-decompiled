package zendesk.android.messaging;

import android.content.Context;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import zendesk.android.ZendeskCredentials;
import zendesk.android.events.ZendeskEvent;
import zendesk.android.messaging.model.MessagingSettings;
import zendesk.conversationkit.android.ConversationKit;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, d2 = {"Lzendesk/android/messaging/MessagingFactory;", "", "create", "Lzendesk/android/messaging/Messaging;", "params", "Lzendesk/android/messaging/MessagingFactory$CreateParams;", "CreateParams", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingFactory.kt */
public interface MessagingFactory {
    Messaging create(CreateParams createParams);

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001BV\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\"\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000b\u0012\u0006\u0010\u000f\u001a\u00020\u0010ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R2\u0010\n\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000bø\u0001\u0000¢\u0006\n\n\u0002\u0010\u001c\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u0002\u0004\n\u0002\b\u0019¨\u0006\u001f"}, d2 = {"Lzendesk/android/messaging/MessagingFactory$CreateParams;", "", "credentials", "Lzendesk/android/ZendeskCredentials;", "conversationKit", "Lzendesk/conversationkit/android/ConversationKit;", "messagingSettings", "Lzendesk/android/messaging/model/MessagingSettings;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "dispatchEvent", "Lkotlin/Function2;", "Lzendesk/android/events/ZendeskEvent;", "Lkotlin/coroutines/Continuation;", "", "context", "Landroid/content/Context;", "(Lzendesk/android/ZendeskCredentials;Lzendesk/conversationkit/android/ConversationKit;Lzendesk/android/messaging/model/MessagingSettings;Lkotlinx/coroutines/CoroutineScope;Lkotlin/jvm/functions/Function2;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "getConversationKit", "()Lzendesk/conversationkit/android/ConversationKit;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "getCredentials", "()Lzendesk/android/ZendeskCredentials;", "getDispatchEvent", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getMessagingSettings", "()Lzendesk/android/messaging/model/MessagingSettings;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagingFactory.kt */
    public static final class CreateParams {
        private final Context context;
        private final ConversationKit conversationKit;
        private final CoroutineScope coroutineScope;
        private final ZendeskCredentials credentials;
        private final Function2<ZendeskEvent, Continuation<? super Unit>, Object> dispatchEvent;
        private final MessagingSettings messagingSettings;

        public CreateParams(ZendeskCredentials zendeskCredentials, ConversationKit conversationKit2, MessagingSettings messagingSettings2, CoroutineScope coroutineScope2, Function2<? super ZendeskEvent, ? super Continuation<? super Unit>, ? extends Object> function2, Context context2) {
            Intrinsics.checkNotNullParameter(zendeskCredentials, "credentials");
            Intrinsics.checkNotNullParameter(conversationKit2, "conversationKit");
            Intrinsics.checkNotNullParameter(messagingSettings2, "messagingSettings");
            Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
            Intrinsics.checkNotNullParameter(function2, "dispatchEvent");
            Intrinsics.checkNotNullParameter(context2, "context");
            this.credentials = zendeskCredentials;
            this.conversationKit = conversationKit2;
            this.messagingSettings = messagingSettings2;
            this.coroutineScope = coroutineScope2;
            this.dispatchEvent = function2;
            this.context = context2;
        }

        public final ZendeskCredentials getCredentials() {
            return this.credentials;
        }

        public final ConversationKit getConversationKit() {
            return this.conversationKit;
        }

        public final MessagingSettings getMessagingSettings() {
            return this.messagingSettings;
        }

        public final CoroutineScope getCoroutineScope() {
            return this.coroutineScope;
        }

        public final Function2<ZendeskEvent, Continuation<? super Unit>, Object> getDispatchEvent() {
            return this.dispatchEvent;
        }

        public final Context getContext() {
            return this.context;
        }
    }
}
