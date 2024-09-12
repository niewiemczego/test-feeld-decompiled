package com.launchdarkly.sdk.android;

@FunctionalInterface
public interface FeatureFlagChangeListener {
    void onFeatureFlagChange(String str);
}
