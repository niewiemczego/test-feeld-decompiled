package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class h3 implements p2 {
    private final String a;
    private final a2 b;

    public h3(String str, a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "originalRequest");
        this.a = str;
        this.b = a2Var;
    }

    public String a() {
        return this.a;
    }

    public a2 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h3)) {
            return false;
        }
        h3 h3Var = (h3) obj;
        return Intrinsics.areEqual((Object) a(), (Object) h3Var.a()) && Intrinsics.areEqual((Object) b(), (Object) h3Var.b());
    }

    public int hashCode() {
        return ((a() == null ? 0 : a().hashCode()) * 31) + b().hashCode();
    }

    public String toString() {
        return "InvalidApiKeyError(errorMessage=" + a() + ", originalRequest=" + b() + ')';
    }
}
