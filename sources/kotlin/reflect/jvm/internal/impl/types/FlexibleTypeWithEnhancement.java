package kotlin.reflect.jvm.internal.impl.types;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: TypeWithEnhancement.kt */
public final class FlexibleTypeWithEnhancement extends FlexibleType implements TypeWithEnhancement {
    private final KotlinType enhancement;
    private final FlexibleType origin;

    public FlexibleType getOrigin() {
        return this.origin;
    }

    public KotlinType getEnhancement() {
        return this.enhancement;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlexibleTypeWithEnhancement(FlexibleType flexibleType, KotlinType kotlinType) {
        super(flexibleType.getLowerBound(), flexibleType.getUpperBound());
        Intrinsics.checkNotNullParameter(flexibleType, "origin");
        Intrinsics.checkNotNullParameter(kotlinType, "enhancement");
        this.origin = flexibleType;
        this.enhancement = kotlinType;
    }

    public UnwrappedType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return TypeWithEnhancementKt.wrapEnhancement(getOrigin().replaceAttributes(typeAttributes), getEnhancement());
    }

    public UnwrappedType makeNullableAsSpecified(boolean z) {
        return TypeWithEnhancementKt.wrapEnhancement(getOrigin().makeNullableAsSpecified(z), getEnhancement().unwrap().makeNullableAsSpecified(z));
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        if (descriptorRendererOptions.getEnhancedTypes()) {
            return descriptorRenderer.renderType(getEnhancement());
        }
        return getOrigin().render(descriptorRenderer, descriptorRendererOptions);
    }

    public SimpleType getDelegate() {
        return getOrigin().getDelegate();
    }

    public FlexibleTypeWithEnhancement refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        KotlinType refineType = kotlinTypeRefiner.refineType(getOrigin());
        Intrinsics.checkNotNull(refineType, "null cannot be cast to non-null type org.jetbrains.kotlin.types.FlexibleType");
        return new FlexibleTypeWithEnhancement((FlexibleType) refineType, kotlinTypeRefiner.refineType(getEnhancement()));
    }

    public String toString() {
        return "[@EnhancedForWarnings(" + getEnhancement() + ")] " + getOrigin();
    }
}
