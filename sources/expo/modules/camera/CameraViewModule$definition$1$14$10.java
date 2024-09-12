package expo.modules.camera;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0005H\n¢\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "view", "Lexpo/modules/camera/ExpoCameraView;", "settings", "", "", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraViewModule.kt */
final class CameraViewModule$definition$1$14$10 extends Lambda implements Function2<ExpoCameraView, Map<String, ? extends Object>, Unit> {
    public static final CameraViewModule$definition$1$14$10 INSTANCE = new CameraViewModule$definition$1$14$10();

    CameraViewModule$definition$1$14$10() {
        super(2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((ExpoCameraView) obj, (Map<String, ? extends Object>) (Map) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(ExpoCameraView expoCameraView, Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(expoCameraView, ViewHierarchyConstants.VIEW_KEY);
        expoCameraView.setBarCodeScannerSettings(new BarCodeScannerSettings(map));
    }
}
