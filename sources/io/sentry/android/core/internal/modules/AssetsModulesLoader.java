package io.sentry.android.core.internal.modules;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.internal.modules.ModulesLoader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.TreeMap;

public final class AssetsModulesLoader extends ModulesLoader {
    private final Context context;

    public AssetsModulesLoader(Context context2, ILogger iLogger) {
        super(iLogger);
        this.context = context2;
    }

    /* access modifiers changed from: protected */
    public Map<String, String> loadModules() {
        InputStream open;
        TreeMap treeMap = new TreeMap();
        try {
            open = this.context.getAssets().open(ModulesLoader.EXTERNAL_MODULES_FILENAME);
            Map<String, String> parseStream = parseStream(open);
            if (open != null) {
                open.close();
            }
            return parseStream;
        } catch (FileNotFoundException unused) {
            this.logger.log(SentryLevel.INFO, "%s file was not found.", ModulesLoader.EXTERNAL_MODULES_FILENAME);
            return treeMap;
        } catch (IOException e) {
            this.logger.log(SentryLevel.ERROR, "Error extracting modules.", (Throwable) e);
            return treeMap;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
