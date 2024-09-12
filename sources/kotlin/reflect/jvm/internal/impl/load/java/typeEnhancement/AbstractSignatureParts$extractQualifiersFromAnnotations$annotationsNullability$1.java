package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AbstractSignatureParts.kt */
final class AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1 extends Lambda implements Function1<TAnnotation, Boolean> {
    final /* synthetic */ AbstractSignatureParts<TAnnotation> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AbstractSignatureParts$extractQualifiersFromAnnotations$annotationsNullability$1(AbstractSignatureParts<TAnnotation> abstractSignatureParts) {
        super(1);
        this.this$0 = abstractSignatureParts;
    }

    public final Boolean invoke(TAnnotation tannotation) {
        Intrinsics.checkNotNullParameter(tannotation, "$this$extractNullability");
        return Boolean.valueOf(this.this$0.getForceWarning(tannotation));
    }
}
