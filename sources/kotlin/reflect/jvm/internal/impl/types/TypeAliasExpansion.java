package kotlin.reflect.jvm.internal.impl.types;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;

/* compiled from: TypeAliasExpansion.kt */
public final class TypeAliasExpansion {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<TypeProjection> arguments;
    private final TypeAliasDescriptor descriptor;
    private final Map<TypeParameterDescriptor, TypeProjection> mapping;
    private final TypeAliasExpansion parent;

    public /* synthetic */ TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List list, Map map, DefaultConstructorMarker defaultConstructorMarker) {
        this(typeAliasExpansion, typeAliasDescriptor, list, map);
    }

    private TypeAliasExpansion(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list, Map<TypeParameterDescriptor, ? extends TypeProjection> map) {
        this.parent = typeAliasExpansion;
        this.descriptor = typeAliasDescriptor;
        this.arguments = list;
        this.mapping = map;
    }

    public final TypeAliasDescriptor getDescriptor() {
        return this.descriptor;
    }

    public final List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public final TypeProjection getReplacement(TypeConstructor typeConstructor) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return this.mapping.get(declarationDescriptor);
        }
        return null;
    }

    public final boolean isRecursion(TypeAliasDescriptor typeAliasDescriptor) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "descriptor");
        if (!Intrinsics.areEqual((Object) this.descriptor, (Object) typeAliasDescriptor)) {
            TypeAliasExpansion typeAliasExpansion = this.parent;
            return typeAliasExpansion != null ? typeAliasExpansion.isRecursion(typeAliasDescriptor) : false;
        }
    }

    /* compiled from: TypeAliasExpansion.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final TypeAliasExpansion create(TypeAliasExpansion typeAliasExpansion, TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
            Intrinsics.checkNotNullParameter(typeAliasDescriptor, "typeAliasDescriptor");
            Intrinsics.checkNotNullParameter(list, "arguments");
            List<TypeParameterDescriptor> parameters = typeAliasDescriptor.getTypeConstructor().getParameters();
            Intrinsics.checkNotNullExpressionValue(parameters, "typeAliasDescriptor.typeConstructor.parameters");
            Iterable<TypeParameterDescriptor> iterable = parameters;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (TypeParameterDescriptor original : iterable) {
                arrayList.add(original.getOriginal());
            }
            return new TypeAliasExpansion(typeAliasExpansion, typeAliasDescriptor, list, MapsKt.toMap(CollectionsKt.zip((List) arrayList, list)), (DefaultConstructorMarker) null);
        }
    }
}
