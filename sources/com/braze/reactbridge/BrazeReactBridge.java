package com.braze.reactbridge;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b*\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\f\u001a\u00020\b2\b\u0010\r\u001a\u0004\u0018\u00010\nH\u0007J&\u0010\u000e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0013\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\n2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010\u0018\u001a\u00020\bH\u0007J\b\u0010\u0019\u001a\u00020\bH\u0007J\u0012\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010\u001d\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001c\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010 \u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010!\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J&\u0010$\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J&\u0010%\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J&\u0010&\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u0012\u0010'\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010(\u001a\u00020\nH\u0016J\u0012\u0010)\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0007J\u001c\u0010*\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010+\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010,\u001a\u00020\bH\u0007J$\u0010-\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\b\u0010/\u001a\u00020\bH\u0007J\b\u00100\u001a\u00020\bH\u0007J\u0012\u00101\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u00103\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u00104\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u00105\u001a\u00020\b2\b\u00106\u001a\u0004\u0018\u00010\n2\b\u00107\u001a\u0004\u0018\u000108H\u0007J\u0010\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\nH\u0007J\u001a\u0010;\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\n2\u0006\u0010=\u001a\u00020.H\u0007J\u0012\u0010>\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010?\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010@\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010A\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J8\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\n2\b\u0010D\u001a\u0004\u0018\u00010\n2\b\u0010E\u001a\u0004\u0018\u00010\n2\u0006\u0010F\u001a\u00020.2\b\u0010G\u001a\u0004\u0018\u000108H\u0007J\u001a\u0010H\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u00010\n2\u0006\u0010=\u001a\u00020.H\u0007J\u0012\u0010I\u001a\u00020\b2\b\u00102\u001a\u0004\u0018\u00010\nH\u0007J\b\u0010J\u001a\u00020\bH\u0007J\u0012\u0010K\u001a\u00020\b2\b\u0010L\u001a\u0004\u0018\u00010\nH\u0007J&\u0010M\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010N\u001a\u00020\b2\b\u0010\u0014\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0010\u0010O\u001a\u00020\b2\u0006\u0010P\u001a\u00020.H\u0007J\b\u0010Q\u001a\u00020\bH\u0007J\b\u0010R\u001a\u00020\bH\u0007J\u0018\u0010S\u001a\u00020\b2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.H\u0007J\b\u0010V\u001a\u00020\bH\u0007J\b\u0010W\u001a\u00020\bH\u0007J\u0012\u0010X\u001a\u00020\b2\b\u0010Y\u001a\u0004\u0018\u000108H\u0007J0\u0010Z\u001a\u00020\b2\b\u0010[\u001a\u0004\u0018\u00010\n2\b\u0010\\\u001a\u0004\u0018\u00010\n2\b\u0010]\u001a\u0004\u0018\u00010\n2\b\u0010^\u001a\u0004\u0018\u00010\nH\u0007J$\u0010_\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020`2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010a\u001a\u00020\b2\b\u0010b\u001a\u0004\u0018\u00010\nH\u0007J&\u0010c\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J,\u0010e\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u0002082\u0006\u0010f\u001a\u00020`2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J&\u0010g\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010d2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J$\u0010h\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J \u0010i\u001a\u00020\b2\u0006\u0010j\u001a\u00020.2\u0006\u0010k\u001a\u00020.2\u0006\u0010l\u001a\u00020.H\u0007J$\u0010m\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010n\u001a\u00020\b2\b\u0010o\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010p\u001a\u00020\b2\b\u0010q\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010r\u001a\u00020\b2\b\u0010s\u001a\u0004\u0018\u00010\nH\u0007J\u001c\u0010t\u001a\u00020\b2\b\u0010u\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001a\u0010v\u001a\u00020\b2\b\u0010w\u001a\u0004\u0018\u00010\n2\u0006\u0010x\u001a\u00020`H\u0007J\u0012\u0010y\u001a\u00020\b2\b\u0010z\u001a\u0004\u0018\u00010\nH\u0007J$\u0010{\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0010\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0012\u0010|\u001a\u00020\b2\b\u0010}\u001a\u0004\u0018\u00010\nH\u0007J2\u0010~\u001a\u00020\b2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.2\u0006\u0010\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020.H\u0007J\u0014\u0010\u0001\u001a\u00020\b2\t\u0010\u0001\u001a\u0004\u0018\u00010\nH\u0007J-\u0010\u0001\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010T\u001a\u00020.2\u0006\u0010U\u001a\u00020.2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0014\u0010\u0001\u001a\u00020\b2\t\u0010\u0001\u001a\u0004\u0018\u00010\nH\u0007J\u001d\u0010\u0001\u001a\u00020\b2\b\u0010q\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u0013\u0010\u0001\u001a\u00020\b2\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J'\u0010\u0001\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001c\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020`2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\u001d\u0010\u0001\u001a\u00020\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0007J\t\u0010\u0001\u001a\u00020\bH\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001"}, d2 = {"Lcom/braze/reactbridge/BrazeReactBridge;", "Lcom/facebook/react/bridge/ReactContextBaseJavaModule;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "brazeImpl", "Lcom/braze/reactbridge/BrazeReactBridgeImpl;", "addAlias", "", "aliasName", "", "aliasLabel", "addListener", "eventType", "addToCustomUserAttributeArray", "key", "value", "callback", "Lcom/facebook/react/bridge/Callback;", "addToSubscriptionGroup", "groupId", "changeUser", "userId", "signature", "disableSDK", "enableSDK", "getAllFeatureFlags", "promise", "Lcom/facebook/react/bridge/Promise;", "getCachedContentCards", "getCardCountForCategories", "category", "getContentCards", "getDeviceId", "getFeatureFlag", "flagId", "getFeatureFlagBooleanProperty", "getFeatureFlagNumberProperty", "getFeatureFlagStringProperty", "getInitialURL", "getName", "getNewsFeedCards", "getUnreadCardCountForCategories", "getUserId", "hideCurrentInAppMessage", "incrementCustomUserAttribute", "", "launchContentCards", "launchNewsFeed", "logContentCardClicked", "cardId", "logContentCardDismissed", "logContentCardImpression", "logCustomEvent", "eventName", "eventProperties", "Lcom/facebook/react/bridge/ReadableMap;", "logFeatureFlagImpression", "id", "logInAppMessageButtonClicked", "inAppMessageString", "buttonId", "logInAppMessageClicked", "logInAppMessageImpression", "logNewsFeedCardClicked", "logNewsFeedCardImpression", "logPurchase", "productId", "price", "currencyCode", "quantity", "purchaseProperties", "performInAppMessageAction", "processContentCardClickAction", "refreshFeatureFlags", "registerPushToken", "token", "removeFromCustomUserAttributeArray", "removeFromSubscriptionGroup", "removeListeners", "count", "requestContentCardsRefresh", "requestFeedRefresh", "requestGeofences", "latitude", "longitude", "requestImmediateDataFlush", "requestLocationInitialization", "requestPushPermission", "permissionOptions", "setAttributionData", "network", "campaign", "adGroup", "creative", "setBoolCustomUserAttribute", "", "setCountry", "country", "setCustomUserAttributeArray", "Lcom/facebook/react/bridge/ReadableArray;", "setCustomUserAttributeObject", "merge", "setCustomUserAttributeObjectArray", "setDateCustomUserAttribute", "setDateOfBirth", "year", "month", "day", "setDoubleCustomUserAttribute", "setEmail", "email", "setEmailNotificationSubscriptionType", "notificationSubscriptionType", "setFirstName", "firstName", "setGender", "gender", "setGoogleAdvertisingId", "googleAdvertisingId", "adTrackingEnabled", "setHomeCity", "homeCity", "setIntCustomUserAttribute", "setLanguage", "language", "setLastKnownLocation", "altitude", "horizontalAccuracy", "verticalAccuracy", "setLastName", "lastName", "setLocationCustomAttribute", "setPhoneNumber", "phoneNumber", "setPushNotificationSubscriptionType", "setSdkAuthenticationSignature", "setStringCustomUserAttribute", "subscribeToInAppMessage", "useBrazeUI", "unsetCustomUserAttribute", "wipeData", "braze_react-native-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BrazeReactBridge.kt */
public final class BrazeReactBridge extends ReactContextBaseJavaModule {
    private final BrazeReactBridgeImpl brazeImpl;

    @ReactMethod
    public final void getInitialURL(Callback callback) {
    }

    public String getName() {
        return BrazeReactBridgeImpl.NAME;
    }

    public BrazeReactBridge(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        Intrinsics.checkNotNull(reactApplicationContext);
        this.brazeImpl = new BrazeReactBridgeImpl(reactApplicationContext, getCurrentActivity());
    }

    @ReactMethod
    public final void getDeviceId(Callback callback) {
        this.brazeImpl.getDeviceId(callback);
    }

    @ReactMethod
    public final void changeUser(String str, String str2) {
        this.brazeImpl.changeUser(str, str2);
    }

    @ReactMethod
    public final void getUserId(Callback callback) {
        this.brazeImpl.getUserId(callback);
    }

    @ReactMethod
    public final void setSdkAuthenticationSignature(String str) {
        this.brazeImpl.setSdkAuthenticationSignature(str);
    }

    @ReactMethod
    public final void addAlias(String str, String str2) {
        this.brazeImpl.addAlias(str, str2);
    }

    @ReactMethod
    public final void setFirstName(String str) {
        this.brazeImpl.setFirstName(str);
    }

    @ReactMethod
    public final void setLastName(String str) {
        this.brazeImpl.setLastName(str);
    }

    @ReactMethod
    public final void setEmail(String str) {
        this.brazeImpl.setEmail(str);
    }

    @ReactMethod
    public final void setGender(String str, Callback callback) {
        this.brazeImpl.setGender(str, callback);
    }

    @ReactMethod
    public final void setLanguage(String str) {
        this.brazeImpl.setLanguage(str);
    }

    @ReactMethod
    public final void setCountry(String str) {
        this.brazeImpl.setCountry(str);
    }

    @ReactMethod
    public final void setHomeCity(String str) {
        this.brazeImpl.setHomeCity(str);
    }

    @ReactMethod
    public final void setPhoneNumber(String str) {
        this.brazeImpl.setPhoneNumber(str);
    }

    @ReactMethod
    public final void setDateOfBirth(double d, double d2, double d3) {
        this.brazeImpl.setDateOfBirth((int) d, (int) d2, (int) d3);
    }

    @ReactMethod
    public final void registerPushToken(String str) {
        this.brazeImpl.registerPushToken(str);
    }

    @ReactMethod
    public final void setGoogleAdvertisingId(String str, boolean z) {
        this.brazeImpl.setGoogleAdvertisingId(str, Boolean.valueOf(z));
    }

    @ReactMethod
    public final void addToSubscriptionGroup(String str, Callback callback) {
        this.brazeImpl.addToSubscriptionGroup(str, callback);
    }

    @ReactMethod
    public final void removeFromSubscriptionGroup(String str, Callback callback) {
        this.brazeImpl.removeFromSubscriptionGroup(str, callback);
    }

    @ReactMethod
    public final void setPushNotificationSubscriptionType(String str, Callback callback) {
        this.brazeImpl.setPushNotificationSubscriptionType(str, callback);
    }

    @ReactMethod
    public final void setEmailNotificationSubscriptionType(String str, Callback callback) {
        this.brazeImpl.setEmailNotificationSubscriptionType(str, callback);
    }

    @ReactMethod
    public final void logCustomEvent(String str, ReadableMap readableMap) {
        this.brazeImpl.logCustomEvent(str, readableMap);
    }

    @ReactMethod
    public final void logPurchase(String str, String str2, String str3, double d, ReadableMap readableMap) {
        this.brazeImpl.logPurchase(str, str2, str3, (int) d, readableMap);
    }

    @ReactMethod
    public final void setIntCustomUserAttribute(String str, double d, Callback callback) {
        this.brazeImpl.setIntCustomUserAttribute(str, (int) d, callback);
    }

    @ReactMethod
    public final void setDoubleCustomUserAttribute(String str, double d, Callback callback) {
        this.brazeImpl.setDoubleCustomUserAttribute(str, (float) d, callback);
    }

    @ReactMethod
    public final void setBoolCustomUserAttribute(String str, boolean z, Callback callback) {
        this.brazeImpl.setBoolCustomUserAttribute(str, Boolean.valueOf(z), callback);
    }

    @ReactMethod
    public final void setStringCustomUserAttribute(String str, String str2, Callback callback) {
        this.brazeImpl.setStringCustomUserAttribute(str, str2, callback);
    }

    @ReactMethod
    public final void setCustomUserAttributeArray(String str, ReadableArray readableArray, Callback callback) {
        this.brazeImpl.setCustomUserAttributeArray(str, readableArray, callback);
    }

    @ReactMethod
    public final void setCustomUserAttributeObjectArray(String str, ReadableArray readableArray, Callback callback) {
        this.brazeImpl.setCustomUserAttributeObjectArray(str, readableArray, callback);
    }

    @ReactMethod
    public final void setDateCustomUserAttribute(String str, double d, Callback callback) {
        this.brazeImpl.setDateCustomUserAttribute(str, (int) d, callback);
    }

    @ReactMethod
    public final void setCustomUserAttributeObject(String str, ReadableMap readableMap, boolean z, Callback callback) {
        Intrinsics.checkNotNullParameter(readableMap, "value");
        this.brazeImpl.setCustomUserAttributeObject(str, readableMap, z, callback);
    }

    @ReactMethod
    public final void addToCustomUserAttributeArray(String str, String str2, Callback callback) {
        this.brazeImpl.addToCustomAttributeArray(str, str2, callback);
    }

    @ReactMethod
    public final void removeFromCustomUserAttributeArray(String str, String str2, Callback callback) {
        this.brazeImpl.removeFromCustomAttributeArray(str, str2, callback);
    }

    @ReactMethod
    public final void unsetCustomUserAttribute(String str, Callback callback) {
        this.brazeImpl.unsetCustomUserAttribute(str, callback);
    }

    @ReactMethod
    public final void incrementCustomUserAttribute(String str, double d, Callback callback) {
        this.brazeImpl.incrementCustomUserAttribute(str, (int) d, callback);
    }

    @ReactMethod
    public final void setAttributionData(String str, String str2, String str3, String str4) {
        this.brazeImpl.setAttributionData(str, str2, str3, str4);
    }

    @ReactMethod
    public final void launchNewsFeed() {
        this.brazeImpl.launchNewsFeed();
    }

    @ReactMethod
    public final void logNewsFeedCardClicked(String str) {
        this.brazeImpl.logNewsFeedCardClicked(str);
    }

    @ReactMethod
    public final void logNewsFeedCardImpression(String str) {
        this.brazeImpl.logNewsFeedCardImpression(str);
    }

    @ReactMethod
    public final void getNewsFeedCards(Promise promise) {
        this.brazeImpl.getNewsFeedCards(promise);
    }

    @ReactMethod
    public final void launchContentCards() {
        this.brazeImpl.launchContentCards();
    }

    @ReactMethod
    public final void requestContentCardsRefresh() {
        this.brazeImpl.requestContentCardsRefresh();
    }

    @ReactMethod
    public final void logContentCardClicked(String str) {
        this.brazeImpl.logContentCardClicked(str);
    }

    @ReactMethod
    public final void logContentCardDismissed(String str) {
        this.brazeImpl.logContentCardDismissed(str);
    }

    @ReactMethod
    public final void logContentCardImpression(String str) {
        this.brazeImpl.logContentCardImpression(str);
    }

    @ReactMethod
    public final void processContentCardClickAction(String str) {
        this.brazeImpl.processContentCardClickAction(str);
    }

    @ReactMethod
    public final void getContentCards(Promise promise) {
        this.brazeImpl.getContentCards(promise);
    }

    @ReactMethod
    public final void getCachedContentCards(Promise promise) {
        this.brazeImpl.getCachedContentCards(promise);
    }

    @ReactMethod
    public final void getCardCountForCategories(String str, Callback callback) {
        this.brazeImpl.getCardCountForCategories(str, callback);
    }

    @ReactMethod
    public final void getUnreadCardCountForCategories(String str, Callback callback) {
        this.brazeImpl.getUnreadCardCountForCategories(str, callback);
    }

    @ReactMethod
    public final void requestFeedRefresh() {
        this.brazeImpl.requestFeedRefresh();
    }

    @ReactMethod
    public final void requestImmediateDataFlush() {
        this.brazeImpl.requestImmediateDataFlush();
    }

    @ReactMethod
    public final void wipeData() {
        this.brazeImpl.wipeData();
    }

    @ReactMethod
    public final void disableSDK() {
        this.brazeImpl.disableSDK();
    }

    @ReactMethod
    public final void enableSDK() {
        this.brazeImpl.enableSDK();
    }

    @ReactMethod
    public final void requestLocationInitialization() {
        this.brazeImpl.requestLocationInitialization();
    }

    @ReactMethod
    public final void requestGeofences(double d, double d2) {
        this.brazeImpl.requestGeofences(Double.valueOf(d), Double.valueOf(d2));
    }

    @ReactMethod
    public final void setLocationCustomAttribute(String str, double d, double d2, Callback callback) {
        this.brazeImpl.setLocationCustomAttribute(str, Double.valueOf(d), Double.valueOf(d2), callback);
    }

    @ReactMethod
    public final void setLastKnownLocation(double d, double d2, double d3, double d4, double d5) {
        this.brazeImpl.setLastKnownLocation(d, d2, d3, d4, d5);
    }

    @ReactMethod
    public final void subscribeToInAppMessage(boolean z, Callback callback) {
        this.brazeImpl.subscribeToInAppMessage(z);
    }

    @ReactMethod
    public final void hideCurrentInAppMessage() {
        this.brazeImpl.hideCurrentInAppMessage();
    }

    @ReactMethod
    public final void logInAppMessageClicked(String str) {
        this.brazeImpl.logInAppMessageClicked(str);
    }

    @ReactMethod
    public final void logInAppMessageImpression(String str) {
        this.brazeImpl.logInAppMessageImpression(str);
    }

    @ReactMethod
    public final void logInAppMessageButtonClicked(String str, double d) {
        this.brazeImpl.logInAppMessageButtonClicked(str, (int) d);
    }

    @ReactMethod
    public final void performInAppMessageAction(String str, double d) {
        this.brazeImpl.performInAppMessageAction(str, (int) d);
    }

    @ReactMethod
    public final void requestPushPermission(ReadableMap readableMap) {
        this.brazeImpl.requestPushPermission(readableMap);
    }

    @ReactMethod
    public final void getAllFeatureFlags(Promise promise) {
        this.brazeImpl.getAllFeatureFlags(promise);
    }

    @ReactMethod
    public final void getFeatureFlag(String str, Promise promise) {
        this.brazeImpl.getFeatureFlag(str, promise);
    }

    @ReactMethod
    public final void getFeatureFlagBooleanProperty(String str, String str2, Promise promise) {
        this.brazeImpl.getFeatureFlagBooleanProperty(str, str2, promise);
    }

    @ReactMethod
    public final void getFeatureFlagStringProperty(String str, String str2, Promise promise) {
        this.brazeImpl.getFeatureFlagStringProperty(str, str2, promise);
    }

    @ReactMethod
    public final void getFeatureFlagNumberProperty(String str, String str2, Promise promise) {
        this.brazeImpl.getFeatureFlagNumberProperty(str, str2, promise);
    }

    @ReactMethod
    public final void refreshFeatureFlags() {
        this.brazeImpl.refreshFeatureFlags();
    }

    @ReactMethod
    public final void logFeatureFlagImpression(String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        this.brazeImpl.logFeatureFlagImpression(str);
    }

    @ReactMethod
    public final void addListener(String str) {
        if (str != null) {
            this.brazeImpl.addListener(str);
        }
    }

    @ReactMethod
    public final void removeListeners(double d) {
        this.brazeImpl.removeListeners((int) d);
    }
}
