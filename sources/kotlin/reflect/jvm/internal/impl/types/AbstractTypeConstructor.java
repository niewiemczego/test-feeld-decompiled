package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.SupertypeLoopChecker;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: AbstractTypeConstructor.kt */
public abstract class AbstractTypeConstructor extends ClassifierBasedTypeConstructor {
    private final boolean shouldReportCyclicScopeWithCompanionWarning;
    private final NotNullLazyValue<Supertypes> supertypes;

    /* access modifiers changed from: protected */
    public abstract Collection<KotlinType> computeSupertypes();

    /* access modifiers changed from: protected */
    public KotlinType defaultSupertypeIfEmpty() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract SupertypeLoopChecker getSupertypeLoopChecker();

    /* access modifiers changed from: protected */
    public List<KotlinType> processSupertypesWithoutCycles(List<KotlinType> list) {
        Intrinsics.checkNotNullParameter(list, "supertypes");
        return list;
    }

    /* access modifiers changed from: protected */
    public void reportScopesLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    /* access modifiers changed from: protected */
    public void reportSupertypeLoopError(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "type");
    }

    public AbstractTypeConstructor(StorageManager storageManager) {
        Intrinsics.checkNotNullParameter(storageManager, "storageManager");
        this.supertypes = storageManager.createLazyValueWithPostCompute(new AbstractTypeConstructor$supertypes$1(this), AbstractTypeConstructor$supertypes$2.INSTANCE, new AbstractTypeConstructor$supertypes$3(this));
    }

    public List<KotlinType> getSupertypes() {
        return ((Supertypes) this.supertypes.invoke()).getSupertypesWithoutCycles();
    }

    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return new ModuleViewTypeConstructor(this, kotlinTypeRefiner);
    }

    /* compiled from: AbstractTypeConstructor.kt */
    private final class ModuleViewTypeConstructor implements TypeConstructor {
        /* access modifiers changed from: private */
        public final KotlinTypeRefiner kotlinTypeRefiner;
        private final Lazy refinedSupertypes$delegate;
        final /* synthetic */ AbstractTypeConstructor this$0;

        public ModuleViewTypeConstructor(AbstractTypeConstructor abstractTypeConstructor, KotlinTypeRefiner kotlinTypeRefiner2) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            this.this$0 = abstractTypeConstructor;
            this.kotlinTypeRefiner = kotlinTypeRefiner2;
            this.refinedSupertypes$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new AbstractTypeConstructor$ModuleViewTypeConstructor$refinedSupertypes$2(this, abstractTypeConstructor));
        }

        private final List<KotlinType> getRefinedSupertypes() {
            return (List) this.refinedSupertypes$delegate.getValue();
        }

        public List<TypeParameterDescriptor> getParameters() {
            List<TypeParameterDescriptor> parameters = this.this$0.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "this@AbstractTypeConstructor.parameters");
            return parameters;
        }

        public List<KotlinType> getSupertypes() {
            return getRefinedSupertypes();
        }

        public boolean isDenotable() {
            return this.this$0.isDenotable();
        }

        public ClassifierDescriptor getDeclarationDescriptor() {
            return this.this$0.getDeclarationDescriptor();
        }

        public KotlinBuiltIns getBuiltIns() {
            KotlinBuiltIns builtIns = this.this$0.getBuiltIns();
            Intrinsics.checkNotNullExpressionValue(builtIns, "this@AbstractTypeConstructor.builtIns");
            return builtIns;
        }

        public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner2) {
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
            return this.this$0.refine(kotlinTypeRefiner2);
        }

        public boolean equals(Object obj) {
            return this.this$0.equals(obj);
        }

        public int hashCode() {
            return this.this$0.hashCode();
        }

        public String toString() {
            return this.this$0.toString();
        }
    }

    /* compiled from: AbstractTypeConstructor.kt */
    private static final class Supertypes {
        private final Collection<KotlinType> allSupertypes;
        private List<? extends KotlinType> supertypesWithoutCycles = CollectionsKt.listOf(ErrorUtils.INSTANCE.getErrorTypeForLoopInSupertypes());

        public Supertypes(Collection<? extends KotlinType> collection) {
            Intrinsics.checkNotNullParameter(collection, "allSupertypes");
            this.allSupertypes = collection;
        }

        public final Collection<KotlinType> getAllSupertypes() {
            return this.allSupertypes;
        }

        public final List<KotlinType> getSupertypesWithoutCycles() {
            return this.supertypesWithoutCycles;
        }

        public final void setSupertypesWithoutCycles(List<? extends KotlinType> list) {
            Intrinsics.checkNotNullParameter(list, "<set-?>");
            this.supertypesWithoutCycles = list;
        }
    }

    /* access modifiers changed from: private */
    public final Collection<KotlinType> computeNeighbours(TypeConstructor typeConstructor, boolean z) {
        List<T> plus;
        AbstractTypeConstructor abstractTypeConstructor = typeConstructor instanceof AbstractTypeConstructor ? (AbstractTypeConstructor) typeConstructor : null;
        if (abstractTypeConstructor != null && (plus = CollectionsKt.plus(((Supertypes) abstractTypeConstructor.supertypes.invoke()).getAllSupertypes(), abstractTypeConstructor.getAdditionalNeighboursInSupertypeGraph(z))) != null) {
            return plus;
        }
        Collection<KotlinType> supertypes2 = typeConstructor.getSupertypes();
        Intrinsics.checkNotNullExpressionValue(supertypes2, "supertypes");
        return supertypes2;
    }

    /* access modifiers changed from: protected */
    public boolean getShouldReportCyclicScopeWithCompanionWarning() {
        return this.shouldReportCyclicScopeWithCompanionWarning;
    }

    /* access modifiers changed from: protected */
    public Collection<KotlinType> getAdditionalNeighboursInSupertypeGraph(boolean z) {
        return CollectionsKt.emptyList();
    }
}
