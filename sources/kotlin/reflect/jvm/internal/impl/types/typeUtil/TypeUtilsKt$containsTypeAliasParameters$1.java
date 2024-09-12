package kotlin.reflect.jvm.internal.impl.types.typeUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: TypeUtils.kt */
final class TypeUtilsKt$containsTypeAliasParameters$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final TypeUtilsKt$containsTypeAliasParameters$1 INSTANCE = new TypeUtilsKt$containsTypeAliasParameters$1();

    TypeUtilsKt$containsTypeAliasParameters$1() {
        super(1);
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        Intrinsics.checkNotNullParameter(unwrappedType, "it");
        ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
        return Boolean.valueOf(declarationDescriptor != null ? TypeUtilsKt.isTypeAliasParameter(declarationDescriptor) : false);
    }
}
