package com.google.android.exoplayer2.source.chunk;

import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public final class BundledChunkExtractor implements ExtractorOutput, ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new BundledChunkExtractor$$ExternalSyntheticLambda0();
    private static final PositionHolder POSITION_HOLDER = new PositionHolder();
    private final SparseArray<BindingTrackOutput> bindingTrackOutputs = new SparseArray<>();
    private long endTimeUs;
    private final Extractor extractor;
    private boolean extractorInitialized;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private Format[] sampleFormats;
    private SeekMap seekMap;
    private ChunkExtractor.TrackOutputProvider trackOutputProvider;

    /* JADX WARNING: type inference failed for: r8v3, types: [com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ com.google.android.exoplayer2.source.chunk.ChunkExtractor lambda$static$0(int r6, com.google.android.exoplayer2.Format r7, boolean r8, java.util.List r9, com.google.android.exoplayer2.extractor.TrackOutput r10, com.google.android.exoplayer2.analytics.PlayerId r11) {
        /*
            java.lang.String r11 = r7.containerMimeType
            boolean r0 = com.google.android.exoplayer2.util.MimeTypes.isText(r11)
            if (r0 == 0) goto L_0x000a
            r6 = 0
            return r6
        L_0x000a:
            boolean r11 = com.google.android.exoplayer2.util.MimeTypes.isMatroska(r11)
            if (r11 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor r8 = new com.google.android.exoplayer2.extractor.mkv.MatroskaExtractor
            r9 = 1
            r8.<init>(r9)
            goto L_0x0026
        L_0x0017:
            r11 = 0
            if (r8 == 0) goto L_0x001b
            r11 = 4
        L_0x001b:
            r1 = r11
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor r8 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor
            r2 = 0
            r3 = 0
            r0 = r8
            r4 = r9
            r5 = r10
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x0026:
            com.google.android.exoplayer2.source.chunk.BundledChunkExtractor r9 = new com.google.android.exoplayer2.source.chunk.BundledChunkExtractor
            r9.<init>(r8, r6, r7)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.chunk.BundledChunkExtractor.lambda$static$0(int, com.google.android.exoplayer2.Format, boolean, java.util.List, com.google.android.exoplayer2.extractor.TrackOutput, com.google.android.exoplayer2.analytics.PlayerId):com.google.android.exoplayer2.source.chunk.ChunkExtractor");
    }

    public BundledChunkExtractor(Extractor extractor2, int i, Format format) {
        this.extractor = extractor2;
        this.primaryTrackType = i;
        this.primaryTrackManifestFormat = format;
    }

    public ChunkIndex getChunkIndex() {
        SeekMap seekMap2 = this.seekMap;
        if (seekMap2 instanceof ChunkIndex) {
            return (ChunkIndex) seekMap2;
        }
        return null;
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j, long j2) {
        this.trackOutputProvider = trackOutputProvider2;
        this.endTimeUs = j2;
        if (!this.extractorInitialized) {
            this.extractor.init(this);
            if (j != C.TIME_UNSET) {
                this.extractor.seek(0, j);
            }
            this.extractorInitialized = true;
            return;
        }
        Extractor extractor2 = this.extractor;
        if (j == C.TIME_UNSET) {
            j = 0;
        }
        extractor2.seek(0, j);
        for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
            this.bindingTrackOutputs.valueAt(i).bind(trackOutputProvider2, j2);
        }
    }

    public void release() {
        this.extractor.release();
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        int read = this.extractor.read(extractorInput, POSITION_HOLDER);
        Assertions.checkState(read != 1);
        if (read == 0) {
            return true;
        }
        return false;
    }

    public TrackOutput track(int i, int i2) {
        BindingTrackOutput bindingTrackOutput = this.bindingTrackOutputs.get(i);
        if (bindingTrackOutput == null) {
            Assertions.checkState(this.sampleFormats == null);
            bindingTrackOutput = new BindingTrackOutput(i, i2, i2 == this.primaryTrackType ? this.primaryTrackManifestFormat : null);
            bindingTrackOutput.bind(this.trackOutputProvider, this.endTimeUs);
            this.bindingTrackOutputs.put(i, bindingTrackOutput);
        }
        return bindingTrackOutput;
    }

    public void endTracks() {
        Format[] formatArr = new Format[this.bindingTrackOutputs.size()];
        for (int i = 0; i < this.bindingTrackOutputs.size(); i++) {
            formatArr[i] = (Format) Assertions.checkStateNotNull(this.bindingTrackOutputs.valueAt(i).sampleFormat);
        }
        this.sampleFormats = formatArr;
    }

    public void seekMap(SeekMap seekMap2) {
        this.seekMap = seekMap2;
    }

    private static final class BindingTrackOutput implements TrackOutput {
        private long endTimeUs;
        private final DummyTrackOutput fakeTrackOutput = new DummyTrackOutput();
        private final int id;
        private final Format manifestFormat;
        public Format sampleFormat;
        private TrackOutput trackOutput;
        private final int type;

        public BindingTrackOutput(int i, int i2, Format format) {
            this.id = i;
            this.type = i2;
            this.manifestFormat = format;
        }

        public void bind(ChunkExtractor.TrackOutputProvider trackOutputProvider, long j) {
            if (trackOutputProvider == null) {
                this.trackOutput = this.fakeTrackOutput;
                return;
            }
            this.endTimeUs = j;
            TrackOutput track = trackOutputProvider.track(this.id, this.type);
            this.trackOutput = track;
            Format format = this.sampleFormat;
            if (format != null) {
                track.format(format);
            }
        }

        public void format(Format format) {
            Format format2 = this.manifestFormat;
            if (format2 != null) {
                format = format.withManifestFormatInfo(format2);
            }
            this.sampleFormat = format;
            ((TrackOutput) Util.castNonNull(this.trackOutput)).format(this.sampleFormat);
        }

        public int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
            return ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(dataReader, i, z);
        }

        public void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleData(parsableByteArray, i);
        }

        public void sampleMetadata(long j, int i, int i2, int i3, TrackOutput.CryptoData cryptoData) {
            long j2 = this.endTimeUs;
            if (j2 != C.TIME_UNSET && j >= j2) {
                this.trackOutput = this.fakeTrackOutput;
            }
            ((TrackOutput) Util.castNonNull(this.trackOutput)).sampleMetadata(j, i, i2, i3, cryptoData);
        }
    }
}
