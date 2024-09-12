package expo.modules.image.okhttp;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010\u000e\u001a\u00020\u0003H\u0002J\b\u0010\u000f\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\tH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/image/okhttp/GlideUrlWithCustomCacheKey;", "Lcom/bumptech/glide/load/model/GlideUrl;", "uri", "", "headers", "Lcom/bumptech/glide/load/model/Headers;", "cacheKey", "(Ljava/lang/String;Lcom/bumptech/glide/load/model/Headers;Ljava/lang/String;)V", "hashCode", "", "equals", "", "other", "", "getBaseCacheKey", "getCacheKey", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoImageOkHttpClientGlideModule.kt */
public final class GlideUrlWithCustomCacheKey extends GlideUrl {
    private final String cacheKey;
    private int hashCode;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GlideUrlWithCustomCacheKey(String str, Headers headers, String str2) {
        super(str, headers);
        Intrinsics.checkNotNullParameter(str2, "cacheKey");
        this.cacheKey = str2;
    }

    private final String getBaseCacheKey() {
        String cacheKey2 = super.getCacheKey();
        Intrinsics.checkNotNullExpressionValue(cacheKey2, "super.getCacheKey()");
        return cacheKey2;
    }

    public String getCacheKey() {
        return this.cacheKey;
    }

    public boolean equals(Object obj) {
        if (obj instanceof GlideUrlWithCustomCacheKey) {
            GlideUrlWithCustomCacheKey glideUrlWithCustomCacheKey = (GlideUrlWithCustomCacheKey) obj;
            if (!Intrinsics.areEqual((Object) getBaseCacheKey(), (Object) glideUrlWithCustomCacheKey.getBaseCacheKey()) || !getHeaders().equals(glideUrlWithCustomCacheKey.getHeaders())) {
                return false;
            }
            return true;
        } else if (!(obj instanceof GlideUrl)) {
            return false;
        } else {
            GlideUrl glideUrl = (GlideUrl) obj;
            if (!Intrinsics.areEqual((Object) getBaseCacheKey(), (Object) glideUrl.getCacheKey()) || !getHeaders().equals(glideUrl.getHeaders())) {
                return false;
            }
            return true;
        }
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            int hashCode2 = getBaseCacheKey().hashCode();
            this.hashCode = hashCode2;
            this.hashCode = (hashCode2 * 31) + getHeaders().hashCode();
        }
        return this.hashCode;
    }
}
