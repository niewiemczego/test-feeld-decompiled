package com.google.android.play.core.integrity;

import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class h extends StandardIntegrityManager.PrepareIntegrityTokenRequest {
    private final long a;

    /* synthetic */ h(long j, g gVar) {
        this.a = j;
    }

    public final long a() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof StandardIntegrityManager.PrepareIntegrityTokenRequest) && this.a == ((StandardIntegrityManager.PrepareIntegrityTokenRequest) obj).a();
    }

    public final int hashCode() {
        long j = this.a;
        return ((int) (j ^ (j >>> 32))) ^ 1000003;
    }

    public final String toString() {
        long j = this.a;
        return "PrepareIntegrityTokenRequest{cloudProjectNumber=" + j + "}";
    }
}
