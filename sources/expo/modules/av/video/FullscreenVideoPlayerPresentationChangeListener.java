package expo.modules.av.video;

public interface FullscreenVideoPlayerPresentationChangeListener {
    void onFullscreenPlayerDidDismiss();

    void onFullscreenPlayerDidPresent();

    void onFullscreenPlayerWillDismiss();

    void onFullscreenPlayerWillPresent();
}
