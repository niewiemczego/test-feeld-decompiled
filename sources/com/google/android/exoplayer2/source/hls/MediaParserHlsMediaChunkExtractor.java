package com.google.android.exoplayer2.source.hls;

import android.media.MediaFormat;
import android.media.MediaParser;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.source.mediaparser.InputReaderAdapterV30;
import com.google.android.exoplayer2.source.mediaparser.MediaParserUtil;
import com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public final class MediaParserHlsMediaChunkExtractor implements HlsMediaChunkExtractor {
    public static final HlsExtractorFactory FACTORY = new MediaParserHlsMediaChunkExtractor$$ExternalSyntheticLambda0();
    private final Format format;
    private final InputReaderAdapterV30 inputReaderAdapter = new InputReaderAdapterV30();
    private final MediaParser mediaParser;
    private final ImmutableList<MediaFormat> muxedCaptionMediaFormats;
    private final OutputConsumerAdapterV30 outputConsumerAdapter;
    private final boolean overrideInBandCaptionDeclarations;
    private int pendingSkipBytes;
    private final PlayerId playerId;

    static /* synthetic */ HlsMediaChunkExtractor lambda$static$0(Uri uri, Format format2, List list, TimestampAdjuster timestampAdjuster, Map map, ExtractorInput extractorInput, PlayerId playerId2) throws IOException {
        if (FileTypes.inferFileTypeFromMimeType(format2.sampleMimeType) == 13) {
            return new BundledHlsMediaChunkExtractor(new WebvttExtractor(format2.language, timestampAdjuster), format2, timestampAdjuster);
        }
        boolean z = list != null;
        ImmutableList.Builder builder = ImmutableList.builder();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                builder.add((Object) MediaParserUtil.toCaptionsMediaFormat((Format) list.get(i)));
            }
        } else {
            builder.add((Object) MediaParserUtil.toCaptionsMediaFormat(new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_CEA608).build()));
        }
        ImmutableList build = builder.build();
        OutputConsumerAdapterV30 outputConsumerAdapterV30 = new OutputConsumerAdapterV30();
        if (list == null) {
            list = ImmutableList.of();
        }
        outputConsumerAdapterV30.setMuxedCaptionFormats(list);
        outputConsumerAdapterV30.setTimestampAdjuster(timestampAdjuster);
        MediaParser createMediaParserInstance = createMediaParserInstance(outputConsumerAdapterV30, format2, z, build, playerId2, "android.media.mediaparser.FragmentedMp4Parser", "android.media.mediaparser.Ac3Parser", "android.media.mediaparser.Ac4Parser", "android.media.mediaparser.AdtsParser", "android.media.mediaparser.Mp3Parser", "android.media.mediaparser.TsParser");
        PeekingInputReader peekingInputReader = new PeekingInputReader(extractorInput);
        createMediaParserInstance.advance(peekingInputReader);
        outputConsumerAdapterV30.setSelectedParserName(createMediaParserInstance.getParserName());
        return new MediaParserHlsMediaChunkExtractor(createMediaParserInstance, outputConsumerAdapterV30, format2, z, build, peekingInputReader.totalPeekedBytes, playerId2);
    }

    public MediaParserHlsMediaChunkExtractor(MediaParser mediaParser2, OutputConsumerAdapterV30 outputConsumerAdapterV30, Format format2, boolean z, ImmutableList<MediaFormat> immutableList, int i, PlayerId playerId2) {
        this.mediaParser = mediaParser2;
        this.outputConsumerAdapter = outputConsumerAdapterV30;
        this.overrideInBandCaptionDeclarations = z;
        this.muxedCaptionMediaFormats = immutableList;
        this.format = format2;
        this.playerId = playerId2;
        this.pendingSkipBytes = i;
    }

    public void init(ExtractorOutput extractorOutput) {
        this.outputConsumerAdapter.setExtractorOutput(extractorOutput);
    }

    public boolean read(ExtractorInput extractorInput) throws IOException {
        extractorInput.skipFully(this.pendingSkipBytes);
        this.pendingSkipBytes = 0;
        this.inputReaderAdapter.setDataReader(extractorInput, extractorInput.getLength());
        return this.mediaParser.advance(this.inputReaderAdapter);
    }

    public boolean isPackedAudioExtractor() {
        String parserName = this.mediaParser.getParserName();
        return "android.media.mediaparser.Ac3Parser".equals(parserName) || "android.media.mediaparser.Ac4Parser".equals(parserName) || "android.media.mediaparser.AdtsParser".equals(parserName) || "android.media.mediaparser.Mp3Parser".equals(parserName);
    }

    public boolean isReusable() {
        String parserName = this.mediaParser.getParserName();
        return "android.media.mediaparser.FragmentedMp4Parser".equals(parserName) || "android.media.mediaparser.TsParser".equals(parserName);
    }

    public HlsMediaChunkExtractor recreate() {
        Assertions.checkState(!isReusable());
        return new MediaParserHlsMediaChunkExtractor(createMediaParserInstance(this.outputConsumerAdapter, this.format, this.overrideInBandCaptionDeclarations, this.muxedCaptionMediaFormats, this.playerId, this.mediaParser.getParserName()), this.outputConsumerAdapter, this.format, this.overrideInBandCaptionDeclarations, this.muxedCaptionMediaFormats, 0, this.playerId);
    }

    public void onTruncatedSegmentParsed() {
        this.mediaParser.seek(MediaParser.SeekPoint.START);
    }

    private static MediaParser createMediaParserInstance(MediaParser.OutputConsumer outputConsumer, Format format2, boolean z, ImmutableList<MediaFormat> immutableList, PlayerId playerId2, String... strArr) {
        MediaParser mediaParser2;
        if (strArr.length == 1) {
            mediaParser2 = MediaParser.createByName(strArr[0], outputConsumer);
        } else {
            mediaParser2 = MediaParser.create(outputConsumer, strArr);
        }
        mediaParser2.setParameter(MediaParserUtil.PARAMETER_EXPOSE_CAPTION_FORMATS, immutableList);
        mediaParser2.setParameter(MediaParserUtil.PARAMETER_OVERRIDE_IN_BAND_CAPTION_DECLARATIONS, Boolean.valueOf(z));
        mediaParser2.setParameter(MediaParserUtil.PARAMETER_IN_BAND_CRYPTO_INFO, true);
        mediaParser2.setParameter(MediaParserUtil.PARAMETER_EAGERLY_EXPOSE_TRACK_TYPE, true);
        mediaParser2.setParameter(MediaParserUtil.PARAMETER_IGNORE_TIMESTAMP_OFFSET, true);
        mediaParser2.setParameter("android.media.mediaparser.ts.ignoreSpliceInfoStream", true);
        mediaParser2.setParameter("android.media.mediaparser.ts.mode", "hls");
        String str = format2.codecs;
        if (!TextUtils.isEmpty(str)) {
            if (!MimeTypes.AUDIO_AAC.equals(MimeTypes.getAudioMediaMimeType(str))) {
                mediaParser2.setParameter("android.media.mediaparser.ts.ignoreAacStream", true);
            }
            if (!MimeTypes.VIDEO_H264.equals(MimeTypes.getVideoMediaMimeType(str))) {
                mediaParser2.setParameter("android.media.mediaparser.ts.ignoreAvcStream", true);
            }
        }
        if (Util.SDK_INT >= 31) {
            MediaParserUtil.setLogSessionIdOnMediaParser(mediaParser2, playerId2);
        }
        return mediaParser2;
    }

    private static final class PeekingInputReader implements MediaParser.SeekableInputReader {
        private final ExtractorInput extractorInput;
        /* access modifiers changed from: private */
        public int totalPeekedBytes;

        private PeekingInputReader(ExtractorInput extractorInput2) {
            this.extractorInput = extractorInput2;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int peek = this.extractorInput.peek(bArr, i, i2);
            this.totalPeekedBytes += peek;
            return peek;
        }

        public long getPosition() {
            return this.extractorInput.getPeekPosition();
        }

        public long getLength() {
            return this.extractorInput.getLength();
        }

        public void seekToPosition(long j) {
            throw new UnsupportedOperationException();
        }
    }
}
