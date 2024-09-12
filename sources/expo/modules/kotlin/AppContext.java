package expo.modules.kotlin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.turbomodule.core.interfaces.CallInvokerHolder;
import com.facebook.react.uimanager.UIManagerHelper;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.errors.ContextDestroyedException;
import expo.modules.core.errors.ModuleNotFoundException;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.JavaScriptContextProvider;
import expo.modules.interfaces.barcodescanner.BarCodeScannerInterface;
import expo.modules.interfaces.camera.CameraViewInterface;
import expo.modules.interfaces.constants.ConstantsInterface;
import expo.modules.interfaces.filesystem.AppDirectoriesModuleInterface;
import expo.modules.interfaces.filesystem.FilePermissionModuleInterface;
import expo.modules.interfaces.font.FontManagerInterface;
import expo.modules.interfaces.imageloader.ImageLoaderInterface;
import expo.modules.interfaces.permissions.Permissions;
import expo.modules.interfaces.sensors.SensorServiceInterface;
import expo.modules.interfaces.taskManager.TaskManagerInterface;
import expo.modules.kotlin.activityresult.ActivityResultsManager;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.activityresult.AppContextActivityResultContract;
import expo.modules.kotlin.activityresult.AppContextActivityResultFallbackCallback;
import expo.modules.kotlin.activityresult.AppContextActivityResultLauncher;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.defaultmodules.NativeModulesProxyModule;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.KEventEmitterWrapper;
import expo.modules.kotlin.events.KModuleEventEmitterWrapper;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.jni.JSIInteropModuleRegistry;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.providers.CurrentActivityProvider;
import java.io.File;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.android.HandlerDispatcher;
import kotlinx.coroutines.android.HandlerDispatcherKt;

@Metadata(d1 = {"\u0000¦\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\u0010\nJ\u0010\u0010m\u001a\u0004\u0018\u00010\"2\u0006\u0010n\u001a\u00020oJ\u000e\u0010p\u001a\u00020q2\u0006\u0010r\u001a\u00020sJ!\u0010t\u001a\u0004\u0018\u0001Hu\"\b\b\u0000\u0010u*\u00020v2\u0006\u0010w\u001a\u00020xH\u0007¢\u0006\u0002\u0010yJ\u0006\u0010z\u001a\u00020qJ\u0018\u0010{\u001a\u0004\u0018\u0001H|\"\u0006\b\u0000\u0010|\u0018\u0001H\b¢\u0006\u0002\u0010}J4\u0010~\u001a\u00020q2\u0006\u0010\u001a\u00020.2\u0007\u0010\u0001\u001a\u00020x2\u0007\u0010\u0001\u001a\u00020x2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020qH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020qH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020qH\u0000¢\u0006\u0003\b\u0001J\u000f\u0010\u0001\u001a\u00020qH\u0000¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00020q2\n\u0010\u0001\u001a\u0005\u0018\u00010\u0001H\u0000¢\u0006\u0003\b\u0001Je\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001\"\n\b\u0000\u0010\u0001*\u00030\u0001\"\u0005\b\u0001\u0010\u00012\u0016\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u00012\u0016\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u0003H\u0001\u0012\u0005\u0012\u0003H\u00010\u0001H@ø\u0001\u0000¢\u0006\u0003\u0010\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u00128BX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0016\u0010!\u001a\u0004\u0018\u00010\"8@X\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0013\u0010%\u001a\u0004\u0018\u00010&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0016\u0010-\u001a\u0004\u0018\u00010.8VX\u0004¢\u0006\u0006\u001a\u0004\b/\u00100R\u0016\u00101\u001a\u0004\u0018\u0001028@X\u0004¢\u0006\u0006\u001a\u0004\b3\u00104R\u0013\u00105\u001a\u0004\u0018\u0001068F¢\u0006\u0006\u001a\u0004\b7\u00108R\u0013\u00109\u001a\u0004\u0018\u00010:8F¢\u0006\u0006\u001a\u0004\b;\u0010<R\u0011\u0010=\u001a\u00020>8F¢\u0006\u0006\u001a\u0004\b?\u0010@R\u0013\u0010A\u001a\u0004\u0018\u00010B8F¢\u0006\u0006\u001a\u0004\bC\u0010DR\u000e\u0010E\u001a\u00020FX.¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\"\u0010I\u001a\n\u0012\u0004\u0012\u00020J\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0011\u0010O\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bP\u0010\u0018R\u0011\u0010Q\u001a\u00020\u0016¢\u0006\b\n\u0000\u001a\u0004\bR\u0010\u0018R\u000e\u0010S\u001a\u00020TX\u0004¢\u0006\u0002\n\u0000R\u0013\u0010U\u001a\u0004\u0018\u00010V8F¢\u0006\u0006\u001a\u0004\bW\u0010XR\u0011\u0010Y\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\bZ\u0010 R\u0013\u0010[\u001a\u0004\u0018\u00010\\8F¢\u0006\u0006\u001a\u0004\b]\u0010^R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020`X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010a\u001a\u00020b¢\u0006\b\n\u0000\u001a\u0004\bc\u0010dR\u0013\u0010e\u001a\u0004\u0018\u00010f8F¢\u0006\u0006\u001a\u0004\bg\u0010hR\u0013\u0010i\u001a\u0004\u0018\u00010j8F¢\u0006\u0006\u001a\u0004\bk\u0010l\u0002\u0004\n\u0002\b\u0019¨\u0006\u0001"}, d2 = {"Lexpo/modules/kotlin/AppContext;", "Lexpo/modules/kotlin/providers/CurrentActivityProvider;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "modulesProvider", "Lexpo/modules/kotlin/ModulesProvider;", "legacyModuleRegistry", "Lexpo/modules/core/ModuleRegistry;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModulesProvider;Lexpo/modules/core/ModuleRegistry;Ljava/lang/ref/WeakReference;)V", "activityProvider", "Lexpo/modules/core/interfaces/ActivityProvider;", "getActivityProvider", "()Lexpo/modules/core/interfaces/ActivityProvider;", "activityResultsManager", "Lexpo/modules/kotlin/activityresult/ActivityResultsManager;", "appDirectories", "Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "getAppDirectories", "()Lexpo/modules/interfaces/filesystem/AppDirectoriesModuleInterface;", "backgroundCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getBackgroundCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "barcodeScanner", "Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "getBarcodeScanner", "()Lexpo/modules/interfaces/barcodescanner/BarCodeScannerInterface;", "cacheDirectory", "Ljava/io/File;", "getCacheDirectory", "()Ljava/io/File;", "callbackInvoker", "Lexpo/modules/kotlin/events/EventEmitter;", "getCallbackInvoker$expo_modules_core_release", "()Lexpo/modules/kotlin/events/EventEmitter;", "camera", "Lexpo/modules/interfaces/camera/CameraViewInterface;", "getCamera", "()Lexpo/modules/interfaces/camera/CameraViewInterface;", "constants", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "getConstants", "()Lexpo/modules/interfaces/constants/ConstantsInterface;", "currentActivity", "Landroid/app/Activity;", "getCurrentActivity", "()Landroid/app/Activity;", "errorManager", "Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "getErrorManager$expo_modules_core_release", "()Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "filePermission", "Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "getFilePermission", "()Lexpo/modules/interfaces/filesystem/FilePermissionModuleInterface;", "font", "Lexpo/modules/interfaces/font/FontManagerInterface;", "getFont", "()Lexpo/modules/interfaces/font/FontManagerInterface;", "hasActiveReactInstance", "", "getHasActiveReactInstance", "()Z", "imageLoader", "Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "getImageLoader", "()Lexpo/modules/interfaces/imageloader/ImageLoaderInterface;", "jsiInterop", "Lexpo/modules/kotlin/jni/JSIInteropModuleRegistry;", "getLegacyModuleRegistry", "()Lexpo/modules/core/ModuleRegistry;", "legacyModulesProxyHolder", "Lexpo/modules/adapters/react/NativeModulesProxy;", "getLegacyModulesProxyHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "setLegacyModulesProxyHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "mainQueue", "getMainQueue", "modulesQueue", "getModulesQueue", "modulesQueueDispatcher", "Lkotlinx/coroutines/android/HandlerDispatcher;", "permissions", "Lexpo/modules/interfaces/permissions/Permissions;", "getPermissions", "()Lexpo/modules/interfaces/permissions/Permissions;", "persistentFilesDirectory", "getPersistentFilesDirectory", "reactContext", "Landroid/content/Context;", "getReactContext", "()Landroid/content/Context;", "reactLifecycleDelegate", "Lexpo/modules/kotlin/ReactLifecycleDelegate;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "sensor", "Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "getSensor", "()Lexpo/modules/interfaces/sensors/SensorServiceInterface;", "taskManager", "Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "getTaskManager", "()Lexpo/modules/interfaces/taskManager/TaskManagerInterface;", "eventEmitter", "module", "Lexpo/modules/kotlin/modules/Module;", "executeOnJavaScriptThread", "", "runnable", "Ljava/lang/Runnable;", "findView", "T", "Landroid/view/View;", "viewTag", "", "(I)Landroid/view/View;", "installJSIInterop", "legacyModule", "Module", "()Ljava/lang/Object;", "onActivityResult", "activity", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onActivityResult$expo_modules_core_release", "onDestroy", "onDestroy$expo_modules_core_release", "onHostDestroy", "onHostDestroy$expo_modules_core_release", "onHostPause", "onHostPause$expo_modules_core_release", "onHostResume", "onHostResume$expo_modules_core_release", "onNewIntent", "intent", "onNewIntent$expo_modules_core_release", "registerForActivityResult", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultLauncher;", "I", "O", "Ljava/io/Serializable;", "contract", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;", "fallbackCallback", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;", "(Lexpo/modules/kotlin/activityresult/AppContextActivityResultContract;Lexpo/modules/kotlin/activityresult/AppContextActivityResultFallbackCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: AppContext.kt */
public final class AppContext implements CurrentActivityProvider, AppContextActivityResultCaller {
    private final ActivityResultsManager activityResultsManager;
    private final CoroutineScope backgroundCoroutineScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.BackgroundCoroutineScope")));
    private JSIInteropModuleRegistry jsiInterop;
    private final ModuleRegistry legacyModuleRegistry;
    private WeakReference<NativeModulesProxy> legacyModulesProxyHolder;
    private final CoroutineScope mainQueue;
    private final CoroutineScope modulesQueue;
    private final HandlerDispatcher modulesQueueDispatcher;
    private final WeakReference<ReactApplicationContext> reactContextHolder;
    private final ReactLifecycleDelegate reactLifecycleDelegate;
    private final ModuleRegistry registry;

    public AppContext(ModulesProvider modulesProvider, ModuleRegistry moduleRegistry, WeakReference<ReactApplicationContext> weakReference) {
        Intrinsics.checkNotNullParameter(modulesProvider, "modulesProvider");
        Intrinsics.checkNotNullParameter(moduleRegistry, "legacyModuleRegistry");
        Intrinsics.checkNotNullParameter(weakReference, "reactContextHolder");
        this.legacyModuleRegistry = moduleRegistry;
        this.reactContextHolder = weakReference;
        ModuleRegistry moduleRegistry2 = new ModuleRegistry(new WeakReference(this));
        this.registry = moduleRegistry2;
        ReactLifecycleDelegate reactLifecycleDelegate2 = new ReactLifecycleDelegate(this);
        this.reactLifecycleDelegate = reactLifecycleDelegate2;
        HandlerThread handlerThread = new HandlerThread("expo.modules.AsyncFunctionQueue");
        handlerThread.start();
        HandlerDispatcher from$default = HandlerDispatcherKt.from$default(new Handler(handlerThread.getLooper()), (String) null, 1, (Object) null);
        this.modulesQueueDispatcher = from$default;
        this.modulesQueue = CoroutineScopeKt.CoroutineScope(from$default.plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.AsyncFunctionQueue")));
        this.mainQueue = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain().plus(SupervisorKt.SupervisorJob$default((Job) null, 1, (Object) null)).plus(new CoroutineName("expo.modules.MainQueue")));
        this.activityResultsManager = new ActivityResultsManager(this);
        Object obj = weakReference.get();
        if (obj != null) {
            ReactApplicationContext reactApplicationContext = (ReactApplicationContext) obj;
            reactApplicationContext.addLifecycleEventListener(reactLifecycleDelegate2);
            reactApplicationContext.addActivityEventListener(reactLifecycleDelegate2);
            moduleRegistry2.register((Module) new ErrorManagerModule());
            moduleRegistry2.register((Module) new NativeModulesProxyModule());
            moduleRegistry2.register(modulesProvider);
            CoreLoggerKt.getLogger().info("✅ AppContext was initialized");
            return;
        }
        throw new IllegalArgumentException("The app context should be created with valid react context.".toString());
    }

    public final ModuleRegistry getLegacyModuleRegistry() {
        return this.legacyModuleRegistry;
    }

    public final ModuleRegistry getRegistry() {
        return this.registry;
    }

    public final CoroutineScope getBackgroundCoroutineScope() {
        return this.backgroundCoroutineScope;
    }

    public final CoroutineScope getModulesQueue() {
        return this.modulesQueue;
    }

    public final CoroutineScope getMainQueue() {
        return this.mainQueue;
    }

    public final WeakReference<NativeModulesProxy> getLegacyModulesProxyHolder$expo_modules_core_release() {
        return this.legacyModulesProxyHolder;
    }

    public final void setLegacyModulesProxyHolder$expo_modules_core_release(WeakReference<NativeModulesProxy> weakReference) {
        this.legacyModulesProxyHolder = weakReference;
    }

    public final void installJSIInterop() {
        Object obj;
        synchronized (this) {
            try {
                this.jsiInterop = new JSIInteropModuleRegistry(this);
                ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
                if (reactApplicationContext != null) {
                    Intrinsics.checkNotNullExpressionValue(reactApplicationContext, "reactContextHolder.get() ?: return");
                    JSIInteropModuleRegistry jSIInteropModuleRegistry = null;
                    try {
                        obj = getLegacyModuleRegistry().getModule(JavaScriptContextProvider.class);
                    } catch (Exception unused) {
                        obj = null;
                    }
                    JavaScriptContextProvider javaScriptContextProvider = (JavaScriptContextProvider) obj;
                    if (javaScriptContextProvider != null) {
                        long javaScriptContextRef = javaScriptContextProvider.getJavaScriptContextRef();
                        CatalystInstance catalystInstance = reactApplicationContext.getCatalystInstance();
                        if (catalystInstance != null) {
                            Intrinsics.checkNotNullExpressionValue(catalystInstance, "reactContext.catalystInstance ?: return");
                            Long valueOf = Long.valueOf(javaScriptContextRef);
                            if (!(valueOf.longValue() != 0)) {
                                valueOf = null;
                            }
                            if (valueOf != null) {
                                long longValue = valueOf.longValue();
                                JSIInteropModuleRegistry jSIInteropModuleRegistry2 = this.jsiInterop;
                                if (jSIInteropModuleRegistry2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("jsiInterop");
                                } else {
                                    jSIInteropModuleRegistry = jSIInteropModuleRegistry2;
                                }
                                CallInvokerHolderImpl jSCallInvokerHolder = javaScriptContextProvider.getJSCallInvokerHolder();
                                Intrinsics.checkNotNullExpressionValue(jSCallInvokerHolder, "jsContextProvider.jsCallInvokerHolder");
                                CallInvokerHolder nativeCallInvokerHolder = catalystInstance.getNativeCallInvokerHolder();
                                Intrinsics.checkNotNull(nativeCallInvokerHolder, "null cannot be cast to non-null type com.facebook.react.turbomodule.core.CallInvokerHolderImpl");
                                jSIInteropModuleRegistry.installJSI(longValue, jSCallInvokerHolder, (CallInvokerHolderImpl) nativeCallInvokerHolder);
                                CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                            }
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            } catch (Throwable th) {
                CoreLoggerKt.getLogger().error("❌ Cannot install JSI interop: " + th, th);
            }
        }
    }

    public final /* synthetic */ <Module> Module legacyModule() {
        try {
            ModuleRegistry legacyModuleRegistry2 = getLegacyModuleRegistry();
            Intrinsics.reifiedOperationMarker(4, "Module");
            Class<Object> cls = Object.class;
            Class cls2 = cls;
            return legacyModuleRegistry2.getModule(cls);
        } catch (Exception unused) {
            return null;
        }
    }

    public final File getPersistentFilesDirectory() {
        File persistentFilesDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories != null && (persistentFilesDirectory = appDirectories.getPersistentFilesDirectory()) != null) {
            return persistentFilesDirectory;
        }
        throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
    }

    public final File getCacheDirectory() {
        File cacheDirectory;
        AppDirectoriesModuleInterface appDirectories = getAppDirectories();
        if (appDirectories != null && (cacheDirectory = appDirectories.getCacheDirectory()) != null) {
            return cacheDirectory;
        }
        throw new ModuleNotFoundException("expo.modules.interfaces.filesystem.AppDirectories");
    }

    public final Context getReactContext() {
        return (Context) this.reactContextHolder.get();
    }

    public final boolean getHasActiveReactInstance() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            return reactApplicationContext.hasActiveReactInstance();
        }
        return false;
    }

    public final ErrorManagerModule getErrorManager$expo_modules_core_release() {
        AppContextProvider appContextProvider;
        Object obj;
        boolean z;
        Iterator it = this.registry.getRegistry().values().iterator();
        while (true) {
            appContextProvider = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Module module = ((ModuleHolder) obj).getModule();
            if (module != null) {
                z = module instanceof ErrorManagerModule;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        ModuleHolder moduleHolder = (ModuleHolder) obj;
        AppContextProvider module2 = moduleHolder != null ? moduleHolder.getModule() : null;
        if (module2 instanceof ErrorManagerModule) {
            appContextProvider = module2;
        }
        return (ErrorManagerModule) appContextProvider;
    }

    public final void onDestroy$expo_modules_core_release() {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.removeLifecycleEventListener(this.reactLifecycleDelegate);
        }
        this.registry.post(EventName.MODULE_DESTROY);
        this.registry.cleanUp();
        CoroutineScopeKt.cancel(this.modulesQueue, new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
        CoroutineScopeKt.cancel(this.mainQueue, new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
        CoroutineScopeKt.cancel(this.backgroundCoroutineScope, new ContextDestroyedException((String) null, 1, (DefaultConstructorMarker) null));
        CoreLoggerKt.getLogger().info("✅ AppContext was destroyed");
    }

    public final void onHostResume$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (!(currentActivity instanceof AppCompatActivity)) {
            Activity currentActivity2 = getCurrentActivity();
            throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
        }
        this.activityResultsManager.onHostResume((AppCompatActivity) currentActivity);
        this.registry.post(EventName.ACTIVITY_ENTERS_FOREGROUND);
    }

    public final void onHostPause$expo_modules_core_release() {
        this.registry.post(EventName.ACTIVITY_ENTERS_BACKGROUND);
    }

    public final void onHostDestroy$expo_modules_core_release() {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            if (!(currentActivity instanceof AppCompatActivity)) {
                Activity currentActivity2 = getCurrentActivity();
                throw new IllegalStateException(("Current Activity is of incorrect class, expected AppCompatActivity, received " + (currentActivity2 != null ? currentActivity2.getLocalClassName() : null)).toString());
            }
            this.activityResultsManager.onHostDestroy((AppCompatActivity) currentActivity);
        }
        this.registry.post(EventName.ACTIVITY_DESTROYS);
    }

    public final void onActivityResult$expo_modules_core_release(Activity activity, int i, int i2, Intent intent) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.activityResultsManager.onActivityResult(activity, i, i2, intent);
        this.registry.post(EventName.ON_ACTIVITY_RESULT, activity, new OnActivityResultPayload(i, i2, intent));
    }

    public final void onNewIntent$expo_modules_core_release(Intent intent) {
        this.registry.post(EventName.ON_NEW_INTENT, intent);
    }

    public final <T extends View> T findView(int i) {
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext == null) {
            return null;
        }
        UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(reactApplicationContext, i);
        T resolveView = uIManagerForReactTag != null ? uIManagerForReactTag.resolveView(i) : null;
        if (resolveView instanceof View) {
            return resolveView;
        }
        return null;
    }

    public final void executeOnJavaScriptThread(Runnable runnable) {
        Intrinsics.checkNotNullParameter(runnable, "runnable");
        ReactApplicationContext reactApplicationContext = (ReactApplicationContext) this.reactContextHolder.get();
        if (reactApplicationContext != null) {
            reactApplicationContext.runOnJSQueueThread(runnable);
        }
    }

    public Activity getCurrentActivity() {
        ActivityProvider activityProvider = getActivityProvider();
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    @Deprecated(message = "`registerForActivityResult` was deprecated. Please use `RegisterActivityContracts` component instead.")
    public <I extends Serializable, O> Object registerForActivityResult(AppContextActivityResultContract<I, O> appContextActivityResultContract, AppContextActivityResultFallbackCallback<I, O> appContextActivityResultFallbackCallback, Continuation<? super AppContextActivityResultLauncher<I, O>> continuation) {
        return this.activityResultsManager.registerForActivityResult(appContextActivityResultContract, appContextActivityResultFallbackCallback, continuation);
    }

    public final ConstantsInterface getConstants() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ConstantsInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ConstantsInterface) obj;
    }

    public final FilePermissionModuleInterface getFilePermission() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FilePermissionModuleInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FilePermissionModuleInterface) obj;
    }

    private final AppDirectoriesModuleInterface getAppDirectories() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(AppDirectoriesModuleInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (AppDirectoriesModuleInterface) obj;
    }

    public final Permissions getPermissions() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(Permissions.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (Permissions) obj;
    }

    public final ImageLoaderInterface getImageLoader() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ImageLoaderInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ImageLoaderInterface) obj;
    }

    public final BarCodeScannerInterface getBarcodeScanner() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(BarCodeScannerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (BarCodeScannerInterface) obj;
    }

    public final CameraViewInterface getCamera() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(CameraViewInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (CameraViewInterface) obj;
    }

    public final FontManagerInterface getFont() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(FontManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (FontManagerInterface) obj;
    }

    public final SensorServiceInterface getSensor() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(SensorServiceInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (SensorServiceInterface) obj;
    }

    public final TaskManagerInterface getTaskManager() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(TaskManagerInterface.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (TaskManagerInterface) obj;
    }

    public final ActivityProvider getActivityProvider() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(ActivityProvider.class);
        } catch (Exception unused) {
            obj = null;
        }
        return (ActivityProvider) obj;
    }

    public final EventEmitter eventEmitter(Module module) {
        Object obj;
        Intrinsics.checkNotNullParameter(module, "module");
        try {
            obj = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            obj = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) obj;
        if (eventEmitter == null) {
            return null;
        }
        ModuleHolder moduleHolder = this.registry.getModuleHolder(module);
        if (moduleHolder != null) {
            return new KModuleEventEmitterWrapper(moduleHolder, eventEmitter, this.reactContextHolder);
        }
        throw new IllegalArgumentException("Cannot create an event emitter for the module that isn't present in the module registry.".toString());
    }

    public final EventEmitter getCallbackInvoker$expo_modules_core_release() {
        Object obj;
        try {
            obj = getLegacyModuleRegistry().getModule(expo.modules.core.interfaces.services.EventEmitter.class);
        } catch (Exception unused) {
            obj = null;
        }
        expo.modules.core.interfaces.services.EventEmitter eventEmitter = (expo.modules.core.interfaces.services.EventEmitter) obj;
        if (eventEmitter == null) {
            return null;
        }
        return new KEventEmitterWrapper(eventEmitter, this.reactContextHolder);
    }
}
