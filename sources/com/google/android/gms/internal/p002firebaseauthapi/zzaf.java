package com.google.android.gms.internal.p002firebaseauthapi;

import javax.annotation.CheckForNull;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaf  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
abstract class zzaf extends zzi<String> {
    final CharSequence zza;
    private final zzj zzb;
    private final boolean zzc;
    private int zzd = 0;
    private int zze;

    /* access modifiers changed from: package-private */
    public abstract int zza(int i);

    /* access modifiers changed from: package-private */
    public abstract int zzb(int i);

    /* access modifiers changed from: protected */
    @CheckForNull
    public final /* synthetic */ Object zza() {
        int i;
        int i2 = this.zzd;
        while (true) {
            int i3 = this.zzd;
            if (i3 != -1) {
                int zzb2 = zzb(i3);
                if (zzb2 == -1) {
                    zzb2 = this.zza.length();
                    this.zzd = -1;
                } else {
                    this.zzd = zza(zzb2);
                }
                int i4 = this.zzd;
                if (i4 == i2) {
                    int i5 = i4 + 1;
                    this.zzd = i5;
                    if (i5 > this.zza.length()) {
                        this.zzd = -1;
                    }
                } else {
                    while (i2 < zzb2 && this.zzb.zza(this.zza.charAt(i2))) {
                        i2++;
                    }
                    while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                        zzb2 = i - 1;
                    }
                    int i6 = this.zze;
                    if (i6 == 1) {
                        i = this.zza.length();
                        this.zzd = -1;
                        while (i > i2 && this.zzb.zza(this.zza.charAt(i - 1))) {
                            i--;
                        }
                    } else {
                        this.zze = i6 - 1;
                    }
                    return this.zza.subSequence(i2, i).toString();
                }
            } else {
                zzb();
                return null;
            }
        }
    }

    protected zzaf(zzac zzac, CharSequence charSequence) {
        this.zzb = zzac.zza;
        this.zzc = false;
        this.zze = zzac.zzd;
        this.zza = charSequence;
    }
}
