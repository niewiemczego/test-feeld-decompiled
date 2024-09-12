package zendesk.conversationkit.android.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0001\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/model/MessageType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "UNSUPPORTED", "TEXT", "FILE_UPLOAD", "FILE", "IMAGE", "CAROUSEL", "LIST", "LOCATION", "FORM", "FORM_RESPONSE", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public enum MessageType {
    UNSUPPORTED("unsupported"),
    TEXT("text"),
    FILE_UPLOAD("file_upload"),
    FILE("file"),
    IMAGE("image"),
    CAROUSEL("carousel"),
    LIST("list"),
    LOCATION(FirebaseAnalytics.Param.LOCATION),
    FORM("form"),
    FORM_RESPONSE("formResponse");
    
    public static final Companion Companion = null;
    private final String value;

    private MessageType(String str) {
        this.value = str;
    }

    public final String getValue$zendesk_conversationkit_conversationkit_android() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/model/MessageType$Companion;", "", "()V", "findByValue", "Lzendesk/conversationkit/android/model/MessageType;", "value", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MessageType findByValue(String str) {
            MessageType messageType;
            Intrinsics.checkNotNullParameter(str, "value");
            MessageType[] values = MessageType.values();
            int length = values.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    messageType = null;
                    break;
                }
                messageType = values[i];
                if (Intrinsics.areEqual((Object) messageType.getValue$zendesk_conversationkit_conversationkit_android(), (Object) str)) {
                    break;
                }
                i++;
            }
            return messageType == null ? MessageType.UNSUPPORTED : messageType;
        }
    }
}
