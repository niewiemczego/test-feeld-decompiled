package expo.modules.image;

import android.net.Uri;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0005H\u0016R\u0014\u0010\b\u001a\u00020\u0000X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u0015"}, d2 = {"Lexpo/modules/image/GlideBlurhashModel;", "Lexpo/modules/image/GlideModel;", "uri", "Landroid/net/Uri;", "width", "", "height", "(Landroid/net/Uri;II)V", "glideData", "getGlideData", "()Lexpo/modules/image/GlideBlurhashModel;", "getHeight", "()I", "getUri", "()Landroid/net/Uri;", "getWidth", "equals", "", "other", "", "hashCode", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: GlideModel.kt */
public final class GlideBlurhashModel extends GlideModel {
    private final GlideBlurhashModel glideData = this;
    private final int height;
    private final Uri uri;
    private final int width;

    public final Uri getUri() {
        return this.uri;
    }

    public final int getWidth() {
        return this.width;
    }

    public final int getHeight() {
        return this.height;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlideBlurhashModel(Uri uri2, int i, int i2) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(uri2, "uri");
        this.uri = uri2;
        this.width = i;
        this.height = i2;
    }

    public GlideBlurhashModel getGlideData() {
        return this.glideData;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GlideBlurhashModel) {
            GlideBlurhashModel glideBlurhashModel = (GlideBlurhashModel) obj;
            return Intrinsics.areEqual((Object) this.uri, (Object) glideBlurhashModel.uri) && this.width == glideBlurhashModel.width && this.height == glideBlurhashModel.height;
        }
    }

    public int hashCode() {
        return (((this.uri.hashCode() * 31) + this.width) * 31) + this.height;
    }
}
