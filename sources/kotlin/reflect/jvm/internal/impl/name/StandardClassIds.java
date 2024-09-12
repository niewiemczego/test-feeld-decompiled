package kotlin.reflect.jvm.internal.impl.name;

import io.sentry.protocol.DebugImage;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: StandardClassIds.kt */
public final class StandardClassIds {
    private static final ClassId Annotation = StandardClassIdsKt.baseId("Annotation");
    private static final ClassId AnnotationRetention = StandardClassIdsKt.annotationId("AnnotationRetention");
    private static final ClassId AnnotationTarget = StandardClassIdsKt.annotationId("AnnotationTarget");
    private static final ClassId Any = StandardClassIdsKt.baseId("Any");
    private static final ClassId Array = StandardClassIdsKt.baseId("Array");
    private static final FqName BASE_ANNOTATION_PACKAGE;
    private static final FqName BASE_COLLECTIONS_PACKAGE;
    private static final FqName BASE_COROUTINES_PACKAGE;
    private static final FqName BASE_INTERNAL_IR_PACKAGE;
    private static final FqName BASE_INTERNAL_PACKAGE;
    private static final FqName BASE_JVM_INTERNAL_PACKAGE;
    private static final FqName BASE_JVM_PACKAGE;
    private static final FqName BASE_KOTLIN_PACKAGE;
    private static final FqName BASE_RANGES_PACKAGE;
    private static final FqName BASE_REFLECT_PACKAGE;
    private static final ClassId Boolean;
    private static final ClassId Byte;
    private static final ClassId Char;
    private static final ClassId CharRange = StandardClassIdsKt.rangesId("CharRange");
    private static final ClassId Cloneable = StandardClassIdsKt.baseId("Cloneable");
    private static final ClassId Collection = StandardClassIdsKt.collectionsId("Collection");
    private static final ClassId Comparable = StandardClassIdsKt.baseId("Comparable");
    private static final ClassId Continuation = StandardClassIdsKt.coroutinesId("Continuation");
    private static final ClassId Double;
    private static final ClassId Enum = StandardClassIdsKt.baseId("Enum");
    private static final ClassId Float;
    private static final ClassId Function = StandardClassIdsKt.baseId("Function");
    public static final StandardClassIds INSTANCE = new StandardClassIds();
    private static final ClassId Int;
    private static final ClassId IntRange = StandardClassIdsKt.rangesId("IntRange");
    private static final ClassId Iterable = StandardClassIdsKt.collectionsId("Iterable");
    private static final ClassId Iterator = StandardClassIdsKt.collectionsId("Iterator");
    private static final ClassId KCallable = StandardClassIdsKt.reflectId("KCallable");
    private static final ClassId KClass = StandardClassIdsKt.reflectId("KClass");
    private static final ClassId KFunction = StandardClassIdsKt.reflectId("KFunction");
    private static final ClassId KMutableProperty = StandardClassIdsKt.reflectId("KMutableProperty");
    private static final ClassId KMutableProperty0 = StandardClassIdsKt.reflectId("KMutableProperty0");
    private static final ClassId KMutableProperty1 = StandardClassIdsKt.reflectId("KMutableProperty1");
    private static final ClassId KMutableProperty2 = StandardClassIdsKt.reflectId("KMutableProperty2");
    private static final ClassId KProperty = StandardClassIdsKt.reflectId("KProperty");
    private static final ClassId KProperty0 = StandardClassIdsKt.reflectId("KProperty0");
    private static final ClassId KProperty1 = StandardClassIdsKt.reflectId("KProperty1");
    private static final ClassId KProperty2 = StandardClassIdsKt.reflectId("KProperty2");
    private static final ClassId List = StandardClassIdsKt.collectionsId("List");
    private static final ClassId ListIterator = StandardClassIdsKt.collectionsId("ListIterator");
    private static final ClassId Long;
    private static final ClassId LongRange = StandardClassIdsKt.rangesId("LongRange");
    private static final ClassId Map;
    private static final ClassId MapEntry;
    private static final ClassId MutableCollection = StandardClassIdsKt.collectionsId("MutableCollection");
    private static final ClassId MutableIterable = StandardClassIdsKt.collectionsId("MutableIterable");
    private static final ClassId MutableIterator = StandardClassIdsKt.collectionsId("MutableIterator");
    private static final ClassId MutableList = StandardClassIdsKt.collectionsId("MutableList");
    private static final ClassId MutableListIterator = StandardClassIdsKt.collectionsId("MutableListIterator");
    private static final ClassId MutableMap;
    private static final ClassId MutableMapEntry;
    private static final ClassId MutableSet = StandardClassIdsKt.collectionsId("MutableSet");
    private static final ClassId Nothing = StandardClassIdsKt.baseId("Nothing");
    private static final ClassId Number = StandardClassIdsKt.baseId("Number");
    private static final ClassId Result = StandardClassIdsKt.baseId("Result");
    private static final ClassId Set = StandardClassIdsKt.collectionsId("Set");
    private static final ClassId Short;
    private static final ClassId String = StandardClassIdsKt.baseId("String");
    private static final ClassId Throwable = StandardClassIdsKt.baseId("Throwable");
    private static final ClassId UByte;
    private static final ClassId UInt;
    private static final ClassId ULong;
    private static final ClassId UShort;
    private static final ClassId Unit = StandardClassIdsKt.baseId("Unit");
    private static final Set<FqName> builtInsPackages;
    private static final Set<ClassId> constantAllowedTypes = SetsKt.plus(SetsKt.plus(primitiveTypes, unsignedTypes), String);
    private static final Map<ClassId, ClassId> elementTypeByPrimitiveArrayType;
    private static final Map<ClassId, ClassId> elementTypeByUnsignedArrayType;
    private static final Map<ClassId, ClassId> primitiveArrayTypeByElementType;
    private static final Set<ClassId> primitiveTypes;
    private static final Map<ClassId, ClassId> unsignedArrayTypeByElementType;
    private static final Set<ClassId> unsignedTypes;

    private StandardClassIds() {
    }

    static {
        FqName fqName = new FqName("kotlin");
        BASE_KOTLIN_PACKAGE = fqName;
        FqName child = fqName.child(Name.identifier("reflect"));
        Intrinsics.checkNotNullExpressionValue(child, "BASE_KOTLIN_PACKAGE.chil…me.identifier(\"reflect\"))");
        BASE_REFLECT_PACKAGE = child;
        FqName child2 = fqName.child(Name.identifier("collections"));
        Intrinsics.checkNotNullExpressionValue(child2, "BASE_KOTLIN_PACKAGE.chil…dentifier(\"collections\"))");
        BASE_COLLECTIONS_PACKAGE = child2;
        FqName child3 = fqName.child(Name.identifier("ranges"));
        Intrinsics.checkNotNullExpressionValue(child3, "BASE_KOTLIN_PACKAGE.chil…ame.identifier(\"ranges\"))");
        BASE_RANGES_PACKAGE = child3;
        FqName child4 = fqName.child(Name.identifier(DebugImage.JVM));
        Intrinsics.checkNotNullExpressionValue(child4, "BASE_KOTLIN_PACKAGE.child(Name.identifier(\"jvm\"))");
        BASE_JVM_PACKAGE = child4;
        FqName child5 = child4.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child5, "BASE_JVM_PACKAGE.child(N…e.identifier(\"internal\"))");
        BASE_JVM_INTERNAL_PACKAGE = child5;
        FqName child6 = fqName.child(Name.identifier("annotation"));
        Intrinsics.checkNotNullExpressionValue(child6, "BASE_KOTLIN_PACKAGE.chil…identifier(\"annotation\"))");
        BASE_ANNOTATION_PACKAGE = child6;
        FqName child7 = fqName.child(Name.identifier("internal"));
        Intrinsics.checkNotNullExpressionValue(child7, "BASE_KOTLIN_PACKAGE.chil…e.identifier(\"internal\"))");
        BASE_INTERNAL_PACKAGE = child7;
        FqName child8 = child7.child(Name.identifier("ir"));
        Intrinsics.checkNotNullExpressionValue(child8, "BASE_INTERNAL_PACKAGE.child(Name.identifier(\"ir\"))");
        BASE_INTERNAL_IR_PACKAGE = child8;
        FqName child9 = fqName.child(Name.identifier("coroutines"));
        Intrinsics.checkNotNullExpressionValue(child9, "BASE_KOTLIN_PACKAGE.chil…identifier(\"coroutines\"))");
        BASE_COROUTINES_PACKAGE = child9;
        builtInsPackages = SetsKt.setOf(fqName, child2, child3, child6, child, child7, child9);
        ClassId access$baseId = StandardClassIdsKt.baseId("Boolean");
        Boolean = access$baseId;
        ClassId access$baseId2 = StandardClassIdsKt.baseId("Char");
        Char = access$baseId2;
        ClassId access$baseId3 = StandardClassIdsKt.baseId("Byte");
        Byte = access$baseId3;
        ClassId access$baseId4 = StandardClassIdsKt.baseId("Short");
        Short = access$baseId4;
        ClassId access$baseId5 = StandardClassIdsKt.baseId("Int");
        Int = access$baseId5;
        ClassId access$baseId6 = StandardClassIdsKt.baseId("Long");
        Long = access$baseId6;
        ClassId access$baseId7 = StandardClassIdsKt.baseId("Float");
        Float = access$baseId7;
        ClassId access$baseId8 = StandardClassIdsKt.baseId("Double");
        Double = access$baseId8;
        UByte = StandardClassIdsKt.unsignedId(access$baseId3);
        UShort = StandardClassIdsKt.unsignedId(access$baseId4);
        UInt = StandardClassIdsKt.unsignedId(access$baseId5);
        ULong = StandardClassIdsKt.unsignedId(access$baseId6);
        Set<ClassId> of = SetsKt.setOf(access$baseId, access$baseId2, access$baseId3, access$baseId4, access$baseId5, access$baseId6, access$baseId7, access$baseId8);
        primitiveTypes = of;
        Iterable iterable = of;
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable, 10)), 16));
        for (Object next : iterable) {
            Name shortClassName = ((ClassId) next).getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName, "id.shortClassName");
            linkedHashMap.put(next, StandardClassIdsKt.primitiveArrayId(shortClassName));
        }
        Map<ClassId, ClassId> map = linkedHashMap;
        primitiveArrayTypeByElementType = map;
        elementTypeByPrimitiveArrayType = StandardClassIdsKt.inverseMap(map);
        Set<ClassId> of2 = SetsKt.setOf(UByte, UShort, UInt, ULong);
        unsignedTypes = of2;
        Iterable iterable2 = of2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable2, 10)), 16));
        for (Object next2 : iterable2) {
            Name shortClassName2 = ((ClassId) next2).getShortClassName();
            Intrinsics.checkNotNullExpressionValue(shortClassName2, "id.shortClassName");
            linkedHashMap2.put(next2, StandardClassIdsKt.primitiveArrayId(shortClassName2));
        }
        Map<ClassId, ClassId> map2 = linkedHashMap2;
        unsignedArrayTypeByElementType = map2;
        elementTypeByUnsignedArrayType = StandardClassIdsKt.inverseMap(map2);
        ClassId access$collectionsId = StandardClassIdsKt.collectionsId("Map");
        Map = access$collectionsId;
        ClassId access$collectionsId2 = StandardClassIdsKt.collectionsId("MutableMap");
        MutableMap = access$collectionsId2;
        ClassId createNestedClassId = access$collectionsId.createNestedClassId(Name.identifier("Entry"));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId, "Map.createNestedClassId(Name.identifier(\"Entry\"))");
        MapEntry = createNestedClassId;
        ClassId createNestedClassId2 = access$collectionsId2.createNestedClassId(Name.identifier("MutableEntry"));
        Intrinsics.checkNotNullExpressionValue(createNestedClassId2, "MutableMap.createNestedC…entifier(\"MutableEntry\"))");
        MutableMapEntry = createNestedClassId2;
    }

    public final FqName getBASE_KOTLIN_PACKAGE() {
        return BASE_KOTLIN_PACKAGE;
    }

    public final FqName getBASE_REFLECT_PACKAGE() {
        return BASE_REFLECT_PACKAGE;
    }

    public final FqName getBASE_COLLECTIONS_PACKAGE() {
        return BASE_COLLECTIONS_PACKAGE;
    }

    public final FqName getBASE_RANGES_PACKAGE() {
        return BASE_RANGES_PACKAGE;
    }

    public final FqName getBASE_ANNOTATION_PACKAGE() {
        return BASE_ANNOTATION_PACKAGE;
    }

    public final FqName getBASE_COROUTINES_PACKAGE() {
        return BASE_COROUTINES_PACKAGE;
    }

    public final ClassId getArray() {
        return Array;
    }

    public final ClassId getKFunction() {
        return KFunction;
    }

    public final ClassId getKClass() {
        return KClass;
    }

    public final ClassId getMutableList() {
        return MutableList;
    }

    public final ClassId getMutableSet() {
        return MutableSet;
    }

    public final ClassId getMutableMap() {
        return MutableMap;
    }
}
