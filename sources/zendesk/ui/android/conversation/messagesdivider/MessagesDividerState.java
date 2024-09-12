package zendesk.ui.android.conversation.messagesdivider;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.internal.ColorExtKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\b\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001d\u001eB5\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\nJ<\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\u0006\u0010\u001a\u001a\u00020\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\nR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000f\u0010\n¨\u0006\u001f"}, d2 = {"Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;", "", "text", "", "dividerColor", "", "textColor", "textStyle", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDividerColor", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getText", "()Ljava/lang/String;", "getTextColor", "getTextStyle", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState$Builder;", "toString", "Builder", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessagesDividerState.kt */
public final class MessagesDividerState {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final float LABEL_ALPHA = 0.65f;
    private final Integer dividerColor;
    private final String text;
    private final Integer textColor;
    private final Integer textStyle;

    public MessagesDividerState() {
        this((String) null, (Integer) null, (Integer) null, (Integer) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessagesDividerState copy$default(MessagesDividerState messagesDividerState, String str, Integer num, Integer num2, Integer num3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messagesDividerState.text;
        }
        if ((i & 2) != 0) {
            num = messagesDividerState.dividerColor;
        }
        if ((i & 4) != 0) {
            num2 = messagesDividerState.textColor;
        }
        if ((i & 8) != 0) {
            num3 = messagesDividerState.textStyle;
        }
        return messagesDividerState.copy(str, num, num2, num3);
    }

    public final String component1() {
        return this.text;
    }

    public final Integer component2() {
        return this.dividerColor;
    }

    public final Integer component3() {
        return this.textColor;
    }

    public final Integer component4() {
        return this.textStyle;
    }

    public final MessagesDividerState copy(String str, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new MessagesDividerState(str, num, num2, num3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessagesDividerState)) {
            return false;
        }
        MessagesDividerState messagesDividerState = (MessagesDividerState) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) messagesDividerState.text) && Intrinsics.areEqual((Object) this.dividerColor, (Object) messagesDividerState.dividerColor) && Intrinsics.areEqual((Object) this.textColor, (Object) messagesDividerState.textColor) && Intrinsics.areEqual((Object) this.textStyle, (Object) messagesDividerState.textStyle);
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        Integer num = this.dividerColor;
        int i = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.textColor;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.textStyle;
        if (num3 != null) {
            i = num3.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return "MessagesDividerState(text=" + this.text + ", dividerColor=" + this.dividerColor + ", textColor=" + this.textColor + ", textStyle=" + this.textStyle + ')';
    }

    public MessagesDividerState(String str, Integer num, Integer num2, Integer num3) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.dividerColor = num;
        this.textColor = num2;
        this.textStyle = num3;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessagesDividerState(String str, Integer num, Integer num2, Integer num3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : num, (i & 4) != 0 ? null : num2, (i & 8) != 0 ? null : num3);
    }

    public final String getText() {
        return this.text;
    }

    public final Integer getDividerColor() {
        return this.dividerColor;
    }

    public final Integer getTextColor() {
        return this.textColor;
    }

    public final Integer getTextStyle() {
        return this.textStyle;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState$Builder;", "", "state", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;", "(Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;)V", "()V", "build", "dividerColor", "", "text", "", "textColor", "textStyle", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagesDividerState.kt */
    public static final class Builder {
        private MessagesDividerState state;

        public Builder() {
            this.state = new MessagesDividerState((String) null, (Integer) null, (Integer) null, (Integer) null, 15, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessagesDividerState messagesDividerState) {
            this();
            Intrinsics.checkNotNullParameter(messagesDividerState, "state");
            this.state = messagesDividerState;
        }

        public final Builder text(String str) {
            Intrinsics.checkNotNullParameter(str, "text");
            Builder builder = this;
            this.state = MessagesDividerState.copy$default(this.state, str, (Integer) null, (Integer) null, (Integer) null, 14, (Object) null);
            return this;
        }

        public final Builder dividerColor(int i) {
            Builder builder = this;
            this.state = MessagesDividerState.copy$default(this.state, (String) null, Integer.valueOf(i), (Integer) null, (Integer) null, 13, (Object) null);
            return this;
        }

        public final Builder textColor(int i) {
            Builder builder = this;
            this.state = MessagesDividerState.copy$default(this.state, (String) null, (Integer) null, Integer.valueOf(i), (Integer) null, 11, (Object) null);
            return this;
        }

        public final Builder textStyle(int i) {
            Builder builder = this;
            this.state = MessagesDividerState.copy$default(this.state, (String) null, (Integer) null, (Integer) null, Integer.valueOf(i), 7, (Object) null);
            return this;
        }

        public final MessagesDividerState build() {
            return this.state;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState$Companion;", "", "()V", "LABEL_ALPHA", "", "newMessagesDividerState", "Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;", "dividerColor", "", "context", "Landroid/content/Context;", "(Ljava/lang/Integer;Landroid/content/Context;)Lzendesk/ui/android/conversation/messagesdivider/MessagesDividerState;", "timeDividerState", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagesDividerState.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ MessagesDividerState newMessagesDividerState$default(Companion companion, Integer num, Context context, int i, Object obj) {
            if ((i & 1) != 0) {
                num = null;
            }
            return companion.newMessagesDividerState(num, context);
        }

        public final MessagesDividerState newMessagesDividerState(Integer num, Context context) {
            int i;
            Intrinsics.checkNotNullParameter(context, "context");
            Builder dividerColor = new Builder().textStyle(R.style.TextAppearance_MaterialComponents_Body2).dividerColor(num != null ? num.intValue() : ContextCompat.getColor(context, R.color.colorError));
            if (num != null) {
                i = num.intValue();
            } else {
                i = ColorExtKt.adjustAlpha(ContextCompat.getColor(context, R.color.colorOnBackground), 0.65f);
            }
            return dividerColor.textColor(i).build();
        }

        public final MessagesDividerState timeDividerState(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new Builder().textStyle(R.style.TextAppearance_MaterialComponents_Caption).dividerColor(ContextCompat.getColor(context, R.color.zuia_color_transparent)).textColor(ColorExtKt.adjustAlpha(ContextCompat.getColor(context, R.color.colorOnBackground), 0.65f)).build();
        }
    }
}
