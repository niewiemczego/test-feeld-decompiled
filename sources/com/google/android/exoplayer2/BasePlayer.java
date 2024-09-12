package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public abstract class BasePlayer implements Player {
    protected final Timeline.Window window = new Timeline.Window();

    public final boolean canAdvertiseSession() {
        return true;
    }

    protected BasePlayer() {
    }

    public final void setMediaItem(MediaItem mediaItem) {
        setMediaItems(Collections.singletonList(mediaItem));
    }

    public final void setMediaItem(MediaItem mediaItem, long j) {
        setMediaItems(Collections.singletonList(mediaItem), 0, j);
    }

    public final void setMediaItem(MediaItem mediaItem, boolean z) {
        setMediaItems(Collections.singletonList(mediaItem), z);
    }

    public final void setMediaItems(List<MediaItem> list) {
        setMediaItems(list, true);
    }

    public final void addMediaItem(int i, MediaItem mediaItem) {
        addMediaItems(i, Collections.singletonList(mediaItem));
    }

    public final void addMediaItem(MediaItem mediaItem) {
        addMediaItems(Collections.singletonList(mediaItem));
    }

    public final void addMediaItems(List<MediaItem> list) {
        addMediaItems(Integer.MAX_VALUE, list);
    }

    public final void moveMediaItem(int i, int i2) {
        if (i != i2) {
            moveMediaItems(i, i + 1, i2);
        }
    }

    public final void removeMediaItem(int i) {
        removeMediaItems(i, i + 1);
    }

    public final void clearMediaItems() {
        removeMediaItems(0, Integer.MAX_VALUE);
    }

    public final boolean isCommandAvailable(int i) {
        return getAvailableCommands().contains(i);
    }

    public final void play() {
        setPlayWhenReady(true);
    }

    public final void pause() {
        setPlayWhenReady(false);
    }

    public final boolean isPlaying() {
        return getPlaybackState() == 3 && getPlayWhenReady() && getPlaybackSuppressionReason() == 0;
    }

    public final void seekToDefaultPosition() {
        seekToDefaultPosition(getCurrentMediaItemIndex());
    }

    public final void seekToDefaultPosition(int i) {
        seekTo(i, C.TIME_UNSET);
    }

    public final void seekTo(long j) {
        seekTo(getCurrentMediaItemIndex(), j);
    }

    public final void seekBack() {
        seekToOffset(-getSeekBackIncrement());
    }

    public final void seekForward() {
        seekToOffset(getSeekForwardIncrement());
    }

    @Deprecated
    public final boolean hasPrevious() {
        return hasPreviousMediaItem();
    }

    @Deprecated
    public final boolean hasPreviousWindow() {
        return hasPreviousMediaItem();
    }

    public final boolean hasPreviousMediaItem() {
        return getPreviousMediaItemIndex() != -1;
    }

    @Deprecated
    public final void previous() {
        seekToPreviousMediaItem();
    }

    @Deprecated
    public final void seekToPreviousWindow() {
        seekToPreviousMediaItem();
    }

    public final void seekToPreviousMediaItem() {
        int previousMediaItemIndex = getPreviousMediaItemIndex();
        if (previousMediaItemIndex != -1) {
            seekToDefaultPosition(previousMediaItemIndex);
        }
    }

    public final void seekToPrevious() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            boolean hasPreviousMediaItem = hasPreviousMediaItem();
            if (!isCurrentMediaItemLive() || isCurrentMediaItemSeekable()) {
                if (!hasPreviousMediaItem || getCurrentPosition() > getMaxSeekToPreviousPosition()) {
                    seekTo(0);
                } else {
                    seekToPreviousMediaItem();
                }
            } else if (hasPreviousMediaItem) {
                seekToPreviousMediaItem();
            }
        }
    }

    @Deprecated
    public final boolean hasNext() {
        return hasNextMediaItem();
    }

    @Deprecated
    public final boolean hasNextWindow() {
        return hasNextMediaItem();
    }

    public final boolean hasNextMediaItem() {
        return getNextMediaItemIndex() != -1;
    }

    @Deprecated
    public final void next() {
        seekToNextMediaItem();
    }

    @Deprecated
    public final void seekToNextWindow() {
        seekToNextMediaItem();
    }

    public final void seekToNextMediaItem() {
        int nextMediaItemIndex = getNextMediaItemIndex();
        if (nextMediaItemIndex != -1) {
            seekToDefaultPosition(nextMediaItemIndex);
        }
    }

    public final void seekToNext() {
        if (!getCurrentTimeline().isEmpty() && !isPlayingAd()) {
            if (hasNextMediaItem()) {
                seekToNextMediaItem();
            } else if (isCurrentMediaItemLive() && isCurrentMediaItemDynamic()) {
                seekToDefaultPosition();
            }
        }
    }

    public final void setPlaybackSpeed(float f) {
        setPlaybackParameters(getPlaybackParameters().withSpeed(f));
    }

    @Deprecated
    public final int getCurrentWindowIndex() {
        return getCurrentMediaItemIndex();
    }

    @Deprecated
    public final int getNextWindowIndex() {
        return getNextMediaItemIndex();
    }

    public final int getNextMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getNextWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    @Deprecated
    public final int getPreviousWindowIndex() {
        return getPreviousMediaItemIndex();
    }

    public final int getPreviousMediaItemIndex() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return -1;
        }
        return currentTimeline.getPreviousWindowIndex(getCurrentMediaItemIndex(), getRepeatModeForNavigation(), getShuffleModeEnabled());
    }

    public final MediaItem getCurrentMediaItem() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).mediaItem;
    }

    public final int getMediaItemCount() {
        return getCurrentTimeline().getWindowCount();
    }

    public final MediaItem getMediaItemAt(int i) {
        return getCurrentTimeline().getWindow(i, this.window).mediaItem;
    }

    public final Object getCurrentManifest() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return null;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).manifest;
    }

    public final int getBufferedPercentage() {
        long bufferedPosition = getBufferedPosition();
        long duration = getDuration();
        if (bufferedPosition == C.TIME_UNSET || duration == C.TIME_UNSET) {
            return 0;
        }
        if (duration == 0) {
            return 100;
        }
        return Util.constrainValue((int) ((bufferedPosition * 100) / duration), 0, 100);
    }

    @Deprecated
    public final boolean isCurrentWindowDynamic() {
        return isCurrentMediaItemDynamic();
    }

    public final boolean isCurrentMediaItemDynamic() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isDynamic;
    }

    @Deprecated
    public final boolean isCurrentWindowLive() {
        return isCurrentMediaItemLive();
    }

    public final boolean isCurrentMediaItemLive() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isLive();
    }

    public final long getCurrentLiveOffset() {
        Timeline currentTimeline = getCurrentTimeline();
        if (!currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).windowStartTimeMs != C.TIME_UNSET) {
            return (this.window.getCurrentUnixTimeMs() - this.window.windowStartTimeMs) - getContentPosition();
        }
        return C.TIME_UNSET;
    }

    @Deprecated
    public final boolean isCurrentWindowSeekable() {
        return isCurrentMediaItemSeekable();
    }

    public final boolean isCurrentMediaItemSeekable() {
        Timeline currentTimeline = getCurrentTimeline();
        return !currentTimeline.isEmpty() && currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).isSeekable;
    }

    public final long getContentDuration() {
        Timeline currentTimeline = getCurrentTimeline();
        if (currentTimeline.isEmpty()) {
            return C.TIME_UNSET;
        }
        return currentTimeline.getWindow(getCurrentMediaItemIndex(), this.window).getDurationMs();
    }

    private int getRepeatModeForNavigation() {
        int repeatMode = getRepeatMode();
        if (repeatMode == 1) {
            return 0;
        }
        return repeatMode;
    }

    private void seekToOffset(long j) {
        long currentPosition = getCurrentPosition() + j;
        long duration = getDuration();
        if (duration != C.TIME_UNSET) {
            currentPosition = Math.min(currentPosition, duration);
        }
        seekTo(Math.max(currentPosition, 0));
    }
}
