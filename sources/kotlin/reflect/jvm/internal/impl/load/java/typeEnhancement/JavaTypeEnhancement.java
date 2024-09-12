package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.JavaResolverSettings;
import kotlin.reflect.jvm.internal.impl.types.FlexibleTypesKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.SpecialTypesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributesKt;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class JavaTypeEnhancement {
    private final JavaResolverSettings javaResolverSettings;

    /* compiled from: typeEnhancement.kt */
    private static final class Result {
        private final int subtreeSize;
        private final KotlinType type;

        public Result(KotlinType kotlinType, int i) {
            this.type = kotlinType;
            this.subtreeSize = i;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final KotlinType getType() {
            return this.type;
        }
    }

    public JavaTypeEnhancement(JavaResolverSettings javaResolverSettings2) {
        Intrinsics.checkNotNullParameter(javaResolverSettings2, "javaResolverSettings");
        this.javaResolverSettings = javaResolverSettings2;
    }

    /* compiled from: typeEnhancement.kt */
    private static final class SimpleResult {
        private final boolean forWarnings;
        private final int subtreeSize;
        private final SimpleType type;

        public SimpleResult(SimpleType simpleType, int i, boolean z) {
            this.type = simpleType;
            this.subtreeSize = i;
            this.forWarnings = z;
        }

        public final boolean getForWarnings() {
            return this.forWarnings;
        }

        public final int getSubtreeSize() {
            return this.subtreeSize;
        }

        public final SimpleType getType() {
            return this.type;
        }
    }

    public final KotlinType enhance(KotlinType kotlinType, Function1<? super Integer, JavaTypeQualifiers> function1, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(function1, "qualifiers");
        return enhancePossiblyFlexible(kotlinType.unwrap(), function1, 0, z).getType();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x009c, code lost:
        if (r13 == null) goto L_0x009e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.Result enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeQualifiers> r13, int r14, boolean r15) {
        /*
            r11 = this;
            r0 = r12
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r0
            boolean r0 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt.isError(r0)
            r1 = 0
            if (r0 == 0) goto L_0x0011
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            r13 = 1
            r12.<init>(r1, r13)
            return r12
        L_0x0011:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.FlexibleType
            if (r0 == 0) goto L_0x00b9
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.RawType
            r9 = r12
            kotlin.reflect.jvm.internal.impl.types.FlexibleType r9 = (kotlin.reflect.jvm.internal.impl.types.FlexibleType) r9
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getLowerBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_LOWER
            r2 = r11
            r4 = r13
            r5 = r14
            r7 = r0
            r8 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r10 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r9.getUpperBound()
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r6 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.FLEXIBLE_UPPER
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = r2.enhanceInflexible(r3, r4, r5, r6, r7, r8)
            r10.getSubtreeSize()
            r13.getSubtreeSize()
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0046
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r13.getType()
            if (r14 != 0) goto L_0x0046
            goto L_0x00ad
        L_0x0046:
            boolean r14 = r10.getForWarnings()
            if (r14 != 0) goto L_0x008b
            boolean r14 = r13.getForWarnings()
            if (r14 == 0) goto L_0x0053
            goto L_0x008b
        L_0x0053:
            if (r0 == 0) goto L_0x0072
            kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl r12 = new kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0061
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r9.getLowerBound()
        L_0x0061:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x006b
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x006b:
            r12.<init>(r14, r13)
            r1 = r12
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r1
            goto L_0x00ad
        L_0x0072:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r10.getType()
            if (r12 != 0) goto L_0x007c
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r9.getLowerBound()
        L_0x007c:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 != 0) goto L_0x0086
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r9.getUpperBound()
        L_0x0086:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r12, r13)
            goto L_0x00ad
        L_0x008b:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r13.getType()
            if (r13 == 0) goto L_0x009e
            kotlin.reflect.jvm.internal.impl.types.SimpleType r14 = r10.getType()
            if (r14 != 0) goto L_0x0098
            r14 = r13
        L_0x0098:
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory.flexibleType(r14, r13)
            if (r13 != 0) goto L_0x00a7
        L_0x009e:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r13 = r10.getType()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r13 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r13
        L_0x00a7:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r13 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r13
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r1 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r13)
        L_0x00ad:
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r12 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            int r13 = r10.getSubtreeSize()
            r12.<init>(r1, r13)
            goto L_0x00f1
        L_0x00b9:
            boolean r0 = r12 instanceof kotlin.reflect.jvm.internal.impl.types.SimpleType
            if (r0 == 0) goto L_0x00f2
            r2 = r12
            kotlin.reflect.jvm.internal.impl.types.SimpleType r2 = (kotlin.reflect.jvm.internal.impl.types.SimpleType) r2
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition r5 = kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.TypeComponentPosition.INFLEXIBLE
            r6 = 0
            r8 = 8
            r9 = 0
            r1 = r11
            r3 = r13
            r4 = r14
            r7 = r15
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$SimpleResult r13 = enhanceInflexible$default(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result r14 = new kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result
            boolean r15 = r13.getForWarnings()
            if (r15 == 0) goto L_0x00e1
            kotlin.reflect.jvm.internal.impl.types.SimpleType r15 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r15 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r15
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt.wrapEnhancement(r12, r15)
            goto L_0x00e7
        L_0x00e1:
            kotlin.reflect.jvm.internal.impl.types.SimpleType r12 = r13.getType()
            kotlin.reflect.jvm.internal.impl.types.UnwrappedType r12 = (kotlin.reflect.jvm.internal.impl.types.UnwrappedType) r12
        L_0x00e7:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r12 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r12
            int r13 = r13.getSubtreeSize()
            r14.<init>(r12, r13)
            r12 = r14
        L_0x00f1:
            return r12
        L_0x00f2:
            kotlin.NoWhenBranchMatchedException r12 = new kotlin.NoWhenBranchMatchedException
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement.enhancePossiblyFlexible(kotlin.reflect.jvm.internal.impl.types.UnwrappedType, kotlin.jvm.functions.Function1, int, boolean):kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.JavaTypeEnhancement$Result");
    }

    static /* synthetic */ SimpleResult enhanceInflexible$default(JavaTypeEnhancement javaTypeEnhancement, SimpleType simpleType, Function1 function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2, int i2, Object obj) {
        return javaTypeEnhancement.enhanceInflexible(simpleType, function1, i, typeComponentPosition, (i2 & 8) != 0 ? false : z, (i2 & 16) != 0 ? false : z2);
    }

    private final SimpleResult enhanceInflexible(SimpleType simpleType, Function1<? super Integer, JavaTypeQualifiers> function1, int i, TypeComponentPosition typeComponentPosition, boolean z, boolean z2) {
        TypeConstructor typeConstructor;
        boolean z3;
        boolean z4;
        boolean z5;
        Result result;
        TypeProjection typeProjection;
        Function1<? super Integer, JavaTypeQualifiers> function12 = function1;
        TypeComponentPosition typeComponentPosition2 = typeComponentPosition;
        boolean z6 = z2;
        boolean shouldEnhance = TypeComponentPositionKt.shouldEnhance(typeComponentPosition);
        boolean z7 = !z6 || !z;
        KotlinType kotlinType = null;
        if (!shouldEnhance && simpleType.getArguments().isEmpty()) {
            return new SimpleResult((SimpleType) null, 1, false);
        }
        ClassifierDescriptor declarationDescriptor = simpleType.getConstructor().getDeclarationDescriptor();
        if (declarationDescriptor == null) {
            return new SimpleResult((SimpleType) null, 1, false);
        }
        JavaTypeQualifiers invoke = function12.invoke(Integer.valueOf(i));
        ClassifierDescriptor access$enhanceMutability = TypeEnhancementKt.enhanceMutability(declarationDescriptor, invoke, typeComponentPosition2);
        Boolean access$getEnhancedNullability = TypeEnhancementKt.getEnhancedNullability(invoke, typeComponentPosition2);
        if (access$enhanceMutability == null || (typeConstructor = access$enhanceMutability.getTypeConstructor()) == null) {
            typeConstructor = simpleType.getConstructor();
        }
        TypeConstructor typeConstructor2 = typeConstructor;
        Intrinsics.checkNotNullExpressionValue(typeConstructor2, "enhancedClassifier?.typeConstructor ?: constructor");
        int i2 = i + 1;
        Iterable arguments = simpleType.getArguments();
        List<TypeParameterDescriptor> parameters = typeConstructor2.getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
        Iterable iterable = parameters;
        Iterator it = arguments.iterator();
        Iterator it2 = iterable.iterator();
        ArrayList arrayList = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(arguments, 10), CollectionsKt.collectionSizeOrDefault(iterable, 10)));
        while (it.hasNext() && it2.hasNext()) {
            Object next = it.next();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) it2.next();
            TypeProjection typeProjection2 = (TypeProjection) next;
            if (!z7) {
                z5 = z7;
                result = new Result(kotlinType, 0);
            } else {
                z5 = z7;
                if (!typeProjection2.isStarProjection()) {
                    result = enhancePossiblyFlexible(typeProjection2.getType().unwrap(), function12, i2, z6);
                } else if (function12.invoke(Integer.valueOf(i2)).getNullability() == NullabilityQualifier.FORCE_FLEXIBILITY) {
                    KotlinType unwrap = typeProjection2.getType().unwrap();
                    result = new Result(KotlinTypeFactory.flexibleType(FlexibleTypesKt.lowerIfFlexible(unwrap).makeNullableAsSpecified(false), FlexibleTypesKt.upperIfFlexible(unwrap).makeNullableAsSpecified(true)), 1);
                } else {
                    result = new Result((KotlinType) null, 1);
                }
            }
            i2 += result.getSubtreeSize();
            if (result.getType() != null) {
                KotlinType type = result.getType();
                Variance projectionKind = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type, projectionKind, typeParameterDescriptor);
            } else if (access$enhanceMutability == null || typeProjection2.isStarProjection()) {
                typeProjection = access$enhanceMutability != null ? TypeUtils.makeStarProjection(typeParameterDescriptor) : null;
            } else {
                KotlinType type2 = typeProjection2.getType();
                Intrinsics.checkNotNullExpressionValue(type2, "arg.type");
                Variance projectionKind2 = typeProjection2.getProjectionKind();
                Intrinsics.checkNotNullExpressionValue(projectionKind2, "arg.projectionKind");
                typeProjection = TypeUtilsKt.createProjection(type2, projectionKind2, typeParameterDescriptor);
            }
            arrayList.add(typeProjection);
            function12 = function1;
            z7 = z5;
            kotlinType = null;
        }
        List list = arrayList;
        int i3 = i2 - i;
        if (access$enhanceMutability == null && access$getEnhancedNullability == null) {
            Iterable iterable2 = list;
            if (!(iterable2 instanceof Collection) || !((Collection) iterable2).isEmpty()) {
                Iterator it3 = iterable2.iterator();
                while (true) {
                    if (!it3.hasNext()) {
                        break;
                    }
                    if (((TypeProjection) it3.next()) == null) {
                        z4 = true;
                        continue;
                    } else {
                        z4 = false;
                        continue;
                    }
                    if (!z4) {
                        z3 = false;
                        break;
                    }
                }
            }
            z3 = true;
            if (z3) {
                return new SimpleResult((SimpleType) null, i3, false);
            }
        }
        Annotations[] annotationsArr = new Annotations[3];
        annotationsArr[0] = simpleType.getAnnotations();
        EnhancedTypeAnnotations access$getENHANCED_MUTABILITY_ANNOTATIONS$p = TypeEnhancementKt.ENHANCED_MUTABILITY_ANNOTATIONS;
        if (!(access$enhanceMutability != null)) {
            access$getENHANCED_MUTABILITY_ANNOTATIONS$p = null;
        }
        annotationsArr[1] = access$getENHANCED_MUTABILITY_ANNOTATIONS$p;
        EnhancedTypeAnnotations access$getENHANCED_NULLABILITY_ANNOTATIONS$p = TypeEnhancementKt.ENHANCED_NULLABILITY_ANNOTATIONS;
        if (!(access$getEnhancedNullability != null)) {
            access$getENHANCED_NULLABILITY_ANNOTATIONS$p = null;
        }
        annotationsArr[2] = access$getENHANCED_NULLABILITY_ANNOTATIONS$p;
        TypeAttributes defaultAttributes = TypeAttributesKt.toDefaultAttributes(TypeEnhancementKt.compositeAnnotationsOrSingle(CollectionsKt.listOfNotNull((T[]) annotationsArr)));
        Iterable iterable3 = list;
        Iterable arguments2 = simpleType.getArguments();
        Iterator it4 = iterable3.iterator();
        Iterator it5 = arguments2.iterator();
        ArrayList arrayList2 = new ArrayList(Math.min(CollectionsKt.collectionSizeOrDefault(iterable3, 10), CollectionsKt.collectionSizeOrDefault(arguments2, 10)));
        while (it4.hasNext() && it5.hasNext()) {
            Object next2 = it4.next();
            TypeProjection typeProjection3 = (TypeProjection) it5.next();
            TypeProjection typeProjection4 = (TypeProjection) next2;
            if (typeProjection4 != null) {
                typeProjection3 = typeProjection4;
            }
            arrayList2.add(typeProjection3);
        }
        SimpleType simpleType$default = KotlinTypeFactory.simpleType$default(defaultAttributes, typeConstructor2, (List) arrayList2, access$getEnhancedNullability != null ? access$getEnhancedNullability.booleanValue() : simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
        if (invoke.getDefinitelyNotNull()) {
            simpleType$default = notNullTypeParameter(simpleType$default);
        }
        return new SimpleResult(simpleType$default, i3, access$getEnhancedNullability != null && invoke.isNullabilityQualifierForWarning());
    }

    private final SimpleType notNullTypeParameter(SimpleType simpleType) {
        if (this.javaResolverSettings.getCorrectNullabilityForNotNullTypeParameter()) {
            return SpecialTypesKt.makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, true);
        }
        return new NotNullTypeParameterImpl(simpleType);
    }
}
