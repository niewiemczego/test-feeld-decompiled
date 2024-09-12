package expo.modules.image.events;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.react.uimanager.events.TouchesHelper;
import expo.modules.image.ExpoImageViewWrapper;
import expo.modules.image.enums.ImageCacheType;
import expo.modules.image.records.ImageErrorEvent;
import expo.modules.image.records.ImageLoadEvent;
import expo.modules.image.records.ImageSource;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import java.lang.ref.WeakReference;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J2\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\bH\u0016J6\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000f\u001a\u00020\bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/image/events/GlideRequestListener;", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "expoImageViewWrapper", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "(Ljava/lang/ref/WeakReference;)V", "onLoadFailed", "", "e", "Lcom/bumptech/glide/load/engine/GlideException;", "model", "", "target", "Lcom/bumptech/glide/request/target/Target;", "isFirstResource", "onResourceReady", "resource", "dataSource", "Lcom/bumptech/glide/load/DataSource;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideRequestListener.kt */
public final class GlideRequestListener implements RequestListener<Drawable> {
    private final WeakReference<ExpoImageViewWrapper> expoImageViewWrapper;

    public GlideRequestListener(WeakReference<ExpoImageViewWrapper> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "expoImageViewWrapper");
        this.expoImageViewWrapper = weakReference;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, Target<Drawable> target, boolean z) {
        String str;
        ViewEventCallback<ImageErrorEvent> onError$expo_image_release;
        String message;
        Intrinsics.checkNotNullParameter(target, TouchesHelper.TARGET_KEY);
        if (glideException == null || (message = glideException.getMessage()) == null || (str = StringsKt.removeSuffix(message, (CharSequence) "\n call GlideException#logRootCauses(String) for more detail")) == null) {
            str = "Unknown error";
        }
        ExpoImageViewWrapper expoImageViewWrapper2 = (ExpoImageViewWrapper) this.expoImageViewWrapper.get();
        if (!(expoImageViewWrapper2 == null || (onError$expo_image_release = expoImageViewWrapper2.getOnError$expo_image_release()) == null)) {
            onError$expo_image_release.invoke(new ImageErrorEvent(str));
        }
        Log.e("ExpoImage", str);
        if (glideException == null) {
            return false;
        }
        glideException.logRootCauses("ExpoImage");
        return false;
    }

    public boolean onResourceReady(Drawable drawable, Object obj, Target<Drawable> target, DataSource dataSource, boolean z) {
        ViewEventCallback<ImageLoadEvent> onLoad$expo_image_release;
        Intrinsics.checkNotNullParameter(drawable, "resource");
        Intrinsics.checkNotNullParameter(obj, "model");
        Intrinsics.checkNotNullParameter(target, TouchesHelper.TARGET_KEY);
        Intrinsics.checkNotNullParameter(dataSource, "dataSource");
        ExpoImageViewWrapper expoImageViewWrapper2 = (ExpoImageViewWrapper) this.expoImageViewWrapper.get();
        if (expoImageViewWrapper2 == null || (onLoad$expo_image_release = expoImageViewWrapper2.getOnLoad$expo_image_release()) == null) {
            return false;
        }
        String name = ImageCacheType.Companion.fromNativeValue(dataSource).name();
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String lowerCase = name.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        onLoad$expo_image_release.invoke(new ImageLoadEvent(lowerCase, new ImageSource(obj.toString(), drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), (String) null)));
        return false;
    }
}
