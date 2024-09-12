package com.google.android.recaptcha.internal;

import java.io.Serializable;
import java.util.ArrayList;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzdb implements zzdd {
    public static final zzdb zza = new zzdb();

    private zzdb() {
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
                        if (zza2 instanceof Integer) {
                            obj = Integer.valueOf(((Number) zza2).intValue() / intValue);
                        } else if (zza2 instanceof int[]) {
                            ArrayList arrayList = new ArrayList(r4);
                            for (int i2 : (int[]) zza2) {
                                arrayList.add(Integer.valueOf(i2 / intValue));
                            }
                            obj = (Serializable) arrayList.toArray(new Integer[0]);
                        } else {
                            throw new zzae(4, 5, (Throwable) null);
                        }
                        zzcj.zzc().zzf(i, obj);
                    } catch (ArithmeticException e) {
                        throw new zzae(4, 6, e);
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
