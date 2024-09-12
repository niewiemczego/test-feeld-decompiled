package com.launchdarkly.sdk;

import com.facebook.appevents.UserDataStore;
import com.google.gson.annotations.JsonAdapter;
import com.launchdarkly.sdk.json.JsonSerializable;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.IOUtils;

@JsonAdapter(AttributeRefTypeAdapter.class)
public final class AttributeRef implements JsonSerializable, Comparable<AttributeRef> {
    private static final Map<String, AttributeRef> COMMON_LITERALS = makeLiteralsMap("kind", "key", "name", "anonymous", "email", "firstName", "lastName", UserDataStore.COUNTRY, "ip", "avatar");
    private final String[] components;
    private final String error;
    private final String rawPath;
    private final String singlePathComponent;

    private AttributeRef(String str, String str2, String[] strArr) {
        this.error = null;
        this.rawPath = str == null ? "" : str;
        this.singlePathComponent = str2;
        this.components = strArr;
    }

    private AttributeRef(String str, String str2) {
        this.error = str;
        this.rawPath = str2 == null ? "" : str2;
        this.singlePathComponent = null;
        this.components = null;
    }

    public static AttributeRef fromPath(String str) {
        if (str == null || str.isEmpty() || str.equals("/")) {
            return new AttributeRef("attribute reference cannot be empty", str);
        }
        if (str.charAt(0) != '/') {
            return new AttributeRef(str, str, (String[]) null);
        }
        if (str.indexOf(47, 1) < 0) {
            String unescapePath = unescapePath(str.substring(1));
            if (unescapePath == null) {
                return new AttributeRef("attribute reference contained an escape character (~) that was not followed by 0 or 1", str);
            }
            return new AttributeRef(str, unescapePath, (String[]) null);
        } else if (str.endsWith("/")) {
            return new AttributeRef("attribute reference contained a double slash or a trailing slash", str);
        } else {
            String[] split = str.substring(1).split("/");
            for (int i = 0; i < split.length; i++) {
                String str2 = split[i];
                if (str2.isEmpty()) {
                    return new AttributeRef("attribute reference contained a double slash or a trailing slash", str);
                }
                String unescapePath2 = unescapePath(str2);
                if (unescapePath2 == null) {
                    return new AttributeRef("attribute reference contained an escape character (~) that was not followed by 0 or 1", str);
                }
                split[i] = unescapePath2;
            }
            return new AttributeRef(str, (String) null, split);
        }
    }

    public static AttributeRef fromLiteral(String str) {
        if (str == null || str.isEmpty()) {
            return new AttributeRef("attribute reference cannot be empty", "");
        }
        if (str.charAt(0) == '/') {
            return new AttributeRef("/" + str.replace("~", "~0").replace("/", "~1"), str, (String[]) null);
        }
        AttributeRef attributeRef = COMMON_LITERALS.get(str);
        return attributeRef == null ? new AttributeRef(str, str, (String[]) null) : attributeRef;
    }

    public boolean isValid() {
        return this.error == null;
    }

    public String getError() {
        return this.error;
    }

    public int getDepth() {
        if (this.error != null) {
            return 0;
        }
        String[] strArr = this.components;
        if (strArr == null) {
            return 1;
        }
        return strArr.length;
    }

    public String getComponent(int i) {
        String[] strArr = this.components;
        if (strArr == null) {
            if (i == 0) {
                return this.singlePathComponent;
            }
            return null;
        } else if (i < 0 || i >= strArr.length) {
            return null;
        } else {
            return strArr[i];
        }
    }

    public String toString() {
        return this.rawPath;
    }

    public boolean equals(Object obj) {
        if (obj instanceof AttributeRef) {
            return this.rawPath.equals(((AttributeRef) obj).rawPath);
        }
        return false;
    }

    public int hashCode() {
        return this.rawPath.hashCode();
    }

    public int compareTo(AttributeRef attributeRef) {
        return this.rawPath.compareTo(attributeRef.rawPath);
    }

    private static String unescapePath(String str) {
        if (str.indexOf(126) < 0) {
            return str;
        }
        StringBuilder sb = new StringBuilder(100);
        int i = 0;
        while (i < str.length()) {
            char charAt = str.charAt(i);
            if (charAt != '~') {
                sb.append(charAt);
            } else {
                i++;
                if (i >= str.length()) {
                    return null;
                }
                char charAt2 = str.charAt(i);
                if (charAt2 == '0') {
                    sb.append('~');
                } else if (charAt2 != '1') {
                    return null;
                } else {
                    sb.append(IOUtils.DIR_SEPARATOR_UNIX);
                }
            }
            i++;
        }
        return sb.toString();
    }

    private static Map<String, AttributeRef> makeLiteralsMap(String... strArr) {
        HashMap hashMap = new HashMap();
        for (String str : strArr) {
            hashMap.put(str, new AttributeRef(str, str, (String[]) null));
        }
        return hashMap;
    }
}
