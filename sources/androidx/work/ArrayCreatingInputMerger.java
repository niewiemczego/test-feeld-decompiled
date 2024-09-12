package androidx.work;

import androidx.work.Data;
import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u001e\u0010\f\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0002J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0010H\u0016¨\u0006\u0011"}, d2 = {"Landroidx/work/ArrayCreatingInputMerger;", "Landroidx/work/InputMerger;", "()V", "concatenateArrayAndNonArray", "", "array", "obj", "valueClass", "Ljava/lang/Class;", "concatenateArrays", "array1", "array2", "createArrayFor", "merge", "Landroidx/work/Data;", "inputs", "", "work-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ArrayCreatingInputMerger.kt */
public final class ArrayCreatingInputMerger extends InputMerger {
    public Data merge(List<Data> list) {
        Class cls;
        Intrinsics.checkNotNullParameter(list, "inputs");
        Data.Builder builder = new Data.Builder();
        Map hashMap = new HashMap();
        for (Data keyValueMap : list) {
            Map<String, Object> keyValueMap2 = keyValueMap.getKeyValueMap();
            Intrinsics.checkNotNullExpressionValue(keyValueMap2, "input.keyValueMap");
            Iterator<Map.Entry<String, Object>> it = keyValueMap2.entrySet().iterator();
            while (true) {
                if (it.hasNext()) {
                    Map.Entry next = it.next();
                    String str = (String) next.getKey();
                    Object value = next.getValue();
                    if (value == null || (cls = value.getClass()) == null) {
                        cls = String.class;
                    }
                    Object obj = hashMap.get(str);
                    Intrinsics.checkNotNullExpressionValue(str, "key");
                    if (obj != null) {
                        Class<?> cls2 = obj.getClass();
                        if (Intrinsics.areEqual((Object) cls2, (Object) cls)) {
                            Intrinsics.checkNotNullExpressionValue(value, "value");
                            value = concatenateArrays(obj, value);
                        } else if (Intrinsics.areEqual((Object) cls2.getComponentType(), (Object) cls)) {
                            value = concatenateArrayAndNonArray(obj, value, cls);
                        } else {
                            throw new IllegalArgumentException();
                        }
                    } else if (!cls.isArray()) {
                        value = createArrayFor(value, cls);
                    }
                    Intrinsics.checkNotNullExpressionValue(value, "if (existingValue == nul…      }\n                }");
                    hashMap.put(str, value);
                }
            }
        }
        builder.putAll((Map<String, Object>) hashMap);
        Data build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "output.build()");
        return build;
    }

    private final Object concatenateArrays(Object obj, Object obj2) {
        int length = Array.getLength(obj);
        int length2 = Array.getLength(obj2);
        Class<?> componentType = obj.getClass().getComponentType();
        Intrinsics.checkNotNull(componentType);
        Object newInstance = Array.newInstance(componentType, length + length2);
        System.arraycopy(obj, 0, newInstance, 0, length);
        System.arraycopy(obj2, 0, newInstance, length, length2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }

    private final Object concatenateArrayAndNonArray(Object obj, Object obj2, Class<?> cls) {
        int length = Array.getLength(obj);
        Object newInstance = Array.newInstance(cls, length + 1);
        System.arraycopy(obj, 0, newInstance, 0, length);
        Array.set(newInstance, length, obj2);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }

    private final Object createArrayFor(Object obj, Class<?> cls) {
        Object newInstance = Array.newInstance(cls, 1);
        Array.set(newInstance, 0, obj);
        Intrinsics.checkNotNullExpressionValue(newInstance, "newArray");
        return newInstance;
    }
}
