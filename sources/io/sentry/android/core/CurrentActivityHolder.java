package io.sentry.android.core;

import android.app.Activity;
import java.lang.ref.WeakReference;

public class CurrentActivityHolder {
    private static final CurrentActivityHolder instance = new CurrentActivityHolder();
    private WeakReference<Activity> currentActivity;

    private CurrentActivityHolder() {
    }

    public static CurrentActivityHolder getInstance() {
        return instance;
    }

    public Activity getActivity() {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference != null) {
            return (Activity) weakReference.get();
        }
        return null;
    }

    public void setActivity(Activity activity) {
        WeakReference<Activity> weakReference = this.currentActivity;
        if (weakReference == null || weakReference.get() != activity) {
            this.currentActivity = new WeakReference<>(activity);
        }
    }

    public void clearActivity() {
        this.currentActivity = null;
    }
}
