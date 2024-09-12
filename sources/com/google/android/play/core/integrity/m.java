package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ak;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class m implements t {
    private Context a;

    private m() {
    }

    /* synthetic */ m(l lVar) {
    }

    public final m a(Context context) {
        context.getClass();
        this.a = context;
        return this;
    }

    public final o b() {
        ak.a(this.a, Context.class);
        return new o(this.a, (n) null);
    }
}
