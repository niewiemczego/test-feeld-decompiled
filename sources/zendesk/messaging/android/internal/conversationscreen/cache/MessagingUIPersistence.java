package zendesk.messaging.android.internal.conversationscreen.cache;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/cache/MessagingUIPersistence;", "", "conversationId", "", "composerText", "(Ljava/lang/String;Ljava/lang/String;)V", "getComposerText", "()Ljava/lang/String;", "getConversationId", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagingUIPersistence.kt */
public final class MessagingUIPersistence {
    private final String composerText;
    private final String conversationId;

    public static /* synthetic */ MessagingUIPersistence copy$default(MessagingUIPersistence messagingUIPersistence, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messagingUIPersistence.conversationId;
        }
        if ((i & 2) != 0) {
            str2 = messagingUIPersistence.composerText;
        }
        return messagingUIPersistence.copy(str, str2);
    }

    public final String component1() {
        return this.conversationId;
    }

    public final String component2() {
        return this.composerText;
    }

    public final MessagingUIPersistence copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(str2, "composerText");
        return new MessagingUIPersistence(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagingUIPersistence)) {
            return false;
        }
        MessagingUIPersistence messagingUIPersistence = (MessagingUIPersistence) obj;
        return Intrinsics.areEqual((Object) this.conversationId, (Object) messagingUIPersistence.conversationId) && Intrinsics.areEqual((Object) this.composerText, (Object) messagingUIPersistence.composerText);
    }

    public int hashCode() {
        return (this.conversationId.hashCode() * 31) + this.composerText.hashCode();
    }

    public String toString() {
        return "MessagingUIPersistence(conversationId=" + this.conversationId + ", composerText=" + this.composerText + ')';
    }

    public MessagingUIPersistence(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "conversationId");
        Intrinsics.checkNotNullParameter(str2, "composerText");
        this.conversationId = str;
        this.composerText = str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagingUIPersistence(String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? "" : str2);
    }

    public final String getConversationId() {
        return this.conversationId;
    }

    public final String getComposerText() {
        return this.composerText;
    }
}
