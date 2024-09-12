package coil.request;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import coil.ImageLoader;
import coil.size.Dimension;
import coil.size.Scale;
import coil.size.Size;
import coil.target.Target;
import coil.target.ViewTarget;
import coil.util.Bitmaps;
import coil.util.HardwareBitmapService;
import coil.util.HardwareBitmaps;
import coil.util.Logger;
import coil.util.Requests;
import coil.util.SystemCallbacks;
import coil.util.Utils;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u0010\u0018\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u001f\u001a\u00020 R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcoil/request/RequestService;", "", "imageLoader", "Lcoil/ImageLoader;", "systemCallbacks", "Lcoil/util/SystemCallbacks;", "logger", "Lcoil/util/Logger;", "(Lcoil/ImageLoader;Lcoil/util/SystemCallbacks;Lcoil/util/Logger;)V", "hardwareBitmapService", "Lcoil/util/HardwareBitmapService;", "allowHardwareWorkerThread", "", "options", "Lcoil/request/Options;", "errorResult", "Lcoil/request/ErrorResult;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "isConfigValidForHardware", "requestedConfig", "Landroid/graphics/Bitmap$Config;", "isConfigValidForHardwareAllocation", "size", "Lcoil/size/Size;", "isConfigValidForTransformations", "requestDelegate", "Lcoil/request/RequestDelegate;", "initialRequest", "job", "Lkotlinx/coroutines/Job;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RequestService.kt */
public final class RequestService {
    private final HardwareBitmapService hardwareBitmapService;
    private final ImageLoader imageLoader;
    private final SystemCallbacks systemCallbacks;

    public RequestService(ImageLoader imageLoader2, SystemCallbacks systemCallbacks2, Logger logger) {
        this.imageLoader = imageLoader2;
        this.systemCallbacks = systemCallbacks2;
        this.hardwareBitmapService = HardwareBitmaps.HardwareBitmapService(logger);
    }

    public final RequestDelegate requestDelegate(ImageRequest imageRequest, Job job) {
        Lifecycle lifecycle = imageRequest.getLifecycle();
        Target target = imageRequest.getTarget();
        if (!(target instanceof ViewTarget)) {
            return new BaseRequestDelegate(lifecycle, job);
        }
        return new ViewTargetRequestDelegate(this.imageLoader, imageRequest, (ViewTarget) target, lifecycle, job);
    }

    public final ErrorResult errorResult(ImageRequest imageRequest, Throwable th) {
        Drawable drawable;
        if (th instanceof NullRequestDataException) {
            drawable = imageRequest.getFallback();
            if (drawable == null) {
                drawable = imageRequest.getError();
            }
        } else {
            drawable = imageRequest.getError();
        }
        return new ErrorResult(drawable, imageRequest, th);
    }

    public final Options options(ImageRequest imageRequest, Size size) {
        CachePolicy cachePolicy;
        Scale scale;
        Bitmap.Config bitmapConfig = isConfigValidForTransformations(imageRequest) && isConfigValidForHardwareAllocation(imageRequest, size) ? imageRequest.getBitmapConfig() : Bitmap.Config.ARGB_8888;
        if (this.systemCallbacks.isOnline()) {
            cachePolicy = imageRequest.getNetworkCachePolicy();
        } else {
            cachePolicy = CachePolicy.DISABLED;
        }
        CachePolicy cachePolicy2 = cachePolicy;
        boolean z = imageRequest.getAllowRgb565() && imageRequest.getTransformations().isEmpty() && bitmapConfig != Bitmap.Config.ALPHA_8;
        if (Intrinsics.areEqual((Object) size.getWidth(), (Object) Dimension.Undefined.INSTANCE) || Intrinsics.areEqual((Object) size.getHeight(), (Object) Dimension.Undefined.INSTANCE)) {
            scale = Scale.FIT;
        } else {
            scale = imageRequest.getScale();
        }
        return new Options(imageRequest.getContext(), bitmapConfig, imageRequest.getColorSpace(), size, scale, Requests.getAllowInexactSize(imageRequest), z, imageRequest.getPremultipliedAlpha(), imageRequest.getDiskCacheKey(), imageRequest.getHeaders(), imageRequest.getTags(), imageRequest.getParameters(), imageRequest.getMemoryCachePolicy(), imageRequest.getDiskCachePolicy(), cachePolicy2);
    }

    public final boolean isConfigValidForHardware(ImageRequest imageRequest, Bitmap.Config config) {
        if (!Bitmaps.isHardware(config)) {
            return true;
        }
        if (!imageRequest.getAllowHardware()) {
            return false;
        }
        Target target = imageRequest.getTarget();
        if (target instanceof ViewTarget) {
            View view = ((ViewTarget) target).getView();
            if (view.isAttachedToWindow() && !view.isHardwareAccelerated()) {
                return false;
            }
        }
        return true;
    }

    public final boolean allowHardwareWorkerThread(Options options) {
        return !Bitmaps.isHardware(options.getConfig()) || this.hardwareBitmapService.allowHardwareWorkerThread();
    }

    private final boolean isConfigValidForHardwareAllocation(ImageRequest imageRequest, Size size) {
        return isConfigValidForHardware(imageRequest, imageRequest.getBitmapConfig()) && this.hardwareBitmapService.allowHardwareMainThread(size);
    }

    private final boolean isConfigValidForTransformations(ImageRequest imageRequest) {
        return imageRequest.getTransformations().isEmpty() || ArraysKt.contains((T[]) Utils.getVALID_TRANSFORMATION_CONFIGS(), imageRequest.getBitmapConfig());
    }
}
