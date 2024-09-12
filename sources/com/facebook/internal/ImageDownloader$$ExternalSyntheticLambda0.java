package com.facebook.internal;

import android.graphics.Bitmap;
import com.facebook.internal.ImageRequest;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ImageDownloader$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ImageRequest f$0;
    public final /* synthetic */ Exception f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Bitmap f$3;
    public final /* synthetic */ ImageRequest.Callback f$4;

    public /* synthetic */ ImageDownloader$$ExternalSyntheticLambda0(ImageRequest imageRequest, Exception exc, boolean z, Bitmap bitmap, ImageRequest.Callback callback) {
        this.f$0 = imageRequest;
        this.f$1 = exc;
        this.f$2 = z;
        this.f$3 = bitmap;
        this.f$4 = callback;
    }

    public final void run() {
        ImageDownloader.m340issueResponse$lambda4(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
