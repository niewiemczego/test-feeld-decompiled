package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.android.subsystems.ApplicationInfo;

public final class ApplicationInfoBuilder {
    private String applicationId;
    private String applicationVersion;

    public ApplicationInfoBuilder applicationId(String str) {
        this.applicationId = str;
        return this;
    }

    public ApplicationInfoBuilder applicationVersion(String str) {
        this.applicationVersion = str;
        return this;
    }

    public ApplicationInfo createApplicationInfo() {
        return new ApplicationInfo(this.applicationId, this.applicationVersion);
    }
}
