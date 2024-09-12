package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorScopeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: StubTypes.kt */
public abstract class AbstractStubType extends SimpleType {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean isMarkedNullable;
    private final MemberScope memberScope;
    private final NewTypeVariableConstructor originalTypeVariable;

    public abstract AbstractStubType materialize(boolean z);

    public AbstractStubType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public AbstractStubType(NewTypeVariableConstructor newTypeVariableConstructor, boolean z) {
        Intrinsics.checkNotNullParameter(newTypeVariableConstructor, "originalTypeVariable");
        this.originalTypeVariable = newTypeVariableConstructor;
        this.isMarkedNullable = z;
        this.memberScope = ErrorUtils.createErrorScope(ErrorScopeKind.STUB_TYPE_SCOPE, newTypeVariableConstructor.toString());
    }

    public final NewTypeVariableConstructor getOriginalTypeVariable() {
        return this.originalTypeVariable;
    }

    public boolean isMarkedNullable() {
        return this.isMarkedNullable;
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public List<TypeProjection> getArguments() {
        return CollectionsKt.emptyList();
    }

    public TypeAttributes getAttributes() {
        return TypeAttributes.Companion.getEmpty();
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        return z == isMarkedNullable() ? this : materialize(z);
    }

    /* compiled from: StubTypes.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
