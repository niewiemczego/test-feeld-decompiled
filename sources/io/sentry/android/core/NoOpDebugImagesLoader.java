package io.sentry.android.core;

import io.sentry.protocol.DebugImage;
import java.util.List;

final class NoOpDebugImagesLoader implements IDebugImagesLoader {
    private static final NoOpDebugImagesLoader instance = new NoOpDebugImagesLoader();

    public void clearDebugImages() {
    }

    public List<DebugImage> loadDebugImages() {
        return null;
    }

    private NoOpDebugImagesLoader() {
    }

    public static NoOpDebugImagesLoader getInstance() {
        return instance;
    }
}
