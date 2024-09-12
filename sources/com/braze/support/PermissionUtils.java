package com.braze.support;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.braze.support.BrazeLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\u0014\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0001\u001a\f\u0010\r\u001a\u00020\n*\u0004\u0018\u00010\u000e\u001a\f\u0010\u000f\u001a\u00020\f*\u0004\u0018\u00010\u000e\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"NOTIFICATION_PERMISSION", "", "PERMISSION_STORAGE_PREFS_FILE", "TAG", "getPermissionRequestCount", "", "context", "Landroid/content/Context;", "permission", "incrementPermissionRequestCount", "", "hasPermission", "", "requestPushPermissionPrompt", "Landroid/app/Activity;", "wouldPushPermissionPromptDisplay", "android-sdk-base_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class PermissionUtils {
    private static final String NOTIFICATION_PERMISSION = "android.permission.POST_NOTIFICATIONS";
    private static final String PERMISSION_STORAGE_PREFS_FILE = "com.braze.support.permission_util.requested_perms";
    private static final String TAG = BrazeLogger.INSTANCE.getBrazeLogTag("PermissionUtils");

    static final class a extends Lambda implements Function0 {
        final /* synthetic */ String b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.b = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failure checking permission " + this.b;
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Incrementing permission request counter to " + this.b + '.';
        }
    }

    static final class c extends Lambda implements Function0 {
        public static final c b = new c();

        c() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Attempting to execute requestPushPermissionPrompt()";
        }
    }

    static final class d extends Lambda implements Function0 {
        public static final d b = new d();

        d() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot request push permission with null Activity.";
        }
    }

    static final class e extends Lambda implements Function0 {
        public static final e b = new e();

        e() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Permission prompt would not display, not attempting to request push permission prompt.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Requesting push permission from system.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Cannot request push permission with null Activity.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Device API version of " + Build.VERSION.SDK_INT + " is too low to display push permission prompt.";
        }
    }

    static final class i extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "App Target API version of " + this.b + " is too low to display push permission prompt.";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Notification permission already granted, doing nothing.";
        }
    }

    static final class k extends Lambda implements Function0 {
        final /* synthetic */ int b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(int i) {
            super(0);
            this.b = i;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Notification permission request count is " + this.b + ". Returning value of 'shouldShowRequestPermissionRationale(NOTIFICATION_PERMISSION)'";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Push Prompt can be shown on this device, within a reasonable confidence.";
        }
    }

    public static final int getPermissionRequestCount(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "permission");
        return context.getSharedPreferences(PERMISSION_STORAGE_PREFS_FILE, 0).getInt(str, 0);
    }

    public static final boolean hasPermission(Context context, String str) {
        Intrinsics.checkNotNullParameter(str, "permission");
        if (context == null) {
            return false;
        }
        try {
            return context.checkCallingOrSelfPermission(str) == 0;
        } catch (Throwable th) {
            BrazeLogger.INSTANCE.brazelog(TAG, BrazeLogger.Priority.E, th, (Function0<String>) new a(str));
            return false;
        }
    }

    public static final void incrementPermissionRequestCount(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "permission");
        SharedPreferences sharedPreferences = context.getSharedPreferences(PERMISSION_STORAGE_PREFS_FILE, 0);
        int i2 = sharedPreferences.getInt(str, 0) + 1;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new b(i2), 6, (Object) null);
        sharedPreferences.edit().putInt(str, i2).apply();
    }

    public static final void requestPushPermissionPrompt(Activity activity) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        String str = TAG;
        BrazeLogger.Priority priority = BrazeLogger.Priority.V;
        BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, (Function0) c.b, 4, (Object) null);
        if (activity == null) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d.b, 6, (Object) null);
        } else if (!wouldPushPermissionPromptDisplay(activity) || Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(brazeLogger, str, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e.b, 6, (Object) null);
        } else {
            incrementPermissionRequestCount(activity, "android.permission.POST_NOTIFICATIONS");
            BrazeLogger.brazelog$default(brazeLogger, str, priority, (Throwable) null, (Function0) f.b, 4, (Object) null);
            activity.requestPermissions(new String[]{"android.permission.POST_NOTIFICATIONS"}, IntentUtils.getRequestCode());
        }
    }

    public static final boolean wouldPushPermissionPromptDisplay(Activity activity) {
        if (activity == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, (BrazeLogger.Priority) null, (Throwable) null, (Function0) g.b, 6, (Object) null);
            return false;
        } else if (Build.VERSION.SDK_INT < 33) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, (Function0) h.b, 4, (Object) null);
            return false;
        } else {
            int i2 = activity.getApplicationInfo().targetSdkVersion;
            if (i2 < 33) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, (Function0) new i(i2), 4, (Object) null);
                return false;
            } else if (hasPermission(activity, "android.permission.POST_NOTIFICATIONS")) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, (Function0) j.b, 4, (Object) null);
                return false;
            } else {
                int permissionRequestCount = getPermissionRequestCount(activity, "android.permission.POST_NOTIFICATIONS");
                if (permissionRequestCount >= 2) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.I, (Throwable) null, (Function0) new k(permissionRequestCount), 4, (Object) null);
                    return activity.shouldShowRequestPermissionRationale("android.permission.POST_NOTIFICATIONS");
                }
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, TAG, BrazeLogger.Priority.V, (Throwable) null, (Function0) l.b, 4, (Object) null);
                return true;
            }
        }
    }
}
