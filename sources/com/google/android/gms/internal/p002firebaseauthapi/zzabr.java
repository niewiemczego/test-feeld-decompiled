package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzam;
import com.google.firebase.auth.internal.zzl;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzabr  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
final class zzabr extends zzacw<Void, zzl> {
    private final String zzaa;
    private final long zzab;
    private final boolean zzac;
    private final boolean zzad;
    private final String zzae;
    private final String zzaf;
    private final boolean zzag;
    private final String zzy;
    private final String zzz;

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
    }

    public zzabr(zzam zzam, String str, String str2, long j, boolean z, boolean z2, String str3, String str4, boolean z3) {
        super(8);
        Preconditions.checkNotNull(zzam);
        Preconditions.checkNotEmpty(str);
        this.zzy = Preconditions.checkNotEmpty(zzam.zzb());
        this.zzz = str;
        this.zzaa = str2;
        this.zzab = j;
        this.zzac = z;
        this.zzad = z2;
        this.zzae = str3;
        this.zzaf = str4;
        this.zzag = z3;
    }

    public final void zza(TaskCompletionSource taskCompletionSource, zzace zzace) {
        this.zzg = new zzadg(this, taskCompletionSource);
        zzace.zza(this.zzy, this.zzz, this.zzaa, this.zzab, this.zzac, this.zzad, this.zzae, this.zzaf, this.zzag, this.zzb);
    }
}
