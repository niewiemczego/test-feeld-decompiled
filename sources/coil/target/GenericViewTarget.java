package coil.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import coil.transition.TransitionTarget;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u00032\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0013\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\bH\u0016J\b\u0010\u0019\u001a\u00020\u0010H\u0004J\u0012\u0010\u001a\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0004R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcoil/target/GenericViewTarget;", "T", "Landroid/view/View;", "Lcoil/target/ViewTarget;", "Lcoil/transition/TransitionTarget;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "()V", "drawable", "Landroid/graphics/drawable/Drawable;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "setDrawable", "(Landroid/graphics/drawable/Drawable;)V", "isStarted", "", "onError", "", "error", "onStart", "placeholder", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStop", "onSuccess", "result", "updateAnimation", "updateDrawable", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GenericViewTarget.kt */
public abstract class GenericViewTarget<T extends View> implements ViewTarget<T>, TransitionTarget, DefaultLifecycleObserver {
    private boolean isStarted;

    public abstract Drawable getDrawable();

    public abstract void setDrawable(Drawable drawable);

    public void onStart(Drawable drawable) {
        updateDrawable(drawable);
    }

    public void onError(Drawable drawable) {
        updateDrawable(drawable);
    }

    public void onSuccess(Drawable drawable) {
        updateDrawable(drawable);
    }

    public void onStart(LifecycleOwner lifecycleOwner) {
        this.isStarted = true;
        updateAnimation();
    }

    public void onStop(LifecycleOwner lifecycleOwner) {
        this.isStarted = false;
        updateAnimation();
    }

    /* access modifiers changed from: protected */
    public final void updateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
        if (animatable != null) {
            animatable.stop();
        }
        setDrawable(drawable);
        updateAnimation();
    }

    /* access modifiers changed from: protected */
    public final void updateAnimation() {
        Drawable drawable = getDrawable();
        Animatable animatable = drawable instanceof Animatable ? (Animatable) drawable : null;
        if (animatable != null) {
            if (this.isStarted) {
                animatable.start();
            } else {
                animatable.stop();
            }
        }
    }
}
