package io.sentry.android.core;

import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class NdkIntegration implements Integration, Closeable {
    public static final String SENTRY_NDK_CLASS_NAME = "io.sentry.android.ndk.SentryNdk";
    private SentryAndroidOptions options;
    private final Class<?> sentryNdkClass;

    public NdkIntegration(Class<?> cls) {
        this.sentryNdkClass = cls;
    }

    public final void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        boolean isEnableNdk = sentryAndroidOptions.isEnableNdk();
        this.options.getLogger().log(SentryLevel.DEBUG, "NdkIntegration enabled: %s", Boolean.valueOf(isEnableNdk));
        if (!isEnableNdk || this.sentryNdkClass == null) {
            disableNdkIntegration(this.options);
        } else if (this.options.getCacheDirPath() == null) {
            this.options.getLogger().log(SentryLevel.ERROR, "No cache dir path is defined in options.", new Object[0]);
            disableNdkIntegration(this.options);
        } else {
            try {
                this.sentryNdkClass.getMethod(Session.JsonKeys.INIT, new Class[]{SentryAndroidOptions.class}).invoke((Object) null, new Object[]{this.options});
                this.options.getLogger().log(SentryLevel.DEBUG, "NdkIntegration installed.", new Object[0]);
                IntegrationUtils.addIntegrationToSdkVersion(getClass());
            } catch (NoSuchMethodException e) {
                disableNdkIntegration(this.options);
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to invoke the SentryNdk.init method.", (Throwable) e);
            } catch (Throwable th) {
                disableNdkIntegration(this.options);
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to initialize SentryNdk.", th);
            }
        }
    }

    private void disableNdkIntegration(SentryAndroidOptions sentryAndroidOptions) {
        sentryAndroidOptions.setEnableNdk(false);
        sentryAndroidOptions.setEnableScopeSync(false);
    }

    /* access modifiers changed from: package-private */
    public Class<?> getSentryNdkClass() {
        return this.sentryNdkClass;
    }

    public void close() throws IOException {
        Class<?> cls;
        SentryAndroidOptions sentryAndroidOptions = this.options;
        if (sentryAndroidOptions != null && sentryAndroidOptions.isEnableNdk() && (cls = this.sentryNdkClass) != null) {
            try {
                cls.getMethod(AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE, new Class[0]).invoke((Object) null, new Object[0]);
                this.options.getLogger().log(SentryLevel.DEBUG, "NdkIntegration removed.", new Object[0]);
            } catch (NoSuchMethodException e) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to invoke the SentryNdk.close method.", (Throwable) e);
            } catch (Throwable th) {
                disableNdkIntegration(this.options);
                throw th;
            }
            disableNdkIntegration(this.options);
        }
    }
}
