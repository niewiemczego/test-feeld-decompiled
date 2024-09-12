package com.google.android.exoplayer2.source.rtsp;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.math.IntMath;
import java.nio.ByteBuffer;

public final class RtpPacket {
    public static final int CSRC_SIZE = 4;
    /* access modifiers changed from: private */
    public static final byte[] EMPTY = new byte[0];
    public static final int MAX_SEQUENCE_NUMBER = 65535;
    public static final int MAX_SIZE = 65507;
    public static final int MIN_HEADER_SIZE = 12;
    public static final int MIN_SEQUENCE_NUMBER = 0;
    public static final int RTP_VERSION = 2;
    public final byte[] csrc;
    public final byte csrcCount;
    public final boolean extension;
    public final boolean marker;
    public final boolean padding;
    public final byte[] payloadData;
    public final byte payloadType;
    public final int sequenceNumber;
    public final int ssrc;
    public final long timestamp;
    public final byte version;

    public static final class Builder {
        /* access modifiers changed from: private */
        public byte[] csrc = RtpPacket.EMPTY;
        /* access modifiers changed from: private */
        public boolean marker;
        /* access modifiers changed from: private */
        public boolean padding;
        /* access modifiers changed from: private */
        public byte[] payloadData = RtpPacket.EMPTY;
        /* access modifiers changed from: private */
        public byte payloadType;
        /* access modifiers changed from: private */
        public int sequenceNumber;
        /* access modifiers changed from: private */
        public int ssrc;
        /* access modifiers changed from: private */
        public long timestamp;

        public Builder setPadding(boolean z) {
            this.padding = z;
            return this;
        }

        public Builder setMarker(boolean z) {
            this.marker = z;
            return this;
        }

        public Builder setPayloadType(byte b) {
            this.payloadType = b;
            return this;
        }

        public Builder setSequenceNumber(int i) {
            Assertions.checkArgument(i >= 0 && i <= 65535);
            this.sequenceNumber = i & 65535;
            return this;
        }

        public Builder setTimestamp(long j) {
            this.timestamp = j;
            return this;
        }

        public Builder setSsrc(int i) {
            this.ssrc = i;
            return this;
        }

        public Builder setCsrc(byte[] bArr) {
            Assertions.checkNotNull(bArr);
            this.csrc = bArr;
            return this;
        }

        public Builder setPayloadData(byte[] bArr) {
            Assertions.checkNotNull(bArr);
            this.payloadData = bArr;
            return this;
        }

        public RtpPacket build() {
            return new RtpPacket(this);
        }
    }

    public static int getNextSequenceNumber(int i) {
        return IntMath.mod(i + 1, 65536);
    }

    public static int getPreviousSequenceNumber(int i) {
        return IntMath.mod(i - 1, 65536);
    }

    public static RtpPacket parse(ParsableByteArray parsableByteArray) {
        byte[] bArr;
        if (parsableByteArray.bytesLeft() < 12) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        byte b = (byte) (readUnsignedByte >> 6);
        boolean z = true;
        boolean z2 = ((readUnsignedByte >> 5) & 1) == 1;
        byte b2 = (byte) (readUnsignedByte & 15);
        if (b != 2) {
            return null;
        }
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        if (((readUnsignedByte2 >> 7) & 1) != 1) {
            z = false;
        }
        byte b3 = (byte) (readUnsignedByte2 & 127);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        int readInt = parsableByteArray.readInt();
        if (b2 > 0) {
            bArr = new byte[(b2 * 4)];
            for (int i = 0; i < b2; i++) {
                parsableByteArray.readBytes(bArr, i * 4, 4);
            }
        } else {
            bArr = EMPTY;
        }
        byte[] bArr2 = new byte[parsableByteArray.bytesLeft()];
        parsableByteArray.readBytes(bArr2, 0, parsableByteArray.bytesLeft());
        return new Builder().setPadding(z2).setMarker(z).setPayloadType(b3).setSequenceNumber(readUnsignedShort).setTimestamp(readUnsignedInt).setSsrc(readInt).setCsrc(bArr).setPayloadData(bArr2).build();
    }

    public static RtpPacket parse(byte[] bArr, int i) {
        return parse(new ParsableByteArray(bArr, i));
    }

    private RtpPacket(Builder builder) {
        this.version = 2;
        this.padding = builder.padding;
        this.extension = false;
        this.marker = builder.marker;
        this.payloadType = builder.payloadType;
        this.sequenceNumber = builder.sequenceNumber;
        this.timestamp = builder.timestamp;
        this.ssrc = builder.ssrc;
        byte[] access$800 = builder.csrc;
        this.csrc = access$800;
        this.csrcCount = (byte) (access$800.length / 4);
        this.payloadData = builder.payloadData;
    }

    public int writeToBuffer(byte[] bArr, int i, int i2) {
        int length = (this.csrcCount * 4) + 12 + this.payloadData.length;
        if (i2 < length || bArr.length - i < length) {
            return -1;
        }
        ByteBuffer.wrap(bArr, i, i2).put((byte) (((this.padding ? 1 : 0) << true) | 128 | ((this.extension ? 1 : 0) << true) | (this.csrcCount & Ascii.SI))).put((byte) (((this.marker ? 1 : 0) << true) | (this.payloadType & Byte.MAX_VALUE))).putShort((short) this.sequenceNumber).putInt((int) this.timestamp).putInt(this.ssrc).put(this.csrc).put(this.payloadData);
        return length;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RtpPacket rtpPacket = (RtpPacket) obj;
        if (this.payloadType == rtpPacket.payloadType && this.sequenceNumber == rtpPacket.sequenceNumber && this.marker == rtpPacket.marker && this.timestamp == rtpPacket.timestamp && this.ssrc == rtpPacket.ssrc) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.timestamp;
        return ((((((((527 + this.payloadType) * 31) + this.sequenceNumber) * 31) + (this.marker ? 1 : 0)) * 31) + ((int) (j ^ (j >>> 32)))) * 31) + this.ssrc;
    }

    public String toString() {
        return Util.formatInvariant("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.payloadType), Integer.valueOf(this.sequenceNumber), Long.valueOf(this.timestamp), Integer.valueOf(this.ssrc), Boolean.valueOf(this.marker));
    }
}
