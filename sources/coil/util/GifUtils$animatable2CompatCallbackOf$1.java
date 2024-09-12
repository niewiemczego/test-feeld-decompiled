package coil.util;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0007"}, d2 = {"coil/util/-GifUtils$animatable2CompatCallbackOf$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "onAnimationStart", "coil-gif_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-GifUtils$animatable2CompatCallbackOf$1  reason: invalid class name */
/* compiled from: Utils.kt */
public final class GifUtils$animatable2CompatCallbackOf$1 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ Function0<Unit> $onEnd;
    final /* synthetic */ Function0<Unit> $onStart;

    GifUtils$animatable2CompatCallbackOf$1(Function0<Unit> function0, Function0<Unit> function02) {
        this.$onStart = function0;
        this.$onEnd = function02;
    }

    public void onAnimationStart(Drawable drawable) {
        Function0<Unit> function0 = this.$onStart;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public void onAnimationEnd(Drawable drawable) {
        Function0<Unit> function0 = this.$onEnd;
        if (function0 != null) {
            function0.invoke();
        }
    }
}
