package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ah;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.aj;
import com.google.android.play.integrity.internal.al;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class s {
    private final s a = this;
    private final al b;
    private final al c;
    private final al d;
    private final al e;
    private final al f;

    /* synthetic */ s(Context context, r rVar) {
        ai b2 = aj.b(context);
        this.b = b2;
        al b3 = ah.b(an.a);
        this.c = b3;
        al b4 = ah.b(new az(b2, b3));
        this.d = b4;
        al b5 = ah.b(new be(b4));
        this.e = b5;
        this.f = ah.b(new am(b4, b5));
    }

    public final StandardIntegrityManager a() {
        return (StandardIntegrityManager) this.f.a();
    }
}
