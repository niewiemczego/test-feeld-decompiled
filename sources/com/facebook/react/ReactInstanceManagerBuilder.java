package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.facebook.common.logging.FLog;
import com.facebook.hermes.reactexecutor.HermesExecutor;
import com.facebook.hermes.reactexecutor.HermesExecutorFactory;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSExceptionHandler;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.DefaultDevSupportManagerFactory;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.jscexecutor.JSCExecutor;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.RequestHandler;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReactInstanceManagerBuilder {
    private static final String TAG = "ReactInstanceManagerBuilder";
    private JSEngineResolutionAlgorithm jsEngineResolutionAlgorithm = null;
    private Application mApplication;
    private NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;
    private Activity mCurrentActivity;
    private Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DefaultHardwareBackBtnHandler mDefaultHardwareBackBtnHandler;
    private DevBundleDownloadListener mDevBundleDownloadListener;
    private DevSupportManagerFactory mDevSupportManagerFactory;
    private LifecycleState mInitialLifecycleState;
    private String mJSBundleAssetUrl;
    private JSBundleLoader mJSBundleLoader;
    private JSExceptionHandler mJSExceptionHandler;
    private JSIModulePackage mJSIModulesPackage;
    private String mJSMainModulePath;
    private JavaScriptExecutorFactory mJavaScriptExecutorFactory;
    private boolean mLazyViewManagersEnabled;
    private int mMinNumShakes = 1;
    private int mMinTimeLeftInFrameForNonBatchedOperationMs = -1;
    private final List<ReactPackage> mPackages = new ArrayList();
    private RedBoxHandler mRedBoxHandler;
    private boolean mRequireActivity;
    private SurfaceDelegateFactory mSurfaceDelegateFactory;
    private ReactPackageTurboModuleManagerDelegate.Builder mTMMDelegateBuilder;
    private boolean mUseDeveloperSupport;

    ReactInstanceManagerBuilder() {
    }

    public ReactInstanceManagerBuilder setJSIModulesPackage(JSIModulePackage jSIModulePackage) {
        this.mJSIModulesPackage = jSIModulePackage;
        return this;
    }

    public ReactInstanceManagerBuilder setJavaScriptExecutorFactory(JavaScriptExecutorFactory javaScriptExecutorFactory) {
        this.mJavaScriptExecutorFactory = javaScriptExecutorFactory;
        return this;
    }

    public ReactInstanceManagerBuilder setBundleAssetName(String str) {
        this.mJSBundleAssetUrl = str == null ? null : "assets://" + str;
        this.mJSBundleLoader = null;
        return this;
    }

    public ReactInstanceManagerBuilder setJSBundleFile(String str) {
        if (!str.startsWith("assets://")) {
            return setJSBundleLoader(JSBundleLoader.createFileLoader(str));
        }
        this.mJSBundleAssetUrl = str;
        this.mJSBundleLoader = null;
        return this;
    }

    public ReactInstanceManagerBuilder setJSBundleLoader(JSBundleLoader jSBundleLoader) {
        this.mJSBundleLoader = jSBundleLoader;
        this.mJSBundleAssetUrl = null;
        return this;
    }

    private void setJSEngineResolutionAlgorithm(JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm) {
        this.jsEngineResolutionAlgorithm = jSEngineResolutionAlgorithm;
    }

    public ReactInstanceManagerBuilder setJSMainModulePath(String str) {
        this.mJSMainModulePath = str;
        return this;
    }

    public ReactInstanceManagerBuilder addPackage(ReactPackage reactPackage) {
        this.mPackages.add(reactPackage);
        return this;
    }

    public ReactInstanceManagerBuilder addPackages(List<ReactPackage> list) {
        this.mPackages.addAll(list);
        return this;
    }

    public ReactInstanceManagerBuilder setBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener notThreadSafeBridgeIdleDebugListener) {
        this.mBridgeIdleDebugListener = notThreadSafeBridgeIdleDebugListener;
        return this;
    }

    public ReactInstanceManagerBuilder setApplication(Application application) {
        this.mApplication = application;
        return this;
    }

    public ReactInstanceManagerBuilder setCurrentActivity(Activity activity) {
        this.mCurrentActivity = activity;
        return this;
    }

    public ReactInstanceManagerBuilder setDefaultHardwareBackBtnHandler(DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler) {
        this.mDefaultHardwareBackBtnHandler = defaultHardwareBackBtnHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setUseDeveloperSupport(boolean z) {
        this.mUseDeveloperSupport = z;
        return this;
    }

    public ReactInstanceManagerBuilder setDevSupportManagerFactory(DevSupportManagerFactory devSupportManagerFactory) {
        this.mDevSupportManagerFactory = devSupportManagerFactory;
        return this;
    }

    public ReactInstanceManagerBuilder setRequireActivity(boolean z) {
        this.mRequireActivity = z;
        return this;
    }

    public ReactInstanceManagerBuilder setSurfaceDelegateFactory(SurfaceDelegateFactory surfaceDelegateFactory) {
        this.mSurfaceDelegateFactory = surfaceDelegateFactory;
        return this;
    }

    public ReactInstanceManagerBuilder setInitialLifecycleState(LifecycleState lifecycleState) {
        this.mInitialLifecycleState = lifecycleState;
        return this;
    }

    public ReactInstanceManagerBuilder setJSExceptionHandler(JSExceptionHandler jSExceptionHandler) {
        this.mJSExceptionHandler = jSExceptionHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setRedBoxHandler(RedBoxHandler redBoxHandler) {
        this.mRedBoxHandler = redBoxHandler;
        return this;
    }

    public ReactInstanceManagerBuilder setLazyViewManagersEnabled(boolean z) {
        this.mLazyViewManagersEnabled = z;
        return this;
    }

    public ReactInstanceManagerBuilder setDevBundleDownloadListener(DevBundleDownloadListener devBundleDownloadListener) {
        this.mDevBundleDownloadListener = devBundleDownloadListener;
        return this;
    }

    public ReactInstanceManagerBuilder setMinNumShakes(int i) {
        this.mMinNumShakes = i;
        return this;
    }

    public ReactInstanceManagerBuilder setMinTimeLeftInFrameForNonBatchedOperationMs(int i) {
        this.mMinTimeLeftInFrameForNonBatchedOperationMs = i;
        return this;
    }

    public ReactInstanceManagerBuilder setCustomPackagerCommandHandlers(Map<String, RequestHandler> map) {
        this.mCustomPackagerCommandHandlers = map;
        return this;
    }

    public ReactInstanceManagerBuilder setReactPackageTurboModuleManagerDelegateBuilder(ReactPackageTurboModuleManagerDelegate.Builder builder) {
        this.mTMMDelegateBuilder = builder;
        return this;
    }

    public ReactInstanceManager build() {
        String str;
        Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder");
        if (this.mInitialLifecycleState == LifecycleState.RESUMED) {
            Assertions.assertNotNull(this.mCurrentActivity, "Activity needs to be set if initial lifecycle state is resumed");
        }
        boolean z = true;
        Assertions.assertCondition((!this.mUseDeveloperSupport && this.mJSBundleAssetUrl == null && this.mJSBundleLoader == null) ? false : true, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
        if (this.mJSMainModulePath == null && this.mJSBundleAssetUrl == null && this.mJSBundleLoader == null) {
            z = false;
        }
        Assertions.assertCondition(z, "Either MainModulePath or JS Bundle File needs to be provided");
        String packageName = this.mApplication.getPackageName();
        String friendlyDeviceName = AndroidInfoHelpers.getFriendlyDeviceName();
        Application application = this.mApplication;
        Activity activity = this.mCurrentActivity;
        DefaultHardwareBackBtnHandler defaultHardwareBackBtnHandler = this.mDefaultHardwareBackBtnHandler;
        JavaScriptExecutorFactory javaScriptExecutorFactory = this.mJavaScriptExecutorFactory;
        JavaScriptExecutorFactory defaultJSExecutorFactory = javaScriptExecutorFactory == null ? getDefaultJSExecutorFactory(packageName, friendlyDeviceName, application.getApplicationContext()) : javaScriptExecutorFactory;
        JSBundleLoader jSBundleLoader = this.mJSBundleLoader;
        if (jSBundleLoader == null && (str = this.mJSBundleAssetUrl) != null) {
            jSBundleLoader = JSBundleLoader.createAssetLoader(this.mApplication, str, false);
        }
        JSBundleLoader jSBundleLoader2 = jSBundleLoader;
        String str2 = this.mJSMainModulePath;
        List<ReactPackage> list = this.mPackages;
        boolean z2 = this.mUseDeveloperSupport;
        DevSupportManagerFactory devSupportManagerFactory = this.mDevSupportManagerFactory;
        if (devSupportManagerFactory == null) {
            devSupportManagerFactory = new DefaultDevSupportManagerFactory();
        }
        return new ReactInstanceManager(application, activity, defaultHardwareBackBtnHandler, defaultJSExecutorFactory, jSBundleLoader2, str2, list, z2, devSupportManagerFactory, this.mRequireActivity, this.mBridgeIdleDebugListener, (LifecycleState) Assertions.assertNotNull(this.mInitialLifecycleState, "Initial lifecycle state was not set"), this.mJSExceptionHandler, this.mRedBoxHandler, this.mLazyViewManagersEnabled, this.mDevBundleDownloadListener, this.mMinNumShakes, this.mMinTimeLeftInFrameForNonBatchedOperationMs, this.mJSIModulesPackage, this.mCustomPackagerCommandHandlers, this.mTMMDelegateBuilder, this.mSurfaceDelegateFactory);
    }

    private JavaScriptExecutorFactory getDefaultJSExecutorFactory(String str, String str2, Context context) {
        JSEngineResolutionAlgorithm jSEngineResolutionAlgorithm = this.jsEngineResolutionAlgorithm;
        if (jSEngineResolutionAlgorithm == null) {
            FLog.w(TAG, "You're not setting the JS Engine Resolution Algorithm. We'll try to load JSC first, and if it fails we'll fallback to Hermes");
            try {
                ReactInstanceManager.initializeSoLoaderIfNecessary(context);
                JSCExecutor.loadLibrary();
                return new JSCExecutorFactory(str, str2);
            } catch (UnsatisfiedLinkError e) {
                if (!e.getMessage().contains("__cxa_bad_typeid")) {
                    HermesExecutor.loadLibrary();
                    return new HermesExecutorFactory();
                }
                throw e;
            }
        } else if (jSEngineResolutionAlgorithm == JSEngineResolutionAlgorithm.HERMES) {
            HermesExecutor.loadLibrary();
            return new HermesExecutorFactory();
        } else {
            JSCExecutor.loadLibrary();
            return new JSCExecutorFactory(str, str2);
        }
    }
}
