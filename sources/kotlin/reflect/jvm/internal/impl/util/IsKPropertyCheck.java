package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.descriptors.FunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ValueParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;
import kotlin.reflect.jvm.internal.impl.util.Check;

/* compiled from: modifierChecks.kt */
final class IsKPropertyCheck implements Check {
    public static final IsKPropertyCheck INSTANCE = new IsKPropertyCheck();
    private static final String description = "second parameter must be of type KProperty<*> or its supertype";

    private IsKPropertyCheck() {
    }

    public String invoke(FunctionDescriptor functionDescriptor) {
        return Check.DefaultImpls.invoke(this, functionDescriptor);
    }

    public String getDescription() {
        return description;
    }

    public boolean check(FunctionDescriptor functionDescriptor) {
        Intrinsics.checkNotNullParameter(functionDescriptor, "functionDescriptor");
        ValueParameterDescriptor valueParameterDescriptor = functionDescriptor.getValueParameters().get(1);
        ReflectionTypes.Companion companion = ReflectionTypes.Companion;
        Intrinsics.checkNotNullExpressionValue(valueParameterDescriptor, "secondParameter");
        KotlinType createKPropertyStarType = companion.createKPropertyStarType(DescriptorUtilsKt.getModule(valueParameterDescriptor));
        if (createKPropertyStarType == null) {
            return false;
        }
        KotlinType type = valueParameterDescriptor.getType();
        Intrinsics.checkNotNullExpressionValue(type, "secondParameter.type");
        return TypeUtilsKt.isSubtypeOf(createKPropertyStarType, TypeUtilsKt.makeNotNullable(type));
    }
}
