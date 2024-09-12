package com.google.android.play.core.integrity;

import android.app.PendingIntent;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class a extends ag {
    private String a;
    private q b;
    private PendingIntent c;

    a() {
    }

    /* access modifiers changed from: package-private */
    public final ag a(PendingIntent pendingIntent) {
        this.c = pendingIntent;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ag b(q qVar) {
        if (qVar != null) {
            this.b = qVar;
            return this;
        }
        throw new NullPointerException("Null logger");
    }

    /* access modifiers changed from: package-private */
    public final ag c(String str) {
        this.a = str;
        return this;
    }

    /* access modifiers changed from: package-private */
    public final ah d() {
        q qVar;
        String str = this.a;
        if (str != null && (qVar = this.b) != null) {
            return new ah(str, qVar, this.c);
        }
        StringBuilder sb = new StringBuilder();
        if (this.a == null) {
            sb.append(" token");
        }
        if (this.b == null) {
            sb.append(" logger");
        }
        throw new IllegalStateException("Missing required properties:".concat(sb.toString()));
    }
}
