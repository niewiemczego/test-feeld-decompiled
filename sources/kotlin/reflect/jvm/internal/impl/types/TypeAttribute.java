package kotlin.reflect.jvm.internal.impl.types;

import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.types.TypeAttribute;

/* compiled from: TypeAttributes.kt */
public abstract class TypeAttribute<T extends TypeAttribute<T>> {
    public abstract T add(T t);

    public abstract KClass<? extends T> getKey();

    public abstract T intersect(T t);
}
