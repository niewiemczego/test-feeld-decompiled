package com.google.common.util.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.google.common.collect.Sets;
import com.google.common.util.concurrent.AbstractFuture;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
abstract class AggregateFutureState<OutputT> extends AbstractFuture.TrustedFuture<OutputT> {
    private static final AtomicHelper ATOMIC_HELPER;
    private static final Logger log;
    private volatile int remaining;
    /* access modifiers changed from: private */
    @CheckForNull
    public volatile Set<Throwable> seenExceptions = null;

    /* access modifiers changed from: package-private */
    public abstract void addInitialException(Set<Throwable> set);

    static /* synthetic */ int access$306(AggregateFutureState aggregateFutureState) {
        int i = aggregateFutureState.remaining - 1;
        aggregateFutureState.remaining = i;
        return i;
    }

    static {
        AtomicHelper atomicHelper;
        Class<AggregateFutureState> cls = AggregateFutureState.class;
        log = Logger.getLogger(cls.getName());
        Throwable th = null;
        try {
            atomicHelper = new SafeAtomicHelper(AtomicReferenceFieldUpdater.newUpdater(cls, Set.class, "seenExceptions"), AtomicIntegerFieldUpdater.newUpdater(cls, "remaining"));
        } catch (Throwable th2) {
            atomicHelper = new SynchronizedAtomicHelper();
            th = th2;
        }
        ATOMIC_HELPER = atomicHelper;
        if (th != null) {
            log.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
    }

    AggregateFutureState(int i) {
        this.remaining = i;
    }

    /* access modifiers changed from: package-private */
    public final Set<Throwable> getOrInitSeenExceptions() {
        Set<Throwable> set = this.seenExceptions;
        if (set != null) {
            return set;
        }
        Set newConcurrentHashSet = Sets.newConcurrentHashSet();
        addInitialException(newConcurrentHashSet);
        ATOMIC_HELPER.compareAndSetSeenExceptions(this, (Set<Throwable>) null, newConcurrentHashSet);
        return (Set) Objects.requireNonNull(this.seenExceptions);
    }

    /* access modifiers changed from: package-private */
    public final int decrementRemainingAndGet() {
        return ATOMIC_HELPER.decrementAndGetRemainingCount(this);
    }

    /* access modifiers changed from: package-private */
    public final void clearSeenExceptions() {
        this.seenExceptions = null;
    }

    private static abstract class AtomicHelper {
        /* access modifiers changed from: package-private */
        public abstract void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2);

        /* access modifiers changed from: package-private */
        public abstract int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState);

        private AtomicHelper() {
        }
    }

    private static final class SafeAtomicHelper extends AtomicHelper {
        final AtomicIntegerFieldUpdater<AggregateFutureState<?>> remainingCountUpdater;
        final AtomicReferenceFieldUpdater<AggregateFutureState<?>, Set<Throwable>> seenExceptionsUpdater;

        SafeAtomicHelper(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicIntegerFieldUpdater atomicIntegerFieldUpdater) {
            super();
            this.seenExceptionsUpdater = atomicReferenceFieldUpdater;
            this.remainingCountUpdater = atomicIntegerFieldUpdater;
        }

        /* access modifiers changed from: package-private */
        public void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(this.seenExceptionsUpdater, aggregateFutureState, set, set2);
        }

        /* access modifiers changed from: package-private */
        public int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            return this.remainingCountUpdater.decrementAndGet(aggregateFutureState);
        }
    }

    private static final class SynchronizedAtomicHelper extends AtomicHelper {
        private SynchronizedAtomicHelper() {
            super();
        }

        /* access modifiers changed from: package-private */
        public void compareAndSetSeenExceptions(AggregateFutureState<?> aggregateFutureState, @CheckForNull Set<Throwable> set, Set<Throwable> set2) {
            synchronized (aggregateFutureState) {
                if (aggregateFutureState.seenExceptions == set) {
                    Set unused = aggregateFutureState.seenExceptions = set2;
                }
            }
        }

        /* access modifiers changed from: package-private */
        public int decrementAndGetRemainingCount(AggregateFutureState<?> aggregateFutureState) {
            int access$306;
            synchronized (aggregateFutureState) {
                access$306 = AggregateFutureState.access$306(aggregateFutureState);
            }
            return access$306;
        }
    }
}
