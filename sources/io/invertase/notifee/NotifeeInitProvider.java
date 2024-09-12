package io.invertase.notifee;

import android.content.Context;
import app.notifee.core.InitProvider;
import app.notifee.core.Notifee;
import com.facebook.react.modules.systeminfo.ReactNativeVersion;
import java.util.Map;

public class NotifeeInitProvider extends InitProvider {
    public boolean onCreate() {
        boolean onCreate = super.onCreate();
        Notifee.initialize(new NotifeeEventSubscriber());
        return onCreate;
    }

    private String getApplicationVersionString() {
        Context context = getContext();
        if (context != null) {
            try {
                return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception unused) {
            }
        }
        return "unknown";
    }

    private String getReactNativeVersionString() {
        Map<String, Object> map = ReactNativeVersion.VERSION;
        int intValue = ((Integer) map.get("major")).intValue();
        int intValue2 = ((Integer) map.get("minor")).intValue();
        int intValue3 = ((Integer) map.get("patch")).intValue();
        String str = (String) map.get("prerelease");
        String str2 = intValue + "." + intValue2 + "." + intValue3;
        return str != null ? str2 + "." + str : str2;
    }
}
