package zendesk.messaging.android.push.internal;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\u0002\u0010\u0010J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0016J\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010&\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010'\u001a\u00020\tHÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u0010+\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÆ\u0001¢\u0006\u0002\u0010,J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0012R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0012¨\u00063"}, d2 = {"Lzendesk/messaging/android/push/internal/MessagePayload;", "", "id", "", "authorId", "role", "name", "avatarUrl", "received", "", "type", "text", "mediaUrl", "mediaType", "mediaSize", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)V", "getAuthorId", "()Ljava/lang/String;", "getAvatarUrl", "getId", "getMediaSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaType", "getMediaUrl", "getName", "getReceived", "()D", "getRole", "getText", "getType", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;)Lzendesk/messaging/android/push/internal/MessagePayload;", "equals", "", "other", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagePayload.kt */
public final class MessagePayload {
    private final String authorId;
    private final String avatarUrl;
    private final String id;
    private final Long mediaSize;
    private final String mediaType;
    private final String mediaUrl;
    private final String name;
    private final double received;
    private final String role;
    private final String text;
    private final String type;

    public static /* synthetic */ MessagePayload copy$default(MessagePayload messagePayload, String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, Long l, int i, Object obj) {
        MessagePayload messagePayload2 = messagePayload;
        int i2 = i;
        return messagePayload.copy((i2 & 1) != 0 ? messagePayload2.id : str, (i2 & 2) != 0 ? messagePayload2.authorId : str2, (i2 & 4) != 0 ? messagePayload2.role : str3, (i2 & 8) != 0 ? messagePayload2.name : str4, (i2 & 16) != 0 ? messagePayload2.avatarUrl : str5, (i2 & 32) != 0 ? messagePayload2.received : d, (i2 & 64) != 0 ? messagePayload2.type : str6, (i2 & 128) != 0 ? messagePayload2.text : str7, (i2 & 256) != 0 ? messagePayload2.mediaUrl : str8, (i2 & 512) != 0 ? messagePayload2.mediaType : str9, (i2 & 1024) != 0 ? messagePayload2.mediaSize : l);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.mediaType;
    }

    public final Long component11() {
        return this.mediaSize;
    }

    public final String component2() {
        return this.authorId;
    }

    public final String component3() {
        return this.role;
    }

    public final String component4() {
        return this.name;
    }

    public final String component5() {
        return this.avatarUrl;
    }

    public final double component6() {
        return this.received;
    }

    public final String component7() {
        return this.type;
    }

    public final String component8() {
        return this.text;
    }

    public final String component9() {
        return this.mediaUrl;
    }

    public final MessagePayload copy(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, Long l) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str10 = str2;
        Intrinsics.checkNotNullParameter(str10, "authorId");
        String str11 = str3;
        Intrinsics.checkNotNullParameter(str11, "role");
        String str12 = str6;
        Intrinsics.checkNotNullParameter(str12, "type");
        return new MessagePayload(str, str10, str11, str4, str5, d, str12, str7, str8, str9, l);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagePayload)) {
            return false;
        }
        MessagePayload messagePayload = (MessagePayload) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messagePayload.id) && Intrinsics.areEqual((Object) this.authorId, (Object) messagePayload.authorId) && Intrinsics.areEqual((Object) this.role, (Object) messagePayload.role) && Intrinsics.areEqual((Object) this.name, (Object) messagePayload.name) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) messagePayload.avatarUrl) && Intrinsics.areEqual((Object) Double.valueOf(this.received), (Object) Double.valueOf(messagePayload.received)) && Intrinsics.areEqual((Object) this.type, (Object) messagePayload.type) && Intrinsics.areEqual((Object) this.text, (Object) messagePayload.text) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) messagePayload.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) messagePayload.mediaType) && Intrinsics.areEqual((Object) this.mediaSize, (Object) messagePayload.mediaSize);
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.authorId.hashCode()) * 31) + this.role.hashCode()) * 31;
        String str = this.name;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatarUrl;
        int hashCode3 = (((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + Double.hashCode(this.received)) * 31) + this.type.hashCode()) * 31;
        String str3 = this.text;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mediaUrl;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.mediaType;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Long l = this.mediaSize;
        if (l != null) {
            i = l.hashCode();
        }
        return hashCode6 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessagePayload(id=").append(this.id).append(", authorId=").append(this.authorId).append(", role=").append(this.role).append(", name=").append(this.name).append(", avatarUrl=").append(this.avatarUrl).append(", received=").append(this.received).append(", type=").append(this.type).append(", text=").append(this.text).append(", mediaUrl=").append(this.mediaUrl).append(", mediaType=").append(this.mediaType).append(", mediaSize=").append(this.mediaSize).append(')');
        return sb.toString();
    }

    public MessagePayload(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, Long l) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "authorId");
        Intrinsics.checkNotNullParameter(str3, "role");
        Intrinsics.checkNotNullParameter(str6, "type");
        this.id = str;
        this.authorId = str2;
        this.role = str3;
        this.name = str4;
        this.avatarUrl = str5;
        this.received = d;
        this.type = str6;
        this.text = str7;
        this.mediaUrl = str8;
        this.mediaType = str9;
        this.mediaSize = l;
    }

    public final String getId() {
        return this.id;
    }

    public final String getAuthorId() {
        return this.authorId;
    }

    public final String getRole() {
        return this.role;
    }

    public final String getName() {
        return this.name;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final double getReceived() {
        return this.received;
    }

    public final String getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public final String getMediaType() {
        return this.mediaType;
    }

    public final Long getMediaSize() {
        return this.mediaSize;
    }
}
