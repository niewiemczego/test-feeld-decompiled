package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibilities;
import kotlin.reflect.jvm.internal.impl.descriptors.DescriptorVisibility;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: ProtoEnumFlagsUtils.kt */
public final class ProtoEnumFlagsUtilsKt {

    /* compiled from: ProtoEnumFlagsUtils.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        static {
            int[] iArr = new int[ProtoBuf.MemberKind.values().length];
            iArr[ProtoBuf.MemberKind.DECLARATION.ordinal()] = 1;
            iArr[ProtoBuf.MemberKind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr[ProtoBuf.MemberKind.DELEGATION.ordinal()] = 3;
            iArr[ProtoBuf.MemberKind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[CallableMemberDescriptor.Kind.values().length];
            iArr2[CallableMemberDescriptor.Kind.DECLARATION.ordinal()] = 1;
            iArr2[CallableMemberDescriptor.Kind.FAKE_OVERRIDE.ordinal()] = 2;
            iArr2[CallableMemberDescriptor.Kind.DELEGATION.ordinal()] = 3;
            iArr2[CallableMemberDescriptor.Kind.SYNTHESIZED.ordinal()] = 4;
            $EnumSwitchMapping$1 = iArr2;
            int[] iArr3 = new int[ProtoBuf.Visibility.values().length];
            iArr3[ProtoBuf.Visibility.INTERNAL.ordinal()] = 1;
            iArr3[ProtoBuf.Visibility.PRIVATE.ordinal()] = 2;
            iArr3[ProtoBuf.Visibility.PRIVATE_TO_THIS.ordinal()] = 3;
            iArr3[ProtoBuf.Visibility.PROTECTED.ordinal()] = 4;
            iArr3[ProtoBuf.Visibility.PUBLIC.ordinal()] = 5;
            iArr3[ProtoBuf.Visibility.LOCAL.ordinal()] = 6;
            $EnumSwitchMapping$2 = iArr3;
        }
    }

    public static final CallableMemberDescriptor.Kind memberKind(ProtoEnumFlags protoEnumFlags, ProtoBuf.MemberKind memberKind) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        int i = memberKind == null ? -1 : WhenMappings.$EnumSwitchMapping$0[memberKind.ordinal()];
        if (i == 1) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        if (i == 2) {
            return CallableMemberDescriptor.Kind.FAKE_OVERRIDE;
        }
        if (i == 3) {
            return CallableMemberDescriptor.Kind.DELEGATION;
        }
        if (i != 4) {
            return CallableMemberDescriptor.Kind.DECLARATION;
        }
        return CallableMemberDescriptor.Kind.SYNTHESIZED;
    }

    public static final DescriptorVisibility descriptorVisibility(ProtoEnumFlags protoEnumFlags, ProtoBuf.Visibility visibility) {
        Intrinsics.checkNotNullParameter(protoEnumFlags, "<this>");
        switch (visibility == null ? -1 : WhenMappings.$EnumSwitchMapping$2[visibility.ordinal()]) {
            case 1:
                DescriptorVisibility descriptorVisibility = DescriptorVisibilities.INTERNAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility, "INTERNAL");
                return descriptorVisibility;
            case 2:
                DescriptorVisibility descriptorVisibility2 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility2, "PRIVATE");
                return descriptorVisibility2;
            case 3:
                DescriptorVisibility descriptorVisibility3 = DescriptorVisibilities.PRIVATE_TO_THIS;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility3, "PRIVATE_TO_THIS");
                return descriptorVisibility3;
            case 4:
                DescriptorVisibility descriptorVisibility4 = DescriptorVisibilities.PROTECTED;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility4, "PROTECTED");
                return descriptorVisibility4;
            case 5:
                DescriptorVisibility descriptorVisibility5 = DescriptorVisibilities.PUBLIC;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility5, "PUBLIC");
                return descriptorVisibility5;
            case 6:
                DescriptorVisibility descriptorVisibility6 = DescriptorVisibilities.LOCAL;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility6, "LOCAL");
                return descriptorVisibility6;
            default:
                DescriptorVisibility descriptorVisibility7 = DescriptorVisibilities.PRIVATE;
                Intrinsics.checkNotNullExpressionValue(descriptorVisibility7, "PRIVATE");
                return descriptorVisibility7;
        }
    }
}
