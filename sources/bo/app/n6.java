package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import com.braze.support.StringUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import org.json.JSONObject;

public final class n6 implements v2 {
    public static final a p = new a((DefaultConstructorMarker) null);
    private static final long q = TimeUnit.SECONDS.toMillis(30);
    /* access modifiers changed from: private */
    public static final String r = BrazeLogger.getBrazeLogTag((Class<?>) n6.class);
    /* access modifiers changed from: private */
    public final Context a;
    private final z1 b;
    /* access modifiers changed from: private */
    public final i2 c;
    private i2 d;
    private final long e;
    private final SharedPreferences f;
    private final s2 g;
    private final y2 h;
    private final AtomicInteger i;
    private final Queue j;
    private final Map k;
    private long l;
    private volatile long m;

    /* renamed from: n  reason: collision with root package name */
    private final ReentrantLock f17n = new ReentrantLock();
    private final ReentrantLock o = new ReentrantLock();

    public static final class a {

        /* renamed from: bo.app.n6$a$a  reason: collision with other inner class name */
        static final class C0019a extends Lambda implements Function0 {
            public static final C0019a b = new C0019a();

            C0019a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Ignoring minimum time interval between triggered actions because the trigger event is a test.";
            }
        }

        static final class b extends Lambda implements Function0 {
            final /* synthetic */ int b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(int i) {
                super(0);
                this.b = i;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Using override minimum display interval: " + this.b;
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ long b;
            final /* synthetic */ long c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(long j, long j2) {
                super(0);
                this.b = j;
                this.c = j2;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Minimum time interval requirement met for matched trigger. Action display time: " + this.b + " . Next viable display time: " + this.c;
            }
        }

        static final class d extends Lambda implements Function0 {
            final /* synthetic */ long b;
            final /* synthetic */ long c;
            final /* synthetic */ long d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(long j, long j2, long j3) {
                super(0);
                this.b = j;
                this.c = j2;
                this.d = j3;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Minimum time interval requirement and triggered action override time interval requirement of " + this.b + " not met for matched trigger. Returning null. Next viable display time: " + this.c + ". Action display time: " + this.d;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(u2 u2Var, z2 z2Var, long j, long j2) {
            long j3;
            u2 u2Var2 = u2Var;
            Intrinsics.checkNotNullParameter(u2Var2, "triggerEvent");
            Intrinsics.checkNotNullParameter(z2Var, "action");
            if (u2Var2 instanceof d6) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, n6.r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) C0019a.b, 6, (Object) null);
                return true;
            }
            long nowInSeconds = DateTimeUtils.nowInSeconds() + ((long) z2Var.n().o());
            int r = z2Var.n().r();
            if (r != -1) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, n6.r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(r), 6, (Object) null);
                j3 = j + ((long) r);
            } else {
                j3 = j + j2;
            }
            long j4 = j3;
            if (nowInSeconds >= j4) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, n6.r, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(nowInSeconds, j4), 4, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, n6.r, BrazeLogger.Priority.I, (Throwable) null, (Function0) new d(j2, j4, nowInSeconds), 4, (Object) null);
            return false;
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "In flight trigger requests is empty. Executing any pending trigger events.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ u2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(u2 u2Var) {
            super(0);
            this.b = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "New incoming <" + this.b.d() + ">. Searching for matching triggers.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ u2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(u2 u2Var) {
            super(0);
            this.b = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "No action found for " + this.b.d() + " event, publishing NoMatchingTriggerEvent";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Found potential triggered action for incoming trigger event. Action id " + this.b.getId() + '.';
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ u2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(u2 u2Var) {
            super(0);
            this.b = u2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to match triggered action for incoming <" + this.b.d() + ">.";
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ u2 b;
        final /* synthetic */ Ref.ObjectRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(u2 u2Var, Ref.ObjectRef objectRef) {
            super(0);
            this.b = u2Var;
            this.c = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return StringsKt.trimIndent("\n     Found best triggered action for incoming trigger event " + (this.b.a() != null ? JsonUtils.getPrettyPrintedString((JSONObject) this.b.a().forJsonPut()) : "") + ".\n     Matched Action id: " + ((z2) this.c.element).getId() + ".\n                ");
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ long b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(long j) {
            super(0);
            this.b = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "TriggerManager lastDisplayTimeSeconds updated to " + this.b;
        }
    }

    static final class i extends SuspendLambda implements Function1 {
        int b;
        final /* synthetic */ z2 c;
        final /* synthetic */ n6 d;
        final /* synthetic */ u2 e;
        final /* synthetic */ long f;
        final /* synthetic */ long g;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ long b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(long j) {
                super(0);
                this.b = j;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Performing triggered action after a delay of " + this.b + " ms.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(z2 z2Var, n6 n6Var, u2 u2Var, long j, long j2, Continuation continuation) {
            super(1, continuation);
            this.c = z2Var;
            this.d = n6Var;
            this.e = u2Var;
            this.f = j;
            this.g = j2;
        }

        /* renamed from: a */
        public final Object invoke(Continuation continuation) {
            return ((i) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Continuation continuation) {
            return new i(this.c, this.d, this.e, this.f, this.g, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, n6.r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new a(this.g), 6, (Object) null);
                this.c.a(this.d.a, this.d.c, this.e, this.f);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger manager received reenqueue with action with id: <" + this.b.getId() + ">.";
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(List list) {
            super(0);
            this.b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering " + this.b.size() + " new triggered actions.";
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering triggered action id " + this.b.getId() + ' ';
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Test triggered actions found, triggering test event.";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "No test triggered actions found.";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received null or blank serialized triggered action string for action id " + this.b + " from shared preferences. Not parsing.";
        }
    }

    static final class p extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrieving templated triggered action id " + this.b.getId() + " from local storage.";
        }
    }

    static final class q extends Lambda implements Function0 {
        public static final q b = new q();

        q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Encountered unexpected exception while parsing stored triggered actions.";
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Trigger manager received failed triggered action with id: <" + this.b.getId() + ">. Will attempt to perform fallback triggered actions, if present.";
        }
    }

    static final class s extends Lambda implements Function0 {
        public static final s b = new s();

        s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action has no trigger metadata and cannot fallback. Doing nothing.";
        }
    }

    static final class t extends Lambda implements Function0 {
        public static final t b = new t();

        t() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Triggered action has no fallback action to perform. Doing nothing.";
        }
    }

    static final class u extends Lambda implements Function0 {
        final /* synthetic */ z2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(z2 z2Var) {
            super(0);
            this.b = z2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Fallback trigger has expired. Trigger id: " + this.b.getId();
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ z2 b;
        final /* synthetic */ long c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(z2 z2Var, long j) {
            super(0);
            this.b = z2Var;
            this.c = j;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Performing fallback triggered action with id: <" + this.b.getId() + "> with a delay: " + this.c + " ms";
        }
    }

    static final class w extends SuspendLambda implements Function1 {
        int b;
        final /* synthetic */ z2 c;
        final /* synthetic */ n6 d;
        final /* synthetic */ u2 e;
        final /* synthetic */ long f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(z2 z2Var, n6 n6Var, u2 u2Var, long j, Continuation continuation) {
            super(1, continuation);
            this.c = z2Var;
            this.d = n6Var;
            this.e = u2Var;
            this.f = j;
        }

        /* renamed from: a */
        public final Object invoke(Continuation continuation) {
            return ((w) create(continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Continuation continuation) {
            return new w(this.c, this.d, this.e, this.f, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                this.c.a(this.d.a, this.d.c, this.e, this.f);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static final class x extends Lambda implements Function0 {
        public static final x b = new x();

        x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Subscribing to trigger dispatch events.";
        }
    }

    public n6(Context context, z1 z1Var, i2 i2Var, i2 i2Var2, BrazeConfigurationProvider brazeConfigurationProvider, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(str2, DynamicLink.Builder.KEY_API_KEY);
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.a = applicationContext;
        this.b = z1Var;
        this.c = i2Var;
        this.d = i2Var2;
        this.e = brazeConfigurationProvider.getTriggerActionMinimumTimeIntervalInSeconds();
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.appboy.storage.triggers.actions" + StringUtils.getCacheFileSuffix(context, str, str2), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…xt.MODE_PRIVATE\n        )");
        this.f = sharedPreferences;
        this.g = new f6(context, str2);
        this.h = new q6(context, str, str2);
        this.k = e();
        this.i = new AtomicInteger(0);
        this.j = new ArrayDeque();
        f();
    }

    private final void f() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, BrazeLogger.Priority.V, (Throwable) null, (Function0) x.b, 4, (Object) null);
        this.c.c(i6.class, new n6$$ExternalSyntheticLambda0(this));
        this.c.c(h6.class, new n6$$ExternalSyntheticLambda1(this));
    }

    public long c() {
        return this.m;
    }

    public y2 d() {
        return this.h;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0049 A[Catch:{ Exception -> 0x0082 }] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005b A[Catch:{ Exception -> 0x0082 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.Map e() {
        /*
            r14 = this;
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            android.content.SharedPreferences r1 = r14.f
            java.util.Map r1 = r1.getAll()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0018
            boolean r4 = r1.isEmpty()
            if (r4 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r4 = r2
            goto L_0x0019
        L_0x0018:
            r4 = r3
        L_0x0019:
            if (r4 == 0) goto L_0x001c
            return r0
        L_0x001c:
            java.util.Set r1 = r1.keySet()
            java.util.Set r1 = kotlin.collections.CollectionsKt.toSet(r1)
            java.util.Iterator r1 = r1.iterator()     // Catch:{ Exception -> 0x0082 }
        L_0x0028:
            boolean r4 = r1.hasNext()     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x008e
            java.lang.Object r4 = r1.next()     // Catch:{ Exception -> 0x0082 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x0082 }
            android.content.SharedPreferences r5 = r14.f     // Catch:{ Exception -> 0x0082 }
            r6 = 0
            java.lang.String r5 = r5.getString(r4, r6)     // Catch:{ Exception -> 0x0082 }
            if (r5 == 0) goto L_0x0046
            boolean r6 = kotlin.text.StringsKt.isBlank(r5)     // Catch:{ Exception -> 0x0082 }
            if (r6 == 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r6 = r2
            goto L_0x0047
        L_0x0046:
            r6 = r3
        L_0x0047:
            if (r6 == 0) goto L_0x005b
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0082 }
            java.lang.String r8 = r     // Catch:{ Exception -> 0x0082 }
            com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ Exception -> 0x0082 }
            r10 = 0
            bo.app.n6$o r11 = new bo.app.n6$o     // Catch:{ Exception -> 0x0082 }
            r11.<init>(r4)     // Catch:{ Exception -> 0x0082 }
            r12 = 4
            r13 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0028
        L_0x005b:
            bo.app.p6 r4 = bo.app.p6.a     // Catch:{ Exception -> 0x0082 }
            org.json.JSONObject r6 = new org.json.JSONObject     // Catch:{ Exception -> 0x0082 }
            r6.<init>((java.lang.String) r5)     // Catch:{ Exception -> 0x0082 }
            bo.app.z1 r5 = r14.b     // Catch:{ Exception -> 0x0082 }
            bo.app.z2 r4 = r4.b(r6, r5)     // Catch:{ Exception -> 0x0082 }
            if (r4 == 0) goto L_0x0028
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0082 }
            java.lang.String r6 = r     // Catch:{ Exception -> 0x0082 }
            r7 = 0
            r8 = 0
            bo.app.n6$p r9 = new bo.app.n6$p     // Catch:{ Exception -> 0x0082 }
            r9.<init>(r4)     // Catch:{ Exception -> 0x0082 }
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)     // Catch:{ Exception -> 0x0082 }
            java.lang.String r5 = r4.getId()     // Catch:{ Exception -> 0x0082 }
            r0.put(r5, r4)     // Catch:{ Exception -> 0x0082 }
            goto L_0x0028
        L_0x0082:
            r1 = move-exception
            com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r3 = r
            com.braze.support.BrazeLogger$Priority r4 = com.braze.support.BrazeLogger.Priority.E
            bo.app.n6$q r5 = bo.app.n6.q.b
            r2.brazelog((java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r1, (kotlin.jvm.functions.Function0<java.lang.String>) r5)
        L_0x008e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.n6.e():java.util.Map");
    }

    public final void b(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(u2Var), 6, (Object) null);
        z2 c2 = c(u2Var);
        if (c2 != null) {
            b(u2Var, c2);
            return;
        }
        String d2 = u2Var.d();
        if (d2 != null) {
            int hashCode = d2.hashCode();
            if (hashCode != 3417674) {
                if (hashCode != 717572172) {
                    if (hashCode != 1743324417 || !d2.equals(FirebaseAnalytics.Event.PURCHASE)) {
                        return;
                    }
                } else if (!d2.equals("custom_event")) {
                    return;
                }
            } else if (!d2.equals(TtmlNode.TEXT_EMPHASIS_MARK_OPEN)) {
                return;
            }
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new d(u2Var), 3, (Object) null);
            i2 i2Var = this.d;
            String d3 = u2Var.d();
            Intrinsics.checkNotNullExpressionValue(d3, "triggerEvent.triggerEventType");
            i2Var.a((Object) new NoMatchingTriggerEvent(d3), NoMatchingTriggerEvent.class);
        }
    }

    /* JADX INFO: finally extract failed */
    public final z2 c(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "event");
        ReentrantLock reentrantLock = this.f17n;
        reentrantLock.lock();
        try {
            Ref.ObjectRef objectRef = new Ref.ObjectRef();
            int i2 = Integer.MIN_VALUE;
            ArrayList arrayList = new ArrayList();
            for (T t2 : this.k.values()) {
                if (t2.b(u2Var) && d().b(t2)) {
                    if (p.a(u2Var, t2, c(), this.e)) {
                        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new e(t2), 6, (Object) null);
                        int j2 = t2.n().j();
                        if (j2 > i2) {
                            objectRef.element = t2;
                            i2 = j2;
                        }
                        arrayList.add(t2);
                    }
                }
            }
            T t3 = objectRef.element;
            if (t3 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(u2Var), 6, (Object) null);
                reentrantLock.unlock();
                return null;
            }
            arrayList.remove(t3);
            ((z2) objectRef.element).a(new o6(arrayList));
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new g(u2Var, objectRef), 6, (Object) null);
            z2 z2Var = (z2) objectRef.element;
            reentrantLock.unlock();
            return z2Var;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(z2 z2Var) {
        Intrinsics.checkNotNullParameter(z2Var, "action");
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new j(z2Var), 6, (Object) null);
        a(this.l);
        this.l = 0;
        d().c(z2Var);
    }

    public void a(long j2) {
        this.l = this.m;
        this.m = j2;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new h(j2), 3, (Object) null);
    }

    /* JADX INFO: finally extract failed */
    public void a(List list) {
        List list2 = list;
        Intrinsics.checkNotNullParameter(list2, "triggeredActions");
        d6 d6Var = new d6();
        ReentrantLock reentrantLock = this.f17n;
        reentrantLock.lock();
        try {
            this.k.clear();
            SharedPreferences.Editor clear = this.f.edit().clear();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new k(list2), 6, (Object) null);
            Iterator it = list.iterator();
            boolean z = false;
            while (it.hasNext()) {
                z2 z2Var = (z2) it.next();
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new l(z2Var), 6, (Object) null);
                this.k.put(z2Var.getId(), z2Var);
                clear.putString(z2Var.getId(), String.valueOf(z2Var.forJsonPut()));
                if (z2Var.b(d6Var)) {
                    z = true;
                }
            }
            clear.apply();
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            d().a(list2);
            this.g.a(list2);
            if (z) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, BrazeLogger.Priority.I, (Throwable) null, (Function0) m.b, 4, (Object) null);
                a((u2) d6Var);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) n.b, 6, (Object) null);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void b() {
        ReentrantLock reentrantLock = this.o;
        reentrantLock.lock();
        try {
            if (this.i.get() <= 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, r, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 6, (Object) null);
                while (!this.j.isEmpty()) {
                    u2 u2Var = (u2) this.j.poll();
                    if (u2Var != null) {
                        Intrinsics.checkNotNullExpressionValue(u2Var, "poll()");
                        b(u2Var);
                    }
                }
                Unit unit = Unit.INSTANCE;
                reentrantLock.unlock();
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void b(u2 u2Var, z2 z2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "event");
        Intrinsics.checkNotNullParameter(z2Var, "action");
        z2Var.a(this.g.a(z2Var));
        q2 n2 = z2Var.n();
        long e2 = n2.k() != -1 ? u2Var.e() + ((long) n2.k()) : -1;
        long millis = TimeUnit.SECONDS.toMillis((long) n2.o());
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(millis), (CoroutineContext) null, new i(z2Var, this, u2Var, e2, millis, (Continuation) null), 2, (Object) null);
    }

    public void a(u2 u2Var) {
        Intrinsics.checkNotNullParameter(u2Var, "triggerEvent");
        ReentrantLock reentrantLock = this.o;
        reentrantLock.lock();
        try {
            this.j.add(u2Var);
            if (this.i.get() == 0) {
                b();
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void a(u2 u2Var, z2 z2Var) {
        long j2;
        u2 u2Var2 = u2Var;
        z2 z2Var2 = z2Var;
        Intrinsics.checkNotNullParameter(u2Var2, "triggerEvent");
        Intrinsics.checkNotNullParameter(z2Var2, "failedAction");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str = r;
        BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new r(z2Var2), 6, (Object) null);
        o6 c2 = z2Var.c();
        if (c2 == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) s.b, 6, (Object) null);
            return;
        }
        z2 a2 = c2.a();
        if (a2 == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) t.b, 6, (Object) null);
            return;
        }
        a2.a(c2);
        a2.a(this.g.a(a2));
        long e2 = u2Var.e();
        q2 n2 = a2.n();
        long k2 = (long) n2.k();
        long millis = TimeUnit.SECONDS.toMillis((long) n2.o());
        if (k2 != -1) {
            j2 = k2 + e2;
        } else {
            j2 = e2 + millis + q;
        }
        long j3 = j2;
        if (j3 < DateTimeUtils.nowInMilliseconds()) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new u(a2), 6, (Object) null);
            a(u2Var2, a2);
            return;
        }
        long max = Math.max(0, (millis + e2) - DateTimeUtils.nowInMilliseconds());
        BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new v(a2, max), 6, (Object) null);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(max), (CoroutineContext) null, new w(a2, this, u2Var, j3, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void a(n6 n6Var, i6 i6Var) {
        Intrinsics.checkNotNullParameter(n6Var, "this$0");
        Intrinsics.checkNotNullParameter(i6Var, "it");
        n6Var.i.incrementAndGet();
    }

    /* access modifiers changed from: private */
    public static final void a(n6 n6Var, h6 h6Var) {
        Intrinsics.checkNotNullParameter(n6Var, "this$0");
        Intrinsics.checkNotNullParameter(h6Var, "it");
        n6Var.i.decrementAndGet();
        n6Var.b();
    }
}
