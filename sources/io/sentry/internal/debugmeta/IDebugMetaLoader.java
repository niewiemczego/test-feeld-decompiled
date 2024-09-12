package io.sentry.internal.debugmeta;

import java.util.List;
import java.util.Properties;

public interface IDebugMetaLoader {
    List<Properties> loadDebugMeta();
}
