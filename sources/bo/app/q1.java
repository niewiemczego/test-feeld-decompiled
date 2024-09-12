package bo.app;

import android.content.Context;
import com.braze.support.BrazeLogger;
import com.braze.support.ReflectionUtils;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import java.lang.reflect.Method;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class q1 {
    public static final a e = new a((DefaultConstructorMarker) null);
    private final Context a;
    private final l2 b;
    private final boolean c = ReflectionUtils.doesMethodExist("com.google.firebase.iid.FirebaseInstanceId", "getToken", String.class, String.class);
    private final boolean d = ReflectionUtils.doesMethodExist("com.google.firebase.messaging.FirebaseMessaging", "getToken", new Class[0]);

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
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
            return "Firebase Cloud Messaging requires the Google Play Store to be installed.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ Task b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(Task task) {
            super(0);
            this.b = task;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Fetching registration token failed using FirebaseMessaging instance with default Firebase installation with exception " + this.b.getException();
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
            return "Automatically obtained Firebase Cloud Messaging token: " + this.b;
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to register for Firebase Cloud Messaging";
        }
    }

    static final class f extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering for Firebase Cloud Messaging token using sender id: " + this.b;
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'getInstance' method could not obtained. Not registering for Firebase Cloud Messaging.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not call 'getInstance' method. Not registering for Firebase Cloud Messaging.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'InstanceId' object could not be invoked. Not registering for Firebase Cloud Messaging.";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Firebase Cloud Messaging 'FirebaseInstanceId.getInstance().getToken()' method could not obtained. Not registering for Firebase Cloud Messaging.";
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not invoke 'getToken()' Not registering for Firebase Cloud Messaging.";
        }
    }

    static final class l extends Lambda implements Function0 {
        final /* synthetic */ Object b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(Object obj) {
            super(0);
            this.b = obj;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Automatically obtained Firebase Cloud Messaging token: " + this.b;
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to get push token via instance id";
        }
    }

    public q1(Context context, l2 l2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(l2Var, "registrationDataProvider");
        this.a = context;
        this.b = l2Var;
    }

    private final void b(String str) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new f(str), 2, (Object) null);
        try {
            Method methodQuietly = ReflectionUtils.getMethodQuietly("com.google.firebase.iid.FirebaseInstanceId", "getInstance", (Class<?>[]) new Class[0]);
            if (methodQuietly == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) g.b, 3, (Object) null);
                return;
            }
            Pair<Boolean, Object> invokeMethodQuietly = ReflectionUtils.invokeMethodQuietly((Object) null, methodQuietly, new Object[0]);
            if (!invokeMethodQuietly.getFirst().booleanValue()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
                return;
            }
            Object second = invokeMethodQuietly.getSecond();
            if (second == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) i.b, 3, (Object) null);
                return;
            }
            Method methodQuietly2 = ReflectionUtils.getMethodQuietly(second.getClass(), "getToken", (Class<?>[]) new Class[]{String.class, String.class});
            if (methodQuietly2 == null) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) j.b, 3, (Object) null);
                return;
            }
            Pair<Boolean, Object> invokeMethodQuietly2 = ReflectionUtils.invokeMethodQuietly(second, methodQuietly2, str, FirebaseMessaging.INSTANCE_ID_SCOPE);
            if (!invokeMethodQuietly2.getFirst().booleanValue()) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) k.b, 3, (Object) null);
                return;
            }
            Object second2 = invokeMethodQuietly2.getSecond();
            if (second2 instanceof String) {
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, priority, (Throwable) null, (Function0) new l(second2), 2, (Object) null);
                this.b.a((String) second2);
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) m.b);
        }
    }

    public final void a(String str) {
        Intrinsics.checkNotNullParameter(str, "firebaseSenderId");
        try {
            if (this.d) {
                FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new q1$$ExternalSyntheticLambda0(this));
            } else if (this.c) {
                b(str);
            }
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
        }
    }

    /* access modifiers changed from: private */
    public static final void a(q1 q1Var, Task task) {
        Intrinsics.checkNotNullParameter(q1Var, "this$0");
        Intrinsics.checkNotNullParameter(task, "task");
        if (!task.isSuccessful()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) q1Var, BrazeLogger.Priority.W, (Throwable) null, (Function0) new c(task), 2, (Object) null);
            return;
        }
        String str = (String) task.getResult();
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) q1Var, BrazeLogger.Priority.V, (Throwable) null, (Function0) new d(str), 2, (Object) null);
        q1Var.b.a(str);
    }

    public final boolean a() {
        if (!com.braze.support.f.b(this.a)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) b.b, 2, (Object) null);
            return false;
        } else if (this.c || this.d) {
            return true;
        } else {
            return false;
        }
    }
}
