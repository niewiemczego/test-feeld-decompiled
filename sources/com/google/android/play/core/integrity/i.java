package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class i extends StandardIntegrityManager.StandardIntegrityTokenRequest.Builder {
    private String a;

    i() {
    }

    public final StandardIntegrityManager.StandardIntegrityTokenRequest build() {
        return new k(this.a, (j) null);
    }

    public final StandardIntegrityManager.StandardIntegrityTokenRequest.Builder setRequestHash(String str) {
        this.a = str;
        return this;
    }
}
