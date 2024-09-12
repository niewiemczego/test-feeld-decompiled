package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.reflect.KClass;
import kotlin.reflect.jvm.internal.impl.util.AttributeArrayOwner;
import kotlin.reflect.jvm.internal.impl.util.TypeRegistry;

/* compiled from: TypeAttributes.kt */
public final class TypeAttributes extends AttributeArrayOwner<TypeAttribute<?>, TypeAttribute<?>> implements Iterable<TypeAttribute<?>>, KMappedMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final TypeAttributes Empty = new TypeAttributes((List<? extends TypeAttribute<?>>) CollectionsKt.emptyList());

    public /* synthetic */ TypeAttributes(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this((List<? extends TypeAttribute<?>>) list);
    }

    private TypeAttributes(List<? extends TypeAttribute<?>> list) {
        for (TypeAttribute typeAttribute : list) {
            registerComponent(typeAttribute.getKey(), typeAttribute);
        }
    }

    /* compiled from: TypeAttributes.kt */
    public static final class Companion extends TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public <T extends TypeAttribute<?>> int customComputeIfAbsent(ConcurrentHashMap<KClass<? extends TypeAttribute<?>>, Integer> concurrentHashMap, KClass<T> kClass, Function1<? super KClass<? extends TypeAttribute<?>>, Integer> function1) {
            int intValue;
            Intrinsics.checkNotNullParameter(concurrentHashMap, "<this>");
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(function1, "compute");
            Integer num = concurrentHashMap.get(kClass);
            if (num != null) {
                return num.intValue();
            }
            synchronized (concurrentHashMap) {
                Integer num2 = concurrentHashMap.get(kClass);
                if (num2 == null) {
                    Integer invoke = function1.invoke(kClass);
                    concurrentHashMap.putIfAbsent(kClass, Integer.valueOf(invoke.intValue()));
                    num2 = invoke;
                }
                Intrinsics.checkNotNullExpressionValue(num2, "this[kClass] ?: compute(…putIfAbsent(kClass, it) }");
                intValue = num2.intValue();
            }
            return intValue;
        }

        public final TypeAttributes getEmpty() {
            return TypeAttributes.Empty;
        }

        public final TypeAttributes create(List<? extends TypeAttribute<?>> list) {
            Intrinsics.checkNotNullParameter(list, "attributes");
            if (list.isEmpty()) {
                return getEmpty();
            }
            return new TypeAttributes(list, (DefaultConstructorMarker) null);
        }
    }

    private TypeAttributes(TypeAttribute<?> typeAttribute) {
        this((List<? extends TypeAttribute<?>>) CollectionsKt.listOf(typeAttribute));
    }

    public final boolean contains(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        return getArrayMap().get(Companion.getId(typeAttribute.getKey())) != null;
    }

    public final TypeAttributes plus(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        if (contains(typeAttribute)) {
            return this;
        }
        if (isEmpty()) {
            return new TypeAttributes(typeAttribute);
        }
        return Companion.create(CollectionsKt.plus(CollectionsKt.toList(this), typeAttribute));
    }

    public final TypeAttributes remove(TypeAttribute<?> typeAttribute) {
        Intrinsics.checkNotNullParameter(typeAttribute, "attribute");
        if (isEmpty()) {
            return this;
        }
        Collection arrayList = new ArrayList();
        for (Object next : getArrayMap()) {
            if (!Intrinsics.areEqual((Object) (TypeAttribute) next, (Object) typeAttribute)) {
                arrayList.add(next);
            }
        }
        List list = (List) arrayList;
        if (list.size() == getArrayMap().getSize()) {
            return this;
        }
        return Companion.create(list);
    }

    /* access modifiers changed from: protected */
    public TypeRegistry<TypeAttribute<?>, TypeAttribute<?>> getTypeRegistry() {
        return Companion;
    }

    public final TypeAttributes intersect(TypeAttributes typeAttributes) {
        TypeAttribute typeAttribute;
        Intrinsics.checkNotNullParameter(typeAttributes, "other");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        List arrayList = new ArrayList();
        for (Number intValue : Companion.getIndices()) {
            int intValue2 = intValue.intValue();
            TypeAttribute typeAttribute2 = (TypeAttribute) getArrayMap().get(intValue2);
            TypeAttribute typeAttribute3 = (TypeAttribute) typeAttributes.getArrayMap().get(intValue2);
            if (typeAttribute2 == null) {
                typeAttribute = typeAttribute3 != null ? typeAttribute3.intersect(typeAttribute2) : null;
            } else {
                typeAttribute = typeAttribute2.intersect(typeAttribute3);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, typeAttribute);
        }
        return Companion.create(arrayList);
    }

    public final TypeAttributes add(TypeAttributes typeAttributes) {
        TypeAttribute typeAttribute;
        Intrinsics.checkNotNullParameter(typeAttributes, "other");
        if (isEmpty() && typeAttributes.isEmpty()) {
            return this;
        }
        List arrayList = new ArrayList();
        for (Number intValue : Companion.getIndices()) {
            int intValue2 = intValue.intValue();
            TypeAttribute typeAttribute2 = (TypeAttribute) getArrayMap().get(intValue2);
            TypeAttribute typeAttribute3 = (TypeAttribute) typeAttributes.getArrayMap().get(intValue2);
            if (typeAttribute2 == null) {
                typeAttribute = typeAttribute3 != null ? typeAttribute3.add(typeAttribute2) : null;
            } else {
                typeAttribute = typeAttribute2.add(typeAttribute3);
            }
            kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, typeAttribute);
        }
        return Companion.create(arrayList);
    }
}
