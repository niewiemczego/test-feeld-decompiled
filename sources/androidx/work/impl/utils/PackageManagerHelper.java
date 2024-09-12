package androidx.work.impl.utils;

import android.content.ComponentName;
import android.content.Context;
import androidx.work.Logger;

public class PackageManagerHelper {
    private static final String TAG = Logger.tagWithPrefix("PackageManagerHelper");

    private PackageManagerHelper() {
    }

    public static void setComponentEnabled(Context context, Class<?> cls, boolean z) {
        String str;
        String str2 = "enabled";
        try {
            context.getPackageManager().setComponentEnabledSetting(new ComponentName(context, cls.getName()), z ? 1 : 2, 1);
            Logger logger = Logger.get();
            String str3 = TAG;
            StringBuilder append = new StringBuilder().append(cls.getName()).append(" ");
            if (z) {
                str = str2;
            } else {
                str = "disabled";
            }
            logger.debug(str3, append.append(str).toString());
        } catch (Exception e) {
            Logger logger2 = Logger.get();
            String str4 = TAG;
            StringBuilder append2 = new StringBuilder().append(cls.getName()).append("could not be ");
            if (!z) {
                str2 = "disabled";
            }
            logger2.debug(str4, append2.append(str2).toString(), e);
        }
    }

    public static boolean isComponentExplicitlyEnabled(Context context, Class<?> cls) {
        return isComponentExplicitlyEnabled(context, cls.getName());
    }

    public static boolean isComponentExplicitlyEnabled(Context context, String str) {
        return context.getPackageManager().getComponentEnabledSetting(new ComponentName(context, str)) == 1;
    }
}
