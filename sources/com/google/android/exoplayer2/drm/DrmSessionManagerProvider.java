package com.google.android.exoplayer2.drm;

import com.google.android.exoplayer2.MediaItem;

public interface DrmSessionManagerProvider {
    DrmSessionManager get(MediaItem mediaItem);
}
