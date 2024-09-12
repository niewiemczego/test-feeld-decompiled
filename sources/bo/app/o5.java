package bo.app;

import io.sentry.cache.EnvelopeCache;
import kotlin.jvm.internal.Intrinsics;

public final class o5 {
    private final n5 a;

    public o5(n5 n5Var) {
        Intrinsics.checkNotNullParameter(n5Var, EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        this.a = n5Var;
        if (!(!n5Var.y())) {
            throw new IllegalArgumentException("Session created events cannot be created with already sealed sessions.".toString());
        }
    }

    public final n5 a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof o5) && Intrinsics.areEqual((Object) this.a, (Object) ((o5) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    public String toString() {
        return "SessionCreatedEvent(session=" + this.a + ')';
    }
}
