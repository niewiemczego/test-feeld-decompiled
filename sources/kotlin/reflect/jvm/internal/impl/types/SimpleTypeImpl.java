package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScope;
import kotlin.reflect.jvm.internal.impl.types.error.ThrowingScope;

/* compiled from: KotlinTypeFactory.kt */
final class SimpleTypeImpl extends SimpleType {
    private final List<TypeProjection> arguments;
    private final TypeConstructor constructor;
    private final boolean isMarkedNullable;
    private final MemberScope memberScope;
    private final Function1<KotlinTypeRefiner, SimpleType> refinedTypeFactory;

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    public List<TypeProjection> getArguments() {
        return this.arguments;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public SimpleTypeImpl(TypeConstructor typeConstructor, List<? extends TypeProjection> list, boolean z, MemberScope memberScope2, Function1<? super KotlinTypeRefiner, ? extends SimpleType> function1) {
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        Intrinsics.checkNotNullParameter(list, "arguments");
        Intrinsics.checkNotNullParameter(memberScope2, "memberScope");
        Intrinsics.checkNotNullParameter(function1, "refinedTypeFactory");
        this.constructor = typeConstructor;
        this.arguments = list;
        this.isMarkedNullable = z;
        this.memberScope = memberScope2;
        this.refinedTypeFactory = function1;
        if ((getMemberScope() instanceof ErrorScope) && !(getMemberScope() instanceof ThrowingScope)) {
            throw new IllegalStateException("SimpleTypeImpl should not be created for error type: " + getMemberScope() + 10 + getConstructor());
        }
    }

    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        if (typeAttributes.isEmpty()) {
            return this;
        }
        return new SimpleTypeWithAttributes(this, typeAttributes);
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        if (z) {
            return new NullableSimpleType(this);
        }
        return new NotNullSimpleType(this);
    }

    public SimpleType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        SimpleType invoke = this.refinedTypeFactory.invoke(kotlinTypeRefiner);
        return invoke == null ? this : invoke;
    }
}
