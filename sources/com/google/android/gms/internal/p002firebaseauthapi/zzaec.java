package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.collection.ArrayMap;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.FirebaseApp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaec  reason: invalid package */
/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzaec {
    private static final Map<String, zzaeb> zza = new ArrayMap();
    private static final Map<String, List<WeakReference<zzaee>>> zzb = new ArrayMap();

    private static String zza(String str, int i, boolean z) {
        if (z) {
            return "http://[" + str + "]:" + i + "/";
        }
        return "http://" + str + CertificateUtil.DELIMITER + i + "/";
    }

    public static String zza(String str) {
        zzaeb zzaeb;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaeb = map.get(str);
        }
        if (zzaeb != null) {
            return zza(zzaeb.zzb(), zzaeb.zza(), zzaeb.zzb().contains(CertificateUtil.DELIMITER)) + "emulator/auth/handler";
        }
        throw new IllegalStateException("Tried to get the emulator widget endpoint, but no emulator endpoint overrides found.");
    }

    public static String zzb(String str) {
        zzaeb zzaeb;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaeb = map.get(str);
        }
        if (zzaeb != null) {
            str2 = "" + zza(zzaeb.zzb(), zzaeb.zza(), zzaeb.zzb().contains(CertificateUtil.DELIMITER));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "www.googleapis.com/identitytoolkit/v3/relyingparty";
    }

    public static String zzc(String str) {
        zzaeb zzaeb;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaeb = map.get(str);
        }
        if (zzaeb != null) {
            str2 = "" + zza(zzaeb.zzb(), zzaeb.zza(), zzaeb.zzb().contains(CertificateUtil.DELIMITER));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "identitytoolkit.googleapis.com/v2";
    }

    public static String zzd(String str) {
        zzaeb zzaeb;
        String str2;
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            zzaeb = map.get(str);
        }
        if (zzaeb != null) {
            str2 = "" + zza(zzaeb.zzb(), zzaeb.zza(), zzaeb.zzb().contains(CertificateUtil.DELIMITER));
        } else {
            str2 = "" + "https://";
        }
        return str2 + "securetoken.googleapis.com/v1";
    }

    public static void zza(String str, zzaee zzaee) {
        Map<String, List<WeakReference<zzaee>>> map = zzb;
        synchronized (map) {
            if (map.containsKey(str)) {
                map.get(str).add(new WeakReference(zzaee));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new WeakReference(zzaee));
                map.put(str, arrayList);
            }
        }
    }

    public static void zza(FirebaseApp firebaseApp, String str, int i) {
        String apiKey = firebaseApp.getOptions().getApiKey();
        Map<String, zzaeb> map = zza;
        synchronized (map) {
            map.put(apiKey, new zzaeb(str, i));
        }
        Map<String, List<WeakReference<zzaee>>> map2 = zzb;
        synchronized (map2) {
            if (map2.containsKey(apiKey)) {
                boolean z = false;
                for (WeakReference weakReference : map2.get(apiKey)) {
                    zzaee zzaee = (zzaee) weakReference.get();
                    if (zzaee != null) {
                        z = true;
                        zzaee.zza();
                    }
                }
                if (!z) {
                    zza.remove(apiKey);
                }
            }
        }
    }

    public static boolean zza(FirebaseApp firebaseApp) {
        return zza.containsKey(firebaseApp.getOptions().getApiKey());
    }
}
