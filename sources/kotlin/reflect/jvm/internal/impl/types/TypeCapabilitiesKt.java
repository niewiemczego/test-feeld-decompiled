package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeCapabilities.kt */
public final class TypeCapabilitiesKt {
    public static final boolean isCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        CustomTypeParameter customTypeParameter = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (customTypeParameter != null) {
            return customTypeParameter.isTypeParameter();
        }
        return false;
    }

    public static final CustomTypeParameter getCustomTypeParameter(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        CustomTypeParameter customTypeParameter = unwrap instanceof CustomTypeParameter ? (CustomTypeParameter) unwrap : null;
        if (customTypeParameter == null || !customTypeParameter.isTypeParameter()) {
            return null;
        }
        return customTypeParameter;
    }
}
