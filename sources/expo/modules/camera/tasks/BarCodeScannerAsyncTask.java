package expo.modules.camera.tasks;

import android.os.AsyncTask;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B5\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\u000b¢\u0006\u0002\u0010\u000eJ'\u0010\u000f\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0010\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0011\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lexpo/modules/camera/tasks/BarCodeScannerAsyncTask;", "Landroid/os/AsyncTask;", "Ljava/lang/Void;", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "delegate", "Lexpo/modules/camera/tasks/BarCodeScannerAsyncTaskDelegate;", "barCodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "imageData", "", "width", "", "height", "rotation", "(Lexpo/modules/camera/tasks/BarCodeScannerAsyncTaskDelegate;Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;[BIII)V", "doInBackground", "params", "", "([Ljava/lang/Void;)Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "onPostExecute", "", "result", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BarCodeScannerAsyncTask.kt */
public final class BarCodeScannerAsyncTask extends AsyncTask<Void, Void, BarCodeScannerResult> {
    private final BarCodeScannerInterface barCodeScanner;
    private final BarCodeScannerAsyncTaskDelegate delegate;
    private final int height;
    private final byte[] imageData;
    private final int rotation;
    private final int width;

    public BarCodeScannerAsyncTask(BarCodeScannerAsyncTaskDelegate barCodeScannerAsyncTaskDelegate, BarCodeScannerInterface barCodeScannerInterface, byte[] bArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(barCodeScannerAsyncTaskDelegate, "delegate");
        Intrinsics.checkNotNullParameter(barCodeScannerInterface, "barCodeScanner");
        Intrinsics.checkNotNullParameter(bArr, "imageData");
        this.delegate = barCodeScannerAsyncTaskDelegate;
        this.barCodeScanner = barCodeScannerInterface;
        this.imageData = bArr;
        this.width = i;
        this.height = i2;
        this.rotation = i3;
    }

    /* access modifiers changed from: protected */
    public BarCodeScannerResult doInBackground(Void... voidArr) {
        Intrinsics.checkNotNullParameter(voidArr, "params");
        if (!isCancelled()) {
            return this.barCodeScanner.scan(this.imageData, this.width, this.height, this.rotation);
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(BarCodeScannerResult barCodeScannerResult) {
        super.onPostExecute(barCodeScannerResult);
        if (barCodeScannerResult != null) {
            this.delegate.onBarCodeScanned(barCodeScannerResult);
        }
        this.delegate.onBarCodeScanningTaskCompleted();
    }
}
