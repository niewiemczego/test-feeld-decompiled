package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: KotlinTypeFactory.kt */
final class KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1 extends Lambda implements Function1<KotlinTypeRefiner, SimpleType> {
    final /* synthetic */ List<TypeProjection> $arguments;
    final /* synthetic */ TypeAttributes $attributes;
    final /* synthetic */ TypeConstructor $constructor;
    final /* synthetic */ MemberScope $memberScope;
    final /* synthetic */ boolean $nullable;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    KotlinTypeFactory$simpleTypeWithNonTrivialMemberScope$1(TypeConstructor typeConstructor, List<? extends TypeProjection> list, TypeAttributes typeAttributes, boolean z, MemberScope memberScope) {
        super(1);
        this.$constructor = typeConstructor;
        this.$arguments = list;
        this.$attributes = typeAttributes;
        this.$nullable = z;
        this.$memberScope = memberScope;
    }

    public final SimpleType invoke(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinTypeFactory.ExpandedTypeOrRefinedConstructor access$refineConstructor = KotlinTypeFactory.INSTANCE.refineConstructor(this.$constructor, kotlinTypeRefiner, this.$arguments);
        if (access$refineConstructor == null) {
            return null;
        }
        SimpleType expandedType = access$refineConstructor.getExpandedType();
        if (expandedType != null) {
            return expandedType;
        }
        TypeAttributes typeAttributes = this.$attributes;
        TypeConstructor refinedConstructor = access$refineConstructor.getRefinedConstructor();
        Intrinsics.checkNotNull(refinedConstructor);
        return KotlinTypeFactory.simpleTypeWithNonTrivialMemberScope(typeAttributes, refinedConstructor, this.$arguments, this.$nullable, this.$memberScope);
    }
}
