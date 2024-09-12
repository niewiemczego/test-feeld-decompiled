package com.google.android.recaptcha.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzct implements zzdd {
    public static final zzct zza = new zzct();

    private zzct() {
    }

    private static final boolean zzb(List list) {
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(Boolean.valueOf(((zzpq) it.next()).zzN()));
        }
        if (!arrayList.contains(false)) {
            return true;
        }
        return false;
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzb(ArraysKt.toList((T[]) zzpqArr))) {
            for (zzpq zzi : zzpqArr) {
                zzcj.zzc().zzb(zzi.zzi());
            }
            return;
        }
        throw new zzae(4, 5, (Throwable) null);
    }
}
