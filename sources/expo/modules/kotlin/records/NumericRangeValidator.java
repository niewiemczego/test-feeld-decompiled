package expo.modules.kotlin.records;

import com.google.firebase.messaging.Constants;
import expo.modules.kotlin.exception.ValidationException;
import java.lang.Comparable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\u0006\u0010\u0005\u001a\u00028\u0000\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0015\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u000eR\u0010\u0010\u0004\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00028\u0000X\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\b\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/records/NumericRangeValidator;", "T", "", "Lexpo/modules/kotlin/records/FieldValidator;", "from", "to", "fromInclusive", "", "toInclusive", "(Ljava/lang/Comparable;Ljava/lang/Comparable;ZZ)V", "Ljava/lang/Comparable;", "validate", "", "value", "(Ljava/lang/Comparable;)V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FieldValidator.kt */
public final class NumericRangeValidator<T extends Comparable<? super T>> implements FieldValidator<T> {
    private final T from;
    private final boolean fromInclusive;
    private final T to;
    private final boolean toInclusive;

    public NumericRangeValidator(T t, T t2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(t, Constants.MessagePayloadKeys.FROM);
        Intrinsics.checkNotNullParameter(t2, "to");
        this.from = t;
        this.to = t2;
        this.fromInclusive = z;
        this.toInclusive = z2;
    }

    public void validate(T t) {
        Intrinsics.checkNotNullParameter(t, "value");
        if (t.compareTo(this.from) < 0 || this.to.compareTo(t) < 0 || ((Intrinsics.areEqual((Object) t, (Object) this.from) && !this.fromInclusive) || (Intrinsics.areEqual((Object) t, (Object) this.to) && !this.toInclusive))) {
            T t2 = this.from;
            String str = "<=";
            String str2 = this.fromInclusive ? str : "<";
            if (!this.toInclusive) {
                str = "<";
            }
            throw new ValidationException("Value should be in range " + t2 + " " + str2 + " 'value' " + str + " " + this.to + ", got " + t);
        }
    }
}
