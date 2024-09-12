package com.google.android.recaptcha.internal;

import java.lang.reflect.Field;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzdt implements zzdd {
    public static final zzdt zza = new zzdt();

    private zzdt() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        if (zzpqArr.length == 3) {
            Object zza2 = zzcj.zzc().zza(zzpqArr[0]);
            if (true != (zza2 instanceof Field)) {
                zza2 = null;
            }
            Field field = (Field) zza2;
            if (field != null) {
                try {
                    field.set(zzcj.zzc().zza(zzpqArr[1]), zzcj.zzc().zza(zzpqArr[2]));
                } catch (Exception e) {
                    throw new zzae(6, 11, e);
                }
            } else {
                throw new zzae(4, 5, (Throwable) null);
            }
        } else {
            throw new zzae(4, 3, (Throwable) null);
        }
    }
}
