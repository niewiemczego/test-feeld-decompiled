package io.sentry.android.core;

import io.sentry.protocol.DebugImage;
import java.util.List;

public interface IDebugImagesLoader {
    void clearDebugImages();

    List<DebugImage> loadDebugImages();
}
