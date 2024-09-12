package androidx.work;

import android.os.Build;
import androidx.work.WorkRequest;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00062\u00020\u0001:\u0002\u0005\u0006B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0007"}, d2 = {"Landroidx/work/PeriodicWorkRequest;", "Landroidx/work/WorkRequest;", "builder", "Landroidx/work/PeriodicWorkRequest$Builder;", "(Landroidx/work/PeriodicWorkRequest$Builder;)V", "Builder", "Companion", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PeriodicWorkRequest.kt */
public final class PeriodicWorkRequest extends WorkRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long MIN_PERIODIC_FLEX_MILLIS = 300000;
    public static final long MIN_PERIODIC_INTERVAL_MILLIS = 900000;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PeriodicWorkRequest(Builder builder) {
        super(builder.getId$work_runtime_release(), builder.getWorkSpec$work_runtime_release(), builder.getTags$work_runtime_release());
        Intrinsics.checkNotNullParameter(builder, "builder");
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u00020\u0001B)\b\u0016\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB\u001f\b\u0017\u0012\u000e\u0010\u0003\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u000b¢\u0006\u0002\u0010\fB9\b\u0016\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u0007\u0012\u0006\u0010\u000e\u001a\u00020\t¢\u0006\u0002\u0010\u000fB)\b\u0017\u0012\u0010\u0010\u0003\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u0010J\r\u0010\u0014\u001a\u00020\u0002H\u0010¢\u0006\u0002\b\u0015R\u0014\u0010\u0011\u001a\u00020\u00008PX\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Landroidx/work/PeriodicWorkRequest$Builder;", "Landroidx/work/WorkRequest$Builder;", "Landroidx/work/PeriodicWorkRequest;", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "repeatInterval", "", "repeatIntervalTimeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/Class;JLjava/util/concurrent/TimeUnit;)V", "Ljava/time/Duration;", "(Ljava/lang/Class;Ljava/time/Duration;)V", "flexInterval", "flexIntervalTimeUnit", "(Ljava/lang/Class;JLjava/util/concurrent/TimeUnit;JLjava/util/concurrent/TimeUnit;)V", "(Ljava/lang/Class;Ljava/time/Duration;Ljava/time/Duration;)V", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/PeriodicWorkRequest$Builder;", "buildInternal", "buildInternal$work_runtime_release", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PeriodicWorkRequest.kt */
    public static final class Builder extends WorkRequest.Builder<Builder, PeriodicWorkRequest> {
        public Builder getThisObject$work_runtime_release() {
            return this;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            Intrinsics.checkNotNullParameter(timeUnit, "repeatIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, Duration duration) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            Intrinsics.checkNotNullParameter(duration, "repeatInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, long j, TimeUnit timeUnit, long j2, TimeUnit timeUnit2) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            Intrinsics.checkNotNullParameter(timeUnit, "repeatIntervalTimeUnit");
            Intrinsics.checkNotNullParameter(timeUnit2, "flexIntervalTimeUnit");
            getWorkSpec$work_runtime_release().setPeriodic(timeUnit.toMillis(j), timeUnit2.toMillis(j2));
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Builder(Class<? extends ListenableWorker> cls, Duration duration, Duration duration2) {
            super(cls);
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            Intrinsics.checkNotNullParameter(duration, "repeatInterval");
            Intrinsics.checkNotNullParameter(duration2, "flexInterval");
            getWorkSpec$work_runtime_release().setPeriodic(DurationApi26Impl.toMillisCompat(duration), DurationApi26Impl.toMillisCompat(duration2));
        }

        public PeriodicWorkRequest buildInternal$work_runtime_release() {
            if (!(!getBackoffCriteriaSet$work_runtime_release() || Build.VERSION.SDK_INT < 23 || !getWorkSpec$work_runtime_release().constraints.requiresDeviceIdle())) {
                throw new IllegalArgumentException("Cannot set backoff criteria on an idle mode job".toString());
            } else if (!getWorkSpec$work_runtime_release().expedited) {
                return new PeriodicWorkRequest(this);
            } else {
                throw new IllegalArgumentException("PeriodicWorkRequests cannot be expedited".toString());
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Landroidx/work/PeriodicWorkRequest$Companion;", "", "()V", "MIN_PERIODIC_FLEX_MILLIS", "", "MIN_PERIODIC_INTERVAL_MILLIS", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: PeriodicWorkRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
