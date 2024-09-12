package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: ModuleDescriptorImpl.kt */
final class ModuleDescriptorImpl$packages$1 extends Lambda implements Function1<FqName, PackageViewDescriptor> {
    final /* synthetic */ ModuleDescriptorImpl this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ModuleDescriptorImpl$packages$1(ModuleDescriptorImpl moduleDescriptorImpl) {
        super(1);
        this.this$0 = moduleDescriptorImpl;
    }

    public final PackageViewDescriptor invoke(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        PackageViewDescriptorFactory access$getPackageViewDescriptorFactory$p = this.this$0.packageViewDescriptorFactory;
        ModuleDescriptorImpl moduleDescriptorImpl = this.this$0;
        return access$getPackageViewDescriptorFactory$p.compute(moduleDescriptorImpl, fqName, moduleDescriptorImpl.storageManager);
    }
}
