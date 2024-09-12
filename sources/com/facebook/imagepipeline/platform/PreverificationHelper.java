package com.facebook.imagepipeline.platform;

import android.graphics.Bitmap;
import javax.annotation.Nullable;

class PreverificationHelper {
    PreverificationHelper() {
    }

    /* access modifiers changed from: package-private */
    public boolean shouldUseHardwareBitmapConfig(@Nullable Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
