package io.sentry.transport;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public final class ReusableCountLatch {
    private final Sync sync;

    public ReusableCountLatch(int i) {
        if (i >= 0) {
            this.sync = new Sync(i);
            return;
        }
        throw new IllegalArgumentException("negative initial count '" + i + "' is not allowed");
    }

    public ReusableCountLatch() {
        this(0);
    }

    public int getCount() {
        return this.sync.getCount();
    }

    public void decrement() {
        this.sync.decrement();
    }

    public void increment() {
        this.sync.increment();
    }

    public void waitTillZero() throws InterruptedException {
        this.sync.acquireSharedInterruptibly(1);
    }

    public boolean waitTillZero(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.sync.tryAcquireSharedNanos(1, timeUnit.toNanos(j));
    }

    private static final class Sync extends AbstractQueuedSynchronizer {
        private static final long serialVersionUID = 5970133580157457018L;

        Sync(int i) {
            setState(i);
        }

        /* access modifiers changed from: private */
        public int getCount() {
            return getState();
        }

        /* access modifiers changed from: private */
        public void increment() {
            int state;
            do {
                state = getState();
            } while (!compareAndSetState(state, state + 1));
        }

        /* access modifiers changed from: private */
        public void decrement() {
            releaseShared(1);
        }

        public int tryAcquireShared(int i) {
            return getState() == 0 ? 1 : -1;
        }

        public boolean tryReleaseShared(int i) {
            int state;
            int i2;
            do {
                state = getState();
                if (state == 0) {
                    return false;
                }
                i2 = state - 1;
            } while (!compareAndSetState(state, i2));
            if (i2 == 0) {
                return true;
            }
            return false;
        }
    }
}
