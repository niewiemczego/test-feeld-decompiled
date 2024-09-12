package expo.modules.camera.tasks;

import expo.modules.interfaces.facedetector.FaceDetectionError;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FaceDetectorTask$$ExternalSyntheticLambda1 implements FaceDetectionError {
    public final /* synthetic */ FaceDetectorTask f$0;

    public /* synthetic */ FaceDetectorTask$$ExternalSyntheticLambda1(FaceDetectorTask faceDetectorTask) {
        this.f$0 = faceDetectorTask;
    }

    public final void onError(Throwable th) {
        FaceDetectorTask.m750execute$lambda3(this.f$0, th);
    }
}
