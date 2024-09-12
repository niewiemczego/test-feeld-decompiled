package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import expo.modules.interfaces.permissions.PermissionsResponse;
import java.util.EnumMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzih {
    public static final zzih zza = new zzih((Boolean) null, (Boolean) null, 100);
    private final EnumMap<zza, Boolean> zzb;
    private final int zzc;

    static String zza(int i) {
        return i != -20 ? i != -10 ? i != 0 ? i != 30 ? i != 90 ? i != 100 ? "OTHER" : "UNKNOWN" : "REMOTE_CONFIG" : "1P_INIT" : "1P_API" : "MANIFEST" : "API";
    }

    static String zza(boolean z) {
        return z ? PermissionsResponse.GRANTED_KEY : "denied";
    }

    public static boolean zza(int i, int i2) {
        return i <= i2;
    }

    static char zza(Boolean bool) {
        if (bool == null) {
            return '-';
        }
        return bool.booleanValue() ? '1' : '0';
    }

    /* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
    public enum zza {
        AD_STORAGE("ad_storage"),
        ANALYTICS_STORAGE("analytics_storage"),
        AD_USER_DATA("ad_user_data"),
        AD_PERSONALIZATION("ad_personalization");
        
        public final String zze;

        private zza(String str) {
            this.zze = str;
        }
    }

    private static int zzb(Boolean bool) {
        if (bool == null) {
            return 0;
        }
        return bool.booleanValue() ? 1 : 2;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int hashCode() {
        int i = this.zzc * 17;
        for (Boolean zzb2 : this.zzb.values()) {
            i = (i * 31) + zzb(zzb2);
        }
        return i;
    }

    public final Bundle zzb() {
        Bundle bundle = new Bundle();
        for (Map.Entry next : this.zzb.entrySet()) {
            Boolean bool = (Boolean) next.getValue();
            if (bool != null) {
                bundle.putString(((zza) next.getKey()).zze, zza(bool.booleanValue()));
            }
        }
        return bundle;
    }

    public static zzih zza(Bundle bundle, int i) {
        if (bundle == null) {
            return new zzih((Boolean) null, (Boolean) null, i);
        }
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zza2 : zzig.STORAGE.zzd) {
            enumMap.put(zza2, zzb(bundle.getString(zza2.zze)));
        }
        return new zzih(enumMap, i);
    }

    public static zzih zza(String str) {
        return zza(str, 100);
    }

    public static zzih zza(String str, int i) {
        EnumMap enumMap = new EnumMap(zza.class);
        if (str != null) {
            zza[] zza2 = zzig.STORAGE.zza();
            for (int i2 = 0; i2 < zza2.length; i2++) {
                zza zza3 = zza2[i2];
                int i3 = i2 + 2;
                if (i3 < str.length()) {
                    enumMap.put(zza3, zza(str.charAt(i3)));
                }
            }
        }
        return new zzih(enumMap, i);
    }

    public final zzih zza(zzih zzih) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zza2 : zzig.STORAGE.zzd) {
            Boolean bool = this.zzb.get(zza2);
            Boolean bool2 = zzih.zzb.get(zza2);
            if (bool == null) {
                bool = bool2;
            } else if (bool2 != null) {
                bool = Boolean.valueOf(bool.booleanValue() && bool2.booleanValue());
            }
            enumMap.put(zza2, bool);
        }
        return new zzih(enumMap, 100);
    }

    public final zzih zzb(zzih zzih) {
        EnumMap enumMap = new EnumMap(zza.class);
        for (zza zza2 : zzig.STORAGE.zzd) {
            Boolean bool = this.zzb.get(zza2);
            if (bool == null) {
                bool = zzih.zzb.get(zza2);
            }
            enumMap.put(zza2, bool);
        }
        return new zzih(enumMap, this.zzc);
    }

    static Boolean zzb(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(PermissionsResponse.GRANTED_KEY)) {
            return Boolean.TRUE;
        }
        if (str.equals("denied")) {
            return Boolean.FALSE;
        }
        return null;
    }

    static Boolean zza(char c) {
        if (c == '0') {
            return Boolean.FALSE;
        }
        if (c != '1') {
            return null;
        }
        return Boolean.TRUE;
    }

    public final Boolean zzc() {
        return this.zzb.get(zza.AD_STORAGE);
    }

    public final Boolean zzd() {
        return this.zzb.get(zza.ANALYTICS_STORAGE);
    }

    public static String zza(Bundle bundle) {
        String string;
        for (zza zza2 : zzig.STORAGE.zzd) {
            if (bundle.containsKey(zza2.zze) && (string = bundle.getString(zza2.zze)) != null && zzb(string) == null) {
                return string;
            }
        }
        return null;
    }

    public final String zze() {
        StringBuilder sb = new StringBuilder("G1");
        for (zza zza2 : zzig.STORAGE.zza()) {
            sb.append(zza(this.zzb.get(zza2)));
        }
        return sb.toString();
    }

    public final String zzf() {
        char c;
        StringBuilder sb = new StringBuilder("G2");
        for (zza zza2 : zzig.STORAGE.zza()) {
            Boolean bool = this.zzb.get(zza2);
            if (bool == null) {
                c = 'g';
            } else {
                c = bool.booleanValue() ? 'G' : 'D';
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public final String toString() {
        StringBuilder append = new StringBuilder("source=").append(zza(this.zzc));
        for (zza zza2 : zzig.STORAGE.zzd) {
            append.append(",");
            append.append(zza2.zze);
            append.append("=");
            Boolean bool = this.zzb.get(zza2);
            if (bool == null) {
                append.append("uninitialized");
            } else {
                append.append(bool.booleanValue() ? PermissionsResponse.GRANTED_KEY : "denied");
            }
        }
        return append.toString();
    }

    private zzih(EnumMap<zza, Boolean> enumMap, int i) {
        EnumMap<zza, Boolean> enumMap2 = new EnumMap<>(zza.class);
        this.zzb = enumMap2;
        enumMap2.putAll(enumMap);
        this.zzc = i;
    }

    public zzih(Boolean bool, Boolean bool2, int i) {
        EnumMap<zza, Boolean> enumMap = new EnumMap<>(zza.class);
        this.zzb = enumMap;
        enumMap.put(zza.AD_STORAGE, bool);
        enumMap.put(zza.ANALYTICS_STORAGE, bool2);
        this.zzc = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzih)) {
            return false;
        }
        zzih zzih = (zzih) obj;
        for (zza zza2 : zzig.STORAGE.zzd) {
            if (zzb(this.zzb.get(zza2)) != zzb(zzih.zzb.get(zza2))) {
                return false;
            }
        }
        if (this.zzc == zzih.zzc) {
            return true;
        }
        return false;
    }

    public final boolean zza(zzih zzih, zza... zzaArr) {
        for (zza zza2 : zzaArr) {
            if (!zzih.zza(zza2) && zza(zza2)) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzg() {
        return zza(zza.AD_STORAGE);
    }

    public final boolean zza(zza zza2) {
        Boolean bool = this.zzb.get(zza2);
        return bool == null || bool.booleanValue();
    }

    public final boolean zzh() {
        return zza(zza.ANALYTICS_STORAGE);
    }

    public final boolean zzi() {
        for (Boolean bool : this.zzb.values()) {
            if (bool != null) {
                return true;
            }
        }
        return false;
    }

    public final boolean zzc(zzih zzih) {
        return zzb(zzih, (zza[]) this.zzb.keySet().toArray(new zza[0]));
    }

    public final boolean zzb(zzih zzih, zza... zzaArr) {
        for (zza zza2 : zzaArr) {
            Boolean bool = this.zzb.get(zza2);
            Boolean bool2 = zzih.zzb.get(zza2);
            if (bool == Boolean.FALSE && bool2 != Boolean.FALSE) {
                return true;
            }
        }
        return false;
    }
}
