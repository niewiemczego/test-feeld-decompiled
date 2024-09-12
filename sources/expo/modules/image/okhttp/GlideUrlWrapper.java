package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import expo.modules.image.events.OkHttpProgressListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWrapper;", "", "glideUrl", "Lcom/bumptech/glide/load/model/GlideUrl;", "(Lcom/bumptech/glide/load/model/GlideUrl;)V", "getGlideUrl", "()Lcom/bumptech/glide/load/model/GlideUrl;", "progressListener", "Lexpo/modules/image/events/OkHttpProgressListener;", "getProgressListener", "()Lexpo/modules/image/events/OkHttpProgressListener;", "setProgressListener", "(Lexpo/modules/image/events/OkHttpProgressListener;)V", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageOkHttpClientGlideModule.kt */
public final class GlideUrlWrapper {
    private final GlideUrl glideUrl;
    private OkHttpProgressListener progressListener;

    public static /* synthetic */ GlideUrlWrapper copy$default(GlideUrlWrapper glideUrlWrapper, GlideUrl glideUrl2, int i, Object obj) {
        if ((i & 1) != 0) {
            glideUrl2 = glideUrlWrapper.glideUrl;
        }
        return glideUrlWrapper.copy(glideUrl2);
    }

    public final GlideUrl component1() {
        return this.glideUrl;
    }

    public final GlideUrlWrapper copy(GlideUrl glideUrl2) {
        Intrinsics.checkNotNullParameter(glideUrl2, "glideUrl");
        return new GlideUrlWrapper(glideUrl2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof GlideUrlWrapper) && Intrinsics.areEqual((Object) this.glideUrl, (Object) ((GlideUrlWrapper) obj).glideUrl);
    }

    public int hashCode() {
        return this.glideUrl.hashCode();
    }

    public GlideUrlWrapper(GlideUrl glideUrl2) {
        Intrinsics.checkNotNullParameter(glideUrl2, "glideUrl");
        this.glideUrl = glideUrl2;
    }

    public final GlideUrl getGlideUrl() {
        return this.glideUrl;
    }

    public final OkHttpProgressListener getProgressListener() {
        return this.progressListener;
    }

    public final void setProgressListener(OkHttpProgressListener okHttpProgressListener) {
        this.progressListener = okHttpProgressListener;
    }

    public String toString() {
        String glideUrl2 = this.glideUrl.toString();
        Intrinsics.checkNotNullExpressionValue(glideUrl2, "glideUrl.toString()");
        return glideUrl2;
    }
}
