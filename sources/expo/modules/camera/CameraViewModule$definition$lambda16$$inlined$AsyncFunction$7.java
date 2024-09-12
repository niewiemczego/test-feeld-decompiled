package expo.modules.camera;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.camera.CameraExceptions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u0001\"\u0006\b\u0003\u0010\u0005\u0018\u00012\u0010\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\n¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "P2", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$11"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.camera.CameraViewModule$definition$lambda-16$$inlined$AsyncFunction$7  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CameraViewModule$definition$lambda16$$inlined$AsyncFunction$7 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraViewModule$definition$lambda16$$inlined$AsyncFunction$7(CameraViewModule cameraViewModule) {
        super(2);
        this.this$0 = cameraViewModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        RecordingOptions recordingOptions = objArr[0];
        if (recordingOptions != null) {
            RecordingOptions recordingOptions2 = recordingOptions;
            Integer num = objArr[1];
            if (num != null) {
                int intValue = num.intValue();
                if (this.this$0.getPermissionsManager().hasGrantedPermissions("android.permission.RECORD_AUDIO")) {
                    ExpoCameraView access$findView = this.this$0.findView(intValue);
                    if (access$findView.getCameraView$expo_camera_release().isCameraOpened()) {
                        access$findView.record(recordingOptions2, promise, this.this$0.getCacheDirectory());
                        return;
                    }
                    throw new CameraExceptions.CameraIsNotRunning();
                }
                throw new Exceptions.MissingPermissions("android.permission.RECORD_AUDIO");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
        throw new NullPointerException("null cannot be cast to non-null type expo.modules.camera.RecordingOptions");
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
