package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.StandardClassIds;

/* compiled from: FakePureImplementationsProvider.kt */
public final class FakePureImplementationsProvider {
    public static final FakePureImplementationsProvider INSTANCE;
    private static final Map<ClassId, ClassId> pureImplementationsClassIds;
    private static final Map<FqName, FqName> pureImplementationsFqNames;

    private FakePureImplementationsProvider() {
    }

    public final FqName getPurelyImplementedInterface(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "classFqName");
        return pureImplementationsFqNames.get(fqName);
    }

    static {
        FakePureImplementationsProvider fakePureImplementationsProvider = new FakePureImplementationsProvider();
        INSTANCE = fakePureImplementationsProvider;
        Map<ClassId, ClassId> linkedHashMap = new LinkedHashMap<>();
        pureImplementationsClassIds = linkedHashMap;
        fakePureImplementationsProvider.implementedWith(StandardClassIds.INSTANCE.getMutableList(), fakePureImplementationsProvider.fqNameListOf("java.util.ArrayList", "java.util.LinkedList"));
        fakePureImplementationsProvider.implementedWith(StandardClassIds.INSTANCE.getMutableSet(), fakePureImplementationsProvider.fqNameListOf("java.util.HashSet", "java.util.TreeSet", "java.util.LinkedHashSet"));
        fakePureImplementationsProvider.implementedWith(StandardClassIds.INSTANCE.getMutableMap(), fakePureImplementationsProvider.fqNameListOf("java.util.HashMap", "java.util.TreeMap", "java.util.LinkedHashMap", "java.util.concurrent.ConcurrentHashMap", "java.util.concurrent.ConcurrentSkipListMap"));
        ClassId classId = ClassId.topLevel(new FqName("java.util.function.Function"));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(\"java.util.function.Function\"))");
        fakePureImplementationsProvider.implementedWith(classId, fakePureImplementationsProvider.fqNameListOf("java.util.function.UnaryOperator"));
        ClassId classId2 = ClassId.topLevel(new FqName("java.util.function.BiFunction"));
        Intrinsics.checkNotNullExpressionValue(classId2, "topLevel(FqName(\"java.util.function.BiFunction\"))");
        fakePureImplementationsProvider.implementedWith(classId2, fakePureImplementationsProvider.fqNameListOf("java.util.function.BinaryOperator"));
        Collection arrayList = new ArrayList(linkedHashMap.size());
        for (Map.Entry next : linkedHashMap.entrySet()) {
            arrayList.add(TuplesKt.to(((ClassId) next.getKey()).asSingleFqName(), ((ClassId) next.getValue()).asSingleFqName()));
        }
        pureImplementationsFqNames = MapsKt.toMap((List) arrayList);
    }

    private final void implementedWith(ClassId classId, List<ClassId> list) {
        Map<ClassId, ClassId> map = pureImplementationsClassIds;
        for (Object next : list) {
            ClassId classId2 = (ClassId) next;
            map.put(next, classId);
        }
    }

    private final List<ClassId> fqNameListOf(String... strArr) {
        Collection arrayList = new ArrayList(strArr.length);
        for (String fqName : strArr) {
            arrayList.add(ClassId.topLevel(new FqName(fqName)));
        }
        return (List) arrayList;
    }
}
