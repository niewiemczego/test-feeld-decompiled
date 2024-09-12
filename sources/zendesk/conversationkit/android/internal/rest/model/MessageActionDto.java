package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b&\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\u0014\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0012J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010\u0014J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u00100\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\rHÆ\u0003J¦\u0001\u00101\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u00102J\u0013\u00103\u001a\u00020\b2\b\u00104\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001J\t\u00107\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0017R\u001f\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0017¨\u00068"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "", "id", "", "type", "text", "uri", "default", "", "iconUrl", "fallback", "payload", "metadata", "", "amount", "", "currency", "state", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)V", "getAmount", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCurrency", "()Ljava/lang/String;", "getDefault", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getFallback", "getIconUrl", "getId", "getMetadata", "()Ljava/util/Map;", "getPayload", "getState", "getText", "getType", "getUri", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;)Lzendesk/conversationkit/android/internal/rest/model/MessageActionDto;", "equals", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageActionDto {
    private final Long amount;
    private final String currency;

    /* renamed from: default  reason: not valid java name */
    private final Boolean f8default;
    private final String fallback;
    private final String iconUrl;
    private final String id;
    private final Map<String, Object> metadata;
    private final String payload;
    private final String state;
    private final String text;
    private final String type;
    private final String uri;

    public static /* synthetic */ MessageActionDto copy$default(MessageActionDto messageActionDto, String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, Map map, Long l, String str8, String str9, int i, Object obj) {
        MessageActionDto messageActionDto2 = messageActionDto;
        int i2 = i;
        return messageActionDto.copy((i2 & 1) != 0 ? messageActionDto2.id : str, (i2 & 2) != 0 ? messageActionDto2.type : str2, (i2 & 4) != 0 ? messageActionDto2.text : str3, (i2 & 8) != 0 ? messageActionDto2.uri : str4, (i2 & 16) != 0 ? messageActionDto2.f8default : bool, (i2 & 32) != 0 ? messageActionDto2.iconUrl : str5, (i2 & 64) != 0 ? messageActionDto2.fallback : str6, (i2 & 128) != 0 ? messageActionDto2.payload : str7, (i2 & 256) != 0 ? messageActionDto2.metadata : map, (i2 & 512) != 0 ? messageActionDto2.amount : l, (i2 & 1024) != 0 ? messageActionDto2.currency : str8, (i2 & 2048) != 0 ? messageActionDto2.state : str9);
    }

    public final String component1() {
        return this.id;
    }

    public final Long component10() {
        return this.amount;
    }

    public final String component11() {
        return this.currency;
    }

    public final String component12() {
        return this.state;
    }

    public final String component2() {
        return this.type;
    }

    public final String component3() {
        return this.text;
    }

    public final String component4() {
        return this.uri;
    }

    public final Boolean component5() {
        return this.f8default;
    }

    public final String component6() {
        return this.iconUrl;
    }

    public final String component7() {
        return this.fallback;
    }

    public final String component8() {
        return this.payload;
    }

    public final Map<String, Object> component9() {
        return this.metadata;
    }

    public final MessageActionDto copy(@Json(name = "_id") String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, Map<String, ? extends Object> map, Long l, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        String str10 = str2;
        Intrinsics.checkNotNullParameter(str10, "type");
        return new MessageActionDto(str, str10, str3, str4, bool, str5, str6, str7, map, l, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageActionDto)) {
            return false;
        }
        MessageActionDto messageActionDto = (MessageActionDto) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) messageActionDto.id) && Intrinsics.areEqual((Object) this.type, (Object) messageActionDto.type) && Intrinsics.areEqual((Object) this.text, (Object) messageActionDto.text) && Intrinsics.areEqual((Object) this.uri, (Object) messageActionDto.uri) && Intrinsics.areEqual((Object) this.f8default, (Object) messageActionDto.f8default) && Intrinsics.areEqual((Object) this.iconUrl, (Object) messageActionDto.iconUrl) && Intrinsics.areEqual((Object) this.fallback, (Object) messageActionDto.fallback) && Intrinsics.areEqual((Object) this.payload, (Object) messageActionDto.payload) && Intrinsics.areEqual((Object) this.metadata, (Object) messageActionDto.metadata) && Intrinsics.areEqual((Object) this.amount, (Object) messageActionDto.amount) && Intrinsics.areEqual((Object) this.currency, (Object) messageActionDto.currency) && Intrinsics.areEqual((Object) this.state, (Object) messageActionDto.state);
    }

    public int hashCode() {
        int hashCode = ((this.id.hashCode() * 31) + this.type.hashCode()) * 31;
        String str = this.text;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.uri;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.f8default;
        int hashCode4 = (hashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.iconUrl;
        int hashCode5 = (hashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.fallback;
        int hashCode6 = (hashCode5 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.payload;
        int hashCode7 = (hashCode6 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Map<String, Object> map = this.metadata;
        int hashCode8 = (hashCode7 + (map == null ? 0 : map.hashCode())) * 31;
        Long l = this.amount;
        int hashCode9 = (hashCode8 + (l == null ? 0 : l.hashCode())) * 31;
        String str6 = this.currency;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.state;
        if (str7 != null) {
            i = str7.hashCode();
        }
        return hashCode10 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MessageActionDto(id=").append(this.id).append(", type=").append(this.type).append(", text=").append(this.text).append(", uri=").append(this.uri).append(", default=").append(this.f8default).append(", iconUrl=").append(this.iconUrl).append(", fallback=").append(this.fallback).append(", payload=").append(this.payload).append(", metadata=").append(this.metadata).append(", amount=").append(this.amount).append(", currency=").append(this.currency).append(", state=");
        sb.append(this.state).append(')');
        return sb.toString();
    }

    public MessageActionDto(@Json(name = "_id") String str, String str2, String str3, String str4, Boolean bool, String str5, String str6, String str7, Map<String, ? extends Object> map, Long l, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "type");
        this.id = str;
        this.type = str2;
        this.text = str3;
        this.uri = str4;
        this.f8default = bool;
        this.iconUrl = str5;
        this.fallback = str6;
        this.payload = str7;
        this.metadata = map;
        this.amount = l;
        this.currency = str8;
        this.state = str9;
    }

    public final String getId() {
        return this.id;
    }

    public final String getType() {
        return this.type;
    }

    public final String getText() {
        return this.text;
    }

    public final String getUri() {
        return this.uri;
    }

    public final Boolean getDefault() {
        return this.f8default;
    }

    public final String getIconUrl() {
        return this.iconUrl;
    }

    public final String getFallback() {
        return this.fallback;
    }

    public final String getPayload() {
        return this.payload;
    }

    public final Map<String, Object> getMetadata() {
        return this.metadata;
    }

    public final Long getAmount() {
        return this.amount;
    }

    public final String getCurrency() {
        return this.currency;
    }

    public final String getState() {
        return this.state;
    }
}
