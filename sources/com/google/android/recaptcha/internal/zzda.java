package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzda implements zzdd {
    public static final zzda zza = new zzda();

    private zzda() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 2) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                Object zza3 = zzcj.zzc().zza(zzpqArr[1]);
                if (true != (zza3 instanceof Integer)) {
                    zza3 = null;
                }
                Integer num = (Integer) zza3;
                if (num != null) {
                    int intValue = num.intValue();
                    try {
                        if (zza2 instanceof String) {
                            zza2 = zzcj.zzh().zza((String) zza2);
                        }
                        zzcj.zzc().zzf(i, Array.newInstance(zzci.zza(zza2), intValue));
                    } catch (Exception e) {
                        throw new zzae(6, 21, e);
                    }
                } else {
                    throw new zzae(4, 5, (Throwable) null);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
