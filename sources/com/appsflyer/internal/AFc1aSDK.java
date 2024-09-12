package com.appsflyer.internal;

import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AFc1aSDK<Body> implements ResponseNetwork<Body> {
    public final AFc1eSDK AFInAppEventParameterName;
    private final Body AFInAppEventType;
    final Map<String, List<String>> AFKeystoreWrapper;
    final boolean valueOf;
    final int values;

    public AFc1aSDK(Body body, int i, boolean z, Map<String, List<String>> map, AFc1eSDK aFc1eSDK) {
        this.AFInAppEventType = body;
        this.values = i;
        this.valueOf = z;
        this.AFKeystoreWrapper = new HashMap(map);
        this.AFInAppEventParameterName = aFc1eSDK;
    }

    public Body getBody() {
        return this.AFInAppEventType;
    }

    public int getStatusCode() {
        return this.values;
    }

    public boolean isSuccessful() {
        return this.valueOf;
    }

    public List<String> getHeaderField(String str) {
        for (String next : this.AFKeystoreWrapper.keySet()) {
            if (next != null && next.equalsIgnoreCase(str)) {
                return this.AFKeystoreWrapper.get(next);
            }
        }
        return null;
    }

    public final String valueOf(String str) {
        List<String> headerField = getHeaderField(str);
        if (headerField == null || headerField.isEmpty()) {
            return null;
        }
        Iterator<String> it = headerField.iterator();
        StringBuilder sb = new StringBuilder(it.next());
        while (it.hasNext()) {
            sb.append(", ").append(it.next());
        }
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFc1aSDK aFc1aSDK = (AFc1aSDK) obj;
        if (this.values == aFc1aSDK.values && this.valueOf == aFc1aSDK.valueOf && this.AFInAppEventType.equals(aFc1aSDK.AFInAppEventType) && this.AFKeystoreWrapper.equals(aFc1aSDK.AFKeystoreWrapper)) {
            return this.AFInAppEventParameterName.equals(aFc1aSDK.AFInAppEventParameterName);
        }
        return false;
    }

    public int hashCode() {
        return (((((((this.AFInAppEventType.hashCode() * 31) + this.values) * 31) + (this.valueOf ? 1 : 0)) * 31) + this.AFKeystoreWrapper.hashCode()) * 31) + this.AFInAppEventParameterName.hashCode();
    }
}
