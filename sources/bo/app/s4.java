package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class s4 {
    private final t4 a;
    private final String b;

    public s4(t4 t4Var, String str) {
        Intrinsics.checkNotNullParameter(t4Var, "pathType");
        Intrinsics.checkNotNullParameter(str, "remoteUrl");
        this.a = t4Var;
        this.b = str;
    }

    public final t4 a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s4)) {
            return false;
        }
        s4 s4Var = (s4) obj;
        return this.a == s4Var.a && Intrinsics.areEqual((Object) this.b, (Object) s4Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "RemotePath(pathType=" + this.a + ", remoteUrl=" + this.b + ')';
    }
}
