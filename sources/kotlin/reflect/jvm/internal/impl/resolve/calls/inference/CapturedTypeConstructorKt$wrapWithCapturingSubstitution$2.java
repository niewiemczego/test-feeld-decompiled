package kotlin.reflect.jvm.internal.impl.resolve.calls.inference;

import kotlin.reflect.jvm.internal.impl.types.DelegatedTypeSubstitution;
import kotlin.reflect.jvm.internal.impl.types.TypeSubstitution;

/* compiled from: CapturedTypeConstructor.kt */
public final class CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2 extends DelegatedTypeSubstitution {
    final /* synthetic */ boolean $needApproximation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2(TypeSubstitution typeSubstitution, boolean z) {
        super(typeSubstitution);
        this.$needApproximation = z;
    }

    public boolean approximateContravariantCapturedTypes() {
        return this.$needApproximation;
    }

    /* JADX WARNING: type inference failed for: r4v2, types: [kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.reflect.jvm.internal.impl.types.TypeProjection get(kotlin.reflect.jvm.internal.impl.types.KotlinType r4) {
        /*
            r3 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r0 = super.get(r4)
            r1 = 0
            if (r0 == 0) goto L_0x001f
            kotlin.reflect.jvm.internal.impl.types.TypeConstructor r4 = r4.getConstructor()
            kotlin.reflect.jvm.internal.impl.descriptors.ClassifierDescriptor r4 = r4.getDeclarationDescriptor()
            boolean r2 = r4 instanceof kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor
            if (r2 == 0) goto L_0x001b
            r1 = r4
            kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor r1 = (kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor) r1
        L_0x001b:
            kotlin.reflect.jvm.internal.impl.types.TypeProjection r1 = kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt.createCapturedIfNeeded(r0, r1)
        L_0x001f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt$wrapWithCapturingSubstitution$2.get(kotlin.reflect.jvm.internal.impl.types.KotlinType):kotlin.reflect.jvm.internal.impl.types.TypeProjection");
    }
}
