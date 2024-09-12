package com.google.android.exoplayer2.analytics;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.source.rtsp.RtspMediaSource;
import java.util.Collections;
import java.util.List;

public final class PlaybackStats {
    public static final PlaybackStats EMPTY = merge(new PlaybackStats[0]);
    public static final int PLAYBACK_STATE_ABANDONED = 15;
    public static final int PLAYBACK_STATE_BUFFERING = 6;
    static final int PLAYBACK_STATE_COUNT = 16;
    public static final int PLAYBACK_STATE_ENDED = 11;
    public static final int PLAYBACK_STATE_FAILED = 13;
    public static final int PLAYBACK_STATE_INTERRUPTED_BY_AD = 14;
    public static final int PLAYBACK_STATE_JOINING_BACKGROUND = 1;
    public static final int PLAYBACK_STATE_JOINING_FOREGROUND = 2;
    public static final int PLAYBACK_STATE_NOT_STARTED = 0;
    public static final int PLAYBACK_STATE_PAUSED = 4;
    public static final int PLAYBACK_STATE_PAUSED_BUFFERING = 7;
    public static final int PLAYBACK_STATE_PLAYING = 3;
    public static final int PLAYBACK_STATE_SEEKING = 5;
    public static final int PLAYBACK_STATE_STOPPED = 12;
    public static final int PLAYBACK_STATE_SUPPRESSED = 9;
    public static final int PLAYBACK_STATE_SUPPRESSED_BUFFERING = 10;
    public final int abandonedBeforeReadyCount;
    public final int adPlaybackCount;
    public final List<EventTimeAndFormat> audioFormatHistory;
    public final int backgroundJoiningCount;
    public final int endedCount;
    public final int fatalErrorCount;
    public final List<EventTimeAndException> fatalErrorHistory;
    public final int fatalErrorPlaybackCount;
    public final long firstReportedTimeMs;
    public final int foregroundPlaybackCount;
    public final int initialAudioFormatBitrateCount;
    public final int initialVideoFormatBitrateCount;
    public final int initialVideoFormatHeightCount;
    public final long maxRebufferTimeMs;
    public final List<long[]> mediaTimeHistory;
    public final int nonFatalErrorCount;
    public final List<EventTimeAndException> nonFatalErrorHistory;
    public final int playbackCount;
    private final long[] playbackStateDurationsMs;
    public final List<EventTimeAndPlaybackState> playbackStateHistory;
    public final long totalAudioFormatBitrateTimeProduct;
    public final long totalAudioFormatTimeMs;
    public final long totalAudioUnderruns;
    public final long totalBandwidthBytes;
    public final long totalBandwidthTimeMs;
    public final long totalDroppedFrames;
    public final long totalInitialAudioFormatBitrate;
    public final long totalInitialVideoFormatBitrate;
    public final int totalInitialVideoFormatHeight;
    public final int totalPauseBufferCount;
    public final int totalPauseCount;
    public final int totalRebufferCount;
    public final int totalSeekCount;
    public final long totalValidJoinTimeMs;
    public final long totalVideoFormatBitrateTimeMs;
    public final long totalVideoFormatBitrateTimeProduct;
    public final long totalVideoFormatHeightTimeMs;
    public final long totalVideoFormatHeightTimeProduct;
    public final int validJoinTimeCount;
    public final List<EventTimeAndFormat> videoFormatHistory;

    public static final class EventTimeAndPlaybackState {
        public final AnalyticsListener.EventTime eventTime;
        public final int playbackState;

        public EventTimeAndPlaybackState(AnalyticsListener.EventTime eventTime2, int i) {
            this.eventTime = eventTime2;
            this.playbackState = i;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            EventTimeAndPlaybackState eventTimeAndPlaybackState = (EventTimeAndPlaybackState) obj;
            if (this.playbackState != eventTimeAndPlaybackState.playbackState) {
                return false;
            }
            return this.eventTime.equals(eventTimeAndPlaybackState.eventTime);
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.playbackState;
        }
    }

    public static final class EventTimeAndFormat {
        public final AnalyticsListener.EventTime eventTime;
        public final Format format;

        public EventTimeAndFormat(AnalyticsListener.EventTime eventTime2, Format format2) {
            this.eventTime = eventTime2;
            this.format = format2;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            EventTimeAndFormat eventTimeAndFormat = (EventTimeAndFormat) obj;
            if (!this.eventTime.equals(eventTimeAndFormat.eventTime)) {
                return false;
            }
            Format format2 = this.format;
            Format format3 = eventTimeAndFormat.format;
            if (format2 != null) {
                return format2.equals(format3);
            }
            if (format3 == null) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.eventTime.hashCode() * 31;
            Format format2 = this.format;
            return hashCode + (format2 != null ? format2.hashCode() : 0);
        }
    }

    public static final class EventTimeAndException {
        public final AnalyticsListener.EventTime eventTime;
        public final Exception exception;

        public EventTimeAndException(AnalyticsListener.EventTime eventTime2, Exception exc) {
            this.eventTime = eventTime2;
            this.exception = exc;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            EventTimeAndException eventTimeAndException = (EventTimeAndException) obj;
            if (!this.eventTime.equals(eventTimeAndException.eventTime)) {
                return false;
            }
            return this.exception.equals(eventTimeAndException.exception);
        }

        public int hashCode() {
            return (this.eventTime.hashCode() * 31) + this.exception.hashCode();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.analytics.PlaybackStats merge(com.google.android.exoplayer2.analytics.PlaybackStats... r66) {
        /*
            r0 = r66
            r1 = 16
            long[] r4 = new long[r1]
            int r2 = r0.length
            r9 = 0
            r27 = r9
            r29 = r27
            r31 = r29
            r33 = r31
            r35 = r33
            r37 = r35
            r46 = r37
            r48 = r46
            r50 = r48
            r52 = r50
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r25 = 0
            r26 = 0
            r39 = 0
            r40 = 0
            r41 = -1
            r43 = 0
            r44 = -1
            r54 = 0
            r55 = 0
            r58 = -1
            r59 = 0
        L_0x0051:
            if (r11 >= r2) goto L_0x0156
            r3 = r0[r11]
            int r7 = r3.playbackCount
            int r9 = r9 + r7
            r7 = 0
        L_0x0059:
            if (r7 >= r1) goto L_0x0068
            r62 = r4[r7]
            long[] r8 = r3.playbackStateDurationsMs
            r64 = r8[r7]
            long r62 = r62 + r64
            r4[r7] = r62
            int r7 = r7 + 1
            goto L_0x0059
        L_0x0068:
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r60 = (r12 > r7 ? 1 : (r12 == r7 ? 0 : -1))
            if (r60 != 0) goto L_0x0076
            long r12 = r3.firstReportedTimeMs
            r63 = r2
            goto L_0x0082
        L_0x0076:
            r63 = r2
            long r1 = r3.firstReportedTimeMs
            int r64 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r64 == 0) goto L_0x0082
            long r12 = java.lang.Math.min(r12, r1)
        L_0x0082:
            int r1 = r3.foregroundPlaybackCount
            int r10 = r10 + r1
            int r1 = r3.abandonedBeforeReadyCount
            int r14 = r14 + r1
            int r1 = r3.endedCount
            int r15 = r15 + r1
            int r1 = r3.backgroundJoiningCount
            int r16 = r16 + r1
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r17 > r1 ? 1 : (r17 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x009d
            long r7 = r3.totalValidJoinTimeMs
            r17 = r7
            goto L_0x00a5
        L_0x009d:
            long r7 = r3.totalValidJoinTimeMs
            int r64 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r64 == 0) goto L_0x00a5
            long r17 = r17 + r7
        L_0x00a5:
            int r1 = r3.validJoinTimeCount
            int r19 = r19 + r1
            int r1 = r3.totalPauseCount
            int r20 = r20 + r1
            int r1 = r3.totalPauseBufferCount
            int r21 = r21 + r1
            int r1 = r3.totalSeekCount
            int r22 = r22 + r1
            int r1 = r3.totalRebufferCount
            int r25 = r25 + r1
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x00c5
            long r5 = r3.maxRebufferTimeMs
            goto L_0x00cf
        L_0x00c5:
            long r7 = r3.maxRebufferTimeMs
            int r60 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r60 == 0) goto L_0x00cf
            long r5 = java.lang.Math.max(r5, r7)
        L_0x00cf:
            int r7 = r3.adPlaybackCount
            int r26 = r26 + r7
            long r7 = r3.totalVideoFormatHeightTimeMs
            long r27 = r27 + r7
            long r7 = r3.totalVideoFormatHeightTimeProduct
            long r29 = r29 + r7
            long r7 = r3.totalVideoFormatBitrateTimeMs
            long r31 = r31 + r7
            long r7 = r3.totalVideoFormatBitrateTimeProduct
            long r33 = r33 + r7
            long r7 = r3.totalAudioFormatTimeMs
            long r35 = r35 + r7
            long r7 = r3.totalAudioFormatBitrateTimeProduct
            long r37 = r37 + r7
            int r7 = r3.initialVideoFormatHeightCount
            int r39 = r39 + r7
            int r7 = r3.initialVideoFormatBitrateCount
            int r40 = r40 + r7
            r7 = r58
            r8 = -1
            if (r7 != r8) goto L_0x00fb
            int r7 = r3.totalInitialVideoFormatHeight
            goto L_0x0102
        L_0x00fb:
            int r1 = r3.totalInitialVideoFormatHeight
            if (r1 == r8) goto L_0x0102
            int r58 = r7 + r1
            goto L_0x0104
        L_0x0102:
            r58 = r7
        L_0x0104:
            r1 = -1
            int r7 = (r41 > r1 ? 1 : (r41 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0111
            r23 = r9
            long r8 = r3.totalInitialVideoFormatBitrate
            r41 = r8
            goto L_0x011b
        L_0x0111:
            r23 = r9
            long r7 = r3.totalInitialVideoFormatBitrate
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x011b
            long r41 = r41 + r7
        L_0x011b:
            int r7 = r3.initialAudioFormatBitrateCount
            int r43 = r43 + r7
            int r7 = (r44 > r1 ? 1 : (r44 == r1 ? 0 : -1))
            if (r7 != 0) goto L_0x0128
            long r7 = r3.totalInitialAudioFormatBitrate
            r44 = r7
            goto L_0x0130
        L_0x0128:
            long r7 = r3.totalInitialAudioFormatBitrate
            int r9 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r9 == 0) goto L_0x0130
            long r44 = r44 + r7
        L_0x0130:
            long r7 = r3.totalBandwidthTimeMs
            long r46 = r46 + r7
            long r7 = r3.totalBandwidthBytes
            long r48 = r48 + r7
            long r7 = r3.totalDroppedFrames
            long r50 = r50 + r7
            long r7 = r3.totalAudioUnderruns
            long r52 = r52 + r7
            int r7 = r3.fatalErrorPlaybackCount
            int r54 = r54 + r7
            int r7 = r3.fatalErrorCount
            int r55 = r55 + r7
            int r3 = r3.nonFatalErrorCount
            int r59 = r59 + r3
            int r11 = r11 + 1
            r9 = r23
            r2 = r63
            r1 = 16
            goto L_0x0051
        L_0x0156:
            r7 = r58
            com.google.android.exoplayer2.analytics.PlaybackStats r0 = new com.google.android.exoplayer2.analytics.PlaybackStats
            r2 = r0
            java.util.List r1 = java.util.Collections.emptyList()
            r60 = r5
            r5 = r1
            java.util.List r6 = java.util.Collections.emptyList()
            java.util.List r23 = java.util.Collections.emptyList()
            java.util.List r24 = java.util.Collections.emptyList()
            java.util.List r56 = java.util.Collections.emptyList()
            java.util.List r57 = java.util.Collections.emptyList()
            r3 = r9
            r7 = r12
            r9 = r10
            r10 = r14
            r11 = r15
            r12 = r16
            r13 = r17
            r15 = r19
            r16 = r20
            r17 = r21
            r18 = r22
            r19 = r25
            r20 = r60
            r22 = r26
            r25 = r27
            r27 = r29
            r29 = r31
            r31 = r33
            r33 = r35
            r35 = r37
            r37 = r39
            r38 = r40
            r39 = r58
            r40 = r41
            r42 = r43
            r43 = r44
            r45 = r46
            r47 = r48
            r49 = r50
            r51 = r52
            r53 = r54
            r54 = r55
            r55 = r59
            r2.<init>(r3, r4, r5, r6, r7, r9, r10, r11, r12, r13, r15, r16, r17, r18, r19, r20, r22, r23, r24, r25, r27, r29, r31, r33, r35, r37, r38, r39, r40, r42, r43, r45, r47, r49, r51, r53, r54, r55, r56, r57)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.analytics.PlaybackStats.merge(com.google.android.exoplayer2.analytics.PlaybackStats[]):com.google.android.exoplayer2.analytics.PlaybackStats");
    }

    PlaybackStats(int i, long[] jArr, List<EventTimeAndPlaybackState> list, List<long[]> list2, long j, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int i8, int i9, int i10, long j3, int i11, List<EventTimeAndFormat> list3, List<EventTimeAndFormat> list4, long j4, long j5, long j6, long j7, long j8, long j9, int i12, int i13, int i14, long j10, int i15, long j11, long j12, long j13, long j14, long j15, int i16, int i17, int i18, List<EventTimeAndException> list5, List<EventTimeAndException> list6) {
        this.playbackCount = i;
        this.playbackStateDurationsMs = jArr;
        this.playbackStateHistory = Collections.unmodifiableList(list);
        this.mediaTimeHistory = Collections.unmodifiableList(list2);
        this.firstReportedTimeMs = j;
        this.foregroundPlaybackCount = i2;
        this.abandonedBeforeReadyCount = i3;
        this.endedCount = i4;
        this.backgroundJoiningCount = i5;
        this.totalValidJoinTimeMs = j2;
        this.validJoinTimeCount = i6;
        this.totalPauseCount = i7;
        this.totalPauseBufferCount = i8;
        this.totalSeekCount = i9;
        this.totalRebufferCount = i10;
        this.maxRebufferTimeMs = j3;
        this.adPlaybackCount = i11;
        this.videoFormatHistory = Collections.unmodifiableList(list3);
        this.audioFormatHistory = Collections.unmodifiableList(list4);
        this.totalVideoFormatHeightTimeMs = j4;
        this.totalVideoFormatHeightTimeProduct = j5;
        this.totalVideoFormatBitrateTimeMs = j6;
        this.totalVideoFormatBitrateTimeProduct = j7;
        this.totalAudioFormatTimeMs = j8;
        this.totalAudioFormatBitrateTimeProduct = j9;
        this.initialVideoFormatHeightCount = i12;
        this.initialVideoFormatBitrateCount = i13;
        this.totalInitialVideoFormatHeight = i14;
        this.totalInitialVideoFormatBitrate = j10;
        this.initialAudioFormatBitrateCount = i15;
        this.totalInitialAudioFormatBitrate = j11;
        this.totalBandwidthTimeMs = j12;
        this.totalBandwidthBytes = j13;
        this.totalDroppedFrames = j14;
        this.totalAudioUnderruns = j15;
        this.fatalErrorPlaybackCount = i16;
        this.fatalErrorCount = i17;
        this.nonFatalErrorCount = i18;
        this.fatalErrorHistory = Collections.unmodifiableList(list5);
        this.nonFatalErrorHistory = Collections.unmodifiableList(list6);
    }

    public long getPlaybackStateDurationMs(int i) {
        return this.playbackStateDurationsMs[i];
    }

    public int getPlaybackStateAtTime(long j) {
        int i = 0;
        for (EventTimeAndPlaybackState next : this.playbackStateHistory) {
            if (next.eventTime.realtimeMs > j) {
                break;
            }
            i = next.playbackState;
        }
        return i;
    }

    public long getMediaTimeMsAtRealtimeMs(long j) {
        if (this.mediaTimeHistory.isEmpty()) {
            return C.TIME_UNSET;
        }
        int i = 0;
        while (i < this.mediaTimeHistory.size() && this.mediaTimeHistory.get(i)[0] <= j) {
            i++;
        }
        if (i == 0) {
            return this.mediaTimeHistory.get(0)[1];
        }
        if (i == this.mediaTimeHistory.size()) {
            List<long[]> list = this.mediaTimeHistory;
            return list.get(list.size() - 1)[1];
        }
        int i2 = i - 1;
        long j2 = this.mediaTimeHistory.get(i2)[0];
        long j3 = this.mediaTimeHistory.get(i2)[1];
        long j4 = this.mediaTimeHistory.get(i)[0];
        long j5 = this.mediaTimeHistory.get(i)[1];
        long j6 = j4 - j2;
        if (j6 == 0) {
            return j3;
        }
        return j3 + ((long) (((float) (j5 - j3)) * (((float) (j - j2)) / ((float) j6))));
    }

    public long getMeanJoinTimeMs() {
        int i = this.validJoinTimeCount;
        return i == 0 ? C.TIME_UNSET : this.totalValidJoinTimeMs / ((long) i);
    }

    public long getTotalJoinTimeMs() {
        return getPlaybackStateDurationMs(2);
    }

    public long getTotalPlayTimeMs() {
        return getPlaybackStateDurationMs(3);
    }

    public long getMeanPlayTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalPlayTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getTotalPausedTimeMs() {
        return getPlaybackStateDurationMs(4) + getPlaybackStateDurationMs(7);
    }

    public long getMeanPausedTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalPausedTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getTotalRebufferTimeMs() {
        return getPlaybackStateDurationMs(6);
    }

    public long getMeanRebufferTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalRebufferTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMeanSingleRebufferTimeMs() {
        if (this.totalRebufferCount == 0) {
            return C.TIME_UNSET;
        }
        return (getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(7)) / ((long) this.totalRebufferCount);
    }

    public long getTotalSeekTimeMs() {
        return getPlaybackStateDurationMs(5);
    }

    public long getMeanSeekTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalSeekTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getMeanSingleSeekTimeMs() {
        return this.totalSeekCount == 0 ? C.TIME_UNSET : getTotalSeekTimeMs() / ((long) this.totalSeekCount);
    }

    public long getTotalWaitTimeMs() {
        return getPlaybackStateDurationMs(2) + getPlaybackStateDurationMs(6) + getPlaybackStateDurationMs(5);
    }

    public long getMeanWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getTotalPlayAndWaitTimeMs() {
        return getTotalPlayTimeMs() + getTotalWaitTimeMs();
    }

    public long getMeanPlayAndWaitTimeMs() {
        if (this.foregroundPlaybackCount == 0) {
            return C.TIME_UNSET;
        }
        return getTotalPlayAndWaitTimeMs() / ((long) this.foregroundPlaybackCount);
    }

    public long getTotalElapsedTimeMs() {
        long j = 0;
        for (int i = 0; i < 16; i++) {
            j += this.playbackStateDurationsMs[i];
        }
        return j;
    }

    public long getMeanElapsedTimeMs() {
        return this.playbackCount == 0 ? C.TIME_UNSET : getTotalElapsedTimeMs() / ((long) this.playbackCount);
    }

    public float getAbandonedBeforeReadyRatio() {
        int i = this.abandonedBeforeReadyCount;
        int i2 = this.playbackCount;
        int i3 = this.foregroundPlaybackCount;
        int i4 = i - (i2 - i3);
        if (i3 == 0) {
            return 0.0f;
        }
        return ((float) i4) / ((float) i3);
    }

    public float getEndedRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.endedCount) / ((float) i);
    }

    public float getMeanPauseCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseCount) / ((float) i);
    }

    public float getMeanPauseBufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalPauseBufferCount) / ((float) i);
    }

    public float getMeanSeekCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalSeekCount) / ((float) i);
    }

    public float getMeanRebufferCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.totalRebufferCount) / ((float) i);
    }

    public float getWaitTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalWaitTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public float getJoinTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalJoinTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public float getRebufferTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalRebufferTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public float getSeekTimeRatio() {
        long totalPlayAndWaitTimeMs = getTotalPlayAndWaitTimeMs();
        if (totalPlayAndWaitTimeMs == 0) {
            return 0.0f;
        }
        return ((float) getTotalSeekTimeMs()) / ((float) totalPlayAndWaitTimeMs);
    }

    public float getRebufferRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalRebufferCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getMeanTimeBetweenRebuffers() {
        return 1.0f / getRebufferRate();
    }

    public int getMeanInitialVideoFormatHeight() {
        int i = this.initialVideoFormatHeightCount;
        if (i == 0) {
            return -1;
        }
        return this.totalInitialVideoFormatHeight / i;
    }

    public int getMeanInitialVideoFormatBitrate() {
        int i = this.initialVideoFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialVideoFormatBitrate / ((long) i));
    }

    public int getMeanInitialAudioFormatBitrate() {
        int i = this.initialAudioFormatBitrateCount;
        if (i == 0) {
            return -1;
        }
        return (int) (this.totalInitialAudioFormatBitrate / ((long) i));
    }

    public int getMeanVideoFormatHeight() {
        long j = this.totalVideoFormatHeightTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatHeightTimeProduct / j);
    }

    public int getMeanVideoFormatBitrate() {
        long j = this.totalVideoFormatBitrateTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalVideoFormatBitrateTimeProduct / j);
    }

    public int getMeanAudioFormatBitrate() {
        long j = this.totalAudioFormatTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) (this.totalAudioFormatBitrateTimeProduct / j);
    }

    public int getMeanBandwidth() {
        long j = this.totalBandwidthTimeMs;
        if (j == 0) {
            return -1;
        }
        return (int) ((this.totalBandwidthBytes * RtspMediaSource.DEFAULT_TIMEOUT_MS) / j);
    }

    public float getDroppedFramesRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalDroppedFrames) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getAudioUnderrunRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.totalAudioUnderruns) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getFatalErrorRatio() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.fatalErrorPlaybackCount) / ((float) i);
    }

    public float getFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.fatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getMeanTimeBetweenFatalErrors() {
        return 1.0f / getFatalErrorRate();
    }

    public float getMeanNonFatalErrorCount() {
        int i = this.foregroundPlaybackCount;
        if (i == 0) {
            return 0.0f;
        }
        return ((float) this.nonFatalErrorCount) / ((float) i);
    }

    public float getNonFatalErrorRate() {
        long totalPlayTimeMs = getTotalPlayTimeMs();
        if (totalPlayTimeMs == 0) {
            return 0.0f;
        }
        return (((float) this.nonFatalErrorCount) * 1000.0f) / ((float) totalPlayTimeMs);
    }

    public float getMeanTimeBetweenNonFatalErrors() {
        return 1.0f / getNonFatalErrorRate();
    }
}
