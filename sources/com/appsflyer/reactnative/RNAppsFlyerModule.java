package com.appsflyer.reactnative;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.deeplink.DeepLinkListener;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.platform_extension.Plugin;
import com.appsflyer.internal.platform_extension.PluginInfo;
import com.appsflyer.share.CrossPromotionHelper;
import com.appsflyer.share.LinkGenerator;
import com.appsflyer.share.ShareInviteHelper;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.login.LoginLogger;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.net.URI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RNAppsFlyerModule extends ReactContextBaseJavaModule {
    private Application application;
    private String personalDevKey = "";
    /* access modifiers changed from: private */
    public ReactApplicationContext reactContext;

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return "RNAppsFlyer";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public RNAppsFlyerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.reactContext = reactApplicationContext;
        this.application = (Application) reactApplicationContext.getApplicationContext();
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("ACHIEVEMENT_UNLOCKED", AFInAppEventType.ACHIEVEMENT_UNLOCKED);
        hashMap.put(ViewHierarchyConstants.ADD_PAYMENT_INFO, AFInAppEventType.ADD_PAYMENT_INFO);
        hashMap.put(ViewHierarchyConstants.ADD_TO_CART, AFInAppEventType.ADD_TO_CART);
        hashMap.put("ADD_TO_WISH_LIST", AFInAppEventType.ADD_TO_WISH_LIST);
        hashMap.put(ViewHierarchyConstants.COMPLETE_REGISTRATION, AFInAppEventType.COMPLETE_REGISTRATION);
        hashMap.put("CONTENT_VIEW", AFInAppEventType.CONTENT_VIEW);
        hashMap.put("INITIATED_CHECKOUT", AFInAppEventType.INITIATED_CHECKOUT);
        hashMap.put("INVITE", AFInAppEventType.INVITE);
        hashMap.put("LEVEL_ACHIEVED", AFInAppEventType.LEVEL_ACHIEVED);
        hashMap.put("LOCATION_CHANGED", AFInAppEventType.LOCATION_CHANGED);
        hashMap.put("LOCATION_COORDINATES", AFInAppEventType.LOCATION_COORDINATES);
        hashMap.put("LOGIN", AFInAppEventType.LOGIN);
        hashMap.put("OPENED_FROM_PUSH_NOTIFICATION", AFInAppEventType.OPENED_FROM_PUSH_NOTIFICATION);
        hashMap.put("ORDER_ID", "af_order_id");
        hashMap.put(ViewHierarchyConstants.PURCHASE, AFInAppEventType.PURCHASE);
        hashMap.put("RATE", AFInAppEventType.RATE);
        hashMap.put("RE_ENGAGE", AFInAppEventType.RE_ENGAGE);
        hashMap.put(ViewHierarchyConstants.SEARCH, AFInAppEventType.SEARCH);
        hashMap.put("SHARE", AFInAppEventType.SHARE);
        hashMap.put("SPENT_CREDIT", AFInAppEventType.SPENT_CREDIT);
        hashMap.put("TRAVEL_BOOKING", AFInAppEventType.TRAVEL_BOOKING);
        hashMap.put("TUTORIAL_COMPLETION", AFInAppEventType.TUTORIAL_COMPLETION);
        hashMap.put("UPDATE", AFInAppEventType.UPDATE);
        return hashMap;
    }

    @ReactMethod
    public void initSdkWithCallBack(ReadableMap readableMap, Callback callback, Callback callback2) {
        try {
            String callSdkInternal = callSdkInternal(readableMap);
            if (callSdkInternal == null) {
                callback.invoke("Success");
                return;
            }
            callback2.invoke(new Exception(callSdkInternal).getMessage());
        } catch (Exception e) {
            callback2.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void initSdkWithPromise(ReadableMap readableMap, Promise promise) {
        try {
            String callSdkInternal = callSdkInternal(readableMap);
            if (callSdkInternal == null) {
                promise.resolve("Success");
            } else {
                promise.reject(callSdkInternal, new Exception(callSdkInternal).getMessage());
            }
        } catch (Exception e) {
            promise.reject("AF Unknown Error", (Throwable) e);
        }
    }

    private String callSdkInternal(ReadableMap readableMap) {
        AppsFlyerLib instance = AppsFlyerLib.getInstance();
        JSONObject readableMapToJson = RNUtil.readableMapToJson(readableMap);
        String optString = readableMapToJson.optString("devKey", "");
        if (optString.trim().equals("")) {
            return "No 'devKey' found or its empty";
        }
        this.personalDevKey = optString;
        boolean optBoolean = readableMapToJson.optBoolean("isDebug", false);
        instance.setDebugLog(optBoolean);
        boolean optBoolean2 = readableMapToJson.optBoolean("onInstallConversionDataListener", true);
        if (optBoolean) {
            Log.d("AppsFlyer", "Starting SDK");
        }
        boolean optBoolean3 = readableMapToJson.optBoolean("onDeepLinkListener", false);
        boolean optBoolean4 = readableMapToJson.optBoolean("manualStart", false);
        instance.setPluginInfo(new PluginInfo(isExpoApp() ? Plugin.EXPO : Plugin.REACT_NATIVE, "6.10.3"));
        instance.init(optString, optBoolean2 ? registerConversionListener() : null, this.application.getApplicationContext());
        if (optBoolean3) {
            instance.subscribeForDeepLink(registerDeepLinkListener());
        }
        if (!optBoolean4) {
            startSdk();
        }
        return null;
    }

    private boolean isExpoApp() {
        try {
            Class.forName("expo.modules.devmenu.react.DevMenuAwareReactActivity");
            return true;
        } catch (ClassNotFoundException | Exception unused) {
            return false;
        }
    }

    private DeepLinkListener registerDeepLinkListener() {
        return new DeepLinkListener() {
            public void onDeepLinking(DeepLinkResult deepLinkResult) {
                JSONObject jSONObject = new JSONObject();
                DeepLinkResult.Error error = deepLinkResult.getError();
                try {
                    jSONObject.put("deepLinkStatus", (Object) deepLinkResult.getStatus());
                    jSONObject.put("status", (Object) "success");
                    jSONObject.put("type", (Object) "onDeepLinking");
                    if (error != null) {
                        if (deepLinkResult.getStatus() == DeepLinkResult.Status.ERROR) {
                            jSONObject.put("status", (Object) LoginLogger.EVENT_EXTRAS_FAILURE);
                            jSONObject.put("data", (Object) error.toString());
                            jSONObject.put("isDeferred", false);
                            RNAppsFlyerModule rNAppsFlyerModule = RNAppsFlyerModule.this;
                            rNAppsFlyerModule.sendEvent(rNAppsFlyerModule.reactContext, "onDeepLinking", jSONObject.toString());
                        }
                    }
                    if (deepLinkResult.getStatus() == DeepLinkResult.Status.FOUND) {
                        jSONObject.put("data", (Object) deepLinkResult.getDeepLink().getClickEvent());
                        jSONObject.put("isDeferred", (Object) deepLinkResult.getDeepLink().isDeferred());
                    } else {
                        jSONObject.put("data", (Object) "deep link not found");
                        jSONObject.put("isDeferred", false);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                try {
                    RNAppsFlyerModule rNAppsFlyerModule2 = RNAppsFlyerModule.this;
                    rNAppsFlyerModule2.sendEvent(rNAppsFlyerModule2.reactContext, "onDeepLinking", jSONObject.toString());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
    }

    private AppsFlyerConversionListener registerConversionListener() {
        return new AppsFlyerConversionListener() {
            public void onAppOpenAttribution(Map<String, String> map) {
                RNAppsFlyerModule.this.handleSuccess("onAppOpenAttribution", (Map<String, Object>) null, map);
            }

            public void onAttributionFailure(String str) {
                RNAppsFlyerModule.this.handleError("onAttributionFailure", str);
            }

            public void onConversionDataSuccess(Map<String, Object> map) {
                RNAppsFlyerModule.this.handleSuccess("onInstallConversionDataLoaded", map, (Map<String, String>) null);
            }

            public void onConversionDataFail(String str) {
                RNAppsFlyerModule.this.handleError("onInstallConversionFailure", str);
            }
        };
    }

    /* access modifiers changed from: private */
    public void handleSuccess(String str, Map<String, Object> map, Map<String, String> map2) {
        JSONObject jSONObject = new JSONObject();
        try {
            if (map == null) {
                map = map2;
            }
            JSONObject jSONObject2 = new JSONObject((Map<?, ?>) map);
            jSONObject.put("status", (Object) "success");
            jSONObject.put("type", (Object) str);
            jSONObject.put("data", (Object) jSONObject2);
            if (str.equals("onInstallConversionDataLoaded")) {
                sendEvent(this.reactContext, "onInstallConversionDataLoaded", jSONObject.toString());
            } else if (str.equals("onAppOpenAttribution")) {
                sendEvent(this.reactContext, "onAppOpenAttribution", jSONObject.toString());
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void handleError(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", (Object) LoginLogger.EVENT_EXTRAS_FAILURE);
            jSONObject.put("type", (Object) str);
            jSONObject.put("data", (Object) str2);
            sendEvent(this.reactContext, "onInstallConversionDataLoaded", jSONObject.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void sendEvent(ReactContext reactContext2, String str, Object obj) {
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) reactContext2.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(str, obj);
    }

    @ReactMethod
    public void startSdk() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            AppsFlyerLib.getInstance().start(currentActivity, this.personalDevKey);
            return;
        }
        AppsFlyerLib.getInstance().logEvent(this.application, (String) null, (Map<String, Object>) null);
        AppsFlyerLib.getInstance().start(this.application, this.personalDevKey);
    }

    @ReactMethod
    public void logEvent(String str, ReadableMap readableMap, final Callback callback, final Callback callback2) {
        try {
            if (str.trim().equals("")) {
                callback2.invoke("No 'eventName' found or its empty");
                return;
            }
            Map map = RNUtil.toMap(readableMap);
            if (map == null) {
                map = new HashMap();
            }
            if (getCurrentActivity() != null) {
                AppsFlyerLib.getInstance().logEvent(getCurrentActivity(), str, map, new AppsFlyerRequestListener() {
                    public void onSuccess() {
                        callback.invoke("Success");
                    }

                    public void onError(int i, String str) {
                        callback2.invoke(str);
                    }
                });
            }
        } catch (Exception e) {
            callback2.invoke(e.getMessage());
        }
    }

    @ReactMethod
    public void logEventWithPromise(String str, ReadableMap readableMap, final Promise promise) {
        try {
            if (str.trim().equals("")) {
                promise.reject("No 'eventName' found or its empty", new Exception("No 'eventName' found or its empty").getMessage());
                return;
            }
            Map map = RNUtil.toMap(readableMap);
            if (map == null) {
                map = new HashMap();
            }
            if (getCurrentActivity() != null) {
                AppsFlyerLib.getInstance().logEvent(getCurrentActivity(), str, map, new AppsFlyerRequestListener() {
                    public void onSuccess() {
                        promise.resolve("Success");
                    }

                    public void onError(int i, String str) {
                        promise.reject(str);
                    }
                });
            }
        } catch (Exception e) {
            promise.reject("AF Unknown Error", (Throwable) e);
        }
    }

    @ReactMethod
    public void getAppsFlyerUID(Callback callback) {
        callback.invoke(null, AppsFlyerLib.getInstance().getAppsFlyerUID(getReactApplicationContext()));
    }

    @ReactMethod
    public void updateServerUninstallToken(String str, Callback callback) {
        AppsFlyerLib.getInstance().updateServerUninstallToken(getReactApplicationContext(), str);
        if (callback != null) {
            callback.invoke("Success");
        }
    }

    @ReactMethod
    public void setCustomerUserId(String str, Callback callback) {
        AppsFlyerLib.getInstance().setCustomerUserId(str);
        callback.invoke("Success");
    }

    @ReactMethod
    public void setCollectIMEI(boolean z, Callback callback) {
        AppsFlyerLib.getInstance().setCollectIMEI(z);
        if (callback != null) {
            callback.invoke("Success");
        }
    }

    @ReactMethod
    public void setCollectAndroidID(boolean z, Callback callback) {
        AppsFlyerLib.getInstance().setCollectAndroidID(z);
        if (callback != null) {
            callback.invoke("Success");
        }
    }

    @ReactMethod
    public void stop(boolean z, Callback callback) {
        AppsFlyerLib.getInstance().stop(z, getReactApplicationContext());
        callback.invoke("Success");
    }

    @ReactMethod
    public void setAdditionalData(ReadableMap readableMap, Callback callback) {
        try {
            Map map = RNUtil.toMap(readableMap);
            if (map == null) {
                map = new HashMap();
            }
            AppsFlyerLib.getInstance().setAdditionalData(new HashMap(map));
            callback.invoke("Success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void setUserEmails(ReadableMap readableMap, Callback callback, Callback callback2) {
        JSONObject readableMapToJson = RNUtil.readableMapToJson(readableMap);
        int optInt = readableMapToJson.optInt("emailsCryptType", 0);
        JSONArray optJSONArray = readableMapToJson.optJSONArray("emails");
        if (optJSONArray.length() == 0) {
            callback2.invoke(new Exception("No arguments found or list is corrupted").getMessage());
            return;
        }
        AppsFlyerProperties.EmailsCryptType emailsCryptType = AppsFlyerProperties.EmailsCryptType.NONE;
        AppsFlyerProperties.EmailsCryptType[] values = AppsFlyerProperties.EmailsCryptType.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            AppsFlyerProperties.EmailsCryptType emailsCryptType2 = values[i];
            if (emailsCryptType2.getValue() == optInt) {
                emailsCryptType = emailsCryptType2;
                break;
            }
            i++;
        }
        String[] strArr = new String[optJSONArray.length()];
        int i2 = 0;
        while (i2 < optJSONArray.length()) {
            try {
                strArr[i2] = optJSONArray.getString(i2);
                i2++;
            } catch (JSONException e) {
                e.printStackTrace();
                callback2.invoke(new Exception("No arguments found or list is corrupted").getMessage());
                return;
            }
        }
        AppsFlyerLib.getInstance().setUserEmails(emailsCryptType, strArr);
        callback.invoke("Success");
    }

    @ReactMethod
    public void setAppInviteOneLinkID(String str, Callback callback) {
        AppsFlyerLib.getInstance().setAppInviteOneLink(str);
        callback.invoke("Success");
    }

    @ReactMethod
    public void setCurrencyCode(String str, Callback callback) {
        AppsFlyerLib.getInstance().setCurrencyCode(str);
        callback.invoke("Success");
    }

    @ReactMethod
    public void generateInviteLink(ReadableMap readableMap, final Callback callback, final Callback callback2) {
        LinkGenerator generateInviteUrl = ShareInviteHelper.generateInviteUrl(getReactApplicationContext());
        try {
            JSONObject readableMapToJson = RNUtil.readableMapToJson(readableMap);
            String optString = readableMapToJson.optString("channel", "");
            String optString2 = readableMapToJson.optString("campaign", "");
            String optString3 = readableMapToJson.optString("referrerName", "");
            String optString4 = readableMapToJson.optString("referreImageURL", "");
            String optString5 = readableMapToJson.optString("customerID", "");
            String optString6 = readableMapToJson.optString("baseDeepLink", "");
            String optString7 = readableMapToJson.optString("brandDomain", "");
            if (!(optString == null || optString == "")) {
                generateInviteUrl.setChannel(optString);
            }
            if (!(optString2 == null || optString2 == "")) {
                generateInviteUrl.setCampaign(optString2);
            }
            if (!(optString3 == null || optString3 == "")) {
                generateInviteUrl.setReferrerName(optString3);
            }
            if (!(optString4 == null || optString4 == "")) {
                generateInviteUrl.setReferrerImageURL(optString4);
            }
            if (!(optString5 == null || optString5 == "")) {
                generateInviteUrl.setReferrerCustomerId(optString5);
            }
            if (!(optString6 == null || optString6 == "")) {
                generateInviteUrl.setBaseDeeplink(optString6);
            }
            if (!(optString7 == null || optString7 == "")) {
                generateInviteUrl.setBrandDomain(optString7);
            }
            if (readableMapToJson.length() > 1 && !readableMapToJson.get("userParams").equals("")) {
                JSONObject jSONObject = readableMapToJson.getJSONObject("userParams");
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    generateInviteUrl.addParameter(next, jSONObject.get(next).toString());
                }
            }
        } catch (JSONException unused) {
        }
        generateInviteUrl.generateLink((Context) getReactApplicationContext(), (CreateOneLinkHttpTask.ResponseListener) new CreateOneLinkHttpTask.ResponseListener() {
            public void onResponse(String str) {
                callback.invoke(str);
            }

            public void onResponseError(String str) {
                callback2.invoke(str);
            }
        });
    }

    @ReactMethod
    public void logCrossPromotionImpression(String str, String str2, ReadableMap readableMap) {
        try {
            CrossPromotionHelper.logCrossPromoteImpression(getReactApplicationContext(), str, str2, RNUtil.toMap(readableMap));
        } catch (Exception unused) {
            CrossPromotionHelper.logCrossPromoteImpression(getReactApplicationContext(), str, str2);
        }
    }

    @ReactMethod
    public void logCrossPromotionAndOpenStore(String str, String str2, ReadableMap readableMap) {
        Map<String, Object> map;
        try {
            map = RNUtil.toMap(readableMap);
        } catch (Exception unused) {
            map = null;
        }
        CrossPromotionHelper.logAndOpenStore(getReactApplicationContext(), str, str2, map);
    }

    @ReactMethod
    public void anonymizeUser(boolean z, Callback callback) {
        AppsFlyerLib.getInstance().anonymizeUser(z);
        callback.invoke("Success");
    }

    @ReactMethod
    public void setOneLinkCustomDomains(ReadableArray readableArray, Callback callback, Callback callback2) {
        if (readableArray.size() <= 0) {
            callback2.invoke("No arguments found or list is corrupted");
            return;
        }
        List<Object> list = RNUtil.toList(readableArray);
        try {
            AppsFlyerLib.getInstance().setOneLinkCustomDomain((String[]) list.toArray(new String[list.size()]));
            callback.invoke("Success");
        } catch (Exception e) {
            e.printStackTrace();
            callback2.invoke("No arguments found or list is corrupted");
        }
    }

    @ReactMethod
    public void setResolveDeepLinkURLs(ReadableArray readableArray, Callback callback, Callback callback2) {
        if (readableArray.size() <= 0) {
            callback2.invoke("No arguments found or list is corrupted");
            return;
        }
        List<Object> list = RNUtil.toList(readableArray);
        try {
            AppsFlyerLib.getInstance().setResolveDeepLinkURLs((String[]) list.toArray(new String[list.size()]));
            callback.invoke("Success");
        } catch (Exception e) {
            e.printStackTrace();
            callback2.invoke("No arguments found or list is corrupted");
        }
    }

    @ReactMethod
    public void performOnAppAttribution(String str, Callback callback, Callback callback2) {
        try {
            URI create = URI.create(str);
            AppsFlyerLib.getInstance().performOnAppAttribution(this.application.getApplicationContext(), create);
            callback.invoke("Success");
        } catch (Exception e) {
            e.printStackTrace();
            callback2.invoke("Passed string is not a valid URI");
        }
    }

    @ReactMethod
    public void setSharingFilterForPartners(ReadableArray readableArray) {
        List<Object> list = RNUtil.toList(readableArray);
        if (list == null) {
            AppsFlyerLib.getInstance().setSharingFilterForPartners((String[]) null);
            return;
        }
        try {
            AppsFlyerLib.getInstance().setSharingFilterForPartners((String[]) list.toArray(new String[list.size()]));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @ReactMethod
    public void logLocation(double d, double d2, Callback callback) {
        AppsFlyerLib.getInstance().logLocation(getReactApplicationContext(), d2, d);
        callback.invoke("Success");
    }

    @ReactMethod
    public void validateAndLogInAppPurchase(ReadableMap readableMap, Callback callback, Callback callback2) {
        Map<String, String> map;
        ReadableMap readableMap2 = readableMap;
        Callback callback3 = callback2;
        try {
            readableMap2.hasKey("additionalParameters");
            JSONObject readableMapToJson = RNUtil.readableMapToJson(readableMap);
            String optString = readableMapToJson.optString("publicKey", "");
            String optString2 = readableMapToJson.optString("signature", "");
            String optString3 = readableMapToJson.optString("purchaseData", "");
            String optString4 = readableMapToJson.optString(FirebaseAnalytics.Param.PRICE, "");
            String optString5 = readableMapToJson.optString(FirebaseAnalytics.Param.CURRENCY, "");
            if (readableMap2.hasKey("additionalParameters")) {
                map = RNUtil.jsonObjectToMap(readableMapToJson.optJSONObject("additionalParameters"));
            } else {
                map = null;
            }
            Map<String, String> map2 = map;
            if (optString == "" || optString2 == "" || optString3 == "" || optString4 == "" || optString5 == "") {
                callback3.invoke("Please provide purchase parameters");
                return;
            }
            initInAppPurchaseValidatorListener(callback, callback3);
            AppsFlyerLib.getInstance().validateAndLogInAppPurchase(this.reactContext, optString, optString2, optString3, optString4, optString5, map2);
        } catch (Exception e) {
            e.printStackTrace();
            callback3.invoke(e);
        }
    }

    @ReactMethod
    public void initInAppPurchaseValidatorListener(final Callback callback, final Callback callback2) {
        AppsFlyerLib.getInstance().registerValidatorListener(this.reactContext, new AppsFlyerInAppPurchaseValidatorListener() {
            public void onValidateInApp() {
                callback.invoke("In-App Purchase Validation success");
            }

            public void onValidateInAppFailure(String str) {
                callback2.invoke("In-App Purchase Validation failed with error: " + str);
            }
        });
    }

    @ReactMethod
    public void sendPushNotificationData(ReadableMap readableMap, Callback callback) {
        JSONObject readableMapToJson = RNUtil.readableMapToJson(readableMap);
        if (readableMapToJson == null) {
            handleErrorMessage("PushNotification payload is null", callback);
            return;
        }
        try {
            Bundle jsonToBundle = RNUtil.jsonToBundle(readableMapToJson);
            Activity currentActivity = getCurrentActivity();
            if (currentActivity != null) {
                Intent intent = currentActivity.getIntent();
                if (intent != null) {
                    intent.putExtras(jsonToBundle);
                    currentActivity.setIntent(intent);
                    AppsFlyerLib.getInstance().sendPushNotificationData(currentActivity);
                    return;
                }
                handleErrorMessage("The intent is null. Push payload has not been sent!", callback);
                return;
            }
            handleErrorMessage("The activity is null. Push payload has not been sent!", callback);
        } catch (JSONException e) {
            e.printStackTrace();
            handleErrorMessage("Can't parse pushPayload to bundle", callback);
        }
    }

    private void handleErrorMessage(String str, Callback callback) {
        Log.d("AppsFlyer", str);
        if (callback != null) {
            callback.invoke(str);
        }
    }

    @ReactMethod
    public void setHost(String str, String str2, Callback callback) {
        AppsFlyerLib.getInstance().setHost(str, str2);
        callback.invoke("Success");
    }

    @ReactMethod
    public void addPushNotificationDeepLinkPath(ReadableArray readableArray, Callback callback, Callback callback2) {
        if (readableArray.size() <= 0) {
            callback2.invoke("No arguments found or list is corrupted");
            return;
        }
        List<Object> list = RNUtil.toList(readableArray);
        try {
            AppsFlyerLib.getInstance().addPushNotificationDeepLinkPath((String[]) list.toArray(new String[list.size()]));
            callback.invoke("Success");
        } catch (Exception e) {
            e.printStackTrace();
            callback2.invoke(e);
        }
    }

    @ReactMethod
    public void disableAdvertisingIdentifier(Boolean bool) {
        AppsFlyerLib.getInstance().setDisableAdvertisingIdentifiers(bool.booleanValue());
    }

    @ReactMethod
    public void setPartnerData(String str, ReadableMap readableMap) {
        AppsFlyerLib.getInstance().setPartnerData(str, RNUtil.toMap(readableMap));
    }

    @ReactMethod
    public void appendParametersToDeepLinkingURL(String str, ReadableMap readableMap) {
        AppsFlyerLib.getInstance().appendParametersToDeepLinkingURL(str, RNUtil.toMap(readableMap));
    }

    @ReactMethod
    public void setDisableNetworkData(Boolean bool) {
        AppsFlyerLib.getInstance().setDisableNetworkData(bool.booleanValue());
    }

    @ReactMethod
    public void performOnDeepLinking() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Intent intent = currentActivity.getIntent();
            if (intent != null) {
                AppsFlyerLib.getInstance().performOnDeepLinking(intent, this.application);
            } else {
                Log.d("AppsFlyer", "performOnDeepLinking: intent is null!");
            }
        } else {
            Log.d("AppsFlyer", "performOnDeepLinking: activity is null!");
        }
    }
}
