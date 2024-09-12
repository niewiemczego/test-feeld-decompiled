package kotlin.reflect.jvm.internal.impl.types;

import com.facebook.react.uimanager.ViewProps;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeWithEnhancement.kt */
public final class TypeWithEnhancementKt {
    public static final KotlinType getEnhancement(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        if (kotlinType instanceof TypeWithEnhancement) {
            return ((TypeWithEnhancement) kotlinType).getEnhancement();
        }
        return null;
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType, Function1<? super KotlinType, ? extends KotlinType> function1) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "origin");
        Intrinsics.checkNotNullParameter(function1, ViewProps.TRANSFORM);
        KotlinType enhancement = getEnhancement(kotlinType);
        return wrapEnhancement(unwrappedType, enhancement != null ? (KotlinType) function1.invoke(enhancement) : null);
    }

    public static final UnwrappedType inheritEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        Intrinsics.checkNotNullParameter(kotlinType, "origin");
        return wrapEnhancement(unwrappedType, getEnhancement(kotlinType));
    }

    public static final UnwrappedType wrapEnhancement(UnwrappedType unwrappedType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        if (unwrappedType instanceof TypeWithEnhancement) {
            return wrapEnhancement(((TypeWithEnhancement) unwrappedType).getOrigin(), kotlinType);
        }
        if (kotlinType == null || Intrinsics.areEqual((Object) kotlinType, (Object) unwrappedType)) {
            return unwrappedType;
        }
        if (unwrappedType instanceof SimpleType) {
            return new SimpleTypeWithEnhancement((SimpleType) unwrappedType, kotlinType);
        }
        if (unwrappedType instanceof FlexibleType) {
            return new FlexibleTypeWithEnhancement((FlexibleType) unwrappedType, kotlinType);
        }
        throw new NoWhenBranchMatchedException();
    }
}
