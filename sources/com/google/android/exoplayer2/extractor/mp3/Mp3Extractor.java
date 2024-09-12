package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.Id3Peeker;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.id3.Id3Decoder;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.EOFException;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Mp3Extractor implements Extractor {
    public static final ExtractorsFactory FACTORY = new Mp3Extractor$$ExternalSyntheticLambda0();
    public static final int FLAG_DISABLE_ID3_METADATA = 8;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING = 1;
    public static final int FLAG_ENABLE_CONSTANT_BITRATE_SEEKING_ALWAYS = 2;
    public static final int FLAG_ENABLE_INDEX_SEEKING = 4;
    private static final int MAX_SNIFF_BYTES = 32768;
    private static final int MAX_SYNC_BYTES = 131072;
    private static final int MPEG_AUDIO_HEADER_MASK = -128000;
    private static final Id3Decoder.FramePredicate REQUIRED_ID3_FRAME_PREDICATE = new Mp3Extractor$$ExternalSyntheticLambda1();
    private static final int SCRATCH_LENGTH = 10;
    private static final int SEEK_HEADER_INFO = 1231971951;
    private static final int SEEK_HEADER_UNSET = 0;
    private static final int SEEK_HEADER_VBRI = 1447187017;
    private static final int SEEK_HEADER_XING = 1483304551;
    private long basisTimeUs;
    private TrackOutput currentTrackOutput;
    private boolean disableSeeking;
    private ExtractorOutput extractorOutput;
    private long firstSamplePosition;
    private final int flags;
    private final long forcedFirstSampleTimestampUs;
    private final GaplessInfoHolder gaplessInfoHolder;
    private final Id3Peeker id3Peeker;
    private boolean isSeekInProgress;
    private Metadata metadata;
    private TrackOutput realTrackOutput;
    private int sampleBytesRemaining;
    private long samplesRead;
    private final ParsableByteArray scratch;
    private long seekTimeUs;
    private Seeker seeker;
    private final TrackOutput skippingTrackOutput;
    private final MpegAudioUtil.Header synchronizedHeader;
    private int synchronizedHeaderData;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    private static boolean headersMatch(int i, long j) {
        return ((long) (i & MPEG_AUDIO_HEADER_MASK)) == (j & -128000);
    }

    static /* synthetic */ boolean lambda$static$1(int i, int i2, int i3, int i4, int i5) {
        return (i2 == 67 && i3 == 79 && i4 == 77 && (i5 == 77 || i == 2)) || (i2 == 77 && i3 == 76 && i4 == 76 && (i5 == 84 || i == 2));
    }

    public void release() {
    }

    static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp3Extractor()};
    }

    public Mp3Extractor() {
        this(0);
    }

    public Mp3Extractor(int i) {
        this(i, C.TIME_UNSET);
    }

    public Mp3Extractor(int i, long j) {
        this.flags = (i & 2) != 0 ? i | 1 : i;
        this.forcedFirstSampleTimestampUs = j;
        this.scratch = new ParsableByteArray(10);
        this.synchronizedHeader = new MpegAudioUtil.Header();
        this.gaplessInfoHolder = new GaplessInfoHolder();
        this.basisTimeUs = C.TIME_UNSET;
        this.id3Peeker = new Id3Peeker();
        DummyTrackOutput dummyTrackOutput = new DummyTrackOutput();
        this.skippingTrackOutput = dummyTrackOutput;
        this.currentTrackOutput = dummyTrackOutput;
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return synchronize(extractorInput, true);
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        TrackOutput track = extractorOutput2.track(0, 1);
        this.realTrackOutput = track;
        this.currentTrackOutput = track;
        this.extractorOutput.endTracks();
    }

    public void seek(long j, long j2) {
        this.synchronizedHeaderData = 0;
        this.basisTimeUs = C.TIME_UNSET;
        this.samplesRead = 0;
        this.sampleBytesRemaining = 0;
        this.seekTimeUs = j2;
        Seeker seeker2 = this.seeker;
        if ((seeker2 instanceof IndexSeeker) && !((IndexSeeker) seeker2).isTimeUsInIndex(j2)) {
            this.isSeekInProgress = true;
            this.currentTrackOutput = this.skippingTrackOutput;
        }
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        assertInitialized();
        int readInternal = readInternal(extractorInput);
        if (readInternal == -1 && (this.seeker instanceof IndexSeeker)) {
            long computeTimeUs = computeTimeUs(this.samplesRead);
            if (this.seeker.getDurationUs() != computeTimeUs) {
                ((IndexSeeker) this.seeker).setDurationUs(computeTimeUs);
                this.extractorOutput.seekMap(this.seeker);
            }
        }
        return readInternal;
    }

    public void disableSeeking() {
        this.disableSeeking = true;
    }

    @RequiresNonNull({"extractorOutput", "realTrackOutput"})
    private int readInternal(ExtractorInput extractorInput) throws IOException {
        if (this.synchronizedHeaderData == 0) {
            try {
                synchronize(extractorInput, false);
            } catch (EOFException unused) {
                return -1;
            }
        }
        if (this.seeker == null) {
            Seeker computeSeeker = computeSeeker(extractorInput);
            this.seeker = computeSeeker;
            this.extractorOutput.seekMap(computeSeeker);
            this.currentTrackOutput.format(new Format.Builder().setSampleMimeType(this.synchronizedHeader.mimeType).setMaxInputSize(4096).setChannelCount(this.synchronizedHeader.channels).setSampleRate(this.synchronizedHeader.sampleRate).setEncoderDelay(this.gaplessInfoHolder.encoderDelay).setEncoderPadding(this.gaplessInfoHolder.encoderPadding).setMetadata((this.flags & 8) != 0 ? null : this.metadata).build());
            this.firstSamplePosition = extractorInput.getPosition();
        } else if (this.firstSamplePosition != 0) {
            long position = extractorInput.getPosition();
            long j = this.firstSamplePosition;
            if (position < j) {
                extractorInput.skipFully((int) (j - position));
            }
        }
        return readSample(extractorInput);
    }

    @RequiresNonNull({"realTrackOutput", "seeker"})
    private int readSample(ExtractorInput extractorInput) throws IOException {
        if (this.sampleBytesRemaining == 0) {
            extractorInput.resetPeekPosition();
            if (peekEndOfStreamOrHeader(extractorInput)) {
                return -1;
            }
            this.scratch.setPosition(0);
            int readInt = this.scratch.readInt();
            if (!headersMatch(readInt, (long) this.synchronizedHeaderData) || MpegAudioUtil.getFrameSize(readInt) == -1) {
                extractorInput.skipFully(1);
                this.synchronizedHeaderData = 0;
                return 0;
            }
            this.synchronizedHeader.setForHeaderData(readInt);
            if (this.basisTimeUs == C.TIME_UNSET) {
                this.basisTimeUs = this.seeker.getTimeUs(extractorInput.getPosition());
                if (this.forcedFirstSampleTimestampUs != C.TIME_UNSET) {
                    this.basisTimeUs += this.forcedFirstSampleTimestampUs - this.seeker.getTimeUs(0);
                }
            }
            this.sampleBytesRemaining = this.synchronizedHeader.frameSize;
            Seeker seeker2 = this.seeker;
            if (seeker2 instanceof IndexSeeker) {
                IndexSeeker indexSeeker = (IndexSeeker) seeker2;
                indexSeeker.maybeAddSeekPoint(computeTimeUs(this.samplesRead + ((long) this.synchronizedHeader.samplesPerFrame)), extractorInput.getPosition() + ((long) this.synchronizedHeader.frameSize));
                if (this.isSeekInProgress && indexSeeker.isTimeUsInIndex(this.seekTimeUs)) {
                    this.isSeekInProgress = false;
                    this.currentTrackOutput = this.realTrackOutput;
                }
            }
        }
        int sampleData = this.currentTrackOutput.sampleData((DataReader) extractorInput, this.sampleBytesRemaining, true);
        if (sampleData == -1) {
            return -1;
        }
        int i = this.sampleBytesRemaining - sampleData;
        this.sampleBytesRemaining = i;
        if (i > 0) {
            return 0;
        }
        this.currentTrackOutput.sampleMetadata(computeTimeUs(this.samplesRead), 1, this.synchronizedHeader.frameSize, 0, (TrackOutput.CryptoData) null);
        this.samplesRead += (long) this.synchronizedHeader.samplesPerFrame;
        this.sampleBytesRemaining = 0;
        return 0;
    }

    private long computeTimeUs(long j) {
        return this.basisTimeUs + ((j * 1000000) / ((long) this.synchronizedHeader.sampleRate));
    }

    private boolean synchronize(ExtractorInput extractorInput, boolean z) throws IOException {
        int i;
        int i2;
        int frameSize;
        Id3Decoder.FramePredicate framePredicate;
        int i3 = z ? 32768 : 131072;
        extractorInput.resetPeekPosition();
        if (extractorInput.getPosition() == 0) {
            if ((this.flags & 8) == 0) {
                framePredicate = null;
            } else {
                framePredicate = REQUIRED_ID3_FRAME_PREDICATE;
            }
            Metadata peekId3Data = this.id3Peeker.peekId3Data(extractorInput, framePredicate);
            this.metadata = peekId3Data;
            if (peekId3Data != null) {
                this.gaplessInfoHolder.setFromMetadata(peekId3Data);
            }
            i2 = (int) extractorInput.getPeekPosition();
            if (!z) {
                extractorInput.skipFully(i2);
            }
            i = 0;
        } else {
            i2 = 0;
            i = 0;
        }
        int i4 = i;
        int i5 = i4;
        while (true) {
            if (!peekEndOfStreamOrHeader(extractorInput)) {
                this.scratch.setPosition(0);
                int readInt = this.scratch.readInt();
                if ((i == 0 || headersMatch(readInt, (long) i)) && (frameSize = MpegAudioUtil.getFrameSize(readInt)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.synchronizedHeader.setForHeaderData(readInt);
                        i = readInt;
                    }
                    extractorInput.advancePeekPosition(frameSize - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 != i3) {
                        if (z) {
                            extractorInput.resetPeekPosition();
                            extractorInput.advancePeekPosition(i2 + i6);
                        } else {
                            extractorInput.skipFully(1);
                        }
                        i4 = 0;
                        i5 = i6;
                        i = 0;
                    } else if (z) {
                        return false;
                    } else {
                        throw ParserException.createForMalformedContainer("Searched too many bytes.", (Throwable) null);
                    }
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            extractorInput.skipFully(i2 + i5);
        } else {
            extractorInput.resetPeekPosition();
        }
        this.synchronizedHeaderData = i;
        return true;
    }

    private boolean peekEndOfStreamOrHeader(ExtractorInput extractorInput) throws IOException {
        Seeker seeker2 = this.seeker;
        if (seeker2 != null) {
            long dataEndPosition = seeker2.getDataEndPosition();
            if (dataEndPosition != -1 && extractorInput.getPeekPosition() > dataEndPosition - 4) {
                return true;
            }
        }
        try {
            return !extractorInput.peekFully(this.scratch.getData(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: com.google.android.exoplayer2.extractor.mp3.Seeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.google.android.exoplayer2.extractor.mp3.MlltSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: com.google.android.exoplayer2.extractor.mp3.IndexSeeker} */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        if (r0 == null) goto L_0x0053;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        r0 = null;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.google.android.exoplayer2.extractor.mp3.Seeker computeSeeker(com.google.android.exoplayer2.extractor.ExtractorInput r12) throws java.io.IOException {
        /*
            r11 = this;
            com.google.android.exoplayer2.extractor.mp3.Seeker r0 = r11.maybeReadSeekFrame(r12)
            com.google.android.exoplayer2.metadata.Metadata r1 = r11.metadata
            long r2 = r12.getPosition()
            com.google.android.exoplayer2.extractor.mp3.MlltSeeker r1 = maybeHandleSeekMetadata(r1, r2)
            boolean r2 = r11.disableSeeking
            if (r2 == 0) goto L_0x0018
            com.google.android.exoplayer2.extractor.mp3.Seeker$UnseekableSeeker r12 = new com.google.android.exoplayer2.extractor.mp3.Seeker$UnseekableSeeker
            r12.<init>()
            return r12
        L_0x0018:
            r2 = 0
            int r3 = r11.flags
            r3 = r3 & 4
            if (r3 == 0) goto L_0x004c
            r2 = -1
            if (r1 == 0) goto L_0x002e
            long r2 = r1.getDurationUs()
            long r0 = r1.getDataEndPosition()
        L_0x002b:
            r9 = r0
            r5 = r2
            goto L_0x0041
        L_0x002e:
            if (r0 == 0) goto L_0x0039
            long r2 = r0.getDurationUs()
            long r0 = r0.getDataEndPosition()
            goto L_0x002b
        L_0x0039:
            com.google.android.exoplayer2.metadata.Metadata r0 = r11.metadata
            long r0 = getId3TlenUs(r0)
            r5 = r0
            r9 = r2
        L_0x0041:
            com.google.android.exoplayer2.extractor.mp3.IndexSeeker r0 = new com.google.android.exoplayer2.extractor.mp3.IndexSeeker
            long r7 = r12.getPosition()
            r4 = r0
            r4.<init>(r5, r7, r9)
            goto L_0x0054
        L_0x004c:
            if (r1 == 0) goto L_0x0050
            r0 = r1
            goto L_0x0054
        L_0x0050:
            if (r0 == 0) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r0 = r2
        L_0x0054:
            r1 = 1
            if (r0 == 0) goto L_0x0062
            boolean r2 = r0.isSeekable()
            if (r2 != 0) goto L_0x006e
            int r2 = r11.flags
            r2 = r2 & r1
            if (r2 == 0) goto L_0x006e
        L_0x0062:
            int r0 = r11.flags
            r0 = r0 & 2
            if (r0 == 0) goto L_0x0069
            goto L_0x006a
        L_0x0069:
            r1 = 0
        L_0x006a:
            com.google.android.exoplayer2.extractor.mp3.Seeker r0 = r11.getConstantBitrateSeeker(r12, r1)
        L_0x006e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp3.Mp3Extractor.computeSeeker(com.google.android.exoplayer2.extractor.ExtractorInput):com.google.android.exoplayer2.extractor.mp3.Seeker");
    }

    private Seeker maybeReadSeekFrame(ExtractorInput extractorInput) throws IOException {
        ParsableByteArray parsableByteArray = new ParsableByteArray(this.synchronizedHeader.frameSize);
        extractorInput.peekFully(parsableByteArray.getData(), 0, this.synchronizedHeader.frameSize);
        int i = 21;
        if ((this.synchronizedHeader.version & 1) != 0) {
            if (this.synchronizedHeader.channels != 1) {
                i = 36;
            }
        } else if (this.synchronizedHeader.channels == 1) {
            i = 13;
        }
        int i2 = i;
        int seekFrameHeader = getSeekFrameHeader(parsableByteArray, i2);
        if (seekFrameHeader == SEEK_HEADER_XING || seekFrameHeader == SEEK_HEADER_INFO) {
            XingSeeker create = XingSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            if (create != null && !this.gaplessInfoHolder.hasGaplessInfo()) {
                extractorInput.resetPeekPosition();
                extractorInput.advancePeekPosition(i2 + 141);
                extractorInput.peekFully(this.scratch.getData(), 0, 3);
                this.scratch.setPosition(0);
                this.gaplessInfoHolder.setFromXingHeaderValue(this.scratch.readUnsignedInt24());
            }
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return (create == null || create.isSeekable() || seekFrameHeader != SEEK_HEADER_INFO) ? create : getConstantBitrateSeeker(extractorInput, false);
        } else if (seekFrameHeader == SEEK_HEADER_VBRI) {
            VbriSeeker create2 = VbriSeeker.create(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, parsableByteArray);
            extractorInput.skipFully(this.synchronizedHeader.frameSize);
            return create2;
        } else {
            extractorInput.resetPeekPosition();
            return null;
        }
    }

    private Seeker getConstantBitrateSeeker(ExtractorInput extractorInput, boolean z) throws IOException {
        extractorInput.peekFully(this.scratch.getData(), 0, 4);
        this.scratch.setPosition(0);
        this.synchronizedHeader.setForHeaderData(this.scratch.readInt());
        return new ConstantBitrateSeeker(extractorInput.getLength(), extractorInput.getPosition(), this.synchronizedHeader, z);
    }

    @EnsuresNonNull({"extractorOutput", "realTrackOutput"})
    private void assertInitialized() {
        Assertions.checkStateNotNull(this.realTrackOutput);
        Util.castNonNull(this.extractorOutput);
    }

    private static int getSeekFrameHeader(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.limit() >= i + 4) {
            parsableByteArray.setPosition(i);
            int readInt = parsableByteArray.readInt();
            if (readInt == SEEK_HEADER_XING || readInt == SEEK_HEADER_INFO) {
                return readInt;
            }
        }
        if (parsableByteArray.limit() < 40) {
            return 0;
        }
        parsableByteArray.setPosition(36);
        if (parsableByteArray.readInt() == SEEK_HEADER_VBRI) {
            return SEEK_HEADER_VBRI;
        }
        return 0;
    }

    private static MlltSeeker maybeHandleSeekMetadata(Metadata metadata2, long j) {
        if (metadata2 == null) {
            return null;
        }
        int length = metadata2.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata2.get(i);
            if (entry instanceof MlltFrame) {
                return MlltSeeker.create(j, (MlltFrame) entry, getId3TlenUs(metadata2));
            }
        }
        return null;
    }

    private static long getId3TlenUs(Metadata metadata2) {
        if (metadata2 == null) {
            return C.TIME_UNSET;
        }
        int length = metadata2.length();
        for (int i = 0; i < length; i++) {
            Metadata.Entry entry = metadata2.get(i);
            if (entry instanceof TextInformationFrame) {
                TextInformationFrame textInformationFrame = (TextInformationFrame) entry;
                if (textInformationFrame.id.equals("TLEN")) {
                    return Util.msToUs(Long.parseLong(textInformationFrame.value));
                }
            }
        }
        return C.TIME_UNSET;
    }
}
