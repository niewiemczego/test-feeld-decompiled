package expo.modules.camera;

import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import expo.modules.camera.CameraExceptions;
import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\n¢\u0006\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "args", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$8"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.camera.CameraViewModule$definition$lambda-16$$inlined$AsyncFunction$13  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CameraViewModule$definition$lambda16$$inlined$AsyncFunction$13 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraViewModule$definition$lambda16$$inlined$AsyncFunction$13(CameraViewModule cameraViewModule) {
        super(2);
        this.this$0 = cameraViewModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        String str = objArr[0];
        ExpoCameraView access$findView = this.this$0.findView(((Integer) promise).intValue());
        if (access$findView.getCameraView$expo_camera_release().isCameraOpened()) {
            SortedSet<Size> availablePictureSizes = access$findView.getCameraView$expo_camera_release().getAvailablePictureSizes(AspectRatio.parse(str));
            Intrinsics.checkNotNullExpressionValue(availablePictureSizes, "sizes");
            Iterable<Size> iterable = availablePictureSizes;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (Size size : iterable) {
                arrayList.add(size.toString());
            }
            List list = (List) arrayList;
            return;
        }
        throw new CameraExceptions.CameraIsNotRunning();
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Object[]) obj, (Promise) obj2);
        return Unit.INSTANCE;
    }
}
