package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.core.integrity.StandardIntegrityManager;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class bb extends StandardIntegrityManager.StandardIntegrityToken {
    private final String a;
    private final u b;

    bb(String str, q qVar, PendingIntent pendingIntent) {
        this.a = str;
        this.b = new u(qVar, pendingIntent);
    }

    public final String token() {
        return this.a;
    }
}
