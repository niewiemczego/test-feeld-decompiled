package zendesk.ui.android.conversation.imagecell;

import android.graphics.drawable.Drawable;
import coil.request.ErrorResult;
import coil.request.ImageRequest;
import coil.request.SuccessResult;
import com.google.android.material.shape.MaterialShapeDrawable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, d2 = {"coil/request/ImageRequest$Builder$listener$5", "Lcoil/request/ImageRequest$Listener;", "onCancel", "", "request", "Lcoil/request/ImageRequest;", "onError", "result", "Lcoil/request/ErrorResult;", "onStart", "onSuccess", "Lcoil/request/SuccessResult;", "coil-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* renamed from: zendesk.ui.android.conversation.imagecell.ImageCellView$render$lambda-5$$inlined$listener$1  reason: invalid class name */
/* compiled from: ImageRequest.kt */
public final class ImageCellView$render$lambda5$$inlined$listener$1 implements ImageRequest.Listener {
    final /* synthetic */ MaterialShapeDrawable $backgroundDrawable$inlined;
    final /* synthetic */ ImageCellView this$0;

    public ImageCellView$render$lambda5$$inlined$listener$1(ImageCellView imageCellView, MaterialShapeDrawable materialShapeDrawable, ImageCellView imageCellView2, ImageCellView imageCellView3, ImageCellView imageCellView4) {
        this.this$0 = imageCellView;
        this.$backgroundDrawable$inlined = materialShapeDrawable;
    }

    public void onStart(ImageRequest imageRequest) {
        this.this$0.imageView.setBackground(this.$backgroundDrawable$inlined);
        this.this$0.errorTextView.setVisibility(8);
    }

    public void onSuccess(ImageRequest imageRequest, SuccessResult successResult) {
        this.this$0.imageView.setBackground((Drawable) null);
        this.this$0.errorTextView.setVisibility(8);
    }

    public void onError(ImageRequest imageRequest, ErrorResult errorResult) {
        this.this$0.errorTextView.setVisibility(0);
    }

    public void onCancel(ImageRequest imageRequest) {
        this.this$0.errorTextView.setVisibility(0);
    }
}
