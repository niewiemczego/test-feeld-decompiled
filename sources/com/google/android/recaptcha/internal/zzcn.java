package com.google.android.recaptcha.internal;

import java.lang.reflect.Array;
import java.util.List;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzcn implements zzdd {
    public static final zzcn zza = new zzcn();

    private zzcn() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        Object obj;
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
                            obj = String.valueOf(((String) zza2).charAt(intValue));
                        } else if (zza2 instanceof List) {
                            obj = ((List) zza2).get(intValue);
                        } else {
                            obj = Array.get(zza2, intValue);
                        }
                        zzcj.zzc().zzf(i, obj);
                    } catch (Exception e) {
                        if (e instanceof ArrayIndexOutOfBoundsException) {
                            throw new zzae(4, 22, e);
                        }
                        throw new zzae(4, 23, e);
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
