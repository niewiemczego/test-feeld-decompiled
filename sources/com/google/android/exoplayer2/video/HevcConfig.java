package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Collections;
import java.util.List;

public final class HevcConfig {
    private static final int SPS_NAL_UNIT_TYPE = 33;
    public final String codecs;
    public final int height;
    public final List<byte[]> initializationData;
    public final int nalUnitLengthFieldLength;
    public final float pixelWidthHeightRatio;
    public final int width;

    public static HevcConfig parse(ParsableByteArray parsableByteArray) throws ParserException {
        int i;
        int i2;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        try {
            parsableByteArray2.skipBytes(21);
            int readUnsignedByte = parsableByteArray.readUnsignedByte() & 3;
            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
            int position = parsableByteArray.getPosition();
            int i3 = 0;
            for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
                parsableByteArray2.skipBytes(1);
                int readUnsignedShort = parsableByteArray.readUnsignedShort();
                for (int i5 = 0; i5 < readUnsignedShort; i5++) {
                    int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
                    i3 += readUnsignedShort2 + 4;
                    parsableByteArray2.skipBytes(readUnsignedShort2);
                }
            }
            parsableByteArray2.setPosition(position);
            byte[] bArr = new byte[i3];
            float f = 1.0f;
            String str = null;
            int i6 = -1;
            int i7 = -1;
            int i8 = 0;
            for (int i9 = 0; i9 < readUnsignedByte2; i9++) {
                int readUnsignedByte3 = parsableByteArray.readUnsignedByte() & 127;
                int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                int i10 = 0;
                while (i10 < readUnsignedShort3) {
                    int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                    int i11 = readUnsignedByte2;
                    System.arraycopy(NalUnitUtil.NAL_START_CODE, 0, bArr, i8, NalUnitUtil.NAL_START_CODE.length);
                    int length = i8 + NalUnitUtil.NAL_START_CODE.length;
                    System.arraycopy(parsableByteArray.getData(), parsableByteArray.getPosition(), bArr, length, readUnsignedShort4);
                    if (readUnsignedByte3 == 33 && i10 == 0) {
                        NalUnitUtil.H265SpsData parseH265SpsNalUnit = NalUnitUtil.parseH265SpsNalUnit(bArr, length, length + readUnsignedShort4);
                        int i12 = parseH265SpsNalUnit.width;
                        i7 = parseH265SpsNalUnit.height;
                        f = parseH265SpsNalUnit.pixelWidthHeightRatio;
                        i2 = readUnsignedByte3;
                        i = readUnsignedShort3;
                        i6 = i12;
                        str = CodecSpecificDataUtil.buildHevcCodecString(parseH265SpsNalUnit.generalProfileSpace, parseH265SpsNalUnit.generalTierFlag, parseH265SpsNalUnit.generalProfileIdc, parseH265SpsNalUnit.generalProfileCompatibilityFlags, parseH265SpsNalUnit.constraintBytes, parseH265SpsNalUnit.generalLevelIdc);
                    } else {
                        i2 = readUnsignedByte3;
                        i = readUnsignedShort3;
                    }
                    i8 = length + readUnsignedShort4;
                    parsableByteArray2.skipBytes(readUnsignedShort4);
                    i10++;
                    readUnsignedByte2 = i11;
                    readUnsignedByte3 = i2;
                    readUnsignedShort3 = i;
                }
                int i13 = readUnsignedByte2;
            }
            return new HevcConfig(i3 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), readUnsignedByte + 1, i6, i7, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw ParserException.createForMalformedContainer("Error parsing HEVC config", e);
        }
    }

    private HevcConfig(List<byte[]> list, int i, int i2, int i3, float f, String str) {
        this.initializationData = list;
        this.nalUnitLengthFieldLength = i;
        this.width = i2;
        this.height = i3;
        this.pixelWidthHeightRatio = f;
        this.codecs = str;
    }
}
