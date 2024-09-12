package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.BrazeNetworkFailureEvent;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.FeedUpdatedEvent;
import com.braze.events.NoMatchingTriggerEvent;
import com.braze.models.inappmessage.IInAppMessage;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import org.json.JSONArray;
import org.json.JSONObject;

public final class s {
    public static final a l = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String m = BrazeLogger.getBrazeLogTag((Class<?>) s.class);
    /* access modifiers changed from: private */
    public final a2 a;
    private final j2 b;
    /* access modifiers changed from: private */
    public final i2 c;
    /* access modifiers changed from: private */
    public final i2 d;
    /* access modifiers changed from: private */
    public final p1 e;
    /* access modifiers changed from: private */
    public final z1 f;
    /* access modifiers changed from: private */
    public final l5 g;
    /* access modifiers changed from: private */
    public final a0 h;
    private final y0 i;
    private final g0 j;
    private final Map k;

    public static final class a {

        /* renamed from: bo.app.s$a$a  reason: collision with other inner class name */
        static final class C0022a extends Lambda implements Function0 {
            final /* synthetic */ Object b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0022a(Object obj) {
                super(0);
                this.b = obj;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Encountered exception while parsing server response for " + this.b;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final void a(Object obj, Function0 function0) {
            try {
                function0.invoke();
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog(obj, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) new C0022a(obj));
            }
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ b5 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(b5 b5Var) {
            super(0);
            this.b = b5Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not parse request parameters for POST request to " + this.b + ", cancelling request.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Exception b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Exception exc) {
            super(0);
            this.b = exc;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced network communication exception processing API response. Sending network error event. " + this.b.getMessage();
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Experienced exception processing API response. Failing task.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ z c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(s sVar, z zVar, String str) {
            super(0);
            this.b = sVar;
            this.c = zVar;
            this.d = str;
        }

        public final void a() {
            ContentCardsUpdatedEvent a = this.b.h.a(this.c, this.d);
            if (a != null) {
                this.b.d.a((Object) a, ContentCardsUpdatedEvent.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ JSONArray c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(s sVar, JSONArray jSONArray) {
            super(0);
            this.b = sVar;
            this.c = jSONArray;
        }

        public final void a() {
            this.b.c.a((Object) new k1(this.c), k1.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ JSONArray c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(s sVar, JSONArray jSONArray, String str) {
            super(0);
            this.b = sVar;
            this.c = jSONArray;
            this.d = str;
        }

        public final void a() {
            FeedUpdatedEvent a = this.b.e.a(this.c, this.d);
            if (a != null) {
                this.b.d.a((Object) a, FeedUpdatedEvent.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ List c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(s sVar, List list) {
            super(0);
            this.b = sVar;
            this.c = list;
        }

        public final void a() {
            this.b.c.a((Object) new t1(this.c), t1.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ j5 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(s sVar, j5 j5Var) {
            super(0);
            this.b = sVar;
            this.c = j5Var;
        }

        public final void a() {
            this.b.g.a(this.c);
            this.b.c.a((Object) new k5(this.c), k5.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class j extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ IInAppMessage c;
        final /* synthetic */ String d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(s sVar, IInAppMessage iInAppMessage, String str) {
            super(0);
            this.b = sVar;
            this.c = iInAppMessage;
            this.d = str;
        }

        public final void a() {
            if (this.b.a instanceof a6) {
                this.c.setExpirationTimestamp(((a6) this.b.a).t());
                this.b.c.a((Object) new d3(((a6) this.b.a).u(), ((a6) this.b.a).v(), this.c, this.d), d3.class);
            }
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ List c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(s sVar, List list) {
            super(0);
            this.b = sVar;
            this.c = list;
        }

        public final void a() {
            this.b.c.a((Object) new u6(this.c), u6.class);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.INSTANCE;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Processing server response payload for user with id: " + this.b;
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ p2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(p2 p2Var) {
            super(0);
            this.b = p2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received server error from request: " + this.b.a();
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ s b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(s sVar, int i) {
            super(0);
            this.b = sVar;
            this.c = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Retrying request: " + this.b.a + " after delay of " + this.c + " ms";
        }
    }

    static final class o extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ int c;
        final /* synthetic */ s d;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ s b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(s sVar) {
                super(0);
                this.b = sVar;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Adding retried request to dispatch: " + this.b.a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(int i, s sVar, Continuation continuation) {
            super(2, continuation);
            this.c = i;
            this.d = sVar;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((o) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new o(this.c, this.d, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.b = 1;
                if (DelayKt.delay((long) this.c, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, s.m, BrazeLogger.Priority.V, (Throwable) null, (Function0) new a(this.d), 4, (Object) null);
            this.d.f.a(this.d.a);
            return Unit.INSTANCE;
        }
    }

    static final class p extends Lambda implements Function0 {
        public static final p b = new p();

        p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Api response was null, failing task.";
        }
    }

    public s(a2 a2Var, j2 j2Var, i2 i2Var, i2 i2Var2, p1 p1Var, z1 z1Var, l5 l5Var, a0 a0Var, y0 y0Var, g0 g0Var) {
        Intrinsics.checkNotNullParameter(a2Var, "request");
        Intrinsics.checkNotNullParameter(j2Var, "httpConnector");
        Intrinsics.checkNotNullParameter(i2Var, "internalPublisher");
        Intrinsics.checkNotNullParameter(i2Var2, "externalPublisher");
        Intrinsics.checkNotNullParameter(p1Var, "feedStorageProvider");
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorage");
        Intrinsics.checkNotNullParameter(a0Var, "contentCardsStorage");
        Intrinsics.checkNotNullParameter(y0Var, "endpointMetadataProvider");
        Intrinsics.checkNotNullParameter(g0Var, "dataSyncPolicyProvider");
        this.a = a2Var;
        this.b = j2Var;
        this.c = i2Var;
        this.d = i2Var2;
        this.e = p1Var;
        this.f = z1Var;
        this.g = l5Var;
        this.h = a0Var;
        this.i = y0Var;
        this.j = g0Var;
        Map a2 = y4.a();
        this.k = a2;
        a2Var.a(a2);
    }

    public final d b() {
        try {
            this.a.a(Long.valueOf(DateTimeUtils.nowInSeconds()));
            b5 i2 = this.a.i();
            JSONObject e2 = this.a.e();
            if (e2 == null) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new b(i2), 2, (Object) null);
                return null;
            }
            this.k.put("X-Braze-Last-Req-Ms-Ago", String.valueOf(this.i.a(i2)));
            if (this.a instanceof h0) {
                if (!this.j.c()) {
                    this.k.put("X-Braze-Req-Attempt", "1");
                    return new d(this.b.a(i2, this.k, e2), this.a, this.f);
                }
            }
            this.k.put("X-Braze-Req-Attempt", String.valueOf(this.i.a(i2, this.a instanceof h0)));
            return new d(this.b.a(i2, this.k, e2), this.a, this.f);
        } catch (Exception e3) {
            if (e3 instanceof o3) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) new c(e3));
                this.c.a((Object) new z4(this.a), z4.class);
                this.d.a((Object) new BrazeNetworkFailureEvent(e3, this.a), BrazeNetworkFailureEvent.class);
            }
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e3, (Function0<String>) d.b);
            return null;
        }
    }

    public final void c() {
        d b2 = b();
        if (b2 != null) {
            a(b2);
            this.c.a((Object) new a5(this.a), a5.class);
            if (b2.c() instanceof e5) {
                this.c.a((Object) new o0(this.a), o0.class);
            } else {
                this.c.a((Object) new q0(this.a), q0.class);
            }
        } else {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) p.b, 2, (Object) null);
            p3 p3Var = new p3("An error occurred during request processing, resulting in no valid response being received. Check the error log for more details.", this.a);
            this.a.a(this.c, this.d, (p2) p3Var);
            this.c.a((Object) new o0(this.a), o0.class);
            a((p2) p3Var);
        }
        this.a.b(this.c);
    }

    public final void a(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "apiResponse");
        if (dVar.c() == null) {
            this.i.b(this.a.i(), this.a instanceof h0);
            this.a.a(this.c, this.d, dVar);
        } else {
            a(dVar.c());
            this.a.a(this.c, this.d, dVar.c());
        }
        b(dVar);
    }

    public final void a(p2 p2Var) {
        Intrinsics.checkNotNullParameter(p2Var, "responseError");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) new m(p2Var), 2, (Object) null);
        this.c.a((Object) new m5(p2Var), m5.class);
        if (this.a.a(p2Var)) {
            int a2 = this.a.m().a();
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new n(this, a2), 3, (Object) null);
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new o(a2, this, (Continuation) null), 3, (Object) null);
            return;
        }
        a2 a2Var = this.a;
        if (a2Var instanceof a6) {
            i2 i2Var = this.d;
            String d2 = ((a6) a2Var).u().d();
            Intrinsics.checkNotNullExpressionValue(d2, "request.triggerEvent.triggerEventType");
            i2Var.a((Object) new NoMatchingTriggerEvent(d2), NoMatchingTriggerEvent.class);
        }
    }

    private final void a(String str) {
        if (str != null) {
            this.c.a((Object) new u0(str), u0.class);
        }
    }

    private final void a(JSONArray jSONArray, String str) {
        if (jSONArray != null) {
            l.a(jSONArray, new g(this, jSONArray, str));
        }
    }

    private final void a(z zVar, String str) {
        if (zVar != null) {
            l.a(zVar, new e(this, zVar, str));
        }
    }

    private final void a(j5 j5Var) {
        if (j5Var != null) {
            l.a(j5Var, new i(this, j5Var));
        }
    }

    private final void a(List list) {
        if (list != null) {
            l.a(list, new h(this, list));
        }
    }

    private final void a(JSONArray jSONArray) {
        if (jSONArray != null) {
            l.a(jSONArray, new f(this, jSONArray));
        }
    }

    private final void a(IInAppMessage iInAppMessage, String str) {
        if (iInAppMessage != null) {
            l.a(iInAppMessage, new j(this, iInAppMessage, str));
        }
    }

    public final void b(d dVar) {
        Intrinsics.checkNotNullParameter(dVar, "apiResponse");
        String a2 = this.f.a();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new l(a2), 2, (Object) null);
        a(dVar.e(), a2);
        a(dVar.a(), a2);
        a(dVar.i());
        b(dVar.k());
        a(dVar.f());
        a(dVar.d());
        a(dVar.j(), a2);
        a(dVar.b());
    }

    private final void b(List list) {
        if (list != null) {
            l.a(list, new k(this, list));
        }
    }
}
