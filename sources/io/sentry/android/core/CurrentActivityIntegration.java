package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryOptions;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class CurrentActivityIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application application;

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public CurrentActivityIntegration(Application application2) {
        this.application = (Application) Objects.requireNonNull(application2, "Application is required");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        this.application.registerActivityLifecycleCallbacks(this);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        setCurrentActivity(activity);
    }

    public void onActivityStarted(Activity activity) {
        setCurrentActivity(activity);
    }

    public void onActivityResumed(Activity activity) {
        setCurrentActivity(activity);
    }

    public void onActivityPaused(Activity activity) {
        cleanCurrentActivity(activity);
    }

    public void onActivityStopped(Activity activity) {
        cleanCurrentActivity(activity);
    }

    public void onActivityDestroyed(Activity activity) {
        cleanCurrentActivity(activity);
    }

    public void close() throws IOException {
        this.application.unregisterActivityLifecycleCallbacks(this);
        CurrentActivityHolder.getInstance().clearActivity();
    }

    private void cleanCurrentActivity(Activity activity) {
        if (CurrentActivityHolder.getInstance().getActivity() == activity) {
            CurrentActivityHolder.getInstance().clearActivity();
        }
    }

    private void setCurrentActivity(Activity activity) {
        CurrentActivityHolder.getInstance().setActivity(activity);
    }
}
