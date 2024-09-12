package com.facebook.appevents.iap;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import com.facebook.FacebookSdk;
import com.facebook.internal.FeatureManager;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0007J\b\u0010\t\u001a\u00020\bH\u0007J\b\u0010\n\u001a\u00020\u000bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseManager;", "", "()V", "GOOGLE_BILLINGCLIENT_VERSION", "", "enabled", "Ljava/util/concurrent/atomic/AtomicBoolean;", "enableAutoLogging", "", "startTracking", "usingBillingLib2Plus", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseManager.kt */
public final class InAppPurchaseManager {
    private static final String GOOGLE_BILLINGCLIENT_VERSION = "com.google.android.play.billingclient.version";
    public static final InAppPurchaseManager INSTANCE = new InAppPurchaseManager();
    private static final AtomicBoolean enabled = new AtomicBoolean(false);

    private InAppPurchaseManager() {
    }

    @JvmStatic
    public static final void enableAutoLogging() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                enabled.set(true);
                startTracking();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    @JvmStatic
    public static final void startTracking() {
        Class<InAppPurchaseManager> cls = InAppPurchaseManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                if (enabled.get()) {
                    if (INSTANCE.usingBillingLib2Plus()) {
                        FeatureManager featureManager = FeatureManager.INSTANCE;
                        if (FeatureManager.isEnabled(FeatureManager.Feature.IapLoggingLib2)) {
                            InAppPurchaseAutoLogger inAppPurchaseAutoLogger = InAppPurchaseAutoLogger.INSTANCE;
                            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                            InAppPurchaseAutoLogger.startIapLogging(FacebookSdk.getApplicationContext());
                            return;
                        }
                    }
                    InAppPurchaseActivityLifecycleTracker inAppPurchaseActivityLifecycleTracker = InAppPurchaseActivityLifecycleTracker.INSTANCE;
                    InAppPurchaseActivityLifecycleTracker.startIapLogging();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final boolean usingBillingLib2Plus() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return false;
        }
        try {
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            Context applicationContext = FacebookSdk.getApplicationContext();
            ApplicationInfo applicationInfo = applicationContext.getPackageManager().getApplicationInfo(applicationContext.getPackageName(), 128);
            Intrinsics.checkNotNullExpressionValue(applicationInfo, "context.packageManager.getApplicationInfo(\n              context.packageName, PackageManager.GET_META_DATA)");
            String string = applicationInfo.metaData.getString(GOOGLE_BILLINGCLIENT_VERSION);
            if (string != null && Integer.parseInt((String) StringsKt.split$default((CharSequence) string, new String[]{"."}, false, 3, 2, (Object) null).get(0)) >= 2) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return false;
        }
    }
}
