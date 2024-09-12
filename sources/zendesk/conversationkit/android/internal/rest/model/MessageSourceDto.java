package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;", "", "id", "", "type", "sessionId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getSessionId", "getType", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageSourceDto {
    private final String id;
    private final String sessionId;
    private final String type;

    public static /* synthetic */ MessageSourceDto copy$default(MessageSourceDto messageSourceDto, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageSourceDto.id;
        }
        if ((i & 2) != 0) {
            str2 = messageSourceDto.type;
        }
        if ((i & 4) != 0) {
            str3 = messageSourceDto.sessionId;
        }
        return messageSourceDto.copy(str, str2, str3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.sessionId;
    }

    public final MessageSourceDto copy(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "type");
        return new MessageSourceDto(str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageSourceDto)) {
            return false;
        }
        MessageSourceDto messageSourceDto = (MessageSourceDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messageSourceDto.id) && Intrinsics.areEqual((Object) this.type, (Object) messageSourceDto.type) && Intrinsics.areEqual((Object) this.sessionId, (Object) messageSourceDto.sessionId);
    }

    public int hashCode() {
        String str = this.id;
        int i = 0;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.type.hashCode()) * 31;
        String str2 = this.sessionId;
        if (str2 != null) {
            i = str2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "MessageSourceDto(id=" + this.id + ", type=" + this.type + ", sessionId=" + this.sessionId + ')';
    }

    public MessageSourceDto(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str2, "type");
        this.id = str;
        this.type = str2;
        this.sessionId = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getSessionId() {
        return this.sessionId;
    }
}
