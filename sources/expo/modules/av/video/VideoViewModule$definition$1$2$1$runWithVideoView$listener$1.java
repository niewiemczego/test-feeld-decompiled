package expo.modules.av.video;

import expo.modules.kotlin.Promise;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\u0012\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\b\u001a\u00020\u0003H\u0014J\b\u0010\t\u001a\u00020\u0003H\u0014¨\u0006\n"}, d2 = {"expo/modules/av/video/VideoViewModule$definition$1$2$1$runWithVideoView$listener$1", "Lexpo/modules/av/video/FullscreenVideoPlayerPresentationChangeProgressListener;", "onFullscreenPlayerDidDismiss", "", "onFullscreenPlayerDidPresent", "onFullscreenPlayerPresentationError", "errorMessage", "", "onFullscreenPlayerPresentationInterrupted", "onFullscreenPlayerPresentationTriedToInterrupt", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
public final class VideoViewModule$definition$1$2$1$runWithVideoView$listener$1 extends FullscreenVideoPlayerPresentationChangeProgressListener {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ VideoView $videoView;

    VideoViewModule$definition$1$2$1$runWithVideoView$listener$1(Promise promise, VideoView videoView) {
        this.$promise = promise;
        this.$videoView = videoView;
    }

    public void onFullscreenPlayerDidDismiss() {
        this.$promise.resolve(this.$videoView.getStatus());
    }

    public void onFullscreenPlayerDidPresent() {
        this.$promise.resolve(this.$videoView.getStatus());
    }

    /* access modifiers changed from: protected */
    public void onFullscreenPlayerPresentationTriedToInterrupt() {
        this.$promise.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change tries to interrupt an older request. Await the old request and then try again.", (Throwable) null);
    }

    /* access modifiers changed from: protected */
    public void onFullscreenPlayerPresentationInterrupted() {
        this.$promise.reject("E_FULLSCREEN_VIDEO_PLAYER", "This presentation change has been interrupted by a newer change request.", (Throwable) null);
    }

    /* access modifiers changed from: protected */
    public void onFullscreenPlayerPresentationError(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("This presentation change has been interrupted by an error.");
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        this.$promise.reject("E_FULLSCREEN_VIDEO_PLAYER", sb.toString(), (Throwable) null);
    }
}
