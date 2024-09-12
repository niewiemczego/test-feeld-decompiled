package zendesk.ui.android.internal;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006"}, d2 = {"zendesk/ui/android/internal/ImageViewExtensionKt$applyLoopingAnimatedVectorDrawable$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewExtension.kt */
public final class ImageViewExtensionKt$applyLoopingAnimatedVectorDrawable$1 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ AnimatedVectorDrawableCompat $animated;
    final /* synthetic */ ImageView $this_applyLoopingAnimatedVectorDrawable;

    ImageViewExtensionKt$applyLoopingAnimatedVectorDrawable$1(ImageView imageView, AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.$this_applyLoopingAnimatedVectorDrawable = imageView;
        this.$animated = animatedVectorDrawableCompat;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAnimationEnd$lambda-0  reason: not valid java name */
    public static final void m2809onAnimationEnd$lambda0(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        animatedVectorDrawableCompat.start();
    }

    public void onAnimationEnd(Drawable drawable) {
        this.$this_applyLoopingAnimatedVectorDrawable.post(new ImageViewExtensionKt$applyLoopingAnimatedVectorDrawable$1$$ExternalSyntheticLambda0(this.$animated));
    }
}
