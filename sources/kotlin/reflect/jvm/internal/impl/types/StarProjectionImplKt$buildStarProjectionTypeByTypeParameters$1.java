package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1 extends TypeConstructorSubstitution {
    final /* synthetic */ List<TypeConstructor> $typeParameters;

    StarProjectionImplKt$buildStarProjectionTypeByTypeParameters$1(List<? extends TypeConstructor> list) {
        this.$typeParameters = list;
    }

    public TypeProjection get(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "key");
        if (!this.$typeParameters.contains(typeConstructor)) {
            return null;
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor, "null cannot be cast to non-null type org.jetbrains.kotlin.descriptors.TypeParameterDescriptor");
        return TypeUtils.makeStarProjection((TypeParameterDescriptor) declarationDescriptor);
    }
}
