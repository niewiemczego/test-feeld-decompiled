package bo.app;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

public final class t1 {
    private final List a;

    public t1(List list) {
        Intrinsics.checkNotNullParameter(list, "geofencesList");
        this.a = list;
    }

    public final List a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof t1) && Intrinsics.areEqual((Object) this.a, (Object) ((t1) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "GeofencesReceivedEvent(geofencesList=" + this.a + ')';
    }
}
