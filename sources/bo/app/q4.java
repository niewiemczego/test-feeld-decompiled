package bo.app;

import android.content.Context;
import android.content.SharedPreferences;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeLogger;
import io.sentry.ProfilingTraceData;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class q4 implements l2 {
    public static final a c = new a((DefaultConstructorMarker) null);
    private final BrazeConfigurationProvider a;
    public final SharedPreferences b;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private a() {
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ int b;
        final /* synthetic */ int c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i, int i2) {
            super(0);
            this.b = i;
            this.c = i2;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Stored push registration ID version code " + this.b + " does not match live version code " + this.c + ". Not returning saved registration ID.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device identifier differs from saved device identifier. Returning null token.";
        }
    }

    public q4(Context context, BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.a = brazeConfigurationProvider;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.braze.push_registration", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.b = sharedPreferences;
    }

    private final boolean b() {
        return this.a.isFirebaseCloudMessagingRegistrationEnabled() || this.a.isAdmMessagingRegistrationEnabled();
    }

    public synchronized String a() {
        int versionCode;
        int i;
        if (!b() || !this.b.contains(ProfilingTraceData.JsonKeys.VERSION_CODE) || (versionCode = this.a.getVersionCode()) == (i = this.b.getInt(ProfilingTraceData.JsonKeys.VERSION_CODE, Integer.MIN_VALUE))) {
            if (this.b.contains("device_identifier")) {
                if (!Intrinsics.areEqual((Object) l0.b.a(), (Object) this.b.getString("device_identifier", ""))) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
                    return null;
                }
            }
            return this.b.getString("registration_id", (String) null);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, (Function0) new b(i, versionCode), 2, (Object) null);
        return null;
    }

    public synchronized void a(String str) {
        if (str != null) {
            this.b.edit().putString("registration_id", str).putInt(ProfilingTraceData.JsonKeys.VERSION_CODE, this.a.getVersionCode()).putString("device_identifier", l0.b.a()).apply();
        } else {
            throw new NullPointerException("Provided push token is null. Cannot set null push token.");
        }
    }
}
