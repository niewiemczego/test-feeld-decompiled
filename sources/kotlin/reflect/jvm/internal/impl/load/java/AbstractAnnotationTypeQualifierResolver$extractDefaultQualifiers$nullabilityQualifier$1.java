package kotlin.reflect.jvm.internal.impl.load.java;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractAnnotationTypeQualifierResolver.kt */
final class AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1 extends Lambda implements Function1<TAnnotation, Boolean> {
    public static final AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1 INSTANCE = new AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1();

    AbstractAnnotationTypeQualifierResolver$extractDefaultQualifiers$nullabilityQualifier$1() {
        super(1);
    }

    public final Boolean invoke(TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "$this$extractNullability");
        return false;
    }
}
