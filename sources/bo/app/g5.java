package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.support.BrazeLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class g5 {
    public static final a b = new a((DefaultConstructorMarker) null);
    private final SharedPreferences a;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Setting Braze SDK disabled to: " + this.b;
        }
    }

    public g5(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.a = new e(context, "persistent.com.appboy.storage.sdk_enabled_cache");
    }

    public final boolean a() {
        return this.a.getBoolean("appboy_sdk_disabled", false);
    }

    public final void a(boolean z) {
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) new b(z), 2, (Object) null);
        this.a.edit().putBoolean("appboy_sdk_disabled", z).apply();
    }
}
