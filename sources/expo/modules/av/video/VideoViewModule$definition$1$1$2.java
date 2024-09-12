package expo.modules.av.video;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.core.Promise;
import expo.modules.core.arguments.MapArguments;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/av/video/VideoViewWrapper;", "status", "Lcom/facebook/react/bridge/ReadableMap;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: VideoViewModule.kt */
final class VideoViewModule$definition$1$1$2 extends Lambda implements Function2<VideoViewWrapper, ReadableMap, Unit> {
    public static final VideoViewModule$definition$1$1$2 INSTANCE = new VideoViewModule$definition$1$1$2();

    VideoViewModule$definition$1$1$2() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((VideoViewWrapper) obj, (ReadableMap) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(VideoViewWrapper videoViewWrapper, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(videoViewWrapper, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(readableMap, "status");
        videoViewWrapper.getVideoViewInstance().setStatus(new MapArguments(readableMap.toHashMap()), (Promise) null);
    }
}
