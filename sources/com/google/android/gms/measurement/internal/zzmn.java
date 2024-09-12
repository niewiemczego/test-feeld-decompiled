package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfc;
import com.google.android.gms.internal.measurement.zzqd;
import java.util.HashMap;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzmn extends zzml {
    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    public final /* bridge */ /* synthetic */ zzt zzg() {
        return super.zzg();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzao zzh() {
        return super.zzh();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzba zzf() {
        return super.zzf();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfq zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgd zzk() {
        return super.zzk();
    }

    public final /* bridge */ /* synthetic */ zzgp zzm() {
        return super.zzm();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgy zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ zzls zzn() {
        return super.zzn();
    }

    public final zzmq zza(String str) {
        if (zzqd.zza() && zze().zza(zzbi.zzbu)) {
            zzj().zzp().zza("sgtm feature flag enabled.");
            zzh zzd = zzh().zzd(str);
            if (zzd == null) {
                return new zzmq(zzb(str));
            }
            zzmq zzmq = null;
            if (zzd.zzam()) {
                zzj().zzp().zza("sgtm upload enabled in manifest.");
                zzfc.zzd zzc = zzm().zzc(zzd.zzx());
                if (zzc != null) {
                    String zzj = zzc.zzj();
                    if (!TextUtils.isEmpty(zzj)) {
                        String zzi = zzc.zzi();
                        zzj().zzp().zza("sgtm configured with upload_url, server_info", zzj, TextUtils.isEmpty(zzi) ? "Y" : "N");
                        if (TextUtils.isEmpty(zzi)) {
                            zzmq = new zzmq(zzj);
                        } else {
                            HashMap hashMap = new HashMap();
                            hashMap.put("x-google-sgtm-server-info", zzi);
                            zzmq = new zzmq(zzj, hashMap);
                        }
                    }
                }
            }
            if (zzmq != null) {
                return zzmq;
            }
        }
        return new zzmq(zzb(str));
    }

    public final /* bridge */ /* synthetic */ zzmn zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzmz g_() {
        return super.g_();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zznd zzq() {
        return super.zzq();
    }

    private final String zzb(String str) {
        String zzf = zzm().zzf(str);
        if (TextUtils.isEmpty(zzf)) {
            return zzbi.zzq.zza(null);
        }
        Uri parse = Uri.parse(zzbi.zzq.zza(null));
        Uri.Builder buildUpon = parse.buildUpon();
        buildUpon.authority(zzf + "." + parse.getAuthority());
        return buildUpon.build().toString();
    }

    zzmn(zzmp zzmp) {
        super(zzmp);
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }
}
