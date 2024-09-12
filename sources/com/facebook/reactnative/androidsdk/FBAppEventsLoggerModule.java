package com.facebook.reactnative.androidsdk;

import androidx.autofill.HintConstants;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.AppEventsLogger;
import com.facebook.appevents.UserDataStore;
import com.facebook.internal.AttributionIdentifiers;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.module.annotations.ReactModule;
import io.sentry.protocol.Geo;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@ReactModule(name = "FBAppEventsLogger")
public class FBAppEventsLoggerModule extends ReactContextBaseJavaModule {
    public static final String NAME = "FBAppEventsLogger";
    private AppEventsLogger mAppEventLogger;
    private AttributionIdentifiers mAttributionIdentifiers;
    private ReactApplicationContext mReactContext;

    public String getName() {
        return NAME;
    }

    public FBAppEventsLoggerModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
        this.mReactContext = reactApplicationContext;
    }

    public void initialize() {
        this.mAppEventLogger = AppEventsLogger.newLogger(this.mReactContext);
        this.mAttributionIdentifiers = AttributionIdentifiers.getAttributionIdentifiers(this.mReactContext);
    }

    @ReactMethod
    public void setFlushBehavior(String str) {
        AppEventsLogger.setFlushBehavior(AppEventsLogger.FlushBehavior.valueOf(str.toUpperCase(Locale.ROOT)));
    }

    @ReactMethod
    public void logEvent(String str, double d, ReadableMap readableMap) {
        this.mAppEventLogger.logEvent(str, d, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPurchase(double d, String str, ReadableMap readableMap) {
        this.mAppEventLogger.logPurchase(BigDecimal.valueOf(d), Currency.getInstance(str), Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logPushNotificationOpen(ReadableMap readableMap) {
        this.mAppEventLogger.logPushNotificationOpen(Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void logProductItem(String str, String str2, String str3, String str4, String str5, String str6, String str7, double d, String str8, String str9, String str10, String str11, ReadableMap readableMap) {
        String str12 = str;
        String str13 = str4;
        String str14 = str5;
        String str15 = str6;
        String str16 = str7;
        String str17 = str9;
        String str18 = str10;
        String str19 = str11;
        this.mAppEventLogger.logProductItem(str12, AppEventsLogger.ProductAvailability.valueOf(str2.toUpperCase(Locale.ROOT)), AppEventsLogger.ProductCondition.valueOf(str3.toUpperCase(Locale.ROOT)), str13, str14, str15, str16, BigDecimal.valueOf(d), Currency.getInstance(str8), str17, str18, str19, Arguments.toBundle(readableMap));
    }

    @ReactMethod
    public void setUserID(String str) {
        AppEventsLogger.setUserID(str);
    }

    @ReactMethod
    public void clearUserID() {
        AppEventsLogger.clearUserID();
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public String getUserID() {
        return AppEventsLogger.getUserID();
    }

    @ReactMethod
    public void getAnonymousID(Promise promise) {
        try {
            promise.resolve(AppEventsLogger.getAnonymousAppDeviceGUID(this.mReactContext));
        } catch (Exception e) {
            promise.reject("E_ANONYMOUS_ID_ERROR", "Can not get anonymousID", (Throwable) e);
        }
    }

    @ReactMethod
    public void getAdvertiserID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.getAndroidAdvertiserId());
        } catch (Exception e) {
            promise.reject("E_ADVERTISER_ID_ERROR", "Can not get advertiserID", (Throwable) e);
        }
    }

    @ReactMethod
    public void getAttributionID(Promise promise) {
        try {
            promise.resolve(this.mAttributionIdentifiers.getAttributionId());
        } catch (Exception e) {
            promise.reject("E_ATTRIBUTION_ID_ERROR", "Can not get attributionID", (Throwable) e);
        }
    }

    private String getNullableString(ReadableMap readableMap, String str) {
        if (readableMap.hasKey(str)) {
            return readableMap.getString(str);
        }
        return null;
    }

    @ReactMethod
    public void setUserData(ReadableMap readableMap) {
        AppEventsLogger.setUserData(getNullableString(readableMap, "email"), getNullableString(readableMap, "firstName"), getNullableString(readableMap, "lastName"), getNullableString(readableMap, "phone"), getNullableString(readableMap, "dateOfBirth"), getNullableString(readableMap, HintConstants.AUTOFILL_HINT_GENDER), getNullableString(readableMap, Geo.JsonKeys.CITY), getNullableString(readableMap, "state"), getNullableString(readableMap, "zip"), getNullableString(readableMap, UserDataStore.COUNTRY));
    }

    @ReactMethod
    public void flush() {
        this.mAppEventLogger.flush();
    }

    @ReactMethod
    public void setPushNotificationsRegistrationId(String str) {
        AppEventsLogger.setPushNotificationsRegistrationId(str);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("AchievedLevel", AppEventsConstants.EVENT_NAME_ACHIEVED_LEVEL);
        hashMap2.put(AppEventsConstants.EVENT_NAME_AD_CLICK, AppEventsConstants.EVENT_NAME_AD_CLICK);
        hashMap2.put(AppEventsConstants.EVENT_NAME_AD_IMPRESSION, AppEventsConstants.EVENT_NAME_AD_IMPRESSION);
        hashMap2.put("AddedPaymentInfo", AppEventsConstants.EVENT_NAME_ADDED_PAYMENT_INFO);
        hashMap2.put("AddedToCart", AppEventsConstants.EVENT_NAME_ADDED_TO_CART);
        hashMap2.put("AddedToWishlist", AppEventsConstants.EVENT_NAME_ADDED_TO_WISHLIST);
        hashMap2.put("CompletedRegistration", AppEventsConstants.EVENT_NAME_COMPLETED_REGISTRATION);
        hashMap2.put("CompletedTutorial", AppEventsConstants.EVENT_NAME_COMPLETED_TUTORIAL);
        hashMap2.put(AppEventsConstants.EVENT_NAME_CONTACT, AppEventsConstants.EVENT_NAME_CONTACT);
        hashMap2.put(AppEventsConstants.EVENT_NAME_CUSTOMIZE_PRODUCT, AppEventsConstants.EVENT_NAME_CUSTOMIZE_PRODUCT);
        hashMap2.put(AppEventsConstants.EVENT_NAME_DONATE, AppEventsConstants.EVENT_NAME_DONATE);
        hashMap2.put(AppEventsConstants.EVENT_NAME_FIND_LOCATION, AppEventsConstants.EVENT_NAME_FIND_LOCATION);
        hashMap2.put("InitiatedCheckout", AppEventsConstants.EVENT_NAME_INITIATED_CHECKOUT);
        hashMap2.put("Purchased", AppEventsConstants.EVENT_NAME_PURCHASED);
        hashMap2.put("Rated", AppEventsConstants.EVENT_NAME_RATED);
        hashMap2.put("Searched", AppEventsConstants.EVENT_NAME_SEARCHED);
        hashMap2.put("SpentCredits", AppEventsConstants.EVENT_NAME_SPENT_CREDITS);
        hashMap2.put(AppEventsConstants.EVENT_NAME_SCHEDULE, AppEventsConstants.EVENT_NAME_SCHEDULE);
        hashMap2.put(AppEventsConstants.EVENT_NAME_START_TRIAL, AppEventsConstants.EVENT_NAME_START_TRIAL);
        hashMap2.put(AppEventsConstants.EVENT_NAME_SUBMIT_APPLICATION, AppEventsConstants.EVENT_NAME_SUBMIT_APPLICATION);
        hashMap2.put(AppEventsConstants.EVENT_NAME_SUBSCRIBE, AppEventsConstants.EVENT_NAME_SUBSCRIBE);
        hashMap2.put("UnlockedAchievement", AppEventsConstants.EVENT_NAME_UNLOCKED_ACHIEVEMENT);
        hashMap2.put("ViewedContent", AppEventsConstants.EVENT_NAME_VIEWED_CONTENT);
        hashMap.put("AppEvents", hashMap2);
        HashMap hashMap3 = new HashMap();
        hashMap3.put("AddType", AppEventsConstants.EVENT_PARAM_AD_TYPE);
        hashMap3.put("Content", AppEventsConstants.EVENT_PARAM_CONTENT);
        hashMap3.put("ContentID", AppEventsConstants.EVENT_PARAM_CONTENT_ID);
        hashMap3.put("ContentType", AppEventsConstants.EVENT_PARAM_CONTENT_TYPE);
        hashMap3.put("Currency", AppEventsConstants.EVENT_PARAM_CURRENCY);
        hashMap3.put("Description", AppEventsConstants.EVENT_PARAM_DESCRIPTION);
        hashMap3.put("Level", AppEventsConstants.EVENT_PARAM_LEVEL);
        hashMap3.put("NumItems", AppEventsConstants.EVENT_PARAM_NUM_ITEMS);
        hashMap3.put("MaxRatingValue", AppEventsConstants.EVENT_PARAM_MAX_RATING_VALUE);
        hashMap3.put("OrderId", AppEventsConstants.EVENT_PARAM_ORDER_ID);
        hashMap3.put("PaymentInfoAvailable", AppEventsConstants.EVENT_PARAM_PAYMENT_INFO_AVAILABLE);
        hashMap3.put("RegistrationMethod", AppEventsConstants.EVENT_PARAM_REGISTRATION_METHOD);
        hashMap3.put("SearchString", AppEventsConstants.EVENT_PARAM_SEARCH_STRING);
        hashMap3.put("Success", AppEventsConstants.EVENT_PARAM_SUCCESS);
        hashMap3.put("ValueNo", "0");
        hashMap3.put("ValueYes", "1");
        hashMap.put("AppEventParams", hashMap3);
        return hashMap;
    }
}
