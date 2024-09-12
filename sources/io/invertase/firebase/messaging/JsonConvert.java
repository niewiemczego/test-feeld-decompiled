package io.invertase.firebase.messaging;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class JsonConvert {
    public static JSONObject reactToJSON(ReadableMap readableMap) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                case 1:
                    jSONObject.put(nextKey, JSONObject.NULL);
                    break;
                case 2:
                    jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                    break;
                case 3:
                    try {
                        jSONObject.put(nextKey, readableMap.getInt(nextKey));
                        break;
                    } catch (Exception unused) {
                        jSONObject.put(nextKey, readableMap.getDouble(nextKey));
                        break;
                    }
                case 4:
                    jSONObject.put(nextKey, (Object) readableMap.getString(nextKey));
                    break;
                case 5:
                    jSONObject.put(nextKey, (Object) reactToJSON(readableMap.getMap(nextKey)));
                    break;
                case 6:
                    jSONObject.put(nextKey, (Object) reactToJSON(readableMap.getArray(nextKey)));
                    break;
            }
        }
        return jSONObject;
    }

    /* renamed from: io.invertase.firebase.messaging.JsonConvert$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$facebook$react$bridge$ReadableType;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.facebook.react.bridge.ReadableType[] r0 = com.facebook.react.bridge.ReadableType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$facebook$react$bridge$ReadableType = r0
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Null     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Boolean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Number     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.String     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x003e }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Map     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$facebook$react$bridge$ReadableType     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.facebook.react.bridge.ReadableType r1 = com.facebook.react.bridge.ReadableType.Array     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.invertase.firebase.messaging.JsonConvert.AnonymousClass1.<clinit>():void");
        }
    }

    public static JSONArray reactToJSON(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    jSONArray.put(JSONObject.NULL);
                    break;
                case 2:
                    jSONArray.put(readableArray.getBoolean(i));
                    break;
                case 3:
                    try {
                        jSONArray.put(readableArray.getInt(i));
                        break;
                    } catch (Exception unused) {
                        jSONArray.put(readableArray.getDouble(i));
                        break;
                    }
                case 4:
                    jSONArray.put((Object) readableArray.getString(i));
                    break;
                case 5:
                    jSONArray.put((Object) reactToJSON(readableArray.getMap(i)));
                    break;
                case 6:
                    jSONArray.put((Object) reactToJSON(readableArray.getArray(i)));
                    break;
            }
        }
        return jSONArray;
    }

    public static WritableMap jsonToReact(JSONObject jSONObject) throws JSONException {
        WritableMap createMap = Arguments.createMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if ((obj instanceof Float) || (obj instanceof Double)) {
                createMap.putDouble(next, jSONObject.getDouble(next));
            } else if (obj instanceof Number) {
                createMap.putInt(next, jSONObject.getInt(next));
            } else if (obj instanceof String) {
                createMap.putString(next, jSONObject.getString(next));
            } else if (obj instanceof JSONObject) {
                createMap.putMap(next, jsonToReact(jSONObject.getJSONObject(next)));
            } else if (obj instanceof JSONArray) {
                createMap.putArray(next, jsonToReact(jSONObject.getJSONArray(next)));
            } else if (obj == JSONObject.NULL) {
                createMap.putNull(next);
            }
        }
        return createMap;
    }

    public static WritableArray jsonToReact(JSONArray jSONArray) throws JSONException {
        WritableArray createArray = Arguments.createArray();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if ((obj instanceof Float) || (obj instanceof Double)) {
                createArray.pushDouble(jSONArray.getDouble(i));
            } else if (obj instanceof Number) {
                createArray.pushInt(jSONArray.getInt(i));
            } else if (obj instanceof String) {
                createArray.pushString(jSONArray.getString(i));
            } else if (obj instanceof JSONObject) {
                createArray.pushMap(jsonToReact(jSONArray.getJSONObject(i)));
            } else if (obj instanceof JSONArray) {
                createArray.pushArray(jsonToReact(jSONArray.getJSONArray(i)));
            } else if (obj == JSONObject.NULL) {
                createArray.pushNull();
            }
        }
        return createArray;
    }
}
