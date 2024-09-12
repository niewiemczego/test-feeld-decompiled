package kotlin.reflect.jvm.internal.calls;

import com.braze.ui.actions.brazeactions.steps.StepData;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001\"\b\b\u0000\u0010\u0003*\u00020\u00012\u000e\u0010\u0004\u001a\n \u0002*\u0004\u0018\u00010\u00010\u00012\u000e\u0010\u0005\u001a\n \u0002*\u0004\u0018\u00010\u00060\u00062,\u0010\u0007\u001a(\u0012\f\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001 \u0002*\u0014\u0012\u000e\b\u0001\u0012\n \u0002*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\b0\bH\n¢\u0006\u0004\b\t\u0010\n"}, d2 = {"<anonymous>", "", "kotlin.jvm.PlatformType", "T", "<anonymous parameter 0>", "method", "Ljava/lang/reflect/Method;", "args", "", "invoke", "(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: AnnotationConstructorCaller.kt */
final class AnnotationConstructorCallerKt$createAnnotationInstance$result$1 implements InvocationHandler {
    final /* synthetic */ Class<T> $annotationClass;
    final /* synthetic */ Lazy<Integer> $hashCode$delegate;
    final /* synthetic */ List<Method> $methods;
    final /* synthetic */ Lazy<String> $toString$delegate;
    final /* synthetic */ Map<String, Object> $values;

    AnnotationConstructorCallerKt$createAnnotationInstance$result$1(Class<T> cls, Map<String, ? extends Object> map, Lazy<String> lazy, Lazy<Integer> lazy2, List<Method> list) {
        this.$annotationClass = cls;
        this.$values = map;
        this.$toString$delegate = lazy;
        this.$hashCode$delegate = lazy2;
        this.$methods = list;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        String name = method.getName();
        if (name != null) {
            int hashCode = name.hashCode();
            if (hashCode != -1776922004) {
                if (hashCode != 147696667) {
                    if (hashCode == 1444986633 && name.equals("annotationType")) {
                        return this.$annotationClass;
                    }
                } else if (name.equals("hashCode")) {
                    return Integer.valueOf(AnnotationConstructorCallerKt.m2266createAnnotationInstance$lambda2(this.$hashCode$delegate));
                }
            } else if (name.equals("toString")) {
                return AnnotationConstructorCallerKt.m2267createAnnotationInstance$lambda3(this.$toString$delegate);
            }
        }
        if (Intrinsics.areEqual((Object) name, (Object) "equals")) {
            boolean z = true;
            if (objArr == null || objArr.length != 1) {
                z = false;
            }
            if (z) {
                Class<T> cls = this.$annotationClass;
                List<Method> list = this.$methods;
                Map<String, Object> map = this.$values;
                Intrinsics.checkNotNullExpressionValue(objArr, StepData.ARGS);
                return Boolean.valueOf(AnnotationConstructorCallerKt.createAnnotationInstance$equals(cls, list, map, ArraysKt.single((T[]) objArr)));
            }
        }
        if (this.$values.containsKey(name)) {
            return this.$values.get(name);
        }
        StringBuilder append = new StringBuilder().append("Method is not supported: ").append(method).append(" (args: ");
        if (objArr == null) {
            objArr = new Object[0];
        }
        throw new KotlinReflectionInternalError(append.append(ArraysKt.toList((T[]) objArr)).append(')').toString());
    }
}
