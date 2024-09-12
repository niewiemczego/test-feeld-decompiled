package expo.modules.image.thumbhash;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.signature.ObjectKey;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import expo.modules.image.GlideThumbhashModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\u000f"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashModelLoader;", "Lcom/bumptech/glide/load/model/ModelLoader;", "Lexpo/modules/image/GlideThumbhashModel;", "Landroid/graphics/Bitmap;", "()V", "buildLoadData", "Lcom/bumptech/glide/load/model/ModelLoader$LoadData;", "model", "width", "", "height", "options", "Lcom/bumptech/glide/load/Options;", "handles", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThumbhashModelLoader.kt */
public final class ThumbhashModelLoader implements ModelLoader<GlideThumbhashModel, Bitmap> {
    public boolean handles(GlideThumbhashModel glideThumbhashModel) {
        Intrinsics.checkNotNullParameter(glideThumbhashModel, "model");
        return true;
    }

    public ModelLoader.LoadData<Bitmap> buildLoadData(GlideThumbhashModel glideThumbhashModel, int i, int i2, Options options) {
        GlideThumbhashModel glideThumbhashModel2 = glideThumbhashModel;
        Intrinsics.checkNotNullParameter(glideThumbhashModel2, "model");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        List<String> pathSegments = glideThumbhashModel.getUri().getPathSegments();
        Intrinsics.checkNotNullExpressionValue(pathSegments, "model.uri.pathSegments");
        return new ModelLoader.LoadData<>(new ObjectKey(glideThumbhashModel2), new ThumbhashFetcher(StringsKt.replace$default(CollectionsKt.joinToString$default(pathSegments, "/", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), "\\", "/", false, 4, (Object) null)));
    }
}
