package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class ah extends IntegrityTokenResponse {
    private final String a;
    private final u b;

    ah(String str, q qVar, PendingIntent pendingIntent) {
        this.a = str;
        this.b = new u(qVar, pendingIntent);
    }

    public final String token() {
        return this.a;
    }
}
