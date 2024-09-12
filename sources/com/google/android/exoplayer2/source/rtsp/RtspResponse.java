package com.google.android.exoplayer2.source.rtsp;

final class RtspResponse {
    public final RtspHeaders headers;
    public final String messageBody;
    public final int status;

    public RtspResponse(int i, RtspHeaders rtspHeaders, String str) {
        this.status = i;
        this.headers = rtspHeaders;
        this.messageBody = str;
    }

    public RtspResponse(int i, RtspHeaders rtspHeaders) {
        this(i, rtspHeaders, "");
    }
}
