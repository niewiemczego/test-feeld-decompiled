package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.appsflyer.AFLogger;
import com.appsflyer.internal.AFb1gSDK;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

final class AFb1cSDK implements Application.ActivityLifecycleCallbacks {
    private final Executor AFInAppEventParameterName;
    /* access modifiers changed from: package-private */
    public boolean AFInAppEventType;
    /* access modifiers changed from: private */
    public boolean AFKeystoreWrapper;
    private final AFa1tSDK valueOf;
    final AFb1gSDK.AFa1zSDK values;

    public final void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        Intrinsics.checkNotNullParameter(bundle, "");
    }

    public final void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    public final void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
    }

    public AFb1cSDK(Executor executor, AFa1tSDK aFa1tSDK, AFb1gSDK.AFa1zSDK aFa1zSDK) {
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        Intrinsics.checkNotNullParameter(aFa1zSDK, "");
        this.AFInAppEventParameterName = executor;
        this.valueOf = aFa1tSDK;
        this.values = aFa1zSDK;
    }

    public final void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.AFInAppEventParameterName.execute(new AFb1cSDK$$ExternalSyntheticLambda0(this, activity));
    }

    /* access modifiers changed from: private */
    public static final void valueOf(AFb1cSDK aFb1cSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        if (!aFb1cSDK.AFInAppEventType) {
            try {
                aFb1cSDK.values.AFInAppEventType(activity);
            } catch (Exception e) {
                AFLogger.afErrorLog("Listener thrown an exception: ", e, true);
            }
        }
        aFb1cSDK.AFKeystoreWrapper = false;
        aFb1cSDK.AFInAppEventType = true;
    }

    public final void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.AFInAppEventParameterName.execute(new AFb1cSDK$$ExternalSyntheticLambda2(this, activity));
    }

    /* access modifiers changed from: private */
    public static final void AFInAppEventType(AFb1cSDK aFb1cSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        aFb1cSDK.AFKeystoreWrapper = true;
        Context applicationContext = activity.getApplicationContext();
        try {
            AFb1gSDK.AFa1ySDK aFa1ySDK = AFb1gSDK.AFa1ySDK;
            new Timer().schedule(new AFa1xSDK(aFb1cSDK, applicationContext), AFb1gSDK.AFa1ySDK.AFInAppEventType());
        } catch (Throwable th) {
            AFLogger.afErrorLog("Background task failed with a throwable: ", th);
        }
    }

    public static final class AFa1xSDK extends TimerTask {
        private /* synthetic */ AFb1cSDK AFInAppEventParameterName;
        private /* synthetic */ Context values;

        AFa1xSDK(AFb1cSDK aFb1cSDK, Context context) {
            this.AFInAppEventParameterName = aFb1cSDK;
            this.values = context;
        }

        public final void run() {
            if (this.AFInAppEventParameterName.AFInAppEventType && this.AFInAppEventParameterName.AFKeystoreWrapper) {
                this.AFInAppEventParameterName.AFInAppEventType = false;
                try {
                    this.AFInAppEventParameterName.values.AFInAppEventType(this.values);
                } catch (Exception e) {
                    AFLogger.afErrorLog("Listener threw exception! ", e);
                }
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "");
        this.AFInAppEventParameterName.execute(new AFb1cSDK$$ExternalSyntheticLambda1(this, activity));
    }

    /* access modifiers changed from: private */
    public static final void AFKeystoreWrapper(AFb1cSDK aFb1cSDK, Activity activity) {
        Intrinsics.checkNotNullParameter(aFb1cSDK, "");
        Intrinsics.checkNotNullParameter(activity, "");
        AFa1tSDK aFa1tSDK = aFb1cSDK.valueOf;
        AFa1tSDK.valueOf(activity.getIntent());
    }
}
