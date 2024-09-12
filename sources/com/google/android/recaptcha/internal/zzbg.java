package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.HashMap;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzbg {
    private final String zza;
    private final Context zzb;
    private final zzab zzc;
    private final zzbh zzd;
    private final HashMap zze = new HashMap();
    private final zzt zzf;

    public zzbg(String str, Context context, zzab zzab, zzt zzt, zzbh zzbh) {
        this.zza = str;
        this.zzb = context;
        this.zzc = zzab;
        this.zzf = zzt;
        this.zzd = zzbh;
    }

    public final void zza(zzbb zzbb) {
        zze(zzbb, 3, (zzmr) null);
    }

    public final void zzb(zzbb zzbb, zzp zzp, String str) {
        String valueOf = String.valueOf(zzp.zzb().zza());
        int zza2 = zzp.zza().zza();
        String zzd2 = zzp.zzd();
        zzmq zzg = zzmr.zzg();
        zzg.zzp(valueOf);
        zzg.zzd(zza2);
        if (zzd2 != null) {
            zzg.zze(zzd2);
        }
        zze(zzbb, 4, (zzmr) zzg.zzj());
    }

    public final void zzd(zzpd zzpd) {
        this.zzd.zza(zzpd);
    }

    /* access modifiers changed from: protected */
    public final void zze(zzbb zzbb, int i, zzmr zzmr) {
        zzx zzx;
        zzbf zzbf = (zzbf) this.zze.get(zzbb);
        if (zzbf != null) {
            zznf zza2 = zzbf.zza(i, zzmr, this.zzb);
            zzpc zzi = zzpd.zzi();
            zzi.zzd(zza2);
            zzpd zzpd = (zzpd) zzi.zzj();
            zzv zzv = zzv.zza;
            zzne zza3 = zzbb.zza();
            long zzf2 = zza2.zzf() * 1000;
            zzne zzne = zzne.UNKNOWN;
            int ordinal = zza3.ordinal();
            if (ordinal == 1) {
                zzx = zzx.zzd;
            } else if (ordinal == 2) {
                zzx = zzx.zze;
            } else if (ordinal == 5) {
                zzx = zzx.zzf;
            } else if (ordinal == 6) {
                zzx = zzx.zzg;
            } else if (ordinal != 24) {
                switch (ordinal) {
                    case 12:
                        zzx = zzx.zzh;
                        break;
                    case 13:
                        zzx = zzx.zzi;
                        break;
                    case 14:
                        zzx = zzx.zzj;
                        break;
                    default:
                        zzx = zzx.zzb;
                        break;
                }
            } else {
                zzx = zzx.zzk;
            }
            zzv.zza(zzx.zza(), zzf2);
            this.zzd.zza(zzpd);
            zzbf zzbf2 = (zzbf) this.zze.remove(zzbb);
        }
    }
}
