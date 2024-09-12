package com.facebook.imagepipeline.image;

import com.facebook.common.logging.FLog;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.io.Closeable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class CloseableImage implements Closeable, ImageInfo {
    private static final String TAG = "CloseableImage";
    private static final Set<String> mImageExtrasList = new HashSet(Arrays.asList(new String[]{ProducerContext.ExtraKeys.ENCODED_SIZE, ProducerContext.ExtraKeys.ENCODED_WIDTH, ProducerContext.ExtraKeys.ENCODED_HEIGHT, ProducerContext.ExtraKeys.SOURCE_URI, ProducerContext.ExtraKeys.IMAGE_FORMAT, "bitmap_config", "is_rounded"}));
    private Map<String, Object> mExtras = new HashMap();

    public abstract void close();

    public abstract int getSizeInBytes();

    public abstract boolean isClosed();

    public boolean isStateful() {
        return false;
    }

    public QualityInfo getQualityInfo() {
        return ImmutableQualityInfo.FULL_QUALITY;
    }

    public Map<String, Object> getExtras() {
        return this.mExtras;
    }

    public void setImageExtras(@Nullable Map<String, Object> map) {
        if (map != null) {
            for (String next : mImageExtrasList) {
                Object obj = map.get(next);
                if (obj != null) {
                    this.mExtras.put(next, obj);
                }
            }
        }
    }

    public void setImageExtra(String str, Object obj) {
        if (mImageExtrasList.contains(str)) {
            this.mExtras.put(str, obj);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
        if (!isClosed()) {
            FLog.w(TAG, "finalize: %s %x still open.", getClass().getSimpleName(), Integer.valueOf(System.identityHashCode(this)));
            try {
                close();
            } finally {
                super.finalize();
            }
        }
    }
}
