package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class k5 {
    private final j5 a;

    public k5(j5 j5Var) {
        Intrinsics.checkNotNullParameter(j5Var, "serverConfig");
        this.a = j5Var;
    }

    public final j5 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k5) && Intrinsics.areEqual((Object) this.a, (Object) ((k5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "ServerConfigReceivedEvent(serverConfig=" + this.a + ')';
    }
}
