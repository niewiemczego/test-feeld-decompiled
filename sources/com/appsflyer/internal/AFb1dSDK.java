package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.appsflyer.internal.AFb1gSDK;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

public final class AFb1dSDK implements AFb1gSDK {
    private AFb1cSDK AFKeystoreWrapper;
    private final AFa1tSDK valueOf;
    private final Executor values;

    public AFb1dSDK(Executor executor, AFa1tSDK aFa1tSDK) {
        Intrinsics.checkNotNullParameter(executor, "");
        Intrinsics.checkNotNullParameter(aFa1tSDK, "");
        this.values = executor;
        this.valueOf = aFa1tSDK;
    }

    public final void AFKeystoreWrapper(Context context, AFb1gSDK.AFa1zSDK aFa1zSDK) {
        Intrinsics.checkNotNullParameter(context, "");
        Intrinsics.checkNotNullParameter(aFa1zSDK, "");
        Intrinsics.checkNotNullParameter(context, "");
        if (this.AFKeystoreWrapper != null) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null) {
                ((Application) applicationContext).unregisterActivityLifecycleCallbacks(this.AFKeystoreWrapper);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
            }
        }
        this.AFKeystoreWrapper = null;
        AFb1cSDK aFb1cSDK = new AFb1cSDK(this.values, this.valueOf, aFa1zSDK);
        this.AFKeystoreWrapper = aFb1cSDK;
        if (context instanceof Activity) {
            aFb1cSDK.onActivityResumed((Activity) context);
        }
        Context applicationContext2 = context.getApplicationContext();
        if (applicationContext2 != null) {
            ((Application) applicationContext2).registerActivityLifecycleCallbacks(this.AFKeystoreWrapper);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Application");
    }

    public final boolean AFKeystoreWrapper() {
        return this.AFKeystoreWrapper != null;
    }

    public final void AFKeystoreWrapper(Context context) {
        AFb1gSDK.AFa1zSDK aFa1zSDK;
        Intrinsics.checkNotNullParameter(context, "");
        AFb1cSDK aFb1cSDK = this.AFKeystoreWrapper;
        if (aFb1cSDK != null && (aFa1zSDK = aFb1cSDK.values) != null) {
            aFa1zSDK.AFInAppEventType(context);
        }
    }
}
