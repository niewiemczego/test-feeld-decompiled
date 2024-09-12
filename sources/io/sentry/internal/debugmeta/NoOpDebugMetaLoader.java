package io.sentry.internal.debugmeta;

import java.util.List;
import java.util.Properties;

public final class NoOpDebugMetaLoader implements IDebugMetaLoader {
    private static final NoOpDebugMetaLoader instance = new NoOpDebugMetaLoader();

    public List<Properties> loadDebugMeta() {
        return null;
    }

    public static NoOpDebugMetaLoader getInstance() {
        return instance;
    }

    private NoOpDebugMetaLoader() {
    }
}
