package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Ji\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\u0016\b\u0002\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u001f\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u0006("}, d2 = {"Lzendesk/conversationkit/android/model/MessageItem;", "", "title", "", "description", "actions", "", "Lzendesk/conversationkit/android/model/MessageAction;", "size", "Lzendesk/conversationkit/android/model/MessageItemSize;", "metadata", "", "mediaUrl", "mediaType", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lzendesk/conversationkit/android/model/MessageItemSize;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getActions", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getMediaType", "getMediaUrl", "getMetadata", "()Ljava/util/Map;", "getSize", "()Lzendesk/conversationkit/android/model/MessageItemSize;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageItem.kt */
public final class MessageItem {
    private final List<MessageAction> actions;
    private final String description;
    private final String mediaType;
    private final String mediaUrl;
    private final Map<String, Object> metadata;
    private final MessageItemSize size;
    private final String title;

    public static /* synthetic */ MessageItem copy$default(MessageItem messageItem, String str, String str2, List<MessageAction> list, MessageItemSize messageItemSize, Map<String, Object> map, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageItem.title;
        }
        if ((i & 2) != 0) {
            str2 = messageItem.description;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            list = messageItem.actions;
        }
        List<MessageAction> list2 = list;
        if ((i & 8) != 0) {
            messageItemSize = messageItem.size;
        }
        MessageItemSize messageItemSize2 = messageItemSize;
        if ((i & 16) != 0) {
            map = messageItem.metadata;
        }
        Map<String, Object> map2 = map;
        if ((i & 32) != 0) {
            str3 = messageItem.mediaUrl;
        }
        String str6 = str3;
        if ((i & 64) != 0) {
            str4 = messageItem.mediaType;
        }
        return messageItem.copy(str, str5, list2, messageItemSize2, map2, str6, str4);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final List<MessageAction> component3() {
        return this.actions;
    }

    public final MessageItemSize component4() {
        return this.size;
    }

    public final Map<String, Object> component5() {
        return this.metadata;
    }

    public final String component6() {
        return this.mediaUrl;
    }

    public final String component7() {
        return this.mediaType;
    }

    public final MessageItem copy(String str, String str2, List<? extends MessageAction> list, MessageItemSize messageItemSize, Map<String, ? extends Object> map, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(messageItemSize, "size");
        return new MessageItem(str, str2, list, messageItemSize, map, str3, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageItem)) {
            return false;
        }
        MessageItem messageItem = (MessageItem) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) messageItem.title) && Intrinsics.areEqual((Object) this.description, (Object) messageItem.description) && Intrinsics.areEqual((Object) this.actions, (Object) messageItem.actions) && this.size == messageItem.size && Intrinsics.areEqual((Object) this.metadata, (Object) messageItem.metadata) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) messageItem.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) messageItem.mediaType);
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actions.hashCode()) * 31) + this.size.hashCode()) * 31;
        Map<String, Object> map = this.metadata;
        int hashCode3 = (hashCode2 + (map == null ? 0 : map.hashCode())) * 31;
        String str2 = this.mediaUrl;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.mediaType;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        return "MessageItem(title=" + this.title + ", description=" + this.description + ", actions=" + this.actions + ", size=" + this.size + ", metadata=" + this.metadata + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ')';
    }

    public MessageItem(String str, String str2, List<? extends MessageAction> list, MessageItemSize messageItemSize, Map<String, ? extends Object> map, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        Intrinsics.checkNotNullParameter(messageItemSize, "size");
        this.title = str;
        this.description = str2;
        this.actions = list;
        this.size = messageItemSize;
        this.metadata = map;
        this.mediaUrl = str3;
        this.mediaType = str4;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<MessageAction> getActions() {
        return this.actions;
    }

    public final MessageItemSize getSize() {
        return this.size;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getMediaUrl() {
        return this.mediaUrl;
    }

    public final String getMediaType() {
        return this.mediaType;
    }
}
