package com.launchdarkly.sdk.android;

import com.google.gson.annotations.JsonAdapter;

@JsonAdapter(LDFailureSerialization.class)
public class LDFailure extends LaunchDarklyException {
    private final FailureType failureType;

    public enum FailureType {
        INVALID_RESPONSE_BODY,
        NETWORK_FAILURE,
        UNEXPECTED_STREAM_ELEMENT_TYPE,
        UNEXPECTED_RESPONSE_CODE,
        UNKNOWN_ERROR
    }

    public LDFailure(String str, FailureType failureType2) {
        super(str);
        this.failureType = failureType2;
    }

    public LDFailure(String str, Throwable th, FailureType failureType2) {
        super(str, th);
        this.failureType = failureType2;
    }

    public FailureType getFailureType() {
        return this.failureType;
    }
}
