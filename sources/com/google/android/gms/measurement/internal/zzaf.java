package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzoo;
import com.google.android.gms.internal.measurement.zzot;
import java.lang.reflect.InvocationTargetException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzaf extends zzid {
    private Boolean zza;
    private zzah zzb = zzai.zza;
    private Boolean zzc;

    public final double zza(String str, zzfi<Double> zzfi) {
        if (str == null) {
            return zzfi.zza(null).doubleValue();
        }
        String zza2 = this.zzb.zza(str, zzfi.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfi.zza(null).doubleValue();
        }
        try {
            return zzfi.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
        } catch (NumberFormatException unused) {
            return zzfi.zza(null).doubleValue();
        }
    }

    /* access modifiers changed from: package-private */
    public final int zzc() {
        if (!zzot.zza() || !zze().zzf((String) null, zzbi.zzcc) || !zzq().zza(231100000, true)) {
            return 0;
        }
        return 35;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str) {
        return zza(str, zzbi.zzah, 500, 2000);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        return (!zzoo.zza() || !zze().zzf((String) null, zzbi.zzcu)) ? 100 : 500;
    }

    /* access modifiers changed from: package-private */
    public final int zzc(String str) {
        return Math.max(zzb(str), 256);
    }

    public final int zzg() {
        return zzq().zza(201500000, true) ? 100 : 25;
    }

    public final int zzd(String str) {
        return zza(str, zzbi.zzai, 25, 100);
    }

    public final int zze(String str) {
        return zzb(str, zzbi.zzo);
    }

    public final int zzb(String str, zzfi<Integer> zzfi) {
        if (str == null) {
            return zzfi.zza(null).intValue();
        }
        String zza2 = this.zzb.zza(str, zzfi.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfi.zza(null).intValue();
        }
        try {
            return zzfi.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
        } catch (NumberFormatException unused) {
            return zzfi.zza(null).intValue();
        }
    }

    public final int zza(String str, zzfi<Integer> zzfi, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzfi), i2), i);
    }

    /* access modifiers changed from: package-private */
    public final long zzf(String str) {
        return zzc(str, zzbi.zza);
    }

    public static long zzh() {
        return zzbi.zzd.zza(null).longValue();
    }

    public static long zzm() {
        return zzbi.zzad.zza(null).longValue();
    }

    public final long zzc(String str, zzfi<Long> zzfi) {
        if (str == null) {
            return zzfi.zza(null).longValue();
        }
        String zza2 = this.zzb.zza(str, zzfi.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfi.zza(null).longValue();
        }
        try {
            return zzfi.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
        } catch (NumberFormatException unused) {
            return zzfi.zza(null).longValue();
        }
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    private final Bundle zzy() {
        try {
            if (zza().getPackageManager() == null) {
                zzj().zzg().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(zza().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzj().zzg().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzj().zzg().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
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

    @Pure
    public final /* bridge */ /* synthetic */ zzgy zzl() {
        return super.zzl();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zznd zzq() {
        return super.zzq();
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzg(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzy = zzy();
        if (zzy == null) {
            zzj().zzg().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzy.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzy.getBoolean(str));
        }
    }

    public final String zzn() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzo() {
        return zza("debug.deferred.deeplink", "");
    }

    public final String zzd(String str, zzfi<String> zzfi) {
        if (str == null) {
            return zzfi.zza(null);
        }
        return zzfi.zza(this.zzb.zza(str, zzfi.zza()));
    }

    /* access modifiers changed from: package-private */
    public final String zzh(String str) {
        return zzd(str, zzbi.zzal);
    }

    private final String zza(String str, String str2) {
        try {
            String str3 = (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
            Preconditions.checkNotNull(str3);
            return str3;
        } catch (ClassNotFoundException e) {
            zzj().zzg().zza("Could not find SystemProperties class", e);
            return str2;
        } catch (NoSuchMethodException e2) {
            zzj().zzg().zza("Could not find SystemProperties.get() method", e2);
            return str2;
        } catch (IllegalAccessException e3) {
            zzj().zzg().zza("Could not access SystemProperties.get()", e3);
            return str2;
        } catch (InvocationTargetException e4) {
            zzj().zzg().zza("SystemProperties.get() threw an exception", e4);
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzi(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzy()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzfr r4 = r3.zzj()
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzg()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zza()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzfr r0 = r3.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzaf.zzi(java.lang.String):java.util.List");
    }

    zzaf(zzhf zzhf) {
        super(zzhf);
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

    /* access modifiers changed from: package-private */
    public final void zza(zzah zzah) {
        this.zzb = zzah;
    }

    public final boolean zzp() {
        Boolean zzg = zzg("google_analytics_adid_collection_enabled");
        return zzg == null || zzg.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj(String str) {
        return zzf(str, zzbi.zzak);
    }

    public final boolean zza(zzfi<Boolean> zzfi) {
        return zzf((String) null, zzfi);
    }

    public final boolean zze(String str, zzfi<Boolean> zzfi) {
        return zzf(str, zzfi);
    }

    public final boolean zzf(String str, zzfi<Boolean> zzfi) {
        if (str == null) {
            return zzfi.zza(null).booleanValue();
        }
        String zza2 = this.zzb.zza(str, zzfi.zza());
        if (TextUtils.isEmpty(zza2)) {
            return zzfi.zza(null).booleanValue();
        }
        return zzfi.zza(Boolean.valueOf("1".equals(zza2))).booleanValue();
    }

    public final boolean zzk(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzu() {
        Boolean zzg = zzg("google_analytics_automatic_screen_reporting_enabled");
        return zzg == null || zzg.booleanValue();
    }

    public final boolean zzv() {
        Boolean zzg = zzg("firebase_analytics_collection_deactivated");
        return zzg != null && zzg.booleanValue();
    }

    public final boolean zzl(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        if (this.zza == null) {
            Boolean zzg = zzg("app_measurement_lite");
            this.zza = zzg;
            if (zzg == null) {
                this.zza = false;
            }
        }
        if (this.zza.booleanValue() || !this.zzu.zzag()) {
            return true;
        }
        return false;
    }

    @EnsuresNonNull({"this.isMainProcess"})
    public final boolean zzx() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zza().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzj().zzg().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }
}
