package bo.app;

import android.app.ActivityManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import androidx.core.content.pm.PackageInfoCompat;
import bo.app.i0;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.support.BrazeImageUtils;
import com.braze.support.BrazeLogger;
import com.braze.support.ReflectionUtils;
import com.google.firebase.messaging.Constants;
import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

public final class k0 implements d2 {
    public static final a f = new a((DefaultConstructorMarker) null);
    private Context a;
    private final BrazeConfigurationProvider b;
    private final String c;
    public final SharedPreferences d;
    private PackageInfo e;

    public static final class a {

        /* renamed from: bo.app.k0$a$a  reason: collision with other inner class name */
        static final class C0016a extends Lambda implements Function0 {
            public static final C0016a b = new C0016a();

            C0016a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to obtain device resolution";
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final String a(Context context, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            try {
                Pair<Integer, Integer> displayHeightAndWidthPixels = BrazeImageUtils.getDisplayHeightAndWidthPixels(context);
                int intValue = displayHeightAndWidthPixels.component1().intValue();
                int intValue2 = displayHeightAndWidthPixels.component2().intValue();
                if (z) {
                    return new StringBuilder().append(intValue).append('x').append(intValue2).toString();
                }
                return new StringBuilder().append(intValue2).append('x').append(intValue).toString();
            } catch (Exception e) {
                BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e, (Function0<String>) C0016a.b);
                return null;
            }
        }

        private a() {
        }

        public final String a(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            String locale2 = locale.toString();
            Intrinsics.checkNotNullExpressionValue(locale2, "locale.toString()");
            return locale2;
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to read notifications enabled state from NotificationManagerCompat.";
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "App version code could not be read. Returning null";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to collect background restriction information from Activity Manager";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Caught exception while reading the phone carrier name.";
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
            return "Unable to inspect package [" + this.b + ']';
        }
    }

    public k0(Context context, BrazeConfigurationProvider brazeConfigurationProvider) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        this.a = context;
        this.b = brazeConfigurationProvider;
        PackageInfo m = m();
        this.c = m != null ? m.versionName : null;
        SharedPreferences sharedPreferences = this.a.getSharedPreferences("com.appboy.managers.device_data_provider", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.d = sharedPreferences;
    }

    private final boolean g() {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            Object systemService = this.a.getSystemService("activity");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
            return ((ActivityManager) systemService).isBackgroundRestricted();
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) d.b);
            return false;
        }
    }

    private final boolean h() {
        return this.a.getResources().getConfiguration().orientation == 2;
    }

    private final String i() {
        return String.valueOf(Build.VERSION.SDK_INT);
    }

    private final String j() {
        try {
            Object systemService = this.a.getSystemService("phone");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            String networkOperatorName = ((TelephonyManager) systemService).getNetworkOperatorName();
            if (networkOperatorName != null) {
                return StringsKt.trim((CharSequence) networkOperatorName).toString();
            }
            return null;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) e.b);
            return null;
        }
    }

    private final Locale k() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        return locale;
    }

    private final TimeZone l() {
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault()");
        return timeZone;
    }

    private final PackageInfo m() {
        PackageInfo packageInfo;
        PackageInfo packageInfo2;
        PackageInfo packageInfo3 = this.e;
        if (packageInfo3 != null) {
            return packageInfo3;
        }
        String packageName = this.a.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo2 = this.a.getPackageManager().getPackageInfo(packageName, PackageManager.PackageInfoFlags.of(0));
            } else {
                packageInfo2 = this.a.getPackageManager().getPackageInfo(packageName, 0);
            }
            this.e = packageInfo2;
            return packageInfo2;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) new f(packageName));
            ApplicationInfo applicationInfo = this.a.getApplicationInfo();
            if (Build.VERSION.SDK_INT >= 33) {
                packageInfo = this.a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, PackageManager.PackageInfoFlags.of(0));
            } else {
                packageInfo = this.a.getPackageManager().getPackageArchiveInfo(applicationInfo.sourceDir, 0);
            }
            this.e = packageInfo;
            return packageInfo;
        }
    }

    public String a() {
        return this.c;
    }

    public i0 b() {
        i0.a f2 = new i0.a(this.b).a(i()).c(j()).b(Build.BRAND).f(Build.MODEL);
        a aVar = f;
        return f2.e(aVar.a(k())).h(l().getID()).g(aVar.a(this.a, h())).c(Boolean.valueOf(e())).b(Boolean.valueOf(g())).d(d()).a(f()).a();
    }

    public String c() {
        long j;
        PackageInfo m = m();
        if (m != null) {
            if (Build.VERSION.SDK_INT >= 28) {
                j = m.getLongVersionCode();
            } else {
                j = PackageInfoCompat.getLongVersionCode(m);
            }
            return j + ".0.0.0";
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c.b, 3, (Object) null);
        return null;
    }

    public final String d() {
        return this.d.getString("google_ad_id", (String) null);
    }

    public final boolean e() {
        Method methodQuietly;
        if (Build.VERSION.SDK_INT >= 24) {
            Object systemService = this.a.getSystemService("notification");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.app.NotificationManager");
            return ((NotificationManager) systemService).areNotificationsEnabled();
        }
        try {
            Method methodQuietly2 = ReflectionUtils.getMethodQuietly("androidx.core.app.NotificationManagerCompat", Constants.MessagePayloadKeys.FROM, (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly2 == null) {
                return true;
            }
            Object second = ReflectionUtils.invokeMethodQuietly((Object) null, methodQuietly2, this.a).getSecond();
            if (second == null || (methodQuietly = ReflectionUtils.getMethodQuietly(second.getClass(), "areNotificationsEnabled", (Class<?>[]) new Class[0])) == null) {
                return true;
            }
            Pair<Boolean, Object> invokeMethodQuietly = ReflectionUtils.invokeMethodQuietly(second, methodQuietly, new Object[0]);
            Object second2 = invokeMethodQuietly.getFirst().booleanValue() ? invokeMethodQuietly.getSecond() : Boolean.TRUE;
            if (second2 instanceof Boolean) {
                return ((Boolean) second2).booleanValue();
            }
            return true;
        } catch (Exception e2) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.E, (Throwable) e2, (Function0<String>) b.b);
            return true;
        }
    }

    public final Boolean f() {
        if (!this.d.contains("ad_tracking_enabled")) {
            return null;
        }
        return Boolean.valueOf(this.d.getBoolean("ad_tracking_enabled", true));
    }

    public i0 a(j0 j0Var) {
        Intrinsics.checkNotNullParameter(j0Var, "deviceCache");
        j0Var.a(b());
        return (i0) j0Var.a();
    }

    public void a(String str) {
        Intrinsics.checkNotNullParameter(str, "googleAdvertisingId");
        this.d.edit().putString("google_ad_id", str).apply();
    }

    public void a(boolean z) {
        this.d.edit().putBoolean("ad_tracking_enabled", !z).apply();
    }
}
