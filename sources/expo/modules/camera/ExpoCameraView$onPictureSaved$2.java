package expo.modules.camera;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "event", "Lexpo/modules/camera/PictureSavedEvent;", "invoke", "(Lexpo/modules/camera/PictureSavedEvent;)Ljava/lang/Short;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoCameraView.kt */
final class ExpoCameraView$onPictureSaved$2 extends Lambda implements Function1<PictureSavedEvent, Short> {
    public static final ExpoCameraView$onPictureSaved$2 INSTANCE = new ExpoCameraView$onPictureSaved$2();

    ExpoCameraView$onPictureSaved$2() {
        super(1);
    }

    public final Short invoke(PictureSavedEvent pictureSavedEvent) {
        Intrinsics.checkNotNullParameter(pictureSavedEvent, "event");
        String string = pictureSavedEvent.getData().getString("uri");
        return Short.valueOf((short) ((string != null ? string.hashCode() : -1) % 32767));
    }
}
