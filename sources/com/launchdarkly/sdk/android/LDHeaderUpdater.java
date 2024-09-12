package com.launchdarkly.sdk.android;

import java.util.Map;

public interface LDHeaderUpdater {
    void updateHeaders(Map<String, String> map);
}
