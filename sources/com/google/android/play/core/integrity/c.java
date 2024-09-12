package com.google.android.play.core.integrity;

import android.net.Network;
import com.google.android.play.core.integrity.IntegrityTokenRequest;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class c extends IntegrityTokenRequest.Builder {
    private String a;
    private Long b;

    c() {
    }

    public final IntegrityTokenRequest build() {
        String str = this.a;
        if (str != null) {
            return new e(str, this.b, (Network) null, (d) null);
        }
        throw new IllegalStateException("Missing required properties: nonce");
    }

    public final IntegrityTokenRequest.Builder setCloudProjectNumber(long j) {
        this.b = Long.valueOf(j);
        return this;
    }

    public final IntegrityTokenRequest.Builder setNonce(String str) {
        if (str != null) {
            this.a = str;
            return this;
        }
        throw new NullPointerException("Null nonce");
    }
}
