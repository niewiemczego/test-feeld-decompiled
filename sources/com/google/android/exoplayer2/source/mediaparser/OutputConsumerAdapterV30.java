package com.google.android.exoplayer2.source.mediaparser;

import android.media.DrmInitData;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaParser;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.DummyExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.ColorInfo;
import com.google.common.collect.ImmutableList;
import io.sentry.protocol.Device;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.CharUtils;

public final class OutputConsumerAdapterV30 implements MediaParser.OutputConsumer {
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS = "chunk-index-long-us-durations";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS = "chunk-index-long-offsets";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES = "chunk-index-int-sizes";
    private static final String MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES = "chunk-index-long-us-times";
    private static final String MEDIA_FORMAT_KEY_TRACK_TYPE = "track-type-string";
    private static final Pattern REGEX_CRYPTO_INFO_PATTERN = Pattern.compile("pattern \\(encrypt: (\\d+), skip: (\\d+)\\)");
    private static final Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> SEEK_POINT_PAIR_START = Pair.create(MediaParser.SeekPoint.START, MediaParser.SeekPoint.START);
    private static final String TAG = "OConsumerAdapterV30";
    private String containerMimeType;
    private MediaParser.SeekMap dummySeekMap;
    private final boolean expectDummySeekMap;
    private ExtractorOutput extractorOutput;
    private ChunkIndex lastChunkIndex;
    private final ArrayList<TrackOutput.CryptoData> lastOutputCryptoDatas;
    private final ArrayList<MediaCodec.CryptoInfo> lastReceivedCryptoInfos;
    private MediaParser.SeekMap lastSeekMap;
    private List<Format> muxedCaptionFormats;
    private int primaryTrackIndex;
    private final Format primaryTrackManifestFormat;
    private final int primaryTrackType;
    private long sampleTimestampUpperLimitFilterUs;
    private final DataReaderAdapter scratchDataReaderAdapter;
    private boolean seekingDisabled;
    private TimestampAdjuster timestampAdjuster;
    private final ArrayList<Format> trackFormats;
    private final ArrayList<TrackOutput> trackOutputs;
    private boolean tracksEnded;
    private boolean tracksFoundCalled;

    public OutputConsumerAdapterV30() {
        this((Format) null, -2, false);
    }

    public OutputConsumerAdapterV30(Format format, int i, boolean z) {
        this.expectDummySeekMap = z;
        this.primaryTrackManifestFormat = format;
        this.primaryTrackType = i;
        this.trackOutputs = new ArrayList<>();
        this.trackFormats = new ArrayList<>();
        this.lastReceivedCryptoInfos = new ArrayList<>();
        this.lastOutputCryptoDatas = new ArrayList<>();
        this.scratchDataReaderAdapter = new DataReaderAdapter();
        this.extractorOutput = new DummyExtractorOutput();
        this.sampleTimestampUpperLimitFilterUs = C.TIME_UNSET;
        this.muxedCaptionFormats = ImmutableList.of();
    }

    public void setSampleTimestampUpperLimitFilterUs(long j) {
        this.sampleTimestampUpperLimitFilterUs = j;
    }

    public void setTimestampAdjuster(TimestampAdjuster timestampAdjuster2) {
        this.timestampAdjuster = timestampAdjuster2;
    }

    public void setExtractorOutput(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public void setMuxedCaptionFormats(List<Format> list) {
        this.muxedCaptionFormats = list;
    }

    public void disableSeeking() {
        this.seekingDisabled = true;
    }

    public MediaParser.SeekMap getDummySeekMap() {
        return this.dummySeekMap;
    }

    public ChunkIndex getChunkIndex() {
        return this.lastChunkIndex;
    }

    public Pair<MediaParser.SeekPoint, MediaParser.SeekPoint> getSeekPoints(long j) {
        MediaParser.SeekMap seekMap = this.lastSeekMap;
        return seekMap != null ? seekMap.getSeekPoints(j) : SEEK_POINT_PAIR_START;
    }

    public void setSelectedParserName(String str) {
        this.containerMimeType = getMimeType(str);
    }

    public Format[] getSampleFormats() {
        if (!this.tracksFoundCalled) {
            return null;
        }
        Format[] formatArr = new Format[this.trackFormats.size()];
        for (int i = 0; i < this.trackFormats.size(); i++) {
            formatArr[i] = (Format) Assertions.checkNotNull(this.trackFormats.get(i));
        }
        return formatArr;
    }

    public void onTrackCountFound(int i) {
        this.tracksFoundCalled = true;
        maybeEndTracks();
    }

    public void onSeekMapFound(MediaParser.SeekMap seekMap) {
        SeekMap seekMap2;
        if (!this.expectDummySeekMap || this.dummySeekMap != null) {
            this.lastSeekMap = seekMap;
            long durationMicros = seekMap.getDurationMicros();
            ExtractorOutput extractorOutput2 = this.extractorOutput;
            if (this.seekingDisabled) {
                if (durationMicros == -2147483648L) {
                    durationMicros = C.TIME_UNSET;
                }
                seekMap2 = new SeekMap.Unseekable(durationMicros);
            } else {
                seekMap2 = new SeekMapAdapter(seekMap);
            }
            extractorOutput2.seekMap(seekMap2);
            return;
        }
        this.dummySeekMap = seekMap;
    }

    public void onTrackDataFound(int i, MediaParser.TrackData trackData) {
        String str;
        if (!maybeObtainChunkIndex(trackData.mediaFormat)) {
            ensureSpaceForTrackIndex(i);
            TrackOutput trackOutput = this.trackOutputs.get(i);
            if (trackOutput == null) {
                String string = trackData.mediaFormat.getString(MEDIA_FORMAT_KEY_TRACK_TYPE);
                if (string != null) {
                    str = string;
                } else {
                    str = trackData.mediaFormat.getString("mime");
                }
                int trackTypeConstant = toTrackTypeConstant(str);
                if (trackTypeConstant == this.primaryTrackType) {
                    this.primaryTrackIndex = i;
                }
                TrackOutput track = this.extractorOutput.track(i, trackTypeConstant);
                this.trackOutputs.set(i, track);
                if (string == null) {
                    trackOutput = track;
                } else {
                    return;
                }
            }
            Format exoPlayerFormat = toExoPlayerFormat(trackData);
            Format format = this.primaryTrackManifestFormat;
            trackOutput.format((format == null || i != this.primaryTrackIndex) ? exoPlayerFormat : exoPlayerFormat.withManifestFormatInfo(format));
            this.trackFormats.set(i, exoPlayerFormat);
            maybeEndTracks();
        }
    }

    public void onSampleDataFound(int i, MediaParser.InputReader inputReader) throws IOException {
        ensureSpaceForTrackIndex(i);
        this.scratchDataReaderAdapter.input = inputReader;
        TrackOutput trackOutput = this.trackOutputs.get(i);
        if (trackOutput == null) {
            trackOutput = this.extractorOutput.track(i, -1);
            this.trackOutputs.set(i, trackOutput);
        }
        trackOutput.sampleData((DataReader) this.scratchDataReaderAdapter, (int) inputReader.getLength(), true);
    }

    public void onSampleCompleted(int i, long j, int i2, int i3, int i4, MediaCodec.CryptoInfo cryptoInfo) {
        long j2 = this.sampleTimestampUpperLimitFilterUs;
        if (j2 == C.TIME_UNSET || j < j2) {
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j = timestampAdjuster2.adjustSampleTimestamp(j);
            }
            ((TrackOutput) Assertions.checkNotNull(this.trackOutputs.get(i))).sampleMetadata(j, i2, i3, i4, toExoPlayerCryptoData(i, cryptoInfo));
        }
    }

    private boolean maybeObtainChunkIndex(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_SIZES);
        if (byteBuffer == null) {
            return false;
        }
        IntBuffer asIntBuffer = byteBuffer.asIntBuffer();
        LongBuffer asLongBuffer = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_OFFSETS))).asLongBuffer();
        LongBuffer asLongBuffer2 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_DURATIONS))).asLongBuffer();
        LongBuffer asLongBuffer3 = ((ByteBuffer) Assertions.checkNotNull(mediaFormat.getByteBuffer(MEDIA_FORMAT_KEY_CHUNK_INDEX_TIMES))).asLongBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        long[] jArr = new long[asLongBuffer.remaining()];
        long[] jArr2 = new long[asLongBuffer2.remaining()];
        long[] jArr3 = new long[asLongBuffer3.remaining()];
        asIntBuffer.get(iArr);
        asLongBuffer.get(jArr);
        asLongBuffer2.get(jArr2);
        asLongBuffer3.get(jArr3);
        ChunkIndex chunkIndex = new ChunkIndex(iArr, jArr, jArr2, jArr3);
        this.lastChunkIndex = chunkIndex;
        this.extractorOutput.seekMap(chunkIndex);
        return true;
    }

    private void ensureSpaceForTrackIndex(int i) {
        for (int size = this.trackOutputs.size(); size <= i; size++) {
            this.trackOutputs.add((Object) null);
            this.trackFormats.add((Object) null);
            this.lastReceivedCryptoInfos.add((Object) null);
            this.lastOutputCryptoDatas.add((Object) null);
        }
    }

    private TrackOutput.CryptoData toExoPlayerCryptoData(int i, MediaCodec.CryptoInfo cryptoInfo) {
        int i2;
        if (cryptoInfo == null) {
            return null;
        }
        if (this.lastReceivedCryptoInfos.get(i) == cryptoInfo) {
            return (TrackOutput.CryptoData) Assertions.checkNotNull(this.lastOutputCryptoDatas.get(i));
        }
        int i3 = 0;
        try {
            Matcher matcher = REGEX_CRYPTO_INFO_PATTERN.matcher(cryptoInfo.toString());
            matcher.find();
            int parseInt = Integer.parseInt((String) Util.castNonNull(matcher.group(1)));
            i2 = Integer.parseInt((String) Util.castNonNull(matcher.group(2)));
            i3 = parseInt;
        } catch (RuntimeException e) {
            Log.e(TAG, "Unexpected error while parsing CryptoInfo: " + cryptoInfo, e);
            i2 = 0;
        }
        TrackOutput.CryptoData cryptoData = new TrackOutput.CryptoData(cryptoInfo.mode, cryptoInfo.key, i3, i2);
        this.lastReceivedCryptoInfos.set(i, cryptoInfo);
        this.lastOutputCryptoDatas.set(i, cryptoData);
        return cryptoData;
    }

    private void maybeEndTracks() {
        if (this.tracksFoundCalled && !this.tracksEnded) {
            int size = this.trackOutputs.size();
            int i = 0;
            while (i < size) {
                if (this.trackOutputs.get(i) != null) {
                    i++;
                } else {
                    return;
                }
            }
            this.extractorOutput.endTracks();
            this.tracksEnded = true;
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int toTrackTypeConstant(java.lang.String r5) {
        /*
            r0 = -1
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r5.hashCode()
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -450004177: goto L_0x003f;
                case -284840886: goto L_0x0034;
                case 3556653: goto L_0x0029;
                case 93166550: goto L_0x001e;
                case 112202875: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            r1 = r0
            goto L_0x0049
        L_0x0013:
            java.lang.String r1 = "video"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x001c
            goto L_0x0011
        L_0x001c:
            r1 = 4
            goto L_0x0049
        L_0x001e:
            java.lang.String r1 = "audio"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0027
            goto L_0x0011
        L_0x0027:
            r1 = r2
            goto L_0x0049
        L_0x0029:
            java.lang.String r1 = "text"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0032
            goto L_0x0011
        L_0x0032:
            r1 = r3
            goto L_0x0049
        L_0x0034:
            java.lang.String r1 = "unknown"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x003d
            goto L_0x0011
        L_0x003d:
            r1 = r4
            goto L_0x0049
        L_0x003f:
            java.lang.String r1 = "metadata"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L_0x0048
            goto L_0x0011
        L_0x0048:
            r1 = 0
        L_0x0049:
            switch(r1) {
                case 0: goto L_0x0055;
                case 1: goto L_0x0054;
                case 2: goto L_0x0053;
                case 3: goto L_0x0052;
                case 4: goto L_0x0051;
                default: goto L_0x004c;
            }
        L_0x004c:
            int r5 = com.google.android.exoplayer2.util.MimeTypes.getTrackType(r5)
            return r5
        L_0x0051:
            return r3
        L_0x0052:
            return r4
        L_0x0053:
            return r2
        L_0x0054:
            return r0
        L_0x0055:
            r5 = 5
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.mediaparser.OutputConsumerAdapterV30.toTrackTypeConstant(java.lang.String):int");
    }

    private Format toExoPlayerFormat(MediaParser.TrackData trackData) {
        MediaFormat mediaFormat = trackData.mediaFormat;
        String string = mediaFormat.getString("mime");
        int integer = mediaFormat.getInteger("caption-service-number", -1);
        int i = 0;
        Format.Builder accessibilityChannel = new Format.Builder().setDrmInitData(toExoPlayerDrmInitData(mediaFormat.getString("crypto-mode-fourcc"), trackData.drmInitData)).setContainerMimeType(this.containerMimeType).setPeakBitrate(mediaFormat.getInteger("bitrate", -1)).setChannelCount(mediaFormat.getInteger("channel-count", -1)).setColorInfo(getColorInfo(mediaFormat)).setSampleMimeType(string).setCodecs(mediaFormat.getString("codecs-string")).setFrameRate(mediaFormat.getFloat("frame-rate", -1.0f)).setWidth(mediaFormat.getInteger("width", -1)).setHeight(mediaFormat.getInteger("height", -1)).setInitializationData(getInitializationData(mediaFormat)).setLanguage(mediaFormat.getString(Device.JsonKeys.LANGUAGE)).setMaxInputSize(mediaFormat.getInteger("max-input-size", -1)).setPcmEncoding(mediaFormat.getInteger("exo-pcm-encoding", -1)).setRotationDegrees(mediaFormat.getInteger("rotation-degrees", 0)).setSampleRate(mediaFormat.getInteger("sample-rate", -1)).setSelectionFlags(getSelectionFlags(mediaFormat)).setEncoderDelay(mediaFormat.getInteger("encoder-delay", 0)).setEncoderPadding(mediaFormat.getInteger("encoder-padding", 0)).setPixelWidthHeightRatio(mediaFormat.getFloat("pixel-width-height-ratio-float", 1.0f)).setSubsampleOffsetUs(mediaFormat.getLong("subsample-offset-us-long", Long.MAX_VALUE)).setAccessibilityChannel(integer);
        while (true) {
            if (i >= this.muxedCaptionFormats.size()) {
                break;
            }
            Format format = this.muxedCaptionFormats.get(i);
            if (Util.areEqual(format.sampleMimeType, string) && format.accessibilityChannel == integer) {
                accessibilityChannel.setLanguage(format.language).setRoleFlags(format.roleFlags).setSelectionFlags(format.selectionFlags).setLabel(format.label).setMetadata(format.metadata);
                break;
            }
            i++;
        }
        return accessibilityChannel.build();
    }

    private static DrmInitData toExoPlayerDrmInitData(String str, android.media.DrmInitData drmInitData) {
        if (drmInitData == null) {
            return null;
        }
        int schemeInitDataCount = drmInitData.getSchemeInitDataCount();
        DrmInitData.SchemeData[] schemeDataArr = new DrmInitData.SchemeData[schemeInitDataCount];
        for (int i = 0; i < schemeInitDataCount; i++) {
            DrmInitData.SchemeInitData schemeInitDataAt = drmInitData.getSchemeInitDataAt(i);
            schemeDataArr[i] = new DrmInitData.SchemeData(schemeInitDataAt.uuid, schemeInitDataAt.mimeType, schemeInitDataAt.data);
        }
        return new com.google.android.exoplayer2.drm.DrmInitData(str, schemeDataArr);
    }

    private static int getSelectionFlags(MediaFormat mediaFormat) {
        return getFlag(mediaFormat, "is-forced-subtitle", 2) | getFlag(mediaFormat, "is-autoselect", 4) | 0 | getFlag(mediaFormat, "is-default", 1);
    }

    private static int getFlag(MediaFormat mediaFormat, String str, int i) {
        if (mediaFormat.getInteger(str, 0) != 0) {
            return i;
        }
        return 0;
    }

    private static List<byte[]> getInitializationData(MediaFormat mediaFormat) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int i2 = i + 1;
            ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-" + i);
            if (byteBuffer == null) {
                return arrayList;
            }
            arrayList.add(getArray(byteBuffer));
            i = i2;
        }
    }

    private static ColorInfo getColorInfo(MediaFormat mediaFormat) {
        ByteBuffer byteBuffer = mediaFormat.getByteBuffer("hdr-static-info");
        byte[] array = byteBuffer != null ? getArray(byteBuffer) : null;
        int integer = mediaFormat.getInteger("color-transfer", -1);
        int integer2 = mediaFormat.getInteger("color-range", -1);
        int integer3 = mediaFormat.getInteger("color-standard", -1);
        if (array == null && integer == -1 && integer2 == -1 && integer3 == -1) {
            return null;
        }
        return new ColorInfo(integer3, integer2, integer, array);
    }

    private static byte[] getArray(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }

    private static String getMimeType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -2063506020:
                if (str.equals("android.media.mediaparser.Mp4Parser")) {
                    c = 0;
                    break;
                }
                break;
            case -1870824006:
                if (str.equals("android.media.mediaparser.OggParser")) {
                    c = 1;
                    break;
                }
                break;
            case -1566427438:
                if (str.equals("android.media.mediaparser.TsParser")) {
                    c = 2;
                    break;
                }
                break;
            case -900207883:
                if (str.equals("android.media.mediaparser.AdtsParser")) {
                    c = 3;
                    break;
                }
                break;
            case -589864617:
                if (str.equals("android.media.mediaparser.WavParser")) {
                    c = 4;
                    break;
                }
                break;
            case 52265814:
                if (str.equals("android.media.mediaparser.PsParser")) {
                    c = 5;
                    break;
                }
                break;
            case 116768877:
                if (str.equals("android.media.mediaparser.FragmentedMp4Parser")) {
                    c = 6;
                    break;
                }
                break;
            case 376876796:
                if (str.equals("android.media.mediaparser.Ac3Parser")) {
                    c = 7;
                    break;
                }
                break;
            case 703268017:
                if (str.equals("android.media.mediaparser.AmrParser")) {
                    c = 8;
                    break;
                }
                break;
            case 768643067:
                if (str.equals("android.media.mediaparser.FlacParser")) {
                    c = 9;
                    break;
                }
                break;
            case 965962719:
                if (str.equals("android.media.mediaparser.MatroskaParser")) {
                    c = 10;
                    break;
                }
                break;
            case 1264380477:
                if (str.equals("android.media.mediaparser.Ac4Parser")) {
                    c = 11;
                    break;
                }
                break;
            case 1343957595:
                if (str.equals("android.media.mediaparser.Mp3Parser")) {
                    c = 12;
                    break;
                }
                break;
            case 2063134683:
                if (str.equals("android.media.mediaparser.FlvParser")) {
                    c = CharUtils.CR;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 6:
                return MimeTypes.VIDEO_MP4;
            case 1:
                return MimeTypes.AUDIO_OGG;
            case 2:
                return MimeTypes.VIDEO_MP2T;
            case 3:
                return MimeTypes.AUDIO_AAC;
            case 4:
                return MimeTypes.AUDIO_RAW;
            case 5:
                return MimeTypes.VIDEO_PS;
            case 7:
                return MimeTypes.AUDIO_AC3;
            case 8:
                return MimeTypes.AUDIO_AMR;
            case 9:
                return MimeTypes.AUDIO_FLAC;
            case 10:
                return MimeTypes.VIDEO_WEBM;
            case 11:
                return MimeTypes.AUDIO_AC4;
            case 12:
                return MimeTypes.AUDIO_MPEG;
            case 13:
                return MimeTypes.VIDEO_FLV;
            default:
                throw new IllegalArgumentException("Illegal parser name: " + str);
        }
    }

    private static final class SeekMapAdapter implements SeekMap {
        private final MediaParser.SeekMap adaptedSeekMap;

        public SeekMapAdapter(MediaParser.SeekMap seekMap) {
            this.adaptedSeekMap = seekMap;
        }

        public boolean isSeekable() {
            return this.adaptedSeekMap.isSeekable();
        }

        public long getDurationUs() {
            long durationMicros = this.adaptedSeekMap.getDurationMicros();
            return durationMicros != -2147483648L ? durationMicros : C.TIME_UNSET;
        }

        public SeekMap.SeekPoints getSeekPoints(long j) {
            Pair seekPoints = this.adaptedSeekMap.getSeekPoints(j);
            if (seekPoints.first == seekPoints.second) {
                return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.first));
            }
            return new SeekMap.SeekPoints(asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.first), asExoPlayerSeekPoint((MediaParser.SeekPoint) seekPoints.second));
        }

        private static SeekPoint asExoPlayerSeekPoint(MediaParser.SeekPoint seekPoint) {
            return new SeekPoint(seekPoint.timeMicros, seekPoint.position);
        }
    }

    private static final class DataReaderAdapter implements DataReader {
        public MediaParser.InputReader input;

        private DataReaderAdapter() {
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            return ((MediaParser.InputReader) Util.castNonNull(this.input)).read(bArr, i, i2);
        }
    }
}
