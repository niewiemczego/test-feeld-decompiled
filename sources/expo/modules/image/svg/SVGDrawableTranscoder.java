package expo.modules.image.svg;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.PictureDrawable;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.SimpleResource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.caverock.androidsvg.SVG;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J&\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u00062\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"Lexpo/modules/image/svg/SVGDrawableTranscoder;", "Lcom/bumptech/glide/load/resource/transcode/ResourceTranscoder;", "Lcom/caverock/androidsvg/SVG;", "Landroid/graphics/drawable/Drawable;", "()V", "transcode", "Lcom/bumptech/glide/load/engine/Resource;", "toTranscode", "options", "Lcom/bumptech/glide/load/Options;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: SVGDrawableTranscoder.kt */
public final class SVGDrawableTranscoder implements ResourceTranscoder<SVG, Drawable> {
    public Resource<Drawable> transcode(Resource<SVG> resource, Options options) {
        Intrinsics.checkNotNullParameter(resource, "toTranscode");
        Intrinsics.checkNotNullParameter(options, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return new SimpleResource<>(new PictureDrawable(resource.get().renderToPicture()));
    }
}
