package com.google.android.exoplayer2.analytics;

import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.google.android.exoplayer2.DeviceInfo;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaMetadata;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Tracks;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.FlagSet;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import java.io.IOException;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public class DefaultAnalyticsCollector implements AnalyticsCollector {
    private final Clock clock;
    private final SparseArray<AnalyticsListener.EventTime> eventTimes;
    private HandlerWrapper handler;
    private boolean isSeeking;
    private ListenerSet<AnalyticsListener> listeners;
    private final MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline.Period period;
    private Player player;
    private final Timeline.Window window = new Timeline.Window();

    static /* synthetic */ void lambda$new$0(AnalyticsListener analyticsListener, FlagSet flagSet) {
    }

    public void onEvents(Player player2, Player.Events events) {
    }

    public void onLoadingChanged(boolean z) {
    }

    public void onPositionDiscontinuity(int i) {
    }

    public void onRenderedFirstFrame() {
    }

    public DefaultAnalyticsCollector(Clock clock2) {
        this.clock = (Clock) Assertions.checkNotNull(clock2);
        this.listeners = new ListenerSet<>(Util.getCurrentOrMainLooper(), clock2, new DefaultAnalyticsCollector$$ExternalSyntheticLambda49());
        Timeline.Period period2 = new Timeline.Period();
        this.period = period2;
        this.mediaPeriodQueueTracker = new MediaPeriodQueueTracker(period2);
        this.eventTimes = new SparseArray<>();
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public void setPlayer(Player player2, Looper looper) {
        Assertions.checkState(this.player == null || this.mediaPeriodQueueTracker.mediaPeriodQueue.isEmpty());
        this.player = (Player) Assertions.checkNotNull(player2);
        this.handler = this.clock.createHandler(looper, (Handler.Callback) null);
        this.listeners = this.listeners.copy(looper, new DefaultAnalyticsCollector$$ExternalSyntheticLambda19(this, player2));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setPlayer$1$com-google-android-exoplayer2-analytics-DefaultAnalyticsCollector  reason: not valid java name */
    public /* synthetic */ void m469lambda$setPlayer$1$comgoogleandroidexoplayer2analyticsDefaultAnalyticsCollector(Player player2, AnalyticsListener analyticsListener, FlagSet flagSet) {
        analyticsListener.onEvents(player2, new AnalyticsListener.Events(flagSet, this.eventTimes));
    }

    public void release() {
        ((HandlerWrapper) Assertions.checkStateNotNull(this.handler)).post(new DefaultAnalyticsCollector$$ExternalSyntheticLambda9(this));
    }

    public final void updateMediaPeriodQueueInfo(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId) {
        this.mediaPeriodQueueTracker.onQueueUpdated(list, mediaPeriodId, (Player) Assertions.checkNotNull(this.player));
    }

    public final void notifySeekStarted() {
        if (!this.isSeeking) {
            AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda69(generateCurrentPlayerMediaPeriodEventTime));
        }
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1007, new DefaultAnalyticsCollector$$ExternalSyntheticLambda40(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onAudioEnabled$3(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 1, decoderCounters);
    }

    public final void onAudioDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1008, new DefaultAnalyticsCollector$$ExternalSyntheticLambda14(generateReadingMediaPeriodEventTime, str, j2, j));
    }

    static /* synthetic */ void lambda$onAudioDecoderInitialized$4(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j);
        long j3 = j;
        analyticsListener.onAudioDecoderInitialized(eventTime, str, j2, j3);
        analyticsListener.onDecoderInitialized(eventTime, 1, str, j3);
    }

    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1009, new DefaultAnalyticsCollector$$ExternalSyntheticLambda38(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    static /* synthetic */ void lambda$onAudioInputFormatChanged$5(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(eventTime, format);
        analyticsListener.onAudioInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 1, format);
    }

    public final void onAudioPositionAdvancing(long j) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1010, new DefaultAnalyticsCollector$$ExternalSyntheticLambda21(generateReadingMediaPeriodEventTime, j));
    }

    public final void onAudioUnderrun(int i, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1011, new DefaultAnalyticsCollector$$ExternalSyntheticLambda33(generateReadingMediaPeriodEventTime, i, j, j2));
    }

    public final void onAudioDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1012, new DefaultAnalyticsCollector$$ExternalSyntheticLambda20(generateReadingMediaPeriodEventTime, str));
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1013, new DefaultAnalyticsCollector$$ExternalSyntheticLambda51(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onAudioDisabled$9(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 1, decoderCounters);
    }

    public final void onAudioSinkError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1014, new DefaultAnalyticsCollector$$ExternalSyntheticLambda30(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onAudioCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_AUDIO_CODEC_ERROR, new DefaultAnalyticsCollector$$ExternalSyntheticLambda50(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onVolumeChanged(float f) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 22, new DefaultAnalyticsCollector$$ExternalSyntheticLambda44(generateReadingMediaPeriodEventTime, f));
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1015, new DefaultAnalyticsCollector$$ExternalSyntheticLambda8(generateReadingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onVideoEnabled$13(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(eventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(eventTime, 2, decoderCounters);
    }

    public final void onVideoDecoderInitialized(String str, long j, long j2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1016, new DefaultAnalyticsCollector$$ExternalSyntheticLambda2(generateReadingMediaPeriodEventTime, str, j2, j));
    }

    static /* synthetic */ void lambda$onVideoDecoderInitialized$14(AnalyticsListener.EventTime eventTime, String str, long j, long j2, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j);
        long j3 = j;
        analyticsListener.onVideoDecoderInitialized(eventTime, str, j2, j3);
        analyticsListener.onDecoderInitialized(eventTime, 2, str, j3);
    }

    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1017, new DefaultAnalyticsCollector$$ExternalSyntheticLambda53(generateReadingMediaPeriodEventTime, format, decoderReuseEvaluation));
    }

    static /* synthetic */ void lambda$onVideoInputFormatChanged$15(AnalyticsListener.EventTime eventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(eventTime, format);
        analyticsListener.onVideoInputFormatChanged(eventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(eventTime, 2, format);
    }

    public final void onDroppedFrames(int i, long j) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1018, new DefaultAnalyticsCollector$$ExternalSyntheticLambda36(generatePlayingMediaPeriodEventTime, i, j));
    }

    public final void onVideoDecoderReleased(String str) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 1019, new DefaultAnalyticsCollector$$ExternalSyntheticLambda4(generateReadingMediaPeriodEventTime, str));
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1020, new DefaultAnalyticsCollector$$ExternalSyntheticLambda37(generatePlayingMediaPeriodEventTime, decoderCounters));
    }

    static /* synthetic */ void lambda$onVideoDisabled$18(AnalyticsListener.EventTime eventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(eventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(eventTime, 2, decoderCounters);
    }

    public final void onRenderedFirstFrame(Object obj, long j) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 26, new DefaultAnalyticsCollector$$ExternalSyntheticLambda7(generateReadingMediaPeriodEventTime, obj, j));
    }

    public final void onVideoFrameProcessingOffset(long j, int i) {
        AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime = generatePlayingMediaPeriodEventTime();
        sendEvent(generatePlayingMediaPeriodEventTime, 1021, new DefaultAnalyticsCollector$$ExternalSyntheticLambda68(generatePlayingMediaPeriodEventTime, j, i));
    }

    public final void onVideoCodecError(Exception exc) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, AnalyticsListener.EVENT_VIDEO_CODEC_ERROR, new DefaultAnalyticsCollector$$ExternalSyntheticLambda67(generateReadingMediaPeriodEventTime, exc));
    }

    public final void onSurfaceSizeChanged(int i, int i2) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 24, new DefaultAnalyticsCollector$$ExternalSyntheticLambda43(generateReadingMediaPeriodEventTime, i, i2));
    }

    public final void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1000, new DefaultAnalyticsCollector$$ExternalSyntheticLambda59(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1001, new DefaultAnalyticsCollector$$ExternalSyntheticLambda65(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1002, new DefaultAnalyticsCollector$$ExternalSyntheticLambda17(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData));
    }

    public final void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1003, new DefaultAnalyticsCollector$$ExternalSyntheticLambda48(generateMediaPeriodEventTime, loadEventInfo, mediaLoadData, iOException, z));
    }

    public final void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1005, new DefaultAnalyticsCollector$$ExternalSyntheticLambda39(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1004, new DefaultAnalyticsCollector$$ExternalSyntheticLambda31(generateMediaPeriodEventTime, mediaLoadData));
    }

    public final void onTimelineChanged(Timeline timeline, int i) {
        this.mediaPeriodQueueTracker.onTimelineChanged((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 0, new DefaultAnalyticsCollector$$ExternalSyntheticLambda61(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onMediaItemTransition(MediaItem mediaItem, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda22(generateCurrentPlayerMediaPeriodEventTime, mediaItem, i));
    }

    public void onTracksChanged(Tracks tracks) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 2, new DefaultAnalyticsCollector$$ExternalSyntheticLambda25(generateCurrentPlayerMediaPeriodEventTime, tracks));
    }

    public final void onIsLoadingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 3, new DefaultAnalyticsCollector$$ExternalSyntheticLambda57(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    static /* synthetic */ void lambda$onIsLoadingChanged$32(AnalyticsListener.EventTime eventTime, boolean z, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadingChanged(eventTime, z);
        analyticsListener.onIsLoadingChanged(eventTime, z);
    }

    public void onAvailableCommandsChanged(Player.Commands commands) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 13, new DefaultAnalyticsCollector$$ExternalSyntheticLambda42(generateCurrentPlayerMediaPeriodEventTime, commands));
    }

    public final void onPlayerStateChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda35(generateCurrentPlayerMediaPeriodEventTime, z, i));
    }

    public final void onPlaybackStateChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 4, new DefaultAnalyticsCollector$$ExternalSyntheticLambda55(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onPlayWhenReadyChanged(boolean z, int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 5, new DefaultAnalyticsCollector$$ExternalSyntheticLambda45(generateCurrentPlayerMediaPeriodEventTime, z, i));
    }

    public final void onPlaybackSuppressionReasonChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 6, new DefaultAnalyticsCollector$$ExternalSyntheticLambda34(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public void onIsPlayingChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 7, new DefaultAnalyticsCollector$$ExternalSyntheticLambda27(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    public final void onRepeatModeChanged(int i) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 8, new DefaultAnalyticsCollector$$ExternalSyntheticLambda41(generateCurrentPlayerMediaPeriodEventTime, i));
    }

    public final void onShuffleModeEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 9, new DefaultAnalyticsCollector$$ExternalSyntheticLambda5(generateCurrentPlayerMediaPeriodEventTime, z));
    }

    public final void onPlayerError(PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new DefaultAnalyticsCollector$$ExternalSyntheticLambda12(eventTimeForErrorEvent, playbackException));
    }

    public void onPlayerErrorChanged(PlaybackException playbackException) {
        AnalyticsListener.EventTime eventTimeForErrorEvent = getEventTimeForErrorEvent(playbackException);
        sendEvent(eventTimeForErrorEvent, 10, new DefaultAnalyticsCollector$$ExternalSyntheticLambda3(eventTimeForErrorEvent, playbackException));
    }

    public final void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
        if (i == 1) {
            this.isSeeking = false;
        }
        this.mediaPeriodQueueTracker.onPositionDiscontinuity((Player) Assertions.checkNotNull(this.player));
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 11, new DefaultAnalyticsCollector$$ExternalSyntheticLambda64(generateCurrentPlayerMediaPeriodEventTime, i, positionInfo, positionInfo2));
    }

    static /* synthetic */ void lambda$onPositionDiscontinuity$43(AnalyticsListener.EventTime eventTime, int i, Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(eventTime, i);
        analyticsListener.onPositionDiscontinuity(eventTime, positionInfo, positionInfo2, i);
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 12, new DefaultAnalyticsCollector$$ExternalSyntheticLambda58(generateCurrentPlayerMediaPeriodEventTime, playbackParameters));
    }

    public void onSeekBackIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 16, new DefaultAnalyticsCollector$$ExternalSyntheticLambda32(generateCurrentPlayerMediaPeriodEventTime, j));
    }

    public void onSeekForwardIncrementChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 17, new DefaultAnalyticsCollector$$ExternalSyntheticLambda10(generateCurrentPlayerMediaPeriodEventTime, j));
    }

    public void onMaxSeekToPreviousPositionChanged(long j) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 18, new DefaultAnalyticsCollector$$ExternalSyntheticLambda16(generateCurrentPlayerMediaPeriodEventTime, j));
    }

    public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 14, new DefaultAnalyticsCollector$$ExternalSyntheticLambda66(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 15, new DefaultAnalyticsCollector$$ExternalSyntheticLambda46(generateCurrentPlayerMediaPeriodEventTime, mediaMetadata));
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 28, new DefaultAnalyticsCollector$$ExternalSyntheticLambda0(generateCurrentPlayerMediaPeriodEventTime, metadata));
    }

    public void onCues(List<Cue> list) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new DefaultAnalyticsCollector$$ExternalSyntheticLambda63(generateCurrentPlayerMediaPeriodEventTime, list));
    }

    public void onCues(CueGroup cueGroup) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 27, new DefaultAnalyticsCollector$$ExternalSyntheticLambda47(generateCurrentPlayerMediaPeriodEventTime, cueGroup));
    }

    public final void onSeekProcessed() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, -1, new DefaultAnalyticsCollector$$ExternalSyntheticLambda62(generateCurrentPlayerMediaPeriodEventTime));
    }

    public final void onSkipSilenceEnabledChanged(boolean z) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 23, new DefaultAnalyticsCollector$$ExternalSyntheticLambda13(generateReadingMediaPeriodEventTime, z));
    }

    public final void onAudioSessionIdChanged(int i) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 21, new DefaultAnalyticsCollector$$ExternalSyntheticLambda15(generateReadingMediaPeriodEventTime, i));
    }

    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 20, new DefaultAnalyticsCollector$$ExternalSyntheticLambda29(generateReadingMediaPeriodEventTime, audioAttributes));
    }

    public final void onVideoSizeChanged(VideoSize videoSize) {
        AnalyticsListener.EventTime generateReadingMediaPeriodEventTime = generateReadingMediaPeriodEventTime();
        sendEvent(generateReadingMediaPeriodEventTime, 25, new DefaultAnalyticsCollector$$ExternalSyntheticLambda24(generateReadingMediaPeriodEventTime, videoSize));
    }

    static /* synthetic */ void lambda$onVideoSizeChanged$57(AnalyticsListener.EventTime eventTime, VideoSize videoSize, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(eventTime, videoSize);
        analyticsListener.onVideoSizeChanged(eventTime, videoSize.width, videoSize.height, videoSize.unappliedRotationDegrees, videoSize.pixelWidthHeightRatio);
    }

    public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 19, new DefaultAnalyticsCollector$$ExternalSyntheticLambda1(generateCurrentPlayerMediaPeriodEventTime, trackSelectionParameters));
    }

    public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 29, new DefaultAnalyticsCollector$$ExternalSyntheticLambda11(generateCurrentPlayerMediaPeriodEventTime, deviceInfo));
    }

    public void onDeviceVolumeChanged(int i, boolean z) {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, 30, new DefaultAnalyticsCollector$$ExternalSyntheticLambda6(generateCurrentPlayerMediaPeriodEventTime, i, z));
    }

    public final void onBandwidthSample(int i, long j, long j2) {
        AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime = generateLoadingMediaPeriodEventTime();
        sendEvent(generateLoadingMediaPeriodEventTime, 1006, new DefaultAnalyticsCollector$$ExternalSyntheticLambda52(generateLoadingMediaPeriodEventTime, i, j, j2));
    }

    public final void onDrmSessionAcquired(int i, MediaSource.MediaPeriodId mediaPeriodId, int i2) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, new DefaultAnalyticsCollector$$ExternalSyntheticLambda54(generateMediaPeriodEventTime, i2));
    }

    static /* synthetic */ void lambda$onDrmSessionAcquired$62(AnalyticsListener.EventTime eventTime, int i, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(eventTime);
        analyticsListener.onDrmSessionAcquired(eventTime, i);
    }

    public final void onDrmKeysLoaded(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_LOADED, new DefaultAnalyticsCollector$$ExternalSyntheticLambda18(generateMediaPeriodEventTime));
    }

    public final void onDrmSessionManagerError(int i, MediaSource.MediaPeriodId mediaPeriodId, Exception exc) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1024, new DefaultAnalyticsCollector$$ExternalSyntheticLambda60(generateMediaPeriodEventTime, exc));
    }

    public final void onDrmKeysRestored(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, 1025, new DefaultAnalyticsCollector$$ExternalSyntheticLambda56(generateMediaPeriodEventTime));
    }

    public final void onDrmKeysRemoved(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_KEYS_REMOVED, new DefaultAnalyticsCollector$$ExternalSyntheticLambda28(generateMediaPeriodEventTime));
    }

    public final void onDrmSessionReleased(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        AnalyticsListener.EventTime generateMediaPeriodEventTime = generateMediaPeriodEventTime(i, mediaPeriodId);
        sendEvent(generateMediaPeriodEventTime, AnalyticsListener.EVENT_DRM_SESSION_RELEASED, new DefaultAnalyticsCollector$$ExternalSyntheticLambda23(generateMediaPeriodEventTime));
    }

    /* access modifiers changed from: protected */
    public final void sendEvent(AnalyticsListener.EventTime eventTime, int i, ListenerSet.Event<AnalyticsListener> event) {
        this.eventTimes.put(i, eventTime);
        this.listeners.sendEvent(i, event);
    }

    /* access modifiers changed from: protected */
    public final AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod());
    }

    /* access modifiers changed from: protected */
    @RequiresNonNull({"player"})
    public final AnalyticsListener.EventTime generateEventTime(Timeline timeline, int i, MediaSource.MediaPeriodId mediaPeriodId) {
        long j;
        Timeline timeline2 = timeline;
        int i2 = i;
        MediaSource.MediaPeriodId mediaPeriodId2 = timeline.isEmpty() ? null : mediaPeriodId;
        long elapsedRealtime = this.clock.elapsedRealtime();
        boolean z = true;
        boolean z2 = timeline2.equals(this.player.getCurrentTimeline()) && i2 == this.player.getCurrentMediaItemIndex();
        long j2 = 0;
        if (mediaPeriodId2 != null && mediaPeriodId2.isAd()) {
            if (!(z2 && this.player.getCurrentAdGroupIndex() == mediaPeriodId2.adGroupIndex && this.player.getCurrentAdIndexInAdGroup() == mediaPeriodId2.adIndexInAdGroup)) {
                z = false;
            }
            if (z) {
                j2 = this.player.getCurrentPosition();
            }
        } else if (z2) {
            j = this.player.getContentPosition();
            return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
        } else if (!timeline.isEmpty()) {
            j2 = timeline2.getWindow(i2, this.window).getDefaultPositionMs();
        }
        j = j2;
        return new AnalyticsListener.EventTime(elapsedRealtime, timeline, i, mediaPeriodId2, j, this.player.getCurrentTimeline(), this.player.getCurrentMediaItemIndex(), this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod(), this.player.getCurrentPosition(), this.player.getTotalBufferedDuration());
    }

    /* access modifiers changed from: private */
    public void releaseInternal() {
        AnalyticsListener.EventTime generateCurrentPlayerMediaPeriodEventTime = generateCurrentPlayerMediaPeriodEventTime();
        sendEvent(generateCurrentPlayerMediaPeriodEventTime, AnalyticsListener.EVENT_PLAYER_RELEASED, new DefaultAnalyticsCollector$$ExternalSyntheticLambda26(generateCurrentPlayerMediaPeriodEventTime));
        this.listeners.release();
    }

    private AnalyticsListener.EventTime generateEventTime(MediaSource.MediaPeriodId mediaPeriodId) {
        Timeline timeline;
        Assertions.checkNotNull(this.player);
        if (mediaPeriodId == null) {
            timeline = null;
        } else {
            timeline = this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId);
        }
        if (mediaPeriodId != null && timeline != null) {
            return generateEventTime(timeline, timeline.getPeriodByUid(mediaPeriodId.periodUid, this.period).windowIndex, mediaPeriodId);
        }
        int currentMediaItemIndex = this.player.getCurrentMediaItemIndex();
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (!(currentMediaItemIndex < currentTimeline.getWindowCount())) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, currentMediaItemIndex, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime generatePlayingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getPlayingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateReadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getReadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateLoadingMediaPeriodEventTime() {
        return generateEventTime(this.mediaPeriodQueueTracker.getLoadingMediaPeriod());
    }

    private AnalyticsListener.EventTime generateMediaPeriodEventTime(int i, MediaSource.MediaPeriodId mediaPeriodId) {
        Assertions.checkNotNull(this.player);
        boolean z = true;
        if (mediaPeriodId != null) {
            if (this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline(mediaPeriodId) == null) {
                z = false;
            }
            if (z) {
                return generateEventTime(mediaPeriodId);
            }
            return generateEventTime(Timeline.EMPTY, i, mediaPeriodId);
        }
        Timeline currentTimeline = this.player.getCurrentTimeline();
        if (i >= currentTimeline.getWindowCount()) {
            z = false;
        }
        if (!z) {
            currentTimeline = Timeline.EMPTY;
        }
        return generateEventTime(currentTimeline, i, (MediaSource.MediaPeriodId) null);
    }

    private AnalyticsListener.EventTime getEventTimeForErrorEvent(PlaybackException playbackException) {
        if (playbackException instanceof ExoPlaybackException) {
            ExoPlaybackException exoPlaybackException = (ExoPlaybackException) playbackException;
            if (exoPlaybackException.mediaPeriodId != null) {
                return generateEventTime(new MediaSource.MediaPeriodId(exoPlaybackException.mediaPeriodId));
            }
        }
        return generateCurrentPlayerMediaPeriodEventTime();
    }

    private static final class MediaPeriodQueueTracker {
        private MediaSource.MediaPeriodId currentPlayerMediaPeriod;
        /* access modifiers changed from: private */
        public ImmutableList<MediaSource.MediaPeriodId> mediaPeriodQueue = ImmutableList.of();
        private ImmutableMap<MediaSource.MediaPeriodId, Timeline> mediaPeriodTimelines = ImmutableMap.of();
        private final Timeline.Period period;
        private MediaSource.MediaPeriodId playingMediaPeriod;
        private MediaSource.MediaPeriodId readingMediaPeriod;

        public MediaPeriodQueueTracker(Timeline.Period period2) {
            this.period = period2;
        }

        public MediaSource.MediaPeriodId getCurrentPlayerMediaPeriod() {
            return this.currentPlayerMediaPeriod;
        }

        public MediaSource.MediaPeriodId getPlayingMediaPeriod() {
            return this.playingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getReadingMediaPeriod() {
            return this.readingMediaPeriod;
        }

        public MediaSource.MediaPeriodId getLoadingMediaPeriod() {
            if (this.mediaPeriodQueue.isEmpty()) {
                return null;
            }
            return (MediaSource.MediaPeriodId) Iterables.getLast(this.mediaPeriodQueue);
        }

        public Timeline getMediaPeriodIdTimeline(MediaSource.MediaPeriodId mediaPeriodId) {
            return this.mediaPeriodTimelines.get(mediaPeriodId);
        }

        public void onPositionDiscontinuity(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
        }

        public void onTimelineChanged(Player player) {
            this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        public void onQueueUpdated(List<MediaSource.MediaPeriodId> list, MediaSource.MediaPeriodId mediaPeriodId, Player player) {
            this.mediaPeriodQueue = ImmutableList.copyOf(list);
            if (!list.isEmpty()) {
                this.playingMediaPeriod = list.get(0);
                this.readingMediaPeriod = (MediaSource.MediaPeriodId) Assertions.checkNotNull(mediaPeriodId);
            }
            if (this.currentPlayerMediaPeriod == null) {
                this.currentPlayerMediaPeriod = findCurrentPlayerMediaPeriodInQueue(player, this.mediaPeriodQueue, this.playingMediaPeriod, this.period);
            }
            updateMediaPeriodTimelines(player.getCurrentTimeline());
        }

        private void updateMediaPeriodTimelines(Timeline timeline) {
            ImmutableMap.Builder builder = ImmutableMap.builder();
            if (this.mediaPeriodQueue.isEmpty()) {
                addTimelineForMediaPeriodId(builder, this.playingMediaPeriod, timeline);
                if (!Objects.equal(this.readingMediaPeriod, this.playingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.readingMediaPeriod, timeline);
                }
                if (!Objects.equal(this.currentPlayerMediaPeriod, this.playingMediaPeriod) && !Objects.equal(this.currentPlayerMediaPeriod, this.readingMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            } else {
                for (int i = 0; i < this.mediaPeriodQueue.size(); i++) {
                    addTimelineForMediaPeriodId(builder, (MediaSource.MediaPeriodId) this.mediaPeriodQueue.get(i), timeline);
                }
                if (!this.mediaPeriodQueue.contains(this.currentPlayerMediaPeriod)) {
                    addTimelineForMediaPeriodId(builder, this.currentPlayerMediaPeriod, timeline);
                }
            }
            this.mediaPeriodTimelines = builder.buildOrThrow();
        }

        private void addTimelineForMediaPeriodId(ImmutableMap.Builder<MediaSource.MediaPeriodId, Timeline> builder, MediaSource.MediaPeriodId mediaPeriodId, Timeline timeline) {
            if (mediaPeriodId != null) {
                if (timeline.getIndexOfPeriod(mediaPeriodId.periodUid) != -1) {
                    builder.put(mediaPeriodId, timeline);
                    return;
                }
                Timeline timeline2 = this.mediaPeriodTimelines.get(mediaPeriodId);
                if (timeline2 != null) {
                    builder.put(mediaPeriodId, timeline2);
                }
            }
        }

        private static MediaSource.MediaPeriodId findCurrentPlayerMediaPeriodInQueue(Player player, ImmutableList<MediaSource.MediaPeriodId> immutableList, MediaSource.MediaPeriodId mediaPeriodId, Timeline.Period period2) {
            Timeline currentTimeline = player.getCurrentTimeline();
            int currentPeriodIndex = player.getCurrentPeriodIndex();
            Object uidOfPeriod = currentTimeline.isEmpty() ? null : currentTimeline.getUidOfPeriod(currentPeriodIndex);
            int adGroupIndexAfterPositionUs = (player.isPlayingAd() || currentTimeline.isEmpty()) ? -1 : currentTimeline.getPeriod(currentPeriodIndex, period2).getAdGroupIndexAfterPositionUs(Util.msToUs(player.getCurrentPosition()) - period2.getPositionInWindowUs());
            for (int i = 0; i < immutableList.size(); i++) {
                MediaSource.MediaPeriodId mediaPeriodId2 = (MediaSource.MediaPeriodId) immutableList.get(i);
                if (isMatchingMediaPeriod(mediaPeriodId2, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId2;
                }
            }
            if (immutableList.isEmpty() && mediaPeriodId != null) {
                if (isMatchingMediaPeriod(mediaPeriodId, uidOfPeriod, player.isPlayingAd(), player.getCurrentAdGroupIndex(), player.getCurrentAdIndexInAdGroup(), adGroupIndexAfterPositionUs)) {
                    return mediaPeriodId;
                }
            }
            return null;
        }

        private static boolean isMatchingMediaPeriod(MediaSource.MediaPeriodId mediaPeriodId, Object obj, boolean z, int i, int i2, int i3) {
            if (!mediaPeriodId.periodUid.equals(obj)) {
                return false;
            }
            if ((z && mediaPeriodId.adGroupIndex == i && mediaPeriodId.adIndexInAdGroup == i2) || (!z && mediaPeriodId.adGroupIndex == -1 && mediaPeriodId.nextAdGroupIndex == i3)) {
                return true;
            }
            return false;
        }
    }
}
