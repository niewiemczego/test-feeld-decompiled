package kotlin.reflect.jvm.internal.impl.types;

import com.braze.Constants;
import io.sentry.protocol.SentryThread;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.model.ArgumentList;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentListMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeArgumentMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariableTypeConstructorMarker;
import kotlin.reflect.jvm.internal.impl.types.model.TypeVariance;
import kotlin.reflect.jvm.internal.impl.utils.SmartList;

/* compiled from: AbstractTypeChecker.kt */
public final class AbstractTypeChecker {
    public static final AbstractTypeChecker INSTANCE = new AbstractTypeChecker();
    public static boolean RUN_SLOW_ASSERTIONS;

    /* compiled from: AbstractTypeChecker.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TypeVariance.values().length];
            iArr[TypeVariance.INV.ordinal()] = 1;
            iArr[TypeVariance.OUT.ordinal()] = 2;
            iArr[TypeVariance.IN.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[TypeCheckerState.LowerCapturedTypePolicy.values().length];
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_ONLY_LOWER.ordinal()] = 1;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.CHECK_SUBTYPE_AND_LOWER.ordinal()] = 2;
            iArr2[TypeCheckerState.LowerCapturedTypePolicy.SKIP_LOWER.ordinal()] = 3;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final boolean isSubtypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        return isSubtypeOf$default(this, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, (Object) null);
    }

    private AbstractTypeChecker() {
    }

    public static /* synthetic */ boolean isSubtypeOf$default(AbstractTypeChecker abstractTypeChecker, TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        return abstractTypeChecker.isSubtypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean isSubtypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, "subType");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "superType");
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        if (!typeCheckerState.customIsSubtypeOf(kotlinTypeMarker, kotlinTypeMarker2)) {
            return false;
        }
        return completeIsSubTypeOf(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, z);
    }

    public final boolean equalTypes(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "state");
        Intrinsics.checkNotNullParameter(kotlinTypeMarker, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(kotlinTypeMarker2, "b");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (kotlinTypeMarker == kotlinTypeMarker2) {
            return true;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        if (abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker) && abstractTypeChecker.isCommonDenotableType(typeSystemContext, kotlinTypeMarker2)) {
            KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
            KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
            SimpleTypeMarker lowerBoundIfFlexible = typeSystemContext.lowerBoundIfFlexible(prepareType);
            if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(prepareType), typeSystemContext.typeConstructor(prepareType2))) {
                return false;
            }
            if (typeSystemContext.argumentsCount(lowerBoundIfFlexible) == 0) {
                if (typeSystemContext.hasFlexibleNullability(prepareType) || typeSystemContext.hasFlexibleNullability(prepareType2) || typeSystemContext.isMarkedNullable(lowerBoundIfFlexible) == typeSystemContext.isMarkedNullable(typeSystemContext.lowerBoundIfFlexible(prepareType2))) {
                    return true;
                }
                return false;
            }
        }
        if (!isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 8, (Object) null) || !isSubtypeOf$default(abstractTypeChecker, typeCheckerState, kotlinTypeMarker2, kotlinTypeMarker, false, 8, (Object) null)) {
            return false;
        }
        return true;
    }

    private final boolean completeIsSubTypeOf(TypeCheckerState typeCheckerState, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, boolean z) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        KotlinTypeMarker prepareType = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker));
        KotlinTypeMarker prepareType2 = typeCheckerState.prepareType(typeCheckerState.refineType(kotlinTypeMarker2));
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        Boolean checkSubtypeForSpecialCases = abstractTypeChecker.checkSubtypeForSpecialCases(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
        if (checkSubtypeForSpecialCases != null) {
            boolean booleanValue = checkSubtypeForSpecialCases.booleanValue();
            typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z);
            return booleanValue;
        }
        Boolean addSubtypeConstraint = typeCheckerState.addSubtypeConstraint(prepareType, prepareType2, z);
        if (addSubtypeConstraint != null) {
            return addSubtypeConstraint.booleanValue();
        }
        return abstractTypeChecker.isSubtypeOfForSingleClassifierType(typeCheckerState, typeSystemContext.lowerBoundIfFlexible(prepareType), typeSystemContext.upperBoundIfFlexible(prepareType2));
    }

    private final Boolean checkSubtypeForIntegerLiteralType(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (!typeSystemContext.isIntegerLiteralType(simpleTypeMarker) && !typeSystemContext.isIntegerLiteralType(simpleTypeMarker2)) {
            return null;
        }
        if (m2272checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker) && m2272checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(typeSystemContext, simpleTypeMarker2)) {
            return true;
        }
        if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker)) {
            if (m2273checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker, simpleTypeMarker2, false)) {
                return true;
            }
        } else if (typeSystemContext.isIntegerLiteralType(simpleTypeMarker2) && (m2271checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(typeSystemContext, simpleTypeMarker) || m2273checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(typeSystemContext, typeCheckerState, simpleTypeMarker2, simpleTypeMarker, true))) {
            return true;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0046, code lost:
        if (isSubtypeOf$default(INSTANCE, r11, r13, r6, false, 8, (java.lang.Object) null) != false) goto L_0x004b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x004e A[SYNTHETIC] */
    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isTypeInIntegerLiteralType  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m2273checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r10, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r11, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r12, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r13, boolean r14) {
        /*
            java.util.Collection r12 = r10.possibleIntegerTypes(r12)
            java.lang.Iterable r12 = (java.lang.Iterable) r12
            boolean r0 = r12 instanceof java.util.Collection
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            r0 = r12
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0017
        L_0x0015:
            r1 = r2
            goto L_0x004e
        L_0x0017:
            java.util.Iterator r12 = r12.iterator()
        L_0x001b:
            boolean r0 = r12.hasNext()
            if (r0 == 0) goto L_0x0015
            java.lang.Object r0 = r12.next()
            r6 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r0 = r10.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6)
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r10.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r13)
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r3)
            if (r0 != 0) goto L_0x004b
            if (r14 == 0) goto L_0x0049
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r5 = r13
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r5 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r5
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r11
            boolean r0 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r0 == 0) goto L_0x0049
            goto L_0x004b
        L_0x0049:
            r0 = r2
            goto L_0x004c
        L_0x004b:
            r0 = r1
        L_0x004c:
            if (r0 == 0) goto L_0x001b
        L_0x004e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m2273checkSubtypeForIntegerLiteralType$lambda7$isTypeInIntegerLiteralType(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, boolean):boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isIntegerLiteralTypeInIntersectionComponents  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final boolean m2271checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r4) {
        /*
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r4 = r3.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r4)
            boolean r0 = r4 instanceof kotlin.reflect.jvm.internal.impl.types.model.IntersectionTypeConstructorMarker
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0044
            java.util.Collection r4 = r3.supertypes(r4)
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            boolean r0 = r4 instanceof java.util.Collection
            if (r0 == 0) goto L_0x001f
            r0 = r4
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x001f
        L_0x001d:
            r3 = r2
            goto L_0x0041
        L_0x001f:
            java.util.Iterator r4 = r4.iterator()
        L_0x0023:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r4.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r3.asSimpleType(r0)
            if (r0 == 0) goto L_0x003d
            boolean r0 = r3.isIntegerLiteralType(r0)
            if (r0 != r1) goto L_0x003d
            r0 = r1
            goto L_0x003e
        L_0x003d:
            r0 = r2
        L_0x003e:
            if (r0 == 0) goto L_0x0023
            r3 = r1
        L_0x0041:
            if (r3 == 0) goto L_0x0044
            goto L_0x0045
        L_0x0044:
            r1 = r2
        L_0x0045:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.m2271checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeInIntersectionComponents(kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):boolean");
    }

    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isCapturedIntegerLiteralType  reason: not valid java name */
    private static final boolean m2270checkSubtypeForIntegerLiteralType$lambda7$isCapturedIntegerLiteralType(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        if (!(simpleTypeMarker instanceof CapturedTypeMarker)) {
            return false;
        }
        TypeArgumentMarker projection = typeSystemContext.projection(typeSystemContext.typeConstructor((CapturedTypeMarker) simpleTypeMarker));
        if (typeSystemContext.isStarProjection(projection) || !typeSystemContext.isIntegerLiteralType(typeSystemContext.upperBoundIfFlexible(typeSystemContext.getType(projection)))) {
            return false;
        }
        return true;
    }

    /* renamed from: checkSubtypeForIntegerLiteralType$lambda-7$isIntegerLiteralTypeOrCapturedOne  reason: not valid java name */
    private static final boolean m2272checkSubtypeForIntegerLiteralType$lambda7$isIntegerLiteralTypeOrCapturedOne(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker) {
        return typeSystemContext.isIntegerLiteralType(simpleTypeMarker) || m2270checkSubtypeForIntegerLiteralType$lambda7$isCapturedIntegerLiteralType(typeSystemContext, simpleTypeMarker);
    }

    private final boolean hasNothingSupertype(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker);
        if (typeSystemContext.isClassTypeConstructor(typeConstructor)) {
            return typeSystemContext.isNothingConstructor(typeConstructor);
        }
        if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(simpleTypeMarker))) {
            return true;
        }
        typeCheckerState.initialize();
        ArrayDeque<SimpleTypeMarker> supertypesDeque = typeCheckerState.getSupertypesDeque();
        Intrinsics.checkNotNull(supertypesDeque);
        Set<SimpleTypeMarker> supertypesSet = typeCheckerState.getSupertypesSet();
        Intrinsics.checkNotNull(supertypesSet);
        supertypesDeque.push(simpleTypeMarker);
        while (!supertypesDeque.isEmpty()) {
            if (supertypesSet.size() <= 1000) {
                SimpleTypeMarker pop = supertypesDeque.pop();
                Intrinsics.checkNotNullExpressionValue(pop, SentryThread.JsonKeys.CURRENT);
                if (supertypesSet.add(pop)) {
                    if (typeSystemContext.isClassType(pop)) {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy == null) {
                        continue;
                    } else {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            SimpleTypeMarker transformType2 = supertypesPolicy.transformType(typeCheckerState, transformType);
                            if (typeSystemContext.isNothingConstructor(typeSystemContext.typeConstructor(transformType2))) {
                                typeCheckerState.clear();
                                return true;
                            }
                            supertypesDeque.add(transformType2);
                        }
                        continue;
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        typeCheckerState.clear();
        return false;
    }

    private final boolean isSubtypeOfForSingleClassifierType(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        KotlinTypeMarker type;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker3 = simpleTypeMarker;
        SimpleTypeMarker simpleTypeMarker4 = simpleTypeMarker2;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (RUN_SLOW_ASSERTIONS) {
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker3) && !typeSystemContext.isIntersection(typeSystemContext.typeConstructor(simpleTypeMarker3))) {
                boolean isAllowedTypeVariable = typeCheckerState2.isAllowedTypeVariable(simpleTypeMarker3);
            }
            if (!typeSystemContext.isSingleClassifierType(simpleTypeMarker4)) {
                boolean isAllowedTypeVariable2 = typeCheckerState2.isAllowedTypeVariable(simpleTypeMarker4);
            }
        }
        boolean z = false;
        if (!AbstractNullabilityChecker.INSTANCE.isPossibleSubtype(typeCheckerState2, simpleTypeMarker3, simpleTypeMarker4)) {
            return false;
        }
        AbstractTypeChecker abstractTypeChecker = INSTANCE;
        KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker3;
        KotlinTypeMarker kotlinTypeMarker2 = simpleTypeMarker4;
        Boolean checkSubtypeForIntegerLiteralType = abstractTypeChecker.checkSubtypeForIntegerLiteralType(typeCheckerState2, typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker), typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker2));
        if (checkSubtypeForIntegerLiteralType != null) {
            boolean booleanValue = checkSubtypeForIntegerLiteralType.booleanValue();
            TypeCheckerState.addSubtypeConstraint$default(typeCheckerState, kotlinTypeMarker, kotlinTypeMarker2, false, 4, (Object) null);
            return booleanValue;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker4);
        boolean z2 = true;
        if ((typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker3), typeConstructor) && typeSystemContext.parametersCount(typeConstructor) == 0) || typeSystemContext.isAnyConstructor(typeSystemContext.typeConstructor(simpleTypeMarker4))) {
            return true;
        }
        Iterable<SimpleTypeMarker> findCorrespondingSupertypes = abstractTypeChecker.findCorrespondingSupertypes(typeCheckerState2, simpleTypeMarker3, typeConstructor);
        int i = 10;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(findCorrespondingSupertypes, 10));
        for (SimpleTypeMarker simpleTypeMarker5 : findCorrespondingSupertypes) {
            SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(typeCheckerState2.prepareType(simpleTypeMarker5));
            if (asSimpleType != null) {
                simpleTypeMarker5 = asSimpleType;
            }
            arrayList.add(simpleTypeMarker5);
        }
        List list = (List) arrayList;
        int size = list.size();
        if (size == 0) {
            return INSTANCE.hasNothingSupertype(typeCheckerState2, simpleTypeMarker3);
        }
        if (size == 1) {
            return INSTANCE.isSubtypeForSameConstructor(typeCheckerState2, typeSystemContext.asArgumentList((SimpleTypeMarker) CollectionsKt.first(list)), simpleTypeMarker4);
        }
        ArgumentList argumentList = new ArgumentList(typeSystemContext.parametersCount(typeConstructor));
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        int i2 = 0;
        boolean z3 = false;
        while (i2 < parametersCount) {
            z3 = (z3 || typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i2)) != TypeVariance.OUT) ? z2 : z;
            if (!z3) {
                Iterable<SimpleTypeMarker> iterable = list;
                Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, i));
                for (SimpleTypeMarker simpleTypeMarker6 : iterable) {
                    TypeArgumentMarker argumentOrNull = typeSystemContext.getArgumentOrNull(simpleTypeMarker6, i2);
                    if (argumentOrNull != null) {
                        if (!(typeSystemContext.getVariance(argumentOrNull) == TypeVariance.INV)) {
                            argumentOrNull = null;
                        }
                        if (!(argumentOrNull == null || (type = typeSystemContext.getType(argumentOrNull)) == null)) {
                            arrayList2.add(type);
                        }
                    }
                    throw new IllegalStateException(("Incorrect type: " + simpleTypeMarker6 + ", subType: " + simpleTypeMarker3 + ", superType: " + simpleTypeMarker4).toString());
                }
                argumentList.add(typeSystemContext.asTypeArgument(typeSystemContext.intersectTypes((List) arrayList2)));
            }
            i2++;
            z = false;
            z2 = true;
            i = 10;
        }
        if (z3 || !INSTANCE.isSubtypeForSameConstructor(typeCheckerState2, argumentList, simpleTypeMarker4)) {
            return typeCheckerState2.runForkingPoint(new AbstractTypeChecker$isSubtypeOfForSingleClassifierType$1$4(list, typeCheckerState2, typeSystemContext, simpleTypeMarker4));
        }
        return true;
    }

    private final boolean isTypeVariableAgainstStarProjectionForSelfType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2, TypeConstructorMarker typeConstructorMarker) {
        TypeParameterMarker typeParameter;
        SimpleTypeMarker asSimpleType = typeSystemContext.asSimpleType(kotlinTypeMarker);
        if (!(asSimpleType instanceof CapturedTypeMarker)) {
            return false;
        }
        CapturedTypeMarker capturedTypeMarker = (CapturedTypeMarker) asSimpleType;
        if (typeSystemContext.isOldCapturedType(capturedTypeMarker) || !typeSystemContext.isStarProjection(typeSystemContext.projection(typeSystemContext.typeConstructor(capturedTypeMarker))) || typeSystemContext.captureStatus(capturedTypeMarker) != CaptureStatus.FOR_SUBTYPING) {
            return false;
        }
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(kotlinTypeMarker2);
        TypeVariableTypeConstructorMarker typeVariableTypeConstructorMarker = typeConstructor instanceof TypeVariableTypeConstructorMarker ? (TypeVariableTypeConstructorMarker) typeConstructor : null;
        if (typeVariableTypeConstructorMarker == null || (typeParameter = typeSystemContext.getTypeParameter(typeVariableTypeConstructorMarker)) == null || !typeSystemContext.hasRecursiveBounds(typeParameter, typeConstructorMarker)) {
            return false;
        }
        return true;
    }

    public final boolean isSubtypeForSameConstructor(TypeCheckerState typeCheckerState, TypeArgumentListMarker typeArgumentListMarker, SimpleTypeMarker simpleTypeMarker) {
        boolean z;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        TypeArgumentListMarker typeArgumentListMarker2 = typeArgumentListMarker;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "<this>");
        Intrinsics.checkNotNullParameter(typeArgumentListMarker2, "capturedSubArguments");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "superType");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        TypeConstructorMarker typeConstructor = typeSystemContext.typeConstructor(simpleTypeMarker2);
        int size = typeSystemContext.size(typeArgumentListMarker2);
        int parametersCount = typeSystemContext.parametersCount(typeConstructor);
        if (size == parametersCount) {
            KotlinTypeMarker kotlinTypeMarker = simpleTypeMarker2;
            if (size == typeSystemContext.argumentsCount(kotlinTypeMarker)) {
                for (int i = 0; i < parametersCount; i++) {
                    TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
                    if (!typeSystemContext.isStarProjection(argument)) {
                        KotlinTypeMarker type = typeSystemContext.getType(argument);
                        TypeArgumentMarker typeArgumentMarker = typeSystemContext.get(typeArgumentListMarker2, i);
                        typeSystemContext.getVariance(typeArgumentMarker);
                        TypeVariance typeVariance = TypeVariance.INV;
                        KotlinTypeMarker type2 = typeSystemContext.getType(typeArgumentMarker);
                        AbstractTypeChecker abstractTypeChecker = INSTANCE;
                        TypeVariance effectiveVariance = abstractTypeChecker.effectiveVariance(typeSystemContext.getVariance(typeSystemContext.getParameter(typeConstructor, i)), typeSystemContext.getVariance(argument));
                        if (effectiveVariance == null) {
                            return typeCheckerState.isErrorTypeEqualsToAnything();
                        }
                        if (effectiveVariance == TypeVariance.INV && (abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type2, type, typeConstructor) || abstractTypeChecker.isTypeVariableAgainstStarProjectionForSelfType(typeSystemContext, type, type2, typeConstructor))) {
                            continue;
                        } else if (typeCheckerState.argumentsDepth <= 100) {
                            typeCheckerState2.argumentsDepth = typeCheckerState.argumentsDepth + 1;
                            int i2 = WhenMappings.$EnumSwitchMapping$0[effectiveVariance.ordinal()];
                            if (i2 == 1) {
                                z = abstractTypeChecker.equalTypes(typeCheckerState2, type2, type);
                            } else if (i2 == 2) {
                                z = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type2, type, false, 8, (Object) null);
                            } else if (i2 == 3) {
                                z = isSubtypeOf$default(abstractTypeChecker, typeCheckerState, type, type2, false, 8, (Object) null);
                            } else {
                                throw new NoWhenBranchMatchedException();
                            }
                            typeCheckerState2.argumentsDepth = typeCheckerState.argumentsDepth - 1;
                            if (!z) {
                                return false;
                            }
                        } else {
                            throw new IllegalStateException(("Arguments depth is too high. Some related argument: " + type2).toString());
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private final boolean isCommonDenotableType(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker) {
        return typeSystemContext.isDenotable(typeSystemContext.typeConstructor(kotlinTypeMarker)) && !typeSystemContext.isDynamic(kotlinTypeMarker) && !typeSystemContext.isDefinitelyNotNullType(kotlinTypeMarker) && !typeSystemContext.isNotNullTypeParameter(kotlinTypeMarker) && Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker)), (Object) typeSystemContext.typeConstructor(typeSystemContext.upperBoundIfFlexible(kotlinTypeMarker)));
    }

    public final TypeVariance effectiveVariance(TypeVariance typeVariance, TypeVariance typeVariance2) {
        Intrinsics.checkNotNullParameter(typeVariance, "declared");
        Intrinsics.checkNotNullParameter(typeVariance2, "useSite");
        if (typeVariance == TypeVariance.INV) {
            return typeVariance2;
        }
        if (typeVariance2 == TypeVariance.INV || typeVariance == typeVariance2) {
            return typeVariance;
        }
        return null;
    }

    private final boolean isStubTypeSubtypeOfAnother(TypeSystemContext typeSystemContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
        SimpleTypeMarker simpleTypeMarker3;
        SimpleTypeMarker simpleTypeMarker4;
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker);
        if (asDefinitelyNotNullType == null || (simpleTypeMarker3 = typeSystemContext.original(asDefinitelyNotNullType)) == null) {
            simpleTypeMarker3 = simpleTypeMarker;
        }
        DefinitelyNotNullTypeMarker asDefinitelyNotNullType2 = typeSystemContext.asDefinitelyNotNullType(simpleTypeMarker2);
        if (asDefinitelyNotNullType2 == null || (simpleTypeMarker4 = typeSystemContext.original(asDefinitelyNotNullType2)) == null) {
            simpleTypeMarker4 = simpleTypeMarker2;
        }
        if (typeSystemContext.typeConstructor(simpleTypeMarker3) != typeSystemContext.typeConstructor(simpleTypeMarker4)) {
            return false;
        }
        if (!typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker) && typeSystemContext.isDefinitelyNotNullType(simpleTypeMarker2)) {
            return false;
        }
        if (!typeSystemContext.isMarkedNullable(simpleTypeMarker) || typeSystemContext.isMarkedNullable(simpleTypeMarker2)) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:74:0x013c, code lost:
        if (r11 == false) goto L_0x0155;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Boolean checkSubtypeForSpecialCases(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState r18, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r19, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r20) {
        /*
            r17 = this;
            r0 = r19
            r1 = r20
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r2 = r18.getTypeSystemContext()
            r10 = r0
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r10 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r10
            boolean r3 = r2.isError(r10)
            r11 = 0
            r12 = 1
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r12)
            if (r3 != 0) goto L_0x015f
            r14 = r1
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r14 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r14
            boolean r3 = r2.isError(r14)
            if (r3 == 0) goto L_0x0022
            goto L_0x015f
        L_0x0022:
            boolean r3 = r2.isStubTypeForBuilderInference(r0)
            if (r3 == 0) goto L_0x0042
            boolean r3 = r2.isStubTypeForBuilderInference(r1)
            if (r3 == 0) goto L_0x0042
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            boolean r0 = r3.isStubTypeSubtypeOfAnother(r2, r0, r1)
            if (r0 != 0) goto L_0x003c
            boolean r0 = r18.isStubTypeEqualsToAnything()
            if (r0 == 0) goto L_0x003d
        L_0x003c:
            r11 = r12
        L_0x003d:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x0042:
            boolean r3 = r2.isStubType(r0)
            if (r3 != 0) goto L_0x0156
            boolean r3 = r2.isStubType(r1)
            if (r3 == 0) goto L_0x0050
            goto L_0x0156
        L_0x0050:
            kotlin.reflect.jvm.internal.impl.types.model.DefinitelyNotNullTypeMarker r3 = r2.asDefinitelyNotNullType(r1)
            if (r3 == 0) goto L_0x005c
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r3 = r2.original(r3)
            if (r3 != 0) goto L_0x005d
        L_0x005c:
            r3 = r1
        L_0x005d:
            kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker r3 = r2.asCapturedType(r3)
            r15 = 0
            if (r3 == 0) goto L_0x0069
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.lowerType(r3)
            goto L_0x006a
        L_0x0069:
            r4 = r15
        L_0x006a:
            if (r3 == 0) goto L_0x00be
            if (r4 == 0) goto L_0x00be
            boolean r5 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            if (r5 == 0) goto L_0x007c
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r4, (boolean) r12)
        L_0x0078:
            r9 = r18
            r6 = r4
            goto L_0x0087
        L_0x007c:
            boolean r5 = r2.isDefinitelyNotNullType(r14)
            if (r5 == 0) goto L_0x0078
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r4 = r2.makeDefinitelyNotNullOrNotNull(r4)
            goto L_0x0078
        L_0x0087:
            kotlin.reflect.jvm.internal.impl.types.TypeCheckerState$LowerCapturedTypePolicy r3 = r9.getLowerCapturedTypePolicy(r0, r3)
            int[] r4 = kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r12) goto L_0x00ac
            r4 = 2
            if (r3 == r4) goto L_0x0099
            goto L_0x00be
        L_0x0099:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r16 = 0
            r4 = r18
            r5 = r10
            r9 = r16
            boolean r3 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r3 == 0) goto L_0x00be
            return r13
        L_0x00ac:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r18
            r5 = r10
            boolean r0 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x00be:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            boolean r4 = r2.isIntersection(r3)
            if (r4 == 0) goto L_0x0105
            r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            java.util.Collection r0 = r2.supertypes(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r1 = r0 instanceof java.util.Collection
            if (r1 == 0) goto L_0x00e0
            r1 = r0
            java.util.Collection r1 = (java.util.Collection) r1
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x00e0
        L_0x00de:
            r11 = r12
            goto L_0x0100
        L_0x00e0:
            java.util.Iterator r0 = r0.iterator()
        L_0x00e4:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00de
            java.lang.Object r1 = r0.next()
            r6 = r1
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r6 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r6
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r3 = INSTANCE
            r7 = 0
            r8 = 8
            r9 = 0
            r4 = r18
            r5 = r10
            boolean r1 = isSubtypeOf$default(r3, r4, r5, r6, r7, r8, r9)
            if (r1 != 0) goto L_0x00e4
        L_0x0100:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x0105:
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r3 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0)
            boolean r0 = r0 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r0 != 0) goto L_0x013e
            boolean r0 = r2.isIntersection(r3)
            if (r0 == 0) goto L_0x0155
            java.util.Collection r0 = r2.supertypes(r3)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0128
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x0128
        L_0x0126:
            r11 = r12
            goto L_0x013c
        L_0x0128:
            java.util.Iterator r0 = r0.iterator()
        L_0x012c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0126
            java.lang.Object r3 = r0.next()
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r3 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r3
            boolean r3 = r3 instanceof kotlin.reflect.jvm.internal.impl.types.model.CapturedTypeMarker
            if (r3 != 0) goto L_0x012c
        L_0x013c:
            if (r11 == 0) goto L_0x0155
        L_0x013e:
            kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker r0 = INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.TypeSystemContext r3 = r18.getTypeSystemContext()
            kotlin.reflect.jvm.internal.impl.types.model.TypeParameterMarker r0 = r0.getTypeParameterForArgumentInBaseIfItEqualToTarget(r3, r14, r10)
            if (r0 == 0) goto L_0x0155
            kotlin.reflect.jvm.internal.impl.types.model.TypeConstructorMarker r1 = r2.typeConstructor((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            boolean r0 = r2.hasRecursiveBounds(r0, r1)
            if (r0 == 0) goto L_0x0155
            return r13
        L_0x0155:
            return r15
        L_0x0156:
            boolean r0 = r18.isStubTypeEqualsToAnything()
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        L_0x015f:
            boolean r3 = r18.isErrorTypeEqualsToAnything()
            if (r3 == 0) goto L_0x0166
            return r13
        L_0x0166:
            boolean r3 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0)
            if (r3 == 0) goto L_0x0177
            boolean r3 = r2.isMarkedNullable((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1)
            if (r3 != 0) goto L_0x0177
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r11)
            return r0
        L_0x0177:
            kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker r3 = kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker.INSTANCE
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r0 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r0, (boolean) r11)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r0 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r0
            kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker r1 = r2.withNullability((kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker) r1, (boolean) r11)
            kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker r1 = (kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker) r1
            boolean r0 = r3.strictEqualTypes(r2, r0, r1)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker.checkSubtypeForSpecialCases(kotlin.reflect.jvm.internal.impl.types.TypeCheckerState, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker, kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker):java.lang.Boolean");
    }

    private final TypeParameterMarker getTypeParameterForArgumentInBaseIfItEqualToTarget(TypeSystemContext typeSystemContext, KotlinTypeMarker kotlinTypeMarker, KotlinTypeMarker kotlinTypeMarker2) {
        KotlinTypeMarker type;
        int argumentsCount = typeSystemContext.argumentsCount(kotlinTypeMarker);
        int i = 0;
        while (true) {
            TypeArgumentMarker typeArgumentMarker = null;
            if (i >= argumentsCount) {
                return null;
            }
            TypeArgumentMarker argument = typeSystemContext.getArgument(kotlinTypeMarker, i);
            boolean z = true;
            if (!typeSystemContext.isStarProjection(argument)) {
                typeArgumentMarker = argument;
            }
            if (!(typeArgumentMarker == null || (type = typeSystemContext.getType(typeArgumentMarker)) == null)) {
                if (!typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(type)) || !typeSystemContext.isCapturedType(typeSystemContext.lowerBoundIfFlexible(kotlinTypeMarker2))) {
                    z = false;
                }
                if (!Intrinsics.areEqual((Object) type, (Object) kotlinTypeMarker2) && (!z || !Intrinsics.areEqual((Object) typeSystemContext.typeConstructor(type), (Object) typeSystemContext.typeConstructor(kotlinTypeMarker2)))) {
                    TypeParameterMarker typeParameterForArgumentInBaseIfItEqualToTarget = getTypeParameterForArgumentInBaseIfItEqualToTarget(typeSystemContext, type, kotlinTypeMarker2);
                    if (typeParameterForArgumentInBaseIfItEqualToTarget != null) {
                        return typeParameterForArgumentInBaseIfItEqualToTarget;
                    }
                }
            }
            i++;
        }
        return typeSystemContext.getParameter(typeSystemContext.typeConstructor(kotlinTypeMarker), i);
    }

    private final List<SimpleTypeMarker> collectAllSupertypesWithGivenTypeConstructor(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        TypeConstructorMarker typeConstructorMarker2 = typeConstructorMarker;
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        List<SimpleTypeMarker> fastCorrespondingSupertypes = typeSystemContext.fastCorrespondingSupertypes(simpleTypeMarker2, typeConstructorMarker2);
        if (fastCorrespondingSupertypes != null) {
            return fastCorrespondingSupertypes;
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker2) && typeSystemContext.isClassType(simpleTypeMarker2)) {
            return CollectionsKt.emptyList();
        }
        if (!typeSystemContext.isCommonFinalClassConstructor(typeConstructorMarker2)) {
            List<SimpleTypeMarker> smartList = new SmartList<>();
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
                        SimpleTypeMarker captureFromArguments = typeSystemContext.captureFromArguments(pop, CaptureStatus.FOR_SUBTYPING);
                        if (captureFromArguments == null) {
                            captureFromArguments = pop;
                        }
                        if (typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(captureFromArguments), typeConstructorMarker2)) {
                            smartList.add(captureFromArguments);
                            supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                        } else if (typeSystemContext.argumentsCount(captureFromArguments) == 0) {
                            supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                        } else {
                            supertypesPolicy = typeCheckerState.getTypeSystemContext().substitutionSupertypePolicy(captureFromArguments);
                        }
                        if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                            supertypesPolicy = null;
                        }
                        if (supertypesPolicy != null) {
                            TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                            for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                                supertypesDeque.add(supertypesPolicy.transformType(typeCheckerState, transformType));
                            }
                        }
                    }
                    TypeCheckerState typeCheckerState2 = typeCheckerState;
                } else {
                    throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
                }
            }
            TypeCheckerState typeCheckerState3 = typeCheckerState;
            typeCheckerState.clear();
            return smartList;
        } else if (!typeSystemContext.areEqualTypeConstructors(typeSystemContext.typeConstructor(simpleTypeMarker2), typeConstructorMarker2)) {
            return CollectionsKt.emptyList();
        } else {
            SimpleTypeMarker captureFromArguments2 = typeSystemContext.captureFromArguments(simpleTypeMarker2, CaptureStatus.FOR_SUBTYPING);
            if (captureFromArguments2 != null) {
                simpleTypeMarker2 = captureFromArguments2;
            }
            return CollectionsKt.listOf(simpleTypeMarker2);
        }
    }

    private final List<SimpleTypeMarker> collectAndFilter(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        return selectOnlyPureKotlinSupertypes(typeCheckerState, collectAllSupertypesWithGivenTypeConstructor(typeCheckerState, simpleTypeMarker, typeConstructorMarker));
    }

    private final List<SimpleTypeMarker> selectOnlyPureKotlinSupertypes(TypeCheckerState typeCheckerState, List<? extends SimpleTypeMarker> list) {
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (list.size() < 2) {
            return list;
        }
        Collection arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            TypeArgumentListMarker asArgumentList = typeSystemContext.asArgumentList((SimpleTypeMarker) next);
            int size = typeSystemContext.size(asArgumentList);
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                if (!(typeSystemContext.asFlexibleType(typeSystemContext.getType(typeSystemContext.get(asArgumentList, i))) == null)) {
                    z = false;
                    break;
                }
                i++;
            }
            if (z) {
                arrayList.add(next);
            }
        }
        List<SimpleTypeMarker> list2 = (List) arrayList;
        return list2.isEmpty() ^ true ? list2 : list;
    }

    public final List<SimpleTypeMarker> findCorrespondingSupertypes(TypeCheckerState typeCheckerState, SimpleTypeMarker simpleTypeMarker, TypeConstructorMarker typeConstructorMarker) {
        TypeCheckerState.SupertypesPolicy supertypesPolicy;
        TypeCheckerState typeCheckerState2 = typeCheckerState;
        SimpleTypeMarker simpleTypeMarker2 = simpleTypeMarker;
        TypeConstructorMarker typeConstructorMarker2 = typeConstructorMarker;
        Intrinsics.checkNotNullParameter(typeCheckerState2, "state");
        Intrinsics.checkNotNullParameter(simpleTypeMarker2, "subType");
        Intrinsics.checkNotNullParameter(typeConstructorMarker2, "superConstructor");
        TypeSystemContext typeSystemContext = typeCheckerState.getTypeSystemContext();
        if (typeSystemContext.isClassType(simpleTypeMarker2)) {
            return INSTANCE.collectAndFilter(typeCheckerState2, simpleTypeMarker2, typeConstructorMarker2);
        }
        if (!typeSystemContext.isClassTypeConstructor(typeConstructorMarker2) && !typeSystemContext.isIntegerLiteralTypeConstructor(typeConstructorMarker2)) {
            return INSTANCE.collectAllSupertypesWithGivenTypeConstructor(typeCheckerState2, simpleTypeMarker2, typeConstructorMarker2);
        }
        SmartList<SimpleTypeMarker> smartList = new SmartList<>();
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
                    if (typeSystemContext.isClassType(pop)) {
                        smartList.add(pop);
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.None.INSTANCE;
                    } else {
                        supertypesPolicy = TypeCheckerState.SupertypesPolicy.LowerIfFlexible.INSTANCE;
                    }
                    if (!(!Intrinsics.areEqual((Object) supertypesPolicy, (Object) TypeCheckerState.SupertypesPolicy.None.INSTANCE))) {
                        supertypesPolicy = null;
                    }
                    if (supertypesPolicy != null) {
                        TypeSystemContext typeSystemContext2 = typeCheckerState.getTypeSystemContext();
                        for (KotlinTypeMarker transformType : typeSystemContext2.supertypes(typeSystemContext2.typeConstructor(pop))) {
                            supertypesDeque.add(supertypesPolicy.transformType(typeCheckerState2, transformType));
                        }
                    }
                }
            } else {
                throw new IllegalStateException(("Too many supertypes for type: " + simpleTypeMarker2 + ". Supertypes = " + CollectionsKt.joinToString$default(supertypesSet, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null)).toString());
            }
        }
        typeCheckerState.clear();
        Collection arrayList = new ArrayList();
        for (SimpleTypeMarker simpleTypeMarker3 : smartList) {
            AbstractTypeChecker abstractTypeChecker = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(simpleTypeMarker3, "it");
            CollectionsKt.addAll(arrayList, abstractTypeChecker.collectAndFilter(typeCheckerState2, simpleTypeMarker3, typeConstructorMarker2));
        }
        return (List) arrayList;
    }
}
