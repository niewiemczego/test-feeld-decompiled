package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinTypeFactory.kt */
public abstract class DelegatingSimpleTypeImpl extends DelegatingSimpleType {
    private final SimpleType delegate;

    public DelegatingSimpleTypeImpl(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        this.delegate = simpleType;
    }

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.delegate;
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        if (typeAttributes != getAttributes()) {
            return new SimpleTypeWithAttributes(this, typeAttributes);
        }
        return this;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        if (z == isMarkedNullable()) {
            return this;
        }
        return getDelegate().makeNullableAsSpecified(z).replaceAttributes(getAttributes());
    }
}
