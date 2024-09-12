package com.google.android.exoplayer2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class StreamVolumeManager$VolumeChangeReceiver$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ StreamVolumeManager f$0;

    public /* synthetic */ StreamVolumeManager$VolumeChangeReceiver$$ExternalSyntheticLambda0(StreamVolumeManager streamVolumeManager) {
        this.f$0 = streamVolumeManager;
    }

    public final void run() {
        this.f$0.updateVolumeAndNotifyIfChanged();
    }
}
