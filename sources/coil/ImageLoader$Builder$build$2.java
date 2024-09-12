package coil;

import coil.ImageLoader;
import coil.disk.DiskCache;
import coil.util.SingletonDiskCache;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/disk/DiskCache;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageLoader.kt */
final class ImageLoader$Builder$build$2 extends Lambda implements Function0<DiskCache> {
    final /* synthetic */ ImageLoader.Builder this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageLoader$Builder$build$2(ImageLoader.Builder builder) {
        super(0);
        this.this$0 = builder;
    }

    public final DiskCache invoke() {
        return SingletonDiskCache.INSTANCE.get(this.this$0.applicationContext);
    }
}
