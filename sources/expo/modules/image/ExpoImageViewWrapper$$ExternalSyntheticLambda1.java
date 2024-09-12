package expo.modules.image;

import android.graphics.drawable.Drawable;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ExpoImageViewWrapper$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ExpoImageViewWrapper f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ ImageViewWrapperTarget f$2;
    public final /* synthetic */ Drawable f$3;

    public /* synthetic */ ExpoImageViewWrapper$$ExternalSyntheticLambda1(ExpoImageViewWrapper expoImageViewWrapper, boolean z, ImageViewWrapperTarget imageViewWrapperTarget, Drawable drawable) {
        this.f$0 = expoImageViewWrapper;
        this.f$1 = z;
        this.f$2 = imageViewWrapperTarget;
        this.f$3 = drawable;
    }

    public final void run() {
        ExpoImageViewWrapper.m762onResourceReady$lambda8(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
