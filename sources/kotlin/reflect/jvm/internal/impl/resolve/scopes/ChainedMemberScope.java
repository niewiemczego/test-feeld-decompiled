package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptorWithTypeParameters;
import kotlin.reflect.jvm.internal.impl.descriptors.DeclarationDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SimpleFunctionDescriptor;
import kotlin.reflect.jvm.internal.impl.incremental.components.LookupLocation;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.util.collectionUtils.ScopeUtilsKt;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: ChainedMemberScope.kt */
public final class ChainedMemberScope implements MemberScope {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String debugName;
    /* access modifiers changed from: private */
    public final MemberScope[] scopes;

    public /* synthetic */ ChainedMemberScope(String str, MemberScope[] memberScopeArr, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, memberScopeArr);
    }

    private ChainedMemberScope(String str, MemberScope[] memberScopeArr) {
        this.debugName = str;
        this.scopes = memberScopeArr;
    }

    public ClassifierDescriptor getContributedClassifier(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        ClassifierDescriptor classifierDescriptor = null;
        for (MemberScope contributedClassifier : this.scopes) {
            ClassifierDescriptor contributedClassifier2 = contributedClassifier.getContributedClassifier(name, lookupLocation);
            if (contributedClassifier2 != null) {
                if (!(contributedClassifier2 instanceof ClassifierDescriptorWithTypeParameters) || !((ClassifierDescriptorWithTypeParameters) contributedClassifier2).isExpect()) {
                    return contributedClassifier2;
                }
                if (classifierDescriptor == null) {
                    classifierDescriptor = contributedClassifier2;
                }
            }
        }
        return classifierDescriptor;
    }

    public Collection<PropertyDescriptor> getContributedVariables(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedVariables(name, lookupLocation);
        }
        Collection<PropertyDescriptor> collection = null;
        for (MemberScope contributedVariables : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedVariables.getContributedVariables(name, lookupLocation));
        }
        if (collection == null) {
            return SetsKt.emptySet();
        }
        return collection;
    }

    public Collection<SimpleFunctionDescriptor> getContributedFunctions(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedFunctions(name, lookupLocation);
        }
        Collection<SimpleFunctionDescriptor> collection = null;
        for (MemberScope contributedFunctions : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedFunctions.getContributedFunctions(name, lookupLocation));
        }
        if (collection == null) {
            return SetsKt.emptySet();
        }
        return collection;
    }

    public Collection<DeclarationDescriptor> getContributedDescriptors(DescriptorKindFilter descriptorKindFilter, Function1<? super Name, Boolean> function1) {
        Intrinsics.checkNotNullParameter(descriptorKindFilter, "kindFilter");
        Intrinsics.checkNotNullParameter(function1, "nameFilter");
        MemberScope[] memberScopeArr = this.scopes;
        int length = memberScopeArr.length;
        if (length == 0) {
            return CollectionsKt.emptyList();
        }
        if (length == 1) {
            return memberScopeArr[0].getContributedDescriptors(descriptorKindFilter, function1);
        }
        Collection<DeclarationDescriptor> collection = null;
        for (MemberScope contributedDescriptors : memberScopeArr) {
            collection = ScopeUtilsKt.concat(collection, contributedDescriptors.getContributedDescriptors(descriptorKindFilter, function1));
        }
        if (collection == null) {
            return SetsKt.emptySet();
        }
        return collection;
    }

    public Set<Name> getFunctionNames() {
        MemberScope[] memberScopeArr = this.scopes;
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope functionNames : memberScopeArr) {
            CollectionsKt.addAll(linkedHashSet, functionNames.getFunctionNames());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getVariableNames() {
        MemberScope[] memberScopeArr = this.scopes;
        Collection linkedHashSet = new LinkedHashSet();
        for (MemberScope variableNames : memberScopeArr) {
            CollectionsKt.addAll(linkedHashSet, variableNames.getVariableNames());
        }
        return (Set) linkedHashSet;
    }

    public Set<Name> getClassifierNames() {
        return MemberScopeKt.flatMapClassifierNamesOrNull(ArraysKt.asIterable((T[]) this.scopes));
    }

    public void recordLookup(Name name, LookupLocation lookupLocation) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(lookupLocation, FirebaseAnalytics.Param.LOCATION);
        for (MemberScope recordLookup : this.scopes) {
            recordLookup.recordLookup(name, lookupLocation);
        }
    }

    public String toString() {
        return this.debugName;
    }

    /* compiled from: ChainedMemberScope.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MemberScope create(String str, Iterable<? extends MemberScope> iterable) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(iterable, "scopes");
            SmartList smartList = new SmartList();
            for (MemberScope memberScope : iterable) {
                if (memberScope != MemberScope.Empty.INSTANCE) {
                    if (memberScope instanceof ChainedMemberScope) {
                        CollectionsKt.addAll(smartList, (T[]) ((ChainedMemberScope) memberScope).scopes);
                    } else {
                        smartList.add(memberScope);
                    }
                }
            }
            return createOrSingle$descriptors(str, smartList);
        }

        public final MemberScope createOrSingle$descriptors(String str, List<? extends MemberScope> list) {
            Intrinsics.checkNotNullParameter(str, "debugName");
            Intrinsics.checkNotNullParameter(list, "scopes");
            int size = list.size();
            if (size == 0) {
                return MemberScope.Empty.INSTANCE;
            }
            if (size == 1) {
                return (MemberScope) list.get(0);
            }
            Object[] array = list.toArray(new MemberScope[0]);
            Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            return new ChainedMemberScope(str, (MemberScope[]) array, (DefaultConstructorMarker) null);
        }
    }
}
