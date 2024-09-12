package com.google.android.gms.internal.measurement;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
public final class zzh {
    private final zzh zza;
    private zzbb zzb;
    private Map<String, zzaq> zzc = new HashMap();
    private Map<String, Boolean> zzd = new HashMap();

    public final zzh zza() {
        return new zzh(this, this.zzb);
    }

    public final zzaq zza(zzaq zzaq) {
        return this.zzb.zza(this, zzaq);
    }

    public final zzaq zza(zzaf zzaf) {
        zzaq zzaq = zzaq.zzc;
        Iterator<Integer> zzg = zzaf.zzg();
        while (zzg.hasNext()) {
            zzaq = this.zzb.zza(this, zzaf.zza(zzg.next().intValue()));
            if (zzaq instanceof zzaj) {
                break;
            }
        }
        return zzaq;
    }

    public final zzaq zza(String str) {
        zzh zzh = this;
        while (!zzh.zzc.containsKey(str)) {
            zzh = zzh.zza;
            if (zzh == null) {
                throw new IllegalArgumentException(String.format("%s is not defined", new Object[]{str}));
            }
        }
        return zzh.zzc.get(str);
    }

    public zzh(zzh zzh, zzbb zzbb) {
        this.zza = zzh;
        this.zzb = zzbb;
    }

    public final void zza(String str, zzaq zzaq) {
        if (this.zzd.containsKey(str)) {
            return;
        }
        if (zzaq == null) {
            this.zzc.remove(str);
        } else {
            this.zzc.put(str, zzaq);
        }
    }

    public final void zzb(String str, zzaq zzaq) {
        zza(str, zzaq);
        this.zzd.put(str, true);
    }

    public final void zzc(String str, zzaq zzaq) {
        zzh zzh = this;
        while (!zzh.zzc.containsKey(str) && (r1 = zzh.zza) != null && r1.zzb(str)) {
            zzh = zzh.zza;
        }
        if (zzh.zzd.containsKey(str)) {
            return;
        }
        if (zzaq == null) {
            zzh.zzc.remove(str);
        } else {
            zzh.zzc.put(str, zzaq);
        }
    }

    public final boolean zzb(String str) {
        zzh zzh = this;
        while (!zzh.zzc.containsKey(str)) {
            zzh = zzh.zza;
            if (zzh == null) {
                return false;
            }
        }
        return true;
    }
}
