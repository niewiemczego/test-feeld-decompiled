package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.sdk.android.LDHeaderUpdater;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class HttpConfiguration {
    private final int connectTimeoutMillis;
    private final Map<String, String> defaultHeaders;
    private final LDHeaderUpdater headerTransform;
    private final boolean useReport;

    public HttpConfiguration(int i, Map<String, String> map, LDHeaderUpdater lDHeaderUpdater, boolean z) {
        this.connectTimeoutMillis = i;
        this.defaultHeaders = map == null ? Collections.emptyMap() : new HashMap<>(map);
        this.headerTransform = lDHeaderUpdater;
        this.useReport = z;
    }

    public int getConnectTimeoutMillis() {
        return this.connectTimeoutMillis;
    }

    public Iterable<Map.Entry<String, String>> getDefaultHeaders() {
        return this.defaultHeaders.entrySet();
    }

    public LDHeaderUpdater getHeaderTransform() {
        return this.headerTransform;
    }

    public boolean isUseReport() {
        return this.useReport;
    }
}
