package kotlin.reflect.jvm.internal.impl.types;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRenderer;
import kotlin.reflect.jvm.internal.impl.renderer.DescriptorRendererOptions;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;
import kotlin.reflect.jvm.internal.impl.types.model.DynamicTypeMarker;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* compiled from: dynamicTypes.kt */
public final class DynamicType extends FlexibleType implements DynamicTypeMarker {
    private final TypeAttributes attributes;

    public boolean isMarkedNullable() {
        return false;
    }

    public DynamicType makeNullableAsSpecified(boolean z) {
        return this;
    }

    public DynamicType refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }

    public String render(DescriptorRenderer descriptorRenderer, DescriptorRendererOptions descriptorRendererOptions) {
        Intrinsics.checkNotNullParameter(descriptorRenderer, "renderer");
        Intrinsics.checkNotNullParameter(descriptorRendererOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        return "dynamic";
    }

    public TypeAttributes getAttributes() {
        return this.attributes;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DynamicType(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns r3, kotlin.reflect.jvm.internal.impl.types.TypeAttributes r4) {
        /*
            r2 = this;
            java.lang.String r0 = "builtIns"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "attributes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r0 = r3.getNothingType()
            java.lang.String r1 = "builtIns.nothingType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.reflect.jvm.internal.impl.types.SimpleType r3 = r3.getNullableAnyType()
            java.lang.String r1 = "builtIns.nullableAnyType"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r1)
            r2.<init>(r0, r3)
            r2.attributes = r4
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.types.DynamicType.<init>(kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns, kotlin.reflect.jvm.internal.impl.types.TypeAttributes):void");
    }

    public SimpleType getDelegate() {
        return getUpperBound();
    }

    public DynamicType replaceAttributes(TypeAttributes typeAttributes) {
        Intrinsics.checkNotNullParameter(typeAttributes, "newAttributes");
        return new DynamicType(TypeUtilsKt.getBuiltIns(getDelegate()), typeAttributes);
    }
}
