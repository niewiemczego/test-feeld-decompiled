package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.DelegatingSimpleType;
import kotlin.reflect.jvm.internal.impl.types.FlexibleType;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.NotNullTypeParameter;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeUtils;
import kotlin.reflect.jvm.internal.impl.types.TypeWithEnhancementKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: typeEnhancement.kt */
public final class NotNullTypeParameterImpl extends DelegatingSimpleType implements NotNullTypeParameter {
    private final SimpleType delegate;

    public boolean isMarkedNullable() {
        return false;
    }

    public boolean isTypeParameter() {
        return true;
    }

    public NotNullTypeParameterImpl(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        this.delegate = simpleType;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.delegate;
    }

    public KotlinType substitutionResult(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "replacement");
        UnwrappedType unwrap = kotlinType.unwrap();
        KotlinType kotlinType2 = unwrap;
        if (!TypeUtilsKt.isTypeParameter(kotlinType2) && !TypeUtils.isNullableType(kotlinType2)) {
            return kotlinType2;
        }
        if (unwrap instanceof SimpleType) {
            return prepareReplacement((SimpleType) unwrap);
        }
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return TypeWithEnhancementKt.wrapEnhancement(KotlinTypeFactory.flexibleType(prepareReplacement(flexibleType.getLowerBound()), prepareReplacement(flexibleType.getUpperBound())), TypeWithEnhancementKt.getEnhancement(kotlinType2));
        }
        throw new IllegalStateException(("Incorrect type: " + unwrap).toString());
    }

    private final SimpleType prepareReplacement(SimpleType simpleType) {
        SimpleType makeNullableAsSpecified = simpleType.makeNullableAsSpecified(false);
        if (!TypeUtilsKt.isTypeParameter(simpleType)) {
            return makeNullableAsSpecified;
        }
        return new NotNullTypeParameterImpl(makeNullableAsSpecified);
    }

    public NotNullTypeParameterImpl replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new NotNullTypeParameterImpl(getDelegate().replaceAttributes(typeAttributes));
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z ? getDelegate().makeNullableAsSpecified(true) : this;
    }

    public NotNullTypeParameterImpl replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new NotNullTypeParameterImpl(simpleType);
    }
}
