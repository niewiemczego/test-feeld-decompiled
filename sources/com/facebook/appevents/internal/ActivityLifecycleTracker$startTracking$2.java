package com.facebook.appevents.internal;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.LoggingBehavior;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000f"}, d2 = {"com/facebook/appevents/internal/ActivityLifecycleTracker$startTracking$2", "Landroid/app/Application$ActivityLifecycleCallbacks;", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ActivityLifecycleTracker.kt */
public final class ActivityLifecycleTracker$startTracking$2 implements Application.ActivityLifecycleCallbacks {
    ActivityLifecycleTracker$startTracking$2() {
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityCreated");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.onActivityCreated(activity);
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences = ActivityLifecycleTracker.activityReferences + 1;
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStarted");
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityResumed");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.onActivityResumed(activity);
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityPaused");
        AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
        AppEventUtility.assertIsMainThread();
        ActivityLifecycleTracker.INSTANCE.onActivityPaused(activity);
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityStopped");
        AppEventsLogger.Companion.onContextStop();
        ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
        ActivityLifecycleTracker.activityReferences = ActivityLifecycleTracker.activityReferences - 1;
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivitySaveInstanceState");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Logger.Companion.log(LoggingBehavior.APP_EVENTS, ActivityLifecycleTracker.TAG, "onActivityDestroyed");
        ActivityLifecycleTracker.INSTANCE.onActivityDestroyed(activity);
    }
}
