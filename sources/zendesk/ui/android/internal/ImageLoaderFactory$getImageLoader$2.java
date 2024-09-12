package zendesk.ui.android.internal;

import android.content.Context;
import coil.disk.DiskCache;
import java.io.File;
import kotlin.Metadata;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcoil/disk/DiskCache;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageLoaderFactory.kt */
final class ImageLoaderFactory$getImageLoader$2 extends Lambda implements Function0<DiskCache> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ImageLoaderFactory$getImageLoader$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final DiskCache invoke() {
        DiskCache.Builder maxSizeBytes = new DiskCache.Builder().maxSizeBytes(20000000);
        File cacheDir = this.$context.getCacheDir();
        Intrinsics.checkNotNullExpressionValue(cacheDir, "context.cacheDir");
        return maxSizeBytes.directory(FilesKt.resolve(cacheDir, "zendesk_conversationkit_image_cache")).build();
    }
}
