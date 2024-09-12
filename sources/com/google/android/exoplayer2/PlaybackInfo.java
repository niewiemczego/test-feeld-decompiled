package com.google.android.exoplayer2;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

final class PlaybackInfo {
    private static final MediaSource.MediaPeriodId PLACEHOLDER_MEDIA_PERIOD_ID = new MediaSource.MediaPeriodId(new Object());
    public volatile long bufferedPositionUs;
    public final long discontinuityStartPositionUs;
    public final boolean isLoading;
    public final MediaSource.MediaPeriodId loadingMediaPeriodId;
    public final MediaSource.MediaPeriodId periodId;
    public final boolean playWhenReady;
    public final ExoPlaybackException playbackError;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public volatile long positionUs;
    public final long requestedContentPositionUs;
    public final boolean sleepingForOffload;
    public final List<Metadata> staticMetadata;
    public final Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    public static PlaybackInfo createDummy(TrackSelectorResult trackSelectorResult2) {
        Timeline timeline2 = Timeline.EMPTY;
        MediaSource.MediaPeriodId mediaPeriodId = PLACEHOLDER_MEDIA_PERIOD_ID;
        return new PlaybackInfo(timeline2, mediaPeriodId, C.TIME_UNSET, 0, 1, (ExoPlaybackException) null, false, TrackGroupArray.EMPTY, trackSelectorResult2, ImmutableList.of(), mediaPeriodId, false, 0, PlaybackParameters.DEFAULT, 0, 0, 0, false);
    }

    public PlaybackInfo(Timeline timeline2, MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, int i, ExoPlaybackException exoPlaybackException, boolean z, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2, List<Metadata> list, MediaSource.MediaPeriodId mediaPeriodId2, boolean z2, int i2, PlaybackParameters playbackParameters2, long j3, long j4, long j5, boolean z3) {
        this.timeline = timeline2;
        this.periodId = mediaPeriodId;
        this.requestedContentPositionUs = j;
        this.discontinuityStartPositionUs = j2;
        this.playbackState = i;
        this.playbackError = exoPlaybackException;
        this.isLoading = z;
        this.trackGroups = trackGroupArray;
        this.trackSelectorResult = trackSelectorResult2;
        this.staticMetadata = list;
        this.loadingMediaPeriodId = mediaPeriodId2;
        this.playWhenReady = z2;
        this.playbackSuppressionReason = i2;
        this.playbackParameters = playbackParameters2;
        this.bufferedPositionUs = j3;
        this.totalBufferedDurationUs = j4;
        this.positionUs = j5;
        this.sleepingForOffload = z3;
    }

    public static MediaSource.MediaPeriodId getDummyPeriodForEmptyTimeline() {
        return PLACEHOLDER_MEDIA_PERIOD_ID;
    }

    public PlaybackInfo copyWithNewPosition(MediaSource.MediaPeriodId mediaPeriodId, long j, long j2, long j3, long j4, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult2, List<Metadata> list) {
        long j5 = j;
        TrackGroupArray trackGroupArray2 = trackGroupArray;
        TrackSelectorResult trackSelectorResult3 = trackSelectorResult2;
        List<Metadata> list2 = list;
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, mediaPeriodId, j2, j3, this.playbackState, this.playbackError, this.isLoading, trackGroupArray2, trackSelectorResult3, list2, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, j4, j5, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline2) {
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithPlaybackState(int i) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, i, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithPlaybackError(ExoPlaybackException exoPlaybackException) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, exoPlaybackException, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithIsLoading(boolean z) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, z, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithLoadingMediaPeriodId(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, mediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithPlayWhenReady(boolean z, int i) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, z, i, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithPlaybackParameters(PlaybackParameters playbackParameters2) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, playbackParameters2, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, this.sleepingForOffload);
    }

    public PlaybackInfo copyWithSleepingForOffload(boolean z) {
        Timeline timeline2 = this.timeline;
        return new PlaybackInfo(timeline2, this.periodId, this.requestedContentPositionUs, this.discontinuityStartPositionUs, this.playbackState, this.playbackError, this.isLoading, this.trackGroups, this.trackSelectorResult, this.staticMetadata, this.loadingMediaPeriodId, this.playWhenReady, this.playbackSuppressionReason, this.playbackParameters, this.bufferedPositionUs, this.totalBufferedDurationUs, this.positionUs, z);
    }
}
