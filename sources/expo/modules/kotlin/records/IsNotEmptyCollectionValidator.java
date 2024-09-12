package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import java.util.Collection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/records/IsNotEmptyCollectionValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", "()V", "validate", "", "value", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FieldValidator.kt */
public final class IsNotEmptyCollectionValidator implements FieldValidator<Collection<?>> {
    public void validate(Collection<?> collection) {
        Intrinsics.checkNotNullParameter(collection, "value");
        if (collection.isEmpty()) {
            throw new ValidationException("Collection is empty");
        }
    }
}
