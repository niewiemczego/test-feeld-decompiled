package bo.app;

import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.support.BrazeLogger;
import com.braze.support.JsonUtils;
import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.ReceiveChannel;
import org.json.JSONObject;

public final class v0 {
    public static final a b = new a((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String c = BrazeLogger.getBrazeLogTag((Class<?>) v0.class);
    /* access modifiers changed from: private */
    public Job a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }

        /* access modifiers changed from: private */
        public final String a(String str, String str2) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
            return substring;
        }
    }

    static final class b extends ContinuationImpl {
        Object b;
        Object c;
        Object d;
        Object e;
        Object f;
        Object g;
        /* synthetic */ Object h;
        final /* synthetic */ v0 i;
        int j;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(v0 v0Var, Continuation continuation) {
            super(continuation);
            this.i = v0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.h = obj;
            this.j |= Integer.MIN_VALUE;
            return this.i.a((CoroutineScope) null, (ReceiveChannel) null, (Function1) null, this);
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Waiting to consume new line";
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
            return "Received new line: '" + this.b + '\'';
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Recorded event type: " + ((String) this.b.element);
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(Ref.ObjectRef objectRef) {
            super(0);
            this.b = objectRef;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Recorded data type: " + ((String) this.b.element);
        }
    }

    static final class g extends Lambda implements Function0 {
        final /* synthetic */ Ref.ObjectRef b;
        final /* synthetic */ Ref.ObjectRef c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
            super(0);
            this.b = objectRef;
            this.c = objectRef2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Handling full event on blank line. lastEventType: '" + ((String) this.b.element) + "' \ndata: '" + ((String) this.c.element) + '\'';
        }
    }

    static final class h extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got un-actionable stream line:\n" + this.b;
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ v0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(v0 v0Var) {
            super(0);
            this.b = v0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got call to endStream(). Stream job: " + this.b.a;
        }
    }

    static final class j extends ContinuationImpl {
        Object b;
        /* synthetic */ Object c;
        final /* synthetic */ v0 d;
        int e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(v0 v0Var, Continuation continuation) {
            super(continuation);
            this.d = v0Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return this.d.a((Continuation) this);
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ v0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(v0 v0Var) {
            super(0);
            this.b = v0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got call to endStreamAndJoin(). Stream job: " + this.b.a;
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got event '" + this.b + "' and data: '" + this.c + '\'';
        }
    }

    static final class m extends Lambda implements Function0 {
        final /* synthetic */ JSONObject b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(JSONObject jSONObject) {
            super(0);
            this.b = jSONObject;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Parsed dust message json to:\n" + JsonUtils.getPrettyPrintedString(this.b);
        }
    }

    static final class n extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to parse data line:\n" + this.b;
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ String c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(String str, String str2) {
            super(0);
            this.b = str;
            this.c = str2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not handling event: '" + this.b + "' and data: '" + this.c + '\'';
        }
    }

    static final class p extends SuspendLambda implements Function2 {
        int b;
        private /* synthetic */ Object c;
        final /* synthetic */ BufferedReader d;

        static final class a extends SuspendLambda implements Function2 {
            int b;
            private /* synthetic */ Object c;
            final /* synthetic */ BufferedReader d;
            final /* synthetic */ ProducerScope e;

            /* renamed from: bo.app.v0$p$a$a  reason: collision with other inner class name */
            static final class C0023a extends Lambda implements Function0 {
                public static final C0023a b = new C0023a();

                C0023a() {
                    super(0);
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Caught unexpected exception in stream producer";
                }
            }

            static final class b extends Lambda implements Function0 {
                final /* synthetic */ Exception b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                b(Exception exc) {
                    super(0);
                    this.b = exc;
                }

                /* renamed from: a */
                public final String invoke() {
                    return "Stream producer job cancelled " + this.b;
                }
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(BufferedReader bufferedReader, ProducerScope producerScope, Continuation continuation) {
                super(2, continuation);
                this.d = bufferedReader;
                this.e = producerScope;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                a aVar = new a(this.d, this.e, continuation);
                aVar.c = obj;
                return aVar;
            }

            public final Object invokeSuspend(Object obj) {
                Exception e2;
                CoroutineScope coroutineScope;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.b;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    CoroutineScope coroutineScope2 = (CoroutineScope) this.c;
                    try {
                        String readLine = this.d.readLine();
                        if (readLine == null) {
                            return Unit.INSTANCE;
                        }
                        ProducerScope producerScope = this.e;
                        this.c = coroutineScope2;
                        this.b = 1;
                        if (producerScope.send(readLine, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } catch (Exception e3) {
                        Exception exc = e3;
                        coroutineScope = coroutineScope2;
                        e2 = exc;
                        if (CoroutineScopeKt.isActive(coroutineScope)) {
                            BrazeLogger.INSTANCE.brazelog(v0.c, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) C0023a.b);
                        } else {
                            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, v0.c, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(e2), 6, (Object) null);
                        }
                        return Unit.INSTANCE;
                    }
                } else if (i == 1) {
                    coroutineScope = (CoroutineScope) this.c;
                    try {
                        ResultKt.throwOnFailure(obj);
                    } catch (Exception e4) {
                        e2 = e4;
                    }
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(BufferedReader bufferedReader, Continuation continuation) {
            super(2, continuation);
            this.d = bufferedReader;
        }

        /* renamed from: a */
        public final Object invoke(ProducerScope producerScope, Continuation continuation) {
            return ((p) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            p pVar = new p(this.d, continuation);
            pVar.c = obj;
            return pVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.channels.ProducerScope} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r7) {
            /*
                r6 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r6.b
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r6.c
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
                kotlin.ResultKt.throwOnFailure(r7)
                goto L_0x0023
            L_0x0013:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r0)
                throw r7
            L_0x001b:
                kotlin.ResultKt.throwOnFailure(r7)
                java.lang.Object r7 = r6.c
                r1 = r7
                kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            L_0x0023:
                boolean r7 = kotlinx.coroutines.CoroutineScopeKt.isActive(r1)
                if (r7 == 0) goto L_0x0040
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()
                bo.app.v0$p$a r3 = new bo.app.v0$p$a
                java.io.BufferedReader r4 = r6.d
                r5 = 0
                r3.<init>(r4, r1, r5)
                r6.c = r1
                r6.b = r2
                java.lang.Object r7 = kotlinx.coroutines.BuildersKt.withContext(r7, r3, r6)
                if (r7 != r0) goto L_0x0023
                return r0
            L_0x0040:
                kotlin.Unit r7 = kotlin.Unit.INSTANCE
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.v0.p.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class q extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Got call to startStream() for url " + this.b;
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ v0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(v0 v0Var) {
            super(0);
            this.b = v0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not restarting stream since " + this.b.a + " is still active.";
        }
    }

    static final class s extends SuspendLambda implements Function2 {
        int b;
        final /* synthetic */ v0 c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        s(v0 v0Var, Continuation continuation) {
            super(2, continuation);
            this.c = v0Var;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((s) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            return new s(this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.b;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                v0 v0Var = this.c;
                this.b = 1;
                if (v0Var.a((Continuation) this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    static final class t extends SuspendLambda implements Function2 {
        Object b;
        Object c;
        int d;
        private /* synthetic */ Object e;
        final /* synthetic */ v0 f;
        final /* synthetic */ Function1 g;
        final /* synthetic */ String h;

        static final class a extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Starting DUST stream to " + this.b;
            }
        }

        static final class b extends SuspendLambda implements Function2 {
            int b;
            final /* synthetic */ String c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(String str, Continuation continuation) {
                super(2, continuation);
                this.c = str;
            }

            /* renamed from: a */
            public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
                return ((b) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            public final Continuation create(Object obj, Continuation continuation) {
                return new b(this.c, continuation);
            }

            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.b == 0) {
                    ResultKt.throwOnFailure(obj);
                    URLConnection openConnection = new URL(this.c).openConnection();
                    openConnection.setRequestProperty("Accept", "text/event-stream");
                    openConnection.setDoInput(true);
                    openConnection.connect();
                    return openConnection;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        static final class c extends Lambda implements Function0 {
            final /* synthetic */ Ref.ObjectRef b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            c(Ref.ObjectRef objectRef) {
                super(0);
                this.b = objectRef;
            }

            /* renamed from: a */
            public final String invoke() {
                return "DUST stream response code " + ((HttpURLConnection) this.b.element).getResponseCode();
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Stream job coroutine no longer active";
            }
        }

        static final class e extends Lambda implements Function0 {
            public static final e b = new e();

            e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Caught unexpected exception listening to DUST stream";
            }
        }

        static final class f extends Lambda implements Function0 {
            public static final f b = new f();

            f() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Stream connection job cancelled";
            }
        }

        static final class g extends Lambda implements Function0 {
            public static final g b = new g();

            g() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Closing stream connection data";
            }
        }

        static final class h extends Lambda implements Function0 {
            public static final h b = new h();

            h() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Stream job finished";
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(v0 v0Var, Function1 function1, String str, Continuation continuation) {
            super(2, continuation);
            this.f = v0Var;
            this.g = function1;
            this.h = str;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
            return ((t) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation create(Object obj, Continuation continuation) {
            t tVar = new t(this.f, this.g, this.h, continuation);
            tVar.e = obj;
            return tVar;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: T} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v14, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: T} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v22, resolved type: kotlin.jvm.internal.Ref$ObjectRef} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: kotlinx.coroutines.CoroutineScope} */
        /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fe, code lost:
            if (r0 == null) goto L_0x014d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:51:0x0148, code lost:
            if (r0 == null) goto L_0x014d;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x014a, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x014d, code lost:
            com.braze.support.BrazeLogger.brazelog$default(com.braze.support.BrazeLogger.INSTANCE, bo.app.v0.a(), (com.braze.support.BrazeLogger.Priority) null, (java.lang.Throwable) null, (kotlin.jvm.functions.Function0) bo.app.v0.t.h.b, 6, (java.lang.Object) null);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:54:0x015e, code lost:
            return kotlin.Unit.INSTANCE;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x0114 A[Catch:{ all -> 0x010b }] */
        /* JADX WARNING: Removed duplicated region for block: B:49:0x0122 A[Catch:{ all -> 0x010b }] */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x0174  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r22) {
            /*
                r21 = this;
                r1 = r21
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r1.d
                r3 = 0
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L_0x0046
                if (r2 == r5) goto L_0x002b
                if (r2 != r4) goto L_0x0023
                java.lang.Object r0 = r1.b
                r2 = r0
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r0 = r1.e
                r3 = r0
                kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
                kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Exception -> 0x0020 }
                goto L_0x00dc
            L_0x0020:
                r0 = move-exception
                goto L_0x0101
            L_0x0023:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L_0x002b:
                java.lang.Object r2 = r1.c
                kotlin.jvm.internal.Ref$ObjectRef r2 = (kotlin.jvm.internal.Ref.ObjectRef) r2
                java.lang.Object r5 = r1.b
                kotlin.jvm.internal.Ref$ObjectRef r5 = (kotlin.jvm.internal.Ref.ObjectRef) r5
                java.lang.Object r6 = r1.e
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                kotlin.ResultKt.throwOnFailure(r22)     // Catch:{ Exception -> 0x0042, all -> 0x003f }
                r7 = r6
                r6 = r5
                r5 = r22
                goto L_0x0083
            L_0x003f:
                r0 = move-exception
                goto L_0x0105
            L_0x0042:
                r0 = move-exception
                r2 = r5
                goto L_0x010e
            L_0x0046:
                kotlin.ResultKt.throwOnFailure(r22)
                java.lang.Object r2 = r1.e
                r6 = r2
                kotlinx.coroutines.CoroutineScope r6 = (kotlinx.coroutines.CoroutineScope) r6
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r8 = bo.app.v0.c
                bo.app.v0$t$a r11 = new bo.app.v0$t$a
                java.lang.String r2 = r1.h
                r11.<init>(r2)
                r9 = 0
                r10 = 0
                r12 = 6
                r13 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)
                kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
                r2.<init>()
                kotlinx.coroutines.CoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getIO()     // Catch:{ Exception -> 0x010d }
                bo.app.v0$t$b r8 = new bo.app.v0$t$b     // Catch:{ Exception -> 0x010d }
                java.lang.String r9 = r1.h     // Catch:{ Exception -> 0x010d }
                r8.<init>(r9, r3)     // Catch:{ Exception -> 0x010d }
                r1.e = r6     // Catch:{ Exception -> 0x010d }
                r1.b = r2     // Catch:{ Exception -> 0x010d }
                r1.c = r2     // Catch:{ Exception -> 0x010d }
                r1.d = r5     // Catch:{ Exception -> 0x010d }
                java.lang.Object r5 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r1)     // Catch:{ Exception -> 0x010d }
                if (r5 != r0) goto L_0x0081
                return r0
            L_0x0081:
                r7 = r6
                r6 = r2
            L_0x0083:
                java.lang.String r8 = "null cannot be cast to non-null type java.net.HttpURLConnection"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r8)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r2.element = r5     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.lang.String r9 = bo.app.v0.c     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r10 = 0
                r11 = 0
                bo.app.v0$t$c r12 = new bo.app.v0$t$c     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r12.<init>(r6)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r13 = 6
                r14 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r8, (java.lang.String) r9, (com.braze.support.BrazeLogger.Priority) r10, (java.lang.Throwable) r11, (kotlin.jvm.functions.Function0) r12, (int) r13, (java.lang.Object) r14)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                bo.app.v0 r2 = r1.f     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                T r5 = r6.element     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.net.HttpURLConnection r5 = (java.net.HttpURLConnection) r5     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.io.InputStream r5 = r5.getInputStream()     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.lang.String r8 = "conn.inputStream"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.nio.charset.Charset r8 = kotlin.text.Charsets.UTF_8     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.io.InputStreamReader r9 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r9.<init>(r5, r8)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r5 = 8192(0x2000, float:1.14794E-41)
                boolean r8 = r9 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                if (r8 == 0) goto L_0x00bd
                java.io.BufferedReader r9 = (java.io.BufferedReader) r9     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                goto L_0x00c3
            L_0x00bd:
                java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r8.<init>(r9, r5)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r9 = r8
            L_0x00c3:
                kotlinx.coroutines.channels.ReceiveChannel r2 = r2.a((kotlinx.coroutines.CoroutineScope) r7, (java.io.BufferedReader) r9)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                bo.app.v0 r5 = r1.f     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                kotlin.jvm.functions.Function1 r8 = r1.g     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r1.e = r7     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r1.b = r6     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r1.c = r3     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                r1.d = r4     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                java.lang.Object r2 = r5.a(r7, r2, r8, r1)     // Catch:{ Exception -> 0x0107, all -> 0x0103 }
                if (r2 != r0) goto L_0x00da
                return r0
            L_0x00da:
                r2 = r6
                r3 = r7
            L_0x00dc:
                com.braze.support.BrazeLogger r0 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ Exception -> 0x0020 }
                java.lang.String r5 = bo.app.v0.c     // Catch:{ Exception -> 0x0020 }
                r6 = 0
                r7 = 0
                bo.app.v0$t$d r8 = bo.app.v0.t.d.b     // Catch:{ Exception -> 0x0020 }
                r9 = 6
                r10 = 0
                r4 = r0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)     // Catch:{ Exception -> 0x0020 }
                java.lang.String r5 = bo.app.v0.c
                bo.app.v0$t$g r8 = bo.app.v0.t.g.b
                r6 = 0
                r7 = 0
                r9 = 6
                r10 = 0
                r4 = r0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r4, (java.lang.String) r5, (com.braze.support.BrazeLogger.Priority) r6, (java.lang.Throwable) r7, (kotlin.jvm.functions.Function0) r8, (int) r9, (java.lang.Object) r10)
                T r0 = r2.element
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                if (r0 == 0) goto L_0x014d
                goto L_0x014a
            L_0x0101:
                r6 = r3
                goto L_0x010e
            L_0x0103:
                r0 = move-exception
                r5 = r6
            L_0x0105:
                r2 = r5
                goto L_0x015f
            L_0x0107:
                r0 = move-exception
                r2 = r6
                r6 = r7
                goto L_0x010e
            L_0x010b:
                r0 = move-exception
                goto L_0x015f
            L_0x010d:
                r0 = move-exception
            L_0x010e:
                boolean r3 = kotlinx.coroutines.CoroutineScopeKt.isActive(r6)     // Catch:{ all -> 0x010b }
                if (r3 == 0) goto L_0x0122
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x010b }
                java.lang.String r4 = bo.app.v0.c     // Catch:{ all -> 0x010b }
                com.braze.support.BrazeLogger$Priority r5 = com.braze.support.BrazeLogger.Priority.E     // Catch:{ all -> 0x010b }
                bo.app.v0$t$e r6 = bo.app.v0.t.e.b     // Catch:{ all -> 0x010b }
                r3.brazelog((java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r0, (kotlin.jvm.functions.Function0<java.lang.String>) r6)     // Catch:{ all -> 0x010b }
                goto L_0x0131
            L_0x0122:
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ all -> 0x010b }
                java.lang.String r8 = bo.app.v0.c     // Catch:{ all -> 0x010b }
                r9 = 0
                r10 = 0
                bo.app.v0$t$f r11 = bo.app.v0.t.f.b     // Catch:{ all -> 0x010b }
                r12 = 6
                r13 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.String) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ all -> 0x010b }
            L_0x0131:
                com.braze.support.BrazeLogger r14 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r15 = bo.app.v0.c
                bo.app.v0$t$g r18 = bo.app.v0.t.g.b
                r16 = 0
                r17 = 0
                r19 = 6
                r20 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r14, (java.lang.String) r15, (com.braze.support.BrazeLogger.Priority) r16, (java.lang.Throwable) r17, (kotlin.jvm.functions.Function0) r18, (int) r19, (java.lang.Object) r20)
                T r0 = r2.element
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0
                if (r0 == 0) goto L_0x014d
            L_0x014a:
                r0.disconnect()
            L_0x014d:
                com.braze.support.BrazeLogger r2 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r3 = bo.app.v0.c
                bo.app.v0$t$h r6 = bo.app.v0.t.h.b
                r4 = 0
                r5 = 0
                r7 = 6
                r8 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r2, (java.lang.String) r3, (com.braze.support.BrazeLogger.Priority) r4, (java.lang.Throwable) r5, (kotlin.jvm.functions.Function0) r6, (int) r7, (java.lang.Object) r8)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x015f:
                com.braze.support.BrazeLogger r3 = com.braze.support.BrazeLogger.INSTANCE
                java.lang.String r4 = bo.app.v0.c
                bo.app.v0$t$g r7 = bo.app.v0.t.g.b
                r5 = 0
                r6 = 0
                r8 = 6
                r9 = 0
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r3, (java.lang.String) r4, (com.braze.support.BrazeLogger.Priority) r5, (java.lang.Throwable) r6, (kotlin.jvm.functions.Function0) r7, (int) r8, (java.lang.Object) r9)
                T r2 = r2.element
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2
                if (r2 == 0) goto L_0x0177
                r2.disconnect()
            L_0x0177:
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: bo.app.v0.t.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    static final class u extends Lambda implements Function0 {
        final /* synthetic */ v0 b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(v0 v0Var) {
            super(0);
            this.b = v0Var;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Started stream job " + this.b.a;
        }
    }

    public final void b() {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new i(this), 3, (Object) null);
        Job job = this.a;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.a = null;
    }

    public final void a(String str, Function1 function1, boolean z) {
        Intrinsics.checkNotNullParameter(str, "url");
        Intrinsics.checkNotNullParameter(function1, "ingestor");
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new q(str), 3, (Object) null);
        if (!z || this.a == null) {
            Object unused = BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new s(this, (Continuation) null), 1, (Object) null);
            this.a = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, (CoroutineContext) null, (CoroutineStart) null, new t(this, function1, str, (Continuation) null), 3, (Object) null);
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new u(this), 3, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new r(this), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlinx.coroutines.CoroutineScope r24, kotlinx.coroutines.channels.ReceiveChannel r25, kotlin.jvm.functions.Function1 r26, kotlin.coroutines.Continuation r27) {
        /*
            r23 = this;
            r0 = r27
            boolean r1 = r0 instanceof bo.app.v0.b
            if (r1 == 0) goto L_0x0017
            r1 = r0
            bo.app.v0$b r1 = (bo.app.v0.b) r1
            int r2 = r1.j
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0017
            int r2 = r2 - r3
            r1.j = r2
            r2 = r23
            goto L_0x001e
        L_0x0017:
            bo.app.v0$b r1 = new bo.app.v0$b
            r2 = r23
            r1.<init>(r2, r0)
        L_0x001e:
            java.lang.Object r0 = r1.h
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r1.j
            r5 = 1
            java.lang.String r6 = ""
            if (r4 == 0) goto L_0x005a
            if (r4 != r5) goto L_0x0052
            java.lang.Object r4 = r1.g
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r7 = r1.f
            kotlin.jvm.internal.Ref$ObjectRef r7 = (kotlin.jvm.internal.Ref.ObjectRef) r7
            java.lang.Object r8 = r1.e
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            java.lang.Object r9 = r1.d
            kotlinx.coroutines.channels.ReceiveChannel r9 = (kotlinx.coroutines.channels.ReceiveChannel) r9
            java.lang.Object r10 = r1.c
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            java.lang.Object r11 = r1.b
            bo.app.v0 r11 = (bo.app.v0) r11
            kotlin.ResultKt.throwOnFailure(r0)
            r22 = r4
            r4 = r1
            r1 = r9
            r9 = r7
            r7 = r3
            r3 = r8
            r8 = r22
            goto L_0x00a6
        L_0x0052:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x005a:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlin.jvm.internal.Ref$ObjectRef r0 = new kotlin.jvm.internal.Ref$ObjectRef
            r0.<init>()
            r0.element = r6
            kotlin.jvm.internal.Ref$ObjectRef r4 = new kotlin.jvm.internal.Ref$ObjectRef
            r4.<init>()
            r4.element = r6
            r9 = r0
            r11 = r2
            r7 = r3
            r8 = r4
            r0 = r24
            r3 = r26
            r4 = r1
            r1 = r25
        L_0x0076:
            boolean r10 = kotlinx.coroutines.CoroutineScopeKt.isActive(r0)
            if (r10 == 0) goto L_0x016f
            com.braze.support.BrazeLogger r12 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r13 = c
            com.braze.support.BrazeLogger$Priority r14 = com.braze.support.BrazeLogger.Priority.V
            bo.app.v0$c r16 = bo.app.v0.c.b
            r15 = 0
            r17 = 4
            r18 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
            r4.b = r11
            r4.c = r0
            r4.d = r1
            r4.e = r3
            r4.f = r9
            r4.g = r8
            r4.j = r5
            java.lang.Object r10 = r1.receive(r4)
            if (r10 != r7) goto L_0x00a1
            return r7
        L_0x00a1:
            r22 = r10
            r10 = r0
            r0 = r22
        L_0x00a6:
            java.lang.String r0 = (java.lang.String) r0
            com.braze.support.BrazeLogger r19 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r20 = c
            com.braze.support.BrazeLogger$Priority r14 = com.braze.support.BrazeLogger.Priority.V
            bo.app.v0$d r15 = new bo.app.v0$d
            r15.<init>(r0)
            r16 = 0
            r17 = 4
            r18 = 0
            r12 = r19
            r13 = r20
            r21 = r15
            r15 = r16
            r16 = r21
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
            java.lang.String r12 = "event: "
            r13 = 0
            r14 = 2
            r15 = 0
            boolean r16 = kotlin.text.StringsKt.startsWith$default(r0, r12, r13, r14, r15)
            if (r16 == 0) goto L_0x00ef
            bo.app.v0$a r13 = b
            java.lang.String r0 = r13.a(r0, r12)
            r9.element = r0
            bo.app.v0$e r0 = new bo.app.v0$e
            r0.<init>(r9)
            r14 = 0
            r15 = 0
            r17 = 6
            r18 = 0
            r12 = r19
            r13 = r20
            r16 = r0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
            goto L_0x016c
        L_0x00ef:
            java.lang.String r12 = "data: "
            boolean r13 = kotlin.text.StringsKt.startsWith$default(r0, r12, r13, r14, r15)
            if (r13 == 0) goto L_0x0129
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            T r14 = r8.element
            java.lang.String r14 = (java.lang.String) r14
            java.lang.StringBuilder r13 = r13.append(r14)
            bo.app.v0$a r14 = b
            java.lang.String r0 = r14.a(r0, r12)
            java.lang.StringBuilder r0 = r13.append(r0)
            java.lang.String r0 = r0.toString()
            r8.element = r0
            bo.app.v0$f r0 = new bo.app.v0$f
            r0.<init>(r8)
            r14 = 0
            r15 = 0
            r17 = 6
            r18 = 0
            r12 = r19
            r13 = r20
            r16 = r0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
            goto L_0x016c
        L_0x0129:
            boolean r12 = kotlin.text.StringsKt.isBlank(r0)
            if (r12 == 0) goto L_0x0153
            bo.app.v0$g r0 = new bo.app.v0$g
            r0.<init>(r9, r8)
            r14 = 0
            r15 = 0
            r17 = 6
            r18 = 0
            r12 = r19
            r13 = r20
            r16 = r0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
            T r0 = r9.element
            java.lang.String r0 = (java.lang.String) r0
            T r12 = r8.element
            java.lang.String r12 = (java.lang.String) r12
            r11.a((java.lang.String) r0, (java.lang.String) r12, (kotlin.jvm.functions.Function1) r3)
            r8.element = r6
            r9.element = r6
            goto L_0x016c
        L_0x0153:
            r9.element = r6
            r8.element = r6
            bo.app.v0$h r15 = new bo.app.v0$h
            r15.<init>(r0)
            r14 = 0
            r0 = 0
            r17 = 6
            r18 = 0
            r12 = r19
            r13 = r20
            r16 = r15
            r15 = r0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r12, (java.lang.String) r13, (com.braze.support.BrazeLogger.Priority) r14, (java.lang.Throwable) r15, (kotlin.jvm.functions.Function0) r16, (int) r17, (java.lang.Object) r18)
        L_0x016c:
            r0 = r10
            goto L_0x0076
        L_0x016f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.v0.a(kotlinx.coroutines.CoroutineScope, kotlinx.coroutines.channels.ReceiveChannel, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final ReceiveChannel a(CoroutineScope coroutineScope, BufferedReader bufferedReader) {
        return ProduceKt.produce$default(coroutineScope, (CoroutineContext) null, 0, new p(bufferedReader, (Continuation) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object a(kotlin.coroutines.Continuation r13) {
        /*
            r12 = this;
            boolean r0 = r13 instanceof bo.app.v0.j
            if (r0 == 0) goto L_0x0013
            r0 = r13
            bo.app.v0$j r0 = (bo.app.v0.j) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.e = r1
            goto L_0x0018
        L_0x0013:
            bo.app.v0$j r0 = new bo.app.v0$j
            r0.<init>(r12, r13)
        L_0x0018:
            java.lang.Object r13 = r0.c
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r0 = r0.b
            bo.app.v0 r0 = (bo.app.v0) r0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0073
        L_0x0030:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x0038:
            java.lang.Object r2 = r0.b
            bo.app.v0 r2 = (bo.app.v0) r2
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0063
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r13)
            com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
            java.lang.String r6 = c
            bo.app.v0$k r9 = new bo.app.v0$k
            r9.<init>(r12)
            r7 = 0
            r8 = 0
            r10 = 6
            r11 = 0
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.String) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
            kotlinx.coroutines.Job r13 = r12.a
            if (r13 == 0) goto L_0x0072
            r0.b = r12
            r0.e = r4
            java.lang.Object r13 = kotlinx.coroutines.JobKt.cancelAndJoin(r13, r0)
            if (r13 != r1) goto L_0x0062
            return r1
        L_0x0062:
            r2 = r12
        L_0x0063:
            r0.b = r2
            r0.e = r3
            r3 = 50
            java.lang.Object r13 = kotlinx.coroutines.DelayKt.delay(r3, r0)
            if (r13 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r0 = r2
            goto L_0x0073
        L_0x0072:
            r0 = r12
        L_0x0073:
            r13 = 0
            r0.a = r13
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: bo.app.v0.a(kotlin.coroutines.Continuation):java.lang.Object");
    }

    private final void a(String str, String str2, Function1 function1) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str3 = c;
        BrazeLogger.brazelog$default(brazeLogger, str3, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new l(str, str2), 6, (Object) null);
        if (Intrinsics.areEqual((Object) str, (Object) "msg")) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                BrazeLogger.brazelog$default(brazeLogger, str3, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new m(jSONObject), 6, (Object) null);
                function1.invoke(g2.a.a(jSONObject));
            } catch (Exception e2) {
                BrazeLogger.INSTANCE.brazelog(c, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new n(str2));
            }
        } else {
            BrazeLogger.brazelog$default(brazeLogger, str3, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new o(str, str2), 6, (Object) null);
        }
    }
}
