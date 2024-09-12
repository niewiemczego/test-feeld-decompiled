package kotlin.reflect.jvm.internal.impl.types;

import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeConstructorSubstitution extends TypeSubstitution {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
        return Companion.create(typeConstructor, list);
    }

    @JvmStatic
    public static final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
        return Companion.createByConstructorsMap(map);
    }

    public abstract TypeProjection get(TypeConstructor typeConstructor);

    public TypeProjection get(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "key");
        return get(kotlinType.getConstructor());
    }

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map) {
            Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
            return createByConstructorsMap$default(this, map, false, 2, (Object) null);
        }

        private Companion() {
        }

        public static /* synthetic */ TypeConstructorSubstitution createByConstructorsMap$default(Companion companion, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                z = false;
            }
            return companion.createByConstructorsMap(map, z);
        }

        @JvmStatic
        public final TypeConstructorSubstitution createByConstructorsMap(Map<TypeConstructor, ? extends TypeProjection> map, boolean z) {
            Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
            return new TypeConstructorSubstitution$Companion$createByConstructorsMap$1(map, z);
        }

        @JvmStatic
        public final TypeSubstitution create(KotlinType kotlinType) {
            Intrinsics.checkNotNullParameter(kotlinType, "kotlinType");
            return create(kotlinType.getConstructor(), kotlinType.getArguments());
        }

        @JvmStatic
        public final TypeSubstitution create(TypeConstructor typeConstructor, List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeConstructor, "typeConstructor");
            Intrinsics.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeConstructor.parameters");
            TypeParameterDescriptor typeParameterDescriptor = (TypeParameterDescriptor) CollectionsKt.lastOrNull(parameters);
            boolean z = true;
            if (typeParameterDescriptor == null || !typeParameterDescriptor.isCapturedFromOuterDeclaration()) {
                z = false;
            }
            if (!z) {
                return new IndexedParametersSubstitution(parameters, list);
            }
            List<TypeParameterDescriptor> parameters2 = typeConstructor.getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters2, "typeConstructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters2;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor typeConstructor2 : iterable) {
                arrayList.add(typeConstructor2.getTypeConstructor());
            }
            return createByConstructorsMap$default(this, MapsKt.toMap(CollectionsKt.zip((List) arrayList, list)), false, 2, (Object) null);
        }
    }
}
