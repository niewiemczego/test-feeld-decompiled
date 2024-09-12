package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import androidx.collection.ArrayMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public final class zzdd implements zzcl {
    private static final Map zza = new ArrayMap();
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static zzdd zza(Context context, String str, Runnable runnable) {
        zzdd zzdd;
        if (!zzcc.zzb()) {
            synchronized (zzdd.class) {
                zzdd = (zzdd) zza.get((Object) null);
                if (zzdd == null) {
                    StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    try {
                        throw null;
                    } catch (Throwable th) {
                        StrictMode.setThreadPolicy(allowThreadDiskReads);
                        throw th;
                    }
                }
            }
            return zzdd;
        }
        throw null;
    }

    static synchronized void zzc() {
        synchronized (zzdd.class) {
            Map map = zza;
            Iterator it = map.values().iterator();
            if (!it.hasNext()) {
                map.clear();
            } else {
                zzdd zzdd = (zzdd) it.next();
                SharedPreferences sharedPreferences = zzdd.zzb;
                SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = zzdd.zzc;
                throw null;
            }
        }
    }

    public final Object zzb(String str) {
        throw null;
    }
}
