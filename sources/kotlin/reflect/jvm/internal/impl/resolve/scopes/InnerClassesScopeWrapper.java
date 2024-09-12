package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;

/* compiled from: InnerClassesScopeWrapper.kt */
public final class InnerClassesScopeWrapper extends MemberScopeImpl {
    private final MemberScope workerScope;

    public InnerClassesScopeWrapper(MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        this.workerScope = memberScope;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        ClassifierDescriptor contributedClassifier = this.workerScope.getContributedClassifier(name, lookupLocation);
        ClassifierDescriptorWithTypeParameters classifierDescriptorWithTypeParameters = null;
        if (contributedClassifier != null) {
            ClassDescriptor classDescriptor = contributedClassifier instanceof ClassDescriptor ? (ClassDescriptor) contributedClassifier : null;
            if (classDescriptor != null) {
                classifierDescriptorWithTypeParameters = classDescriptor;
            } else {
                if (contributedClassifier instanceof TypeAliasDescriptor) {
                    classifierDescriptorWithTypeParameters = (TypeAliasDescriptor) contributedClassifier;
                }
                classifierDescriptorWithTypeParameters = classifierDescriptorWithTypeParameters;
            }
        }
        return classifierDescriptorWithTypeParameters;
    }

    public List<ClassifierDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        DescriptorKindFilter restrictedToKindsOrNull = descriptorKindFilter.restrictedToKindsOrNull(DescriptorKindFilter.Companion.getCLASSIFIERS_MASK());
        if (restrictedToKindsOrNull == null) {
            return CollectionsKt.emptyList();
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.workerScope.getContributedDescriptors(restrictedToKindsOrNull, function1)) {
            if (next instanceof ClassifierDescriptorWithTypeParameters) {
                arrayList.add(next);
            }
        }
        return (List) arrayList;
    }

    public Set<Name> getFunctionNames() {
        return this.workerScope.getFunctionNames();
    }

    public Set<Name> getVariableNames() {
        return this.workerScope.getVariableNames();
    }

    public Set<Name> getClassifierNames() {
        return this.workerScope.getClassifierNames();
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        this.workerScope.recordLookup(name, lookupLocation);
    }

    public String toString() {
        return "Classes from " + this.workerScope;
    }
}
