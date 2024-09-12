package androidx.work;

import android.os.Build;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.utils.DurationApi26Impl;
import java.time.Duration;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\r\b&\u0018\u0000 \u00142\u00020\u0001:\u0002\u0013\u0014B%\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Landroidx/work/WorkRequest;", "", "id", "Ljava/util/UUID;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "tags", "", "", "(Ljava/util/UUID;Landroidx/work/impl/model/WorkSpec;Ljava/util/Set;)V", "getId", "()Ljava/util/UUID;", "stringId", "getStringId", "()Ljava/lang/String;", "getTags", "()Ljava/util/Set;", "getWorkSpec", "()Landroidx/work/impl/model/WorkSpec;", "Builder", "Companion", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkRequest.kt */
public abstract class WorkRequest {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long DEFAULT_BACKOFF_DELAY_MILLIS = 30000;
    public static final long MAX_BACKOFF_MILLIS = 18000000;
    public static final long MIN_BACKOFF_MILLIS = 10000;
    private final UUID id;
    private final Set<String> tags;
    private final WorkSpec workSpec;

    public WorkRequest(UUID uuid, WorkSpec workSpec2, Set<String> set) {
        Intrinsics.checkNotNullParameter(uuid, "id");
        Intrinsics.checkNotNullParameter(workSpec2, "workSpec");
        Intrinsics.checkNotNullParameter(set, "tags");
        this.id = uuid;
        this.workSpec = workSpec2;
        this.tags = set;
    }

    public UUID getId() {
        return this.id;
    }

    public final WorkSpec getWorkSpec() {
        return this.workSpec;
    }

    public final Set<String> getTags() {
        return this.tags;
    }

    public final String getStringId() {
        String uuid = getId().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
        return uuid;
    }

    @Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\u0012\b\u0000\u0010\u0001*\f\u0012\u0004\u0012\u0002H\u0001\u0012\u0002\b\u00030\u0000*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0017\b\u0000\u0012\u000e\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006¢\u0006\u0002\u0010\bJ\u0013\u0010%\u001a\u00028\u00002\u0006\u0010&\u001a\u00020\u0017¢\u0006\u0002\u0010'J\u000b\u0010(\u001a\u00028\u0001¢\u0006\u0002\u0010)J\u000f\u0010*\u001a\u00028\u0001H ¢\u0006\u0004\b+\u0010)J\u0015\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u0010/J\u001b\u0010,\u001a\u00028\u00002\u0006\u0010-\u001a\u0002002\u0006\u00101\u001a\u000202¢\u0006\u0002\u00103J\u001d\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u0002062\u0006\u0010-\u001a\u00020.H\u0007¢\u0006\u0002\u00107J#\u00104\u001a\u00028\u00002\u0006\u00105\u001a\u0002062\u0006\u00108\u001a\u0002002\u0006\u00101\u001a\u000202¢\u0006\u0002\u00109J\u0013\u0010:\u001a\u00028\u00002\u0006\u0010;\u001a\u00020<¢\u0006\u0002\u0010=J\u0015\u0010>\u001a\u00028\u00002\u0006\u0010?\u001a\u00020@H\u0017¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010CJ\u0015\u0010D\u001a\u00028\u00002\u0006\u0010-\u001a\u00020.H\u0017¢\u0006\u0002\u0010/J\u001d\u0010D\u001a\u00028\u00002\u0006\u0010-\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016¢\u0006\u0002\u00103J\u0015\u0010E\u001a\u00028\u00002\u0006\u0010F\u001a\u00020GH\u0007¢\u0006\u0002\u0010HJ\u0015\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00020KH\u0007¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00028\u00002\u0006\u0010N\u001a\u00020O¢\u0006\u0002\u0010PJ\u001d\u0010Q\u001a\u00028\u00002\u0006\u0010R\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00103J\u001d\u0010S\u001a\u00028\u00002\u0006\u0010T\u001a\u0002002\u0006\u00101\u001a\u000202H\u0007¢\u0006\u0002\u00103R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00028\u0000X \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0005\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$¨\u0006U"}, d2 = {"Landroidx/work/WorkRequest$Builder;", "B", "W", "Landroidx/work/WorkRequest;", "", "workerClass", "Ljava/lang/Class;", "Landroidx/work/ListenableWorker;", "(Ljava/lang/Class;)V", "backoffCriteriaSet", "", "getBackoffCriteriaSet$work_runtime_release", "()Z", "setBackoffCriteriaSet$work_runtime_release", "(Z)V", "id", "Ljava/util/UUID;", "getId$work_runtime_release", "()Ljava/util/UUID;", "setId$work_runtime_release", "(Ljava/util/UUID;)V", "tags", "", "", "getTags$work_runtime_release", "()Ljava/util/Set;", "thisObject", "getThisObject$work_runtime_release", "()Landroidx/work/WorkRequest$Builder;", "workSpec", "Landroidx/work/impl/model/WorkSpec;", "getWorkSpec$work_runtime_release", "()Landroidx/work/impl/model/WorkSpec;", "setWorkSpec$work_runtime_release", "(Landroidx/work/impl/model/WorkSpec;)V", "getWorkerClass$work_runtime_release", "()Ljava/lang/Class;", "addTag", "tag", "(Ljava/lang/String;)Landroidx/work/WorkRequest$Builder;", "build", "()Landroidx/work/WorkRequest;", "buildInternal", "buildInternal$work_runtime_release", "keepResultsForAtLeast", "duration", "Ljava/time/Duration;", "(Ljava/time/Duration;)Landroidx/work/WorkRequest$Builder;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "setBackoffCriteria", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "(Landroidx/work/BackoffPolicy;Ljava/time/Duration;)Landroidx/work/WorkRequest$Builder;", "backoffDelay", "(Landroidx/work/BackoffPolicy;JLjava/util/concurrent/TimeUnit;)Landroidx/work/WorkRequest$Builder;", "setConstraints", "constraints", "Landroidx/work/Constraints;", "(Landroidx/work/Constraints;)Landroidx/work/WorkRequest$Builder;", "setExpedited", "policy", "Landroidx/work/OutOfQuotaPolicy;", "(Landroidx/work/OutOfQuotaPolicy;)Landroidx/work/WorkRequest$Builder;", "setId", "(Ljava/util/UUID;)Landroidx/work/WorkRequest$Builder;", "setInitialDelay", "setInitialRunAttemptCount", "runAttemptCount", "", "(I)Landroidx/work/WorkRequest$Builder;", "setInitialState", "state", "Landroidx/work/WorkInfo$State;", "(Landroidx/work/WorkInfo$State;)Landroidx/work/WorkRequest$Builder;", "setInputData", "inputData", "Landroidx/work/Data;", "(Landroidx/work/Data;)Landroidx/work/WorkRequest$Builder;", "setLastEnqueueTime", "periodStartTime", "setScheduleRequestedAt", "scheduleRequestedAt", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkRequest.kt */
    public static abstract class Builder<B extends Builder<B, ?>, W extends WorkRequest> {
        private boolean backoffCriteriaSet;
        private UUID id;
        private final Set<String> tags;
        private WorkSpec workSpec;
        private final Class<? extends ListenableWorker> workerClass;

        public abstract W buildInternal$work_runtime_release();

        public abstract B getThisObject$work_runtime_release();

        public Builder(Class<? extends ListenableWorker> cls) {
            Intrinsics.checkNotNullParameter(cls, "workerClass");
            this.workerClass = cls;
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            this.id = randomUUID;
            String uuid = this.id.toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
            String name = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name, "workerClass.name");
            this.workSpec = new WorkSpec(uuid, name);
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "workerClass.name");
            this.tags = SetsKt.mutableSetOf(name2);
        }

        public final Class<? extends ListenableWorker> getWorkerClass$work_runtime_release() {
            return this.workerClass;
        }

        public final boolean getBackoffCriteriaSet$work_runtime_release() {
            return this.backoffCriteriaSet;
        }

        public final void setBackoffCriteriaSet$work_runtime_release(boolean z) {
            this.backoffCriteriaSet = z;
        }

        public final UUID getId$work_runtime_release() {
            return this.id;
        }

        public final void setId$work_runtime_release(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "<set-?>");
            this.id = uuid;
        }

        public final WorkSpec getWorkSpec$work_runtime_release() {
            return this.workSpec;
        }

        public final void setWorkSpec$work_runtime_release(WorkSpec workSpec2) {
            Intrinsics.checkNotNullParameter(workSpec2, "<set-?>");
            this.workSpec = workSpec2;
        }

        public final Set<String> getTags$work_runtime_release() {
            return this.tags;
        }

        public final B setId(UUID uuid) {
            Intrinsics.checkNotNullParameter(uuid, "id");
            this.id = uuid;
            String uuid2 = uuid.toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "id.toString()");
            this.workSpec = new WorkSpec(uuid2, this.workSpec);
            return getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(timeUnit.toMillis(j));
            return getThisObject$work_runtime_release();
        }

        public final B setBackoffCriteria(BackoffPolicy backoffPolicy, Duration duration) {
            Intrinsics.checkNotNullParameter(backoffPolicy, "backoffPolicy");
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.backoffCriteriaSet = true;
            this.workSpec.backoffPolicy = backoffPolicy;
            this.workSpec.setBackoffDelayDuration(DurationApi26Impl.toMillisCompat(duration));
            return getThisObject$work_runtime_release();
        }

        public final B setConstraints(Constraints constraints) {
            Intrinsics.checkNotNullParameter(constraints, "constraints");
            this.workSpec.constraints = constraints;
            return getThisObject$work_runtime_release();
        }

        public final B setInputData(Data data) {
            Intrinsics.checkNotNullParameter(data, "inputData");
            this.workSpec.input = data;
            return getThisObject$work_runtime_release();
        }

        public final B addTag(String str) {
            Intrinsics.checkNotNullParameter(str, "tag");
            this.tags.add(str);
            return getThisObject$work_runtime_release();
        }

        public final B keepResultsForAtLeast(long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.minimumRetentionDuration = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        public final B keepResultsForAtLeast(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.workSpec.minimumRetentionDuration = DurationApi26Impl.toMillisCompat(duration);
            return getThisObject$work_runtime_release();
        }

        public B setInitialDelay(long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.initialDelay = timeUnit.toMillis(j);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        public B setInitialDelay(Duration duration) {
            Intrinsics.checkNotNullParameter(duration, "duration");
            this.workSpec.initialDelay = DurationApi26Impl.toMillisCompat(duration);
            if (Long.MAX_VALUE - System.currentTimeMillis() > this.workSpec.initialDelay) {
                return getThisObject$work_runtime_release();
            }
            throw new IllegalArgumentException("The given initial delay is too large and will cause an overflow!".toString());
        }

        public B setExpedited(OutOfQuotaPolicy outOfQuotaPolicy) {
            Intrinsics.checkNotNullParameter(outOfQuotaPolicy, "policy");
            this.workSpec.expedited = true;
            this.workSpec.outOfQuotaPolicy = outOfQuotaPolicy;
            return getThisObject$work_runtime_release();
        }

        public final W build() {
            W buildInternal$work_runtime_release = buildInternal$work_runtime_release();
            Constraints constraints = this.workSpec.constraints;
            boolean z = false;
            boolean z2 = (Build.VERSION.SDK_INT >= 24 && constraints.hasContentUriTriggers()) || constraints.requiresBatteryNotLow() || constraints.requiresCharging() || (Build.VERSION.SDK_INT >= 23 && constraints.requiresDeviceIdle());
            if (this.workSpec.expedited) {
                if (!z2) {
                    if (this.workSpec.initialDelay <= 0) {
                        z = true;
                    }
                    if (!z) {
                        throw new IllegalArgumentException("Expedited jobs cannot be delayed".toString());
                    }
                } else {
                    throw new IllegalArgumentException("Expedited jobs only support network and storage constraints".toString());
                }
            }
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            setId(randomUUID);
            return buildInternal$work_runtime_release;
        }

        public final B setInitialState(WorkInfo.State state) {
            Intrinsics.checkNotNullParameter(state, "state");
            this.workSpec.state = state;
            return getThisObject$work_runtime_release();
        }

        public final B setInitialRunAttemptCount(int i) {
            this.workSpec.runAttemptCount = i;
            return getThisObject$work_runtime_release();
        }

        public final B setLastEnqueueTime(long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.lastEnqueueTime = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }

        public final B setScheduleRequestedAt(long j, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            this.workSpec.scheduleRequestedAt = timeUnit.toMillis(j);
            return getThisObject$work_runtime_release();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Landroidx/work/WorkRequest$Companion;", "", "()V", "DEFAULT_BACKOFF_DELAY_MILLIS", "", "MAX_BACKOFF_MILLIS", "MIN_BACKOFF_MILLIS", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkRequest.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
