package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.offline.DownloadService;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadService$ForegroundNotificationUpdater$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DownloadService.ForegroundNotificationUpdater f$0;

    public /* synthetic */ DownloadService$ForegroundNotificationUpdater$$ExternalSyntheticLambda0(DownloadService.ForegroundNotificationUpdater foregroundNotificationUpdater) {
        this.f$0 = foregroundNotificationUpdater;
    }

    public final void run() {
        this.f$0.update();
    }
}
