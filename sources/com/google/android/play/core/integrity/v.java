package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ae;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class v {
    private static o a;

    static synchronized o a(Context context) {
        o oVar;
        synchronized (v.class) {
            if (a == null) {
                m mVar = new m((l) null);
                mVar.a(ae.a(context));
                a = mVar.b();
            }
            oVar = a;
        }
        return oVar;
    }
}
