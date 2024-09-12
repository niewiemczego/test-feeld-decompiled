package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ChainedMemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
final class LazyPackageViewDescriptorImpl$memberScope$1 extends Lambda implements Function0<MemberScope> {
    final /* synthetic */ LazyPackageViewDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    LazyPackageViewDescriptorImpl$memberScope$1(LazyPackageViewDescriptorImpl lazyPackageViewDescriptorImpl) {
        super(0);
        this.this$0 = lazyPackageViewDescriptorImpl;
    }

    public final MemberScope invoke() {
        if (this.this$0.isEmpty()) {
            return MemberScope.Empty.INSTANCE;
        }
        Iterable<PackageFragmentDescriptor> fragments = this.this$0.getFragments();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(fragments, 10));
        for (PackageFragmentDescriptor memberScope : fragments) {
            arrayList.add(memberScope.getMemberScope());
        }
        return ChainedMemberScope.Companion.create("package view scope for " + this.this$0.getFqName() + " in " + this.this$0.getModule().getName(), CollectionsKt.plus((List) arrayList, new SubpackagesScope(this.this$0.getModule(), this.this$0.getFqName())));
    }
}
