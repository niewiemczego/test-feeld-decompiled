package zendesk.messaging.android.push.internal;

import android.content.Context;
import java.util.Map;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "zendesk.messaging.android.push.internal.NotificationProcessor", f = "NotificationProcessor.kt", i = {0, 0, 0, 0, 0}, l = {64}, m = "displayPushNotification", n = {"context", "notificationBuilder", "conversationId", "messagePayload", "smallIconId"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
/* compiled from: NotificationProcessor.kt */
final class NotificationProcessor$displayPushNotification$1 extends ContinuationImpl {
    int I$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ NotificationProcessor this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NotificationProcessor$displayPushNotification$1(NotificationProcessor notificationProcessor, Continuation<? super NotificationProcessor$displayPushNotification$1> continuation) {
        super(continuation);
        this.this$0 = notificationProcessor;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.displayPushNotification((Context) null, (Map<String, String>) null, (NotificationBuilder) null, 0, this);
    }
}
