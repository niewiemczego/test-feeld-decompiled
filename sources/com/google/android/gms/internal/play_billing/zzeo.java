package com.google.android.gms.internal.play_billing;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzeo {
    private static final zzeo zzb = new zzeo(true);
    final zzgz zza = new zzgp(16);
    private boolean zzc;
    private boolean zzd;

    private zzeo() {
    }

    public static zzeo zza() {
        throw null;
    }

    private static final void zzd(zzen zzen, Object obj) {
        boolean z;
        zzht zzb2 = zzen.zzb();
        byte[] bArr = zzfd.zzd;
        obj.getClass();
        zzht zzht = zzht.DOUBLE;
        zzhu zzhu = zzhu.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z = obj instanceof Integer;
                break;
            case 1:
                z = obj instanceof Long;
                break;
            case 2:
                z = obj instanceof Float;
                break;
            case 3:
                z = obj instanceof Double;
                break;
            case 4:
                z = obj instanceof Boolean;
                break;
            case 5:
                z = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzdw) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzez)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzgc) || (obj instanceof zzfh)) {
                    return;
                }
        }
        if (z) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzen.zza()), zzen.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzeo zzeo = new zzeo();
        for (int i = 0; i < this.zza.zzb(); i++) {
            Map.Entry zzg = this.zza.zzg(i);
            zzeo.zzc((zzen) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzeo.zzc((zzen) entry.getKey(), entry.getValue());
        }
        zzeo.zzd = this.zzd;
        return zzeo;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzeo)) {
            return false;
        }
        return this.zza.equals(((zzeo) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i = 0; i < this.zza.zzb(); i++) {
                Map.Entry zzg = this.zza.zzg(i);
                if (zzg.getValue() instanceof zzex) {
                    ((zzex) zzg.getValue()).zzn();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzen zzen, Object obj) {
        if (!zzen.zzc()) {
            zzd(zzen, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                zzd(zzen, arrayList.get(i));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzfh) {
            this.zzd = true;
        }
        this.zza.put(zzen, obj);
    }

    private zzeo(boolean z) {
        zzb();
        zzb();
    }
}
