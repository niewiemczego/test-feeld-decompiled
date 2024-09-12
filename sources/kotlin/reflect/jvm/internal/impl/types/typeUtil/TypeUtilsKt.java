package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.types.AbstractStubType;
import kotlin.reflect.jvm.internal.impl.types.DefinitelyNotNullType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.StarProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutionKt;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;

/* compiled from: TypeUtils.kt */
public final class TypeUtilsKt {
    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        return hasTypeParameterRecursiveBounds$default(typeParameterDescriptor, (TypeConstructor) null, (Set) null, 6, (Object) null);
    }

    public static final KotlinBuiltIns getBuiltIns(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinBuiltIns builtIns = kotlinType.getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "constructor.builtIns");
        return builtIns;
    }

    public static final KotlinType makeNullable(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNullable = TypeUtils.makeNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNullable, "makeNullable(this)");
        return makeNullable;
    }

    public static final KotlinType makeNotNullable(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        KotlinType makeNotNullable = TypeUtils.makeNotNullable(kotlinType);
        Intrinsics.checkNotNullExpressionValue(makeNotNullable, "makeNotNullable(this)");
        return makeNotNullable;
    }

    public static final boolean isTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return TypeUtils.isTypeParameter(kotlinType);
    }

    public static final boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType2, "superType");
        return KotlinTypeChecker.DEFAULT.isSubtypeOf(kotlinType, kotlinType2);
    }

    public static final KotlinType replaceAnnotations(KotlinType kotlinType, Annotations annotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        if (!kotlinType.getAnnotations().isEmpty() || !annotations.isEmpty()) {
            return kotlinType.unwrap().replaceAttributes(TypeAttributesKt.replaceAnnotations(kotlinType.getAttributes(), annotations));
        }
        return kotlinType;
    }

    public static final TypeProjection createProjection(KotlinType kotlinType, Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        Intrinsics.checkNotNullParameter(variance, "projectionKind");
        if ((typeParameterDescriptor != null ? typeParameterDescriptor.getVariance() : null) == variance) {
            variance = Variance.INVARIANT;
        }
        return new TypeProjectionImpl(variance, kotlinType);
    }

    public static final TypeProjection asTypeProjection(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return new TypeProjectionImpl(kotlinType);
    }

    public static final boolean contains(KotlinType kotlinType, Function1<? super UnwrappedType, Boolean> function1) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "predicate");
        return TypeUtils.contains(kotlinType, function1);
    }

    public static final Set<TypeParameterDescriptor> extractTypeParametersFromUpperBounds(KotlinType kotlinType, Set<? extends TypeParameterDescriptor> set) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Set<TypeParameterDescriptor> linkedHashSet = new LinkedHashSet<>();
        extractTypeParametersFromUpperBounds(kotlinType, kotlinType, linkedHashSet, set);
        return linkedHashSet;
    }

    private static final void extractTypeParametersFromUpperBounds(KotlinType kotlinType, KotlinType kotlinType2, Set<TypeParameterDescriptor> set, Set<? extends TypeParameterDescriptor> set2) {
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        if (!(declarationDescriptor instanceof TypeParameterDescriptor)) {
            ClassifierDescriptor declarationDescriptor2 = kotlinType.getConstructor().getDeclarationDescriptor();
            ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor2 instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor2 : null;
            List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
            int i = 0;
            for (TypeProjection next : kotlinType.getArguments()) {
                int i2 = i + 1;
                TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (TypeParameterDescriptor) CollectionsKt.getOrNull(declaredTypeParameters, i) : null;
                if (!((typeParameterDescriptor == null || set2 == null || !set2.contains(typeParameterDescriptor)) ? false : true) && !next.isStarProjection() && !CollectionsKt.contains(set, next.getType().getConstructor().getDeclarationDescriptor()) && !Intrinsics.areEqual((Object) next.getType().getConstructor(), (Object) kotlinType2.getConstructor())) {
                    KotlinType type = next.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    extractTypeParametersFromUpperBounds(type, kotlinType2, set, set2);
                }
                i = i2;
            }
        } else if (!Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) kotlinType2.getConstructor())) {
            set.add(declarationDescriptor);
        } else {
            for (KotlinType next2 : ((TypeParameterDescriptor) declarationDescriptor).getUpperBounds()) {
                Intrinsics.checkNotNullExpressionValue(next2, "upperBound");
                extractTypeParametersFromUpperBounds(next2, kotlinType2, set, set2);
            }
        }
    }

    public static /* synthetic */ boolean hasTypeParameterRecursiveBounds$default(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set set, int i, Object obj) {
        if ((i & 2) != 0) {
            typeConstructor = null;
        }
        if ((i & 4) != 0) {
            set = null;
        }
        return hasTypeParameterRecursiveBounds(typeParameterDescriptor, typeConstructor, set);
    }

    public static final boolean hasTypeParameterRecursiveBounds(TypeParameterDescriptor typeParameterDescriptor, TypeConstructor typeConstructor, Set<? extends TypeParameterDescriptor> set) {
        boolean z;
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        Iterable<KotlinType> iterable = upperBounds;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            for (KotlinType kotlinType : iterable) {
                Intrinsics.checkNotNullExpressionValue(kotlinType, "upperBound");
                if (!containsSelfTypeParameter(kotlinType, typeParameterDescriptor.getDefaultType().getConstructor(), set) || (typeConstructor != null && !Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) typeConstructor))) {
                    z = false;
                    continue;
                } else {
                    z = true;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final boolean containsSelfTypeParameter(KotlinType kotlinType, TypeConstructor typeConstructor, Set<? extends TypeParameterDescriptor> set) {
        boolean z;
        if (Intrinsics.areEqual((Object) kotlinType.getConstructor(), (Object) typeConstructor)) {
            return true;
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = declarationDescriptor instanceof ClassifierDescriptorWithTypeParameters ? (ClassifierDescriptorWithTypeParameters) declarationDescriptor : null;
        List<TypeParameterDescriptor> declaredTypeParameters = classifierDescriptorWithTypeParameters != null ? classifierDescriptorWithTypeParameters.getDeclaredTypeParameters() : null;
        Iterable<IndexedValue> withIndex = CollectionsKt.withIndex(kotlinType.getArguments());
        if (!(withIndex instanceof Collection) || !((Collection) withIndex).isEmpty()) {
            for (IndexedValue indexedValue : withIndex) {
                int component1 = indexedValue.component1();
                TypeProjection typeProjection = (TypeProjection) indexedValue.component2();
                TypeParameterDescriptor typeParameterDescriptor = declaredTypeParameters != null ? (TypeParameterDescriptor) CollectionsKt.getOrNull(declaredTypeParameters, component1) : null;
                if (((typeParameterDescriptor == null || set == null || !set.contains(typeParameterDescriptor)) ? false : true) || typeProjection.isStarProjection()) {
                    z = false;
                    continue;
                } else {
                    KotlinType type = typeProjection.getType();
                    Intrinsics.checkNotNullExpressionValue(type, "argument.type");
                    z = containsSelfTypeParameter(type, typeConstructor, set);
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public static final boolean containsTypeAliasParameters(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$containsTypeAliasParameters$1.INSTANCE);
    }

    public static final boolean isTypeAliasParameter(ClassifierDescriptor classifierDescriptor) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "<this>");
        return (classifierDescriptor instanceof TypeParameterDescriptor) && (((TypeParameterDescriptor) classifierDescriptor).getContainingDeclaration() instanceof TypeAliasDescriptor);
    }

    public static final boolean requiresTypeAliasExpansion(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return contains(kotlinType, TypeUtilsKt$requiresTypeAliasExpansion$1.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: kotlin.reflect.jvm.internal.impl.types.KotlinType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v9, resolved type: kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor} */
    /* JADX WARNING: type inference failed for: r4v3, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kotlin.reflect.jvm.internal.impl.types.KotlinType getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r7) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.util.List r0 = r7.getUpperBounds()
            java.lang.String r1 = "upperBounds"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            r0.isEmpty()
            java.util.List r0 = r7.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0021:
            boolean r2 = r0.hasNext()
            r3 = 0
            if (r2 == 0) goto L_0x0056
            java.lang.Object r2 = r0.next()
            r4 = r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r4 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r4
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            boolean r5 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor
            if (r5 == 0) goto L_0x003e
            r3 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor r3 = (kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor) r3
        L_0x003e:
            r4 = 0
            if (r3 != 0) goto L_0x0042
            goto L_0x0053
        L_0x0042:
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r6 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.INTERFACE
            if (r5 == r6) goto L_0x0053
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r3 = r3.getKind()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassKind r5 = kotlin.reflect.jvm.internal.impl.descriptors.ClassKind.ANNOTATION_CLASS
            if (r3 == r5) goto L_0x0053
            r4 = 1
        L_0x0053:
            if (r4 == 0) goto L_0x0021
            r3 = r2
        L_0x0056:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
            if (r3 != 0) goto L_0x006e
            java.util.List r7 = r7.getUpperBounds()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r1)
            java.lang.Object r7 = kotlin.collections.CollectionsKt.first(r7)
            java.lang.String r0 = "upperBounds.first()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r0)
            r3 = r7
            kotlin.reflect.jvm.internal.impl.types.KotlinType r3 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r3
        L_0x006e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.getRepresentativeUpperBound(kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    public static final boolean shouldBeUpdated(KotlinType kotlinType) {
        return kotlinType == null || contains(kotlinType, TypeUtilsKt$shouldBeUpdated$1.INSTANCE);
    }

    public static final boolean isStubType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (!(kotlinType instanceof AbstractStubType)) {
            if (!((kotlinType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) kotlinType).getOriginal() instanceof AbstractStubType))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isStubTypeForBuilderInference(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (!(kotlinType instanceof StubTypeForBuilderInference)) {
            if (!((kotlinType instanceof DefinitelyNotNullType) && (((DefinitelyNotNullType) kotlinType).getOriginal() instanceof StubTypeForBuilderInference))) {
                return false;
            }
        }
        return true;
    }

    public static final boolean isUnresolvedType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        return (kotlinType instanceof ErrorType) && ((ErrorType) kotlinType).getKind().isUnresolved();
    }

    public static final KotlinType replaceArgumentsWithStarProjections(KotlinType kotlinType) {
        UnwrappedType unwrappedType;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable = parameters;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TypeParameterDescriptor starProjectionImpl : iterable) {
                    arrayList.add(new StarProjectionImpl(starProjectionImpl));
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, (List) arrayList, (TypeAttributes) null, 2, (Object) null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable2 = parameters2;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (TypeParameterDescriptor starProjectionImpl2 : iterable2) {
                    arrayList2.add(new StarProjectionImpl(starProjectionImpl2));
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, (List) arrayList2, (TypeAttributes) null, 2, (Object) null);
            }
            unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            if (!simpleType.getConstructor().getParameters().isEmpty() && simpleType.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable3 = parameters3;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (TypeParameterDescriptor starProjectionImpl3 : iterable3) {
                    arrayList3.add(new StarProjectionImpl(starProjectionImpl3));
                }
                simpleType = TypeSubstitutionKt.replace$default(simpleType, (List) arrayList3, (TypeAttributes) null, 2, (Object) null);
            }
            unwrappedType = simpleType;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap);
    }

    public static final KotlinType replaceArgumentsWithStarProjectionOrMapped(KotlinType kotlinType, TypeSubstitutor typeSubstitutor, Map<TypeConstructor, ? extends TypeProjection> map, Variance variance, Set<? extends TypeParameterDescriptor> set) {
        UnwrappedType unwrappedType;
        TypeSubstitutor typeSubstitutor2 = typeSubstitutor;
        Map<TypeConstructor, ? extends TypeProjection> map2 = map;
        Variance variance2 = variance;
        Set<? extends TypeParameterDescriptor> set2 = set;
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(typeSubstitutor2, "substitutor");
        Intrinsics.checkNotNullParameter(map2, "substitutionMap");
        Intrinsics.checkNotNullParameter(variance2, "variance");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            SimpleType lowerBound = flexibleType.getLowerBound();
            if (!lowerBound.getConstructor().getParameters().isEmpty() && lowerBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters = lowerBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable = parameters;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
                    TypeProjection typeProjection = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor)) || typeProjection == null || !map2.containsKey(typeProjection.getType().getConstructor())) {
                        typeProjection = new StarProjectionImpl(typeParameterDescriptor);
                    }
                    arrayList.add(typeProjection);
                }
                lowerBound = TypeSubstitutionKt.replace$default(lowerBound, (List) arrayList, (TypeAttributes) null, 2, (Object) null);
            }
            SimpleType upperBound = flexibleType.getUpperBound();
            if (!upperBound.getConstructor().getParameters().isEmpty() && upperBound.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters2 = upperBound.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters2, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable2 = parameters2;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
                for (TypeParameterDescriptor typeParameterDescriptor2 : iterable2) {
                    TypeProjection typeProjection2 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor2.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor2)) || typeProjection2 == null || !map2.containsKey(typeProjection2.getType().getConstructor())) {
                        typeProjection2 = new StarProjectionImpl(typeParameterDescriptor2);
                    }
                    arrayList2.add(typeProjection2);
                }
                upperBound = TypeSubstitutionKt.replace$default(upperBound, (List) arrayList2, (TypeAttributes) null, 2, (Object) null);
            }
            unwrappedType = KotlinTypeFactory.flexibleType(lowerBound, upperBound);
        } else if (unwrap instanceof SimpleType) {
            SimpleType simpleType = (SimpleType) unwrap;
            if (!simpleType.getConstructor().getParameters().isEmpty() && simpleType.getConstructor().getDeclarationDescriptor() != null) {
                List<TypeParameterDescriptor> parameters3 = simpleType.getConstructor().getParameters();
                Intrinsics.checkNotNullExpressionValue(parameters3, "constructor.parameters");
                Iterable<TypeParameterDescriptor> iterable3 = parameters3;
                Collection arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable3, 10));
                for (TypeParameterDescriptor typeParameterDescriptor3 : iterable3) {
                    TypeProjection typeProjection3 = (TypeProjection) CollectionsKt.getOrNull(kotlinType.getArguments(), typeParameterDescriptor3.getIndex());
                    if ((set2 != null && set2.contains(typeParameterDescriptor3)) || typeProjection3 == null || !map2.containsKey(typeProjection3.getType().getConstructor())) {
                        typeProjection3 = new StarProjectionImpl(typeParameterDescriptor3);
                    }
                    arrayList3.add(typeProjection3);
                }
                simpleType = TypeSubstitutionKt.replace$default(simpleType, (List) arrayList3, (TypeAttributes) null, 2, (Object) null);
            }
            unwrappedType = simpleType;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        KotlinType safeSubstitute = typeSubstitutor2.safeSubstitute(TypeWithEnhancementKt.inheritEnhancement(unwrappedType, unwrap), variance2);
        Intrinsics.checkNotNullExpressionValue(safeSubstitute, "replaceArgumentsByParame…ubstitute(it, variance) }");
        return safeSubstitute;
    }
}
