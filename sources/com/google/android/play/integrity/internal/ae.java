package com.google.android.play.integrity.internal;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class ae {
    public static Context a(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext != null ? applicationContext : context;
    }
}
