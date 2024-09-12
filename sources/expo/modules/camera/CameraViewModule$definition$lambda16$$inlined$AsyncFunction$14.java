package expo.modules.camera;

import com.google.android.cameraview.AspectRatio;
import com.google.android.cameraview.Size;
import expo.modules.camera.CameraExceptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.SortedSet;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0003\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u0001\"\u0006\b\u0002\u0010\u0004\u0018\u00012\u0010\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0006H\n¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"<anonymous>", "", "R", "P0", "P1", "it", "", "invoke", "([Ljava/lang/Object;)Ljava/lang/Object;", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$9"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.camera.CameraViewModule$definition$lambda-16$$inlined$AsyncFunction$14  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CameraViewModule$definition$lambda16$$inlined$AsyncFunction$14 extends Lambda implements Function1<Object[], Object> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraViewModule$definition$lambda16$$inlined$AsyncFunction$14(CameraViewModule cameraViewModule) {
        super(1);
        this.this$0 = cameraViewModule;
    }

    public final Object invoke(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "it");
        String str = objArr[0];
        Integer num = objArr[1];
        if (num != null) {
            ExpoCameraView access$findView = this.this$0.findView(num.intValue());
            if (access$findView.getCameraView$expo_camera_release().isCameraOpened()) {
                SortedSet<Size> availablePictureSizes = access$findView.getCameraView$expo_camera_release().getAvailablePictureSizes(AspectRatio.parse(str));
                Intrinsics.checkNotNullExpressionValue(availablePictureSizes, "sizes");
                Iterable<Size> iterable = availablePictureSizes;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (Size size : iterable) {
                    arrayList.add(size.toString());
                }
                return (List) arrayList;
            }
            throw new CameraExceptions.CameraIsNotRunning();
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
    }
}
