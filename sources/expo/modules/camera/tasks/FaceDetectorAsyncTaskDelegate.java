package expo.modules.camera.tasks;

import android.os.Bundle;
import expo.modules.interfaces.facedetector.FaceDetectorInterface;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0016\u0010\u0007\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH&¨\u0006\u000b"}, d2 = {"Lexpo/modules/camera/tasks/FaceDetectorAsyncTaskDelegate;", "", "onFaceDetectingTaskCompleted", "", "onFaceDetectionError", "faceDetector", "Lexpo/modules/interfaces/facedetector/FaceDetectorInterface;", "onFacesDetected", "faces", "", "Landroid/os/Bundle;", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FaceDetectorAsyncTaskDelegate.kt */
public interface FaceDetectorAsyncTaskDelegate {
    void onFaceDetectingTaskCompleted();

    void onFaceDetectionError(FaceDetectorInterface faceDetectorInterface);

    void onFacesDetected(List<Bundle> list);
}
