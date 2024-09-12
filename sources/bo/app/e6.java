package bo.app;

import com.braze.enums.BrazeDateFormat;
import com.braze.support.DateTimeUtils;
import java.util.TimeZone;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.RangesKt;

public final class e6 {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final double a;
    private final double b;
    private long c = DateTimeUtils.nowInMilliseconds();
    private double d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    public e6(int i, int i2) {
        this.a = (double) RangesKt.coerceAtLeast(i, 1);
        this.b = (double) RangesKt.coerceAtLeast(i2, 1);
        this.d = (double) i;
    }

    public final boolean a() {
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        double a2 = a(nowInMilliseconds);
        this.d = a2;
        this.c = nowInMilliseconds;
        if (a2 < 1.0d) {
            return false;
        }
        this.d = a2 - ((double) 1);
        return true;
    }

    public final long b() {
        double a2 = a(DateTimeUtils.nowInMilliseconds());
        this.d = a2;
        if (a2 >= 1.0d) {
            return 0;
        }
        return Math.max(0, (long) ((((double) 1) - a2) * this.b * ((double) 1000)));
    }

    public String toString() {
        return "(capacity=" + this.a + ", refillRate=" + this.b + ", lastCallAt='" + DateTimeUtils.formatDateFromMillis$default(this.c, (BrazeDateFormat) null, (TimeZone) null, 3, (Object) null) + "', currentTokenCount=" + a(DateTimeUtils.nowInMilliseconds()) + ')';
    }

    public final double a(long j) {
        return Math.min(this.d + ((((double) (j - this.c)) / this.b) / ((double) 1000)), this.a);
    }
}
