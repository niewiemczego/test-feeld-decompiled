package bo.app;

import java.util.concurrent.TimeUnit;

public final class v1 {
    public static final v1 a = new v1();
    private static final int b = ((int) TimeUnit.SECONDS.toMillis(5));
    private static j2 c;

    private v1() {
    }

    public static final j2 a() {
        j2 j2Var = c;
        return j2Var == null ? new j3(new u1(b)) : j2Var;
    }
}
