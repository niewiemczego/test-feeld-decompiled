package kotlin.reflect.jvm.internal.impl.types;

import io.sentry.protocol.SentryThread;
import java.util.ArrayDeque;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractNullabilityChecker {
    public static final AbstractNullabilityChecker INSTANCE = new AbstractNullabilityChecker();

    private AbstractNullabilityChecker() {
    }

    public final boolean isPossibleSubtype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        return runIsPossibleSubtype(typeCheckerState, simpleTypeMarker, simpleTypeMarker2);
    }

    private final boolean runIsPossibleSubtype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (AbstractTypeChecker.RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker))) {
                boolean isAllowedTypeVariable = typeCheckerState.isAllowedTypeVariable(simpleTypeMarker);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker2)) {
                boolean isAllowedTypeVariable2 = typeCheckerState.isAllowedTypeVariable(simpleTypeMarker2);
            }
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return true;
        }
        KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker;
        if (typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) || typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker)) {
            return true;
        }
        if ((simpleTypeMarker instanceof CapturedTypeMarker) && typeSystemContext.isProjectionNotNull((CapturedTypeMarker) simpleTypeMarker)) {
            return true;
        }
        AbstractNullabilityChecker abstractNullabilityChecker = INSTANCE;
        if (abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker, TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE)) {
            return true;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2) && !abstractNullabilityChecker.hasNotNullSupertype(typeCheckerState, simpleTypeMarker2, TypeCheckerState.SupertypesPolicy.UpperIfFlexible.INSTANCE) && !typeSystemContext.isClassType(simpleTypeMarker)) {
            return abstractNullabilityChecker.hasPathByNotMarkedNullableNodes(typeCheckerState, simpleTypeMarker, typeSystemContext.typeConstructor(simpleTypeMarker2));
        }
        return false;
    }

    public final boolean hasNotNullSupertype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeCheckerState.SupertypesPolicy supertypesPolicy) {
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "<this>");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "type");
        TypeCheckerState.SupertypesPolicy supertypesPolicy2 = supertypesPolicy;
        Intrinsics.checkNotNullParameter(supertypesPolicy2, "supertypesPolicy");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!((typeSystemContext.isClassType(simpleTypeMarker2) && !typeSystemContext.isMarkedNullable(simpleTypeMarker2)) || typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2))) {
            typeCheckerState.initialize();
            ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
            Intrinsics.checkNotNull(supertypesDeque);
            Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
            Intrinsics.checkNotNull(supertypesSet);
            supertypesDeque.push(simpleTypeMarker2);
            while (!supertypesDeque.isEmpty()) {
                if (supertypesSet.size() <= 1000) {
                    SimpleTypeMarker pop = supertypesDeque.pop();
                    Intrinsics.checkNotNullExpressionValue(pop, SentryThread.JsonKeys.CURRENT);
                    if (supertypesSet.add(pop)) {
                        TypeCheckerState.SupertypesPolicy supertypesPolicy3 = typeSystemContext.isMarkedNullable(pop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : supertypesPolicy2;
                        if (!(!Intrinsics.areEqual((Object) supertypesPolicy3, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy3 = null;
                        }
                        if (supertypesPolicy3 == null) {
                            continue;
                        } else {
                            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                            for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                                SimpleTypeMarker transformType2 = supertypesPolicy3.transformType(typeCheckerState2, transformType);
                                if ((typeSystemContext.isClassType(transformType2) && !typeSystemContext.isMarkedNullable(transformType2)) || typeSystemContext.isDefinitelyNotNullType(transformType2)) {
                                    typeCheckerState.clear();
                                } else {
                                    supertypesDeque.add(transformType2);
                                }
                            }
                            continue;
                        }
                    }
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                }
            }
            typeCheckerState.clear();
            return false;
        }
        return true;
    }

    public final boolean hasPathByNotMarkedNullableNodes(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        TypeConstructorMarker typeConstructorMarker2 = typeConstructorMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "start");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "end");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (INSTANCE.isApplicableAsEndNode(typeCheckerState2, simpleTypeMarker2, typeConstructorMarker2)) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker2);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, SentryThread.JsonKeys.CURRENT);
                if (supertypesSet.add(pop)) {
                    TypeCheckerState.SupertypesPolicy supertypesPolicy = typeSystemContext.isMarkedNullable(pop) ? TypeCheckerState.SupertypesPolicy.None.INSTANCE : TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            SimpleTypeMarker transformType2 = supertypesPolicy.transformType(typeCheckerState2, transformType);
                            if (INSTANCE.isApplicableAsEndNode(typeCheckerState2, transformType2, typeConstructorMarker2)) {
                                typeCheckerState.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType2);
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isApplicableAsEndNode(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isNothing(simpleTypeMarker)) {
            return true;
        }
        if (typeSystemContext.isMarkedNullable(simpleTypeMarker)) {
            return false;
        }
        if (!typeCheckerState.isStubTypeEqualsToAnything() || !typeSystemContext.isStubType(simpleTypeMarker)) {
            return typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker), typeConstructorMarker);
        }
        return true;
    }
}
