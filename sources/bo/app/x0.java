package bo.app;

import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class x0 implements o2 {
    private final i2 a;
    private boolean b;
    private final List c = new ArrayList();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Short circuiting execution of network request and immediately marking it as succeeded.";
        }
    }

    public x0(i2 i2Var, boolean z) {
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        this.a = i2Var;
        this.b = z;
    }

    private final void c(n2 n2Var) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a.b, 3, (Object) null);
        i2 i2Var = this.a;
        n2Var.a(i2Var, i2Var, (d) null);
        n2Var.b(this.a);
        if (n2Var instanceof a2) {
            this.a.a((Object) new q0((a2) n2Var), q0.class);
        }
    }

    public void a(n2 n2Var) {
        Intrinsics.checkNotNullParameter(n2Var, "request");
        c(n2Var);
    }

    public void b(n2 n2Var) {
        Intrinsics.checkNotNullParameter(n2Var, "request");
        c(n2Var);
    }
}
