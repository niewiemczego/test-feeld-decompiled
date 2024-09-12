package kotlin.reflect.jvm.internal.impl.resolve;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Modality;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.ResolutionScope;

/* compiled from: SealedClassInheritorsProvider.kt */
public final class CliSealedClassInheritorsProvider extends SealedClassInheritorsProvider {
    public static final CliSealedClassInheritorsProvider INSTANCE = new CliSealedClassInheritorsProvider();

    private CliSealedClassInheritorsProvider() {
    }

    public Collection<ClassDescriptor> computeSealedSubclasses(ClassDescriptor classDescriptor, boolean z) {
        DeclarationDescriptor declarationDescriptor;
        DeclarationDescriptor declarationDescriptor2;
        Intrinsics.checkNotNullParameter(classDescriptor, "sealedClass");
        if (classDescriptor.getModality() != Modality.SEALED) {
            return CollectionsKt.emptyList();
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        if (!z) {
            declarationDescriptor = classDescriptor.getContainingDeclaration();
        } else {
            Iterator<DeclarationDescriptor> it = DescriptorUtilsKt.getParents(classDescriptor).iterator();
            while (true) {
                if (!it.hasNext()) {
                    declarationDescriptor2 = null;
                    break;
                }
                declarationDescriptor2 = it.next();
                if (declarationDescriptor2 instanceof PackageFragmentDescriptor) {
                    break;
                }
            }
            declarationDescriptor = declarationDescriptor2;
        }
        if (declarationDescriptor instanceof PackageFragmentDescriptor) {
            computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, ((PackageFragmentDescriptor) declarationDescriptor).getMemberScope(), z);
        }
        MemberScope unsubstitutedInnerClassesScope = classDescriptor.getUnsubstitutedInnerClassesScope();
        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "sealedClass.unsubstitutedInnerClassesScope");
        computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, true);
        return CollectionsKt.sortedWith(linkedHashSet, new CliSealedClassInheritorsProvider$computeSealedSubclasses$$inlined$sortedBy$1());
    }

    private static final void computeSealedSubclasses$collectSubclasses(ClassDescriptor classDescriptor, LinkedHashSet<ClassDescriptor> linkedHashSet, MemberScope memberScope, boolean z) {
        for (DeclarationDescriptor declarationDescriptor : ResolutionScope.DefaultImpls.getContributedDescriptors$default(memberScope, DescriptorKindFilter.CLASSIFIERS, (Function1) null, 2, (Object) null)) {
            if (declarationDescriptor instanceof ClassDescriptor) {
                ClassDescriptor classDescriptor2 = (ClassDescriptor) declarationDescriptor;
                if (classDescriptor2.isExpect()) {
                    Name name = classDescriptor2.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "descriptor.name");
                    ClassifierDescriptor contributedClassifier = memberScope.getContributedClassifier(name, NoLookupLocation.WHEN_GET_ALL_DESCRIPTORS);
                    if (contributedClassifier instanceof ClassDescriptor) {
                        classDescriptor2 = (ClassDescriptor) contributedClassifier;
                    } else {
                        classDescriptor2 = contributedClassifier instanceof TypeAliasDescriptor ? ((TypeAliasDescriptor) contributedClassifier).getClassDescriptor() : null;
                    }
                }
                if (classDescriptor2 != null) {
                    if (DescriptorUtils.isDirectSubclass(classDescriptor2, classDescriptor)) {
                        linkedHashSet.add(classDescriptor2);
                    }
                    if (z) {
                        MemberScope unsubstitutedInnerClassesScope = classDescriptor2.getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(unsubstitutedInnerClassesScope, "refinedDescriptor.unsubstitutedInnerClassesScope");
                        computeSealedSubclasses$collectSubclasses(classDescriptor, linkedHashSet, unsubstitutedInnerClassesScope, z);
                    }
                }
            }
        }
    }
}
