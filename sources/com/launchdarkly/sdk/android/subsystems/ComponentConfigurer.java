package com.launchdarkly.sdk.android.subsystems;

public interface ComponentConfigurer<T> {
    T build(ClientContext clientContext);
}
