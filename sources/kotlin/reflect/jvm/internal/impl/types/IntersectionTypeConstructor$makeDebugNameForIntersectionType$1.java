package kotlin.reflect.jvm.internal.impl.types;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: IntersectionTypeConstructor.kt */
final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$1 extends Lambda implements Function1<KotlinType, String> {
    public static final IntersectionTypeConstructor$makeDebugNameForIntersectionType$1 INSTANCE = new IntersectionTypeConstructor$makeDebugNameForIntersectionType$1();

    IntersectionTypeConstructor$makeDebugNameForIntersectionType$1() {
        super(1);
    }

    public final String invoke(KotlinType kotlinType) {
        Intrinsics.checkNotNullParameter(kotlinType, "it");
        return kotlinType.toString();
    }
}
