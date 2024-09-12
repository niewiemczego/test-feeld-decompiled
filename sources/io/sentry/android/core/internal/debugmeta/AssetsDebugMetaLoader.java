package io.sentry.android.core.internal.debugmeta;

import android.content.Context;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import io.sentry.util.DebugMetaPropertiesApplier;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

public final class AssetsDebugMetaLoader implements IDebugMetaLoader {
    private final Context context;
    private final ILogger logger;

    public AssetsDebugMetaLoader(Context context2, ILogger iLogger) {
        this.context = context2;
        this.logger = iLogger;
    }

    public List<Properties> loadDebugMeta() {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(this.context.getAssets().open(DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME));
            Properties properties = new Properties();
            properties.load(bufferedInputStream);
            List<Properties> singletonList = Collections.singletonList(properties);
            bufferedInputStream.close();
            return singletonList;
        } catch (FileNotFoundException e) {
            this.logger.log(SentryLevel.INFO, e, "%s file was not found.", DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME);
            return null;
        } catch (IOException e2) {
            this.logger.log(SentryLevel.ERROR, "Error getting Proguard UUIDs.", (Throwable) e2);
            return null;
        } catch (RuntimeException e3) {
            this.logger.log(SentryLevel.ERROR, e3, "%s file is malformed.", DebugMetaPropertiesApplier.DEBUG_META_PROPERTIES_FILENAME);
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }
}
