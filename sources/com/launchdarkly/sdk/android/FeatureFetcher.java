package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.subsystems.Callback;
import java.io.Closeable;

interface FeatureFetcher extends Closeable {
    void fetch(LDContext lDContext, Callback<String> callback);
}
