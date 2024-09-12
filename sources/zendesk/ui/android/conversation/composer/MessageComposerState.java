package zendesk.ui.android.conversation.composer;

import androidx.core.app.FrameMetricsAggregator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001:\u00017Be\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b\u0012\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u001d\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\bHÀ\u0003¢\u0006\u0002\b(J\u0012\u0010)\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b*\u0010\u0010J\u0012\u0010+\u001a\u0004\u0018\u00010\bHÀ\u0003¢\u0006\u0004\b,\u0010\u0010J\u000e\u0010-\u001a\u00020\rHÀ\u0003¢\u0006\u0002\b.Jl\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\n\b\u0003\u0010\n\u001a\u0004\u0018\u00010\b2\n\b\u0003\u0010\u000b\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001¢\u0006\u0002\u00100J\u0013\u00101\u001a\u00020\u00032\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u00020\bHÖ\u0001J\u0006\u00104\u001a\u000205J\t\u00106\u001a\u00020\rHÖ\u0001R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\f\u001a\u00020\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0013R\u0014\u0010\t\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\n\u001a\u0004\u0018\u00010\bX\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u001a\u0010\u0010R\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0013R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0019¨\u00068"}, d2 = {"Lzendesk/ui/android/conversation/composer/MessageComposerState;", "", "enabled", "", "cameraSupported", "gallerySupported", "showAttachment", "visibility", "", "inputMaxLength", "sendButtonColor", "attachButtonColor", "composerText", "", "(ZZZZIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "getAttachButtonColor$zendesk_ui_ui_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getCameraSupported$zendesk_ui_ui_android", "()Z", "getComposerText$zendesk_ui_ui_android", "()Ljava/lang/String;", "getEnabled$zendesk_ui_ui_android", "getGallerySupported$zendesk_ui_ui_android", "getInputMaxLength$zendesk_ui_ui_android", "()I", "getSendButtonColor$zendesk_ui_ui_android", "getShowAttachment$zendesk_ui_ui_android", "getVisibility$zendesk_ui_ui_android", "component1", "component1$zendesk_ui_ui_android", "component2", "component2$zendesk_ui_ui_android", "component3", "component3$zendesk_ui_ui_android", "component4", "component4$zendesk_ui_ui_android", "component5", "component5$zendesk_ui_ui_android", "component6", "component6$zendesk_ui_ui_android", "component7", "component7$zendesk_ui_ui_android", "component8", "component8$zendesk_ui_ui_android", "component9", "component9$zendesk_ui_ui_android", "copy", "(ZZZZIILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lzendesk/ui/android/conversation/composer/MessageComposerState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/ui/android/conversation/composer/MessageComposerState$Builder;", "toString", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageComposerState.kt */
public final class MessageComposerState {
    private final Integer attachButtonColor;
    private final boolean cameraSupported;
    private final String composerText;
    private final boolean enabled;
    private final boolean gallerySupported;
    private final int inputMaxLength;
    private final Integer sendButtonColor;
    private final boolean showAttachment;
    private final int visibility;

    public MessageComposerState() {
        this(false, false, false, false, 0, 0, (Integer) null, (Integer) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageComposerState copy$default(MessageComposerState messageComposerState, boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Integer num, Integer num2, String str, int i3, Object obj) {
        MessageComposerState messageComposerState2 = messageComposerState;
        int i4 = i3;
        return messageComposerState.copy((i4 & 1) != 0 ? messageComposerState2.enabled : z, (i4 & 2) != 0 ? messageComposerState2.cameraSupported : z2, (i4 & 4) != 0 ? messageComposerState2.gallerySupported : z3, (i4 & 8) != 0 ? messageComposerState2.showAttachment : z4, (i4 & 16) != 0 ? messageComposerState2.visibility : i, (i4 & 32) != 0 ? messageComposerState2.inputMaxLength : i2, (i4 & 64) != 0 ? messageComposerState2.sendButtonColor : num, (i4 & 128) != 0 ? messageComposerState2.attachButtonColor : num2, (i4 & 256) != 0 ? messageComposerState2.composerText : str);
    }

    public final boolean component1$zendesk_ui_ui_android() {
        return this.enabled;
    }

    public final boolean component2$zendesk_ui_ui_android() {
        return this.cameraSupported;
    }

    public final boolean component3$zendesk_ui_ui_android() {
        return this.gallerySupported;
    }

    public final boolean component4$zendesk_ui_ui_android() {
        return this.showAttachment;
    }

    public final int component5$zendesk_ui_ui_android() {
        return this.visibility;
    }

    public final int component6$zendesk_ui_ui_android() {
        return this.inputMaxLength;
    }

    public final Integer component7$zendesk_ui_ui_android() {
        return this.sendButtonColor;
    }

    public final Integer component8$zendesk_ui_ui_android() {
        return this.attachButtonColor;
    }

    public final String component9$zendesk_ui_ui_android() {
        return this.composerText;
    }

    public final MessageComposerState copy(boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Integer num, Integer num2, String str) {
        String str2 = str;
        Intrinsics.checkNotNullParameter(str2, "composerText");
        return new MessageComposerState(z, z2, z3, z4, i, i2, num, num2, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageComposerState)) {
            return false;
        }
        MessageComposerState messageComposerState = (MessageComposerState) obj;
        return this.enabled == messageComposerState.enabled && this.cameraSupported == messageComposerState.cameraSupported && this.gallerySupported == messageComposerState.gallerySupported && this.showAttachment == messageComposerState.showAttachment && this.visibility == messageComposerState.visibility && this.inputMaxLength == messageComposerState.inputMaxLength && Intrinsics.areEqual((Object) this.sendButtonColor, (Object) messageComposerState.sendButtonColor) && Intrinsics.areEqual((Object) this.attachButtonColor, (Object) messageComposerState.attachButtonColor) && Intrinsics.areEqual((Object) this.composerText, (Object) messageComposerState.composerText);
    }

    public int hashCode() {
        boolean z = this.enabled;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        boolean z3 = this.cameraSupported;
        if (z3) {
            z3 = true;
        }
        int i2 = (i + (z3 ? 1 : 0)) * 31;
        boolean z4 = this.gallerySupported;
        if (z4) {
            z4 = true;
        }
        int i3 = (i2 + (z4 ? 1 : 0)) * 31;
        boolean z5 = this.showAttachment;
        if (!z5) {
            z2 = z5;
        }
        int hashCode = (((((i3 + (z2 ? 1 : 0)) * 31) + Integer.hashCode(this.visibility)) * 31) + Integer.hashCode(this.inputMaxLength)) * 31;
        Integer num = this.sendButtonColor;
        int i4 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.attachButtonColor;
        if (num2 != null) {
            i4 = num2.hashCode();
        }
        return ((hashCode2 + i4) * 31) + this.composerText.hashCode();
    }

    public String toString() {
        return "MessageComposerState(enabled=" + this.enabled + ", cameraSupported=" + this.cameraSupported + ", gallerySupported=" + this.gallerySupported + ", showAttachment=" + this.showAttachment + ", visibility=" + this.visibility + ", inputMaxLength=" + this.inputMaxLength + ", sendButtonColor=" + this.sendButtonColor + ", attachButtonColor=" + this.attachButtonColor + ", composerText=" + this.composerText + ')';
    }

    public MessageComposerState(boolean z, boolean z2, boolean z3, boolean z4, int i, int i2, Integer num, Integer num2, String str) {
        Intrinsics.checkNotNullParameter(str, "composerText");
        this.enabled = z;
        this.cameraSupported = z2;
        this.gallerySupported = z3;
        this.showAttachment = z4;
        this.visibility = i;
        this.inputMaxLength = i2;
        this.sendButtonColor = num;
        this.attachButtonColor = num2;
        this.composerText = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageComposerState(boolean r11, boolean r12, boolean r13, boolean r14, int r15, int r16, java.lang.Integer r17, java.lang.Integer r18, java.lang.String r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r10 = this;
            r0 = r20
            r1 = r0 & 1
            r2 = 1
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r11
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r12
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r2 = r13
        L_0x0017:
            r4 = r0 & 8
            r5 = 0
            if (r4 == 0) goto L_0x001e
            r4 = r5
            goto L_0x001f
        L_0x001e:
            r4 = r14
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0024
            goto L_0x0025
        L_0x0024:
            r5 = r15
        L_0x0025:
            r6 = r0 & 32
            if (r6 == 0) goto L_0x002d
            r6 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x002f
        L_0x002d:
            r6 = r16
        L_0x002f:
            r7 = r0 & 64
            r8 = 0
            if (r7 == 0) goto L_0x0036
            r7 = r8
            goto L_0x0038
        L_0x0036:
            r7 = r17
        L_0x0038:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            goto L_0x003f
        L_0x003d:
            r8 = r18
        L_0x003f:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0046
            java.lang.String r0 = ""
            goto L_0x0048
        L_0x0046:
            r0 = r19
        L_0x0048:
            r11 = r10
            r12 = r1
            r13 = r3
            r14 = r2
            r15 = r4
            r16 = r5
            r17 = r6
            r18 = r7
            r19 = r8
            r20 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19, r20)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.composer.MessageComposerState.<init>(boolean, boolean, boolean, boolean, int, int, java.lang.Integer, java.lang.Integer, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final boolean getEnabled$zendesk_ui_ui_android() {
        return this.enabled;
    }

    public final boolean getCameraSupported$zendesk_ui_ui_android() {
        return this.cameraSupported;
    }

    public final boolean getGallerySupported$zendesk_ui_ui_android() {
        return this.gallerySupported;
    }

    public final boolean getShowAttachment$zendesk_ui_ui_android() {
        return this.showAttachment;
    }

    public final int getVisibility$zendesk_ui_ui_android() {
        return this.visibility;
    }

    public final int getInputMaxLength$zendesk_ui_ui_android() {
        return this.inputMaxLength;
    }

    public final Integer getSendButtonColor$zendesk_ui_ui_android() {
        return this.sendButtonColor;
    }

    public final Integer getAttachButtonColor$zendesk_ui_ui_android() {
        return this.attachButtonColor;
    }

    public final String getComposerText$zendesk_ui_ui_android() {
        return this.composerText;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000bJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lzendesk/ui/android/conversation/composer/MessageComposerState$Builder;", "", "state", "Lzendesk/ui/android/conversation/composer/MessageComposerState;", "(Lzendesk/ui/android/conversation/composer/MessageComposerState;)V", "()V", "attachButtonColor", "color", "", "build", "cameraSupported", "", "composerText", "", "enabled", "gallerySupported", "inputMaxLength", "value", "sendButtonColor", "showAttachment", "visibility", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageComposerState.kt */
    public static final class Builder {
        private MessageComposerState state;

        public Builder() {
            this.state = new MessageComposerState(false, false, false, false, 0, 0, (Integer) null, (Integer) null, (String) null, FrameMetricsAggregator.EVERY_DURATION, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageComposerState messageComposerState) {
            this();
            Intrinsics.checkNotNullParameter(messageComposerState, "state");
            this.state = messageComposerState;
        }

        public final Builder enabled(boolean z) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, z, false, false, false, 0, 0, (Integer) null, (Integer) null, (String) null, 510, (Object) null);
            return this;
        }

        public final Builder cameraSupported(boolean z) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, z, false, false, 0, 0, (Integer) null, (Integer) null, (String) null, 509, (Object) null);
            return this;
        }

        public final Builder gallerySupported(boolean z) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, z, false, 0, 0, (Integer) null, (Integer) null, (String) null, 507, (Object) null);
            return this;
        }

        public final Builder visibility(int i) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, false, i, 0, (Integer) null, (Integer) null, (String) null, 495, (Object) null);
            return this;
        }

        public final Builder inputMaxLength(int i) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, false, 0, i, (Integer) null, (Integer) null, (String) null, 479, (Object) null);
            return this;
        }

        public final Builder showAttachment(boolean z) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, z, 0, 0, (Integer) null, (Integer) null, (String) null, 503, (Object) null);
            return this;
        }

        public final Builder sendButtonColor(int i) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, false, 0, 0, Integer.valueOf(i), (Integer) null, (String) null, 447, (Object) null);
            return this;
        }

        public final Builder attachButtonColor(int i) {
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, false, 0, 0, (Integer) null, Integer.valueOf(i), (String) null, 383, (Object) null);
            return this;
        }

        public final Builder composerText(String str) {
            Intrinsics.checkNotNullParameter(str, "composerText");
            Builder builder = this;
            this.state = MessageComposerState.copy$default(this.state, false, false, false, false, 0, 0, (Integer) null, (Integer) null, str, 255, (Object) null);
            return this;
        }

        public final MessageComposerState build() {
            return this.state;
        }
    }
}
