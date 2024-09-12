package com.facebook.drawee.backends.pipeline.debug;

import com.facebook.drawee.backends.pipeline.info.ImageOriginListener;
import javax.annotation.Nullable;

public class DebugOverlayImageOriginListener implements ImageOriginListener {
    private int mImageOrigin = 1;

    public void onImageLoaded(String str, int i, boolean z, @Nullable String str2) {
        this.mImageOrigin = i;
    }

    public int getImageOrigin() {
        return this.mImageOrigin;
    }
}
