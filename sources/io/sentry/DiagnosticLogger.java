package io.sentry;

import io.sentry.util.Objects;

public final class DiagnosticLogger implements ILogger {
    private final ILogger logger;
    private final SentryOptions options;

    public DiagnosticLogger(SentryOptions sentryOptions, ILogger iLogger) {
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.logger = iLogger;
    }

    public boolean isEnabled(SentryLevel sentryLevel) {
        SentryLevel diagnosticLevel = this.options.getDiagnosticLevel();
        if (sentryLevel != null && this.options.isDebug() && sentryLevel.ordinal() >= diagnosticLevel.ordinal()) {
            return true;
        }
        return false;
    }

    public void log(SentryLevel sentryLevel, String str, Object... objArr) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, str, objArr);
        }
    }

    public void log(SentryLevel sentryLevel, String str, Throwable th) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, str, th);
        }
    }

    public void log(SentryLevel sentryLevel, Throwable th, String str, Object... objArr) {
        if (this.logger != null && isEnabled(sentryLevel)) {
            this.logger.log(sentryLevel, th, str, objArr);
        }
    }

    public ILogger getLogger() {
        return this.logger;
    }
}
