package com.launchdarkly.sdk.internal.events;

import java.util.UUID;

class DiagnosticId {
    final String diagnosticId = UUID.randomUUID().toString();
    final String sdkKeySuffix;

    DiagnosticId(String str) {
        if (str == null) {
            this.sdkKeySuffix = null;
        } else {
            this.sdkKeySuffix = str.substring(Math.max(0, str.length() - 6));
        }
    }
}
