package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.ListenerSet;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ListenerSet$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ CopyOnWriteArraySet f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ ListenerSet.Event f$2;

    public /* synthetic */ ListenerSet$$ExternalSyntheticLambda1(CopyOnWriteArraySet copyOnWriteArraySet, int i, ListenerSet.Event event) {
        this.f$0 = copyOnWriteArraySet;
        this.f$1 = i;
        this.f$2 = event;
    }

    public final void run() {
        ListenerSet.lambda$queueEvent$0(this.f$0, this.f$1, this.f$2);
    }
}
