package bo.app;

import com.braze.Braze;
import com.braze.Constants;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.NotificationSubscriptionType;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.JsonUtils;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;

public final class p0 implements f2 {
    public static final a l = new a((DefaultConstructorMarker) null);
    private final w6 a;
    private final d2 b;
    private final BrazeConfigurationProvider c;
    private final f5 d;
    private final h5 e;
    private final j0 f;
    private final e2 g;
    private final Channel h = ChannelKt.Channel$default(1000, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    private final ConcurrentHashMap i = new ConcurrentHashMap();
    private final ConcurrentHashMap j = new ConcurrentHashMap();
    private final AtomicInteger k = new AtomicInteger(0);

    public static final class a {

        /* renamed from: bo.app.p0$a$a  reason: collision with other inner class name */
        static final class C0021a extends Lambda implements Function0 {
            final /* synthetic */ f5 b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0021a(f5 f5Var) {
                super(0);
                this.b = f5Var;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Adding SDK Auth token to request '" + this.b.a() + '\'';
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "SDK Auth is disabled, not adding signature to request";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(BrazeConfigurationProvider brazeConfigurationProvider, f5 f5Var, a2 a2Var, String str) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            Intrinsics.checkNotNullParameter(f5Var, "sdkAuthenticationCache");
            Intrinsics.checkNotNullParameter(a2Var, "brazeRequest");
            Intrinsics.checkNotNullParameter(str, "deviceId");
            a2Var.c(str);
            a2Var.g(brazeConfigurationProvider.getBrazeApiKey().toString());
            a2Var.b(Constants.BRAZE_SDK_VERSION);
            a2Var.a(Long.valueOf(DateTimeUtils.nowInSeconds()));
            if (brazeConfigurationProvider.isSdkAuthenticationEnabled()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new C0021a(f5Var), 2, (Object) null);
                a2Var.e(f5Var.a());
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) b.b, 2, (Object) null);
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
            return "Network requests are offline, not adding request to queue.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ a2 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(a2 a2Var) {
            super(0);
            this.b = a2Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "A maximum of 5 invalid api key errors reached. Device data will remain unaffected after dropping this request " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Added request to dispatcher with parameters: \n" + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not add request to dispatcher as queue is full or closed. Marking as complete. Incoming Request: \n" + this.b;
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ x1 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(x1 x1Var) {
            super(0);
            this.b = x1Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Event dispatched: " + this.b.forJsonPut() + " with uid: " + this.b.t();
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Max number of events per dispatch reached: 32 . No more events will be included in this dispatch";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Flushing pending events to dispatcher map";
        }
    }

    static final class i extends ContinuationImpl {
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ p0 d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(p0 p0Var, Continuation continuation) {
            super(continuation);
            this.d = p0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Continuation) this);
        }
    }

    public p0(w6 w6Var, d2 d2Var, BrazeConfigurationProvider brazeConfigurationProvider, f5 f5Var, h5 h5Var, j0 j0Var, e2 e2Var, i2 i2Var) {
        Intrinsics.checkNotNullParameter(w6Var, "userCache");
        Intrinsics.checkNotNullParameter(d2Var, "deviceDataProvider");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(f5Var, "sdkAuthenticationCache");
        Intrinsics.checkNotNullParameter(h5Var, "sdkMetadataCache");
        Intrinsics.checkNotNullParameter(j0Var, "deviceCache");
        Intrinsics.checkNotNullParameter(e2Var, "deviceIdProvider");
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        this.a = w6Var;
        this.b = d2Var;
        this.c = brazeConfigurationProvider;
        this.d = f5Var;
        this.e = h5Var;
        this.f = j0Var;
        this.g = e2Var;
        i2Var.c(h3.class, new p0$$ExternalSyntheticLambda0(this));
    }

    /* access modifiers changed from: private */
    public static final void a(p0 p0Var, h3 h3Var) {
        Intrinsics.checkNotNullParameter(p0Var, "this$0");
        Intrinsics.checkNotNullParameter(h3Var, "it");
        p0Var.k.incrementAndGet();
    }

    public synchronized void b(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.j.putIfAbsent(x1Var.t(), x1Var);
    }

    public final boolean c() {
        return Braze.Companion.getOutboundNetworkRequestsOffline();
    }

    public final a2 d() {
        a2 a2Var = (a2) ChannelResult.m2527getOrNullimpl(this.h.m2545tryReceivePtdJZtk());
        if (a2Var == null) {
            return null;
        }
        b(a2Var);
        return a2Var;
    }

    public final synchronized k a() {
        LinkedHashSet linkedHashSet;
        Collection values = this.i.values();
        Intrinsics.checkNotNullExpressionValue(values, "brazeEventMap.values");
        linkedHashSet = new LinkedHashSet();
        Iterator it = values.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            x1 x1Var = (x1) it.next();
            Intrinsics.checkNotNullExpressionValue(x1Var, "event");
            linkedHashSet.add(x1Var);
            values.remove(x1Var);
            BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new f(x1Var), 3, (Object) null);
            if (linkedHashSet.size() >= 32) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) g.b, 2, (Object) null);
                break;
            }
        }
        return new k(linkedHashSet);
    }

    public final boolean b() {
        return !this.h.isEmpty();
    }

    public final synchronized a2 b(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "brazeRequest");
        l.a(this.c, this.d, a2Var, this.g.getDeviceId());
        if (a2Var.h()) {
            a(a2Var);
        }
        if (a2Var instanceof l4) {
            a2Var.a(this.b.b());
        }
        return a2Var;
    }

    public synchronized void a(p5 p5Var) {
        Intrinsics.checkNotNullParameter(p5Var, "sessionId");
        ConcurrentHashMap concurrentHashMap = this.j;
        if (!concurrentHashMap.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
            Collection<x1> values = concurrentHashMap.values();
            Intrinsics.checkNotNullExpressionValue(values, "events.values");
            for (x1 a2 : values) {
                a2.a(p5Var);
            }
            this.i.putAll(concurrentHashMap);
            Set<String> keySet = concurrentHashMap.keySet();
            Intrinsics.checkNotNullExpressionValue(keySet, "events.keys");
            for (String remove : keySet) {
                this.j.remove(remove);
            }
        }
    }

    public synchronized void a(x1 x1Var) {
        Intrinsics.checkNotNullParameter(x1Var, "event");
        this.i.putIfAbsent(x1Var.t(), x1Var);
    }

    public void a(i2 i2Var, a2 a2Var) {
        Intrinsics.checkNotNullParameter(i2Var, "internalEventPublisher");
        Intrinsics.checkNotNullParameter(a2Var, "request");
        if (c()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) b.b, 2, (Object) null);
        } else if (this.k.get() >= 5) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new c(a2Var), 2, (Object) null);
        } else {
            String prettyPrintedString = JsonUtils.getPrettyPrintedString(a2Var.e());
            a2Var.a(i2Var);
            if (ChannelResult.m2532isSuccessimpl(this.h.m2546trySendJP2dKIU(a2Var))) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d(prettyPrintedString), 2, (Object) null);
                return;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, (Function0) new e(prettyPrintedString), 2, (Object) null);
            a2Var.b(i2Var);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof bo.app.p0.i
            if (r0 == 0) goto L_0x0013
            r0 = r5
            bo.app.p0$i r0 = (bo.app.p0.i) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            bo.app.p0$i r0 = new bo.app.p0$i
            r0.<init>(r4, r5)
        L_0x0018:
            java.lang.Object r5 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r0 = r0.b
            bo.app.p0 r0 = (bo.app.p0) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0046
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r5)
            kotlinx.coroutines.channels.Channel r5 = r4.h
            r0.b = r4
            r0.e = r3
            java.lang.Object r5 = r5.receive(r0)
            if (r5 != r1) goto L_0x0045
            return r1
        L_0x0045:
            r0 = r4
        L_0x0046:
            bo.app.a2 r5 = (bo.app.a2) r5
            bo.app.a2 r5 = r0.b((bo.app.a2) r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.p0.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final synchronized void a(a2 a2Var) {
        Intrinsics.checkNotNullParameter(a2Var, "brazeRequest");
        a2Var.d(this.b.a());
        a2Var.a(this.c.getSdkFlavor());
        a2Var.f(this.b.c());
        i0 a2 = this.b.a(this.f);
        a2Var.a(a2);
        boolean z = false;
        if (a2 != null && a2.w()) {
            this.a.b(NotificationSubscriptionType.OPTED_IN);
        }
        if (a2 != null && a2.u()) {
            z = true;
        }
        if (z) {
            this.a.g();
        }
        a2Var.a((z3) this.a.a());
        k a3 = a();
        a2Var.a(a3);
        if (a3.a()) {
            a2Var.a(this.e.b(this.c.getSdkMetadata()));
        }
    }
}
