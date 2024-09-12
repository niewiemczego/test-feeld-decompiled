package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: PackageViewDescriptorFactory.kt */
public interface PackageViewDescriptorFactory {
    public static final Companion Companion = Companion.$$INSTANCE;

    PackageViewDescriptor compute(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager);

    /* compiled from: PackageViewDescriptorFactory.kt */
    public static final class Default implements PackageViewDescriptorFactory {
        public static final Default INSTANCE = new Default();

        private Default() {
        }

        public PackageViewDescriptor compute(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName, StorageManager storageManager) {
            Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
            Intrinsics.checkNotNullParameter(fqName, "fqName");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            return new LazyPackageViewDescriptorImpl(moduleDescriptorImpl, fqName, storageManager);
        }
    }

    /* compiled from: PackageViewDescriptorFactory.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final ModuleCapability<PackageViewDescriptorFactory> CAPABILITY = new ModuleCapability<>("PackageViewDescriptorFactory");

        private Companion() {
        }

        public final ModuleCapability<PackageViewDescriptorFactory> getCAPABILITY() {
            return CAPABILITY;
        }
    }
}
