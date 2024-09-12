package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayDeque;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.utils.SmartSet;

/* compiled from: AbstractTypeChecker.kt */
public class TypeCheckerState {
    private final boolean allowedTypeVariable;
    /* access modifiers changed from: private */
    public int argumentsDepth;
    private final boolean isErrorTypeEqualsToAnything;
    private final boolean isStubTypeEqualsToAnything;
    private final AbstractTypePreparator kotlinTypePreparator;
    private final AbstractTypeRefiner kotlinTypeRefiner;
    private ArrayDeque<SimpleTypeMarker> supertypesDeque;
    private boolean supertypesLocked;
    private Set<SimpleTypeMarker> supertypesSet;
    private final TypeSystemContext typeSystemContext;

    /* compiled from: AbstractTypeChecker.kt */
    public enum LowerCapturedTypePolicy {
        CHECK_ONLY_LOWER,
        CHECK_SUBTYPE_AND_LOWER,
        SKIP_LOWER
    }

    public Boolean addSubtypeConstraint(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return null;
    }

    public boolean customIsSubtypeOf(KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return true;
    }

    public TypeCheckerState(boolean z, boolean z2, boolean z3, TypeSystemContext typeSystemContext2, AbstractTypePreparator abstractTypePreparator, AbstractTypeRefiner abstractTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeSystemContext2, "typeSystemContext");
        Intrinsics.checkNotNullParameter(abstractTypePreparator, "kotlinTypePreparator");
        Intrinsics.checkNotNullParameter(abstractTypeRefiner, "kotlinTypeRefiner");
        this.isErrorTypeEqualsToAnything = z;
        this.isStubTypeEqualsToAnything = z2;
        this.allowedTypeVariable = z3;
        this.typeSystemContext = typeSystemContext2;
        this.kotlinTypePreparator = abstractTypePreparator;
        this.kotlinTypeRefiner = abstractTypeRefiner;
    }

    public final boolean isErrorTypeEqualsToAnything() {
        return this.isErrorTypeEqualsToAnything;
    }

    public final boolean isStubTypeEqualsToAnything() {
        return this.isStubTypeEqualsToAnything;
    }

    public final TypeSystemContext getTypeSystemContext() {
        return this.typeSystemContext;
    }

    public final KotlinTypeMarker refineType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        return this.kotlinTypeRefiner.refineType(kotlinTypeMarker);
    }

    public final KotlinTypeMarker prepareType(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        return this.kotlinTypePreparator.prepareType(kotlinTypeMarker);
    }

    public LowerCapturedTypePolicy getLowerCapturedTypePolicy(SimpleTypeMarker simpleTypeMarker, CapturedTypeMarker capturedTypeMarker) {
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(capturedTypeMarker, "superType");
        return LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER;
    }

    public static /* synthetic */ Boolean addSubtypeConstraint$default(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                z = false;
            }
            return typeCheckerState.addSubtypeConstraint(kotlinTypeMarker, kotlinTypeMarker2, z);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addSubtypeConstraint");
    }

    public boolean runForkingPoint(Function1<? super ForkPointContext, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        ForkPointContext.Default defaultR = new ForkPointContext.Default();
        function1.invoke(defaultR);
        return defaultR.getResult();
    }

    /* compiled from: AbstractTypeChecker.kt */
    public interface ForkPointContext {
        void fork(Function0<Boolean> function0);

        /* compiled from: AbstractTypeChecker.kt */
        public static final class Default implements ForkPointContext {
            private boolean result;

            public final boolean getResult() {
                return this.result;
            }

            public void fork(Function0<Boolean> function0) {
                Intrinsics.checkNotNullParameter(function0, "block");
                if (!this.result) {
                    this.result = function0.invoke().booleanValue();
                }
            }
        }
    }

    public final ArrayDeque<SimpleTypeMarker> getSupertypesDeque() {
        return this.supertypesDeque;
    }

    public final Set<SimpleTypeMarker> getSupertypesSet() {
        return this.supertypesSet;
    }

    public final void initialize() {
        this.supertypesLocked = true;
        if (this.supertypesDeque == null) {
            this.supertypesDeque = new ArrayDeque<>(4);
        }
        if (this.supertypesSet == null) {
            this.supertypesSet = SmartSet.Companion.create();
        }
    }

    public final void clear() {
        ArrayDeque<SimpleTypeMarker> arrayDeque = this.supertypesDeque;
        Intrinsics.checkNotNull(arrayDeque);
        arrayDeque.clear();
        Set<SimpleTypeMarker> set = this.supertypesSet;
        Intrinsics.checkNotNull(set);
        set.clear();
        this.supertypesLocked = false;
    }

    /* compiled from: AbstractTypeChecker.kt */
    public static abstract class SupertypesPolicy {
        public /* synthetic */ SupertypesPolicy(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract SimpleTypeMarker transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker);

        private SupertypesPolicy() {
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class None extends SupertypesPolicy {
            public static final None INSTANCE = new None();

            private None() {
                super((DefaultConstructorMarker) null);
            }

            public Void transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                throw new UnsupportedOperationException("Should not be called");
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class UpperIfFlexible extends SupertypesPolicy {
            public static final UpperIfFlexible INSTANCE = new UpperIfFlexible();

            private UpperIfFlexible() {
                super((DefaultConstructorMarker) null);
            }

            public SimpleTypeMarker transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return typeCheckerState.getTypeSystemContext().upperBoundIfFlexible(kotlinTypeMarker);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static final class LowerIfFlexible extends SupertypesPolicy {
            public static final LowerIfFlexible INSTANCE = new LowerIfFlexible();

            private LowerIfFlexible() {
                super((DefaultConstructorMarker) null);
            }

            public SimpleTypeMarker transformType(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker) {
                Intrinsics.checkNotNullParameter(typeCheckerState, "state");
                Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
                return typeCheckerState.getTypeSystemContext().lowerBoundIfFlexible(kotlinTypeMarker);
            }
        }

        /* compiled from: AbstractTypeChecker.kt */
        public static abstract class DoCustomTransform extends SupertypesPolicy {
            public DoCustomTransform() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    public final boolean isAllowedTypeVariable(KotlinTypeMarker kotlinTypeMarker) {
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "type");
        return this.allowedTypeVariable && this.typeSystemContext.isTypeVariableType(kotlinTypeMarker);
    }
}
