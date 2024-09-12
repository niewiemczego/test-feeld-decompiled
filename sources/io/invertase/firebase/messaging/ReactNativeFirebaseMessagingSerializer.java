package io.invertase.firebase.messaging;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.google.firebase.messaging.RemoteMessage;
import io.invertase.firebase.common.ReactNativeFirebaseEvent;
import io.invertase.firebase.common.SharedUtils;
import io.sentry.protocol.MetricSummary;
import io.sentry.protocol.SentryThread;
import java.util.Map;

public class ReactNativeFirebaseMessagingSerializer {
    private static final String EVENT_MESSAGES_DELETED = "messaging_message_deleted";
    private static final String EVENT_MESSAGE_RECEIVED = "messaging_message_received";
    private static final String EVENT_MESSAGE_SEND_ERROR = "messaging_message_send_error";
    private static final String EVENT_MESSAGE_SENT = "messaging_message_sent";
    private static final String EVENT_NEW_TOKEN = "messaging_token_refresh";
    private static final String EVENT_NOTIFICATION_OPENED = "messaging_notification_opened";
    private static final String KEY_COLLAPSE_KEY = "collapseKey";
    private static final String KEY_DATA = "data";
    private static final String KEY_ERROR = "error";
    private static final String KEY_FROM = "from";
    private static final String KEY_MESSAGE_ID = "messageId";
    private static final String KEY_MESSAGE_TYPE = "messageType";
    private static final String KEY_SENT_TIME = "sentTime";
    private static final String KEY_TO = "to";
    private static final String KEY_TOKEN = "token";
    private static final String KEY_TTL = "ttl";

    public static ReactNativeFirebaseEvent messagesDeletedToEvent() {
        return new ReactNativeFirebaseEvent(EVENT_MESSAGES_DELETED, Arguments.createMap());
    }

    public static ReactNativeFirebaseEvent messageSentToEvent(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(KEY_MESSAGE_ID, str);
        return new ReactNativeFirebaseEvent(EVENT_MESSAGE_SENT, createMap);
    }

    public static ReactNativeFirebaseEvent messageSendErrorToEvent(String str, Exception exc) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(KEY_MESSAGE_ID, str);
        createMap.putMap("error", SharedUtils.getExceptionMap(exc));
        return new ReactNativeFirebaseEvent(EVENT_MESSAGE_SEND_ERROR, createMap);
    }

    public static ReactNativeFirebaseEvent remoteMessageToEvent(RemoteMessage remoteMessage, Boolean bool) {
        return new ReactNativeFirebaseEvent(bool.booleanValue() ? EVENT_NOTIFICATION_OPENED : EVENT_MESSAGE_RECEIVED, remoteMessageToWritableMap(remoteMessage));
    }

    public static ReactNativeFirebaseEvent remoteMessageMapToEvent(WritableMap writableMap, Boolean bool) {
        return new ReactNativeFirebaseEvent(bool.booleanValue() ? EVENT_NOTIFICATION_OPENED : EVENT_MESSAGE_RECEIVED, writableMap);
    }

    public static ReactNativeFirebaseEvent newTokenToTokenEvent(String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString(KEY_TOKEN, str);
        return new ReactNativeFirebaseEvent(EVENT_NEW_TOKEN, createMap);
    }

    static WritableMap remoteMessageToWritableMap(RemoteMessage remoteMessage) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (remoteMessage.getCollapseKey() != null) {
            createMap.putString(KEY_COLLAPSE_KEY, remoteMessage.getCollapseKey());
        }
        if (remoteMessage.getFrom() != null) {
            createMap.putString("from", remoteMessage.getFrom());
        }
        if (remoteMessage.getTo() != null) {
            createMap.putString("to", remoteMessage.getTo());
        }
        if (remoteMessage.getMessageId() != null) {
            createMap.putString(KEY_MESSAGE_ID, remoteMessage.getMessageId());
        }
        if (remoteMessage.getMessageType() != null) {
            createMap.putString(KEY_MESSAGE_TYPE, remoteMessage.getMessageType());
        }
        if (remoteMessage.getData().size() > 0) {
            for (Map.Entry next : remoteMessage.getData().entrySet()) {
                createMap2.putString((String) next.getKey(), (String) next.getValue());
            }
        }
        createMap.putMap("data", createMap2);
        createMap.putDouble(KEY_TTL, (double) remoteMessage.getTtl());
        createMap.putDouble(KEY_SENT_TIME, (double) remoteMessage.getSentTime());
        if (remoteMessage.getNotification() != null) {
            createMap.putMap("notification", remoteMessageNotificationToWritableMap(remoteMessage.getNotification()));
        }
        return createMap;
    }

    static WritableMap remoteMessageNotificationToWritableMap(RemoteMessage.Notification notification) {
        WritableMap createMap = Arguments.createMap();
        WritableMap createMap2 = Arguments.createMap();
        if (notification.getTitle() != null) {
            createMap.putString("title", notification.getTitle());
        }
        if (notification.getTitleLocalizationKey() != null) {
            createMap.putString("titleLocKey", notification.getTitleLocalizationKey());
        }
        if (notification.getTitleLocalizationArgs() != null) {
            createMap.putArray("titleLocArgs", Arguments.fromJavaArgs(notification.getTitleLocalizationArgs()));
        }
        if (notification.getBody() != null) {
            createMap.putString("body", notification.getBody());
        }
        if (notification.getBodyLocalizationKey() != null) {
            createMap.putString("bodyLocKey", notification.getBodyLocalizationKey());
        }
        if (notification.getBodyLocalizationArgs() != null) {
            createMap.putArray("bodyLocArgs", Arguments.fromJavaArgs(notification.getBodyLocalizationArgs()));
        }
        if (notification.getChannelId() != null) {
            createMap2.putString("channelId", notification.getChannelId());
        }
        if (notification.getClickAction() != null) {
            createMap2.putString("clickAction", notification.getClickAction());
        }
        if (notification.getColor() != null) {
            createMap2.putString("color", notification.getColor());
        }
        if (notification.getIcon() != null) {
            createMap2.putString("smallIcon", notification.getIcon());
        }
        if (notification.getImageUrl() != null) {
            createMap2.putString("imageUrl", notification.getImageUrl().toString());
        }
        if (notification.getLink() != null) {
            createMap2.putString("link", notification.getLink().toString());
        }
        if (notification.getNotificationCount() != null) {
            createMap2.putInt(MetricSummary.JsonKeys.COUNT, notification.getNotificationCount().intValue());
        }
        if (notification.getNotificationPriority() != null) {
            createMap2.putInt(SentryThread.JsonKeys.PRIORITY, notification.getNotificationPriority().intValue());
        }
        if (notification.getSound() != null) {
            createMap2.putString("sound", notification.getSound());
        }
        if (notification.getTicker() != null) {
            createMap2.putString("ticker", notification.getTicker());
        }
        if (notification.getVisibility() != null) {
            createMap2.putInt("visibility", notification.getVisibility().intValue());
        }
        createMap.putMap("android", createMap2);
        return createMap;
    }

    static RemoteMessage remoteMessageFromReadableMap(ReadableMap readableMap) {
        RemoteMessage.Builder builder = new RemoteMessage.Builder(readableMap.getString("to"));
        if (readableMap.hasKey(KEY_TTL)) {
            builder.setTtl(readableMap.getInt(KEY_TTL));
        }
        if (readableMap.hasKey(KEY_MESSAGE_ID)) {
            builder.setMessageId(readableMap.getString(KEY_MESSAGE_ID));
        }
        if (readableMap.hasKey(KEY_MESSAGE_TYPE)) {
            builder.setMessageType(readableMap.getString(KEY_MESSAGE_TYPE));
        }
        if (readableMap.hasKey(KEY_COLLAPSE_KEY)) {
            builder.setCollapseKey(readableMap.getString(KEY_COLLAPSE_KEY));
        }
        if (readableMap.hasKey("data")) {
            ReadableMap map = readableMap.getMap("data");
            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                builder.addData(nextKey, map.getString(nextKey));
            }
        }
        return builder.build();
    }
}
