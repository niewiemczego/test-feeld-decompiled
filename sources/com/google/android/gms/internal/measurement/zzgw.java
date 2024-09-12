package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzgw implements zzgb {
    private static final Map<String, zzgw> zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final Runnable zzc;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzd;
    private final Object zze = new Object();
    private volatile Map<String, ?> zzf;
    private final List<zzfz> zzg = new ArrayList();

    private static SharedPreferences zza(Context context, String str) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (str.startsWith("direct_boot:")) {
                if (zzfw.zza()) {
                    context = context.createDeviceProtectedStorageContext();
                }
                return context.getSharedPreferences(str.substring(12), 0);
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            StrictMode.setThreadPolicy(allowThreadDiskReads);
            return sharedPreferences;
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    static zzgw zza(Context context, String str, Runnable runnable) {
        zzgw zzgw;
        if (!((!zzfw.zza() || str.startsWith("direct_boot:")) ? true : zzfw.zzb(context))) {
            return null;
        }
        synchronized (zzgw.class) {
            Map<String, zzgw> map = zza;
            zzgw = map.get(str);
            if (zzgw == null) {
                zzgw = new zzgw(zza(context, str), runnable);
                map.put(str, zzgw);
            }
        }
        return zzgw;
    }

    /* JADX INFO: finally extract failed */
    public final Object zza(String str) {
        Map<String, ?> map = this.zzf;
        if (map == null) {
            synchronized (this.zze) {
                map = this.zzf;
                if (map == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        Map<String, ?> all = this.zzb.getAll();
                        this.zzf = all;
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        map = all;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }

    private zzgw(SharedPreferences sharedPreferences, Runnable runnable) {
        zzgz zzgz = new zzgz(this);
        this.zzd = zzgz;
        this.zzb = sharedPreferences;
        this.zzc = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(zzgz);
    }

    static synchronized void zza() {
        synchronized (zzgw.class) {
            for (zzgw next : zza.values()) {
                next.zzb.unregisterOnSharedPreferenceChangeListener(next.zzd);
            }
            zza.clear();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(SharedPreferences sharedPreferences, String str) {
        synchronized (this.zze) {
            this.zzf = null;
            this.zzc.run();
        }
        synchronized (this) {
            for (zzfz zza2 : this.zzg) {
                zza2.zza();
            }
        }
    }
}
