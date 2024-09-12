package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.TypeParameterDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.NullabilityChecker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;

/* compiled from: SpecialTypes.kt */
public final class DefinitelyNotNullType extends DelegatingSimpleType implements CustomTypeParameter, DefinitelyNotNullTypeMarker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final SimpleType original;
    private final boolean useCorrectedNullabilityForTypeParameters;

    public /* synthetic */ DefinitelyNotNullType(SimpleType simpleType, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(simpleType, z);
    }

    public boolean isMarkedNullable() {
        return false;
    }

    public final SimpleType getOriginal() {
        return this.original;
    }

    private DefinitelyNotNullType(SimpleType simpleType, boolean z) {
        this.original = simpleType;
        this.useCorrectedNullabilityForTypeParameters = z;
    }

    /* compiled from: SpecialTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ DefinitelyNotNullType makeDefinitelyNotNull$default(Companion companion, UnwrappedType unwrappedType, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.makeDefinitelyNotNull(unwrappedType, z);
        }

        public final DefinitelyNotNullType makeDefinitelyNotNull(UnwrappedType unwrappedType, boolean z) {
            Intrinsics.checkNotNullParameter(unwrappedType, "type");
            if (unwrappedType instanceof DefinitelyNotNullType) {
                return (DefinitelyNotNullType) unwrappedType;
            }
            if (!makesSenseToBeDefinitelyNotNull(unwrappedType, z)) {
                return null;
            }
            if (unwrappedType instanceof FlexibleType) {
                FlexibleType flexibleType = (FlexibleType) unwrappedType;
                Intrinsics.areEqual((Object) flexibleType.getLowerBound().getConstructor(), (Object) flexibleType.getUpperBound().getConstructor());
            }
            return new DefinitelyNotNullType(FlexibleTypesKt.lowerIfFlexible(unwrappedType).makeNullableAsSpecified(false), z, (DefaultConstructorMarker) null);
        }

        private final boolean makesSenseToBeDefinitelyNotNull(UnwrappedType unwrappedType, boolean z) {
            boolean z2 = false;
            if (!canHaveUndefinedNullability(unwrappedType)) {
                return false;
            }
            if (unwrappedType instanceof StubTypeForBuilderInference) {
                return TypeUtils.isNullableType(unwrappedType);
            }
            ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
            TypeParameterDescriptorImpl typeParameterDescriptorImpl = declarationDescriptor instanceof TypeParameterDescriptorImpl ? (TypeParameterDescriptorImpl) declarationDescriptor : null;
            if (typeParameterDescriptorImpl != null && !typeParameterDescriptorImpl.isInitialized()) {
                z2 = true;
            }
            if (z2) {
                return true;
            }
            if (!z || !(unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor)) {
                return !NullabilityChecker.INSTANCE.isSubtypeOfAny(unwrappedType);
            }
            return TypeUtils.isNullableType(unwrappedType);
        }

        private final boolean canHaveUndefinedNullability(UnwrappedType unwrappedType) {
            return (unwrappedType.getConstructor() instanceof NewTypeVariableConstructor) || (unwrappedType.getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor) || (unwrappedType instanceof NewCapturedType) || (unwrappedType instanceof StubTypeForBuilderInference);
        }
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.original;
    }

    public boolean isTypeParameter() {
        return (getDelegate().getConstructor() instanceof NewTypeVariableConstructor) || (getDelegate().getConstructor().getDeclarationDescriptor() instanceof TypeParameterDescriptor);
    }

    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        return SpecialTypesKt.makeDefinitelyNotNullOrNotNull(kotlinType.unwrap(), this.useCorrectedNullabilityForTypeParameters);
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new DefinitelyNotNullType(getDelegate().replaceAttributes(typeAttributes), this.useCorrectedNullabilityForTypeParameters);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(z) : this;
    }

    public String toString() {
        return getDelegate() + " & Any";
    }

    public DefinitelyNotNullType replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new DefinitelyNotNullType(simpleType, this.useCorrectedNullabilityForTypeParameters);
    }
}
