package zendesk.ui.android.internal;

import coil.util.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J,\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"zendesk/ui/android/internal/ImageLoaderFactory$getImageLoader$5", "Lcoil/util/Logger;", "level", "", "getLevel", "()I", "setLevel", "(I)V", "log", "", "tag", "", "priority", "message", "throwable", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageLoaderFactory.kt */
public final class ImageLoaderFactory$getImageLoader$5 implements Logger {
    private int level = 3;

    ImageLoaderFactory$getImageLoader$5() {
    }

    public int getLevel() {
        return this.level;
    }

    public void setLevel(int i) {
        this.level = i;
    }

    public void log(String str, int i, String str2, Throwable th) {
        Intrinsics.checkNotNullParameter(str, "tag");
        zendesk.logger.Logger.i(str, str2, new Object[0]);
    }
}
