package kotlin.reflect.jvm.internal.impl.types;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.TypeIntersectionScope;
import kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker;

/* compiled from: IntersectionTypeConstructor.kt */
public final class IntersectionTypeConstructor implements TypeConstructor, IntersectionTypeConstructorMarker {
    private KotlinType alternative;
    private final int hashCode;
    private final LinkedHashSet<KotlinType> intersectedTypes;

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public boolean isDenotable() {
        return false;
    }

    public IntersectionTypeConstructor(Collection<? extends KotlinType> collection) {
        Intrinsics.checkNotNullParameter(collection, "typesToIntersect");
        collection.isEmpty();
        LinkedHashSet<KotlinType> linkedHashSet = new LinkedHashSet<>(collection);
        this.intersectedTypes = linkedHashSet;
        this.hashCode = linkedHashSet.hashCode();
    }

    private IntersectionTypeConstructor(Collection<? extends KotlinType> collection, KotlinType kotlinType) {
        this(collection);
        this.alternative = kotlinType;
    }

    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    public Collection<KotlinType> getSupertypes() {
        return this.intersectedTypes;
    }

    public final MemberScope createScopeForKotlinType() {
        return TypeIntersectionScope.Companion.create("member scope for intersection type", this.intersectedTypes);
    }

    public KotlinBuiltIns getBuiltIns() {
        KotlinBuiltIns builtIns = ((KotlinType) this.intersectedTypes.iterator().next()).getConstructor().getBuiltIns();
        Intrinsics.checkNotNullExpressionValue(builtIns, "intersectedTypes.iterato…xt().constructor.builtIns");
        return builtIns;
    }

    public String toString() {
        return makeDebugNameForIntersectionType$default(this, (Function1) null, 1, (Object) null);
    }

    public static /* synthetic */ String makeDebugNameForIntersectionType$default(IntersectionTypeConstructor intersectionTypeConstructor, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = IntersectionTypeConstructor$makeDebugNameForIntersectionType$1.INSTANCE;
        }
        return intersectionTypeConstructor.makeDebugNameForIntersectionType(function1);
    }

    public final String makeDebugNameForIntersectionType(Function1<? super KotlinType, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "getProperTypeRelatedToStringify");
        return CollectionsKt.joinToString$default(CollectionsKt.sortedWith(this.intersectedTypes, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(function1)), " & ", "{", "}", 0, (CharSequence) null, new IntersectionTypeConstructor$makeDebugNameForIntersectionType$3(function1), 24, (Object) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntersectionTypeConstructor)) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.intersectedTypes, (Object) ((IntersectionTypeConstructor) obj).intersectedTypes);
    }

    public final SimpleType createType() {
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(TypeAttributes.Companion.getEmpty(), this, CollectionsKt.emptyList(), false, createScopeForKotlinType(), new IntersectionTypeConstructor$createType$1(this));
    }

    public int hashCode() {
        return this.hashCode;
    }

    public final IntersectionTypeConstructor setAlternative(KotlinType kotlinType) {
        return new IntersectionTypeConstructor(this.intersectedTypes, kotlinType);
    }

    public final KotlinType getAlternativeType() {
        return this.alternative;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor} */
    /* JADX WARNING: type inference failed for: r0v4 */
    /* JADX WARNING: type inference failed for: r0v7, types: [kotlin.reflect.jvm.internal.impl.types.KotlinType] */
    /* JADX WARNING: type inference failed for: r0v10 */
    /* JADX WARNING: type inference failed for: r0v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner r5) {
        /*
            r4 = this;
            java.lang.String r0 = "kotlinTypeRefiner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Collection r0 = r4.getSupertypes()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r0, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
            r2 = 0
        L_0x001d:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0033
            java.lang.Object r2 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = (kotlin.reflect.jvm.internal.impl.types.KotlinType) r2
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r2.refine(r5)
            r3 = 1
            r1.add(r2)
            r2 = r3
            goto L_0x001d
        L_0x0033:
            java.util.List r1 = (java.util.List) r1
            r0 = 0
            if (r2 != 0) goto L_0x0039
            goto L_0x004e
        L_0x0039:
            kotlin.reflect.jvm.internal.impl.types.KotlinType r2 = r4.getAlternativeType()
            if (r2 == 0) goto L_0x0043
            kotlin.reflect.jvm.internal.impl.types.KotlinType r0 = r2.refine(r5)
        L_0x0043:
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r5 = new kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor
            java.util.Collection r1 = (java.util.Collection) r1
            r5.<init>(r1)
            kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor r0 = r5.setAlternative(r0)
        L_0x004e:
            if (r0 != 0) goto L_0x0051
            r0 = r4
        L_0x0051:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor.refine(kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner):kotlin.reflect.jvm.internal.impl.types.IntersectionTypeConstructor");
    }
}
