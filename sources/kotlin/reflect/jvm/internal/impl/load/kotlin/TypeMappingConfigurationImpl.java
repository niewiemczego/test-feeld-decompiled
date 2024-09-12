package kotlin.reflect.jvm.internal.impl.load.kotlin;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.load.kotlin.TypeMappingConfiguration;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;

/* compiled from: methodSignatureMapping.kt */
public final class TypeMappingConfigurationImpl implements TypeMappingConfiguration<JvmType> {
    public static final TypeMappingConfigurationImpl INSTANCE = new TypeMappingConfigurationImpl();

    public String getPredefinedInternalNameForClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    public JvmType getPredefinedTypeForClass(ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        return null;
    }

    public void processErrorType(KotlinType kotlinType, ClassDescriptor classDescriptor) {
        Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
    }

    private TypeMappingConfigurationImpl() {
    }

    public String getPredefinedFullInternalNameForClass(ClassDescriptor classDescriptor) {
        return TypeMappingConfiguration.DefaultImpls.getPredefinedFullInternalNameForClass(this, classDescriptor);
    }

    public KotlinType preprocessType(KotlinType kotlinType) {
        return TypeMappingConfiguration.DefaultImpls.preprocessType(this, kotlinType);
    }

    public KotlinType commonSupertype(Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "types");
        throw new AssertionError("There should be no intersection type in existing descriptors, but found: " + CollectionsKt.joinToString$default(collection, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null));
    }
}
