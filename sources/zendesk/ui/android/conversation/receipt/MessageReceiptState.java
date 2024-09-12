package zendesk.ui.android.conversation.receipt;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u0001,BE\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007¢\u0006\u0002\u0010\fJ\u000e\u0010\u0018\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0019J\u000e\u0010\u001a\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u001bJ\u000e\u0010\u001c\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b\u001dJ\u0012\u0010\u001e\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b\u001f\u0010\u000eJ\u0012\u0010 \u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b!\u0010\u000eJ\u000e\u0010\"\u001a\u00020\u0007HÀ\u0003¢\u0006\u0002\b#JN\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\u0007HÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020\u00072\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001J\u0006\u0010)\u001a\u00020*J\t\u0010+\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\n\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u000b\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016¨\u0006-"}, d2 = {"Lzendesk/ui/android/conversation/receipt/MessageReceiptState;", "", "label", "", "messageReceiptPosition", "Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;", "showIcon", "", "labelColor", "", "iconColor", "shouldAnimateReceipt", "(Ljava/lang/String;Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;ZLjava/lang/Integer;Ljava/lang/Integer;Z)V", "getIconColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getLabel$zendesk_ui_ui_android", "()Ljava/lang/String;", "getLabelColor$zendesk_ui_ui_android", "getMessageReceiptPosition$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;", "getShouldAnimateReceipt$zendesk_ui_ui_android", "()Z", "getShowIcon$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "copy", "(Ljava/lang/String;Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;ZLjava/lang/Integer;Ljava/lang/Integer;Z)Lzendesk/ui/android/conversation/receipt/MessageReceiptState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/receipt/MessageReceiptState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageReceiptState.kt */
public final class MessageReceiptState {
    private final Integer iconColor;
    private final String label;
    private final Integer labelColor;
    private final MessageReceiptPosition messageReceiptPosition;
    private final boolean shouldAnimateReceipt;
    private final boolean showIcon;

    public MessageReceiptState() {
        this((String) null, (MessageReceiptPosition) null, false, (Integer) null, (Integer) null, false, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageReceiptState copy$default(MessageReceiptState messageReceiptState, String str, MessageReceiptPosition messageReceiptPosition2, boolean z, Integer num, Integer num2, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageReceiptState.label;
        }
        if ((i & 2) != 0) {
            messageReceiptPosition2 = messageReceiptState.messageReceiptPosition;
        }
        MessageReceiptPosition messageReceiptPosition3 = messageReceiptPosition2;
        if ((i & 4) != 0) {
            z = messageReceiptState.showIcon;
        }
        boolean z3 = z;
        if ((i & 8) != 0) {
            num = messageReceiptState.labelColor;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            num2 = messageReceiptState.iconColor;
        }
        Integer num4 = num2;
        if ((i & 32) != 0) {
            z2 = messageReceiptState.shouldAnimateReceipt;
        }
        return messageReceiptState.copy(str, messageReceiptPosition3, z3, num3, num4, z2);
    }

    public final String component1$zendesk_ui_ui_android() {
        return this.label;
    }

    public final MessageReceiptPosition component2$zendesk_ui_ui_android() {
        return this.messageReceiptPosition;
    }

    public final boolean component3$zendesk_ui_ui_android() {
        return this.showIcon;
    }

    public final Integer component4$zendesk_ui_ui_android() {
        return this.labelColor;
    }

    public final Integer component5$zendesk_ui_ui_android() {
        return this.iconColor;
    }

    public final boolean component6$zendesk_ui_ui_android() {
        return this.shouldAnimateReceipt;
    }

    public final MessageReceiptState copy(String str, MessageReceiptPosition messageReceiptPosition2, boolean z, Integer num, Integer num2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(messageReceiptPosition2, "messageReceiptPosition");
        return new MessageReceiptState(str, messageReceiptPosition2, z, num, num2, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageReceiptState)) {
            return false;
        }
        MessageReceiptState messageReceiptState = (MessageReceiptState) obj;
        return Intrinsics.areEqual((Object) this.label, (Object) messageReceiptState.label) && this.messageReceiptPosition == messageReceiptState.messageReceiptPosition && this.showIcon == messageReceiptState.showIcon && Intrinsics.areEqual((Object) this.labelColor, (Object) messageReceiptState.labelColor) && Intrinsics.areEqual((Object) this.iconColor, (Object) messageReceiptState.iconColor) && this.shouldAnimateReceipt == messageReceiptState.shouldAnimateReceipt;
    }

    public int hashCode() {
        int hashCode = ((this.label.hashCode() * 31) + this.messageReceiptPosition.hashCode()) * 31;
        boolean z = this.showIcon;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (hashCode + (z ? 1 : 0)) * 31;
        Integer num = this.labelColor;
        int i2 = 0;
        int hashCode2 = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.iconColor;
        if (num2 != null) {
            i2 = num2.hashCode();
        }
        int i3 = (hashCode2 + i2) * 31;
        boolean z3 = this.shouldAnimateReceipt;
        if (!z3) {
            z2 = z3;
        }
        return i3 + (z2 ? 1 : 0);
    }

    public String toString() {
        return "MessageReceiptState(label=" + this.label + ", messageReceiptPosition=" + this.messageReceiptPosition + ", showIcon=" + this.showIcon + ", labelColor=" + this.labelColor + ", iconColor=" + this.iconColor + ", shouldAnimateReceipt=" + this.shouldAnimateReceipt + ')';
    }

    public MessageReceiptState(String str, MessageReceiptPosition messageReceiptPosition2, boolean z, Integer num, Integer num2, boolean z2) {
        Intrinsics.checkNotNullParameter(str, "label");
        Intrinsics.checkNotNullParameter(messageReceiptPosition2, "messageReceiptPosition");
        this.label = str;
        this.messageReceiptPosition = messageReceiptPosition2;
        this.showIcon = z;
        this.labelColor = num;
        this.iconColor = num2;
        this.shouldAnimateReceipt = z2;
    }

    public final String getLabel$zendesk_ui_ui_android() {
        return this.label;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageReceiptState(java.lang.String r5, zendesk.ui.android.conversation.receipt.MessageReceiptPosition r6, boolean r7, java.lang.Integer r8, java.lang.Integer r9, boolean r10, int r11, kotlin.jvm.internal.DefaultConstructorMarker r12) {
        /*
            r4 = this;
            r12 = r11 & 1
            if (r12 == 0) goto L_0x0006
            java.lang.String r5 = ""
        L_0x0006:
            r12 = r11 & 2
            if (r12 == 0) goto L_0x000c
            zendesk.ui.android.conversation.receipt.MessageReceiptPosition r6 = zendesk.ui.android.conversation.receipt.MessageReceiptPosition.NONE
        L_0x000c:
            r12 = r6
            r6 = r11 & 4
            if (r6 == 0) goto L_0x0012
            r7 = 1
        L_0x0012:
            r0 = r7
            r6 = r11 & 8
            r7 = 0
            if (r6 == 0) goto L_0x001a
            r1 = r7
            goto L_0x001b
        L_0x001a:
            r1 = r8
        L_0x001b:
            r6 = r11 & 16
            if (r6 == 0) goto L_0x0021
            r2 = r7
            goto L_0x0022
        L_0x0021:
            r2 = r9
        L_0x0022:
            r6 = r11 & 32
            if (r6 == 0) goto L_0x0027
            r10 = 0
        L_0x0027:
            r3 = r10
            r6 = r4
            r7 = r5
            r8 = r12
            r9 = r0
            r10 = r1
            r11 = r2
            r12 = r3
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.receipt.MessageReceiptState.<init>(java.lang.String, zendesk.ui.android.conversation.receipt.MessageReceiptPosition, boolean, java.lang.Integer, java.lang.Integer, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final MessageReceiptPosition getMessageReceiptPosition$zendesk_ui_ui_android() {
        return this.messageReceiptPosition;
    }

    public final boolean getShowIcon$zendesk_ui_ui_android() {
        return this.showIcon;
    }

    public final Integer getLabelColor$zendesk_ui_ui_android() {
        return this.labelColor;
    }

    public final Integer getIconColor$zendesk_ui_ui_android() {
        return this.iconColor;
    }

    public final boolean getShouldAnimateReceipt$zendesk_ui_ui_android() {
        return this.shouldAnimateReceipt;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0006\u001a\u00020\u0003J\u0010\u0010\u0007\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00002\b\b\u0001\u0010\b\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lzendesk/ui/android/conversation/receipt/MessageReceiptState$Builder;", "", "state", "Lzendesk/ui/android/conversation/receipt/MessageReceiptState;", "(Lzendesk/ui/android/conversation/receipt/MessageReceiptState;)V", "()V", "build", "iconColor", "color", "", "label", "", "labelColor", "messageReceiptPosition", "Lzendesk/ui/android/conversation/receipt/MessageReceiptPosition;", "shouldAnimateReceipt", "value", "", "showIcon", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageReceiptState.kt */
    public static final class Builder {
        private MessageReceiptState state;

        public Builder() {
            this.state = new MessageReceiptState((String) null, (MessageReceiptPosition) null, false, (Integer) null, (Integer) null, false, 63, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageReceiptState messageReceiptState) {
            this();
            Intrinsics.checkNotNullParameter(messageReceiptState, "state");
            this.state = messageReceiptState;
        }

        public final Builder label(String str) {
            Intrinsics.checkNotNullParameter(str, "label");
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, str, (MessageReceiptPosition) null, false, (Integer) null, (Integer) null, false, 62, (Object) null);
            return this;
        }

        public final Builder messageReceiptPosition(MessageReceiptPosition messageReceiptPosition) {
            Intrinsics.checkNotNullParameter(messageReceiptPosition, "messageReceiptPosition");
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, (String) null, messageReceiptPosition, false, (Integer) null, (Integer) null, false, 61, (Object) null);
            return this;
        }

        public final Builder showIcon(boolean z) {
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, (String) null, (MessageReceiptPosition) null, z, (Integer) null, (Integer) null, false, 59, (Object) null);
            return this;
        }

        public final Builder labelColor(int i) {
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, (String) null, (MessageReceiptPosition) null, false, Integer.valueOf(i), (Integer) null, false, 55, (Object) null);
            return this;
        }

        public final Builder iconColor(int i) {
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, (String) null, (MessageReceiptPosition) null, false, (Integer) null, Integer.valueOf(i), false, 47, (Object) null);
            return this;
        }

        public final Builder shouldAnimateReceipt(boolean z) {
            Builder builder = this;
            this.state = MessageReceiptState.copy$default(this.state, (String) null, (MessageReceiptPosition) null, false, (Integer) null, (Integer) null, z, 31, (Object) null);
            return this;
        }

        public final MessageReceiptState build() {
            return this.state;
        }
    }
}
