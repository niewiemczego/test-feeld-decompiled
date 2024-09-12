package bo.app;

import android.content.Context;
import com.amazon.device.messaging.ADM;
import com.amazon.device.messaging.development.ADMManifest;
import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class b {
    public static final a c = new a((DefaultConstructorMarker) null);
    private final Context a;
    /* access modifiers changed from: private */
    public final l2 b;

    public static final class a {

        /* renamed from: bo.app.b$a$a  reason: collision with other inner class name */
        static final class C0002a extends Lambda implements Function0 {
            public static final C0002a b = new C0002a();

            C0002a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "com.amazon.device.messaging.ADM not found";
            }
        }

        /* renamed from: bo.app.b$a$b  reason: collision with other inner class name */
        static final class C0003b extends Lambda implements Function0 {
            final /* synthetic */ Exception b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0003b(Exception exc) {
                super(0);
                this.b = exc;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Manifest not authored properly to support ADM. ADM manifest exception: " + this.b;
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final boolean b(Context context) {
            try {
                ADMManifest.checkManifestAuthoredProperly(context);
                return true;
            } catch (Exception e) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new C0003b(e), 2, (Object) null);
                return false;
            }
        }

        public final boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return a() && b(context);
        }

        private a() {
        }

        private final boolean a() {
            try {
                Class.forName("com.amazon.device.messaging.ADM");
                return true;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) C0002a.b, 2, (Object) null);
                return false;
            }
        }
    }

    /* renamed from: bo.app.b$b  reason: collision with other inner class name */
    static final class C0004b extends Lambda implements Function0 {
        final /* synthetic */ b b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0004b(b bVar) {
            super(0);
            this.b = bVar;
        }

        /* renamed from: a */
        public final String invoke() {
            return "The device is already registered with the ADM server and is eligible to receive ADM messages.ADM registration id: " + this.b.b.a();
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Registering with ADM server...";
        }
    }

    public b(Context context, l2 l2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(l2Var, "admRegistrationDataProvider");
        this.a = context;
        this.b = l2Var;
    }

    public final void a() {
        if (this.b.a() != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new C0004b(this), 2, (Object) null);
            l2 l2Var = this.b;
            l2Var.a(l2Var.a());
            return;
        }
        ADM adm = new ADM(this.a);
        if (adm.isSupported()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
            adm.startRegister();
        }
    }
}
