package expo.modules.camera.tasks;

import expo.modules.interfaces.facedetector.FaceDetectorInterface;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001BM\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/camera/tasks/FaceDetectorTask;", "", "mDelegate", "Lexpo/modules/camera/tasks/FaceDetectorAsyncTaskDelegate;", "mFaceDetector", "Lexpo/modules/interfaces/facedetector/FaceDetectorInterface;", "mImageData", "", "mWidth", "", "mHeight", "mRotation", "mMirrored", "", "mScaleX", "", "mScaleY", "(Lexpo/modules/camera/tasks/FaceDetectorAsyncTaskDelegate;Lexpo/modules/interfaces/facedetector/FaceDetectorInterface;[BIIIZDD)V", "execute", "", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FaceDetectorTask.kt */
public final class FaceDetectorTask {
    private final FaceDetectorAsyncTaskDelegate mDelegate;
    private final FaceDetectorInterface mFaceDetector;
    private final int mHeight;
    private final byte[] mImageData;
    private final boolean mMirrored;
    private final int mRotation;
    private final double mScaleX;
    private final double mScaleY;
    private final int mWidth;

    public FaceDetectorTask(FaceDetectorAsyncTaskDelegate faceDetectorAsyncTaskDelegate, FaceDetectorInterface faceDetectorInterface, byte[] bArr, int i, int i2, int i3, boolean z, double d, double d2) {
        Intrinsics.checkNotNullParameter(faceDetectorAsyncTaskDelegate, "mDelegate");
        Intrinsics.checkNotNullParameter(faceDetectorInterface, "mFaceDetector");
        Intrinsics.checkNotNullParameter(bArr, "mImageData");
        this.mDelegate = faceDetectorAsyncTaskDelegate;
        this.mFaceDetector = faceDetectorInterface;
        this.mImageData = bArr;
        this.mWidth = i;
        this.mHeight = i2;
        this.mRotation = i3;
        this.mMirrored = z;
        this.mScaleX = d;
        this.mScaleY = d2;
    }

    public final void execute() {
        this.mFaceDetector.detectFaces(this.mImageData, this.mWidth, this.mHeight, this.mRotation, this.mMirrored, this.mScaleX, this.mScaleY, new FaceDetectorTask$$ExternalSyntheticLambda0(this), new FaceDetectorTask$$ExternalSyntheticLambda1(this), new FaceDetectorTask$$ExternalSyntheticLambda2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-2  reason: not valid java name */
    public static final void m749execute$lambda2(FaceDetectorTask faceDetectorTask, ArrayList arrayList) {
        Unit unit;
        Intrinsics.checkNotNullParameter(faceDetectorTask, "this$0");
        if (arrayList != null) {
            faceDetectorTask.mDelegate.onFacesDetected(arrayList);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            faceDetectorTask.mDelegate.onFaceDetectionError(faceDetectorTask.mFaceDetector);
        }
        faceDetectorTask.mDelegate.onFaceDetectingTaskCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-3  reason: not valid java name */
    public static final void m750execute$lambda3(FaceDetectorTask faceDetectorTask, Throwable th) {
        Intrinsics.checkNotNullParameter(faceDetectorTask, "this$0");
        faceDetectorTask.mDelegate.onFaceDetectionError(faceDetectorTask.mFaceDetector);
        faceDetectorTask.mDelegate.onFaceDetectingTaskCompleted();
    }

    /* access modifiers changed from: private */
    /* renamed from: execute$lambda-4  reason: not valid java name */
    public static final void m751execute$lambda4(FaceDetectorTask faceDetectorTask, String str) {
        Intrinsics.checkNotNullParameter(faceDetectorTask, "this$0");
        faceDetectorTask.mDelegate.onFaceDetectingTaskCompleted();
    }
}
