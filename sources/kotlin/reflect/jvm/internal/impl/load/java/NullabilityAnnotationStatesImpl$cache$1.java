package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.name.FqName;
import kotlin.reflect.jvm.internal.impl.name.FqNamesUtilKt;

/* compiled from: JavaNullabilityAnnotationSettings.kt */
final class NullabilityAnnotationStatesImpl$cache$1 extends Lambda implements Function1<FqName, T> {
    final /* synthetic */ NullabilityAnnotationStatesImpl<T> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    NullabilityAnnotationStatesImpl$cache$1(NullabilityAnnotationStatesImpl<T> nullabilityAnnotationStatesImpl) {
        super(1);
        this.this$0 = nullabilityAnnotationStatesImpl;
    }

    public final T invoke(FqName fqName) {
        Intrinsics.checkNotNullExpressionValue(fqName, "it");
        return FqNamesUtilKt.findValueForMostSpecificFqname(fqName, this.this$0.getStates());
    }
}
