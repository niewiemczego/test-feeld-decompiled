package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzde implements zzdd {
    public static final zzde zza = new zzde();

    private zzde() {
    }

    private static final List zzc(Object obj) {
        if (obj instanceof byte[]) {
            return ArraysKt.toList((byte[]) obj);
        }
        if (obj instanceof short[]) {
            return ArraysKt.toList((short[]) obj);
        }
        if (obj instanceof int[]) {
            return ArraysKt.toList((int[]) obj);
        }
        if (obj instanceof long[]) {
            return ArraysKt.toList((long[]) obj);
        }
        if (obj instanceof float[]) {
            return ArraysKt.toList((float[]) obj);
        }
        if (!(obj instanceof double[])) {
            return null;
        }
        return ArraysKt.toList((double[]) obj);
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                if (true != (zza3 instanceof Object)) {
                    zza3 = null;
                }
                if (zza3 != null) {
                    zzcj.zzc().zzf(i, zzb(zza2, zza3));
                    return;
                }
                throw new zzae(4, 5, (Throwable) null);
            }
            throw new zzae(4, 5, (Throwable) null);
        }
        throw new zzae(4, 3, (Throwable) null);
    }

    public final Object zzb(Object obj, Object obj2) throws zzae {
        List<Number> zzc = zzc(obj);
        List<Number> zzc2 = zzc(obj2);
        if (obj instanceof Number) {
            if (obj2 instanceof Number) {
                return Double.valueOf(Math.pow(((Number) obj).doubleValue(), ((Number) obj2).doubleValue()));
            }
            if (zzc2 != null) {
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zzc2, 10));
                for (Number doubleValue : zzc2) {
                    arrayList.add(Double.valueOf(Math.pow(doubleValue.doubleValue(), ((Number) obj).doubleValue())));
                }
                return (Serializable) arrayList.toArray(new Double[0]);
            }
        }
        if (zzc != null && (obj2 instanceof Number)) {
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(zzc, 10));
            for (Number doubleValue2 : zzc) {
                arrayList2.add(Double.valueOf(Math.pow(doubleValue2.doubleValue(), ((Number) obj2).doubleValue())));
            }
            return (Serializable) arrayList2.toArray(new Double[0]);
        } else if (zzc == null || zzc2 == null) {
            throw new zzae(4, 5, (Throwable) null);
        } else {
            zzdc.zza(this, zzc.size(), zzc2.size());
            int size = zzc.size();
            Double[] dArr = new Double[size];
            for (int i = 0; i < size; i++) {
                dArr[i] = Double.valueOf(Math.pow(((Number) zzc.get(i)).doubleValue(), ((Number) zzc2.get(i)).doubleValue()));
            }
            return (Serializable) dArr;
        }
    }
}
