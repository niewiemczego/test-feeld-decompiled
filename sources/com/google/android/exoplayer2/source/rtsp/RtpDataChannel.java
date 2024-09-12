package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtspMessageChannel;
import com.google.android.exoplayer2.upstream.DataSource;
import java.io.IOException;

interface RtpDataChannel extends DataSource {

    public interface Factory {
        RtpDataChannel createAndOpenDataChannel(int i) throws IOException;

        Factory createFallbackDataChannelFactory() {
            return null;
        }
    }

    RtspMessageChannel.InterleavedBinaryDataListener getInterleavedBinaryDataListener();

    int getLocalPort();

    String getTransport();
}
