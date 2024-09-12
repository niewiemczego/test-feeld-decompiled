package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;

/* compiled from: methodSignatureBuildingUtils.kt */
public final class MethodSignatureBuildingUtilsKt {
    public static final String signature(SignatureBuildingComponents signatureBuildingComponents, ClassDescriptor classDescriptor, String str) {
        Intrinsics.checkNotNullParameter(signatureBuildingComponents, "<this>");
        Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
        Intrinsics.checkNotNullParameter(str, "jvmDescriptor");
        return signatureBuildingComponents.signature(MethodSignatureMappingKt.getInternalName(classDescriptor), str);
    }
}
