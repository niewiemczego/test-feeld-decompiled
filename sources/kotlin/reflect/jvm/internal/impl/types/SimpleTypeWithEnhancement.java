package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
public final class SimpleTypeWithEnhancement extends DelegatingSimpleType implements TypeWithEnhancement {
    private final SimpleType delegate;
    private final KotlinType enhancement;

    /* access modifiers changed from: protected */
    public SimpleType getDelegate() {
        return this.delegate;
    }

    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    public SimpleTypeWithEnhancement(SimpleType simpleType, KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        Intrinsics.checkNotNullParameter(kotlinType, "enhancement");
        this.delegate = simpleType;
        this.enhancement = kotlinType;
    }

    public SimpleType getOrigin() {
        return getDelegate();
    }

    public SimpleType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(typeAttributes), getEnhancement());
        Intrinsics.checkNotNull(wrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) wrapEnhancement;
    }

    public SimpleType makeNullableAsSpecified(boolean z) {
        UnwrappedType wrapEnhancement = TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
        Intrinsics.checkNotNull(wrapEnhancement, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return (SimpleType) wrapEnhancement;
    }

    public SimpleTypeWithEnhancement replaceDelegate(SimpleType simpleType) {
        Intrinsics.checkNotNullParameter(simpleType, "delegate");
        return new SimpleTypeWithEnhancement(simpleType, getEnhancement());
    }

    public SimpleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getDelegate());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.SimpleType");
        return new SimpleTypeWithEnhancement((SimpleType) refineType, kotlinTypeRefiner.refineType(getEnhancement()));
    }

    public String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }
}
