package io.sentry;

import java.util.List;

public final class NoOpTransactionProfiler implements ITransactionProfiler {
    private static final NoOpTransactionProfiler instance = new NoOpTransactionProfiler();

    public void bindTransaction(ITransaction iTransaction) {
    }

    public void close() {
    }

    public boolean isRunning() {
        return false;
    }

    public ProfilingTraceData onTransactionFinish(ITransaction iTransaction, List<PerformanceCollectionData> list, SentryOptions sentryOptions) {
        return null;
    }

    public void start() {
    }

    private NoOpTransactionProfiler() {
    }

    public static NoOpTransactionProfiler getInstance() {
        return instance;
    }
}
