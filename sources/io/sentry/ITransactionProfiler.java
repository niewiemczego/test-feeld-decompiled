package io.sentry;

import java.util.List;

public interface ITransactionProfiler {
    void bindTransaction(ITransaction iTransaction);

    void close();

    boolean isRunning();

    ProfilingTraceData onTransactionFinish(ITransaction iTransaction, List<PerformanceCollectionData> list, SentryOptions sentryOptions);

    void start();
}
