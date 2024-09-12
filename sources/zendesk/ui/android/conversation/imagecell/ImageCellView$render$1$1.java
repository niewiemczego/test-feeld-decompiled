package zendesk.ui.android.conversation.imagecell;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import zendesk.ui.android.conversation.textcell.TextCellRendering;
import zendesk.ui.android.conversation.textcell.TextCellState;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lzendesk/ui/android/conversation/textcell/TextCellRendering;", "textCellRendering", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellView.kt */
final class ImageCellView$render$1$1 extends Lambda implements Function1<TextCellRendering, TextCellRendering> {
    final /* synthetic */ ImageCellState $this_with;
    final /* synthetic */ ImageCellView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCellView$render$1$1(ImageCellView imageCellView, ImageCellState imageCellState) {
        super(1);
        this.this$0 = imageCellView;
        this.$this_with = imageCellState;
    }

    public final TextCellRendering invoke(TextCellRendering textCellRendering) {
        Intrinsics.checkNotNullParameter(textCellRendering, "textCellRendering");
        TextCellRendering.Builder builder = textCellRendering.toBuilder();
        final ImageCellState imageCellState = this.$this_with;
        final ImageCellView imageCellView = this.this$0;
        return builder.state(new Function1<TextCellState, TextCellState>() {
            public final TextCellState invoke(TextCellState textCellState) {
                Intrinsics.checkNotNullParameter(textCellState, "state");
                String messageText$zendesk_ui_ui_android = imageCellState.getMessageText$zendesk_ui_ui_android();
                if (messageText$zendesk_ui_ui_android == null) {
                    messageText$zendesk_ui_ui_android = "";
                }
                String str = messageText$zendesk_ui_ui_android;
                Integer textColor$zendesk_ui_ui_android = imageCellState.getTextColor$zendesk_ui_ui_android();
                Integer backgroundColor$zendesk_ui_ui_android = imageCellState.getBackgroundColor$zendesk_ui_ui_android();
                int access$getTextCellViewBackgroundResource = imageCellView.getTextCellViewBackgroundResource();
                return textCellState.copy(str, imageCellView.rendering.getState$zendesk_ui_ui_android().getActions$zendesk_ui_ui_android(), textColor$zendesk_ui_ui_android, backgroundColor$zendesk_ui_ui_android, Integer.valueOf(access$getTextCellViewBackgroundResource), imageCellView.rendering.getState$zendesk_ui_ui_android().getActionColor$zendesk_ui_ui_android());
            }
        }).onActionButtonClicked(this.this$0.rendering.getOnActionButtonClicked$zendesk_ui_ui_android()).build();
    }
}
