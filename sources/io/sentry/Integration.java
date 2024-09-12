package io.sentry;

public interface Integration {
    void register(IHub iHub, SentryOptions sentryOptions);
}
