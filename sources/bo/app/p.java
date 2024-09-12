package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class p {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final i2 a;
    private final l5 b;
    public final SharedPreferences c;
    public boolean d;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ long b;
        final /* synthetic */ long c;
        final /* synthetic */ long d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(long j, long j2, long j3) {
            super(0);
            this.b = j;
            this.c = j2;
            this.d = j3;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Messaging session timeout: " + this.b + ", current diff: " + (this.c - this.d);
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Publishing new messaging session event.";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Messaging session not started.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Messaging session stopped. Adding new messaging session timestamp: " + this.b;
        }
    }

    public p(Context context, i2 i2Var, l5 l5Var) {
        Intrinsics.checkNotNullParameter(context, "applicationContext");
        Intrinsics.checkNotNullParameter(i2Var, "eventPublisher");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        this.a = i2Var;
        this.b = l5Var;
        this.c = context.getSharedPreferences("com.appboy.storage.sessions.messaging_session", 0);
    }

    public final boolean a() {
        long q = this.b.q();
        if (q == -1 || this.d) {
            return false;
        }
        long j = this.c.getLong("messaging_session_timestamp", -1);
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(q, nowInSeconds, j), 3, (Object) null);
        if (j + q < nowInSeconds) {
            return true;
        }
        return false;
    }

    public final void b() {
        if (a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
            this.a.a((Object) m3.b, m3.class);
            this.d = true;
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
    }

    public final void c() {
        long nowInSeconds = DateTimeUtils.nowInSeconds();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(nowInSeconds), 3, (Object) null);
        this.c.edit().putLong("messaging_session_timestamp", nowInSeconds).apply();
        this.d = false;
    }
}
