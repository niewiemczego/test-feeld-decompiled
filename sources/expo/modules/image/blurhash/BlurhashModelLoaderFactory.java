package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.MultiModelLoaderFactory;
import expo.modules.image.GlideBlurhashModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModelLoaderFactory;", "Lcom/bumptech/glide/load/model/ModelLoaderFactory;", "Lexpo/modules/image/GlideBlurhashModel;", "Landroid/graphics/Bitmap;", "()V", "build", "Lcom/bumptech/glide/load/model/ModelLoader;", "multiFactory", "Lcom/bumptech/glide/load/model/MultiModelLoaderFactory;", "teardown", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlurhashModelLoaderFactory.kt */
public final class BlurhashModelLoaderFactory implements ModelLoaderFactory<GlideBlurhashModel, Bitmap> {
    public void teardown() {
    }

    public ModelLoader<GlideBlurhashModel, Bitmap> build(MultiModelLoaderFactory multiModelLoaderFactory) {
        Intrinsics.checkNotNullParameter(multiModelLoaderFactory, "multiFactory");
        return new BlurhashModelLoader();
    }
}
