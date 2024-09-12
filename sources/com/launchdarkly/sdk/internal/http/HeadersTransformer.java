package com.launchdarkly.sdk.internal.http;

import java.util.Map;

public interface HeadersTransformer {
    void updateHeaders(Map<String, String> map);
}
