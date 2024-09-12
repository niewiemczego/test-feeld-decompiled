package com.braze.support;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import com.braze.support.BrazeLogger;
import com.google.android.gms.common.GoogleApiAvailability;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

public final class f {
    public static final f a = new f();

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services Availability API not found. Google Play Services not enabled.";
        }
    }

    static final class b extends Lambda implements Function0 {
        public static final b b = new b();

        b() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services is available.";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services is unavailable. Connection result: " + this.b;
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unexpected exception while checking for com.google.android.gsf";
        }
    }

    private f() {
    }

    public static final boolean a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Class.forName("com.google.android.gms.common.GoogleApiAvailability");
            int isGooglePlayServicesAvailable = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(context);
            if (isGooglePlayServicesAvailable == 0) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b.b, 3, (Object) null);
                return true;
            }
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) a, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new c(isGooglePlayServicesAvailable), 3, (Object) null);
            return false;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.I, (Throwable) e, (Function0<String>) a.b);
            return false;
        }
    }

    public static final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            if (Build.VERSION.SDK_INT >= 33) {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", PackageManager.PackageInfoFlags.of(0));
            } else {
                context.getPackageManager().getPackageInfo("com.google.android.gsf", 0);
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) a, BrazeLogger.Priority.W, (Throwable) e, (Function0<String>) d.b);
            return false;
        }
    }
}
