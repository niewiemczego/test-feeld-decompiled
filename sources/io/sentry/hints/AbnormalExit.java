package io.sentry.hints;

public interface AbnormalExit {
    boolean ignoreCurrentThread();

    String mechanism();

    Long timestamp();
}
