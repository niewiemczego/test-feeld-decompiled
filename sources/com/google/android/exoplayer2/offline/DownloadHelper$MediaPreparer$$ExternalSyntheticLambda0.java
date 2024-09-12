package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.offline.DownloadHelper;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadHelper$MediaPreparer$$ExternalSyntheticLambda0 implements Handler.Callback {
    public final /* synthetic */ DownloadHelper.MediaPreparer f$0;

    public /* synthetic */ DownloadHelper$MediaPreparer$$ExternalSyntheticLambda0(DownloadHelper.MediaPreparer mediaPreparer) {
        this.f$0 = mediaPreparer;
    }

    public final boolean handleMessage(Message message) {
        return this.f$0.handleDownloadHelperCallbackMessage(message);
    }
}
