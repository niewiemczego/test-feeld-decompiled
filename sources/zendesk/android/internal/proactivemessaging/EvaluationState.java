package zendesk.android.internal.proactivemessaging;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J7\u0010\u001a\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012¨\u0006\""}, d2 = {"Lzendesk/android/internal/proactivemessaging/EvaluationState;", "", "evaluationResults", "", "Lzendesk/android/internal/proactivemessaging/EvaluationResult;", "job", "Lkotlinx/coroutines/Job;", "startTime", "", "remainingSeconds", "(Ljava/util/List;Lkotlinx/coroutines/Job;JJ)V", "getEvaluationResults", "()Ljava/util/List;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "getRemainingSeconds", "()J", "setRemainingSeconds", "(J)V", "getStartTime", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EvaluationState.kt */
public final class EvaluationState {
    private final List<EvaluationResult> evaluationResults;
    private Job job;
    private long remainingSeconds;
    private final long startTime;

    public static /* synthetic */ EvaluationState copy$default(EvaluationState evaluationState, List<EvaluationResult> list, Job job2, long j, long j2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = evaluationState.evaluationResults;
        }
        if ((i & 2) != 0) {
            job2 = evaluationState.job;
        }
        Job job3 = job2;
        if ((i & 4) != 0) {
            j = evaluationState.startTime;
        }
        long j3 = j;
        if ((i & 8) != 0) {
            j2 = evaluationState.remainingSeconds;
        }
        return evaluationState.copy(list, job3, j3, j2);
    }

    public final List<EvaluationResult> component1() {
        return this.evaluationResults;
    }

    public final Job component2() {
        return this.job;
    }

    public final long component3() {
        return this.startTime;
    }

    public final long component4() {
        return this.remainingSeconds;
    }

    public final EvaluationState copy(List<EvaluationResult> list, Job job2, long j, long j2) {
        Intrinsics.checkNotNullParameter(list, "evaluationResults");
        Intrinsics.checkNotNullParameter(job2, "job");
        return new EvaluationState(list, job2, j, j2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof EvaluationState)) {
            return false;
        }
        EvaluationState evaluationState = (EvaluationState) obj;
        return Intrinsics.areEqual((Object) this.evaluationResults, (Object) evaluationState.evaluationResults) && Intrinsics.areEqual((Object) this.job, (Object) evaluationState.job) && this.startTime == evaluationState.startTime && this.remainingSeconds == evaluationState.remainingSeconds;
    }

    public int hashCode() {
        return (((((this.evaluationResults.hashCode() * 31) + this.job.hashCode()) * 31) + Long.hashCode(this.startTime)) * 31) + Long.hashCode(this.remainingSeconds);
    }

    public String toString() {
        return "EvaluationState(evaluationResults=" + this.evaluationResults + ", job=" + this.job + ", startTime=" + this.startTime + ", remainingSeconds=" + this.remainingSeconds + ')';
    }

    public EvaluationState(List<EvaluationResult> list, Job job2, long j, long j2) {
        Intrinsics.checkNotNullParameter(list, "evaluationResults");
        Intrinsics.checkNotNullParameter(job2, "job");
        this.evaluationResults = list;
        this.job = job2;
        this.startTime = j;
        this.remainingSeconds = j2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ EvaluationState(List list, Job job2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, job2, j, (i & 8) != 0 ? -1 : j2);
    }

    public final List<EvaluationResult> getEvaluationResults() {
        return this.evaluationResults;
    }

    public final Job getJob() {
        return this.job;
    }

    public final void setJob(Job job2) {
        Intrinsics.checkNotNullParameter(job2, "<set-?>");
        this.job = job2;
    }

    public final long getStartTime() {
        return this.startTime;
    }

    public final long getRemainingSeconds() {
        return this.remainingSeconds;
    }

    public final void setRemainingSeconds(long j) {
        this.remainingSeconds = j;
    }
}
