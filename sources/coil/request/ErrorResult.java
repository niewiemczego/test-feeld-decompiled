package coil.request;

import android.graphics.drawable.Drawable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ&\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lcoil/request/ErrorResult;", "Lcoil/request/ImageResult;", "drawable", "Landroid/graphics/drawable/Drawable;", "request", "Lcoil/request/ImageRequest;", "throwable", "", "(Landroid/graphics/drawable/Drawable;Lcoil/request/ImageRequest;Ljava/lang/Throwable;)V", "getDrawable", "()Landroid/graphics/drawable/Drawable;", "getRequest", "()Lcoil/request/ImageRequest;", "getThrowable", "()Ljava/lang/Throwable;", "copy", "equals", "", "other", "", "hashCode", "", "coil-base_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageResult.kt */
public final class ErrorResult extends ImageResult {
    private final Drawable drawable;
    private final ImageRequest request;
    private final Throwable throwable;

    public Drawable getDrawable() {
        return this.drawable;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public final Throwable getThrowable() {
        return this.throwable;
    }

    public ErrorResult(Drawable drawable2, ImageRequest imageRequest, Throwable th) {
        super((DefaultConstructorMarker) null);
        this.drawable = drawable2;
        this.request = imageRequest;
        this.throwable = th;
    }

    public static /* synthetic */ ErrorResult copy$default(ErrorResult errorResult, Drawable drawable2, ImageRequest imageRequest, Throwable th, int i, Object obj) {
        if ((i & 1) != 0) {
            drawable2 = errorResult.getDrawable();
        }
        if ((i & 2) != 0) {
            imageRequest = errorResult.getRequest();
        }
        if ((i & 4) != 0) {
            th = errorResult.throwable;
        }
        return errorResult.copy(drawable2, imageRequest, th);
    }

    public final ErrorResult copy(Drawable drawable2, ImageRequest imageRequest, Throwable th) {
        return new ErrorResult(drawable2, imageRequest, th);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ErrorResult) {
            ErrorResult errorResult = (ErrorResult) obj;
            if (!Intrinsics.areEqual((Object) getDrawable(), (Object) errorResult.getDrawable()) || !Intrinsics.areEqual((Object) getRequest(), (Object) errorResult.getRequest()) || !Intrinsics.areEqual((Object) this.throwable, (Object) errorResult.throwable)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Drawable drawable2 = getDrawable();
        return ((((drawable2 != null ? drawable2.hashCode() : 0) * 31) + getRequest().hashCode()) * 31) + this.throwable.hashCode();
    }
}
