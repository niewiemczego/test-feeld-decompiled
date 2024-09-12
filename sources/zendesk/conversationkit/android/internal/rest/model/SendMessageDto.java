package zendesk.conversationkit.android.internal.rest.model;

import com.facebook.GraphRequest;
import com.squareup.moshi.JsonClass;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u000f\u0010B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R \u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b\u0001\u0002\u0011\u0012¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "", "type", "", "(Ljava/lang/String;)V", "metadata", "", "getMetadata", "()Ljava/util/Map;", "payload", "getPayload", "()Ljava/lang/String;", "role", "getRole", "getType", "FormResponse", "Text", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$Text;", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$FormResponse;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageRequestDto.kt */
public abstract class SendMessageDto {
    private final String type;

    public /* synthetic */ SendMessageDto(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract Map<String, Object> getMetadata();

    public abstract String getPayload();

    public abstract String getRole();

    private SendMessageDto(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003JA\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001b"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$Text;", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "role", "", "metadata", "", "", "payload", "text", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;)V", "getMetadata", "()Ljava/util/Map;", "getPayload", "()Ljava/lang/String;", "getRole", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendMessageRequestDto.kt */
    public static final class Text extends SendMessageDto {
        private final Map<String, Object> metadata;
        private final String payload;
        private final String role;
        private final String text;

        public static /* synthetic */ Text copy$default(Text text2, String str, Map<String, Object> map, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text2.getRole();
            }
            if ((i & 2) != 0) {
                map = text2.getMetadata();
            }
            if ((i & 4) != 0) {
                str2 = text2.getPayload();
            }
            if ((i & 8) != 0) {
                str3 = text2.text;
            }
            return text2.copy(str, map, str2, str3);
        }

        public final String component1() {
            return getRole();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return getPayload();
        }

        public final String component4() {
            return this.text;
        }

        public final Text copy(String str, Map<String, ? extends Object> map, String str2, String str3) {
            Intrinsics.checkNotNullParameter(str, "role");
            Intrinsics.checkNotNullParameter(str3, "text");
            return new Text(str, map, str2, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text2 = (Text) obj;
            return Intrinsics.areEqual((Object) getRole(), (Object) text2.getRole()) && Intrinsics.areEqual((Object) getMetadata(), (Object) text2.getMetadata()) && Intrinsics.areEqual((Object) getPayload(), (Object) text2.getPayload()) && Intrinsics.areEqual((Object) this.text, (Object) text2.text);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((getRole().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
            if (getPayload() != null) {
                i = getPayload().hashCode();
            }
            return ((hashCode + i) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Text(role=" + getRole() + ", metadata=" + getMetadata() + ", payload=" + getPayload() + ", text=" + this.text + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Text(String str, Map map, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str2, str3);
        }

        public String getRole() {
            return this.role;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public String getPayload() {
            return this.payload;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(String str, Map<String, ? extends Object> map, String str2, String str3) {
            super("text", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "role");
            Intrinsics.checkNotNullParameter(str3, "text");
            this.role = str;
            this.metadata = map;
            this.payload = str2;
            this.text = str3;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tHÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JQ\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\"\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006!"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto$FormResponse;", "Lzendesk/conversationkit/android/internal/rest/model/SendMessageDto;", "role", "", "metadata", "", "", "payload", "fields", "", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "quotedMessageId", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getFields", "()Ljava/util/List;", "getMetadata", "()Ljava/util/Map;", "getPayload", "()Ljava/lang/String;", "getQuotedMessageId", "getRole", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendMessageRequestDto.kt */
    public static final class FormResponse extends SendMessageDto {
        private final List<SendFieldResponseDto> fields;
        private final Map<String, Object> metadata;
        private final String payload;
        private final String quotedMessageId;
        private final String role;

        public static /* synthetic */ FormResponse copy$default(FormResponse formResponse, String str, Map<String, Object> map, String str2, List<SendFieldResponseDto> list, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = formResponse.getRole();
            }
            if ((i & 2) != 0) {
                map = formResponse.getMetadata();
            }
            Map<String, Object> map2 = map;
            if ((i & 4) != 0) {
                str2 = formResponse.getPayload();
            }
            String str4 = str2;
            if ((i & 8) != 0) {
                list = formResponse.fields;
            }
            List<SendFieldResponseDto> list2 = list;
            if ((i & 16) != 0) {
                str3 = formResponse.quotedMessageId;
            }
            return formResponse.copy(str, map2, str4, list2, str3);
        }

        public final String component1() {
            return getRole();
        }

        public final Map<String, Object> component2() {
            return getMetadata();
        }

        public final String component3() {
            return getPayload();
        }

        public final List<SendFieldResponseDto> component4() {
            return this.fields;
        }

        public final String component5() {
            return this.quotedMessageId;
        }

        public final FormResponse copy(String str, Map<String, ? extends Object> map, String str2, List<? extends SendFieldResponseDto> list, String str3) {
            Intrinsics.checkNotNullParameter(str, "role");
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            Intrinsics.checkNotNullParameter(str3, "quotedMessageId");
            return new FormResponse(str, map, str2, list, str3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FormResponse)) {
                return false;
            }
            FormResponse formResponse = (FormResponse) obj;
            return Intrinsics.areEqual((Object) getRole(), (Object) formResponse.getRole()) && Intrinsics.areEqual((Object) getMetadata(), (Object) formResponse.getMetadata()) && Intrinsics.areEqual((Object) getPayload(), (Object) formResponse.getPayload()) && Intrinsics.areEqual((Object) this.fields, (Object) formResponse.fields) && Intrinsics.areEqual((Object) this.quotedMessageId, (Object) formResponse.quotedMessageId);
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((getRole().hashCode() * 31) + (getMetadata() == null ? 0 : getMetadata().hashCode())) * 31;
            if (getPayload() != null) {
                i = getPayload().hashCode();
            }
            return ((((hashCode + i) * 31) + this.fields.hashCode()) * 31) + this.quotedMessageId.hashCode();
        }

        public String toString() {
            return "FormResponse(role=" + getRole() + ", metadata=" + getMetadata() + ", payload=" + getPayload() + ", fields=" + this.fields + ", quotedMessageId=" + this.quotedMessageId + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FormResponse(String str, Map map, String str2, List list, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : map, (i & 4) != 0 ? null : str2, list, str3);
        }

        public String getRole() {
            return this.role;
        }

        public Map<String, Object> getMetadata() {
            return this.metadata;
        }

        public String getPayload() {
            return this.payload;
        }

        public final List<SendFieldResponseDto> getFields() {
            return this.fields;
        }

        public final String getQuotedMessageId() {
            return this.quotedMessageId;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public FormResponse(String str, Map<String, ? extends Object> map, String str2, List<? extends SendFieldResponseDto> list, String str3) {
            super("formResponse", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "role");
            Intrinsics.checkNotNullParameter(list, GraphRequest.FIELDS_PARAM);
            Intrinsics.checkNotNullParameter(str3, "quotedMessageId");
            this.role = str;
            this.metadata = map;
            this.payload = str2;
            this.fields = list;
            this.quotedMessageId = str3;
        }
    }
}
