package expo.modules.camera;

import expo.modules.camera.CameraExceptions;
import expo.modules.camera.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.kotlin.Promise;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007H\n¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$12"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.camera.CameraViewModule$definition$lambda-16$$inlined$AsyncFunction$6  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CameraViewModule$definition$lambda16$$inlined$AsyncFunction$6 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraViewModule$definition$lambda16$$inlined$AsyncFunction$6(CameraViewModule cameraViewModule) {
        super(1);
        this.this$0 = cameraViewModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        PictureOptions pictureOptions = objArr[0];
        if (pictureOptions != null) {
            PictureOptions pictureOptions2 = pictureOptions;
            Integer num = objArr[1];
            if (num != null) {
                Integer num2 = num;
                Promise promise = objArr[2];
                if (promise != null) {
                    Promise promise2 = promise;
                    ExpoCameraView access$findView = this.this$0.findView(num2.intValue());
                    if (EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                        return new ResolveTakenPictureAsyncTask(CameraViewHelper.INSTANCE.generateSimulatorPhoto(access$findView.getWidth(), access$findView.getHeight()), promise2, pictureOptions2, this.this$0.getCacheDirectory(), access$findView).execute(new Void[0]);
                    }
                    if (access$findView.getCameraView$expo_camera_release().isCameraOpened()) {
                        access$findView.takePicture(pictureOptions2, promise2, this.this$0.getCacheDirectory());
                        return Unit.INSTANCE;
                    }
                    throw new CameraExceptions.CameraIsNotRunning();
                }
                throw new NullPointerException("null cannot be cast to non-null type expo.modules.kotlin.Promise");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type expo.modules.camera.PictureOptions");
    }
}
