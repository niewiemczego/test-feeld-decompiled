package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class f extends StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder {
    private long a;
    private byte b;

    f() {
    }

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest build() {
        if (this.b == 1) {
            return new h(this.a, (g) null);
        }
        throw new IllegalStateException("Missing required properties: cloudProjectNumber");
    }

    public final StandardIntegrityManager.PrepareIntegrityTokenRequest.Builder setCloudProjectNumber(long j) {
        this.a = j;
        this.b = 1;
        return this;
    }
}
