package bo.app;

import java.util.Collection;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;

public final class k implements h2 {
    private final Set b;
    private final boolean c;

    public k(Set set) {
        Intrinsics.checkNotNullParameter(set, "eventsList");
        this.b = set;
        this.c = set.isEmpty();
    }

    public final boolean a() {
        boolean z;
        Set<x1> set = this.b;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            for (x1 a : set) {
                if (a.a() == h1.SESSION_START) {
                    z = true;
                    continue;
                } else {
                    z = false;
                    continue;
                }
                if (z) {
                    return true;
                }
            }
        }
        return false;
    }

    public final Set b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k) && Intrinsics.areEqual((Object) this.b, (Object) ((k) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public boolean isEmpty() {
        return this.c;
    }

    public String toString() {
        return "BrazeEventContainer(eventsList=" + this.b + ')';
    }
}
