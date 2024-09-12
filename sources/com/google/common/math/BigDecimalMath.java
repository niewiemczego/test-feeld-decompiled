package com.google.common.math;

import java.math.BigDecimal;
import java.math.RoundingMode;

@ElementTypesAreNonnullByDefault
public class BigDecimalMath {
    private BigDecimalMath() {
    }

    public static double roundToDouble(BigDecimal bigDecimal, RoundingMode roundingMode) {
        return BigDecimalToDoubleRounder.INSTANCE.roundToDouble(bigDecimal, roundingMode);
    }

    private static class BigDecimalToDoubleRounder extends ToDoubleRounder<BigDecimal> {
        static final BigDecimalToDoubleRounder INSTANCE = new BigDecimalToDoubleRounder();

        private BigDecimalToDoubleRounder() {
        }

        /* access modifiers changed from: package-private */
        public double roundToDoubleArbitrarily(BigDecimal bigDecimal) {
            return bigDecimal.doubleValue();
        }

        /* access modifiers changed from: package-private */
        public int sign(BigDecimal bigDecimal) {
            return bigDecimal.signum();
        }

        /* access modifiers changed from: package-private */
        public BigDecimal toX(double d, RoundingMode roundingMode) {
            return new BigDecimal(d);
        }

        /* access modifiers changed from: package-private */
        public BigDecimal minus(BigDecimal bigDecimal, BigDecimal bigDecimal2) {
            return bigDecimal.subtract(bigDecimal2);
        }
    }
}
