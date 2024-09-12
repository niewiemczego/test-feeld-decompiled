package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;

public final class SilenceMediaSource extends BaseMediaSource {
    private static final int CHANNEL_COUNT = 2;
    /* access modifiers changed from: private */
    public static final Format FORMAT;
    public static final String MEDIA_ID = "SilenceMediaSource";
    /* access modifiers changed from: private */
    public static final MediaItem MEDIA_ITEM;
    private static final int PCM_ENCODING = 2;
    private static final int SAMPLE_RATE_HZ = 44100;
    /* access modifiers changed from: private */
    public static final byte[] SILENCE_SAMPLE = new byte[(Util.getPcmFrameSize(2, 2) * 1024)];
    private final long durationUs;
    private final MediaItem mediaItem;

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
    }

    /* access modifiers changed from: protected */
    public void releaseSourceInternal() {
    }

    public static final class Factory {
        private long durationUs;
        private Object tag;

        public Factory setDurationUs(long j) {
            this.durationUs = j;
            return this;
        }

        public Factory setTag(Object obj) {
            this.tag = obj;
            return this;
        }

        public SilenceMediaSource createMediaSource() {
            Assertions.checkState(this.durationUs > 0);
            return new SilenceMediaSource(this.durationUs, SilenceMediaSource.MEDIA_ITEM.buildUpon().setTag(this.tag).build());
        }
    }

    static {
        Format build = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_RAW).setChannelCount(2).setSampleRate(SAMPLE_RATE_HZ).setPcmEncoding(2).build();
        FORMAT = build;
        MEDIA_ITEM = new MediaItem.Builder().setMediaId(MEDIA_ID).setUri(Uri.EMPTY).setMimeType(build.sampleMimeType).build();
    }

    public SilenceMediaSource(long j) {
        this(j, MEDIA_ITEM);
    }

    private SilenceMediaSource(long j, MediaItem mediaItem2) {
        Assertions.checkArgument(j >= 0);
        this.durationUs = j;
        this.mediaItem = mediaItem2;
    }

    /* access modifiers changed from: protected */
    public void prepareSourceInternal(TransferListener transferListener) {
        refreshSourceInfo(new SinglePeriodTimeline(this.durationUs, true, false, false, (Object) null, this.mediaItem));
    }

    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        return new SilenceMediaPeriod(this.durationUs);
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    private static final class SilenceMediaPeriod implements MediaPeriod {
        private static final TrackGroupArray TRACKS = new TrackGroupArray(new TrackGroup(SilenceMediaSource.FORMAT));
        private final long durationUs;
        private final ArrayList<SampleStream> sampleStreams = new ArrayList<>();

        public boolean continueLoading(long j) {
            return false;
        }

        public void discardBuffer(long j, boolean z) {
        }

        public long getBufferedPositionUs() {
            return Long.MIN_VALUE;
        }

        public long getNextLoadPositionUs() {
            return Long.MIN_VALUE;
        }

        public boolean isLoading() {
            return false;
        }

        public void maybeThrowPrepareError() {
        }

        public long readDiscontinuity() {
            return C.TIME_UNSET;
        }

        public void reevaluateBuffer(long j) {
        }

        public SilenceMediaPeriod(long j) {
            this.durationUs = j;
        }

        public void prepare(MediaPeriod.Callback callback, long j) {
            callback.onPrepared(this);
        }

        public TrackGroupArray getTrackGroups() {
            return TRACKS;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.Object[]} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: java.lang.Object[]} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[] r5, boolean[] r6, com.google.android.exoplayer2.source.SampleStream[] r7, boolean[] r8, long r9) {
            /*
                r4 = this;
                long r9 = r4.constrainSeekPosition(r9)
                r0 = 0
            L_0x0005:
                int r1 = r5.length
                if (r0 >= r1) goto L_0x003b
                r1 = r7[r0]
                if (r1 == 0) goto L_0x001c
                r2 = r5[r0]
                if (r2 == 0) goto L_0x0014
                boolean r2 = r6[r0]
                if (r2 != 0) goto L_0x001c
            L_0x0014:
                java.util.ArrayList<com.google.android.exoplayer2.source.SampleStream> r2 = r4.sampleStreams
                r2.remove(r1)
                r1 = 0
                r7[r0] = r1
            L_0x001c:
                r1 = r7[r0]
                if (r1 != 0) goto L_0x0038
                r1 = r5[r0]
                if (r1 == 0) goto L_0x0038
                com.google.android.exoplayer2.source.SilenceMediaSource$SilenceSampleStream r1 = new com.google.android.exoplayer2.source.SilenceMediaSource$SilenceSampleStream
                long r2 = r4.durationUs
                r1.<init>(r2)
                r1.seekTo(r9)
                java.util.ArrayList<com.google.android.exoplayer2.source.SampleStream> r2 = r4.sampleStreams
                r2.add(r1)
                r7[r0] = r1
                r1 = 1
                r8[r0] = r1
            L_0x0038:
                int r0 = r0 + 1
                goto L_0x0005
            L_0x003b:
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SilenceMediaSource.SilenceMediaPeriod.selectTracks(com.google.android.exoplayer2.trackselection.ExoTrackSelection[], boolean[], com.google.android.exoplayer2.source.SampleStream[], boolean[], long):long");
        }

        public long seekToUs(long j) {
            long constrainSeekPosition = constrainSeekPosition(j);
            for (int i = 0; i < this.sampleStreams.size(); i++) {
                ((SilenceSampleStream) this.sampleStreams.get(i)).seekTo(constrainSeekPosition);
            }
            return constrainSeekPosition;
        }

        public long getAdjustedSeekPositionUs(long j, SeekParameters seekParameters) {
            return constrainSeekPosition(j);
        }

        private long constrainSeekPosition(long j) {
            return Util.constrainValue(j, 0, this.durationUs);
        }
    }

    private static final class SilenceSampleStream implements SampleStream {
        private final long durationBytes;
        private long positionBytes;
        private boolean sentFormat;

        public boolean isReady() {
            return true;
        }

        public void maybeThrowError() {
        }

        public SilenceSampleStream(long j) {
            this.durationBytes = SilenceMediaSource.getAudioByteCount(j);
            seekTo(0);
        }

        public void seekTo(long j) {
            this.positionBytes = Util.constrainValue(SilenceMediaSource.getAudioByteCount(j), 0, this.durationBytes);
        }

        public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
            if (!this.sentFormat || (i & 2) != 0) {
                formatHolder.format = SilenceMediaSource.FORMAT;
                this.sentFormat = true;
                return -5;
            }
            long j = this.durationBytes;
            long j2 = this.positionBytes;
            long j3 = j - j2;
            if (j3 == 0) {
                decoderInputBuffer.addFlag(4);
                return -4;
            }
            decoderInputBuffer.timeUs = SilenceMediaSource.getAudioPositionUs(j2);
            decoderInputBuffer.addFlag(1);
            int min = (int) Math.min((long) SilenceMediaSource.SILENCE_SAMPLE.length, j3);
            if ((i & 4) == 0) {
                decoderInputBuffer.ensureSpaceForWrite(min);
                decoderInputBuffer.data.put(SilenceMediaSource.SILENCE_SAMPLE, 0, min);
            }
            if ((i & 1) == 0) {
                this.positionBytes += (long) min;
            }
            return -4;
        }

        public int skipData(long j) {
            long j2 = this.positionBytes;
            seekTo(j);
            return (int) ((this.positionBytes - j2) / ((long) SilenceMediaSource.SILENCE_SAMPLE.length));
        }
    }

    /* access modifiers changed from: private */
    public static long getAudioByteCount(long j) {
        return ((long) Util.getPcmFrameSize(2, 2)) * ((j * 44100) / 1000000);
    }

    /* access modifiers changed from: private */
    public static long getAudioPositionUs(long j) {
        return ((j / ((long) Util.getPcmFrameSize(2, 2))) * 1000000) / 44100;
    }
}
