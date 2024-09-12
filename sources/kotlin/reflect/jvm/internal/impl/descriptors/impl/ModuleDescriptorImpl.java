package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import com.facebook.internal.NativeProtocol;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.InvalidModuleExceptionKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleCapability;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.PackageViewDescriptorFactory;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.platform.TargetPlatform;
import kotlin.reflect.jvm.internal.impl.storage.MemoizedFunctionToNotNull;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: ModuleDescriptorImpl.kt */
public final class ModuleDescriptorImpl extends DeclarationDescriptorImpl implements ModuleDescriptor {
    private final KotlinBuiltIns builtIns;
    private final Map<ModuleCapability<?>, Object> capabilities;
    /* access modifiers changed from: private */
    public ModuleDependencies dependencies;
    private boolean isValid;
    /* access modifiers changed from: private */
    public PackageFragmentProvider packageFragmentProviderForModuleContent;
    private final Lazy packageFragmentProviderForWholeModuleWithDependencies$delegate;
    /* access modifiers changed from: private */
    public final PackageViewDescriptorFactory packageViewDescriptorFactory;
    private final MemoizedFunctionToNotNull<FqName, PackageViewDescriptor> packages;
    private final TargetPlatform platform;
    private final Name stableName;
    /* access modifiers changed from: private */
    public final StorageManager storageManager;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name name, StorageManager storageManager2, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform) {
        this(name, storageManager2, kotlinBuiltIns, targetPlatform, (Map) null, (Name) null, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        return ModuleDescriptor.DefaultImpls.accept(this, declarationDescriptorVisitor, d);
    }

    public DeclarationDescriptor getContainingDeclaration() {
        return ModuleDescriptor.DefaultImpls.getContainingDeclaration(this);
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.builtIns;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ModuleDescriptorImpl(kotlin.reflect.jvm.internal.impl.name.Name r10, kotlin.reflect.jvm.internal.impl.storage.StorageManager r11, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r12, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform r13, java.util.Map r14, kotlin.reflect.jvm.internal.impl.name.Name r15, int r16, kotlin.jvm.internal.DefaultConstructorMarker r17) {
        /*
            r9 = this;
            r0 = r16 & 8
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r6 = r1
            goto L_0x0008
        L_0x0007:
            r6 = r13
        L_0x0008:
            r0 = r16 & 16
            if (r0 == 0) goto L_0x0012
            java.util.Map r0 = kotlin.collections.MapsKt.emptyMap()
            r7 = r0
            goto L_0x0013
        L_0x0012:
            r7 = r14
        L_0x0013:
            r0 = r16 & 32
            if (r0 == 0) goto L_0x0019
            r8 = r1
            goto L_0x001a
        L_0x0019:
            r8 = r15
        L_0x001a:
            r2 = r9
            r3 = r10
            r4 = r11
            r5 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleDescriptorImpl.<init>(kotlin.reflect.jvm.internal.impl.name.Name, kotlin.reflect.jvm.internal.impl.storage.StorageManager, kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.platform.TargetPlatform, java.util.Map, kotlin.reflect.jvm.internal.impl.name.Name, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ModuleDescriptorImpl(Name name, StorageManager storageManager2, KotlinBuiltIns kotlinBuiltIns, TargetPlatform targetPlatform, Map<ModuleCapability<?>, ? extends Object> map, Name name2) {
        super(Annotations.Companion.getEMPTY(), name);
        Intrinsics.checkNotNullParameter(name, "moduleName");
        Intrinsics.checkNotNullParameter(storageManager2, "storageManager");
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "builtIns");
        Intrinsics.checkNotNullParameter(map, "capabilities");
        this.storageManager = storageManager2;
        this.builtIns = kotlinBuiltIns;
        this.platform = targetPlatform;
        this.stableName = name2;
        if (name.isSpecial()) {
            this.capabilities = map;
            PackageViewDescriptorFactory packageViewDescriptorFactory2 = (PackageViewDescriptorFactory) getCapability(PackageViewDescriptorFactory.Companion.getCAPABILITY());
            this.packageViewDescriptorFactory = packageViewDescriptorFactory2 == null ? PackageViewDescriptorFactory.Default.INSTANCE : packageViewDescriptorFactory2;
            this.isValid = true;
            this.packages = storageManager2.createMemoizedFunction(new ModuleDescriptorImpl$packages$1(this));
            this.packageFragmentProviderForWholeModuleWithDependencies$delegate = LazyKt.lazy(new ModuleDescriptorImpl$packageFragmentProviderForWholeModuleWithDependencies$2(this));
            return;
        }
        throw new IllegalArgumentException("Module name must be special: " + name);
    }

    public boolean isValid() {
        return this.isValid;
    }

    public void assertValid() {
        if (!isValid()) {
            InvalidModuleExceptionKt.moduleInvalidated(this);
        }
    }

    public List<ModuleDescriptor> getExpectedByModules() {
        ModuleDependencies moduleDependencies = this.dependencies;
        if (moduleDependencies != null) {
            return moduleDependencies.getDirectExpectedByDependencies();
        }
        throw new AssertionError("Dependencies of module " + getId() + " were not set");
    }

    public PackageViewDescriptor getPackage(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        assertValid();
        return this.packages.invoke(fqName);
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        assertValid();
        return getPackageFragmentProvider().getSubPackagesOf(fqName, function1);
    }

    private final CompositePackageFragmentProvider getPackageFragmentProviderForWholeModuleWithDependencies() {
        return (CompositePackageFragmentProvider) this.packageFragmentProviderForWholeModuleWithDependencies$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final boolean isInitialized() {
        return this.packageFragmentProviderForModuleContent != null;
    }

    public final void setDependencies(ModuleDependencies moduleDependencies) {
        Intrinsics.checkNotNullParameter(moduleDependencies, "dependencies");
        this.dependencies = moduleDependencies;
    }

    public final void setDependencies(ModuleDescriptorImpl... moduleDescriptorImplArr) {
        Intrinsics.checkNotNullParameter(moduleDescriptorImplArr, "descriptors");
        setDependencies((List<ModuleDescriptorImpl>) ArraysKt.toList((T[]) moduleDescriptorImplArr));
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        setDependencies(list, SetsKt.emptySet());
    }

    public final void setDependencies(List<ModuleDescriptorImpl> list, Set<ModuleDescriptorImpl> set) {
        Intrinsics.checkNotNullParameter(list, "descriptors");
        Intrinsics.checkNotNullParameter(set, NativeProtocol.AUDIENCE_FRIENDS);
        setDependencies((ModuleDependencies) new ModuleDependenciesImpl(list, set, CollectionsKt.emptyList(), SetsKt.emptySet()));
    }

    public boolean shouldSeeInternalsOf(ModuleDescriptor moduleDescriptor) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "targetModule");
        if (Intrinsics.areEqual((Object) this, (Object) moduleDescriptor)) {
            return true;
        }
        ModuleDependencies moduleDependencies = this.dependencies;
        Intrinsics.checkNotNull(moduleDependencies);
        if (!CollectionsKt.contains(moduleDependencies.getModulesWhoseInternalsAreVisible(), moduleDescriptor) && !getExpectedByModules().contains(moduleDescriptor) && !moduleDescriptor.getExpectedByModules().contains(this)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final String getId() {
        String name = getName().toString();
        Intrinsics.checkNotNullExpressionValue(name, "name.toString()");
        return name;
    }

    public final void initialize(PackageFragmentProvider packageFragmentProvider) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "providerForModuleContent");
        isInitialized();
        this.packageFragmentProviderForModuleContent = packageFragmentProvider;
    }

    public final PackageFragmentProvider getPackageFragmentProvider() {
        assertValid();
        return getPackageFragmentProviderForWholeModuleWithDependencies();
    }

    public <T> T getCapability(ModuleCapability<T> moduleCapability) {
        Intrinsics.checkNotNullParameter(moduleCapability, "capability");
        T t = this.capabilities.get(moduleCapability);
        if (t == null) {
            return null;
        }
        return t;
    }
}
