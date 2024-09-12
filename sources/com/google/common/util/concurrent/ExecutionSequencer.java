package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public final class ExecutionSequencer {
    /* access modifiers changed from: private */
    public ThreadConfinedTaskQueue latestTaskQueue = new ThreadConfinedTaskQueue();
    private final AtomicReference<ListenableFuture<Void>> ref = new AtomicReference<>(Futures.immediateVoidFuture());

    enum RunningState {
        NOT_RUN,
        CANCELLED,
        STARTED
    }

    private ExecutionSequencer() {
    }

    public static ExecutionSequencer create() {
        return new ExecutionSequencer();
    }

    private static final class ThreadConfinedTaskQueue {
        @CheckForNull
        Executor nextExecutor;
        @CheckForNull
        Runnable nextTask;
        @CheckForNull
        Thread thread;

        private ThreadConfinedTaskQueue() {
        }
    }

    public <T> ListenableFuture<T> submit(final Callable<T> callable, Executor executor) {
        Preconditions.checkNotNull(callable);
        Preconditions.checkNotNull(executor);
        return submitAsync(new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                return Futures.immediateFuture(callable.call());
            }

            public String toString() {
                return callable.toString();
            }
        }, executor);
    }

    public <T> ListenableFuture<T> submitAsync(final AsyncCallable<T> asyncCallable, Executor executor) {
        Preconditions.checkNotNull(asyncCallable);
        Preconditions.checkNotNull(executor);
        final TaskNonReentrantExecutor taskNonReentrantExecutor = new TaskNonReentrantExecutor(executor, this);
        AnonymousClass2 r9 = new AsyncCallable<T>(this) {
            public ListenableFuture<T> call() throws Exception {
                if (!taskNonReentrantExecutor.trySetStarted()) {
                    return Futures.immediateCancelledFuture();
                }
                return asyncCallable.call();
            }

            public String toString() {
                return asyncCallable.toString();
            }
        };
        SettableFuture create = SettableFuture.create();
        ListenableFuture andSet = this.ref.getAndSet(create);
        TrustedListenableFutureTask create2 = TrustedListenableFutureTask.create(r9);
        andSet.addListener(create2, taskNonReentrantExecutor);
        ListenableFuture<T> nonCancellationPropagating = Futures.nonCancellationPropagating(create2);
        ExecutionSequencer$$ExternalSyntheticLambda0 executionSequencer$$ExternalSyntheticLambda0 = new ExecutionSequencer$$ExternalSyntheticLambda0(create2, create, andSet, nonCancellationPropagating, taskNonReentrantExecutor);
        nonCancellationPropagating.addListener(executionSequencer$$ExternalSyntheticLambda0, MoreExecutors.directExecutor());
        create2.addListener(executionSequencer$$ExternalSyntheticLambda0, MoreExecutors.directExecutor());
        return nonCancellationPropagating;
    }

    static /* synthetic */ void lambda$submitAsync$0(TrustedListenableFutureTask trustedListenableFutureTask, SettableFuture settableFuture, ListenableFuture listenableFuture, ListenableFuture listenableFuture2, TaskNonReentrantExecutor taskNonReentrantExecutor) {
        if (trustedListenableFutureTask.isDone()) {
            settableFuture.setFuture(listenableFuture);
        } else if (listenableFuture2.isCancelled() && taskNonReentrantExecutor.trySetCancelled()) {
            trustedListenableFutureTask.cancel(false);
        }
    }

    private static final class TaskNonReentrantExecutor extends AtomicReference<RunningState> implements Executor, Runnable {
        @CheckForNull
        Executor delegate;
        @CheckForNull
        ExecutionSequencer sequencer;
        @CheckForNull
        Thread submitting;
        @CheckForNull
        Runnable task;

        private TaskNonReentrantExecutor(Executor executor, ExecutionSequencer executionSequencer) {
            super(RunningState.NOT_RUN);
            this.delegate = executor;
            this.sequencer = executionSequencer;
        }

        public void execute(Runnable runnable) {
            if (get() == RunningState.CANCELLED) {
                this.delegate = null;
                this.sequencer = null;
                return;
            }
            this.submitting = Thread.currentThread();
            try {
                ThreadConfinedTaskQueue access$300 = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue;
                if (access$300.thread == this.submitting) {
                    this.sequencer = null;
                    Preconditions.checkState(access$300.nextTask == null);
                    access$300.nextTask = runnable;
                    access$300.nextExecutor = (Executor) Objects.requireNonNull(this.delegate);
                    this.delegate = null;
                } else {
                    this.delegate = null;
                    this.task = runnable;
                    ((Executor) Objects.requireNonNull(this.delegate)).execute(this);
                }
            } finally {
                this.submitting = null;
            }
        }

        public void run() {
            Executor executor;
            Thread currentThread = Thread.currentThread();
            if (currentThread != this.submitting) {
                this.task = null;
                ((Runnable) Objects.requireNonNull(this.task)).run();
                return;
            }
            ThreadConfinedTaskQueue threadConfinedTaskQueue = new ThreadConfinedTaskQueue();
            threadConfinedTaskQueue.thread = currentThread;
            ThreadConfinedTaskQueue unused = ((ExecutionSequencer) Objects.requireNonNull(this.sequencer)).latestTaskQueue = threadConfinedTaskQueue;
            this.sequencer = null;
            try {
                this.task = null;
                ((Runnable) Objects.requireNonNull(this.task)).run();
                while (true) {
                    Runnable runnable = threadConfinedTaskQueue.nextTask;
                    if (runnable != null && (executor = threadConfinedTaskQueue.nextExecutor) != null) {
                        threadConfinedTaskQueue.nextTask = null;
                        threadConfinedTaskQueue.nextExecutor = null;
                        executor.execute(runnable);
                    }
                }
            } finally {
                threadConfinedTaskQueue.thread = null;
            }
        }

        /* access modifiers changed from: private */
        public boolean trySetStarted() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.STARTED);
        }

        /* access modifiers changed from: private */
        public boolean trySetCancelled() {
            return compareAndSet(RunningState.NOT_RUN, RunningState.CANCELLED);
        }
    }
}
