package com.google.android.gms.internal.play_billing;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@6.1.0 */
final class zzcw extends AbstractMap {
    /* access modifiers changed from: private */
    public static final Comparator zza = new zzct();
    /* access modifiers changed from: private */
    public final Object[] zzb;
    /* access modifiers changed from: private */
    public final int[] zzc;
    private final Set zzd = new zzcv(this, -1);
    private Integer zze = null;
    private String zzf = null;

    zzcw(List list) {
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            int size = list.size();
            Object[] objArr = new Object[size];
            int[] iArr = new int[1];
            Iterator it2 = list.iterator();
            if (!it2.hasNext()) {
                iArr[0] = 0;
                if (size > 16 && size * 9 > 0) {
                    objArr = Arrays.copyOf(objArr, 0);
                }
                this.zzb = objArr;
                this.zzc = iArr;
                return;
            }
            String unused = ((zzcs) it2.next()).zza;
            throw null;
        }
        String unused2 = ((zzcs) it.next()).zza;
        throw null;
    }

    public final Set entrySet() {
        return this.zzd;
    }

    public final int hashCode() {
        if (this.zze == null) {
            this.zze = Integer.valueOf(super.hashCode());
        }
        return this.zze.intValue();
    }

    public final String toString() {
        if (this.zzf == null) {
            this.zzf = super.toString();
        }
        return this.zzf;
    }
}
