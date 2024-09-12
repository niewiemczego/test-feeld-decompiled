package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.extractor.ts.PsExtractor;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class FragmentedMp4Extractor implements Extractor {
    private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();
    private static final int EXTRA_TRACKS_BASE_ID = 100;
    public static final ExtractorsFactory FACTORY = new FragmentedMp4Extractor$$ExternalSyntheticLambda1();
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, Ascii.DC4, -94, 68, 108, 66, 124, 100, -115, -12};
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] ceaTrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static boolean shouldParseContainerAtom(int i) {
        return i == 1836019574 || i == 1953653099 || i == 1835297121 || i == 1835626086 || i == 1937007212 || i == 1836019558 || i == 1953653094 || i == 1836475768 || i == 1701082227;
    }

    private static boolean shouldParseLeafAtom(int i) {
        return i == 1751411826 || i == 1835296868 || i == 1836476516 || i == 1936286840 || i == 1937011556 || i == 1937011827 || i == 1668576371 || i == 1937011555 || i == 1937011578 || i == 1937013298 || i == 1937007471 || i == 1668232756 || i == 1937011571 || i == 1952867444 || i == 1952868452 || i == 1953196132 || i == 1953654136 || i == 1953658222 || i == 1886614376 || i == 1935763834 || i == 1935763823 || i == 1936027235 || i == 1970628964 || i == 1935828848 || i == 1936158820 || i == 1701606260 || i == 1835362404 || i == 1701671783;
    }

    /* access modifiers changed from: protected */
    public Track modifyTrack(Track track) {
        return track;
    }

    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    public FragmentedMp4Extractor(int i) {
        this(i, (TimestampAdjuster) null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster2) {
        this(i, timestampAdjuster2, (Track) null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster2, Track track) {
        this(i, timestampAdjuster2, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster2, Track track, List<Format> list) {
        this(i, timestampAdjuster2, track, list, (TrackOutput) null);
    }

    public FragmentedMp4Extractor(int i, TimestampAdjuster timestampAdjuster2, Track track, List<Format> list, TrackOutput trackOutput) {
        this.flags = i;
        this.timestampAdjuster = timestampAdjuster2;
        this.sideloadedTrack = track;
        this.closedCaptionFormats = Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = C.TIME_UNSET;
        this.pendingSeekTimeUs = C.TIME_UNSET;
        this.segmentIndexEarliestPresentationTimeUs = C.TIME_UNSET;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.emsgTrackOutputs = new TrackOutput[0];
        this.ceaTrackOutputs = new TrackOutput[0];
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        enterReadingAtomHeaderState();
        initExtraTracks();
        if (this.sideloadedTrack != null) {
            this.trackBundles.put(0, new TrackBundle(extractorOutput2.track(0, this.sideloadedTrack.type), new TrackSampleTable(this.sideloadedTrack, new long[0], new int[0], 0, new long[0], new int[0], 0), new DefaultSampleValues(0, 0, 0, 0)));
            this.extractorOutput.endTracks();
        }
    }

    public void seek(long j, long j2) {
        int size = this.trackBundles.size();
        for (int i = 0; i < size; i++) {
            this.trackBundles.valueAt(i).resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j2;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i = this.parserState;
            if (i != 0) {
                if (i == 1) {
                    readAtomPayload(extractorInput);
                } else if (i == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j = this.atomSize;
        if (j == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            long position = extractorInput.getPosition() - ((long) this.atomHeaderBytesRead);
            int i = this.atomType;
            if ((i == 1836019558 || i == 1835295092) && !this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                this.haveOutputSeekMap = true;
            }
            if (this.atomType == 1836019558) {
                int size = this.trackBundles.size();
                for (int i2 = 0; i2 < size; i2++) {
                    TrackFragment trackFragment = this.trackBundles.valueAt(i2).fragment;
                    trackFragment.atomPosition = position;
                    trackFragment.auxiliaryDataPosition = position;
                    trackFragment.dataPosition = position;
                }
            }
            int i3 = this.atomType;
            if (i3 == 1835295092) {
                this.currentTrackBundle = null;
                this.endOfMdatPosition = position + this.atomSize;
                this.parserState = 2;
                return true;
            }
            if (shouldParseContainerAtom(i3)) {
                long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position2);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead != 8) {
                    throw ParserException.createForUnsupportedContainerFeature("Leaf atom defines extended atom size (unsupported).");
                } else if (this.atomSize <= 2147483647L) {
                    ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                    System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
                    this.atomData = parsableByteArray;
                    this.parserState = 1;
                } else {
                    throw ParserException.createForUnsupportedContainerFeature("Leaf atom with length > 2147483647 (unsupported).");
                }
            } else if (this.atomSize <= 2147483647L) {
                this.atomData = null;
                this.parserState = 1;
            } else {
                throw ParserException.createForUnsupportedContainerFeature("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw ParserException.createForUnsupportedContainerFeature("Atom size less than header length (unsupported).");
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException {
        int i = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), 8, i);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void processAtomEnded(long j) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
        } else if (leafAtom.type == 1936286840) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
        } else if (leafAtom.type == 1701671783) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        if (containerAtom.type == 1836019574) {
            onMoovContainerAtomRead(containerAtom);
        } else if (containerAtom.type == 1836019558) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z = true;
        int i = 0;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(Atom.TYPE_mvex));
        SparseArray sparseArray = new SparseArray();
        int size = containerAtom2.leafChildren.size();
        long j = -9223372036854775807L;
        for (int i2 = 0; i2 < size; i2++) {
            Atom.LeafAtom leafAtom = containerAtom2.leafChildren.get(i2);
            if (leafAtom.type == 1953654136) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), (DefaultSampleValues) parseTrex.second);
            } else if (leafAtom.type == 1835362404) {
                j = parseMehd(leafAtom.data);
            }
        }
        List<TrackSampleTable> parseTraks = AtomParsers.parseTraks(containerAtom, new GaplessInfoHolder(), j, drmInitDataFromAtoms, (this.flags & 16) != 0, false, new FragmentedMp4Extractor$$ExternalSyntheticLambda0(this));
        int size2 = parseTraks.size();
        if (this.trackBundles.size() == 0) {
            while (i < size2) {
                TrackSampleTable trackSampleTable = parseTraks.get(i);
                Track track = trackSampleTable.track;
                this.trackBundles.put(track.id, new TrackBundle(this.extractorOutput.track(i, track.type), trackSampleTable, getDefaultSampleValues(sparseArray, track.id)));
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i++;
            }
            this.extractorOutput.endTracks();
            return;
        }
        if (this.trackBundles.size() != size2) {
            z = false;
        }
        Assertions.checkState(z);
        while (i < size2) {
            TrackSampleTable trackSampleTable2 = parseTraks.get(i);
            Track track2 = trackSampleTable2.track;
            this.trackBundles.get(track2.id).reset(trackSampleTable2, getDefaultSampleValues(sparseArray, track2.id));
            i++;
        }
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i));
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        parseMoof(containerAtom, this.trackBundles, this.sideloadedTrack != null, this.flags, this.scratchBytes);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i = 0; i < size; i++) {
                this.trackBundles.valueAt(i).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != C.TIME_UNSET) {
            int size2 = this.trackBundles.size();
            for (int i2 = 0; i2 < size2; i2++) {
                this.trackBundles.valueAt(i2).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = C.TIME_UNSET;
        }
    }

    private void initExtraTracks() {
        int i;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.emsgTrackOutputs = trackOutputArr;
        TrackOutput trackOutput = this.additionalEmsgTrackOutput;
        int i2 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i = 1;
        } else {
            i = 0;
        }
        int i3 = 100;
        if ((this.flags & 4) != 0) {
            trackOutputArr[i] = this.extractorOutput.track(100, 5);
            i++;
            i3 = 101;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.emsgTrackOutputs, i);
        this.emsgTrackOutputs = trackOutputArr2;
        for (TrackOutput format : trackOutputArr2) {
            format.format(EMSG_FORMAT);
        }
        this.ceaTrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
        while (i2 < this.ceaTrackOutputs.length) {
            TrackOutput track = this.extractorOutput.track(i3, 3);
            track.format(this.closedCaptionFormats.get(i2));
            this.ceaTrackOutputs[i2] = track;
            i2++;
            i3++;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onEmsgLeafAtomRead(com.google.android.exoplayer2.util.ParsableByteArray r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.emsgTrackOutputs
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.setPosition(r2)
            int r2 = r28.readInt()
            int r2 = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(r2)
            r3 = 1
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0076
            if (r2 == r3) goto L_0x003a
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r3 = "Skipping unsupported emsg version: "
            java.lang.StringBuilder r1 = r1.append(r3)
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            com.google.android.exoplayer2.util.Log.w(r2, r1)
            return
        L_0x003a:
            long r12 = r28.readUnsignedInt()
            long r6 = r28.readUnsignedLongToLong()
            r8 = 1000000(0xf4240, double:4.940656E-318)
            r10 = r12
            long r14 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r6, r8, r10)
            long r6 = r28.readUnsignedInt()
            r8 = 1000(0x3e8, double:4.94E-321)
            long r6 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r6, r8, r10)
            long r8 = r28.readUnsignedInt()
            java.lang.String r2 = r28.readNullTerminatedString()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r10 = r28.readNullTerminatedString()
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            java.lang.String r10 = (java.lang.String) r10
            r20 = r2
            r22 = r6
            r24 = r8
            r21 = r10
            r8 = r4
            goto L_0x00c0
        L_0x0076:
            java.lang.String r2 = r28.readNullTerminatedString()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r6 = r28.readNullTerminatedString()
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            r10 = r6
            java.lang.String r10 = (java.lang.String) r10
            long r6 = r28.readUnsignedInt()
            long r11 = r28.readUnsignedInt()
            r13 = 1000000(0xf4240, double:4.940656E-318)
            r15 = r6
            long r8 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            long r11 = r0.segmentIndexEarliestPresentationTimeUs
            int r13 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r13 == 0) goto L_0x00a5
            long r11 = r11 + r8
            r17 = r11
            goto L_0x00a7
        L_0x00a5:
            r17 = r4
        L_0x00a7:
            long r11 = r28.readUnsignedInt()
            r13 = 1000(0x3e8, double:4.94E-321)
            r15 = r6
            long r6 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            long r11 = r28.readUnsignedInt()
            r20 = r2
            r22 = r6
            r21 = r10
            r24 = r11
            r14 = r17
        L_0x00c0:
            int r2 = r28.bytesLeft()
            byte[] r2 = new byte[r2]
            int r6 = r28.bytesLeft()
            r7 = 0
            r1.readBytes(r2, r7, r6)
            com.google.android.exoplayer2.metadata.emsg.EventMessage r1 = new com.google.android.exoplayer2.metadata.emsg.EventMessage
            r19 = r1
            r26 = r2
            r19.<init>(r20, r21, r22, r24, r26)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = new com.google.android.exoplayer2.util.ParsableByteArray
            com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder r6 = r0.eventMessageEncoder
            byte[] r1 = r6.encode(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.bytesLeft()
            com.google.android.exoplayer2.extractor.TrackOutput[] r6 = r0.emsgTrackOutputs
            int r10 = r6.length
            r11 = r7
        L_0x00ea:
            if (r11 >= r10) goto L_0x00f7
            r12 = r6[r11]
            r2.setPosition(r7)
            r12.sampleData(r2, r1)
            int r11 = r11 + 1
            goto L_0x00ea
        L_0x00f7:
            int r2 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            if (r2 != 0) goto L_0x010b
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.pendingMetadataSampleInfos
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r4 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r4.<init>(r8, r3, r1)
            r2.addLast(r4)
            int r2 = r0.pendingMetadataSampleBytes
            int r2 = r2 + r1
            r0.pendingMetadataSampleBytes = r2
            goto L_0x0142
        L_0x010b:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.pendingMetadataSampleInfos
            boolean r2 = r2.isEmpty()
            if (r2 != 0) goto L_0x0123
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.pendingMetadataSampleInfos
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r14, r7, r1)
            r2.addLast(r3)
            int r2 = r0.pendingMetadataSampleBytes
            int r2 = r2 + r1
            r0.pendingMetadataSampleBytes = r2
            goto L_0x0142
        L_0x0123:
            com.google.android.exoplayer2.util.TimestampAdjuster r2 = r0.timestampAdjuster
            if (r2 == 0) goto L_0x012b
            long r14 = r2.adjustSampleTimestamp(r14)
        L_0x012b:
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.emsgTrackOutputs
            int r3 = r2.length
        L_0x012e:
            if (r7 >= r3) goto L_0x0142
            r16 = r2[r7]
            r19 = 1
            r21 = 0
            r22 = 0
            r17 = r14
            r20 = r1
            r16.sampleMetadata(r17, r19, r20, r21, r22)
            int r7 = r7 + 1
            goto L_0x012e
        L_0x0142:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.onEmsgLeafAtomRead(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i2 = 0; i2 < size; i2++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i2);
            if (containerAtom2.type == 1953653094) {
                parseTraf(containerAtom2, sparseArray, z, i, bArr);
            }
        }
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, boolean z, int i, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd = parseTfhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd))).data, sparseArray, z);
        if (parseTfhd != null) {
            TrackFragment trackFragment = parseTfhd.fragment;
            long j = trackFragment.nextFragmentDecodeTime;
            boolean z2 = trackFragment.nextFragmentDecodeTimeIncludesMoov;
            parseTfhd.resetFragmentInfo();
            boolean unused = parseTfhd.currentlyInFragment = true;
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt);
            if (leafAtomOfType == null || (i & 2) != 0) {
                trackFragment.nextFragmentDecodeTime = j;
                trackFragment.nextFragmentDecodeTimeIncludesMoov = z2;
            } else {
                trackFragment.nextFragmentDecodeTime = parseTfdt(leafAtomOfType.data);
                trackFragment.nextFragmentDecodeTimeIncludesMoov = true;
            }
            parseTruns(containerAtom, parseTfhd, i);
            TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Assertions.checkNotNull(trackFragment.header)).sampleDescriptionIndex);
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
            if (leafAtomOfType2 != null) {
                parseSaiz((TrackEncryptionBox) Assertions.checkNotNull(sampleDescriptionEncryptionBox), leafAtomOfType2.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
            if (leafAtomOfType3 != null) {
                parseSaio(leafAtomOfType3.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
            if (leafAtomOfType4 != null) {
                parseSenc(leafAtomOfType4.data, trackFragment);
            }
            parseSampleGroups(containerAtom, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
            int size = containerAtom.leafChildren.size();
            for (int i2 = 0; i2 < size; i2++) {
                Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i2);
                if (leafAtom.type == 1970628964) {
                    parseUuid(leafAtom.data, trackFragment, bArr);
                }
            }
        }
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < size; i4++) {
            Atom.LeafAtom leafAtom = list.get(i4);
            if (leafAtom.type == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i3 += readUnsignedIntToInt;
                    i2++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i2, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < size; i7++) {
            Atom.LeafAtom leafAtom2 = list.get(i7);
            if (leafAtom2.type == 1953658222) {
                i6 = parseTrun(trackBundle, i5, i, leafAtom2.data, i6);
                i5++;
            }
        }
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i;
        int i2 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        boolean z = true;
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt <= trackFragment.sampleCount) {
            if (readUnsignedByte == 0) {
                boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                i = 0;
                for (int i3 = 0; i3 < readUnsignedIntToInt; i3++) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i += readUnsignedByte2;
                    zArr[i3] = readUnsignedByte2 > i2;
                }
            } else {
                if (readUnsignedByte <= i2) {
                    z = false;
                }
                i = (readUnsignedByte * readUnsignedIntToInt) + 0;
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
            }
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, readUnsignedIntToInt, trackFragment.sampleCount, false);
            if (i > 0) {
                trackFragment.initEncryptionData(i);
                return;
            }
            return;
        }
        throw ParserException.createForMalformedContainer("Saiz sample count " + readUnsignedIntToInt + " is greater than fragment sample count" + trackFragment.sampleCount, (Throwable) null);
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        long j;
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            int parseFullAtomVersion = Atom.parseFullAtomVersion(readInt);
            long j2 = trackFragment.auxiliaryDataPosition;
            if (parseFullAtomVersion == 0) {
                j = parsableByteArray.readUnsignedInt();
            } else {
                j = parsableByteArray.readUnsignedLongToLong();
            }
            trackFragment.auxiliaryDataPosition = j2 + j;
            return;
        }
        throw ParserException.createForMalformedContainer("Unexpected saio entry count: " + readUnsignedIntToInt, (Throwable) null);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [android.util.SparseArray, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle parseTfhd(com.google.android.exoplayer2.util.ParsableByteArray r4, android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle> r5, boolean r6) {
        /*
            r0 = 8
            r4.setPosition(r0)
            int r0 = r4.readInt()
            int r0 = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(r0)
            int r1 = r4.readInt()
            if (r6 == 0) goto L_0x0019
            r6 = 0
            java.lang.Object r5 = r5.valueAt(r6)
            goto L_0x001d
        L_0x0019:
            java.lang.Object r5 = r5.get(r1)
        L_0x001d:
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r5 = (com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle) r5
            if (r5 != 0) goto L_0x0023
            r4 = 0
            return r4
        L_0x0023:
            r6 = r0 & 1
            if (r6 == 0) goto L_0x0033
            long r1 = r4.readUnsignedLongToLong()
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r6 = r5.fragment
            r6.dataPosition = r1
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r6 = r5.fragment
            r6.auxiliaryDataPosition = r1
        L_0x0033:
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r6 = r5.defaultSampleValues
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0040
            int r1 = r4.readInt()
            int r1 = r1 + -1
            goto L_0x0042
        L_0x0040:
            int r1 = r6.sampleDescriptionIndex
        L_0x0042:
            r2 = r0 & 8
            if (r2 == 0) goto L_0x004b
            int r2 = r4.readInt()
            goto L_0x004d
        L_0x004b:
            int r2 = r6.duration
        L_0x004d:
            r3 = r0 & 16
            if (r3 == 0) goto L_0x0056
            int r3 = r4.readInt()
            goto L_0x0058
        L_0x0056:
            int r3 = r6.size
        L_0x0058:
            r0 = r0 & 32
            if (r0 == 0) goto L_0x0061
            int r4 = r4.readInt()
            goto L_0x0063
        L_0x0061:
            int r4 = r6.flags
        L_0x0063:
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r6 = r5.fragment
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r0 = new com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues
            r0.<init>(r1, r2, r3, r4)
            r6.header = r0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.parseTfhd(com.google.android.exoplayer2.util.ParsableByteArray, android.util.SparseArray, boolean):com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle");
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static int parseTrun(TrackBundle trackBundle, int i, int i2, ParsableByteArray parsableByteArray, int i3) throws ParserException {
        boolean z;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        boolean z5;
        int i6;
        TrackBundle trackBundle2 = trackBundle;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        Track track = trackBundle2.moovSampleTable.track;
        TrackFragment trackFragment = trackBundle2.fragment;
        DefaultSampleValues defaultSampleValues = (DefaultSampleValues) Util.castNonNull(trackFragment.header);
        trackFragment.trunLength[i] = parsableByteArray.readUnsignedIntToInt();
        trackFragment.trunDataPosition[i] = trackFragment.dataPosition;
        if ((parseFullAtomFlags & 1) != 0) {
            long[] jArr = trackFragment.trunDataPosition;
            jArr[i] = jArr[i] + ((long) parsableByteArray.readInt());
        }
        boolean z6 = (parseFullAtomFlags & 4) != 0;
        int i7 = defaultSampleValues.flags;
        if (z6) {
            i7 = parsableByteArray.readInt();
        }
        boolean z7 = (parseFullAtomFlags & 256) != 0;
        boolean z8 = (parseFullAtomFlags & 512) != 0;
        boolean z9 = (parseFullAtomFlags & 1024) != 0;
        boolean z10 = (parseFullAtomFlags & 2048) != 0;
        long j = 0;
        if (track.editListDurations != null && track.editListDurations.length == 1 && track.editListDurations[0] == 0) {
            j = ((long[]) Util.castNonNull(track.editListMediaTimes))[0];
        }
        int[] iArr = trackFragment.sampleSizeTable;
        long[] jArr2 = trackFragment.samplePresentationTimesUs;
        boolean[] zArr = trackFragment.sampleIsSyncFrameTable;
        int i8 = i7;
        boolean z11 = track.type == 2 && (i2 & 1) != 0;
        int i9 = i3 + trackFragment.trunLength[i];
        boolean z12 = z11;
        long[] jArr3 = jArr2;
        boolean[] zArr2 = zArr;
        long j2 = track.timescale;
        long j3 = trackFragment.nextFragmentDecodeTime;
        int i10 = i3;
        while (i10 < i9) {
            int checkNonNegative = checkNonNegative(z7 ? parsableByteArray.readInt() : defaultSampleValues.duration);
            if (z8) {
                i4 = parsableByteArray.readInt();
                z = z7;
            } else {
                z = z7;
                i4 = defaultSampleValues.size;
            }
            int checkNonNegative2 = checkNonNegative(i4);
            if (z9) {
                z2 = z6;
                i5 = parsableByteArray.readInt();
            } else if (i10 != 0 || !z6) {
                z2 = z6;
                i5 = defaultSampleValues.flags;
            } else {
                z2 = z6;
                i5 = i8;
            }
            if (z10) {
                z5 = z10;
                z4 = z8;
                z3 = z9;
                i6 = parsableByteArray.readInt();
            } else {
                z5 = z10;
                z4 = z8;
                z3 = z9;
                i6 = 0;
            }
            jArr3[i10] = Util.scaleLargeTimestamp((((long) i6) + j3) - j, 1000000, j2);
            if (!trackFragment.nextFragmentDecodeTimeIncludesMoov) {
                jArr3[i10] = jArr3[i10] + trackBundle2.moovSampleTable.durationUs;
            }
            iArr[i10] = checkNonNegative2;
            zArr2[i10] = ((i5 >> 16) & 1) == 0 && (!z12 || i10 == 0);
            j3 += (long) checkNonNegative;
            i10++;
            trackBundle2 = trackBundle;
            z7 = z;
            z6 = z2;
            z10 = z5;
            z8 = z4;
            z9 = z3;
        }
        trackFragment.nextFragmentDecodeTime = j3;
        return i9;
    }

    private static int checkNonNegative(int i) throws ParserException {
        if (i >= 0) {
            return i;
        }
        throw ParserException.createForMalformedContainer("Unexpected negative value: " + i, (Throwable) null);
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) == 0) {
            boolean z = (parseFullAtomFlags & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == 0) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, trackFragment.sampleCount, false);
            } else if (readUnsignedIntToInt == trackFragment.sampleCount) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z);
                trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                trackFragment.fillEncryptionData(parsableByteArray);
            } else {
                throw ParserException.createForMalformedContainer("Senc sample count " + readUnsignedIntToInt + " is different from fragment sample count" + trackFragment.sampleCount, (Throwable) null);
            }
        } else {
            throw ParserException.createForUnsupportedContainerFeature("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    private static void parseSampleGroups(Atom.ContainerAtom containerAtom, String str, TrackFragment trackFragment) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i = 0; i < containerAtom2.leafChildren.size(); i++) {
            Atom.LeafAtom leafAtom = containerAtom2.leafChildren.get(i);
            ParsableByteArray parsableByteArray3 = leafAtom.data;
            if (leafAtom.type == 1935828848) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (leafAtom.type == 1936158820) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray != null && parsableByteArray2 != null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            parsableByteArray.skipBytes(4);
            if (parseFullAtomVersion == 1) {
                parsableByteArray.skipBytes(4);
            }
            if (parsableByteArray.readInt() == 1) {
                parsableByteArray2.setPosition(8);
                int parseFullAtomVersion2 = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
                parsableByteArray2.skipBytes(4);
                if (parseFullAtomVersion2 == 1) {
                    if (parsableByteArray2.readUnsignedInt() == 0) {
                        throw ParserException.createForUnsupportedContainerFeature("Variable length description in sgpd found (unsupported)");
                    }
                } else if (parseFullAtomVersion2 >= 2) {
                    parsableByteArray2.skipBytes(4);
                }
                if (parsableByteArray2.readUnsignedInt() == 1) {
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    int i2 = (readUnsignedByte & PsExtractor.VIDEO_STREAM_MASK) >> 4;
                    int i3 = readUnsignedByte & 15;
                    boolean z = parsableByteArray2.readUnsignedByte() == 1;
                    if (z) {
                        int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                        byte[] bArr2 = new byte[16];
                        parsableByteArray2.readBytes(bArr2, 0, 16);
                        if (readUnsignedByte2 == 0) {
                            int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                            bArr = new byte[readUnsignedByte3];
                            parsableByteArray2.readBytes(bArr, 0, readUnsignedByte3);
                        }
                        trackFragment2.definesEncryptionData = true;
                        trackFragment2.trackEncryptionBox = new TrackEncryptionBox(z, str, readUnsignedByte2, bArr2, i2, i3, bArr);
                        return;
                    }
                    return;
                }
                throw ParserException.createForUnsupportedContainerFeature("Entry count in sgpd != 1 (unsupported).");
            }
            throw ParserException.createForUnsupportedContainerFeature("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j) throws ParserException {
        long j2;
        long j3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray2.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            j3 = parsableByteArray.readUnsignedInt();
            j2 = parsableByteArray.readUnsignedInt();
        } else {
            j3 = parsableByteArray.readUnsignedLongToLong();
            j2 = parsableByteArray.readUnsignedLongToLong();
        }
        long j4 = j3;
        long j5 = j + j2;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j4, 1000000, readUnsignedInt);
        parsableByteArray2.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j6 = scaleLargeTimestamp;
        long j7 = j4;
        int i = 0;
        long j8 = j7;
        while (i < readUnsignedShort) {
            int readInt = parsableByteArray.readInt();
            if ((readInt & Integer.MIN_VALUE) == 0) {
                long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                iArr[i] = readInt & Integer.MAX_VALUE;
                jArr[i] = j5;
                jArr3[i] = j6;
                long j9 = j8 + readUnsignedInt2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i2 = readUnsignedShort;
                int[] iArr2 = iArr;
                long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j9, 1000000, readUnsignedInt);
                jArr4[i] = scaleLargeTimestamp2 - jArr5[i];
                parsableByteArray2.skipBytes(4);
                j5 += (long) iArr2[i];
                i++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                readUnsignedShort = i2;
                long j10 = scaleLargeTimestamp2;
                j8 = j9;
                j6 = j10;
            } else {
                throw ParserException.createForMalformedContainer("Unhandled indirect reference", (Throwable) null);
            }
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException {
        int size = this.trackBundles.size();
        long j = Long.MAX_VALUE;
        TrackBundle trackBundle = null;
        for (int i = 0; i < size; i++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill && trackFragment.auxiliaryDataPosition < j) {
                j = trackFragment.auxiliaryDataPosition;
                trackBundle = this.trackBundles.valueAt(i);
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.skipFully(position);
            trackBundle.fragment.fillEncryptionData(extractorInput);
            return;
        }
        throw ParserException.createForMalformedContainer("Offset to encryption data was negative.", (Throwable) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readSample(com.google.android.exoplayer2.extractor.ExtractorInput r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r2 = r0.currentTrackBundle
            r3 = 0
            r4 = 0
            if (r2 != 0) goto L_0x0043
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle> r2 = r0.trackBundles
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r2 = getNextTrackBundle(r2)
            if (r2 != 0) goto L_0x002a
            long r5 = r0.endOfMdatPosition
            long r7 = r17.getPosition()
            long r5 = r5 - r7
            int r2 = (int) r5
            if (r2 < 0) goto L_0x0023
            r1.skipFully(r2)
            r16.enterReadingAtomHeaderState()
            return r4
        L_0x0023:
            java.lang.String r1 = "Offset to end of mdat was negative."
            com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r1, r3)
            throw r1
        L_0x002a:
            long r5 = r2.getCurrentSampleOffset()
            long r7 = r17.getPosition()
            long r5 = r5 - r7
            int r5 = (int) r5
            if (r5 >= 0) goto L_0x003e
            java.lang.String r5 = "FragmentedMp4Extractor"
            java.lang.String r6 = "Ignoring negative offset to sample data."
            com.google.android.exoplayer2.util.Log.w(r5, r6)
            r5 = r4
        L_0x003e:
            r1.skipFully(r5)
            r0.currentTrackBundle = r2
        L_0x0043:
            int r5 = r0.parserState
            r6 = 3
            r7 = 4
            r8 = 1
            if (r5 != r6) goto L_0x00bb
            int r5 = r2.getCurrentSampleSize()
            r0.sampleSize = r5
            int r5 = r2.currentSampleIndex
            int r9 = r2.firstSampleToOutputIndex
            if (r5 >= r9) goto L_0x0069
            int r4 = r0.sampleSize
            r1.skipFully(r4)
            r2.skipSampleEncryptionData()
            boolean r1 = r2.next()
            if (r1 != 0) goto L_0x0066
            r0.currentTrackBundle = r3
        L_0x0066:
            r0.parserState = r6
            return r8
        L_0x0069:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r5 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r5 = r5.track
            int r5 = r5.sampleTransformation
            if (r5 != r8) goto L_0x007b
            int r5 = r0.sampleSize
            r9 = 8
            int r5 = r5 - r9
            r0.sampleSize = r5
            r1.skipFully(r9)
        L_0x007b:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r5 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r5 = r5.track
            com.google.android.exoplayer2.Format r5 = r5.format
            java.lang.String r5 = r5.sampleMimeType
            java.lang.String r9 = "audio/ac4"
            boolean r5 = r9.equals(r5)
            if (r5 == 0) goto L_0x00a8
            int r5 = r0.sampleSize
            r9 = 7
            int r5 = r2.outputSampleEncryptionData(r5, r9)
            r0.sampleBytesWritten = r5
            int r5 = r0.sampleSize
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.scratch
            com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(r5, r10)
            com.google.android.exoplayer2.extractor.TrackOutput r5 = r2.output
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.scratch
            r5.sampleData(r10, r9)
            int r5 = r0.sampleBytesWritten
            int r5 = r5 + r9
            r0.sampleBytesWritten = r5
            goto L_0x00b0
        L_0x00a8:
            int r5 = r0.sampleSize
            int r5 = r2.outputSampleEncryptionData(r5, r4)
            r0.sampleBytesWritten = r5
        L_0x00b0:
            int r5 = r0.sampleSize
            int r9 = r0.sampleBytesWritten
            int r5 = r5 + r9
            r0.sampleSize = r5
            r0.parserState = r7
            r0.sampleCurrentNalBytesRemaining = r4
        L_0x00bb:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r5 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r5 = r5.track
            com.google.android.exoplayer2.extractor.TrackOutput r9 = r2.output
            long r10 = r2.getCurrentSamplePresentationTimeUs()
            com.google.android.exoplayer2.util.TimestampAdjuster r12 = r0.timestampAdjuster
            if (r12 == 0) goto L_0x00cd
            long r10 = r12.adjustSampleTimestamp(r10)
        L_0x00cd:
            r14 = r10
            int r10 = r5.nalUnitLengthFieldLength
            if (r10 == 0) goto L_0x019a
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.nalPrefix
            byte[] r10 = r10.getData()
            r10[r4] = r4
            r10[r8] = r4
            r11 = 2
            r10[r11] = r4
            int r11 = r5.nalUnitLengthFieldLength
            int r11 = r11 + r8
            int r12 = r5.nalUnitLengthFieldLength
            int r12 = 4 - r12
        L_0x00e6:
            int r13 = r0.sampleBytesWritten
            int r6 = r0.sampleSize
            if (r13 >= r6) goto L_0x01ab
            int r6 = r0.sampleCurrentNalBytesRemaining
            if (r6 != 0) goto L_0x013d
            r1.readFully(r10, r12, r11)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            r6.setPosition(r4)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            int r6 = r6.readInt()
            if (r6 < r8) goto L_0x0136
            int r6 = r6 + -1
            r0.sampleCurrentNalBytesRemaining = r6
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalStartCode
            r6.setPosition(r4)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalStartCode
            r9.sampleData(r6, r7)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            r9.sampleData(r6, r8)
            com.google.android.exoplayer2.extractor.TrackOutput[] r6 = r0.ceaTrackOutputs
            int r6 = r6.length
            if (r6 <= 0) goto L_0x0126
            com.google.android.exoplayer2.Format r6 = r5.format
            java.lang.String r6 = r6.sampleMimeType
            byte r13 = r10[r7]
            boolean r6 = com.google.android.exoplayer2.util.NalUnitUtil.isNalUnitSei(r6, r13)
            if (r6 == 0) goto L_0x0126
            r6 = r8
            goto L_0x0127
        L_0x0126:
            r6 = r4
        L_0x0127:
            r0.processSeiNalUnitPayload = r6
            int r6 = r0.sampleBytesWritten
            int r6 = r6 + 5
            r0.sampleBytesWritten = r6
            int r6 = r0.sampleSize
            int r6 = r6 + r12
            r0.sampleSize = r6
            r6 = 3
            goto L_0x00e6
        L_0x0136:
            java.lang.String r1 = "Invalid NAL length"
            com.google.android.exoplayer2.ParserException r1 = com.google.android.exoplayer2.ParserException.createForMalformedContainer(r1, r3)
            throw r1
        L_0x013d:
            boolean r13 = r0.processSeiNalUnitPayload
            if (r13 == 0) goto L_0x0186
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            r13.reset((int) r6)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalBuffer
            byte[] r6 = r6.getData()
            int r13 = r0.sampleCurrentNalBytesRemaining
            r1.readFully(r6, r4, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalBuffer
            int r13 = r0.sampleCurrentNalBytesRemaining
            r9.sampleData(r6, r13)
            int r6 = r0.sampleCurrentNalBytesRemaining
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            byte[] r13 = r13.getData()
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r0.nalBuffer
            int r7 = r7.limit()
            int r7 = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(r13, r7)
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            com.google.android.exoplayer2.Format r8 = r5.format
            java.lang.String r8 = r8.sampleMimeType
            java.lang.String r3 = "video/hevc"
            boolean r3 = r3.equals(r8)
            r13.setPosition(r3)
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r0.nalBuffer
            r3.setLimit(r7)
            com.google.android.exoplayer2.util.ParsableByteArray r3 = r0.nalBuffer
            com.google.android.exoplayer2.extractor.TrackOutput[] r7 = r0.ceaTrackOutputs
            com.google.android.exoplayer2.extractor.CeaUtil.consume(r14, r3, r7)
            goto L_0x018a
        L_0x0186:
            int r6 = r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r1, (int) r6, (boolean) r4)
        L_0x018a:
            int r3 = r0.sampleBytesWritten
            int r3 = r3 + r6
            r0.sampleBytesWritten = r3
            int r3 = r0.sampleCurrentNalBytesRemaining
            int r3 = r3 - r6
            r0.sampleCurrentNalBytesRemaining = r3
            r3 = 0
            r6 = 3
            r7 = 4
            r8 = 1
            goto L_0x00e6
        L_0x019a:
            int r3 = r0.sampleBytesWritten
            int r5 = r0.sampleSize
            if (r3 >= r5) goto L_0x01ab
            int r5 = r5 - r3
            int r3 = r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r1, (int) r5, (boolean) r4)
            int r5 = r0.sampleBytesWritten
            int r5 = r5 + r3
            r0.sampleBytesWritten = r5
            goto L_0x019a
        L_0x01ab:
            int r12 = r2.getCurrentSampleFlags()
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r1 = r2.getEncryptionBoxIfEncrypted()
            if (r1 == 0) goto L_0x01b8
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData r1 = r1.cryptoData
            goto L_0x01b9
        L_0x01b8:
            r1 = 0
        L_0x01b9:
            int r13 = r0.sampleSize
            r3 = 0
            r10 = r14
            r4 = r14
            r14 = r3
            r15 = r1
            r9.sampleMetadata(r10, r12, r13, r14, r15)
            r0.outputPendingMetadataSamples(r4)
            boolean r1 = r2.next()
            if (r1 != 0) goto L_0x01cf
            r1 = 0
            r0.currentTrackBundle = r1
        L_0x01cf:
            r1 = 3
            r0.parserState = r1
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.readSample(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    private void outputPendingMetadataSamples(long j) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            long j2 = removeFirst.sampleTimeUs;
            if (removeFirst.sampleTimeIsRelative) {
                j2 += j;
            }
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j2 = timestampAdjuster2.adjustSampleTimestamp(j2);
            }
            for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                sampleMetadata.sampleMetadata(j2, 1, removeFirst.size, this.pendingMetadataSampleBytes, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static TrackBundle getNextTrackBundle(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j = Long.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            TrackBundle valueAt = sparseArray.valueAt(i);
            if ((valueAt.currentlyInFragment || valueAt.currentSampleIndex != valueAt.moovSampleTable.sampleCount) && (!valueAt.currentlyInFragment || valueAt.currentTrackRunIndex != valueAt.fragment.trunCount)) {
                long currentSampleOffset = valueAt.getCurrentSampleOffset();
                if (currentSampleOffset < j) {
                    trackBundle = valueAt;
                    j = currentSampleOffset;
                }
            }
        }
        return trackBundle;
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i = 0; i < size; i++) {
            Atom.LeafAtom leafAtom = list.get(i);
            if (leafAtom.type == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] data = leafAtom.data.getData();
                UUID parseUuid = PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, MimeTypes.VIDEO_MP4, data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static final class MetadataSampleInfo {
        public final boolean sampleTimeIsRelative;
        public final long sampleTimeUs;
        public final int size;

        public MetadataSampleInfo(long j, boolean z, int i) {
            this.sampleTimeUs = j;
            this.sampleTimeIsRelative = z;
            this.size = i;
        }
    }

    private static final class TrackBundle {
        private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        /* access modifiers changed from: private */
        public boolean currentlyInFragment;
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();
        public DefaultSampleValues defaultSampleValues;
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        public int firstSampleToOutputIndex;
        public final TrackFragment fragment = new TrackFragment();
        public TrackSampleTable moovSampleTable;
        public final TrackOutput output;
        public final ParsableByteArray scratch = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues2) {
            this.output = trackOutput;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues2;
            reset(trackSampleTable, defaultSampleValues2);
        }

        public void reset(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues2) {
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues2;
            this.output.format(trackSampleTable.track.format);
            resetFragmentInfo();
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex);
            this.output.format(this.moovSampleTable.track.format.buildUpon().setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }

        public void resetFragmentInfo() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
            this.currentlyInFragment = false;
        }

        public void seek(long j) {
            int i = this.currentSampleIndex;
            while (i < this.fragment.sampleCount && this.fragment.getSamplePresentationTimeUs(i) < j) {
                if (this.fragment.sampleIsSyncFrameTable[i]) {
                    this.firstSampleToOutputIndex = i;
                }
                i++;
            }
        }

        public long getCurrentSamplePresentationTimeUs() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.timestampsUs[this.currentSampleIndex];
            }
            return this.fragment.getSamplePresentationTimeUs(this.currentSampleIndex);
        }

        public long getCurrentSampleOffset() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.offsets[this.currentSampleIndex];
            }
            return this.fragment.trunDataPosition[this.currentTrackRunIndex];
        }

        public int getCurrentSampleSize() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.sizes[this.currentSampleIndex];
            }
            return this.fragment.sampleSizeTable[this.currentSampleIndex];
        }

        public int getCurrentSampleFlags() {
            int i;
            if (!this.currentlyInFragment) {
                i = this.moovSampleTable.flags[this.currentSampleIndex];
            } else {
                i = this.fragment.sampleIsSyncFrameTable[this.currentSampleIndex] ? 1 : 0;
            }
            return getEncryptionBoxIfEncrypted() != null ? i | 1073741824 : i;
        }

        public boolean next() {
            this.currentSampleIndex++;
            if (!this.currentlyInFragment) {
                return false;
            }
            int i = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i;
            int[] iArr = this.fragment.trunLength;
            int i2 = this.currentTrackRunIndex;
            if (i != iArr[i2]) {
                return true;
            }
            this.currentTrackRunIndex = i2 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData(int i, int i2) {
            ParsableByteArray parsableByteArray;
            int i3;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
                i3 = encryptionBoxIfEncrypted.perSampleIvSize;
            } else {
                byte[] bArr = (byte[]) Util.castNonNull(encryptionBoxIfEncrypted.defaultInitializationVector);
                this.defaultInitializationVector.reset(bArr, bArr.length);
                parsableByteArray = this.defaultInitializationVector;
                i3 = bArr.length;
            }
            boolean sampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z = sampleHasSubsampleEncryptionTable || i2 != 0;
            this.encryptionSignalByte.getData()[0] = (byte) ((z ? 128 : 0) | i3);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1, 1);
            this.output.sampleData(parsableByteArray, i3, 1);
            if (!z) {
                return i3 + 1;
            }
            if (!sampleHasSubsampleEncryptionTable) {
                this.scratch.reset(8);
                byte[] data = this.scratch.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i2 >> 8) & 255);
                data[3] = (byte) (i2 & 255);
                data[4] = (byte) ((i >> 24) & 255);
                data[5] = (byte) ((i >> 16) & 255);
                data[6] = (byte) ((i >> 8) & 255);
                data[7] = (byte) (i & 255);
                this.output.sampleData(this.scratch, 8, 1);
                return i3 + 1 + 8;
            }
            ParsableByteArray parsableByteArray2 = this.fragment.sampleEncryptionData;
            int readUnsignedShort = parsableByteArray2.readUnsignedShort();
            parsableByteArray2.skipBytes(-2);
            int i4 = (readUnsignedShort * 6) + 2;
            if (i2 != 0) {
                this.scratch.reset(i4);
                byte[] data2 = this.scratch.getData();
                parsableByteArray2.readBytes(data2, 0, i4);
                int i5 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i2;
                data2[2] = (byte) ((i5 >> 8) & 255);
                data2[3] = (byte) (i5 & 255);
                parsableByteArray2 = this.scratch;
            }
            this.output.sampleData(parsableByteArray2, i4, 1);
            return i3 + 1 + i4;
        }

        public void skipSampleEncryptionData() {
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted != null) {
                ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
                if (encryptionBoxIfEncrypted.perSampleIvSize != 0) {
                    parsableByteArray.skipBytes(encryptionBoxIfEncrypted.perSampleIvSize);
                }
                if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                    parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
                }
            }
        }

        public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            TrackEncryptionBox trackEncryptionBox;
            if (!this.currentlyInFragment) {
                return null;
            }
            int i = ((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex;
            if (this.fragment.trackEncryptionBox != null) {
                trackEncryptionBox = this.fragment.trackEncryptionBox;
            } else {
                trackEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(i);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
                return null;
            }
            return trackEncryptionBox;
        }
    }
}
