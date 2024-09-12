package io.sentry;

public final class JavaMemoryCollector implements IPerformanceSnapshotCollector {
    private final Runtime runtime = Runtime.getRuntime();

    public void setup() {
    }

    public void collect(PerformanceCollectionData performanceCollectionData) {
        performanceCollectionData.addMemoryData(new MemoryCollectionData(System.currentTimeMillis(), this.runtime.totalMemory() - this.runtime.freeMemory()));
    }
}
