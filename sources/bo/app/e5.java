package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class e5 implements p2 {
    private final a2 a;
    private final int b;
    private final String c;
    private final String d;

    public e5(a2 a2Var, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(a2Var, "originalRequest");
        this.a = a2Var;
        this.b = i;
        this.c = str;
        this.d = str2;
    }

    public String a() {
        return this.d;
    }

    public a2 b() {
        return this.a;
    }

    public int c() {
        return this.b;
    }

    public String d() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e5)) {
            return false;
        }
        e5 e5Var = (e5) obj;
        return Intrinsics.areEqual((Object) b(), (Object) e5Var.b()) && c() == e5Var.c() && Intrinsics.areEqual((Object) d(), (Object) e5Var.d()) && Intrinsics.areEqual((Object) a(), (Object) e5Var.a());
    }

    public int hashCode() {
        int i = 0;
        int hashCode = ((((b().hashCode() * 31) + Integer.hashCode(c())) * 31) + (d() == null ? 0 : d().hashCode())) * 31;
        if (a() != null) {
            i = a().hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "{code = " + c() + ", reason = " + d() + ", message = " + a() + '}';
    }
}
