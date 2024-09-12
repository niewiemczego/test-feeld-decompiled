package io.sentry.backpressure;

public final class NoOpBackpressureMonitor implements IBackpressureMonitor {
    private static final NoOpBackpressureMonitor instance = new NoOpBackpressureMonitor();

    public int getDownsampleFactor() {
        return 0;
    }

    public void start() {
    }

    private NoOpBackpressureMonitor() {
    }

    public static NoOpBackpressureMonitor getInstance() {
        return instance;
    }
}
