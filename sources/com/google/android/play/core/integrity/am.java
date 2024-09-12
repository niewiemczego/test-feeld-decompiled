package com.google.android.play.core.integrity;

import com.google.android.play.integrity.internal.ai;
import com.google.android.play.integrity.internal.al;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final class am implements ai {
    private final al a;
    private final al b;

    public am(al alVar, al alVar2) {
        this.a = alVar;
        this.b = alVar2;
    }

    public final /* bridge */ /* synthetic */ Object a() {
        return new al((ax) this.a.a(), (bd) this.b.a());
    }
}
