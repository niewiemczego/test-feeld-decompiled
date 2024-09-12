package expo.modules.camera;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import expo.modules.core.interfaces.services.UIManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/camera/ExpoCameraView;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraViewModule.kt */
final class CameraViewModule$definition$1$14$1 extends Lambda implements Function1<ExpoCameraView, Unit> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CameraViewModule$definition$1$14$1(CameraViewModule cameraViewModule) {
        super(1);
        this.this$0 = cameraViewModule;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ExpoCameraView) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoCameraView expoCameraView) {
        Object obj;
        Intrinsics.checkNotNullParameter(expoCameraView, ViewHierarchyConstants.VIEW_KEY);
        try {
            obj = this.this$0.getAppContext().getLegacyModuleRegistry().getModule(UIManager.class);
        } catch (Exception unused) {
            obj = null;
        }
        UIManager uIManager = (UIManager) obj;
        if (uIManager != null) {
            uIManager.unregisterLifecycleEventListener(expoCameraView);
        }
        expoCameraView.getCameraView$expo_camera_release().stop();
    }
}
