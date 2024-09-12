package com.facebook.hermes.intl;

import android.os.Build;

public class LocaleObject {
    public static ILocaleObject createDefault() {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleObjectICU.createDefault();
        }
        return LocaleObjectAndroid.createDefault();
    }

    public static ILocaleObject createFromLocaleId(String str) throws JSRangeErrorException {
        if (Build.VERSION.SDK_INT >= 24) {
            return LocaleObjectICU.createFromLocaleId(str);
        }
        return LocaleObjectAndroid.createFromLocaleId(str);
    }
}
