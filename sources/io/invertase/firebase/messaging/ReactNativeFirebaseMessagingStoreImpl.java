package io.invertase.firebase.messaging;

import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.UniversalFirebasePreferences;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class ReactNativeFirebaseMessagingStoreImpl implements ReactNativeFirebaseMessagingStore {
    private static final int MAX_SIZE_NOTIFICATIONS = 100;
    private static final String S_KEY_ALL_NOTIFICATION_IDS = "all_notification_ids";
    private final String DELIMITER = ",";

    public void storeFirebaseMessage(RemoteMessage remoteMessage) {
        try {
            String jSONObject = JsonConvert.reactToJSON((ReadableMap) ReactNativeFirebaseMessagingSerializer.remoteMessageToWritableMap(remoteMessage)).toString();
            UniversalFirebasePreferences sharedInstance = UniversalFirebasePreferences.getSharedInstance();
            sharedInstance.setStringValue(remoteMessage.getMessageId(), jSONObject);
            String str = sharedInstance.getStringValue(S_KEY_ALL_NOTIFICATION_IDS, "") + remoteMessage.getMessageId() + ",";
            List<String> convertToArray = convertToArray(str);
            if (convertToArray.size() > 100) {
                String str2 = convertToArray.get(0);
                sharedInstance.remove(str2);
                str = removeRemoteMessage(str2, str);
            }
            sharedInstance.setStringValue(S_KEY_ALL_NOTIFICATION_IDS, str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Deprecated
    public RemoteMessage getFirebaseMessage(String str) {
        WritableMap firebaseMessageMap = getFirebaseMessageMap(str);
        if (firebaseMessageMap != null) {
            return ReactNativeFirebaseMessagingSerializer.remoteMessageFromReadableMap(firebaseMessageMap);
        }
        return null;
    }

    public WritableMap getFirebaseMessageMap(String str) {
        String stringValue = UniversalFirebasePreferences.getSharedInstance().getStringValue(str, (String) null);
        if (stringValue != null) {
            try {
                WritableMap jsonToReact = JsonConvert.jsonToReact(new JSONObject(stringValue));
                jsonToReact.putString("to", str);
                return jsonToReact;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public void clearFirebaseMessage(String str) {
        UniversalFirebasePreferences sharedInstance = UniversalFirebasePreferences.getSharedInstance();
        sharedInstance.remove(str);
        String stringValue = sharedInstance.getStringValue(S_KEY_ALL_NOTIFICATION_IDS, "");
        if (!stringValue.isEmpty()) {
            sharedInstance.setStringValue(S_KEY_ALL_NOTIFICATION_IDS, removeRemoteMessage(str, stringValue));
        }
    }

    private String removeRemoteMessage(String str, String str2) {
        return str2.replace(str + ",", "");
    }

    private List<String> convertToArray(String str) {
        return new ArrayList(Arrays.asList(str.split(",")));
    }
}
