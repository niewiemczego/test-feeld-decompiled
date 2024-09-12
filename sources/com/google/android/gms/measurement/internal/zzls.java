package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.util.Clock;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzls extends zzmo {
    public final zzgi zza;
    public final zzgi zzb;
    public final zzgi zzc;
    public final zzgi zzd;
    public final zzgi zze;
    private final Map<String, zzlr> zzg = new HashMap();

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    @Deprecated
    private final Pair<String, Boolean> zza(String str) {
        zzlr zzlr;
        zzt();
        long elapsedRealtime = zzb().elapsedRealtime();
        zzlr zzlr2 = this.zzg.get(str);
        if (zzlr2 != null && elapsedRealtime < zzlr2.zzc) {
            return new Pair<>(zzlr2.zza, Boolean.valueOf(zzlr2.zzb));
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        long zzf = zze().zzf(str) + elapsedRealtime;
        AdvertisingIdClient.Info info = null;
        try {
            long zzc2 = zze().zzc(str, zzbi.zzb);
            if (zzc2 > 0) {
                try {
                    info = AdvertisingIdClient.getAdvertisingIdInfo(zza());
                } catch (PackageManager.NameNotFoundException unused) {
                    if (zzlr2 != null) {
                        if (elapsedRealtime < zzlr2.zzc + zzc2) {
                            return new Pair<>(zzlr2.zza, Boolean.valueOf(zzlr2.zzb));
                        }
                    }
                }
            } else {
                info = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            }
            if (info == null) {
                return new Pair<>("00000000-0000-0000-0000-000000000000", false);
            }
            String id = info.getId();
            if (id != null) {
                zzlr = new zzlr(id, info.isLimitAdTrackingEnabled(), zzf);
            } else {
                zzlr = new zzlr("", info.isLimitAdTrackingEnabled(), zzf);
            }
            this.zzg.put(str, zzlr);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair<>(zzlr.zza, Boolean.valueOf(zzlr.zzb));
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            zzlr = new zzlr("", false, zzf);
        }
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str, zzih zzih) {
        if (zzih.zzg()) {
            return zza(str);
        }
        return new Pair<>("", false);
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

    /* access modifiers changed from: package-private */
    @Deprecated
    public final String zza(String str, boolean z) {
        zzt();
        String str2 = z ? (String) zza(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest zzu = zznd.zzu();
        if (zzu == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new Object[]{new BigInteger(1, zzu.digest(str2.getBytes()))});
    }

    zzls(zzmp zzmp) {
        super(zzmp);
        zzgd zzk = zzk();
        zzk.getClass();
        this.zza = new zzgi(zzk, "last_delete_stale", 0);
        zzgd zzk2 = zzk();
        zzk2.getClass();
        this.zzb = new zzgi(zzk2, "backoff", 0);
        zzgd zzk3 = zzk();
        zzk3.getClass();
        this.zzc = new zzgi(zzk3, "last_upload", 0);
        zzgd zzk4 = zzk();
        zzk4.getClass();
        this.zzd = new zzgi(zzk4, "last_upload_attempt", 0);
        zzgd zzk5 = zzk();
        zzk5.getClass();
        this.zze = new zzgi(zzk5, "midnight_offset", 0);
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
