package coil.size;

import android.content.Context;
import android.util.DisplayMetrics;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\u0011\u0010\u000b\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, d2 = {"Lcoil/size/DisplaySizeResolver;", "Lcoil/size/SizeResolver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "equals", "", "other", "", "hashCode", "", "size", "Lcoil/size/Size;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: DisplaySizeResolver.kt */
public final class DisplaySizeResolver implements SizeResolver {
    private final Context context;

    public DisplaySizeResolver(Context context2) {
        this.context = context2;
    }

    public Object size(Continuation<? super Size> continuation) {
        DisplayMetrics displayMetrics = this.context.getResources().getDisplayMetrics();
        Dimension Dimension = Dimensions.Dimension(Math.max(displayMetrics.widthPixels, displayMetrics.heightPixels));
        return new Size(Dimension, Dimension);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DisplaySizeResolver) && Intrinsics.areEqual((Object) this.context, (Object) ((DisplaySizeResolver) obj).context);
    }

    public int hashCode() {
        return this.context.hashCode();
    }
}
