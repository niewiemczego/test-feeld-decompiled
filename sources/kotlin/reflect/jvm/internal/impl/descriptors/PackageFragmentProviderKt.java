package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.FqName;

/* compiled from: PackageFragmentProvider.kt */
public final class PackageFragmentProviderKt {
    public static final List<PackageFragmentDescriptor> packageFragments(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        List<PackageFragmentDescriptor> arrayList = new ArrayList<>();
        collectPackageFragmentsOptimizedIfPossible(packageFragmentProvider, fqName, arrayList);
        return arrayList;
    }

    public static final boolean isEmpty(PackageFragmentProvider packageFragmentProvider, FqName fqName) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            return ((PackageFragmentProviderOptimized) packageFragmentProvider).isEmpty(fqName);
        }
        return packageFragments(packageFragmentProvider, fqName).isEmpty();
    }

    public static final void collectPackageFragmentsOptimizedIfPossible(PackageFragmentProvider packageFragmentProvider, FqName fqName, Collection<PackageFragmentDescriptor> collection) {
        Intrinsics.checkNotNullParameter(packageFragmentProvider, "<this>");
        Intrinsics.checkNotNullParameter(fqName, "fqName");
        Intrinsics.checkNotNullParameter(collection, "packageFragments");
        if (packageFragmentProvider instanceof PackageFragmentProviderOptimized) {
            ((PackageFragmentProviderOptimized) packageFragmentProvider).collectPackageFragments(fqName, collection);
        } else {
            collection.addAll(packageFragmentProvider.getPackageFragments(fqName));
        }
    }
}
