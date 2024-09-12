package expo.modules.image;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
import expo.modules.image.enums.ContentFit;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%J\n\u0010&\u001a\u0004\u0018\u00010\u0016H\u0016J\u0010\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020#H\u0016J\u0012\u0010+\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010\u0002H\u0016J\u0012\u0010/\u001a\u00020#2\b\u0010,\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u00100\u001a\u00020#2\u0006\u00101\u001a\u00020\u00022\u0010\u00102\u001a\f\u0012\u0006\b\u0000\u0012\u00020\u0002\u0018\u000103H\u0016J\b\u00104\u001a\u00020#H\u0016J\b\u00105\u001a\u00020#H\u0016J\u0010\u00106\u001a\u00020#2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u00107\u001a\u00020#2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001aX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001c\"\u0004\b!\u0010\u001e¨\u00068"}, d2 = {"Lexpo/modules/image/ImageViewWrapperTarget;", "Lcom/bumptech/glide/request/target/Target;", "Landroid/graphics/drawable/Drawable;", "imageViewHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "(Ljava/lang/ref/WeakReference;)V", "hasSource", "", "getHasSource", "()Z", "setHasSource", "(Z)V", "isUsed", "setUsed", "placeholderContentFit", "Lexpo/modules/image/enums/ContentFit;", "getPlaceholderContentFit", "()Lexpo/modules/image/enums/ContentFit;", "setPlaceholderContentFit", "(Lexpo/modules/image/enums/ContentFit;)V", "request", "Lcom/bumptech/glide/request/Request;", "sizeDeterminer", "Lexpo/modules/image/SizeDeterminer;", "sourceHeight", "", "getSourceHeight", "()I", "setSourceHeight", "(I)V", "sourceWidth", "getSourceWidth", "setSourceWidth", "clear", "", "requestManager", "Lcom/bumptech/glide/RequestManager;", "getRequest", "getSize", "cb", "Lcom/bumptech/glide/request/target/SizeReadyCallback;", "onDestroy", "onLoadCleared", "placeholder", "onLoadFailed", "errorDrawable", "onLoadStarted", "onResourceReady", "resource", "transition", "Lcom/bumptech/glide/request/transition/Transition;", "onStart", "onStop", "removeCallback", "setRequest", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ImageViewWrapperTarget.kt */
public final class ImageViewWrapperTarget implements Target<Drawable> {
    private boolean hasSource;
    private final WeakReference<ExpoImageViewWrapper> imageViewHolder;
    private boolean isUsed;
    private ContentFit placeholderContentFit;
    private Request request;
    private SizeDeterminer sizeDeterminer;
    private int sourceHeight = -1;
    private int sourceWidth = -1;

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public ImageViewWrapperTarget(WeakReference<ExpoImageViewWrapper> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "imageViewHolder");
        this.imageViewHolder = weakReference;
        this.sizeDeterminer = new SizeDeterminer(weakReference);
    }

    public final boolean getHasSource() {
        return this.hasSource;
    }

    public final void setHasSource(boolean z) {
        this.hasSource = z;
    }

    public final boolean isUsed() {
        return this.isUsed;
    }

    public final void setUsed(boolean z) {
        this.isUsed = z;
    }

    public final int getSourceHeight() {
        return this.sourceHeight;
    }

    public final void setSourceHeight(int i) {
        this.sourceHeight = i;
    }

    public final int getSourceWidth() {
        return this.sourceWidth;
    }

    public final void setSourceWidth(int i) {
        this.sourceWidth = i;
    }

    public final ContentFit getPlaceholderContentFit() {
        return this.placeholderContentFit;
    }

    public final void setPlaceholderContentFit(ContentFit contentFit) {
        this.placeholderContentFit = contentFit;
    }

    public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
        Request privateFullRequest;
        Intrinsics.checkNotNullParameter(drawable, "resource");
        Object obj = this.imageViewHolder.get();
        if (obj == null) {
            Log.w("ExpoImage", "The `ExpoImageViewWrapper` was deallocated, but the target wasn't canceled in time.");
            return;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "imageViewHolder.get().if…ime.\")\n      return\n    }");
        ExpoImageViewWrapper expoImageViewWrapper = (ExpoImageViewWrapper) obj;
        Request request2 = this.request;
        boolean z = false;
        if (request2 instanceof ThumbnailRequestCoordinator) {
            ThumbnailRequestCoordinator thumbnailRequestCoordinator = request2 instanceof ThumbnailRequestCoordinator ? (ThumbnailRequestCoordinator) request2 : null;
            if (!(thumbnailRequestCoordinator == null || (privateFullRequest = ThumbnailRequestCoordinatorExtensionKt.getPrivateFullRequest(thumbnailRequestCoordinator)) == null || privateFullRequest.isComplete())) {
                z = true;
            }
        }
        expoImageViewWrapper.onResourceReady(this, drawable, z);
    }

    public void getSize(SizeReadyCallback sizeReadyCallback) {
        Intrinsics.checkNotNullParameter(sizeReadyCallback, "cb");
        if (this.imageViewHolder.get() == null) {
            sizeReadyCallback.onSizeReady(Integer.MIN_VALUE, Integer.MIN_VALUE);
        } else {
            this.sizeDeterminer.getSize(sizeReadyCallback);
        }
    }

    public void removeCallback(SizeReadyCallback sizeReadyCallback) {
        Intrinsics.checkNotNullParameter(sizeReadyCallback, "cb");
        this.sizeDeterminer.removeCallback(sizeReadyCallback);
    }

    public void setRequest(Request request2) {
        this.request = request2;
    }

    public Request getRequest() {
        return this.request;
    }

    public final void clear(RequestManager requestManager) {
        Intrinsics.checkNotNullParameter(requestManager, "requestManager");
        this.sizeDeterminer.clearCallbacksAndListener();
        requestManager.clear((Target<?>) this);
    }
}
