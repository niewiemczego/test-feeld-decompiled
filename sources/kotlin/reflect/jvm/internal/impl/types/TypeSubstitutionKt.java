package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.FilteredAnnotations;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeSubstitution.kt */
public final class TypeSubstitutionKt {
    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> list, Annotations annotations) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        return replace$default(kotlinType, list, annotations, (List) null, 4, (Object) null);
    }

    public static /* synthetic */ KotlinType replace$default(KotlinType kotlinType, List<TypeProjection> list, Annotations annotations, List<TypeProjection> list2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = kotlinType.getArguments();
        }
        if ((i & 2) != 0) {
            annotations = kotlinType.getAnnotations();
        }
        if ((i & 4) != 0) {
            list2 = list;
        }
        return replace(kotlinType, list, annotations, list2);
    }

    public static final KotlinType replace(KotlinType kotlinType, List<? extends TypeProjection> list, Annotations annotations, List<? extends TypeProjection> list2) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(annotations, "newAnnotations");
        Intrinsics.checkNotNullParameter(list2, "newArgumentsForUpperBound");
        if ((list.isEmpty() || list == kotlinType.getArguments()) && annotations == kotlinType.getAnnotations()) {
            return kotlinType;
        }
        TypeAttributes attributes = kotlinType.getAttributes();
        if ((annotations instanceof FilteredAnnotations) && annotations.isEmpty()) {
            annotations = Annotations.Companion.getEMPTY();
        }
        TypeAttributes replaceAnnotations = TypeAttributesKt.replaceAnnotations(attributes, annotations);
        UnwrappedType unwrap = kotlinType.unwrap();
        if (unwrap instanceof FlexibleType) {
            FlexibleType flexibleType = (FlexibleType) unwrap;
            return KotlinTypeFactory.flexibleType(replace(flexibleType.getLowerBound(), list, replaceAnnotations), replace(flexibleType.getUpperBound(), list2, replaceAnnotations));
        } else if (unwrap instanceof SimpleType) {
            return replace((SimpleType) unwrap, list, replaceAnnotations);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ SimpleType replace$default(SimpleType simpleType, List<TypeProjection> list, TypeAttributes typeAttributes, int i, Object obj) {
        if ((i & 1) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        return replace(simpleType, (List<? extends TypeProjection>) list, typeAttributes);
    }

    public static final SimpleType replace(SimpleType simpleType, List<? extends TypeProjection> list, TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(simpleType, "<this>");
        Intrinsics.checkNotNullParameter(list, "newArguments");
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        if (list.isEmpty() && typeAttributes == simpleType.getAttributes()) {
            return simpleType;
        }
        if (list.isEmpty()) {
            return simpleType.replaceAttributes(typeAttributes);
        }
        return KotlinTypeFactory.simpleType$default(typeAttributes, simpleType.getConstructor(), (List) list, simpleType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }

    public static final SimpleType asSimpleType(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "<this>");
        UnwrappedType unwrap = kotlinType.unwrap();
        SimpleType simpleType = unwrap instanceof SimpleType ? (SimpleType) unwrap : null;
        if (simpleType != null) {
            return simpleType;
        }
        throw new IllegalStateException(("This is should be simple type: " + kotlinType).toString());
    }
}
