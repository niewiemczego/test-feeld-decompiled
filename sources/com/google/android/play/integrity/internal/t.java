package com.google.android.play.integrity.internal;

import android.os.IBinder;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final /* synthetic */ class t implements IBinder.DeathRecipient {
    public final /* synthetic */ ac a;

    public /* synthetic */ t(ac acVar) {
        this.a = acVar;
    }

    public final void binderDied() {
        ac.k(this.a);
    }
}
