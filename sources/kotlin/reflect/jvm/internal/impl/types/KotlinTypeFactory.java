package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeAliasDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.descriptors.impl.ModuleAwareClassDescriptorKt;
import kotlin.reflect.jvm.internal.impl.resolve.constants.IntegerLiteralTypeConstructor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.TypeAliasExpansionReportStrategy;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: KotlinTypeFactory.kt */
public final class KotlinTypeFactory {
    private static final Function1<KotlinTypeRefiner, SimpleType> EMPTY_REFINED_TYPE_FACTORY = KotlinTypeFactory$EMPTY_REFINED_TYPE_FACTORY$1.INSTANCE;
    public static final KotlinTypeFactory INSTANCE = new KotlinTypeFactory();

    private KotlinTypeFactory() {
    }

    private final MemberScope computeMemberScope(TypeConstructor typeConstructor, List<? extends TypeProjection> list, KotlinTypeRefiner kotlinTypeRefiner) {
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor instanceof TypeParameterDescriptor) {
            return ((TypeParameterDescriptor) declarationDescriptor).getDefaultType().getMemberScope();
        }
        if (declarationDescriptor instanceof ClassDescriptor) {
            if (kotlinTypeRefiner == null) {
                kotlinTypeRefiner = DescriptorUtilsKt.getKotlinTypeRefiner(DescriptorUtilsKt.getModule(declarationDescriptor));
            }
            if (list.isEmpty()) {
                return ModuleAwareClassDescriptorKt.getRefinedUnsubstitutedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, kotlinTypeRefiner);
            }
            return ModuleAwareClassDescriptorKt.getRefinedMemberScopeIfPossible((ClassDescriptor) declarationDescriptor, TypeConstructorSubstitution.Companion.create(typeConstructor, list), kotlinTypeRefiner);
        } else if (declarationDescriptor instanceof TypeAliasDescriptor) {
            ErrorScopeKind errorScopeKind = ErrorScopeKind.SCOPE_FOR_ABBREVIATION_TYPE;
            String name = ((TypeAliasDescriptor) declarationDescriptor).getName().toString();
            Intrinsics.checkNotNullExpressionValue(name, "descriptor.name.toString()");
            return ErrorUtils.createErrorScope(errorScopeKind, true, name);
        } else if (typeConstructor instanceof IntersectionTypeConstructor) {
            return ((IntersectionTypeConstructor) typeConstructor).createScopeForKotlinType();
        } else {
            throw new IllegalStateException("Unsupported classifier: " + declarationDescriptor + " for constructor: " + typeConstructor);
        }
    }

    public static /* synthetic */ SimpleType simpleType$default(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List list, boolean z, KotlinTypeRefiner kotlinTypeRefiner, int i, Object obj) {
        if ((i & 16) != 0) {
            kotlinTypeRefiner = null;
        }
        return simpleType(typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z, kotlinTypeRefiner);
    }

    @JvmStatic
    public static final SimpleType simpleType(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        if (!typeAttributes.isEmpty() || !list.isEmpty() || z || typeConstructor.getDeclarationDescriptor() == null) {
            return simpleTypeWithNonTrivialMemberScope(typeAttributes, typeConstructor, list, z, INSTANCE.computeMemberScope(typeConstructor, list, kotlinTypeRefiner), new KotlinTypeFactory$simpleType$1(typeConstructor, list, typeAttributes, z));
        }
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        Intrinsics.checkNotNull(declarationDescriptor);
        SimpleType defaultType = declarationDescriptor.getDefaultType();
        Intrinsics.checkNotNullExpressionValue(defaultType, "constructor.declarationDescriptor!!.defaultType");
        return defaultType;
    }

    @JvmStatic
    public static final SimpleType computeExpandedType(TypeAliasDescriptor typeAliasDescriptor, List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAliasDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(list, "arguments");
        return new TypeAliasExpander(TypeAliasExpansionReportStrategy.DO_NOTHING.INSTANCE, false).expand(TypeAliasExpansion.Companion.create((TypeAliasExpansion) null, typeAliasDescriptor, list), TypeAttributes.Companion.getEmpty());
    }

    /* access modifiers changed from: private */
    public final ExpandedTypeOrRefinedConstructor refineConstructor(TypeConstructor typeConstructor, KotlinTypeRefiner kotlinTypeRefiner, List<? extends TypeProjection> list) {
        ClassifierDescriptor refineDescriptor;
        ClassifierDescriptor declarationDescriptor = typeConstructor.getDeclarationDescriptor();
        if (declarationDescriptor == null || (refineDescriptor = kotlinTypeRefiner.refineDescriptor(declarationDescriptor)) == null) {
            return null;
        }
        if (refineDescriptor instanceof TypeAliasDescriptor) {
            return new ExpandedTypeOrRefinedConstructor(computeExpandedType((TypeAliasDescriptor) refineDescriptor, list), (TypeConstructor) null);
        }
        TypeConstructor refine = refineDescriptor.getTypeConstructor().refine(kotlinTypeRefiner);
        Intrinsics.checkNotNullExpressionValue(refine, "descriptor.typeConstruct…refine(kotlinTypeRefiner)");
        return new ExpandedTypeOrRefinedConstructor((SimpleType) null, refine);
    }

    /* compiled from: KotlinTypeFactory.kt */
    private static final class ExpandedTypeOrRefinedConstructor {
        private final SimpleType expandedType;
        private final TypeConstructor refinedConstructor;

        public ExpandedTypeOrRefinedConstructor(SimpleType simpleType, TypeConstructor typeConstructor) {
            this.expandedType = simpleType;
            this.refinedConstructor = typeConstructor;
        }

        public final SimpleType getExpandedType() {
            return this.expandedType;
        }

        public final TypeConstructor getRefinedConstructor() {
            return this.refinedConstructor;
        }
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope) {
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        TypeConstructor typeConstructor2 = typeConstructor;
        List<? extends TypeProjection> list2 = list;
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor2, list2, z, memberScope, new KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(typeConstructor2, list2, typeAttributes, z, memberScope));
        if (typeAttributes.isEmpty()) {
            return simpleTypeImpl;
        }
        return new SimpleTypeWithAttributes(simpleTypeImpl, typeAttributes);
    }

    @JvmStatic
    public static final SimpleType simpleTypeWithNonTrivialMemberScope(TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        SimpleTypeImpl simpleTypeImpl = new SimpleTypeImpl(typeConstructor, list, z, memberScope, function1);
        if (typeAttributes.isEmpty()) {
            return simpleTypeImpl;
        }
        return new SimpleTypeWithAttributes(simpleTypeImpl, typeAttributes);
    }

    @JvmStatic
    public static final SimpleType simpleNotNullType(TypeAttributes typeAttributes, ClassDescriptor classDescriptor, List<? extends TypeProjection> list) {
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        Intrinsics.checkNotNullParameter(classDescriptor, "descriptor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        TypeConstructor typeConstructor = classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "descriptor.typeConstructor");
        return simpleType$default(typeAttributes, typeConstructor, (List) list, false, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    public static /* synthetic */ SimpleType simpleType$default(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<TypeProjection> list, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            typeAttributes = simpleType.getAttributes();
        }
        if ((i & 4) != 0) {
            typeConstructor = simpleType.getConstructor();
        }
        if ((i & 8) != 0) {
            list = simpleType.getArguments();
        }
        if ((i & 16) != 0) {
            z = simpleType.isMarkedNullable();
        }
        return simpleType(simpleType, typeAttributes, typeConstructor, (List<? extends TypeProjection>) list, z);
    }

    @JvmStatic
    public static final SimpleType simpleType(SimpleType simpleType, TypeAttributes typeAttributes, TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z) {
        Intrinsics.checkNotNullParameter(simpleType, "baseType");
        Intrinsics.checkNotNullParameter(typeAttributes, "annotations");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        return simpleType$default(typeAttributes, typeConstructor, (List) list, z, (KotlinTypeRefiner) null, 16, (Object) null);
    }

    @JvmStatic
    public static final UnwrappedType flexibleType(SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        if (Intrinsics.areEqual((Object) simpleType, (Object) simpleType2)) {
            return simpleType;
        }
        return new FlexibleTypeImpl(simpleType, simpleType2);
    }

    @JvmStatic
    public static final SimpleType integerLiteralType(TypeAttributes typeAttributes, IntegerLiteralTypeConstructor integerLiteralTypeConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        Intrinsics.checkNotNullParameter(integerLiteralTypeConstructor, "constructor");
        return simpleTypeWithNonTrivialMemberScope(typeAttributes, integerLiteralTypeConstructor, CollectionsKt.emptyList(), z, ErrorUtils.createErrorScope(ErrorScopeKind.INTEGER_LITERAL_TYPE_SCOPE, true, "unknown integer literal type"));
    }
}
