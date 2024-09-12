package expo.modules.camera;

import androidx.exifinterface.media.ExifInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunction;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.Queues;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeKt;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import java.io.File;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KTypeProjection;
import kotlinx.coroutines.DebugKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lexpo/modules/camera/CameraViewModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "permissionsManager", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissionsManager", "()Lexpo/modules/interfaces/permissions/Permissions;", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "findView", "Lexpo/modules/camera/ExpoCameraView;", "viewTag", "", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraViewModule.kt */
public final class CameraViewModule extends Module {
    public ModuleDefinitionData definition() {
        AsyncFunction asyncFunction;
        AsyncFunction asyncFunction2;
        AsyncFunction asyncFunction3;
        AsyncFunction asyncFunction4;
        AsyncFunction asyncFunction5;
        AsyncFunction asyncFunction6;
        AsyncFunction asyncFunction7;
        AsyncFunction asyncFunction8;
        AsyncFunction asyncFunction9;
        AsyncFunction asyncFunction10;
        AsyncFunction asyncFunction11;
        AsyncFunction asyncFunction12;
        boolean z;
        AsyncFunction asyncFunction13;
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name("ExponentCamera");
        boolean z2 = true;
        moduleDefinitionBuilder.Constants((Pair<String, ? extends Object>[]) new Pair[]{TuplesKt.to("Type", MapsKt.mapOf(TuplesKt.to("front", 1), TuplesKt.to("back", 0))), TuplesKt.to("FlashMode", MapsKt.mapOf(TuplesKt.to(DebugKt.DEBUG_PROPERTY_VALUE_OFF, 0), TuplesKt.to("on", 1), TuplesKt.to("auto", 3), TuplesKt.to("torch", 2))), TuplesKt.to("AutoFocus", MapsKt.mapOf(TuplesKt.to("on", true), TuplesKt.to(DebugKt.DEBUG_PROPERTY_VALUE_OFF, false))), TuplesKt.to(ExifInterface.TAG_WHITE_BALANCE, MapsKt.mapOf(TuplesKt.to("auto", 0), TuplesKt.to("cloudy", 1), TuplesKt.to("sunny", 2), TuplesKt.to("shadow", 3), TuplesKt.to("fluorescent", 4), TuplesKt.to("incandescent", 5))), TuplesKt.to("VideoQuality", MapsKt.mapOf(TuplesKt.to("2160p", 0), TuplesKt.to("1080p", 1), TuplesKt.to("720p", 2), TuplesKt.to("480p", 3), TuplesKt.to("4:3", 4)))});
        ObjectDefinitionBuilder objectDefinitionBuilder = moduleDefinitionBuilder;
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Integer.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction = new AsyncFunctionWithPromiseComponent("pausePreview", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$1(this));
        } else {
            asyncFunction = new AsyncFunctionComponent("pausePreview", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$2(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("pausePreview", asyncFunction);
        asyncFunction.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Integer.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction2 = new AsyncFunctionWithPromiseComponent("resumePreview", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$3(this));
        } else {
            asyncFunction2 = new AsyncFunctionComponent("resumePreview", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$4(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("resumePreview", asyncFunction2);
        asyncFunction2.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction3 = new AsyncFunctionWithPromiseComponent("takePicture", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(PictureOptions.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$5(this));
        } else {
            asyncFunction3 = new AsyncFunctionComponent("takePicture", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(PictureOptions.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$6(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("takePicture", asyncFunction3);
        asyncFunction3.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction4 = new AsyncFunctionWithPromiseComponent("record", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(RecordingOptions.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$7(this));
        } else {
            asyncFunction4 = new AsyncFunctionComponent("record", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(RecordingOptions.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$8(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("record", asyncFunction4);
        asyncFunction4.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Integer.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction5 = new AsyncFunctionWithPromiseComponent("stopRecording", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$9(this));
        } else {
            asyncFunction5 = new AsyncFunctionComponent("stopRecording", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$10(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("stopRecording", asyncFunction5);
        asyncFunction5.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Integer.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction6 = new AsyncFunctionWithPromiseComponent("getSupportedRatios", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$11(this));
        } else {
            asyncFunction6 = new AsyncFunctionComponent("getSupportedRatios", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$12(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("getSupportedRatios", asyncFunction6);
        asyncFunction6.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Integer.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction7 = new AsyncFunctionWithPromiseComponent("getAvailablePictureSizes", new AnyType[]{AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$13(this));
        } else {
            asyncFunction7 = new AsyncFunctionComponent("getAvailablePictureSizes", new AnyType[]{AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$14(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("getAvailablePictureSizes", asyncFunction7);
        asyncFunction7.runOnQueue(Queues.MAIN);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction8 = new AsyncFunctionWithPromiseComponent("requestPermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$15(this));
        } else {
            asyncFunction8 = new AsyncFunctionComponent("requestPermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$16(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("requestPermissionsAsync", asyncFunction8);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction9 = new AsyncFunctionWithPromiseComponent("requestCameraPermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$17(this));
        } else {
            asyncFunction9 = new AsyncFunctionComponent("requestCameraPermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$18(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("requestCameraPermissionsAsync", asyncFunction9);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction10 = new AsyncFunctionWithPromiseComponent("requestMicrophonePermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$19(this));
        } else {
            asyncFunction10 = new AsyncFunctionComponent("requestMicrophonePermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$20(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("requestMicrophonePermissionsAsync", asyncFunction10);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction11 = new AsyncFunctionWithPromiseComponent("getPermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$21(this));
        } else {
            asyncFunction11 = new AsyncFunctionComponent("getPermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$22(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("getPermissionsAsync", asyncFunction11);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction12 = new AsyncFunctionWithPromiseComponent("getCameraPermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$23(this));
        } else {
            asyncFunction12 = new AsyncFunctionComponent("getCameraPermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$24(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("getCameraPermissionsAsync", asyncFunction12);
        if (Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(Promise.class), (Object) Reflection.getOrCreateKotlinClass(Promise.class))) {
            asyncFunction13 = new AsyncFunctionWithPromiseComponent("getMicrophonePermissionsAsync", new AnyType[0], new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$25(this));
            z = false;
        } else {
            z = false;
            asyncFunction13 = new AsyncFunctionComponent("getMicrophonePermissionsAsync", new AnyType[]{AnyTypeKt.toAnyType(Reflection.typeOf(Promise.class))}, new CameraViewModule$definition$lambda16$$inlined$AsyncFunction$26(this));
        }
        objectDefinitionBuilder.getAsyncFunctions().put("getMicrophonePermissionsAsync", asyncFunction13);
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ExpoCameraView.class);
        if (moduleDefinitionBuilder.getViewManagerDefinition() != null) {
            z2 = z;
        }
        if (z2) {
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(orCreateKotlinClass);
            viewDefinitionBuilder.Events("onCameraReady", "onMountError", "onBarCodeScanned", "onFacesDetected", "onFaceDetectionError", "onPictureSaved");
            viewDefinitionBuilder.setOnViewDestroys(new CameraViewModule$definition$lambda16$lambda15$$inlined$OnViewDestroysGeneric$1(new CameraViewModule$definition$1$14$1(this)));
            viewDefinitionBuilder.getProps().put("type", new ConcreteViewProp("type", AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), CameraViewModule$definition$1$14$2.INSTANCE));
            viewDefinitionBuilder.getProps().put("ratio", new ConcreteViewProp("ratio", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), CameraViewModule$definition$1$14$3.INSTANCE));
            viewDefinitionBuilder.getProps().put("flashMode", new ConcreteViewProp("flashMode", AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), CameraViewModule$definition$1$14$4.INSTANCE));
            viewDefinitionBuilder.getProps().put("autoFocus", new ConcreteViewProp("autoFocus", AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), CameraViewModule$definition$1$14$5.INSTANCE));
            viewDefinitionBuilder.getProps().put("focusDepth", new ConcreteViewProp("focusDepth", AnyTypeKt.toAnyType(Reflection.typeOf(Float.TYPE)), CameraViewModule$definition$1$14$6.INSTANCE));
            viewDefinitionBuilder.getProps().put("zoom", new ConcreteViewProp("zoom", AnyTypeKt.toAnyType(Reflection.typeOf(Float.TYPE)), CameraViewModule$definition$1$14$7.INSTANCE));
            viewDefinitionBuilder.getProps().put("whiteBalance", new ConcreteViewProp("whiteBalance", AnyTypeKt.toAnyType(Reflection.typeOf(Integer.TYPE)), CameraViewModule$definition$1$14$8.INSTANCE));
            viewDefinitionBuilder.getProps().put("pictureSize", new ConcreteViewProp("pictureSize", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(String.class)), CameraViewModule$definition$1$14$9.INSTANCE));
            viewDefinitionBuilder.getProps().put("barCodeScannerSettings", new ConcreteViewProp("barCodeScannerSettings", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.nullableTypeOf(Object.class)))), CameraViewModule$definition$1$14$10.INSTANCE));
            viewDefinitionBuilder.getProps().put("useCamera2Api", new ConcreteViewProp("useCamera2Api", AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), CameraViewModule$definition$1$14$11.INSTANCE));
            viewDefinitionBuilder.getProps().put("barCodeScannerEnabled", new ConcreteViewProp("barCodeScannerEnabled", AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), CameraViewModule$definition$1$14$12.INSTANCE));
            viewDefinitionBuilder.getProps().put("faceDetectorEnabled", new ConcreteViewProp("faceDetectorEnabled", AnyTypeKt.toAnyType(Reflection.typeOf(Boolean.TYPE)), CameraViewModule$definition$1$14$13.INSTANCE));
            viewDefinitionBuilder.getProps().put("faceDetectorSettings", new ConcreteViewProp("faceDetectorSettings", AnyTypeKt.toAnyType(Reflection.nullableTypeOf(Map.class, KTypeProjection.Companion.invariant(Reflection.typeOf(String.class)), KTypeProjection.Companion.invariant(Reflection.typeOf(Object.class)))), CameraViewModule$definition$1$14$14.INSTANCE));
            moduleDefinitionBuilder.setViewManagerDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }

    /* access modifiers changed from: private */
    public final File getCacheDirectory() {
        return getAppContext().getCacheDirectory();
    }

    /* access modifiers changed from: private */
    public final Permissions getPermissionsManager() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions != null) {
            return permissions;
        }
        throw new Exceptions.PermissionsModuleNotFound();
    }

    /* access modifiers changed from: private */
    public final ExpoCameraView findView(int i) {
        ExpoCameraView expoCameraView = (ExpoCameraView) getAppContext().findView(i);
        if (expoCameraView != null) {
            return expoCameraView;
        }
        throw new Exceptions.ViewNotFound(Reflection.getOrCreateKotlinClass(ExpoCameraView.class), i);
    }
}
