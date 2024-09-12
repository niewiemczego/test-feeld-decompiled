package zendesk.messaging.android.internal.conversationscreen.messagelog;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.form.DisplayedField;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001:\u00017Bq\b\u0000\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t\u0012\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u0010J\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÀ\u0003¢\u0006\u0002\b\u001fJ\u000e\u0010 \u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b!J\u001a\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bHÀ\u0003¢\u0006\u0002\b#J\u000e\u0010$\u001a\u00020\u0006HÀ\u0003¢\u0006\u0002\b%J\u0012\u0010&\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b'\u0010\u0012J\u0012\u0010(\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b)\u0010\u0012J\u0012\u0010*\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b+\u0010\u0012J\u0012\u0010,\u001a\u0004\u0018\u00010\tHÀ\u0003¢\u0006\u0004\b-\u0010\u0012Jx\u0010.\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0014\b\u0002\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000e\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\u000f\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010/J\u0013\u00100\u001a\u00020\u00062\b\u00101\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00102\u001a\u00020\tHÖ\u0001J\u0006\u00103\u001a\u000204J\t\u00105\u001a\u000206HÖ\u0001R\u0018\u0010\r\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u0018\u0010\f\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001a\u0010\u0012R\u0014\u0010\u000b\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001c¨\u00068"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "", "messageLogEntryList", "", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "shouldScrollToBottom", "", "mapOfDisplayedFields", "", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "shouldAnnounceMessage", "outboundMessageColor", "actionColor", "notifyColor", "iconColor", "(Ljava/util/List;ZLjava/util/Map;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getActionColor$zendesk_messaging_messaging_android", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getIconColor$zendesk_messaging_messaging_android", "getMapOfDisplayedFields$zendesk_messaging_messaging_android", "()Ljava/util/Map;", "getMessageLogEntryList$zendesk_messaging_messaging_android", "()Ljava/util/List;", "getNotifyColor$zendesk_messaging_messaging_android", "getOutboundMessageColor$zendesk_messaging_messaging_android", "getShouldAnnounceMessage$zendesk_messaging_messaging_android", "()Z", "getShouldScrollToBottom$zendesk_messaging_messaging_android", "component1", "component1$zendesk_messaging_messaging_android", "component2", "component2$zendesk_messaging_messaging_android", "component3", "component3$zendesk_messaging_messaging_android", "component4", "component4$zendesk_messaging_messaging_android", "component5", "component5$zendesk_messaging_messaging_android", "component6", "component6$zendesk_messaging_messaging_android", "component7", "component7$zendesk_messaging_messaging_android", "component8", "component8$zendesk_messaging_messaging_android", "copy", "(Ljava/util/List;ZLjava/util/Map;ZLjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "equals", "other", "hashCode", "toBuilder", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState$Builder;", "toString", "", "Builder", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogState.kt */
public final class MessageLogState {
    private final Integer actionColor;
    private final Integer iconColor;
    private final Map<Integer, DisplayedField> mapOfDisplayedFields;
    private final List<MessageLogEntry> messageLogEntryList;
    private final Integer notifyColor;
    private final Integer outboundMessageColor;
    private final boolean shouldAnnounceMessage;
    private final boolean shouldScrollToBottom;

    public MessageLogState() {
        this((List) null, false, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 255, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ MessageLogState copy$default(MessageLogState messageLogState, List list, boolean z, Map map, boolean z2, Integer num, Integer num2, Integer num3, Integer num4, int i, Object obj) {
        MessageLogState messageLogState2 = messageLogState;
        int i2 = i;
        return messageLogState.copy((i2 & 1) != 0 ? messageLogState2.messageLogEntryList : list, (i2 & 2) != 0 ? messageLogState2.shouldScrollToBottom : z, (i2 & 4) != 0 ? messageLogState2.mapOfDisplayedFields : map, (i2 & 8) != 0 ? messageLogState2.shouldAnnounceMessage : z2, (i2 & 16) != 0 ? messageLogState2.outboundMessageColor : num, (i2 & 32) != 0 ? messageLogState2.actionColor : num2, (i2 & 64) != 0 ? messageLogState2.notifyColor : num3, (i2 & 128) != 0 ? messageLogState2.iconColor : num4);
    }

    public final List<MessageLogEntry> component1$zendesk_messaging_messaging_android() {
        return this.messageLogEntryList;
    }

    public final boolean component2$zendesk_messaging_messaging_android() {
        return this.shouldScrollToBottom;
    }

    public final Map<Integer, DisplayedField> component3$zendesk_messaging_messaging_android() {
        return this.mapOfDisplayedFields;
    }

    public final boolean component4$zendesk_messaging_messaging_android() {
        return this.shouldAnnounceMessage;
    }

    public final Integer component5$zendesk_messaging_messaging_android() {
        return this.outboundMessageColor;
    }

    public final Integer component6$zendesk_messaging_messaging_android() {
        return this.actionColor;
    }

    public final Integer component7$zendesk_messaging_messaging_android() {
        return this.notifyColor;
    }

    public final Integer component8$zendesk_messaging_messaging_android() {
        return this.iconColor;
    }

    public final MessageLogState copy(List<? extends MessageLogEntry> list, boolean z, Map<Integer, DisplayedField> map, boolean z2, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(list, "messageLogEntryList");
        Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
        return new MessageLogState(list, z, map, z2, num, num2, num3, num4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageLogState)) {
            return false;
        }
        MessageLogState messageLogState = (MessageLogState) obj;
        return Intrinsics.areEqual((Object) this.messageLogEntryList, (Object) messageLogState.messageLogEntryList) && this.shouldScrollToBottom == messageLogState.shouldScrollToBottom && Intrinsics.areEqual((Object) this.mapOfDisplayedFields, (Object) messageLogState.mapOfDisplayedFields) && this.shouldAnnounceMessage == messageLogState.shouldAnnounceMessage && Intrinsics.areEqual((Object) this.outboundMessageColor, (Object) messageLogState.outboundMessageColor) && Intrinsics.areEqual((Object) this.actionColor, (Object) messageLogState.actionColor) && Intrinsics.areEqual((Object) this.notifyColor, (Object) messageLogState.notifyColor) && Intrinsics.areEqual((Object) this.iconColor, (Object) messageLogState.iconColor);
    }

    public int hashCode() {
        int hashCode = this.messageLogEntryList.hashCode() * 31;
        boolean z = this.shouldScrollToBottom;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int hashCode2 = (((hashCode + (z ? 1 : 0)) * 31) + this.mapOfDisplayedFields.hashCode()) * 31;
        boolean z3 = this.shouldAnnounceMessage;
        if (!z3) {
            z2 = z3;
        }
        int i = (hashCode2 + (z2 ? 1 : 0)) * 31;
        Integer num = this.outboundMessageColor;
        int i2 = 0;
        int hashCode3 = (i + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.actionColor;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.notifyColor;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.iconColor;
        if (num4 != null) {
            i2 = num4.hashCode();
        }
        return hashCode5 + i2;
    }

    public String toString() {
        return "MessageLogState(messageLogEntryList=" + this.messageLogEntryList + ", shouldScrollToBottom=" + this.shouldScrollToBottom + ", mapOfDisplayedFields=" + this.mapOfDisplayedFields + ", shouldAnnounceMessage=" + this.shouldAnnounceMessage + ", outboundMessageColor=" + this.outboundMessageColor + ", actionColor=" + this.actionColor + ", notifyColor=" + this.notifyColor + ", iconColor=" + this.iconColor + ')';
    }

    public MessageLogState(List<? extends MessageLogEntry> list, boolean z, Map<Integer, DisplayedField> map, boolean z2, Integer num, Integer num2, Integer num3, Integer num4) {
        Intrinsics.checkNotNullParameter(list, "messageLogEntryList");
        Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
        this.messageLogEntryList = list;
        this.shouldScrollToBottom = z;
        this.mapOfDisplayedFields = map;
        this.shouldAnnounceMessage = z2;
        this.outboundMessageColor = num;
        this.actionColor = num2;
        this.notifyColor = num3;
        this.iconColor = num4;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ MessageLogState(java.util.List r10, boolean r11, java.util.Map r12, boolean r13, java.lang.Integer r14, java.lang.Integer r15, java.lang.Integer r16, java.lang.Integer r17, int r18, kotlin.jvm.internal.DefaultConstructorMarker r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000b
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            goto L_0x000c
        L_0x000b:
            r1 = r10
        L_0x000c:
            r2 = r0 & 2
            r3 = 0
            if (r2 == 0) goto L_0x0013
            r2 = r3
            goto L_0x0014
        L_0x0013:
            r2 = r11
        L_0x0014:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0020
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            java.util.Map r4 = (java.util.Map) r4
            goto L_0x0021
        L_0x0020:
            r4 = r12
        L_0x0021:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0026
            goto L_0x0027
        L_0x0026:
            r3 = r13
        L_0x0027:
            r5 = r0 & 16
            r6 = 0
            if (r5 == 0) goto L_0x002e
            r5 = r6
            goto L_0x002f
        L_0x002e:
            r5 = r14
        L_0x002f:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0035
            r7 = r6
            goto L_0x0036
        L_0x0035:
            r7 = r15
        L_0x0036:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x003c
            r8 = r6
            goto L_0x003e
        L_0x003c:
            r8 = r16
        L_0x003e:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x0043
            goto L_0x0045
        L_0x0043:
            r6 = r17
        L_0x0045:
            r10 = r9
            r11 = r1
            r12 = r2
            r13 = r4
            r14 = r3
            r15 = r5
            r16 = r7
            r17 = r8
            r18 = r6
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogState.<init>(java.util.List, boolean, java.util.Map, boolean, java.lang.Integer, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final List<MessageLogEntry> getMessageLogEntryList$zendesk_messaging_messaging_android() {
        return this.messageLogEntryList;
    }

    public final boolean getShouldScrollToBottom$zendesk_messaging_messaging_android() {
        return this.shouldScrollToBottom;
    }

    public final Map<Integer, DisplayedField> getMapOfDisplayedFields$zendesk_messaging_messaging_android() {
        return this.mapOfDisplayedFields;
    }

    public final boolean getShouldAnnounceMessage$zendesk_messaging_messaging_android() {
        return this.shouldAnnounceMessage;
    }

    public final Integer getOutboundMessageColor$zendesk_messaging_messaging_android() {
        return this.outboundMessageColor;
    }

    public final Integer getActionColor$zendesk_messaging_messaging_android() {
        return this.actionColor;
    }

    public final Integer getNotifyColor$zendesk_messaging_messaging_android() {
        return this.notifyColor;
    }

    public final Integer getIconColor$zendesk_messaging_messaging_android() {
        return this.iconColor;
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003J\u0010\u0010\n\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u001a\u0010\u000b\u001a\u00020\u00002\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\r0\fJ\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u0010\u0010\u0011\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u0010\u0010\u0012\u001a\u00020\u00002\b\b\u0001\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState$Builder;", "", "state", "Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;", "(Lzendesk/messaging/android/internal/conversationscreen/messagelog/MessageLogState;)V", "()V", "actionColor", "color", "", "build", "iconColor", "mapOfDisplayedFields", "", "Lzendesk/ui/android/conversation/form/DisplayedField;", "messageLogEntryList", "", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "notifyColor", "outboundMessageColor", "shouldAnnounceMessage", "", "shouldScrollToBottom", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogState.kt */
    public static final class Builder {
        private MessageLogState state;

        public Builder() {
            this.state = new MessageLogState((List) null, false, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 255, (DefaultConstructorMarker) null);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(MessageLogState messageLogState) {
            this();
            Intrinsics.checkNotNullParameter(messageLogState, "state");
            this.state = messageLogState;
        }

        public final Builder messageLogEntryList(List<? extends MessageLogEntry> list) {
            Intrinsics.checkNotNullParameter(list, "messageLogEntryList");
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, list, false, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 254, (Object) null);
            return this;
        }

        public final Builder mapOfDisplayedFields(Map<Integer, DisplayedField> map) {
            Intrinsics.checkNotNullParameter(map, "mapOfDisplayedFields");
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, map, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 251, (Object) null);
            return this;
        }

        public final Builder shouldScrollToBottom(boolean z) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, z, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 253, (Object) null);
            return this;
        }

        public final Builder shouldAnnounceMessage(boolean z) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, (Map) null, z, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 247, (Object) null);
            return this;
        }

        public final Builder outboundMessageColor(int i) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, (Map) null, false, Integer.valueOf(i), (Integer) null, (Integer) null, (Integer) null, 239, (Object) null);
            return this;
        }

        public final Builder actionColor(int i) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, (Map) null, false, (Integer) null, Integer.valueOf(i), (Integer) null, (Integer) null, 223, (Object) null);
            return this;
        }

        public final Builder notifyColor(int i) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, (Map) null, false, (Integer) null, (Integer) null, Integer.valueOf(i), (Integer) null, 191, (Object) null);
            return this;
        }

        public final Builder iconColor(int i) {
            Builder builder = this;
            this.state = MessageLogState.copy$default(this.state, (List) null, false, (Map) null, false, (Integer) null, (Integer) null, (Integer) null, Integer.valueOf(i), 127, (Object) null);
            return this;
        }

        public final MessageLogState build() {
            return this.state;
        }
    }
}
