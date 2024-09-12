package expo.modules.av.video;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/av/video/VideoViewWrapper;", "useNativeControls", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
final class VideoViewModule$definition$1$1$3 extends Lambda implements Function2<VideoViewWrapper, Boolean, Unit> {
    public static final VideoViewModule$definition$1$1$3 INSTANCE = new VideoViewModule$definition$1$1$3();

    VideoViewModule$definition$1$1$3() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((VideoViewWrapper) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(VideoViewWrapper videoViewWrapper, boolean z) {
        Intrinsics.checkNotNullParameter(videoViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        videoViewWrapper.getVideoViewInstance().setUseNativeControls(z);
    }
}
