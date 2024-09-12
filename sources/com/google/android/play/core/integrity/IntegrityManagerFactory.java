package com.google.android.play.core.integrity;

import android.content.Context;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public class IntegrityManagerFactory {
    private IntegrityManagerFactory() {
    }

    public static IntegrityManager create(Context context) {
        return v.a(context).a();
    }

    public static StandardIntegrityManager createStandard(Context context) {
        return aj.a(context).a();
    }
}
