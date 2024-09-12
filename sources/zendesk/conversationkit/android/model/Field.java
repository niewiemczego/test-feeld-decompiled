package zendesk.conversationkit.android.model;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0011\u0012\u0013B\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0005\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0012\u0010\t\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\bR\u0012\u0010\u000b\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\bR\u0012\u0010\r\u001a\u00020\u0006X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0001\u0003\u0014\u0015\u0016¨\u0006\u0017"}, d2 = {"Lzendesk/conversationkit/android/model/Field;", "", "type", "Lzendesk/conversationkit/android/model/FieldType;", "(Lzendesk/conversationkit/android/model/FieldType;)V", "id", "", "getId", "()Ljava/lang/String;", "label", "getLabel", "name", "getName", "placeholder", "getPlaceholder", "getType", "()Lzendesk/conversationkit/android/model/FieldType;", "Email", "Select", "Text", "Lzendesk/conversationkit/android/model/Field$Text;", "Lzendesk/conversationkit/android/model/Field$Email;", "Lzendesk/conversationkit/android/model/Field$Select;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field.kt */
public abstract class Field {
    private final FieldType type;

    public /* synthetic */ Field(FieldType fieldType, DefaultConstructorMarker defaultConstructorMarker) {
        this(fieldType);
    }

    public abstract String getId();

    public abstract String getLabel();

    public abstract String getName();

    public abstract String getPlaceholder();

    private Field(FieldType fieldType) {
        this.type = fieldType;
    }

    public final FieldType getType() {
        return this.type;
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 #2\u00020\u0001:\u0001#B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\bHÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\rR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006$"}, d2 = {"Lzendesk/conversationkit/android/model/Field$Text;", "Lzendesk/conversationkit/android/model/Field;", "id", "", "name", "label", "placeholder", "minSize", "", "maxSize", "text", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;)V", "getId", "()Ljava/lang/String;", "getLabel", "getMaxSize", "()I", "getMinSize", "getName", "getPlaceholder", "getText", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Field.kt */
    public static final class Text extends Field {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int DEFAULT_MAX_SIZE = 128;
        public static final int DEFAULT_MIN_SIZE = 1;
        private final String id;
        private final String label;
        private final int maxSize;
        private final int minSize;
        private final String name;
        private final String placeholder;
        private final String text;

        public static /* synthetic */ Text copy$default(Text text2, String str, String str2, String str3, String str4, int i, int i2, String str5, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = text2.getId();
            }
            if ((i3 & 2) != 0) {
                str2 = text2.getName();
            }
            String str6 = str2;
            if ((i3 & 4) != 0) {
                str3 = text2.getLabel();
            }
            String str7 = str3;
            if ((i3 & 8) != 0) {
                str4 = text2.getPlaceholder();
            }
            String str8 = str4;
            if ((i3 & 16) != 0) {
                i = text2.minSize;
            }
            int i4 = i;
            if ((i3 & 32) != 0) {
                i2 = text2.maxSize;
            }
            int i5 = i2;
            if ((i3 & 64) != 0) {
                str5 = text2.text;
            }
            return text2.copy(str, str6, str7, str8, i4, i5, str5);
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
            return getPlaceholder();
        }

        public final int component5() {
            return this.minSize;
        }

        public final int component6() {
            return this.maxSize;
        }

        public final String component7() {
            return this.text;
        }

        public final Text copy(String str, String str2, String str3, String str4, int i, int i2, String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            String str6 = str5;
            Intrinsics.checkNotNullParameter(str6, "text");
            return new Text(str, str2, str3, str4, i, i2, str6);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text2 = (Text) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) text2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) text2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) text2.getLabel()) && Intrinsics.areEqual((Object) getPlaceholder(), (Object) text2.getPlaceholder()) && this.minSize == text2.minSize && this.maxSize == text2.maxSize && Intrinsics.areEqual((Object) this.text, (Object) text2.text);
        }

        public int hashCode() {
            return (((((((((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + getPlaceholder().hashCode()) * 31) + Integer.hashCode(this.minSize)) * 31) + Integer.hashCode(this.maxSize)) * 31) + this.text.hashCode();
        }

        public String toString() {
            return "Text(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", placeholder=" + getPlaceholder() + ", minSize=" + this.minSize + ", maxSize=" + this.maxSize + ", text=" + this.text + ')';
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

        public String getPlaceholder() {
            return this.placeholder;
        }

        public final int getMinSize() {
            return this.minSize;
        }

        public final int getMaxSize() {
            return this.maxSize;
        }

        public final String getText() {
            return this.text;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Text(String str, String str2, String str3, String str4, int i, int i2, String str5) {
            super(FieldType.TEXT, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            Intrinsics.checkNotNullParameter(str5, "text");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.placeholder = str4;
            this.minSize = i;
            this.maxSize = i2;
            this.text = str5;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lzendesk/conversationkit/android/model/Field$Text$Companion;", "", "()V", "DEFAULT_MAX_SIZE", "", "DEFAULT_MIN_SIZE", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Field.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J;\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001c"}, d2 = {"Lzendesk/conversationkit/android/model/Field$Email;", "Lzendesk/conversationkit/android/model/Field;", "id", "", "name", "label", "placeholder", "email", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmail", "()Ljava/lang/String;", "getId", "getLabel", "getName", "getPlaceholder", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Field.kt */
    public static final class Email extends Field {
        private final String email;
        private final String id;
        private final String label;
        private final String name;
        private final String placeholder;

        public static /* synthetic */ Email copy$default(Email email2, String str, String str2, String str3, String str4, String str5, int i, Object obj) {
            if ((i & 1) != 0) {
                str = email2.getId();
            }
            if ((i & 2) != 0) {
                str2 = email2.getName();
            }
            String str6 = str2;
            if ((i & 4) != 0) {
                str3 = email2.getLabel();
            }
            String str7 = str3;
            if ((i & 8) != 0) {
                str4 = email2.getPlaceholder();
            }
            String str8 = str4;
            if ((i & 16) != 0) {
                str5 = email2.email;
            }
            return email2.copy(str, str6, str7, str8, str5);
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
            return getPlaceholder();
        }

        public final String component5() {
            return this.email;
        }

        public final Email copy(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            Intrinsics.checkNotNullParameter(str5, "email");
            return new Email(str, str2, str3, str4, str5);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email2 = (Email) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) email2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) email2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) email2.getLabel()) && Intrinsics.areEqual((Object) getPlaceholder(), (Object) email2.getPlaceholder()) && Intrinsics.areEqual((Object) this.email, (Object) email2.email);
        }

        public int hashCode() {
            return (((((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + getPlaceholder().hashCode()) * 31) + this.email.hashCode();
        }

        public String toString() {
            return "Email(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", placeholder=" + getPlaceholder() + ", email=" + this.email + ')';
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

        public String getPlaceholder() {
            return this.placeholder;
        }

        public final String getEmail() {
            return this.email;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Email(String str, String str2, String str3, String str4, String str5) {
            super(FieldType.EMAIL, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            Intrinsics.checkNotNullParameter(str5, "email");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.placeholder = str4;
            this.email = str5;
        }
    }

    @JsonClass(generateAdapter = true)
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u0000 &2\u00020\u0001:\u0001&BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\u000bHÆ\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J[\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u000bHÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006'"}, d2 = {"Lzendesk/conversationkit/android/model/Field$Select;", "Lzendesk/conversationkit/android/model/Field;", "id", "", "name", "label", "placeholder", "options", "", "Lzendesk/conversationkit/android/model/FieldOption;", "selectSize", "", "select", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ILjava/util/List;)V", "getId", "()Ljava/lang/String;", "getLabel", "getName", "getOptions", "()Ljava/util/List;", "getPlaceholder", "getSelect", "getSelectSize", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "", "hashCode", "toString", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Field.kt */
    public static final class Select extends Field {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        public static final int DEFAULT_SELECT_SIZE = 1;
        private final String id;
        private final String label;
        private final String name;
        private final List<FieldOption> options;
        private final String placeholder;
        private final List<FieldOption> select;
        private final int selectSize;

        public static /* synthetic */ Select copy$default(Select select2, String str, String str2, String str3, String str4, List<FieldOption> list, int i, List<FieldOption> list2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = select2.getId();
            }
            if ((i2 & 2) != 0) {
                str2 = select2.getName();
            }
            String str5 = str2;
            if ((i2 & 4) != 0) {
                str3 = select2.getLabel();
            }
            String str6 = str3;
            if ((i2 & 8) != 0) {
                str4 = select2.getPlaceholder();
            }
            String str7 = str4;
            if ((i2 & 16) != 0) {
                list = select2.options;
            }
            List<FieldOption> list3 = list;
            if ((i2 & 32) != 0) {
                i = select2.selectSize;
            }
            int i3 = i;
            if ((i2 & 64) != 0) {
                list2 = select2.select;
            }
            return select2.copy(str, str5, str6, str7, list3, i3, list2);
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
            return getPlaceholder();
        }

        public final List<FieldOption> component5() {
            return this.options;
        }

        public final int component6() {
            return this.selectSize;
        }

        public final List<FieldOption> component7() {
            return this.select;
        }

        public final Select copy(String str, String str2, String str3, String str4, List<FieldOption> list, int i, List<FieldOption> list2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            List<FieldOption> list3 = list2;
            Intrinsics.checkNotNullParameter(list3, "select");
            return new Select(str, str2, str3, str4, list, i, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Select)) {
                return false;
            }
            Select select2 = (Select) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) select2.getId()) && Intrinsics.areEqual((Object) getName(), (Object) select2.getName()) && Intrinsics.areEqual((Object) getLabel(), (Object) select2.getLabel()) && Intrinsics.areEqual((Object) getPlaceholder(), (Object) select2.getPlaceholder()) && Intrinsics.areEqual((Object) this.options, (Object) select2.options) && this.selectSize == select2.selectSize && Intrinsics.areEqual((Object) this.select, (Object) select2.select);
        }

        public int hashCode() {
            return (((((((((((getId().hashCode() * 31) + getName().hashCode()) * 31) + getLabel().hashCode()) * 31) + getPlaceholder().hashCode()) * 31) + this.options.hashCode()) * 31) + Integer.hashCode(this.selectSize)) * 31) + this.select.hashCode();
        }

        public String toString() {
            return "Select(id=" + getId() + ", name=" + getName() + ", label=" + getLabel() + ", placeholder=" + getPlaceholder() + ", options=" + this.options + ", selectSize=" + this.selectSize + ", select=" + this.select + ')';
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

        public String getPlaceholder() {
            return this.placeholder;
        }

        public final List<FieldOption> getOptions() {
            return this.options;
        }

        public final int getSelectSize() {
            return this.selectSize;
        }

        public final List<FieldOption> getSelect() {
            return this.select;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(String str, String str2, String str3, String str4, List<FieldOption> list, int i, List<FieldOption> list2) {
            super(FieldType.SELECT, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "name");
            Intrinsics.checkNotNullParameter(str3, "label");
            Intrinsics.checkNotNullParameter(str4, ReactTextInputShadowNode.PROP_PLACEHOLDER);
            Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            Intrinsics.checkNotNullParameter(list2, "select");
            this.id = str;
            this.name = str2;
            this.label = str3;
            this.placeholder = str4;
            this.options = list;
            this.selectSize = i;
            this.select = list2;
        }

        @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lzendesk/conversationkit/android/model/Field$Select$Companion;", "", "()V", "DEFAULT_SELECT_SIZE", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: Field.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
