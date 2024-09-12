package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.content.Context;
import androidx.core.content.ContextCompat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.textcell.TextCellRendering;
import zendesk.ui.android.conversation.textcell.TextCellState;
import zendesk.ui.android.conversation.textcell.TextCellView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "textCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createTextCell$3$1 extends Lambda implements Function1<TextCellRendering, TextCellRendering> {
    final /* synthetic */ Integer $actionColor;
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ Function1<MessageLogEntry.MessageContainer, Unit> $onMessageContainerClicked;
    final /* synthetic */ Function1<String, Unit> $onMessageTextClicked;
    final /* synthetic */ int $resolvedOutboundMessageColor;
    final /* synthetic */ TextCellView $this_apply;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createTextCell$3$1(MessageLogEntry.MessageContainer messageContainer, TextCellView textCellView, int i, Integer num, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, Function1<? super String, Unit> function12, UriHandler uriHandler) {
        super(1);
        this.$item = messageContainer;
        this.$this_apply = textCellView;
        this.$resolvedOutboundMessageColor = i;
        this.$actionColor = num;
        this.$onMessageContainerClicked = function1;
        this.$onMessageTextClicked = function12;
        this.$uriHandler = uriHandler;
    }

    public final TextCellRendering invoke(TextCellRendering textCellRendering) {
        Intrinsics.checkNotNullParameter(textCellRendering, "textCellRendering");
        TextCellRendering.Builder builder = textCellRendering.toBuilder();
        final MessageLogEntry.MessageContainer messageContainer = this.$item;
        final TextCellView textCellView = this.$this_apply;
        final int i = this.$resolvedOutboundMessageColor;
        final Integer num = this.$actionColor;
        TextCellRendering.Builder state = builder.state(new Function1<TextCellState, TextCellState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createTextCell$3$1$1$WhenMappings */
            /* compiled from: MessageLogCellFactory.kt */
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

            public final TextCellState invoke(TextCellState textCellState) {
                int i;
                int i2;
                Intrinsics.checkNotNullParameter(textCellState, "state");
                MessageContent content = messageContainer.getMessage().getContent();
                MessageContent.Text text = content instanceof MessageContent.Text ? (MessageContent.Text) content : null;
                String text2 = text != null ? text.getText() : null;
                if (text2 == null) {
                    text2 = "";
                }
                String str = text2;
                if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                    i = ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_message_inbound_text);
                } else if (messageContainer.getStatus() == MessageStatus.FAILED) {
                    i = ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_on_danger);
                } else {
                    i = ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_message_outbound_text);
                }
                if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                    i2 = ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_message_inbound_background);
                } else {
                    int i3 = WhenMappings.$EnumSwitchMapping$0[messageContainer.getStatus().ordinal()];
                    if (i3 == 1) {
                        i2 = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, i, 0.0f, 1, (Object) null);
                    } else if (i3 == 2) {
                        i2 = i;
                    } else if (i3 == 3) {
                        i2 = ContextCompat.getColor(textCellView.getContext(), R.color.zma_color_danger);
                    } else {
                        throw new NoWhenBranchMatchedException();
                    }
                }
                int access$getCellDrawable = MessageLogCellFactory.INSTANCE.getCellDrawable(messageContainer.getShape(), messageContainer.getDirection());
                MessageLogCellFactory messageLogCellFactory = MessageLogCellFactory.INSTANCE;
                MessageLogEntry.MessageContainer messageContainer = messageContainer;
                Context context = textCellView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return textCellState.copy(str, messageLogCellFactory.getCellActions(messageContainer, context), Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(access$getCellDrawable), num);
            }
        });
        final Function1<MessageLogEntry.MessageContainer, Unit> function1 = this.$onMessageContainerClicked;
        final MessageLogEntry.MessageContainer messageContainer2 = this.$item;
        TextCellRendering.Builder onCellClicked = state.onCellClicked(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                function1.invoke(messageContainer2);
            }
        });
        final Function1<String, Unit> function12 = this.$onMessageTextClicked;
        TextCellRendering.Builder onCellTextClicked = onCellClicked.onCellTextClicked(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                function12.invoke(str);
            }
        });
        final UriHandler uriHandler = this.$uriHandler;
        return onCellTextClicked.onActionButtonClicked(new Function2<String, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "uri");
                Intrinsics.checkNotNullParameter(str2, "source");
                MessageLogCellFactory.INSTANCE.onActionUriClicked(str2, uriHandler, str);
            }
        }).build();
    }
}
