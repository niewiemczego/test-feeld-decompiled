package io.sentry;

public interface IPerformanceContinuousCollector extends IPerformanceCollector {
    void clear();

    void onSpanFinished(ISpan iSpan);

    void onSpanStarted(ISpan iSpan);
}
