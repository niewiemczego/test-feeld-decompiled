package bo.app;

import kotlin.jvm.internal.Intrinsics;

public final class j6 {
    private final String a;
    private final x1 b;

    public j6(String str, x1 x1Var) {
        Intrinsics.checkNotNullParameter(str, "campaignId");
        Intrinsics.checkNotNullParameter(x1Var, "pushClickEvent");
        this.a = str;
        this.b = x1Var;
    }

    public final String a() {
        return this.a;
    }

    public final x1 b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j6)) {
            return false;
        }
        j6 j6Var = (j6) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) j6Var.a) && Intrinsics.areEqual((Object) this.b, (Object) j6Var.b);
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.b.hashCode();
    }

    public String toString() {
        return "TriggerEligiblePushClickEvent(campaignId=" + this.a + ", pushClickEvent=" + this.b + ')';
    }
}
