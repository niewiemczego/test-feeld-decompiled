package zendesk.messaging.android.internal.model;

import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageAction;
import zendesk.conversationkit.android.model.MessageStatus;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0006\u0007\b\t\n\u000b\fB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u0001\u0006\r\u000e\u000f\u0010\u0011\u0012¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry;", "", "id", "", "(Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "LoadMore", "MessageContainer", "MessagesDivider", "QuickReply", "TimestampDivider", "TypingIndicator", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TypingIndicator;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$MessagesDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$QuickReply;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$LoadMore;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogEntry.kt */
public abstract class MessageLogEntry {
    private final String id;

    public /* synthetic */ MessageLogEntry(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private MessageLogEntry(String str) {
        this.id = str;
    }

    public String getId() {
        return this.id;
    }

    @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bg\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0007HÆ\u0003J\t\u0010,\u001a\u00020\tHÆ\u0003J\t\u0010-\u001a\u00020\u000bHÆ\u0003J\t\u0010.\u001a\u00020\rHÆ\u0003J\t\u0010/\u001a\u00020\u000fHÆ\u0003J\t\u00100\u001a\u00020\u0011HÆ\u0003Js\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001J\u0013\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u000207HÖ\u0001J\t\u00108\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&¨\u00069"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$MessageContainer;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "label", "avatarUrl", "direction", "Lzendesk/messaging/android/internal/model/MessageDirection;", "position", "Lzendesk/messaging/android/internal/model/MessagePosition;", "shape", "Lzendesk/messaging/android/internal/model/MessageShape;", "size", "Lzendesk/messaging/android/internal/model/MessageSize;", "status", "Lzendesk/conversationkit/android/model/MessageStatus;", "message", "Lzendesk/conversationkit/android/model/Message;", "receipt", "Lzendesk/messaging/android/internal/model/MessageReceipt;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lzendesk/messaging/android/internal/model/MessageDirection;Lzendesk/messaging/android/internal/model/MessagePosition;Lzendesk/messaging/android/internal/model/MessageShape;Lzendesk/messaging/android/internal/model/MessageSize;Lzendesk/conversationkit/android/model/MessageStatus;Lzendesk/conversationkit/android/model/Message;Lzendesk/messaging/android/internal/model/MessageReceipt;)V", "getAvatarUrl", "()Ljava/lang/String;", "getDirection", "()Lzendesk/messaging/android/internal/model/MessageDirection;", "getId", "getLabel", "getMessage", "()Lzendesk/conversationkit/android/model/Message;", "getPosition", "()Lzendesk/messaging/android/internal/model/MessagePosition;", "getReceipt", "()Lzendesk/messaging/android/internal/model/MessageReceipt;", "getShape", "()Lzendesk/messaging/android/internal/model/MessageShape;", "getSize", "()Lzendesk/messaging/android/internal/model/MessageSize;", "getStatus", "()Lzendesk/conversationkit/android/model/MessageStatus;", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static final class MessageContainer extends MessageLogEntry {
        private final String avatarUrl;
        private final MessageDirection direction;
        private final String id;
        private final String label;
        private final Message message;
        private final MessagePosition position;
        private final MessageReceipt receipt;
        private final MessageShape shape;
        private final MessageSize size;
        private final MessageStatus status;

        public static /* synthetic */ MessageContainer copy$default(MessageContainer messageContainer, String str, String str2, String str3, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, MessageSize messageSize, MessageStatus messageStatus, Message message2, MessageReceipt messageReceipt, int i, Object obj) {
            MessageContainer messageContainer2 = messageContainer;
            int i2 = i;
            return messageContainer.copy((i2 & 1) != 0 ? messageContainer.getId() : str, (i2 & 2) != 0 ? messageContainer2.label : str2, (i2 & 4) != 0 ? messageContainer2.avatarUrl : str3, (i2 & 8) != 0 ? messageContainer2.direction : messageDirection, (i2 & 16) != 0 ? messageContainer2.position : messagePosition, (i2 & 32) != 0 ? messageContainer2.shape : messageShape, (i2 & 64) != 0 ? messageContainer2.size : messageSize, (i2 & 128) != 0 ? messageContainer2.status : messageStatus, (i2 & 256) != 0 ? messageContainer2.message : message2, (i2 & 512) != 0 ? messageContainer2.receipt : messageReceipt);
        }

        public final String component1() {
            return getId();
        }

        public final MessageReceipt component10() {
            return this.receipt;
        }

        public final String component2() {
            return this.label;
        }

        public final String component3() {
            return this.avatarUrl;
        }

        public final MessageDirection component4() {
            return this.direction;
        }

        public final MessagePosition component5() {
            return this.position;
        }

        public final MessageShape component6() {
            return this.shape;
        }

        public final MessageSize component7() {
            return this.size;
        }

        public final MessageStatus component8() {
            return this.status;
        }

        public final Message component9() {
            return this.message;
        }

        public final MessageContainer copy(String str, String str2, String str3, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, MessageSize messageSize, MessageStatus messageStatus, Message message2, MessageReceipt messageReceipt) {
            Intrinsics.checkNotNullParameter(str, "id");
            MessageDirection messageDirection2 = messageDirection;
            Intrinsics.checkNotNullParameter(messageDirection2, "direction");
            MessagePosition messagePosition2 = messagePosition;
            Intrinsics.checkNotNullParameter(messagePosition2, ViewProps.POSITION);
            MessageShape messageShape2 = messageShape;
            Intrinsics.checkNotNullParameter(messageShape2, "shape");
            MessageSize messageSize2 = messageSize;
            Intrinsics.checkNotNullParameter(messageSize2, "size");
            MessageStatus messageStatus2 = messageStatus;
            Intrinsics.checkNotNullParameter(messageStatus2, "status");
            Message message3 = message2;
            Intrinsics.checkNotNullParameter(message3, "message");
            return new MessageContainer(str, str2, str3, messageDirection2, messagePosition2, messageShape2, messageSize2, messageStatus2, message3, messageReceipt);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessageContainer)) {
                return false;
            }
            MessageContainer messageContainer = (MessageContainer) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) messageContainer.getId()) && Intrinsics.areEqual((Object) this.label, (Object) messageContainer.label) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) messageContainer.avatarUrl) && this.direction == messageContainer.direction && this.position == messageContainer.position && this.shape == messageContainer.shape && this.size == messageContainer.size && this.status == messageContainer.status && Intrinsics.areEqual((Object) this.message, (Object) messageContainer.message) && Intrinsics.areEqual((Object) this.receipt, (Object) messageContainer.receipt);
        }

        public int hashCode() {
            int hashCode = getId().hashCode() * 31;
            String str = this.label;
            int i = 0;
            int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.avatarUrl;
            int hashCode3 = (((((((((((((hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.direction.hashCode()) * 31) + this.position.hashCode()) * 31) + this.shape.hashCode()) * 31) + this.size.hashCode()) * 31) + this.status.hashCode()) * 31) + this.message.hashCode()) * 31;
            MessageReceipt messageReceipt = this.receipt;
            if (messageReceipt != null) {
                i = messageReceipt.hashCode();
            }
            return hashCode3 + i;
        }

        public String toString() {
            return "MessageContainer(id=" + getId() + ", label=" + this.label + ", avatarUrl=" + this.avatarUrl + ", direction=" + this.direction + ", position=" + this.position + ", shape=" + this.shape + ", size=" + this.size + ", status=" + this.status + ", message=" + this.message + ", receipt=" + this.receipt + ')';
        }

        public String getId() {
            return this.id;
        }

        public final String getLabel() {
            return this.label;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        public final MessageDirection getDirection() {
            return this.direction;
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MessageContainer(java.lang.String r15, java.lang.String r16, java.lang.String r17, zendesk.messaging.android.internal.model.MessageDirection r18, zendesk.messaging.android.internal.model.MessagePosition r19, zendesk.messaging.android.internal.model.MessageShape r20, zendesk.messaging.android.internal.model.MessageSize r21, zendesk.conversationkit.android.model.MessageStatus r22, zendesk.conversationkit.android.model.Message r23, zendesk.messaging.android.internal.model.MessageReceipt r24, int r25, kotlin.jvm.internal.DefaultConstructorMarker r26) {
            /*
                r14 = this;
                r0 = r25
                r1 = r0 & 2
                r2 = 0
                if (r1 == 0) goto L_0x0009
                r5 = r2
                goto L_0x000b
            L_0x0009:
                r5 = r16
            L_0x000b:
                r1 = r0 & 4
                if (r1 == 0) goto L_0x0011
                r6 = r2
                goto L_0x0013
            L_0x0011:
                r6 = r17
            L_0x0013:
                r1 = r0 & 16
                if (r1 == 0) goto L_0x001b
                zendesk.messaging.android.internal.model.MessagePosition r1 = zendesk.messaging.android.internal.model.MessagePosition.STANDALONE
                r8 = r1
                goto L_0x001d
            L_0x001b:
                r8 = r19
            L_0x001d:
                r1 = r0 & 32
                if (r1 == 0) goto L_0x0025
                zendesk.messaging.android.internal.model.MessageShape r1 = zendesk.messaging.android.internal.model.MessageShape.STANDALONE
                r9 = r1
                goto L_0x0027
            L_0x0025:
                r9 = r20
            L_0x0027:
                r1 = r0 & 64
                if (r1 == 0) goto L_0x002f
                zendesk.messaging.android.internal.model.MessageSize r1 = zendesk.messaging.android.internal.model.MessageSize.NORMAL
                r10 = r1
                goto L_0x0031
            L_0x002f:
                r10 = r21
            L_0x0031:
                r0 = r0 & 512(0x200, float:7.175E-43)
                if (r0 == 0) goto L_0x0037
                r13 = r2
                goto L_0x0039
            L_0x0037:
                r13 = r24
            L_0x0039:
                r3 = r14
                r4 = r15
                r7 = r18
                r11 = r22
                r12 = r23
                r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.MessageContainer.<init>(java.lang.String, java.lang.String, java.lang.String, zendesk.messaging.android.internal.model.MessageDirection, zendesk.messaging.android.internal.model.MessagePosition, zendesk.messaging.android.internal.model.MessageShape, zendesk.messaging.android.internal.model.MessageSize, zendesk.conversationkit.android.model.MessageStatus, zendesk.conversationkit.android.model.Message, zendesk.messaging.android.internal.model.MessageReceipt, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public final MessagePosition getPosition() {
            return this.position;
        }

        public final MessageShape getShape() {
            return this.shape;
        }

        public final MessageSize getSize() {
            return this.size;
        }

        public final MessageStatus getStatus() {
            return this.status;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final MessageReceipt getReceipt() {
            return this.receipt;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessageContainer(String str, String str2, String str3, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, MessageSize messageSize, MessageStatus messageStatus, Message message2, MessageReceipt messageReceipt) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(messageDirection, "direction");
            Intrinsics.checkNotNullParameter(messagePosition, ViewProps.POSITION);
            Intrinsics.checkNotNullParameter(messageShape, "shape");
            Intrinsics.checkNotNullParameter(messageSize, "size");
            Intrinsics.checkNotNullParameter(messageStatus, "status");
            Intrinsics.checkNotNullParameter(message2, "message");
            this.id = str;
            this.label = str2;
            this.avatarUrl = str3;
            this.direction = messageDirection;
            this.position = messagePosition;
            this.shape = messageShape;
            this.size = messageSize;
            this.status = messageStatus;
            this.message = message2;
            this.receipt = messageReceipt;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$TypingIndicator;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "avatarUrl", "(Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getId", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static final class TypingIndicator extends MessageLogEntry {
        private final String avatarUrl;
        private final String id;

        public static /* synthetic */ TypingIndicator copy$default(TypingIndicator typingIndicator, String str, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = typingIndicator.getId();
            }
            if ((i & 2) != 0) {
                str2 = typingIndicator.avatarUrl;
            }
            return typingIndicator.copy(str, str2);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return this.avatarUrl;
        }

        public final TypingIndicator copy(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "avatarUrl");
            return new TypingIndicator(str, str2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TypingIndicator)) {
                return false;
            }
            TypingIndicator typingIndicator = (TypingIndicator) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) typingIndicator.getId()) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) typingIndicator.avatarUrl);
        }

        public int hashCode() {
            return (getId().hashCode() * 31) + this.avatarUrl.hashCode();
        }

        public String toString() {
            return "TypingIndicator(id=" + getId() + ", avatarUrl=" + this.avatarUrl + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ TypingIndicator(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
            /*
                r0 = this;
                r3 = r3 & 1
                if (r3 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r3 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
            L_0x0011:
                r0.<init>(r1, r2)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.TypingIndicator.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public String getId() {
            return this.id;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public TypingIndicator(String str, String str2) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "avatarUrl");
            this.id = str;
            this.avatarUrl = str2;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$MessagesDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "text", "type", "Lzendesk/messaging/android/internal/model/MessageLogType;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/messaging/android/internal/model/MessageLogType;)V", "getId", "()Ljava/lang/String;", "getText", "getType", "()Lzendesk/messaging/android/internal/model/MessageLogType;", "setType", "(Lzendesk/messaging/android/internal/model/MessageLogType;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static final class MessagesDivider extends MessageLogEntry {
        private final String id;
        private final String text;
        private MessageLogType type;

        public static /* synthetic */ MessagesDivider copy$default(MessagesDivider messagesDivider, String str, String str2, MessageLogType messageLogType, int i, Object obj) {
            if ((i & 1) != 0) {
                str = messagesDivider.getId();
            }
            if ((i & 2) != 0) {
                str2 = messagesDivider.text;
            }
            if ((i & 4) != 0) {
                messageLogType = messagesDivider.type;
            }
            return messagesDivider.copy(str, str2, messageLogType);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return this.text;
        }

        public final MessageLogType component3() {
            return this.type;
        }

        public final MessagesDivider copy(String str, String str2, MessageLogType messageLogType) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(messageLogType, "type");
            return new MessagesDivider(str, str2, messageLogType);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof MessagesDivider)) {
                return false;
            }
            MessagesDivider messagesDivider = (MessagesDivider) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) messagesDivider.getId()) && Intrinsics.areEqual((Object) this.text, (Object) messagesDivider.text) && this.type == messagesDivider.type;
        }

        public int hashCode() {
            return (((getId().hashCode() * 31) + this.text.hashCode()) * 31) + this.type.hashCode();
        }

        public String toString() {
            return "MessagesDivider(id=" + getId() + ", text=" + this.text + ", type=" + this.type + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ MessagesDivider(java.lang.String r1, java.lang.String r2, zendesk.messaging.android.internal.model.MessageLogType r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
            /*
                r0 = this;
                r4 = r4 & 1
                if (r4 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r4 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            L_0x0011:
                r0.<init>(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.MessagesDivider.<init>(java.lang.String, java.lang.String, zendesk.messaging.android.internal.model.MessageLogType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public String getId() {
            return this.id;
        }

        public final String getText() {
            return this.text;
        }

        public final MessageLogType getType() {
            return this.type;
        }

        public final void setType(MessageLogType messageLogType) {
            Intrinsics.checkNotNullParameter(messageLogType, "<set-?>");
            this.type = messageLogType;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public MessagesDivider(String str, String str2, MessageLogType messageLogType) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(str2, "text");
            Intrinsics.checkNotNullParameter(messageLogType, "type");
            this.id = str;
            this.text = str2;
            this.type = messageLogType;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\t\nB\u0017\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007\u0001\u0002\u000b\f¨\u0006\r"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "timestamp", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTimestamp", "MessageDayDivider", "MessageTimeDivider", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider$MessageTimeDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider$MessageDayDivider;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static abstract class TimestampDivider extends MessageLogEntry {
        private final String id;
        private final String timestamp;

        public /* synthetic */ TimestampDivider(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, str2);
        }

        public String getId() {
            return this.id;
        }

        public String getTimestamp() {
            return this.timestamp;
        }

        private TimestampDivider(String str, String str2) {
            super(str, (DefaultConstructorMarker) null);
            this.id = str;
            this.timestamp = str2;
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider$MessageTimeDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider;", "id", "", "timestamp", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: MessageLogEntry.kt */
        public static final class MessageTimeDivider extends TimestampDivider {
            private final String id;
            private final String timestamp;

            public static /* synthetic */ MessageTimeDivider copy$default(MessageTimeDivider messageTimeDivider, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = messageTimeDivider.getId();
                }
                if ((i & 2) != 0) {
                    str2 = messageTimeDivider.getTimestamp();
                }
                return messageTimeDivider.copy(str, str2);
            }

            public final String component1() {
                return getId();
            }

            public final String component2() {
                return getTimestamp();
            }

            public final MessageTimeDivider copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                return new MessageTimeDivider(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageTimeDivider)) {
                    return false;
                }
                MessageTimeDivider messageTimeDivider = (MessageTimeDivider) obj;
                return Intrinsics.areEqual((Object) getId(), (Object) messageTimeDivider.getId()) && Intrinsics.areEqual((Object) getTimestamp(), (Object) messageTimeDivider.getTimestamp());
            }

            public int hashCode() {
                return (getId().hashCode() * 31) + getTimestamp().hashCode();
            }

            public String toString() {
                return "MessageTimeDivider(id=" + getId() + ", timestamp=" + getTimestamp() + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ MessageTimeDivider(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
                /*
                    r0 = this;
                    r3 = r3 & 1
                    if (r3 == 0) goto L_0x0011
                    java.util.UUID r1 = java.util.UUID.randomUUID()
                    java.lang.String r1 = r1.toString()
                    java.lang.String r3 = "randomUUID().toString()"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                L_0x0011:
                    r0.<init>(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.TimestampDivider.MessageTimeDivider.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public String getId() {
                return this.id;
            }

            public String getTimestamp() {
                return this.timestamp;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageTimeDivider(String str, String str2) {
                super(str, str2, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                this.id = str;
                this.timestamp = str2;
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider$MessageDayDivider;", "Lzendesk/messaging/android/internal/model/MessageLogEntry$TimestampDivider;", "id", "", "timestamp", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTimestamp", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
        /* compiled from: MessageLogEntry.kt */
        public static final class MessageDayDivider extends TimestampDivider {
            private final String id;
            private final String timestamp;

            public static /* synthetic */ MessageDayDivider copy$default(MessageDayDivider messageDayDivider, String str, String str2, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = messageDayDivider.getId();
                }
                if ((i & 2) != 0) {
                    str2 = messageDayDivider.getTimestamp();
                }
                return messageDayDivider.copy(str, str2);
            }

            public final String component1() {
                return getId();
            }

            public final String component2() {
                return getTimestamp();
            }

            public final MessageDayDivider copy(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                return new MessageDayDivider(str, str2);
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof MessageDayDivider)) {
                    return false;
                }
                MessageDayDivider messageDayDivider = (MessageDayDivider) obj;
                return Intrinsics.areEqual((Object) getId(), (Object) messageDayDivider.getId()) && Intrinsics.areEqual((Object) getTimestamp(), (Object) messageDayDivider.getTimestamp());
            }

            public int hashCode() {
                return (getId().hashCode() * 31) + getTimestamp().hashCode();
            }

            public String toString() {
                return "MessageDayDivider(id=" + getId() + ", timestamp=" + getTimestamp() + ')';
            }

            /* JADX WARNING: Illegal instructions before constructor call */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public /* synthetic */ MessageDayDivider(java.lang.String r1, java.lang.String r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
                /*
                    r0 = this;
                    r3 = r3 & 1
                    if (r3 == 0) goto L_0x0011
                    java.util.UUID r1 = java.util.UUID.randomUUID()
                    java.lang.String r1 = r1.toString()
                    java.lang.String r3 = "randomUUID().toString()"
                    kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)
                L_0x0011:
                    r0.<init>(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.TimestampDivider.MessageDayDivider.<init>(java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
            }

            public String getId() {
                return this.id;
            }

            public String getTimestamp() {
                return this.timestamp;
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public MessageDayDivider(String str, String str2) {
                super(str, str2, (DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(str, "id");
                Intrinsics.checkNotNullParameter(str2, "timestamp");
                this.id = str;
                this.timestamp = str2;
            }
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$QuickReply;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "replies", "", "Lzendesk/conversationkit/android/model/MessageAction$Reply;", "(Ljava/lang/String;Ljava/util/List;)V", "getId", "()Ljava/lang/String;", "getReplies", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static final class QuickReply extends MessageLogEntry {
        private final String id;
        private final List<MessageAction.Reply> replies;

        public static /* synthetic */ QuickReply copy$default(QuickReply quickReply, String str, List<MessageAction.Reply> list, int i, Object obj) {
            if ((i & 1) != 0) {
                str = quickReply.getId();
            }
            if ((i & 2) != 0) {
                list = quickReply.replies;
            }
            return quickReply.copy(str, list);
        }

        public final String component1() {
            return getId();
        }

        public final List<MessageAction.Reply> component2() {
            return this.replies;
        }

        public final QuickReply copy(String str, List<MessageAction.Reply> list) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "replies");
            return new QuickReply(str, list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof QuickReply)) {
                return false;
            }
            QuickReply quickReply = (QuickReply) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) quickReply.getId()) && Intrinsics.areEqual((Object) this.replies, (Object) quickReply.replies);
        }

        public int hashCode() {
            return (getId().hashCode() * 31) + this.replies.hashCode();
        }

        public String toString() {
            return "QuickReply(id=" + getId() + ", replies=" + this.replies + ')';
        }

        public String getId() {
            return this.id;
        }

        public final List<MessageAction.Reply> getReplies() {
            return this.replies;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public QuickReply(String str, List<MessageAction.Reply> list) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(list, "replies");
            this.id = str;
            this.replies = list;
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lzendesk/messaging/android/internal/model/MessageLogEntry$LoadMore;", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "id", "", "failedRetryText", "status", "Lzendesk/messaging/android/internal/model/LoadMoreStatus;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/messaging/android/internal/model/LoadMoreStatus;)V", "getFailedRetryText", "()Ljava/lang/String;", "getId", "getStatus", "()Lzendesk/messaging/android/internal/model/LoadMoreStatus;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageLogEntry.kt */
    public static final class LoadMore extends MessageLogEntry {
        private final String failedRetryText;
        private final String id;
        private final LoadMoreStatus status;

        public static /* synthetic */ LoadMore copy$default(LoadMore loadMore, String str, String str2, LoadMoreStatus loadMoreStatus, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loadMore.getId();
            }
            if ((i & 2) != 0) {
                str2 = loadMore.failedRetryText;
            }
            if ((i & 4) != 0) {
                loadMoreStatus = loadMore.status;
            }
            return loadMore.copy(str, str2, loadMoreStatus);
        }

        public final String component1() {
            return getId();
        }

        public final String component2() {
            return this.failedRetryText;
        }

        public final LoadMoreStatus component3() {
            return this.status;
        }

        public final LoadMore copy(String str, String str2, LoadMoreStatus loadMoreStatus) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(loadMoreStatus, "status");
            return new LoadMore(str, str2, loadMoreStatus);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadMore)) {
                return false;
            }
            LoadMore loadMore = (LoadMore) obj;
            return Intrinsics.areEqual((Object) getId(), (Object) loadMore.getId()) && Intrinsics.areEqual((Object) this.failedRetryText, (Object) loadMore.failedRetryText) && this.status == loadMore.status;
        }

        public int hashCode() {
            int hashCode = getId().hashCode() * 31;
            String str = this.failedRetryText;
            return ((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.status.hashCode();
        }

        public String toString() {
            return "LoadMore(id=" + getId() + ", failedRetryText=" + this.failedRetryText + ", status=" + this.status + ')';
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ LoadMore(java.lang.String r1, java.lang.String r2, zendesk.messaging.android.internal.model.LoadMoreStatus r3, int r4, kotlin.jvm.internal.DefaultConstructorMarker r5) {
            /*
                r0 = this;
                r5 = r4 & 1
                if (r5 == 0) goto L_0x0011
                java.util.UUID r1 = java.util.UUID.randomUUID()
                java.lang.String r1 = r1.toString()
                java.lang.String r5 = "randomUUID().toString()"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r5)
            L_0x0011:
                r4 = r4 & 2
                if (r4 == 0) goto L_0x0016
                r2 = 0
            L_0x0016:
                r0.<init>(r1, r2, r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.model.MessageLogEntry.LoadMore.<init>(java.lang.String, java.lang.String, zendesk.messaging.android.internal.model.LoadMoreStatus, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
        }

        public String getId() {
            return this.id;
        }

        public final String getFailedRetryText() {
            return this.failedRetryText;
        }

        public final LoadMoreStatus getStatus() {
            return this.status;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadMore(String str, String str2, LoadMoreStatus loadMoreStatus) {
            super(str, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(loadMoreStatus, "status");
            this.id = str;
            this.failedRetryText = str2;
            this.status = loadMoreStatus;
        }
    }
}
