package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageViewDescriptor;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindExclude;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScopeImpl;

/* compiled from: SubpackagesScope.kt */
public class SubpackagesScope extends MemberScopeImpl {
    private final FqName fqName;
    private final ModuleDescriptor moduleDescriptor;

    public SubpackagesScope(ModuleDescriptor moduleDescriptor2, FqName fqName2) {
        Intrinsics.checkNotNullParameter(moduleDescriptor2, "moduleDescriptor");
        Intrinsics.checkNotNullParameter(fqName2, "fqName");
        this.moduleDescriptor = moduleDescriptor2;
        this.fqName = fqName2;
    }

    /* access modifiers changed from: protected */
    public final PackageViewDescriptor getPackage(Name name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (name.isSpecial()) {
            return null;
        }
        ModuleDescriptor moduleDescriptor2 = this.moduleDescriptor;
        FqName child = this.fqName.child(name);
        Intrinsics.checkNotNullExpressionValue(child, "fqName.child(name)");
        PackageViewDescriptor packageViewDescriptor = moduleDescriptor2.getPackage(child);
        if (packageViewDescriptor.isEmpty()) {
            return null;
        }
        return packageViewDescriptor;
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        if (!descriptorKindFilter.acceptsKinds(DescriptorKindFilter.Companion.getPACKAGES_MASK())) {
            return CollectionsKt.emptyList();
        }
        if (this.fqName.isRoot() && descriptorKindFilter.getExcludes().contains(DescriptorKindExclude.TopLevelPackages.INSTANCE)) {
            return CollectionsKt.emptyList();
        }
        Collection<FqName> subPackagesOf = this.moduleDescriptor.getSubPackagesOf(this.fqName, function1);
        ArrayList arrayList = new ArrayList(subPackagesOf.size());
        for (FqName shortName : subPackagesOf) {
            Name shortName2 = shortName.shortName();
            Intrinsics.checkNotNullExpressionValue(shortName2, "subFqName.shortName()");
            if (function1.invoke(shortName2).booleanValue()) {
                kotlin.reflect.jvm.internal.impl.utils.CollectionsKt.addIfNotNull(arrayList, getPackage(shortName2));
            }
        }
        return arrayList;
    }

    public Set<Name> getClassifierNames() {
        return SetsKt.emptySet();
    }

    public String toString() {
        return "subpackages of " + this.fqName + " from " + this.moduleDescriptor;
    }
}
