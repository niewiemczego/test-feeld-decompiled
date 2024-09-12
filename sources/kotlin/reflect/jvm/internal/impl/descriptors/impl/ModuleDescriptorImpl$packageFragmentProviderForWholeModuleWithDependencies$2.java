package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;

/* compiled from: ModuleDescriptorImpl.kt */
final class ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2 extends Lambda implements Function0<CompositePackageFragmentProvider> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(0);
        this.this$0 = moduleDescriptorImpl;
    }

    public final CompositePackageFragmentProvider invoke() {
        ModuleDependencies access$getDependencies$p = this.this$0.dependencies;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        if (access$getDependencies$p != null) {
            List<ModuleDescriptorImpl> allDependencies = access$getDependencies$p.getAllDependencies();
            this.this$0.assertValid();
            allDependencies.contains(this.this$0);
            Iterable<ModuleDescriptorImpl> iterable = allDependencies;
            for (ModuleDescriptorImpl access$isInitialized : iterable) {
                boolean unused = access$isInitialized.isInitialized();
            }
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (ModuleDescriptorImpl access$getPackageFragmentProviderForModuleContent$p : iterable) {
                PackageFragmentProvider access$getPackageFragmentProviderForModuleContent$p2 = access$getPackageFragmentProviderForModuleContent$p.packageFragmentProviderForModuleContent;
                Intrinsics.checkNotNull(access$getPackageFragmentProviderForModuleContent$p2);
                arrayList.add(access$getPackageFragmentProviderForModuleContent$p2);
            }
            return new CompositePackageFragmentProvider((List) arrayList, "CompositeProvider@ModuleDescriptor for " + this.this$0.getName());
        }
        throw new AssertionError("Dependencies of module " + moduleDescriptorImpl.getId() + " were not set before querying module content");
    }
}
