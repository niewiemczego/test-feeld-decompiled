package expo.modules.image;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.okhttp.GlideUrlWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lexpo/modules/image/GlideUrlModel;", "Lexpo/modules/image/GlideModel;", "glideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "(Lcom/bumptech/glide/load/model/GlideUrl;)V", "glideData", "Lexpo/modules/image/okhttp/GlideUrlWrapper;", "getGlideData", "()Lexpo/modules/image/okhttp/GlideUrlWrapper;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideModel.kt */
public final class GlideUrlModel extends GlideModel {
    private final GlideUrlWrapper glideData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlideUrlModel(GlideUrl glideUrl) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(glideUrl, "glideUrl");
        this.glideData = new GlideUrlWrapper(glideUrl);
    }

    public GlideUrlWrapper getGlideData() {
        return this.glideData;
    }
}
