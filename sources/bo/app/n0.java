package bo.app;

import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

public final class n0 {
    public static final a e = new a((DefaultConstructorMarker) null);
    public final b a;
    public final x1 b;
    public final p5 c;
    public final a2 d;

    public static final class a {

        /* renamed from: bo.app.n0$a$a  reason: collision with other inner class name */
        static final class C0018a extends Lambda implements Function0 {
            public static final C0018a b = new C0018a();

            C0018a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "There should be a session ID here";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final n0 a(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            return new n0(b.ADD_BRAZE_EVENT, x1Var, (p5) null, (a2) null, 12, (DefaultConstructorMarker) null);
        }

        public final n0 b(x1 x1Var) {
            Intrinsics.checkNotNullParameter(x1Var, "event");
            return new n0(b.ADD_PENDING_BRAZE_EVENT, x1Var, (p5) null, (a2) null, 12, (DefaultConstructorMarker) null);
        }

        private a() {
        }

        public final n0 a(p5 p5Var) {
            if (p5Var == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) C0018a.b, 3, (Object) null);
            }
            return new n0(b.FLUSH_PENDING_BRAZE_EVENTS, (x1) null, p5Var, (a2) null, 10, (DefaultConstructorMarker) null);
        }

        public final n0 a(a2 a2Var) {
            Intrinsics.checkNotNullParameter(a2Var, "request");
            return new n0(b.ADD_REQUEST, (x1) null, (p5) null, a2Var, 6, (DefaultConstructorMarker) null);
        }
    }

    public enum b {
        ADD_PENDING_BRAZE_EVENT,
        ADD_BRAZE_EVENT,
        FLUSH_PENDING_BRAZE_EVENTS,
        ADD_REQUEST
    }

    private n0(b bVar, x1 x1Var, p5 p5Var, a2 a2Var) {
        this.a = bVar;
        this.b = x1Var;
        this.c = p5Var;
        this.d = a2Var;
    }

    public final b a() {
        return this.a;
    }

    public final x1 b() {
        return this.b;
    }

    public final p5 c() {
        return this.c;
    }

    public final a2 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n0)) {
            return false;
        }
        n0 n0Var = (n0) obj;
        return this.a == n0Var.a && Intrinsics.areEqual((Object) this.b, (Object) n0Var.b) && Intrinsics.areEqual((Object) this.c, (Object) n0Var.c) && Intrinsics.areEqual((Object) this.d, (Object) n0Var.d);
    }

    public int hashCode() {
        int hashCode = this.a.hashCode() * 31;
        x1 x1Var = this.b;
        int i = 0;
        int hashCode2 = (hashCode + (x1Var == null ? 0 : x1Var.hashCode())) * 31;
        p5 p5Var = this.c;
        int hashCode3 = (hashCode2 + (p5Var == null ? 0 : p5Var.hashCode())) * 31;
        a2 a2Var = this.d;
        if (a2Var != null) {
            i = a2Var.hashCode();
        }
        return hashCode3 + i;
    }

    public String toString() {
        return StringsKt.trimIndent("\n            commandType = " + this.a + "\n            brazeEvent = " + this.b + "\n            sessionId = " + this.c + "\n            brazeRequest = " + this.d + "\n        ");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ n0(b bVar, x1 x1Var, p5 p5Var, a2 a2Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(bVar, (i & 2) != 0 ? null : x1Var, (i & 4) != 0 ? null : p5Var, (i & 8) != 0 ? null : a2Var);
    }
}
