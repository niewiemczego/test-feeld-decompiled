package kotlin.reflect.jvm.internal.impl.types.error;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.DescriptorKindFilter;

/* compiled from: ThrowingScope.kt */
public final class ThrowingScope extends ErrorScope {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ThrowingScope(ErrorScopeKind errorScopeKind, String... strArr) {
        super(errorScopeKind, (String[]) Arrays.copyOf(strArr, strArr.length));
        Intrinsics.checkNotNullParameter(errorScopeKind, "kind");
        Intrinsics.checkNotNullParameter(strArr, "formatParams");
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        throw new IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    public Set<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        throw new IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    public Set<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        throw new IllegalStateException(getDebugMessage() + ", required name: " + name);
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        throw new IllegalStateException(getDebugMessage());
    }

    public Set<Name> getFunctionNames() {
        throw new IllegalStateException();
    }

    public Set<Name> getVariableNames() {
        throw new IllegalStateException();
    }

    public Set<Name> getClassifierNames() {
        throw new IllegalStateException();
    }

    public Void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        throw new IllegalStateException();
    }

    public String toString() {
        return "ThrowingScope{" + getDebugMessage() + '}';
    }
}
