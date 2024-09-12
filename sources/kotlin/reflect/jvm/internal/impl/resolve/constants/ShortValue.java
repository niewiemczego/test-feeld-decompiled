package kotlin.reflect.jvm.internal.impl.resolve.constants;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;

/* compiled from: constantValues.kt */
public final class ShortValue extends IntegerValueConstant<Short> {
    public ShortValue(short s) {
        super(Short.valueOf(s));
    }

    public SimpleType getType(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "module");
        SimpleType shortType = moduleDescriptor.getBuiltIns().getShortType();
        Intrinsics.checkNotNullExpressionValue(shortType, "module.builtIns.shortType");
        return shortType;
    }

    public String toString() {
        return ((Number) getValue()).intValue() + ".toShort()";
    }
}
