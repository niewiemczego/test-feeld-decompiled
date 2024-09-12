package io.sentry.internal.modules;

import java.util.Map;

public interface IModulesLoader {
    Map<String, String> getOrLoadModules();
}
