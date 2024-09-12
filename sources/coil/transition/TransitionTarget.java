package coil.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import coil.target.Target;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcoil/transition/TransitionTarget;", "Lcoil/target/Target;", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: TransitionTarget.kt */
public interface TransitionTarget extends Target {
    Drawable getDrawable();

    View getView();

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: TransitionTarget.kt */
    public static final class DefaultImpls {
        public static void onError(TransitionTarget transitionTarget, Drawable drawable) {
            Target.DefaultImpls.onError(transitionTarget, drawable);
        }

        public static void onStart(TransitionTarget transitionTarget, Drawable drawable) {
            Target.DefaultImpls.onStart(transitionTarget, drawable);
        }

        public static void onSuccess(TransitionTarget transitionTarget, Drawable drawable) {
            Target.DefaultImpls.onSuccess(transitionTarget, drawable);
        }
    }
}
