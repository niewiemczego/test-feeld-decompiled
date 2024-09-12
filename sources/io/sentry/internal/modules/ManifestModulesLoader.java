package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.util.ClassLoaderUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ManifestModulesLoader extends ModulesLoader {
    private final Pattern NAME_AND_VERSION;
    private final Pattern URL_LIB_PATTERN;
    private final ClassLoader classLoader;

    public ManifestModulesLoader(ILogger iLogger) {
        this(ManifestModulesLoader.class.getClassLoader(), iLogger);
    }

    ManifestModulesLoader(ClassLoader classLoader2, ILogger iLogger) {
        super(iLogger);
        this.URL_LIB_PATTERN = Pattern.compile(".*/(.+)!/META-INF/MANIFEST.MF");
        this.NAME_AND_VERSION = Pattern.compile("(.*?)-(\\d+\\.\\d+.*).jar");
        this.classLoader = ClassLoaderUtils.classLoaderOrDefault(classLoader2);
    }

    /* access modifiers changed from: protected */
    public Map<String, String> loadModules() {
        HashMap hashMap = new HashMap();
        for (Module next : detectModulesViaManifestFiles()) {
            hashMap.put(next.name, next.version);
        }
        return hashMap;
    }

    private List<Module> detectModulesViaManifestFiles() {
        ArrayList arrayList = new ArrayList();
        try {
            Enumeration<URL> resources = this.classLoader.getResources("META-INF/MANIFEST.MF");
            while (resources.hasMoreElements()) {
                Module convertOriginalNameToModule = convertOriginalNameToModule(extractDependencyNameFromUrl(resources.nextElement()));
                if (convertOriginalNameToModule != null) {
                    arrayList.add(convertOriginalNameToModule);
                }
            }
        } catch (Throwable th) {
            this.logger.log(SentryLevel.ERROR, "Unable to detect modules via manifest files.", th);
        }
        return arrayList;
    }

    private Module convertOriginalNameToModule(String str) {
        if (str == null) {
            return null;
        }
        Matcher matcher = this.NAME_AND_VERSION.matcher(str);
        if (!matcher.matches() || matcher.groupCount() != 2) {
            return null;
        }
        return new Module(matcher.group(1), matcher.group(2));
    }

    private String extractDependencyNameFromUrl(URL url) {
        Matcher matcher = this.URL_LIB_PATTERN.matcher(url.toString());
        if (!matcher.matches() || matcher.groupCount() != 1) {
            return null;
        }
        return matcher.group(1);
    }

    private static final class Module {
        /* access modifiers changed from: private */
        public final String name;
        /* access modifiers changed from: private */
        public final String version;

        public Module(String str, String str2) {
            this.name = str;
            this.version = str2;
        }
    }
}
