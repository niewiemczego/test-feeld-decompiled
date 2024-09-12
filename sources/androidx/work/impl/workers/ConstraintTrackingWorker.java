package androidx.work.impl.workers;

import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.Logger;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkManagerImpl;
import androidx.work.impl.constraints.WorkConstraintsCallback;
import androidx.work.impl.constraints.WorkConstraintsTrackerImpl;
import androidx.work.impl.constraints.trackers.Trackers;
import androidx.work.impl.model.WorkSpec;
import androidx.work.impl.model.WorkSpecDao;
import androidx.work.impl.utils.futures.SettableFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\u0016\u0010\u0019\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0015H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0002J\u000e\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001dH\u0016R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R$\u0010\u000b\u001a\u0004\u0018\u00010\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u00018G@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR2\u0010\u000e\u001a&\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010 \u0011*\u0012\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0018\u00010\u000f0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Landroidx/work/impl/workers/ConstraintTrackingWorker;", "Landroidx/work/ListenableWorker;", "Landroidx/work/impl/constraints/WorkConstraintsCallback;", "appContext", "Landroid/content/Context;", "workerParameters", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "areConstraintsUnmet", "", "<set-?>", "delegate", "getDelegate", "()Landroidx/work/ListenableWorker;", "future", "Landroidx/work/impl/utils/futures/SettableFuture;", "Landroidx/work/ListenableWorker$Result;", "kotlin.jvm.PlatformType", "lock", "", "onAllConstraintsMet", "", "workSpecs", "", "Landroidx/work/impl/model/WorkSpec;", "onAllConstraintsNotMet", "onStopped", "setupAndRunConstraintTrackingWork", "startWork", "Lcom/google/common/util/concurrent/ListenableFuture;", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstraintTrackingWorker.kt */
public final class ConstraintTrackingWorker extends ListenableWorker implements WorkConstraintsCallback {
    private volatile boolean areConstraintsUnmet;
    private ListenableWorker delegate;
    private final SettableFuture<ListenableWorker.Result> future = SettableFuture.create();
    private final Object lock = new Object();
    private final WorkerParameters workerParameters;

    public void onAllConstraintsMet(List<WorkSpec> list) {
        Intrinsics.checkNotNullParameter(list, "workSpecs");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters2) {
        super(context, workerParameters2);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters2, "workerParameters");
        this.workerParameters = workerParameters2;
    }

    public final ListenableWorker getDelegate() {
        return this.delegate;
    }

    /* access modifiers changed from: private */
    public static final void startWork$lambda$0(ConstraintTrackingWorker constraintTrackingWorker) {
        Intrinsics.checkNotNullParameter(constraintTrackingWorker, "this$0");
        constraintTrackingWorker.setupAndRunConstraintTrackingWork();
    }

    public ListenableFuture<ListenableWorker.Result> startWork() {
        getBackgroundExecutor().execute(new ConstraintTrackingWorker$$ExternalSyntheticLambda0(this));
        SettableFuture<ListenableWorker.Result> settableFuture = this.future;
        Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
        return settableFuture;
    }

    private final void setupAndRunConstraintTrackingWork() {
        if (!this.future.isCancelled()) {
            String string = getInputData().getString(ConstraintTrackingWorkerKt.ARGUMENT_CLASS_NAME);
            Logger logger = Logger.get();
            Intrinsics.checkNotNullExpressionValue(logger, "get()");
            CharSequence charSequence = string;
            if (charSequence == null || charSequence.length() == 0) {
                logger.error(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                SettableFuture<ListenableWorker.Result> settableFuture = this.future;
                Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
                boolean unused = ConstraintTrackingWorkerKt.setFailed(settableFuture);
                return;
            }
            ListenableWorker createWorkerWithDefaultFallback = getWorkerFactory().createWorkerWithDefaultFallback(getApplicationContext(), string, this.workerParameters);
            this.delegate = createWorkerWithDefaultFallback;
            if (createWorkerWithDefaultFallback == null) {
                logger.debug(ConstraintTrackingWorkerKt.TAG, "No worker to delegate to.");
                SettableFuture<ListenableWorker.Result> settableFuture2 = this.future;
                Intrinsics.checkNotNullExpressionValue(settableFuture2, "future");
                boolean unused2 = ConstraintTrackingWorkerKt.setFailed(settableFuture2);
                return;
            }
            WorkManagerImpl instance = WorkManagerImpl.getInstance(getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(applicationContext)");
            WorkSpecDao workSpecDao = instance.getWorkDatabase().workSpecDao();
            String uuid = getId().toString();
            Intrinsics.checkNotNullExpressionValue(uuid, "id.toString()");
            WorkSpec workSpec = workSpecDao.getWorkSpec(uuid);
            if (workSpec == null) {
                SettableFuture<ListenableWorker.Result> settableFuture3 = this.future;
                Intrinsics.checkNotNullExpressionValue(settableFuture3, "future");
                boolean unused3 = ConstraintTrackingWorkerKt.setFailed(settableFuture3);
                return;
            }
            Trackers trackers = instance.getTrackers();
            Intrinsics.checkNotNullExpressionValue(trackers, "workManagerImpl.trackers");
            WorkConstraintsTrackerImpl workConstraintsTrackerImpl = new WorkConstraintsTrackerImpl(trackers, (WorkConstraintsCallback) this);
            workConstraintsTrackerImpl.replace(CollectionsKt.listOf(workSpec));
            String uuid2 = getId().toString();
            Intrinsics.checkNotNullExpressionValue(uuid2, "id.toString()");
            if (workConstraintsTrackerImpl.areAllConstraintsMet(uuid2)) {
                logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints met for delegate " + string);
                try {
                    ListenableWorker listenableWorker = this.delegate;
                    Intrinsics.checkNotNull(listenableWorker);
                    ListenableFuture<ListenableWorker.Result> startWork = listenableWorker.startWork();
                    Intrinsics.checkNotNullExpressionValue(startWork, "delegate!!.startWork()");
                    startWork.addListener(new ConstraintTrackingWorker$$ExternalSyntheticLambda1(this, startWork), getBackgroundExecutor());
                } catch (Throwable th) {
                    logger.debug(ConstraintTrackingWorkerKt.TAG, "Delegated worker " + string + " threw exception in startWork.", th);
                    synchronized (this.lock) {
                        if (this.areConstraintsUnmet) {
                            logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints were unmet, Retrying.");
                            SettableFuture<ListenableWorker.Result> settableFuture4 = this.future;
                            Intrinsics.checkNotNullExpressionValue(settableFuture4, "future");
                            boolean unused4 = ConstraintTrackingWorkerKt.setRetry(settableFuture4);
                        } else {
                            SettableFuture<ListenableWorker.Result> settableFuture5 = this.future;
                            Intrinsics.checkNotNullExpressionValue(settableFuture5, "future");
                            boolean unused5 = ConstraintTrackingWorkerKt.setFailed(settableFuture5);
                        }
                    }
                }
            } else {
                logger.debug(ConstraintTrackingWorkerKt.TAG, "Constraints not met for delegate " + string + ". Requesting retry.");
                SettableFuture<ListenableWorker.Result> settableFuture6 = this.future;
                Intrinsics.checkNotNullExpressionValue(settableFuture6, "future");
                boolean unused6 = ConstraintTrackingWorkerKt.setRetry(settableFuture6);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void setupAndRunConstraintTrackingWork$lambda$2(ConstraintTrackingWorker constraintTrackingWorker, ListenableFuture listenableFuture) {
        Intrinsics.checkNotNullParameter(constraintTrackingWorker, "this$0");
        Intrinsics.checkNotNullParameter(listenableFuture, "$innerFuture");
        synchronized (constraintTrackingWorker.lock) {
            if (constraintTrackingWorker.areConstraintsUnmet) {
                SettableFuture<ListenableWorker.Result> settableFuture = constraintTrackingWorker.future;
                Intrinsics.checkNotNullExpressionValue(settableFuture, "future");
                boolean unused = ConstraintTrackingWorkerKt.setRetry(settableFuture);
            } else {
                constraintTrackingWorker.future.setFuture(listenableFuture);
            }
            Unit unit = Unit.INSTANCE;
        }
    }

    public void onStopped() {
        super.onStopped();
        ListenableWorker listenableWorker = this.delegate;
        if (listenableWorker != null && !listenableWorker.isStopped()) {
            listenableWorker.stop();
        }
    }

    public void onAllConstraintsNotMet(List<WorkSpec> list) {
        Intrinsics.checkNotNullParameter(list, "workSpecs");
        Logger.get().debug(ConstraintTrackingWorkerKt.TAG, "Constraints changed for " + list);
        synchronized (this.lock) {
            this.areConstraintsUnmet = true;
            Unit unit = Unit.INSTANCE;
        }
    }
}
