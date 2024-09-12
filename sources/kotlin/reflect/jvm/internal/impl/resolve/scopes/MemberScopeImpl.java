package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.utils.FunctionsKt;

/* compiled from: MemberScopeImpl.kt */
public abstract class MemberScopeImpl implements MemberScope {
    public Set<Name> getClassifierNames() {
        return null;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return null;
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return CollectionsKt.emptyList();
    }

    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return CollectionsKt.emptyList();
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return CollectionsKt.emptyList();
    }

    public Set<Name> getFunctionNames() {
        Collection linkedHashSet = new LinkedHashSet();
        for (Object next : getContributedDescriptors(DescriptorKindFilter.FUNCTIONS, FunctionsKt.alwaysTrue())) {
            if (next instanceof SimpleFunctionDescriptor) {
                Name name = ((SimpleFunctionDescriptor) next).getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getVariableNames() {
        Collection linkedHashSet = new LinkedHashSet();
        for (Object next : getContributedDescriptors(DescriptorKindFilter.VARIABLES, FunctionsKt.alwaysTrue())) {
            if (next instanceof SimpleFunctionDescriptor) {
                Name name = ((SimpleFunctionDescriptor) next).getName();
                Intrinsics.checkNotNullExpressionValue(name, "it.name");
                linkedHashSet.add(name);
            }
        }
        return (Set) linkedHashSet;
    }
}
