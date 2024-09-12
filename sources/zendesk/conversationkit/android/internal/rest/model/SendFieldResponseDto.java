package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.Json;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\r\u000e\u000fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0007\u0001\u0003\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "", "type", "", "(Ljava/lang/String;)V", "id", "getId", "()Ljava/lang/String;", "label", "getLabel", "name", "getName", "getType", "Email", "Select", "Text", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Text;", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Email;", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Select;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: SendMessageRequestDto.kt */
public abstract class SendFieldResponseDto {
    private final String type;

    public /* synthetic */ SendFieldResponseDto(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    public abstract String getId();

    public abstract String getLabel();

    public abstract String getName();

    private SendFieldResponseDto(String str) {
        this.type = str;
    }

    public final String getType() {
        return this.type;
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Text;", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "id", "", "name", "label", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "getName", "getText", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendMessageRequestDto.kt */
    public static final class Text extends SendFieldResponseDto {
        private final String id;
        private final String label;
        private final String name;
        private final String text;

        public static /* synthetic */ Text copy$default(Text text2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = text2.getId();
            }
            if ((i & 2) != 0) {
                str2 = text2.getName();
            }
            if ((i & 4) != 0) {
                str3 = text2.getLabel();
            }
            if ((i & 8) != 0) {
                str4 = text2.text;
            }
            return text2.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return getName();
        }

        public final String component3() {
            return getLabel();
        }

        public final String component4() {
            return this.text;
        }

        public final Text copy(@Json(name = "_id") String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, "text");
            return new Text(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text2 = (Text) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) text2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) text2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) text2.getLabel()) && Intrinsics.areEqual((Object) this.text, (Object) text2.text);
        }

        public int hashCode() {
            return (((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Text(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", text=" + this.text + ')';
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getLabel() {
            return this.label;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(@Json(name = "_id") String str, String str2, String str3, String str4) {
            super("text", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, "text");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.text = str4;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B'\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0019"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Email;", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "id", "", "name", "label", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "getLabel", "getName", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendMessageRequestDto.kt */
    public static final class Email extends SendFieldResponseDto {
        private final String email;
        private final String id;
        private final String label;
        private final String name;

        public static /* synthetic */ Email copy$default(Email email2, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = email2.getId();
            }
            if ((i & 2) != 0) {
                str2 = email2.getName();
            }
            if ((i & 4) != 0) {
                str3 = email2.getLabel();
            }
            if ((i & 8) != 0) {
                str4 = email2.email;
            }
            return email2.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return getName();
        }

        public final String component3() {
            return getLabel();
        }

        public final String component4() {
            return this.email;
        }

        public final Email copy(@Json(name = "_id") String str, String str2, String str3, String str4) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, "email");
            return new Email(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email2 = (Email) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) email2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) email2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) email2.getLabel()) && Intrinsics.areEqual((Object) this.email, (Object) email2.email);
        }

        public int hashCode() {
            return (((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + this.email.hashCode();
        }

        public String toString() {
            return "Email(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", email=" + this.email + ')';
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getLabel() {
            return this.label;
        }

        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Email(@Json(name = "_id") String str, String str2, String str3, String str4) {
            super("email", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, "email");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.email = str4;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J7\u0010\u0014\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto$Select;", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldResponseDto;", "id", "", "name", "label", "select", "", "Lzendesk/conversationkit/android/internal/rest/model/SendFieldSelectDto;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getLabel", "getName", "getSelect", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: SendMessageRequestDto.kt */
    public static final class Select extends SendFieldResponseDto {
        private final String id;
        private final String label;
        private final String name;
        private final List<SendFieldSelectDto> select;

        public static /* synthetic */ Select copy$default(Select select2, String str, String str2, String str3, List<SendFieldSelectDto> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = select2.getId();
            }
            if ((i & 2) != 0) {
                str2 = select2.getName();
            }
            if ((i & 4) != 0) {
                str3 = select2.getLabel();
            }
            if ((i & 8) != 0) {
                list = select2.select;
            }
            return select2.copy(str, str2, str3, list);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return getName();
        }

        public final String component3() {
            return getLabel();
        }

        public final List<SendFieldSelectDto> component4() {
            return this.select;
        }

        public final Select copy(@Json(name = "_id") String str, String str2, String str3, List<SendFieldSelectDto> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(list, "select");
            return new Select(str, str2, str3, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Select)) {
                return false;
            }
            Select select2 = (Select) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) select2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) select2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) select2.getLabel()) && Intrinsics.areEqual((Object) this.select, (Object) select2.select);
        }

        public int hashCode() {
            return (((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + this.select.hashCode();
        }

        public String toString() {
            return "Select(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", select=" + this.select + ')';
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String getLabel() {
            return this.label;
        }

        public final List<SendFieldSelectDto> getSelect() {
            return this.select;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(@Json(name = "_id") String str, String str2, String str3, List<SendFieldSelectDto> list) {
            super("select", (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(list, "select");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.select = list;
        }
    }
}
