package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeKt;
import kotlin.reflect.jvm.internal.impl.types.StubTypeForBuilderInference;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;

/* compiled from: TypeUtils.kt */
final class TypeUtilsKt$shouldBeUpdated$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final TypeUtilsKt$shouldBeUpdated$1 INSTANCE = new TypeUtilsKt$shouldBeUpdated$1();

    TypeUtilsKt$shouldBeUpdated$1() {
        super(1);
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "it");
        return Boolean.valueOf((unwrappedType instanceof StubTypeForBuilderInference) || (unwrappedType.getConstructor() instanceof TypeVariableTypeConstructorMarker) || KotlinTypeKt.isError(unwrappedType));
    }
}
