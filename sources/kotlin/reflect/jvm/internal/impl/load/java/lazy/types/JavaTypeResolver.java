package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMapper;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaAnnotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.LazyJavaResolverContext;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.TypeParameterResolver;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaArrayType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClass;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifier;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaPrimitiveType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypeParameter;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaTypesKt;
import kotlin.reflect.jvm.internal.impl.load.java.structure.JavaWildcardType;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.LazyWrappedType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: JavaTypeResolver.kt */
public final class JavaTypeResolver {
    private final LazyJavaResolverContext c;
    private final RawSubstitution rawSubstitution;
    private final TypeParameterResolver typeParameterResolver;
    /* access modifiers changed from: private */
    public final TypeParameterUpperBoundEraser typeParameterUpperBoundEraser;

    public JavaTypeResolver(LazyJavaResolverContext lazyJavaResolverContext, TypeParameterResolver typeParameterResolver2) {
        Intrinsics.checkNotNullParameter(lazyJavaResolverContext, "c");
        Intrinsics.checkNotNullParameter(typeParameterResolver2, "typeParameterResolver");
        this.c = lazyJavaResolverContext;
        this.typeParameterResolver = typeParameterResolver2;
        TypeParameterUpperBoundEraser typeParameterUpperBoundEraser2 = new TypeParameterUpperBoundEraser((RawSubstitution) null, 1, (DefaultConstructorMarker) null);
        this.typeParameterUpperBoundEraser = typeParameterUpperBoundEraser2;
        this.rawSubstitution = new RawSubstitution(typeParameterUpperBoundEraser2);
    }

    public final KotlinType transformJavaType(JavaType javaType, JavaTypeAttributes javaTypeAttributes) {
        KotlinType transformJavaType;
        SimpleType simpleType;
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        if (javaType instanceof JavaPrimitiveType) {
            PrimitiveType type = ((JavaPrimitiveType) javaType).getType();
            if (type != null) {
                simpleType = this.c.getModule().getBuiltIns().getPrimitiveKotlinType(type);
            } else {
                simpleType = this.c.getModule().getBuiltIns().getUnitType();
            }
            Intrinsics.checkNotNullExpressionValue(simpleType, "{\n                val pr…ns.unitType\n            }");
            return simpleType;
        } else if (javaType instanceof JavaClassifierType) {
            return transformJavaClassifierType((JavaClassifierType) javaType, javaTypeAttributes);
        } else {
            if (javaType instanceof JavaArrayType) {
                return transformArrayType$default(this, (JavaArrayType) javaType, javaTypeAttributes, false, 4, (Object) null);
            } else if (javaType instanceof JavaWildcardType) {
                JavaType bound = ((JavaWildcardType) javaType).getBound();
                if (bound != null && (transformJavaType = transformJavaType(bound, javaTypeAttributes)) != null) {
                    return transformJavaType;
                }
                SimpleType defaultBound = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound, "c.module.builtIns.defaultBound");
                return defaultBound;
            } else if (javaType == null) {
                SimpleType defaultBound2 = this.c.getModule().getBuiltIns().getDefaultBound();
                Intrinsics.checkNotNullExpressionValue(defaultBound2, "c.module.builtIns.defaultBound");
                return defaultBound2;
            } else {
                throw new UnsupportedOperationException("Unsupported type: " + javaType);
            }
        }
    }

    public static /* synthetic */ KotlinType transformArrayType$default(JavaTypeResolver javaTypeResolver, JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return javaTypeResolver.transformArrayType(javaArrayType, javaTypeAttributes, z);
    }

    public final KotlinType transformArrayType(JavaArrayType javaArrayType, JavaTypeAttributes javaTypeAttributes, boolean z) {
        Intrinsics.checkNotNullParameter(javaArrayType, "arrayType");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "attr");
        JavaType componentType = javaArrayType.getComponentType();
        JavaPrimitiveType javaPrimitiveType = componentType instanceof JavaPrimitiveType ? (JavaPrimitiveType) componentType : null;
        PrimitiveType type = javaPrimitiveType != null ? javaPrimitiveType.getType() : null;
        LazyJavaAnnotations lazyJavaAnnotations = new LazyJavaAnnotations(this.c, javaArrayType, true);
        if (type != null) {
            SimpleType primitiveArrayKotlinType = this.c.getModule().getBuiltIns().getPrimitiveArrayKotlinType(type);
            Intrinsics.checkNotNullExpressionValue(primitiveArrayKotlinType, "c.module.builtIns.getPri…KotlinType(primitiveType)");
            KotlinType kotlinType = primitiveArrayKotlinType;
            TypeUtilsKt.replaceAnnotations(kotlinType, Annotations.Companion.create(CollectionsKt.plus(lazyJavaAnnotations, (LazyJavaAnnotations) primitiveArrayKotlinType.getAnnotations())));
            return javaTypeAttributes.isForAnnotationParameter() ? kotlinType : KotlinTypeFactory.flexibleType(primitiveArrayKotlinType, primitiveArrayKotlinType.makeNullableAsSpecified(true));
        }
        KotlinType transformJavaType = transformJavaType(componentType, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, javaTypeAttributes.isForAnnotationParameter(), (TypeParameterDescriptor) null, 2, (Object) null));
        if (javaTypeAttributes.isForAnnotationParameter()) {
            SimpleType arrayType = this.c.getModule().getBuiltIns().getArrayType(z ? Variance.OUT_VARIANCE : Variance.INVARIANT, transformJavaType, lazyJavaAnnotations);
            Intrinsics.checkNotNullExpressionValue(arrayType, "c.module.builtIns.getArr…mponentType, annotations)");
            return arrayType;
        }
        Annotations annotations = lazyJavaAnnotations;
        SimpleType arrayType2 = this.c.getModule().getBuiltIns().getArrayType(Variance.INVARIANT, transformJavaType, annotations);
        Intrinsics.checkNotNullExpressionValue(arrayType2, "c.module.builtIns.getArr…mponentType, annotations)");
        return KotlinTypeFactory.flexibleType(arrayType2, this.c.getModule().getBuiltIns().getArrayType(Variance.OUT_VARIANCE, transformJavaType, annotations).makeNullableAsSpecified(true));
    }

    private static final ErrorType transformJavaClassifierType$errorType(JavaClassifierType javaClassifierType) {
        return ErrorUtils.createErrorType(ErrorTypeKind.UNRESOLVED_JAVA_CLASS, javaClassifierType.getPresentableText());
    }

    private final KotlinType transformJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        boolean z = !javaTypeAttributes.isForAnnotationParameter() && javaTypeAttributes.getHowThisTypeIsUsed() != TypeUsage.SUPERTYPE;
        boolean isRaw = javaClassifierType.isRaw();
        if (isRaw || z) {
            SimpleType computeSimpleJavaClassifierType = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND), (SimpleType) null);
            if (computeSimpleJavaClassifierType == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            SimpleType computeSimpleJavaClassifierType2 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes.withFlexibility(JavaTypeFlexibility.FLEXIBLE_UPPER_BOUND), computeSimpleJavaClassifierType);
            if (computeSimpleJavaClassifierType2 == null) {
                return transformJavaClassifierType$errorType(javaClassifierType);
            }
            if (isRaw) {
                return new RawTypeImpl(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
            }
            return KotlinTypeFactory.flexibleType(computeSimpleJavaClassifierType, computeSimpleJavaClassifierType2);
        }
        SimpleType computeSimpleJavaClassifierType3 = computeSimpleJavaClassifierType(javaClassifierType, javaTypeAttributes, (SimpleType) null);
        return computeSimpleJavaClassifierType3 != null ? computeSimpleJavaClassifierType3 : transformJavaClassifierType$errorType(javaClassifierType);
    }

    private final SimpleType computeSimpleJavaClassifierType(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, SimpleType simpleType) {
        TypeAttributes typeAttributes;
        if (simpleType == null || (typeAttributes = simpleType.getAttributes()) == null) {
            typeAttributes = TypeAttributesKt.toDefaultAttributes(new LazyJavaAnnotations(this.c, javaClassifierType, false, 4, (DefaultConstructorMarker) null));
        }
        TypeAttributes typeAttributes2 = typeAttributes;
        TypeConstructor computeTypeConstructor = computeTypeConstructor(javaClassifierType, javaTypeAttributes);
        TypeConstructor typeConstructor = null;
        if (computeTypeConstructor == null) {
            return null;
        }
        boolean isNullable = isNullable(javaTypeAttributes);
        if (simpleType != null) {
            typeConstructor = simpleType.getConstructor();
        }
        if (!Intrinsics.areEqual((Object) typeConstructor, (Object) computeTypeConstructor) || javaClassifierType.isRaw() || !isNullable) {
            return KotlinTypeFactory.simpleType$default(typeAttributes2, computeTypeConstructor, (List) computeArguments(javaClassifierType, javaTypeAttributes, computeTypeConstructor), isNullable, (KotlinTypeRefiner) null, 16, (Object) null);
        }
        return simpleType.makeNullableAsSpecified(true);
    }

    private final TypeConstructor computeTypeConstructor(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes) {
        TypeConstructor typeConstructor;
        JavaClassifier classifier = javaClassifierType.getClassifier();
        if (classifier == null) {
            return createNotFoundClass(javaClassifierType);
        }
        if (classifier instanceof JavaClass) {
            JavaClass javaClass = (JavaClass) classifier;
            FqName fqName = javaClass.getFqName();
            if (fqName != null) {
                ClassDescriptor mapKotlinClass = mapKotlinClass(javaClassifierType, javaTypeAttributes, fqName);
                if (mapKotlinClass == null) {
                    mapKotlinClass = this.c.getComponents().getModuleClassResolver().resolveClass(javaClass);
                }
                if (mapKotlinClass == null || (typeConstructor = mapKotlinClass.getTypeConstructor()) == null) {
                    return createNotFoundClass(javaClassifierType);
                }
                return typeConstructor;
            }
            throw new AssertionError("Class type should have a FQ name: " + classifier);
        } else if (classifier instanceof JavaTypeParameter) {
            TypeParameterDescriptor resolveTypeParameter = this.typeParameterResolver.resolveTypeParameter((JavaTypeParameter) classifier);
            if (resolveTypeParameter != null) {
                return resolveTypeParameter.getTypeConstructor();
            }
            return null;
        } else {
            throw new IllegalStateException("Unknown classifier kind: " + classifier);
        }
    }

    private final TypeConstructor createNotFoundClass(JavaClassifierType javaClassifierType) {
        ClassId classId = ClassId.topLevel(new FqName(javaClassifierType.getClassifierQualifiedName()));
        Intrinsics.checkNotNullExpressionValue(classId, "topLevel(FqName(javaType.classifierQualifiedName))");
        TypeConstructor typeConstructor = this.c.getComponents().getDeserializedDescriptorResolver().getComponents().getNotFoundClasses().getClass(classId, CollectionsKt.listOf(0)).getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "c.components.deserialize…istOf(0)).typeConstructor");
        return typeConstructor;
    }

    private final ClassDescriptor mapKotlinClass(JavaClassifierType javaClassifierType, JavaTypeAttributes javaTypeAttributes, FqName fqName) {
        if (javaTypeAttributes.isForAnnotationParameter() && Intrinsics.areEqual((Object) fqName, (Object) JavaTypeResolverKt.JAVA_LANG_CLASS_FQ_NAME)) {
            return this.c.getComponents().getReflectionTypes().getKClass();
        }
        JavaToKotlinClassMapper javaToKotlinClassMapper = JavaToKotlinClassMapper.INSTANCE;
        ClassDescriptor mapJavaToKotlin$default = JavaToKotlinClassMapper.mapJavaToKotlin$default(javaToKotlinClassMapper, fqName, this.c.getModule().getBuiltIns(), (Integer) null, 4, (Object) null);
        if (mapJavaToKotlin$default == null) {
            return null;
        }
        return (!javaToKotlinClassMapper.isReadOnly(mapJavaToKotlin$default) || !(javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE || argumentsMakeSenseOnlyForMutableContainer(javaClassifierType, mapJavaToKotlin$default))) ? mapJavaToKotlin$default : javaToKotlinClassMapper.convertReadOnlyToMutable(mapJavaToKotlin$default);
    }

    private final boolean argumentsMakeSenseOnlyForMutableContainer(JavaClassifierType javaClassifierType, ClassDescriptor classDescriptor) {
        Variance variance;
        if (!JavaTypesKt.isSuperWildcard((JavaType) CollectionsKt.lastOrNull(javaClassifierType.getTypeArguments()))) {
            return false;
        }
        List<TypeParameterDescriptor> parameters = JavaToKotlinClassMapper.INSTANCE.convertReadOnlyToMutable(classDescriptor).getTypeConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "JavaToKotlinClassMapper.…ypeConstructor.parameters");
        TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull(parameters);
        if (typeParameterDescriptor == null || (variance = typeParameterDescriptor.getVariance()) == null || variance == Variance.OUT_VARIANCE) {
            return false;
        }
        return true;
    }

    private final List<TypeProjection> computeRawTypeArguments(JavaClassifierType javaClassifierType, List<? extends TypeParameterDescriptor> list, TypeConstructor typeConstructor, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjection;
        Iterable<TypeParameterDescriptor> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (TypeParameterDescriptor typeParameterDescriptor : iterable) {
            if (TypeUtilsKt.hasTypeParameterRecursiveBounds(typeParameterDescriptor, (TypeConstructor) null, javaTypeAttributes.getVisitedTypeParameters())) {
                typeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
            } else {
                typeProjection = this.rawSubstitution.computeProjection(typeParameterDescriptor, javaClassifierType.isRaw() ? javaTypeAttributes : javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE), new LazyWrappedType(this.c.getStorageManager(), new JavaTypeResolver$computeRawTypeArguments$1$erasedUpperBound$1(this, typeParameterDescriptor, javaClassifierType, javaTypeAttributes, typeConstructor)));
            }
            arrayList.add(typeProjection);
        }
        return (List) arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        if ((!r0.isEmpty()) != false) goto L_0x0027;
     */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<kotlin.reflect.jvm.internal.impl.types.TypeProjection> computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType r7, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r8, kotlin.reflect.jvm.internal.impl.types.TypeConstructor r9) {
        /*
            r6 = this;
            boolean r0 = r7.isRaw()
            java.lang.String r1 = "constructor.parameters"
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0027
            java.util.List r0 = r7.getTypeArguments()
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0025
            java.util.List r0 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r3
            if (r0 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r0 = r2
            goto L_0x0028
        L_0x0027:
            r0 = r3
        L_0x0028:
            java.util.List r4 = r9.getParameters()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r1)
            if (r0 == 0) goto L_0x0036
            java.util.List r7 = r6.computeRawTypeArguments(r7, r4, r9, r8)
            return r7
        L_0x0036:
            int r8 = r4.size()
            java.util.List r9 = r7.getTypeArguments()
            int r9 = r9.size()
            r0 = 10
            if (r8 == r9) goto L_0x008e
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            java.util.ArrayList r7 = new java.util.ArrayList
            int r8 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r4, r0)
            r7.<init>(r8)
            java.util.Collection r7 = (java.util.Collection) r7
            java.util.Iterator r8 = r4.iterator()
        L_0x0057:
            boolean r9 = r8.hasNext()
            if (r9 == 0) goto L_0x0085
            java.lang.Object r9 = r8.next()
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r9 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r9
            kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl r0 = new kotlin.reflect.jvm.internal.impl.types.TypeProjectionImpl
            kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind r1 = kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind.MISSED_TYPE_ARGUMENT_FOR_TYPE_PARAMETER
            java.lang.String[] r4 = new java.lang.String[r3]
            kotlin.reflect.jvm.internal.impl.name.Name r9 = r9.getName()
            java.lang.String r9 = r9.asString()
            java.lang.String r5 = "p.name.asString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r5)
            r4[r2] = r9
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r9 = kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils.createErrorType(r1, r4)
            kotlin.reflect.jvm.internal.impl.types.KotlinType r9 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r9
            r0.<init>(r9)
            r7.add(r0)
            goto L_0x0057
        L_0x0085:
            java.util.List r7 = (java.util.List) r7
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.toList(r7)
            return r7
        L_0x008e:
            java.util.List r7 = r7.getTypeArguments()
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.lang.Iterable r7 = kotlin.collections.CollectionsKt.withIndex(r7)
            java.util.ArrayList r8 = new java.util.ArrayList
            int r9 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r0)
            r8.<init>(r9)
            java.util.Collection r8 = (java.util.Collection) r8
            java.util.Iterator r7 = r7.iterator()
        L_0x00a7:
            boolean r9 = r7.hasNext()
            if (r9 == 0) goto L_0x00db
            java.lang.Object r9 = r7.next()
            kotlin.collections.IndexedValue r9 = (kotlin.collections.IndexedValue) r9
            int r0 = r9.component1()
            java.lang.Object r9 = r9.component2()
            kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType r9 = (kotlin.reflect.jvm.internal.impl.load.java.structure.JavaType) r9
            r4.size()
            java.lang.Object r0 = r4.get(r0)
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r0 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r0
            kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage r1 = kotlin.reflect.jvm.internal.impl.load.java.components.TypeUsage.COMMON
            r3 = 3
            r5 = 0
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r1 = kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolverKt.toAttributes$default(r1, r2, r5, r3, r5)
            java.lang.String r3 = "parameter"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r9 = r6.transformToTypeProjection(r9, r1, r0)
            r8.add(r9)
            goto L_0x00a7
        L_0x00db:
            java.util.List r8 = (java.util.List) r8
            java.lang.Iterable r8 = (java.lang.Iterable) r8
            java.util.List r7 = kotlin.collections.CollectionsKt.toList(r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeResolver.computeArguments(kotlin.reflect.jvm.internal.impl.load.java.structure.JavaClassifierType, kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes, kotlin.reflect.jvm.internal.impl.types.TypeConstructor):java.util.List");
    }

    private final TypeProjection transformToTypeProjection(JavaType javaType, JavaTypeAttributes javaTypeAttributes, TypeParameterDescriptor typeParameterDescriptor) {
        if (!(javaType instanceof JavaWildcardType)) {
            return new TypeProjectionImpl(Variance.INVARIANT, transformJavaType(javaType, javaTypeAttributes));
        }
        JavaWildcardType javaWildcardType = (JavaWildcardType) javaType;
        JavaType bound = javaWildcardType.getBound();
        Variance variance = javaWildcardType.isExtends() ? Variance.OUT_VARIANCE : Variance.IN_VARIANCE;
        if (bound == null || isConflictingArgumentFor(variance, typeParameterDescriptor)) {
            return JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor, javaTypeAttributes);
        }
        return TypeUtilsKt.createProjection(transformJavaType(bound, JavaTypeResolverKt.toAttributes$default(TypeUsage.COMMON, false, (TypeParameterDescriptor) null, 3, (Object) null)), variance, typeParameterDescriptor);
    }

    private final boolean isConflictingArgumentFor(Variance variance, TypeParameterDescriptor typeParameterDescriptor) {
        if (typeParameterDescriptor.getVariance() == Variance.INVARIANT || variance == typeParameterDescriptor.getVariance()) {
            return false;
        }
        return true;
    }

    private final boolean isNullable(JavaTypeAttributes javaTypeAttributes) {
        if (javaTypeAttributes.getFlexibility() == JavaTypeFlexibility.FLEXIBLE_LOWER_BOUND || javaTypeAttributes.isForAnnotationParameter() || javaTypeAttributes.getHowThisTypeIsUsed() == TypeUsage.SUPERTYPE) {
            return false;
        }
        return true;
    }
}
