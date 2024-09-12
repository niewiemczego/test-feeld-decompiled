package com.google.android.exoplayer2.analytics;

import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.PlaybackSessionManager;
import com.google.android.exoplayer2.analytics.PlaybackStats;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class PlaybackStatsListener implements AnalyticsListener, PlaybackSessionManager.Listener {
    private Format audioFormat;
    private long bandwidthBytes;
    private long bandwidthTimeMs;
    private final Callback callback;
    private long discontinuityFromPositionMs;
    private String discontinuityFromSession;
    private int discontinuityReason;
    private int droppedFrames;
    private PlaybackStats finishedPlaybackStats = PlaybackStats.EMPTY;
    private final boolean keepHistory;
    private Exception nonFatalException;
    private final Timeline.Period period = new Timeline.Period();
    private final Map<String, PlaybackStatsTracker> playbackStatsTrackers = new HashMap();
    private final PlaybackSessionManager sessionManager;
    private final Map<String, AnalyticsListener.EventTime> sessionStartEventTimes = new HashMap();
    private Format videoFormat;
    private VideoSize videoSize = VideoSize.UNKNOWN;

    public interface Callback {
        void onPlaybackStatsReady(AnalyticsListener.EventTime eventTime, PlaybackStats playbackStats);
    }

    public PlaybackStatsListener(boolean z, Callback callback2) {
        this.callback = callback2;
        this.keepHistory = z;
        DefaultPlaybackSessionManager defaultPlaybackSessionManager = new DefaultPlaybackSessionManager();
        this.sessionManager = defaultPlaybackSessionManager;
        defaultPlaybackSessionManager.setListener(this);
    }

    public PlaybackStats getCombinedPlaybackStats() {
        int i = 1;
        PlaybackStats[] playbackStatsArr = new PlaybackStats[(this.playbackStatsTrackers.size() + 1)];
        playbackStatsArr[0] = this.finishedPlaybackStats;
        for (PlaybackStatsTracker build : this.playbackStatsTrackers.values()) {
            playbackStatsArr[i] = build.build(false);
            i++;
        }
        return PlaybackStats.merge(playbackStatsArr);
    }

    public PlaybackStats getPlaybackStats() {
        PlaybackStatsTracker playbackStatsTracker;
        String activeSessionId = this.sessionManager.getActiveSessionId();
        if (activeSessionId == null) {
            playbackStatsTracker = null;
        } else {
            playbackStatsTracker = this.playbackStatsTrackers.get(activeSessionId);
        }
        if (playbackStatsTracker == null) {
            return null;
        }
        return playbackStatsTracker.build(false);
    }

    public void onSessionCreated(AnalyticsListener.EventTime eventTime, String str) {
        this.playbackStatsTrackers.put(str, new PlaybackStatsTracker(this.keepHistory, eventTime));
        this.sessionStartEventTimes.put(str, eventTime);
    }

    public void onSessionActive(AnalyticsListener.EventTime eventTime, String str) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onForeground();
    }

    public void onAdPlaybackStarted(AnalyticsListener.EventTime eventTime, String str, String str2) {
        ((PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.get(str))).onInterruptedByAd();
    }

    public void onSessionFinished(AnalyticsListener.EventTime eventTime, String str, boolean z) {
        PlaybackStatsTracker playbackStatsTracker = (PlaybackStatsTracker) Assertions.checkNotNull(this.playbackStatsTrackers.remove(str));
        AnalyticsListener.EventTime eventTime2 = (AnalyticsListener.EventTime) Assertions.checkNotNull(this.sessionStartEventTimes.remove(str));
        playbackStatsTracker.onFinished(eventTime, z, str.equals(this.discontinuityFromSession) ? this.discontinuityFromPositionMs : C.TIME_UNSET);
        PlaybackStats build = playbackStatsTracker.build(true);
        this.finishedPlaybackStats = PlaybackStats.merge(this.finishedPlaybackStats, build);
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onPlaybackStatsReady(eventTime2, build);
        }
    }

    public void onPositionDiscontinuity(AnalyticsListener.EventTime eventTime, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        if (this.discontinuityFromSession == null) {
            this.discontinuityFromSession = this.sessionManager.getActiveSessionId();
            this.discontinuityFromPositionMs = positionInfo.positionMs;
        }
        this.discontinuityReason = i;
    }

    public void onDroppedVideoFrames(AnalyticsListener.EventTime eventTime, int i, long j) {
        this.droppedFrames = i;
    }

    public void onLoadError(AnalyticsListener.EventTime eventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        this.nonFatalException = iOException;
    }

    public void onDrmSessionManagerError(AnalyticsListener.EventTime eventTime, Exception exc) {
        this.nonFatalException = exc;
    }

    public void onBandwidthEstimate(AnalyticsListener.EventTime eventTime, int i, long j, long j2) {
        this.bandwidthTimeMs = (long) i;
        this.bandwidthBytes = j;
    }

    public void onDownstreamFormatChanged(AnalyticsListener.EventTime eventTime, MediaLoadData mediaLoadData) {
        if (mediaLoadData.trackType == 2 || mediaLoadData.trackType == 0) {
            this.videoFormat = mediaLoadData.trackFormat;
        } else if (mediaLoadData.trackType == 1) {
            this.audioFormat = mediaLoadData.trackFormat;
        }
    }

    public void onVideoSizeChanged(AnalyticsListener.EventTime eventTime, VideoSize videoSize2) {
        this.videoSize = videoSize2;
    }

    public void onEvents(Player player, AnalyticsListener.Events events) {
        VideoSize videoSize2;
        AnalyticsListener.Events events2 = events;
        if (events.size() != 0) {
            maybeAddSessions(events2);
            for (String next : this.playbackStatsTrackers.keySet()) {
                Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime = findBestEventTime(events2, next);
                PlaybackStatsTracker playbackStatsTracker = this.playbackStatsTrackers.get(next);
                boolean hasEvent = hasEvent(events2, next, 11);
                boolean hasEvent2 = hasEvent(events2, next, 1018);
                boolean hasEvent3 = hasEvent(events2, next, 1011);
                boolean hasEvent4 = hasEvent(events2, next, 1000);
                boolean hasEvent5 = hasEvent(events2, next, 10);
                boolean z = hasEvent(events2, next, 1003) || hasEvent(events2, next, 1024);
                boolean hasEvent6 = hasEvent(events2, next, 1006);
                boolean hasEvent7 = hasEvent(events2, next, 1004);
                boolean hasEvent8 = hasEvent(events2, next, 25);
                AnalyticsListener.EventTime eventTime = (AnalyticsListener.EventTime) findBestEventTime.first;
                boolean booleanValue = ((Boolean) findBestEventTime.second).booleanValue();
                long j = next.equals(this.discontinuityFromSession) ? this.discontinuityFromPositionMs : C.TIME_UNSET;
                int i = hasEvent2 ? this.droppedFrames : 0;
                PlaybackException playerError = hasEvent5 ? player.getPlayerError() : null;
                Exception exc = z ? this.nonFatalException : null;
                long j2 = hasEvent6 ? this.bandwidthTimeMs : 0;
                long j3 = hasEvent6 ? this.bandwidthBytes : 0;
                Format format = hasEvent7 ? this.videoFormat : null;
                Format format2 = hasEvent7 ? this.audioFormat : null;
                if (hasEvent8) {
                    videoSize2 = this.videoSize;
                } else {
                    videoSize2 = null;
                }
                playbackStatsTracker.onEvents(player, eventTime, booleanValue, j, hasEvent, i, hasEvent3, hasEvent4, playerError, exc, j2, j3, format, format2, videoSize2);
            }
            this.videoFormat = null;
            this.audioFormat = null;
            this.discontinuityFromSession = null;
            if (events2.contains(AnalyticsListener.EVENT_PLAYER_RELEASED)) {
                this.sessionManager.finishAllSessions(events2.getEventTime(AnalyticsListener.EVENT_PLAYER_RELEASED));
            }
        }
    }

    private void maybeAddSessions(AnalyticsListener.Events events) {
        for (int i = 0; i < events.size(); i++) {
            int i2 = events.get(i);
            AnalyticsListener.EventTime eventTime = events.getEventTime(i2);
            if (i2 == 0) {
                this.sessionManager.updateSessionsWithTimelineChange(eventTime);
            } else if (i2 == 11) {
                this.sessionManager.updateSessionsWithDiscontinuity(eventTime, this.discontinuityReason);
            } else {
                this.sessionManager.updateSessions(eventTime);
            }
        }
    }

    private Pair<AnalyticsListener.EventTime, Boolean> findBestEventTime(AnalyticsListener.Events events, String str) {
        AnalyticsListener.Events events2 = events;
        String str2 = str;
        AnalyticsListener.EventTime eventTime = null;
        boolean z = false;
        for (int i = 0; i < events.size(); i++) {
            AnalyticsListener.EventTime eventTime2 = events2.getEventTime(events2.get(i));
            boolean belongsToSession = this.sessionManager.belongsToSession(eventTime2, str2);
            if (eventTime == null || ((belongsToSession && !z) || (belongsToSession == z && eventTime2.realtimeMs > eventTime.realtimeMs))) {
                eventTime = eventTime2;
                z = belongsToSession;
            }
        }
        Assertions.checkNotNull(eventTime);
        if (!z && eventTime.mediaPeriodId != null && eventTime.mediaPeriodId.isAd()) {
            long adGroupTimeUs = eventTime.timeline.getPeriodByUid(eventTime.mediaPeriodId.periodUid, this.period).getAdGroupTimeUs(eventTime.mediaPeriodId.adGroupIndex);
            if (adGroupTimeUs == Long.MIN_VALUE) {
                adGroupTimeUs = this.period.durationUs;
            }
            long positionInWindowUs = adGroupTimeUs + this.period.getPositionInWindowUs();
            AnalyticsListener.EventTime eventTime3 = new AnalyticsListener.EventTime(eventTime.realtimeMs, eventTime.timeline, eventTime.windowIndex, new MediaSource.MediaPeriodId(eventTime.mediaPeriodId.periodUid, eventTime.mediaPeriodId.windowSequenceNumber, eventTime.mediaPeriodId.adGroupIndex), Util.usToMs(positionInWindowUs), eventTime.timeline, eventTime.currentWindowIndex, eventTime.currentMediaPeriodId, eventTime.currentPlaybackPositionMs, eventTime.totalBufferedDurationMs);
            z = this.sessionManager.belongsToSession(eventTime3, str);
            eventTime = eventTime3;
        }
        return Pair.create(eventTime, Boolean.valueOf(z));
    }

    private boolean hasEvent(AnalyticsListener.Events events, String str, int i) {
        return events.contains(i) && this.sessionManager.belongsToSession(events.getEventTime(i), str);
    }

    private static final class PlaybackStatsTracker {
        private long audioFormatBitrateTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> audioFormatHistory;
        private long audioFormatTimeMs;
        private long audioUnderruns;
        private long bandwidthBytes;
        private long bandwidthTimeMs;
        private Format currentAudioFormat;
        private float currentPlaybackSpeed;
        private int currentPlaybackState;
        private long currentPlaybackStateStartTimeMs;
        private Format currentVideoFormat;
        private long droppedFrames;
        private int fatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> fatalErrorHistory;
        private long firstReportedTimeMs;
        private boolean hasBeenReady;
        private boolean hasEnded;
        private boolean hasFatalError;
        private long initialAudioFormatBitrate;
        private long initialVideoFormatBitrate;
        private int initialVideoFormatHeight;
        private final boolean isAd;
        private boolean isForeground;
        private boolean isInterruptedByAd;
        private boolean isJoinTimeInvalid;
        private boolean isSeeking;
        private final boolean keepHistory;
        private long lastAudioFormatStartTimeMs;
        private long lastRebufferStartTimeMs;
        private long lastVideoFormatStartTimeMs;
        private long maxRebufferTimeMs;
        private final List<long[]> mediaTimeHistory;
        private int nonFatalErrorCount;
        private final List<PlaybackStats.EventTimeAndException> nonFatalErrorHistory;
        private int pauseBufferCount;
        private int pauseCount;
        private final long[] playbackStateDurationsMs = new long[16];
        private final List<PlaybackStats.EventTimeAndPlaybackState> playbackStateHistory;
        private int rebufferCount;
        private int seekCount;
        private boolean startedLoading;
        private long videoFormatBitrateTimeMs;
        private long videoFormatBitrateTimeProduct;
        private long videoFormatHeightTimeMs;
        private long videoFormatHeightTimeProduct;
        private final List<PlaybackStats.EventTimeAndFormat> videoFormatHistory;

        private static boolean isInvalidJoinTransition(int i, int i2) {
            return ((i != 1 && i != 2 && i != 14) || i2 == 1 || i2 == 2 || i2 == 14 || i2 == 3 || i2 == 4 || i2 == 9 || i2 == 11) ? false : true;
        }

        private static boolean isPausedState(int i) {
            return i == 4 || i == 7;
        }

        private static boolean isReadyState(int i) {
            return i == 3 || i == 4 || i == 9;
        }

        private static boolean isRebufferingState(int i) {
            return i == 6 || i == 7 || i == 10;
        }

        public PlaybackStatsTracker(boolean z, AnalyticsListener.EventTime eventTime) {
            this.keepHistory = z;
            this.playbackStateHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.mediaTimeHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.videoFormatHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.audioFormatHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.fatalErrorHistory = z ? new ArrayList<>() : Collections.emptyList();
            this.nonFatalErrorHistory = z ? new ArrayList<>() : Collections.emptyList();
            boolean z2 = false;
            this.currentPlaybackState = 0;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            this.firstReportedTimeMs = C.TIME_UNSET;
            this.maxRebufferTimeMs = C.TIME_UNSET;
            if (eventTime.mediaPeriodId != null && eventTime.mediaPeriodId.isAd()) {
                z2 = true;
            }
            this.isAd = z2;
            this.initialAudioFormatBitrate = -1;
            this.initialVideoFormatBitrate = -1;
            this.initialVideoFormatHeight = -1;
            this.currentPlaybackSpeed = 1.0f;
        }

        public void onForeground() {
            this.isForeground = true;
        }

        public void onInterruptedByAd() {
            this.isInterruptedByAd = true;
            this.isSeeking = false;
        }

        public void onFinished(AnalyticsListener.EventTime eventTime, boolean z, long j) {
            int i = 11;
            if (this.currentPlaybackState != 11 && !z) {
                i = 15;
            }
            maybeUpdateMediaTimeHistory(eventTime.realtimeMs, j);
            maybeRecordVideoFormatTime(eventTime.realtimeMs);
            maybeRecordAudioFormatTime(eventTime.realtimeMs);
            updatePlaybackState(i, eventTime);
        }

        public void onEvents(Player player, AnalyticsListener.EventTime eventTime, boolean z, long j, boolean z2, int i, boolean z3, boolean z4, PlaybackException playbackException, Exception exc, long j2, long j3, Format format, Format format2, VideoSize videoSize) {
            AnalyticsListener.EventTime eventTime2 = eventTime;
            long j4 = j;
            PlaybackException playbackException2 = playbackException;
            Exception exc2 = exc;
            Format format3 = format;
            Format format4 = format2;
            VideoSize videoSize2 = videoSize;
            long j5 = C.TIME_UNSET;
            if (j4 != C.TIME_UNSET) {
                maybeUpdateMediaTimeHistory(eventTime2.realtimeMs, j4);
                this.isSeeking = true;
            }
            if (player.getPlaybackState() != 2) {
                this.isSeeking = false;
            }
            int playbackState = player.getPlaybackState();
            if (playbackState == 1 || playbackState == 4 || z2) {
                this.isInterruptedByAd = false;
            }
            if (playbackException2 != null) {
                this.hasFatalError = true;
                this.fatalErrorCount++;
                if (this.keepHistory) {
                    this.fatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, playbackException2));
                }
            } else if (player.getPlayerError() == null) {
                this.hasFatalError = false;
            }
            if (this.isForeground && !this.isInterruptedByAd) {
                Tracks currentTracks = player.getCurrentTracks();
                if (!currentTracks.isTypeSelected(2)) {
                    maybeUpdateVideoFormat(eventTime2, (Format) null);
                }
                if (!currentTracks.isTypeSelected(1)) {
                    maybeUpdateAudioFormat(eventTime2, (Format) null);
                }
            }
            if (format3 != null) {
                maybeUpdateVideoFormat(eventTime2, format3);
            }
            if (format4 != null) {
                maybeUpdateAudioFormat(eventTime2, format4);
            }
            Format format5 = this.currentVideoFormat;
            if (!(format5 == null || format5.height != -1 || videoSize2 == null)) {
                maybeUpdateVideoFormat(eventTime2, this.currentVideoFormat.buildUpon().setWidth(videoSize2.width).setHeight(videoSize2.height).build());
            }
            if (z4) {
                this.startedLoading = true;
            }
            if (z3) {
                this.audioUnderruns++;
            }
            this.droppedFrames += (long) i;
            this.bandwidthTimeMs += j2;
            this.bandwidthBytes += j3;
            if (exc2 != null) {
                this.nonFatalErrorCount++;
                if (this.keepHistory) {
                    this.nonFatalErrorHistory.add(new PlaybackStats.EventTimeAndException(eventTime2, exc2));
                }
            }
            int resolveNewPlaybackState = resolveNewPlaybackState(player);
            float f = player.getPlaybackParameters().speed;
            if (!(this.currentPlaybackState == resolveNewPlaybackState && this.currentPlaybackSpeed == f)) {
                long j6 = eventTime2.realtimeMs;
                if (z) {
                    j5 = eventTime2.eventPlaybackPositionMs;
                }
                maybeUpdateMediaTimeHistory(j6, j5);
                maybeRecordVideoFormatTime(eventTime2.realtimeMs);
                maybeRecordAudioFormatTime(eventTime2.realtimeMs);
            }
            this.currentPlaybackSpeed = f;
            if (this.currentPlaybackState != resolveNewPlaybackState) {
                updatePlaybackState(resolveNewPlaybackState, eventTime2);
            }
        }

        public PlaybackStats build(boolean z) {
            ArrayList arrayList;
            long[] jArr;
            long j;
            long[] jArr2 = this.playbackStateDurationsMs;
            List<long[]> list = this.mediaTimeHistory;
            if (!z) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long[] copyOf = Arrays.copyOf(this.playbackStateDurationsMs, 16);
                long max = Math.max(0, elapsedRealtime - this.currentPlaybackStateStartTimeMs);
                int i = this.currentPlaybackState;
                copyOf[i] = copyOf[i] + max;
                maybeUpdateMaxRebufferTimeMs(elapsedRealtime);
                maybeRecordVideoFormatTime(elapsedRealtime);
                maybeRecordAudioFormatTime(elapsedRealtime);
                ArrayList arrayList2 = new ArrayList(this.mediaTimeHistory);
                if (this.keepHistory && this.currentPlaybackState == 3) {
                    arrayList2.add(guessMediaTimeBasedOnElapsedRealtime(elapsedRealtime));
                }
                jArr = copyOf;
                arrayList = arrayList2;
            } else {
                jArr = jArr2;
                arrayList = list;
            }
            int i2 = (this.isJoinTimeInvalid || !this.hasBeenReady) ? 1 : 0;
            if (i2 != 0) {
                j = C.TIME_UNSET;
            } else {
                j = jArr[2];
            }
            long j2 = j;
            int i3 = jArr[1] > 0 ? 1 : 0;
            List arrayList3 = z ? this.videoFormatHistory : new ArrayList(this.videoFormatHistory);
            List arrayList4 = z ? this.audioFormatHistory : new ArrayList(this.audioFormatHistory);
            List arrayList5 = z ? this.playbackStateHistory : new ArrayList(this.playbackStateHistory);
            long j3 = this.firstReportedTimeMs;
            boolean z2 = this.isForeground;
            boolean z3 = !this.hasBeenReady;
            boolean z4 = this.hasEnded;
            int i4 = i2 ^ 1;
            int i5 = this.pauseCount;
            int i6 = this.pauseBufferCount;
            int i7 = this.seekCount;
            int i8 = this.rebufferCount;
            int i9 = i6;
            long j4 = this.maxRebufferTimeMs;
            boolean z5 = this.isAd;
            long[] jArr3 = jArr;
            long j5 = this.videoFormatHeightTimeMs;
            long j6 = this.videoFormatHeightTimeProduct;
            long j7 = this.videoFormatBitrateTimeMs;
            long j8 = this.videoFormatBitrateTimeProduct;
            long j9 = this.audioFormatTimeMs;
            long j10 = this.audioFormatBitrateTimeProduct;
            int i10 = this.initialVideoFormatHeight;
            int i11 = i10;
            int i12 = i10 == -1 ? 0 : 1;
            long j11 = this.initialVideoFormatBitrate;
            long j12 = j11;
            int i13 = j11 == -1 ? 0 : 1;
            long j13 = this.initialAudioFormatBitrate;
            long j14 = j13;
            int i14 = j13 == -1 ? 0 : 1;
            long j15 = this.bandwidthTimeMs;
            long j16 = this.bandwidthBytes;
            long j17 = this.droppedFrames;
            long j18 = this.audioUnderruns;
            int i15 = this.fatalErrorCount;
            return new PlaybackStats(1, jArr3, arrayList5, arrayList, j3, z2 ? 1 : 0, z3 ? 1 : 0, z4 ? 1 : 0, i3, j2, i4, i5, i9, i7, i8, j4, z5 ? 1 : 0, arrayList3, arrayList4, j5, j6, j7, j8, j9, j10, i12, i13, i11, j12, i14, j14, j15, j16, j17, j18, i15 > 0 ? 1 : 0, i15, this.nonFatalErrorCount, this.fatalErrorHistory, this.nonFatalErrorHistory);
        }

        private void updatePlaybackState(int i, AnalyticsListener.EventTime eventTime) {
            boolean z = false;
            Assertions.checkArgument(eventTime.realtimeMs >= this.currentPlaybackStateStartTimeMs);
            long j = eventTime.realtimeMs - this.currentPlaybackStateStartTimeMs;
            long[] jArr = this.playbackStateDurationsMs;
            int i2 = this.currentPlaybackState;
            jArr[i2] = jArr[i2] + j;
            if (this.firstReportedTimeMs == C.TIME_UNSET) {
                this.firstReportedTimeMs = eventTime.realtimeMs;
            }
            this.isJoinTimeInvalid |= isInvalidJoinTransition(this.currentPlaybackState, i);
            this.hasBeenReady |= isReadyState(i);
            boolean z2 = this.hasEnded;
            if (i == 11) {
                z = true;
            }
            this.hasEnded = z2 | z;
            if (!isPausedState(this.currentPlaybackState) && isPausedState(i)) {
                this.pauseCount++;
            }
            if (i == 5) {
                this.seekCount++;
            }
            if (!isRebufferingState(this.currentPlaybackState) && isRebufferingState(i)) {
                this.rebufferCount++;
                this.lastRebufferStartTimeMs = eventTime.realtimeMs;
            }
            if (isRebufferingState(this.currentPlaybackState) && this.currentPlaybackState != 7 && i == 7) {
                this.pauseBufferCount++;
            }
            maybeUpdateMaxRebufferTimeMs(eventTime.realtimeMs);
            this.currentPlaybackState = i;
            this.currentPlaybackStateStartTimeMs = eventTime.realtimeMs;
            if (this.keepHistory) {
                this.playbackStateHistory.add(new PlaybackStats.EventTimeAndPlaybackState(eventTime, this.currentPlaybackState));
            }
        }

        private int resolveNewPlaybackState(Player player) {
            int playbackState = player.getPlaybackState();
            if (this.isSeeking && this.isForeground) {
                return 5;
            }
            if (this.hasFatalError) {
                return 13;
            }
            if (!this.isForeground) {
                return this.startedLoading ? 1 : 0;
            }
            if (this.isInterruptedByAd) {
                return 14;
            }
            if (playbackState == 4) {
                return 11;
            }
            if (playbackState == 2) {
                int i = this.currentPlaybackState;
                if (i == 0 || i == 1 || i == 2 || i == 14) {
                    return 2;
                }
                if (!player.getPlayWhenReady()) {
                    return 7;
                }
                return player.getPlaybackSuppressionReason() != 0 ? 10 : 6;
            } else if (playbackState == 3) {
                if (!player.getPlayWhenReady()) {
                    return 4;
                }
                if (player.getPlaybackSuppressionReason() != 0) {
                    return 9;
                }
                return 3;
            } else if (playbackState != 1 || this.currentPlaybackState == 0) {
                return this.currentPlaybackState;
            } else {
                return 12;
            }
        }

        private void maybeUpdateMaxRebufferTimeMs(long j) {
            if (isRebufferingState(this.currentPlaybackState)) {
                long j2 = j - this.lastRebufferStartTimeMs;
                long j3 = this.maxRebufferTimeMs;
                if (j3 == C.TIME_UNSET || j2 > j3) {
                    this.maxRebufferTimeMs = j2;
                }
            }
        }

        private void maybeUpdateMediaTimeHistory(long j, long j2) {
            if (this.keepHistory) {
                if (this.currentPlaybackState != 3) {
                    if (j2 != C.TIME_UNSET) {
                        if (!this.mediaTimeHistory.isEmpty()) {
                            List<long[]> list = this.mediaTimeHistory;
                            long j3 = list.get(list.size() - 1)[1];
                            if (j3 != j2) {
                                this.mediaTimeHistory.add(new long[]{j, j3});
                            }
                        }
                    } else {
                        return;
                    }
                }
                if (j2 != C.TIME_UNSET) {
                    this.mediaTimeHistory.add(new long[]{j, j2});
                } else if (!this.mediaTimeHistory.isEmpty()) {
                    this.mediaTimeHistory.add(guessMediaTimeBasedOnElapsedRealtime(j));
                }
            }
        }

        private long[] guessMediaTimeBasedOnElapsedRealtime(long j) {
            List<long[]> list = this.mediaTimeHistory;
            long[] jArr = list.get(list.size() - 1);
            return new long[]{j, jArr[1] + ((long) (((float) (j - jArr[0])) * this.currentPlaybackSpeed))};
        }

        private void maybeUpdateVideoFormat(AnalyticsListener.EventTime eventTime, Format format) {
            if (!Util.areEqual(this.currentVideoFormat, format)) {
                maybeRecordVideoFormatTime(eventTime.realtimeMs);
                if (format != null) {
                    if (this.initialVideoFormatHeight == -1 && format.height != -1) {
                        this.initialVideoFormatHeight = format.height;
                    }
                    if (this.initialVideoFormatBitrate == -1 && format.bitrate != -1) {
                        this.initialVideoFormatBitrate = (long) format.bitrate;
                    }
                }
                this.currentVideoFormat = format;
                if (this.keepHistory) {
                    this.videoFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, this.currentVideoFormat));
                }
            }
        }

        private void maybeUpdateAudioFormat(AnalyticsListener.EventTime eventTime, Format format) {
            if (!Util.areEqual(this.currentAudioFormat, format)) {
                maybeRecordAudioFormatTime(eventTime.realtimeMs);
                if (!(format == null || this.initialAudioFormatBitrate != -1 || format.bitrate == -1)) {
                    this.initialAudioFormatBitrate = (long) format.bitrate;
                }
                this.currentAudioFormat = format;
                if (this.keepHistory) {
                    this.audioFormatHistory.add(new PlaybackStats.EventTimeAndFormat(eventTime, this.currentAudioFormat));
                }
            }
        }

        private void maybeRecordVideoFormatTime(long j) {
            Format format;
            if (this.currentPlaybackState == 3 && (format = this.currentVideoFormat) != null) {
                long j2 = (long) (((float) (j - this.lastVideoFormatStartTimeMs)) * this.currentPlaybackSpeed);
                if (format.height != -1) {
                    this.videoFormatHeightTimeMs += j2;
                    this.videoFormatHeightTimeProduct += ((long) this.currentVideoFormat.height) * j2;
                }
                if (this.currentVideoFormat.bitrate != -1) {
                    this.videoFormatBitrateTimeMs += j2;
                    this.videoFormatBitrateTimeProduct += j2 * ((long) this.currentVideoFormat.bitrate);
                }
            }
            this.lastVideoFormatStartTimeMs = j;
        }

        private void maybeRecordAudioFormatTime(long j) {
            Format format;
            if (!(this.currentPlaybackState != 3 || (format = this.currentAudioFormat) == null || format.bitrate == -1)) {
                long j2 = (long) (((float) (j - this.lastAudioFormatStartTimeMs)) * this.currentPlaybackSpeed);
                this.audioFormatTimeMs += j2;
                this.audioFormatBitrateTimeProduct += j2 * ((long) this.currentAudioFormat.bitrate);
            }
            this.lastAudioFormatStartTimeMs = j;
        }
    }
}
