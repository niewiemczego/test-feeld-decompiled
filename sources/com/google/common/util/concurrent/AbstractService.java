package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class AbstractService implements Service {
    private static final ListenerCallQueue.Event<Service.Listener> RUNNING_EVENT = new ListenerCallQueue.Event<Service.Listener>() {
        public String toString() {
            return "running()";
        }

        public void call(Service.Listener listener) {
            listener.running();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> STARTING_EVENT = new ListenerCallQueue.Event<Service.Listener>() {
        public String toString() {
            return "starting()";
        }

        public void call(Service.Listener listener) {
            listener.starting();
        }
    };
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_RUNNING_EVENT = stoppingEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> STOPPING_FROM_STARTING_EVENT = stoppingEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_NEW_EVENT = terminatedEvent(Service.State.NEW);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_RUNNING_EVENT = terminatedEvent(Service.State.RUNNING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STARTING_EVENT = terminatedEvent(Service.State.STARTING);
    private static final ListenerCallQueue.Event<Service.Listener> TERMINATED_FROM_STOPPING_EVENT = terminatedEvent(Service.State.STOPPING);
    private final Monitor.Guard hasReachedRunning = new HasReachedRunningGuard();
    private final Monitor.Guard isStartable = new IsStartableGuard();
    private final Monitor.Guard isStoppable = new IsStoppableGuard();
    private final Monitor.Guard isStopped = new IsStoppedGuard();
    private final ListenerCallQueue<Service.Listener> listeners = new ListenerCallQueue<>();
    /* access modifiers changed from: private */
    public final Monitor monitor = new Monitor();
    private volatile StateSnapshot snapshot = new StateSnapshot(Service.State.NEW);

    /* access modifiers changed from: protected */
    public void doCancelStart() {
    }

    /* access modifiers changed from: protected */
    public abstract void doStart();

    /* access modifiers changed from: protected */
    public abstract void doStop();

    private static ListenerCallQueue.Event<Service.Listener> terminatedEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            public void call(Service.Listener listener) {
                listener.terminated(Service.State.this);
            }

            public String toString() {
                String valueOf = String.valueOf(Service.State.this);
                return new StringBuilder(String.valueOf(valueOf).length() + 21).append("terminated({from = ").append(valueOf).append("})").toString();
            }
        };
    }

    private static ListenerCallQueue.Event<Service.Listener> stoppingEvent(final Service.State state) {
        return new ListenerCallQueue.Event<Service.Listener>() {
            public void call(Service.Listener listener) {
                listener.stopping(Service.State.this);
            }

            public String toString() {
                String valueOf = String.valueOf(Service.State.this);
                return new StringBuilder(String.valueOf(valueOf).length() + 19).append("stopping({from = ").append(valueOf).append("})").toString();
            }
        };
    }

    private final class IsStartableGuard extends Monitor.Guard {
        IsStartableGuard() {
            super(AbstractService.this.monitor);
        }

        public boolean isSatisfied() {
            return AbstractService.this.state() == Service.State.NEW;
        }
    }

    private final class IsStoppableGuard extends Monitor.Guard {
        IsStoppableGuard() {
            super(AbstractService.this.monitor);
        }

        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) <= 0;
        }
    }

    private final class HasReachedRunningGuard extends Monitor.Guard {
        HasReachedRunningGuard() {
            super(AbstractService.this.monitor);
        }

        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.RUNNING) >= 0;
        }
    }

    private final class IsStoppedGuard extends Monitor.Guard {
        IsStoppedGuard() {
            super(AbstractService.this.monitor);
        }

        public boolean isSatisfied() {
            return AbstractService.this.state().compareTo(Service.State.TERMINATED) >= 0;
        }
    }

    protected AbstractService() {
    }

    public final Service startAsync() {
        if (this.monitor.enterIf(this.isStartable)) {
            try {
                this.snapshot = new StateSnapshot(Service.State.STARTING);
                enqueueStartingEvent();
                doStart();
            } catch (Throwable th) {
                this.monitor.leave();
                dispatchListenerEvents();
                throw th;
            }
            this.monitor.leave();
            dispatchListenerEvents();
            return this;
        }
        String valueOf = String.valueOf(this);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 33).append("Service ").append(valueOf).append(" has already been started").toString());
    }

    public final Service stopAsync() {
        if (this.monitor.enterIf(this.isStoppable)) {
            try {
                Service.State state = state();
                switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                    case 1:
                        this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                        enqueueTerminatedEvent(Service.State.NEW);
                        break;
                    case 2:
                        this.snapshot = new StateSnapshot(Service.State.STARTING, true, (Throwable) null);
                        enqueueStoppingEvent(Service.State.STARTING);
                        doCancelStart();
                        break;
                    case 3:
                        this.snapshot = new StateSnapshot(Service.State.STOPPING);
                        enqueueStoppingEvent(Service.State.RUNNING);
                        doStop();
                        break;
                    case 4:
                    case 5:
                    case 6:
                        String valueOf = String.valueOf(state);
                        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 45).append("isStoppable is incorrectly implemented, saw: ").append(valueOf).toString());
                }
            } catch (Throwable th) {
                this.monitor.leave();
                dispatchListenerEvents();
                throw th;
            }
            this.monitor.leave();
            dispatchListenerEvents();
        }
        return this;
    }

    /* renamed from: com.google.common.util.concurrent.AbstractService$6  reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$util$concurrent$Service$State;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.google.common.util.concurrent.Service$State[] r0 = com.google.common.util.concurrent.Service.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$google$common$util$concurrent$Service$State = r0
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.NEW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$google$common$util$concurrent$Service$State     // Catch:{ NoSuchFieldError -> 0x001d }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.STARTING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$google$common$util$concurrent$Service$State     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.RUNNING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$google$common$util$concurrent$Service$State     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.STOPPING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$google$common$util$concurrent$Service$State     // Catch:{ NoSuchFieldError -> 0x003e }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.TERMINATED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$google$common$util$concurrent$Service$State     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.google.common.util.concurrent.Service$State r1 = com.google.common.util.concurrent.Service.State.FAILED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.util.concurrent.AbstractService.AnonymousClass6.<clinit>():void");
        }
    }

    public final void awaitRunning() {
        this.monitor.enterWhenUninterruptibly(this.hasReachedRunning);
        try {
            checkCurrentState(Service.State.RUNNING);
        } finally {
            this.monitor.leave();
        }
    }

    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.hasReachedRunning, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.RUNNING);
            } finally {
                this.monitor.leave();
            }
        } else {
            String valueOf = String.valueOf(this);
            throw new TimeoutException(new StringBuilder(String.valueOf(valueOf).length() + 50).append("Timed out waiting for ").append(valueOf).append(" to reach the RUNNING state.").toString());
        }
    }

    public final void awaitTerminated() {
        this.monitor.enterWhenUninterruptibly(this.isStopped);
        try {
            checkCurrentState(Service.State.TERMINATED);
        } finally {
            this.monitor.leave();
        }
    }

    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        if (this.monitor.enterWhenUninterruptibly(this.isStopped, j, timeUnit)) {
            try {
                checkCurrentState(Service.State.TERMINATED);
            } finally {
                this.monitor.leave();
            }
        } else {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(state());
            throw new TimeoutException(new StringBuilder(String.valueOf(valueOf).length() + 65 + String.valueOf(valueOf2).length()).append("Timed out waiting for ").append(valueOf).append(" to reach a terminal state. Current state: ").append(valueOf2).toString());
        }
    }

    private void checkCurrentState(Service.State state) {
        Service.State state2 = state();
        if (state2 == state) {
            return;
        }
        if (state2 == Service.State.FAILED) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(state);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 56 + String.valueOf(valueOf2).length()).append("Expected the service ").append(valueOf).append(" to be ").append(valueOf2).append(", but the service has FAILED").toString(), failureCause());
        }
        String valueOf3 = String.valueOf(this);
        String valueOf4 = String.valueOf(state);
        String valueOf5 = String.valueOf(state2);
        throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf3).length() + 38 + String.valueOf(valueOf4).length() + String.valueOf(valueOf5).length()).append("Expected the service ").append(valueOf3).append(" to be ").append(valueOf4).append(", but was ").append(valueOf5).toString());
    }

    /* access modifiers changed from: protected */
    public final void notifyStarted() {
        this.monitor.enter();
        try {
            if (this.snapshot.state == Service.State.STARTING) {
                if (this.snapshot.shutdownWhenStartupFinishes) {
                    this.snapshot = new StateSnapshot(Service.State.STOPPING);
                    doStop();
                } else {
                    this.snapshot = new StateSnapshot(Service.State.RUNNING);
                    enqueueRunningEvent();
                }
                return;
            }
            String valueOf = String.valueOf(this.snapshot.state);
            IllegalStateException illegalStateException = new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Cannot notifyStarted() when the service is ").append(valueOf).toString());
            notifyFailed(illegalStateException);
            throw illegalStateException;
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyStopped() {
        this.monitor.enter();
        try {
            Service.State state = state();
            switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
                case 1:
                case 5:
                case 6:
                    String valueOf = String.valueOf(state);
                    throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 43).append("Cannot notifyStopped() when the service is ").append(valueOf).toString());
                case 2:
                case 3:
                case 4:
                    this.snapshot = new StateSnapshot(Service.State.TERMINATED);
                    enqueueTerminatedEvent(state);
                    break;
            }
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    /* access modifiers changed from: protected */
    public final void notifyFailed(Throwable th) {
        Preconditions.checkNotNull(th);
        this.monitor.enter();
        try {
            Service.State state = state();
            int i = AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()];
            if (i != 1) {
                if (i == 2 || i == 3 || i == 4) {
                    this.snapshot = new StateSnapshot(Service.State.FAILED, false, th);
                    enqueueFailedEvent(state, th);
                } else if (i != 5) {
                }
                return;
            }
            String valueOf = String.valueOf(state);
            throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf).length() + 22).append("Failed while in state:").append(valueOf).toString(), th);
        } finally {
            this.monitor.leave();
            dispatchListenerEvents();
        }
    }

    public final boolean isRunning() {
        return state() == Service.State.RUNNING;
    }

    public final Service.State state() {
        return this.snapshot.externalState();
    }

    public final Throwable failureCause() {
        return this.snapshot.failureCause();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.listeners.addListener(listener, executor);
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        String valueOf = String.valueOf(state());
        return new StringBuilder(String.valueOf(simpleName).length() + 3 + String.valueOf(valueOf).length()).append(simpleName).append(" [").append(valueOf).append("]").toString();
    }

    private void dispatchListenerEvents() {
        if (!this.monitor.isOccupiedByCurrentThread()) {
            this.listeners.dispatch();
        }
    }

    private void enqueueStartingEvent() {
        this.listeners.enqueue(STARTING_EVENT);
    }

    private void enqueueRunningEvent() {
        this.listeners.enqueue(RUNNING_EVENT);
    }

    private void enqueueStoppingEvent(Service.State state) {
        if (state == Service.State.STARTING) {
            this.listeners.enqueue(STOPPING_FROM_STARTING_EVENT);
        } else if (state == Service.State.RUNNING) {
            this.listeners.enqueue(STOPPING_FROM_RUNNING_EVENT);
        } else {
            throw new AssertionError();
        }
    }

    private void enqueueTerminatedEvent(Service.State state) {
        switch (AnonymousClass6.$SwitchMap$com$google$common$util$concurrent$Service$State[state.ordinal()]) {
            case 1:
                this.listeners.enqueue(TERMINATED_FROM_NEW_EVENT);
                return;
            case 2:
                this.listeners.enqueue(TERMINATED_FROM_STARTING_EVENT);
                return;
            case 3:
                this.listeners.enqueue(TERMINATED_FROM_RUNNING_EVENT);
                return;
            case 4:
                this.listeners.enqueue(TERMINATED_FROM_STOPPING_EVENT);
                return;
            case 5:
            case 6:
                throw new AssertionError();
            default:
                return;
        }
    }

    private void enqueueFailedEvent(final Service.State state, final Throwable th) {
        this.listeners.enqueue(new ListenerCallQueue.Event<Service.Listener>(this) {
            public void call(Service.Listener listener) {
                listener.failed(state, th);
            }

            public String toString() {
                String valueOf = String.valueOf(state);
                String valueOf2 = String.valueOf(th);
                return new StringBuilder(String.valueOf(valueOf).length() + 27 + String.valueOf(valueOf2).length()).append("failed({from = ").append(valueOf).append(", cause = ").append(valueOf2).append("})").toString();
            }
        });
    }

    private static final class StateSnapshot {
        @CheckForNull
        final Throwable failure;
        final boolean shutdownWhenStartupFinishes;
        final Service.State state;

        StateSnapshot(Service.State state2) {
            this(state2, false, (Throwable) null);
        }

        StateSnapshot(Service.State state2, boolean z, @CheckForNull Throwable th) {
            boolean z2 = false;
            Preconditions.checkArgument(!z || state2 == Service.State.STARTING, "shutdownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", (Object) state2);
            Preconditions.checkArgument((th != null) == (state2 == Service.State.FAILED) ? true : z2, "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", (Object) state2, (Object) th);
            this.state = state2;
            this.shutdownWhenStartupFinishes = z;
            this.failure = th;
        }

        /* access modifiers changed from: package-private */
        public Service.State externalState() {
            if (!this.shutdownWhenStartupFinishes || this.state != Service.State.STARTING) {
                return this.state;
            }
            return Service.State.STOPPING;
        }

        /* access modifiers changed from: package-private */
        public Throwable failureCause() {
            Preconditions.checkState(this.state == Service.State.FAILED, "failureCause() is only valid if the service has failed, service is %s", (Object) this.state);
            return (Throwable) Objects.requireNonNull(this.failure);
        }
    }
}
