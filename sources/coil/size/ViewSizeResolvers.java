package coil.size;

import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"ViewSizeResolver", "Lcoil/size/ViewSizeResolver;", "T", "Landroid/view/View;", "view", "subtractPadding", "", "create", "(Landroid/view/View;Z)Lcoil/size/ViewSizeResolver;", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewSizeResolver.kt */
public final class ViewSizeResolvers {
    public static final <T extends View> ViewSizeResolver<T> create(T t) {
        return create$default(t, false, 2, (Object) null);
    }

    public static /* synthetic */ ViewSizeResolver create$default(View view, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return create(view, z);
    }

    public static final <T extends View> ViewSizeResolver<T> create(T t, boolean z) {
        return new RealViewSizeResolver<>(t, z);
    }
}
