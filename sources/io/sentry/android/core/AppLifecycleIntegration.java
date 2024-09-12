package io.sentry.android.core;

import androidx.lifecycle.ProcessLifecycleOwner;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class AppLifecycleIntegration implements Integration, Closeable {
    private final MainLooperHandler handler;
    private SentryAndroidOptions options;
    volatile LifecycleWatcher watcher;

    public AppLifecycleIntegration() {
        this(new MainLooperHandler());
    }

    AppLifecycleIntegration(MainLooperHandler mainLooperHandler) {
        this.handler = mainLooperHandler;
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        SentryAndroidOptions sentryAndroidOptions = (SentryAndroidOptions) Objects.requireNonNull(sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null, "SentryAndroidOptions is required");
        this.options = sentryAndroidOptions;
        sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "enableSessionTracking enabled: %s", Boolean.valueOf(this.options.isEnableAutoSessionTracking()));
        this.options.getLogger().log(SentryLevel.DEBUG, "enableAppLifecycleBreadcrumbs enabled: %s", Boolean.valueOf(this.options.isEnableAppLifecycleBreadcrumbs()));
        if (this.options.isEnableAutoSessionTracking() || this.options.isEnableAppLifecycleBreadcrumbs()) {
            try {
                Class.forName("androidx.lifecycle.DefaultLifecycleObserver");
                Class.forName("androidx.lifecycle.ProcessLifecycleOwner");
                if (AndroidMainThreadChecker.getInstance().isMainThread()) {
                    m898lambda$register$0$iosentryandroidcoreAppLifecycleIntegration(iHub);
                } else {
                    this.handler.post(new AppLifecycleIntegration$$ExternalSyntheticLambda1(this, iHub));
                }
            } catch (ClassNotFoundException e) {
                sentryOptions.getLogger().log(SentryLevel.INFO, "androidx.lifecycle is not available, AppLifecycleIntegration won't be installed", (Throwable) e);
            } catch (IllegalStateException e2) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "AppLifecycleIntegration could not be installed", (Throwable) e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: addObserver */
    public void m898lambda$register$0$iosentryandroidcoreAppLifecycleIntegration(IHub iHub) {
        if (this.options != null) {
            this.watcher = new LifecycleWatcher(iHub, this.options.getSessionTrackingIntervalMillis(), this.options.isEnableAutoSessionTracking(), this.options.isEnableAppLifecycleBreadcrumbs());
            try {
                ProcessLifecycleOwner.get().getLifecycle().addObserver(this.watcher);
                this.options.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration installed.", new Object[0]);
                IntegrationUtils.addIntegrationToSdkVersion(getClass());
            } catch (Throwable th) {
                this.watcher = null;
                this.options.getLogger().log(SentryLevel.ERROR, "AppLifecycleIntegration failed to get Lifecycle and could not be installed.", th);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: removeObserver */
    public void m897lambda$close$1$iosentryandroidcoreAppLifecycleIntegration() {
        LifecycleWatcher lifecycleWatcher = this.watcher;
        if (lifecycleWatcher != null) {
            ProcessLifecycleOwner.get().getLifecycle().removeObserver(lifecycleWatcher);
            SentryAndroidOptions sentryAndroidOptions = this.options;
            if (sentryAndroidOptions != null) {
                sentryAndroidOptions.getLogger().log(SentryLevel.DEBUG, "AppLifecycleIntegration removed.", new Object[0]);
            }
        }
        this.watcher = null;
    }

    public void close() throws IOException {
        if (this.watcher != null) {
            if (AndroidMainThreadChecker.getInstance().isMainThread()) {
                m897lambda$close$1$iosentryandroidcoreAppLifecycleIntegration();
            } else {
                this.handler.post(new AppLifecycleIntegration$$ExternalSyntheticLambda0(this));
            }
        }
    }
}
