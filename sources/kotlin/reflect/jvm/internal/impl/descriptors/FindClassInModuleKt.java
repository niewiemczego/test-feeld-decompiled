package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.incremental.components.NoLookupLocation;
import kotlin.reflect.jvm.internal.impl.name.ClassId;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.ResolutionAnchorProviderKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.sequences.SequencesKt;

/* compiled from: findClassInModule.kt */
public final class FindClassInModuleKt {
    public static final ClassDescriptor findClassAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof ClassDescriptor) {
            return (ClassDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final ClassDescriptor findNonGenericClassAcrossDependencies(ModuleDescriptor moduleDescriptor, ClassId classId, NotFoundClasses notFoundClasses) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(notFoundClasses, "notFoundClasses");
        ClassDescriptor findClassAcrossModuleDependencies = findClassAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassAcrossModuleDependencies != null) {
            return findClassAcrossModuleDependencies;
        }
        return notFoundClasses.getClass(classId, SequencesKt.toList(SequencesKt.map(SequencesKt.generateSequence(classId, FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$1.INSTANCE), FindClassInModuleKt$findNonGenericClassAcrossDependencies$typeParametersCount$2.INSTANCE)));
    }

    public static final TypeAliasDescriptor findTypeAliasAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ClassifierDescriptor findClassifierAcrossModuleDependencies = findClassifierAcrossModuleDependencies(moduleDescriptor, classId);
        if (findClassifierAcrossModuleDependencies instanceof TypeAliasDescriptor) {
            return (TypeAliasDescriptor) findClassifierAcrossModuleDependencies;
        }
        return null;
    }

    public static final ClassifierDescriptor findClassifierAcrossModuleDependencies(ModuleDescriptor moduleDescriptor, ClassId classId) {
        ClassifierDescriptor classifierDescriptor;
        Intrinsics.checkNotNullParameter(moduleDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(classId, "classId");
        ModuleDescriptor resolutionAnchorIfAny = ResolutionAnchorProviderKt.getResolutionAnchorIfAny(moduleDescriptor);
        if (resolutionAnchorIfAny == null) {
            FqName packageFqName = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor = moduleDescriptor.getPackage(packageFqName);
            List<Name> pathSegments = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope = packageViewDescriptor.getMemberScope();
            Object first = CollectionsKt.first(pathSegments);
            Intrinsics.checkNotNullExpressionValue(first, "segments.first()");
            classifierDescriptor = memberScope.getContributedClassifier((Name) first, NoLookupLocation.FROM_DESERIALIZATION);
            if (classifierDescriptor == null) {
                return null;
            }
            for (Name next : pathSegments.subList(1, pathSegments.size())) {
                if (!(classifierDescriptor instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope = ((ClassDescriptor) classifierDescriptor).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(next, "name");
                ClassifierDescriptor contributedClassifier = unsubstitutedInnerClassesScope.getContributedClassifier(next, NoLookupLocation.FROM_DESERIALIZATION);
                ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
                if (classDescriptor == null) {
                    return null;
                }
                classifierDescriptor = classDescriptor;
            }
        } else {
            FqName packageFqName2 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName2, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor2 = resolutionAnchorIfAny.getPackage(packageFqName2);
            List<Name> pathSegments2 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments2, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope2 = packageViewDescriptor2.getMemberScope();
            Object first2 = CollectionsKt.first(pathSegments2);
            Intrinsics.checkNotNullExpressionValue(first2, "segments.first()");
            ClassifierDescriptor contributedClassifier2 = memberScope2.getContributedClassifier((Name) first2, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier2 != null) {
                Iterator<Name> it = pathSegments2.subList(1, pathSegments2.size()).iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Name next2 = it.next();
                    if (contributedClassifier2 instanceof ClassDescriptor) {
                        MemberScope unsubstitutedInnerClassesScope2 = ((ClassDescriptor) contributedClassifier2).getUnsubstitutedInnerClassesScope();
                        Intrinsics.checkNotNullExpressionValue(next2, "name");
                        ClassifierDescriptor contributedClassifier3 = unsubstitutedInnerClassesScope2.getContributedClassifier(next2, NoLookupLocation.FROM_DESERIALIZATION);
                        ClassDescriptor classDescriptor2 = contributedClassifier3 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier3 : null;
                        if (classDescriptor2 == null) {
                            break;
                        }
                        contributedClassifier2 = classDescriptor2;
                    } else {
                        break;
                    }
                }
            }
            contributedClassifier2 = null;
            if (contributedClassifier2 != null) {
                return contributedClassifier2;
            }
            FqName packageFqName3 = classId.getPackageFqName();
            Intrinsics.checkNotNullExpressionValue(packageFqName3, "classId.packageFqName");
            PackageViewDescriptor packageViewDescriptor3 = moduleDescriptor.getPackage(packageFqName3);
            List<Name> pathSegments3 = classId.getRelativeClassName().pathSegments();
            Intrinsics.checkNotNullExpressionValue(pathSegments3, "classId.relativeClassName.pathSegments()");
            MemberScope memberScope3 = packageViewDescriptor3.getMemberScope();
            Object first3 = CollectionsKt.first(pathSegments3);
            Intrinsics.checkNotNullExpressionValue(first3, "segments.first()");
            ClassifierDescriptor contributedClassifier4 = memberScope3.getContributedClassifier((Name) first3, NoLookupLocation.FROM_DESERIALIZATION);
            if (contributedClassifier4 == null) {
                return null;
            }
            for (Name next3 : pathSegments3.subList(1, pathSegments3.size())) {
                if (!(classifierDescriptor instanceof ClassDescriptor)) {
                    return null;
                }
                MemberScope unsubstitutedInnerClassesScope3 = ((ClassDescriptor) classifierDescriptor).getUnsubstitutedInnerClassesScope();
                Intrinsics.checkNotNullExpressionValue(next3, "name");
                ClassifierDescriptor contributedClassifier5 = unsubstitutedInnerClassesScope3.getContributedClassifier(next3, NoLookupLocation.FROM_DESERIALIZATION);
                ClassDescriptor classDescriptor3 = contributedClassifier5 instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier5 : null;
                if (classDescriptor3 == null) {
                    return null;
                }
                contributedClassifier4 = classDescriptor3;
            }
        }
        return classifierDescriptor;
    }
}
