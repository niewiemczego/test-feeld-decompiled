package expo.modules.image.events;

import com.facebook.react.modules.network.ProgressListener;
import expo.modules.image.ExpoImageViewWrapper;
import expo.modules.image.records.ImageProgressEvent;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lexpo/modules/image/events/OkHttpProgressListener;", "Lcom/facebook/react/modules/network/ProgressListener;", "expoImageViewWrapper", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/image/ExpoImageViewWrapper;", "(Ljava/lang/ref/WeakReference;)V", "onProgress", "", "bytesWritten", "", "contentLength", "done", "", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: OkHttpProgressListener.kt */
public final class OkHttpProgressListener implements ProgressListener {
    private final WeakReference<ExpoImageViewWrapper> expoImageViewWrapper;

    public OkHttpProgressListener(WeakReference<ExpoImageViewWrapper> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "expoImageViewWrapper");
        this.expoImageViewWrapper = weakReference;
    }

    public void onProgress(long j, long j2, boolean z) {
        ExpoImageViewWrapper expoImageViewWrapper2;
        ViewEventCallback<ImageProgressEvent> onProgress$expo_image_release;
        if (j2 > 0 && !z && (expoImageViewWrapper2 = (ExpoImageViewWrapper) this.expoImageViewWrapper.get()) != null && (onProgress$expo_image_release = expoImageViewWrapper2.getOnProgress$expo_image_release()) != null) {
            onProgress$expo_image_release.invoke(new ImageProgressEvent((int) j, (int) j2));
        }
    }
}
