package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class g implements p2 {
    private final String a;
    private final a2 b;

    public g(String str, a2 a2Var) {
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
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return Intrinsics.areEqual((Object) a(), (Object) gVar.a()) && Intrinsics.areEqual((Object) b(), (Object) gVar.b());
    }

    public int hashCode() {
        return ((a() == null ? 0 : a().hashCode()) * 31) + b().hashCode();
    }

    public String toString() {
        return "BasicResponseError(errorMessage=" + a() + ", originalRequest=" + b() + ')';
    }
}
