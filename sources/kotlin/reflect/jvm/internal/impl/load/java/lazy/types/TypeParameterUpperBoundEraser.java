package kotlin.reflect.jvm.internal.impl.load.java.lazy.types;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: TypeParameterUpperBoundEraser.kt */
public final class TypeParameterUpperBoundEraser {
    private final Lazy erroneousErasedBound$delegate;
    private final MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> getErasedUpperBound;
    private final RawSubstitution rawSubstitution;
    private final LockBasedStorageManager storage;

    public TypeParameterUpperBoundEraser() {
        this((RawSubstitution) null, 1, (DefaultConstructorMarker) null);
    }

    public TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution2) {
        LockBasedStorageManager lockBasedStorageManager = new LockBasedStorageManager("Type parameter upper bound erasion results");
        this.storage = lockBasedStorageManager;
        this.erroneousErasedBound$delegate = LazyKt.lazy(new TypeParameterUpperBoundEraser$erroneousErasedBound$2(this));
        this.rawSubstitution = rawSubstitution2 == null ? new RawSubstitution(this) : rawSubstitution2;
        MemoizedFunctionToNotNull<DataToEraseUpperBound, KotlinType> createMemoizedFunction = lockBasedStorageManager.createMemoizedFunction(new TypeParameterUpperBoundEraser$getErasedUpperBound$1(this));
        Intrinsics.checkNotNullExpressionValue(createMemoizedFunction, "storage.createMemoizedFu… isRaw, typeAttr) }\n    }");
        this.getErasedUpperBound = createMemoizedFunction;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TypeParameterUpperBoundEraser(RawSubstitution rawSubstitution2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : rawSubstitution2);
    }

    private final ErrorType getErroneousErasedBound() {
        return (ErrorType) this.erroneousErasedBound$delegate.getValue();
    }

    /* compiled from: TypeParameterUpperBoundEraser.kt */
    private static final class DataToEraseUpperBound {
        private final boolean isRaw;
        private final JavaTypeAttributes typeAttr;
        private final TypeParameterDescriptor typeParameter;

        public String toString() {
            return "DataToEraseUpperBound(typeParameter=" + this.typeParameter + ", isRaw=" + this.isRaw + ", typeAttr=" + this.typeAttr + ')';
        }

        public DataToEraseUpperBound(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
            Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
            Intrinsics.checkNotNullParameter(javaTypeAttributes, "typeAttr");
            this.typeParameter = typeParameterDescriptor;
            this.isRaw = z;
            this.typeAttr = javaTypeAttributes;
        }

        public final TypeParameterDescriptor getTypeParameter() {
            return this.typeParameter;
        }

        public final boolean isRaw() {
            return this.isRaw;
        }

        public final JavaTypeAttributes getTypeAttr() {
            return this.typeAttr;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof DataToEraseUpperBound)) {
                return false;
            }
            DataToEraseUpperBound dataToEraseUpperBound = (DataToEraseUpperBound) obj;
            if (Intrinsics.areEqual((Object) dataToEraseUpperBound.typeParameter, (Object) this.typeParameter) && dataToEraseUpperBound.isRaw == this.isRaw && dataToEraseUpperBound.typeAttr.getFlexibility() == this.typeAttr.getFlexibility() && dataToEraseUpperBound.typeAttr.getHowThisTypeIsUsed() == this.typeAttr.getHowThisTypeIsUsed() && dataToEraseUpperBound.typeAttr.isForAnnotationParameter() == this.typeAttr.isForAnnotationParameter() && Intrinsics.areEqual((Object) dataToEraseUpperBound.typeAttr.getDefaultType(), (Object) this.typeAttr.getDefaultType())) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.typeParameter.hashCode();
            int i = hashCode + (hashCode * 31) + (this.isRaw ? 1 : 0);
            int hashCode2 = i + (i * 31) + this.typeAttr.getFlexibility().hashCode();
            int hashCode3 = hashCode2 + (hashCode2 * 31) + this.typeAttr.getHowThisTypeIsUsed().hashCode();
            int i2 = hashCode3 + (hashCode3 * 31) + (this.typeAttr.isForAnnotationParameter() ? 1 : 0);
            int i3 = i2 * 31;
            SimpleType defaultType = this.typeAttr.getDefaultType();
            return i2 + i3 + (defaultType != null ? defaultType.hashCode() : 0);
        }
    }

    public final KotlinType getErasedUpperBound$descriptors_jvm(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        Intrinsics.checkNotNullParameter(javaTypeAttributes, "typeAttr");
        return this.getErasedUpperBound.invoke(new DataToEraseUpperBound(typeParameterDescriptor, z, javaTypeAttributes));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlin.reflect.jvm.internal.impl.types.KotlinType getDefaultType(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes r1) {
        /*
            r0 = this;
            kotlin.reflect.jvm.internal.impl.types.SimpleType r1 = r1.getDefaultType()
            if (r1 == 0) goto L_0x000e
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt.replaceArgumentsWithStarProjections(r1)
            if (r1 != 0) goto L_0x0014
        L_0x000e:
            kotlin.reflect.jvm.internal.impl.types.error.ErrorType r1 = r0.getErroneousErasedBound()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r1 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r1
        L_0x0014:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.load.java.lazy.types.TypeParameterUpperBoundEraser.getDefaultType(kotlin.reflect.jvm.internal.impl.load.java.lazy.types.JavaTypeAttributes):kotlin.reflect.jvm.internal.impl.types.KotlinType");
    }

    /* access modifiers changed from: private */
    public final KotlinType getErasedUpperBoundInternal(TypeParameterDescriptor typeParameterDescriptor, boolean z, JavaTypeAttributes javaTypeAttributes) {
        TypeProjection typeProjection;
        JavaTypeAttributes javaTypeAttributes2;
        Set<TypeParameterDescriptor> visitedTypeParameters = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters != null && visitedTypeParameters.contains(typeParameterDescriptor.getOriginal())) {
            return getDefaultType(javaTypeAttributes);
        }
        SimpleType defaultType = typeParameterDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
        Iterable<TypeParameterDescriptor> extractTypeParametersFromUpperBounds = TypeUtilsKt.extractTypeParametersFromUpperBounds(defaultType, visitedTypeParameters);
        Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(extractTypeParametersFromUpperBounds, 10)), 16));
        for (TypeParameterDescriptor typeParameterDescriptor2 : extractTypeParametersFromUpperBounds) {
            if (visitedTypeParameters == null || !visitedTypeParameters.contains(typeParameterDescriptor2)) {
                RawSubstitution rawSubstitution2 = this.rawSubstitution;
                if (z) {
                    javaTypeAttributes2 = javaTypeAttributes;
                } else {
                    javaTypeAttributes2 = javaTypeAttributes.withFlexibility(JavaTypeFlexibility.INFLEXIBLE);
                }
                KotlinType erasedUpperBound$descriptors_jvm = getErasedUpperBound$descriptors_jvm(typeParameterDescriptor2, z, javaTypeAttributes.withNewVisitedTypeParameter(typeParameterDescriptor));
                Intrinsics.checkNotNullExpressionValue(erasedUpperBound$descriptors_jvm, "getErasedUpperBound(it, …Parameter(typeParameter))");
                typeProjection = rawSubstitution2.computeProjection(typeParameterDescriptor2, javaTypeAttributes2, erasedUpperBound$descriptors_jvm);
            } else {
                typeProjection = JavaTypeResolverKt.makeStarProjection(typeParameterDescriptor2, javaTypeAttributes);
            }
            Pair pair = TuplesKt.to(typeParameterDescriptor2.getTypeConstructor(), typeProjection);
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        TypeSubstitutor create = TypeSubstitutor.create((TypeSubstitution) TypeConstructorSubstitution.Companion.createByConstructorsMap$default(TypeConstructorSubstitution.Companion, linkedHashMap, false, 2, (Object) null));
        Intrinsics.checkNotNullExpressionValue(create, "create(TypeConstructorSu…rsMap(erasedUpperBounds))");
        List<KotlinType> upperBounds = typeParameterDescriptor.getUpperBounds();
        Intrinsics.checkNotNullExpressionValue(upperBounds, "typeParameter.upperBounds");
        KotlinType kotlinType = (KotlinType) CollectionsKt.first(upperBounds);
        if (kotlinType.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
            Intrinsics.checkNotNullExpressionValue(kotlinType, "firstUpperBound");
            return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(kotlinType, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
        }
        Set<TypeParameterDescriptor> visitedTypeParameters2 = javaTypeAttributes.getVisitedTypeParameters();
        if (visitedTypeParameters2 == null) {
            visitedTypeParameters2 = SetsKt.setOf(this);
        }
        ClassifierDescriptor declarationDescriptor = kotlinType.getConstructor().getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        while (true) {
            TypeParameterDescriptor typeParameterDescriptor3 = (TypeParameterDescriptor) declarationDescriptor;
            if (visitedTypeParameters2.contains(typeParameterDescriptor3)) {
                return getDefaultType(javaTypeAttributes);
            }
            List<KotlinType> upperBounds2 = typeParameterDescriptor3.getUpperBounds();
            Intrinsics.checkNotNullExpressionValue(upperBounds2, "current.upperBounds");
            KotlinType kotlinType2 = (KotlinType) CollectionsKt.first(upperBounds2);
            if (kotlinType2.getConstructor().getDeclarationDescriptor() instanceof ClassDescriptor) {
                Intrinsics.checkNotNullExpressionValue(kotlinType2, "nextUpperBound");
                return TypeUtilsKt.replaceArgumentsWithStarProjectionOrMapped(kotlinType2, create, linkedHashMap, Variance.OUT_VARIANCE, javaTypeAttributes.getVisitedTypeParameters());
            }
            declarationDescriptor = kotlinType2.getConstructor().getDeclarationDescriptor();
            Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        }
    }
}
