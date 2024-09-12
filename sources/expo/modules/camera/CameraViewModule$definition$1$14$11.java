package expo.modules.camera;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/camera/ExpoCameraView;", "useCamera2Api", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraViewModule.kt */
final class CameraViewModule$definition$1$14$11 extends Lambda implements Function2<ExpoCameraView, Boolean, Unit> {
    public static final CameraViewModule$definition$1$14$11 INSTANCE = new CameraViewModule$definition$1$14$11();

    CameraViewModule$definition$1$14$11() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoCameraView) obj, ((Boolean) obj2).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoCameraView expoCameraView, boolean z) {
        Intrinsics.checkNotNullParameter(expoCameraView, ViewHierarchyConstants.VIEW_KEY);
        expoCameraView.getCameraView$expo_camera_release().setUsingCamera2Api(z);
    }
}
