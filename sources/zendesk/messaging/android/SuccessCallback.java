package zendesk.messaging.android;

import kotlin.Deprecated;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bç\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/SuccessCallback;", "T", "", "onSuccess", "", "value", "(Ljava/lang/Object;)V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Please use Zendesk SDK")
/* compiled from: MessagingCallback.kt */
public interface SuccessCallback<T> {
    void onSuccess(T t);
}
