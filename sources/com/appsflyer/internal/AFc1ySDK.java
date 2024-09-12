package com.appsflyer.internal;

import android.content.SharedPreferences;
import com.appsflyer.AFLogger;

public final class AFc1ySDK implements AFc1xSDK {
    private final SharedPreferences valueOf;

    public AFc1ySDK(SharedPreferences sharedPreferences) {
        this.valueOf = sharedPreferences;
    }

    public final void AFKeystoreWrapper(String str, String str2) {
        this.valueOf.edit().putString(str, str2).apply();
    }

    public final String AFInAppEventType(String str, String str2) {
        try {
            return this.valueOf.getString(str, str2);
        } catch (ClassCastException e) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e);
            return str2;
        }
    }

    public final boolean AFInAppEventParameterName(String str) {
        try {
            return this.valueOf.getBoolean(str, false);
        } catch (ClassCastException e) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e);
            return false;
        }
    }

    public final void AFInAppEventType(String str, boolean z) {
        this.valueOf.edit().putBoolean(str, z).apply();
    }

    public final long AFKeystoreWrapper(String str, long j) {
        try {
            return this.valueOf.getLong(str, j);
        } catch (ClassCastException e) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e);
            return j;
        }
    }

    public final void AFInAppEventType(String str, long j) {
        this.valueOf.edit().putLong(str, j).apply();
    }

    public final void valueOf(String str, int i) {
        this.valueOf.edit().putInt(str, i).apply();
    }

    public final int AFKeystoreWrapper(String str, int i) {
        try {
            return this.valueOf.getInt(str, i);
        } catch (ClassCastException e) {
            AFLogger.afErrorLog("Unexpected data type found for key ".concat(String.valueOf(str)), e);
            return i;
        }
    }

    public final void valueOf(String str) {
        this.valueOf.edit().remove(str).apply();
    }
}
