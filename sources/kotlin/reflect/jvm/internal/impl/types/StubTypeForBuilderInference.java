package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.types.checker.NewTypeVariableConstructor;
import kotlin.reflect.jvm.internal.impl.types.model.StubTypeMarker;

/* compiled from: StubTypes.kt */
public final class StubTypeForBuilderInference extends AbstractStubType implements StubTypeMarker {
    private final TypeConstructor constructor;
    private final MemberScope memberScope;

    public TypeConstructor getConstructor() {
        return this.constructor;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StubTypeForBuilderInference(NewTypeVariableConstructor newTypeVariableConstructor, boolean z, TypeConstructor typeConstructor) {
        super(newTypeVariableConstructor, z);
        Intrinsics.checkNotNullParameter(newTypeVariableConstructor, "originalTypeVariable");
        Intrinsics.checkNotNullParameter(typeConstructor, "constructor");
        this.constructor = typeConstructor;
        this.memberScope = newTypeVariableConstructor.getBuiltIns().getAnyType().getMemberScope();
    }

    public AbstractStubType materialize(boolean z) {
        return new StubTypeForBuilderInference(getOriginalTypeVariable(), z, getConstructor());
    }

    public MemberScope getMemberScope() {
        return this.memberScope;
    }

    public String toString() {
        return "Stub (BI): " + getOriginalTypeVariable() + (isMarkedNullable() ? "?" : "");
    }
}
