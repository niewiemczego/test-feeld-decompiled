package com.launchdarkly.sdk.android;

public class LaunchDarklyException extends Exception {
    public LaunchDarklyException(String str) {
        super(str);
    }

    LaunchDarklyException(String str, Throwable th) {
        super(str, th);
    }
}
