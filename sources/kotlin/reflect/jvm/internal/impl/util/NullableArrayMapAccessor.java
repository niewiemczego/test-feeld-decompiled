package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ReadOnlyProperty;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner;

/* compiled from: ArrayMapOwner.kt */
public final class NullableArrayMapAccessor<K, V, T extends V> extends AbstractArrayMapOwner.AbstractArrayMapAccessor<K, V, T> implements ReadOnlyProperty<AbstractArrayMapOwner<K, V>, V> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NullableArrayMapAccessor(KClass<? extends K> kClass, int i) {
        super(kClass, i);
        Intrinsics.checkNotNullParameter(kClass, "key");
    }

    public T getValue(AbstractArrayMapOwner<K, V> abstractArrayMapOwner, KProperty<?> kProperty) {
        Intrinsics.checkNotNullParameter(abstractArrayMapOwner, "thisRef");
        Intrinsics.checkNotNullParameter(kProperty, "property");
        return extractValue(abstractArrayMapOwner);
    }
}
