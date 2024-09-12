package io.sentry.android.core.performance;

public class ActivityLifecycleTimeSpan implements Comparable<ActivityLifecycleTimeSpan> {
    private final TimeSpan onCreate = new TimeSpan();
    private final TimeSpan onStart = new TimeSpan();

    public final TimeSpan getOnCreate() {
        return this.onCreate;
    }

    public final TimeSpan getOnStart() {
        return this.onStart;
    }

    public int compareTo(ActivityLifecycleTimeSpan activityLifecycleTimeSpan) {
        int compare = Long.compare(this.onCreate.getStartUptimeMs(), activityLifecycleTimeSpan.onCreate.getStartUptimeMs());
        return compare == 0 ? Long.compare(this.onStart.getStartUptimeMs(), activityLifecycleTimeSpan.onStart.getStartUptimeMs()) : compare;
    }
}
