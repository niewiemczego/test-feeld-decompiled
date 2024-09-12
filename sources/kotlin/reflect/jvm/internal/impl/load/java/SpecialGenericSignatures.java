package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.load.kotlin.SignatureBuildingComponents;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* compiled from: SpecialGenericSignatures.kt */
public class SpecialGenericSignatures {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final List<String> ERASED_COLLECTION_PARAMETER_NAMES;
    private static final List<Companion.NameAndSignature> ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
    /* access modifiers changed from: private */
    public static final List<String> ERASED_COLLECTION_PARAMETER_SIGNATURES;
    /* access modifiers changed from: private */
    public static final Set<Name> ERASED_VALUE_PARAMETERS_SHORT_NAMES;
    /* access modifiers changed from: private */
    public static final Set<String> ERASED_VALUE_PARAMETERS_SIGNATURES;
    private static final Map<Companion.NameAndSignature, TypeSafeBarrierDescription> GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP;
    /* access modifiers changed from: private */
    public static final Map<Name, Name> JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
    private static final Map<Companion.NameAndSignature, Name> NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP;
    /* access modifiers changed from: private */
    public static final List<Name> ORIGINAL_SHORT_NAMES;
    /* access modifiers changed from: private */
    public static final Companion.NameAndSignature REMOVE_AT_NAME_AND_SIGNATURE;
    /* access modifiers changed from: private */
    public static final Map<String, TypeSafeBarrierDescription> SIGNATURE_TO_DEFAULT_VALUES_MAP;
    /* access modifiers changed from: private */
    public static final Map<String, Name> SIGNATURE_TO_JVM_REPRESENTATION_NAME;

    /* compiled from: SpecialGenericSignatures.kt */
    public enum TypeSafeBarrierDescription {
        NULL((String) null),
        INDEX(-1),
        FALSE(false);
        
        private final Object defaultValue;

        private TypeSafeBarrierDescription(Object obj) {
            this.defaultValue = obj;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        static final class MAP_GET_OR_DEFAULT extends TypeSafeBarrierDescription {
            MAP_GET_OR_DEFAULT(String str, int i) {
                super(str, i, (Object) null, (DefaultConstructorMarker) null);
            }
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public enum SpecialSignatureInfo {
        ONE_COLLECTION_PARAMETER("Ljava/util/Collection<+Ljava/lang/Object;>;", false),
        OBJECT_PARAMETER_NON_GENERIC((String) null, true),
        OBJECT_PARAMETER_GENERIC("Ljava/lang/Object;", true);
        
        private final boolean isObjectReplacedWithTypeParameter;
        private final String valueParametersSignature;

        private SpecialSignatureInfo(String str, boolean z) {
            this.valueParametersSignature = str;
            this.isObjectReplacedWithTypeParameter = z;
        }
    }

    /* compiled from: SpecialGenericSignatures.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SpecialSignatureInfo getSpecialSignatureInfo(String str) {
            Intrinsics.checkNotNullParameter(str, "builtinSignature");
            if (getERASED_COLLECTION_PARAMETER_SIGNATURES().contains(str)) {
                return SpecialSignatureInfo.ONE_COLLECTION_PARAMETER;
            }
            if (((TypeSafeBarrierDescription) MapsKt.getValue(getSIGNATURE_TO_DEFAULT_VALUES_MAP(), str)) == TypeSafeBarrierDescription.NULL) {
                return SpecialSignatureInfo.OBJECT_PARAMETER_GENERIC;
            }
            return SpecialSignatureInfo.OBJECT_PARAMETER_NON_GENERIC;
        }

        /* compiled from: SpecialGenericSignatures.kt */
        public static final class NameAndSignature {
            private final Name name;
            private final String signature;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof NameAndSignature)) {
                    return false;
                }
                NameAndSignature nameAndSignature = (NameAndSignature) obj;
                return Intrinsics.areEqual((Object) this.name, (Object) nameAndSignature.name) && Intrinsics.areEqual((Object) this.signature, (Object) nameAndSignature.signature);
            }

            public int hashCode() {
                return (this.name.hashCode() * 31) + this.signature.hashCode();
            }

            public String toString() {
                return "NameAndSignature(name=" + this.name + ", signature=" + this.signature + ')';
            }

            public NameAndSignature(Name name2, String str) {
                Intrinsics.checkNotNullParameter(name2, "name");
                Intrinsics.checkNotNullParameter(str, "signature");
                this.name = name2;
                this.signature = str;
            }

            public final Name getName() {
                return this.name;
            }

            public final String getSignature() {
                return this.signature;
            }
        }

        /* access modifiers changed from: private */
        public final NameAndSignature method(String str, String str2, String str3, String str4) {
            Name identifier = Name.identifier(str2);
            Intrinsics.checkNotNullExpressionValue(identifier, "identifier(name)");
            return new NameAndSignature(identifier, SignatureBuildingComponents.INSTANCE.signature(str, str2 + '(' + str3 + ')' + str4));
        }

        public final List<String> getERASED_COLLECTION_PARAMETER_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_COLLECTION_PARAMETER_SIGNATURES;
        }

        public final Map<String, TypeSafeBarrierDescription> getSIGNATURE_TO_DEFAULT_VALUES_MAP() {
            return SpecialGenericSignatures.SIGNATURE_TO_DEFAULT_VALUES_MAP;
        }

        public final Set<Name> getERASED_VALUE_PARAMETERS_SHORT_NAMES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SHORT_NAMES;
        }

        public final Set<String> getERASED_VALUE_PARAMETERS_SIGNATURES() {
            return SpecialGenericSignatures.ERASED_VALUE_PARAMETERS_SIGNATURES;
        }

        public final NameAndSignature getREMOVE_AT_NAME_AND_SIGNATURE() {
            return SpecialGenericSignatures.REMOVE_AT_NAME_AND_SIGNATURE;
        }

        public final Map<String, Name> getSIGNATURE_TO_JVM_REPRESENTATION_NAME() {
            return SpecialGenericSignatures.SIGNATURE_TO_JVM_REPRESENTATION_NAME;
        }

        public final List<Name> getORIGINAL_SHORT_NAMES() {
            return SpecialGenericSignatures.ORIGINAL_SHORT_NAMES;
        }

        public final Map<Name, Name> getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP() {
            return SpecialGenericSignatures.JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP;
        }

        public final Name getBuiltinFunctionNamesByJvmName(Name name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return getJVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP().get(name);
        }

        public final boolean getSameAsRenamedInJvmBuiltin(Name name) {
            Intrinsics.checkNotNullParameter(name, "<this>");
            return getORIGINAL_SHORT_NAMES().contains(name);
        }
    }

    static {
        Iterable<String> of = SetsKt.setOf("containsAll", "removeAll", "retainAll");
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(of, 10));
        for (String access$method : of) {
            Companion companion = Companion;
            String desc = JvmPrimitiveType.BOOLEAN.getDesc();
            Intrinsics.checkNotNullExpressionValue(desc, "BOOLEAN.desc");
            arrayList.add(companion.method("java/util/Collection", access$method, "Ljava/util/Collection;", desc));
        }
        List<Companion.NameAndSignature> list = (List) arrayList;
        ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES = list;
        Iterable<Companion.NameAndSignature> iterable = list;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Companion.NameAndSignature signature : iterable) {
            arrayList2.add(signature.getSignature());
        }
        ERASED_COLLECTION_PARAMETER_SIGNATURES = (List) arrayList2;
        Iterable<Companion.NameAndSignature> iterable2 = ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES;
        Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Companion.NameAndSignature name : iterable2) {
            arrayList3.add(name.getName().asString());
        }
        ERASED_COLLECTION_PARAMETER_NAMES = (List) arrayList3;
        SignatureBuildingComponents signatureBuildingComponents = SignatureBuildingComponents.INSTANCE;
        Companion companion2 = Companion;
        String javaUtil = signatureBuildingComponents.javaUtil("Collection");
        String desc2 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc2, "BOOLEAN.desc");
        String javaUtil2 = signatureBuildingComponents.javaUtil("Collection");
        String desc3 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc3, "BOOLEAN.desc");
        String javaUtil3 = signatureBuildingComponents.javaUtil("Map");
        String desc4 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc4, "BOOLEAN.desc");
        String javaUtil4 = signatureBuildingComponents.javaUtil("Map");
        String desc5 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc5, "BOOLEAN.desc");
        String javaUtil5 = signatureBuildingComponents.javaUtil("Map");
        String desc6 = JvmPrimitiveType.BOOLEAN.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc6, "BOOLEAN.desc");
        String javaUtil6 = signatureBuildingComponents.javaUtil("List");
        String desc7 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc7, "INT.desc");
        String javaUtil7 = signatureBuildingComponents.javaUtil("List");
        String desc8 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc8, "INT.desc");
        Map<Companion.NameAndSignature, TypeSafeBarrierDescription> mapOf = MapsKt.mapOf(TuplesKt.to(companion2.method(javaUtil, "contains", "Ljava/lang/Object;", desc2), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion2.method(javaUtil2, "remove", "Ljava/lang/Object;", desc3), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion2.method(javaUtil3, "containsKey", "Ljava/lang/Object;", desc4), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion2.method(javaUtil4, "containsValue", "Ljava/lang/Object;", desc5), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion2.method(javaUtil5, "remove", "Ljava/lang/Object;Ljava/lang/Object;", desc6), TypeSafeBarrierDescription.FALSE), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "getOrDefault", "Ljava/lang/Object;Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.MAP_GET_OR_DEFAULT), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "get", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(companion2.method(signatureBuildingComponents.javaUtil("Map"), "remove", "Ljava/lang/Object;", "Ljava/lang/Object;"), TypeSafeBarrierDescription.NULL), TuplesKt.to(companion2.method(javaUtil6, "indexOf", "Ljava/lang/Object;", desc7), TypeSafeBarrierDescription.INDEX), TuplesKt.to(companion2.method(javaUtil7, "lastIndexOf", "Ljava/lang/Object;", desc8), TypeSafeBarrierDescription.INDEX));
        GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP = mapOf;
        Map<String, TypeSafeBarrierDescription> linkedHashMap = new LinkedHashMap<>(MapsKt.mapCapacity(mapOf.size()));
        for (Map.Entry entry : mapOf.entrySet()) {
            linkedHashMap.put(((Companion.NameAndSignature) entry.getKey()).getSignature(), entry.getValue());
        }
        SIGNATURE_TO_DEFAULT_VALUES_MAP = linkedHashMap;
        Iterable<Companion.NameAndSignature> plus = SetsKt.plus(GENERIC_PARAMETERS_METHODS_TO_DEFAULT_VALUES_MAP.keySet(), ERASED_COLLECTION_PARAMETER_NAME_AND_SIGNATURES);
        Collection arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature name2 : plus) {
            arrayList4.add(name2.getName());
        }
        ERASED_VALUE_PARAMETERS_SHORT_NAMES = CollectionsKt.toSet((List) arrayList4);
        Collection arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(plus, 10));
        for (Companion.NameAndSignature signature2 : plus) {
            arrayList5.add(signature2.getSignature());
        }
        ERASED_VALUE_PARAMETERS_SIGNATURES = CollectionsKt.toSet((List) arrayList5);
        Companion companion3 = Companion;
        String desc9 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc9, "INT.desc");
        Companion.NameAndSignature access$method2 = companion3.method("java/util/List", "removeAt", desc9, "Ljava/lang/Object;");
        REMOVE_AT_NAME_AND_SIGNATURE = access$method2;
        SignatureBuildingComponents signatureBuildingComponents2 = SignatureBuildingComponents.INSTANCE;
        String javaLang = signatureBuildingComponents2.javaLang("Number");
        String desc10 = JvmPrimitiveType.BYTE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc10, "BYTE.desc");
        String javaLang2 = signatureBuildingComponents2.javaLang("Number");
        String desc11 = JvmPrimitiveType.SHORT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc11, "SHORT.desc");
        String javaLang3 = signatureBuildingComponents2.javaLang("Number");
        String desc12 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc12, "INT.desc");
        String javaLang4 = signatureBuildingComponents2.javaLang("Number");
        String desc13 = JvmPrimitiveType.LONG.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc13, "LONG.desc");
        String javaLang5 = signatureBuildingComponents2.javaLang("Number");
        String desc14 = JvmPrimitiveType.FLOAT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc14, "FLOAT.desc");
        String javaLang6 = signatureBuildingComponents2.javaLang("Number");
        String desc15 = JvmPrimitiveType.DOUBLE.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc15, "DOUBLE.desc");
        String javaLang7 = signatureBuildingComponents2.javaLang("CharSequence");
        String desc16 = JvmPrimitiveType.INT.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc16, "INT.desc");
        String desc17 = JvmPrimitiveType.CHAR.getDesc();
        Intrinsics.checkNotNullExpressionValue(desc17, "CHAR.desc");
        Map<Companion.NameAndSignature, Name> mapOf2 = MapsKt.mapOf(TuplesKt.to(companion3.method(javaLang, "toByte", "", desc10), Name.identifier("byteValue")), TuplesKt.to(companion3.method(javaLang2, "toShort", "", desc11), Name.identifier("shortValue")), TuplesKt.to(companion3.method(javaLang3, "toInt", "", desc12), Name.identifier("intValue")), TuplesKt.to(companion3.method(javaLang4, "toLong", "", desc13), Name.identifier("longValue")), TuplesKt.to(companion3.method(javaLang5, "toFloat", "", desc14), Name.identifier("floatValue")), TuplesKt.to(companion3.method(javaLang6, "toDouble", "", desc15), Name.identifier("doubleValue")), TuplesKt.to(access$method2, Name.identifier("remove")), TuplesKt.to(companion3.method(javaLang7, "get", desc16, desc17), Name.identifier("charAt")));
        NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP = mapOf2;
        Map<String, Name> linkedHashMap2 = new LinkedHashMap<>(MapsKt.mapCapacity(mapOf2.size()));
        for (Map.Entry entry2 : mapOf2.entrySet()) {
            linkedHashMap2.put(((Companion.NameAndSignature) entry2.getKey()).getSignature(), entry2.getValue());
        }
        SIGNATURE_TO_JVM_REPRESENTATION_NAME = linkedHashMap2;
        Iterable<Companion.NameAndSignature> keySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.keySet();
        Collection arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(keySet, 10));
        for (Companion.NameAndSignature name3 : keySet) {
            arrayList6.add(name3.getName());
        }
        ORIGINAL_SHORT_NAMES = (List) arrayList6;
        Iterable<Map.Entry> entrySet = NAME_AND_SIGNATURE_TO_JVM_REPRESENTATION_NAME_MAP.entrySet();
        Collection arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(entrySet, 10));
        for (Map.Entry entry3 : entrySet) {
            arrayList7.add(new Pair(((Companion.NameAndSignature) entry3.getKey()).getName(), entry3.getValue()));
        }
        Iterable<Pair> iterable3 = (List) arrayList7;
        Map<Name, Name> linkedHashMap3 = new LinkedHashMap<>(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(iterable3, 10)), 16));
        for (Pair pair : iterable3) {
            linkedHashMap3.put((Name) pair.getSecond(), (Name) pair.getFirst());
        }
        JVM_SHORT_NAME_TO_BUILTIN_SHORT_NAMES_MAP = linkedHashMap3;
    }
}
