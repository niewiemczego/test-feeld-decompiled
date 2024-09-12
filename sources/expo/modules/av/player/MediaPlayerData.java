package expo.modules.av.player;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.PlaybackParams;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.Surface;
import expo.modules.av.AVManagerInterface;
import expo.modules.av.AudioFocusNotAcquiredException;
import expo.modules.av.player.PlayerData;
import expo.modules.core.ModuleRegistry;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.HttpCookie;
import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MediaPlayerData extends PlayerData implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnSeekCompleteListener, MediaPlayer.OnVideoSizeChangedListener {
    static final String IMPLEMENTATION_NAME = "MediaPlayer";
    private boolean mIsBuffering = false;
    /* access modifiers changed from: private */
    public MediaPlayer mMediaPlayer = null;
    private boolean mMediaPlayerHasStartedEver = false;
    private ModuleRegistry mModuleRegistry = null;
    private Integer mPlayableDurationMillis = null;

    /* access modifiers changed from: package-private */
    public String getImplementationName() {
        return IMPLEMENTATION_NAME;
    }

    MediaPlayerData(AVManagerInterface aVManagerInterface, Context context, Uri uri, Map<String, Object> map) {
        super(aVManagerInterface, uri, map);
        this.mModuleRegistry = aVManagerInterface.getModuleRegistry();
    }

    public void load(final Bundle bundle, final PlayerData.LoadCompletionListener loadCompletionListener) {
        if (this.mMediaPlayer != null) {
            loadCompletionListener.onLoadError("Load encountered an error: MediaPlayerData cannot be loaded twice.");
            return;
        }
        MediaPlayer mediaPlayer = new MediaPlayer();
        try {
            Uri uri = this.mUri;
            if (uri.getScheme() == null) {
                uri = Uri.parse("android.resource://" + this.mAVModule.getContext().getPackageName() + "/" + this.mAVModule.getContext().getResources().getIdentifier(uri.toString(), "raw", this.mAVModule.getContext().getPackageName()));
            }
            if (Build.VERSION.SDK_INT >= 26) {
                mediaPlayer.setDataSource(this.mAVModule.getContext(), uri, (Map) null, getHttpCookiesList());
            } else {
                HashMap hashMap = new HashMap(1);
                StringBuilder sb = new StringBuilder();
                for (HttpCookie next : getHttpCookiesList()) {
                    sb.append(next.getName());
                    sb.append("=");
                    sb.append(next.getValue());
                    sb.append("; ");
                }
                sb.append("\r\n");
                hashMap.put("Cookie", sb.toString());
                if (this.mRequestHeaders != null) {
                    for (Map.Entry entry : this.mRequestHeaders.entrySet()) {
                        if (entry.getValue() instanceof String) {
                            hashMap.put((String) entry.getKey(), (String) entry.getValue());
                        }
                    }
                }
                mediaPlayer.setDataSource(this.mAVModule.getContext(), uri, hashMap);
            }
            mediaPlayer.setOnErrorListener(new MediaPlayer.OnErrorListener() {
                public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
                    loadCompletionListener.onLoadError("Load encountered an error: the OnErrorListener was called with 'what' code " + i + " and 'extra' code " + i2 + ".");
                    return true;
                }
            });
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                public void onPrepared(MediaPlayer mediaPlayer) {
                    MediaPlayerData.this.mMediaPlayer = mediaPlayer;
                    MediaPlayerData.this.mMediaPlayer.setOnBufferingUpdateListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnCompletionListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnErrorListener(MediaPlayerData.this);
                    MediaPlayerData.this.mMediaPlayer.setOnInfoListener(MediaPlayerData.this);
                    MediaPlayerData.this.setStatusWithListener(bundle, new PlayerData.SetStatusCompletionListener() {
                        public void onSetStatusComplete() {
                            loadCompletionListener.onLoadSuccess(MediaPlayerData.this.getStatus());
                        }

                        public void onSetStatusError(String str) {
                            loadCompletionListener.onLoadSuccess(MediaPlayerData.this.getStatus());
                        }
                    });
                }
            });
            try {
                mediaPlayer.prepareAsync();
            } catch (Throwable th) {
                loadCompletionListener.onLoadError("Load encountered an error: an exception was thrown from prepareAsync() with message: " + th.toString());
            }
        } catch (Throwable th2) {
            loadCompletionListener.onLoadError("Load encountered an error: setDataSource() threw an exception was thrown with message: " + th2.toString());
        }
    }

    public synchronized void release() {
        super.release();
        stopUpdatingProgressIfNecessary();
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setOnBufferingUpdateListener((MediaPlayer.OnBufferingUpdateListener) null);
            this.mMediaPlayer.setOnCompletionListener((MediaPlayer.OnCompletionListener) null);
            this.mMediaPlayer.setOnErrorListener((MediaPlayer.OnErrorListener) null);
            this.mMediaPlayer.setOnInfoListener((MediaPlayer.OnInfoListener) null);
            this.mMediaPlayer.stop();
            this.mMediaPlayer.release();
            this.mMediaPlayer = null;
        }
    }

    /* access modifiers changed from: protected */
    public double getCurrentPositionSeconds() {
        return ((double) this.mMediaPlayer.getCurrentPosition()) / 1000.0d;
    }

    /* access modifiers changed from: package-private */
    public boolean shouldContinueUpdatingProgress() {
        return this.mMediaPlayer != null && !this.mIsBuffering;
    }

    private void playMediaPlayerWithRateMAndHigher(float f) {
        PlaybackParams playbackParams = this.mMediaPlayer.getPlaybackParams();
        playbackParams.setPitch(this.mShouldCorrectPitch ? 1.0f : f);
        playbackParams.setSpeed(f);
        playbackParams.setAudioFallbackMode(0);
        this.mMediaPlayer.setPlaybackParams(playbackParams);
        this.mMediaPlayer.start();
    }

    /* access modifiers changed from: package-private */
    public void playPlayerWithRateAndMuteIfNecessary() throws AudioFocusNotAcquiredException {
        if (this.mMediaPlayer != null && shouldPlayerPlay()) {
            if (!this.mIsMuted) {
                this.mAVModule.acquireAudioFocus();
            }
            updateVolumeMuteAndDuck();
            if (Build.VERSION.SDK_INT >= 23) {
                boolean z = false;
                try {
                    PlaybackParams playbackParams = this.mMediaPlayer.getPlaybackParams();
                    float speed = playbackParams.getSpeed();
                    boolean z2 = playbackParams.getPitch() == 1.0f;
                    if (speed == this.mRate && z2 == this.mShouldCorrectPitch) {
                        z = true;
                    }
                } catch (Throwable unused) {
                }
                if (this.mRate != 0.0f && (!this.mMediaPlayer.isPlaying() || !z)) {
                    if (Build.VERSION.SDK_INT >= 24) {
                        playMediaPlayerWithRateMAndHigher(this.mRate);
                    } else if (Build.VERSION.SDK_INT >= 23) {
                        playMediaPlayerWithRateMAndHigher(2.0f);
                        this.mMediaPlayer.pause();
                        playMediaPlayerWithRateMAndHigher(this.mRate);
                    }
                    this.mMediaPlayerHasStartedEver = true;
                }
            } else if (!this.mMediaPlayer.isPlaying()) {
                this.mMediaPlayer.start();
                this.mMediaPlayerHasStartedEver = true;
            }
            beginUpdatingProgressIfNecessary();
        }
    }

    /* access modifiers changed from: package-private */
    public void applyNewStatus(Integer num, Boolean bool) throws AudioFocusNotAcquiredException, IllegalStateException {
        if (this.mMediaPlayer != null) {
            if (Build.VERSION.SDK_INT < 23 && this.mRate != 1.0f) {
                Log.w("Expo MediaPlayerData", "Cannot set audio/video playback rate for Android SDK < 23.");
                this.mRate = 1.0f;
            }
            if (bool != null) {
                this.mMediaPlayer.setLooping(bool.booleanValue());
            }
            if (!shouldPlayerPlay()) {
                if (this.mMediaPlayerHasStartedEver) {
                    this.mMediaPlayer.pause();
                }
                stopUpdatingProgressIfNecessary();
            }
            updateVolumeMuteAndDuck();
            if (!(num == null || num.intValue() == this.mMediaPlayer.getCurrentPosition())) {
                this.mMediaPlayer.seekTo(num.intValue());
            }
            playPlayerWithRateAndMuteIfNecessary();
            return;
        }
        throw new IllegalStateException("mMediaPlayer is null!");
    }

    /* access modifiers changed from: package-private */
    public boolean isLoaded() {
        return this.mMediaPlayer != null;
    }

    /* access modifiers changed from: package-private */
    public void getExtraStatusFields(Bundle bundle) {
        Integer valueOf = Integer.valueOf(this.mMediaPlayer.getDuration());
        if (valueOf.intValue() < 0) {
            valueOf = null;
        }
        if (valueOf != null) {
            bundle.putInt("durationMillis", valueOf.intValue());
        }
        bundle.putInt("positionMillis", getClippedIntegerForValue(Integer.valueOf(this.mMediaPlayer.getCurrentPosition()), 0, valueOf));
        Integer num = this.mPlayableDurationMillis;
        if (num != null) {
            bundle.putInt("playableDurationMillis", getClippedIntegerForValue(num, 0, valueOf));
        }
        bundle.putBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH, this.mMediaPlayer.isPlaying());
        bundle.putBoolean("isBuffering", this.mIsBuffering);
        bundle.putBoolean("isLooping", this.mMediaPlayer.isLooping());
    }

    public Pair<Integer, Integer> getVideoWidthHeight() {
        return this.mMediaPlayer == null ? new Pair<>(0, 0) : new Pair<>(Integer.valueOf(this.mMediaPlayer.getVideoWidth()), Integer.valueOf(this.mMediaPlayer.getVideoHeight()));
    }

    public void tryUpdateVideoSurface(Surface surface) {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setSurface(surface);
            if (!this.mMediaPlayerHasStartedEver && !this.mShouldPlay) {
                this.mMediaPlayer.start();
                this.mMediaPlayer.pause();
                this.mMediaPlayerHasStartedEver = true;
            }
        }
    }

    public int getAudioSessionId() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null) {
            return mediaPlayer.getAudioSessionId();
        }
        return 0;
    }

    public void pauseImmediately() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        if (mediaPlayer != null && this.mMediaPlayerHasStartedEver) {
            mediaPlayer.pause();
        }
        stopUpdatingProgressIfNecessary();
    }

    public boolean requiresAudioFocus() {
        MediaPlayer mediaPlayer = this.mMediaPlayer;
        return mediaPlayer != null && (mediaPlayer.isPlaying() || shouldPlayerPlay()) && !this.mIsMuted;
    }

    public void updateVolumeMuteAndDuck() {
        float f;
        if (this.mMediaPlayer != null) {
            float volumeForDuckAndFocus = this.mAVModule.getVolumeForDuckAndFocus(this.mIsMuted, this.mVolume);
            if (this.mPan > 0.0f) {
                f = volumeForDuckAndFocus;
                volumeForDuckAndFocus = (1.0f - this.mPan) * volumeForDuckAndFocus;
            } else {
                f = this.mPan < 0.0f ? (this.mPan + 1.0f) * volumeForDuckAndFocus : volumeForDuckAndFocus;
            }
            this.mMediaPlayer.setVolume(volumeForDuckAndFocus, f);
        }
    }

    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        if (mediaPlayer.getDuration() >= 0) {
            this.mPlayableDurationMillis = Integer.valueOf((int) (((double) mediaPlayer.getDuration()) * (((double) i) / 100.0d)));
        } else {
            this.mPlayableDurationMillis = null;
        }
        callStatusUpdateListener();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        callStatusUpdateListenerWithDidJustFinish();
        if (!mediaPlayer.isLooping()) {
            this.mAVModule.abandonAudioFocusIfUnused();
            stopUpdatingProgressIfNecessary();
        }
    }

    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        release();
        if (this.mErrorListener == null) {
            return true;
        }
        this.mErrorListener.onError("MediaPlayer failed with 'what' code " + i + " and 'extra' code " + i2 + ".");
        return true;
    }

    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        if (i != 3) {
            if (i == 701) {
                this.mIsBuffering = true;
            } else if (i == 702) {
                this.mIsBuffering = false;
                beginUpdatingProgressIfNecessary();
            }
        } else if (this.mVideoSizeUpdateListener != null) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(new Pair(Integer.valueOf(mediaPlayer.getVideoWidth()), Integer.valueOf(mediaPlayer.getVideoHeight())));
        }
        callStatusUpdateListener();
        return true;
    }

    public void onSeekComplete(MediaPlayer mediaPlayer) {
        callStatusUpdateListener();
    }

    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        if (this.mVideoSizeUpdateListener != null) {
            this.mVideoSizeUpdateListener.onVideoSizeUpdate(new Pair(Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    private List<HttpCookie> getHttpCookiesList() {
        CookieHandler cookieHandler;
        ModuleRegistry moduleRegistry = this.mModuleRegistry;
        if (!(moduleRegistry == null || (cookieHandler = (CookieHandler) moduleRegistry.getModule(CookieHandler.class)) == null)) {
            try {
                List<String> list = cookieHandler.get(URI.create(this.mUri.toString()), (Map) null).get("Cookie");
                if (list == null) {
                    return Collections.emptyList();
                }
                ArrayList arrayList = new ArrayList();
                for (String parse : list) {
                    arrayList.addAll(HttpCookie.parse(parse));
                }
                return arrayList;
            } catch (IOException unused) {
            }
        }
        return Collections.emptyList();
    }
}
