package com.google.android.recaptcha.internal;

import java.util.Collection;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.text.Charsets;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzcv implements zzdd {
    public static final zzcv zza = new zzcv();

    private zzcv() {
    }

    public final void zza(int i, zzcj zzcj, zzpq... zzpqArr) throws zzae {
        String str;
        String str2;
        zzpq[] zzpqArr2 = zzpqArr;
        if (zzpqArr2.length == 1) {
            Object zza2 = zzcj.zzc().zza(zzpqArr2[0]);
            if (true != (zza2 instanceof Object)) {
                zza2 = null;
            }
            if (zza2 != null) {
                if (zza2 instanceof int[]) {
                    str = ArraysKt.joinToString$default((int[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                } else {
                    if (zza2 instanceof byte[]) {
                        str2 = new String((byte[]) zza2, Charsets.UTF_8);
                    } else if (zza2 instanceof long[]) {
                        str = ArraysKt.joinToString$default((long[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof short[]) {
                        str = ArraysKt.joinToString$default((short[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof float[]) {
                        str = ArraysKt.joinToString$default((float[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof double[]) {
                        str = ArraysKt.joinToString$default((double[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof char[]) {
                        str2 = new String((char[]) zza2);
                    } else if (zza2 instanceof Object[]) {
                        str = ArraysKt.joinToString$default((Object[]) zza2, (CharSequence) ",", (CharSequence) "[", (CharSequence) "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else if (zza2 instanceof Collection) {
                        str = CollectionsKt.joinToString$default((Iterable) zza2, ",", "[", "]", 0, (CharSequence) null, (Function1) null, 56, (Object) null);
                    } else {
                        throw new zzae(4, 5, (Throwable) null);
                    }
                    str = str2;
                }
                int i2 = i;
                zzcj.zzc().zzf(i, str);
                return;
            }
            throw new zzae(4, 5, (Throwable) null);
        }
        throw new zzae(4, 3, (Throwable) null);
    }
}
