package io.sentry;

public interface IPerformanceSnapshotCollector extends IPerformanceCollector {
    void collect(PerformanceCollectionData performanceCollectionData);

    void setup();
}
