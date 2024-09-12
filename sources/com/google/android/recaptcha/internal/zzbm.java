package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbm implements zzbh {
    public static final zzbi zza = new zzbi((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static Timer zzb;
    private final zzbn zzc;
    /* access modifiers changed from: private */
    public final CoroutineScope zzd;
    /* access modifiers changed from: private */
    public final zzaz zze;

    public zzbm(Context context, zzbn zzbn, CoroutineScope coroutineScope) {
        this.zzc = zzbn;
        this.zzd = coroutineScope;
        zzax zzax = zzaz.zza;
        zzaz zzaz = null;
        try {
            zzaz zzc2 = zzaz.zzc;
            zzc2 = zzc2 == null ? new zzaz(context, (DefaultConstructorMarker) null) : zzc2;
            zzaz.zzc = zzc2;
            zzaz = zzc2;
        } catch (Exception unused) {
        }
        this.zze = zzaz;
        zzh();
    }

    /* access modifiers changed from: private */
    public final void zzg() {
        zzaz zzaz;
        zzaz zzaz2 = this.zze;
        if (zzaz2 != null) {
            for (List<zzba> it : CollectionsKt.windowed(zzaz2.zzd(), 20, 20, true)) {
                zznh zzi = zzni.zzi();
                ArrayList arrayList = new ArrayList();
                for (zzba zzba : it) {
                    try {
                        zzpd zzk = zzpd.zzk(zzfy.zzg().zzj(zzba.zzc()));
                        int zzJ = zzk.zzJ();
                        int i = zzJ - 1;
                        if (zzJ != 0) {
                            if (i == 0) {
                                zzi.zzp(zzk.zzf());
                            } else if (i == 1) {
                                zzi.zzq(zzk.zzg());
                            }
                            arrayList.add(zzba);
                        } else {
                            throw null;
                        }
                    } catch (Exception unused) {
                        zzaz zzaz3 = this.zze;
                        if (zzaz3 != null) {
                            zzaz3.zzf(zzba);
                        }
                    }
                }
                if (zzi.zzd() + zzi.zze() != 0) {
                    if (this.zzc.zza(((zzni) zzi.zzj()).zzd()) && (zzaz = this.zze) != null) {
                        zzaz.zza(arrayList);
                    }
                }
            }
        }
    }

    private final void zzh() {
        if (zzb == null) {
            Timer timer = new Timer();
            zzb = timer;
            timer.schedule(new zzbj(this), 120000, 120000);
        }
    }

    public final void zza(zzpd zzpd) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.zzd, (CoroutineContext) null, (CoroutineStart) null, new zzbl(this, zzpd, (Continuation) null), 3, (Object) null);
        zzh();
    }
}
