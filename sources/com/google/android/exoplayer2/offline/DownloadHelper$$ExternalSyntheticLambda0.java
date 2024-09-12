package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DownloadHelper$$ExternalSyntheticLambda0 implements DrmSessionManagerProvider {
    public final /* synthetic */ DrmSessionManager f$0;

    public /* synthetic */ DownloadHelper$$ExternalSyntheticLambda0(DrmSessionManager drmSessionManager) {
        this.f$0 = drmSessionManager;
    }

    public final DrmSessionManager get(MediaItem mediaItem) {
        return DownloadHelper.lambda$createMediaSourceInternal$6(this.f$0, mediaItem);
    }
}
