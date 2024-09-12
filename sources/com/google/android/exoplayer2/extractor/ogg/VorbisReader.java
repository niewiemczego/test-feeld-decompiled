package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.VorbisUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class VorbisReader extends StreamReader {
    private VorbisUtil.CommentHeader commentHeader;
    private int previousPacketBlockSize;
    private boolean seenFirstAudioPacket;
    private VorbisUtil.VorbisIdHeader vorbisIdHeader;
    private VorbisSetup vorbisSetup;

    static int readBits(byte b, int i, int i2) {
        return (b >> i2) & (255 >>> (8 - i));
    }

    VorbisReader() {
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        try {
            return VorbisUtil.verifyVorbisHeaderCapturePattern(1, parsableByteArray, true);
        } catch (ParserException unused) {
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void reset(boolean z) {
        super.reset(z);
        if (z) {
            this.vorbisSetup = null;
            this.vorbisIdHeader = null;
            this.commentHeader = null;
        }
        this.previousPacketBlockSize = 0;
        this.seenFirstAudioPacket = false;
    }

    /* access modifiers changed from: protected */
    public void onSeekEnd(long j) {
        super.onSeekEnd(j);
        int i = 0;
        this.seenFirstAudioPacket = j != 0;
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = this.vorbisIdHeader;
        if (vorbisIdHeader2 != null) {
            i = vorbisIdHeader2.blockSize0;
        }
        this.previousPacketBlockSize = i;
    }

    /* access modifiers changed from: protected */
    public long preparePayload(ParsableByteArray parsableByteArray) {
        int i = 0;
        if ((parsableByteArray.getData()[0] & 1) == 1) {
            return -1;
        }
        int decodeBlockSize = decodeBlockSize(parsableByteArray.getData()[0], (VorbisSetup) Assertions.checkStateNotNull(this.vorbisSetup));
        if (this.seenFirstAudioPacket) {
            i = (this.previousPacketBlockSize + decodeBlockSize) / 4;
        }
        long j = (long) i;
        appendNumberOfSamples(parsableByteArray, j);
        this.seenFirstAudioPacket = true;
        this.previousPacketBlockSize = decodeBlockSize;
        return j;
    }

    /* access modifiers changed from: protected */
    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j, StreamReader.SetupData setupData) throws IOException {
        if (this.vorbisSetup != null) {
            Assertions.checkNotNull(setupData.format);
            return false;
        }
        VorbisSetup readSetupHeaders = readSetupHeaders(parsableByteArray);
        this.vorbisSetup = readSetupHeaders;
        if (readSetupHeaders == null) {
            return true;
        }
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = readSetupHeaders.idHeader;
        ArrayList arrayList = new ArrayList();
        arrayList.add(vorbisIdHeader2.data);
        arrayList.add(readSetupHeaders.setupHeaderData);
        setupData.format = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_VORBIS).setAverageBitrate(vorbisIdHeader2.bitrateNominal).setPeakBitrate(vorbisIdHeader2.bitrateMaximum).setChannelCount(vorbisIdHeader2.channels).setSampleRate(vorbisIdHeader2.sampleRate).setInitializationData(arrayList).setMetadata(VorbisUtil.parseVorbisComments(ImmutableList.copyOf((E[]) readSetupHeaders.commentHeader.comments))).build();
        return true;
    }

    /* access modifiers changed from: package-private */
    public VorbisSetup readSetupHeaders(ParsableByteArray parsableByteArray) throws IOException {
        VorbisUtil.VorbisIdHeader vorbisIdHeader2 = this.vorbisIdHeader;
        if (vorbisIdHeader2 == null) {
            this.vorbisIdHeader = VorbisUtil.readVorbisIdentificationHeader(parsableByteArray);
            return null;
        }
        VorbisUtil.CommentHeader commentHeader2 = this.commentHeader;
        if (commentHeader2 == null) {
            this.commentHeader = VorbisUtil.readVorbisCommentHeader(parsableByteArray);
            return null;
        }
        byte[] bArr = new byte[parsableByteArray.limit()];
        System.arraycopy(parsableByteArray.getData(), 0, bArr, 0, parsableByteArray.limit());
        VorbisUtil.Mode[] readVorbisModes = VorbisUtil.readVorbisModes(parsableByteArray, vorbisIdHeader2.channels);
        return new VorbisSetup(vorbisIdHeader2, commentHeader2, bArr, readVorbisModes, VorbisUtil.iLog(readVorbisModes.length - 1));
    }

    static void appendNumberOfSamples(ParsableByteArray parsableByteArray, long j) {
        if (parsableByteArray.capacity() < parsableByteArray.limit() + 4) {
            parsableByteArray.reset(Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit() + 4));
        } else {
            parsableByteArray.setLimit(parsableByteArray.limit() + 4);
        }
        byte[] data = parsableByteArray.getData();
        data[parsableByteArray.limit() - 4] = (byte) ((int) (j & 255));
        data[parsableByteArray.limit() - 3] = (byte) ((int) ((j >>> 8) & 255));
        data[parsableByteArray.limit() - 2] = (byte) ((int) ((j >>> 16) & 255));
        data[parsableByteArray.limit() - 1] = (byte) ((int) ((j >>> 24) & 255));
    }

    private static int decodeBlockSize(byte b, VorbisSetup vorbisSetup2) {
        if (!vorbisSetup2.modes[readBits(b, vorbisSetup2.iLogModes, 1)].blockFlag) {
            return vorbisSetup2.idHeader.blockSize0;
        }
        return vorbisSetup2.idHeader.blockSize1;
    }

    static final class VorbisSetup {
        public final VorbisUtil.CommentHeader commentHeader;
        public final int iLogModes;
        public final VorbisUtil.VorbisIdHeader idHeader;
        public final VorbisUtil.Mode[] modes;
        public final byte[] setupHeaderData;

        public VorbisSetup(VorbisUtil.VorbisIdHeader vorbisIdHeader, VorbisUtil.CommentHeader commentHeader2, byte[] bArr, VorbisUtil.Mode[] modeArr, int i) {
            this.idHeader = vorbisIdHeader;
            this.commentHeader = commentHeader2;
            this.setupHeaderData = bArr;
            this.modes = modeArr;
            this.iLogModes = i;
        }
    }
}
