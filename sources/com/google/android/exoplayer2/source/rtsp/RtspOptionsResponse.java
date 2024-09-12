package com.google.android.exoplayer2.source.rtsp;

import com.google.common.collect.ImmutableList;
import java.util.List;

final class RtspOptionsResponse {
    public final int status;
    public final ImmutableList<Integer> supportedMethods;

    public RtspOptionsResponse(int i, List<Integer> list) {
        this.status = i;
        this.supportedMethods = ImmutableList.copyOf(list);
    }
}
