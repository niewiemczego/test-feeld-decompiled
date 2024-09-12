package expo.modules.camera.tasks;

import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lexpo/modules/camera/tasks/BarCodeScannerAsyncTaskDelegate;", "", "onBarCodeScanned", "", "barCode", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "onBarCodeScanningTaskCompleted", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BarCodeScannerAsyncTaskDelegate.kt */
public interface BarCodeScannerAsyncTaskDelegate {
    void onBarCodeScanned(BarCodeScannerResult barCodeScannerResult);

    void onBarCodeScanningTaskCompleted();
}
