package com.google.android.recaptcha.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public abstract class zzce implements InvocationHandler {
    private final Object zza;

    public zzce(Object obj) {
        this.zza = obj;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object obj2;
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "toString") && method.getParameterTypes().length == 0) {
            return "Proxy@".concat(String.valueOf(Integer.toHexString(obj.hashCode())));
        }
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "hashCode") && method.getParameterTypes().length == 0) {
            return Integer.valueOf(System.identityHashCode(obj));
        }
        if (Intrinsics.areEqual((Object) method.getName(), (Object) "equals") && method.getParameterTypes().length != 0) {
            boolean z = false;
            if (!(objArr == null || objArr.length == 0)) {
                Object obj3 = objArr[0];
                if ((obj3 != null ? obj3.hashCode() : 0) == obj.hashCode()) {
                    z = true;
                }
            }
            return Boolean.valueOf(z);
        } else if (!zza(obj, method, objArr)) {
            return Unit.INSTANCE;
        } else {
            if ((this.zza != null || !Intrinsics.areEqual((Object) method.getReturnType(), (Object) Void.TYPE)) && ((obj2 = this.zza) == null || !Intrinsics.areEqual((Object) zzgd.zza(obj2.getClass()), (Object) zzgd.zza(method.getReturnType())))) {
                Object obj4 = this.zza;
                Class<?> returnType = method.getReturnType();
                throw new IllegalArgumentException(obj4 + " cannot be returned from method with return type " + returnType);
            }
            Object obj5 = this.zza;
            return obj5 == null ? Unit.INSTANCE : obj5;
        }
    }

    public abstract boolean zza(Object obj, Method method, Object[] objArr);
}
