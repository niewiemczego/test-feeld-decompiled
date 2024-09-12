package io.invertase.firebase.messaging;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.facebook.react.HeadlessJsTaskService;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.app.ReactNativeFirebaseApp;
import io.invertase.firebase.common.ReactNativeFirebaseEventEmitter;
import io.invertase.firebase.common.SharedUtils;
import java.util.HashMap;

public class ReactNativeFirebaseMessagingReceiver extends BroadcastReceiver {
    private static final String TAG = "RNFirebaseMsgReceiver";
    static HashMap<String, RemoteMessage> notifications = new HashMap<>();

    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "broadcast received for message");
        if (ReactNativeFirebaseApp.getApplicationContext() == null) {
            ReactNativeFirebaseApp.setApplicationContext(context.getApplicationContext());
        }
        RemoteMessage remoteMessage = new RemoteMessage(intent.getExtras());
        ReactNativeFirebaseEventEmitter sharedInstance = ReactNativeFirebaseEventEmitter.getSharedInstance();
        if (remoteMessage.getNotification() != null) {
            notifications.put(remoteMessage.getMessageId(), remoteMessage);
            ReactNativeFirebaseMessagingStoreHelper.getInstance().getMessagingStore().storeFirebaseMessage(remoteMessage);
        }
        if (SharedUtils.isAppInForeground(context)) {
            sharedInstance.sendEvent(ReactNativeFirebaseMessagingSerializer.remoteMessageToEvent(remoteMessage, false));
            return;
        }
        try {
            Intent intent2 = new Intent(context, ReactNativeFirebaseMessagingHeadlessService.class);
            intent2.putExtra("message", remoteMessage);
            if (context.startService(intent2) != null) {
                HeadlessJsTaskService.acquireWakeLockNow(context);
            }
        } catch (IllegalStateException e) {
            Log.e(TAG, "Background messages only work if the message priority is set to 'high'", e);
        }
    }
}
