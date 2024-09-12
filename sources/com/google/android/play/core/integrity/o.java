package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ah;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.aj;
import com.google.android.play.integrity.internal.al;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class o {
    private final o a = this;
    private final al b;
    private final al c;
    private final al d;
    private final al e;

    /* synthetic */ o(Context context, n nVar) {
        ai b2 = aj.b(context);
        this.b = b2;
        al b3 = ah.b(y.a);
        this.c = b3;
        al b4 = ah.b(new af(b2, b3));
        this.d = b4;
        this.e = ah.b(new x(b4));
    }

    public final IntegrityManager a() {
        return (IntegrityManager) this.e.a();
    }
}
