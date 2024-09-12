package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.reflect.jvm.internal.impl.descriptors.CallableDescriptor;

/* compiled from: DescriptorBasedDeprecationInfo.kt */
public final class DescriptorBasedDeprecationInfoKt {
    private static final CallableDescriptor.UserDataKey<DescriptorBasedDeprecationInfo> DEPRECATED_FUNCTION_KEY = new DescriptorBasedDeprecationInfoKt$DEPRECATED_FUNCTION_KEY$1();

    public static final CallableDescriptor.UserDataKey<DescriptorBasedDeprecationInfo> getDEPRECATED_FUNCTION_KEY() {
        return DEPRECATED_FUNCTION_KEY;
    }
}
