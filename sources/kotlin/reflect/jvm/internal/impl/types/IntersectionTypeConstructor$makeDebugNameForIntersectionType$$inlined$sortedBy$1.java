package kotlin.reflect.jvm.internal.impl.types;

import java.util.Comparator;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comparisons.kt */
public final class IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ Function1 $getProperTypeRelatedToStringify$inlined;

    public IntersectionTypeConstructor$makeDebugNameForIntersectionType$$inlined$sortedBy$1(Function1 function1) {
        this.$getProperTypeRelatedToStringify$inlined = function1;
    }

    public final int compare(T t, T t2) {
        KotlinType kotlinType = (KotlinType) t;
        Function1 function1 = this.$getProperTypeRelatedToStringify$inlined;
        Intrinsics.checkNotNullExpressionValue(kotlinType, "it");
        KotlinType kotlinType2 = (KotlinType) t2;
        Function1 function12 = this.$getProperTypeRelatedToStringify$inlined;
        Intrinsics.checkNotNullExpressionValue(kotlinType2, "it");
        return ComparisonsKt.compareValues(function1.invoke(kotlinType).toString(), function12.invoke(kotlinType2).toString());
    }
}
