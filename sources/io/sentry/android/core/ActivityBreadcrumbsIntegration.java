package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import io.sentry.Breadcrumb;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.Integration;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.TypeCheckHint;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class ActivityBreadcrumbsIntegration implements Integration, Closeable, Application.ActivityLifecycleCallbacks {
    private final Application application;
    private boolean enabled;
    private IHub hub;

    public ActivityBreadcrumbsIntegration(Application application2) {
        this.application = (Application) Objects.requireNonNull(application2, "Application is required");
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        SentryAndroidOptions sentryAndroidOptions = sentryOptions instanceof SentryAndroidOptions ? (SentryAndroidOptions) sentryOptions : null;
        this.hub = (IHub) Objects.requireNonNull(iHub, "Hub is required");
        this.enabled = ((SentryAndroidOptions) Objects.requireNonNull(sentryAndroidOptions, "SentryAndroidOptions is required")).isEnableActivityLifecycleBreadcrumbs();
        sentryOptions.getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration enabled: %s", Boolean.valueOf(this.enabled));
        if (this.enabled) {
            this.application.registerActivityLifecycleCallbacks(this);
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbIntegration installed.", new Object[0]);
            IntegrationUtils.addIntegrationToSdkVersion(getClass());
        }
    }

    public void close() throws IOException {
        if (this.enabled) {
            this.application.unregisterActivityLifecycleCallbacks(this);
            IHub iHub = this.hub;
            if (iHub != null) {
                iHub.getOptions().getLogger().log(SentryLevel.DEBUG, "ActivityBreadcrumbsIntegration removed.", new Object[0]);
            }
        }
    }

    public synchronized void onActivityCreated(Activity activity, Bundle bundle) {
        addBreadcrumb(activity, "created");
    }

    public synchronized void onActivityStarted(Activity activity) {
        addBreadcrumb(activity, Session.JsonKeys.STARTED);
    }

    public synchronized void onActivityResumed(Activity activity) {
        addBreadcrumb(activity, "resumed");
    }

    public synchronized void onActivityPaused(Activity activity) {
        addBreadcrumb(activity, "paused");
    }

    public synchronized void onActivityStopped(Activity activity) {
        addBreadcrumb(activity, "stopped");
    }

    public synchronized void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        addBreadcrumb(activity, "saveInstanceState");
    }

    public synchronized void onActivityDestroyed(Activity activity) {
        addBreadcrumb(activity, "destroyed");
    }

    private void addBreadcrumb(Activity activity, String str) {
        if (this.hub != null) {
            Breadcrumb breadcrumb = new Breadcrumb();
            breadcrumb.setType(NotificationCompat.CATEGORY_NAVIGATION);
            breadcrumb.setData("state", str);
            breadcrumb.setData("screen", getActivityName(activity));
            breadcrumb.setCategory("ui.lifecycle");
            breadcrumb.setLevel(SentryLevel.INFO);
            Hint hint = new Hint();
            hint.set(TypeCheckHint.ANDROID_ACTIVITY, activity);
            this.hub.addBreadcrumb(breadcrumb, hint);
        }
    }

    private String getActivityName(Activity activity) {
        return activity.getClass().getSimpleName();
    }
}
