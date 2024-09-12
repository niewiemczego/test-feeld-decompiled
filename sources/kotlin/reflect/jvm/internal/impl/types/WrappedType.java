package kotlin.reflect.jvm.internal.impl.types;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* compiled from: KotlinType.kt */
public abstract class WrappedType extends KotlinType {
    /* access modifiers changed from: protected */
    public abstract KotlinType getDelegate();

    public boolean isComputed() {
        return true;
    }

    public WrappedType() {
        super((DefaultConstructorMarker) null);
    }

    public TypeConstructor getConstructor() {
        return getDelegate().getConstructor();
    }

    public List<TypeProjection> getArguments() {
        return getDelegate().getArguments();
    }

    public boolean isMarkedNullable() {
        return getDelegate().isMarkedNullable();
    }

    public MemberScope getMemberScope() {
        return getDelegate().getMemberScope();
    }

    public TypeAttributes getAttributes() {
        return getDelegate().getAttributes();
    }

    public final UnwrappedType unwrap() {
        KotlinType delegate = getDelegate();
        while (delegate instanceof WrappedType) {
            delegate = ((WrappedType) delegate).getDelegate();
        }
        Intrinsics.checkNotNull(delegate, "null cannot be cast to non-null type org.jetbrains.kotlin.types.UnwrappedType");
        return (UnwrappedType) delegate;
    }

    public String toString() {
        return isComputed() ? getDelegate().toString() : "<Not computed yet>";
    }
}
