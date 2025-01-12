package expo.modules.image;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/GlideUriModel;", "Lexpo/modules/image/GlideModel;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "glideData", "getGlideData", "()Landroid/net/Uri;", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideModel.kt */
public final class GlideUriModel extends GlideModel {
    private final Uri glideData;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlideUriModel(Uri uri) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri, "uri");
        this.glideData = uri;
    }

    public Uri getGlideData() {
        return this.glideData;
    }
}
