package zendesk.messaging.android.internal.conversationscreen.messagelog;

import android.content.Context;
import android.net.Uri;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.android.messaging.UrlSource;
import zendesk.conversationkit.android.model.MessageContent;
import zendesk.conversationkit.android.model.MessageStatus;
import zendesk.messaging.R;
import zendesk.messaging.android.internal.UriHandler;
import zendesk.messaging.android.internal.model.MessageLogEntry;
import zendesk.ui.android.conversation.imagecell.ImageCellDirection;
import zendesk.ui.android.conversation.imagecell.ImageCellRendering;
import zendesk.ui.android.conversation.imagecell.ImageCellState;
import zendesk.ui.android.conversation.imagecell.ImageCellView;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;", "imageCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageLogCellFactory.kt */
final class MessageLogCellFactory$createImageCell$cell$1$1 extends Lambda implements Function1<ImageCellRendering, ImageCellRendering> {
    final /* synthetic */ Integer $actionColor;
    final /* synthetic */ int $backgroundColor;
    final /* synthetic */ MessageContent.Image $content;
    final /* synthetic */ MessageLogEntry.MessageContainer $item;
    final /* synthetic */ ViewGroup $parentView;
    final /* synthetic */ int $textColor;
    final /* synthetic */ ImageCellView $this_apply;
    final /* synthetic */ UriHandler $uriHandler;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MessageLogCellFactory$createImageCell$cell$1$1(MessageContent.Image image, ViewGroup viewGroup, MessageLogEntry.MessageContainer messageContainer, ImageCellView imageCellView, int i, int i2, Integer num, UriHandler uriHandler) {
        super(1);
        this.$content = image;
        this.$parentView = viewGroup;
        this.$item = messageContainer;
        this.$this_apply = imageCellView;
        this.$textColor = i;
        this.$backgroundColor = i2;
        this.$actionColor = num;
        this.$uriHandler = uriHandler;
    }

    public final ImageCellRendering invoke(ImageCellRendering imageCellRendering) {
        Intrinsics.checkNotNullParameter(imageCellRendering, "imageCellRendering");
        ImageCellRendering.Builder builder = imageCellRendering.toBuilder();
        final MessageContent.Image image = this.$content;
        final ViewGroup viewGroup = this.$parentView;
        final MessageLogEntry.MessageContainer messageContainer = this.$item;
        final ImageCellView imageCellView = this.$this_apply;
        final int i = this.$textColor;
        final int i2 = this.$backgroundColor;
        final Integer num = this.$actionColor;
        ImageCellRendering.Builder state = builder.state(new Function1<ImageCellState, ImageCellState>() {
            public final ImageCellState invoke(ImageCellState imageCellState) {
                Intrinsics.checkNotNullParameter(imageCellState, "state");
                Uri parse = Uri.parse(image.getMediaUrl());
                String localUri = image.getLocalUri();
                Uri parse2 = localUri != null ? Uri.parse(localUri) : null;
                String mediaType = image.getMediaType();
                String text = image.getText();
                String string = viewGroup.getContext().getString(R.string.zma_image_loading_error);
                ImageCellDirection access$getImageCellDirection = MessageLogCellFactory.INSTANCE.getImageCellDirection(messageContainer.getShape(), messageContainer.getDirection());
                MessageLogCellFactory messageLogCellFactory = MessageLogCellFactory.INSTANCE;
                MessageLogEntry.MessageContainer messageContainer = messageContainer;
                Context context = imageCellView.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                return ImageCellState.copy$default(imageCellState, parse, parse2, mediaType, text, false, false, messageLogCellFactory.getCellActions(messageContainer, context), Integer.valueOf(i), Integer.valueOf(i2), num, string, access$getImageCellDirection, 48, (Object) null);
            }
        });
        final MessageLogEntry.MessageContainer messageContainer2 = this.$item;
        final UriHandler uriHandler = this.$uriHandler;
        ImageCellRendering.Builder onImageCellClicked = state.onImageCellClicked(new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(String str) {
                Intrinsics.checkNotNullParameter(str, "uri");
                if (messageContainer2.getStatus() == MessageStatus.SENT) {
                    uriHandler.onUriClicked(str, UrlSource.IMAGE);
                }
            }
        });
        final UriHandler uriHandler2 = this.$uriHandler;
        return onImageCellClicked.onActionButtonClicked(new Function2<String, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((String) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(String str, String str2) {
                Intrinsics.checkNotNullParameter(str, "uri");
                Intrinsics.checkNotNullParameter(str2, "source");
                MessageLogCellFactory.INSTANCE.onActionUriClicked(str2, uriHandler2, str);
            }
        }).build();
    }
}
