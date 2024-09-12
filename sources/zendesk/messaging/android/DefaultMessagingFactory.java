package zendesk.messaging.android;

import com.squareup.moshi.Moshi;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.android.messaging.Messaging;
import zendesk.android.messaging.MessagingFactory;
import zendesk.core.android.internal.app.ProcessLifecycleObserver;
import zendesk.messaging.android.internal.CoroutinesDispatcherProvider;
import zendesk.messaging.android.internal.DefaultMessaging;
import zendesk.messaging.android.internal.UnreadMessageCounter;
import zendesk.messaging.android.internal.di.DaggerMessagingComponent;
import zendesk.messaging.android.internal.di.MessagingComponent;
import zendesk.messaging.android.internal.proactivemessaging.LocalNotificationHandler;
import zendesk.messaging.android.push.internal.NotificationProcessor;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/DefaultMessagingFactory;", "Lzendesk/android/messaging/MessagingFactory;", "()V", "create", "Lzendesk/android/messaging/Messaging;", "params", "Lzendesk/android/messaging/MessagingFactory$CreateParams;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultMessagingFactory.kt */
public final class DefaultMessagingFactory implements MessagingFactory {
    public Messaging create(MessagingFactory.CreateParams createParams) {
        Intrinsics.checkNotNullParameter(createParams, "params");
        MessagingComponent create = DaggerMessagingComponent.factory().create(createParams.getCredentials(), createParams.getMessagingSettings(), createParams.getConversationKit(), createParams.getDispatchEvent(), createParams.getCoroutineScope());
        return new DefaultMessaging(createParams.getCredentials(), createParams.getMessagingSettings(), createParams.getConversationKit(), createParams.getDispatchEvent(), ProcessLifecycleObserver.Companion.newInstance(), createParams.getCoroutineScope(), new UnreadMessageCounter(), new CoroutinesDispatcherProvider(), new LocalNotificationHandler(new NotificationProcessor((Moshi) null, 1, (DefaultConstructorMarker) null), createParams.getContext()), create);
    }
}
