package com.facebook;

import com.facebook.GraphRequestBatch;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ProgressOutputStream$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ GraphRequestBatch.Callback f$0;
    public final /* synthetic */ ProgressOutputStream f$1;

    public /* synthetic */ ProgressOutputStream$$ExternalSyntheticLambda0(GraphRequestBatch.Callback callback, ProgressOutputStream progressOutputStream) {
        this.f$0 = callback;
        this.f$1 = progressOutputStream;
    }

    public final void run() {
        ProgressOutputStream.m214reportBatchProgress$lambda0(this.f$0, this.f$1);
    }
}
