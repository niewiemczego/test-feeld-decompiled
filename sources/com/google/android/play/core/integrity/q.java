package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ak;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class q implements ai {
    private Context a;

    private q() {
    }

    /* synthetic */ q(p pVar) {
    }

    public final q a(Context context) {
        context.getClass();
        this.a = context;
        return this;
    }

    public final s b() {
        ak.a(this.a, Context.class);
        return new s(this.a, (r) null);
    }
}
