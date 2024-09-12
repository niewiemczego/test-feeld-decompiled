package expo.modules.camera;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "event", "Lexpo/modules/camera/BarCodeScannedEvent;", "invoke", "(Lexpo/modules/camera/BarCodeScannedEvent;)Ljava/lang/Short;"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoCameraView.kt */
final class ExpoCameraView$onBarCodeScanned$2 extends Lambda implements Function1<BarCodeScannedEvent, Short> {
    public static final ExpoCameraView$onBarCodeScanned$2 INSTANCE = new ExpoCameraView$onBarCodeScanned$2();

    ExpoCameraView$onBarCodeScanned$2() {
        super(1);
    }

    public final Short invoke(BarCodeScannedEvent barCodeScannedEvent) {
        Intrinsics.checkNotNullParameter(barCodeScannedEvent, "event");
        return Short.valueOf((short) (barCodeScannedEvent.getData().hashCode() % 32767));
    }
}
