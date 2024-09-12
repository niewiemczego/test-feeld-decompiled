package expo.modules.av;

import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.uimanager.IllegalViewOperationException;
import expo.modules.av.video.VideoView;
import expo.modules.av.video.VideoViewWrapper;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.interfaces.services.UIManager;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J(\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0007J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0003J(\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0003¨\u0006\u0010"}, d2 = {"Lexpo/modules/av/ViewUtils;", "", "()V", "tryRunWithVideoView", "", "moduleRegistry", "Lexpo/modules/core/ModuleRegistry;", "viewTag", "", "callback", "Lexpo/modules/av/ViewUtils$VideoViewCallback;", "promise", "Lexpo/modules/core/Promise;", "Lexpo/modules/kotlin/Promise;", "tryRunWithVideoViewOnUiThread", "VideoViewCallback", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lexpo/modules/av/ViewUtils$VideoViewCallback;", "", "runWithVideoView", "", "videoView", "Lexpo/modules/av/video/VideoView;", "expo-av_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ViewUtils.kt */
    public interface VideoViewCallback {
        void runWithVideoView(VideoView videoView);
    }

    private ViewUtils() {
    }

    private final void tryRunWithVideoViewOnUiThread(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, Promise promise) {
        try {
            VideoViewWrapper videoViewWrapper = (VideoViewWrapper) ((UIManager) moduleRegistry.getModule(UIManager.class)).resolveView(i);
            VideoView videoViewInstance = videoViewWrapper != null ? videoViewWrapper.getVideoViewInstance() : null;
            if (videoViewInstance != null) {
                videoViewCallback.runWithVideoView(videoViewInstance);
            } else {
                promise.reject("E_VIDEO_TAGINCORRECT", "Invalid view returned from registry.");
            }
        } catch (IllegalViewOperationException unused) {
            promise.reject("E_VIDEO_TAGINCORRECT", "Invalid view returned from registry.");
        }
    }

    @JvmStatic
    @Deprecated(message = "Use `dispatchCommands` in favor of finding view with imperative calls")
    public static final void tryRunWithVideoView(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, Promise promise) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        Intrinsics.checkNotNullParameter(videoViewCallback, "callback");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (UiThreadUtil.isOnUiThread()) {
            INSTANCE.tryRunWithVideoViewOnUiThread(moduleRegistry, i, videoViewCallback, promise);
        } else {
            UiThreadUtil.runOnUiThread(new ViewUtils$$ExternalSyntheticLambda1(moduleRegistry, i, videoViewCallback, promise));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryRunWithVideoView$lambda-0  reason: not valid java name */
    public static final void m711tryRunWithVideoView$lambda0(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, Promise promise) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "$moduleRegistry");
        Intrinsics.checkNotNullParameter(videoViewCallback, "$callback");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        INSTANCE.tryRunWithVideoViewOnUiThread(moduleRegistry, i, videoViewCallback, promise);
    }

    private final void tryRunWithVideoViewOnUiThread(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, expo.modules.kotlin.Promise promise) {
        try {
            VideoViewWrapper videoViewWrapper = (VideoViewWrapper) ((UIManager) moduleRegistry.getModule(UIManager.class)).resolveView(i);
            VideoView videoViewInstance = videoViewWrapper != null ? videoViewWrapper.getVideoViewInstance() : null;
            if (videoViewInstance != null) {
                videoViewCallback.runWithVideoView(videoViewInstance);
            } else {
                promise.reject("E_VIDEO_TAGINCORRECT", "Invalid view returned from registry.", (Throwable) null);
            }
        } catch (IllegalViewOperationException unused) {
            promise.reject("E_VIDEO_TAGINCORRECT", "Invalid view returned from registry.", (Throwable) null);
        }
    }

    @Deprecated(message = "Use `dispatchCommands` in favor of finding view with imperative calls")
    public final void tryRunWithVideoView(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, expo.modules.kotlin.Promise promise) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "moduleRegistry");
        Intrinsics.checkNotNullParameter(videoViewCallback, "callback");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        if (UiThreadUtil.isOnUiThread()) {
            tryRunWithVideoViewOnUiThread(moduleRegistry, i, videoViewCallback, promise);
        } else {
            UiThreadUtil.runOnUiThread(new ViewUtils$$ExternalSyntheticLambda0(moduleRegistry, i, videoViewCallback, promise));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: tryRunWithVideoView$lambda-1  reason: not valid java name */
    public static final void m712tryRunWithVideoView$lambda1(ModuleRegistry moduleRegistry, int i, VideoViewCallback videoViewCallback, expo.modules.kotlin.Promise promise) {
        Intrinsics.checkNotNullParameter(moduleRegistry, "$moduleRegistry");
        Intrinsics.checkNotNullParameter(videoViewCallback, "$callback");
        Intrinsics.checkNotNullParameter(promise, "$promise");
        INSTANCE.tryRunWithVideoViewOnUiThread(moduleRegistry, i, videoViewCallback, promise);
    }
}
