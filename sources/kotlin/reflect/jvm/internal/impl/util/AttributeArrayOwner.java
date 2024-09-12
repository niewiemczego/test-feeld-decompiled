package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: AttributeArrayOwner.kt */
public abstract class AttributeArrayOwner<K, T> extends AbstractArrayMapOwner<K, T> {
    private ArrayMap<T> arrayMap;

    protected AttributeArrayOwner(ArrayMap<T> arrayMap2) {
        Intrinsics.checkNotNullParameter(arrayMap2, "arrayMap");
        this.arrayMap = arrayMap2;
    }

    /* access modifiers changed from: protected */
    public final ArrayMap<T> getArrayMap() {
        return this.arrayMap;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AttributeArrayOwner() {
        /*
            r2 = this;
            kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap r0 = kotlin.reflect.jvm.internal.impl.util.EmptyArrayMap.INSTANCE
            java.lang.String r1 = "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            kotlin.reflect.jvm.internal.impl.util.ArrayMap r0 = (kotlin.reflect.jvm.internal.impl.util.ArrayMap) r0
            r2.<init>(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner.<init>():void");
    }

    /* access modifiers changed from: protected */
    public final void registerComponent(KClass<? extends K> kClass, T t) {
        Intrinsics.checkNotNullParameter(kClass, "tClass");
        Intrinsics.checkNotNullParameter(t, "value");
        int id = getTypeRegistry().getId(kClass);
        int size = this.arrayMap.getSize();
        if (size != 0) {
            if (size == 1) {
                ArrayMap<T> arrayMap2 = this.arrayMap;
                Intrinsics.checkNotNull(arrayMap2, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
                OneElementArrayMap oneElementArrayMap = (OneElementArrayMap) arrayMap2;
                if (oneElementArrayMap.getIndex() == id) {
                    this.arrayMap = new OneElementArrayMap(t, id);
                    return;
                }
                ArrayMap<T> arrayMapImpl = new ArrayMapImpl<>();
                this.arrayMap = arrayMapImpl;
                arrayMapImpl.set(oneElementArrayMap.getIndex(), oneElementArrayMap.getValue());
            }
            this.arrayMap.set(id, t);
            return;
        }
        this.arrayMap = new OneElementArrayMap(t, id);
    }
}
