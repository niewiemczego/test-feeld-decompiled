package expo.modules.av.video;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import expo.modules.av.AVManagerInterface;
import expo.modules.av.AudioEventHandler;
import expo.modules.av.player.PlayerData;
import expo.modules.av.player.PlayerDataControl;
import expo.modules.av.video.scalablevideoview.ScalableType;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.kotlin.AppContext;
import kotlin.Unit;

public class VideoView extends FrameLayout implements AudioEventHandler, FullscreenVideoPlayerPresentationChangeListener, PlayerData.FullscreenPresenter {
    private final AVManagerInterface mAVModule;
    private FullscreenVideoPlayer mFullscreenPlayer = null;
    private FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenPlayerPresentationChangeProgressListener = null;
    /* access modifiers changed from: private */
    public FullscreenVideoPlayerPresentationChangeProgressListener mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
    /* access modifiers changed from: private */
    public boolean mIsLoaded = false;
    private ReadableArguments mLastSource;
    /* access modifiers changed from: private */
    public MediaController mMediaController = null;
    /* access modifiers changed from: private */
    public final Runnable mMediaControllerUpdater = new Runnable() {
        public void run() {
            if (VideoView.this.mMediaController != null) {
                VideoView.this.mMediaController.updateControls();
            }
        }
    };
    private Boolean mOverridingUseNativeControls = null;
    /* access modifiers changed from: private */
    public PlayerData mPlayerData = null;
    /* access modifiers changed from: private */
    public ScalableType mResizeMode = ScalableType.LEFT_TOP;
    /* access modifiers changed from: private */
    public boolean mShouldShowFullscreenPlayerOnLoad = false;
    private Bundle mStatusToSet = new Bundle();
    /* access modifiers changed from: private */
    public final PlayerData.StatusUpdateListener mStatusUpdateListener = new PlayerData.StatusUpdateListener() {
        public void onStatusUpdate(Bundle bundle) {
            VideoView videoView = VideoView.this;
            videoView.post(videoView.mMediaControllerUpdater);
            VideoView.this.mVideoViewWrapper.getOnStatusUpdate().invoke(bundle);
        }
    };
    private boolean mUseNativeControls = false;
    /* access modifiers changed from: private */
    public VideoTextureView mVideoTextureView = null;
    /* access modifiers changed from: private */
    public VideoViewWrapper mVideoViewWrapper;
    /* access modifiers changed from: private */
    public Pair<Integer, Integer> mVideoWidthHeight = null;

    public VideoView(Context context, VideoViewWrapper videoViewWrapper, AppContext appContext) {
        super(context);
        this.mVideoViewWrapper = videoViewWrapper;
        AVManagerInterface aVManagerInterface = (AVManagerInterface) appContext.getLegacyModuleRegistry().getModule(AVManagerInterface.class);
        this.mAVModule = aVManagerInterface;
        aVManagerInterface.registerVideoViewForAudioLifecycle(this);
        VideoTextureView videoTextureView = new VideoTextureView(context, this);
        this.mVideoTextureView = videoTextureView;
        addView(videoTextureView, generateDefaultLayoutParams());
        FullscreenVideoPlayer fullscreenVideoPlayer = new FullscreenVideoPlayer(context, this, appContext);
        this.mFullscreenPlayer = fullscreenVideoPlayer;
        fullscreenVideoPlayer.setUpdateListener(this);
        MediaController mediaController = new MediaController(getContext());
        this.mMediaController = mediaController;
        mediaController.setAnchorView(this);
        maybeUpdateMediaControllerForUseNativeControls();
    }

    public void unloadPlayerAndMediaController() {
        ensureFullscreenPlayerIsDismissed();
        MediaController mediaController = this.mMediaController;
        if (mediaController != null) {
            mediaController.hide();
            this.mMediaController.setEnabled(false);
            this.mMediaController.setAnchorView((ViewGroup) null);
            this.mMediaController = null;
        }
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.release();
            this.mPlayerData = null;
        }
        this.mIsLoaded = false;
    }

    /* access modifiers changed from: package-private */
    public void onDropViewInstance() {
        this.mAVModule.unregisterVideoViewForAudioLifecycle(this);
        unloadPlayerAndMediaController();
    }

    /* access modifiers changed from: private */
    public void callOnError(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("error", str);
        this.mVideoViewWrapper.getOnError().invoke(bundle);
    }

    /* access modifiers changed from: private */
    public void callOnReadyForDisplay(Pair<Integer, Integer> pair) {
        if (pair != null && this.mIsLoaded) {
            int intValue = ((Integer) pair.first).intValue();
            int intValue2 = ((Integer) pair.second).intValue();
            if (intValue != 0 && intValue2 != 0) {
                Bundle bundle = new Bundle();
                bundle.putInt("width", intValue);
                bundle.putInt("height", intValue2);
                bundle.putString("orientation", intValue > intValue2 ? "landscape" : "portrait");
                Bundle bundle2 = new Bundle();
                bundle2.putBundle("naturalSize", bundle);
                bundle2.putBundle("status", this.mPlayerData.getStatus());
                this.mVideoViewWrapper.getOnReadyForDisplay().invoke(bundle2);
            }
        }
    }

    public void maybeUpdateMediaControllerForUseNativeControls() {
        maybeUpdateMediaControllerForUseNativeControls(true);
    }

    public void maybeUpdateMediaControllerForUseNativeControls(boolean z) {
        MediaController mediaController;
        if (this.mPlayerData != null && (mediaController = this.mMediaController) != null) {
            mediaController.updateControls();
            this.mMediaController.setEnabled(shouldUseNativeControls());
            if (!shouldUseNativeControls() || !z) {
                this.mMediaController.hide();
            } else {
                this.mMediaController.show();
            }
        }
    }

    public void ensureFullscreenPlayerIsPresented() {
        ensureFullscreenPlayerIsPresented((FullscreenVideoPlayerPresentationChangeProgressListener) null);
    }

    public void ensureFullscreenPlayerIsPresented(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(true, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else if (!isBeingPresentedFullscreen()) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
            }
            this.mFullscreenPlayer.show();
        } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
        }
    }

    public void ensureFullscreenPlayerIsDismissed() {
        ensureFullscreenPlayerIsDismissed((FullscreenVideoPlayerPresentationChangeProgressListener) null);
    }

    public void ensureFullscreenPlayerIsDismissed(FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        if (!this.mIsLoaded) {
            saveFullscreenPlayerStateForOnLoad(false, fullscreenVideoPlayerPresentationChangeProgressListener);
        } else if (this.mFullscreenPlayerPresentationChangeProgressListener != null) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerPresentationTriedToInterrupt();
            }
        } else if (isBeingPresentedFullscreen()) {
            if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
                this.mFullscreenPlayerPresentationChangeProgressListener = fullscreenVideoPlayerPresentationChangeProgressListener;
            }
            this.mFullscreenPlayer.dismiss();
        } else if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
        }
    }

    private void saveFullscreenPlayerStateForOnLoad(boolean z, FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener) {
        this.mShouldShowFullscreenPlayerOnLoad = z;
        FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener2 = this.mFullscreenVideoPlayerPresentationOnLoadChangeListener;
        if (fullscreenVideoPlayerPresentationChangeProgressListener2 != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener2.onFullscreenPlayerPresentationInterrupted();
        }
        this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = fullscreenVideoPlayerPresentationChangeProgressListener;
    }

    public void onFullscreenPlayerWillPresent() {
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_PRESENT);
        FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener = this.mFullscreenPlayerPresentationChangeProgressListener;
        if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerWillPresent();
        }
    }

    public void onFullscreenPlayerDidPresent() {
        MediaController mediaController = this.mMediaController;
        if (mediaController != null) {
            mediaController.updateControls();
        }
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_PRESENT);
        FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener = this.mFullscreenPlayerPresentationChangeProgressListener;
        if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidPresent();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    public void onFullscreenPlayerWillDismiss() {
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_WILL_DISMISS);
        FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener = this.mFullscreenPlayerPresentationChangeProgressListener;
        if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerWillDismiss();
        }
    }

    public void onFullscreenPlayerDidDismiss() {
        MediaController mediaController = this.mMediaController;
        if (mediaController != null) {
            mediaController.updateControls();
        }
        callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate.FULLSCREEN_PLAYER_DID_DISMISS);
        FullscreenVideoPlayerPresentationChangeProgressListener fullscreenVideoPlayerPresentationChangeProgressListener = this.mFullscreenPlayerPresentationChangeProgressListener;
        if (fullscreenVideoPlayerPresentationChangeProgressListener != null) {
            fullscreenVideoPlayerPresentationChangeProgressListener.onFullscreenPlayerDidDismiss();
            this.mFullscreenPlayerPresentationChangeProgressListener = null;
        }
    }

    private void callFullscreenCallbackWithUpdate(FullscreenPlayerUpdate fullscreenPlayerUpdate) {
        Bundle bundle = new Bundle();
        bundle.putInt("fullscreenUpdate", fullscreenPlayerUpdate.getJsValue());
        bundle.putBundle("status", getStatus());
        this.mVideoViewWrapper.getOnFullscreenUpdate().invoke(bundle);
    }

    public void setStatus(ReadableArguments readableArguments, Promise promise) {
        Bundle bundle = readableArguments.toBundle();
        this.mStatusToSet.putAll(bundle);
        if (this.mPlayerData != null) {
            new Bundle().putAll(this.mStatusToSet);
            this.mStatusToSet = new Bundle();
            this.mPlayerData.setStatus(bundle, promise);
        } else if (promise != null) {
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    public Bundle getStatus() {
        PlayerData playerData = this.mPlayerData;
        return playerData == null ? PlayerData.getUnloadedStatus() : playerData.getStatus();
    }

    private boolean shouldUseNativeControls() {
        Boolean bool = this.mOverridingUseNativeControls;
        if (bool != null) {
            return bool.booleanValue();
        }
        return this.mUseNativeControls;
    }

    /* access modifiers changed from: package-private */
    public void setOverridingUseNativeControls(Boolean bool) {
        this.mOverridingUseNativeControls = bool;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    /* access modifiers changed from: package-private */
    public void setUseNativeControls(boolean z) {
        this.mUseNativeControls = z;
        maybeUpdateMediaControllerForUseNativeControls();
    }

    private static boolean equalBundles(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size() || !bundle.keySet().containsAll(bundle2.keySet())) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if (!(obj instanceof Bundle) || !(obj2 instanceof Bundle)) {
                if (obj == null) {
                    if (obj2 != null) {
                        return false;
                    }
                } else if (!obj.equals(obj2)) {
                    return false;
                }
            } else if (!equalBundles((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
        }
        return true;
    }

    public void setSource(ReadableArguments readableArguments) {
        ReadableArguments readableArguments2 = this.mLastSource;
        if (readableArguments2 == null || !equalBundles(readableArguments2.toBundle(), readableArguments.toBundle())) {
            this.mLastSource = readableArguments;
            setSource(readableArguments, (ReadableArguments) null, (Promise) null);
        }
    }

    public void setSource(ReadableArguments readableArguments, ReadableArguments readableArguments2, final Promise promise) {
        PlayerData playerData = this.mPlayerData;
        String str = null;
        if (playerData != null) {
            this.mStatusToSet.putAll(playerData.getStatus());
            this.mPlayerData.release();
            this.mPlayerData = null;
            this.mIsLoaded = false;
        }
        if (readableArguments2 != null) {
            this.mStatusToSet.putAll(readableArguments2.toBundle());
        }
        if (readableArguments != null) {
            str = readableArguments.getString("uri");
        }
        if (str != null) {
            this.mVideoViewWrapper.getOnLoadStart().invoke(Unit.INSTANCE);
            Bundle bundle = new Bundle();
            bundle.putAll(this.mStatusToSet);
            this.mStatusToSet = new Bundle();
            PlayerData createUnloadedPlayerData = PlayerData.createUnloadedPlayerData(this.mAVModule, getContext(), readableArguments, bundle);
            this.mPlayerData = createUnloadedPlayerData;
            createUnloadedPlayerData.setErrorListener(new PlayerData.ErrorListener() {
                public void onError(String str) {
                    VideoView.this.unloadPlayerAndMediaController();
                    VideoView.this.callOnError(str);
                }
            });
            this.mPlayerData.setVideoSizeUpdateListener(new PlayerData.VideoSizeUpdateListener() {
                public void onVideoSizeUpdate(Pair<Integer, Integer> pair) {
                    VideoView.this.mVideoTextureView.scaleVideoSize(pair, VideoView.this.mResizeMode);
                    VideoView.this.mVideoWidthHeight = pair;
                    VideoView.this.callOnReadyForDisplay(pair);
                }
            });
            this.mPlayerData.setFullscreenPresenter(this);
            this.mPlayerData.load(bundle, new PlayerData.LoadCompletionListener() {
                public void onLoadSuccess(Bundle bundle) {
                    VideoView.this.mIsLoaded = true;
                    VideoView.this.mVideoTextureView.scaleVideoSize(VideoView.this.mPlayerData.getVideoWidthHeight(), VideoView.this.mResizeMode);
                    if (VideoView.this.mVideoTextureView.isAttachedToWindow()) {
                        VideoView.this.mPlayerData.tryUpdateVideoSurface(VideoView.this.mVideoTextureView.getSurface());
                    }
                    if (promise != null) {
                        Bundle bundle2 = new Bundle();
                        bundle2.putAll(bundle);
                        promise.resolve(bundle2);
                    }
                    VideoView.this.mPlayerData.setStatusUpdateListener(VideoView.this.mStatusUpdateListener);
                    if (VideoView.this.mMediaController == null) {
                        VideoView.this.mMediaController = new MediaController(VideoView.this.getContext());
                    }
                    VideoView.this.mMediaController.setMediaPlayer(new PlayerDataControl(VideoView.this.mPlayerData));
                    VideoView.this.mMediaController.setAnchorView(VideoView.this);
                    VideoView.this.maybeUpdateMediaControllerForUseNativeControls(false);
                    VideoView.this.mVideoViewWrapper.getOnLoad().invoke(bundle);
                    if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                        FullscreenVideoPlayerPresentationChangeProgressListener r4 = VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener;
                        VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                        if (VideoView.this.mShouldShowFullscreenPlayerOnLoad) {
                            VideoView.this.ensureFullscreenPlayerIsPresented(r4);
                        } else {
                            VideoView.this.ensureFullscreenPlayerIsDismissed(r4);
                        }
                    }
                    VideoView videoView = VideoView.this;
                    videoView.callOnReadyForDisplay(videoView.mVideoWidthHeight);
                }

                public void onLoadError(String str) {
                    if (VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener != null) {
                        VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener.onFullscreenPlayerPresentationError(str);
                        VideoView.this.mFullscreenVideoPlayerPresentationOnLoadChangeListener = null;
                    }
                    VideoView.this.mShouldShowFullscreenPlayerOnLoad = false;
                    VideoView.this.unloadPlayerAndMediaController();
                    Promise promise = promise;
                    if (promise != null) {
                        promise.reject("E_VIDEO_NOTCREATED", str);
                    }
                    VideoView.this.callOnError(str);
                }
            });
        } else if (promise != null) {
            promise.resolve(PlayerData.getUnloadedStatus());
        }
    }

    /* access modifiers changed from: package-private */
    public void setResizeMode(ScalableType scalableType) {
        if (this.mResizeMode != scalableType) {
            this.mResizeMode = scalableType;
            PlayerData playerData = this.mPlayerData;
            if (playerData != null) {
                this.mVideoTextureView.scaleVideoSize(playerData.getVideoWidthHeight(), this.mResizeMode);
            }
        }
    }

    private int getReactId() {
        return this.mVideoViewWrapper.getId();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        MediaController mediaController;
        if (shouldUseNativeControls() && (mediaController = this.mMediaController) != null) {
            mediaController.show();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        PlayerData playerData;
        super.onLayout(z, i, i2, i3, i4);
        if (z && (playerData = this.mPlayerData) != null) {
            this.mVideoTextureView.scaleVideoSize(playerData.getVideoWidthHeight(), this.mResizeMode);
        }
    }

    public void tryUpdateVideoSurface(Surface surface) {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.tryUpdateVideoSurface(surface);
        }
    }

    public void pauseImmediately() {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.pauseImmediately();
        }
    }

    public boolean requiresAudioFocus() {
        PlayerData playerData = this.mPlayerData;
        return playerData != null && playerData.requiresAudioFocus();
    }

    public void updateVolumeMuteAndDuck() {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.updateVolumeMuteAndDuck();
        }
    }

    public void handleAudioFocusInterruptionBegan() {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.handleAudioFocusInterruptionBegan();
        }
    }

    public void handleAudioFocusGained() {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.handleAudioFocusGained();
        }
    }

    public void onPause() {
        if (this.mPlayerData != null) {
            ensureFullscreenPlayerIsDismissed();
            this.mPlayerData.onPause();
        }
    }

    public void onResume() {
        PlayerData playerData = this.mPlayerData;
        if (playerData != null) {
            playerData.onResume();
        }
        this.mVideoTextureView.onResume();
    }

    public boolean isBeingPresentedFullscreen() {
        return this.mFullscreenPlayer.isShowing();
    }

    public void setFullscreenMode(boolean z) {
        if (z) {
            ensureFullscreenPlayerIsPresented();
        } else {
            ensureFullscreenPlayerIsDismissed();
        }
    }
}
