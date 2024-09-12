package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;

/* compiled from: DescriptorUtils.kt */
/* synthetic */ class DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 extends FunctionReference implements Function1<ValueParameterDescriptor, Boolean> {
    public static final DescriptorUtilsKt$declaresOrInheritsDefaultValue$2 INSTANCE = new DescriptorUtilsKt$declaresOrInheritsDefaultValue$2();

    DescriptorUtilsKt$declaresOrInheritsDefaultValue$2() {
        super(1);
    }

    public final String getName() {
        return "declaresDefaultValue";
    }

    public final String getSignature() {
        return "declaresDefaultValue()Z";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(ValueParameterDescriptor.class);
    }

    public final Boolean invoke(ValueParameterDescriptor valueParameterDescriptor) {
        Intrinsics.checkNotNullParameter(valueParameterDescriptor, "p0");
        return Boolean.valueOf(valueParameterDescriptor.declaresDefaultValue());
    }
}
