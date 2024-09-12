package io.sentry.internal.modules;

import io.sentry.ILogger;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public final class CompositeModulesLoader extends ModulesLoader {
    private final List<IModulesLoader> loaders;

    public CompositeModulesLoader(List<IModulesLoader> list, ILogger iLogger) {
        super(iLogger);
        this.loaders = list;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> loadModules() {
        TreeMap treeMap = new TreeMap();
        for (IModulesLoader orLoadModules : this.loaders) {
            Map<String, String> orLoadModules2 = orLoadModules.getOrLoadModules();
            if (orLoadModules2 != null) {
                treeMap.putAll(orLoadModules2);
            }
        }
        return treeMap;
    }
}
