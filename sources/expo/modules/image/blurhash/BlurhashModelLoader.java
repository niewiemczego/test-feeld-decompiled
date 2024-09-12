package expo.modules.image.blurhash;

import android.graphics.Bitmap;
import android.net.Uri;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.image.GlideBlurhashModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J?\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u0002H\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u0002H\u000e0\u0014H\u0002¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u0019"}, d2 = {"Lexpo/modules/image/blurhash/BlurhashModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/GlideBlurhashModel;", "Landroid/graphics/Bitmap;", "()V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "getPath", "T", "uri", "Landroid/net/Uri;", "index", "default", "converter", "Lkotlin/Function1;", "", "(Landroid/net/Uri;ILjava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BlurhashModelLoader.kt */
public final class BlurhashModelLoader implements ModelLoader<GlideBlurhashModel, Bitmap> {
    public boolean handles(GlideBlurhashModel glideBlurhashModel) {
        Intrinsics.checkNotNullParameter(glideBlurhashModel, "model");
        return true;
    }

    public ModelLoader.LoadData<Bitmap> buildLoadData(GlideBlurhashModel glideBlurhashModel, int i, int i2, Options options) {
        Intrinsics.checkNotNullParameter(glideBlurhashModel, "model");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new ModelLoader.LoadData<>(new ObjectKey(glideBlurhashModel), new BlurHashFetcher((String) getPath(glideBlurhashModel.getUri(), 0, (Object) null, BlurhashModelLoader$buildLoadData$blurhash$1.INSTANCE), glideBlurhashModel.getWidth(), glideBlurhashModel.getHeight(), 1.0f));
    }

    private final <T> T getPath(Uri uri, int i, T t, Function1<? super String, ? extends T> function1) {
        List<String> pathSegments = uri.getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "uri.pathSegments");
        String str = (String) CollectionsKt.getOrNull(pathSegments, i);
        if (str == null) {
            return t;
        }
        return function1.invoke(str);
    }
}
