package com.google.android.gms.internal.play_billing;

import java.util.Set;
import javax.annotation.CheckForNull;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
public abstract class zzaj extends zzac implements Set {
    @CheckForNull
    private transient zzaf zza;

    zzaj() {
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size() && containsAll(set)) {
                    return true;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public final int hashCode() {
        return zzar.zza(this);
    }

    public zzaf zzd() {
        zzaf zzaf = this.zza;
        if (zzaf != null) {
            return zzaf;
        }
        zzaf zzh = zzh();
        this.zza = zzh;
        return zzh;
    }

    /* renamed from: zze */
    public abstract zzas iterator();

    /* access modifiers changed from: package-private */
    public zzaf zzh() {
        Object[] array = toArray();
        int i = zzaf.zzd;
        return zzaf.zzi(array, array.length);
    }
}
