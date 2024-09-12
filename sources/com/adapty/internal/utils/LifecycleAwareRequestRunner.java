package com.adapty.internal.utils;

import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;
import com.adapty.errors.AdaptyError;
import com.adapty.internal.data.cache.CacheRepository;
import com.adapty.internal.data.cloud.AnalyticsTracker;
import com.adapty.internal.domain.ProfileInteractor;
import com.adapty.internal.utils.LifecycleManager;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.Job;
import org.apache.commons.lang3.time.DateUtils;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\b\u0010\u0015\u001a\u00020\u0013H\u0016J\b\u0010\u0016\u001a\u00020\u0013H\u0016J\u0006\u0010\u0017\u001a\u00020\u0013J5\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\f2\b\b\u0002\u0010\u001a\u001a\u00020\f2\u0010\u0010\u001b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001d0\u001cH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\fH\u0002R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006 "}, d2 = {"Lcom/adapty/internal/utils/LifecycleAwareRequestRunner;", "Lcom/adapty/internal/utils/LifecycleManager$StateCallback;", "lifecycleManager", "Lcom/adapty/internal/utils/LifecycleManager;", "profileInteractor", "Lcom/adapty/internal/domain/ProfileInteractor;", "analyticsTracker", "Lcom/adapty/internal/data/cloud/AnalyticsTracker;", "cacheRepository", "Lcom/adapty/internal/data/cache/CacheRepository;", "(Lcom/adapty/internal/utils/LifecycleManager;Lcom/adapty/internal/domain/ProfileInteractor;Lcom/adapty/internal/data/cloud/AnalyticsTracker;Lcom/adapty/internal/data/cache/CacheRepository;)V", "APP_OPENED_EVENT_MIN_INTERVAL", "", "PERIODIC_REQUEST_INTERVAL", "areRequestsAllowed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "scheduleGetProfileJob", "Lkotlinx/coroutines/Job;", "cancelScheduledRequests", "", "handleAppOpenedEvent", "onGoBackground", "onGoForeground", "restart", "runPeriodically", "initialDelayMillis", "delayMillis", "call", "Lkotlin/Function0;", "Lkotlinx/coroutines/flow/Flow;", "(JJLkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "scheduleGetProfileRequest", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: LifecycleAwareRequestRunner.kt */
public final class LifecycleAwareRequestRunner implements LifecycleManager.StateCallback {
    private final long APP_OPENED_EVENT_MIN_INTERVAL = DateUtils.MILLIS_PER_HOUR;
    private final long PERIODIC_REQUEST_INTERVAL = 60000;
    private final AnalyticsTracker analyticsTracker;
    private final AtomicBoolean areRequestsAllowed;
    private final CacheRepository cacheRepository;
    /* access modifiers changed from: private */
    public final ProfileInteractor profileInteractor;
    private Job scheduleGetProfileJob;

    public LifecycleAwareRequestRunner(LifecycleManager lifecycleManager, ProfileInteractor profileInteractor2, AnalyticsTracker analyticsTracker2, CacheRepository cacheRepository2) {
        Intrinsics.checkNotNullParameter(lifecycleManager, "lifecycleManager");
        Intrinsics.checkNotNullParameter(profileInteractor2, "profileInteractor");
        Intrinsics.checkNotNullParameter(analyticsTracker2, "analyticsTracker");
        Intrinsics.checkNotNullParameter(cacheRepository2, "cacheRepository");
        this.profileInteractor = profileInteractor2;
        this.analyticsTracker = analyticsTracker2;
        this.cacheRepository = cacheRepository2;
        lifecycleManager.stateCallback = this;
        this.areRequestsAllowed = new AtomicBoolean(false);
    }

    public final /* synthetic */ void restart() {
        onGoBackground();
        this.areRequestsAllowed.set(true);
        if (ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.RESUMED)) {
            handleAppOpenedEvent();
            scheduleGetProfileRequest(this.PERIODIC_REQUEST_INTERVAL);
        }
    }

    public /* synthetic */ void onGoForeground() {
        if (this.areRequestsAllowed.get()) {
            handleAppOpenedEvent();
            scheduleGetProfileRequest(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: cancelScheduledRequests */
    public final void onGoBackground() {
        Job job;
        Job job2 = this.scheduleGetProfileJob;
        boolean z = false;
        if (job2 != null && job2.isActive()) {
            z = true;
        }
        if (z && (job = this.scheduleGetProfileJob) != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.scheduleGetProfileJob = null;
    }

    private final void handleAppOpenedEvent() {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.APP_OPENED_EVENT_MIN_INTERVAL;
        long lastAppOpenedTime = elapsedRealtime - this.cacheRepository.getLastAppOpenedTime();
        boolean z = false;
        if (0 <= lastAppOpenedTime && lastAppOpenedTime <= j) {
            z = true;
        }
        if (!z) {
            AnalyticsTracker.DefaultImpls.trackEvent$default(this.analyticsTracker, "app_opened", (Map) null, (Function2) null, new LifecycleAwareRequestRunner$$ExternalSyntheticLambda0(this, elapsedRealtime), 6, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void handleAppOpenedEvent$lambda$0(LifecycleAwareRequestRunner lifecycleAwareRequestRunner, long j, AdaptyError adaptyError) {
        Intrinsics.checkNotNullParameter(lifecycleAwareRequestRunner, "this$0");
        if (adaptyError == null) {
            lifecycleAwareRequestRunner.cacheRepository.saveLastAppOpenedTime(j);
        }
    }

    private final void scheduleGetProfileRequest(long j) {
        this.scheduleGetProfileJob = Intrinsics.checkNotNullParameter(new LifecycleAwareRequestRunner$scheduleGetProfileRequest$1(this, j, (Continuation<? super LifecycleAwareRequestRunner$scheduleGetProfileRequest$1>) null), "block");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x009a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object runPeriodically(long r12, long r14, kotlin.jvm.functions.Function0<? extends kotlinx.coroutines.flow.Flow<?>> r16, kotlin.coroutines.Continuation<? super kotlin.Unit> r17) {
        /*
            r11 = this;
            r0 = r11
            r1 = r12
            r3 = r17
            boolean r4 = r3 instanceof com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$1
            if (r4 == 0) goto L_0x0018
            r4 = r3
            com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$1 r4 = (com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$1) r4
            int r5 = r4.label
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r5 & r6
            if (r5 == 0) goto L_0x0018
            int r3 = r4.label
            int r3 = r3 - r6
            r4.label = r3
            goto L_0x001d
        L_0x0018:
            com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$1 r4 = new com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$1
            r4.<init>(r11, r3)
        L_0x001d:
            java.lang.Object r3 = r4.result
            java.lang.Object r5 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r6 = r4.label
            r7 = 2
            r8 = 1
            if (r6 == 0) goto L_0x004a
            if (r6 == r8) goto L_0x003a
            if (r6 != r7) goto L_0x0032
            kotlin.ResultKt.throwOnFailure(r3)
            goto L_0x009b
        L_0x0032:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003a:
            long r1 = r4.J$0
            java.lang.Object r6 = r4.L$1
            kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
            java.lang.Object r8 = r4.L$0
            com.adapty.internal.utils.LifecycleAwareRequestRunner r8 = (com.adapty.internal.utils.LifecycleAwareRequestRunner) r8
            kotlin.ResultKt.throwOnFailure(r3)
            r9 = r1
            r3 = r6
            goto L_0x0069
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r3)
            r9 = 0
            int r3 = (r1 > r9 ? 1 : (r1 == r9 ? 0 : -1))
            if (r3 <= 0) goto L_0x0065
            r4.L$0 = r0
            r3 = r16
            r4.L$1 = r3
            r9 = r14
            r4.J$0 = r9
            r4.label = r8
            java.lang.Object r1 = kotlinx.coroutines.DelayKt.delay(r12, r4)
            if (r1 != r5) goto L_0x0068
            return r5
        L_0x0065:
            r9 = r14
            r3 = r16
        L_0x0068:
            r8 = r0
        L_0x0069:
            java.lang.Object r1 = r3.invoke()
            kotlinx.coroutines.flow.Flow r1 = (kotlinx.coroutines.flow.Flow) r1
            com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$2 r2 = new com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$2
            r6 = 0
            r12 = r2
            r13 = r9
            r15 = r8
            r16 = r3
            r17 = r6
            r12.<init>(r13, r15, r16, r17)
            kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.onEach(r1, r2)
            com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$3 r2 = new com.adapty.internal.utils.LifecycleAwareRequestRunner$runPeriodically$3
            r3 = 0
            r2.<init>(r3)
            kotlin.jvm.functions.Function3 r2 = (kotlin.jvm.functions.Function3) r2
            kotlinx.coroutines.flow.Flow r1 = kotlinx.coroutines.flow.FlowKt.m2547catch(r1, r2)
            r4.L$0 = r3
            r4.L$1 = r3
            r4.label = r7
            java.lang.Object r1 = kotlinx.coroutines.flow.FlowKt.collect(r1, r4)
            if (r1 != r5) goto L_0x009b
            return r5
        L_0x009b:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.LifecycleAwareRequestRunner.runPeriodically(long, long, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object runPeriodically$default(LifecycleAwareRequestRunner lifecycleAwareRequestRunner, long j, long j2, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            j2 = lifecycleAwareRequestRunner.PERIODIC_REQUEST_INTERVAL;
        }
        return lifecycleAwareRequestRunner.runPeriodically(j, j2, function0, continuation);
    }
}
