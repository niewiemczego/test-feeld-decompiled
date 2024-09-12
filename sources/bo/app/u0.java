package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class u0 {
    private final String a;

    public u0(String str) {
        Intrinsics.checkNotNullParameter(str, "mite");
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u0) && Intrinsics.areEqual((Object) this.a, (Object) ((u0) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "DustMiteReceivedEvent(mite=" + this.a + ')';
    }
}
