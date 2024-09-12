package bo.app;

import android.app.AlarmManager;
import android.content.Context;
import androidx.core.app.NotificationCompat;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.managers.BrazeGeofenceManager;
import com.braze.support.BrazeLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

public final class x6 implements a3 {
    private final com.braze.managers.a A;
    private final j1 B;
    private final p1 C;
    private final a0 D;
    private final o2 E;
    private final String a;
    private final String b;
    private final g5 c;
    private final y0 d;
    private final l5 e;
    public w6 f;
    public j0 g;
    private final e1 h;
    private final t0 i;
    private final f j;
    private final v5 k;
    private final b1 l;
    private final d1 m;

    /* renamed from: n  reason: collision with root package name */
    private final g0 f21n;
    private final t o;
    private final u5 p;
    private final f1 q;
    private final g1 r;
    private final n4 s;
    private final f5 t;
    private final p u;
    private final m4 v;
    private final h5 w;
    private final z1 x;
    private final n6 y;
    private final BrazeGeofenceManager z;

    static final class a extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ x6 d;

        /* renamed from: bo.app.x6$a$a  reason: collision with other inner class name */
        static final class C0024a extends Lambda implements Function0 {
            public static final C0024a b = new C0024a();

            C0024a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "User cache was locked, waiting.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "User cache notified. Continuing UserDependencyManager shutdown";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Device cache was locked, waiting.";
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Device cache notified. Continuing UserDependencyManager shutdown";
            }
        }

        static final class e extends Lambda implements Function0 {
            public static final e b = new e();

            e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while shutting down dispatch manager. Continuing.";
            }
        }

        static final class f extends Lambda implements Function0 {
            public static final f b = new f();

            f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Exception while stopping data sync. Continuing.";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(x6 x6Var, Continuation continuation) {
            super(2, continuation);
            this.d = x6Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            a aVar = new a(this.d, continuation);
            aVar.c = obj;
            return aVar;
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.b == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.c;
                try {
                    if (this.d.i().b()) {
                        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
                        BrazeLogger.brazelog$default(brazeLogger, (Object) coroutineScope, BrazeLogger.Priority.I, (Throwable) null, (Function0) C0024a.b, 2, (Object) null);
                        this.d.i().c();
                        BrazeLogger.brazelog$default(brazeLogger, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
                    }
                    if (this.d.j().b()) {
                        BrazeLogger brazeLogger2 = BrazeLogger.INSTANCE;
                        BrazeLogger.brazelog$default(brazeLogger2, (Object) coroutineScope, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
                        this.d.j().c();
                        BrazeLogger.brazelog$default(brazeLogger2, (Object) coroutineScope, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 3, (Object) null);
                    }
                    this.d.g().a((i2) this.d.e());
                } catch (Exception e2) {
                    BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.W, (Throwable) e2, (Function0<String>) e.b);
                }
                try {
                    this.d.k().g();
                } catch (Exception e3) {
                    BrazeLogger.INSTANCE.brazelog((Object) coroutineScope, BrazeLogger.Priority.W, (Throwable) e3, (Function0<String>) f.b);
                }
                this.d.e().a((Object) new w(), w.class);
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public x6(Context context, t3 t3Var, BrazeConfigurationProvider brazeConfigurationProvider, i2 i2Var, e2 e2Var, l2 l2Var, k4 k4Var, boolean z2, boolean z3, d2 d2Var) {
        Context context2 = context;
        Intrinsics.checkNotNullParameter(context2, "applicationContext");
        Intrinsics.checkNotNullParameter(t3Var, "offlineUserStorageProvider");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(i2Var, "externalEventPublisher");
        Intrinsics.checkNotNullParameter(e2Var, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(l2Var, "registrationDataProvider");
        Intrinsics.checkNotNullParameter(k4Var, "pushDeliveryManager");
        Intrinsics.checkNotNullParameter(d2Var, "deviceDataProvider");
        String a2 = t3Var.a();
        this.a = a2;
        String iVar = brazeConfigurationProvider.getBrazeApiKey().toString();
        this.b = iVar;
        g5 g5Var = new g5(context2);
        this.c = g5Var;
        y0 y0Var = new y0(context2);
        this.d = y0Var;
        this.e = new l5(context2, iVar);
        this.h = new e1(g5Var);
        t0 t0Var = r1;
        y0 y0Var2 = y0Var;
        g5 g5Var2 = g5Var;
        t0 t0Var2 = new t0(l(), e(), context, a2, iVar);
        this.i = t0Var;
        v5 v5Var = new v5(context2, a2, iVar);
        this.k = v5Var;
        b1 b1Var = new b1(v5Var, e());
        this.l = b1Var;
        this.f21n = new g0(context2, e(), new f0(context2), l());
        e1 e2 = e();
        Object systemService = context2.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.AlarmManager");
        Context context3 = context;
        i2 i2Var2 = i2Var;
        String str = iVar;
        String str2 = a2;
        this.o = new t(context3, b1Var, e2, i2Var2, (AlarmManager) systemService, brazeConfigurationProvider.getSessionTimeoutSeconds(), brazeConfigurationProvider.isSessionStartBasedTimeoutEnabled());
        u5 u5Var = new u5(context2, str2, str);
        this.p = u5Var;
        f1 f1Var = new f1(u5Var, e());
        this.q = f1Var;
        this.r = new g1(f1Var);
        this.s = new n4(context, str, str2, e(), l());
        this.t = new f5(context2, str2, str);
        this.u = new p(context2, e(), l());
        this.v = new m4(context2, str, str2);
        h5 h5Var = new h5(context2, str2, str);
        this.w = h5Var;
        t v2 = v();
        e1 e3 = e();
        l5 l2 = l();
        Context context4 = context;
        o oVar = r1;
        l5 l5Var = l2;
        h5 h5Var2 = h5Var;
        String str3 = str2;
        String str4 = str;
        o oVar2 = new o(context4, str2, str, v2, e3, brazeConfigurationProvider, l5Var, m(), z3, u(), g5Var2, n(), k4Var, d());
        this.x = oVar;
        this.y = new n6(context4, f(), e(), i2Var, brazeConfigurationProvider, str3, str4);
        String str5 = str4;
        this.z = new BrazeGeofenceManager(context4, str5, f(), brazeConfigurationProvider, l(), e());
        Context context5 = context;
        this.A = new com.braze.managers.a(context5, f(), brazeConfigurationProvider);
        this.B = new j1(context, str5, str3, e(), i2Var, l(), f());
        String str6 = str3;
        this.C = new p1(context5, str6, f());
        this.D = new a0(context, str6, str4, f(), (String) null, 16, (DefaultConstructorMarker) null);
        x4 x4Var = new x4(v1.a(), e(), i2Var, c(), l(), q(), f(), y0Var2, k());
        this.E = x4Var;
        if (Intrinsics.areEqual((Object) str6, (Object) "")) {
            Context context6 = context;
            a(new w6(context6, l2Var, g5Var2, (String) null, (String) null, 24, (DefaultConstructorMarker) null));
            a(new j0(context6, (String) null, (String) null, 6, (DefaultConstructorMarker) null));
        } else {
            a(new w6(context, l2Var, g5Var2, str6, str4));
            a(new j0(context5, str6, str4));
        }
        p0 p0Var = new p0(i(), d2Var, brazeConfigurationProvider, h(), h5Var2, j(), e2Var, e());
        k().a(z3);
        this.j = new f(brazeConfigurationProvider, e(), x4Var, p0Var, l(), z2);
        d1 d1Var = r1;
        d1 d1Var2 = new d1(context, o(), g(), f(), i(), j(), r(), r().d(), m(), p(), i2Var, brazeConfigurationProvider, q(), h5Var2, l(), s(), k4Var);
        this.m = d1Var;
    }

    public void a(w6 w6Var) {
        Intrinsics.checkNotNullParameter(w6Var, "<set-?>");
        this.f = w6Var;
    }

    public t0 b() {
        return this.i;
    }

    public p1 c() {
        return this.C;
    }

    public m4 d() {
        return this.v;
    }

    public e1 e() {
        return this.h;
    }

    public z1 f() {
        return this.x;
    }

    public f g() {
        return this.j;
    }

    public f5 h() {
        return this.t;
    }

    public w6 i() {
        w6 w6Var = this.f;
        if (w6Var != null) {
            return w6Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userCache");
        return null;
    }

    public j0 j() {
        j0 j0Var = this.g;
        if (j0Var != null) {
            return j0Var;
        }
        Intrinsics.throwUninitializedPropertyAccessException("deviceCache");
        return null;
    }

    public g0 k() {
        return this.f21n;
    }

    public l5 l() {
        return this.e;
    }

    public g1 m() {
        return this.r;
    }

    public n4 n() {
        return this.s;
    }

    public com.braze.managers.a o() {
        return this.A;
    }

    public BrazeGeofenceManager p() {
        return this.z;
    }

    public a0 q() {
        return this.D;
    }

    public n6 r() {
        return this.y;
    }

    public j1 s() {
        return this.B;
    }

    public d1 t() {
        return this.m;
    }

    public p u() {
        return this.u;
    }

    public t v() {
        return this.o;
    }

    public void a(j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "<set-?>");
        this.g = j0Var;
    }

    public void a() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new a(this, (Continuation) null), 3, (Object) null);
    }
}
