package bo.app;

import com.braze.support.BrazeLogger;
import io.sentry.cache.EnvelopeCache;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class b1 implements r2 {
    private final r2 a;
    private final i2 b;

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to delete the sealed session from the storage.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Error occured while publishing exception.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get the active session from the storage.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to upsert active session in the storage.";
        }
    }

    public b1(r2 r2Var, i2 i2Var) {
        Intrinsics.checkNotNullParameter(r2Var, "sessionStorageManager");
        Intrinsics.checkNotNullParameter(i2Var, "eventPublisher");
        this.a = r2Var;
        this.b = i2Var;
    }

    public n5 a() {
        try {
            return this.a.a();
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) c.b);
            a(this.b, e);
            return null;
        }
    }

    public void a(n5 n5Var) {
        Intrinsics.checkNotNullParameter(n5Var, EnvelopeCache.PREFIX_CURRENT_SESSION_FILE);
        try {
            this.a.a(n5Var);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) d.b);
            a(this.b, e);
        }
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "sessionId");
        try {
            this.a.a(str);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) a.b);
            a(this.b, e);
        }
    }

    public final void a(i2 i2Var, Throwable th) {
        Intrinsics.checkNotNullParameter(i2Var, "eventPublisher");
        Intrinsics.checkNotNullParameter(th, "throwable");
        try {
            i2Var.a((Object) new w5("A storage exception has occurred. Please view the stack trace for more details.", th), w5.class);
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) b.b);
        }
    }
}
