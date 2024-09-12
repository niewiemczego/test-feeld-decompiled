package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.net.Uri;
import androidx.core.content.ContextCompat;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.UrlSource;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageDirection;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.imagecell.ImageCellRendering;
import zendesk.ui.android.conversation.imagecell.ImageCellState;
import zendesk.ui.android.conversation.imagecell.ImageCellView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;", "imageCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createImageUploadCell$1$1 extends Lambda implements Function1<ImageCellRendering, ImageCellRendering> {
    final /* synthetic */ MessageContent.FileUpload $content;
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ Function1<MessageLogEntry.MessageContainer, Unit> $onFailedMessageClicked;
    final /* synthetic */ Integer $outboundMessageColor;
    final /* synthetic */ ImageCellView $this_apply;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createImageUploadCell$1$1(Integer num, ImageCellView imageCellView, MessageLogEntry.MessageContainer messageContainer, MessageContent.FileUpload fileUpload, Function1<? super MessageLogEntry.MessageContainer, Unit> function1, UriHandler uriHandler) {
        super(1);
        this.$outboundMessageColor = num;
        this.$this_apply = imageCellView;
        this.$item = messageContainer;
        this.$content = fileUpload;
        this.$onFailedMessageClicked = function1;
        this.$uriHandler = uriHandler;
    }

    public final ImageCellRendering invoke(ImageCellRendering imageCellRendering) {
        Intrinsics.checkNotNullParameter(imageCellRendering, "imageCellRendering");
        ImageCellRendering.Builder builder = imageCellRendering.toBuilder();
        final Integer num = this.$outboundMessageColor;
        final ImageCellView imageCellView = this.$this_apply;
        final MessageLogEntry.MessageContainer messageContainer = this.$item;
        final MessageContent.FileUpload fileUpload = this.$content;
        ImageCellRendering.Builder state = builder.state(new Function1<ImageCellState, ImageCellState>() {

            @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
            /* renamed from: zendesk.messaging.android.internal.conversationscreen.messagelog.MessageLogCellFactory$createImageUploadCell$1$1$1$WhenMappings */
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

            public final ImageCellState invoke(ImageCellState imageCellState) {
                int i;
                Intrinsics.checkNotNullParameter(imageCellState, "state");
                Integer num = num;
                int intValue = num != null ? num.intValue() : ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_message);
                if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                    i = ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_message_inbound_text);
                } else if (messageContainer.getDirection() == MessageDirection.OUTBOUND && messageContainer.getStatus() == MessageStatus.SENT) {
                    i = ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_message_outbound_text);
                } else {
                    i = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_message_outbound_text), 0.0f, 1, (Object) null);
                }
                if (messageContainer.getDirection() == MessageDirection.INBOUND) {
                    intValue = ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_message_inbound_background);
                } else {
                    int i2 = WhenMappings.$EnumSwitchMapping$0[messageContainer.getStatus().ordinal()];
                    if (i2 == 1) {
                        intValue = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, intValue, 0.0f, 1, (Object) null);
                    } else if (i2 != 2) {
                        if (i2 == 3) {
                            intValue = MessageLogCellFactory.adjustAlpha$zendesk_messaging_messaging_android$default(MessageLogCellFactory.INSTANCE, ContextCompat.getColor(imageCellView.getContext(), R.color.zma_color_alert), 0.0f, 1, (Object) null);
                        } else {
                            throw new NoWhenBranchMatchedException();
                        }
                    }
                }
                Uri parse = Uri.parse(fileUpload.getUri());
                Uri parse2 = Uri.parse(fileUpload.getUri());
                String mimeType = fileUpload.getMimeType();
                boolean z = false;
                boolean z2 = messageContainer.getStatus() == MessageStatus.FAILED;
                if (messageContainer.getStatus() == MessageStatus.PENDING) {
                    z = true;
                }
                return ImageCellState.copy$default(imageCellState, parse, parse2, mimeType, (String) null, z2, z, (List) null, Integer.valueOf(i), Integer.valueOf(intValue), (Integer) null, (String) null, MessageLogCellFactory.INSTANCE.getImageCellDirection(messageContainer.getShape(), messageContainer.getDirection()), 1608, (Object) null);
            }
        });
        final MessageLogEntry.MessageContainer messageContainer2 = this.$item;
        final Function1<MessageLogEntry.MessageContainer, Unit> function1 = this.$onFailedMessageClicked;
        final UriHandler uriHandler = this.$uriHandler;
        final MessageContent.FileUpload fileUpload2 = this.$content;
        return state.onImageCellClicked(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "it");
                if (messageContainer2.getStatus() == MessageStatus.FAILED) {
                    function1.invoke(messageContainer2);
                } else if (messageContainer2.getStatus() == MessageStatus.SENT) {
                    uriHandler.onUriClicked(fileUpload2.getUri(), UrlSource.IMAGE);
                }
            }
        }).build();
    }
}
