package kotlin.reflect.jvm.internal.impl.types.checker;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructorSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeProjection;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.Variance;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;
import kotlin.reflect.jvm.internal.impl.types.model.CaptureStatus;
import kotlin.reflect.jvm.internal.impl.types.model.KotlinTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: NewCapturedType.kt */
public final class NewCapturedTypeKt {
    public static final SimpleType captureFromArguments(SimpleType simpleType, CaptureStatus captureStatus) {
        Intrinsics.checkNotNullParameter(simpleType, "type");
        Intrinsics.checkNotNullParameter(captureStatus, "status");
        UnwrappedType unwrappedType = simpleType;
        List<TypeProjection> captureArguments = captureArguments(unwrappedType, captureStatus);
        if (captureArguments != null) {
            return replaceArguments(unwrappedType, captureArguments);
        }
        return null;
    }

    private static final SimpleType replaceArguments(UnwrappedType unwrappedType, List<? extends TypeProjection> list) {
        return KotlinTypeFactory.simpleType$default(unwrappedType.getAttributes(), unwrappedType.getConstructor(), (List) list, unwrappedType.isMarkedNullable(), (KotlinTypeRefiner) null, 16, (Object) null);
    }

    private static final List<TypeProjection> captureArguments(UnwrappedType unwrappedType, CaptureStatus captureStatus) {
        UnwrappedType unwrappedType2;
        boolean z;
        if (unwrappedType.getArguments().size() != unwrappedType.getConstructor().getParameters().size()) {
            return null;
        }
        List<TypeProjection> arguments = unwrappedType.getArguments();
        Iterable iterable = arguments;
        boolean z2 = true;
        if (!(iterable instanceof Collection) || !((Collection) iterable).isEmpty()) {
            Iterator it = iterable.iterator();
            while (true) {
                if (it.hasNext()) {
                    if (((TypeProjection) it.next()).getProjectionKind() == Variance.INVARIANT) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (!z) {
                        z2 = false;
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        if (z2) {
            return null;
        }
        List<TypeParameterDescriptor> parameters = unwrappedType.getConstructor().getParameters();
        Intrinsics.checkNotNullExpressionValue(parameters, "type.constructor.parameters");
        Iterable<Pair> zip = CollectionsKt.zip(iterable, parameters);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(zip, 10));
        for (Pair pair : zip) {
            TypeProjection typeProjection = (TypeProjection) pair.component1();
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) pair.component2();
            if (typeProjection.getProjectionKind() != Variance.INVARIANT) {
                if (typeProjection.isStarProjection() || typeProjection.getProjectionKind() != Variance.IN_VARIANCE) {
                    UnwrappedType unwrappedType3 = null;
                    unwrappedType2 = null;
                } else {
                    unwrappedType2 = typeProjection.getType().unwrap();
                }
                Intrinsics.checkNotNullExpressionValue(typeParameterDescriptor, "parameter");
                typeProjection = TypeUtilsKt.asTypeProjection(new NewCapturedType(captureStatus, unwrappedType2, typeProjection, typeParameterDescriptor));
            }
            arrayList.add(typeProjection);
        }
        List<TypeProjection> list = (List) arrayList;
        TypeSubstitutor buildSubstitutor = TypeConstructorSubstitution.Companion.create(unwrappedType.getConstructor(), list).buildSubstitutor();
        int size = arguments.size();
        for (int i = 0; i < size; i++) {
            TypeProjection typeProjection2 = arguments.get(i);
            TypeProjection typeProjection3 = list.get(i);
            if (typeProjection2.getProjectionKind() != Variance.INVARIANT) {
                List<KotlinType> upperBounds = unwrappedType.getConstructor().getParameters().get(i).getUpperBounds();
                Intrinsics.checkNotNullExpressionValue(upperBounds, "type.constructor.parameters[index].upperBounds");
                Collection arrayList2 = new ArrayList();
                for (KotlinType safeSubstitute : upperBounds) {
                    arrayList2.add(KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) buildSubstitutor.safeSubstitute(safeSubstitute, Variance.INVARIANT).unwrap()));
                }
                List list2 = (List) arrayList2;
                UnwrappedType prepareType = (typeProjection2.isStarProjection() || typeProjection2.getProjectionKind() != Variance.OUT_VARIANCE) ? null : KotlinTypePreparator.Default.INSTANCE.prepareType((KotlinTypeMarker) typeProjection2.getType().unwrap());
                KotlinType type = typeProjection3.getType();
                Intrinsics.checkNotNull(type, "null cannot be cast to non-null type org.jetbrains.kotlin.types.checker.NewCapturedType");
                ((NewCapturedType) type).getConstructor().initializeSupertypes(prepareType, list2);
            }
        }
        return list;
    }
}
