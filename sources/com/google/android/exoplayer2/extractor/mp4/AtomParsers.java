package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.facebook.imagepipeline.common.RotationOptions;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ExtractorUtil;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.primitives.Ints;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_nclc = 1852009571;
    private static final int TYPE_nclx = 1852009592;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    private interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    private static int getTrackTypeForHdlr(int i) {
        if (i == TYPE_soun) {
            return 1;
        }
        if (i == TYPE_vide) {
            return 2;
        }
        if (i == TYPE_text || i == TYPE_sbtl || i == TYPE_subt || i == TYPE_clcp) {
            return 3;
        }
        return i == 1835365473 ? 5 : -1;
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j, DrmInitData drmInitData, boolean z, boolean z2, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < containerAtom2.containerChildren.size(); i++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.containerChildren.get(i);
            if (containerAtom3.type != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(parseTrak(containerAtom3, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd)), j, drmInitData, z, z2));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(parseStbl(apply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_mdia))).getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = parseUdtaMeta(parsableByteArray, position + readInt);
            } else if (readInt2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata2 = parseSmta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return Pair.create(metadata, metadata2);
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i = 0; i < readInt; i++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                Log.w(TAG, "Skipped metadata with unknown key index: " + readInt4);
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j, DrmInitData drmInitData, boolean z, boolean z2) throws ParserException {
        long j2;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd))).data);
        long j3 = C.TIME_UNSET;
        if (j == C.TIME_UNSET) {
            leafAtom2 = leafAtom;
            j2 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j2 = j;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j2 != C.TIME_UNSET) {
            j3 = Util.scaleLargeTimestamp(j2, 1000000, parseMvhd);
        }
        long j4 = j3;
        Pair<Long, String> parseMdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_mdhd))).data);
        StsdData parseStsd = parseStsd(((Atom.LeafAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl))).getLeafAtomOfType(Atom.TYPE_stsd))).data, parseTkhd.id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z2);
        if (z || (containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_edts)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j4, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x029b  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0384  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03c0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.google.android.exoplayer2.extractor.mp4.Track r38, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom r39, com.google.android.exoplayer2.extractor.GaplessInfoHolder r40) throws com.google.android.exoplayer2.ParserException {
        /*
            r1 = r38
            r0 = r39
            r2 = r40
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r5 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            com.google.android.exoplayer2.Format r6 = r1.format
            r5.<init>(r3, r6)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0530
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r5 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r5.<init>(r3)
        L_0x0025:
            int r3 = r5.getSampleCount()
            r6 = 0
            if (r3 != 0) goto L_0x0040
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r6]
            int[] r3 = new int[r6]
            r4 = 0
            long[] r5 = new long[r6]
            int[] r6 = new int[r6]
            r7 = 0
            r0 = r9
            r1 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0040:
            r7 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = r0.getLeafAtomOfType(r7)
            r8 = 1
            if (r7 != 0) goto L_0x0059
            r7 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = r0.getLeafAtomOfType(r7)
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r7 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r7
            r9 = r8
            goto L_0x005a
        L_0x0059:
            r9 = r6
        L_0x005a:
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r7.data
            r10 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r10
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r10.data
            r11 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            java.lang.Object r11 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r11
            com.google.android.exoplayer2.util.ParsableByteArray r11 = r11.data
            r12 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r12 = r0.getLeafAtomOfType(r12)
            if (r12 == 0) goto L_0x0086
            com.google.android.exoplayer2.util.ParsableByteArray r12 = r12.data
            goto L_0x0087
        L_0x0086:
            r12 = 0
        L_0x0087:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0093
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r10, r7, r9)
            r7 = 12
            r11.setPosition(r7)
            int r9 = r11.readUnsignedIntToInt()
            int r9 = r9 - r8
            int r10 = r11.readUnsignedIntToInt()
            int r14 = r11.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x00b5
            r0.setPosition(r7)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x00b6
        L_0x00b5:
            r15 = r6
        L_0x00b6:
            r4 = -1
            if (r12 == 0) goto L_0x00cd
            r12.setPosition(r7)
            int r7 = r12.readUnsignedIntToInt()
            if (r7 <= 0) goto L_0x00c9
            int r16 = r12.readUnsignedIntToInt()
            int r16 = r16 + -1
            goto L_0x00d0
        L_0x00c9:
            r16 = r4
            r12 = 0
            goto L_0x00d0
        L_0x00cd:
            r16 = r4
            r7 = r6
        L_0x00d0:
            int r6 = r5.getFixedSampleSize()
            com.google.android.exoplayer2.Format r8 = r1.format
            java.lang.String r8 = r8.sampleMimeType
            if (r6 == r4) goto L_0x00fc
            java.lang.String r4 = "audio/raw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f2
            java.lang.String r4 = "audio/g711-mlaw"
            boolean r4 = r4.equals(r8)
            if (r4 != 0) goto L_0x00f2
            java.lang.String r4 = "audio/g711-alaw"
            boolean r4 = r4.equals(r8)
            if (r4 == 0) goto L_0x00fc
        L_0x00f2:
            if (r9 != 0) goto L_0x00fc
            if (r15 != 0) goto L_0x00fc
            if (r7 != 0) goto L_0x00fc
            r39 = r7
            r4 = 1
            goto L_0x00ff
        L_0x00fc:
            r39 = r7
            r4 = 0
        L_0x00ff:
            if (r4 == 0) goto L_0x0137
            int r0 = r13.length
            long[] r0 = new long[r0]
            int r4 = r13.length
            int[] r4 = new int[r4]
        L_0x0109:
            boolean r5 = r13.moveNext()
            if (r5 == 0) goto L_0x011c
            int r5 = r13.index
            long r9 = r13.offset
            r0[r5] = r9
            int r5 = r13.index
            int r9 = r13.numSamples
            r4[r5] = r9
            goto L_0x0109
        L_0x011c:
            long r9 = (long) r14
            com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r6, r0, r4, r9)
            long[] r4 = r0.offsets
            int[] r5 = r0.sizes
            int r6 = r0.maximumSize
            long[] r9 = r0.timestamps
            int[] r10 = r0.flags
            long r11 = r0.duration
            r14 = r1
            r0 = r3
            r2 = r4
            r3 = r5
            r4 = r6
            r13 = r10
            r15 = r11
            r12 = r9
            goto L_0x02af
        L_0x0137:
            long[] r4 = new long[r3]
            int[] r6 = new int[r3]
            long[] r7 = new long[r3]
            int[] r8 = new int[r3]
            r24 = r11
            r2 = r16
            r1 = 0
            r11 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r25 = 0
            r27 = 0
            r16 = r15
            r15 = r14
            r14 = r10
            r37 = r9
            r9 = r39
        L_0x0157:
            r39 = r37
            java.lang.String r10 = "AtomParsers"
            if (r1 >= r3) goto L_0x021b
            r28 = r27
            r27 = r22
            r22 = 1
        L_0x0163:
            if (r27 != 0) goto L_0x0180
            boolean r22 = r13.moveNext()
            if (r22 == 0) goto L_0x0180
            r30 = r14
            r31 = r15
            long r14 = r13.offset
            r32 = r3
            int r3 = r13.numSamples
            r27 = r3
            r28 = r14
            r14 = r30
            r15 = r31
            r3 = r32
            goto L_0x0163
        L_0x0180:
            r32 = r3
            r30 = r14
            r31 = r15
            if (r22 != 0) goto L_0x01a4
            java.lang.String r2 = "Unexpected end of chunk data"
            com.google.android.exoplayer2.util.Log.w(r10, r2)
            long[] r4 = java.util.Arrays.copyOf(r4, r1)
            int[] r6 = java.util.Arrays.copyOf(r6, r1)
            long[] r7 = java.util.Arrays.copyOf(r7, r1)
            int[] r8 = java.util.Arrays.copyOf(r8, r1)
            r3 = r1
            r2 = r21
            r1 = r27
            goto L_0x0223
        L_0x01a4:
            if (r0 == 0) goto L_0x01b7
        L_0x01a6:
            if (r23 != 0) goto L_0x01b5
            if (r16 <= 0) goto L_0x01b5
            int r23 = r0.readUnsignedIntToInt()
            int r21 = r0.readInt()
            int r16 = r16 + -1
            goto L_0x01a6
        L_0x01b5:
            int r23 = r23 + -1
        L_0x01b7:
            r3 = r21
            r4[r1] = r28
            int r10 = r5.readNextSampleSize()
            r6[r1] = r10
            if (r10 <= r11) goto L_0x01c4
            r11 = r10
        L_0x01c4:
            long r14 = (long) r3
            long r14 = r25 + r14
            r7[r1] = r14
            if (r12 != 0) goto L_0x01cd
            r10 = 1
            goto L_0x01ce
        L_0x01cd:
            r10 = 0
        L_0x01ce:
            r8[r1] = r10
            if (r1 != r2) goto L_0x01e4
            r10 = 1
            r8[r1] = r10
            int r9 = r9 + -1
            if (r9 <= 0) goto L_0x01e4
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r12)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = (com.google.android.exoplayer2.util.ParsableByteArray) r2
            int r2 = r2.readUnsignedIntToInt()
            int r2 = r2 - r10
        L_0x01e4:
            r15 = r2
            r10 = r3
            r14 = r31
            long r2 = (long) r14
            long r25 = r25 + r2
            int r2 = r30 + -1
            if (r2 != 0) goto L_0x01fc
            if (r39 <= 0) goto L_0x01fc
            int r2 = r24.readUnsignedIntToInt()
            int r3 = r24.readInt()
            int r14 = r39 + -1
            goto L_0x01ff
        L_0x01fc:
            r3 = r14
            r14 = r39
        L_0x01ff:
            r39 = r2
            r2 = r6[r1]
            r21 = r3
            long r2 = (long) r2
            long r2 = r28 + r2
            int r22 = r27 + -1
            int r1 = r1 + 1
            r27 = r2
            r2 = r15
            r15 = r21
            r3 = r32
            r21 = r10
            r37 = r14
            r14 = r39
            goto L_0x0157
        L_0x021b:
            r32 = r3
            r30 = r14
            r2 = r21
            r1 = r22
        L_0x0223:
            long r12 = (long) r2
            long r12 = r25 + r12
            if (r0 == 0) goto L_0x0238
        L_0x0228:
            if (r16 <= 0) goto L_0x0238
            int r2 = r0.readUnsignedIntToInt()
            if (r2 == 0) goto L_0x0232
            r0 = 0
            goto L_0x0239
        L_0x0232:
            r0.readInt()
            int r16 = r16 + -1
            goto L_0x0228
        L_0x0238:
            r0 = 1
        L_0x0239:
            if (r9 != 0) goto L_0x024b
            if (r30 != 0) goto L_0x024b
            if (r1 != 0) goto L_0x024b
            if (r39 != 0) goto L_0x024b
            r2 = r23
            if (r2 != 0) goto L_0x024d
            if (r0 != 0) goto L_0x0248
            goto L_0x024d
        L_0x0248:
            r14 = r38
            goto L_0x02a8
        L_0x024b:
            r2 = r23
        L_0x024d:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r14 = "Inconsistent stbl box for track "
            java.lang.StringBuilder r5 = r5.append(r14)
            r14 = r38
            int r15 = r14.id
            java.lang.StringBuilder r5 = r5.append(r15)
            java.lang.String r15 = ": remainingSynchronizationSamples "
            java.lang.StringBuilder r5 = r5.append(r15)
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r9 = ", remainingSamplesAtTimestampDelta "
            java.lang.StringBuilder r5 = r5.append(r9)
            r9 = r30
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.String r9 = ", remainingSamplesInChunk "
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.StringBuilder r1 = r5.append(r1)
            java.lang.String r5 = ", remainingTimestampDeltaChanges "
            java.lang.StringBuilder r1 = r1.append(r5)
            r9 = r39
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r5 = ", remainingSamplesAtTimestampOffset "
            java.lang.StringBuilder r1 = r1.append(r5)
            java.lang.StringBuilder r1 = r1.append(r2)
            if (r0 != 0) goto L_0x029b
            java.lang.String r0 = ", ctts invalid"
            goto L_0x029d
        L_0x029b:
            java.lang.String r0 = ""
        L_0x029d:
            java.lang.StringBuilder r0 = r1.append(r0)
            java.lang.String r0 = r0.toString()
            com.google.android.exoplayer2.util.Log.w(r10, r0)
        L_0x02a8:
            r0 = r3
            r2 = r4
            r3 = r6
            r4 = r11
            r15 = r12
            r12 = r7
            r13 = r8
        L_0x02af:
            r7 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r14.timescale
            r5 = r15
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r5, r7, r9)
            long[] r1 = r14.editListDurations
            r10 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02d0
            long r0 = r14.timescale
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r12, r10, r0)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02d0:
            long[] r1 = r14.editListDurations
            int r1 = r1.length
            r5 = 1
            if (r1 != r5) goto L_0x036f
            int r1 = r14.type
            if (r1 != r5) goto L_0x036f
            int r1 = r12.length
            r5 = 2
            if (r1 < r5) goto L_0x036f
            long[] r1 = r14.editListMediaTimes
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            long[] r1 = (long[]) r1
            r5 = 0
            r21 = r1[r5]
            long[] r1 = r14.editListDurations
            r23 = r1[r5]
            long r5 = r14.timescale
            long r7 = r14.movieTimescale
            r25 = r5
            r27 = r7
            long r5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r23, r25, r27)
            long r23 = r21 + r5
            r5 = r12
            r6 = r15
            r8 = r21
            r25 = r0
            r0 = r10
            r10 = r23
            boolean r5 = canApplyEditWithGaplessInfo(r5, r6, r8, r10)
            if (r5 == 0) goto L_0x0371
            long r6 = r15 - r23
            r5 = 0
            r8 = r12[r5]
            long r26 = r21 - r8
            com.google.android.exoplayer2.Format r5 = r14.format
            int r5 = r5.sampleRate
            long r8 = (long) r5
            long r10 = r14.timescale
            r28 = r8
            r30 = r10
            long r10 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r26, r28, r30)
            com.google.android.exoplayer2.Format r5 = r14.format
            int r5 = r5.sampleRate
            long r8 = (long) r5
            long r0 = r14.timescale
            r39 = r4
            r4 = r10
            r10 = r0
            long r0 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r6, r8, r10)
            r6 = 0
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 != 0) goto L_0x0339
            int r8 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0373
        L_0x0339:
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 > 0) goto L_0x0373
            int r6 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r6 > 0) goto L_0x0373
            int r4 = (int) r4
            r5 = r40
            r5.encoderDelay = r4
            int r0 = (int) r0
            r5.encoderPadding = r0
            long r0 = r14.timescale
            r4 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r12, r4, r0)
            long[] r0 = r14.editListDurations
            r1 = 0
            r4 = r0[r1]
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r8 = r14.movieTimescale
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r4, r6, r8)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x036f:
            r25 = r0
        L_0x0371:
            r39 = r4
        L_0x0373:
            long[] r0 = r14.editListDurations
            int r0 = r0.length
            r1 = 1
            if (r0 != r1) goto L_0x03c0
            long[] r0 = r14.editListDurations
            r1 = 0
            r4 = r0[r1]
            r6 = 0
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x03c0
            long[] r0 = r14.editListMediaTimes
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
            long[] r0 = (long[]) r0
            r4 = r0[r1]
            r6 = 0
        L_0x038f:
            int r0 = r12.length
            if (r6 >= r0) goto L_0x03a6
            r0 = r12[r6]
            long r17 = r0 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.timescale
            r21 = r0
            long r0 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r17, r19, r21)
            r12[r6] = r0
            int r6 = r6 + 1
            goto L_0x038f
        L_0x03a6:
            long r17 = r15 - r4
            r19 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.timescale
            r21 = r0
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r17, r19, r21)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r38
            r4 = r39
            r5 = r12
            r6 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03c0:
            int r0 = r14.type
            r1 = 1
            if (r0 != r1) goto L_0x03c7
            r10 = 1
            goto L_0x03c8
        L_0x03c7:
            r10 = 0
        L_0x03c8:
            long[] r0 = r14.editListDurations
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r1 = r14.editListDurations
            int r1 = r1.length
            int[] r1 = new int[r1]
            long[] r4 = r14.editListMediaTimes
            java.lang.Object r4 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r4)
            long[] r4 = (long[]) r4
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L_0x03de:
            long[] r9 = r14.editListDurations
            int r9 = r9.length
            if (r5 >= r9) goto L_0x0444
            r9 = r2
            r11 = r3
            r2 = r4[r5]
            r15 = -1
            int r15 = (r2 > r15 ? 1 : (r2 == r15 ? 0 : -1))
            if (r15 == 0) goto L_0x0430
            long[] r15 = r14.editListDurations
            r26 = r15[r5]
            r15 = r8
            r16 = r9
            long r8 = r14.timescale
            r40 = r6
            r21 = r7
            long r6 = r14.movieTimescale
            r28 = r8
            r30 = r6
            long r6 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r26, r28, r30)
            r8 = 1
            int r9 = com.google.android.exoplayer2.util.Util.binarySearchFloor((long[]) r12, (long) r2, (boolean) r8, (boolean) r8)
            r0[r5] = r9
            long r2 = r2 + r6
            r6 = 0
            int r2 = com.google.android.exoplayer2.util.Util.binarySearchCeil((long[]) r12, (long) r2, (boolean) r10, (boolean) r6)
            r1[r5] = r2
        L_0x0413:
            r2 = r0[r5]
            r3 = r1[r5]
            if (r2 >= r3) goto L_0x0423
            r7 = r13[r2]
            r7 = r7 & r8
            if (r7 != 0) goto L_0x0423
            int r2 = r2 + 1
            r0[r5] = r2
            goto L_0x0413
        L_0x0423:
            int r7 = r3 - r2
            int r7 = r21 + r7
            r9 = r15
            if (r9 == r2) goto L_0x042c
            r2 = r8
            goto L_0x042d
        L_0x042c:
            r2 = r6
        L_0x042d:
            r2 = r40 | r2
            goto L_0x043c
        L_0x0430:
            r40 = r6
            r21 = r7
            r16 = r9
            r6 = 0
            r9 = r8
            r8 = 1
            r2 = r40
            r3 = r9
        L_0x043c:
            int r5 = r5 + 1
            r6 = r2
            r8 = r3
            r3 = r11
            r2 = r16
            goto L_0x03de
        L_0x0444:
            r16 = r2
            r11 = r3
            r40 = r6
            r3 = r25
            r6 = 0
            r8 = 1
            if (r7 == r3) goto L_0x0450
            goto L_0x0451
        L_0x0450:
            r8 = r6
        L_0x0451:
            r2 = r40 | r8
            if (r2 == 0) goto L_0x0458
            long[] r3 = new long[r7]
            goto L_0x045a
        L_0x0458:
            r3 = r16
        L_0x045a:
            if (r2 == 0) goto L_0x045f
            int[] r4 = new int[r7]
            goto L_0x0460
        L_0x045f:
            r4 = r11
        L_0x0460:
            if (r2 == 0) goto L_0x0464
            r5 = r6
            goto L_0x0466
        L_0x0464:
            r5 = r39
        L_0x0466:
            if (r2 == 0) goto L_0x046b
            int[] r8 = new int[r7]
            goto L_0x046c
        L_0x046b:
            r8 = r13
        L_0x046c:
            long[] r7 = new long[r7]
            r39 = r5
            r15 = r6
            r9 = 0
        L_0x0473:
            long[] r5 = r14.editListDurations
            int r5 = r5.length
            if (r6 >= r5) goto L_0x0510
            long[] r5 = r14.editListMediaTimes
            r17 = r5[r6]
            r5 = r0[r6]
            r27 = r0
            r0 = r1[r6]
            r28 = r1
            if (r2 == 0) goto L_0x0496
            int r1 = r0 - r5
            r29 = r6
            r6 = r16
            java.lang.System.arraycopy(r6, r5, r3, r15, r1)
            java.lang.System.arraycopy(r11, r5, r4, r15, r1)
            java.lang.System.arraycopy(r13, r5, r8, r15, r1)
            goto L_0x049a
        L_0x0496:
            r29 = r6
            r6 = r16
        L_0x049a:
            r1 = r39
        L_0x049c:
            if (r5 >= r0) goto L_0x04ec
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r40 = r0
            r16 = r1
            long r0 = r14.movieTimescale
            r21 = r9
            r25 = r0
            long r0 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            r21 = r12[r5]
            r23 = r12
            r24 = r13
            long r12 = r21 - r17
            r30 = r8
            r21 = r9
            r8 = 0
            long r31 = java.lang.Math.max(r8, r12)
            r33 = 1000000(0xf4240, double:4.940656E-318)
            long r12 = r14.timescale
            r35 = r12
            long r12 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r31, r33, r35)
            long r0 = r0 + r12
            r7[r15] = r0
            if (r2 == 0) goto L_0x04db
            r0 = r4[r15]
            r1 = r16
            if (r0 <= r1) goto L_0x04dd
            r0 = r11[r5]
            r1 = r0
            goto L_0x04dd
        L_0x04db:
            r1 = r16
        L_0x04dd:
            int r15 = r15 + 1
            int r5 = r5 + 1
            r0 = r40
            r9 = r21
            r12 = r23
            r13 = r24
            r8 = r30
            goto L_0x049c
        L_0x04ec:
            r30 = r8
            r21 = r9
            r23 = r12
            r24 = r13
            r8 = 0
            long[] r0 = r14.editListDurations
            r12 = r0[r29]
            long r12 = r21 + r12
            int r0 = r29 + 1
            r39 = r1
            r16 = r6
            r9 = r12
            r12 = r23
            r13 = r24
            r1 = r28
            r8 = r30
            r6 = r0
            r0 = r27
            goto L_0x0473
        L_0x0510:
            r30 = r8
            r21 = r9
            r23 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r14.movieTimescale
            r25 = r0
            long r8 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r10 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r10
            r1 = r38
            r2 = r3
            r3 = r4
            r4 = r39
            r5 = r7
            r6 = r30
            r7 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r10
        L_0x0530:
            java.lang.String r0 = "Track has no sample table size information"
            r1 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r0, r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder):com.google.android.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() != 1935766900) {
                parsableByteArray.setPosition(position + readInt);
            } else if (readInt < 14) {
                return null;
            } else {
                parsableByteArray.skipBytes(5);
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte != 12 && readUnsignedByte != 13) {
                    return null;
                }
                float f = readUnsignedByte == 12 ? 240.0f : 120.0f;
                parsableByteArray.skipBytes(1);
                return new Metadata(new SmtaMetadataEntry(f, parsableByteArray.readUnsignedByte()));
            }
        }
        return null;
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i = 16;
        }
        parsableByteArray.skipBytes(i);
        return parsableByteArray.readUnsignedInt();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z;
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i3 >= i) {
                z = true;
                break;
            } else if (parsableByteArray.getData()[position + i3] != -1) {
                z = false;
                break;
            } else {
                i3++;
            }
        }
        long j = C.TIME_UNSET;
        if (z) {
            parsableByteArray.skipBytes(i);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i2 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i2 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i2 = RotationOptions.ROTATE_180;
        }
        return new TkhdData(readInt, j, i2);
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i = 4;
        }
        parsableByteArray.skipBytes(i);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        return Pair.create(Long.valueOf(readUnsignedInt), "" + ((char) (((readUnsignedShort >> 10) & 31) + 96)) + ((char) (((readUnsignedShort >> 5) & 31) + 96)) + ((char) ((readUnsignedShort & 31) + 96)));
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i, int i2, String str, DrmInitData drmInitData, boolean z) throws ParserException {
        int i3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i4 = i;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i5 = 0; i5 < readInt; i5++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt2 > 0, "childAtomSize must be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1831958048 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1211250227 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                i3 = position;
                parseVideoSampleEntry(parsableByteArray, readInt3, i3, readInt2, i, i2, drmInitData, stsdData, i5);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1835823201 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1685353336 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1835557169 || readInt3 == 1835560241 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                i3 = position;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, z, drmInitData, stsdData, i5);
            } else {
                if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i, str, stsdData);
                } else if (readInt3 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray2, readInt3, position, i4, stsdData);
                } else if (readInt3 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                }
                i3 = position;
            }
            parsableByteArray2.setPosition(i3 + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j = Long.MAX_VALUE;
        if (i != 1414810956) {
            if (i == 1954034535) {
                int i5 = (i3 - 8) - 8;
                byte[] bArr = new byte[i5];
                parsableByteArray.readBytes(bArr, 0, i5);
                immutableList = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i == 1937010800) {
                j = 0;
            } else if (i == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i4).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j).setInitializationData(immutableList).build();
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, int i4, int i5, DrmInitData drmInitData, StsdData stsdData, int i6) throws ParserException {
        DrmInitData drmInitData2;
        byte[] bArr;
        int i7;
        int i8;
        float f;
        byte[] bArr2;
        List<byte[]> list;
        String str;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i9 = i2;
        int i10 = i3;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i9 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        int i11 = i;
        if (i11 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i9, i10);
            if (parseSampleEntryEncryptionData != null) {
                i11 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i6] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        String str2 = MimeTypes.VIDEO_H263;
        String str3 = i11 == 1831958048 ? MimeTypes.VIDEO_MPEG : i11 == 1211250227 ? str2 : null;
        float f2 = 1.0f;
        byte[] bArr3 = null;
        String str4 = null;
        List<byte[]> list2 = null;
        int i12 = -1;
        int i13 = -1;
        int i14 = -1;
        int i15 = -1;
        ByteBuffer byteBuffer = null;
        EsdsData esdsData = null;
        boolean z = false;
        while (true) {
            if (position - i9 >= i10) {
                drmInitData2 = drmInitData3;
                break;
            }
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            String str5 = str2;
            int readInt = parsableByteArray.readInt();
            if (readInt == 0) {
                drmInitData2 = drmInitData3;
                if (parsableByteArray.getPosition() - i9 == i10) {
                    break;
                }
            } else {
                drmInitData2 = drmInitData3;
            }
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse.pixelWidthHeightRatio;
                }
                str4 = parse.codecs;
                str = MimeTypes.VIDEO_H264;
            } else if (readInt2 == 1752589123) {
                ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                if (!z) {
                    f2 = parse2.pixelWidthHeightRatio;
                }
                str4 = parse2.codecs;
                str = MimeTypes.VIDEO_H265;
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    i7 = readUnsignedShort2;
                    i8 = i11;
                    bArr2 = bArr3;
                    f = f2;
                    list = list2;
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str4 = parse3.codecs;
                        str3 = MimeTypes.VIDEO_DOLBY_VISION;
                    }
                } else if (readInt2 == 1987076931) {
                    ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                    str = i11 == 1987063864 ? MimeTypes.VIDEO_VP8 : MimeTypes.VIDEO_VP9;
                } else if (readInt2 == 1635135811) {
                    ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                    str = MimeTypes.VIDEO_AV1;
                } else if (readInt2 == 1668050025) {
                    if (byteBuffer == null) {
                        byteBuffer = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer2 = byteBuffer;
                    byteBuffer2.position(21);
                    byteBuffer2.putShort(parsableByteArray.readShort());
                    byteBuffer2.putShort(parsableByteArray.readShort());
                    byteBuffer = byteBuffer2;
                    i7 = readUnsignedShort2;
                    i8 = i11;
                    position += readInt;
                    i9 = i2;
                    i10 = i3;
                    stsdData2 = stsdData;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i11 = i8;
                    readUnsignedShort2 = i7;
                } else if (readInt2 == 1835295606) {
                    if (byteBuffer == null) {
                        byteBuffer = allocateHdrStaticInfo();
                    }
                    ByteBuffer byteBuffer3 = byteBuffer;
                    short readShort = parsableByteArray.readShort();
                    short readShort2 = parsableByteArray.readShort();
                    short readShort3 = parsableByteArray.readShort();
                    i8 = i11;
                    short readShort4 = parsableByteArray.readShort();
                    short readShort5 = parsableByteArray.readShort();
                    List<byte[]> list3 = list2;
                    short readShort6 = parsableByteArray.readShort();
                    byte[] bArr4 = bArr3;
                    short readShort7 = parsableByteArray.readShort();
                    float f3 = f2;
                    short readShort8 = parsableByteArray.readShort();
                    long readUnsignedInt = parsableByteArray.readUnsignedInt();
                    long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                    i7 = readUnsignedShort2;
                    byteBuffer3.position(1);
                    byteBuffer3.putShort(readShort5);
                    byteBuffer3.putShort(readShort6);
                    byteBuffer3.putShort(readShort);
                    byteBuffer3.putShort(readShort2);
                    byteBuffer3.putShort(readShort3);
                    byteBuffer3.putShort(readShort4);
                    byteBuffer3.putShort(readShort7);
                    byteBuffer3.putShort(readShort8);
                    byteBuffer3.putShort((short) ((int) (readUnsignedInt / 10000)));
                    byteBuffer3.putShort((short) ((int) (readUnsignedInt2 / 10000)));
                    byteBuffer = byteBuffer3;
                    list2 = list3;
                    bArr3 = bArr4;
                    f2 = f3;
                    position += readInt;
                    i9 = i2;
                    i10 = i3;
                    stsdData2 = stsdData;
                    str2 = str5;
                    drmInitData3 = drmInitData2;
                    i11 = i8;
                    readUnsignedShort2 = i7;
                } else {
                    i7 = readUnsignedShort2;
                    i8 = i11;
                    bArr2 = bArr3;
                    f = f2;
                    list = list2;
                    if (readInt2 == 1681012275) {
                        ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                        str3 = str5;
                    } else if (readInt2 == 1702061171) {
                        ExtractorUtil.checkContainerInput(str3 == null, (String) null);
                        esdsData = parseEsdsFromParent(parsableByteArray2, position2);
                        String access$300 = esdsData.mimeType;
                        byte[] access$400 = esdsData.initializationData;
                        list2 = access$400 != null ? ImmutableList.of(access$400) : list;
                        str3 = access$300;
                        bArr3 = bArr2;
                        f2 = f;
                        position += readInt;
                        i9 = i2;
                        i10 = i3;
                        stsdData2 = stsdData;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i11 = i8;
                        readUnsignedShort2 = i7;
                    } else if (readInt2 == 1885434736) {
                        f2 = parsePaspFromParent(parsableByteArray2, position2);
                        list2 = list;
                        bArr3 = bArr2;
                        z = true;
                        position += readInt;
                        i9 = i2;
                        i10 = i3;
                        stsdData2 = stsdData;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i11 = i8;
                        readUnsignedShort2 = i7;
                    } else if (readInt2 == 1937126244) {
                        bArr3 = parseProjFromParent(parsableByteArray2, position2, readInt);
                        list2 = list;
                        f2 = f;
                        position += readInt;
                        i9 = i2;
                        i10 = i3;
                        stsdData2 = stsdData;
                        str2 = str5;
                        drmInitData3 = drmInitData2;
                        i11 = i8;
                        readUnsignedShort2 = i7;
                    } else if (readInt2 == 1936995172) {
                        int readUnsignedByte = parsableByteArray.readUnsignedByte();
                        parsableByteArray2.skipBytes(3);
                        if (readUnsignedByte == 0) {
                            int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                            if (readUnsignedByte2 == 0) {
                                i12 = 0;
                            } else if (readUnsignedByte2 == 1) {
                                i12 = 1;
                            } else if (readUnsignedByte2 == 2) {
                                i12 = 2;
                            } else if (readUnsignedByte2 == 3) {
                                i12 = 3;
                            }
                        }
                    } else if (readInt2 == 1668246642) {
                        int readInt3 = parsableByteArray.readInt();
                        if (readInt3 == TYPE_nclx || readInt3 == TYPE_nclc) {
                            int readUnsignedShort3 = parsableByteArray.readUnsignedShort();
                            int readUnsignedShort4 = parsableByteArray.readUnsignedShort();
                            parsableByteArray2.skipBytes(2);
                            boolean z2 = readInt == 19 && (parsableByteArray.readUnsignedByte() & 128) != 0;
                            i13 = ColorInfo.isoColorPrimariesToColorSpace(readUnsignedShort3);
                            i14 = z2 ? 1 : 2;
                            i15 = ColorInfo.isoTransferCharacteristicsToColorTransfer(readUnsignedShort4);
                        } else {
                            Log.w(TAG, "Unsupported color type: " + Atom.getAtomTypeString(readInt3));
                        }
                    }
                }
                list2 = list;
                bArr3 = bArr2;
                f2 = f;
                position += readInt;
                i9 = i2;
                i10 = i3;
                stsdData2 = stsdData;
                str2 = str5;
                drmInitData3 = drmInitData2;
                i11 = i8;
                readUnsignedShort2 = i7;
            }
            str3 = str;
            i7 = readUnsignedShort2;
            i8 = i11;
            position += readInt;
            i9 = i2;
            i10 = i3;
            stsdData2 = stsdData;
            str2 = str5;
            drmInitData3 = drmInitData2;
            i11 = i8;
            readUnsignedShort2 = i7;
        }
        int i16 = readUnsignedShort2;
        byte[] bArr5 = bArr3;
        float f4 = f2;
        List<byte[]> list4 = list2;
        if (str3 != null) {
            Format.Builder drmInitData4 = new Format.Builder().setId(i4).setSampleMimeType(str3).setCodecs(str4).setWidth(readUnsignedShort).setHeight(i16).setPixelWidthHeightRatio(f4).setRotationDegrees(i5).setProjectionData(bArr5).setStereoMode(i12).setInitializationData(list4).setDrmInitData(drmInitData2);
            int i17 = i13;
            int i18 = i14;
            int i19 = i15;
            if (!(i17 == -1 && i18 == -1 && i19 == -1 && byteBuffer == null)) {
                if (byteBuffer != null) {
                    bArr = byteBuffer.array();
                } else {
                    bArr = null;
                }
                drmInitData4.setColorInfo(new ColorInfo(i17, i18, i19, bArr));
            }
            if (esdsData != null) {
                drmInitData4.setAverageBitrate(Ints.saturatedCast(esdsData.bitrate)).setPeakBitrate(Ints.saturatedCast(esdsData.peakBitrate));
            }
            stsdData.format = drmInitData4.build();
        }
    }

    private static ByteBuffer allocateHdrStaticInfo() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i, int i2, int i3, StsdData stsdData) {
        parsableByteArray.setPosition(i2 + 8 + 8);
        if (i == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i3).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i = 0;
        while (i < readUnsignedIntToInt) {
            jArr[i] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    /* JADX WARNING: Removed duplicated region for block: B:153:0x0312 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x0165  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, com.google.android.exoplayer2.drm.DrmInitData r29, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r30, int r31) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r22
            r1 = r24
            r2 = r25
            r3 = r26
            r4 = r27
            r5 = r29
            r6 = r30
            int r7 = r1 + 8
            r8 = 8
            int r7 = r7 + r8
            r0.setPosition(r7)
            r7 = 6
            if (r28 == 0) goto L_0x0021
            int r8 = r22.readUnsignedShort()
            r0.skipBytes(r7)
            goto L_0x0025
        L_0x0021:
            r0.skipBytes(r8)
            r8 = 0
        L_0x0025:
            r10 = 16
            r11 = 4
            r12 = 2
            r13 = 1
            if (r8 == 0) goto L_0x0049
            if (r8 != r13) goto L_0x002f
            goto L_0x0049
        L_0x002f:
            if (r8 != r12) goto L_0x0048
            r0.skipBytes(r10)
            double r7 = r22.readDouble()
            long r7 = java.lang.Math.round(r7)
            int r7 = (int) r7
            int r8 = r22.readUnsignedIntToInt()
            r10 = 20
            r0.skipBytes(r10)
            r15 = 0
            goto L_0x0066
        L_0x0048:
            return
        L_0x0049:
            int r14 = r22.readUnsignedShort()
            r0.skipBytes(r7)
            int r7 = r22.readUnsignedFixedPoint1616()
            int r15 = r22.getPosition()
            int r15 = r15 - r11
            r0.setPosition(r15)
            int r15 = r22.readInt()
            if (r8 != r13) goto L_0x0065
            r0.skipBytes(r10)
        L_0x0065:
            r8 = r14
        L_0x0066:
            int r10 = r22.getPosition()
            r14 = 1701733217(0x656e6361, float:7.0359778E22)
            r12 = r23
            if (r12 != r14) goto L_0x0098
            android.util.Pair r14 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r14 == 0) goto L_0x0095
            java.lang.Object r12 = r14.first
            java.lang.Integer r12 = (java.lang.Integer) r12
            int r12 = r12.intValue()
            if (r5 != 0) goto L_0x0083
            r5 = 0
            goto L_0x008d
        L_0x0083:
            java.lang.Object r13 = r14.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r13 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r13
            java.lang.String r13 = r13.schemeType
            com.google.android.exoplayer2.drm.DrmInitData r5 = r5.copyWithSchemeType(r13)
        L_0x008d:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r13 = r6.trackEncryptionBoxes
            java.lang.Object r14 = r14.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r14 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r14
            r13[r31] = r14
        L_0x0095:
            r0.setPosition(r10)
        L_0x0098:
            r13 = 1633889587(0x61632d33, float:2.6191674E20)
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r19 = "audio/raw"
            if (r12 != r13) goto L_0x00a7
            java.lang.String r19 = "audio/ac3"
        L_0x00a4:
            r12 = -1
            goto L_0x0159
        L_0x00a7:
            r13 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r12 != r13) goto L_0x00af
            java.lang.String r19 = "audio/eac3"
            goto L_0x00a4
        L_0x00af:
            r13 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r12 != r13) goto L_0x00b7
            java.lang.String r19 = "audio/ac4"
            goto L_0x00a4
        L_0x00b7:
            r13 = 1685353315(0x64747363, float:1.803728E22)
            if (r12 != r13) goto L_0x00bf
            java.lang.String r19 = "audio/vnd.dts"
            goto L_0x00a4
        L_0x00bf:
            r13 = 1685353320(0x64747368, float:1.8037286E22)
            if (r12 == r13) goto L_0x0155
            r13 = 1685353324(0x6474736c, float:1.803729E22)
            if (r12 != r13) goto L_0x00cb
            goto L_0x0155
        L_0x00cb:
            r13 = 1685353317(0x64747365, float:1.8037282E22)
            if (r12 != r13) goto L_0x00d3
            java.lang.String r19 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x00a4
        L_0x00d3:
            r13 = 1685353336(0x64747378, float:1.8037304E22)
            if (r12 != r13) goto L_0x00db
            java.lang.String r19 = "audio/vnd.dts.uhd;profile=p2"
            goto L_0x00a4
        L_0x00db:
            r13 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r12 != r13) goto L_0x00e3
            java.lang.String r19 = "audio/3gpp"
            goto L_0x00a4
        L_0x00e3:
            r13 = 1935767394(0x73617762, float:1.7863284E31)
            if (r12 != r13) goto L_0x00eb
            java.lang.String r19 = "audio/amr-wb"
            goto L_0x00a4
        L_0x00eb:
            r13 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r12 == r13) goto L_0x0153
            r13 = 1936684916(0x736f7774, float:1.89725E31)
            if (r12 != r13) goto L_0x00f6
            goto L_0x0153
        L_0x00f6:
            r13 = 1953984371(0x74776f73, float:7.841539E31)
            if (r12 != r13) goto L_0x00fe
            r12 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0159
        L_0x00fe:
            r13 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r12 == r13) goto L_0x014f
            r13 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r12 != r13) goto L_0x0109
            goto L_0x014f
        L_0x0109:
            r13 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r12 != r13) goto L_0x0111
            java.lang.String r19 = "audio/mha1"
            goto L_0x00a4
        L_0x0111:
            r13 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r12 != r13) goto L_0x0119
            java.lang.String r19 = "audio/mhm1"
            goto L_0x00a4
        L_0x0119:
            if (r12 != r14) goto L_0x011e
            java.lang.String r19 = "audio/alac"
            goto L_0x00a4
        L_0x011e:
            r13 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r12 != r13) goto L_0x0127
            java.lang.String r19 = "audio/g711-alaw"
            goto L_0x00a4
        L_0x0127:
            r13 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r12 != r13) goto L_0x0130
            java.lang.String r19 = "audio/g711-mlaw"
            goto L_0x00a4
        L_0x0130:
            r13 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r12 != r13) goto L_0x0139
            java.lang.String r19 = "audio/opus"
            goto L_0x00a4
        L_0x0139:
            r13 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r12 != r13) goto L_0x0142
            java.lang.String r19 = "audio/flac"
            goto L_0x00a4
        L_0x0142:
            r13 = 1835823201(0x6d6c7061, float:4.573395E27)
            if (r12 != r13) goto L_0x014b
            java.lang.String r19 = "audio/true-hd"
            goto L_0x00a4
        L_0x014b:
            r12 = -1
            r19 = 0
            goto L_0x0159
        L_0x014f:
            java.lang.String r19 = "audio/mpeg"
            goto L_0x00a4
        L_0x0153:
            r12 = 2
            goto L_0x0159
        L_0x0155:
            java.lang.String r19 = "audio/vnd.dts.hd"
            goto L_0x00a4
        L_0x0159:
            r13 = r19
            r19 = 0
            r20 = 0
            r21 = 0
        L_0x0161:
            int r11 = r10 - r1
            if (r11 >= r2) goto L_0x030e
            r0.setPosition(r10)
            int r11 = r22.readInt()
            if (r11 <= 0) goto L_0x0170
            r14 = 1
            goto L_0x0171
        L_0x0170:
            r14 = 0
        L_0x0171:
            java.lang.String r9 = "childAtomSize must be positive"
            com.google.android.exoplayer2.extractor.ExtractorUtil.checkContainerInput(r14, r9)
            int r9 = r22.readInt()
            r14 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r9 != r14) goto L_0x019a
            int r9 = r11 + -13
            byte[] r14 = new byte[r9]
            int r1 = r10 + 13
            r0.setPosition(r1)
            r1 = 0
            r0.readBytes(r14, r1, r9)
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.of(r14)
        L_0x0190:
            r9 = -1
            r14 = 1
            r16 = 4
            r17 = 2
        L_0x0196:
            r18 = 0
            goto L_0x0304
        L_0x019a:
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 == r1) goto L_0x02c9
            if (r28 == 0) goto L_0x01a8
            r14 = 2002876005(0x77617665, float:4.5729223E33)
            if (r9 != r14) goto L_0x01a8
            goto L_0x02c9
        L_0x01a8:
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r9 != r1) goto L_0x01c7
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r1, r4, r5)
            r6.format = r1
        L_0x01bc:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 0
            r14 = 1
            r16 = 4
            r17 = 2
            goto L_0x02c5
        L_0x01c7:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r9 != r1) goto L_0x01dc
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r1, r4, r5)
            r6.format = r1
            goto L_0x01bc
        L_0x01dc:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r9 != r1) goto L_0x01f1
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r26)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac4Util.parseAc4AnnexEFormat(r0, r1, r4, r5)
            r6.format = r1
            goto L_0x01bc
        L_0x01f1:
            r1 = 1684892784(0x646d6c70, float:1.7518768E22)
            if (r9 != r1) goto L_0x0214
            if (r15 <= 0) goto L_0x01fb
            r7 = r15
            r8 = 2
            goto L_0x0190
        L_0x01fb:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid sample rate for Dolby TrueHD MLP stream: "
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.StringBuilder r0 = r0.append(r15)
            java.lang.String r0 = r0.toString()
            r14 = 0
            com.google.android.exoplayer2.ParserException r0 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r0, r14)
            throw r0
        L_0x0214:
            r14 = 0
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r9 != r1) goto L_0x023f
            com.google.android.exoplayer2.Format$Builder r1 = new com.google.android.exoplayer2.Format$Builder
            r1.<init>()
            com.google.android.exoplayer2.Format$Builder r1 = r1.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setSampleMimeType(r13)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setChannelCount(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setSampleRate(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setDrmInitData(r5)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setLanguage(r4)
            com.google.android.exoplayer2.Format r1 = r1.build()
            r6.format = r1
            goto L_0x01bc
        L_0x023f:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r9 != r1) goto L_0x025d
            int r1 = r11 + -8
            byte[] r9 = opusMagic
            int r14 = r9.length
            int r14 = r14 + r1
            byte[] r14 = java.util.Arrays.copyOf(r9, r14)
            int r2 = r10 + 8
            r0.setPosition(r2)
            int r2 = r9.length
            r0.readBytes(r14, r2, r1)
            java.util.List r21 = com.google.android.exoplayer2.audio.OpusUtil.buildInitializationData(r14)
            goto L_0x0190
        L_0x025d:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r9 != r1) goto L_0x028f
            int r1 = r11 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r9 = 102(0x66, float:1.43E-43)
            r14 = 0
            r2[r14] = r9
            r9 = 76
            r14 = 1
            r2[r14] = r9
            r9 = 97
            r17 = 2
            r2[r17] = r9
            r9 = 3
            r18 = 67
            r2[r9] = r18
            int r9 = r10 + 12
            r0.setPosition(r9)
            r9 = 4
            r0.readBytes(r2, r9, r1)
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.of(r2)
            r16 = r9
            r9 = -1
            goto L_0x0196
        L_0x028f:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r14 = 1
            r16 = 4
            r17 = 2
            if (r9 != r2) goto L_0x02c4
            int r1 = r11 + -12
            byte[] r7 = new byte[r1]
            int r8 = r10 + 12
            r0.setPosition(r8)
            r9 = 0
            r0.readBytes(r7, r9, r1)
            android.util.Pair r1 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAlacAudioSpecificConfig(r7)
            java.lang.Object r8 = r1.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.of(r7)
            r7 = r8
            r18 = r9
            r9 = -1
            r8 = r1
            goto L_0x0304
        L_0x02c4:
            r9 = 0
        L_0x02c5:
            r18 = r9
            r9 = -1
            goto L_0x0304
        L_0x02c9:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r14 = 1
            r16 = 4
            r17 = 2
            r18 = 0
            if (r9 != r1) goto L_0x02d7
            r1 = r10
            goto L_0x02db
        L_0x02d7:
            int r1 = findBoxPosition(r0, r1, r10, r11)
        L_0x02db:
            r9 = -1
            if (r1 == r9) goto L_0x0304
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$EsdsData r19 = parseEsdsFromParent(r0, r1)
            java.lang.String r13 = r19.mimeType
            byte[] r1 = r19.initializationData
            if (r1 == 0) goto L_0x0304
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r13)
            if (r2 == 0) goto L_0x0300
            com.google.android.exoplayer2.audio.AacUtil$Config r2 = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(r1)
            int r7 = r2.sampleRateHz
            int r8 = r2.channelCount
            java.lang.String r2 = r2.codecs
            r20 = r2
        L_0x0300:
            com.google.common.collect.ImmutableList r21 = com.google.common.collect.ImmutableList.of(r1)
        L_0x0304:
            int r10 = r10 + r11
            r1 = r24
            r2 = r25
            r14 = 1634492771(0x616c6163, float:2.7252807E20)
            goto L_0x0161
        L_0x030e:
            com.google.android.exoplayer2.Format r0 = r6.format
            if (r0 != 0) goto L_0x0360
            if (r13 == 0) goto L_0x0360
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            com.google.android.exoplayer2.Format$Builder r0 = r0.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleMimeType(r13)
            r1 = r20
            com.google.android.exoplayer2.Format$Builder r0 = r0.setCodecs(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setChannelCount(r8)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleRate(r7)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setPcmEncoding(r12)
            r1 = r21
            com.google.android.exoplayer2.Format$Builder r0 = r0.setInitializationData(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setDrmInitData(r5)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setLanguage(r4)
            if (r19 == 0) goto L_0x035a
            long r1 = r19.bitrate
            int r1 = com.google.common.primitives.Ints.saturatedCast(r1)
            com.google.android.exoplayer2.Format$Builder r1 = r0.setAverageBitrate(r1)
            long r2 = r19.peakBitrate
            int r2 = com.google.common.primitives.Ints.saturatedCast(r2)
            r1.setPeakBitrate(r2)
        L_0x035a:
            com.google.android.exoplayer2.Format r0 = r0.build()
            r6.format = r0
        L_0x0360:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    private static int findBoxPosition(ParsableByteArray parsableByteArray, int i, int i2, int i3) throws ParserException {
        int position = parsableByteArray.getPosition();
        ExtractorUtil.checkContainerInput(position >= i2, (String) null);
        while (position - i2 < i3) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == i) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static EsdsData parseEsdsFromParent(ParsableByteArray parsableByteArray, int i) {
        parsableByteArray.setPosition(i + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedByte());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if (MimeTypes.AUDIO_MPEG.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return new EsdsData(mimeTypeFromMp4ObjectType, (byte[]) null, -1, -1);
        }
        parsableByteArray.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return new EsdsData(mimeTypeFromMp4ObjectType, bArr, readUnsignedInt2 > 0 ? readUnsignedInt2 : -1, readUnsignedInt > 0 ? readUnsignedInt : -1);
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i < i2) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            ExtractorUtil.checkContainerInput(readInt > 0, "childAtomSize must be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i, int i2) throws ParserException {
        int i3 = i + 8;
        boolean z = false;
        int i4 = -1;
        String str = null;
        Integer num = null;
        int i5 = 0;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i4 = i3;
                i5 = readInt;
            }
            i3 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        ExtractorUtil.checkContainerInput(num != null, "frma atom is mandatory");
        ExtractorUtil.checkContainerInput(i4 != -1, "schi atom is mandatory");
        TrackEncryptionBox parseSchiFromParent = parseSchiFromParent(parsableByteArray, i4, i5, str);
        if (parseSchiFromParent != null) {
            z = true;
        }
        ExtractorUtil.checkContainerInput(z, "tenc atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Util.castNonNull(parseSchiFromParent));
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i, int i2, String str) {
        int i3;
        int i4;
        int i5 = i + 8;
        while (true) {
            byte[] bArr = null;
            if (i5 - i >= i2) {
                return null;
            }
            parsableByteArray.setPosition(i5);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i4 = 0;
                    i3 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i3 = readUnsignedByte & 15;
                    i4 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                }
                boolean z = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i4, i3, bArr);
            }
            i5 += readInt;
        }
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i, int i2) {
        int i3 = i + 8;
        while (i3 - i < i2) {
            parsableByteArray.setPosition(i3);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i3, readInt + i3);
            }
            i3 += readInt;
        }
        return null;
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i = (i << 7) | (readUnsignedByte & 127);
        }
        return i;
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(4, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 4, 0, length);
        if (jArr[0] > j2 || j2 >= jArr[constrainValue] || jArr[constrainValue2] >= j3 || j3 > j) {
            return false;
        }
        return true;
    }

    private AtomParsers() {
    }

    private static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z) throws ParserException {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            ExtractorUtil.checkContainerInput(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long j;
            int i = this.index + 1;
            this.index = i;
            if (i == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i2 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i2;
                this.nextSamplesPerChunkChangeIndex = i2 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    private static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */
        public final int id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i, long j, int i2) {
            this.id = i;
            this.duration = j;
            this.rotationDegrees = i2;
        }
    }

    private static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i];
        }
    }

    private static final class EsdsData {
        /* access modifiers changed from: private */
        public final long bitrate;
        /* access modifiers changed from: private */
        public final byte[] initializationData;
        /* access modifiers changed from: private */
        public final String mimeType;
        /* access modifiers changed from: private */
        public final long peakBitrate;

        public EsdsData(String str, byte[] bArr, long j, long j2) {
            this.mimeType = str;
            this.initializationData = bArr;
            this.bitrate = j;
            this.peakBitrate = j2;
        }
    }

    static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (readUnsignedIntToInt == 0 || readUnsignedIntToInt % pcmFrameSize != 0) {
                    Log.w(AtomParsers.TAG, "Audio sample size mismatch. stsd sample size: " + pcmFrameSize + ", stsz sample size: " + readUnsignedIntToInt);
                    readUnsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        public int readNextSampleSize() {
            int i = this.fixedSampleSize;
            return i == -1 ? this.data.readUnsignedIntToInt() : i;
        }
    }

    static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public int getFixedSampleSize() {
            return -1;
        }

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i = this.fieldSize;
            if (i == 8) {
                return this.data.readUnsignedByte();
            }
            if (i == 16) {
                return this.data.readUnsignedShort();
            }
            int i2 = this.sampleIndex;
            this.sampleIndex = i2 + 1;
            if (i2 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
        }
    }
}
