package com.google.android.exoplayer2;

import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.CueGroup;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.exoplayer2.video.VideoSize;
import java.util.List;

public class ForwardingPlayer implements Player {
    private final Player player;

    public ForwardingPlayer(Player player2) {
        this.player = player2;
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    public void addListener(Player.Listener listener) {
        this.player.addListener(new ForwardingListener(this, listener));
    }

    public void removeListener(Player.Listener listener) {
        this.player.removeListener(new ForwardingListener(this, listener));
    }

    public void setMediaItems(List<MediaItem> list) {
        this.player.setMediaItems(list);
    }

    public void setMediaItems(List<MediaItem> list, boolean z) {
        this.player.setMediaItems(list, z);
    }

    public void setMediaItems(List<MediaItem> list, int i, long j) {
        this.player.setMediaItems(list, i, j);
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaItem(MediaItem mediaItem, long j) {
        this.player.setMediaItem(mediaItem, j);
    }

    public void setMediaItem(MediaItem mediaItem, boolean z) {
        this.player.setMediaItem(mediaItem, z);
    }

    public void addMediaItem(MediaItem mediaItem) {
        this.player.addMediaItem(mediaItem);
    }

    public void addMediaItem(int i, MediaItem mediaItem) {
        this.player.addMediaItem(i, mediaItem);
    }

    public void addMediaItems(List<MediaItem> list) {
        this.player.addMediaItems(list);
    }

    public void addMediaItems(int i, List<MediaItem> list) {
        this.player.addMediaItems(i, list);
    }

    public void moveMediaItem(int i, int i2) {
        this.player.moveMediaItem(i, i2);
    }

    public void moveMediaItems(int i, int i2, int i3) {
        this.player.moveMediaItems(i, i2, i3);
    }

    public void removeMediaItem(int i) {
        this.player.removeMediaItem(i);
    }

    public void removeMediaItems(int i, int i2) {
        this.player.removeMediaItems(i, i2);
    }

    public void clearMediaItems() {
        this.player.clearMediaItems();
    }

    public boolean isCommandAvailable(int i) {
        return this.player.isCommandAvailable(i);
    }

    public boolean canAdvertiseSession() {
        return this.player.canAdvertiseSession();
    }

    public Player.Commands getAvailableCommands() {
        return this.player.getAvailableCommands();
    }

    public void prepare() {
        this.player.prepare();
    }

    public int getPlaybackState() {
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        return this.player.getPlaybackSuppressionReason();
    }

    public boolean isPlaying() {
        return this.player.isPlaying();
    }

    public PlaybackException getPlayerError() {
        return this.player.getPlayerError();
    }

    public void play() {
        this.player.play();
    }

    public void pause() {
        this.player.pause();
    }

    public void setPlayWhenReady(boolean z) {
        this.player.setPlayWhenReady(z);
    }

    public boolean getPlayWhenReady() {
        return this.player.getPlayWhenReady();
    }

    public void setRepeatMode(int i) {
        this.player.setRepeatMode(i);
    }

    public int getRepeatMode() {
        return this.player.getRepeatMode();
    }

    public void setShuffleModeEnabled(boolean z) {
        this.player.setShuffleModeEnabled(z);
    }

    public boolean getShuffleModeEnabled() {
        return this.player.getShuffleModeEnabled();
    }

    public boolean isLoading() {
        return this.player.isLoading();
    }

    public void seekToDefaultPosition() {
        this.player.seekToDefaultPosition();
    }

    public void seekToDefaultPosition(int i) {
        this.player.seekToDefaultPosition(i);
    }

    public void seekTo(long j) {
        this.player.seekTo(j);
    }

    public void seekTo(int i, long j) {
        this.player.seekTo(i, j);
    }

    public long getSeekBackIncrement() {
        return this.player.getSeekBackIncrement();
    }

    public void seekBack() {
        this.player.seekBack();
    }

    public long getSeekForwardIncrement() {
        return this.player.getSeekForwardIncrement();
    }

    public void seekForward() {
        this.player.seekForward();
    }

    @Deprecated
    public boolean hasPrevious() {
        return this.player.hasPrevious();
    }

    @Deprecated
    public boolean hasPreviousWindow() {
        return this.player.hasPreviousWindow();
    }

    public boolean hasPreviousMediaItem() {
        return this.player.hasPreviousMediaItem();
    }

    @Deprecated
    public void previous() {
        this.player.previous();
    }

    @Deprecated
    public void seekToPreviousWindow() {
        this.player.seekToPreviousWindow();
    }

    public void seekToPreviousMediaItem() {
        this.player.seekToPreviousMediaItem();
    }

    public void seekToPrevious() {
        this.player.seekToPrevious();
    }

    public long getMaxSeekToPreviousPosition() {
        return this.player.getMaxSeekToPreviousPosition();
    }

    @Deprecated
    public boolean hasNext() {
        return this.player.hasNext();
    }

    @Deprecated
    public boolean hasNextWindow() {
        return this.player.hasNextWindow();
    }

    public boolean hasNextMediaItem() {
        return this.player.hasNextMediaItem();
    }

    @Deprecated
    public void next() {
        this.player.next();
    }

    @Deprecated
    public void seekToNextWindow() {
        this.player.seekToNextWindow();
    }

    public void seekToNextMediaItem() {
        this.player.seekToNextMediaItem();
    }

    public void seekToNext() {
        this.player.seekToNext();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPlaybackSpeed(float f) {
        this.player.setPlaybackSpeed(f);
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.player.getPlaybackParameters();
    }

    public void stop() {
        this.player.stop();
    }

    @Deprecated
    public void stop(boolean z) {
        this.player.stop(z);
    }

    public void release() {
        this.player.release();
    }

    public Tracks getCurrentTracks() {
        return this.player.getCurrentTracks();
    }

    public TrackSelectionParameters getTrackSelectionParameters() {
        return this.player.getTrackSelectionParameters();
    }

    public void setTrackSelectionParameters(TrackSelectionParameters trackSelectionParameters) {
        this.player.setTrackSelectionParameters(trackSelectionParameters);
    }

    public MediaMetadata getMediaMetadata() {
        return this.player.getMediaMetadata();
    }

    public MediaMetadata getPlaylistMetadata() {
        return this.player.getPlaylistMetadata();
    }

    public void setPlaylistMetadata(MediaMetadata mediaMetadata) {
        this.player.setPlaylistMetadata(mediaMetadata);
    }

    public Object getCurrentManifest() {
        return this.player.getCurrentManifest();
    }

    public Timeline getCurrentTimeline() {
        return this.player.getCurrentTimeline();
    }

    public int getCurrentPeriodIndex() {
        return this.player.getCurrentPeriodIndex();
    }

    @Deprecated
    public int getCurrentWindowIndex() {
        return this.player.getCurrentWindowIndex();
    }

    public int getCurrentMediaItemIndex() {
        return this.player.getCurrentMediaItemIndex();
    }

    @Deprecated
    public int getNextWindowIndex() {
        return this.player.getNextWindowIndex();
    }

    public int getNextMediaItemIndex() {
        return this.player.getNextMediaItemIndex();
    }

    @Deprecated
    public int getPreviousWindowIndex() {
        return this.player.getPreviousWindowIndex();
    }

    public int getPreviousMediaItemIndex() {
        return this.player.getPreviousMediaItemIndex();
    }

    public MediaItem getCurrentMediaItem() {
        return this.player.getCurrentMediaItem();
    }

    public int getMediaItemCount() {
        return this.player.getMediaItemCount();
    }

    public MediaItem getMediaItemAt(int i) {
        return this.player.getMediaItemAt(i);
    }

    public long getDuration() {
        return this.player.getDuration();
    }

    public long getCurrentPosition() {
        return this.player.getCurrentPosition();
    }

    public long getBufferedPosition() {
        return this.player.getBufferedPosition();
    }

    public int getBufferedPercentage() {
        return this.player.getBufferedPercentage();
    }

    public long getTotalBufferedDuration() {
        return this.player.getTotalBufferedDuration();
    }

    @Deprecated
    public boolean isCurrentWindowDynamic() {
        return this.player.isCurrentWindowDynamic();
    }

    public boolean isCurrentMediaItemDynamic() {
        return this.player.isCurrentMediaItemDynamic();
    }

    @Deprecated
    public boolean isCurrentWindowLive() {
        return this.player.isCurrentWindowLive();
    }

    public boolean isCurrentMediaItemLive() {
        return this.player.isCurrentMediaItemLive();
    }

    public long getCurrentLiveOffset() {
        return this.player.getCurrentLiveOffset();
    }

    @Deprecated
    public boolean isCurrentWindowSeekable() {
        return this.player.isCurrentWindowSeekable();
    }

    public boolean isCurrentMediaItemSeekable() {
        return this.player.isCurrentMediaItemSeekable();
    }

    public boolean isPlayingAd() {
        return this.player.isPlayingAd();
    }

    public int getCurrentAdGroupIndex() {
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public long getContentDuration() {
        return this.player.getContentDuration();
    }

    public long getContentPosition() {
        return this.player.getContentPosition();
    }

    public long getContentBufferedPosition() {
        return this.player.getContentBufferedPosition();
    }

    public AudioAttributes getAudioAttributes() {
        return this.player.getAudioAttributes();
    }

    public void setVolume(float f) {
        this.player.setVolume(f);
    }

    public float getVolume() {
        return this.player.getVolume();
    }

    public VideoSize getVideoSize() {
        return this.player.getVideoSize();
    }

    public void clearVideoSurface() {
        this.player.clearVideoSurface();
    }

    public void clearVideoSurface(Surface surface) {
        this.player.clearVideoSurface(surface);
    }

    public void setVideoSurface(Surface surface) {
        this.player.setVideoSurface(surface);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.setVideoSurfaceHolder(surfaceHolder);
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.player.clearVideoSurfaceHolder(surfaceHolder);
    }

    public void setVideoSurfaceView(SurfaceView surfaceView) {
        this.player.setVideoSurfaceView(surfaceView);
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.player.clearVideoSurfaceView(surfaceView);
    }

    public void setVideoTextureView(TextureView textureView) {
        this.player.setVideoTextureView(textureView);
    }

    public void clearVideoTextureView(TextureView textureView) {
        this.player.clearVideoTextureView(textureView);
    }

    public CueGroup getCurrentCues() {
        return this.player.getCurrentCues();
    }

    public DeviceInfo getDeviceInfo() {
        return this.player.getDeviceInfo();
    }

    public int getDeviceVolume() {
        return this.player.getDeviceVolume();
    }

    public boolean isDeviceMuted() {
        return this.player.isDeviceMuted();
    }

    public void setDeviceVolume(int i) {
        this.player.setDeviceVolume(i);
    }

    public void increaseDeviceVolume() {
        this.player.increaseDeviceVolume();
    }

    public void decreaseDeviceVolume() {
        this.player.decreaseDeviceVolume();
    }

    public void setDeviceMuted(boolean z) {
        this.player.setDeviceMuted(z);
    }

    public Player getWrappedPlayer() {
        return this.player;
    }

    private static final class ForwardingListener implements Player.Listener {
        private final ForwardingPlayer forwardingPlayer;
        private final Player.Listener listener;

        public ForwardingListener(ForwardingPlayer forwardingPlayer2, Player.Listener listener2) {
            this.forwardingPlayer = forwardingPlayer2;
            this.listener = listener2;
        }

        public void onEvents(Player player, Player.Events events) {
            this.listener.onEvents(this.forwardingPlayer, events);
        }

        public void onTimelineChanged(Timeline timeline, int i) {
            this.listener.onTimelineChanged(timeline, i);
        }

        public void onMediaItemTransition(MediaItem mediaItem, int i) {
            this.listener.onMediaItemTransition(mediaItem, i);
        }

        public void onTracksChanged(Tracks tracks) {
            this.listener.onTracksChanged(tracks);
        }

        public void onMediaMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onMediaMetadataChanged(mediaMetadata);
        }

        public void onPlaylistMetadataChanged(MediaMetadata mediaMetadata) {
            this.listener.onPlaylistMetadataChanged(mediaMetadata);
        }

        public void onIsLoadingChanged(boolean z) {
            this.listener.onIsLoadingChanged(z);
        }

        public void onLoadingChanged(boolean z) {
            this.listener.onIsLoadingChanged(z);
        }

        public void onAvailableCommandsChanged(Player.Commands commands) {
            this.listener.onAvailableCommandsChanged(commands);
        }

        public void onTrackSelectionParametersChanged(TrackSelectionParameters trackSelectionParameters) {
            this.listener.onTrackSelectionParametersChanged(trackSelectionParameters);
        }

        public void onPlayerStateChanged(boolean z, int i) {
            this.listener.onPlayerStateChanged(z, i);
        }

        public void onPlaybackStateChanged(int i) {
            this.listener.onPlaybackStateChanged(i);
        }

        public void onPlayWhenReadyChanged(boolean z, int i) {
            this.listener.onPlayWhenReadyChanged(z, i);
        }

        public void onPlaybackSuppressionReasonChanged(int i) {
            this.listener.onPlaybackSuppressionReasonChanged(i);
        }

        public void onIsPlayingChanged(boolean z) {
            this.listener.onIsPlayingChanged(z);
        }

        public void onRepeatModeChanged(int i) {
            this.listener.onRepeatModeChanged(i);
        }

        public void onShuffleModeEnabledChanged(boolean z) {
            this.listener.onShuffleModeEnabledChanged(z);
        }

        public void onPlayerError(PlaybackException playbackException) {
            this.listener.onPlayerError(playbackException);
        }

        public void onPlayerErrorChanged(PlaybackException playbackException) {
            this.listener.onPlayerErrorChanged(playbackException);
        }

        public void onPositionDiscontinuity(int i) {
            this.listener.onPositionDiscontinuity(i);
        }

        public void onPositionDiscontinuity(Player.PositionInfo positionInfo, Player.PositionInfo positionInfo2, int i) {
            this.listener.onPositionDiscontinuity(positionInfo, positionInfo2, i);
        }

        public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
            this.listener.onPlaybackParametersChanged(playbackParameters);
        }

        public void onSeekBackIncrementChanged(long j) {
            this.listener.onSeekBackIncrementChanged(j);
        }

        public void onSeekForwardIncrementChanged(long j) {
            this.listener.onSeekForwardIncrementChanged(j);
        }

        public void onMaxSeekToPreviousPositionChanged(long j) {
            this.listener.onMaxSeekToPreviousPositionChanged(j);
        }

        public void onSeekProcessed() {
            this.listener.onSeekProcessed();
        }

        public void onVideoSizeChanged(VideoSize videoSize) {
            this.listener.onVideoSizeChanged(videoSize);
        }

        public void onSurfaceSizeChanged(int i, int i2) {
            this.listener.onSurfaceSizeChanged(i, i2);
        }

        public void onRenderedFirstFrame() {
            this.listener.onRenderedFirstFrame();
        }

        public void onAudioSessionIdChanged(int i) {
            this.listener.onAudioSessionIdChanged(i);
        }

        public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
            this.listener.onAudioAttributesChanged(audioAttributes);
        }

        public void onVolumeChanged(float f) {
            this.listener.onVolumeChanged(f);
        }

        public void onSkipSilenceEnabledChanged(boolean z) {
            this.listener.onSkipSilenceEnabledChanged(z);
        }

        public void onCues(List<Cue> list) {
            this.listener.onCues(list);
        }

        public void onCues(CueGroup cueGroup) {
            this.listener.onCues(cueGroup);
        }

        public void onMetadata(Metadata metadata) {
            this.listener.onMetadata(metadata);
        }

        public void onDeviceInfoChanged(DeviceInfo deviceInfo) {
            this.listener.onDeviceInfoChanged(deviceInfo);
        }

        public void onDeviceVolumeChanged(int i, boolean z) {
            this.listener.onDeviceVolumeChanged(i, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForwardingListener)) {
                return false;
            }
            ForwardingListener forwardingListener = (ForwardingListener) obj;
            if (!this.forwardingPlayer.equals(forwardingListener.forwardingPlayer)) {
                return false;
            }
            return this.listener.equals(forwardingListener.listener);
        }

        public int hashCode() {
            return (this.forwardingPlayer.hashCode() * 31) + this.listener.hashCode();
        }
    }
}
