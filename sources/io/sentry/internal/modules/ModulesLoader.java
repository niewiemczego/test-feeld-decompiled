package io.sentry.internal.modules;

import io.sentry.ILogger;
import io.sentry.SentryLevel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.TreeMap;

public abstract class ModulesLoader implements IModulesLoader {
    public static final String EXTERNAL_MODULES_FILENAME = "sentry-external-modules.txt";
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private Map<String, String> cachedModules = null;
    protected final ILogger logger;

    /* access modifiers changed from: protected */
    public abstract Map<String, String> loadModules();

    public ModulesLoader(ILogger iLogger) {
        this.logger = iLogger;
    }

    public Map<String, String> getOrLoadModules() {
        Map<String, String> map = this.cachedModules;
        if (map != null) {
            return map;
        }
        Map<String, String> loadModules = loadModules();
        this.cachedModules = loadModules;
        return loadModules;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> parseStream(InputStream inputStream) {
        BufferedReader bufferedReader;
        TreeMap treeMap = new TreeMap();
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, UTF_8));
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                int lastIndexOf = readLine.lastIndexOf(58);
                treeMap.put(readLine.substring(0, lastIndexOf), readLine.substring(lastIndexOf + 1));
            }
            this.logger.log(SentryLevel.DEBUG, "Extracted %d modules from resources.", Integer.valueOf(treeMap.size()));
            bufferedReader.close();
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error extracting modules.", (Throwable) e);
        } catch (RuntimeException e2) {
            this.logger.log(SentryLevel.ERROR, e2, "%s file is malformed.", EXTERNAL_MODULES_FILENAME);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        return treeMap;
        throw th;
    }
}
