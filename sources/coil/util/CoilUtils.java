package coil.util;

import android.content.Context;
import android.view.View;
import coil.request.ImageResult;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import okhttp3.Cache;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nH\u0007¨\u0006\r"}, d2 = {"Lcoil/util/CoilUtils;", "", "()V", "createDefaultCache", "Lokhttp3/Cache;", "context", "Landroid/content/Context;", "dispose", "", "view", "Landroid/view/View;", "result", "Lcoil/request/ImageResult;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CoilUtils.kt */
public final class CoilUtils {
    public static final CoilUtils INSTANCE = new CoilUtils();

    private CoilUtils() {
    }

    @JvmStatic
    public static final void dispose(View view) {
        Utils.getRequestManager(view).dispose();
    }

    @JvmStatic
    public static final ImageResult result(View view) {
        return Utils.getRequestManager(view).getResult();
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.ERROR, message = "ImageLoaders no longer (and should not) use OkHttp's disk cache. Use 'ImageLoader.Builder.diskCache' to configure a custom disk cache.")
    public static final Cache createDefaultCache(Context context) {
        Utils.unsupported();
        throw new KotlinNothingValueException();
    }
}
