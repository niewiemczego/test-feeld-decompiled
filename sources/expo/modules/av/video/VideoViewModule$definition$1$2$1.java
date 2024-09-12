package expo.modules.av.video;

import expo.modules.av.ViewUtils;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"expo/modules/av/video/VideoViewModule$definition$1$2$1", "Lexpo/modules/av/ViewUtils$VideoViewCallback;", "runWithVideoView", "", "videoView", "Lexpo/modules/av/video/VideoView;", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
public final class VideoViewModule$definition$1$2$1 implements ViewUtils.VideoViewCallback {
    final /* synthetic */ Promise $promise;
    final /* synthetic */ boolean $shouldBeFullscreen;

    VideoViewModule$definition$1$2$1(boolean z, Promise promise) {
        this.$shouldBeFullscreen = z;
        this.$promise = promise;
    }

    public void runWithVideoView(VideoView videoView) {
        Intrinsics.checkNotNullParameter(videoView, "videoView");
        VideoViewModule$definition$1$2$1$runWithVideoView$listener$1 videoViewModule$definition$1$2$1$runWithVideoView$listener$1 = new VideoViewModule$definition$1$2$1$runWithVideoView$listener$1(this.$promise, videoView);
        if (this.$shouldBeFullscreen) {
            videoView.ensureFullscreenPlayerIsPresented(videoViewModule$definition$1$2$1$runWithVideoView$listener$1);
        } else {
            videoView.ensureFullscreenPlayerIsDismissed(videoViewModule$definition$1$2$1$runWithVideoView$listener$1);
        }
    }
}
