package io.invertase.firebase.messaging;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.facebook.react.bridge.ActivityEventListener;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.ReactNativeFirebaseModule;
import java.util.HashMap;
import java.util.Map;

public class ReactNativeFirebaseMessagingModule extends ReactNativeFirebaseModule implements ActivityEventListener {
    private static final String TAG = "Messaging";
    ReadableMap initialNotification = null;
    private HashMap<String, Boolean> initialNotificationMap = new HashMap<>();

    public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
    }

    ReactNativeFirebaseMessagingModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext, TAG);
        reactApplicationContext.addActivityEventListener(this);
    }

    private WritableMap popRemoteMessageMapFromMessagingStore(String str) {
        ReactNativeFirebaseMessagingStore messagingStore = ReactNativeFirebaseMessagingStoreHelper.getInstance().getMessagingStore();
        WritableMap firebaseMessageMap = messagingStore.getFirebaseMessageMap(str);
        messagingStore.clearFirebaseMessage(str);
        return firebaseMessageMap;
    }

    @ReactMethod
    public void getInitialNotification(Promise promise) {
        WritableMap writableMap;
        ReadableMap readableMap = this.initialNotification;
        if (readableMap != null) {
            promise.resolve(readableMap);
            this.initialNotification = null;
            return;
        }
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            Intent intent = currentActivity.getIntent();
            if (!(intent == null || intent.getExtras() == null)) {
                String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
                if (string == null) {
                    string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
                }
                if (string != null && this.initialNotificationMap.get(string) == null) {
                    RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
                    if (remoteMessage == null) {
                        writableMap = popRemoteMessageMapFromMessagingStore(string);
                    } else {
                        writableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
                    }
                    if (writableMap != null) {
                        promise.resolve(writableMap);
                        this.initialNotificationMap.put(string, true);
                        return;
                    }
                }
            }
        } else {
            Log.w(TAG, "Attempt to call getInitialNotification failed. The current activity is not ready, try calling the method later in the React lifecycle.");
        }
        promise.resolve((Object) null);
    }

    @ReactMethod
    public void setAutoInitEnabled(Boolean bool, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda5(bool)).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda6(promise));
    }

    static /* synthetic */ void lambda$setAutoInitEnabled$1(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void getToken(String str, String str2, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda9((FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class))).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda10(promise));
    }

    static /* synthetic */ String lambda$getToken$2(FirebaseMessaging firebaseMessaging) throws Exception {
        return (String) Tasks.await(firebaseMessaging.getToken());
    }

    static /* synthetic */ void lambda$getToken$3(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void deleteToken(String str, String str2, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda7((FirebaseMessaging) FirebaseApp.getInstance(str).get(FirebaseMessaging.class))).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda8(promise));
    }

    static /* synthetic */ void lambda$deleteToken$5(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void hasPermission(Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda13(this)).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda1(promise));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$hasPermission$6$io-invertase-firebase-messaging-ReactNativeFirebaseMessagingModule  reason: not valid java name */
    public /* synthetic */ Boolean m865lambda$hasPermission$6$ioinvertasefirebasemessagingReactNativeFirebaseMessagingModule() throws Exception {
        return Boolean.valueOf(NotificationManagerCompat.from(getReactApplicationContext()).areNotificationsEnabled());
    }

    static /* synthetic */ void lambda$hasPermission$7(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Integer.valueOf(((Boolean) task.getResult()).booleanValue() ? 1 : 0));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void sendMessage(ReadableMap readableMap, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda3(readableMap)).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda4(promise));
    }

    static /* synthetic */ void lambda$sendMessage$9(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void subscribeToTopic(String str, Promise promise) {
        FirebaseMessaging.getInstance().subscribeToTopic(str).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda2(promise));
    }

    static /* synthetic */ void lambda$subscribeToTopic$10(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void unsubscribeFromTopic(String str, Promise promise) {
        FirebaseMessaging.getInstance().unsubscribeFromTopic(str).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda0(promise));
    }

    static /* synthetic */ void lambda$unsubscribeFromTopic$11(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(task.getResult());
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    @ReactMethod
    public void setDeliveryMetricsExportToBigQuery(Boolean bool, Promise promise) {
        Tasks.call(getExecutor(), new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda11(bool)).addOnCompleteListener(new ReactNativeFirebaseMessagingModule$$ExternalSyntheticLambda12(promise));
    }

    static /* synthetic */ void lambda$setDeliveryMetricsExportToBigQuery$13(Promise promise, Task task) {
        if (task.isSuccessful()) {
            promise.resolve(Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        } else {
            rejectPromiseWithExceptionMap(promise, task.getException());
        }
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("isAutoInitEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().isAutoInitEnabled()));
        hashMap.put("isDeliveryMetricsExportToBigQueryEnabled", Boolean.valueOf(FirebaseMessaging.getInstance().deliveryMetricsExportToBigQueryEnabled()));
        return hashMap;
    }

    public void onNewIntent(Intent intent) {
        WritableMap writableMap;
        if (intent != null && intent.getExtras() != null) {
            String string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID);
            if (string == null) {
                string = intent.getExtras().getString(Constants.MessagePayloadKeys.MSGID_SERVER);
            }
            if (string != null) {
                RemoteMessage remoteMessage = ReactNativeFirebaseMessagingReceiver.notifications.get(string);
                if (remoteMessage == null) {
                    writableMap = popRemoteMessageMapFromMessagingStore(string);
                } else {
                    writableMap = ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage);
                }
                if (writableMap != null) {
                    WritableNativeMap writableNativeMap = new WritableNativeMap();
                    writableNativeMap.merge(writableMap);
                    this.initialNotification = writableNativeMap;
                    ReactNativeFirebaseMessagingReceiver.notifications.remove(string);
                    ReactNativeFirebaseEventEmitter.getSharedInstance().sendEvent(ReactNativeFirebaseMessagingSerializer.remoteMessageMapToEvent(writableMap, true));
                }
            }
        }
    }
}
