package expo.modules.av.video;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/av/video/VideoViewWrapper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
final class VideoViewModule$definition$1$1$1 extends Lambda implements Function1<VideoViewWrapper, Unit> {
    public static final VideoViewModule$definition$1$1$1 INSTANCE = new VideoViewModule$definition$1$1$1();

    VideoViewModule$definition$1$1$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VideoViewWrapper) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(VideoViewWrapper videoViewWrapper) {
        Intrinsics.checkNotNullParameter(videoViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        videoViewWrapper.getVideoViewInstance().onDropViewInstance();
    }
}
