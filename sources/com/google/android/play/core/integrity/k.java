package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class k extends StandardIntegrityManager.StandardIntegrityTokenRequest {
    private final String a;

    /* synthetic */ k(String str, j jVar) {
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof StandardIntegrityManager.StandardIntegrityTokenRequest)) {
            return false;
        }
        StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest = (StandardIntegrityManager.StandardIntegrityTokenRequest) obj;
        String str = this.a;
        if (str == null) {
            return standardIntegrityTokenRequest.a() == null;
        }
        return str.equals(standardIntegrityTokenRequest.a());
    }

    public final int hashCode() {
        String str = this.a;
        return (str == null ? 0 : str.hashCode()) ^ 1000003;
    }

    public final String toString() {
        String str = this.a;
        return "StandardIntegrityTokenRequest{requestHash=" + str + "}";
    }
}
