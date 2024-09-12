package expo.modules.kotlin.records;

import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lexpo/modules/kotlin/records/ValidationBinder;", "", "bind", "Lexpo/modules/kotlin/records/FieldValidator;", "annotation", "", "fieldType", "Lkotlin/reflect/KType;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ValidationBinder.kt */
public interface ValidationBinder {
    FieldValidator<?> bind(Annotation annotation, KType kType);
}
