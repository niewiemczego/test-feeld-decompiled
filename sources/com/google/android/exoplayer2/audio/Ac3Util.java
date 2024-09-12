package com.google.android.exoplayer2.audio;

import com.facebook.imagepipeline.memory.BitmapCounterConfig;
import com.facebook.imageutils.JfifUtil;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.nio.ByteBuffer;
import okio.Utf8;

public final class Ac3Util {
    public static final int AC3_MAX_RATE_BYTES_PER_SECOND = 80000;
    private static final int AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT = 1536;
    private static final int AUDIO_SAMPLES_PER_AUDIO_BLOCK = 256;
    private static final int[] BITRATE_BY_HALF_FRMSIZECOD = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, BitmapCounterConfig.DEFAULT_MAX_BITMAP_COUNT, 448, 512, 576, 640};
    private static final int[] BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD = {1, 2, 3, 6};
    private static final int[] CHANNEL_COUNT_BY_ACMOD = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int E_AC3_MAX_RATE_BYTES_PER_SECOND = 768000;
    private static final int[] SAMPLE_RATE_BY_FSCOD = {OpusUtil.SAMPLE_RATE, 44100, 32000};
    private static final int[] SAMPLE_RATE_BY_FSCOD2 = {24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND};
    private static final int[] SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1 = {69, 87, 104, 121, 139, 174, JfifUtil.MARKER_RST0, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};
    public static final int TRUEHD_MAX_RATE_BYTES_PER_SECOND = 3062500;
    public static final int TRUEHD_RECHUNK_SAMPLE_COUNT = 16;
    public static final int TRUEHD_SYNCFRAME_PREFIX_LENGTH = 10;

    public static final class SyncFrameInfo {
        public static final int STREAM_TYPE_TYPE0 = 0;
        public static final int STREAM_TYPE_TYPE1 = 1;
        public static final int STREAM_TYPE_TYPE2 = 2;
        public static final int STREAM_TYPE_UNDEFINED = -1;
        public final int channelCount;
        public final int frameSize;
        public final String mimeType;
        public final int sampleCount;
        public final int sampleRate;
        public final int streamType;

        @Documented
        @Target({ElementType.TYPE_USE})
        @Retention(RetentionPolicy.SOURCE)
        public @interface StreamType {
        }

        private SyncFrameInfo(String str, int i, int i2, int i3, int i4, int i5) {
            this.mimeType = str;
            this.streamType = i;
            this.channelCount = i2;
            this.sampleRate = i3;
            this.frameSize = i4;
            this.sampleCount = i5;
        }
    }

    public static Format parseAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 56) >> 3];
        if ((readUnsignedByte & 4) != 0) {
            i2++;
        }
        return new Format.Builder().setId(str).setSampleMimeType(MimeTypes.AUDIO_AC3).setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static Format parseEAc3AnnexFFormat(ParsableByteArray parsableByteArray, String str, String str2, DrmInitData drmInitData) {
        parsableByteArray.skipBytes(2);
        int i = SAMPLE_RATE_BY_FSCOD[(parsableByteArray.readUnsignedByte() & 192) >> 6];
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i2 = CHANNEL_COUNT_BY_ACMOD[(readUnsignedByte & 14) >> 1];
        if ((readUnsignedByte & 1) != 0) {
            i2++;
        }
        if (((parsableByteArray.readUnsignedByte() & 30) >> 1) > 0 && (2 & parsableByteArray.readUnsignedByte()) != 0) {
            i2 += 2;
        }
        return new Format.Builder().setId(str).setSampleMimeType((parsableByteArray.bytesLeft() <= 0 || (parsableByteArray.readUnsignedByte() & 1) == 0) ? MimeTypes.AUDIO_E_AC3 : MimeTypes.AUDIO_E_AC3_JOC).setChannelCount(i2).setSampleRate(i).setDrmInitData(drmInitData).setLanguage(str2).build();
    }

    public static SyncFrameInfo parseAc3SyncframeInfo(ParsableBitArray parsableBitArray) {
        int i;
        String str;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        ParsableBitArray parsableBitArray2 = parsableBitArray;
        int position = parsableBitArray.getPosition();
        parsableBitArray2.skipBits(40);
        boolean z = parsableBitArray2.readBits(5) > 10;
        parsableBitArray2.setPosition(position);
        int i11 = -1;
        if (z) {
            parsableBitArray2.skipBits(16);
            int readBits = parsableBitArray2.readBits(2);
            if (readBits == 0) {
                i11 = 0;
            } else if (readBits == 1) {
                i11 = 1;
            } else if (readBits == 2) {
                i11 = 2;
            }
            parsableBitArray2.skipBits(3);
            i4 = (parsableBitArray2.readBits(11) + 1) * 2;
            int readBits2 = parsableBitArray2.readBits(2);
            if (readBits2 == 3) {
                i3 = SAMPLE_RATE_BY_FSCOD2[parsableBitArray2.readBits(2)];
                i6 = 6;
                i7 = 3;
            } else {
                i7 = parsableBitArray2.readBits(2);
                i6 = BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i7];
                i3 = SAMPLE_RATE_BY_FSCOD[readBits2];
            }
            i5 = i6 * 256;
            int readBits3 = parsableBitArray2.readBits(3);
            boolean readBit = parsableBitArray.readBit();
            i2 = CHANNEL_COUNT_BY_ACMOD[readBits3] + (readBit ? 1 : 0);
            parsableBitArray2.skipBits(10);
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(8);
            }
            if (readBits3 == 0) {
                parsableBitArray2.skipBits(5);
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
            }
            if (i11 == 1 && parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(16);
            }
            if (parsableBitArray.readBit()) {
                if (readBits3 > 2) {
                    parsableBitArray2.skipBits(2);
                }
                if ((readBits3 & 1) == 0 || readBits3 <= 2) {
                    i9 = 6;
                } else {
                    i9 = 6;
                    parsableBitArray2.skipBits(6);
                }
                if ((readBits3 & 4) != 0) {
                    parsableBitArray2.skipBits(i9);
                }
                if (readBit && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(5);
                }
                if (i11 == 0) {
                    if (parsableBitArray.readBit()) {
                        i10 = 6;
                        parsableBitArray2.skipBits(6);
                    } else {
                        i10 = 6;
                    }
                    if (readBits3 == 0 && parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i10);
                    }
                    if (parsableBitArray.readBit()) {
                        parsableBitArray2.skipBits(i10);
                    }
                    int readBits4 = parsableBitArray2.readBits(2);
                    if (readBits4 == 1) {
                        parsableBitArray2.skipBits(5);
                    } else if (readBits4 == 2) {
                        parsableBitArray2.skipBits(12);
                    } else if (readBits4 == 3) {
                        int readBits5 = parsableBitArray2.readBits(5);
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(4);
                            }
                            if (parsableBitArray.readBit()) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(4);
                                }
                            }
                        }
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(5);
                            if (parsableBitArray.readBit()) {
                                parsableBitArray2.skipBits(7);
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(8);
                                }
                            }
                        }
                        parsableBitArray2.skipBits((readBits5 + 2) * 8);
                        parsableBitArray.byteAlign();
                    }
                    if (readBits3 < 2) {
                        if (parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                        if (readBits3 == 0 && parsableBitArray.readBit()) {
                            parsableBitArray2.skipBits(14);
                        }
                    }
                    if (parsableBitArray.readBit()) {
                        if (i7 == 0) {
                            parsableBitArray2.skipBits(5);
                        } else {
                            for (int i12 = 0; i12 < i6; i12++) {
                                if (parsableBitArray.readBit()) {
                                    parsableBitArray2.skipBits(5);
                                }
                            }
                        }
                    }
                }
            }
            if (parsableBitArray.readBit()) {
                parsableBitArray2.skipBits(5);
                if (readBits3 == 2) {
                    parsableBitArray2.skipBits(4);
                }
                if (readBits3 >= 6) {
                    parsableBitArray2.skipBits(2);
                }
                if (parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits3 == 0 && parsableBitArray.readBit()) {
                    parsableBitArray2.skipBits(8);
                }
                if (readBits2 < 3) {
                    parsableBitArray.skipBit();
                }
            }
            if (i11 == 0 && i7 != 3) {
                parsableBitArray.skipBit();
            }
            if (i11 != 2 || (i7 != 3 && !parsableBitArray.readBit())) {
                i8 = 6;
            } else {
                i8 = 6;
                parsableBitArray2.skipBits(6);
            }
            str = (parsableBitArray.readBit() && parsableBitArray2.readBits(i8) == 1 && parsableBitArray2.readBits(8) == 1) ? MimeTypes.AUDIO_E_AC3_JOC : MimeTypes.AUDIO_E_AC3;
            i = i11;
        } else {
            parsableBitArray2.skipBits(32);
            int readBits6 = parsableBitArray2.readBits(2);
            String str2 = readBits6 == 3 ? null : MimeTypes.AUDIO_AC3;
            i4 = getAc3SyncframeSize(readBits6, parsableBitArray2.readBits(6));
            parsableBitArray2.skipBits(8);
            int readBits7 = parsableBitArray2.readBits(3);
            if (!((readBits7 & 1) == 0 || readBits7 == 1)) {
                parsableBitArray2.skipBits(2);
            }
            if ((readBits7 & 4) != 0) {
                parsableBitArray2.skipBits(2);
            }
            if (readBits7 == 2) {
                parsableBitArray2.skipBits(2);
            }
            int[] iArr = SAMPLE_RATE_BY_FSCOD;
            i3 = readBits6 < iArr.length ? iArr[readBits6] : -1;
            i5 = AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
            i2 = CHANNEL_COUNT_BY_ACMOD[readBits7] + (parsableBitArray.readBit() ? 1 : 0);
            i = -1;
            str = str2;
        }
        return new SyncFrameInfo(str, i, i2, i3, i4, i5);
    }

    public static int parseAc3SyncframeSize(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b = bArr[4];
        return getAc3SyncframeSize((b & 192) >> 6, b & Utf8.REPLACEMENT_BYTE);
    }

    public static int parseAc3SyncframeAudioSampleCount(ByteBuffer byteBuffer) {
        int i = 3;
        if (!(((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10)) {
            return AC3_SYNCFRAME_AUDIO_SAMPLE_COUNT;
        }
        if (((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3) {
            i = (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4;
        }
        return BLOCKS_PER_SYNCFRAME_BY_NUMBLKSCOD[i] * 256;
    }

    public static int findTrueHdSyncframeOffset(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((Util.getBigEndianInt(byteBuffer, i + 4) & -2) == -126718022) {
                return i - position;
            }
        }
        return -1;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(byte[] bArr) {
        boolean z = false;
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b = bArr[7];
            if ((b & 254) == 186) {
                if ((b & 255) == 187) {
                    z = true;
                }
                return 40 << ((bArr[z ? (char) 9 : 8] >> 4) & 7);
            }
        }
        return 0;
    }

    public static int parseTrueHdSyncframeAudioSampleCount(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    private static int getAc3SyncframeSize(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = SAMPLE_RATE_BY_FSCOD;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = SYNCFRAME_SIZE_WORDS_BY_HALF_FRMSIZECOD_44_1;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = BITRATE_BY_HALF_FRMSIZECOD[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    private Ac3Util() {
    }
}
