package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.Constants;
import com.braze.support.BrazeLogger;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Collection;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.json.JSONArray;

public final class l5 {
    public static final b e = new b((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final int f = ((int) TimeUnit.SECONDS.toMillis(10));
    /* access modifiers changed from: private */
    public static final int g = ((int) TimeUnit.MINUTES.toMillis(5));
    private final SharedPreferences a;
    private final ReentrantLock b = new ReentrantLock();
    private final Mutex c = MutexKt.Mutex$default(false, 1, (Object) null);
    private j5 d;

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Detected SDK update from '" + this.b + "' -> '" + this.c + "'. Clearing config update time.";
        }
    }

    public static final class b {
        public /* synthetic */ b(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final int a() {
            return l5.g;
        }

        public final int b() {
            return l5.f;
        }

        private b() {
        }

        public final String a(String str) {
            Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
            return "com.braze.storage.server_config." + str;
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not allowing server config info unlock. Returning null.";
        }
    }

    public static final class d extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Boolean a(int i) {
            return Boolean.valueOf(this.b.opt(i) instanceof String);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    public static final class e extends Lambda implements Function1 {
        final /* synthetic */ JSONArray b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(JSONArray jSONArray) {
            super(1);
            this.b = jSONArray;
        }

        public final Object a(int i) {
            Object obj = this.b.get(i);
            if (obj != null) {
                return (String) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return a(((Number) obj).intValue());
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced exception retrieving blocklisted strings from local storage. Returning null.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to unlock server config info.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unlocking config info lock.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not persist server config to shared preferences.";
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ j5 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(j5 j5Var) {
            super(0);
            this.b = j5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Finishing updating server config to " + this.b;
        }
    }

    public l5(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        SharedPreferences sharedPreferences = context.getSharedPreferences(e.a(str), 0);
        this.a = sharedPreferences;
        String string = sharedPreferences.getString("last_accessed_sdk_version", "");
        if (!Intrinsics.areEqual((Object) Constants.BRAZE_SDK_VERSION, (Object) string)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(string, Constants.BRAZE_SDK_VERSION), 2, (Object) null);
            sharedPreferences.edit().putLong("config_time", 0).putString("last_accessed_sdk_version", Constants.BRAZE_SDK_VERSION).apply();
        }
        F();
    }

    private final void F() {
        j5 j5Var = new j5(0, (Set) null, (Set) null, (Set) null, 0, 0, 0, false, false, false, 0, false, false, 0, false, 0, 0, false, 0, false, 0, 0, false, 0, 0, 0, 0, 134217727, (DefaultConstructorMarker) null);
        j5Var.a(d());
        j5Var.b(e());
        j5Var.c(f());
        j5Var.a(g());
        j5Var.b(q());
        j5Var.k(s());
        j5Var.j(r());
        j5Var.i(p());
        j5Var.f(B());
        j5Var.g(C());
        j5Var.b(x());
        j5Var.d(z());
        j5Var.e(A());
        j5Var.f(m());
        j5Var.a(w());
        j5Var.a(h());
        j5Var.b(i());
        j5Var.i(E());
        j5Var.c(t());
        j5Var.c(y());
        j5Var.h(D());
        j5Var.h(o());
        j5Var.g(n());
        j5Var.d(u());
        j5Var.e(l());
        j5Var.d(k());
        j5Var.c(j());
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            this.d = j5Var;
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean A() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.l();
            } else {
                z = this.a.getBoolean("feature_flags_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean B() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.n();
            } else {
                z = this.a.getBoolean("geofences_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean C() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.o();
            } else {
                z = this.a.getBoolean("geofences_enabled_set", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean D() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.r();
            } else {
                z = this.a.getBoolean("global_req_rate_limit_enabled", true);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean E() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.w();
            } else {
                z = this.a.getBoolean("push_max_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void G() {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) g.b, 2, (Object) null);
        if (this.c.isLocked()) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
            Mutex.DefaultImpls.unlock$default(this.c, (Object) null, 1, (Object) null);
        }
    }

    public final Pair c() {
        if (Mutex.DefaultImpls.tryLock$default(this.c, (Object) null, 1, (Object) null)) {
            return new Pair(Long.valueOf(g()), Boolean.valueOf(v()));
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) c.b, 2, (Object) null);
        return null;
    }

    public final Set d() {
        Set set;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var == null || (set = j5Var.a()) == null) {
                set = a("blacklisted_attributes");
            }
            return set;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set e() {
        Set set;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var == null || (set = j5Var.b()) == null) {
                set = a("blacklisted_events");
            }
            return set;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final Set f() {
        Set set;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var == null || (set = j5Var.c()) == null) {
                set = a("blacklisted_purchases");
            }
            return set;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long g() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            return j5Var != null ? j5Var.d() : this.a.getLong("config_time", 0);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int h() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.e();
            } else {
                i2 = this.a.getInt("content_cards_rate_capacity", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int i() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.f();
            } else {
                i2 = this.a.getInt("content_cards_rate_refill_rate", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int j() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.h();
            } else {
                i2 = this.a.getInt("default_backoff_max_sleep_duration_ms", g);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int k() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.i();
            } else {
                i2 = this.a.getInt("default_backoff_min_sleep_duration__ms", f);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int l() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.j();
            } else {
                i2 = this.a.getInt("default_backoff_scale_factor", 3);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int m() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.m();
            } else {
                i2 = this.a.getInt("feature_flags_refresh_rate_limit", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int n() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.p();
            } else {
                i2 = this.a.getInt("global_req_rate_capacity", 30);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int o() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.q();
            } else {
                i2 = this.a.getInt("global_req_rate_refill_rate", 30);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int p() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.s();
            } else {
                i2 = this.a.getInt("geofences_max_num_to_register", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long q() {
        long j2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                j2 = j5Var.t();
            } else {
                j2 = this.a.getLong("messaging_session_timeout", -1);
            }
            return j2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int r() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.u();
            } else {
                i2 = this.a.getInt("geofences_min_time_since_last_report", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final int s() {
        int i2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                i2 = j5Var.v();
            } else {
                i2 = this.a.getInt("geofences_min_time_since_last_request", -1);
            }
            return i2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long t() {
        long j2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                j2 = j5Var.x();
            } else {
                j2 = this.a.getLong("push_max_redeliver_buffer", 86400);
            }
            return j2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final long u() {
        long j2;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                j2 = j5Var.y();
            } else {
                j2 = this.a.getLong("push_max_redeliver_dedupe_buffer", -1);
            }
            return j2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean v() {
        return g() <= 0;
    }

    public final boolean w() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.g();
            } else {
                z = this.a.getBoolean("content_cards_rate_limit_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean x() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.z();
            } else {
                z = this.a.getBoolean("content_cards_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean y() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.A();
            } else {
                z = this.a.getBoolean("dust_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final boolean z() {
        boolean z;
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            j5 j5Var = this.d;
            if (j5Var != null) {
                z = j5Var.k();
            } else {
                z = this.a.getBoolean("ephemeral_events_enabled", false);
            }
            return z;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void a(j5 j5Var) {
        Intrinsics.checkNotNullParameter(j5Var, "serverConfig");
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            this.d = j5Var;
            Unit unit = Unit.INSTANCE;
            try {
                SharedPreferences.Editor edit = this.a.edit();
                if (j5Var.b() != null) {
                    edit.putString("blacklisted_events", new JSONArray((Collection<?>) j5Var.b()).toString());
                }
                if (j5Var.a() != null) {
                    edit.putString("blacklisted_attributes", new JSONArray((Collection<?>) j5Var.a()).toString());
                }
                if (j5Var.c() != null) {
                    edit.putString("blacklisted_purchases", new JSONArray((Collection<?>) j5Var.c()).toString());
                }
                edit.putLong("config_time", j5Var.d()).putInt("geofences_min_time_since_last_request", j5Var.v()).putInt("geofences_min_time_since_last_report", j5Var.u()).putInt("geofences_max_num_to_register", j5Var.s()).putBoolean("geofences_enabled", j5Var.n()).putBoolean("geofences_enabled_set", j5Var.o()).putLong("messaging_session_timeout", j5Var.t()).putBoolean("ephemeral_events_enabled", j5Var.k()).putBoolean("feature_flags_enabled", j5Var.l()).putInt("feature_flags_refresh_rate_limit", j5Var.m()).putBoolean("content_cards_enabled", j5Var.z()).putBoolean("content_cards_rate_limit_enabled", j5Var.g()).putInt("content_cards_rate_capacity", j5Var.e()).putInt("content_cards_rate_refill_rate", j5Var.f()).putBoolean("push_max_enabled", j5Var.w()).putLong("push_max_redeliver_buffer", j5Var.x()).putBoolean("dust_enabled", j5Var.A()).putBoolean("global_req_rate_limit_enabled", j5Var.r()).putInt("global_req_rate_capacity", j5Var.p()).putInt("global_req_rate_refill_rate", j5Var.q()).putLong("push_max_redeliver_dedupe_buffer", j5Var.y()).putInt("default_backoff_scale_factor", j5Var.j()).putInt("default_backoff_min_sleep_duration__ms", j5Var.i()).putInt("default_backoff_max_sleep_duration_ms", j5Var.h());
                edit.apply();
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) i.b);
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new j(j5Var), 2, (Object) null);
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001c A[Catch:{ Exception -> 0x0053 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Set a(java.lang.String r4) {
        /*
            r3 = this;
            android.content.SharedPreferences r0 = r3.a     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = ""
            java.lang.String r4 = r0.getString(r4, r1)     // Catch:{ Exception -> 0x0053 }
            java.util.HashSet r0 = new java.util.HashSet     // Catch:{ Exception -> 0x0053 }
            r0.<init>()     // Catch:{ Exception -> 0x0053 }
            r1 = 0
            if (r4 == 0) goto L_0x0019
            boolean r2 = kotlin.text.StringsKt.isBlank(r4)     // Catch:{ Exception -> 0x0053 }
            if (r2 == 0) goto L_0x0017
            goto L_0x0019
        L_0x0017:
            r2 = r1
            goto L_0x001a
        L_0x0019:
            r2 = 1
        L_0x001a:
            if (r2 != 0) goto L_0x0062
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x0053 }
            r2.<init>((java.lang.String) r4)     // Catch:{ Exception -> 0x0053 }
            int r4 = r2.length()     // Catch:{ Exception -> 0x0053 }
            kotlin.ranges.IntRange r4 = kotlin.ranges.RangesKt.until((int) r1, (int) r4)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt.asSequence(r4)     // Catch:{ Exception -> 0x0053 }
            bo.app.l5$d r1 = new bo.app.l5$d     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.filter(r4, r1)     // Catch:{ Exception -> 0x0053 }
            bo.app.l5$e r1 = new bo.app.l5$e     // Catch:{ Exception -> 0x0053 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0053 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt.map(r4, r1)     // Catch:{ Exception -> 0x0053 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0053 }
        L_0x0043:
            boolean r1 = r4.hasNext()     // Catch:{ Exception -> 0x0053 }
            if (r1 == 0) goto L_0x0062
            java.lang.Object r1 = r4.next()     // Catch:{ Exception -> 0x0053 }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x0053 }
            r0.add(r1)     // Catch:{ Exception -> 0x0053 }
            goto L_0x0043
        L_0x0053:
            r4 = move-exception
            com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.support.BrazeLogger$Priority r1 = com.braze.support.BrazeLogger.Priority.E
            bo.app.l5$f r2 = bo.app.l5.f.b
            r0.brazelog((java.lang.Object) r3, (com.braze.support.BrazeLogger.Priority) r1, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0<java.lang.String>) r2)
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
        L_0x0062:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.l5.a(java.lang.String):java.util.Set");
    }
}
