package com.appsflyer.reactnative;

import android.os.Bundle;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RNUtil {
    private RNUtil() {
    }

    public static Map<String, Object> toMap(@Nullable ReadableMap readableMap) {
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (!keySetIterator.hasNextKey()) {
            return null;
        }
        HashMap hashMap = new HashMap();
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            hashMap.put(nextKey, toObject(readableMap, nextKey));
        }
        return hashMap;
    }

    /* renamed from: com.appsflyer.reactnative.RNUtil$1  reason: invalid class name */
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
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.reactnative.RNUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public static Object toObject(@Nullable ReadableMap readableMap, String str) {
        if (readableMap == null) {
            return null;
        }
        switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(str).ordinal()]) {
            case 1:
                return null;
            case 2:
                return Boolean.valueOf(readableMap.getBoolean(str));
            case 3:
                double d = readableMap.getDouble(str);
                int i = (int) d;
                if (d == ((double) i)) {
                    return Integer.valueOf(i);
                }
                return Double.valueOf(d);
            case 4:
                return readableMap.getString(str);
            case 5:
                return toMap(readableMap.getMap(str));
            case 6:
                return toList(readableMap.getArray(str));
            default:
                throw new IllegalArgumentException("Could not convert object with key: " + str + ".");
        }
    }

    public static List<Object> toList(@Nullable ReadableArray readableArray) {
        if (readableArray == null) {
            return null;
        }
        List<Object> arrayList = new ArrayList<>(readableArray.size());
        for (int i = 0; i < readableArray.size(); i++) {
            switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()]) {
                case 1:
                    arrayList.add((Object) null);
                    break;
                case 2:
                    arrayList.add(Boolean.valueOf(readableArray.getBoolean(i)));
                    break;
                case 3:
                    double d = readableArray.getDouble(i);
                    int i2 = (int) d;
                    if (d != ((double) i2)) {
                        arrayList.add(Double.valueOf(d));
                        break;
                    } else {
                        arrayList.add(Integer.valueOf(i2));
                        break;
                    }
                case 4:
                    arrayList.add(readableArray.getString(i));
                    break;
                case 5:
                    arrayList.add(toMap(readableArray.getMap(i)));
                    break;
                case 6:
                    arrayList = toList(readableArray.getArray(i));
                    break;
                default:
                    throw new IllegalArgumentException("Could not convert object with index: " + i + ".");
            }
        }
        return arrayList;
    }

    @Nullable
    public static JSONObject readableMapToJson(ReadableMap readableMap) {
        JSONObject jSONObject = new JSONObject();
        if (readableMap == null) {
            return null;
        }
        ReadableMapKeySetIterator keySetIterator = readableMap.keySetIterator();
        if (!keySetIterator.hasNextKey()) {
            return null;
        }
        while (keySetIterator.hasNextKey()) {
            String nextKey = keySetIterator.nextKey();
            try {
                switch (AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableMap.getType(nextKey).ordinal()]) {
                    case 1:
                        jSONObject.put(nextKey, (Object) null);
                        break;
                    case 2:
                        jSONObject.put(nextKey, readableMap.getBoolean(nextKey));
                        break;
                    case 3:
                        jSONObject.put(nextKey, readableMap.getInt(nextKey));
                        break;
                    case 4:
                        jSONObject.put(nextKey, (Object) readableMap.getString(nextKey));
                        break;
                    case 5:
                        jSONObject.put(nextKey, (Object) readableMapToJson(readableMap.getMap(nextKey)));
                        break;
                    case 6:
                        jSONObject.put(nextKey, (Object) convertArrayToJson(readableMap.getArray(nextKey)));
                        break;
                }
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    private static JSONArray convertArrayToJson(ReadableArray readableArray) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < readableArray.size(); i++) {
            int i2 = AnonymousClass1.$SwitchMap$com$facebook$react$bridge$ReadableType[readableArray.getType(i).ordinal()];
            if (i2 == 2) {
                jSONArray.put(readableArray.getBoolean(i));
            } else if (i2 == 3) {
                jSONArray.put(readableArray.getDouble(i));
            } else if (i2 == 4) {
                jSONArray.put((Object) readableArray.getString(i));
            } else if (i2 == 5) {
                jSONArray.put((Object) readableMapToJson(readableArray.getMap(i)));
            } else if (i2 == 6) {
                jSONArray.put((Object) convertArrayToJson(readableArray.getArray(i)));
            }
        }
        return jSONArray;
    }

    @Nullable
    public static WritableMap jsonToWritableMap(JSONObject jSONObject) {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (jSONObject == null) {
            return null;
        }
        Iterator<String> keys = jSONObject.keys();
        if (!keys.hasNext()) {
            return null;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                Object obj = jSONObject.get(next);
                if (obj == null) {
                    writableNativeMap.putNull(next);
                } else if (obj instanceof Boolean) {
                    writableNativeMap.putBoolean(next, ((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeMap.putInt(next, ((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeMap.putDouble(next, ((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeMap.putString(next, (String) obj);
                } else if (obj instanceof JSONObject) {
                    writableNativeMap.putMap(next, jsonToWritableMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeMap.putArray(next, jsonArrayToWritableArray((JSONArray) obj));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeMap;
    }

    @Nullable
    public static WritableArray jsonArrayToWritableArray(JSONArray jSONArray) {
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            try {
                Object obj = jSONArray.get(i);
                if (obj == null) {
                    writableNativeArray.pushNull();
                } else if (obj instanceof Boolean) {
                    writableNativeArray.pushBoolean(((Boolean) obj).booleanValue());
                } else if (obj instanceof Integer) {
                    writableNativeArray.pushInt(((Integer) obj).intValue());
                } else if (obj instanceof Double) {
                    writableNativeArray.pushDouble(((Double) obj).doubleValue());
                } else if (obj instanceof String) {
                    writableNativeArray.pushString((String) obj);
                } else if (obj instanceof JSONObject) {
                    writableNativeArray.pushMap(jsonToWritableMap((JSONObject) obj));
                } else if (obj instanceof JSONArray) {
                    writableNativeArray.pushArray(jsonArrayToWritableArray((JSONArray) obj));
                }
            } catch (JSONException unused) {
            }
        }
        return writableNativeArray;
    }

    @Nullable
    public static Map<String, String> jsonObjectToMap(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            hashMap.put(next, (String) jSONObject.get(next));
        }
        return hashMap;
    }

    public static Bundle jsonToBundle(JSONObject jSONObject) throws JSONException {
        Bundle bundle = new Bundle();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            bundle.putString(next, jSONObject.getString(next));
        }
        return bundle;
    }
}
