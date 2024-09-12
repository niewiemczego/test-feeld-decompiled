package zendesk.ui.android.conversation.form;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u000e\u000f\u0010B'\b\u0004\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f\u0001\u0003\u0011\u0012\u0013¨\u0006\u0014"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState;", "", "placeholder", "", "label", "borderColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBorderColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel$zendesk_ui_ui_android", "()Ljava/lang/String;", "getPlaceholder$zendesk_ui_ui_android", "Email", "Select", "Text", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FieldState.kt */
public abstract class FieldState {
    private final Integer borderColor;
    private final String label;
    private final String placeholder;

    public /* synthetic */ FieldState(String str, String str2, Integer num, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, num);
    }

    private FieldState(String str, String str2, Integer num) {
        this.placeholder = str;
        this.label = str2;
        this.borderColor = num;
    }

    public String getPlaceholder$zendesk_ui_ui_android() {
        return this.placeholder;
    }

    public String getLabel$zendesk_ui_ui_android() {
        return this.label;
    }

    public Integer getBorderColor$zendesk_ui_ui_android() {
        return this.borderColor;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001(BK\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000e\u0010\u0016\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0017J\u000e\u0010\u0018\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0019J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u001bJ\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u0005HÀ\u0003¢\u0006\u0004\b\u001f\u0010\fJR\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010!J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006)"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Text;", "Lzendesk/ui/android/conversation/form/FieldState;", "text", "", "minLength", "", "maxLength", "placeholder", "label", "borderColor", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBorderColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel$zendesk_ui_ui_android", "()Ljava/lang/String;", "getMaxLength$zendesk_ui_ui_android", "()I", "getMinLength$zendesk_ui_ui_android", "getPlaceholder$zendesk_ui_ui_android", "getText", "component1", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Text;", "equals", "", "other", "", "hashCode", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldState.kt */
    public static final class Text extends FieldState {
        private final Integer borderColor;
        private final String label;
        private final int maxLength;
        private final int minLength;
        private final String placeholder;
        private final String text;

        public Text() {
            this((String) null, 0, 0, (String) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Text copy$default(Text text2, String str, int i, int i2, String str2, String str3, Integer num, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = text2.text;
            }
            if ((i3 & 2) != 0) {
                i = text2.minLength;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                i2 = text2.maxLength;
            }
            int i5 = i2;
            if ((i3 & 8) != 0) {
                str2 = text2.getPlaceholder$zendesk_ui_ui_android();
            }
            String str4 = str2;
            if ((i3 & 16) != 0) {
                str3 = text2.getLabel$zendesk_ui_ui_android();
            }
            String str5 = str3;
            if ((i3 & 32) != 0) {
                num = text2.getBorderColor$zendesk_ui_ui_android();
            }
            return text2.copy(str, i4, i5, str4, str5, num);
        }

        public final String component1() {
            return this.text;
        }

        public final int component2$zendesk_ui_ui_android() {
            return this.minLength;
        }

        public final int component3$zendesk_ui_ui_android() {
            return this.maxLength;
        }

        public final String component4$zendesk_ui_ui_android() {
            return getPlaceholder$zendesk_ui_ui_android();
        }

        public final String component5$zendesk_ui_ui_android() {
            return getLabel$zendesk_ui_ui_android();
        }

        public final Integer component6$zendesk_ui_ui_android() {
            return getBorderColor$zendesk_ui_ui_android();
        }

        public final Text copy(String str, int i, int i2, String str2, String str3, Integer num) {
            return new Text(str, i, i2, str2, str3, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Text)) {
                return false;
            }
            Text text2 = (Text) obj;
            return Intrinsics.areEqual((Object) this.text, (Object) text2.text) && this.minLength == text2.minLength && this.maxLength == text2.maxLength && Intrinsics.areEqual((Object) getPlaceholder$zendesk_ui_ui_android(), (Object) text2.getPlaceholder$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getLabel$zendesk_ui_ui_android(), (Object) text2.getLabel$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getBorderColor$zendesk_ui_ui_android(), (Object) text2.getBorderColor$zendesk_ui_ui_android());
        }

        public int hashCode() {
            String str = this.text;
            int i = 0;
            int hashCode = (((((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.minLength)) * 31) + Integer.hashCode(this.maxLength)) * 31) + (getPlaceholder$zendesk_ui_ui_android() == null ? 0 : getPlaceholder$zendesk_ui_ui_android().hashCode())) * 31) + (getLabel$zendesk_ui_ui_android() == null ? 0 : getLabel$zendesk_ui_ui_android().hashCode())) * 31;
            if (getBorderColor$zendesk_ui_ui_android() != null) {
                i = getBorderColor$zendesk_ui_ui_android().hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Text(text=" + this.text + ", minLength=" + this.minLength + ", maxLength=" + this.maxLength + ", placeholder=" + getPlaceholder$zendesk_ui_ui_android() + ", label=" + getLabel$zendesk_ui_ui_android() + ", borderColor=" + getBorderColor$zendesk_ui_ui_android() + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Text(java.lang.String r6, int r7, int r8, java.lang.String r9, java.lang.String r10, java.lang.Integer r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
            /*
                r5 = this;
                r13 = r12 & 1
                r0 = 0
                if (r13 == 0) goto L_0x0007
                r13 = r0
                goto L_0x0008
            L_0x0007:
                r13 = r6
            L_0x0008:
                r6 = r12 & 2
                if (r6 == 0) goto L_0x000d
                r7 = 0
            L_0x000d:
                r1 = r7
                r6 = r12 & 4
                if (r6 == 0) goto L_0x0015
                r8 = 2147483647(0x7fffffff, float:NaN)
            L_0x0015:
                r2 = r8
                r6 = r12 & 8
                if (r6 == 0) goto L_0x001c
                r3 = r0
                goto L_0x001d
            L_0x001c:
                r3 = r9
            L_0x001d:
                r6 = r12 & 16
                if (r6 == 0) goto L_0x0023
                r4 = r0
                goto L_0x0024
            L_0x0023:
                r4 = r10
            L_0x0024:
                r6 = r12 & 32
                if (r6 == 0) goto L_0x002a
                r12 = r0
                goto L_0x002b
            L_0x002a:
                r12 = r11
            L_0x002b:
                r6 = r5
                r7 = r13
                r8 = r1
                r9 = r2
                r10 = r3
                r11 = r4
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FieldState.Text.<init>(java.lang.String, int, int, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final String getText() {
            return this.text;
        }

        public final int getMinLength$zendesk_ui_ui_android() {
            return this.minLength;
        }

        public final int getMaxLength$zendesk_ui_ui_android() {
            return this.maxLength;
        }

        public String getPlaceholder$zendesk_ui_ui_android() {
            return this.placeholder;
        }

        public String getLabel$zendesk_ui_ui_android() {
            return this.label;
        }

        public Integer getBorderColor$zendesk_ui_ui_android() {
            return this.borderColor;
        }

        public Text(String str, int i, int i2, String str2, String str3, Integer num) {
            super(str2, str3, num, (DefaultConstructorMarker) null);
            this.text = str;
            this.minLength = i;
            this.maxLength = i2;
            this.placeholder = str2;
            this.label = str3;
            this.borderColor = num;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0006J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010\r\u001a\u00020\u00002\b\u0010\r\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000e\u001a\u00020\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Text$Builder;", "", "()V", "state", "Lzendesk/ui/android/conversation/form/FieldState$Text;", "borderColor", "", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Text$Builder;", "build", "label", "", "maxLength", "minLength", "placeholder", "text", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldState.kt */
        public static final class Builder {
            private Text state = new Text((String) null, 0, 0, (String) null, (String) null, (Integer) null, 63, (DefaultConstructorMarker) null);

            public final Builder text(String str) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, str, 0, 0, (String) null, (String) null, (Integer) null, 62, (Object) null);
                return this;
            }

            public final Builder minLength(int i) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, (String) null, RangesKt.coerceAtLeast(i, 0), 0, (String) null, (String) null, (Integer) null, 61, (Object) null);
                return this;
            }

            public final Builder maxLength(int i) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, (String) null, 0, i, (String) null, (String) null, (Integer) null, 59, (Object) null);
                return this;
            }

            public final Builder placeholder(String str) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, (String) null, 0, 0, str, (String) null, (Integer) null, 55, (Object) null);
                return this;
            }

            public final Builder label(String str) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, (String) null, 0, 0, (String) null, str, (Integer) null, 47, (Object) null);
                return this;
            }

            public final Builder borderColor(Integer num) {
                Builder builder = this;
                this.state = Text.copy$default(this.state, (String) null, 0, 0, (String) null, (String) null, num, 31, (Object) null);
                return this;
            }

            public final Text build() {
                return this.state;
            }
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001\u001fB7\b\u0000\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0012J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u0014J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0004\b\u0016\u0010\nJ>\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006 "}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Email;", "Lzendesk/ui/android/conversation/form/FieldState;", "email", "", "placeholder", "label", "borderColor", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBorderColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getEmail", "()Ljava/lang/String;", "getLabel$zendesk_ui_ui_android", "getPlaceholder$zendesk_ui_ui_android", "component1", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Email;", "equals", "", "other", "", "hashCode", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldState.kt */
    public static final class Email extends FieldState {
        private final Integer borderColor;
        private final String email;
        private final String label;
        private final String placeholder;

        public Email() {
            this((String) null, (String) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Email copy$default(Email email2, String str, String str2, String str3, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                str = email2.email;
            }
            if ((i & 2) != 0) {
                str2 = email2.getPlaceholder$zendesk_ui_ui_android();
            }
            if ((i & 4) != 0) {
                str3 = email2.getLabel$zendesk_ui_ui_android();
            }
            if ((i & 8) != 0) {
                num = email2.getBorderColor$zendesk_ui_ui_android();
            }
            return email2.copy(str, str2, str3, num);
        }

        public final String component1() {
            return this.email;
        }

        public final String component2$zendesk_ui_ui_android() {
            return getPlaceholder$zendesk_ui_ui_android();
        }

        public final String component3$zendesk_ui_ui_android() {
            return getLabel$zendesk_ui_ui_android();
        }

        public final Integer component4$zendesk_ui_ui_android() {
            return getBorderColor$zendesk_ui_ui_android();
        }

        public final Email copy(String str, String str2, String str3, Integer num) {
            return new Email(str, str2, str3, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Email)) {
                return false;
            }
            Email email2 = (Email) obj;
            return Intrinsics.areEqual((Object) this.email, (Object) email2.email) && Intrinsics.areEqual((Object) getPlaceholder$zendesk_ui_ui_android(), (Object) email2.getPlaceholder$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getLabel$zendesk_ui_ui_android(), (Object) email2.getLabel$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getBorderColor$zendesk_ui_ui_android(), (Object) email2.getBorderColor$zendesk_ui_ui_android());
        }

        public int hashCode() {
            String str = this.email;
            int i = 0;
            int hashCode = (((((str == null ? 0 : str.hashCode()) * 31) + (getPlaceholder$zendesk_ui_ui_android() == null ? 0 : getPlaceholder$zendesk_ui_ui_android().hashCode())) * 31) + (getLabel$zendesk_ui_ui_android() == null ? 0 : getLabel$zendesk_ui_ui_android().hashCode())) * 31;
            if (getBorderColor$zendesk_ui_ui_android() != null) {
                i = getBorderColor$zendesk_ui_ui_android().hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Email(email=" + this.email + ", placeholder=" + getPlaceholder$zendesk_ui_ui_android() + ", label=" + getLabel$zendesk_ui_ui_android() + ", borderColor=" + getBorderColor$zendesk_ui_ui_android() + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Email(String str, String str2, String str3, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : num);
        }

        public final String getEmail() {
            return this.email;
        }

        public String getPlaceholder$zendesk_ui_ui_android() {
            return this.placeholder;
        }

        public String getLabel$zendesk_ui_ui_android() {
            return this.label;
        }

        public Integer getBorderColor$zendesk_ui_ui_android() {
            return this.borderColor;
        }

        public Email(String str, String str2, String str3, Integer num) {
            super(str2, str3, num, (DefaultConstructorMarker) null);
            this.email = str;
            this.placeholder = str2;
            this.label = str3;
            this.borderColor = num;
        }

        @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u000b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\u0010\u0010\f\u001a\u00020\u00002\b\u0010\f\u001a\u0004\u0018\u00010\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Email$Builder;", "", "()V", "state", "Lzendesk/ui/android/conversation/form/FieldState$Email;", "borderColor", "", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Email$Builder;", "build", "email", "", "label", "placeholder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldState.kt */
        public static final class Builder {
            private Email state = new Email((String) null, (String) null, (String) null, (Integer) null, 15, (DefaultConstructorMarker) null);

            public final Builder email(String str) {
                Builder builder = this;
                this.state = Email.copy$default(this.state, str, (String) null, (String) null, (Integer) null, 14, (Object) null);
                return this;
            }

            public final Builder placeholder(String str) {
                Builder builder = this;
                this.state = Email.copy$default(this.state, (String) null, str, (String) null, (Integer) null, 13, (Object) null);
                return this;
            }

            public final Builder label(String str) {
                Builder builder = this;
                this.state = Email.copy$default(this.state, (String) null, (String) null, str, (Integer) null, 11, (Object) null);
                return this;
            }

            public final Builder borderColor(Integer num) {
                Builder builder = this;
                this.state = Email.copy$default(this.state, (String) null, (String) null, (String) null, num, 7, (Object) null);
                return this;
            }

            public final Email build() {
                return this.state;
            }
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001:\u0001%BK\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÀ\u0003¢\u0006\u0002\b\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\nHÀ\u0003¢\u0006\u0004\b\u001c\u0010\rJR\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\nHÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0018\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR\u0016\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006&"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Select;", "Lzendesk/ui/android/conversation/form/FieldState;", "options", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "select", "placeholder", "", "label", "borderColor", "", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "getBorderColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel$zendesk_ui_ui_android", "()Ljava/lang/String;", "getOptions", "()Ljava/util/List;", "getPlaceholder$zendesk_ui_ui_android", "getSelect", "component1", "component2", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Select;", "equals", "", "other", "", "hashCode", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FieldState.kt */
    public static final class Select extends FieldState {
        private final Integer borderColor;
        private final String label;
        private final List<SelectOption> options;
        private final String placeholder;
        private final List<SelectOption> select;

        public Select() {
            this((List) null, (List) null, (String) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Select copy$default(Select select2, List<SelectOption> list, List<SelectOption> list2, String str, String str2, Integer num, int i, Object obj) {
            if ((i & 1) != 0) {
                list = select2.options;
            }
            if ((i & 2) != 0) {
                list2 = select2.select;
            }
            List<SelectOption> list3 = list2;
            if ((i & 4) != 0) {
                str = select2.getPlaceholder$zendesk_ui_ui_android();
            }
            String str3 = str;
            if ((i & 8) != 0) {
                str2 = select2.getLabel$zendesk_ui_ui_android();
            }
            String str4 = str2;
            if ((i & 16) != 0) {
                num = select2.getBorderColor$zendesk_ui_ui_android();
            }
            return select2.copy(list, list3, str3, str4, num);
        }

        public final List<SelectOption> component1() {
            return this.options;
        }

        public final List<SelectOption> component2() {
            return this.select;
        }

        public final String component3$zendesk_ui_ui_android() {
            return getPlaceholder$zendesk_ui_ui_android();
        }

        public final String component4$zendesk_ui_ui_android() {
            return getLabel$zendesk_ui_ui_android();
        }

        public final Integer component5$zendesk_ui_ui_android() {
            return getBorderColor$zendesk_ui_ui_android();
        }

        public final Select copy(List<SelectOption> list, List<SelectOption> list2, String str, String str2, Integer num) {
            Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            Intrinsics.checkNotNullParameter(list2, "select");
            return new Select(list, list2, str, str2, num);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Select)) {
                return false;
            }
            Select select2 = (Select) obj;
            return Intrinsics.areEqual((Object) this.options, (Object) select2.options) && Intrinsics.areEqual((Object) this.select, (Object) select2.select) && Intrinsics.areEqual((Object) getPlaceholder$zendesk_ui_ui_android(), (Object) select2.getPlaceholder$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getLabel$zendesk_ui_ui_android(), (Object) select2.getLabel$zendesk_ui_ui_android()) && Intrinsics.areEqual((Object) getBorderColor$zendesk_ui_ui_android(), (Object) select2.getBorderColor$zendesk_ui_ui_android());
        }

        public int hashCode() {
            int i = 0;
            int hashCode = ((((((this.options.hashCode() * 31) + this.select.hashCode()) * 31) + (getPlaceholder$zendesk_ui_ui_android() == null ? 0 : getPlaceholder$zendesk_ui_ui_android().hashCode())) * 31) + (getLabel$zendesk_ui_ui_android() == null ? 0 : getLabel$zendesk_ui_ui_android().hashCode())) * 31;
            if (getBorderColor$zendesk_ui_ui_android() != null) {
                i = getBorderColor$zendesk_ui_ui_android().hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "Select(options=" + this.options + ", select=" + this.select + ", placeholder=" + getPlaceholder$zendesk_ui_ui_android() + ", label=" + getLabel$zendesk_ui_ui_android() + ", borderColor=" + getBorderColor$zendesk_ui_ui_android() + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Select(java.util.List r4, java.util.List r5, java.lang.String r6, java.lang.String r7, java.lang.Integer r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
            /*
                r3 = this;
                r10 = r9 & 1
                if (r10 == 0) goto L_0x0008
                java.util.List r4 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0008:
                r10 = r9 & 2
                if (r10 == 0) goto L_0x0010
                java.util.List r5 = kotlin.collections.CollectionsKt.emptyList()
            L_0x0010:
                r10 = r5
                r5 = r9 & 4
                r0 = 0
                if (r5 == 0) goto L_0x0018
                r1 = r0
                goto L_0x0019
            L_0x0018:
                r1 = r6
            L_0x0019:
                r5 = r9 & 8
                if (r5 == 0) goto L_0x001f
                r2 = r0
                goto L_0x0020
            L_0x001f:
                r2 = r7
            L_0x0020:
                r5 = r9 & 16
                if (r5 == 0) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r0 = r8
            L_0x0026:
                r5 = r3
                r6 = r4
                r7 = r10
                r8 = r1
                r9 = r2
                r10 = r0
                r5.<init>(r6, r7, r8, r9, r10)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.form.FieldState.Select.<init>(java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final List<SelectOption> getOptions() {
            return this.options;
        }

        public final List<SelectOption> getSelect() {
            return this.select;
        }

        public String getPlaceholder$zendesk_ui_ui_android() {
            return this.placeholder;
        }

        public String getLabel$zendesk_ui_ui_android() {
            return this.label;
        }

        public Integer getBorderColor$zendesk_ui_ui_android() {
            return this.borderColor;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Select(List<SelectOption> list, List<SelectOption> list2, String str, String str2, Integer num) {
            super(str, str2, num, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
            Intrinsics.checkNotNullParameter(list2, "select");
            this.options = list;
            this.select = list2;
            this.placeholder = str;
            this.label = str2;
            this.borderColor = num;
        }

        @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0005\u001a\u00020\u00002\n\b\u0001\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0006\u0010\b\u001a\u00020\u0004J\u0010\u0010\t\u001a\u00020\u00002\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001f\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u000b\u001a\u00020\u00002\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\u000fJ\u0010\u0010\u0010\u001a\u00020\u00002\b\u0010\u0010\u001a\u0004\u0018\u00010\nJ\u001f\u0010\u0011\u001a\u00020\u00002\u0012\u0010\u0011\u001a\n\u0012\u0006\b\u0001\u0012\u00020\r0\f\"\u00020\r¢\u0006\u0002\u0010\u000eJ\u0014\u0010\u0011\u001a\u00020\u00002\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u000fR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/form/FieldState$Select$Builder;", "", "()V", "state", "Lzendesk/ui/android/conversation/form/FieldState$Select;", "borderColor", "", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/form/FieldState$Select$Builder;", "build", "label", "", "options", "", "Lzendesk/ui/android/conversation/form/SelectOption;", "([Lzendesk/ui/android/conversation/form/SelectOption;)Lzendesk/ui/android/conversation/form/FieldState$Select$Builder;", "", "placeholder", "select", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: FieldState.kt */
        public static final class Builder {
            private Select state = new Select((List) null, (List) null, (String) null, (String) null, (Integer) null, 31, (DefaultConstructorMarker) null);

            public final Builder options(List<SelectOption> list) {
                Intrinsics.checkNotNullParameter(list, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                Builder builder = this;
                this.state = Select.copy$default(this.state, list, (List) null, (String) null, (String) null, (Integer) null, 30, (Object) null);
                return this;
            }

            public final Builder options(SelectOption... selectOptionArr) {
                Intrinsics.checkNotNullParameter(selectOptionArr, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
                Builder builder = this;
                this.state = Select.copy$default(this.state, ArraysKt.toList((T[]) selectOptionArr), (List) null, (String) null, (String) null, (Integer) null, 30, (Object) null);
                return this;
            }

            public final Builder select(List<SelectOption> list) {
                Intrinsics.checkNotNullParameter(list, "select");
                Builder builder = this;
                this.state = Select.copy$default(this.state, (List) null, list, (String) null, (String) null, (Integer) null, 29, (Object) null);
                return this;
            }

            public final Builder select(SelectOption... selectOptionArr) {
                Intrinsics.checkNotNullParameter(selectOptionArr, "select");
                Builder builder = this;
                this.state = Select.copy$default(this.state, (List) null, ArraysKt.toList((T[]) selectOptionArr), (String) null, (String) null, (Integer) null, 29, (Object) null);
                return this;
            }

            public final Builder placeholder(String str) {
                Builder builder = this;
                this.state = Select.copy$default(this.state, (List) null, (List) null, str, (String) null, (Integer) null, 27, (Object) null);
                return this;
            }

            public final Builder label(String str) {
                Builder builder = this;
                this.state = Select.copy$default(this.state, (List) null, (List) null, (String) null, str, (Integer) null, 23, (Object) null);
                return this;
            }

            public final Builder borderColor(Integer num) {
                Builder builder = this;
                this.state = Select.copy$default(this.state, (List) null, (List) null, (String) null, (String) null, num, 15, (Object) null);
                return this;
            }

            public final Select build() {
                return this.state;
            }
        }
    }
}
