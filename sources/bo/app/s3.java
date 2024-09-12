package bo.app;

import java.math.BigDecimal;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

public abstract class s3 {
    public static final BigDecimal a(BigDecimal bigDecimal) {
        Intrinsics.checkNotNullParameter(bigDecimal, "<this>");
        BigDecimal scale = bigDecimal.setScale(2, RoundingMode.HALF_UP);
        Intrinsics.checkNotNullExpressionValue(scale, "this.setScale(2, RoundingMode.HALF_UP)");
        return scale;
    }
}
