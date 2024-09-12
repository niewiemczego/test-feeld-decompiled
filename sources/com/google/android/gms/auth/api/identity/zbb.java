package com.google.android.gms.auth.api.identity;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbb {
    private String zba;

    private zbb() {
    }

    /* synthetic */ zbb(zba zba2) {
    }

    public static final zbb zbc(zbc zbc) {
        String zbb = zbc.zbb();
        zbb zbb2 = new zbb();
        if (zbb != null) {
            zbb2.zba = Preconditions.checkNotEmpty(zbb);
        }
        return zbb2;
    }

    public final zbb zba(String str) {
        this.zba = Preconditions.checkNotEmpty(str);
        return this;
    }

    public final zbc zbb() {
        return new zbc(this.zba);
    }
}
