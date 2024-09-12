package com.facebook.bolts;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 @*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0003@ABB\u0007\b\u0010¢\u0006\u0002\u0010\u0003B\u0011\b\u0012\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0005B\u000f\b\u0012\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010%\u001a\b\u0012\u0004\u0012\u0002H&0\u0000\"\u0004\b\u0001\u0010&J4\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u0010J>\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,JJ\u0010'\u001a\b\u0012\u0004\u0012\u00020\u00110\u00002\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00070)2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00000\u00102\b\b\u0002\u0010-\u001a\u00020.2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,J&\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u0010J0\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\b\u0010+\u001a\u0004\u0018\u00010,J.\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.J8\u0010/\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J,\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u0010J6\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,J4\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.J>\u00101\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00110\u0000J&\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u0010J0\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\b\u0010+\u001a\u0004\u0018\u00010,J.\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.J8\u00103\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H00\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J,\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u0010J6\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\b\u0010+\u001a\u0004\u0018\u00010,J4\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.J>\u00104\u001a\b\u0012\u0004\u0012\u0002H00\u0000\"\u0004\b\u0001\u001002\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H00\u00000\u00102\u0006\u0010-\u001a\u00020.2\b\u0010+\u001a\u0004\u0018\u00010,J\b\u00105\u001a\u000206H\u0002J\u0006\u00107\u001a\u00020\u0007J\u0016\u00108\u001a\u00020\u00072\u000e\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014J\u0015\u00109\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010:J\u0006\u0010;\u001a\u000206J\u0016\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?R\u000e\u0010\t\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000e\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00110\u0010\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u0012\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u00148F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0017\u001a\n\u0018\u00010\u0013j\u0004\u0018\u0001`\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0019\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u001b\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0011\u0010\u001c\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u0004\u0018\u00018\u00008F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0012\u0010!\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lcom/facebook/bolts/Task;", "TResult", "", "()V", "result", "(Ljava/lang/Object;)V", "cancelled", "", "(Z)V", "cancelledField", "completeField", "condition", "Ljava/util/concurrent/locks/Condition;", "kotlin.jvm.PlatformType", "continuations", "", "Lcom/facebook/bolts/Continuation;", "Ljava/lang/Void;", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "getError", "()Ljava/lang/Exception;", "errorField", "errorHasBeenObserved", "isCancelled", "()Z", "isCompleted", "isFaulted", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getResult", "()Ljava/lang/Object;", "resultField", "Ljava/lang/Object;", "unobservedErrorNotifier", "Lcom/facebook/bolts/UnobservedErrorNotifier;", "cast", "TOut", "continueWhile", "predicate", "Ljava/util/concurrent/Callable;", "continuation", "ct", "Lcom/facebook/bolts/CancellationToken;", "executor", "Ljava/util/concurrent/Executor;", "continueWith", "TContinuationResult", "continueWithTask", "makeVoid", "onSuccess", "onSuccessTask", "runContinuations", "", "trySetCancelled", "trySetError", "trySetResult", "(Ljava/lang/Object;)Z", "waitForCompletion", "duration", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "Companion", "TaskCompletionSource", "UnobservedExceptionHandler", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Task.kt */
public final class Task<TResult> {
    public static final ExecutorService BACKGROUND_EXECUTOR = BoltsExecutors.Companion.background();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final Executor IMMEDIATE_EXECUTOR = BoltsExecutors.Companion.immediate$facebook_bolts_release();
    /* access modifiers changed from: private */
    public static final Task<?> TASK_CANCELLED = new Task<>(true);
    /* access modifiers changed from: private */
    public static final Task<Boolean> TASK_FALSE = new Task<>(false);
    /* access modifiers changed from: private */
    public static final Task<?> TASK_NULL = new Task<>((Object) null);
    /* access modifiers changed from: private */
    public static final Task<Boolean> TASK_TRUE = new Task<>(true);
    public static final Executor UI_THREAD_EXECUTOR = AndroidExecutors.Companion.uiThread();
    /* access modifiers changed from: private */
    public static volatile UnobservedExceptionHandler unobservedExceptionHandler;
    private boolean cancelledField;
    private boolean completeField;
    private final Condition condition;
    private List<Continuation<TResult, Void>> continuations = new ArrayList();
    private Exception errorField;
    private boolean errorHasBeenObserved;
    private final ReentrantLock lock;
    private TResult resultField;
    private UnobservedErrorNotifier unobservedErrorNotifier;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "", "unobservedException", "", "t", "Lcom/facebook/bolts/Task;", "e", "Lcom/facebook/bolts/UnobservedTaskException;", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Task.kt */
    public interface UnobservedExceptionHandler {
        void unobservedException(Task<?> task, UnobservedTaskException unobservedTaskException);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> call(Callable<TResult> callable) {
        return Companion.call(callable);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
        return Companion.call(callable, cancellationToken);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
        return Companion.call(callable, executor);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
        return Companion.call(callable, executor, cancellationToken);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
        return Companion.callInBackground(callable);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> callInBackground(Callable<TResult> callable, CancellationToken cancellationToken) {
        return Companion.callInBackground(callable, cancellationToken);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> cancelled() {
        return Companion.cancelled();
    }

    @JvmStatic
    public static final Task<Void> delay(long j) {
        return Companion.delay(j);
    }

    @JvmStatic
    public static final Task<Void> delay(long j, CancellationToken cancellationToken) {
        return Companion.delay(j, cancellationToken);
    }

    @JvmStatic
    public static final Task<Void> delay$facebook_bolts_release(long j, ScheduledExecutorService scheduledExecutorService, CancellationToken cancellationToken) {
        return Companion.delay$facebook_bolts_release(j, scheduledExecutorService, cancellationToken);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> forError(Exception exc) {
        return Companion.forError(exc);
    }

    @JvmStatic
    public static final <TResult> Task<TResult> forResult(TResult tresult) {
        return Companion.forResult(tresult);
    }

    @JvmStatic
    public static final UnobservedExceptionHandler getUnobservedExceptionHandler() {
        return Companion.getUnobservedExceptionHandler();
    }

    @JvmStatic
    public static final void setUnobservedExceptionHandler(UnobservedExceptionHandler unobservedExceptionHandler2) {
        Companion.setUnobservedExceptionHandler(unobservedExceptionHandler2);
    }

    @JvmStatic
    public static final Task<Void> whenAll(Collection<? extends Task<?>> collection) {
        return Companion.whenAll(collection);
    }

    @JvmStatic
    public static final <TResult> Task<List<TResult>> whenAllResult(Collection<Task<TResult>> collection) {
        return Companion.whenAllResult(collection);
    }

    @JvmStatic
    public static final Task<Task<?>> whenAny(Collection<? extends Task<?>> collection) {
        return Companion.whenAny(collection);
    }

    @JvmStatic
    public static final <TResult> Task<Task<TResult>> whenAnyResult(Collection<Task<TResult>> collection) {
        return Companion.whenAnyResult(collection);
    }

    public final <TOut> Task<TOut> cast() {
        return this;
    }

    public Task() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
    }

    private Task(TResult tresult) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        trySetResult(tresult);
    }

    private Task(boolean z) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.lock = reentrantLock;
        this.condition = reentrantLock.newCondition();
        if (z) {
            trySetCancelled();
        } else {
            trySetResult((Object) null);
        }
    }

    public final boolean isCompleted() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.completeField;
        } finally {
            lock2.unlock();
        }
    }

    public final boolean isCancelled() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.cancelledField;
        } finally {
            lock2.unlock();
        }
    }

    public final boolean isFaulted() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.errorField != null;
        } finally {
            lock2.unlock();
        }
    }

    public final TResult getResult() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            return this.resultField;
        } finally {
            lock2.unlock();
        }
    }

    public final Exception getError() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.errorField != null) {
                this.errorHasBeenObserved = true;
                UnobservedErrorNotifier unobservedErrorNotifier2 = this.unobservedErrorNotifier;
                if (unobservedErrorNotifier2 != null) {
                    unobservedErrorNotifier2.setObserved();
                    this.unobservedErrorNotifier = null;
                }
            }
            return this.errorField;
        } finally {
            lock2.unlock();
        }
    }

    public final void waitForCompletion() throws InterruptedException {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (!isCompleted()) {
                this.condition.await();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            lock2.unlock();
        }
    }

    public final boolean waitForCompletion(long j, TimeUnit timeUnit) throws InterruptedException {
        Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (!isCompleted()) {
                this.condition.await(j, timeUnit);
            }
            return isCompleted();
        } finally {
            lock2.unlock();
        }
    }

    public final Task<Void> makeVoid() {
        return continueWithTask(new Task$$ExternalSyntheticLambda3());
    }

    /* access modifiers changed from: private */
    /* renamed from: makeVoid$lambda-8  reason: not valid java name */
    public static final Task m295makeVoid$lambda8(Task task) {
        Intrinsics.checkNotNullParameter(task, "task");
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        return Companion.forResult(null);
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWhile(callable, continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public static /* synthetic */ Task continueWhile$default(Task task, Callable callable, Continuation continuation, Executor executor, CancellationToken cancellationToken, int i, Object obj) {
        if ((i & 4) != 0) {
            executor = IMMEDIATE_EXECUTOR;
        }
        if ((i & 8) != 0) {
            cancellationToken = null;
        }
        return task.continueWhile(callable, continuation, executor, cancellationToken);
    }

    public final Task<Void> continueWhile(Callable<Boolean> callable, Continuation<Void, Task<Void>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(callable, "predicate");
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return makeVoid().continueWithTask(new Task$continueWhile$predicateContinuation$1(cancellationToken, callable, continuation, executor), executor);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWith(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                List<Continuation<TResult, Void>> list = this.continuations;
                if (list != null) {
                    list.add(new Task$$ExternalSyntheticLambda1(taskCompletionSource, continuation, executor, cancellationToken));
                }
            }
            Unit unit = Unit.INSTANCE;
            if (isCompleted) {
                Companion.completeImmediately(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: continueWith$lambda-10$lambda-9  reason: not valid java name */
    public static final Void m293continueWith$lambda10$lambda9(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(executor, "$executor");
        Intrinsics.checkNotNullParameter(task, "task");
        Companion.completeImmediately(taskCompletionSource, continuation, task, executor, cancellationToken);
        return null;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWith(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWith(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            boolean isCompleted = isCompleted();
            if (!isCompleted) {
                List<Continuation<TResult, Void>> list = this.continuations;
                if (list != null) {
                    list.add(new Task$$ExternalSyntheticLambda2(taskCompletionSource, continuation, executor, cancellationToken));
                }
            }
            Unit unit = Unit.INSTANCE;
            if (isCompleted) {
                Companion.completeAfterTask(taskCompletionSource, continuation, this, executor, cancellationToken);
            }
            return taskCompletionSource.getTask();
        } finally {
            lock2.unlock();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: continueWithTask$lambda-12$lambda-11  reason: not valid java name */
    public static final Void m294continueWithTask$lambda12$lambda11(TaskCompletionSource taskCompletionSource, Continuation continuation, Executor executor, CancellationToken cancellationToken, Task task) {
        Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(executor, "$executor");
        Intrinsics.checkNotNullParameter(task, "task");
        Companion.completeAfterTask(taskCompletionSource, continuation, task, executor, cancellationToken);
        return null;
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> continueWithTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return continueWithTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return onSuccess(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Task$$ExternalSyntheticLambda0(cancellationToken, continuation), executor);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccess$lambda-13  reason: not valid java name */
    public static final Task m296onSuccess$lambda13(CancellationToken cancellationToken, Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(task, "task");
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWith(continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccess(Continuation<TResult, TContinuationResult> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccess(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return onSuccessTask(continuation, executor, (CancellationToken) null);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, Executor executor, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        Intrinsics.checkNotNullParameter(executor, "executor");
        return continueWithTask(new Task$$ExternalSyntheticLambda4(cancellationToken, continuation), executor);
    }

    /* access modifiers changed from: private */
    /* renamed from: onSuccessTask$lambda-14  reason: not valid java name */
    public static final Task m297onSuccessTask$lambda14(CancellationToken cancellationToken, Continuation continuation, Task task) {
        Intrinsics.checkNotNullParameter(continuation, "$continuation");
        Intrinsics.checkNotNullParameter(task, "task");
        if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
            return Companion.cancelled();
        }
        if (task.isFaulted()) {
            return Companion.forError(task.getError());
        }
        if (task.isCancelled()) {
            return Companion.cancelled();
        }
        return task.continueWithTask(continuation);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR);
    }

    public final <TContinuationResult> Task<TContinuationResult> onSuccessTask(Continuation<TResult, Task<TContinuationResult>> continuation, CancellationToken cancellationToken) {
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        return onSuccessTask(continuation, IMMEDIATE_EXECUTOR, cancellationToken);
    }

    private final void runContinuations() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            List<Continuation<TResult, Void>> list = this.continuations;
            if (list != null) {
                for (Continuation then : list) {
                    then.then(this);
                }
            }
            this.continuations = null;
            Unit unit = Unit.INSTANCE;
            lock2.unlock();
        } catch (RuntimeException e) {
            throw e;
        } catch (Throwable th) {
            lock2.unlock();
            throw th;
        }
    }

    public final boolean trySetCancelled() {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.cancelledField = true;
            this.condition.signalAll();
            runContinuations();
            lock2.unlock();
            return true;
        } finally {
            lock2.unlock();
        }
    }

    public final boolean trySetResult(TResult tresult) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.resultField = tresult;
            this.condition.signalAll();
            runContinuations();
            lock2.unlock();
            return true;
        } finally {
            lock2.unlock();
        }
    }

    public final boolean trySetError(Exception exc) {
        Lock lock2 = this.lock;
        lock2.lock();
        try {
            if (this.completeField) {
                return false;
            }
            this.completeField = true;
            this.errorField = exc;
            this.errorHasBeenObserved = false;
            this.condition.signalAll();
            runContinuations();
            if (!this.errorHasBeenObserved && unobservedExceptionHandler != null) {
                this.unobservedErrorNotifier = new UnobservedErrorNotifier(this);
            }
            lock2.unlock();
            return true;
        } finally {
            lock2.unlock();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/facebook/bolts/Task$TaskCompletionSource;", "Lcom/facebook/bolts/TaskCompletionSource;", "(Lcom/facebook/bolts/Task;)V", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    @Deprecated(message = "Please use [TaskCompletionSource] instead. ")
    /* compiled from: Task.kt */
    public final class TaskCompletionSource extends TaskCompletionSource<TResult> {
        final /* synthetic */ Task<TResult> this$0;

        public TaskCompletionSource(Task task) {
            Intrinsics.checkNotNullParameter(task, "this$0");
            this.this$0 = task;
        }
    }

    @Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0013H\u0007J.\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u0006H\u0007J6\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J$\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u0013H\u0007J.\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00110\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007J\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u0011H\u0007J\\\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\b0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002JV\u0010!\u001a\u00020\u001a\"\u0004\b\u0001\u0010\u001b\"\u0004\b\u0002\u0010\u00112\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u001d2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u001b0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u0002H\u00110\b2\u0006\u0010\u0016\u001a\u00020\u00062\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\u0018\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$H\u0007J\"\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0007J/\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010#0\b2\u0006\u0010\"\u001a\u00020$2\u0006\u0010\u0016\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0015H\u0001¢\u0006\u0002\b'J$\u0010(\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\u000e\u0010)\u001a\n\u0018\u00010*j\u0004\u0018\u0001`+H\u0007J#\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00110\b\"\u0004\b\u0001\u0010\u00112\b\u0010-\u001a\u0004\u0018\u0001H\u0011H\u0007¢\u0006\u0002\u0010.J\n\u0010/\u001a\u0004\u0018\u00010\u000fH\u0007J\u0012\u00100\u001a\u00020\u001a2\b\u00101\u001a\u0004\u0018\u00010\u000fH\u0007J \u00102\u001a\b\u0012\u0004\u0012\u00020#0\b2\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b04H\u0007J0\u00105\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u0001H\u0011060\b\"\u0004\b\u0001\u0010\u00112\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b04H\u0007J$\u00107\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\b2\u0010\u00103\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b04H\u0007J.\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b0\b\"\u0004\b\u0001\u0010\u00112\u0012\u00103\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\b04H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/facebook/bolts/Task$Companion;", "", "()V", "BACKGROUND_EXECUTOR", "Ljava/util/concurrent/ExecutorService;", "IMMEDIATE_EXECUTOR", "Ljava/util/concurrent/Executor;", "TASK_CANCELLED", "Lcom/facebook/bolts/Task;", "TASK_FALSE", "", "TASK_NULL", "TASK_TRUE", "UI_THREAD_EXECUTOR", "unobservedExceptionHandler", "Lcom/facebook/bolts/Task$UnobservedExceptionHandler;", "call", "TResult", "callable", "Ljava/util/concurrent/Callable;", "ct", "Lcom/facebook/bolts/CancellationToken;", "executor", "callInBackground", "cancelled", "completeAfterTask", "", "TContinuationResult", "tcs", "Lcom/facebook/bolts/TaskCompletionSource;", "continuation", "Lcom/facebook/bolts/Continuation;", "task", "completeImmediately", "delay", "Ljava/lang/Void;", "", "cancellationToken", "Ljava/util/concurrent/ScheduledExecutorService;", "delay$facebook_bolts_release", "forError", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "forResult", "value", "(Ljava/lang/Object;)Lcom/facebook/bolts/Task;", "getUnobservedExceptionHandler", "setUnobservedExceptionHandler", "eh", "whenAll", "tasks", "", "whenAllResult", "", "whenAny", "whenAnyResult", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: Task.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final UnobservedExceptionHandler getUnobservedExceptionHandler() {
            return Task.unobservedExceptionHandler;
        }

        @JvmStatic
        public final void setUnobservedExceptionHandler(UnobservedExceptionHandler unobservedExceptionHandler) {
            Task.unobservedExceptionHandler = unobservedExceptionHandler;
        }

        @JvmStatic
        public final <TResult> Task<TResult> forResult(TResult tresult) {
            if (tresult == null) {
                return Task.TASK_NULL;
            }
            if (tresult instanceof Boolean) {
                return ((Boolean) tresult).booleanValue() ? Task.TASK_TRUE : Task.TASK_FALSE;
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setResult(tresult);
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        public final <TResult> Task<TResult> forError(Exception exc) {
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            taskCompletionSource.setError(exc);
            return taskCompletionSource.getTask();
        }

        @JvmStatic
        public final <TResult> Task<TResult> cancelled() {
            return Task.TASK_CANCELLED;
        }

        @JvmStatic
        public final Task<Void> delay(long j) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), (CancellationToken) null);
        }

        @JvmStatic
        public final Task<Void> delay(long j, CancellationToken cancellationToken) {
            return delay$facebook_bolts_release(j, BoltsExecutors.Companion.scheduled$facebook_bolts_release(), cancellationToken);
        }

        @JvmStatic
        public final Task<Void> delay$facebook_bolts_release(long j, ScheduledExecutorService scheduledExecutorService, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(scheduledExecutorService, "executor");
            if (cancellationToken != null && cancellationToken.isCancellationRequested()) {
                return cancelled();
            }
            if (j <= 0) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ScheduledFuture<?> schedule = scheduledExecutorService.schedule(new Task$Companion$$ExternalSyntheticLambda4(taskCompletionSource), j, TimeUnit.MILLISECONDS);
            if (cancellationToken != null) {
                cancellationToken.register(new Task$Companion$$ExternalSyntheticLambda5(schedule, taskCompletionSource));
            }
            return taskCompletionSource.getTask();
        }

        /* access modifiers changed from: private */
        /* renamed from: delay$lambda-0  reason: not valid java name */
        public static final void m304delay$lambda0(TaskCompletionSource taskCompletionSource) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            taskCompletionSource.trySetResult(null);
        }

        /* access modifiers changed from: private */
        /* renamed from: delay$lambda-1  reason: not valid java name */
        public static final void m305delay$lambda1(ScheduledFuture scheduledFuture, TaskCompletionSource taskCompletionSource) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            scheduledFuture.cancel(true);
            taskCompletionSource.trySetCancelled();
        }

        @JvmStatic
        public final <TResult> Task<TResult> callInBackground(Callable<TResult> callable) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, (CancellationToken) null);
        }

        @JvmStatic
        public final <TResult> Task<TResult> callInBackground(Callable<TResult> callable, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.BACKGROUND_EXECUTOR, cancellationToken);
        }

        @JvmStatic
        public final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Intrinsics.checkNotNullParameter(executor, "executor");
            return call(callable, executor, (CancellationToken) null);
        }

        @JvmStatic
        public final <TResult> Task<TResult> call(Callable<TResult> callable, Executor executor, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            Intrinsics.checkNotNullParameter(executor, "executor");
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            try {
                executor.execute(new Task$Companion$$ExternalSyntheticLambda1(cancellationToken, taskCompletionSource, callable));
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
            return taskCompletionSource.getTask();
        }

        /* access modifiers changed from: private */
        /* renamed from: call$lambda-2  reason: not valid java name */
        public static final void m300call$lambda2(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Callable callable) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(callable, "$callable");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    taskCompletionSource.setResult(callable.call());
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        @JvmStatic
        public final <TResult> Task<TResult> call(Callable<TResult> callable) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, (CancellationToken) null);
        }

        @JvmStatic
        public final <TResult> Task<TResult> call(Callable<TResult> callable, CancellationToken cancellationToken) {
            Intrinsics.checkNotNullParameter(callable, "callable");
            return call(callable, Task.IMMEDIATE_EXECUTOR, cancellationToken);
        }

        @JvmStatic
        public final <TResult> Task<Task<TResult>> whenAnyResult(Collection<Task<TResult>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task<TResult> continueWith : collection) {
                continueWith.continueWith(new Task$Companion$$ExternalSyntheticLambda0(atomicBoolean, taskCompletionSource));
            }
            return taskCompletionSource.getTask();
        }

        /* access modifiers changed from: private */
        /* renamed from: whenAnyResult$lambda-3  reason: not valid java name */
        public static final Void m307whenAnyResult$lambda3(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(atomicBoolean, "$isAnyTaskComplete");
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$firstCompleted");
            Intrinsics.checkNotNullParameter(task, "it");
            if (atomicBoolean.compareAndSet(false, true)) {
                taskCompletionSource.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }

        @JvmStatic
        public final Task<Task<?>> whenAny(Collection<? extends Task<?>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task continueWith : collection) {
                continueWith.continueWith(new Task$Companion$$ExternalSyntheticLambda6(atomicBoolean, taskCompletionSource));
            }
            return taskCompletionSource.getTask();
        }

        /* access modifiers changed from: private */
        /* renamed from: whenAny$lambda-4  reason: not valid java name */
        public static final Void m306whenAny$lambda4(AtomicBoolean atomicBoolean, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(atomicBoolean, "$isAnyTaskComplete");
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$firstCompleted");
            Intrinsics.checkNotNullParameter(task, "it");
            if (atomicBoolean.compareAndSet(false, true)) {
                taskCompletionSource.setResult(task);
                return null;
            }
            task.getError();
            return null;
        }

        @JvmStatic
        public final <TResult> Task<List<TResult>> whenAllResult(Collection<Task<TResult>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            return whenAll(collection).onSuccess(new Task$Companion$whenAllResult$1(collection));
        }

        @JvmStatic
        public final Task<Void> whenAll(Collection<? extends Task<?>> collection) {
            Intrinsics.checkNotNullParameter(collection, "tasks");
            if (collection.isEmpty()) {
                return forResult((Object) null);
            }
            TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
            ArrayList arrayList = new ArrayList();
            ReentrantLock reentrantLock = new ReentrantLock();
            AtomicInteger atomicInteger = new AtomicInteger(collection.size());
            AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            for (Task continueWith : collection) {
                continueWith.continueWith(new Task$Companion$whenAll$1(reentrantLock, atomicBoolean, atomicInteger, arrayList, taskCompletionSource));
            }
            return taskCompletionSource.getTask();
        }

        /* access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeImmediately(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, TContinuationResult> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
            try {
                executor.execute(new Task$Companion$$ExternalSyntheticLambda2(cancellationToken, taskCompletionSource, continuation, task));
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: completeImmediately$lambda-5  reason: not valid java name */
        public static final void m303completeImmediately$lambda5(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(continuation, "$continuation");
            Intrinsics.checkNotNullParameter(task, "$task");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    taskCompletionSource.setResult(continuation.then(task));
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        /* access modifiers changed from: private */
        public final <TContinuationResult, TResult> void completeAfterTask(TaskCompletionSource<TContinuationResult> taskCompletionSource, Continuation<TResult, Task<TContinuationResult>> continuation, Task<TResult> task, Executor executor, CancellationToken cancellationToken) {
            try {
                executor.execute(new Task$Companion$$ExternalSyntheticLambda3(cancellationToken, taskCompletionSource, continuation, task));
            } catch (Exception e) {
                taskCompletionSource.setError(new ExecutorException(e));
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: completeAfterTask$lambda-7  reason: not valid java name */
        public static final void m301completeAfterTask$lambda7(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Continuation continuation, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(continuation, "$continuation");
            Intrinsics.checkNotNullParameter(task, "$task");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                try {
                    Task task2 = (Task) continuation.then(task);
                    if (task2 == null) {
                        taskCompletionSource.setResult(null);
                    } else {
                        task2.continueWith(new Task$Companion$$ExternalSyntheticLambda7(cancellationToken, taskCompletionSource));
                    }
                } catch (CancellationException unused) {
                    taskCompletionSource.setCancelled();
                } catch (Exception e) {
                    taskCompletionSource.setError(e);
                }
            } else {
                taskCompletionSource.setCancelled();
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: completeAfterTask$lambda-7$lambda-6  reason: not valid java name */
        public static final Void m302completeAfterTask$lambda7$lambda6(CancellationToken cancellationToken, TaskCompletionSource taskCompletionSource, Task task) {
            Intrinsics.checkNotNullParameter(taskCompletionSource, "$tcs");
            Intrinsics.checkNotNullParameter(task, "task");
            if (cancellationToken == null || !cancellationToken.isCancellationRequested()) {
                if (task.isCancelled()) {
                    taskCompletionSource.setCancelled();
                } else if (task.isFaulted()) {
                    taskCompletionSource.setError(task.getError());
                } else {
                    taskCompletionSource.setResult(task.getResult());
                }
                return null;
            }
            taskCompletionSource.setCancelled();
            return null;
        }
    }
}
