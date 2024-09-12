package kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil;

import java.util.Collection;
import kotlin.collections.CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.utils.DFS;

/* compiled from: DescriptorUtils.kt */
final class DescriptorUtilsKt$firstOverridden$1<N> implements DFS.Neighbors {
    final /* synthetic */ boolean $useOriginal;

    DescriptorUtilsKt$firstOverridden$1(boolean z) {
        this.$useOriginal = z;
    }

    public final Iterable<CallableMemberDescriptor> getNeighbors(CallableMemberDescriptor callableMemberDescriptor) {
        Collection<? extends CallableMemberDescriptor> collection = null;
        if (this.$useOriginal) {
            callableMemberDescriptor = callableMemberDescriptor != null ? callableMemberDescriptor.getOriginal() : null;
        }
        if (callableMemberDescriptor != null) {
            collection = callableMemberDescriptor.getOverriddenDescriptors();
        }
        return collection == null ? CollectionsKt.emptyList() : collection;
    }
}
