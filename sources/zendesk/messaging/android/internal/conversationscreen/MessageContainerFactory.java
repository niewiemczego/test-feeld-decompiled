package zendesk.messaging.android.internal.conversationscreen;

import com.facebook.react.uimanager.ViewProps;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.Message;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.conversationkit.android.model.MessageType;
import zendesk.core.android.internal.DateKtxKt;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.messaging.android.internal.model.MessagePosition;
import zendesk.messaging.android.internal.model.MessageReceipt;
import zendesk.messaging.android.internal.model.MessageShape;
import zendesk.messaging.android.internal.model.MessageSize;
import zendesk.messaging.android.internal.model.MessageStatusIcon;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ>\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J<\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J>\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J>\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lzendesk/messaging/android/internal/conversationscreen/MessageContainerFactory;", "", "labelProvider", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;", "timestampFormatter", "Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;", "currentTimeProvider", "Lkotlin/Function0;", "Ljava/time/LocalDateTime;", "(Lzendesk/messaging/android/internal/conversationscreen/MessageLogLabelProvider;Lzendesk/messaging/android/internal/conversationscreen/MessageLogTimestampFormatter;Lkotlin/jvm/functions/Function0;)V", "createCarouselMessageContainer", "", "Lzendesk/messaging/android/internal/model/MessageLogEntry;", "message", "Lzendesk/conversationkit/android/model/Message;", "direction", "Lzendesk/messaging/android/internal/model/MessageDirection;", "position", "Lzendesk/messaging/android/internal/model/MessagePosition;", "shape", "Lzendesk/messaging/android/internal/model/MessageShape;", "isLatestMessage", "", "shouldAnimateReceipt", "createMessageContainer", "createMultipleMessageContainer", "createSingleMessageContainer", "getReceipt", "Lzendesk/messaging/android/internal/model/MessageReceipt;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerFactory.kt */
public final class MessageContainerFactory {
    private final Function0<LocalDateTime> currentTimeProvider;
    private final MessageLogLabelProvider labelProvider;
    private final MessageLogTimestampFormatter timestampFormatter;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessageContainerFactory.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[MessageType.values().length];
            iArr[MessageType.UNSUPPORTED.ordinal()] = 1;
            iArr[MessageType.LIST.ordinal()] = 2;
            iArr[MessageType.LOCATION.ordinal()] = 3;
            iArr[MessageType.FORM.ordinal()] = 4;
            iArr[MessageType.FORM_RESPONSE.ordinal()] = 5;
            iArr[MessageType.IMAGE.ordinal()] = 6;
            iArr[MessageType.FILE.ordinal()] = 7;
            iArr[MessageType.FILE_UPLOAD.ordinal()] = 8;
            iArr[MessageType.CAROUSEL.ordinal()] = 9;
            iArr[MessageType.TEXT.ordinal()] = 10;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MessageStatus.values().length];
            iArr2[MessageStatus.PENDING.ordinal()] = 1;
            iArr2[MessageStatus.SENT.ordinal()] = 2;
            iArr2[MessageStatus.FAILED.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public MessageContainerFactory(MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter, Function0<LocalDateTime> function0) {
        Intrinsics.checkNotNullParameter(messageLogLabelProvider, "labelProvider");
        Intrinsics.checkNotNullParameter(messageLogTimestampFormatter, "timestampFormatter");
        Intrinsics.checkNotNullParameter(function0, "currentTimeProvider");
        this.labelProvider = messageLogLabelProvider;
        this.timestampFormatter = messageLogTimestampFormatter;
        this.currentTimeProvider = function0;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MessageContainerFactory(MessageLogLabelProvider messageLogLabelProvider, MessageLogTimestampFormatter messageLogTimestampFormatter, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(messageLogLabelProvider, messageLogTimestampFormatter, (i & 4) != 0 ? AnonymousClass1.INSTANCE : function0);
    }

    public final List<MessageLogEntry> createMessageContainer(Message message, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(message, "message");
        Intrinsics.checkNotNullParameter(messageDirection, "direction");
        Intrinsics.checkNotNullParameter(messagePosition, ViewProps.POSITION);
        Intrinsics.checkNotNullParameter(messageShape, "shape");
        switch (WhenMappings.$EnumSwitchMapping$0[message.getContent().getType().ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return createSingleMessageContainer(message, messageDirection, messagePosition, messageShape, z, z2);
            case 9:
                return createCarouselMessageContainer(message, messageDirection, messagePosition, messageShape, z, z2);
            case 10:
                return createMultipleMessageContainer(message, messageDirection, messagePosition, messageShape, z, z2);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final List<MessageLogEntry> createSingleMessageContainer(Message message, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, boolean z, boolean z2) {
        String str;
        MessageDirection messageDirection2 = messageDirection;
        MessagePosition messagePosition2 = messagePosition;
        MessageContent content = message.getContent();
        MessageContent.FormResponse formResponse = content instanceof MessageContent.FormResponse ? (MessageContent.FormResponse) content : null;
        if (formResponse == null || (str = formResponse.getQuotedMessageId()) == null) {
            str = message.getId();
        }
        String str2 = str;
        boolean z3 = true;
        String displayName = (messagePosition2 == MessagePosition.STANDALONE || messagePosition2 == MessagePosition.GROUP_TOP) && messageDirection2 == MessageDirection.INBOUND ? message.getAuthor().getDisplayName() : null;
        String avatarUrl = (messagePosition2 == MessagePosition.STANDALONE || messagePosition2 == MessagePosition.GROUP_BOTTOM) && messageDirection2 == MessageDirection.INBOUND ? message.getAuthor().getAvatarUrl() : null;
        MessageSize messageSize = MessageSize.NORMAL;
        MessageStatus status = message.getStatus();
        MessageReceipt receipt = getReceipt(message, messageDirection2, z2);
        if (!z && message.getStatus() != MessageStatus.FAILED) {
            z3 = false;
        }
        return CollectionsKt.listOf(new MessageLogEntry.MessageContainer(str2, displayName, avatarUrl, messageDirection, messagePosition, messageShape, messageSize, status, message, z3 ? receipt : null));
    }

    private final List<MessageLogEntry> createCarouselMessageContainer(Message message, MessageDirection messageDirection, MessagePosition messagePosition, MessageShape messageShape, boolean z, boolean z2) {
        MessageDirection messageDirection2 = messageDirection;
        MessagePosition messagePosition2 = messagePosition;
        String id = message.getId();
        boolean z3 = true;
        String displayName = (messagePosition2 == MessagePosition.STANDALONE || messagePosition2 == MessagePosition.GROUP_TOP) && messageDirection2 == MessageDirection.INBOUND ? message.getAuthor().getDisplayName() : null;
        String avatarUrl = message.getAuthor().getAvatarUrl();
        MessageSize messageSize = MessageSize.FULL_WIDTH;
        MessageStatus status = message.getStatus();
        MessageReceipt receipt = getReceipt(message, messageDirection2, z2);
        if (!z && message.getStatus() != MessageStatus.FAILED) {
            z3 = false;
        }
        return CollectionsKt.listOf(new MessageLogEntry.MessageContainer(id, displayName, avatarUrl, messageDirection, messagePosition, messageShape, messageSize, status, message, z3 ? receipt : null));
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v2, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<zendesk.messaging.android.internal.model.MessageLogEntry> createMultipleMessageContainer(zendesk.conversationkit.android.model.Message r20, zendesk.messaging.android.internal.model.MessageDirection r21, zendesk.messaging.android.internal.model.MessagePosition r22, zendesk.messaging.android.internal.model.MessageShape r23, boolean r24, boolean r25) {
        /*
            r19 = this;
            r4 = r21
            r5 = r22
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r13 = r0
            java.util.List r13 = (java.util.List) r13
            java.lang.String r1 = r20.getId()
            zendesk.conversationkit.android.model.Author r0 = r20.getAuthor()
            java.lang.String r0 = r0.getDisplayName()
            zendesk.messaging.android.internal.model.MessagePosition r2 = zendesk.messaging.android.internal.model.MessagePosition.STANDALONE
            r15 = 0
            if (r5 == r2) goto L_0x0021
            zendesk.messaging.android.internal.model.MessagePosition r2 = zendesk.messaging.android.internal.model.MessagePosition.GROUP_TOP
            if (r5 != r2) goto L_0x0027
        L_0x0021:
            zendesk.messaging.android.internal.model.MessageDirection r2 = zendesk.messaging.android.internal.model.MessageDirection.INBOUND
            if (r4 != r2) goto L_0x0027
            r2 = 1
            goto L_0x0028
        L_0x0027:
            r2 = r15
        L_0x0028:
            r16 = 0
            if (r2 == 0) goto L_0x002e
            r2 = r0
            goto L_0x0030
        L_0x002e:
            r2 = r16
        L_0x0030:
            zendesk.conversationkit.android.model.Author r0 = r20.getAuthor()
            java.lang.String r0 = r0.getAvatarUrl()
            zendesk.messaging.android.internal.model.MessagePosition r3 = zendesk.messaging.android.internal.model.MessagePosition.STANDALONE
            if (r5 == r3) goto L_0x0040
            zendesk.messaging.android.internal.model.MessagePosition r3 = zendesk.messaging.android.internal.model.MessagePosition.GROUP_BOTTOM
            if (r5 != r3) goto L_0x0046
        L_0x0040:
            zendesk.messaging.android.internal.model.MessageDirection r3 = zendesk.messaging.android.internal.model.MessageDirection.INBOUND
            if (r4 != r3) goto L_0x0046
            r3 = 1
            goto L_0x0047
        L_0x0046:
            r3 = r15
        L_0x0047:
            if (r3 == 0) goto L_0x004b
            r3 = r0
            goto L_0x004d
        L_0x004b:
            r3 = r16
        L_0x004d:
            r7 = 0
            zendesk.conversationkit.android.model.MessageStatus r8 = r20.getStatus()
            r12 = r19
            r11 = r20
            r0 = r25
            zendesk.messaging.android.internal.model.MessageReceipt r0 = r12.getReceipt(r11, r4, r0)
            if (r24 != 0) goto L_0x0069
            zendesk.conversationkit.android.model.MessageStatus r6 = r20.getStatus()
            zendesk.conversationkit.android.model.MessageStatus r9 = zendesk.conversationkit.android.model.MessageStatus.FAILED
            if (r6 != r9) goto L_0x0067
            goto L_0x0069
        L_0x0067:
            r6 = r15
            goto L_0x006a
        L_0x0069:
            r6 = 1
        L_0x006a:
            if (r6 == 0) goto L_0x006e
            r10 = r0
            goto L_0x0070
        L_0x006e:
            r10 = r16
        L_0x0070:
            r17 = 64
            r18 = 0
            zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer r9 = new zendesk.messaging.android.internal.model.MessageLogEntry$MessageContainer
            r0 = r9
            r4 = r21
            r5 = r22
            r6 = r23
            r14 = r9
            r9 = r20
            r11 = r17
            r12 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.add(r14)
            if (r24 == 0) goto L_0x00e3
            zendesk.conversationkit.android.model.MessageContent r0 = r20.getContent()
            boolean r1 = r0 instanceof zendesk.conversationkit.android.model.MessageContent.Text
            if (r1 == 0) goto L_0x0097
            zendesk.conversationkit.android.model.MessageContent$Text r0 = (zendesk.conversationkit.android.model.MessageContent.Text) r0
            goto L_0x0099
        L_0x0097:
            r0 = r16
        L_0x0099:
            if (r0 == 0) goto L_0x00c4
            java.util.List r0 = r0.getActions()
            if (r0 == 0) goto L_0x00c4
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x00ae:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x00c0
            java.lang.Object r2 = r0.next()
            boolean r3 = r2 instanceof zendesk.conversationkit.android.model.MessageAction.Reply
            if (r3 == 0) goto L_0x00ae
            r1.add(r2)
            goto L_0x00ae
        L_0x00c0:
            r16 = r1
            java.util.List r16 = (java.util.List) r16
        L_0x00c4:
            r0 = r16
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x00d4
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00d2
            goto L_0x00d4
        L_0x00d2:
            r14 = r15
            goto L_0x00d5
        L_0x00d4:
            r14 = 1
        L_0x00d5:
            if (r14 != 0) goto L_0x00e3
            zendesk.messaging.android.internal.model.MessageLogEntry$QuickReply r1 = new zendesk.messaging.android.internal.model.MessageLogEntry$QuickReply
            java.lang.String r2 = r20.getId()
            r1.<init>(r2, r0)
            r13.add(r1)
        L_0x00e3:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.internal.conversationscreen.MessageContainerFactory.createMultipleMessageContainer(zendesk.conversationkit.android.model.Message, zendesk.messaging.android.internal.model.MessageDirection, zendesk.messaging.android.internal.model.MessagePosition, zendesk.messaging.android.internal.model.MessageShape, boolean, boolean):java.util.List");
    }

    private final MessageReceipt getReceipt(Message message, MessageDirection messageDirection, boolean z) {
        String str;
        MessageStatusIcon messageStatusIcon;
        LocalDateTime timestamp = message.getTimestamp();
        MessageStatus status = message.getStatus();
        boolean z2 = DateKtxKt.toTimestamp$default(this.currentTimeProvider.invoke(), (ZoneId) null, 1, (Object) null) - DateKtxKt.toTimestamp$default(timestamp, (ZoneId) null, 1, (Object) null) <= 60000;
        if (messageDirection == MessageDirection.OUTBOUND) {
            if (status == MessageStatus.PENDING) {
                str = this.labelProvider.sending();
            } else if (status == MessageStatus.FAILED) {
                str = this.labelProvider.tapToRetry();
            } else if (z2) {
                str = this.labelProvider.sentJustNow();
            } else {
                str = this.labelProvider.sentAt(this.timestampFormatter.timeOnly(timestamp));
            }
        } else if (status == MessageStatus.FAILED && (message.getContent().getType() == MessageType.FORM || message.getContent().getType() == MessageType.FORM_RESPONSE)) {
            str = this.labelProvider.formSubmissionFailed();
        } else if (z2) {
            str = this.labelProvider.justNow();
        } else {
            str = this.timestampFormatter.timeOnly(timestamp);
        }
        int i = WhenMappings.$EnumSwitchMapping$1[status.ordinal()];
        if (i == 1) {
            messageStatusIcon = MessageStatusIcon.TAIL_SENDING;
        } else if (i == 2) {
            messageStatusIcon = MessageStatusIcon.TAIL_SENT;
        } else if (i == 3) {
            messageStatusIcon = MessageStatusIcon.FAILED;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return new MessageReceipt(str, messageStatusIcon, z);
    }
}
