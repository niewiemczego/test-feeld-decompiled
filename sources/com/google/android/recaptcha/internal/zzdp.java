package com.google.android.recaptcha.internal;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import kotlin.collections.ArraysKt;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzdp implements zzdd {
    public static final zzdp zza = new zzdp();

    private zzdp() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        int length = zzpqArr.length;
        if (length != 0) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Constructor<?> constructor = zza2 instanceof Constructor ? (Constructor) zza2 : zza2.getClass().getConstructor(new Class[0]);
                Object[] zzh = zzcj.zzc().zzh(ArraysKt.toList((T[]) zzpqArr).subList(1, length));
                try {
                    zzcj.zzc().zzf(i, constructor.newInstance(Arrays.copyOf(zzh, zzh.length)));
                } catch (Exception e) {
                    throw new zzae(6, 14, e);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
