package io.sentry;

import java.util.List;

public final class NoOpTransactionPerformanceCollector implements TransactionPerformanceCollector {
    private static final NoOpTransactionPerformanceCollector instance = new NoOpTransactionPerformanceCollector();

    public void close() {
    }

    public void onSpanFinished(ISpan iSpan) {
    }

    public void onSpanStarted(ISpan iSpan) {
    }

    public void start(ITransaction iTransaction) {
    }

    public List<PerformanceCollectionData> stop(ITransaction iTransaction) {
        return null;
    }

    public static NoOpTransactionPerformanceCollector getInstance() {
        return instance;
    }

    private NoOpTransactionPerformanceCollector() {
    }
}
