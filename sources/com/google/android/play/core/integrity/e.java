package com.google.android.play.core.integrity;

import android.net.Network;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class e extends IntegrityTokenRequest {
    private final String a;
    private final Long b;

    /* synthetic */ e(String str, Long l, Network network, d dVar) {
        this.a = str;
        this.b = l;
    }

    public final Network a() {
        return null;
    }

    public final Long cloudProjectNumber() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        Long l;
        if (obj == this) {
            return true;
        }
        if (obj instanceof IntegrityTokenRequest) {
            IntegrityTokenRequest integrityTokenRequest = (IntegrityTokenRequest) obj;
            if (this.a.equals(integrityTokenRequest.nonce()) && ((l = this.b) != null ? l.equals(integrityTokenRequest.cloudProjectNumber()) : integrityTokenRequest.cloudProjectNumber() == null)) {
                integrityTokenRequest.a();
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i;
        int hashCode = this.a.hashCode() ^ 1000003;
        Long l = this.b;
        if (l == null) {
            i = 0;
        } else {
            i = l.hashCode();
        }
        return ((hashCode * 1000003) ^ i) * 1000003;
    }

    public final String nonce() {
        return this.a;
    }

    public final String toString() {
        String str = this.a;
        Long l = this.b;
        return "IntegrityTokenRequest{nonce=" + str + ", cloudProjectNumber=" + l + ", network=null}";
    }
}
