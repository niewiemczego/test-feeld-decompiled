package zendesk.ui.android.conversation.imagecell;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellView.kt */
final class ImageCellView$render$1$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ ImageCellState $this_with;
    final /* synthetic */ ImageCellView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageCellView$render$1$2(ImageCellState imageCellState, ImageCellView imageCellView) {
        super(0);
        this.$this_with = imageCellState;
        this.this$0 = imageCellView;
    }

    public final void invoke() {
        Function1<String, Unit> onImageCellClicked$zendesk_ui_ui_android;
        Uri localUri$zendesk_ui_ui_android = this.$this_with.getLocalUri$zendesk_ui_ui_android();
        if (localUri$zendesk_ui_ui_android == null) {
            localUri$zendesk_ui_ui_android = this.$this_with.getUri$zendesk_ui_ui_android();
        }
        if (localUri$zendesk_ui_ui_android != null && (onImageCellClicked$zendesk_ui_ui_android = this.this$0.rendering.getOnImageCellClicked$zendesk_ui_ui_android()) != null) {
            onImageCellClicked$zendesk_ui_ui_android.invoke(String.valueOf(this.$this_with.getUri$zendesk_ui_ui_android()));
        }
    }
}
