package expo.modules.camera;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.CamcorderProfile;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.react.bridge.BaseJavaModule;
import com.google.android.cameraview.CameraView;
import expo.modules.camera.tasks.BarCodeScannerAsyncTask;
import expo.modules.camera.tasks.BarCodeScannerAsyncTaskDelegate;
import expo.modules.camera.tasks.FaceDetectorAsyncTaskDelegate;
import expo.modules.camera.tasks.FaceDetectorTask;
import expo.modules.camera.tasks.PictureSavedDelegate;
import expo.modules.camera.tasks.ResolveTakenPictureAsyncTask;
import expo.modules.camera.utils.FileSystemUtils;
import expo.modules.camera.utils.ImageDimensions;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerProviderInterface;
import expo.modules.interfaces.barcodescanner.BarCodeScannerResult;
import expo.modules.interfaces.barcodescanner.BarCodeScannerSettings;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.facedetector.FaceDetectorInterface;
import expo.modules.interfaces.facedetector.FaceDetectorProviderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ExpoView;
import io.sentry.protocol.Response;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.internal.ProgressionUtilKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ0\u0010I\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020L0K\u0012\u0004\u0012\u00020L0J2\f\u0010M\u001a\b\u0012\u0004\u0012\u00020O0N2\u0006\u0010P\u001a\u00020QH\u0002J\b\u0010R\u001a\u00020OH\u0002J\b\u0010S\u001a\u00020TH\u0016J\b\u0010U\u001a\u00020\u000fH\u0002J\b\u0010V\u001a\u00020(H\u0002J\u0010\u0010 \u001a\u00020(2\u0006\u0010W\u001a\u00020XH\u0016J\b\u0010Y\u001a\u00020(H\u0016J\b\u0010Z\u001a\u00020(H\u0016J\u0010\u0010+\u001a\u00020(2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0016\u0010/\u001a\u00020(2\f\u0010[\u001a\b\u0012\u0004\u0012\u00020L0NH\u0016J\b\u0010\\\u001a\u00020(H\u0016J\b\u0010]\u001a\u00020(H\u0016J\b\u0010^\u001a\u00020(H\u0016J0\u0010_\u001a\u00020(2\u0006\u0010`\u001a\u00020\u000f2\u0006\u0010a\u001a\u00020O2\u0006\u0010b\u001a\u00020O2\u0006\u0010c\u001a\u00020O2\u0006\u0010d\u001a\u00020OH\u0014J\u0010\u00107\u001a\u00020(2\u0006\u0010e\u001a\u00020LH\u0016J\u0010\u0010f\u001a\u00020(2\u0006\u0010g\u001a\u00020hH\u0016J\u001e\u0010i\u001a\u00020(2\u0006\u0010j\u001a\u00020k2\u0006\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020BJ\u000e\u0010n\u001a\u00020(2\u0006\u0010o\u001a\u00020pJ\u001c\u0010q\u001a\u00020(2\u0014\u0010o\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<J\u0012\u0010r\u001a\u00020(2\b\u0010s\u001a\u0004\u0018\u00010tH\u0016J\u000e\u0010u\u001a\u00020(2\u0006\u0010G\u001a\u00020\u000fJ\u000e\u0010v\u001a\u00020(2\u0006\u0010w\u001a\u00020\u000fJ\u001e\u0010x\u001a\u00020(2\u0006\u0010j\u001a\u00020D2\u0006\u0010l\u001a\u00020A2\u0006\u0010m\u001a\u00020BJ\u0010\u0010y\u001a\u00020(2\u0006\u0010W\u001a\u00020XH\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u000e\u0010\u001d\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R!\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8BX\u0002¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b#\u0010$R!\u0010'\u001a\b\u0012\u0004\u0012\u00020(0!8BX\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b)\u0010$R!\u0010+\u001a\b\u0012\u0004\u0012\u00020,0!8BX\u0002¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b-\u0010$R!\u0010/\u001a\b\u0012\u0004\u0012\u0002000!8BX\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b1\u0010$R!\u00103\u001a\b\u0012\u0004\u0012\u0002040!8BX\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b5\u0010$R!\u00107\u001a\b\u0012\u0004\u0012\u0002080!8BX\u0002¢\u0006\f\n\u0004\b:\u0010&\u001a\u0004\b9\u0010$R\u001c\u0010;\u001a\u0010\u0012\u0004\u0012\u00020=\u0012\u0004\u0012\u00020>\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020B0@X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020A\u0012\u0004\u0012\u00020D0@X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\b\u0012\u0004\u0012\u00020A0FX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010AX\u000e¢\u0006\u0002\n\u0000¨\u0006z"}, d2 = {"Lexpo/modules/camera/ExpoCameraView;", "Lexpo/modules/kotlin/views/ExpoView;", "Lexpo/modules/core/interfaces/LifecycleEventListener;", "Lexpo/modules/camera/tasks/BarCodeScannerAsyncTaskDelegate;", "Lexpo/modules/camera/tasks/FaceDetectorAsyncTaskDelegate;", "Lexpo/modules/camera/tasks/PictureSavedDelegate;", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "barCodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "barCodeScannerTaskLock", "", "getBarCodeScannerTaskLock", "()Z", "setBarCodeScannerTaskLock", "(Z)V", "cameraView", "Lcom/google/android/cameraview/CameraView;", "getCameraView$expo_camera_release", "()Lcom/google/android/cameraview/CameraView;", "faceDetector", "Lexpo/modules/interfaces/facedetector/FaceDetectorInterface;", "faceDetectorTaskLock", "getFaceDetectorTaskLock", "setFaceDetectorTaskLock", "isNew", "isPaused", "mShouldScanBarCodes", "onBarCodeScanned", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/camera/BarCodeScannedEvent;", "getOnBarCodeScanned", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onBarCodeScanned$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "onCameraReady", "", "getOnCameraReady", "onCameraReady$delegate", "onFaceDetectionError", "Lexpo/modules/camera/FaceDetectionErrorEvent;", "getOnFaceDetectionError", "onFaceDetectionError$delegate", "onFacesDetected", "Lexpo/modules/camera/FacesDetectedEvent;", "getOnFacesDetected", "onFacesDetected$delegate", "onMountError", "Lexpo/modules/camera/CameraMountErrorEvent;", "getOnMountError", "onMountError$delegate", "onPictureSaved", "Lexpo/modules/camera/PictureSavedEvent;", "getOnPictureSaved", "onPictureSaved$delegate", "pendingFaceDetectorSettings", "", "", "", "pictureTakenDirectories", "", "Lexpo/modules/kotlin/Promise;", "Ljava/io/File;", "pictureTakenOptions", "Lexpo/modules/camera/PictureOptions;", "pictureTakenPromises", "Ljava/util/Queue;", "shouldDetectFaces", "videoRecordedPromise", "getCornerPointsAndBoundingBox", "Lkotlin/Pair;", "Ljava/util/ArrayList;", "Landroid/os/Bundle;", "cornerPoints", "", "", "boundingBox", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult$BoundingBox;", "getDeviceOrientation", "getPreviewSizeAsArray", "", "hasCameraPermissions", "initBarCodeScanner", "barCode", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerResult;", "onBarCodeScanningTaskCompleted", "onFaceDetectingTaskCompleted", "faces", "onHostDestroy", "onHostPause", "onHostResume", "onLayout", "changed", "left", "top", "right", "bottom", "response", "onViewAdded", "child", "Landroid/view/View;", "record", "options", "Lexpo/modules/camera/RecordingOptions;", "promise", "cacheDirectory", "setBarCodeScannerSettings", "settings", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerSettings;", "setFaceDetectorSettings", "setPreviewTexture", "surfaceTexture", "Landroid/graphics/SurfaceTexture;", "setShouldDetectFaces", "setShouldScanBarCodes", "shouldScanBarCodes", "takePicture", "transformBarCodeScannerResultToViewCoordinates", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExpoCameraView.kt */
public final class ExpoCameraView extends ExpoView implements LifecycleEventListener, BarCodeScannerAsyncTaskDelegate, FaceDetectorAsyncTaskDelegate, PictureSavedDelegate, CameraViewInterface {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
    /* access modifiers changed from: private */
    public BarCodeScannerInterface barCodeScanner;
    private volatile boolean barCodeScannerTaskLock;
    private final CameraView cameraView;
    /* access modifiers changed from: private */
    public FaceDetectorInterface faceDetector;
    private volatile boolean faceDetectorTaskLock;
    private boolean isNew = true;
    private boolean isPaused;
    /* access modifiers changed from: private */
    public boolean mShouldScanBarCodes;
    private final ViewEventDelegate onBarCodeScanned$delegate;
    private final ViewEventDelegate onCameraReady$delegate;
    private final ViewEventDelegate onFaceDetectionError$delegate;
    private final ViewEventDelegate onFacesDetected$delegate;
    private final ViewEventDelegate onMountError$delegate;
    private final ViewEventDelegate onPictureSaved$delegate;
    private Map<String, ? extends Object> pendingFaceDetectorSettings;
    /* access modifiers changed from: private */
    public final Map<Promise, File> pictureTakenDirectories = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Map<Promise, PictureOptions> pictureTakenOptions = new ConcurrentHashMap();
    /* access modifiers changed from: private */
    public final Queue<Promise> pictureTakenPromises = new ConcurrentLinkedQueue();
    /* access modifiers changed from: private */
    public boolean shouldDetectFaces;
    /* access modifiers changed from: private */
    public Promise videoRecordedPromise;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ExpoCameraView(Context context, AppContext appContext) {
        super(context, appContext);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.cameraView = new CameraView(context, true);
        View view = this;
        Object obj = null;
        this.onCameraReady$delegate = new ViewEventDelegate(Reflection.typeOf(Unit.class), view, (Function1) null);
        this.onMountError$delegate = new ViewEventDelegate(Reflection.typeOf(CameraMountErrorEvent.class), view, (Function1) null);
        this.onBarCodeScanned$delegate = new ViewEventDelegate(Reflection.typeOf(BarCodeScannedEvent.class), view, ExpoCameraView$onBarCodeScanned$2.INSTANCE);
        this.onFacesDetected$delegate = new ViewEventDelegate(Reflection.typeOf(FacesDetectedEvent.class), view, ExpoCameraView$onFacesDetected$2.INSTANCE);
        this.onFaceDetectionError$delegate = new ViewEventDelegate(Reflection.typeOf(FaceDetectionErrorEvent.class), view, (Function1) null);
        this.onPictureSaved$delegate = new ViewEventDelegate(Reflection.typeOf(PictureSavedEvent.class), view, ExpoCameraView$onPictureSaved$2.INSTANCE);
        initBarCodeScanner();
        setChildrenDrawingOrderEnabled(true);
        try {
            obj = appContext.getLegacyModuleRegistry().getModule(UIManager.class);
        } catch (Exception unused) {
        }
        UIManager uIManager = (UIManager) obj;
        Intrinsics.checkNotNull(uIManager);
        uIManager.registerLifecycleEventListener(this);
        this.cameraView.addCallback(new CameraView.Callback(this) {
            final /* synthetic */ ExpoCameraView this$0;

            {
                this.this$0 = r1;
            }

            public void onCameraOpened(CameraView cameraView) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                this.this$0.getOnCameraReady().invoke(Unit.INSTANCE);
            }

            public void onMountError(CameraView cameraView) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                this.this$0.getOnMountError().invoke(new CameraMountErrorEvent("Camera component could not be rendered - is there any other instance running?"));
            }

            public void onPictureTaken(CameraView cameraView, byte[] bArr) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(bArr, "data");
                Promise promise = (Promise) this.this$0.pictureTakenPromises.poll();
                if (promise != null) {
                    File file = (File) this.this$0.pictureTakenDirectories.remove(promise);
                    Object remove = this.this$0.pictureTakenOptions.remove(promise);
                    Intrinsics.checkNotNull(remove);
                    PictureOptions pictureOptions = (PictureOptions) remove;
                    if (pictureOptions.getFastMode()) {
                        promise.resolve((Object) null);
                    }
                    if (file != null) {
                        new ResolveTakenPictureAsyncTask(bArr, promise, pictureOptions, file, this.this$0).execute(new Void[0]);
                    }
                }
            }

            public void onVideoRecorded(CameraView cameraView, String str) {
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(str, ReactNativeBlobUtilConst.RNFB_RESPONSE_PATH);
                Promise access$getVideoRecordedPromise$p = this.this$0.videoRecordedPromise;
                if (access$getVideoRecordedPromise$p != null) {
                    ExpoCameraView expoCameraView = this.this$0;
                    Bundle bundle = new Bundle();
                    bundle.putString("uri", Uri.fromFile(new File(str)).toString());
                    access$getVideoRecordedPromise$p.resolve(bundle);
                    expoCameraView.videoRecordedPromise = null;
                }
            }

            public void onFramePreview(CameraView cameraView, byte[] bArr, int i, int i2, int i3) {
                FaceDetectorTask faceDetectorTask;
                Intrinsics.checkNotNullParameter(cameraView, "cameraView");
                Intrinsics.checkNotNullParameter(bArr, "data");
                int correctCameraRotation = CameraViewHelper.getCorrectCameraRotation(i3, cameraView.getFacing());
                if (this.this$0.mShouldScanBarCodes && !this.this$0.getBarCodeScannerTaskLock()) {
                    this.this$0.setBarCodeScannerTaskLock(true);
                    BarCodeScannerInterface access$getBarCodeScanner$p = this.this$0.barCodeScanner;
                    if (access$getBarCodeScanner$p != null) {
                        new BarCodeScannerAsyncTask(this.this$0, access$getBarCodeScanner$p, bArr, i, i2, i3).execute(new Void[0]);
                    }
                }
                if (this.this$0.shouldDetectFaces && !this.this$0.getFaceDetectorTaskLock()) {
                    this.this$0.setFaceDetectorTaskLock(true);
                    float f = cameraView.getResources().getDisplayMetrics().density;
                    ImageDimensions imageDimensions = new ImageDimensions(i, i2, correctCameraRotation, cameraView.getFacing());
                    double width = ((double) cameraView.getWidth()) / ((double) (((float) imageDimensions.getWidth()) * f));
                    double height = ((double) cameraView.getHeight()) / ((double) (((float) imageDimensions.getHeight()) * f));
                    FaceDetectorInterface access$getFaceDetector$p = this.this$0.faceDetector;
                    if (access$getFaceDetector$p != null) {
                        faceDetectorTask = new FaceDetectorTask(this.this$0, access$getFaceDetector$p, bArr, i, i2, correctCameraRotation, cameraView.getFacing() == 1, width, height);
                    } else {
                        faceDetectorTask = null;
                    }
                    if (faceDetectorTask != null) {
                        faceDetectorTask.execute();
                    }
                }
            }
        });
        addView(this.cameraView);
    }

    public final CameraView getCameraView$expo_camera_release() {
        return this.cameraView;
    }

    static {
        Class<ExpoCameraView> cls = ExpoCameraView.class;
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(cls, "onCameraReady", "getOnCameraReady()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onMountError", "getOnMountError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onBarCodeScanned", "getOnBarCodeScanned()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onFacesDetected", "getOnFacesDetected()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onFaceDetectionError", "getOnFaceDetectionError()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0)), Reflection.property1(new PropertyReference1Impl(cls, "onPictureSaved", "getOnPictureSaved()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    }

    /* access modifiers changed from: private */
    public final ViewEventCallback<Unit> getOnCameraReady() {
        return this.onCameraReady$delegate.getValue(this, $$delegatedProperties[0]);
    }

    /* access modifiers changed from: private */
    public final ViewEventCallback<CameraMountErrorEvent> getOnMountError() {
        return this.onMountError$delegate.getValue(this, $$delegatedProperties[1]);
    }

    private final ViewEventCallback<BarCodeScannedEvent> getOnBarCodeScanned() {
        return this.onBarCodeScanned$delegate.getValue(this, $$delegatedProperties[2]);
    }

    private final ViewEventCallback<FacesDetectedEvent> getOnFacesDetected() {
        return this.onFacesDetected$delegate.getValue(this, $$delegatedProperties[3]);
    }

    private final ViewEventCallback<FaceDetectionErrorEvent> getOnFaceDetectionError() {
        return this.onFaceDetectionError$delegate.getValue(this, $$delegatedProperties[4]);
    }

    private final ViewEventCallback<PictureSavedEvent> getOnPictureSaved() {
        return this.onPictureSaved$delegate.getValue(this, $$delegatedProperties[5]);
    }

    public final boolean getBarCodeScannerTaskLock() {
        return this.barCodeScannerTaskLock;
    }

    public final void setBarCodeScannerTaskLock(boolean z) {
        this.barCodeScannerTaskLock = z;
    }

    public final boolean getFaceDetectorTaskLock() {
        return this.faceDetectorTaskLock;
    }

    public final void setFaceDetectorTaskLock(boolean z) {
        this.faceDetectorTaskLock = z;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        this.cameraView.layout(0, 0, i5, i6);
        this.cameraView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        View view = this.cameraView.getView();
        if (view != null) {
            view.layout(0, 0, i5, i6);
        }
    }

    public void onViewAdded(View view) {
        Intrinsics.checkNotNullParameter(view, "child");
        if (this.cameraView != view) {
            List<View> arrayList = new ArrayList<>();
            int i = 0;
            int childCount = getChildCount();
            while (i < childCount) {
                View childAt = getChildAt(i);
                if (i != 0 || childAt != this.cameraView) {
                    if (childAt != this.cameraView) {
                        Intrinsics.checkNotNullExpressionValue(childAt, "childView");
                        arrayList.add(childAt);
                    }
                    i++;
                } else {
                    return;
                }
            }
            for (View bringChildToFront : arrayList) {
                bringChildToFront(bringChildToFront);
            }
            this.cameraView.requestLayout();
            this.cameraView.invalidate();
        }
    }

    public final void takePicture(PictureOptions pictureOptions, Promise promise, File file) {
        Intrinsics.checkNotNullParameter(pictureOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(file, "cacheDirectory");
        this.pictureTakenPromises.add(promise);
        this.pictureTakenOptions.put(promise, pictureOptions);
        this.pictureTakenDirectories.put(promise, file);
        try {
            this.cameraView.takePicture();
        } catch (Exception e) {
            this.pictureTakenPromises.remove(promise);
            this.pictureTakenOptions.remove(promise);
            this.pictureTakenDirectories.remove(promise);
            throw e;
        }
    }

    public void onPictureSaved(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, Response.TYPE);
        ViewEventCallback<PictureSavedEvent> onPictureSaved = getOnPictureSaved();
        int i = bundle.getInt("id");
        Bundle bundle2 = bundle.getBundle("data");
        Intrinsics.checkNotNull(bundle2);
        onPictureSaved.invoke(new PictureSavedEvent(i, bundle2));
    }

    public final void record(RecordingOptions recordingOptions, Promise promise, File file) {
        Intrinsics.checkNotNullParameter(recordingOptions, SDKConstants.PARAM_GAME_REQUESTS_OPTIONS);
        Intrinsics.checkNotNullParameter(promise, BaseJavaModule.METHOD_TYPE_PROMISE);
        Intrinsics.checkNotNullParameter(file, "cacheDirectory");
        try {
            String generateOutputPath = FileSystemUtils.INSTANCE.generateOutputPath(file, "Camera", ".mp4");
            CamcorderProfile camcorderProfile = CameraViewHelper.getCamcorderProfile(this.cameraView.getCameraId(), recordingOptions.getQuality());
            Integer videoBitrate = recordingOptions.getVideoBitrate();
            if (videoBitrate != null) {
                camcorderProfile.videoBitRate = videoBitrate.intValue();
            }
            if (this.cameraView.record(generateOutputPath, recordingOptions.getMaxDuration() * 1000, recordingOptions.getMaxFileSize(), !recordingOptions.getMuteValue(), camcorderProfile)) {
                this.videoRecordedPromise = promise;
            } else {
                promise.reject("E_RECORDING_FAILED", "Starting video recording failed. Another recording might be in progress.", (Throwable) null);
            }
        } catch (IOException unused) {
            promise.reject("E_RECORDING_FAILED", "Starting video recording failed - could not create video file.", (Throwable) null);
        }
    }

    private final void initBarCodeScanner() {
        Object obj;
        BarCodeScannerInterface barCodeScannerInterface = null;
        try {
            obj = getAppContext().getLegacyModuleRegistry().getModule(BarCodeScannerProviderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        BarCodeScannerProviderInterface barCodeScannerProviderInterface = (BarCodeScannerProviderInterface) obj;
        if (barCodeScannerProviderInterface != null) {
            barCodeScannerInterface = barCodeScannerProviderInterface.createBarCodeDetectorWithContext(getContext());
        }
        this.barCodeScanner = barCodeScannerInterface;
    }

    public final void setShouldScanBarCodes(boolean z) {
        this.mShouldScanBarCodes = z;
        this.cameraView.setScanning(z || this.shouldDetectFaces);
    }

    public final void setBarCodeScannerSettings(BarCodeScannerSettings barCodeScannerSettings) {
        Intrinsics.checkNotNullParameter(barCodeScannerSettings, "settings");
        BarCodeScannerInterface barCodeScannerInterface = this.barCodeScanner;
        if (barCodeScannerInterface != null) {
            barCodeScannerInterface.setSettings(barCodeScannerSettings);
        }
    }

    private final int getDeviceOrientation() {
        Object systemService = getContext().getSystemService("window");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
        return ((WindowManager) systemService).getDefaultDisplay().getRotation();
    }

    private final void transformBarCodeScannerResultToViewCoordinates(BarCodeScannerResult barCodeScannerResult) {
        List<Integer> cornerPoints = barCodeScannerResult.getCornerPoints();
        int referenceImageHeight = barCodeScannerResult.getReferenceImageHeight();
        int referenceImageWidth = barCodeScannerResult.getReferenceImageWidth();
        boolean z = this.cameraView.getFacing() == 0;
        boolean z2 = this.cameraView.getFacing() == 1;
        boolean z3 = getDeviceOrientation() % 2 == 0;
        boolean z4 = getDeviceOrientation() % 2 == 1;
        if (z && z3) {
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
            IntProgression step = RangesKt.step((IntProgression) RangesKt.until(1, cornerPoints.size()), 2);
            int first = step.getFirst();
            int last = step.getLast();
            int step2 = step.getStep();
            if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
                while (true) {
                    Integer num = cornerPoints.get(first);
                    Intrinsics.checkNotNullExpressionValue(num, "cornerPoints[it]");
                    cornerPoints.set(first, Integer.valueOf(referenceImageHeight - num.intValue()));
                    if (first == last) {
                        break;
                    }
                    first += step2;
                }
            }
        }
        if (z && z4) {
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
            IntProgression step3 = RangesKt.step((IntProgression) RangesKt.until(0, cornerPoints.size()), 2);
            int first2 = step3.getFirst();
            int last2 = step3.getLast();
            int step4 = step3.getStep();
            if ((step4 > 0 && first2 <= last2) || (step4 < 0 && last2 <= first2)) {
                while (true) {
                    Integer num2 = cornerPoints.get(first2);
                    Intrinsics.checkNotNullExpressionValue(num2, "cornerPoints[it]");
                    cornerPoints.set(first2, Integer.valueOf(referenceImageWidth - num2.intValue()));
                    if (first2 == last2) {
                        break;
                    }
                    first2 += step4;
                }
            }
        }
        if (z2) {
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
            IntProgression step5 = RangesKt.step((IntProgression) RangesKt.until(1, cornerPoints.size()), 2);
            int first3 = step5.getFirst();
            int last3 = step5.getLast();
            int step6 = step5.getStep();
            if ((step6 > 0 && first3 <= last3) || (step6 < 0 && last3 <= first3)) {
                while (true) {
                    Integer num3 = cornerPoints.get(first3);
                    Intrinsics.checkNotNullExpressionValue(num3, "cornerPoints[it]");
                    cornerPoints.set(first3, Integer.valueOf(referenceImageHeight - num3.intValue()));
                    if (first3 == last3) {
                        break;
                    }
                    first3 += step6;
                }
            }
            IntProgression step7 = RangesKt.step((IntProgression) RangesKt.until(0, cornerPoints.size()), 2);
            int first4 = step7.getFirst();
            int last4 = step7.getLast();
            int step8 = step7.getStep();
            if ((step8 > 0 && first4 <= last4) || (step8 < 0 && last4 <= first4)) {
                while (true) {
                    Integer num4 = cornerPoints.get(first4);
                    Intrinsics.checkNotNullExpressionValue(num4, "cornerPoints[it]");
                    cornerPoints.set(first4, Integer.valueOf(referenceImageWidth - num4.intValue()));
                    if (first4 == last4) {
                        break;
                    }
                    first4 += step8;
                }
            }
        }
        double width = ((double) getWidth()) / ((double) referenceImageHeight);
        double height = ((double) getHeight()) / ((double) referenceImageWidth);
        Intrinsics.checkNotNullExpressionValue(cornerPoints, "cornerPoints");
        IntProgression step9 = RangesKt.step((IntProgression) RangesKt.until(1, cornerPoints.size()), 2);
        int first5 = step9.getFirst();
        int last5 = step9.getLast();
        int step10 = step9.getStep();
        if ((step10 > 0 && first5 <= last5) || (step10 < 0 && last5 <= first5)) {
            while (true) {
                cornerPoints.set(first5, Integer.valueOf(MathKt.roundToInt(cornerPoints.get(first5).doubleValue() * width)));
                if (first5 == last5) {
                    break;
                }
                first5 += step10;
            }
        }
        IntProgression step11 = RangesKt.step((IntProgression) RangesKt.until(0, cornerPoints.size()), 2);
        int first6 = step11.getFirst();
        int last6 = step11.getLast();
        int step12 = step11.getStep();
        if ((step12 > 0 && first6 <= last6) || (step12 < 0 && last6 <= first6)) {
            while (true) {
                cornerPoints.set(first6, Integer.valueOf(MathKt.roundToInt(cornerPoints.get(first6).doubleValue() * height)));
                if (first6 == last6) {
                    break;
                }
                first6 += step12;
            }
        }
        barCodeScannerResult.setCornerPoints(cornerPoints);
    }

    private final Pair<ArrayList<Bundle>, Bundle> getCornerPointsAndBoundingBox(List<Integer> list, BarCodeScannerResult.BoundingBox boundingBox) {
        float f = this.cameraView.getResources().getDisplayMetrics().density;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, list.size() - 1, 2);
        if (progressionLastElement >= 0) {
            while (true) {
                Bundle bundle = new Bundle();
                bundle.putFloat(ViewHierarchyNode.JsonKeys.X, ((float) list.get(i + 1).intValue()) / f);
                bundle.putFloat(ViewHierarchyNode.JsonKeys.Y, ((float) list.get(i).intValue()) / f);
                arrayList.add(bundle);
                if (i == progressionLastElement) {
                    break;
                }
                i += 2;
            }
        }
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = new Bundle();
        bundle3.putFloat(ViewHierarchyNode.JsonKeys.X, ((float) boundingBox.getX()) / f);
        bundle3.putFloat(ViewHierarchyNode.JsonKeys.Y, ((float) boundingBox.getY()) / f);
        Unit unit = Unit.INSTANCE;
        bundle2.putParcelable("origin", bundle3);
        Bundle bundle4 = new Bundle();
        bundle4.putFloat("width", ((float) boundingBox.getWidth()) / f);
        bundle4.putFloat("height", ((float) boundingBox.getHeight()) / f);
        Unit unit2 = Unit.INSTANCE;
        bundle2.putParcelable("size", bundle4);
        return TuplesKt.to(arrayList, bundle2);
    }

    public void onBarCodeScanned(BarCodeScannerResult barCodeScannerResult) {
        Intrinsics.checkNotNullParameter(barCodeScannerResult, "barCode");
        if (this.mShouldScanBarCodes) {
            transformBarCodeScannerResultToViewCoordinates(barCodeScannerResult);
            List<Integer> cornerPoints = barCodeScannerResult.getCornerPoints();
            Intrinsics.checkNotNullExpressionValue(cornerPoints, "barCode.cornerPoints");
            BarCodeScannerResult.BoundingBox boundingBox = barCodeScannerResult.getBoundingBox();
            Intrinsics.checkNotNullExpressionValue(boundingBox, "barCode.boundingBox");
            Pair<ArrayList<Bundle>, Bundle> cornerPointsAndBoundingBox = getCornerPointsAndBoundingBox(cornerPoints, boundingBox);
            ViewEventCallback<BarCodeScannedEvent> onBarCodeScanned = getOnBarCodeScanned();
            int id = getId();
            String value = barCodeScannerResult.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "barCode.value");
            onBarCodeScanned.invoke(new BarCodeScannedEvent(id, value, barCodeScannerResult.getType(), cornerPointsAndBoundingBox.component1(), cornerPointsAndBoundingBox.component2()));
        }
    }

    public void onBarCodeScanningTaskCompleted() {
        this.barCodeScannerTaskLock = false;
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) {
        this.cameraView.setPreviewTexture(surfaceTexture);
    }

    public int[] getPreviewSizeAsArray() {
        return new int[]{this.cameraView.getPreviewSize().getWidth(), this.cameraView.getPreviewSize().getHeight()};
    }

    public void onHostResume() {
        Object obj;
        if (!hasCameraPermissions()) {
            getOnMountError().invoke(new CameraMountErrorEvent("Camera permissions not granted - component could not be rendered."));
        } else if ((this.isPaused && !this.cameraView.isCameraOpened()) || this.isNew) {
            this.isPaused = false;
            this.isNew = false;
            if (!EmulatorUtilities.INSTANCE.isRunningOnEmulator()) {
                this.cameraView.start();
                try {
                    obj = getAppContext().getLegacyModuleRegistry().getModule(FaceDetectorProviderInterface.class);
                } catch (Exception unused) {
                    obj = null;
                }
                FaceDetectorProviderInterface faceDetectorProviderInterface = (FaceDetectorProviderInterface) obj;
                FaceDetectorInterface createFaceDetectorWithContext = faceDetectorProviderInterface != null ? faceDetectorProviderInterface.createFaceDetectorWithContext(getContext()) : null;
                this.faceDetector = createFaceDetectorWithContext;
                Map<String, ? extends Object> map = this.pendingFaceDetectorSettings;
                if (map != null) {
                    if (createFaceDetectorWithContext != null) {
                        createFaceDetectorWithContext.setSettings(map);
                    }
                    this.pendingFaceDetectorSettings = null;
                }
            }
        }
    }

    public void onHostPause() {
        if (!this.isPaused && this.cameraView.isCameraOpened()) {
            FaceDetectorInterface faceDetectorInterface = this.faceDetector;
            if (faceDetectorInterface != null) {
                faceDetectorInterface.release();
            }
            this.isPaused = true;
            this.cameraView.stop();
        }
    }

    public void onHostDestroy() {
        FaceDetectorInterface faceDetectorInterface = this.faceDetector;
        if (faceDetectorInterface != null) {
            faceDetectorInterface.release();
        }
        this.cameraView.stop();
    }

    private final boolean hasCameraPermissions() {
        Permissions permissions = getAppContext().getPermissions();
        if (permissions == null) {
            return false;
        }
        return permissions.hasGrantedPermissions("android.permission.CAMERA");
    }

    public final void setShouldDetectFaces(boolean z) {
        this.shouldDetectFaces = z;
        this.cameraView.setScanning(this.mShouldScanBarCodes || z);
    }

    public final void setFaceDetectorSettings(Map<String, ? extends Object> map) {
        Unit unit;
        FaceDetectorInterface faceDetectorInterface = this.faceDetector;
        if (faceDetectorInterface != null) {
            faceDetectorInterface.setSettings(map);
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            ExpoCameraView expoCameraView = this;
            this.pendingFaceDetectorSettings = map;
        }
    }

    public void onFacesDetected(List<Bundle> list) {
        Intrinsics.checkNotNullParameter(list, "faces");
        if (this.shouldDetectFaces) {
            getOnFacesDetected().invoke(new FacesDetectedEvent("face", list, getId()));
        }
    }

    public void onFaceDetectionError(FaceDetectorInterface faceDetectorInterface) {
        Intrinsics.checkNotNullParameter(faceDetectorInterface, "faceDetector");
        this.faceDetectorTaskLock = false;
        if (this.shouldDetectFaces) {
            getOnFaceDetectionError().invoke(new FaceDetectionErrorEvent(true));
        }
    }

    public void onFaceDetectingTaskCompleted() {
        this.faceDetectorTaskLock = false;
    }
}
