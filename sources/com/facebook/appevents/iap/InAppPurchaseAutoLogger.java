package com.facebook.appevents.iap;

import android.content.Context;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseAutoLogger;", "", "()V", "BILLING_CLIENT_PURCHASE_NAME", "", "logPurchase", "", "startIapLogging", "context", "Landroid/content/Context;", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseAutoLogger.kt */
public final class InAppPurchaseAutoLogger {
    private static final String BILLING_CLIENT_PURCHASE_NAME = "com.android.billingclient.api.Purchase";
    public static final InAppPurchaseAutoLogger INSTANCE = new InAppPurchaseAutoLogger();

    private InAppPurchaseAutoLogger() {
    }

    @JvmStatic
    public static final void startIapLogging(Context context) {
        InAppPurchaseBillingClientWrapper orCreateInstance;
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(context, "context");
                InAppPurchaseUtils inAppPurchaseUtils = InAppPurchaseUtils.INSTANCE;
                if (InAppPurchaseUtils.getClass(BILLING_CLIENT_PURCHASE_NAME) != null && (orCreateInstance = InAppPurchaseBillingClientWrapper.Companion.getOrCreateInstance(context)) != null && InAppPurchaseBillingClientWrapper.Companion.isServiceConnected().get()) {
                    InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                    if (InAppPurchaseLoggerManager.eligibleQueryPurchaseHistory()) {
                        orCreateInstance.queryPurchaseHistory("inapp", new InAppPurchaseAutoLogger$$ExternalSyntheticLambda0());
                    } else {
                        orCreateInstance.queryPurchase("inapp", new InAppPurchaseAutoLogger$$ExternalSyntheticLambda1());
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-0  reason: not valid java name */
    public static final void m267startIapLogging$lambda0() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startIapLogging$lambda-1  reason: not valid java name */
    public static final void m268startIapLogging$lambda1() {
        Class<InAppPurchaseAutoLogger> cls = InAppPurchaseAutoLogger.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                INSTANCE.logPurchase();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void logPurchase() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = InAppPurchaseLoggerManager.INSTANCE;
                InAppPurchaseLoggerManager.filterPurchaseLogging(InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap(), InAppPurchaseBillingClientWrapper.Companion.getSkuDetailsMap());
                InAppPurchaseBillingClientWrapper.Companion.getPurchaseDetailsMap().clear();
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }
}
