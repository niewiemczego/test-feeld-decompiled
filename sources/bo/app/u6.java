package bo.app;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class u6 {
    private final List a;

    public u6(List list) {
        Intrinsics.checkNotNullParameter(list, "triggeredActions");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof u6) && Intrinsics.areEqual((Object) this.a, (Object) ((u6) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "TriggeredActionsReceivedEvent(triggeredActions=" + this.a + ')';
    }
}
