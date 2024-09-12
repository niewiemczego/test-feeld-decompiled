package zendesk.conversationkit.android.model;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lzendesk/conversationkit/android/model/ActivityData;", "", "type", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getType", "()Ljava/lang/String;", "TYPING_START", "TYPING_STOP", "CONVERSATION_READ", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActivityData.kt */
public enum ActivityData {
    TYPING_START("typing:start"),
    TYPING_STOP("typing:stop"),
    CONVERSATION_READ("conversation:read");
    
    private final String type;

    private ActivityData(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }
}
