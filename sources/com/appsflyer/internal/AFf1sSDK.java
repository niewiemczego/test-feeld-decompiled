package com.appsflyer.internal;

import android.content.Context;
import android.net.Uri;
import com.appsflyer.AFInAppEventType;

public final class AFf1sSDK extends AFf1ySDK {
    public AFf1sSDK(Context context) {
        super(AFInAppEventType.PURCHASE, Boolean.TRUE, context);
    }

    public final AFd1sSDK AFKeystoreWrapper() {
        return AFd1sSDK.PURCHASE_VALIDATE;
    }

    public final AFa1sSDK AFInAppEventParameterName(String str) {
        String AFInAppEventParameterName = AFb1xSDK.AFInAppEventType().AFInAppEventParameterName((Context) this.AFKeystoreWrapper);
        if (AFInAppEventParameterName != null) {
            str = Uri.parse(str).buildUpon().appendQueryParameter("channel", AFInAppEventParameterName).build().toString();
        }
        return super.AFInAppEventParameterName(str);
    }
}
