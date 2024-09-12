package expo.modules.kotlin.records;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/records/DoubleRangeBinder;", "Lexpo/modules/kotlin/records/ValidationBinder;", "()V", "bind", "Lexpo/modules/kotlin/records/FieldValidator;", "annotation", "", "fieldType", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ValidationBinder.kt */
public final class DoubleRangeBinder implements ValidationBinder {
    public FieldValidator<?> bind(Annotation annotation, KType kType) {
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        Intrinsics.checkNotNullParameter(kType, "fieldType");
        DoubleRange doubleRange = (DoubleRange) annotation;
        return new NumericRangeValidator<>(Double.valueOf(doubleRange.from()), Double.valueOf(doubleRange.to()), doubleRange.fromInclusive(), doubleRange.toInclusive());
    }
}
