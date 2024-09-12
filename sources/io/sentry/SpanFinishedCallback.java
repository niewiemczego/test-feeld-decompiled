package io.sentry;

interface SpanFinishedCallback {
    void execute(Span span);
}
