package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010)\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0011\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010HÆ\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\u0017\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\bHÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u00102\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00103\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010\u001aJº\u0001\u00104\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u0016\b\u0002\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u00105J\u0013\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00109\u001a\u00020\fHÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0015\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u001f\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0015\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u001e\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0019\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0019\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\f¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001aR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006;"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "", "id", "", "name", "label", "type", "metadata", "", "placeholder", "text", "minSize", "", "maxSize", "email", "options", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldOptionDto;", "select", "selectSize", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)V", "getEmail", "()Ljava/lang/String;", "getId", "getLabel", "getMaxSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMetadata", "()Ljava/util/Map;", "getMinSize", "getName", "getOptions", "()Ljava/util/List;", "getPlaceholder", "getSelect", "getSelectSize", "getText", "getType", "component1", "component10", "component11", "component12", "component13", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Integer;)Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "equals", "", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageFieldDto {
    private final String email;
    private final String id;
    private final String label;
    private final Integer maxSize;
    private final Map<String, Object> metadata;
    private final Integer minSize;
    private final String name;
    private final List<MessageFieldOptionDto> options;
    private final String placeholder;
    private final List<MessageFieldOptionDto> select;
    private final Integer selectSize;
    private final String text;
    private final String type;

    public static /* synthetic */ MessageFieldDto copy$default(MessageFieldDto messageFieldDto, String str, String str2, String str3, String str4, Map map, String str5, String str6, Integer num, Integer num2, String str7, List list, List list2, Integer num3, int i, Object obj) {
        MessageFieldDto messageFieldDto2 = messageFieldDto;
        int i2 = i;
        return messageFieldDto.copy((i2 & 1) != 0 ? messageFieldDto2.id : str, (i2 & 2) != 0 ? messageFieldDto2.name : str2, (i2 & 4) != 0 ? messageFieldDto2.label : str3, (i2 & 8) != 0 ? messageFieldDto2.type : str4, (i2 & 16) != 0 ? messageFieldDto2.metadata : map, (i2 & 32) != 0 ? messageFieldDto2.placeholder : str5, (i2 & 64) != 0 ? messageFieldDto2.text : str6, (i2 & 128) != 0 ? messageFieldDto2.minSize : num, (i2 & 256) != 0 ? messageFieldDto2.maxSize : num2, (i2 & 512) != 0 ? messageFieldDto2.email : str7, (i2 & 1024) != 0 ? messageFieldDto2.options : list, (i2 & 2048) != 0 ? messageFieldDto2.select : list2, (i2 & 4096) != 0 ? messageFieldDto2.selectSize : num3);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.email;
    }

    public final List<MessageFieldOptionDto> component11() {
        return this.options;
    }

    public final List<MessageFieldOptionDto> component12() {
        return this.select;
    }

    public final Integer component13() {
        return this.selectSize;
    }

    public final String component2() {
        return this.name;
    }

    public final String component3() {
        return this.label;
    }

    public final String component4() {
        return this.type;
    }

    public final Map<String, Object> component5() {
        return this.metadata;
    }

    public final String component6() {
        return this.placeholder;
    }

    public final String component7() {
        return this.text;
    }

    public final Integer component8() {
        return this.minSize;
    }

    public final Integer component9() {
        return this.maxSize;
    }

    public final MessageFieldDto copy(@Json(name = "_id") String str, String str2, String str3, String str4, Map<String, ? extends Object> map, String str5, String str6, Integer num, Integer num2, String str7, List<MessageFieldOptionDto> list, List<MessageFieldOptionDto> list2, Integer num3) {
        String str8 = str;
        Intrinsics.checkNotNullParameter(str8, "id");
        String str9 = str2;
        Intrinsics.checkNotNullParameter(str9, "name");
        String str10 = str3;
        Intrinsics.checkNotNullParameter(str10, "label");
        String str11 = str4;
        Intrinsics.checkNotNullParameter(str11, "type");
        return new MessageFieldDto(str8, str9, str10, str11, map, str5, str6, num, num2, str7, list, list2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFieldDto)) {
            return false;
        }
        MessageFieldDto messageFieldDto = (MessageFieldDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messageFieldDto.id) && Intrinsics.areEqual((Object) this.name, (Object) messageFieldDto.name) && Intrinsics.areEqual((Object) this.label, (Object) messageFieldDto.label) && Intrinsics.areEqual((Object) this.type, (Object) messageFieldDto.type) && Intrinsics.areEqual((Object) this.metadata, (Object) messageFieldDto.metadata) && Intrinsics.areEqual((Object) this.placeholder, (Object) messageFieldDto.placeholder) && Intrinsics.areEqual((Object) this.text, (Object) messageFieldDto.text) && Intrinsics.areEqual((Object) this.minSize, (Object) messageFieldDto.minSize) && Intrinsics.areEqual((Object) this.maxSize, (Object) messageFieldDto.maxSize) && Intrinsics.areEqual((Object) this.email, (Object) messageFieldDto.email) && Intrinsics.areEqual((Object) this.options, (Object) messageFieldDto.options) && Intrinsics.areEqual((Object) this.select, (Object) messageFieldDto.select) && Intrinsics.areEqual((Object) this.selectSize, (Object) messageFieldDto.selectSize);
    }

    public int hashCode() {
        int hashCode = ((((((this.id.hashCode() * 31) + this.name.hashCode()) * 31) + this.label.hashCode()) * 31) + this.type.hashCode()) * 31;
        Map<String, Object> map = this.metadata;
        int i = 0;
        int hashCode2 = (hashCode + (map == null ? 0 : map.hashCode())) * 31;
        String str = this.placeholder;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.text;
        int hashCode4 = (hashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.minSize;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.maxSize;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.email;
        int hashCode7 = (hashCode6 + (str3 == null ? 0 : str3.hashCode())) * 31;
        List<MessageFieldOptionDto> list = this.options;
        int hashCode8 = (hashCode7 + (list == null ? 0 : list.hashCode())) * 31;
        List<MessageFieldOptionDto> list2 = this.select;
        int hashCode9 = (hashCode8 + (list2 == null ? 0 : list2.hashCode())) * 31;
        Integer num3 = this.selectSize;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode9 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageFieldDto(id=").append(this.id).append(", name=").append(this.name).append(", label=").append(this.label).append(", type=").append(this.type).append(", metadata=").append(this.metadata).append(", placeholder=").append(this.placeholder).append(", text=").append(this.text).append(", minSize=").append(this.minSize).append(", maxSize=").append(this.maxSize).append(", email=").append(this.email).append(", options=").append(this.options).append(", select=");
        sb.append(this.select).append(", selectSize=").append(this.selectSize).append(')');
        return sb.toString();
    }

    public MessageFieldDto(@Json(name = "_id") String str, String str2, String str3, String str4, Map<String, ? extends Object> map, String str5, String str6, Integer num, Integer num2, String str7, List<MessageFieldOptionDto> list, List<MessageFieldOptionDto> list2, Integer num3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "label");
        Intrinsics.checkNotNullParameter(str4, "type");
        this.id = str;
        this.name = str2;
        this.label = str3;
        this.type = str4;
        this.metadata = map;
        this.placeholder = str5;
        this.text = str6;
        this.minSize = num;
        this.maxSize = num2;
        this.email = str7;
        this.options = list;
        this.select = list2;
        this.selectSize = num3;
    }

    public final String getId() {
        return this.id;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getType() {
        return this.type;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getMinSize() {
        return this.minSize;
    }

    public final Integer getMaxSize() {
        return this.maxSize;
    }

    public final String getEmail() {
        return this.email;
    }

    public final List<MessageFieldOptionDto> getOptions() {
        return this.options;
    }

    public final List<MessageFieldOptionDto> getSelect() {
        return this.select;
    }

    public final Integer getSelectSize() {
        return this.selectSize;
    }
}
