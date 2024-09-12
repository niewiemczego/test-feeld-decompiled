package expo.modules.kotlin.records;

import expo.modules.kotlin.exception.ValidationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/records/IsNotEmptyIntArrayValidator;", "Lexpo/modules/kotlin/records/FieldValidator;", "", "()V", "validate", "", "value", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FieldValidator.kt */
public final class IsNotEmptyIntArrayValidator implements FieldValidator<int[]> {
    public void validate(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "value");
        if (iArr.length == 0) {
            throw new ValidationException("Array is empty");
        }
    }
}
