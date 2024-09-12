package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.NewCapturedType;

/* compiled from: SpecialTypes.kt */
public final class SpecialTypesKt {
    public static final AbbreviatedType getAbbreviatedType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof AbbreviatedType) {
            return (AbbreviatedType) unwrap;
        }
        return null;
    }

    public static final SimpleType getAbbreviation(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        AbbreviatedType abbreviatedType = getAbbreviatedType(kotlinType);
        if (abbreviatedType != null) {
            return abbreviatedType.getAbbreviation();
        }
        return null;
    }

    public static final SimpleType withAbbreviation(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(simpleType2, "abbreviatedType");
        if (KotlinTypeKt.isError(simpleType)) {
            return simpleType;
        }
        return new AbbreviatedType(simpleType, simpleType2);
    }

    public static final boolean isDefinitelyNotNullType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        return kotlinType.unwrap() instanceof DefinitelyNotNullType;
    }

    public static /* synthetic */ SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull$default(SimpleType simpleType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeSimpleTypeDefinitelyNotNullOrNotNull(simpleType, z);
    }

    public static final SimpleType makeSimpleTypeDefinitelyNotNullOrNotNull(SimpleType simpleType, boolean z) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        DefinitelyNotNullType makeDefinitelyNotNull = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(simpleType, z);
        if (makeDefinitelyNotNull != null) {
            return makeDefinitelyNotNull;
        }
        SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(simpleType);
        return makeIntersectionTypeDefinitelyNotNullOrNotNull == null ? simpleType.makeNullableAsSpecified(false) : makeIntersectionTypeDefinitelyNotNullOrNotNull;
    }

    public static final NewCapturedType withNotNullProjection(NewCapturedType newCapturedType) {
        Intrinsics.checkNotNullParameter(newCapturedType, "<this>");
        return new NewCapturedType(newCapturedType.getCaptureStatus(), newCapturedType.getConstructor(), newCapturedType.getLowerType(), newCapturedType.getAttributes(), newCapturedType.isMarkedNullable(), true);
    }

    public static /* synthetic */ UnwrappedType makeDefinitelyNotNullOrNotNull$default(UnwrappedType unwrappedType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return makeDefinitelyNotNullOrNotNull(unwrappedType, z);
    }

    public static final UnwrappedType makeDefinitelyNotNullOrNotNull(UnwrappedType unwrappedType, boolean z) {
        Intrinsics.checkNotNullParameter(unwrappedType, "<this>");
        UnwrappedType makeDefinitelyNotNull = DefinitelyNotNullType.Companion.makeDefinitelyNotNull(unwrappedType, z);
        if (makeDefinitelyNotNull == null && (makeDefinitelyNotNull = makeIntersectionTypeDefinitelyNotNullOrNotNull(unwrappedType)) == null) {
            return unwrappedType.makeNullableAsSpecified(false);
        }
        return makeDefinitelyNotNull;
    }

    private static final SimpleType makeIntersectionTypeDefinitelyNotNullOrNotNull(KotlinType kotlinType) {
        IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull;
        TypeConstructor constructor = kotlinType.getConstructor();
        IntersectionTypeConstructor intersectionTypeConstructor = constructor instanceof IntersectionTypeConstructor ? (IntersectionTypeConstructor) constructor : null;
        if (intersectionTypeConstructor == null || (makeDefinitelyNotNullOrNotNull = makeDefinitelyNotNullOrNotNull(intersectionTypeConstructor)) == null) {
            return null;
        }
        return makeDefinitelyNotNullOrNotNull.createType();
    }

    private static final IntersectionTypeConstructor makeDefinitelyNotNullOrNotNull(IntersectionTypeConstructor intersectionTypeConstructor) {
        KotlinType kotlinType;
        Iterable supertypes = intersectionTypeConstructor.getSupertypes();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(supertypes, 10));
        Iterator it = supertypes.iterator();
        boolean z = false;
        while (true) {
            kotlinType = null;
            if (!it.hasNext()) {
                break;
            }
            KotlinType kotlinType2 = (KotlinType) it.next();
            if (TypeUtils.isNullableType(kotlinType2)) {
                kotlinType2 = makeDefinitelyNotNullOrNotNull$default(kotlinType2.unwrap(), false, 1, (Object) null);
                z = true;
            }
            arrayList.add(kotlinType2);
        }
        List list = (List) arrayList;
        if (!z) {
            return null;
        }
        KotlinType alternativeType = intersectionTypeConstructor.getAlternativeType();
        if (alternativeType != null) {
            if (TypeUtils.isNullableType(alternativeType)) {
                alternativeType = makeDefinitelyNotNullOrNotNull$default(alternativeType.unwrap(), false, 1, (Object) null);
            }
            kotlinType = alternativeType;
        }
        return new IntersectionTypeConstructor(list).setAlternative(kotlinType);
    }
}
