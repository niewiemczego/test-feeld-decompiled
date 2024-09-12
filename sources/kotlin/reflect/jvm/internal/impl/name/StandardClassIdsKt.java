package kotlin.reflect.jvm.internal.impl.name;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StandardClassIds.kt */
public final class StandardClassIdsKt {
    private static final FqName JAVA_LANG_ANNOTATION_PACKAGE;
    private static final FqName JAVA_LANG_PACKAGE;

    /* access modifiers changed from: private */
    public static final ClassId baseId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId unsignedId(ClassId classId) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_KOTLIN_PACKAGE(), Name.identifier('U' + classId.getShortClassName().getIdentifier()));
    }

    /* access modifiers changed from: private */
    public static final ClassId reflectId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_REFLECT_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId primitiveArrayId(Name name) {
        return new ClassId(StandardClassIds.INSTANCE.getArray().getPackageFqName(), Name.identifier(name.getIdentifier() + StandardClassIds.INSTANCE.getArray().getShortClassName().getIdentifier()));
    }

    /* access modifiers changed from: private */
    public static final ClassId collectionsId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COLLECTIONS_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId rangesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_RANGES_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId annotationId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_ANNOTATION_PACKAGE(), Name.identifier(str));
    }

    /* access modifiers changed from: private */
    public static final ClassId coroutinesId(String str) {
        return new ClassId(StandardClassIds.INSTANCE.getBASE_COROUTINES_PACKAGE(), Name.identifier(str));
    }

    static {
        FqName fqName = new FqName("java.lang");
        JAVA_LANG_PACKAGE = fqName;
        FqName child = fqName.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child, "JAVA_LANG_PACKAGE.child(…identifier(\"annotation\"))");
        JAVA_LANG_ANNOTATION_PACKAGE = child;
    }

    /* access modifiers changed from: private */
    public static final <K, V> Map<V, K> inverseMap(Map<K, ? extends V> map) {
        Iterable<Map.Entry> entrySet = map.entrySet();
        Map<V, K> linkedHashMap = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        for (Map.Entry entry : entrySet) {
            Pair pair = TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        return linkedHashMap;
    }
}
