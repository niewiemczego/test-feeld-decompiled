package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadManager$$ExternalSyntheticLambda0 implements Handler.Callback {
    public final /* synthetic */ DownloadManager f$0;

    public /* synthetic */ DownloadManager$$ExternalSyntheticLambda0(DownloadManager downloadManager) {
        this.f$0 = downloadManager;
    }

    public final boolean handleMessage(Message message) {
        return this.f$0.handleMainMessage(message);
    }
}
