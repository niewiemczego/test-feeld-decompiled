package expo.modules.av.video;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.view.Window;
import android.widget.FrameLayout;
import expo.modules.av.player.PlayerData;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.interfaces.services.KeepAwakeManager;
import expo.modules.kotlin.AppContext;
import java.lang.ref.WeakReference;

public class FullscreenVideoPlayer extends Dialog {
    /* access modifiers changed from: private */
    public WeakReference<AppContext> mAppContext;
    private final FrameLayout mContainerView;
    /* access modifiers changed from: private */
    public Handler mKeepScreenOnHandler = new Handler();
    private Runnable mKeepScreenOnUpdater = new KeepScreenOnUpdater(this);
    private FrameLayout mParent;
    private WeakReference<FullscreenVideoPlayerPresentationChangeListener> mUpdateListener;
    /* access modifiers changed from: private */
    public final VideoView mVideoView;

    private static class KeepScreenOnUpdater implements Runnable {
        private static final long UPDATE_KEEP_SCREEN_ON_FLAG_MS = 200;
        private final WeakReference<FullscreenVideoPlayer> mFullscreenPlayer;

        KeepScreenOnUpdater(FullscreenVideoPlayer fullscreenVideoPlayer) {
            this.mFullscreenPlayer = new WeakReference<>(fullscreenVideoPlayer);
        }

        public void run() {
            FullscreenVideoPlayer fullscreenVideoPlayer = (FullscreenVideoPlayer) this.mFullscreenPlayer.get();
            if (fullscreenVideoPlayer != null) {
                Window window = fullscreenVideoPlayer.getWindow();
                if (window != null) {
                    boolean z = true;
                    boolean z2 = fullscreenVideoPlayer.mVideoView.getStatus().containsKey(PlayerData.STATUS_IS_PLAYING_KEY_PATH) && fullscreenVideoPlayer.mVideoView.getStatus().getBoolean(PlayerData.STATUS_IS_PLAYING_KEY_PATH);
                    AppContext appContext = (AppContext) fullscreenVideoPlayer.mAppContext.get();
                    ModuleRegistry legacyModuleRegistry = appContext != null ? appContext.getLegacyModuleRegistry() : null;
                    if (legacyModuleRegistry != null) {
                        KeepAwakeManager keepAwakeManager = (KeepAwakeManager) legacyModuleRegistry.getModule(KeepAwakeManager.class);
                        if (keepAwakeManager == null || !keepAwakeManager.isActivated()) {
                            z = false;
                        }
                        if (z2 || z) {
                            window.addFlags(128);
                        } else {
                            window.addFlags(128);
                        }
                    }
                }
                fullscreenVideoPlayer.mKeepScreenOnHandler.postDelayed(this, UPDATE_KEEP_SCREEN_ON_FLAG_MS);
            }
        }
    }

    FullscreenVideoPlayer(Context context, VideoView videoView, AppContext appContext) {
        super(context, 16973834);
        this.mAppContext = new WeakReference<>(appContext);
        setCancelable(false);
        this.mVideoView = videoView;
        FrameLayout frameLayout = new FrameLayout(context);
        this.mContainerView = frameLayout;
        setContentView(frameLayout, generateDefaultLayoutParams());
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (isShowing()) {
            dismiss();
        }
    }

    public void show() {
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerWillPresent();
        }
        super.show();
    }

    public void dismiss() {
        this.mVideoView.setOverridingUseNativeControls((Boolean) null);
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerWillDismiss();
        }
        super.dismiss();
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        FrameLayout frameLayout = (FrameLayout) this.mVideoView.getParent();
        this.mParent = frameLayout;
        frameLayout.removeView(this.mVideoView);
        this.mContainerView.addView(this.mVideoView, generateDefaultLayoutParams());
        super.onStart();
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerDidPresent();
        }
        this.mVideoView.setOverridingUseNativeControls(true);
        this.mKeepScreenOnHandler.post(this.mKeepScreenOnUpdater);
    }

    /* access modifiers changed from: package-private */
    public void setUpdateListener(FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener) {
        this.mUpdateListener = new WeakReference<>(fullscreenVideoPlayerPresentationChangeListener);
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        this.mKeepScreenOnHandler.removeCallbacks(this.mKeepScreenOnUpdater);
        this.mContainerView.removeView(this.mVideoView);
        this.mParent.addView(this.mVideoView, generateDefaultLayoutParams());
        this.mParent.requestLayout();
        this.mParent = null;
        super.onStop();
        FullscreenVideoPlayerPresentationChangeListener fullscreenVideoPlayerPresentationChangeListener = (FullscreenVideoPlayerPresentationChangeListener) this.mUpdateListener.get();
        if (fullscreenVideoPlayerPresentationChangeListener != null) {
            fullscreenVideoPlayerPresentationChangeListener.onFullscreenPlayerDidDismiss();
        }
    }

    private FrameLayout.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }
}
