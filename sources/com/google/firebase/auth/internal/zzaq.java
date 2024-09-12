package com.google.firebase.auth.internal;

import android.os.Handler;
import android.os.HandlerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.p002firebaseauthapi.zzg;
import com.google.firebase.FirebaseApp;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaq {
    /* access modifiers changed from: private */
    public static Logger zzc = new Logger("TokenRefresher", "FirebaseAuth:");
    volatile long zza;
    volatile long zzb;
    private final FirebaseApp zzd;
    private long zze;
    private HandlerThread zzf;
    private Handler zzg = new zzg(this.zzf.getLooper());
    private Runnable zzh;

    public zzaq(FirebaseApp firebaseApp) {
        zzc.v("Initializing TokenRefresher", new Object[0]);
        FirebaseApp firebaseApp2 = (FirebaseApp) Preconditions.checkNotNull(firebaseApp);
        this.zzd = firebaseApp2;
        HandlerThread handlerThread = new HandlerThread("TokenRefresher", 10);
        this.zzf = handlerThread;
        handlerThread.start();
        this.zzh = new zzat(this, firebaseApp2.getName());
        this.zze = 300000;
    }

    public final void zzb() {
        this.zzg.removeCallbacks(this.zzh);
    }

    public final void zzc() {
        zzc.v("Scheduling refresh for " + (this.zza - this.zze), new Object[0]);
        zzb();
        this.zzb = Math.max((this.zza - DefaultClock.getInstance().currentTimeMillis()) - this.zze, 0) / 1000;
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }

    /* access modifiers changed from: package-private */
    public final void zzd() {
        long j;
        int i = (int) this.zzb;
        if (i == 30 || i == 60 || i == 120 || i == 240 || i == 480) {
            j = 2 * this.zzb;
        } else {
            j = i != 960 ? 30 : 960;
        }
        this.zzb = j;
        this.zza = DefaultClock.getInstance().currentTimeMillis() + (this.zzb * 1000);
        zzc.v("Scheduling refresh for " + this.zza, new Object[0]);
        this.zzg.postDelayed(this.zzh, this.zzb * 1000);
    }
}
