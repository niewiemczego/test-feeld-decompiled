package kotlin.reflect.jvm.internal.impl.types.checker;

import com.braze.Constants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.types.AbstractStrictEqualityTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;

/* compiled from: NewKotlinTypeChecker.kt */
public final class StrictEqualityTypeChecker {
    public static final StrictEqualityTypeChecker INSTANCE = new StrictEqualityTypeChecker();

    private StrictEqualityTypeChecker() {
    }

    public final boolean strictEqualTypes(UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(unwrappedType, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(unwrappedType2, "b");
        return AbstractStrictEqualityTypeChecker.INSTANCE.strictEqualTypes(SimpleClassicTypeSystemContext.INSTANCE, unwrappedType, unwrappedType2);
    }
}
