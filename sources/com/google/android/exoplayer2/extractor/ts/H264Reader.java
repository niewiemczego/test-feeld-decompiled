package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H264Reader implements ElementaryStreamReader {
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs = C.TIME_UNSET;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private boolean randomAccessIndicator;
    private SampleReader sampleReader;
    private final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6, 128);
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7, 128);
    private long totalBytesWritten;

    public void packetFinished() {
    }

    public H264Reader(SeiReader seiReader2, boolean z, boolean z2) {
        this.seiReader = seiReader2;
        this.allowNonIdrKeyframes = z;
        this.detectAccessUnits = z2;
    }

    public void seek() {
        this.totalBytesWritten = 0;
        this.randomAccessIndicator = false;
        this.pesTimeUs = C.TIME_UNSET;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        SampleReader sampleReader2 = this.sampleReader;
        if (sampleReader2 != null) {
            sampleReader2.reset();
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        this.output = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.sampleReader = new SampleReader(this.output, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public void packetStarted(long j, int i) {
        if (j != C.TIME_UNSET) {
            this.pesTimeUs = j;
        }
        this.randomAccessIndicator |= (i & 2) != 0;
    }

    public void consume(ParsableByteArray parsableByteArray) {
        assertTracksCreated();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                nalUnitData(data, position, limit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(data, findNalUnit);
            int i = findNalUnit - position;
            if (i > 0) {
                nalUnitData(data, position, findNalUnit);
            }
            int i2 = limit - findNalUnit;
            long j = this.totalBytesWritten - ((long) i2);
            endNalUnit(j, i2, i < 0 ? -i : 0, this.pesTimeUs);
            startNalUnit(j, nalUnitType, this.pesTimeUs);
            position = findNalUnit + 3;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void startNalUnit(long j, int i, long j2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(i);
            this.pps.startNalUnit(i);
        }
        this.sei.startNalUnit(i);
        this.sampleReader.startNalUnit(j, i, j2);
    }

    @RequiresNonNull({"sampleReader"})
    private void nalUnitData(byte[] bArr, int i, int i2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(bArr, i, i2);
            this.pps.appendToNalUnit(bArr, i, i2);
        }
        this.sei.appendToNalUnit(bArr, i, i2);
        this.sampleReader.appendToNalUnit(bArr, i, i2);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void endNalUnit(long j, int i, int i2, long j2) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(i2);
            this.pps.endNalUnit(i2);
            if (!this.hasOutputFormat) {
                if (this.sps.isCompleted() && this.pps.isCompleted()) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(Arrays.copyOf(this.sps.nalData, this.sps.nalLength));
                    arrayList.add(Arrays.copyOf(this.pps.nalData, this.pps.nalLength));
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength);
                    NalUnitUtil.PpsData parsePpsNalUnit = NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength);
                    this.output.format(new Format.Builder().setId(this.formatId).setSampleMimeType(MimeTypes.VIDEO_H264).setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc)).setWidth(parseSpsNalUnit.width).setHeight(parseSpsNalUnit.height).setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthHeightRatio).setInitializationData(arrayList).build());
                    this.hasOutputFormat = true;
                    this.sampleReader.putSps(parseSpsNalUnit);
                    this.sampleReader.putPps(parsePpsNalUnit);
                    this.sps.reset();
                    this.pps.reset();
                }
            } else if (this.sps.isCompleted()) {
                this.sampleReader.putSps(NalUnitUtil.parseSpsNalUnit(this.sps.nalData, 3, this.sps.nalLength));
                this.sps.reset();
            } else if (this.pps.isCompleted()) {
                this.sampleReader.putPps(NalUnitUtil.parsePpsNalUnit(this.pps.nalData, 3, this.pps.nalLength));
                this.pps.reset();
            }
        }
        if (this.sei.endNalUnit(i2)) {
            this.seiWrapper.reset(this.sei.nalData, NalUnitUtil.unescapeStream(this.sei.nalData, this.sei.nalLength));
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(j2, this.seiWrapper);
        }
        if (this.sampleReader.endNalUnit(j, i, this.hasOutputFormat, this.randomAccessIndicator)) {
            this.randomAccessIndicator = false;
        }
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    private static final class SampleReader {
        private static final int DEFAULT_BUFFER_SIZE = 128;
        private final boolean allowNonIdrKeyframes;
        private final ParsableNalUnitBitArray bitArray = new ParsableNalUnitBitArray(this.buffer, 0, 0);
        private byte[] buffer = new byte[128];
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final TrackOutput output;
        private final SparseArray<NalUnitUtil.PpsData> pps = new SparseArray<>();
        private SliceHeaderData previousSliceHeader = new SliceHeaderData();
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private SliceHeaderData sliceHeader = new SliceHeaderData();
        private final SparseArray<NalUnitUtil.SpsData> sps = new SparseArray<>();

        public SampleReader(TrackOutput trackOutput, boolean z, boolean z2) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z;
            this.detectAccessUnits = z2;
            reset();
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        public void putSps(NalUnitUtil.SpsData spsData) {
            this.sps.append(spsData.seqParameterSetId, spsData);
        }

        public void putPps(NalUnitUtil.PpsData ppsData) {
            this.pps.append(ppsData.picParameterSetId, ppsData);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long j, int i, long j2) {
            this.nalUnitType = i;
            this.nalUnitTimeUs = j2;
            this.nalUnitStartPosition = j;
            if (!this.allowNonIdrKeyframes || i != 1) {
                if (!this.detectAccessUnits) {
                    return;
                }
                if (!(i == 5 || i == 1 || i == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.previousSliceHeader;
            this.previousSliceHeader = this.sliceHeader;
            this.sliceHeader = sliceHeaderData;
            sliceHeaderData.clear();
            this.bufferLength = 0;
            this.isFilling = true;
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0152  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void appendToNalUnit(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.isFilling
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.buffer
                int r4 = r3.length
                int r5 = r0.bufferLength
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001d
                int r5 = r5 + r2
                int r5 = r5 * r7
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.buffer = r3
            L_0x001d:
                byte[] r3 = r0.buffer
                int r4 = r0.bufferLength
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.bufferLength
                int r1 = r1 + r2
                r0.bufferLength = r1
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                byte[] r3 = r0.buffer
                r4 = 0
                r2.reset(r3, r4, r1)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r2 = 8
                boolean r1 = r1.canReadBits(r2)
                if (r1 != 0) goto L_0x003e
                return
            L_0x003e:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r1.skipBit()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r10 = r1.readBits(r7)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r2 = 5
                r1.skipBits(r2)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0058
                return
            L_0x0058:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r1.readUnsignedExpGolombCodedInt()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0066
                return
            L_0x0066:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r11 = r1.readUnsignedExpGolombCodedInt()
                boolean r1 = r0.detectAccessUnits
                if (r1 != 0) goto L_0x0078
                r0.isFilling = r4
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r1 = r0.sliceHeader
                r1.setSliceType(r11)
                return
            L_0x0078:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0081
                return
            L_0x0081:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r13 = r1.readUnsignedExpGolombCodedInt()
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.pps
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0092
                r0.isFilling = r4
                return
            L_0x0092:
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.pps
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.util.NalUnitUtil$PpsData r1 = (com.google.android.exoplayer2.util.NalUnitUtil.PpsData) r1
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$SpsData> r3 = r0.sps
                int r5 = r1.seqParameterSetId
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.util.NalUnitUtil$SpsData r9 = (com.google.android.exoplayer2.util.NalUnitUtil.SpsData) r9
                boolean r3 = r9.separateColorPlaneFlag
                if (r3 == 0) goto L_0x00b7
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.canReadBits(r7)
                if (r3 != 0) goto L_0x00b2
                return
            L_0x00b2:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                r3.skipBits(r7)
            L_0x00b7:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                int r5 = r9.frameNumLength
                boolean r3 = r3.canReadBits(r5)
                if (r3 != 0) goto L_0x00c2
                return
            L_0x00c2:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                int r5 = r9.frameNumLength
                int r12 = r3.readBits(r5)
                boolean r3 = r9.frameMbsOnlyFlag
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.canReadBits(r5)
                if (r3 != 0) goto L_0x00d8
                return
            L_0x00d8:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.readBit()
                if (r3 == 0) goto L_0x00f4
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.bitArray
                boolean r6 = r6.canReadBits(r5)
                if (r6 != 0) goto L_0x00e9
                return
            L_0x00e9:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.bitArray
                boolean r6 = r6.readBit()
                r14 = r3
                r15 = r5
                r16 = r6
                goto L_0x00fb
            L_0x00f4:
                r14 = r3
                r15 = r4
                goto L_0x00f9
            L_0x00f7:
                r14 = r4
                r15 = r14
            L_0x00f9:
                r16 = r15
            L_0x00fb:
                int r3 = r0.nalUnitType
                if (r3 != r2) goto L_0x0102
                r17 = r5
                goto L_0x0104
            L_0x0102:
                r17 = r4
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                boolean r2 = r2.canReadExpGolombCodedNum()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r2 = r2.readUnsignedExpGolombCodedInt()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = r4
            L_0x011a:
                int r2 = r9.picOrderCountType
                if (r2 != 0) goto L_0x0152
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r3 = r9.picOrderCntLsbLength
                boolean r2 = r2.canReadBits(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r3 = r9.picOrderCntLsbLength
                int r2 = r2.readBits(r3)
                boolean r1 = r1.bottomFieldPicOrderInFramePresentFlag
                if (r1 == 0) goto L_0x014d
                if (r14 != 0) goto L_0x014d
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r1 = r1.readSignedExpGolombCodedInt()
                r20 = r1
                r19 = r2
                r21 = r4
                goto L_0x0196
            L_0x014d:
                r19 = r2
                r20 = r4
                goto L_0x0194
            L_0x0152:
                int r2 = r9.picOrderCountType
                if (r2 != r5) goto L_0x0190
                boolean r2 = r9.deltaPicOrderAlwaysZeroFlag
                if (r2 != 0) goto L_0x0190
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                boolean r2 = r2.canReadExpGolombCodedNum()
                if (r2 != 0) goto L_0x0163
                return
            L_0x0163:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r2 = r2.readSignedExpGolombCodedInt()
                boolean r1 = r1.bottomFieldPicOrderInFramePresentFlag
                if (r1 == 0) goto L_0x0187
                if (r14 != 0) goto L_0x0187
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0178
                return
            L_0x0178:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r1 = r1.readSignedExpGolombCodedInt()
                r22 = r1
                r21 = r2
                r19 = r4
                r20 = r19
                goto L_0x0198
            L_0x0187:
                r21 = r2
                r19 = r4
                r20 = r19
                r22 = r20
                goto L_0x0198
            L_0x0190:
                r19 = r4
                r20 = r19
            L_0x0194:
                r21 = r20
            L_0x0196:
                r22 = r21
            L_0x0198:
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r8 = r0.sliceHeader
                r8.setAll(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.isFilling = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.appendToNalUnit(byte[], int, int):void");
        }

        public boolean endNalUnit(long j, int i, boolean z, boolean z2) {
            boolean z3 = false;
            if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                if (z && this.readingSample) {
                    outputSample(i + ((int) (j - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            if (this.allowNonIdrKeyframes) {
                z2 = this.sliceHeader.isISlice();
            }
            boolean z4 = this.sampleIsKeyframe;
            int i2 = this.nalUnitType;
            if (i2 == 5 || (z2 && i2 == 1)) {
                z3 = true;
            }
            boolean z5 = z4 | z3;
            this.sampleIsKeyframe = z5;
            return z5;
        }

        private void outputSample(int i) {
            long j = this.sampleTimeUs;
            if (j != C.TIME_UNSET) {
                boolean z = this.sampleIsKeyframe;
                this.output.sampleMetadata(j, z ? 1 : 0, (int) (this.nalUnitStartPosition - this.samplePosition), i, (TrackOutput.CryptoData) null);
            }
        }

        private static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private NalUnitUtil.SpsData spsData;

            private SliceHeaderData() {
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            public void setSliceType(int i) {
                this.sliceType = i;
                this.hasSliceType = true;
            }

            public void setAll(NalUnitUtil.SpsData spsData2, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
                this.spsData = spsData2;
                this.nalRefIdc = i;
                this.sliceType = i2;
                this.frameNum = i3;
                this.picParameterSetId = i4;
                this.fieldPicFlag = z;
                this.bottomFieldFlagPresent = z2;
                this.bottomFieldFlag = z3;
                this.idrPicFlag = z4;
                this.idrPicId = i5;
                this.picOrderCntLsb = i6;
                this.deltaPicOrderCntBottom = i7;
                this.deltaPicOrderCnt0 = i8;
                this.deltaPicOrderCnt1 = i9;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.sliceType;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean isISlice() {
                /*
                    r2 = this;
                    boolean r0 = r2.hasSliceType
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.sliceType
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData.isISlice():boolean");
            }

            /* access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                int i;
                int i2;
                boolean z;
                if (!this.isComplete) {
                    return false;
                }
                if (!sliceHeaderData.isComplete) {
                    return true;
                }
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(this.spsData);
                NalUnitUtil.SpsData spsData3 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(sliceHeaderData.spsData);
                if (this.frameNum == sliceHeaderData.frameNum && this.picParameterSetId == sliceHeaderData.picParameterSetId && this.fieldPicFlag == sliceHeaderData.fieldPicFlag && ((!this.bottomFieldFlagPresent || !sliceHeaderData.bottomFieldFlagPresent || this.bottomFieldFlag == sliceHeaderData.bottomFieldFlag) && (((i = this.nalRefIdc) == (i2 = sliceHeaderData.nalRefIdc) || (i != 0 && i2 != 0)) && ((spsData2.picOrderCountType != 0 || spsData3.picOrderCountType != 0 || (this.picOrderCntLsb == sliceHeaderData.picOrderCntLsb && this.deltaPicOrderCntBottom == sliceHeaderData.deltaPicOrderCntBottom)) && ((spsData2.picOrderCountType != 1 || spsData3.picOrderCountType != 1 || (this.deltaPicOrderCnt0 == sliceHeaderData.deltaPicOrderCnt0 && this.deltaPicOrderCnt1 == sliceHeaderData.deltaPicOrderCnt1)) && (z = this.idrPicFlag) == sliceHeaderData.idrPicFlag && (!z || this.idrPicId == sliceHeaderData.idrPicId)))))) {
                    return false;
                }
                return true;
            }
        }
    }
}
