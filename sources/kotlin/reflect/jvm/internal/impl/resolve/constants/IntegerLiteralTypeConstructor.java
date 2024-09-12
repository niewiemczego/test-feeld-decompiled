package kotlin.reflect.jvm.internal.impl.resolve.constants;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ModuleDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeAttributes;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: IntegerLiteralTypeConstructor.kt */
public final class IntegerLiteralTypeConstructor implements TypeConstructor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public final ModuleDescriptor module;
    private final Set<KotlinType> possibleTypes;
    private final Lazy supertypes$delegate;
    /* access modifiers changed from: private */
    public final SimpleType type;
    /* access modifiers changed from: private */
    public final long value;

    public /* synthetic */ IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set set, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, moduleDescriptor, set);
    }

    public ClassifierDescriptor getDeclarationDescriptor() {
        return null;
    }

    public boolean isDenotable() {
        return false;
    }

    /* compiled from: IntegerLiteralTypeConstructor.kt */
    public static final class Companion {

        /* compiled from: IntegerLiteralTypeConstructor.kt */
        private enum Mode {
            COMMON_SUPER_TYPE,
            INTERSECTION_TYPE
        }

        /* compiled from: IntegerLiteralTypeConstructor.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Mode.values().length];
                iArr[Mode.COMMON_SUPER_TYPE.ordinal()] = 1;
                iArr[Mode.INTERSECTION_TYPE.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleType findIntersectionType(Collection<? extends SimpleType> collection) {
            Intrinsics.checkNotNullParameter(collection, "types");
            return findCommonSuperTypeOrIntersectionType(collection, Mode.INTERSECTION_TYPE);
        }

        private final SimpleType findCommonSuperTypeOrIntersectionType(Collection<? extends SimpleType> collection, Mode mode) {
            if (collection.isEmpty()) {
                return null;
            }
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                Object next = it.next();
                while (it.hasNext()) {
                    Companion companion = IntegerLiteralTypeConstructor.Companion;
                    next = companion.fold((SimpleType) next, (SimpleType) it.next(), mode);
                }
                return (SimpleType) next;
            }
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }

        private final SimpleType fold(SimpleType simpleType, SimpleType simpleType2, Mode mode) {
            if (simpleType == null || simpleType2 == null) {
                return null;
            }
            TypeConstructor constructor = simpleType.getConstructor();
            TypeConstructor constructor2 = simpleType2.getConstructor();
            boolean z = constructor instanceof IntegerLiteralTypeConstructor;
            if (z && (constructor2 instanceof IntegerLiteralTypeConstructor)) {
                return fold((IntegerLiteralTypeConstructor) constructor, (IntegerLiteralTypeConstructor) constructor2, mode);
            }
            if (z) {
                return fold((IntegerLiteralTypeConstructor) constructor, simpleType2);
            }
            if (constructor2 instanceof IntegerLiteralTypeConstructor) {
                return fold((IntegerLiteralTypeConstructor) constructor2, simpleType);
            }
            return null;
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, IntegerLiteralTypeConstructor integerLiteralTypeConstructor2, Mode mode) {
            Set set;
            int i = WhenMappings.$EnumSwitchMapping$0[mode.ordinal()];
            if (i == 1) {
                set = CollectionsKt.intersect(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else if (i == 2) {
                set = CollectionsKt.union(integerLiteralTypeConstructor.getPossibleTypes(), integerLiteralTypeConstructor2.getPossibleTypes());
            } else {
                throw new NoWhenBranchMatchedException();
            }
            return KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), new IntegerLiteralTypeConstructor(integerLiteralTypeConstructor.value, integerLiteralTypeConstructor.module, set, (DefaultConstructorMarker) null), false);
        }

        private final SimpleType fold(IntegerLiteralTypeConstructor integerLiteralTypeConstructor, SimpleType simpleType) {
            if (integerLiteralTypeConstructor.getPossibleTypes().contains(simpleType)) {
                return simpleType;
            }
            return null;
        }
    }

    public final Set<KotlinType> getPossibleTypes() {
        return this.possibleTypes;
    }

    private IntegerLiteralTypeConstructor(long j, ModuleDescriptor moduleDescriptor, Set<? extends KotlinType> set) {
        this.type = KotlinTypeFactory.integerLiteralType(TypeAttributes.Companion.getEmpty(), this, false);
        this.supertypes$delegate = LazyKt.lazy(new IntegerLiteralTypeConstructor$supertypes$2(this));
        this.value = j;
        this.module = moduleDescriptor;
        this.possibleTypes = set;
    }

    /* access modifiers changed from: private */
    public final boolean isContainsOnlyUnsignedTypes() {
        Iterable<KotlinType> allSignedLiteralTypes = PrimitiveTypeUtilKt.getAllSignedLiteralTypes(this.module);
        if ((allSignedLiteralTypes instanceof Collection) && ((Collection) allSignedLiteralTypes).isEmpty()) {
            return true;
        }
        for (KotlinType contains : allSignedLiteralTypes) {
            if (!(!this.possibleTypes.contains(contains))) {
                return false;
            }
        }
        return true;
    }

    private final List<KotlinType> getSupertypes() {
        return (List) this.supertypes$delegate.getValue();
    }

    public List<TypeParameterDescriptor> getParameters() {
        return CollectionsKt.emptyList();
    }

    /* renamed from: getSupertypes  reason: collision with other method in class */
    public Collection<KotlinType> m2269getSupertypes() {
        return getSupertypes();
    }

    public KotlinBuiltIns getBuiltIns() {
        return this.module.getBuiltIns();
    }

    public TypeConstructor refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String toString() {
        return "IntegerLiteralType" + valueToString();
    }

    private final String valueToString() {
        return '[' + CollectionsKt.joinToString$default(this.possibleTypes, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, IntegerLiteralTypeConstructor$valueToString$1.INSTANCE, 30, (Object) null) + ']';
    }
}
