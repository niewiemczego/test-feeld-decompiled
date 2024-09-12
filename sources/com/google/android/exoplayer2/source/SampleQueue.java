package com.google.android.exoplayer2.source;

import android.os.Looper;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;

public class SampleQueue implements TrackOutput {
    static final int SAMPLE_CAPACITY_INCREMENT = 1000;
    private static final String TAG = "SampleQueue";
    private int absoluteFirstIndex;
    private int capacity = 1000;
    private TrackOutput.CryptoData[] cryptoDatas = new TrackOutput.CryptoData[1000];
    private DrmSession currentDrmSession;
    private Format downstreamFormat;
    private final DrmSessionEventListener.EventDispatcher drmEventDispatcher;
    private final DrmSessionManager drmSessionManager;
    private final SampleExtrasHolder extrasHolder = new SampleExtrasHolder();
    private int[] flags = new int[1000];
    private boolean isLastSampleQueued;
    private long largestDiscardedTimestampUs = Long.MIN_VALUE;
    private long largestQueuedTimestampUs = Long.MIN_VALUE;
    private int length;
    private boolean loggedUnexpectedNonSyncSample;
    private long[] offsets = new long[1000];
    private boolean pendingSplice;
    private int readPosition;
    private int relativeFirstIndex;
    private final SampleDataQueue sampleDataQueue;
    private long sampleOffsetUs;
    private final SpannedData<SharedSampleMetadata> sharedSampleMetadata = new SpannedData<>(new SampleQueue$$ExternalSyntheticLambda0());
    private int[] sizes = new int[1000];
    private int[] sourceIds = new int[1000];
    private long startTimeUs = Long.MIN_VALUE;
    private long[] timesUs = new long[1000];
    private Format unadjustedUpstreamFormat;
    private boolean upstreamAllSamplesAreSyncSamples;
    private Format upstreamFormat;
    private boolean upstreamFormatAdjustmentRequired;
    private UpstreamFormatChangedListener upstreamFormatChangeListener;
    private boolean upstreamFormatRequired = true;
    private boolean upstreamKeyframeRequired = true;
    private int upstreamSourceId;

    public interface UpstreamFormatChangedListener {
        void onUpstreamFormatChanged(Format format);
    }

    public static SampleQueue createWithoutDrm(Allocator allocator) {
        return new SampleQueue(allocator, (DrmSessionManager) null, (DrmSessionEventListener.EventDispatcher) null);
    }

    public static SampleQueue createWithDrm(Allocator allocator, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager2), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    @Deprecated
    public static SampleQueue createWithDrm(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        drmSessionManager2.setPlayer(looper, PlayerId.UNSET);
        return new SampleQueue(allocator, (DrmSessionManager) Assertions.checkNotNull(drmSessionManager2), (DrmSessionEventListener.EventDispatcher) Assertions.checkNotNull(eventDispatcher));
    }

    protected SampleQueue(Allocator allocator, DrmSessionManager drmSessionManager2, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.drmSessionManager = drmSessionManager2;
        this.drmEventDispatcher = eventDispatcher;
        this.sampleDataQueue = new SampleDataQueue(allocator);
    }

    public void release() {
        reset(true);
        releaseDrmSessionReferences();
    }

    public final void reset() {
        reset(false);
    }

    public void reset(boolean z) {
        this.sampleDataQueue.reset();
        this.length = 0;
        this.absoluteFirstIndex = 0;
        this.relativeFirstIndex = 0;
        this.readPosition = 0;
        this.upstreamKeyframeRequired = true;
        this.startTimeUs = Long.MIN_VALUE;
        this.largestDiscardedTimestampUs = Long.MIN_VALUE;
        this.largestQueuedTimestampUs = Long.MIN_VALUE;
        this.isLastSampleQueued = false;
        this.sharedSampleMetadata.clear();
        if (z) {
            this.unadjustedUpstreamFormat = null;
            this.upstreamFormat = null;
            this.upstreamFormatRequired = true;
        }
    }

    public final void setStartTimeUs(long j) {
        this.startTimeUs = j;
    }

    public final void sourceId(int i) {
        this.upstreamSourceId = i;
    }

    public final void splice() {
        this.pendingSplice = true;
    }

    public final int getWriteIndex() {
        return this.absoluteFirstIndex + this.length;
    }

    public final void discardUpstreamSamples(int i) {
        this.sampleDataQueue.discardUpstreamSampleBytes(discardUpstreamSampleMetadata(i));
    }

    public final void discardUpstreamFrom(long j) {
        if (this.length != 0) {
            Assertions.checkArgument(j > getLargestReadTimestampUs());
            discardUpstreamSamples(this.absoluteFirstIndex + countUnreadSamplesBefore(j));
        }
    }

    public void preRelease() {
        discardToEnd();
        releaseDrmSessionReferences();
    }

    public void maybeThrowError() throws IOException {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) Assertions.checkNotNull(this.currentDrmSession.getError()));
        }
    }

    public final int getFirstIndex() {
        return this.absoluteFirstIndex;
    }

    public final int getReadIndex() {
        return this.absoluteFirstIndex + this.readPosition;
    }

    public final synchronized int peekSourceId() {
        return hasNextSample() ? this.sourceIds[getRelativeIndex(this.readPosition)] : this.upstreamSourceId;
    }

    public final synchronized Format getUpstreamFormat() {
        return this.upstreamFormatRequired ? null : this.upstreamFormat;
    }

    public final synchronized long getLargestQueuedTimestampUs() {
        return this.largestQueuedTimestampUs;
    }

    public final synchronized long getLargestReadTimestampUs() {
        return Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(this.readPosition));
    }

    public final synchronized boolean isLastSampleQueued() {
        return this.isLastSampleQueued;
    }

    public final synchronized long getFirstTimestampUs() {
        return this.length == 0 ? Long.MIN_VALUE : this.timesUs[this.relativeFirstIndex];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0019, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean isReady(boolean r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.hasNextSample()     // Catch:{ all -> 0x003a }
            r1 = 1
            if (r0 != 0) goto L_0x001a
            if (r3 != 0) goto L_0x0018
            boolean r3 = r2.isLastSampleQueued     // Catch:{ all -> 0x003a }
            if (r3 != 0) goto L_0x0018
            com.google.android.exoplayer2.Format r3 = r2.upstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.Format r0 = r2.downstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = 0
        L_0x0018:
            monitor-exit(r2)
            return r1
        L_0x001a:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r3 = r2.sharedSampleMetadata     // Catch:{ all -> 0x003a }
            int r0 = r2.getReadIndex()     // Catch:{ all -> 0x003a }
            java.lang.Object r3 = r3.get(r0)     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r3 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r3     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r3 = r3.format     // Catch:{ all -> 0x003a }
            com.google.android.exoplayer2.Format r0 = r2.downstreamFormat     // Catch:{ all -> 0x003a }
            if (r3 == r0) goto L_0x002e
            monitor-exit(r2)
            return r1
        L_0x002e:
            int r3 = r2.readPosition     // Catch:{ all -> 0x003a }
            int r3 = r2.getRelativeIndex(r3)     // Catch:{ all -> 0x003a }
            boolean r3 = r2.mayReadSample(r3)     // Catch:{ all -> 0x003a }
            monitor-exit(r2)
            return r3
        L_0x003a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.isReady(boolean):boolean");
    }

    public int read(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        boolean z2 = false;
        int peekSampleMetadata = peekSampleMetadata(formatHolder, decoderInputBuffer, (i & 2) != 0, z, this.extrasHolder);
        if (peekSampleMetadata == -4 && !decoderInputBuffer.isEndOfStream()) {
            if ((i & 1) != 0) {
                z2 = true;
            }
            if ((i & 4) == 0) {
                if (z2) {
                    this.sampleDataQueue.peekToBuffer(decoderInputBuffer, this.extrasHolder);
                } else {
                    this.sampleDataQueue.readToBuffer(decoderInputBuffer, this.extrasHolder);
                }
            }
            if (!z2) {
                this.readPosition++;
            }
        }
        return peekSampleMetadata;
    }

    public final synchronized boolean seekTo(int i) {
        rewind();
        int i2 = this.absoluteFirstIndex;
        if (i >= i2) {
            if (i <= this.length + i2) {
                this.startTimeUs = Long.MIN_VALUE;
                this.readPosition = i - i2;
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003f, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized boolean seekTo(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            r8.rewind()     // Catch:{ all -> 0x0040 }
            int r0 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r2 = r8.getRelativeIndex(r0)     // Catch:{ all -> 0x0040 }
            boolean r0 = r8.hasNextSample()     // Catch:{ all -> 0x0040 }
            r7 = 0
            if (r0 == 0) goto L_0x003e
            long[] r0 = r8.timesUs     // Catch:{ all -> 0x0040 }
            r3 = r0[r2]     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 < 0) goto L_0x003e
            long r0 = r8.largestQueuedTimestampUs     // Catch:{ all -> 0x0040 }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            if (r11 != 0) goto L_0x0022
            goto L_0x003e
        L_0x0022:
            int r11 = r8.length     // Catch:{ all -> 0x0040 }
            int r0 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r11 = r1.findSampleBefore(r2, r3, r4, r6)     // Catch:{ all -> 0x0040 }
            r0 = -1
            if (r11 != r0) goto L_0x0034
            monitor-exit(r8)
            return r7
        L_0x0034:
            r8.startTimeUs = r9     // Catch:{ all -> 0x0040 }
            int r9 = r8.readPosition     // Catch:{ all -> 0x0040 }
            int r9 = r9 + r11
            r8.readPosition = r9     // Catch:{ all -> 0x0040 }
            r9 = 1
            monitor-exit(r8)
            return r9
        L_0x003e:
            monitor-exit(r8)
            return r7
        L_0x0040:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.seekTo(long, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x003b, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int getSkipCount(long r9, boolean r11) {
        /*
            r8 = this;
            monitor-enter(r8)
            int r0 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r2 = r8.getRelativeIndex(r0)     // Catch:{ all -> 0x003c }
            boolean r0 = r8.hasNextSample()     // Catch:{ all -> 0x003c }
            r7 = 0
            if (r0 == 0) goto L_0x003a
            long[] r0 = r8.timesUs     // Catch:{ all -> 0x003c }
            r3 = r0[r2]     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r0 >= 0) goto L_0x0017
            goto L_0x003a
        L_0x0017:
            long r0 = r8.largestQueuedTimestampUs     // Catch:{ all -> 0x003c }
            int r0 = (r9 > r0 ? 1 : (r9 == r0 ? 0 : -1))
            if (r0 <= 0) goto L_0x0026
            if (r11 == 0) goto L_0x0026
            int r9 = r8.length     // Catch:{ all -> 0x003c }
            int r10 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r9 = r9 - r10
            monitor-exit(r8)
            return r9
        L_0x0026:
            int r11 = r8.length     // Catch:{ all -> 0x003c }
            int r0 = r8.readPosition     // Catch:{ all -> 0x003c }
            int r3 = r11 - r0
            r6 = 1
            r1 = r8
            r4 = r9
            int r9 = r1.findSampleBefore(r2, r3, r4, r6)     // Catch:{ all -> 0x003c }
            r10 = -1
            if (r9 != r10) goto L_0x0038
            monitor-exit(r8)
            return r7
        L_0x0038:
            monitor-exit(r8)
            return r9
        L_0x003a:
            monitor-exit(r8)
            return r7
        L_0x003c:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.getSkipCount(long, boolean):int");
    }

    public final synchronized void skip(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.readPosition + i <= this.length) {
                    z = true;
                    Assertions.checkArgument(z);
                    this.readPosition += i;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        z = false;
        Assertions.checkArgument(z);
        this.readPosition += i;
    }

    public final void discardTo(long j, boolean z, boolean z2) {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataTo(j, z, z2));
    }

    public final void discardToRead() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToRead());
    }

    public final void discardToEnd() {
        this.sampleDataQueue.discardDownstreamTo(discardSampleMetadataToEnd());
    }

    public final void setSampleOffsetUs(long j) {
        if (this.sampleOffsetUs != j) {
            this.sampleOffsetUs = j;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void setUpstreamFormatChangeListener(UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.upstreamFormatChangeListener = upstreamFormatChangedListener;
    }

    public final void format(Format format) {
        Format adjustedUpstreamFormat = getAdjustedUpstreamFormat(format);
        this.upstreamFormatAdjustmentRequired = false;
        this.unadjustedUpstreamFormat = format;
        boolean upstreamFormat2 = setUpstreamFormat(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.upstreamFormatChangeListener;
        if (upstreamFormatChangedListener != null && upstreamFormat2) {
            upstreamFormatChangedListener.onUpstreamFormatChanged(adjustedUpstreamFormat);
        }
    }

    public final int sampleData(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        return this.sampleDataQueue.sampleData(dataReader, i, z);
    }

    public final void sampleData(ParsableByteArray parsableByteArray, int i, int i2) {
        this.sampleDataQueue.sampleData(parsableByteArray, i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sampleMetadata(long r12, int r14, int r15, int r16, com.google.android.exoplayer2.extractor.TrackOutput.CryptoData r17) {
        /*
            r11 = this;
            r8 = r11
            boolean r0 = r8.upstreamFormatAdjustmentRequired
            if (r0 == 0) goto L_0x0010
            com.google.android.exoplayer2.Format r0 = r8.unadjustedUpstreamFormat
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkStateNotNull(r0)
            com.google.android.exoplayer2.Format r0 = (com.google.android.exoplayer2.Format) r0
            r11.format(r0)
        L_0x0010:
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x0018
            r3 = r2
            goto L_0x0019
        L_0x0018:
            r3 = r1
        L_0x0019:
            boolean r4 = r8.upstreamKeyframeRequired
            if (r4 == 0) goto L_0x0022
            if (r3 != 0) goto L_0x0020
            return
        L_0x0020:
            r8.upstreamKeyframeRequired = r1
        L_0x0022:
            long r4 = r8.sampleOffsetUs
            long r4 = r4 + r12
            boolean r6 = r8.upstreamAllSamplesAreSyncSamples
            if (r6 == 0) goto L_0x0056
            long r6 = r8.startTimeUs
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 >= 0) goto L_0x0030
            return
        L_0x0030:
            if (r0 != 0) goto L_0x0056
            boolean r0 = r8.loggedUnexpectedNonSyncSample
            if (r0 != 0) goto L_0x0052
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r6 = "Overriding unexpected non-sync sample for format: "
            java.lang.StringBuilder r0 = r0.append(r6)
            com.google.android.exoplayer2.Format r6 = r8.upstreamFormat
            java.lang.StringBuilder r0 = r0.append(r6)
            java.lang.String r0 = r0.toString()
            java.lang.String r6 = "SampleQueue"
            com.google.android.exoplayer2.util.Log.w(r6, r0)
            r8.loggedUnexpectedNonSyncSample = r2
        L_0x0052:
            r0 = r14 | 1
            r6 = r0
            goto L_0x0057
        L_0x0056:
            r6 = r14
        L_0x0057:
            boolean r0 = r8.pendingSplice
            if (r0 == 0) goto L_0x0068
            if (r3 == 0) goto L_0x0067
            boolean r0 = r11.attemptSplice(r4)
            if (r0 != 0) goto L_0x0064
            goto L_0x0067
        L_0x0064:
            r8.pendingSplice = r1
            goto L_0x0068
        L_0x0067:
            return
        L_0x0068:
            com.google.android.exoplayer2.source.SampleDataQueue r0 = r8.sampleDataQueue
            long r0 = r0.getTotalBytesWritten()
            r7 = r15
            long r2 = (long) r7
            long r0 = r0 - r2
            r2 = r16
            long r2 = (long) r2
            long r9 = r0 - r2
            r0 = r11
            r1 = r4
            r3 = r6
            r4 = r9
            r6 = r15
            r7 = r17
            r0.commitSample(r1, r3, r4, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.sampleMetadata(long, int, int, int, com.google.android.exoplayer2.extractor.TrackOutput$CryptoData):void");
    }

    /* access modifiers changed from: protected */
    public final void invalidateUpstreamFormatAdjustment() {
        this.upstreamFormatAdjustmentRequired = true;
    }

    /* access modifiers changed from: protected */
    public Format getAdjustedUpstreamFormat(Format format) {
        return (this.sampleOffsetUs == 0 || format.subsampleOffsetUs == Long.MAX_VALUE) ? format : format.buildUpon().setSubsampleOffsetUs(format.subsampleOffsetUs + this.sampleOffsetUs).build();
    }

    private synchronized void rewind() {
        this.readPosition = 0;
        this.sampleDataQueue.rewind();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002a, code lost:
        return -3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized int peekSampleMetadata(com.google.android.exoplayer2.FormatHolder r5, com.google.android.exoplayer2.decoder.DecoderInputBuffer r6, boolean r7, boolean r8, com.google.android.exoplayer2.source.SampleQueue.SampleExtrasHolder r9) {
        /*
            r4 = this;
            monitor-enter(r4)
            r0 = 0
            r6.waitingForKeys = r0     // Catch:{ all -> 0x008a }
            boolean r0 = r4.hasNextSample()     // Catch:{ all -> 0x008a }
            r1 = -5
            r2 = -3
            r3 = -4
            if (r0 != 0) goto L_0x0031
            if (r8 != 0) goto L_0x002b
            boolean r8 = r4.isLastSampleQueued     // Catch:{ all -> 0x008a }
            if (r8 == 0) goto L_0x0014
            goto L_0x002b
        L_0x0014:
            com.google.android.exoplayer2.Format r6 = r4.upstreamFormat     // Catch:{ all -> 0x008a }
            if (r6 == 0) goto L_0x0029
            if (r7 != 0) goto L_0x001e
            com.google.android.exoplayer2.Format r7 = r4.downstreamFormat     // Catch:{ all -> 0x008a }
            if (r6 == r7) goto L_0x0029
        L_0x001e:
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)     // Catch:{ all -> 0x008a }
            com.google.android.exoplayer2.Format r6 = (com.google.android.exoplayer2.Format) r6     // Catch:{ all -> 0x008a }
            r4.onFormatResult(r6, r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r1
        L_0x0029:
            monitor-exit(r4)
            return r2
        L_0x002b:
            r5 = 4
            r6.setFlags(r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r3
        L_0x0031:
            com.google.android.exoplayer2.source.SpannedData<com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata> r8 = r4.sharedSampleMetadata     // Catch:{ all -> 0x008a }
            int r0 = r4.getReadIndex()     // Catch:{ all -> 0x008a }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ all -> 0x008a }
            com.google.android.exoplayer2.source.SampleQueue$SharedSampleMetadata r8 = (com.google.android.exoplayer2.source.SampleQueue.SharedSampleMetadata) r8     // Catch:{ all -> 0x008a }
            com.google.android.exoplayer2.Format r8 = r8.format     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x0085
            com.google.android.exoplayer2.Format r7 = r4.downstreamFormat     // Catch:{ all -> 0x008a }
            if (r8 == r7) goto L_0x0046
            goto L_0x0085
        L_0x0046:
            int r5 = r4.readPosition     // Catch:{ all -> 0x008a }
            int r5 = r4.getRelativeIndex(r5)     // Catch:{ all -> 0x008a }
            boolean r7 = r4.mayReadSample(r5)     // Catch:{ all -> 0x008a }
            if (r7 != 0) goto L_0x0057
            r5 = 1
            r6.waitingForKeys = r5     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r2
        L_0x0057:
            int[] r7 = r4.flags     // Catch:{ all -> 0x008a }
            r7 = r7[r5]     // Catch:{ all -> 0x008a }
            r6.setFlags(r7)     // Catch:{ all -> 0x008a }
            long[] r7 = r4.timesUs     // Catch:{ all -> 0x008a }
            r0 = r7[r5]     // Catch:{ all -> 0x008a }
            r6.timeUs = r0     // Catch:{ all -> 0x008a }
            long r7 = r6.timeUs     // Catch:{ all -> 0x008a }
            long r0 = r4.startTimeUs     // Catch:{ all -> 0x008a }
            int r7 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r7 >= 0) goto L_0x0071
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            r6.addFlag(r7)     // Catch:{ all -> 0x008a }
        L_0x0071:
            int[] r6 = r4.sizes     // Catch:{ all -> 0x008a }
            r6 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.size = r6     // Catch:{ all -> 0x008a }
            long[] r6 = r4.offsets     // Catch:{ all -> 0x008a }
            r7 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.offset = r7     // Catch:{ all -> 0x008a }
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData[] r6 = r4.cryptoDatas     // Catch:{ all -> 0x008a }
            r5 = r6[r5]     // Catch:{ all -> 0x008a }
            r9.cryptoData = r5     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r3
        L_0x0085:
            r4.onFormatResult(r8, r5)     // Catch:{ all -> 0x008a }
            monitor-exit(r4)
            return r1
        L_0x008a:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.peekSampleMetadata(com.google.android.exoplayer2.FormatHolder, com.google.android.exoplayer2.decoder.DecoderInputBuffer, boolean, boolean, com.google.android.exoplayer2.source.SampleQueue$SampleExtrasHolder):int");
    }

    private synchronized boolean setUpstreamFormat(Format format) {
        this.upstreamFormatRequired = false;
        if (Util.areEqual(format, this.upstreamFormat)) {
            return false;
        }
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(format)) {
            this.upstreamFormat = format;
        } else {
            this.upstreamFormat = this.sharedSampleMetadata.getEndValue().format;
        }
        this.upstreamAllSamplesAreSyncSamples = MimeTypes.allSamplesAreSyncSamples(this.upstreamFormat.sampleMimeType, this.upstreamFormat.codecs);
        this.loggedUnexpectedNonSyncSample = false;
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002e, code lost:
        return -1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized long discardSampleMetadataTo(long r11, boolean r13, boolean r14) {
        /*
            r10 = this;
            monitor-enter(r10)
            int r0 = r10.length     // Catch:{ all -> 0x002f }
            r1 = -1
            if (r0 == 0) goto L_0x002d
            long[] r3 = r10.timesUs     // Catch:{ all -> 0x002f }
            int r5 = r10.relativeFirstIndex     // Catch:{ all -> 0x002f }
            r6 = r3[r5]     // Catch:{ all -> 0x002f }
            int r3 = (r11 > r6 ? 1 : (r11 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0012
            goto L_0x002d
        L_0x0012:
            if (r14 == 0) goto L_0x001a
            int r14 = r10.readPosition     // Catch:{ all -> 0x002f }
            if (r14 == r0) goto L_0x001a
            int r0 = r14 + 1
        L_0x001a:
            r6 = r0
            r4 = r10
            r7 = r11
            r9 = r13
            int r11 = r4.findSampleBefore(r5, r6, r7, r9)     // Catch:{ all -> 0x002f }
            r12 = -1
            if (r11 != r12) goto L_0x0027
            monitor-exit(r10)
            return r1
        L_0x0027:
            long r11 = r10.discardSamples(r11)     // Catch:{ all -> 0x002f }
            monitor-exit(r10)
            return r11
        L_0x002d:
            monitor-exit(r10)
            return r1
        L_0x002f:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.discardSampleMetadataTo(long, boolean, boolean):long");
    }

    public synchronized long discardSampleMetadataToRead() {
        int i = this.readPosition;
        if (i == 0) {
            return -1;
        }
        return discardSamples(i);
    }

    private synchronized long discardSampleMetadataToEnd() {
        int i = this.length;
        if (i == 0) {
            return -1;
        }
        return discardSamples(i);
    }

    private void releaseDrmSessionReferences() {
        DrmSession drmSession = this.currentDrmSession;
        if (drmSession != null) {
            drmSession.release(this.drmEventDispatcher);
            this.currentDrmSession = null;
            this.downstreamFormat = null;
        }
    }

    private synchronized void commitSample(long j, int i, long j2, int i2, TrackOutput.CryptoData cryptoData) {
        DrmSessionManager.DrmSessionReference drmSessionReference;
        int i3 = this.length;
        if (i3 > 0) {
            int relativeIndex = getRelativeIndex(i3 - 1);
            Assertions.checkArgument(this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]) <= j2);
        }
        this.isLastSampleQueued = (536870912 & i) != 0;
        this.largestQueuedTimestampUs = Math.max(this.largestQueuedTimestampUs, j);
        int relativeIndex2 = getRelativeIndex(this.length);
        this.timesUs[relativeIndex2] = j;
        this.offsets[relativeIndex2] = j2;
        this.sizes[relativeIndex2] = i2;
        this.flags[relativeIndex2] = i;
        this.cryptoDatas[relativeIndex2] = cryptoData;
        this.sourceIds[relativeIndex2] = this.upstreamSourceId;
        if (this.sharedSampleMetadata.isEmpty() || !this.sharedSampleMetadata.getEndValue().format.equals(this.upstreamFormat)) {
            DrmSessionManager drmSessionManager2 = this.drmSessionManager;
            if (drmSessionManager2 != null) {
                drmSessionReference = drmSessionManager2.preacquireSession(this.drmEventDispatcher, this.upstreamFormat);
            } else {
                drmSessionReference = DrmSessionManager.DrmSessionReference.EMPTY;
            }
            this.sharedSampleMetadata.appendSpan(getWriteIndex(), new SharedSampleMetadata((Format) Assertions.checkNotNull(this.upstreamFormat), drmSessionReference));
        }
        int i4 = this.length + 1;
        this.length = i4;
        int i5 = this.capacity;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            TrackOutput.CryptoData[] cryptoDataArr = new TrackOutput.CryptoData[i6];
            int i7 = this.relativeFirstIndex;
            int i8 = i5 - i7;
            System.arraycopy(this.offsets, i7, jArr, 0, i8);
            System.arraycopy(this.timesUs, this.relativeFirstIndex, jArr2, 0, i8);
            System.arraycopy(this.flags, this.relativeFirstIndex, iArr2, 0, i8);
            System.arraycopy(this.sizes, this.relativeFirstIndex, iArr3, 0, i8);
            System.arraycopy(this.cryptoDatas, this.relativeFirstIndex, cryptoDataArr, 0, i8);
            System.arraycopy(this.sourceIds, this.relativeFirstIndex, iArr, 0, i8);
            int i9 = this.relativeFirstIndex;
            System.arraycopy(this.offsets, 0, jArr, i8, i9);
            System.arraycopy(this.timesUs, 0, jArr2, i8, i9);
            System.arraycopy(this.flags, 0, iArr2, i8, i9);
            System.arraycopy(this.sizes, 0, iArr3, i8, i9);
            System.arraycopy(this.cryptoDatas, 0, cryptoDataArr, i8, i9);
            System.arraycopy(this.sourceIds, 0, iArr, i8, i9);
            this.offsets = jArr;
            this.timesUs = jArr2;
            this.flags = iArr2;
            this.sizes = iArr3;
            this.cryptoDatas = cryptoDataArr;
            this.sourceIds = iArr;
            this.relativeFirstIndex = 0;
            this.capacity = i6;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0010, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean attemptSplice(long r6) {
        /*
            r5 = this;
            monitor-enter(r5)
            int r0 = r5.length     // Catch:{ all -> 0x0027 }
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0011
            long r3 = r5.largestDiscardedTimestampUs     // Catch:{ all -> 0x0027 }
            int r6 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r6 <= 0) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = r2
        L_0x000f:
            monitor-exit(r5)
            return r1
        L_0x0011:
            long r3 = r5.getLargestReadTimestampUs()     // Catch:{ all -> 0x0027 }
            int r0 = (r3 > r6 ? 1 : (r3 == r6 ? 0 : -1))
            if (r0 < 0) goto L_0x001b
            monitor-exit(r5)
            return r2
        L_0x001b:
            int r6 = r5.countUnreadSamplesBefore(r6)     // Catch:{ all -> 0x0027 }
            int r7 = r5.absoluteFirstIndex     // Catch:{ all -> 0x0027 }
            int r7 = r7 + r6
            r5.discardUpstreamSampleMetadata(r7)     // Catch:{ all -> 0x0027 }
            monitor-exit(r5)
            return r1
        L_0x0027:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.source.SampleQueue.attemptSplice(long):boolean");
    }

    private long discardUpstreamSampleMetadata(int i) {
        int writeIndex = getWriteIndex() - i;
        boolean z = false;
        Assertions.checkArgument(writeIndex >= 0 && writeIndex <= this.length - this.readPosition);
        int i2 = this.length - writeIndex;
        this.length = i2;
        this.largestQueuedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i2));
        if (writeIndex == 0 && this.isLastSampleQueued) {
            z = true;
        }
        this.isLastSampleQueued = z;
        this.sharedSampleMetadata.discardFrom(i);
        int i3 = this.length;
        if (i3 == 0) {
            return 0;
        }
        int relativeIndex = getRelativeIndex(i3 - 1);
        return this.offsets[relativeIndex] + ((long) this.sizes[relativeIndex]);
    }

    private boolean hasNextSample() {
        return this.readPosition != this.length;
    }

    private void onFormatResult(Format format, FormatHolder formatHolder) {
        DrmInitData drmInitData;
        Format format2 = this.downstreamFormat;
        boolean z = format2 == null;
        if (z) {
            drmInitData = null;
        } else {
            drmInitData = format2.drmInitData;
        }
        this.downstreamFormat = format;
        DrmInitData drmInitData2 = format.drmInitData;
        DrmSessionManager drmSessionManager2 = this.drmSessionManager;
        formatHolder.format = drmSessionManager2 != null ? format.copyWithCryptoType(drmSessionManager2.getCryptoType(format)) : format;
        formatHolder.drmSession = this.currentDrmSession;
        if (this.drmSessionManager != null) {
            if (z || !Util.areEqual(drmInitData, drmInitData2)) {
                DrmSession drmSession = this.currentDrmSession;
                DrmSession acquireSession = this.drmSessionManager.acquireSession(this.drmEventDispatcher, format);
                this.currentDrmSession = acquireSession;
                formatHolder.drmSession = acquireSession;
                if (drmSession != null) {
                    drmSession.release(this.drmEventDispatcher);
                }
            }
        }
    }

    private boolean mayReadSample(int i) {
        DrmSession drmSession = this.currentDrmSession;
        return drmSession == null || drmSession.getState() == 4 || ((this.flags[i] & 1073741824) == 0 && this.currentDrmSession.playClearSamplesWithoutKeys());
    }

    private int findSampleBefore(int i, int i2, long j, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j2 = this.timesUs[i];
            if (j2 > j) {
                return i3;
            }
            if (!z || (this.flags[i] & 1) != 0) {
                if (j2 == j) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.capacity) {
                i = 0;
            }
        }
        return i3;
    }

    private int countUnreadSamplesBefore(long j) {
        int i = this.length;
        int relativeIndex = getRelativeIndex(i - 1);
        while (i > this.readPosition && this.timesUs[relativeIndex] >= j) {
            i--;
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return i;
    }

    private long discardSamples(int i) {
        this.largestDiscardedTimestampUs = Math.max(this.largestDiscardedTimestampUs, getLargestTimestamp(i));
        this.length -= i;
        int i2 = this.absoluteFirstIndex + i;
        this.absoluteFirstIndex = i2;
        int i3 = this.relativeFirstIndex + i;
        this.relativeFirstIndex = i3;
        int i4 = this.capacity;
        if (i3 >= i4) {
            this.relativeFirstIndex = i3 - i4;
        }
        int i5 = this.readPosition - i;
        this.readPosition = i5;
        if (i5 < 0) {
            this.readPosition = 0;
        }
        this.sharedSampleMetadata.discardTo(i2);
        if (this.length != 0) {
            return this.offsets[this.relativeFirstIndex];
        }
        int i6 = this.relativeFirstIndex;
        if (i6 == 0) {
            i6 = this.capacity;
        }
        int i7 = i6 - 1;
        return this.offsets[i7] + ((long) this.sizes[i7]);
    }

    private long getLargestTimestamp(int i) {
        long j = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int relativeIndex = getRelativeIndex(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            j = Math.max(j, this.timesUs[relativeIndex]);
            if ((this.flags[relativeIndex] & 1) != 0) {
                break;
            }
            relativeIndex--;
            if (relativeIndex == -1) {
                relativeIndex = this.capacity - 1;
            }
        }
        return j;
    }

    private int getRelativeIndex(int i) {
        int i2 = this.relativeFirstIndex + i;
        int i3 = this.capacity;
        return i2 < i3 ? i2 : i2 - i3;
    }

    static final class SampleExtrasHolder {
        public TrackOutput.CryptoData cryptoData;
        public long offset;
        public int size;

        SampleExtrasHolder() {
        }
    }

    private static final class SharedSampleMetadata {
        public final DrmSessionManager.DrmSessionReference drmSessionReference;
        public final Format format;

        private SharedSampleMetadata(Format format2, DrmSessionManager.DrmSessionReference drmSessionReference2) {
            this.format = format2;
            this.drmSessionReference = drmSessionReference2;
        }
    }
}
