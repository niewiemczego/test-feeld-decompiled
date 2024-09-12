package zendesk.conversationkit.android.model;

import java.time.LocalDateTime;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B_\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0014\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0013\u001a\u00020\u0006¢\u0006\u0002\u0010\u0014J\t\u0010$\u001a\u00020\u0006HÆ\u0003J\t\u0010%\u001a\u00020\bHÆ\u0003J\t\u0010&\u001a\u00020\nHÆ\u0003J\t\u0010'\u001a\u00020\fHÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u0010)\u001a\u00020\u000fHÆ\u0003J\u0017\u0010*\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010,\u001a\u00020\u0006HÆ\u0003Ju\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u0006HÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u000202HÖ\u0001J\t\u00103\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001cR\u001f\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001cR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u00064"}, d2 = {"Lzendesk/conversationkit/android/model/EssentialMessageData;", "", "message", "Lzendesk/conversationkit/android/model/Message;", "(Lzendesk/conversationkit/android/model/Message;)V", "id", "", "author", "Lzendesk/conversationkit/android/model/Author;", "status", "Lzendesk/conversationkit/android/model/MessageStatus;", "received", "Ljava/time/LocalDateTime;", "created", "content", "Lzendesk/conversationkit/android/model/MessageContent;", "metadata", "", "sourceId", "localId", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/Author;Lzendesk/conversationkit/android/model/MessageStatus;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Lzendesk/conversationkit/android/model/MessageContent;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Lzendesk/conversationkit/android/model/Author;", "getContent", "()Lzendesk/conversationkit/android/model/MessageContent;", "getCreated", "()Ljava/time/LocalDateTime;", "getId", "()Ljava/lang/String;", "getLocalId", "getMetadata", "()Ljava/util/Map;", "getReceived", "getSourceId", "getStatus", "()Lzendesk/conversationkit/android/model/MessageStatus;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public final class EssentialMessageData {
    private final Author author;
    private final MessageContent content;
    private final LocalDateTime created;
    private final String id;
    private final String localId;
    private final Map<String, Object> metadata;
    private final LocalDateTime received;
    private final String sourceId;
    private final MessageStatus status;

    public static /* synthetic */ EssentialMessageData copy$default(EssentialMessageData essentialMessageData, String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, MessageContent messageContent, Map map, String str2, String str3, int i, Object obj) {
        EssentialMessageData essentialMessageData2 = essentialMessageData;
        int i2 = i;
        return essentialMessageData.copy((i2 & 1) != 0 ? essentialMessageData2.id : str, (i2 & 2) != 0 ? essentialMessageData2.author : author2, (i2 & 4) != 0 ? essentialMessageData2.status : messageStatus, (i2 & 8) != 0 ? essentialMessageData2.received : localDateTime, (i2 & 16) != 0 ? essentialMessageData2.created : localDateTime2, (i2 & 32) != 0 ? essentialMessageData2.content : messageContent, (i2 & 64) != 0 ? essentialMessageData2.metadata : map, (i2 & 128) != 0 ? essentialMessageData2.sourceId : str2, (i2 & 256) != 0 ? essentialMessageData2.localId : str3);
    }

    public final String component1() {
        return this.id;
    }

    public final Author component2() {
        return this.author;
    }

    public final MessageStatus component3() {
        return this.status;
    }

    public final LocalDateTime component4() {
        return this.received;
    }

    public final LocalDateTime component5() {
        return this.created;
    }

    public final MessageContent component6() {
        return this.content;
    }

    public final Map<String, Object> component7() {
        return this.metadata;
    }

    public final String component8() {
        return this.sourceId;
    }

    public final String component9() {
        return this.localId;
    }

    public final EssentialMessageData copy(String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, MessageContent messageContent, Map<String, ? extends Object> map, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(author2, "author");
        Intrinsics.checkNotNullParameter(messageStatus, "status");
        Intrinsics.checkNotNullParameter(localDateTime, "received");
        MessageContent messageContent2 = messageContent;
        Intrinsics.checkNotNullParameter(messageContent2, "content");
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str4, "localId");
        return new EssentialMessageData(str, author2, messageStatus, localDateTime, localDateTime2, messageContent2, map, str2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EssentialMessageData)) {
            return false;
        }
        EssentialMessageData essentialMessageData = (EssentialMessageData) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) essentialMessageData.id) && Intrinsics.areEqual((Object) this.author, (Object) essentialMessageData.author) && this.status == essentialMessageData.status && Intrinsics.areEqual((Object) this.received, (Object) essentialMessageData.received) && Intrinsics.areEqual((Object) this.created, (Object) essentialMessageData.created) && Intrinsics.areEqual((Object) this.content, (Object) essentialMessageData.content) && Intrinsics.areEqual((Object) this.metadata, (Object) essentialMessageData.metadata) && Intrinsics.areEqual((Object) this.sourceId, (Object) essentialMessageData.sourceId) && Intrinsics.areEqual((Object) this.localId, (Object) essentialMessageData.localId);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.author.hashCode()) * 31) + this.status.hashCode()) * 31) + this.received.hashCode()) * 31;
        LocalDateTime localDateTime = this.created;
        int i = 0;
        int hashCode2 = (((hashCode + (localDateTime == null ? 0 : localDateTime.hashCode())) * 31) + this.content.hashCode()) * 31;
        Map<String, Object> map = this.metadata;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.sourceId;
        if (str != null) {
            i = str.hashCode();
        }
        return ((hashCode3 + i) * 31) + this.localId.hashCode();
    }

    public String toString() {
        return "EssentialMessageData(id=" + this.id + ", author=" + this.author + ", status=" + this.status + ", received=" + this.received + ", created=" + this.created + ", content=" + this.content + ", metadata=" + this.metadata + ", sourceId=" + this.sourceId + ", localId=" + this.localId + ')';
    }

    public EssentialMessageData(String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, MessageContent messageContent, Map<String, ? extends Object> map, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(author2, "author");
        Intrinsics.checkNotNullParameter(messageStatus, "status");
        Intrinsics.checkNotNullParameter(localDateTime, "received");
        Intrinsics.checkNotNullParameter(messageContent, "content");
        Intrinsics.checkNotNullParameter(str3, "localId");
        this.id = str;
        this.author = author2;
        this.status = messageStatus;
        this.received = localDateTime;
        this.created = localDateTime2;
        this.content = messageContent;
        this.metadata = map;
        this.sourceId = str2;
        this.localId = str3;
    }

    public final String getId() {
        return this.id;
    }

    public final Author getAuthor() {
        return this.author;
    }

    public final MessageStatus getStatus() {
        return this.status;
    }

    public final LocalDateTime getReceived() {
        return this.received;
    }

    public final LocalDateTime getCreated() {
        return this.created;
    }

    public final MessageContent getContent() {
        return this.content;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getSourceId() {
        return this.sourceId;
    }

    public final String getLocalId() {
        return this.localId;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public EssentialMessageData(Message message) {
        this(message.getId(), message.getAuthor(), message.getStatus(), message.getReceived(), message.getCreated(), message.getContent(), message.getMetadata(), message.getSourceId(), message.getLocalId());
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
