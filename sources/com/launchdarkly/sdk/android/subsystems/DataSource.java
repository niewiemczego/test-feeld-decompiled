package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.sdk.LDContext;

public interface DataSource {
    boolean needsRefresh(boolean z, LDContext lDContext) {
        return true;
    }

    void start(Callback<Boolean> callback);

    void stop(Callback<Void> callback);
}
