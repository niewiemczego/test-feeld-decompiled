package org.json;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.google.firebase.dynamiclinks.DynamicLink;
import expo.modules.interfaces.permissions.PermissionsResponse;

public class Cookie {
    public static String escape(String str) {
        String trim = str.trim();
        int length = trim.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            char charAt = trim.charAt(i);
            if (charAt < ' ' || charAt == '+' || charAt == '%' || charAt == '=' || charAt == ';') {
                sb.append('%');
                sb.append(Character.forDigit((char) ((charAt >>> 4) & 15), 16));
                sb.append(Character.forDigit((char) (charAt & 15), 16));
            } else {
                sb.append(charAt);
            }
        }
        return sb.toString();
    }

    public static JSONObject toJSONObject(String str) throws JSONException {
        Object obj;
        JSONObject jSONObject = new JSONObject();
        JSONTokener jSONTokener = new JSONTokener(str);
        jSONObject.put("name", (Object) jSONTokener.nextTo('='));
        jSONTokener.next('=');
        jSONObject.put("value", (Object) jSONTokener.nextTo(';'));
        jSONTokener.next();
        while (jSONTokener.more()) {
            String unescape = unescape(jSONTokener.nextTo("=;"));
            if (jSONTokener.next() == '=') {
                obj = unescape(jSONTokener.nextTo(';'));
                jSONTokener.next();
            } else if (unescape.equals("secure")) {
                obj = Boolean.TRUE;
            } else {
                throw jSONTokener.syntaxError("Missing '=' in cookie parameter.");
            }
            jSONObject.put(unescape, obj);
        }
        return jSONObject;
    }

    public static String toString(JSONObject jSONObject) throws JSONException {
        StringBuilder sb = new StringBuilder();
        sb.append(escape(jSONObject.getString("name")));
        sb.append("=");
        sb.append(escape(jSONObject.getString("value")));
        if (jSONObject.has(PermissionsResponse.EXPIRES_KEY)) {
            sb.append(";expires=");
            sb.append(jSONObject.getString(PermissionsResponse.EXPIRES_KEY));
        }
        if (jSONObject.has(DynamicLink.Builder.KEY_DOMAIN)) {
            sb.append(";domain=");
            sb.append(escape(jSONObject.getString(DynamicLink.Builder.KEY_DOMAIN)));
        }
        if (jSONObject.has(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)) {
            sb.append(";path=");
            sb.append(escape(jSONObject.getString(ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH)));
        }
        if (jSONObject.optBoolean("secure")) {
            sb.append(";secure");
        }
        return sb.toString();
    }

    public static String unescape(String str) {
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length);
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt == '+') {
                charAt = ' ';
            } else if (charAt == '%' && (i = i2 + 2) < length) {
                int dehexchar = JSONTokener.dehexchar(str.charAt(i2 + 1));
                int dehexchar2 = JSONTokener.dehexchar(str.charAt(i));
                if (dehexchar >= 0 && dehexchar2 >= 0) {
                    charAt = (char) ((dehexchar * 16) + dehexchar2);
                    i2 = i;
                }
            }
            sb.append(charAt);
            i2++;
        }
        return sb.toString();
    }
}
