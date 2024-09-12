package coil.util;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import coil.request.CachePolicy;
import coil.request.DefaultRequestOptions;
import coil.request.ImageRequest;
import coil.size.DisplaySizeResolver;
import coil.size.Precision;
import coil.size.ViewSizeResolver;
import coil.target.ViewTarget;
import coil.transition.Transition;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u001a3\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\n\b\u0001\u0010\f\u001a\u0004\u0018\u00010\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\u000f\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"DEFAULT_REQUEST_OPTIONS", "Lcoil/request/DefaultRequestOptions;", "getDEFAULT_REQUEST_OPTIONS", "()Lcoil/request/DefaultRequestOptions;", "allowInexactSize", "", "Lcoil/request/ImageRequest;", "getAllowInexactSize", "(Lcoil/request/ImageRequest;)Z", "getDrawableCompat", "Landroid/graphics/drawable/Drawable;", "drawable", "resId", "", "default", "(Lcoil/request/ImageRequest;Landroid/graphics/drawable/Drawable;Ljava/lang/Integer;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* renamed from: coil.util.-Requests  reason: invalid class name */
/* compiled from: Requests.kt */
public final class Requests {
    private static final DefaultRequestOptions DEFAULT_REQUEST_OPTIONS = new DefaultRequestOptions((CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (CoroutineDispatcher) null, (Transition.Factory) null, (Precision) null, (Bitmap.Config) null, false, false, (Drawable) null, (Drawable) null, (Drawable) null, (CachePolicy) null, (CachePolicy) null, (CachePolicy) null, 32767, (DefaultConstructorMarker) null);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* renamed from: coil.util.-Requests$WhenMappings */
    /* compiled from: Requests.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Precision.values().length];
            iArr[Precision.EXACT.ordinal()] = 1;
            iArr[Precision.INEXACT.ordinal()] = 2;
            iArr[Precision.AUTOMATIC.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final DefaultRequestOptions getDEFAULT_REQUEST_OPTIONS() {
        return DEFAULT_REQUEST_OPTIONS;
    }

    public static final Drawable getDrawableCompat(ImageRequest imageRequest, Drawable drawable, Integer num, Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return Contexts.getDrawableCompat(imageRequest.getContext(), num.intValue());
    }

    public static final boolean getAllowInexactSize(ImageRequest imageRequest) {
        int i = WhenMappings.$EnumSwitchMapping$0[imageRequest.getPrecision().ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            if (i != 3) {
                throw new NoWhenBranchMatchedException();
            } else if ((imageRequest.getDefined().getSizeResolver() != null || !(imageRequest.getSizeResolver() instanceof DisplaySizeResolver)) && (!(imageRequest.getTarget() instanceof ViewTarget) || !(imageRequest.getSizeResolver() instanceof ViewSizeResolver) || !(((ViewTarget) imageRequest.getTarget()).getView() instanceof ImageView) || ((ViewTarget) imageRequest.getTarget()).getView() != ((ViewSizeResolver) imageRequest.getSizeResolver()).getView())) {
                return false;
            }
        }
        return true;
    }
}
