package zendesk.faye.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import zendesk.faye.BayeuxOptionalFields;
import zendesk.logger.Logger;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0018\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ \u0010\u001f\u001a\u00020\u00042\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\u0012\u0010!\u001a\u0004\u0018\u00010\"2\u0006\u0010#\u001a\u00020\u0004H\u0002J\u0012\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010#\u001a\u00020\u0004H\u0002J,\u0010&\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\u0006\u0010(\u001a\u00020\u00042\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\"\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020%2\u0006\u0010,\u001a\u00020\u00042\b\u0010-\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010.\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ \u0010/\u001a\u00020\u00042\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010'\u001a\u00020\u00042\b\b\u0002\u0010\u001c\u001a\u00020\u001dR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0019X\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lzendesk/faye/internal/Bayeux;", "", "()V", "CONNECT_CHANNEL", "", "DISCONNECT_CHANNEL", "HANDSHAKE_CHANNEL", "KEY_CHANNEL", "KEY_CLIENT_ID", "KEY_CONNECTION_TYPE", "KEY_DATA", "KEY_EXT", "KEY_ID", "KEY_MIN_VERSION", "KEY_SUBSCRIPTION", "KEY_SUCCESS", "KEY_SUPPORT_CONNECTION_TYPES", "KEY_VERSION", "LOG_TAG", "SUBSCRIBE_CHANNEL", "UNSUBSCRIBE_CHANNEL", "VALUE_CONN_TYPE", "VALUE_MIN_VERSION", "VALUE_VERSION", "defaultConnectionTypes", "", "connect", "clientId", "bayeuxOptionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "disconnect", "handshake", "supportedConnTypes", "isJsonArray", "Lorg/json/JSONArray;", "value", "isJsonObject", "Lorg/json/JSONObject;", "publish", "channel", "data", "putField", "", "jsonObject", "fieldName", "fieldValue", "subscribe", "unsubscribe", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Bayeux.kt */
public final class Bayeux {
    public static final String CONNECT_CHANNEL = "/meta/connect";
    public static final String DISCONNECT_CHANNEL = "/meta/disconnect";
    public static final String HANDSHAKE_CHANNEL = "/meta/handshake";
    public static final Bayeux INSTANCE = new Bayeux();
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CLIENT_ID = "clientId";
    private static final String KEY_CONNECTION_TYPE = "connectionType";
    public static final String KEY_DATA = "data";
    private static final String KEY_EXT = "ext";
    private static final String KEY_ID = "id";
    private static final String KEY_MIN_VERSION = "minimumVersion";
    public static final String KEY_SUBSCRIPTION = "subscription";
    public static final String KEY_SUCCESS = "successful";
    private static final String KEY_SUPPORT_CONNECTION_TYPES = "supportedConnectionTypes";
    private static final String KEY_VERSION = "version";
    private static final String LOG_TAG = "Bayeux";
    public static final String SUBSCRIBE_CHANNEL = "/meta/subscribe";
    public static final String UNSUBSCRIBE_CHANNEL = "/meta/unsubscribe";
    private static final String VALUE_CONN_TYPE = "websocket";
    private static final String VALUE_MIN_VERSION = "1.0beta";
    private static final String VALUE_VERSION = "1.0";
    private static final List<String> defaultConnectionTypes = CollectionsKt.listOf("long-polling", "callback-polling", "iframe", VALUE_CONN_TYPE);

    private Bayeux() {
    }

    public static /* synthetic */ String handshake$default(Bayeux bayeux, List<String> list, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 1) != 0) {
            list = defaultConnectionTypes;
        }
        if ((i & 2) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.handshake(list, bayeuxOptionalFields);
    }

    public final String handshake(List<String> list, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(list, "supportedConnTypes");
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONArray jSONArray = new JSONArray();
            if (!(!list.isEmpty())) {
                list = null;
            }
            if (list == null) {
                list = defaultConnectionTypes;
            }
            Iterable<Object> iterable = list;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Object put : iterable) {
                arrayList.add(jSONArray.put(put));
            }
            List list2 = (List) arrayList;
            JSONObject put2 = new JSONObject().put("channel", (Object) HANDSHAKE_CHANNEL).put(KEY_MIN_VERSION, (Object) VALUE_MIN_VERSION).put("version", (Object) "1.0").put(KEY_SUPPORT_CONNECTION_TYPES, (Object) jSONArray);
            Intrinsics.checkNotNullExpressionValue(put2, "json");
            putField(put2, KEY_EXT, bayeuxOptionalFields.getExt());
            put2.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put2.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val connTy…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "handshake - malformed json", new Object[0]);
            return "";
        }
    }

    public static /* synthetic */ String connect$default(Bayeux bayeux, String str, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 2) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.connect(str, bayeuxOptionalFields);
    }

    public final String connect(String str, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(str, KEY_CLIENT_ID);
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONObject put = new JSONObject().put("channel", (Object) CONNECT_CHANNEL).put(KEY_CLIENT_ID, (Object) str).put(KEY_CONNECTION_TYPE, (Object) VALUE_CONN_TYPE);
            Intrinsics.checkNotNullExpressionValue(put, "json");
            putField(put, KEY_EXT, bayeuxOptionalFields.getExt());
            put.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val json =…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "connect - malformed json", new Object[0]);
            return "";
        }
    }

    public static /* synthetic */ String disconnect$default(Bayeux bayeux, String str, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 2) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.disconnect(str, bayeuxOptionalFields);
    }

    public final String disconnect(String str, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(str, KEY_CLIENT_ID);
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONObject put = new JSONObject().put("channel", (Object) DISCONNECT_CHANNEL).put(KEY_CLIENT_ID, (Object) str);
            Intrinsics.checkNotNullExpressionValue(put, "json");
            putField(put, KEY_EXT, bayeuxOptionalFields.getExt());
            put.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val json =…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "disconnect - malformed json", new Object[0]);
            return "";
        }
    }

    public static /* synthetic */ String subscribe$default(Bayeux bayeux, String str, String str2, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 4) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.subscribe(str, str2, bayeuxOptionalFields);
    }

    public final String subscribe(String str, String str2, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(str, KEY_CLIENT_ID);
        Intrinsics.checkNotNullParameter(str2, "channel");
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONObject put = new JSONObject().put("channel", (Object) SUBSCRIBE_CHANNEL).put(KEY_CLIENT_ID, (Object) str).put(KEY_SUBSCRIPTION, (Object) str2);
            Intrinsics.checkNotNullExpressionValue(put, "json");
            putField(put, KEY_EXT, bayeuxOptionalFields.getExt());
            put.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val json =…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "subscribe - malformed json", new Object[0]);
            return "";
        }
    }

    public static /* synthetic */ String unsubscribe$default(Bayeux bayeux, String str, String str2, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 4) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.unsubscribe(str, str2, bayeuxOptionalFields);
    }

    public final String unsubscribe(String str, String str2, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(str, KEY_CLIENT_ID);
        Intrinsics.checkNotNullParameter(str2, "channel");
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONObject put = new JSONObject().put("channel", (Object) UNSUBSCRIBE_CHANNEL).put(KEY_CLIENT_ID, (Object) str).put(KEY_SUBSCRIPTION, (Object) str2);
            Intrinsics.checkNotNullExpressionValue(put, "json");
            putField(put, KEY_EXT, bayeuxOptionalFields.getExt());
            put.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val json =…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "unsubscribe - malformed json", new Object[0]);
            return "";
        }
    }

    public static /* synthetic */ String publish$default(Bayeux bayeux, String str, String str2, String str3, BayeuxOptionalFields bayeuxOptionalFields, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            bayeuxOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        }
        return bayeux.publish(str, str2, str3, bayeuxOptionalFields);
    }

    public final String publish(String str, String str2, String str3, BayeuxOptionalFields bayeuxOptionalFields) {
        Intrinsics.checkNotNullParameter(str, "channel");
        Intrinsics.checkNotNullParameter(str2, "data");
        Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
        try {
            JSONObject put = new JSONObject().put("channel", (Object) str);
            if (str3 != null) {
                put.put(KEY_CLIENT_ID, (Object) str3);
            }
            Intrinsics.checkNotNullExpressionValue(put, "json");
            putField(put, "data", str2);
            putField(put, KEY_EXT, bayeuxOptionalFields.getExt());
            put.put("id", (Object) bayeuxOptionalFields.getId());
            String jSONObject = put.toString();
            Intrinsics.checkNotNullExpressionValue(jSONObject, "{\n            val json =…json.toString()\n        }");
            return jSONObject;
        } catch (JSONException unused) {
            Logger.w(LOG_TAG, "publish - malformed json", new Object[0]);
            return "";
        }
    }

    private final void putField(JSONObject jSONObject, String str, String str2) throws JSONException {
        JSONArray isJsonArray;
        if (str2 == null) {
            Logger.w(LOG_TAG, "putField - value for field with name " + str + " was null, skipping", new Object[0]);
            return;
        }
        JSONObject isJsonObject = isJsonObject(str2);
        if ((isJsonObject == null || jSONObject.put(str, (Object) isJsonObject) == null) && (isJsonArray = isJsonArray(str2)) != null) {
            jSONObject.put(str, (Object) isJsonArray);
        }
    }

    private final JSONObject isJsonObject(String str) {
        if (StringsKt.startsWith$default(str, "{", false, 2, (Object) null)) {
            try {
                return new JSONObject(str);
            } catch (JSONException unused) {
                Logger.w(LOG_TAG, "isJsonObject - Invalid Json Object received: " + str, new Object[0]);
                JSONObject jSONObject = null;
                return null;
            }
        } else {
            Logger.w(LOG_TAG, "isJsonObject - Received value is not a Json Object: " + str, new Object[0]);
            JSONObject jSONObject2 = null;
            return null;
        }
    }

    private final JSONArray isJsonArray(String str) {
        if (StringsKt.startsWith$default(str, "[", false, 2, (Object) null)) {
            try {
                return new JSONArray(str);
            } catch (JSONException unused) {
                Logger.w(LOG_TAG, "isJsonArray - Invalid Json Array received: " + str, new Object[0]);
                JSONArray jSONArray = null;
                return null;
            }
        } else {
            Logger.w(LOG_TAG, "isJsonArray - Received value is not a Json Array: " + str, new Object[0]);
            JSONArray jSONArray2 = null;
            return null;
        }
    }
}
