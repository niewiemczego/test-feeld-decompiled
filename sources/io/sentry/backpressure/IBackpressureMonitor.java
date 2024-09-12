package io.sentry.backpressure;

public interface IBackpressureMonitor {
    int getDownsampleFactor();

    void start();
}
