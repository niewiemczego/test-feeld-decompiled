package coil.request;

import android.graphics.drawable.Drawable;
import coil.decode.DataSource;
import coil.memory.MemoryCache;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\r¢\u0006\u0002\u0010\u000fJP\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rJ\u0013\u0010\u001c\u001a\u00020\r2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006!"}, d2 = {"Lcoil/request/SuccessResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "dataSource", "Lcoil/decode/DataSource;", "memoryCacheKey", "Lcoil/memory/MemoryCache$Key;", "diskCacheKey", "", "isSampled", "", "isPlaceholderCached", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Lcoil/decode/DataSource;Lcoil/memory/MemoryCache$Key;Ljava/lang/String;ZZ)V", "getDataSource", "()Lcoil/decode/DataSource;", "getDiskCacheKey", "()Ljava/lang/String;", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "()Z", "getMemoryCacheKey", "()Lcoil/memory/MemoryCache$Key;", "getRequest", "()Lcoil/request/ImageRequest;", "copy", "equals", "other", "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageResult.kt */
public final class SuccessResult extends ImageResult {
    private final DataSource dataSource;
    private final String diskCacheKey;
    private final Drawable drawable;
    private final boolean isPlaceholderCached;
    private final boolean isSampled;
    private final MemoryCache.Key memoryCacheKey;
    private final ImageRequest request;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SuccessResult(Drawable drawable2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(drawable2, imageRequest, dataSource2, (i & 8) != 0 ? null : key, (i & 16) != 0 ? null : str, (i & 32) != 0 ? false : z, (i & 64) != 0 ? false : z2);
    }

    public Drawable getDrawable() {
        return this.drawable;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public final DataSource getDataSource() {
        return this.dataSource;
    }

    public final MemoryCache.Key getMemoryCacheKey() {
        return this.memoryCacheKey;
    }

    public final String getDiskCacheKey() {
        return this.diskCacheKey;
    }

    public final boolean isSampled() {
        return this.isSampled;
    }

    public final boolean isPlaceholderCached() {
        return this.isPlaceholderCached;
    }

    public SuccessResult(Drawable drawable2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2) {
        super((DefaultConstructorMarker) null);
        this.drawable = drawable2;
        this.request = imageRequest;
        this.dataSource = dataSource2;
        this.memoryCacheKey = key;
        this.diskCacheKey = str;
        this.isSampled = z;
        this.isPlaceholderCached = z2;
    }

    public static /* synthetic */ SuccessResult copy$default(SuccessResult successResult, Drawable drawable2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable2 = successResult.getDrawable();
        }
        if ((i & 2) != 0) {
            imageRequest = successResult.getRequest();
        }
        ImageRequest imageRequest2 = imageRequest;
        if ((i & 4) != 0) {
            dataSource2 = successResult.dataSource;
        }
        DataSource dataSource3 = dataSource2;
        if ((i & 8) != 0) {
            key = successResult.memoryCacheKey;
        }
        MemoryCache.Key key2 = key;
        if ((i & 16) != 0) {
            str = successResult.diskCacheKey;
        }
        String str2 = str;
        if ((i & 32) != 0) {
            z = successResult.isSampled;
        }
        boolean z3 = z;
        if ((i & 64) != 0) {
            z2 = successResult.isPlaceholderCached;
        }
        return successResult.copy(drawable2, imageRequest2, dataSource3, key2, str2, z3, z2);
    }

    public final SuccessResult copy(Drawable drawable2, ImageRequest imageRequest, DataSource dataSource2, MemoryCache.Key key, String str, boolean z, boolean z2) {
        return new SuccessResult(drawable2, imageRequest, dataSource2, key, str, z, z2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SuccessResult) {
            SuccessResult successResult = (SuccessResult) obj;
            if (!Intrinsics.areEqual((Object) getDrawable(), (Object) successResult.getDrawable()) || !Intrinsics.areEqual((Object) getRequest(), (Object) successResult.getRequest()) || this.dataSource != successResult.dataSource || !Intrinsics.areEqual((Object) this.memoryCacheKey, (Object) successResult.memoryCacheKey) || !Intrinsics.areEqual((Object) this.diskCacheKey, (Object) successResult.diskCacheKey) || this.isSampled != successResult.isSampled || this.isPlaceholderCached != successResult.isPlaceholderCached) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        int hashCode = ((((getDrawable().hashCode() * 31) + getRequest().hashCode()) * 31) + this.dataSource.hashCode()) * 31;
        MemoryCache.Key key = this.memoryCacheKey;
        int i = 0;
        int hashCode2 = (hashCode + (key != null ? key.hashCode() : 0)) * 31;
        String str = this.diskCacheKey;
        if (str != null) {
            i = str.hashCode();
        }
        return ((((hashCode2 + i) * 31) + Boolean.hashCode(this.isSampled)) * 31) + Boolean.hashCode(this.isPlaceholderCached);
    }
}
