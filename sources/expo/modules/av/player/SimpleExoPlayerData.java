package expo.modules.av.player;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.RawResourceDataSource;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoSize;
import expo.modules.av.AVManagerInterface;
import expo.modules.av.AudioFocusNotAcquiredException;
import expo.modules.av.player.PlayerData;
import expo.modules.av.player.datasource.DataSourceFactoryProvider;
import expo.modules.core.Promise;
import java.io.IOException;
import java.util.Map;

class SimpleExoPlayerData extends PlayerData implements Player.Listener, MediaSourceEventListener {
    private static final String IMPLEMENTATION_NAME = "SimpleExoPlayer";
    private static final String TAG = "SimpleExoPlayerData";
    private boolean mFirstFrameRendered = false;
    private boolean mIsLoading = true;
    private boolean mIsLooping = false;
    private Integer mLastPlaybackState = null;
    private PlayerData.LoadCompletionListener mLoadCompletionListener = null;
    private final String mOverridingExtension;
    private final Context mReactContext;
    private SimpleExoPlayer mSimpleExoPlayer = null;
    private Pair<Integer, Integer> mVideoWidthHeight = null;

    /* access modifiers changed from: protected */
    public double getCurrentPositionSeconds() {
        return -1.0d;
    }

    /* access modifiers changed from: package-private */
    public String getImplementationName() {
        return IMPLEMENTATION_NAME;
    }

    public void onDownstreamFormatChanged(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    public void onLoadCanceled(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadCompleted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onLoadStarted(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    public void onRepeatModeChanged(int i) {
    }

    public void onShuffleModeEnabledChanged(boolean z) {
    }

    public void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData) {
    }

    SimpleExoPlayerData(AVManagerInterface aVManagerInterface, Context context, Uri uri, String str, Map<String, Object> map) {
        super(aVManagerInterface, uri, map);
        this.mReactContext = context;
        this.mOverridingExtension = str;
    }

    public void load(Bundle bundle, PlayerData.LoadCompletionListener loadCompletionListener) {
        this.mLoadCompletionListener = loadCompletionListener;
        Context context = this.mAVModule.getContext();
        DefaultBandwidthMeter build = new DefaultBandwidthMeter.Builder(context).build();
        SimpleExoPlayer build2 = new SimpleExoPlayer.Builder(context).setTrackSelector(new DefaultTrackSelector(context, (ExoTrackSelection.Factory) new AdaptiveTrackSelection.Factory())).setBandwidthMeter(build).build();
        this.mSimpleExoPlayer = build2;
        build2.addListener(this);
        try {
            this.mSimpleExoPlayer.prepare(buildMediaSource(this.mUri, this.mOverridingExtension, ((DataSourceFactoryProvider) this.mAVModule.getModuleRegistry().getModule(DataSourceFactoryProvider.class)).createFactory(this.mReactContext, this.mAVModule.getModuleRegistry(), Util.getUserAgent(context, "yourApplicationName"), this.mRequestHeaders, build.getTransferListener())));
            setStatus(bundle, (Promise) null);
        } catch (IllegalStateException e) {
            onFatalError(e);
        }
    }

    public synchronized void release() {
        super.release();
        stopUpdatingProgressIfNecessary();
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.release();
            this.mSimpleExoPlayer = null;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean shouldContinueUpdatingProgress() {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        return simpleExoPlayer != null && simpleExoPlayer.getPlayWhenReady();
    }

    /* access modifiers changed from: package-private */
    public void playPlayerWithRateAndMuteIfNecessary() throws AudioFocusNotAcquiredException {
        if (this.mSimpleExoPlayer != null && shouldPlayerPlay()) {
            if (!this.mIsMuted) {
                this.mAVModule.acquireAudioFocus();
            }
            updateVolumeMuteAndDuck();
            this.mSimpleExoPlayer.setPlaybackParameters(new PlaybackParameters(this.mRate, this.mShouldCorrectPitch ? 1.0f : this.mRate));
            this.mSimpleExoPlayer.setPlayWhenReady(this.mShouldPlay);
        }
    }

    /* access modifiers changed from: package-private */
    public void applyNewStatus(Integer num, Boolean bool) throws AudioFocusNotAcquiredException, IllegalStateException {
        if (this.mSimpleExoPlayer != null) {
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                this.mIsLooping = booleanValue;
                if (booleanValue) {
                    this.mSimpleExoPlayer.setRepeatMode(2);
                } else {
                    this.mSimpleExoPlayer.setRepeatMode(0);
                }
            }
            if (!shouldPlayerPlay()) {
                this.mSimpleExoPlayer.setPlayWhenReady(false);
                stopUpdatingProgressIfNecessary();
            }
            updateVolumeMuteAndDuck();
            if (num != null) {
                this.mSimpleExoPlayer.seekTo((long) num.intValue());
            }
            playPlayerWithRateAndMuteIfNecessary();
            return;
        }
        throw new IllegalStateException("mSimpleExoPlayer is null!");
    }

    /* access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.mSimpleExoPlayer != null;
    }

    /* access modifiers changed from: package-private */
    public void getExtraStatusFields(Bundle bundle) {
        int duration = (int) this.mSimpleExoPlayer.getDuration();
        bundle.putInt("durationMillis", duration);
        boolean z = false;
        bundle.putInt("positionMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.getCurrentPosition()), 0, Integer.valueOf(duration)));
        bundle.putInt("playableDurationMillis", getClippedIntegerForValue(Integer.valueOf((int) this.mSimpleExoPlayer.getBufferedPosition()), 0, Integer.valueOf(duration)));
        bundle.putBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH, this.mSimpleExoPlayer.getPlayWhenReady() && this.mSimpleExoPlayer.getPlaybackState() == 3);
        if (this.mIsLoading || this.mSimpleExoPlayer.getPlaybackState() == 2) {
            z = true;
        }
        bundle.putBoolean("isBuffering", z);
        bundle.putBoolean("isLooping", this.mIsLooping);
    }

    public Pair<Integer, Integer> getVideoWidthHeight() {
        Pair<Integer, Integer> pair = this.mVideoWidthHeight;
        return pair != null ? pair : new Pair<>(0, 0);
    }

    public void tryUpdateVideoSurface(Surface surface) {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVideoSurface(surface);
        }
    }

    public int getAudioSessionId() {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        if (simpleExoPlayer != null) {
            return simpleExoPlayer.getAudioSessionId();
        }
        return 0;
    }

    public void pauseImmediately() {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setPlayWhenReady(false);
        }
        stopUpdatingProgressIfNecessary();
    }

    public boolean requiresAudioFocus() {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        return simpleExoPlayer != null && (simpleExoPlayer.getPlayWhenReady() || shouldPlayerPlay()) && !this.mIsMuted;
    }

    public void updateVolumeMuteAndDuck() {
        SimpleExoPlayer simpleExoPlayer = this.mSimpleExoPlayer;
        if (simpleExoPlayer != null) {
            simpleExoPlayer.setVolume(this.mAVModule.getVolumeForDuckAndFocus(this.mIsMuted, this.mVolume));
        }
    }

    public void onLoadingChanged(boolean z) {
        this.mIsLoading = z;
        callStatusUpdateListener();
    }

    public void onPlayerStateChanged(boolean z, int i) {
        PlayerData.LoadCompletionListener loadCompletionListener;
        if (i == 3 && (loadCompletionListener = this.mLoadCompletionListener) != null) {
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadSuccess(getStatus());
        }
        Integer num = this.mLastPlaybackState;
        if (num == null || i == num.intValue() || i != 4) {
            callStatusUpdateListener();
            if (z && i == 3) {
                beginUpdatingProgressIfNecessary();
            }
        } else {
            callStatusUpdateListenerWithDidJustFinish();
            stopUpdatingProgressIfNecessary();
        }
        this.mLastPlaybackState = Integer.valueOf(i);
    }

    public void onPlayerError(PlaybackException playbackException) {
        onFatalError(playbackException.getCause());
    }

    public void onPositionDiscontinuity(int i) {
        if (i == 0) {
            callStatusUpdateListenerWithDidJustFinish();
        }
    }

    public void onVideoSizeChanged(VideoSize videoSize) {
        this.mVideoWidthHeight = new Pair<>(Integer.valueOf(videoSize.width), Integer.valueOf(videoSize.height));
        if (this.mFirstFrameRendered && this.mVideoSizeUpdateListener != null) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
    }

    public void onRenderedFirstFrame() {
        if (!(this.mFirstFrameRendered || this.mVideoWidthHeight == null || this.mVideoSizeUpdateListener == null)) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(this.mVideoWidthHeight);
        }
        this.mFirstFrameRendered = true;
    }

    public void onLoadError(int i, MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z) {
        PlayerData.LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
        if (loadCompletionListener != null) {
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadError(iOException.toString());
        }
    }

    private void onFatalError(Throwable th) {
        PlayerData.LoadCompletionListener loadCompletionListener = this.mLoadCompletionListener;
        if (loadCompletionListener != null) {
            this.mLoadCompletionListener = null;
            loadCompletionListener.onLoadError(th.toString());
        } else if (this.mErrorListener != null) {
            this.mErrorListener.onError("Player error: " + th.getMessage());
        }
        release();
    }

    private MediaSource buildMediaSource(Uri uri, String str, DataSource.Factory factory) {
        try {
            if (uri.getScheme() == null) {
                DataSpec dataSpec = new DataSpec(RawResourceDataSource.buildRawResourceUri(this.mReactContext.getResources().getIdentifier(uri.toString(), "raw", this.mReactContext.getPackageName())));
                RawResourceDataSource rawResourceDataSource = new RawResourceDataSource(this.mReactContext);
                rawResourceDataSource.open(dataSpec);
                uri = rawResourceDataSource.getUri();
            }
        } catch (Exception e) {
            Log.e(TAG, "Error reading raw resource from ExoPlayer", e);
        }
        int inferContentType = Util.inferContentType(TextUtils.isEmpty(str) ? String.valueOf(uri) : "." + str);
        if (inferContentType == 0) {
            return new DashMediaSource.Factory(new DefaultDashChunkSource.Factory(factory), factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (inferContentType == 1) {
            return new SsMediaSource.Factory(new DefaultSsChunkSource.Factory(factory), factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (inferContentType == 2) {
            return new HlsMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        if (inferContentType == 4) {
            return new ProgressiveMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri));
        }
        throw new IllegalStateException("Content of this type is unsupported at the moment. Unsupported type: " + inferContentType);
    }
}
