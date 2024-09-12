package expo.modules.camera;

import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.cameraview.AspectRatio;
import expo.modules.camera.CameraExceptions;
import expo.modules.kotlin.Promise;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001\"\u0006\b\u0001\u0010\u0003\u0018\u00012\u0010\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\n¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"<anonymous>", "", "R", "P0", "<anonymous parameter 0>", "", "", "promise", "Lexpo/modules/kotlin/Promise;", "invoke", "([Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "expo/modules/kotlin/objects/ObjectDefinitionBuilder$AsyncFunction$5"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* renamed from: expo.modules.camera.CameraViewModule$definition$lambda-16$$inlined$AsyncFunction$11  reason: invalid class name */
/* compiled from: ObjectDefinitionBuilder.kt */
public final class CameraViewModule$definition$lambda16$$inlined$AsyncFunction$11 extends Lambda implements Function2<Object[], Promise, Unit> {
    final /* synthetic */ CameraViewModule this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CameraViewModule$definition$lambda16$$inlined$AsyncFunction$11(CameraViewModule cameraViewModule) {
        super(2);
        this.this$0 = cameraViewModule;
    }

    public final void invoke(Object[] objArr, Promise promise) {
        Intrinsics.checkNotNullParameter(objArr, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        ExpoCameraView access$findView = this.this$0.findView(((Integer) promise).intValue());
        if (access$findView.getCameraView$expo_camera_release().isCameraOpened()) {
            Set<AspectRatio> supportedAspectRatios = access$findView.getCameraView$expo_camera_release().getSupportedAspectRatios();
            Intrinsics.checkNotNullExpressionValue(supportedAspectRatios, "view.cameraView.supportedAspectRatios");
            Iterable<AspectRatio> iterable = supportedAspectRatios;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (AspectRatio aspectRatio : iterable) {
                arrayList.add(aspectRatio.toString());
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
