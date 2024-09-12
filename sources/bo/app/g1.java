package bo.app;

import com.braze.support.BrazeLogger;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class g1 {
    private final y1 a;
    private boolean b;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage manager is closed. Not adding event: " + this.b;
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ Set b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Set set) {
            super(0);
            this.b = set;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage manager is closed. Not deleting events: " + this.b;
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Storage manager is closed. Not starting offline recovery.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Started offline event recovery task.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding event to dispatch from storage: " + this.b;
        }
    }

    public g1(y1 y1Var) {
        Intrinsics.checkNotNullParameter(y1Var, "brazeEventStorageProvider");
        this.a = y1Var;
    }

    public final void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        if (this.b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new a(x1Var), 2, (Object) null);
            return;
        }
        this.a.a(x1Var);
    }

    public final void a(Set set) {
        Intrinsics.checkNotNullParameter(set, "events");
        if (this.b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(set), 2, (Object) null);
            return;
        }
        this.a.a(set);
    }

    public final void a() {
        this.b = true;
        this.a.close();
    }

    public final void a(f2 f2Var) {
        Intrinsics.checkNotNullParameter(f2Var, "dispatchManager");
        if (this.b) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) c.b, 2, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
        for (x1 x1Var : CollectionsKt.filterNotNull(this.a.a())) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new e(x1Var), 2, (Object) null);
            f2Var.a(x1Var);
        }
    }
}
