package com.appsflyer.internal;

import androidx.webkit.ProxyConfig;
import com.appsflyer.AFLogger;
import java.util.HashMap;
import java.util.Map;

public class AFc1rSDK implements AFc1qSDK, AFc1tSDK, AFd1wSDK {
    private static String AFInAppEventParameterName;
    private static String valueOf;
    private final String AFInAppEventType;
    private final String AFKeystoreWrapper;
    private final boolean AFLogger;
    private boolean afDebugLog;
    private boolean afErrorLog;
    private final Map<String, String> afInfoLog;
    private boolean afRDLog;
    private int afWarnLog;
    private final byte[] values;

    public AFc1rSDK() {
    }

    public static void values(String str) {
        valueOf = str;
        if (str != null) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (i == 0 || i == str.length() - 1) {
                    sb.append(str.charAt(i));
                } else {
                    sb.append(ProxyConfig.MATCH_ALL_SCHEMES);
                }
            }
            AFInAppEventParameterName = sb.toString();
        }
    }

    public static void AFInAppEventParameterName(String str) {
        if (valueOf == null) {
            values(AFb1xSDK.AFInAppEventType().AFKeystoreWrapper().afWarnLog().AFInAppEventType);
        }
        String str2 = valueOf;
        if (str2 != null) {
            AFLogger.afInfoLog(str.replace(str2, AFInAppEventParameterName));
        }
    }

    public AFc1rSDK(String str, byte[] bArr, String str2, Map<String, String> map, boolean z) {
        this.afRDLog = true;
        this.afErrorLog = false;
        this.afDebugLog = true;
        this.afWarnLog = -1;
        this.AFInAppEventType = str;
        this.values = bArr;
        this.AFKeystoreWrapper = str2;
        this.afInfoLog = map;
        this.AFLogger = z;
    }

    public AFc1rSDK(String str, String str2) {
        this(str, (byte[]) null, str2, new HashMap(), false);
    }

    public String values() {
        return this.AFInAppEventType;
    }

    public byte[] AFInAppEventType() {
        return this.values;
    }

    public String AFLogger() {
        return this.AFKeystoreWrapper;
    }

    public Map<String, String> afErrorLog() {
        return this.afInfoLog;
    }

    public boolean afRDLog() {
        return this.AFLogger;
    }

    public int afDebugLog() {
        return this.afWarnLog;
    }

    public AFc1rSDK AFInAppEventParameterName(int i) {
        this.afWarnLog = i;
        return this;
    }

    public boolean afInfoLog() {
        return this.afRDLog;
    }

    public boolean afErrorLogForExcManagerOnly() {
        return this.afErrorLog;
    }

    public AFc1rSDK valueOf(boolean z) {
        this.afErrorLog = z;
        return this;
    }

    public boolean afWarnLog() {
        return this.afDebugLog;
    }

    public AFc1rSDK AFVersionDeclaration() {
        this.afDebugLog = false;
        return this;
    }
}
