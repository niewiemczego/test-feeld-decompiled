package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* compiled from: Comparisons.kt */
public final class CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1<T> implements Comparator {
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) t).asString(), DescriptorUtilsKt.getFqNameSafe((ClassDescriptor) t2).asString());
    }
}
