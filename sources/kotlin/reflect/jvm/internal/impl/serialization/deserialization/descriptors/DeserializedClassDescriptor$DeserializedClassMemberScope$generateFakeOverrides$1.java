package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeserializedDeclarationsFromSupertypeConflictDataKey;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.FunctionDescriptorImpl;
import kotlin.reflect.jvm.internal.impl.resolve.NonReportingOverrideStrategy;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;

/* compiled from: DeserializedClassDescriptor.kt */
public final class DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1 extends NonReportingOverrideStrategy {
    final /* synthetic */ List<D> $result;

    DeserializedClassDescriptor$DeserializedClassMemberScope$generateFakeOverrides$1(List<D> list) {
        this.$result = list;
    }

    public void addFakeOverride(CallableMemberDescriptor callableMemberDescriptor) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fakeOverride");
        OverridingUtil.resolveUnknownVisibilityForMember(callableMemberDescriptor, (Function1<CallableMemberDescriptor, Unit>) null);
        this.$result.add(callableMemberDescriptor);
    }

    /* access modifiers changed from: protected */
    public void conflict(CallableMemberDescriptor callableMemberDescriptor, CallableMemberDescriptor callableMemberDescriptor2) {
        Intrinsics.checkNotNullParameter(callableMemberDescriptor, "fromSuper");
        Intrinsics.checkNotNullParameter(callableMemberDescriptor2, "fromCurrent");
        if (callableMemberDescriptor2 instanceof FunctionDescriptorImpl) {
            ((FunctionDescriptorImpl) callableMemberDescriptor2).putInUserDataMap(DeserializedDeclarationsFromSupertypeConflictDataKey.INSTANCE, callableMemberDescriptor);
        }
    }
}
