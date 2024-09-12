package com.appsflyer.internal;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.facebook.hermes.intl.Constants;
import org.json.JSONException;
import org.json.JSONObject;

public final class AFb1lSDK {
    public final AFb1pSDK AFInAppEventParameterName;
    private final boolean AFInAppEventType;
    public final AFf1tSDK AFKeystoreWrapper;
    public final String valueOf;
    public final String values;

    public AFb1lSDK() {
    }

    public static Uri AFInAppEventType(Activity activity) {
        if (Build.VERSION.SDK_INT >= 22) {
            return activity.getReferrer();
        }
        Intent intent = activity.getIntent();
        Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.REFERRER");
        if (uri != null) {
            return uri;
        }
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        if (stringExtra != null) {
            return Uri.parse(stringExtra);
        }
        return null;
    }

    public AFb1lSDK(String str) throws JSONException {
        AFf1tSDK aFf1tSDK;
        if (str != null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String string = jSONObject.getString("ver");
                this.valueOf = string;
                this.AFInAppEventType = jSONObject.optBoolean("test_mode");
                this.values = str;
                if (string.startsWith(Constants.COLLATION_DEFAULT)) {
                    aFf1tSDK = AFf1tSDK.DEFAULT;
                } else {
                    aFf1tSDK = AFf1tSDK.CUSTOM;
                }
                this.AFKeystoreWrapper = aFf1tSDK;
                AFb1pSDK aFb1pSDK = null;
                JSONObject optJSONObject = jSONObject.optJSONObject("features");
                this.AFInAppEventParameterName = optJSONObject != null ? new AFb1pSDK(optJSONObject) : aFb1pSDK;
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("Error in RC config parsing", e);
                throw new JSONException("Failed to parse remote configuration JSON");
            }
        } else {
            throw new JSONException("Failed to parse remote configuration JSON: originalJson is null");
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AFb1lSDK aFb1lSDK = (AFb1lSDK) obj;
        if (this.AFInAppEventType == aFb1lSDK.AFInAppEventType && this.valueOf.equals(aFb1lSDK.valueOf)) {
            return this.values.equals(aFb1lSDK.values);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = ((((this.AFInAppEventType ? 1 : 0) * true) + this.valueOf.hashCode()) * 31) + this.values.hashCode();
        AFb1pSDK aFb1pSDK = this.AFInAppEventParameterName;
        return aFb1pSDK != null ? (hashCode * 31) + aFb1pSDK.hashCode() : hashCode;
    }
}
