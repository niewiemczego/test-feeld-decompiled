package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jk\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020$HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u001f\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageItemDto;", "", "title", "", "description", "actions", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "size", "metadata", "", "mediaUrl", "mediaType", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getActions", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getMediaType", "getMediaUrl", "getMetadata", "()Ljava/util/Map;", "getSize", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageItemDto {
    private final List<MessageActionDto> actions;
    private final String description;
    private final String mediaType;
    private final String mediaUrl;
    private final Map<String, Object> metadata;
    private final String size;
    private final String title;

    public static /* synthetic */ MessageItemDto copy$default(MessageItemDto messageItemDto, String str, String str2, List<MessageActionDto> list, String str3, Map<String, Object> map, String str4, String str5, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageItemDto.title;
        }
        if ((i & 2) != 0) {
            str2 = messageItemDto.description;
        }
        String str6 = str2;
        if ((i & 4) != 0) {
            list = messageItemDto.actions;
        }
        List<MessageActionDto> list2 = list;
        if ((i & 8) != 0) {
            str3 = messageItemDto.size;
        }
        String str7 = str3;
        if ((i & 16) != 0) {
            map = messageItemDto.metadata;
        }
        Map<String, Object> map2 = map;
        if ((i & 32) != 0) {
            str4 = messageItemDto.mediaUrl;
        }
        String str8 = str4;
        if ((i & 64) != 0) {
            str5 = messageItemDto.mediaType;
        }
        return messageItemDto.copy(str, str6, list2, str7, map2, str8, str5);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.description;
    }

    public final List<MessageActionDto> component3() {
        return this.actions;
    }

    public final String component4() {
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

    public final MessageItemDto copy(String str, String str2, List<MessageActionDto> list, String str3, Map<String, ? extends Object> map, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        return new MessageItemDto(str, str2, list, str3, map, str4, str5);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageItemDto)) {
            return false;
        }
        MessageItemDto messageItemDto = (MessageItemDto) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) messageItemDto.title) && Intrinsics.areEqual((Object) this.description, (Object) messageItemDto.description) && Intrinsics.areEqual((Object) this.actions, (Object) messageItemDto.actions) && Intrinsics.areEqual((Object) this.size, (Object) messageItemDto.size) && Intrinsics.areEqual((Object) this.metadata, (Object) messageItemDto.metadata) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) messageItemDto.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) messageItemDto.mediaType);
    }

    public int hashCode() {
        int hashCode = this.title.hashCode() * 31;
        String str = this.description;
        int i = 0;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.actions.hashCode()) * 31;
        String str2 = this.size;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Map<String, Object> map = this.metadata;
        int hashCode4 = (hashCode3 + (map == null ? 0 : map.hashCode())) * 31;
        String str3 = this.mediaUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.mediaType;
        if (str4 != null) {
            i = str4.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "MessageItemDto(title=" + this.title + ", description=" + this.description + ", actions=" + this.actions + ", size=" + this.size + ", metadata=" + this.metadata + ", mediaUrl=" + this.mediaUrl + ", mediaType=" + this.mediaType + ')';
    }

    public MessageItemDto(String str, String str2, List<MessageActionDto> list, String str3, Map<String, ? extends Object> map, String str4, String str5) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "actions");
        this.title = str;
        this.description = str2;
        this.actions = list;
        this.size = str3;
        this.metadata = map;
        this.mediaUrl = str4;
        this.mediaType = str5;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getDescription() {
        return this.description;
    }

    public final List<MessageActionDto> getActions() {
        return this.actions;
    }

    public final String getSize() {
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
