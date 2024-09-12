package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.Substitutable;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt;

/* compiled from: SubstitutingScope.kt */
public final class SubstitutingScope implements MemberScope {
    private final Lazy _allDescriptors$delegate = LazyKt.lazy(new SubstitutingScope$_allDescriptors$2(this));
    private Map<DeclarationDescriptor, DeclarationDescriptor> substitutedDescriptors;
    private final TypeSubstitutor substitutor;
    /* access modifiers changed from: private */
    public final MemberScope workerScope;

    public SubstitutingScope(MemberScope memberScope, TypeSubstitutor typeSubstitutor) {
        Intrinsics.checkNotNullParameter(memberScope, "workerScope");
        Intrinsics.checkNotNullParameter(typeSubstitutor, "givenSubstitutor");
        this.workerScope = memberScope;
        TypeSubstitution substitution = typeSubstitutor.getSubstitution();
        Intrinsics.checkNotNullExpressionValue(substitution, "givenSubstitutor.substitution");
        this.substitutor = CapturedTypeConstructorKt.wrapWithCapturingSubstitution$default(substitution, false, 1, (Object) null).buildSubstitutor();
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        MemberScope.DefaultImpls.recordLookup(this, name, lookupLocation);
    }

    private final Collection<DeclarationDescriptor> get_allDescriptors() {
        return (Collection) this._allDescriptors$delegate.getValue();
    }

    private final <D extends DeclarationDescriptor> D substitute(D d) {
        if (this.substitutor.isEmpty()) {
            return d;
        }
        if (this.substitutedDescriptors == null) {
            this.substitutedDescriptors = new HashMap();
        }
        Map<DeclarationDescriptor, DeclarationDescriptor> map = this.substitutedDescriptors;
        Intrinsics.checkNotNull(map);
        D d2 = map.get(d);
        if (d2 == null) {
            if (d instanceof Substitutable) {
                D substitute = ((Substitutable) d).substitute(this.substitutor);
                if (substitute != null) {
                    d2 = (DeclarationDescriptor) substitute;
                    map.put(d, d2);
                } else {
                    throw new AssertionError("We expect that no conflict should happen while substitution is guaranteed to generate invariant projection, but " + d + " substitution fails");
                }
            } else {
                throw new IllegalStateException(("Unknown descriptor in scope: " + d).toString());
            }
        }
        D d3 = (DeclarationDescriptor) d2;
        Intrinsics.checkNotNull(d3, "null cannot be cast to non-null type D of org.jetbrains.kotlin.resolve.scopes.SubstitutingScope.substitute");
        return d3;
    }

    /* access modifiers changed from: private */
    public final <D extends DeclarationDescriptor> Collection<D> substitute(Collection<? extends D> collection) {
        if (this.substitutor.isEmpty() || collection.isEmpty()) {
            return collection;
        }
        LinkedHashSet newLinkedHashSetWithExpectedSize = CollectionsKt.newLinkedHashSetWithExpectedSize(collection.size());
        Iterator<? extends D> it = collection.iterator();
        while (it.hasNext()) {
            newLinkedHashSetWithExpectedSize.add(substitute((DeclarationDescriptor) it.next()));
        }
        return newLinkedHashSetWithExpectedSize;
    }

    public Collection<? extends PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return substitute(this.workerScope.getContributedVariables(name, lookupLocation));
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        ClassifierDescriptor contributedClassifier = this.workerScope.getContributedClassifier(name, lookupLocation);
        if (contributedClassifier != null) {
            return (ClassifierDescriptor) substitute(contributedClassifier);
        }
        return null;
    }

    public Collection<? extends SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        return substitute(this.workerScope.getContributedFunctions(name, lookupLocation));
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        return get_allDescriptors();
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
}
