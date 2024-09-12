package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import java.util.Collection;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNullable;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: AbstractDeserializedPackageFragmentProvider.kt */
public abstract class AbstractDeserializedPackageFragmentProvider implements PackageFragmentProviderOptimized {
    protected DeserializationComponents components;
    private final KotlinMetadataFinder finder;
    private final MemoizedFunctionToNullable<FqName, PackageFragmentDescriptor> fragments;
    private final ModuleDescriptor moduleDescriptor;
    private final StorageManager storageManager;

    /* access modifiers changed from: protected */
    public abstract DeserializedPackageFragment findPackage(FqName fqName);

    public AbstractDeserializedPackageFragmentProvider(StorageManager storageManager2, KotlinMetadataFinder kotlinMetadataFinder, ModuleDescriptor moduleDescriptor2) {
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinMetadataFinder, "finder");
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        this.storageManager = storageManager2;
        this.finder = kotlinMetadataFinder;
        this.moduleDescriptor = moduleDescriptor2;
        this.fragments = storageManager2.createMemoizedFunctionWithNullableValues(new AbstractDeserializedPackageFragmentProvider$fragments$1(this));
    }

    /* access modifiers changed from: protected */
    public final StorageManager getStorageManager() {
        return this.storageManager;
    }

    /* access modifiers changed from: protected */
    public final KotlinMetadataFinder getFinder() {
        return this.finder;
    }

    /* access modifiers changed from: protected */
    public final ModuleDescriptor getModuleDescriptor() {
        return this.moduleDescriptor;
    }

    /* access modifiers changed from: protected */
    public final DeserializationComponents getComponents() {
        DeserializationComponents deserializationComponents = this.components;
        if (deserializationComponents != null) {
            return deserializationComponents;
        }
        Intrinsics.throwUninitializedPropertyAccessException("components");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void setComponents(DeserializationComponents deserializationComponents) {
        Intrinsics.checkNotNullParameter(deserializationComponents, "<set-?>");
        this.components = deserializationComponents;
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        CollectionsKt.addIfNotNull(collection, this.fragments.invoke(fqName));
    }

    public boolean isEmpty(FqName fqName) {
        PackageFragmentDescriptor packageFragmentDescriptor;
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (this.fragments.isComputed(fqName)) {
            packageFragmentDescriptor = this.fragments.invoke(fqName);
        } else {
            packageFragmentDescriptor = findPackage(fqName);
        }
        return packageFragmentDescriptor == null;
    }

    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        return kotlin.collections.CollectionsKt.listOfNotNull(this.fragments.invoke(fqName));
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return SetsKt.emptySet();
    }
}
