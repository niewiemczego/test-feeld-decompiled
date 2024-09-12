package com.braze;

import android.content.Context;
import android.content.Intent;
import com.braze.enums.BrazePushEventType;
import com.braze.enums.GeofenceTransitionType;
import com.braze.events.InAppMessageEvent;
import com.braze.models.IBrazeLocation;
import com.braze.models.push.BrazeNotificationPayload;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0007J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0018\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0016\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\bJ\u001e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u001e\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ \u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u001f\u001a\u00020\b2\u0006\u0010 \u001a\u00020!H\u0007J\u0016\u0010\"\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0012H\u0007J\u0018\u0010&\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010'\u001a\u00020(H\u0007J\u0018\u0010)\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010#\u001a\u00020$H\u0007J\u0016\u0010*\u001a\u00020(2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\b¨\u0006,"}, d2 = {"Lcom/braze/BrazeInternal;", "", "()V", "addSerializedContentCardToStorage", "", "context", "Landroid/content/Context;", "serializedCardJson", "", "userId", "applyPendingRuntimeConfiguration", "getInstance", "Lcom/braze/Braze;", "handleInAppMessageTestPush", "intent", "Landroid/content/Intent;", "logLocationRecordedEvent", "location", "Lcom/braze/models/IBrazeLocation;", "logPushCampaign", "campaignId", "logPushDelivery", "waitTimeMs", "", "performPushDeliveryFlush", "publishBrazePushAction", "pushActionType", "Lcom/braze/enums/BrazePushEventType;", "payload", "Lcom/braze/models/push/BrazeNotificationPayload;", "recordGeofenceTransition", "geofenceId", "transitionType", "Lcom/braze/enums/GeofenceTransitionType;", "reenqueueInAppMessage", "inAppMessageEvent", "Lcom/braze/events/InAppMessageEvent;", "refreshFeatureFlags", "requestGeofenceRefresh", "ignoreRateLimit", "", "retryInAppMessage", "validateAndStorePushId", "pushId", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrazeInternal {
    public static final BrazeInternal INSTANCE = new BrazeInternal();

    private BrazeInternal() {
    }

    @JvmStatic
    public static final void addSerializedContentCardToStorage(Context context, String str, String str2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "serializedCardJson");
        INSTANCE.getInstance(context).addSerializedCardJsonToStorage$android_sdk_base_release(str, str2);
    }

    @JvmStatic
    public static final void applyPendingRuntimeConfiguration(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).applyPendingRuntimeConfiguration$android_sdk_base_release();
    }

    private final Braze getInstance(Context context) {
        return Braze.Companion.getInstance(context);
    }

    @JvmStatic
    public static final void handleInAppMessageTestPush(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, SDKConstants.PARAM_INTENT);
        INSTANCE.getInstance(context).handleInAppMessageTestPush$android_sdk_base_release(intent);
    }

    @JvmStatic
    public static final void logLocationRecordedEvent(Context context, IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        INSTANCE.getInstance(context).logLocationRecordedEventFromLocationUpdate$android_sdk_base_release(iBrazeLocation);
    }

    @JvmStatic
    public static final void recordGeofenceTransition(Context context, String str, GeofenceTransitionType geofenceTransitionType) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(geofenceTransitionType, "transitionType");
        INSTANCE.getInstance(context).recordGeofenceTransition$android_sdk_base_release(str, geofenceTransitionType);
    }

    @JvmStatic
    public static final void refreshFeatureFlags(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).refreshFeatureFlags();
    }

    @JvmStatic
    public static final void requestGeofenceRefresh(Context context, boolean z) {
        Intrinsics.checkNotNullParameter(context, "context");
        INSTANCE.getInstance(context).requestGeofenceRefresh$android_sdk_base_release(z);
    }

    @JvmStatic
    public static final void retryInAppMessage(Context context, InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "inAppMessageEvent");
        INSTANCE.getInstance(context).retryInAppMessage$android_sdk_base_release(inAppMessageEvent);
    }

    public final /* synthetic */ void logPushCampaign(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "campaignId");
        getInstance(context).logPushMaxCampaign$android_sdk_base_release(str);
    }

    public final /* synthetic */ void logPushDelivery(Context context, String str, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "campaignId");
        getInstance(context).logPushDelivery$android_sdk_base_release(str, j);
    }

    public final /* synthetic */ void performPushDeliveryFlush(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        getInstance(context).performPushDeliveryFlush$android_sdk_base_release();
    }

    public final /* synthetic */ void publishBrazePushAction(Context context, BrazePushEventType brazePushEventType, BrazeNotificationPayload brazeNotificationPayload) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(brazePushEventType, "pushActionType");
        Intrinsics.checkNotNullParameter(brazeNotificationPayload, "payload");
        getInstance(context).publishBrazePushAction$android_sdk_base_release(brazePushEventType, brazeNotificationPayload);
    }

    public final void reenqueueInAppMessage(Context context, InAppMessageEvent inAppMessageEvent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(inAppMessageEvent, "inAppMessageEvent");
        getInstance(context).reenqueueInAppMessage$android_sdk_base_release(inAppMessageEvent);
    }

    public final /* synthetic */ boolean validateAndStorePushId(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "pushId");
        return getInstance(context).validateAndStorePushId$android_sdk_base_release(str);
    }

    @JvmStatic
    public static final void requestGeofenceRefresh(Context context, IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        INSTANCE.getInstance(context).requestGeofenceRefresh$android_sdk_base_release(iBrazeLocation);
    }
}
