package com.google.android.exoplayer2.source.chunk;

import android.media.MediaParser;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyTrackOutput;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.chunk.ChunkExtractor;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class MediaParserChunkExtractor implements ChunkExtractor {
    public static final ChunkExtractor.Factory FACTORY = new MediaParserChunkExtractor$$ExternalSyntheticLambda0();
    private static final String TAG = "MediaPrsrChunkExtractor";
    /* access modifiers changed from: private */
    public final DummyTrackOutput dummyTrackOutput;
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    /* access modifiers changed from: private */
    public final OutputConsumerAdapterV30 outputConsumerAdapter;
    private long pendingSeekUs;
    /* access modifiers changed from: private */
    public Format[] sampleFormats;
    /* access modifiers changed from: private */
    public ChunkExtractor.TrackOutputProvider trackOutputProvider;
    private final TrackOutputProviderAdapter trackOutputProviderAdapter;

    static /* synthetic */ ChunkExtractor lambda$static$0(int i, Format format, boolean z, List list, TrackOutput trackOutput, PlayerId playerId) {
        if (!MimeTypes.isText(format.containerMimeType)) {
            return new MediaParserChunkExtractor(i, format, list, playerId);
        }
        Log.w(TAG, "Ignoring an unsupported text track.");
        return null;
    }

    public MediaParserChunkExtractor(int i, Format format, List<Format> list, PlayerId playerId) {
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30(format, i, true);
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        String str = MimeTypes.isMatroska((String) Assertions.checkNotNull(format.containerMimeType)) ? "android.media.mediaparser.MatroskaParser" : "android.media.mediaparser.FragmentedMp4Parser";
        outputConsumerAdapterV30.setSelectedParserName(str);
        MediaParser createByName = MediaParser.createByName(str, outputConsumerAdapterV30);
        this.mediaParser = createByName;
        createByName.setParameter("android.media.mediaparser.matroska.disableCuesSeeking", true);
        createByName.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, true);
        createByName.setParameter(MediaParserUtil.PARAMETER_INCLUDE_SUPPLEMENTAL_DATA, true);
        createByName.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, true);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_DUMMY_SEEK_MAP, true);
        createByName.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CHUNK_INDEX_AS_MEDIA_FORMAT, true);
        createByName.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, true);
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(MediaParserUtil.toCaptionsMediaFormat(list.get(i2)));
        }
        this.mediaParser.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, arrayList);
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(this.mediaParser, playerId);
        }
        this.outputConsumerAdapter.setMuxedCaptionFormats(list);
        this.trackOutputProviderAdapter = new TrackOutputProviderAdapter();
        this.dummyTrackOutput = new DummyTrackOutput();
        this.pendingSeekUs = C.TIME_UNSET;
    }

    public void init(ChunkExtractor.TrackOutputProvider trackOutputProvider2, long j, long j2) {
        this.trackOutputProvider = trackOutputProvider2;
        this.outputConsumerAdapter.setSampleTimestampUpperLimitFilterUs(j2);
        this.outputConsumerAdapter.setExtractorOutput(this.trackOutputProviderAdapter);
        this.pendingSeekUs = j;
    }

    public void release() {
        this.mediaParser.release();
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        maybeExecutePendingSeek();
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    public ChunkIndex getChunkIndex() {
        return this.outputConsumerAdapter.getChunkIndex();
    }

    public Format[] getSampleFormats() {
        return this.sampleFormats;
    }

    private void maybeExecutePendingSeek() {
        MediaParser.SeekMap dummySeekMap = this.outputConsumerAdapter.getDummySeekMap();
        long j = this.pendingSeekUs;
        if (j != C.TIME_UNSET && dummySeekMap != null) {
            this.mediaParser.seek((MediaParser.SeekPoint) dummySeekMap.getSeekPoints(j).first);
            this.pendingSeekUs = C.TIME_UNSET;
        }
    }

    private class TrackOutputProviderAdapter implements ExtractorOutput {
        public void seekMap(SeekMap seekMap) {
        }

        private TrackOutputProviderAdapter() {
        }

        public TrackOutput track(int i, int i2) {
            return MediaParserChunkExtractor.this.trackOutputProvider != null ? MediaParserChunkExtractor.this.trackOutputProvider.track(i, i2) : MediaParserChunkExtractor.this.dummyTrackOutput;
        }

        public void endTracks() {
            MediaParserChunkExtractor mediaParserChunkExtractor = MediaParserChunkExtractor.this;
            Format[] unused = mediaParserChunkExtractor.sampleFormats = mediaParserChunkExtractor.outputConsumerAdapter.getSampleFormats();
        }
    }
}
