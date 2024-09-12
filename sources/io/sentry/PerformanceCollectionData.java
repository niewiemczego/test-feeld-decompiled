package io.sentry;

public final class PerformanceCollectionData {
    private CpuCollectionData cpuData = null;
    private MemoryCollectionData memoryData = null;

    public void addMemoryData(MemoryCollectionData memoryCollectionData) {
        if (memoryCollectionData != null) {
            this.memoryData = memoryCollectionData;
        }
    }

    public void addCpuData(CpuCollectionData cpuCollectionData) {
        if (cpuCollectionData != null) {
            this.cpuData = cpuCollectionData;
        }
    }

    public CpuCollectionData getCpuData() {
        return this.cpuData;
    }

    public MemoryCollectionData getMemoryData() {
        return this.memoryData;
    }
}
