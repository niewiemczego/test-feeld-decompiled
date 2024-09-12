package com.google.android.gms.internal.p002firebaseauthapi;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzala  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzala implements zzaki {
    private final zzakk zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public final zzakk zza() {
        return this.zza;
    }

    public final zzakz zzb() {
        int i = this.zzd;
        if ((i & 1) != 0) {
            return zzakz.PROTO2;
        }
        if ((i & 4) == 4) {
            return zzakz.EDITIONS;
        }
        return zzakz.PROTO3;
    }

    /* access modifiers changed from: package-private */
    public final String zzd() {
        return this.zzb;
    }

    zzala(zzakk zzakk, String str, Object[] objArr) {
        this.zza = zzakk;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c = charAt & 8191;
        int i = 13;
        int i2 = 1;
        while (true) {
            int i3 = i2 + 1;
            char charAt2 = str.charAt(i2);
            if (charAt2 >= 55296) {
                c |= (charAt2 & 8191) << i;
                i += 13;
                i2 = i3;
            } else {
                this.zzd = c | (charAt2 << i);
                return;
            }
        }
    }

    public final boolean zzc() {
        return (this.zzd & 2) == 2;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zze() {
        return this.zzc;
    }
}
