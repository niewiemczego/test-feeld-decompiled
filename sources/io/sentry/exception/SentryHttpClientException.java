package io.sentry.exception;

public final class SentryHttpClientException extends Exception {
    private static final long serialVersionUID = 348162238030337390L;

    public SentryHttpClientException(String str) {
        super(str);
    }
}
