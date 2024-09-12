package kotlin.reflect.jvm.internal.impl.types;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.TypeParameterDescriptor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionImpl extends TypeProjectionBase {
    private final Lazy _type$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new StarProjectionImpl$_type$2(this));
    /* access modifiers changed from: private */
    public final TypeParameterDescriptor typeParameter;

    public boolean isStarProjection() {
        return true;
    }

    public StarProjectionImpl(TypeParameterDescriptor typeParameterDescriptor) {
        Intrinsics.checkNotNullParameter(typeParameterDescriptor, "typeParameter");
        this.typeParameter = typeParameterDescriptor;
    }

    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    private final KotlinType get_type() {
        return (KotlinType) this._type$delegate.getValue();
    }

    public KotlinType getType() {
        return get_type();
    }

    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
