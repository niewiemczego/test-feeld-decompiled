package io.sentry.android.core;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import io.sentry.ILogger;
import io.sentry.Sentry;
import io.sentry.SentryIntegrationPackageStorage;
import io.sentry.SentryLevel;

public final class SentryInitProvider extends EmptySecureContentProvider {
    public String getType(Uri uri) {
        return null;
    }

    public boolean onCreate() {
        AndroidLogger androidLogger = new AndroidLogger();
        Context context = getContext();
        if (context == null) {
            androidLogger.log(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return false;
        } else if (!ManifestMetadataReader.isAutoInit(context, androidLogger)) {
            return true;
        } else {
            SentryAndroid.init(context, (ILogger) androidLogger);
            SentryIntegrationPackageStorage.getInstance().addIntegration("AutoInit");
            return true;
        }
    }

    public void shutdown() {
        Sentry.close();
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (!SentryInitProvider.class.getName().equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }
}
