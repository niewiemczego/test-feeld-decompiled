package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzcf extends zzce {
    private final Function2 zza;
    private final String zzb;

    public zzcf(Function2 function2, String str, Object obj) {
        super(obj);
        this.zza = function2;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!Intrinsics.areEqual((Object) method.getName(), (Object) this.zzb)) {
            return false;
        }
        zzpi zzf = zzpl.zzf();
        if (objArr != null) {
            list = new ArrayList(objArr.length);
            for (Object obj2 : objArr) {
                zzpj zzf2 = zzpk.zzf();
                zzf2.zzv(obj2.toString());
                list.add((zzpk) zzf2.zzj());
            }
        } else {
            list = CollectionsKt.emptyList();
        }
        zzf.zzd(list);
        Function2 function2 = this.zza;
        byte[] zzd = ((zzpl) zzf.zzj()).zzd();
        function2.invoke(objArr, zzfy.zzh().zzi(zzd, 0, zzd.length));
        return true;
    }
}
