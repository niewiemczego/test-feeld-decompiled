package zendesk.messaging.android.internal.conversationscreen.delegates;

import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate;
import zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageReceipt;
import zendesk.ui.android.conversation.receipt.MessageReceiptPosition;
import zendesk.ui.android.conversation.receipt.MessageReceiptRendering;
import zendesk.ui.android.conversation.receipt.MessageReceiptState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/receipt/MessageReceiptRendering;", "receiptViewRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageContainerAdapterDelegate.kt */
final class MessageContainerAdapterDelegate$ViewHolder$renderReceipt$1 extends Lambda implements Function1<MessageReceiptRendering, MessageReceiptRendering> {
    final /* synthetic */ MessageDirection $direction;
    final /* synthetic */ boolean $isUnsupported;
    final /* synthetic */ MessageReceipt $receipt;
    final /* synthetic */ boolean $showIcon;
    final /* synthetic */ MessageStatus $status;
    final /* synthetic */ MessageContainerAdapterDelegate.ViewHolder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageContainerAdapterDelegate$ViewHolder$renderReceipt$1(MessageContainerAdapterDelegate.ViewHolder viewHolder, MessageReceipt messageReceipt, boolean z, MessageDirection messageDirection, MessageStatus messageStatus, boolean z2) {
        super(1);
        this.this$0 = viewHolder;
        this.$receipt = messageReceipt;
        this.$showIcon = z;
        this.$direction = messageDirection;
        this.$status = messageStatus;
        this.$isUnsupported = z2;
    }

    public final MessageReceiptRendering invoke(MessageReceiptRendering messageReceiptRendering) {
        Intrinsics.checkNotNullParameter(messageReceiptRendering, "receiptViewRendering");
        MessageReceiptRendering.Builder builder = messageReceiptRendering.toBuilder();
        final MessageContainerAdapterDelegate.ViewHolder viewHolder = this.this$0;
        final MessageReceipt messageReceipt = this.$receipt;
        final boolean z = this.$showIcon;
        final MessageDirection messageDirection = this.$direction;
        final MessageStatus messageStatus = this.$status;
        final boolean z2 = this.$isUnsupported;
        return builder.state(new Function1<MessageReceiptState, MessageReceiptState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.delegates.MessageContainerAdapterDelegate$ViewHolder$renderReceipt$1$1$WhenMappings */
            /* compiled from: MessageContainerAdapterDelegate.kt */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[MessageStatus.values().length];
                    iArr[MessageStatus.PENDING.ordinal()] = 1;
                    iArr[MessageStatus.SENT.ordinal()] = 2;
                    iArr[MessageStatus.FAILED.ordinal()] = 3;
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            public final MessageReceiptState invoke(MessageReceiptState messageReceiptState) {
                Intrinsics.checkNotNullParameter(messageReceiptState, "state");
                int adjustAlpha$zendesk_messaging_messaging_android = MessageLogCellFactory.INSTANCE.adjustAlpha$zendesk_messaging_messaging_android(ContextCompat.getColor(viewHolder.receiptView.getContext(), R.color.zma_color_on_background), 0.65f);
                int color = ContextCompat.getColor(viewHolder.receiptView.getContext(), R.color.zma_color_on_danger);
                MessageReceiptState.Builder showIcon = messageReceiptState.toBuilder().label(messageReceipt.getLabel()).showIcon(z);
                MessageDirection messageDirection = messageDirection;
                MessageStatus messageStatus = messageStatus;
                boolean z = z2;
                MessageReceipt messageReceipt = messageReceipt;
                MessageContainerAdapterDelegate.ViewHolder viewHolder = viewHolder;
                if (messageDirection == MessageDirection.INBOUND && messageStatus == MessageStatus.FAILED) {
                    showIcon.messageReceiptPosition(MessageReceiptPosition.INBOUND_FAILED);
                    showIcon.labelColor(color);
                    showIcon.iconColor(color);
                } else if (messageDirection == MessageDirection.INBOUND && z) {
                    showIcon.messageReceiptPosition(MessageReceiptPosition.INBOUND_FAILED);
                    showIcon.labelColor(color);
                    showIcon.iconColor(color);
                } else if (messageDirection == MessageDirection.INBOUND) {
                    showIcon.shouldAnimateReceipt(messageReceipt.getShouldAnimateReceipt());
                    int color2 = ContextCompat.getColor(viewHolder.receiptView.getContext(), R.color.zma_color_message_inbound_background);
                    showIcon.messageReceiptPosition(MessageReceiptPosition.INBOUND);
                    showIcon.labelColor(adjustAlpha$zendesk_messaging_messaging_android);
                    showIcon.iconColor(color2);
                } else {
                    Integer access$getOutboundMessageColor$p = viewHolder.outboundMessageColor;
                    int intValue = access$getOutboundMessageColor$p != null ? access$getOutboundMessageColor$p.intValue() : ContextCompat.getColor(viewHolder.receiptView.getContext(), R.color.zma_color_message);
                    int i = WhenMappings.$EnumSwitchMapping$0[messageStatus.ordinal()];
                    if (i == 1) {
                        showIcon.messageReceiptPosition(MessageReceiptPosition.OUTBOUND_SENDING);
                        showIcon.shouldAnimateReceipt(messageReceipt.getShouldAnimateReceipt());
                        showIcon.labelColor(adjustAlpha$zendesk_messaging_messaging_android);
                        showIcon.iconColor(MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, intValue, 0.0f, 1, (Object) null));
                    } else if (i == 2) {
                        showIcon.messageReceiptPosition(MessageReceiptPosition.OUTBOUND_SENT);
                        showIcon.shouldAnimateReceipt(messageReceipt.getShouldAnimateReceipt());
                        showIcon.labelColor(adjustAlpha$zendesk_messaging_messaging_android);
                        showIcon.iconColor(intValue);
                    } else if (i == 3) {
                        showIcon.messageReceiptPosition(MessageReceiptPosition.OUTBOUND_FAILED);
                        showIcon.labelColor(color);
                        showIcon.iconColor(color);
                    }
                }
                return showIcon.build();
            }
        }).build();
    }
}
