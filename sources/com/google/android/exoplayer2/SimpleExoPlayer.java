package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ConditionVariable;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoSize;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.List;

@Deprecated
public class SimpleExoPlayer extends BasePlayer implements ExoPlayer, ExoPlayer.AudioComponent, ExoPlayer.VideoComponent, ExoPlayer.TextComponent, ExoPlayer.DeviceComponent {
    private final ConditionVariable constructorFinished;
    private final ExoPlayerImpl player;

    @Deprecated
    public ExoPlayer.AudioComponent getAudioComponent() {
        return this;
    }

    @Deprecated
    public ExoPlayer.DeviceComponent getDeviceComponent() {
        return this;
    }

    @Deprecated
    public ExoPlayer.TextComponent getTextComponent() {
        return this;
    }

    @Deprecated
    public ExoPlayer.VideoComponent getVideoComponent() {
        return this;
    }

    @Deprecated
    public static final class Builder {
        /* access modifiers changed from: private */
        public final ExoPlayer.Builder wrappedBuilder;

        @Deprecated
        public Builder(Context context) {
            this.wrappedBuilder = new ExoPlayer.Builder(context);
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory);
        }

        @Deprecated
        public Builder(Context context, ExtractorsFactory extractorsFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory extractorsFactory) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory, (MediaSource.Factory) new DefaultMediaSourceFactory(context, extractorsFactory));
        }

        @Deprecated
        public Builder(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
            this.wrappedBuilder = new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector);
        }

        @Deprecated
        public Builder experimentalSetForegroundModeTimeoutMs(long j) {
            this.wrappedBuilder.experimentalSetForegroundModeTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setTrackSelector(TrackSelector trackSelector) {
            this.wrappedBuilder.setTrackSelector(trackSelector);
            return this;
        }

        @Deprecated
        public Builder setMediaSourceFactory(MediaSource.Factory factory) {
            this.wrappedBuilder.setMediaSourceFactory(factory);
            return this;
        }

        @Deprecated
        public Builder setLoadControl(LoadControl loadControl) {
            this.wrappedBuilder.setLoadControl(loadControl);
            return this;
        }

        @Deprecated
        public Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
            this.wrappedBuilder.setBandwidthMeter(bandwidthMeter);
            return this;
        }

        @Deprecated
        public Builder setLooper(Looper looper) {
            this.wrappedBuilder.setLooper(looper);
            return this;
        }

        @Deprecated
        public Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
            this.wrappedBuilder.setAnalyticsCollector(analyticsCollector);
            return this;
        }

        @Deprecated
        public Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
            this.wrappedBuilder.setPriorityTaskManager(priorityTaskManager);
            return this;
        }

        @Deprecated
        public Builder setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
            this.wrappedBuilder.setAudioAttributes(audioAttributes, z);
            return this;
        }

        @Deprecated
        public Builder setWakeMode(int i) {
            this.wrappedBuilder.setWakeMode(i);
            return this;
        }

        @Deprecated
        public Builder setHandleAudioBecomingNoisy(boolean z) {
            this.wrappedBuilder.setHandleAudioBecomingNoisy(z);
            return this;
        }

        @Deprecated
        public Builder setSkipSilenceEnabled(boolean z) {
            this.wrappedBuilder.setSkipSilenceEnabled(z);
            return this;
        }

        @Deprecated
        public Builder setVideoScalingMode(int i) {
            this.wrappedBuilder.setVideoScalingMode(i);
            return this;
        }

        @Deprecated
        public Builder setVideoChangeFrameRateStrategy(int i) {
            this.wrappedBuilder.setVideoChangeFrameRateStrategy(i);
            return this;
        }

        @Deprecated
        public Builder setUseLazyPreparation(boolean z) {
            this.wrappedBuilder.setUseLazyPreparation(z);
            return this;
        }

        @Deprecated
        public Builder setSeekParameters(SeekParameters seekParameters) {
            this.wrappedBuilder.setSeekParameters(seekParameters);
            return this;
        }

        @Deprecated
        public Builder setSeekBackIncrementMs(long j) {
            this.wrappedBuilder.setSeekBackIncrementMs(j);
            return this;
        }

        @Deprecated
        public Builder setSeekForwardIncrementMs(long j) {
            this.wrappedBuilder.setSeekForwardIncrementMs(j);
            return this;
        }

        @Deprecated
        public Builder setReleaseTimeoutMs(long j) {
            this.wrappedBuilder.setReleaseTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setDetachSurfaceTimeoutMs(long j) {
            this.wrappedBuilder.setDetachSurfaceTimeoutMs(j);
            return this;
        }

        @Deprecated
        public Builder setPauseAtEndOfMediaItems(boolean z) {
            this.wrappedBuilder.setPauseAtEndOfMediaItems(z);
            return this;
        }

        @Deprecated
        public Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
            this.wrappedBuilder.setLivePlaybackSpeedControl(livePlaybackSpeedControl);
            return this;
        }

        @Deprecated
        public Builder setClock(Clock clock) {
            this.wrappedBuilder.setClock(clock);
            return this;
        }

        @Deprecated
        public SimpleExoPlayer build() {
            return this.wrappedBuilder.buildSimpleExoPlayer();
        }
    }

    @Deprecated
    protected SimpleExoPlayer(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSource.Factory factory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean z, Clock clock, Looper looper) {
        this(new ExoPlayer.Builder(context, renderersFactory, factory, trackSelector, loadControl, bandwidthMeter, analyticsCollector).setUseLazyPreparation(z).setClock(clock).setLooper(looper));
    }

    protected SimpleExoPlayer(Builder builder) {
        this(builder.wrappedBuilder);
    }

    SimpleExoPlayer(ExoPlayer.Builder builder) {
        ConditionVariable conditionVariable = new ConditionVariable();
        this.constructorFinished = conditionVariable;
        try {
            this.player = new ExoPlayerImpl(builder, this);
            conditionVariable.open();
        } catch (Throwable th) {
            this.constructorFinished.open();
            throw th;
        }
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean z) {
        blockUntilConstructorFinished();
        this.player.experimentalSetOffloadSchedulingEnabled(z);
    }

    public boolean experimentalIsSleepingForOffload() {
        blockUntilConstructorFinished();
        return this.player.experimentalIsSleepingForOffload();
    }

    public void setVideoScalingMode(int i) {
        blockUntilConstructorFinished();
        this.player.setVideoScalingMode(i);
    }

    public int getVideoScalingMode() {
        blockUntilConstructorFinished();
        return this.player.getVideoScalingMode();
    }

    public void setVideoChangeFrameRateStrategy(int i) {
        blockUntilConstructorFinished();
        this.player.setVideoChangeFrameRateStrategy(i);
    }

    public int getVideoChangeFrameRateStrategy() {
        blockUntilConstructorFinished();
        return this.player.getVideoChangeFrameRateStrategy();
    }

    public VideoSize getVideoSize() {
        blockUntilConstructorFinished();
        return this.player.getVideoSize();
    }

    public void clearVideoSurface() {
        blockUntilConstructorFinished();
        this.player.clearVideoSurface();
    }

    public void clearVideoSurface(Surface surface) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurface(surface);
    }

    public void setVideoSurface(Surface surface) {
        blockUntilConstructorFinished();
        this.player.setVideoSurface(surface);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        blockUntilConstructorFinished();
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        blockUntilConstructorFinished();
        this.player.setVideoSurfaceView(surfaceView);
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        blockUntilConstructorFinished();
        this.player.clearVideoSurfaceView(surfaceView);
    }

    public void setVideoTextureView(TextureView textureView) {
        blockUntilConstructorFinished();
        this.player.setVideoTextureView(textureView);
    }

    public void clearVideoTextureView(TextureView textureView) {
        blockUntilConstructorFinished();
        this.player.clearVideoTextureView(textureView);
    }

    public void addAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        blockUntilConstructorFinished();
        this.player.addAudioOffloadListener(audioOffloadListener);
    }

    public void removeAudioOffloadListener(ExoPlayer.AudioOffloadListener audioOffloadListener) {
        blockUntilConstructorFinished();
        this.player.removeAudioOffloadListener(audioOffloadListener);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes, boolean z) {
        blockUntilConstructorFinished();
        this.player.setAudioAttributes(audioAttributes, z);
    }

    public AudioAttributes getAudioAttributes() {
        blockUntilConstructorFinished();
        return this.player.getAudioAttributes();
    }

    public void setAudioSessionId(int i) {
        blockUntilConstructorFinished();
        this.player.setAudioSessionId(i);
    }

    public int getAudioSessionId() {
        blockUntilConstructorFinished();
        return this.player.getAudioSessionId();
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        blockUntilConstructorFinished();
        this.player.setAuxEffectInfo(auxEffectInfo);
    }

    public void clearAuxEffectInfo() {
        blockUntilConstructorFinished();
        this.player.clearAuxEffectInfo();
    }

    public void setVolume(float f) {
        blockUntilConstructorFinished();
        this.player.setVolume(f);
    }

    public float getVolume() {
        blockUntilConstructorFinished();
        return this.player.getVolume();
    }

    public boolean getSkipSilenceEnabled() {
        blockUntilConstructorFinished();
        return this.player.getSkipSilenceEnabled();
    }

    public void setSkipSilenceEnabled(boolean z) {
        blockUntilConstructorFinished();
        this.player.setSkipSilenceEnabled(z);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        blockUntilConstructorFinished();
        return this.player.getAnalyticsCollector();
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        blockUntilConstructorFinished();
        this.player.addAnalyticsListener(analyticsListener);
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        blockUntilConstructorFinished();
        this.player.removeAnalyticsListener(analyticsListener);
    }

    public void setHandleAudioBecomingNoisy(boolean z) {
        blockUntilConstructorFinished();
        this.player.setHandleAudioBecomingNoisy(z);
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        blockUntilConstructorFinished();
        this.player.setPriorityTaskManager(priorityTaskManager);
    }

    public Format getVideoFormat() {
        blockUntilConstructorFinished();
        return this.player.getVideoFormat();
    }

    public Format getAudioFormat() {
        blockUntilConstructorFinished();
        return this.player.getAudioFormat();
    }

    public DecoderCounters getVideoDecoderCounters() {
        blockUntilConstructorFinished();
        return this.player.getVideoDecoderCounters();
    }

    public DecoderCounters getAudioDecoderCounters() {
        blockUntilConstructorFinished();
        return this.player.getAudioDecoderCounters();
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        blockUntilConstructorFinished();
        this.player.setVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        blockUntilConstructorFinished();
        this.player.clearVideoFrameMetadataListener(videoFrameMetadataListener);
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        blockUntilConstructorFinished();
        this.player.setCameraMotionListener(cameraMotionListener);
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        blockUntilConstructorFinished();
        this.player.clearCameraMotionListener(cameraMotionListener);
    }

    public CueGroup getCurrentCues() {
        blockUntilConstructorFinished();
        return this.player.getCurrentCues();
    }

    public Looper getPlaybackLooper() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackLooper();
    }

    public Looper getApplicationLooper() {
        blockUntilConstructorFinished();
        return this.player.getApplicationLooper();
    }

    public Clock getClock() {
        blockUntilConstructorFinished();
        return this.player.getClock();
    }

    public void addListener(Player.Listener listener) {
        blockUntilConstructorFinished();
        this.player.addListener(listener);
    }

    public void removeListener(Player.Listener listener) {
        blockUntilConstructorFinished();
        this.player.removeListener(listener);
    }

    public int getPlaybackState() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackSuppressionReason();
    }

    public ExoPlaybackException getPlayerError() {
        blockUntilConstructorFinished();
        return this.player.getPlayerError();
    }

    @Deprecated
    public void retry() {
        blockUntilConstructorFinished();
        this.player.retry();
    }

    public Player.Commands getAvailableCommands() {
        blockUntilConstructorFinished();
        return this.player.getAvailableCommands();
    }

    public void prepare() {
        blockUntilConstructorFinished();
        this.player.prepare();
    }

    @Deprecated
    public void prepare(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.prepare(mediaSource);
    }

    @Deprecated
    public void prepare(MediaSource mediaSource, boolean z, boolean z2) {
        blockUntilConstructorFinished();
        this.player.prepare(mediaSource, z, z2);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        blockUntilConstructorFinished();
        this.player.setMediaItems(list, z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        blockUntilConstructorFinished();
        this.player.setMediaItems(list, i, j);
    }

    public void setMediaSources(List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list);
    }

    public void setMediaSources(List<MediaSource> list, boolean z) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list, z);
    }

    public void setMediaSources(List<MediaSource> list, int i, long j) {
        blockUntilConstructorFinished();
        this.player.setMediaSources(list, i, j);
    }

    public void setMediaSource(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource);
    }

    public void setMediaSource(MediaSource mediaSource, boolean z) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource, z);
    }

    public void setMediaSource(MediaSource mediaSource, long j) {
        blockUntilConstructorFinished();
        this.player.setMediaSource(mediaSource, j);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        blockUntilConstructorFinished();
        this.player.addMediaItems(i, list);
    }

    public void addMediaSource(MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.addMediaSource(mediaSource);
    }

    public void addMediaSource(int i, MediaSource mediaSource) {
        blockUntilConstructorFinished();
        this.player.addMediaSource(i, mediaSource);
    }

    public void addMediaSources(List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.addMediaSources(list);
    }

    public void addMediaSources(int i, List<MediaSource> list) {
        blockUntilConstructorFinished();
        this.player.addMediaSources(i, list);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        blockUntilConstructorFinished();
        this.player.moveMediaItems(i, i2, i3);
    }

    public void removeMediaItems(int i, int i2) {
        blockUntilConstructorFinished();
        this.player.removeMediaItems(i, i2);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        blockUntilConstructorFinished();
        this.player.setShuffleOrder(shuffleOrder);
    }

    public void setPlayWhenReady(boolean z) {
        blockUntilConstructorFinished();
        this.player.setPlayWhenReady(z);
    }

    public boolean getPlayWhenReady() {
        blockUntilConstructorFinished();
        return this.player.getPlayWhenReady();
    }

    public void setPauseAtEndOfMediaItems(boolean z) {
        blockUntilConstructorFinished();
        this.player.setPauseAtEndOfMediaItems(z);
    }

    public boolean getPauseAtEndOfMediaItems() {
        blockUntilConstructorFinished();
        return this.player.getPauseAtEndOfMediaItems();
    }

    public int getRepeatMode() {
        blockUntilConstructorFinished();
        return this.player.getRepeatMode();
    }

    public void setRepeatMode(int i) {
        blockUntilConstructorFinished();
        this.player.setRepeatMode(i);
    }

    public void setShuffleModeEnabled(boolean z) {
        blockUntilConstructorFinished();
        this.player.setShuffleModeEnabled(z);
    }

    public boolean getShuffleModeEnabled() {
        blockUntilConstructorFinished();
        return this.player.getShuffleModeEnabled();
    }

    public boolean isLoading() {
        blockUntilConstructorFinished();
        return this.player.isLoading();
    }

    public void seekTo(int i, long j) {
        blockUntilConstructorFinished();
        this.player.seekTo(i, j);
    }

    public long getSeekBackIncrement() {
        blockUntilConstructorFinished();
        return this.player.getSeekBackIncrement();
    }

    public long getSeekForwardIncrement() {
        blockUntilConstructorFinished();
        return this.player.getSeekForwardIncrement();
    }

    public long getMaxSeekToPreviousPosition() {
        blockUntilConstructorFinished();
        return this.player.getMaxSeekToPreviousPosition();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        blockUntilConstructorFinished();
        this.player.setPlaybackParameters(playbackParameters);
    }

    public PlaybackParameters getPlaybackParameters() {
        blockUntilConstructorFinished();
        return this.player.getPlaybackParameters();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        blockUntilConstructorFinished();
        this.player.setSeekParameters(seekParameters);
    }

    public SeekParameters getSeekParameters() {
        blockUntilConstructorFinished();
        return this.player.getSeekParameters();
    }

    public void setForegroundMode(boolean z) {
        blockUntilConstructorFinished();
        this.player.setForegroundMode(z);
    }

    public void stop() {
        blockUntilConstructorFinished();
        this.player.stop();
    }

    @Deprecated
    public void stop(boolean z) {
        blockUntilConstructorFinished();
        this.player.stop(z);
    }

    public void release() {
        blockUntilConstructorFinished();
        this.player.release();
    }

    public PlayerMessage createMessage(PlayerMessage.Target target) {
        blockUntilConstructorFinished();
        return this.player.createMessage(target);
    }

    public int getRendererCount() {
        blockUntilConstructorFinished();
        return this.player.getRendererCount();
    }

    public int getRendererType(int i) {
        blockUntilConstructorFinished();
        return this.player.getRendererType(i);
    }

    public Renderer getRenderer(int i) {
        blockUntilConstructorFinished();
        return this.player.getRenderer(i);
    }

    public TrackSelector getTrackSelector() {
        blockUntilConstructorFinished();
        return this.player.getTrackSelector();
    }

    @Deprecated
    public TrackGroupArray getCurrentTrackGroups() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTrackGroups();
    }

    @Deprecated
    public TrackSelectionArray getCurrentTrackSelections() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTrackSelections();
    }

    public Tracks getCurrentTracks() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTracks();
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        blockUntilConstructorFinished();
        return this.player.getTrackSelectionParameters();
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        blockUntilConstructorFinished();
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    public MediaMetadata getMediaMetadata() {
        blockUntilConstructorFinished();
        return this.player.getMediaMetadata();
    }

    public MediaMetadata getPlaylistMetadata() {
        blockUntilConstructorFinished();
        return this.player.getPlaylistMetadata();
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        blockUntilConstructorFinished();
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    public Timeline getCurrentTimeline() {
        blockUntilConstructorFinished();
        return this.player.getCurrentTimeline();
    }

    public int getCurrentPeriodIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentPeriodIndex();
    }

    public int getCurrentMediaItemIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentMediaItemIndex();
    }

    public long getDuration() {
        blockUntilConstructorFinished();
        return this.player.getDuration();
    }

    public long getCurrentPosition() {
        blockUntilConstructorFinished();
        return this.player.getCurrentPosition();
    }

    public long getBufferedPosition() {
        blockUntilConstructorFinished();
        return this.player.getBufferedPosition();
    }

    public long getTotalBufferedDuration() {
        blockUntilConstructorFinished();
        return this.player.getTotalBufferedDuration();
    }

    public boolean isPlayingAd() {
        blockUntilConstructorFinished();
        return this.player.isPlayingAd();
    }

    public int getCurrentAdGroupIndex() {
        blockUntilConstructorFinished();
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        blockUntilConstructorFinished();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public long getContentPosition() {
        blockUntilConstructorFinished();
        return this.player.getContentPosition();
    }

    public long getContentBufferedPosition() {
        blockUntilConstructorFinished();
        return this.player.getContentBufferedPosition();
    }

    @Deprecated
    public void setHandleWakeLock(boolean z) {
        blockUntilConstructorFinished();
        this.player.setHandleWakeLock(z);
    }

    public void setWakeMode(int i) {
        blockUntilConstructorFinished();
        this.player.setWakeMode(i);
    }

    public DeviceInfo getDeviceInfo() {
        blockUntilConstructorFinished();
        return this.player.getDeviceInfo();
    }

    public int getDeviceVolume() {
        blockUntilConstructorFinished();
        return this.player.getDeviceVolume();
    }

    public boolean isDeviceMuted() {
        blockUntilConstructorFinished();
        return this.player.isDeviceMuted();
    }

    public void setDeviceVolume(int i) {
        blockUntilConstructorFinished();
        this.player.setDeviceVolume(i);
    }

    public void increaseDeviceVolume() {
        blockUntilConstructorFinished();
        this.player.increaseDeviceVolume();
    }

    public void decreaseDeviceVolume() {
        blockUntilConstructorFinished();
        this.player.decreaseDeviceVolume();
    }

    public void setDeviceMuted(boolean z) {
        blockUntilConstructorFinished();
        this.player.setDeviceMuted(z);
    }

    /* access modifiers changed from: package-private */
    public void setThrowsWhenUsingWrongThread(boolean z) {
        blockUntilConstructorFinished();
        this.player.setThrowsWhenUsingWrongThread(z);
    }

    private void blockUntilConstructorFinished() {
        this.constructorFinished.blockUninterruptible();
    }
}
