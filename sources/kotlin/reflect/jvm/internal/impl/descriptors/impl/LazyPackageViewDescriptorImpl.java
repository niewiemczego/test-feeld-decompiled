package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptorVisitor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.LazyScopeAdapter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* compiled from: LazyPackageViewDescriptorImpl.kt */
public class LazyPackageViewDescriptorImpl extends DeclarationDescriptorImpl implements PackageViewDescriptor {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    private final NotNullLazyValue empty$delegate;
    private final FqName fqName;
    private final NotNullLazyValue fragments$delegate;
    private final MemberScope memberScope;
    private final ModuleDescriptorImpl module;

    public ModuleDescriptorImpl getModule() {
        return this.module;
    }

    public FqName getFqName() {
        return this.fqName;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyPackageViewDescriptorImpl(ModuleDescriptorImpl moduleDescriptorImpl, FqName fqName2, StorageManager storageManager) {
        super(Annotations.Companion.getEMPTY(), fqName2.shortNameOrSpecial());
        Intrinsics.checkNotNullParameter(moduleDescriptorImpl, "module");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.module = moduleDescriptorImpl;
        this.fqName = fqName2;
        this.fragments$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$fragments$2(this));
        this.empty$delegate = storageManager.createLazyValue(new LazyPackageViewDescriptorImpl$empty$2(this));
        this.memberScope = new LazyScopeAdapter(storageManager, new LazyPackageViewDescriptorImpl$memberScope$1(this));
    }

    static {
        Class<LazyPackageViewDescriptorImpl> cls = LazyPackageViewDescriptorImpl.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "fragments", "getFragments()Ljava/util/List;")), Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(cls), "empty", "getEmpty()Z"))};
    }

    public List<PackageFragmentDescriptor> getFragments() {
        return (List) StorageKt.getValue(this.fragments$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    /* access modifiers changed from: protected */
    public final boolean getEmpty() {
        return ((Boolean) StorageKt.getValue(this.empty$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[1])).booleanValue();
    }

    public boolean isEmpty() {
        return getEmpty();
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public PackageViewDescriptor getContainingDeclaration() {
        if (getFqName().isRoot()) {
            return null;
        }
        ModuleDescriptorImpl module2 = getModule();
        FqName parent = getFqName().parent();
        Intrinsics.checkNotNullExpressionValue(parent, "fqName.parent()");
        return module2.getPackage(parent);
    }

    public boolean equals(Object obj) {
        PackageViewDescriptor packageViewDescriptor = obj instanceof PackageViewDescriptor ? (PackageViewDescriptor) obj : null;
        if (packageViewDescriptor != null && Intrinsics.areEqual((Object) getFqName(), (Object) packageViewDescriptor.getFqName()) && Intrinsics.areEqual((Object) getModule(), (Object) packageViewDescriptor.getModule())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (getModule().hashCode() * 31) + getFqName().hashCode();
    }

    public <R, D> R accept(DeclarationDescriptorVisitor<R, D> declarationDescriptorVisitor, D d) {
        Intrinsics.checkNotNullParameter(declarationDescriptorVisitor, "visitor");
        return declarationDescriptorVisitor.visitPackageViewDescriptor(this, d);
    }
}
