package com.appsflyer.internal;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.util.Base64;
import com.appsflyer.AFLogger;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFa1oSDK {
    public String AFInAppEventParameterName;
    public AFd1sSDK AFInAppEventType;
    public String AFKeystoreWrapper;
    private byte[] valueOf;
    public String values;

    public AFa1oSDK() {
    }

    public static JSONObject values(Map<String, ?> map) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : map.entrySet()) {
            try {
                jSONObject.put((String) next.getKey(), AFKeystoreWrapper(next.getValue()));
            } catch (JSONException unused) {
            }
        }
        return jSONObject;
    }

    public static JSONObject AFInAppEventParameterName(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    private static Object AFKeystoreWrapper(Object obj) {
        if (obj == null) {
            return JSONObject.NULL;
        }
        if ((obj instanceof JSONArray) || (obj instanceof JSONObject) || obj.equals(JSONObject.NULL)) {
            return obj;
        }
        try {
            if (obj instanceof Collection) {
                JSONArray jSONArray = new JSONArray();
                for (Object AFKeystoreWrapper2 : (Collection) obj) {
                    jSONArray.put(AFKeystoreWrapper(AFKeystoreWrapper2));
                }
                return jSONArray;
            } else if (obj.getClass().isArray()) {
                int length = Array.getLength(obj);
                JSONArray jSONArray2 = new JSONArray();
                for (int i = 0; i < length; i++) {
                    jSONArray2.put(AFKeystoreWrapper(Array.get(obj, i)));
                }
                return jSONArray2;
            } else if (obj instanceof Map) {
                return values((Map) obj);
            } else {
                return ((obj instanceof Boolean) || (obj instanceof Byte) || (obj instanceof Character) || (obj instanceof Double) || (obj instanceof Float) || (obj instanceof Integer) || (obj instanceof Long) || (obj instanceof Short) || (obj instanceof String)) ? obj : obj.toString();
            }
        } catch (Exception unused) {
            return JSONObject.NULL;
        }
    }

    public static Map<String, Object> AFInAppEventType(JSONObject jSONObject) throws JSONException {
        HashMap hashMap = new HashMap();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof JSONArray) {
                obj = AFInAppEventParameterName((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            hashMap.put(next, obj);
        }
        return hashMap;
    }

    private static List<Object> AFInAppEventParameterName(JSONArray jSONArray) throws JSONException {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj = jSONArray.get(i);
            if (obj instanceof JSONArray) {
                obj = AFInAppEventParameterName((JSONArray) obj);
            } else if (obj instanceof JSONObject) {
                obj = AFInAppEventType((JSONObject) obj);
            }
            arrayList.add(obj);
        }
        return arrayList;
    }

    static AFe1gSDK AFKeystoreWrapper(Context context) {
        if (context instanceof Activity) {
            return AFe1gSDK.activity;
        }
        if (context instanceof Application) {
            return AFe1gSDK.application;
        }
        return AFe1gSDK.other;
    }

    public AFa1oSDK(String str, byte[] bArr, String str2, AFd1sSDK aFd1sSDK) {
        this.AFKeystoreWrapper = str;
        this.valueOf = bArr;
        this.values = str2;
        this.AFInAppEventType = aFd1sSDK;
    }

    public AFa1oSDK(char[] cArr) {
        Scanner scanner = new Scanner(new String(cArr));
        int i = 0;
        int i2 = 0;
        while (scanner.hasNextLine()) {
            String nextLine = scanner.nextLine();
            if (nextLine.startsWith("url=")) {
                this.AFKeystoreWrapper = nextLine.substring(4).trim();
            } else if (nextLine.startsWith("version=")) {
                this.values = nextLine.substring(8).trim();
                Matcher matcher = Pattern.compile("^(0|[1-9]\\d*)\\.(0|[1-9]\\d*)\\.(0|[1-9]\\d*)(?:-((?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*)(?:\\.(?:0|[1-9]\\d*|\\d*[a-zA-Z-][0-9a-zA-Z-]*))*))?(?:\\+([0-9a-zA-Z-]+(?:\\.[0-9a-zA-Z-]+)*))?$").matcher(this.values);
                if (matcher.matches()) {
                    i = Integer.parseInt(matcher.group(1));
                    i2 = Integer.parseInt(matcher.group(2));
                }
            } else if (nextLine.startsWith("data=")) {
                String trim = nextLine.substring(5).trim();
                this.valueOf = (i > 4 || i2 >= 11) ? Base64.decode(trim, 2) : trim.getBytes();
            } else if (nextLine.startsWith("type=")) {
                String trim2 = nextLine.substring(5).trim();
                try {
                    this.AFInAppEventType = AFd1sSDK.valueOf(trim2);
                } catch (Exception e) {
                    AFLogger.afErrorLog("CACHE: Unknown task type: ".concat(String.valueOf(trim2)), e);
                }
            }
        }
        scanner.close();
    }

    public final byte[] values() {
        return this.valueOf;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            AFa1oSDK aFa1oSDK = (AFa1oSDK) obj;
            String str = this.values;
            if (str == null ? aFa1oSDK.values != null : !str.equals(aFa1oSDK.values)) {
                return false;
            }
            if (!Arrays.equals(this.valueOf, aFa1oSDK.valueOf)) {
                return false;
            }
            String str2 = this.AFKeystoreWrapper;
            if (str2 == null ? aFa1oSDK.AFKeystoreWrapper != null : !str2.equals(aFa1oSDK.AFKeystoreWrapper)) {
                return false;
            }
            String str3 = this.AFInAppEventParameterName;
            if (str3 == null ? aFa1oSDK.AFInAppEventParameterName != null : !str3.equals(aFa1oSDK.AFInAppEventParameterName)) {
                return false;
            }
            if (this.AFInAppEventType == aFa1oSDK.AFInAppEventType) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.values;
        int i = 0;
        int hashCode = (((str != null ? str.hashCode() : 0) * 31) + Arrays.hashCode(this.valueOf)) * 31;
        String str2 = this.AFKeystoreWrapper;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.AFInAppEventParameterName;
        int hashCode3 = (hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31;
        AFd1sSDK aFd1sSDK = this.AFInAppEventType;
        if (aFd1sSDK != null) {
            i = aFd1sSDK.hashCode();
        }
        return hashCode3 + i;
    }
}
