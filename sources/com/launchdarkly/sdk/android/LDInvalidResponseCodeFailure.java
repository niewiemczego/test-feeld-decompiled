package com.launchdarkly.sdk.android;

import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.android.LDFailure;

@JsonAdapter(LDFailureSerialization.class)
public class LDInvalidResponseCodeFailure extends LDFailure {
    private final int responseCode;
    private final boolean retryable;

    public LDInvalidResponseCodeFailure(String str, int i, boolean z) {
        super(str, LDFailure.FailureType.UNEXPECTED_RESPONSE_CODE);
        this.responseCode = i;
        this.retryable = z;
    }

    public LDInvalidResponseCodeFailure(String str, Throwable th, int i, boolean z) {
        super(str, th, LDFailure.FailureType.UNEXPECTED_RESPONSE_CODE);
        this.responseCode = i;
        this.retryable = z;
    }

    public boolean isRetryable() {
        return this.retryable;
    }

    public int getResponseCode() {
        return this.responseCode;
    }
}
