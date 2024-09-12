package kotlin.reflect.jvm.internal.impl.descriptors.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProvider;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderKt;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentProviderOptimized;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: CompositePackageFragmentProvider.kt */
public final class CompositePackageFragmentProvider implements PackageFragmentProviderOptimized {
    private final String debugName;
    private final List<PackageFragmentProvider> providers;

    public CompositePackageFragmentProvider(List<? extends PackageFragmentProvider> list, String str) {
        Intrinsics.checkNotNullParameter(list, "providers");
        Intrinsics.checkNotNullParameter(str, "debugName");
        this.providers = list;
        this.debugName = str;
        list.size();
        CollectionsKt.toSet(list).size();
    }

    @Deprecated(message = "for usages use #packageFragments(FqName) at final point, for impl use #collectPackageFragments(FqName, MutableCollection<PackageFragmentDescriptor>)")
    public List<PackageFragmentDescriptor> getPackageFragments(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        ArrayList arrayList = new ArrayList();
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, arrayList);
        }
        return CollectionsKt.toList(arrayList);
    }

    public void collectPackageFragments(FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        for (PackageFragmentProvider collectPackageFragmentsOptimizedIfPossible : this.providers) {
            PackageFragmentProviderKt.collectPackageFragmentsOptimizedIfPossible(collectPackageFragmentsOptimizedIfPossible, fqName, collection);
        }
    }

    public boolean isEmpty(FqName fqName) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Iterable<PackageFragmentProvider> iterable = this.providers;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return true;
        }
        for (PackageFragmentProvider isEmpty : iterable) {
            if (!PackageFragmentProviderKt.isEmpty(isEmpty, fqName)) {
                return false;
            }
        }
        return true;
    }

    public Collection<FqName> getSubPackagesOf(FqName fqName, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        HashSet hashSet = new HashSet();
        for (PackageFragmentProvider subPackagesOf : this.providers) {
            hashSet.addAll(subPackagesOf.getSubPackagesOf(fqName, function1));
        }
        return hashSet;
    }

    public String toString() {
        return this.debugName;
    }
}
