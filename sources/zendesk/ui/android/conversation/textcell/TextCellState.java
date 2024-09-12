package zendesk.ui.android.conversation.textcell;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.conversation.actionbutton.ActionButton;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001,BS\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0018J\u0016\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÀ\u0003¢\u0006\u0002\b\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b\u001c\u0010\u000eJ\u0012\u0010\u001d\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b\u001e\u0010\u000eJ\u0012\u0010\u001f\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b \u0010\u000eJ\u0012\u0010!\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b\"\u0010\u000eJZ\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010$J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\bHÖ\u0001J\u0006\u0010)\u001a\u00020*J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\t\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0018\u0010\n\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0016\u0010\u000e¨\u0006-"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellState;", "", "messageText", "", "actions", "", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "textColor", "", "backgroundColor", "backgroundDrawable", "actionColor", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getActionColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getActions$zendesk_ui_ui_android", "()Ljava/util/List;", "getBackgroundColor$zendesk_ui_ui_android", "getBackgroundDrawable$zendesk_ui_ui_android", "getMessageText$zendesk_ui_ui_android", "()Ljava/lang/String;", "getTextColor$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/ui/android/conversation/textcell/TextCellState;", "equals", "", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/textcell/TextCellState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TextCellState.kt */
public final class TextCellState {
    private final Integer actionColor;
    private final List<ActionButton> actions;
    private final Integer backgroundColor;
    private final Integer backgroundDrawable;
    private final String messageText;
    private final Integer textColor;

    public TextCellState() {
        this((String) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TextCellState copy$default(TextCellState textCellState, String str, List<ActionButton> list, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = textCellState.messageText;
        }
        if ((i & 2) != 0) {
            list = textCellState.actions;
        }
        List<ActionButton> list2 = list;
        if ((i & 4) != 0) {
            num = textCellState.textColor;
        }
        Integer num5 = num;
        if ((i & 8) != 0) {
            num2 = textCellState.backgroundColor;
        }
        Integer num6 = num2;
        if ((i & 16) != 0) {
            num3 = textCellState.backgroundDrawable;
        }
        Integer num7 = num3;
        if ((i & 32) != 0) {
            num4 = textCellState.actionColor;
        }
        return textCellState.copy(str, list2, num5, num6, num7, num4);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.messageText;
    }

    public final List<ActionButton> component2$zendesk_ui_ui_android() {
        return this.actions;
    }

    public final Integer component3$zendesk_ui_ui_android() {
        return this.textColor;
    }

    public final Integer component4$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Integer component5$zendesk_ui_ui_android() {
        return this.backgroundDrawable;
    }

    public final Integer component6$zendesk_ui_ui_android() {
        return this.actionColor;
    }

    public final TextCellState copy(String str, List<ActionButton> list, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(str, "messageText");
        return new TextCellState(str, list, num, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextCellState)) {
            return false;
        }
        TextCellState textCellState = (TextCellState) obj;
        return Intrinsics.areEqual((Object) this.messageText, (Object) textCellState.messageText) && Intrinsics.areEqual((Object) this.actions, (Object) textCellState.actions) && Intrinsics.areEqual((Object) this.textColor, (Object) textCellState.textColor) && Intrinsics.areEqual((Object) this.backgroundColor, (Object) textCellState.backgroundColor) && Intrinsics.areEqual((Object) this.backgroundDrawable, (Object) textCellState.backgroundDrawable) && Intrinsics.areEqual((Object) this.actionColor, (Object) textCellState.actionColor);
    }

    public int hashCode() {
        int hashCode = this.messageText.hashCode() * 31;
        List<ActionButton> list = this.actions;
        int i = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.textColor;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.backgroundColor;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.backgroundDrawable;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.actionColor;
        if (num4 != null) {
            i = num4.hashCode();
        }
        return hashCode5 + i;
    }

    public String toString() {
        return "TextCellState(messageText=" + this.messageText + ", actions=" + this.actions + ", textColor=" + this.textColor + ", backgroundColor=" + this.backgroundColor + ", backgroundDrawable=" + this.backgroundDrawable + ", actionColor=" + this.actionColor + ')';
    }

    public TextCellState(String str, List<ActionButton> list, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(str, "messageText");
        this.messageText = str;
        this.actions = list;
        this.textColor = num;
        this.backgroundColor = num2;
        this.backgroundDrawable = num3;
        this.actionColor = num4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextCellState(java.lang.String r5, java.util.List r6, java.lang.Integer r7, java.lang.Integer r8, java.lang.Integer r9, java.lang.Integer r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = ""
        L_0x0006:
            r12 = r11 & 2
            r0 = 0
            if (r12 == 0) goto L_0x000d
            r12 = r0
            goto L_0x000e
        L_0x000d:
            r12 = r6
        L_0x000e:
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0014
            r1 = r0
            goto L_0x0015
        L_0x0014:
            r1 = r7
        L_0x0015:
            r6 = r11 & 8
            if (r6 == 0) goto L_0x001b
            r2 = r0
            goto L_0x001c
        L_0x001b:
            r2 = r8
        L_0x001c:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0022
            r3 = r0
            goto L_0x0023
        L_0x0022:
            r3 = r9
        L_0x0023:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0028
            goto L_0x0029
        L_0x0028:
            r0 = r10
        L_0x0029:
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r0
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.textcell.TextCellState.<init>(java.lang.String, java.util.List, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getMessageText$zendesk_ui_ui_android() {
        return this.messageText;
    }

    public final List<ActionButton> getActions$zendesk_ui_ui_android() {
        return this.actions;
    }

    public final Integer getTextColor$zendesk_ui_ui_android() {
        return this.textColor;
    }

    public final Integer getBackgroundColor$zendesk_ui_ui_android() {
        return this.backgroundColor;
    }

    public final Integer getBackgroundDrawable$zendesk_ui_ui_android() {
        return this.backgroundDrawable;
    }

    public final Integer getActionColor$zendesk_ui_ui_android() {
        return this.actionColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u0010\u0010\t\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bJ\u0017\u0010\f\u001a\u00020\u00002\n\b\u0001\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u000f\u001a\u00020\u0003J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/textcell/TextCellState$Builder;", "", "state", "Lzendesk/ui/android/conversation/textcell/TextCellState;", "(Lzendesk/ui/android/conversation/textcell/TextCellState;)V", "()V", "actions", "", "Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "backgroundColor", "color", "", "backgroundDrawable", "drawable", "(Ljava/lang/Integer;)Lzendesk/ui/android/conversation/textcell/TextCellState$Builder;", "build", "messageText", "", "textColor", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TextCellState.kt */
    public static final class Builder {
        private TextCellState state;

        public Builder() {
            this.state = new TextCellState((String) null, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(TextCellState textCellState) {
            this();
            Intrinsics.checkNotNullParameter(textCellState, "state");
            this.state = textCellState;
        }

        public final Builder messageText(String str) {
            Intrinsics.checkNotNullParameter(str, "messageText");
            Builder builder = this;
            this.state = TextCellState.copy$default(this.state, str, (List) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 62, (Object) null);
            return this;
        }

        public final Builder textColor(int i) {
            Builder builder = this;
            this.state = TextCellState.copy$default(this.state, (String) null, (List) null, Integer.valueOf(i), (Integer) null, (Integer) null, (Integer) null, 59, (Object) null);
            return this;
        }

        public final Builder backgroundColor(int i) {
            Builder builder = this;
            this.state = TextCellState.copy$default(this.state, (String) null, (List) null, (Integer) null, Integer.valueOf(i), (Integer) null, (Integer) null, 55, (Object) null);
            return this;
        }

        public final Builder backgroundDrawable(Integer num) {
            Builder builder = this;
            this.state = TextCellState.copy$default(this.state, (String) null, (List) null, (Integer) null, (Integer) null, num, (Integer) null, 47, (Object) null);
            return this;
        }

        public final Builder actions(List<ActionButton> list) {
            Intrinsics.checkNotNullParameter(list, "actions");
            Builder builder = this;
            this.state = TextCellState.copy$default(this.state, (String) null, list, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 61, (Object) null);
            return this;
        }

        public final TextCellState build() {
            return this.state;
        }
    }
}
