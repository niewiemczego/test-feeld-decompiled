package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ArrayValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: DeserializedArrayValue.kt */
public final class DeserializedArrayValue extends ArrayValue {
    private final KotlinType type;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeserializedArrayValue(List<? extends ConstantValue<?>> list, final KotlinType kotlinType) {
        super(list, new Function1<ModuleDescriptor, KotlinType>() {
            public final KotlinType invoke(ModuleDescriptor moduleDescriptor) {
                Intrinsics.checkNotNullParameter(moduleDescriptor, "it");
                return kotlinType;
            }
        });
        Intrinsics.checkNotNullParameter(list, "value");
        Intrinsics.checkNotNullParameter(kotlinType, "type");
        this.type = kotlinType;
    }

    public final KotlinType getType() {
        return this.type;
    }
}
