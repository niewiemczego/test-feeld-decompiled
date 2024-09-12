package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.builtins.jvm.JavaToKotlinClassMap;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: signatureEnhancement.kt */
final class SignatureEnhancement$containsFunctionN$1 extends Lambda implements Function1<UnwrappedType, Boolean> {
    public static final SignatureEnhancement$containsFunctionN$1 INSTANCE = new SignatureEnhancement$containsFunctionN$1();

    SignatureEnhancement$containsFunctionN$1() {
        super(1);
    }

    public final Boolean invoke(UnwrappedType unwrappedType) {
        ClassifierDescriptor declarationDescriptor = unwrappedType.getConstructor().getDeclarationDescriptor();
        boolean z = false;
        if (declarationDescriptor == null) {
            return false;
        }
        if (Intrinsics.areEqual((Object) declarationDescriptor.getName(), (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME().shortName()) && Intrinsics.areEqual((Object) DescriptorUtilsKt.fqNameOrNull(declarationDescriptor), (Object) JavaToKotlinClassMap.INSTANCE.getFUNCTION_N_FQ_NAME())) {
            z = true;
        }
        return Boolean.valueOf(z);
    }
}
