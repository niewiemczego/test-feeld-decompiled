package coil.request;

import android.graphics.drawable.Drawable;
import coil.target.Target;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"coil/request/ImageRequest$Builder$target$4", "Lcoil/target/Target;", "onError", "", "error", "Landroid/graphics/drawable/Drawable;", "onStart", "placeholder", "onSuccess", "result", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 176)
/* compiled from: ImageRequest.kt */
public final class ImageRequest$Builder$target$4 implements Target {
    final /* synthetic */ Function1<Drawable, Unit> $onError;
    final /* synthetic */ Function1<Drawable, Unit> $onStart;
    final /* synthetic */ Function1<Drawable, Unit> $onSuccess;

    public ImageRequest$Builder$target$4(Function1<? super Drawable, Unit> function1, Function1<? super Drawable, Unit> function12, Function1<? super Drawable, Unit> function13) {
        this.$onStart = function1;
        this.$onError = function12;
        this.$onSuccess = function13;
    }

    public void onStart(Drawable drawable) {
        this.$onStart.invoke(drawable);
    }

    public void onError(Drawable drawable) {
        this.$onError.invoke(drawable);
    }

    public void onSuccess(Drawable drawable) {
        this.$onSuccess.invoke(drawable);
    }
}
