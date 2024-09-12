package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import java.util.Map;
import org.json.JSONException;

public final class AFb1oSDK {
    public final double AFInAppEventParameterName;

    public AFb1oSDK() {
    }

    private static void AFInAppEventType(Map<String, String> map) {
        if (AFb1xSDK.valueOf != null) {
            try {
                AFLogger.afDebugLog(new StringBuilder("Calling onAppOpenAttribution with:\n").append(map.toString()).toString());
                AFb1xSDK.valueOf.onAppOpenAttribution(map);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    private static void AFKeystoreWrapper(String str) {
        if (AFb1xSDK.valueOf != null) {
            try {
                AFLogger.afDebugLog("Calling onAppOpenAttributionFailure with: ".concat(String.valueOf(str)));
                AFb1xSDK.valueOf.onAttributionFailure(str);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        }
    }

    public static void values(String str, DeepLinkResult.Error error) {
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onAppOpenAttributionNative().values != null) {
            AFLogger.afDebugLog("[DDL] Error occurred: ".concat(String.valueOf(str)));
            AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, error));
            return;
        }
        AFKeystoreWrapper(str);
    }

    public static void valueOf(Map<String, String> map) {
        DeepLinkResult deepLinkResult;
        if (AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onAppOpenAttributionNative().values != null) {
            try {
                DeepLink AFInAppEventParameterName2 = DeepLink.AFInAppEventParameterName(map);
                AFInAppEventParameterName2.AFInAppEventType.put("is_deferred", false);
                deepLinkResult = new DeepLinkResult(AFInAppEventParameterName2, (DeepLinkResult.Error) null);
            } catch (JSONException e) {
                AFLogger.afErrorLog("[DDL] Error occurred", e, true);
                deepLinkResult = new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.UNEXPECTED);
            } catch (Throwable th) {
                AFInAppEventParameterName(new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null));
                throw th;
            }
            AFInAppEventParameterName(deepLinkResult);
            return;
        }
        AFInAppEventType(map);
    }

    static void AFInAppEventParameterName(DeepLinkResult deepLinkResult) {
        AFa1tSDK onAppOpenAttributionNative = AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().onAppOpenAttributionNative();
        if (onAppOpenAttributionNative.values != null) {
            AFLogger.afDebugLog(new StringBuilder("[DDL] Calling onDeepLinking with:\n").append(deepLinkResult.toString()).toString());
            try {
                onAppOpenAttributionNative.values.onDeepLinking(deepLinkResult);
            } catch (Throwable th) {
                AFLogger.afErrorLog(th.getLocalizedMessage(), th);
            }
        } else {
            AFLogger.afDebugLog("[DDL] skipping, no callback registered");
        }
    }

    public AFb1oSDK(double d) {
        this.AFInAppEventParameterName = d;
    }
}
