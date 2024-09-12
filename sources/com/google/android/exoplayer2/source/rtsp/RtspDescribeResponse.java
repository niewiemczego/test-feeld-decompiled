package com.google.android.exoplayer2.source.rtsp;

final class RtspDescribeResponse {
    public final SessionDescription sessionDescription;
    public final int status;

    public RtspDescribeResponse(int i, SessionDescription sessionDescription2) {
        this.status = i;
        this.sessionDescription = sessionDescription2;
    }
}
