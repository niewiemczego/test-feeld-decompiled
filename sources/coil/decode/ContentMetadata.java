package coil.decode;

import android.net.Uri;
import coil.decode.ImageSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcoil/decode/ContentMetadata;", "Lcoil/decode/ImageSource$Metadata;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "getUri", "()Landroid/net/Uri;", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageSource.kt */
public final class ContentMetadata extends ImageSource.Metadata {
    private final Uri uri;

    public ContentMetadata(Uri uri2) {
        this.uri = uri2;
    }

    public final Uri getUri() {
        return this.uri;
    }
}
