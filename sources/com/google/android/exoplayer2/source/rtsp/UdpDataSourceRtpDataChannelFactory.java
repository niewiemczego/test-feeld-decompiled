package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.source.rtsp.RtpDataChannel;
import com.google.android.exoplayer2.upstream.DataSourceUtil;
import java.io.IOException;

final class UdpDataSourceRtpDataChannelFactory implements RtpDataChannel.Factory {
    private final long socketTimeoutMs;

    public UdpDataSourceRtpDataChannelFactory(long j) {
        this.socketTimeoutMs = j;
    }

    public RtpDataChannel createAndOpenDataChannel(int i) throws IOException {
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel = new UdpDataSourceRtpDataChannel(this.socketTimeoutMs);
        UdpDataSourceRtpDataChannel udpDataSourceRtpDataChannel2 = new UdpDataSourceRtpDataChannel(this.socketTimeoutMs);
        boolean z = false;
        try {
            udpDataSourceRtpDataChannel.open(RtpUtils.getIncomingRtpDataSpec(0));
            int localPort = udpDataSourceRtpDataChannel.getLocalPort();
            if (localPort % 2 == 0) {
                z = true;
            }
            udpDataSourceRtpDataChannel2.open(RtpUtils.getIncomingRtpDataSpec(z ? localPort + 1 : localPort - 1));
            if (z) {
                udpDataSourceRtpDataChannel.setRtcpChannel(udpDataSourceRtpDataChannel2);
                return udpDataSourceRtpDataChannel;
            }
            udpDataSourceRtpDataChannel2.setRtcpChannel(udpDataSourceRtpDataChannel);
            return udpDataSourceRtpDataChannel2;
        } catch (IOException e) {
            DataSourceUtil.closeQuietly(udpDataSourceRtpDataChannel);
            DataSourceUtil.closeQuietly(udpDataSourceRtpDataChannel2);
            throw e;
        }
    }

    public RtpDataChannel.Factory createFallbackDataChannelFactory() {
        return new TransferRtpDataChannelFactory(this.socketTimeoutMs);
    }
}
