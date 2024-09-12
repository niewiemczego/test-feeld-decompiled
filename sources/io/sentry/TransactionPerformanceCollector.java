package io.sentry;

import java.util.List;

public interface TransactionPerformanceCollector {
    void close();

    void onSpanFinished(ISpan iSpan);

    void onSpanStarted(ISpan iSpan);

    void start(ITransaction iTransaction);

    List<PerformanceCollectionData> stop(ITransaction iTransaction);
}
