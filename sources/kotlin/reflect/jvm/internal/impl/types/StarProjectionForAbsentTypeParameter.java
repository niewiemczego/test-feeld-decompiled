package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: StarProjectionImpl.kt */
public final class StarProjectionForAbsentTypeParameter extends TypeProjectionBase {
    private final KotlinType nullableAnyType;

    public boolean isStarProjection() {
        return true;
    }

    public StarProjectionForAbsentTypeParameter(KotlinBuiltIns kotlinBuiltIns) {
        Intrinsics.checkNotNullParameter(kotlinBuiltIns, "kotlinBuiltIns");
        SimpleType nullableAnyType2 = kotlinBuiltIns.getNullableAnyType();
        Intrinsics.checkNotNullExpressionValue(nullableAnyType2, "kotlinBuiltIns.nullableAnyType");
        this.nullableAnyType = nullableAnyType2;
    }

    public Variance getProjectionKind() {
        return Variance.OUT_VARIANCE;
    }

    public KotlinType getType() {
        return this.nullableAnyType;
    }

    public TypeProjection refine(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        return this;
    }
}
