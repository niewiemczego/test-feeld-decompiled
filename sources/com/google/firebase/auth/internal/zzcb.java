package com.google.firebase.auth.internal;

import android.app.Application;
import android.content.Context;
import com.google.android.gms.common.api.internal.BackgroundDetector;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzcb {
    private volatile int zza;
    /* access modifiers changed from: private */
    public final zzaq zzb;
    /* access modifiers changed from: private */
    public volatile boolean zzc;

    public zzcb(FirebaseApp firebaseApp) {
        this(firebaseApp.getApplicationContext(), new zzaq(firebaseApp));
    }

    private zzcb(Context context, zzaq zzaq) {
        this.zzc = false;
        this.zza = 0;
        this.zzb = zzaq;
        BackgroundDetector.initialize((Application) context.getApplicationContext());
        BackgroundDetector.getInstance().addListener(new zzca(this));
    }

    public final void zza() {
        this.zzb.zzb();
    }

    public final void zza(int i) {
        if (i > 0 && this.zza == 0) {
            this.zza = i;
            if (zzb()) {
                this.zzb.zzc();
            }
        } else if (i == 0 && this.zza != 0) {
            this.zzb.zzb();
        }
        this.zza = i;
    }

    public final void zza(zzafm zzafm) {
        if (zzafm != null) {
            long zza2 = zzafm.zza();
            if (zza2 <= 0) {
                zza2 = 3600;
            }
            zzaq zzaq = this.zzb;
            zzaq.zza = zzafm.zzb() + (zza2 * 1000);
            zzaq.zzb = -1;
            if (zzb()) {
                this.zzb.zzc();
            }
        }
    }

    /* access modifiers changed from: private */
    public final boolean zzb() {
        return this.zza > 0 && !this.zzc;
    }
}
