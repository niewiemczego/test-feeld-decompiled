package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.ClassLoaderUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public final class ResourcesModulesLoader extends ModulesLoader {
    private final ClassLoader classLoader;

    public ResourcesModulesLoader(ILogger iLogger) {
        this(iLogger, ResourcesModulesLoader.class.getClassLoader());
    }

    ResourcesModulesLoader(ILogger iLogger, ClassLoader classLoader2) {
        super(iLogger);
        this.classLoader = ClassLoaderUtils.classLoaderOrDefault(classLoader2);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> loadModules() {
        InputStream resourceAsStream;
        TreeMap treeMap = new TreeMap();
        try {
            resourceAsStream = this.classLoader.getResourceAsStream(ModulesLoader.EXTERNAL_MODULES_FILENAME);
            if (resourceAsStream == null) {
                this.logger.log(SentryLevel.INFO, "%s file was not found.", ModulesLoader.EXTERNAL_MODULES_FILENAME);
                if (resourceAsStream != null) {
                    resourceAsStream.close();
                }
                return treeMap;
            }
            Map<String, String> parseStream = parseStream(resourceAsStream);
            if (resourceAsStream != null) {
                resourceAsStream.close();
            }
            return parseStream;
        } catch (SecurityException e) {
            this.logger.log(SentryLevel.INFO, "Access to resources denied.", (Throwable) e);
            return treeMap;
        } catch (IOException e2) {
            this.logger.log(SentryLevel.INFO, "Access to resources failed.", (Throwable) e2);
            return treeMap;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
