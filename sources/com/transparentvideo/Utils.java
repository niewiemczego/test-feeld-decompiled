package com.transparentvideo;

import android.content.Context;

public class Utils {
    public static int getRawResourceId(Context context, String str) {
        return context.getResources().getIdentifier("" + str, "raw", context.getPackageName());
    }
}
