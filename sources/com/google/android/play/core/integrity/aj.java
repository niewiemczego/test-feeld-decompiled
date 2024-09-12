package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ae;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class aj {
    private static s a;

    static synchronized s a(Context context) {
        s sVar;
        synchronized (aj.class) {
            if (a == null) {
                q qVar = new q((p) null);
                qVar.a(ae.a(context));
                a = qVar.b();
            }
            sVar = a;
        }
        return sVar;
    }
}
