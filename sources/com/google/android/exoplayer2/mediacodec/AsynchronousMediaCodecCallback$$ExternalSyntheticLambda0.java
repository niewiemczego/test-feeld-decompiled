package com.google.android.exoplayer2.mediacodec;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsynchronousMediaCodecCallback$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ AsynchronousMediaCodecCallback f$0;

    public /* synthetic */ AsynchronousMediaCodecCallback$$ExternalSyntheticLambda0(AsynchronousMediaCodecCallback asynchronousMediaCodecCallback) {
        this.f$0 = asynchronousMediaCodecCallback;
    }

    public final void run() {
        this.f$0.onFlushCompleted();
    }
}
