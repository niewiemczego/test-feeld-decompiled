package io.sentry.hints;

public interface SubmissionResult {
    boolean isSuccess();

    void setResult(boolean z);
}
