package com.launchdarkly.sdk.android;

import java.util.List;

@FunctionalInterface
public interface LDAllFlagsListener {
    void onChange(List<String> list);
}
