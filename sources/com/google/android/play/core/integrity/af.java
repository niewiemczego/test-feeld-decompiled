package com.google.android.play.core.integrity;

import android.content.Context;
import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.al;
import com.google.android.play.integrity.internal.q;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class af implements ai {
    private final al a;
    private final al b;

    public af(al alVar, al alVar2) {
        this.a = alVar;
        this.b = alVar2;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new ad((Context) this.a.a(), (q) this.b.a());
    }
}