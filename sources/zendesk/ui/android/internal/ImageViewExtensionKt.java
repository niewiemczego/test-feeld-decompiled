package zendesk.ui.android.internal;

import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u001a\u0018\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\b\b\u0001\u0010\u0003\u001a\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"applyLoopingAnimatedVectorDrawable", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "Landroid/widget/ImageView;", "avdResId", "", "zendesk.ui_ui-android"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewExtension.kt */
public final class ImageViewExtensionKt {
    public static final AnimatedVectorDrawableCompat applyLoopingAnimatedVectorDrawable(ImageView imageView, int i) {
        Intrinsics.checkNotNullParameter(imageView, "<this>");
        AnimatedVectorDrawableCompat create = AnimatedVectorDrawableCompat.create(imageView.getContext(), i);
        if (create != null) {
            create.registerAnimationCallback(new ImageViewExtensionKt$applyLoopingAnimatedVectorDrawable$1(imageView, create));
        }
        imageView.setImageDrawable(create);
        if (create != null) {
            create.start();
        }
        return create;
    }
}
