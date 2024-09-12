package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzahp  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzahp extends zzahr {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzahm zzc;

    public final byte zza() {
        int i = this.zza;
        if (i < this.zzb) {
            this.zza = i + 1;
            return this.zzc.zzb(i);
        }
        throw new NoSuchElementException();
    }

    zzahp(zzahm zzahm) {
        this.zzc = zzahm;
        this.zzb = zzahm.zzb();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }
}
