package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bB\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018\u0012\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a\u0012\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001a\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f\u0012\b\u0010 \u001a\u0004\u0018\u00010!\u0012\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001a\u0012\b\u0010$\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010%\u001a\u0004\u0018\u00010&¢\u0006\u0002\u0010'J\t\u0010L\u001a\u00020\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010O\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010HÆ\u0003J\u000b\u0010P\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010R\u001a\u0004\u0018\u00010\u0014HÆ\u0003¢\u0006\u0002\u0010;J\u000b\u0010S\u001a\u0004\u0018\u00010\u0016HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0018HÆ\u0003J\u0011\u0010U\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001aHÆ\u0003J\u0011\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001aHÆ\u0003J\t\u0010W\u001a\u00020\u0003HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u001fHÆ\u0003J\u0010\u0010Y\u001a\u0004\u0018\u00010!HÆ\u0003¢\u0006\u0002\u0010/J\u0011\u0010Z\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001aHÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010&HÆ\u0003J\t\u0010]\u001a\u00020\u0003HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010`\u001a\u00020\tHÆ\u0003J\t\u0010a\u001a\u00020\u0003HÆ\u0003J\u000b\u0010b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010c\u001a\u0004\u0018\u00010\u0003HÆ\u0003JÂ\u0002\u0010d\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0010\b\u0002\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001a2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010!2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001a2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&HÆ\u0001¢\u0006\u0002\u0010eJ\u0013\u0010f\u001a\u00020!2\b\u0010g\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010h\u001a\u00020iHÖ\u0001J\t\u0010j\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b,\u0010+R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b-\u0010+R\u0015\u0010 \u001a\u0004\u0018\u00010!¢\u0006\n\n\u0002\u00100\u001a\u0004\b.\u0010/R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0016¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u001f¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0019\u0010\"\u001a\n\u0012\u0004\u0012\u00020#\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b5\u0010)R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b6\u0010+R\u0019\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001a¢\u0006\b\n\u0000\u001a\u0004\b7\u0010)R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0018¢\u0006\b\n\u0000\u001a\u0004\b8\u00109R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0014¢\u0006\n\n\u0002\u0010<\u001a\u0004\b:\u0010;R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b=\u0010+R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b>\u0010+R\u001f\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0010¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bA\u0010+R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bB\u0010+R\u0013\u0010$\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bC\u0010+R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\bD\u0010ER\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bF\u0010+R\u0013\u0010%\u001a\u0004\u0018\u00010&¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bI\u0010+R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010+R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\bK\u0010+¨\u0006k"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "", "id", "", "authorId", "role", "name", "avatarUrl", "received", "", "type", "text", "textFallback", "altText", "payload", "metadata", "", "mediaUrl", "mediaType", "mediaSize", "", "coordinates", "Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;", "location", "Lzendesk/conversationkit/android/internal/rest/model/LocationDto;", "actions", "", "Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "items", "Lzendesk/conversationkit/android/internal/rest/model/MessageItemDto;", "displaySettings", "Lzendesk/conversationkit/android/internal/rest/model/DisplaySettingsDto;", "blockChatInput", "", "fields", "Lzendesk/conversationkit/android/internal/rest/model/MessageFieldDto;", "quotedMessageId", "source", "Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;Lzendesk/conversationkit/android/internal/rest/model/LocationDto;Ljava/util/List;Ljava/util/List;Lzendesk/conversationkit/android/internal/rest/model/DisplaySettingsDto;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;)V", "getActions", "()Ljava/util/List;", "getAltText", "()Ljava/lang/String;", "getAuthorId", "getAvatarUrl", "getBlockChatInput", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getCoordinates", "()Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;", "getDisplaySettings", "()Lzendesk/conversationkit/android/internal/rest/model/DisplaySettingsDto;", "getFields", "getId", "getItems", "getLocation", "()Lzendesk/conversationkit/android/internal/rest/model/LocationDto;", "getMediaSize", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMediaType", "getMediaUrl", "getMetadata", "()Ljava/util/Map;", "getName", "getPayload", "getQuotedMessageId", "getReceived", "()D", "getRole", "getSource", "()Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;", "getText", "getTextFallback", "getType", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Lzendesk/conversationkit/android/internal/rest/model/CoordinatesDto;Lzendesk/conversationkit/android/internal/rest/model/LocationDto;Ljava/util/List;Ljava/util/List;Lzendesk/conversationkit/android/internal/rest/model/DisplaySettingsDto;Ljava/lang/Boolean;Ljava/util/List;Ljava/lang/String;Lzendesk/conversationkit/android/internal/rest/model/MessageSourceDto;)Lzendesk/conversationkit/android/internal/rest/model/MessageDto;", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageDto {
    private final List<MessageActionDto> actions;
    private final String altText;
    private final String authorId;
    private final String avatarUrl;
    private final Boolean blockChatInput;
    private final CoordinatesDto coordinates;
    private final DisplaySettingsDto displaySettings;
    private final List<MessageFieldDto> fields;
    private final String id;
    private final List<MessageItemDto> items;
    private final LocationDto location;
    private final Long mediaSize;
    private final String mediaType;
    private final String mediaUrl;
    private final Map<String, Object> metadata;
    private final String name;
    private final String payload;
    private final String quotedMessageId;
    private final double received;
    private final String role;
    private final MessageSourceDto source;
    private final String text;
    private final String textFallback;
    private final String type;

    public static /* synthetic */ MessageDto copy$default(MessageDto messageDto, String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, String str10, Map map, String str11, String str12, Long l, CoordinatesDto coordinatesDto, LocationDto locationDto, List list, List list2, DisplaySettingsDto displaySettingsDto, Boolean bool, List list3, String str13, MessageSourceDto messageSourceDto, int i, Object obj) {
        MessageDto messageDto2 = messageDto;
        int i2 = i;
        return messageDto.copy((i2 & 1) != 0 ? messageDto2.id : str, (i2 & 2) != 0 ? messageDto2.authorId : str2, (i2 & 4) != 0 ? messageDto2.role : str3, (i2 & 8) != 0 ? messageDto2.name : str4, (i2 & 16) != 0 ? messageDto2.avatarUrl : str5, (i2 & 32) != 0 ? messageDto2.received : d, (i2 & 64) != 0 ? messageDto2.type : str6, (i2 & 128) != 0 ? messageDto2.text : str7, (i2 & 256) != 0 ? messageDto2.textFallback : str8, (i2 & 512) != 0 ? messageDto2.altText : str9, (i2 & 1024) != 0 ? messageDto2.payload : str10, (i2 & 2048) != 0 ? messageDto2.metadata : map, (i2 & 4096) != 0 ? messageDto2.mediaUrl : str11, (i2 & 8192) != 0 ? messageDto2.mediaType : str12, (i2 & 16384) != 0 ? messageDto2.mediaSize : l, (i2 & 32768) != 0 ? messageDto2.coordinates : coordinatesDto, (i2 & 65536) != 0 ? messageDto2.location : locationDto, (i2 & 131072) != 0 ? messageDto2.actions : list, (i2 & 262144) != 0 ? messageDto2.items : list2, (i2 & 524288) != 0 ? messageDto2.displaySettings : displaySettingsDto, (i2 & 1048576) != 0 ? messageDto2.blockChatInput : bool, (i2 & 2097152) != 0 ? messageDto2.fields : list3, (i2 & 4194304) != 0 ? messageDto2.quotedMessageId : str13, (i2 & 8388608) != 0 ? messageDto2.source : messageSourceDto);
    }

    public final String component1() {
        return this.id;
    }

    public final String component10() {
        return this.altText;
    }

    public final String component11() {
        return this.payload;
    }

    public final Map<String, Object> component12() {
        return this.metadata;
    }

    public final String component13() {
        return this.mediaUrl;
    }

    public final String component14() {
        return this.mediaType;
    }

    public final Long component15() {
        return this.mediaSize;
    }

    public final CoordinatesDto component16() {
        return this.coordinates;
    }

    public final LocationDto component17() {
        return this.location;
    }

    public final List<MessageActionDto> component18() {
        return this.actions;
    }

    public final List<MessageItemDto> component19() {
        return this.items;
    }

    public final String component2() {
        return this.authorId;
    }

    public final DisplaySettingsDto component20() {
        return this.displaySettings;
    }

    public final Boolean component21() {
        return this.blockChatInput;
    }

    public final List<MessageFieldDto> component22() {
        return this.fields;
    }

    public final String component23() {
        return this.quotedMessageId;
    }

    public final MessageSourceDto component24() {
        return this.source;
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
        return this.textFallback;
    }

    public final MessageDto copy(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, String str10, Map<String, ? extends Object> map, String str11, String str12, Long l, CoordinatesDto coordinatesDto, LocationDto locationDto, List<MessageActionDto> list, List<MessageItemDto> list2, DisplaySettingsDto displaySettingsDto, Boolean bool, List<MessageFieldDto> list3, String str13, MessageSourceDto messageSourceDto) {
        String str14 = str;
        Intrinsics.checkNotNullParameter(str14, "id");
        Intrinsics.checkNotNullParameter(str2, "authorId");
        Intrinsics.checkNotNullParameter(str3, "role");
        Intrinsics.checkNotNullParameter(str6, "type");
        return new MessageDto(str14, str2, str3, str4, str5, d, str6, str7, str8, str9, str10, map, str11, str12, l, coordinatesDto, locationDto, list, list2, displaySettingsDto, bool, list3, str13, messageSourceDto);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageDto)) {
            return false;
        }
        MessageDto messageDto = (MessageDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messageDto.id) && Intrinsics.areEqual((Object) this.authorId, (Object) messageDto.authorId) && Intrinsics.areEqual((Object) this.role, (Object) messageDto.role) && Intrinsics.areEqual((Object) this.name, (Object) messageDto.name) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) messageDto.avatarUrl) && Intrinsics.areEqual((Object) Double.valueOf(this.received), (Object) Double.valueOf(messageDto.received)) && Intrinsics.areEqual((Object) this.type, (Object) messageDto.type) && Intrinsics.areEqual((Object) this.text, (Object) messageDto.text) && Intrinsics.areEqual((Object) this.textFallback, (Object) messageDto.textFallback) && Intrinsics.areEqual((Object) this.altText, (Object) messageDto.altText) && Intrinsics.areEqual((Object) this.payload, (Object) messageDto.payload) && Intrinsics.areEqual((Object) this.metadata, (Object) messageDto.metadata) && Intrinsics.areEqual((Object) this.mediaUrl, (Object) messageDto.mediaUrl) && Intrinsics.areEqual((Object) this.mediaType, (Object) messageDto.mediaType) && Intrinsics.areEqual((Object) this.mediaSize, (Object) messageDto.mediaSize) && Intrinsics.areEqual((Object) this.coordinates, (Object) messageDto.coordinates) && Intrinsics.areEqual((Object) this.location, (Object) messageDto.location) && Intrinsics.areEqual((Object) this.actions, (Object) messageDto.actions) && Intrinsics.areEqual((Object) this.items, (Object) messageDto.items) && Intrinsics.areEqual((Object) this.displaySettings, (Object) messageDto.displaySettings) && Intrinsics.areEqual((Object) this.blockChatInput, (Object) messageDto.blockChatInput) && Intrinsics.areEqual((Object) this.fields, (Object) messageDto.fields) && Intrinsics.areEqual((Object) this.quotedMessageId, (Object) messageDto.quotedMessageId) && Intrinsics.areEqual((Object) this.source, (Object) messageDto.source);
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
        String str4 = this.textFallback;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.altText;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.payload;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        Map<String, Object> map = this.metadata;
        int hashCode8 = (hashCode7 + (map == null ? 0 : map.hashCode())) * 31;
        String str7 = this.mediaUrl;
        int hashCode9 = (hashCode8 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.mediaType;
        int hashCode10 = (hashCode9 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Long l = this.mediaSize;
        int hashCode11 = (hashCode10 + (l == null ? 0 : l.hashCode())) * 31;
        CoordinatesDto coordinatesDto = this.coordinates;
        int hashCode12 = (hashCode11 + (coordinatesDto == null ? 0 : coordinatesDto.hashCode())) * 31;
        LocationDto locationDto = this.location;
        int hashCode13 = (hashCode12 + (locationDto == null ? 0 : locationDto.hashCode())) * 31;
        List<MessageActionDto> list = this.actions;
        int hashCode14 = (hashCode13 + (list == null ? 0 : list.hashCode())) * 31;
        List<MessageItemDto> list2 = this.items;
        int hashCode15 = (hashCode14 + (list2 == null ? 0 : list2.hashCode())) * 31;
        DisplaySettingsDto displaySettingsDto = this.displaySettings;
        int hashCode16 = (hashCode15 + (displaySettingsDto == null ? 0 : displaySettingsDto.hashCode())) * 31;
        Boolean bool = this.blockChatInput;
        int hashCode17 = (hashCode16 + (bool == null ? 0 : bool.hashCode())) * 31;
        List<MessageFieldDto> list3 = this.fields;
        int hashCode18 = (hashCode17 + (list3 == null ? 0 : list3.hashCode())) * 31;
        String str9 = this.quotedMessageId;
        int hashCode19 = (hashCode18 + (str9 == null ? 0 : str9.hashCode())) * 31;
        MessageSourceDto messageSourceDto = this.source;
        if (messageSourceDto != null) {
            i = messageSourceDto.hashCode();
        }
        return hashCode19 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageDto(id=").append(this.id).append(", authorId=").append(this.authorId).append(", role=").append(this.role).append(", name=").append(this.name).append(", avatarUrl=").append(this.avatarUrl).append(", received=").append(this.received).append(", type=").append(this.type).append(", text=").append(this.text).append(", textFallback=").append(this.textFallback).append(", altText=").append(this.altText).append(", payload=").append(this.payload).append(", metadata=");
        sb.append(this.metadata).append(", mediaUrl=").append(this.mediaUrl).append(", mediaType=").append(this.mediaType).append(", mediaSize=").append(this.mediaSize).append(", coordinates=").append(this.coordinates).append(", location=").append(this.location).append(", actions=").append(this.actions).append(", items=").append(this.items).append(", displaySettings=").append(this.displaySettings).append(", blockChatInput=").append(this.blockChatInput).append(", fields=").append(this.fields).append(", quotedMessageId=").append(this.quotedMessageId);
        sb.append(", source=").append(this.source).append(')');
        return sb.toString();
    }

    public MessageDto(@Json(name = "_id") String str, String str2, String str3, String str4, String str5, double d, String str6, String str7, String str8, String str9, String str10, Map<String, ? extends Object> map, String str11, String str12, Long l, CoordinatesDto coordinatesDto, LocationDto locationDto, List<MessageActionDto> list, List<MessageItemDto> list2, DisplaySettingsDto displaySettingsDto, Boolean bool, List<MessageFieldDto> list3, String str13, MessageSourceDto messageSourceDto) {
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
        this.textFallback = str8;
        this.altText = str9;
        this.payload = str10;
        this.metadata = map;
        this.mediaUrl = str11;
        this.mediaType = str12;
        this.mediaSize = l;
        this.coordinates = coordinatesDto;
        this.location = locationDto;
        this.actions = list;
        this.items = list2;
        this.displaySettings = displaySettingsDto;
        this.blockChatInput = bool;
        this.fields = list3;
        this.quotedMessageId = str13;
        this.source = messageSourceDto;
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

    public final String getTextFallback() {
        return this.textFallback;
    }

    public final String getAltText() {
        return this.altText;
    }

    public final String getPayload() {
        return this.payload;
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

    public final Long getMediaSize() {
        return this.mediaSize;
    }

    public final CoordinatesDto getCoordinates() {
        return this.coordinates;
    }

    public final LocationDto getLocation() {
        return this.location;
    }

    public final List<MessageActionDto> getActions() {
        return this.actions;
    }

    public final List<MessageItemDto> getItems() {
        return this.items;
    }

    public final DisplaySettingsDto getDisplaySettings() {
        return this.displaySettings;
    }

    public final Boolean getBlockChatInput() {
        return this.blockChatInput;
    }

    public final List<MessageFieldDto> getFields() {
        return this.fields;
    }

    public final String getQuotedMessageId() {
        return this.quotedMessageId;
    }

    public final MessageSourceDto getSource() {
        return this.source;
    }
}
