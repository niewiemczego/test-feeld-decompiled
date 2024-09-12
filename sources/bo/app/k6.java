package bo.app;

import android.util.Base64;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.StringUtils;

public abstract class k6 implements u2 {
    private static final String d = BrazeLogger.getBrazeLogTag((Class<?>) k6.class);
    private final long a;
    private final long b;
    private x1 c;

    protected k6() {
        long nowInMilliseconds = DateTimeUtils.nowInMilliseconds();
        this.b = nowInMilliseconds;
        this.a = nowInMilliseconds / 1000;
    }

    public x1 a() {
        return this.c;
    }

    public long b() {
        return this.a;
    }

    public long e() {
        return this.b;
    }

    /* access modifiers changed from: protected */
    public String a(String str) {
        if (StringUtils.isNullOrBlank(str)) {
            return null;
        }
        try {
            return new String(Base64.decode(str, 0)).split("_")[0];
        } catch (Exception e) {
            BrazeLogger.e(d, "Unexpected error decoding Base64 encoded campaign Id " + str, e);
            return null;
        }
    }

    protected k6(x1 x1Var) {
        this();
        this.c = x1Var;
    }
}
