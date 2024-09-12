package coil.size;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0004¨\u0006\u0005"}, d2 = {"SizeResolver", "Lcoil/size/SizeResolver;", "size", "Lcoil/size/Size;", "create", "coil-base_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: SizeResolver.kt */
public final class SizeResolvers {
    public static final SizeResolver create(Size size) {
        return new RealSizeResolver(size);
    }
}
