package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: KotlinTypeFactory.kt */
final class SimpleTypeWithAttributes extends DelegatingSimpleTypeImpl {
    private final TypeAttributes attributes;

    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleTypeWithAttributes(SimpleType simpleType, TypeAttributes typeAttributes) {
        super(simpleType);
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(typeAttributes, "attributes");
        this.attributes = typeAttributes;
    }

    public SimpleTypeWithAttributes replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new SimpleTypeWithAttributes(simpleType, getAttributes());
    }
}
