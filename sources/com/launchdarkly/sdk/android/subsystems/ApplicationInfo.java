package com.launchdarkly.sdk.android.subsystems;

public final class ApplicationInfo {
    private String applicationId;
    private String applicationVersion;

    public ApplicationInfo(String str, String str2) {
        this.applicationId = str;
        this.applicationVersion = str2;
    }

    public String getApplicationId() {
        return this.applicationId;
    }

    public String getApplicationVersion() {
        return this.applicationVersion;
    }
}
