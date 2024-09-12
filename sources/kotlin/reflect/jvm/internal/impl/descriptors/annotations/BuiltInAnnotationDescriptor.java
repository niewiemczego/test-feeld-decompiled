package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.SourceElement;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.constants.ConstantValue;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: BuiltInAnnotationDescriptor.kt */
public final class BuiltInAnnotationDescriptor implements AnnotationDescriptor {
    private final Map<Name, ConstantValue<?>> allValueArguments;
    /* access modifiers changed from: private */
    public final KotlinBuiltIns builtIns;
    private final FqName fqName;
    private final Lazy type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new BuiltInAnnotationDescriptor$type$2(this));

    public BuiltInAnnotationDescriptor(KotlinBuiltIns kotlinBuiltIns, FqName fqName2, Map<Name, ? extends ConstantValue<?>> map) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        Intrinsics.checkNotNullParameter(map, "allValueArguments");
        this.builtIns = kotlinBuiltIns;
        this.fqName = fqName2;
        this.allValueArguments = map;
    }

    public FqName getFqName() {
        return this.fqName;
    }

    public Map<Name, ConstantValue<?>> getAllValueArguments() {
        return this.allValueArguments;
    }

    public KotlinType getType() {
        Object value = this.type$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-type>(...)");
        return (KotlinType) value;
    }

    public SourceElement getSource() {
        SourceElement sourceElement = SourceElement.NO_SOURCE;
        Intrinsics.checkNotNullExpressionValue(sourceElement, "NO_SOURCE");
        return sourceElement;
    }
}
