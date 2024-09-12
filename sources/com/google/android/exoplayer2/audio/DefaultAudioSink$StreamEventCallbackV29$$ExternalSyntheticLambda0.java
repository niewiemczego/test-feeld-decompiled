package com.google.android.exoplayer2.audio;

import android.os.Handler;
import java.util.concurrent.Executor;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultAudioSink$StreamEventCallbackV29$$ExternalSyntheticLambda0 implements Executor {
    public final /* synthetic */ Handler f$0;

    public /* synthetic */ DefaultAudioSink$StreamEventCallbackV29$$ExternalSyntheticLambda0(Handler handler) {
        this.f$0 = handler;
    }

    public final void execute(Runnable runnable) {
        boolean unused = this.f$0.post(runnable);
    }
}
