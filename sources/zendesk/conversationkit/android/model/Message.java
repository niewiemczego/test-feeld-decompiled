package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zendesk.core.android.internal.DateKtxKt;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 B2\u00020\u0001:\u0001BBs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0014J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0005HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\fHÆ\u0003J\t\u00105\u001a\u00020\u000eHÆ\u0003J\u0017\u00106\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010HÆ\u0003J\u000b\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0001\u00108\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010<\u001a\u00020=H\u0016J\u0010\u0010>\u001a\u00020:2\b\u0010?\u001a\u0004\u0018\u00010@J\b\u0010A\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001e8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0012\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001cR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010+\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b,\u0010\u001c¨\u0006C"}, d2 = {"Lzendesk/conversationkit/android/model/Message;", "", "id", "", "author", "Lzendesk/conversationkit/android/model/Author;", "status", "Lzendesk/conversationkit/android/model/MessageStatus;", "created", "Ljava/time/LocalDateTime;", "received", "beforeTimestamp", "", "content", "Lzendesk/conversationkit/android/model/MessageContent;", "metadata", "", "sourceId", "localId", "payload", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/Author;Lzendesk/conversationkit/android/model/MessageStatus;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;DLzendesk/conversationkit/android/model/MessageContent;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthor", "()Lzendesk/conversationkit/android/model/Author;", "getBeforeTimestamp", "()D", "getContent", "()Lzendesk/conversationkit/android/model/MessageContent;", "getCreated", "()Ljava/time/LocalDateTime;", "essentialMessageData", "Lzendesk/conversationkit/android/model/EssentialMessageData;", "getEssentialMessageData$zendesk_conversationkit_conversationkit_android", "()Lzendesk/conversationkit/android/model/EssentialMessageData;", "getId", "()Ljava/lang/String;", "getLocalId", "getMetadata", "()Ljava/util/Map;", "getPayload", "getReceived", "getSourceId", "getStatus", "()Lzendesk/conversationkit/android/model/MessageStatus;", "timestamp", "getTimestamp", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "isAuthoredBy", "participant", "Lzendesk/conversationkit/android/model/Participant;", "toString", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Message.kt */
public final class Message {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Author author;
    private final double beforeTimestamp;
    private final MessageContent content;
    private final LocalDateTime created;
    private final String id;
    private final String localId;
    private final Map<String, Object> metadata;
    private final String payload;
    private final LocalDateTime received;
    private final String sourceId;
    private final MessageStatus status;

    public static /* synthetic */ Message copy$default(Message message, String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, double d, MessageContent messageContent, Map map, String str2, String str3, String str4, int i, Object obj) {
        Message message2 = message;
        int i2 = i;
        return message.copy((i2 & 1) != 0 ? message2.id : str, (i2 & 2) != 0 ? message2.author : author2, (i2 & 4) != 0 ? message2.status : messageStatus, (i2 & 8) != 0 ? message2.created : localDateTime, (i2 & 16) != 0 ? message2.received : localDateTime2, (i2 & 32) != 0 ? message2.beforeTimestamp : d, (i2 & 64) != 0 ? message2.content : messageContent, (i2 & 128) != 0 ? message2.metadata : map, (i2 & 256) != 0 ? message2.sourceId : str2, (i2 & 512) != 0 ? message2.localId : str3, (i2 & 1024) != 0 ? message2.payload : str4);
    }

    @JvmStatic
    public static final Message create(MessageContent messageContent) {
        return Companion.create(messageContent);
    }

    @JvmStatic
    public static final Message create(MessageContent messageContent, Map<String, ? extends Object> map) {
        return Companion.create(messageContent, map);
    }

    @JvmStatic
    public static final Message create(MessageContent messageContent, Map<String, ? extends Object> map, String str) {
        return Companion.create(messageContent, map, str);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.localId;
    }

    public final String component11() {
        return this.payload;
    }

    public final Author component2() {
        return this.author;
    }

    public final MessageStatus component3() {
        return this.status;
    }

    public final LocalDateTime component4() {
        return this.created;
    }

    public final LocalDateTime component5() {
        return this.received;
    }

    public final double component6() {
        return this.beforeTimestamp;
    }

    public final MessageContent component7() {
        return this.content;
    }

    public final Map<String, Object> component8() {
        return this.metadata;
    }

    public final String component9() {
        return this.sourceId;
    }

    public final Message copy(String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, double d, MessageContent messageContent, Map<String, ? extends Object> map, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Author author3 = author2;
        Intrinsics.checkNotNullParameter(author3, "author");
        MessageStatus messageStatus2 = messageStatus;
        Intrinsics.checkNotNullParameter(messageStatus2, "status");
        LocalDateTime localDateTime3 = localDateTime2;
        Intrinsics.checkNotNullParameter(localDateTime3, "received");
        MessageContent messageContent2 = messageContent;
        Intrinsics.checkNotNullParameter(messageContent2, "content");
        String str5 = str3;
        Intrinsics.checkNotNullParameter(str5, "localId");
        return new Message(str, author3, messageStatus2, localDateTime, localDateTime3, d, messageContent2, map, str2, str5, str4);
    }

    public Message(String str, Author author2, MessageStatus messageStatus, LocalDateTime localDateTime, LocalDateTime localDateTime2, double d, MessageContent messageContent, Map<String, ? extends Object> map, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(author2, "author");
        Intrinsics.checkNotNullParameter(messageStatus, "status");
        Intrinsics.checkNotNullParameter(localDateTime2, "received");
        Intrinsics.checkNotNullParameter(messageContent, "content");
        Intrinsics.checkNotNullParameter(str3, "localId");
        this.id = str;
        this.author = author2;
        this.status = messageStatus;
        this.created = localDateTime;
        this.received = localDateTime2;
        this.beforeTimestamp = d;
        this.content = messageContent;
        this.metadata = map;
        this.sourceId = str2;
        this.localId = str3;
        this.payload = str4;
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

    public final LocalDateTime getCreated() {
        return this.created;
    }

    public final LocalDateTime getReceived() {
        return this.received;
    }

    public final double getBeforeTimestamp() {
        return this.beforeTimestamp;
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

    public final String getPayload() {
        return this.payload;
    }

    public final EssentialMessageData getEssentialMessageData$zendesk_conversationkit_conversationkit_android() {
        return new EssentialMessageData(this);
    }

    public final LocalDateTime getTimestamp() {
        LocalDateTime localDateTime = this.created;
        return localDateTime == null ? this.received : localDateTime;
    }

    public boolean equals(Object obj) {
        return (obj instanceof Message) && Intrinsics.areEqual((Object) getEssentialMessageData$zendesk_conversationkit_conversationkit_android(), (Object) ((Message) obj).getEssentialMessageData$zendesk_conversationkit_conversationkit_android());
    }

    public int hashCode() {
        return getEssentialMessageData$zendesk_conversationkit_conversationkit_android().hashCode();
    }

    public String toString() {
        return StringsKt.replaceFirst$default(getEssentialMessageData$zendesk_conversationkit_conversationkit_android().toString(), "EssentialMessageData", "Message", false, 4, (Object) null);
    }

    public final boolean isAuthoredBy(Participant participant) {
        return Intrinsics.areEqual((Object) this.author.getUserId(), (Object) participant != null ? participant.getUserId() : null);
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tH\u0007¨\u0006\u000b"}, d2 = {"Lzendesk/conversationkit/android/model/Message$Companion;", "", "()V", "create", "Lzendesk/conversationkit/android/model/Message;", "content", "Lzendesk/conversationkit/android/model/MessageContent;", "metadata", "", "", "payload", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Message.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Message create(MessageContent messageContent) {
            Intrinsics.checkNotNullParameter(messageContent, "content");
            return create$default(this, messageContent, (Map) null, (String) null, 6, (Object) null);
        }

        @JvmStatic
        public final Message create(MessageContent messageContent, Map<String, ? extends Object> map) {
            Intrinsics.checkNotNullParameter(messageContent, "content");
            return create$default(this, messageContent, map, (String) null, 4, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ Message create$default(Companion companion, MessageContent messageContent, Map map, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                map = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            return companion.create(messageContent, map, str);
        }

        @JvmStatic
        public final Message create(MessageContent messageContent, Map<String, ? extends Object> map, String str) {
            MessageContent messageContent2 = messageContent;
            Intrinsics.checkNotNullParameter(messageContent2, "content");
            String uuid = UUID.randomUUID().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
            LocalDateTime now = LocalDateTime.now();
            Author author = new Author((String) null, (AuthorType) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
            MessageStatus messageStatus = MessageStatus.PENDING;
            Intrinsics.checkNotNullExpressionValue(now, "currentTime");
            return new Message(uuid, author, messageStatus, now, now, (double) TimeUnit.MILLISECONDS.toSeconds(DateKtxKt.toTimestamp$default(now, (ZoneId) null, 1, (Object) null)), messageContent2, map, (String) null, uuid, str);
        }
    }
}
