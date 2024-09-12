package com.google.android.recaptcha.internal;

import java.lang.reflect.Method;
import java.util.List;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzch extends zzce {
    private final zzcg zza;
    private final String zzb;

    public zzch(zzcg zzcg, String str, Object obj) {
        super(obj);
        this.zza = zzcg;
        this.zzb = str;
    }

    public final boolean zza(Object obj, Method method, Object[] objArr) {
        List list;
        if (!Intrinsics.areEqual((Object) method.getName(), (Object) this.zzb)) {
            return false;
        }
        zzcg zzcg = this.zza;
        if (objArr == null || (list = ArraysKt.asList((T[]) objArr)) == null) {
            list = CollectionsKt.emptyList();
        }
        zzcg.zzb(list);
        return true;
    }
}
