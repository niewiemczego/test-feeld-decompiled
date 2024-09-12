package androidx.work.impl.model;

import androidx.arch.core.util.Function;
import androidx.core.app.NotificationCompat;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.Logger;
import androidx.work.OutOfQuotaPolicy;
import androidx.work.WorkInfo;
import androidx.work.WorkRequest;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u0002\n\u0002\b\u0006\b\b\u0018\u0000 J2\u00020\u0001:\u0003JKLB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0000¢\u0006\u0002\u0010\bBË\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0003\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0011\u0012\b\b\u0002\u0010\u001e\u001a\u00020\u001f\u0012\b\b\u0002\u0010 \u001a\u00020!\u0012\b\b\u0002\u0010\"\u001a\u00020\u0017\u0012\b\b\u0002\u0010#\u001a\u00020\u0017¢\u0006\u0002\u0010$J\u0006\u0010-\u001a\u00020\u0011J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0015HÆ\u0003J\t\u00100\u001a\u00020\u0017HÆ\u0003J\t\u00101\u001a\u00020\u0019HÆ\u0003J\t\u00102\u001a\u00020\u0011HÆ\u0003J\t\u00103\u001a\u00020\u0011HÆ\u0003J\t\u00104\u001a\u00020\u0011HÆ\u0003J\t\u00105\u001a\u00020\u0011HÆ\u0003J\t\u00106\u001a\u00020\u001fHÆ\u0003J\t\u00107\u001a\u00020!HÆ\u0003J\t\u00108\u001a\u00020\u0017HÆ\u0003J\t\u00109\u001a\u00020\nHÆ\u0003J\t\u0010:\u001a\u00020\u0017HÆ\u0003J\t\u0010;\u001a\u00020\u0003HÆ\u0003J\u000b\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010=\u001a\u00020\u000eHÆ\u0003J\t\u0010>\u001a\u00020\u000eHÆ\u0003J\t\u0010?\u001a\u00020\u0011HÆ\u0003J\t\u0010@\u001a\u00020\u0011HÆ\u0003J\t\u0010A\u001a\u00020\u0011HÆ\u0003JÓ\u0001\u0010B\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0003\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00112\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u00112\b\b\u0002\u0010\u001d\u001a\u00020\u00112\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00172\b\b\u0002\u0010#\u001a\u00020\u0017HÆ\u0001J\u0013\u0010C\u001a\u00020\u001f2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010D\u001a\u00020\u001fJ\t\u0010E\u001a\u00020\u0017HÖ\u0001J\u000e\u0010F\u001a\u00020G2\u0006\u0010\u001a\u001a\u00020\u0011J\u000e\u0010H\u001a\u00020G2\u0006\u0010\u0012\u001a\u00020\u0011J\u0016\u0010H\u001a\u00020G2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011J\b\u0010I\u001a\u00020\u0003H\u0016R\u0012\u0010\u001a\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0014\u001a\u00020\u00158\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001e\u001a\u00020\u001f8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\u00020\u00178\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010'\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0011\u0010)\u001a\u00020\u001f8F¢\u0006\u0006\u001a\u0004\b)\u0010(R\u0012\u0010\u001b\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u001a\u00020!8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\"\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010,R\u0012\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00020\u00118\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Landroidx/work/impl/model/WorkSpec;", "", "id", "", "workerClassName_", "(Ljava/lang/String;Ljava/lang/String;)V", "newId", "other", "(Ljava/lang/String;Landroidx/work/impl/model/WorkSpec;)V", "state", "Landroidx/work/WorkInfo$State;", "workerClassName", "inputMergerClassName", "input", "Landroidx/work/Data;", "output", "initialDelay", "", "intervalDuration", "flexDuration", "constraints", "Landroidx/work/Constraints;", "runAttemptCount", "", "backoffPolicy", "Landroidx/work/BackoffPolicy;", "backoffDelayDuration", "lastEnqueueTime", "minimumRetentionDuration", "scheduleRequestedAt", "expedited", "", "outOfQuotaPolicy", "Landroidx/work/OutOfQuotaPolicy;", "periodCount", "generation", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Ljava/lang/String;Ljava/lang/String;Landroidx/work/Data;Landroidx/work/Data;JJJLandroidx/work/Constraints;ILandroidx/work/BackoffPolicy;JJJJZLandroidx/work/OutOfQuotaPolicy;II)V", "getGeneration", "()I", "isBackedOff", "()Z", "isPeriodic", "getPeriodCount", "setPeriodCount", "(I)V", "calculateNextRunTime", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "hasConstraints", "hashCode", "setBackoffDelayDuration", "", "setPeriodic", "toString", "Companion", "IdAndState", "WorkInfoPojo", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: WorkSpec.kt */
public final class WorkSpec {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final long SCHEDULE_NOT_REQUESTED_YET = -1;
    private static final String TAG;
    public static final Function<List<WorkInfoPojo>, List<WorkInfo>> WORK_INFO_MAPPER = new WorkSpec$$ExternalSyntheticLambda0();
    public long backoffDelayDuration;
    public BackoffPolicy backoffPolicy;
    public Constraints constraints;
    public boolean expedited;
    public long flexDuration;
    private final int generation;
    public final String id;
    public long initialDelay;
    public Data input;
    public String inputMergerClassName;
    public long intervalDuration;
    public long lastEnqueueTime;
    public long minimumRetentionDuration;
    public OutOfQuotaPolicy outOfQuotaPolicy;
    public Data output;
    private int periodCount;
    public int runAttemptCount;
    public long scheduleRequestedAt;
    public WorkInfo.State state;
    public String workerClassName;

    public static /* synthetic */ WorkSpec copy$default(WorkSpec workSpec, String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints2, int i, BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3, int i4, Object obj) {
        WorkSpec workSpec2 = workSpec;
        int i5 = i4;
        return workSpec.copy((i5 & 1) != 0 ? workSpec2.id : str, (i5 & 2) != 0 ? workSpec2.state : state2, (i5 & 4) != 0 ? workSpec2.workerClassName : str2, (i5 & 8) != 0 ? workSpec2.inputMergerClassName : str3, (i5 & 16) != 0 ? workSpec2.input : data, (i5 & 32) != 0 ? workSpec2.output : data2, (i5 & 64) != 0 ? workSpec2.initialDelay : j, (i5 & 128) != 0 ? workSpec2.intervalDuration : j2, (i5 & 256) != 0 ? workSpec2.flexDuration : j3, (i5 & 512) != 0 ? workSpec2.constraints : constraints2, (i5 & 1024) != 0 ? workSpec2.runAttemptCount : i, (i5 & 2048) != 0 ? workSpec2.backoffPolicy : backoffPolicy2, (i5 & 4096) != 0 ? workSpec2.backoffDelayDuration : j4, (i5 & 8192) != 0 ? workSpec2.lastEnqueueTime : j5, (i5 & 16384) != 0 ? workSpec2.minimumRetentionDuration : j6, (i5 & 32768) != 0 ? workSpec2.scheduleRequestedAt : j7, (i5 & 65536) != 0 ? workSpec2.expedited : z, (131072 & i5) != 0 ? workSpec2.outOfQuotaPolicy : outOfQuotaPolicy2, (i5 & 262144) != 0 ? workSpec2.periodCount : i2, (i5 & 524288) != 0 ? workSpec2.generation : i3);
    }

    public final String component1() {
        return this.id;
    }

    public final Constraints component10() {
        return this.constraints;
    }

    public final int component11() {
        return this.runAttemptCount;
    }

    public final BackoffPolicy component12() {
        return this.backoffPolicy;
    }

    public final long component13() {
        return this.backoffDelayDuration;
    }

    public final long component14() {
        return this.lastEnqueueTime;
    }

    public final long component15() {
        return this.minimumRetentionDuration;
    }

    public final long component16() {
        return this.scheduleRequestedAt;
    }

    public final boolean component17() {
        return this.expedited;
    }

    public final OutOfQuotaPolicy component18() {
        return this.outOfQuotaPolicy;
    }

    public final int component19() {
        return this.periodCount;
    }

    public final WorkInfo.State component2() {
        return this.state;
    }

    public final int component20() {
        return this.generation;
    }

    public final String component3() {
        return this.workerClassName;
    }

    public final String component4() {
        return this.inputMergerClassName;
    }

    public final Data component5() {
        return this.input;
    }

    public final Data component6() {
        return this.output;
    }

    public final long component7() {
        return this.initialDelay;
    }

    public final long component8() {
        return this.intervalDuration;
    }

    public final long component9() {
        return this.flexDuration;
    }

    public final WorkSpec copy(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints2, int i, BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3) {
        String str4 = str;
        Intrinsics.checkNotNullParameter(str4, "id");
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(str2, "workerClassName");
        Intrinsics.checkNotNullParameter(data, "input");
        Intrinsics.checkNotNullParameter(data2, "output");
        Intrinsics.checkNotNullParameter(constraints2, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy2, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy2, "outOfQuotaPolicy");
        return new WorkSpec(str4, state2, str2, str3, data, data2, j, j2, j3, constraints2, i, backoffPolicy2, j4, j5, j6, j7, z, outOfQuotaPolicy2, i2, i3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WorkSpec)) {
            return false;
        }
        WorkSpec workSpec = (WorkSpec) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) workSpec.id) && this.state == workSpec.state && Intrinsics.areEqual((Object) this.workerClassName, (Object) workSpec.workerClassName) && Intrinsics.areEqual((Object) this.inputMergerClassName, (Object) workSpec.inputMergerClassName) && Intrinsics.areEqual((Object) this.input, (Object) workSpec.input) && Intrinsics.areEqual((Object) this.output, (Object) workSpec.output) && this.initialDelay == workSpec.initialDelay && this.intervalDuration == workSpec.intervalDuration && this.flexDuration == workSpec.flexDuration && Intrinsics.areEqual((Object) this.constraints, (Object) workSpec.constraints) && this.runAttemptCount == workSpec.runAttemptCount && this.backoffPolicy == workSpec.backoffPolicy && this.backoffDelayDuration == workSpec.backoffDelayDuration && this.lastEnqueueTime == workSpec.lastEnqueueTime && this.minimumRetentionDuration == workSpec.minimumRetentionDuration && this.scheduleRequestedAt == workSpec.scheduleRequestedAt && this.expedited == workSpec.expedited && this.outOfQuotaPolicy == workSpec.outOfQuotaPolicy && this.periodCount == workSpec.periodCount && this.generation == workSpec.generation;
    }

    public int hashCode() {
        int hashCode = ((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.workerClassName.hashCode()) * 31;
        String str = this.inputMergerClassName;
        int hashCode2 = (((((((((((((((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.input.hashCode()) * 31) + this.output.hashCode()) * 31) + Long.hashCode(this.initialDelay)) * 31) + Long.hashCode(this.intervalDuration)) * 31) + Long.hashCode(this.flexDuration)) * 31) + this.constraints.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + this.backoffPolicy.hashCode()) * 31) + Long.hashCode(this.backoffDelayDuration)) * 31) + Long.hashCode(this.lastEnqueueTime)) * 31) + Long.hashCode(this.minimumRetentionDuration)) * 31) + Long.hashCode(this.scheduleRequestedAt)) * 31;
        boolean z = this.expedited;
        if (z) {
            z = true;
        }
        return ((((((hashCode2 + (z ? 1 : 0)) * 31) + this.outOfQuotaPolicy.hashCode()) * 31) + Integer.hashCode(this.periodCount)) * 31) + Integer.hashCode(this.generation);
    }

    public WorkSpec(String str, WorkInfo.State state2, String str2, String str3, Data data, Data data2, long j, long j2, long j3, Constraints constraints2, int i, BackoffPolicy backoffPolicy2, long j4, long j5, long j6, long j7, boolean z, OutOfQuotaPolicy outOfQuotaPolicy2, int i2, int i3) {
        Data data3 = data2;
        Constraints constraints3 = constraints2;
        BackoffPolicy backoffPolicy3 = backoffPolicy2;
        OutOfQuotaPolicy outOfQuotaPolicy3 = outOfQuotaPolicy2;
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(state2, "state");
        Intrinsics.checkNotNullParameter(str2, "workerClassName");
        Intrinsics.checkNotNullParameter(data, "input");
        Intrinsics.checkNotNullParameter(data3, "output");
        Intrinsics.checkNotNullParameter(constraints3, "constraints");
        Intrinsics.checkNotNullParameter(backoffPolicy3, "backoffPolicy");
        Intrinsics.checkNotNullParameter(outOfQuotaPolicy3, "outOfQuotaPolicy");
        this.id = str;
        this.state = state2;
        this.workerClassName = str2;
        this.inputMergerClassName = str3;
        this.input = data;
        this.output = data3;
        this.initialDelay = j;
        this.intervalDuration = j2;
        this.flexDuration = j3;
        this.constraints = constraints3;
        this.runAttemptCount = i;
        this.backoffPolicy = backoffPolicy3;
        this.backoffDelayDuration = j4;
        this.lastEnqueueTime = j5;
        this.minimumRetentionDuration = j6;
        this.scheduleRequestedAt = j7;
        this.expedited = z;
        this.outOfQuotaPolicy = outOfQuotaPolicy3;
        this.periodCount = i2;
        this.generation = i3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ WorkSpec(java.lang.String r31, androidx.work.WorkInfo.State r32, java.lang.String r33, java.lang.String r34, androidx.work.Data r35, androidx.work.Data r36, long r37, long r39, long r41, androidx.work.Constraints r43, int r44, androidx.work.BackoffPolicy r45, long r46, long r48, long r50, long r52, boolean r54, androidx.work.OutOfQuotaPolicy r55, int r56, int r57, int r58, kotlin.jvm.internal.DefaultConstructorMarker r59) {
        /*
            r30 = this;
            r0 = r58
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            androidx.work.WorkInfo$State r1 = androidx.work.WorkInfo.State.ENQUEUED
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r32
        L_0x000c:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0013
            r1 = 0
            r6 = r1
            goto L_0x0015
        L_0x0013:
            r6 = r34
        L_0x0015:
            r1 = r0 & 16
            java.lang.String r2 = "EMPTY"
            if (r1 == 0) goto L_0x0022
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r7 = r1
            goto L_0x0024
        L_0x0022:
            r7 = r35
        L_0x0024:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x002f
            androidx.work.Data r1 = androidx.work.Data.EMPTY
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r8 = r1
            goto L_0x0031
        L_0x002f:
            r8 = r36
        L_0x0031:
            r1 = r0 & 64
            r2 = 0
            if (r1 == 0) goto L_0x0039
            r9 = r2
            goto L_0x003b
        L_0x0039:
            r9 = r37
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r39
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0049
            r13 = r2
            goto L_0x004b
        L_0x0049:
            r13 = r41
        L_0x004b:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0053
            androidx.work.Constraints r1 = androidx.work.Constraints.NONE
            r15 = r1
            goto L_0x0055
        L_0x0053:
            r15 = r43
        L_0x0055:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r5 = 0
            if (r1 == 0) goto L_0x005d
            r16 = r5
            goto L_0x005f
        L_0x005d:
            r16 = r44
        L_0x005f:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0068
            androidx.work.BackoffPolicy r1 = androidx.work.BackoffPolicy.EXPONENTIAL
            r17 = r1
            goto L_0x006a
        L_0x0068:
            r17 = r45
        L_0x006a:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0071
            r18 = 30000(0x7530, double:1.4822E-319)
            goto L_0x0073
        L_0x0071:
            r18 = r46
        L_0x0073:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007a
            r20 = r2
            goto L_0x007c
        L_0x007a:
            r20 = r48
        L_0x007c:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0083
            r22 = r2
            goto L_0x0085
        L_0x0083:
            r22 = r50
        L_0x0085:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0090
            r1 = -1
            r24 = r1
            goto L_0x0092
        L_0x0090:
            r24 = r52
        L_0x0092:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009a
            r26 = r5
            goto L_0x009c
        L_0x009a:
            r26 = r54
        L_0x009c:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a6
            androidx.work.OutOfQuotaPolicy r1 = androidx.work.OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST
            r27 = r1
            goto L_0x00a8
        L_0x00a6:
            r27 = r55
        L_0x00a8:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b0
            r28 = r5
            goto L_0x00b2
        L_0x00b0:
            r28 = r56
        L_0x00b2:
            r1 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00ba
            r29 = r5
            goto L_0x00bc
        L_0x00ba:
            r29 = r57
        L_0x00bc:
            r2 = r30
            r3 = r31
            r5 = r33
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24, r26, r27, r28, r29)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.WorkInfo$State, java.lang.String, java.lang.String, androidx.work.Data, androidx.work.Data, long, long, long, androidx.work.Constraints, int, androidx.work.BackoffPolicy, long, long, long, long, boolean, androidx.work.OutOfQuotaPolicy, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final int getPeriodCount() {
        return this.periodCount;
    }

    public final void setPeriodCount(int i) {
        this.periodCount = i;
    }

    public final int getGeneration() {
        return this.generation;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public WorkSpec(String str, String str2) {
        this(str, (WorkInfo.State) null, str2, (String) null, (Data) null, (Data) null, 0, 0, 0, (Constraints) null, 0, (BackoffPolicy) null, 0, 0, 0, 0, false, (OutOfQuotaPolicy) null, 0, 0, 1048570, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "workerClassName_");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public WorkSpec(java.lang.String r34, androidx.work.impl.model.WorkSpec r35) {
        /*
            r33 = this;
            r0 = r35
            r1 = r33
            r2 = r34
            java.lang.String r3 = "newId"
            r4 = r34
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.String r3 = "other"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r3)
            java.lang.String r4 = r0.workerClassName
            androidx.work.WorkInfo$State r3 = r0.state
            java.lang.String r5 = r0.inputMergerClassName
            androidx.work.Data r7 = new androidx.work.Data
            r6 = r7
            androidx.work.Data r8 = r0.input
            r7.<init>((androidx.work.Data) r8)
            androidx.work.Data r8 = new androidx.work.Data
            r7 = r8
            androidx.work.Data r9 = r0.output
            r8.<init>((androidx.work.Data) r9)
            long r8 = r0.initialDelay
            long r10 = r0.intervalDuration
            long r12 = r0.flexDuration
            androidx.work.Constraints r15 = new androidx.work.Constraints
            r14 = r15
            r31 = r1
            androidx.work.Constraints r1 = r0.constraints
            r15.<init>(r1)
            int r15 = r0.runAttemptCount
            androidx.work.BackoffPolicy r1 = r0.backoffPolicy
            r16 = r1
            r32 = r2
            long r1 = r0.backoffDelayDuration
            r17 = r1
            long r1 = r0.lastEnqueueTime
            r19 = r1
            long r1 = r0.minimumRetentionDuration
            r21 = r1
            long r1 = r0.scheduleRequestedAt
            r23 = r1
            boolean r1 = r0.expedited
            r25 = r1
            androidx.work.OutOfQuotaPolicy r1 = r0.outOfQuotaPolicy
            r26 = r1
            int r0 = r0.periodCount
            r27 = r0
            r28 = 0
            r29 = 524288(0x80000, float:7.34684E-40)
            r30 = 0
            r1 = r31
            r2 = r32
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r10, r12, r14, r15, r16, r17, r19, r21, r23, r25, r26, r27, r28, r29, r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpec.<init>(java.lang.String, androidx.work.impl.model.WorkSpec):void");
    }

    public final void setBackoffDelayDuration(long j) {
        if (j > WorkRequest.MAX_BACKOFF_MILLIS) {
            Logger.get().warning(TAG, "Backoff delay duration exceeds maximum value");
        }
        if (j < 10000) {
            Logger.get().warning(TAG, "Backoff delay duration less than minimum value");
        }
        this.backoffDelayDuration = RangesKt.coerceIn(j, 10000, (long) WorkRequest.MAX_BACKOFF_MILLIS);
    }

    public final boolean isPeriodic() {
        return this.intervalDuration != 0;
    }

    public final boolean isBackedOff() {
        return this.state == WorkInfo.State.ENQUEUED && this.runAttemptCount > 0;
    }

    public final void setPeriodic(long j) {
        if (j < 900000) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        setPeriodic(RangesKt.coerceAtLeast(j, 900000), RangesKt.coerceAtLeast(j, 900000));
    }

    public final void setPeriodic(long j, long j2) {
        if (j < 900000) {
            Logger.get().warning(TAG, "Interval duration lesser than minimum allowed value; Changed to 900000");
        }
        this.intervalDuration = RangesKt.coerceAtLeast(j, 900000);
        if (j2 < 300000) {
            Logger.get().warning(TAG, "Flex duration lesser than minimum allowed value; Changed to 300000");
        }
        if (j2 > this.intervalDuration) {
            Logger.get().warning(TAG, "Flex duration greater than interval duration; Changed to " + j);
        }
        this.flexDuration = RangesKt.coerceIn(j2, 300000, this.intervalDuration);
    }

    public final long calculateNextRunTime() {
        boolean z = false;
        if (isBackedOff()) {
            if (this.backoffPolicy == BackoffPolicy.LINEAR) {
                z = true;
            }
            return this.lastEnqueueTime + RangesKt.coerceAtMost(z ? this.backoffDelayDuration * ((long) this.runAttemptCount) : (long) Math.scalb((float) this.backoffDelayDuration, this.runAttemptCount - 1), (long) WorkRequest.MAX_BACKOFF_MILLIS);
        }
        long j = 0;
        if (isPeriodic()) {
            int i = this.periodCount;
            long j2 = this.lastEnqueueTime;
            if (i == 0) {
                j2 += this.initialDelay;
            }
            long j3 = this.flexDuration;
            long j4 = this.intervalDuration;
            if (j3 != j4) {
                z = true;
            }
            if (z) {
                if (i == 0) {
                    j = ((long) -1) * j3;
                }
                j2 += j4;
            } else if (i != 0) {
                j = j4;
            }
            return j2 + j;
        }
        long j5 = this.lastEnqueueTime;
        if (j5 == 0) {
            j5 = System.currentTimeMillis();
        }
        return this.initialDelay + j5;
    }

    public final boolean hasConstraints() {
        return !Intrinsics.areEqual((Object) Constraints.NONE, (Object) this.constraints);
    }

    public String toString() {
        return "{WorkSpec: " + this.id + '}';
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\t\u0010\b\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Landroidx/work/impl/model/WorkSpec$IdAndState;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkSpec.kt */
    public static final class IdAndState {
        public String id;
        public WorkInfo.State state;

        public static /* synthetic */ IdAndState copy$default(IdAndState idAndState, String str, WorkInfo.State state2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = idAndState.id;
            }
            if ((i & 2) != 0) {
                state2 = idAndState.state;
            }
            return idAndState.copy(str, state2);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final IdAndState copy(String str, WorkInfo.State state2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state2, "state");
            return new IdAndState(str, state2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof IdAndState)) {
                return false;
            }
            IdAndState idAndState = (IdAndState) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) idAndState.id) && this.state == idAndState.state;
        }

        public int hashCode() {
            return (this.id.hashCode() * 31) + this.state.hashCode();
        }

        public String toString() {
            return "IdAndState(id=" + this.id + ", state=" + this.state + ')';
        }

        public IdAndState(String str, WorkInfo.State state2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state2, "state");
            this.id = str;
            this.state = state2;
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\"\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\b\u0018\u00002\u00020\u0001BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f¢\u0006\u0002\u0010\u000eJ\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0007HÆ\u0003J\t\u0010)\u001a\u00020\tHÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\u000f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u00030\fHÆ\u0003J\u000f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0003J[\u0010-\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u000e\b\u0002\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\fHÆ\u0001J\u0013\u0010.\u001a\u00020/2\b\u00100\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00101\u001a\u00020\tHÖ\u0001J\t\u00102\u001a\u00020\u0003HÖ\u0001J\u0006\u00103\u001a\u000204R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00070\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u001fR\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001c¨\u00065"}, d2 = {"Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "", "id", "", "state", "Landroidx/work/WorkInfo$State;", "output", "Landroidx/work/Data;", "runAttemptCount", "", "generation", "tags", "", "progress", "(Ljava/lang/String;Landroidx/work/WorkInfo$State;Landroidx/work/Data;IILjava/util/List;Ljava/util/List;)V", "getGeneration", "()I", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOutput", "()Landroidx/work/Data;", "setOutput", "(Landroidx/work/Data;)V", "getProgress", "()Ljava/util/List;", "setProgress", "(Ljava/util/List;)V", "getRunAttemptCount", "setRunAttemptCount", "(I)V", "getState", "()Landroidx/work/WorkInfo$State;", "setState", "(Landroidx/work/WorkInfo$State;)V", "getTags", "setTags", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "toWorkInfo", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkSpec.kt */
    public static final class WorkInfoPojo {
        private final int generation;
        private String id;
        private Data output;
        private List<Data> progress;
        private int runAttemptCount;
        private WorkInfo.State state;
        private List<String> tags;

        public static /* synthetic */ WorkInfoPojo copy$default(WorkInfoPojo workInfoPojo, String str, WorkInfo.State state2, Data data, int i, int i2, List<String> list, List<Data> list2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                str = workInfoPojo.id;
            }
            if ((i3 & 2) != 0) {
                state2 = workInfoPojo.state;
            }
            WorkInfo.State state3 = state2;
            if ((i3 & 4) != 0) {
                data = workInfoPojo.output;
            }
            Data data2 = data;
            if ((i3 & 8) != 0) {
                i = workInfoPojo.runAttemptCount;
            }
            int i4 = i;
            if ((i3 & 16) != 0) {
                i2 = workInfoPojo.generation;
            }
            int i5 = i2;
            if ((i3 & 32) != 0) {
                list = workInfoPojo.tags;
            }
            List<String> list3 = list;
            if ((i3 & 64) != 0) {
                list2 = workInfoPojo.progress;
            }
            return workInfoPojo.copy(str, state3, data2, i4, i5, list3, list2);
        }

        public final String component1() {
            return this.id;
        }

        public final WorkInfo.State component2() {
            return this.state;
        }

        public final Data component3() {
            return this.output;
        }

        public final int component4() {
            return this.runAttemptCount;
        }

        public final int component5() {
            return this.generation;
        }

        public final List<String> component6() {
            return this.tags;
        }

        public final List<Data> component7() {
            return this.progress;
        }

        public final WorkInfoPojo copy(String str, WorkInfo.State state2, Data data, int i, int i2, List<String> list, List<Data> list2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state2, "state");
            Intrinsics.checkNotNullParameter(data, "output");
            Intrinsics.checkNotNullParameter(list, "tags");
            List<Data> list3 = list2;
            Intrinsics.checkNotNullParameter(list3, NotificationCompat.CATEGORY_PROGRESS);
            return new WorkInfoPojo(str, state2, data, i, i2, list, list3);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof WorkInfoPojo)) {
                return false;
            }
            WorkInfoPojo workInfoPojo = (WorkInfoPojo) obj;
            return Intrinsics.areEqual((Object) this.id, (Object) workInfoPojo.id) && this.state == workInfoPojo.state && Intrinsics.areEqual((Object) this.output, (Object) workInfoPojo.output) && this.runAttemptCount == workInfoPojo.runAttemptCount && this.generation == workInfoPojo.generation && Intrinsics.areEqual((Object) this.tags, (Object) workInfoPojo.tags) && Intrinsics.areEqual((Object) this.progress, (Object) workInfoPojo.progress);
        }

        public int hashCode() {
            return (((((((((((this.id.hashCode() * 31) + this.state.hashCode()) * 31) + this.output.hashCode()) * 31) + Integer.hashCode(this.runAttemptCount)) * 31) + Integer.hashCode(this.generation)) * 31) + this.tags.hashCode()) * 31) + this.progress.hashCode();
        }

        public String toString() {
            return "WorkInfoPojo(id=" + this.id + ", state=" + this.state + ", output=" + this.output + ", runAttemptCount=" + this.runAttemptCount + ", generation=" + this.generation + ", tags=" + this.tags + ", progress=" + this.progress + ')';
        }

        public WorkInfoPojo(String str, WorkInfo.State state2, Data data, int i, int i2, List<String> list, List<Data> list2) {
            Intrinsics.checkNotNullParameter(str, "id");
            Intrinsics.checkNotNullParameter(state2, "state");
            Intrinsics.checkNotNullParameter(data, "output");
            Intrinsics.checkNotNullParameter(list, "tags");
            Intrinsics.checkNotNullParameter(list2, NotificationCompat.CATEGORY_PROGRESS);
            this.id = str;
            this.state = state2;
            this.output = data;
            this.runAttemptCount = i;
            this.generation = i2;
            this.tags = list;
            this.progress = list2;
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.id = str;
        }

        public final WorkInfo.State getState() {
            return this.state;
        }

        public final void setState(WorkInfo.State state2) {
            Intrinsics.checkNotNullParameter(state2, "<set-?>");
            this.state = state2;
        }

        public final Data getOutput() {
            return this.output;
        }

        public final void setOutput(Data data) {
            Intrinsics.checkNotNullParameter(data, "<set-?>");
            this.output = data;
        }

        public final int getRunAttemptCount() {
            return this.runAttemptCount;
        }

        public final void setRunAttemptCount(int i) {
            this.runAttemptCount = i;
        }

        public final int getGeneration() {
            return this.generation;
        }

        public final List<String> getTags() {
            return this.tags;
        }

        public final void setTags(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.tags = list;
        }

        public final List<Data> getProgress() {
            return this.progress;
        }

        public final void setProgress(List<Data> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.progress = list;
        }

        public final WorkInfo toWorkInfo() {
            return new WorkInfo(UUID.fromString(this.id), this.state, this.output, this.tags, this.progress.isEmpty() ^ true ? this.progress.get(0) : Data.EMPTY, this.runAttemptCount, this.generation);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\t0\b8\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Landroidx/work/impl/model/WorkSpec$Companion;", "", "()V", "SCHEDULE_NOT_REQUESTED_YET", "", "TAG", "", "WORK_INFO_MAPPER", "Landroidx/arch/core/util/Function;", "", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "Landroidx/work/WorkInfo;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: WorkSpec.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        String tagWithPrefix = Logger.tagWithPrefix("WorkSpec");
        Intrinsics.checkNotNullExpressionValue(tagWithPrefix, "tagWithPrefix(\"WorkSpec\")");
        TAG = tagWithPrefix;
    }

    /* access modifiers changed from: private */
    public static final List WORK_INFO_MAPPER$lambda$1(List list) {
        if (list == null) {
            return null;
        }
        Iterable<WorkInfoPojo> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (WorkInfoPojo workInfo : iterable) {
            arrayList.add(workInfo.toWorkInfo());
        }
        return (List) arrayList;
    }
}
