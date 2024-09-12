package kotlin.reflect.jvm.internal.impl.util;

import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;

/* compiled from: ArrayMapOwner.kt */
public abstract class AbstractArrayMapOwner<K, V> implements Iterable<V>, KMappedMarker {
    /* access modifiers changed from: protected */
    public abstract ArrayMap<V> getArrayMap();

    /* access modifiers changed from: protected */
    public abstract TypeRegistry<K, V> getTypeRegistry();

    /* access modifiers changed from: protected */
    public abstract void registerComponent(KClass<? extends K> kClass, V v);

    /* compiled from: ArrayMapOwner.kt */
    public static abstract class AbstractArrayMapAccessor<K, V, T extends V> {
        private final int id;
        private final KClass<? extends K> key;

        public AbstractArrayMapAccessor(KClass<? extends K> kClass, int i) {
            Intrinsics.checkNotNullParameter(kClass, "key");
            this.key = kClass;
            this.id = i;
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner, kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V>, java.lang.Object] */
        /* access modifiers changed from: protected */
        /* JADX WARNING: Unknown variable types count: 1 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final T extractValue(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner<K, V> r2) {
            /*
                r1 = this;
                java.lang.String r0 = "thisRef"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
                kotlin.reflect.jvm.internal.impl.util.ArrayMap r2 = r2.getArrayMap()
                int r0 = r1.id
                java.lang.Object r2 = r2.get(r0)
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner.AbstractArrayMapAccessor.extractValue(kotlin.reflect.jvm.internal.impl.util.AbstractArrayMapOwner):java.lang.Object");
        }
    }

    public final Iterator<V> iterator() {
        return getArrayMap().iterator();
    }

    public final boolean isEmpty() {
        return getArrayMap().getSize() == 0;
    }
}
