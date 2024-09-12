package com.facebook.appevents.iap;

import android.content.SharedPreferences;
import com.facebook.FacebookSdk;
import com.facebook.appevents.internal.AutomaticAnalyticsLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0010\t\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J-\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\rH\u0001¢\u0006\u0002\b\u0017J\r\u0010\u0018\u001a\u00020\u0019H\u0001¢\u0006\u0002\b\u001aJC\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u00142\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\u00142\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0001¢\u0006\u0002\b\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0007J2\u0010 \u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00150\r2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0014H\u0007J\u001c\u0010!\u001a\u00020\u00192\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0014H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/facebook/appevents/iap/InAppPurchaseLoggerManager;", "", "()V", "CACHE_CLEAR_TIME_LIMIT_SEC", "", "LAST_CLEARED_TIME", "", "LAST_QUERY_PURCHASE_HISTORY_TIME", "PRODUCT_DETAILS_STORE", "PURCHASE_DETAILS_SET", "PURCHASE_IN_CACHE_INTERVAL", "PURCHASE_TIME", "cachedPurchaseMap", "", "", "cachedPurchaseSet", "", "sharedPreferences", "Landroid/content/SharedPreferences;", "cacheDeDupPurchase", "", "Lorg/json/JSONObject;", "purchaseDetailsMap", "cacheDeDupPurchase$facebook_core_release", "clearOutdatedProductInfoInCache", "", "clearOutdatedProductInfoInCache$facebook_core_release", "constructLoggingReadyMap", "skuDetailsMap", "constructLoggingReadyMap$facebook_core_release", "eligibleQueryPurchaseHistory", "", "filterPurchaseLogging", "logPurchases", "readPurchaseCache", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: InAppPurchaseLoggerManager.kt */
public final class InAppPurchaseLoggerManager {
    private static final int CACHE_CLEAR_TIME_LIMIT_SEC = 604800;
    public static final InAppPurchaseLoggerManager INSTANCE = new InAppPurchaseLoggerManager();
    private static final String LAST_CLEARED_TIME = "LAST_CLEARED_TIME";
    private static final String LAST_QUERY_PURCHASE_HISTORY_TIME = "LAST_QUERY_PURCHASE_HISTORY_TIME";
    private static final String PRODUCT_DETAILS_STORE = "com.facebook.internal.iap.PRODUCT_DETAILS";
    private static final String PURCHASE_DETAILS_SET = "PURCHASE_DETAILS_SET";
    private static final int PURCHASE_IN_CACHE_INTERVAL = 86400;
    private static final String PURCHASE_TIME = "purchaseTime";
    private static final Map<String, Long> cachedPurchaseMap = new ConcurrentHashMap();
    private static final Set<String> cachedPurchaseSet = new CopyOnWriteArraySet();
    private static SharedPreferences sharedPreferences;

    private InAppPurchaseLoggerManager() {
    }

    private final void readPurchaseCache() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
                SharedPreferences sharedPreferences2 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.SKU_DETAILS", 0);
                FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
                SharedPreferences sharedPreferences3 = FacebookSdk.getApplicationContext().getSharedPreferences("com.facebook.internal.PURCHASE", 0);
                if (sharedPreferences2.contains(LAST_CLEARED_TIME)) {
                    sharedPreferences2.edit().clear().apply();
                    sharedPreferences3.edit().clear().apply();
                }
                FacebookSdk facebookSdk3 = FacebookSdk.INSTANCE;
                SharedPreferences sharedPreferences4 = FacebookSdk.getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, 0);
                Intrinsics.checkNotNullExpressionValue(sharedPreferences4, "getApplicationContext().getSharedPreferences(PRODUCT_DETAILS_STORE, Context.MODE_PRIVATE)");
                sharedPreferences = sharedPreferences4;
                Set<String> set = cachedPurchaseSet;
                if (sharedPreferences4 != null) {
                    Collection stringSet = sharedPreferences4.getStringSet(PURCHASE_DETAILS_SET, new HashSet());
                    if (stringSet == null) {
                        stringSet = new HashSet();
                    }
                    set.addAll(stringSet);
                    for (String split$default : set) {
                        List split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{";"}, false, 2, 2, (Object) null);
                        cachedPurchaseMap.put(split$default2.get(0), Long.valueOf(Long.parseLong((String) split$default2.get(1))));
                    }
                    clearOutdatedProductInfoInCache$facebook_core_release();
                    return;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @JvmStatic
    public static final void filterPurchaseLogging(Map<String, JSONObject> map, Map<String, ? extends JSONObject> map2) {
        Class<InAppPurchaseLoggerManager> cls = InAppPurchaseLoggerManager.class;
        if (!CrashShieldHandler.isObjectCrashing(cls)) {
            try {
                Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
                Intrinsics.checkNotNullParameter(map2, "skuDetailsMap");
                InAppPurchaseLoggerManager inAppPurchaseLoggerManager = INSTANCE;
                inAppPurchaseLoggerManager.readPurchaseCache();
                inAppPurchaseLoggerManager.logPurchases(inAppPurchaseLoggerManager.constructLoggingReadyMap$facebook_core_release(inAppPurchaseLoggerManager.cacheDeDupPurchase$facebook_core_release(map), map2));
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, cls);
            }
        }
    }

    private final void logPurchases(Map<String, String> map) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                for (Map.Entry next : map.entrySet()) {
                    String str = (String) next.getKey();
                    String str2 = (String) next.getValue();
                    if (!(str == null || str2 == null)) {
                        AutomaticAnalyticsLogger automaticAnalyticsLogger = AutomaticAnalyticsLogger.INSTANCE;
                        AutomaticAnalyticsLogger.logPurchase(str, str2, false);
                    }
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    public final Map<String, JSONObject> cacheDeDupPurchase$facebook_core_release(Map<String, JSONObject> map) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            for (Map.Entry next : MapsKt.toMap(map).entrySet()) {
                String str = (String) next.getKey();
                JSONObject jSONObject = (JSONObject) next.getValue();
                try {
                    if (jSONObject.has(SDKConstants.PARAM_PURCHASE_TOKEN)) {
                        String string = jSONObject.getString(SDKConstants.PARAM_PURCHASE_TOKEN);
                        if (cachedPurchaseMap.containsKey(string)) {
                            map.remove(str);
                        } else {
                            cachedPurchaseSet.add(string + ';' + currentTimeMillis);
                        }
                    }
                } catch (Exception unused) {
                }
            }
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                sharedPreferences2.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).apply();
                return new HashMap<>(map);
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }

    public final void clearOutdatedProductInfoInCache$facebook_core_release() {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                SharedPreferences sharedPreferences2 = sharedPreferences;
                if (sharedPreferences2 != null) {
                    long j = sharedPreferences2.getLong(LAST_CLEARED_TIME, 0);
                    if (j == 0) {
                        SharedPreferences sharedPreferences3 = sharedPreferences;
                        if (sharedPreferences3 != null) {
                            sharedPreferences3.edit().putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                            throw null;
                        }
                    } else if (currentTimeMillis - j > 604800) {
                        for (Map.Entry next : MapsKt.toMap(cachedPurchaseMap).entrySet()) {
                            String str = (String) next.getKey();
                            long longValue = ((Number) next.getValue()).longValue();
                            if (currentTimeMillis - longValue > 86400) {
                                cachedPurchaseSet.remove(str + ';' + longValue);
                                cachedPurchaseMap.remove(str);
                            }
                        }
                        SharedPreferences sharedPreferences4 = sharedPreferences;
                        if (sharedPreferences4 != null) {
                            sharedPreferences4.edit().putStringSet(PURCHASE_DETAILS_SET, cachedPurchaseSet).putLong(LAST_CLEARED_TIME, currentTimeMillis).apply();
                        } else {
                            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                            throw null;
                        }
                    }
                } else {
                    Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                    throw null;
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        }
    }

    @JvmStatic
    public static final boolean eligibleQueryPurchaseHistory() {
        Class<InAppPurchaseLoggerManager> cls = InAppPurchaseLoggerManager.class;
        if (CrashShieldHandler.isObjectCrashing(cls)) {
            return false;
        }
        try {
            INSTANCE.readPurchaseCache();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            SharedPreferences sharedPreferences2 = sharedPreferences;
            if (sharedPreferences2 != null) {
                long j = sharedPreferences2.getLong(LAST_QUERY_PURCHASE_HISTORY_TIME, 0);
                if (j != 0 && currentTimeMillis - j < ((long) PURCHASE_IN_CACHE_INTERVAL)) {
                    return false;
                }
                SharedPreferences sharedPreferences3 = sharedPreferences;
                if (sharedPreferences3 != null) {
                    sharedPreferences3.edit().putLong(LAST_QUERY_PURCHASE_HISTORY_TIME, currentTimeMillis).apply();
                    return true;
                }
                Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
                throw null;
            }
            Intrinsics.throwUninitializedPropertyAccessException("sharedPreferences");
            throw null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, cls);
            return false;
        }
    }

    public final Map<String, String> constructLoggingReadyMap$facebook_core_release(Map<String, ? extends JSONObject> map, Map<String, ? extends JSONObject> map2) {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(map, "purchaseDetailsMap");
            Intrinsics.checkNotNullParameter(map2, "skuDetailsMap");
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            Map<String, String> linkedHashMap = new LinkedHashMap<>();
            for (Map.Entry next : map.entrySet()) {
                JSONObject jSONObject = (JSONObject) next.getValue();
                JSONObject jSONObject2 = (JSONObject) map2.get((String) next.getKey());
                if (jSONObject != null && jSONObject.has(PURCHASE_TIME)) {
                    try {
                        if (currentTimeMillis - (jSONObject.getLong(PURCHASE_TIME) / 1000) <= 86400) {
                            if (jSONObject2 != null) {
                                String jSONObject3 = jSONObject.toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject3, "purchaseDetail.toString()");
                                String jSONObject4 = jSONObject2.toString();
                                Intrinsics.checkNotNullExpressionValue(jSONObject4, "skuDetail.toString()");
                                linkedHashMap.put(jSONObject3, jSONObject4);
                            }
                        }
                    } catch (Exception unused) {
                    }
                }
            }
            return linkedHashMap;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
            return null;
        }
    }
}
