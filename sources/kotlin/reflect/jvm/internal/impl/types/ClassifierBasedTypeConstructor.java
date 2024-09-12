package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PackageFragmentDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.DescriptorUtils;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: ClassifierBasedTypeConstructor.kt */
public abstract class ClassifierBasedTypeConstructor implements TypeConstructor {
    private int hashCode;

    public abstract ClassifierDescriptor getDeclarationDescriptor();

    /* access modifiers changed from: protected */
    public abstract boolean isSameClassifier(ClassifierDescriptor classifierDescriptor);

    public int hashCode() {
        int i;
        int i2 = this.hashCode;
        if (i2 != 0) {
            return i2;
        }
        ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
        if (hasMeaningfulFqName(declarationDescriptor)) {
            i = DescriptorUtils.getFqName(declarationDescriptor).hashCode();
        } else {
            i = System.identityHashCode(this);
        }
        this.hashCode = i;
        return i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TypeConstructor) || obj.hashCode() != hashCode()) {
            return false;
        }
        TypeConstructor typeConstructor = (TypeConstructor) obj;
        if (typeConstructor.getParameters().size() != getParameters().size()) {
            return false;
        }
        ClassifierDescriptor declarationDescriptor = getDeclarationDescriptor();
        ClassifierDescriptor declarationDescriptor2 = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor2 != null && hasMeaningfulFqName(declarationDescriptor) && hasMeaningfulFqName(declarationDescriptor2)) {
            return isSameClassifier(declarationDescriptor2);
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean areFqNamesEqual(ClassifierDescriptor classifierDescriptor, ClassifierDescriptor classifierDescriptor2) {
        Intrinsics.checkNotNullParameter(classifierDescriptor, "first");
        Intrinsics.checkNotNullParameter(classifierDescriptor2, "second");
        if (!Intrinsics.areEqual((Object) classifierDescriptor.getName(), (Object) classifierDescriptor2.getName())) {
            return false;
        }
        DeclarationDescriptor containingDeclaration = classifierDescriptor.getContainingDeclaration();
        DeclarationDescriptor containingDeclaration2 = classifierDescriptor2.getContainingDeclaration();
        while (containingDeclaration != null && containingDeclaration2 != null) {
            if (containingDeclaration instanceof ModuleDescriptor) {
                return containingDeclaration2 instanceof ModuleDescriptor;
            }
            if (containingDeclaration2 instanceof ModuleDescriptor) {
                return false;
            }
            if (containingDeclaration instanceof PackageFragmentDescriptor) {
                if (!(containingDeclaration2 instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual((Object) ((PackageFragmentDescriptor) containingDeclaration).getFqName(), (Object) ((PackageFragmentDescriptor) containingDeclaration2).getFqName())) {
                    return false;
                }
                return true;
            } else if ((containingDeclaration2 instanceof PackageFragmentDescriptor) || !Intrinsics.areEqual((Object) containingDeclaration.getName(), (Object) containingDeclaration2.getName())) {
                return false;
            } else {
                containingDeclaration = containingDeclaration.getContainingDeclaration();
                containingDeclaration2 = containingDeclaration2.getContainingDeclaration();
            }
        }
        return true;
    }

    private final boolean hasMeaningfulFqName(ClassifierDescriptor classifierDescriptor) {
        DeclarationDescriptor declarationDescriptor = classifierDescriptor;
        return !ErrorUtils.isError(declarationDescriptor) && !DescriptorUtils.isLocal(declarationDescriptor);
    }
}
