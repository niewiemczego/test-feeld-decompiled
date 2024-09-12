package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zznw;
import com.google.android.gms.measurement.internal.zzih;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
final class zzgd extends zzic {
    static final Pair<String, Long> zza = new Pair<>("", 0L);
    public zzgh zzb;
    public final zzgi zzc = new zzgi(this, "first_open_time", 0);
    public final zzgi zzd = new zzgi(this, "app_install_time", 0);
    public final zzgj zze = new zzgj(this, "app_instance_id", (String) null);
    public final zzgi zzf = new zzgi(this, "session_timeout", 1800000);
    public final zzgg zzg = new zzgg(this, "start_new_session", true);
    public final zzgj zzh = new zzgj(this, "non_personalized_ads", (String) null);
    public final zzgf zzi = new zzgf(this, "last_received_uri_timestamps_by_source", (Bundle) null);
    public final zzgg zzj = new zzgg(this, "allow_remote_dynamite", false);
    public final zzgi zzk = new zzgi(this, "last_pause_time", 0);
    public final zzgi zzl = new zzgi(this, "session_id", 0);
    public boolean zzm;
    public zzgg zzn = new zzgg(this, "app_backgrounded", false);
    public zzgg zzo = new zzgg(this, "deep_link_retrieval_complete", false);
    public zzgi zzp = new zzgi(this, "deep_link_retrieval_attempts", 0);
    public final zzgj zzq = new zzgj(this, "firebase_feature_rollouts", (String) null);
    public final zzgj zzr = new zzgj(this, "deferred_attribution_cache", (String) null);
    public final zzgi zzs = new zzgi(this, "deferred_attribution_cache_timestamp", 0);
    public final zzgf zzt = new zzgf(this, "default_event_parameters", (Bundle) null);
    private SharedPreferences zzv;
    private String zzw;
    private boolean zzx;
    private long zzy;

    /* access modifiers changed from: protected */
    public final SharedPreferences zzc() {
        zzt();
        zzab();
        Preconditions.checkNotNull(this.zzv);
        return this.zzv;
    }

    /* access modifiers changed from: protected */
    public final boolean zzo() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final Pair<String, Boolean> zza(String str) {
        zzt();
        if (zznw.zza() && zze().zza(zzbi.zzck) && !zzm().zza(zzih.zza.AD_STORAGE)) {
            return new Pair<>("", false);
        }
        long elapsedRealtime = zzb().elapsedRealtime();
        if (this.zzw != null && elapsedRealtime < this.zzy) {
            return new Pair<>(this.zzw, Boolean.valueOf(this.zzx));
        }
        this.zzy = elapsedRealtime + zze().zzf(str);
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(zza());
            this.zzw = "";
            String id = advertisingIdInfo.getId();
            if (id != null) {
                this.zzw = id;
            }
            this.zzx = advertisingIdInfo.isLimitAdTrackingEnabled();
        } catch (Exception e) {
            zzj().zzc().zza("Unable to get advertising id", e);
            this.zzw = "";
        }
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair<>(this.zzw, Boolean.valueOf(this.zzx));
    }

    /* access modifiers changed from: package-private */
    public final SparseArray<Long> zzg() {
        Bundle zza2 = this.zzi.zza();
        if (zza2 == null) {
            return new SparseArray<>();
        }
        int[] intArray = zza2.getIntArray("uriSources");
        long[] longArray = zza2.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray<>();
        }
        if (intArray.length != longArray.length) {
            zzj().zzg().zza("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray<>();
        }
        SparseArray<Long> sparseArray = new SparseArray<>();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    /* access modifiers changed from: package-private */
    public final zzay zzh() {
        zzt();
        return zzay.zza(zzc().getString("dma_consent_settings", (String) null));
    }

    /* access modifiers changed from: package-private */
    public final zzih zzm() {
        zzt();
        return zzih.zza(zzc().getString("consent_settings", "G1"), zzc().getInt("consent_source", 100));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzn() {
        zzt();
        if (!zzc().contains("use_service")) {
            return null;
        }
        return Boolean.valueOf(zzc().getBoolean("use_service", false));
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzp() {
        zzt();
        if (zzc().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(zzc().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzu() {
        zzt();
        if (zzc().contains("measurement_enabled")) {
            return Boolean.valueOf(zzc().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final String zzv() {
        zzt();
        String string = zzc().getString("previous_os_version", (String) null);
        zzf().zzab();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor edit = zzc().edit();
            edit.putString("previous_os_version", str);
            edit.apply();
        }
        return string;
    }

    /* access modifiers changed from: package-private */
    public final String zzw() {
        zzt();
        return zzc().getString("admob_app_id", (String) null);
    }

    /* access modifiers changed from: package-private */
    public final String zzx() {
        zzt();
        return zzc().getString("gmp_app_id", (String) null);
    }

    zzgd(zzhf zzhf) {
        super(zzhf);
    }

    /* access modifiers changed from: package-private */
    public final void zzy() {
        zzt();
        Boolean zzu = zzu();
        SharedPreferences.Editor edit = zzc().edit();
        edit.clear();
        edit.apply();
        if (zzu != null) {
            zza(zzu);
        }
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNull.List({@EnsuresNonNull({"this.preferences"}), @EnsuresNonNull({"this.monitoringSample"})})
    public final void zzz() {
        SharedPreferences sharedPreferences = zza().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.zzv = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.zzm = z;
        if (!z) {
            SharedPreferences.Editor edit = this.zzv.edit();
            edit.putBoolean("has_been_opened", true);
            edit.apply();
        }
        this.zzb = new zzgh(this, "health_monitor", Math.max(0, zzbi.zzc.zza(null).longValue()));
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str) {
        zzt();
        SharedPreferences.Editor edit = zzc().edit();
        edit.putString("admob_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzc(String str) {
        zzt();
        SharedPreferences.Editor edit = zzc().edit();
        edit.putString("gmp_app_id", str);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzc().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(Boolean bool) {
        zzt();
        SharedPreferences.Editor edit = zzc().edit();
        if (bool != null) {
            edit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            edit.remove("measurement_enabled_from_api");
        }
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zza(boolean z) {
        zzt();
        SharedPreferences.Editor edit = zzc().edit();
        edit.putBoolean("use_service", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final void zzb(boolean z) {
        zzt();
        zzj().zzp().zza("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor edit = zzc().edit();
        edit.putBoolean("deferred_analytics_collection", z);
        edit.apply();
    }

    /* access modifiers changed from: package-private */
    public final boolean zzaa() {
        SharedPreferences sharedPreferences = this.zzv;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j) {
        return j - this.zzf.zza() > this.zzk.zza();
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzih zzih) {
        zzt();
        int zza2 = zzih.zza();
        if (!zza(zza2)) {
            return false;
        }
        SharedPreferences.Editor edit = zzc().edit();
        edit.putString("consent_settings", zzih.zze());
        edit.putInt("consent_source", zza2);
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzay zzay) {
        zzt();
        if (!zzih.zza(zzay.zza(), zzh().zza())) {
            return false;
        }
        SharedPreferences.Editor edit = zzc().edit();
        edit.putString("dma_consent_settings", zzay.zzf());
        edit.apply();
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(int i) {
        return zzih.zza(i, zzc().getInt("consent_source", 100));
    }
}
