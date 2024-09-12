package com.launchdarkly.sdk.android.subsystems;

import com.launchdarkly.sdk.LDValue;

public interface DiagnosticDescription {
    LDValue describeConfiguration(ClientContext clientContext);
}
