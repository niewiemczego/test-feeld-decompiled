package com.facebook.react.devsupport;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.hardware.SensorManager;
import android.os.Build;
import android.util.Pair;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.view.ViewCompat;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.DefaultJSExceptionHandler;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.DebugServerException;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.ShakeDetector;
import com.facebook.react.common.SurfaceDelegate;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.DevInternalSettings;
import com.facebook.react.devsupport.DevServerHelper;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.interfaces.BundleLoadCallback;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.ErrorCustomizer;
import com.facebook.react.devsupport.interfaces.ErrorType;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.core.RCTNativeAppEventEmitter;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.Responder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public abstract class DevSupportManagerBase implements DevSupportManager {
    public static final String EMOJI_FACE_WITH_NO_GOOD_GESTURE = " 🙅";
    public static final String EMOJI_HUNDRED_POINTS_SYMBOL = " 💯";
    private static final String EXOPACKAGE_LOCATION_FORMAT = "/data/local/tmp/exopackage/%s//secondary-dex";
    private static final String FLIPPER_DEBUGGER_URL = "flipper://null/Hermesdebuggerrn?device=React%20Native";
    private static final String FLIPPER_DEVTOOLS_URL = "flipper://null/React?device=React%20Native";
    private static final int JAVA_ERROR_COOKIE = -1;
    private static final int JSEXCEPTION_ERROR_COOKIE = -1;
    private static final String RELOAD_APP_ACTION_SUFFIX = ".RELOAD_APP_ACTION";
    private Activity currentActivity;
    /* access modifiers changed from: private */
    public final Context mApplicationContext;
    /* access modifiers changed from: private */
    public DevBundleDownloadListener mBundleDownloadListener;
    /* access modifiers changed from: private */
    public InspectorPackagerConnection.BundleStatus mBundleStatus;
    /* access modifiers changed from: private */
    public ReactContext mCurrentContext;
    private final LinkedHashMap<String, DevOptionHandler> mCustomDevOptions = new LinkedHashMap<>();
    /* access modifiers changed from: private */
    public Map<String, RequestHandler> mCustomPackagerCommandHandlers;
    private DebugOverlayController mDebugOverlayController;
    private final DefaultJSExceptionHandler mDefaultJSExceptionHandler;
    /* access modifiers changed from: private */
    public final DevLoadingViewController mDevLoadingViewController;
    private boolean mDevLoadingViewVisible = false;
    /* access modifiers changed from: private */
    public AlertDialog mDevOptionsDialog;
    /* access modifiers changed from: private */
    public final DevServerHelper mDevServerHelper;
    /* access modifiers changed from: private */
    public DevInternalSettings mDevSettings;
    private List<ErrorCustomizer> mErrorCustomizers;
    private boolean mIsDevSupportEnabled = false;
    private boolean mIsReceiverRegistered = false;
    private boolean mIsShakeDetectorStarted = false;
    private final String mJSAppBundleName;
    private final File mJSBundleDownloadedFile;
    private final File mJSSplitBundlesDir;
    /* access modifiers changed from: private */
    public int mLastErrorCookie = 0;
    private StackFrame[] mLastErrorStack;
    private String mLastErrorTitle;
    private ErrorType mLastErrorType;
    private DevSupportManager.PackagerLocationCustomizer mPackagerLocationCustomizer;
    private int mPendingJSSplitBundleRequests = 0;
    /* access modifiers changed from: private */
    public final ReactInstanceDevHelper mReactInstanceDevHelper;
    private RedBoxHandler mRedBoxHandler;
    /* access modifiers changed from: private */
    public SurfaceDelegate mRedBoxSurfaceDelegate;
    private final BroadcastReceiver mReloadAppBroadcastReceiver;
    private final ShakeDetector mShakeDetector;
    private final SurfaceDelegateFactory mSurfaceDelegateFactory;

    public interface CallbackWithBundleLoader {
        void onError(String str, Throwable th);

        void onSuccess(JSBundleLoader jSBundleLoader);
    }

    /* access modifiers changed from: protected */
    public abstract String getUniqueTag();

    public DevSupportManagerBase(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory) {
        this.mReactInstanceDevHelper = reactInstanceDevHelper;
        this.mApplicationContext = context;
        this.mJSAppBundleName = str;
        this.mDevSettings = new DevInternalSettings(context, new DevInternalSettings.Listener() {
            public void onInternalSettingsChanged() {
                DevSupportManagerBase.this.reloadSettings();
            }
        });
        this.mBundleStatus = new InspectorPackagerConnection.BundleStatus();
        this.mDevServerHelper = new DevServerHelper(this.mDevSettings, context.getPackageName(), new InspectorPackagerConnection.BundleStatusProvider() {
            public InspectorPackagerConnection.BundleStatus getBundleStatus() {
                return DevSupportManagerBase.this.mBundleStatus;
            }
        });
        this.mBundleDownloadListener = devBundleDownloadListener;
        this.mShakeDetector = new ShakeDetector(new ShakeDetector.ShakeListener() {
            public void onShake() {
                DevSupportManagerBase.this.showDevOptionsDialog();
            }
        }, i);
        this.mCustomPackagerCommandHandlers = map;
        this.mReloadAppBroadcastReceiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                if (DevSupportManagerBase.getReloadAppAction(context).equals(intent.getAction())) {
                    if (intent.getBooleanExtra(DevServerHelper.RELOAD_APP_EXTRA_JS_PROXY, false)) {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(true);
                        DevSupportManagerBase.this.mDevServerHelper.launchJSDevtools();
                    } else {
                        DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(false);
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                }
            }
        };
        String uniqueTag = getUniqueTag();
        this.mJSBundleDownloadedFile = new File(context.getFilesDir(), uniqueTag + "ReactNativeDevBundle.js");
        this.mJSSplitBundlesDir = context.getDir(uniqueTag.toLowerCase(Locale.ROOT) + "_dev_js_split_bundles", 0);
        this.mDefaultJSExceptionHandler = new DefaultJSExceptionHandler();
        setDevSupportEnabled(z);
        this.mRedBoxHandler = redBoxHandler;
        this.mDevLoadingViewController = new DevLoadingViewController(reactInstanceDevHelper);
        this.mSurfaceDelegateFactory = surfaceDelegateFactory;
    }

    public void handleException(Exception exc) {
        if (this.mIsDevSupportEnabled) {
            logJSException(exc);
        } else {
            this.mDefaultJSExceptionHandler.handleException(exc);
        }
    }

    private void logJSException(Exception exc) {
        StringBuilder sb = new StringBuilder(exc.getMessage() == null ? "Exception in native call from JS" : exc.getMessage());
        for (Throwable cause = exc.getCause(); cause != null; cause = cause.getCause()) {
            sb.append("\n\n").append(cause.getMessage());
        }
        if (exc instanceof JSException) {
            FLog.e(ReactConstants.TAG, "Exception in native call from JS", (Throwable) exc);
            sb.append("\n\n").append(((JSException) exc).getStack());
            showNewError(sb.toString(), new StackFrame[0], -1, ErrorType.JS);
            return;
        }
        showNewJavaError(sb.toString(), exc);
    }

    public void showNewJavaError(String str, Throwable th) {
        FLog.e(ReactConstants.TAG, "Exception in native call", th);
        showNewError(str, StackTraceHelper.convertJavaStackTrace(th), -1, ErrorType.NATIVE);
    }

    public void addCustomDevOption(String str, DevOptionHandler devOptionHandler) {
        this.mCustomDevOptions.put(str, devOptionHandler);
    }

    public void showNewJSError(String str, ReadableArray readableArray, int i) {
        showNewError(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
    }

    public void registerErrorCustomizer(ErrorCustomizer errorCustomizer) {
        if (this.mErrorCustomizers == null) {
            this.mErrorCustomizers = new ArrayList();
        }
        this.mErrorCustomizers.add(errorCustomizer);
    }

    public Pair<String, StackFrame[]> processErrorCustomizers(Pair<String, StackFrame[]> pair) {
        List<ErrorCustomizer> list = this.mErrorCustomizers;
        if (list == null) {
            return pair;
        }
        for (ErrorCustomizer customizeErrorInfo : list) {
            Pair<String, StackFrame[]> customizeErrorInfo2 = customizeErrorInfo.customizeErrorInfo(pair);
            if (customizeErrorInfo2 != null) {
                pair = customizeErrorInfo2;
            }
        }
        return pair;
    }

    public void updateJSError(final String str, final ReadableArray readableArray, final int i) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                if (DevSupportManagerBase.this.mRedBoxSurfaceDelegate.isShowing() && i == DevSupportManagerBase.this.mLastErrorCookie) {
                    DevSupportManagerBase.this.updateLastErrorInfo(str, StackTraceHelper.convertJsStackTrace(readableArray), i, ErrorType.JS);
                    DevSupportManagerBase.this.mRedBoxSurfaceDelegate.show();
                }
            }
        });
    }

    public void hideRedboxDialog() {
        SurfaceDelegate surfaceDelegate = this.mRedBoxSurfaceDelegate;
        if (surfaceDelegate != null) {
            surfaceDelegate.hide();
        }
    }

    public View createRootView(String str) {
        return this.mReactInstanceDevHelper.createRootView(str);
    }

    public void destroyRootView(View view) {
        this.mReactInstanceDevHelper.destroyRootView(view);
    }

    private void hideDevOptionsDialog() {
        AlertDialog alertDialog = this.mDevOptionsDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
            this.mDevOptionsDialog = null;
        }
    }

    private void showNewError(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        final String str2 = str;
        final StackFrame[] stackFrameArr2 = stackFrameArr;
        final int i2 = i;
        final ErrorType errorType2 = errorType;
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerBase.this.updateLastErrorInfo(str2, stackFrameArr2, i2, errorType2);
                if (DevSupportManagerBase.this.mRedBoxSurfaceDelegate == null) {
                    SurfaceDelegate createSurfaceDelegate = DevSupportManagerBase.this.createSurfaceDelegate("RedBox");
                    if (createSurfaceDelegate != null) {
                        SurfaceDelegate unused = DevSupportManagerBase.this.mRedBoxSurfaceDelegate = createSurfaceDelegate;
                    } else {
                        SurfaceDelegate unused2 = DevSupportManagerBase.this.mRedBoxSurfaceDelegate = new RedBoxDialogSurfaceDelegate(DevSupportManagerBase.this);
                    }
                    DevSupportManagerBase.this.mRedBoxSurfaceDelegate.createContentView("RedBox");
                }
                if (!DevSupportManagerBase.this.mRedBoxSurfaceDelegate.isShowing()) {
                    DevSupportManagerBase.this.mRedBoxSurfaceDelegate.show();
                }
            }
        });
    }

    public void showDevOptionsDialog() {
        String str;
        String str2;
        String str3;
        if (this.mDevOptionsDialog == null && this.mIsDevSupportEnabled && !ActivityManager.isUserAMonkey()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_reload), new DevOptionHandler() {
                public void onOptionSelected() {
                    if (!DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled() && DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled()) {
                        Toast.makeText(DevSupportManagerBase.this.mApplicationContext, DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_hot_reloading_auto_disable), 1).show();
                        DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(false);
                    }
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
            if (this.mDevSettings.isDeviceDebugEnabled()) {
                if (this.mDevSettings.isRemoteJSDebugEnabled()) {
                    this.mDevSettings.setRemoteJSDebugEnabled(false);
                    handleReloadJS();
                }
                linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_debug_open), new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerBase.this.mDevServerHelper.openUrl(DevSupportManagerBase.this.mCurrentContext, DevSupportManagerBase.FLIPPER_DEBUGGER_URL, DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_open_flipper_error));
                    }
                });
                linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_devtools_open), new DevOptionHandler() {
                    public void onOptionSelected() {
                        DevSupportManagerBase.this.mDevServerHelper.openUrl(DevSupportManagerBase.this.mCurrentContext, DevSupportManagerBase.FLIPPER_DEVTOOLS_URL, DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_open_flipper_error));
                    }
                });
            }
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_change_bundle_location), new DevOptionHandler() {
                public void onOptionSelected() {
                    Activity currentActivity = DevSupportManagerBase.this.mReactInstanceDevHelper.getCurrentActivity();
                    if (currentActivity == null || currentActivity.isFinishing()) {
                        FLog.e(ReactConstants.TAG, "Unable to launch change bundle location because react activity is not available");
                        return;
                    }
                    final EditText editText = new EditText(currentActivity);
                    editText.setHint("localhost:8081");
                    new AlertDialog.Builder(currentActivity).setTitle(DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_change_bundle_location)).setView(editText).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogInterface, int i) {
                            DevSupportManagerBase.this.mDevSettings.getPackagerConnectionSettings().setDebugServerHost(editText.getText().toString());
                            DevSupportManagerBase.this.handleReloadJS();
                        }
                    }).create().show();
                }
            });
            if (this.mDevSettings.isElementInspectorEnabled()) {
                str = this.mApplicationContext.getString(R.string.catalyst_inspector_stop);
            } else {
                str = this.mApplicationContext.getString(R.string.catalyst_inspector);
            }
            linkedHashMap.put(str, new DevOptionHandler() {
                public void onOptionSelected() {
                    DevSupportManagerBase.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerBase.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerBase.this.mReactInstanceDevHelper.toggleElementInspector();
                }
            });
            if (this.mDevSettings.isHotModuleReplacementEnabled()) {
                str2 = this.mApplicationContext.getString(R.string.catalyst_hot_reloading_stop);
            } else {
                str2 = this.mApplicationContext.getString(R.string.catalyst_hot_reloading);
            }
            linkedHashMap.put(str2, new DevOptionHandler() {
                public void onOptionSelected() {
                    boolean z = !DevSupportManagerBase.this.mDevSettings.isHotModuleReplacementEnabled();
                    DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    if (DevSupportManagerBase.this.mCurrentContext != null) {
                        if (z) {
                            ((HMRClient) DevSupportManagerBase.this.mCurrentContext.getJSModule(HMRClient.class)).enable();
                        } else {
                            ((HMRClient) DevSupportManagerBase.this.mCurrentContext.getJSModule(HMRClient.class)).disable();
                        }
                    }
                    if (z && !DevSupportManagerBase.this.mDevSettings.isJSDevModeEnabled()) {
                        Toast.makeText(DevSupportManagerBase.this.mApplicationContext, DevSupportManagerBase.this.mApplicationContext.getString(R.string.catalyst_hot_reloading_auto_enable), 1).show();
                        DevSupportManagerBase.this.mDevSettings.setJSDevModeEnabled(true);
                        DevSupportManagerBase.this.handleReloadJS();
                    }
                }
            });
            if (this.mDevSettings.isFpsDebugEnabled()) {
                str3 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor_stop);
            } else {
                str3 = this.mApplicationContext.getString(R.string.catalyst_perf_monitor);
            }
            linkedHashMap.put(str3, new DevOptionHandler() {
                public void onOptionSelected() {
                    if (!DevSupportManagerBase.this.mDevSettings.isFpsDebugEnabled()) {
                        Activity currentActivity = DevSupportManagerBase.this.mReactInstanceDevHelper.getCurrentActivity();
                        if (currentActivity == null) {
                            FLog.e(ReactConstants.TAG, "Unable to get reference to react activity");
                        } else {
                            DebugOverlayController.requestPermission(currentActivity);
                        }
                    }
                    DevSupportManagerBase.this.mDevSettings.setFpsDebugEnabled(!DevSupportManagerBase.this.mDevSettings.isFpsDebugEnabled());
                }
            });
            linkedHashMap.put(this.mApplicationContext.getString(R.string.catalyst_settings), new DevOptionHandler() {
                public void onOptionSelected() {
                    Intent intent = new Intent(DevSupportManagerBase.this.mApplicationContext, DevSettingsActivity.class);
                    intent.setFlags(268435456);
                    DevSupportManagerBase.this.mApplicationContext.startActivity(intent);
                }
            });
            if (this.mCustomDevOptions.size() > 0) {
                linkedHashMap.putAll(this.mCustomDevOptions);
            }
            final DevOptionHandler[] devOptionHandlerArr = (DevOptionHandler[]) linkedHashMap.values().toArray(new DevOptionHandler[0]);
            Activity currentActivity2 = this.mReactInstanceDevHelper.getCurrentActivity();
            if (currentActivity2 == null || currentActivity2.isFinishing()) {
                FLog.e(ReactConstants.TAG, "Unable to launch dev options menu because react activity isn't available");
                return;
            }
            TextView textView = new TextView(getApplicationContext());
            textView.setText("React Native DevMenu (" + getUniqueTag() + ")");
            textView.setPadding(0, 50, 0, 0);
            textView.setGravity(17);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(17.0f);
            textView.setTypeface(textView.getTypeface(), 1);
            AlertDialog create = new AlertDialog.Builder(currentActivity2).setCustomTitle(textView).setItems((CharSequence[]) linkedHashMap.keySet().toArray(new String[0]), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    devOptionHandlerArr[i].onOptionSelected();
                    AlertDialog unused = DevSupportManagerBase.this.mDevOptionsDialog = null;
                }
            }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                public void onCancel(DialogInterface dialogInterface) {
                    AlertDialog unused = DevSupportManagerBase.this.mDevOptionsDialog = null;
                }
            }).create();
            this.mDevOptionsDialog = create;
            create.show();
            ReactContext reactContext = this.mCurrentContext;
            if (reactContext != null) {
                ((RCTNativeAppEventEmitter) reactContext.getJSModule(RCTNativeAppEventEmitter.class)).emit("RCTDevMenuShown", (Object) null);
            }
        }
    }

    public void setDevSupportEnabled(boolean z) {
        this.mIsDevSupportEnabled = z;
        reloadSettings();
    }

    public boolean getDevSupportEnabled() {
        return this.mIsDevSupportEnabled;
    }

    public DevInternalSettings getDevSettings() {
        return this.mDevSettings;
    }

    public RedBoxHandler getRedBoxHandler() {
        return this.mRedBoxHandler;
    }

    public void onNewReactContextCreated(ReactContext reactContext) {
        resetCurrentContext(reactContext);
    }

    public void onReactInstanceDestroyed(ReactContext reactContext) {
        if (reactContext == this.mCurrentContext) {
            resetCurrentContext((ReactContext) null);
        }
    }

    public String getSourceMapUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceMapUrl((String) Assertions.assertNotNull(str));
    }

    public String getSourceUrl() {
        String str = this.mJSAppBundleName;
        if (str == null) {
            return "";
        }
        return this.mDevServerHelper.getSourceUrl((String) Assertions.assertNotNull(str));
    }

    public String getJSBundleURLForRemoteDebugging() {
        return this.mDevServerHelper.getJSBundleURLForRemoteDebugging((String) Assertions.assertNotNull(this.mJSAppBundleName));
    }

    public String getDownloadedJSBundleFile() {
        return this.mJSBundleDownloadedFile.getAbsolutePath();
    }

    public boolean hasUpToDateJSBundleInCache() {
        if (this.mIsDevSupportEnabled && this.mJSBundleDownloadedFile.exists()) {
            try {
                String packageName = this.mApplicationContext.getPackageName();
                if (this.mJSBundleDownloadedFile.lastModified() > this.mApplicationContext.getPackageManager().getPackageInfo(packageName, 0).lastUpdateTime) {
                    File file = new File(String.format(Locale.US, EXOPACKAGE_LOCATION_FORMAT, new Object[]{packageName}));
                    if (!file.exists()) {
                        return true;
                    }
                    if (this.mJSBundleDownloadedFile.lastModified() > file.lastModified()) {
                        return true;
                    }
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
                FLog.e(ReactConstants.TAG, "DevSupport is unable to get current app info");
            }
        }
        return false;
    }

    private void resetCurrentContext(ReactContext reactContext) {
        if (this.mCurrentContext != reactContext) {
            this.mCurrentContext = reactContext;
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(false);
            }
            if (reactContext != null) {
                this.mDebugOverlayController = new DebugOverlayController(reactContext);
            }
            if (this.mCurrentContext != null) {
                try {
                    URL url = new URL(getSourceUrl());
                    ((HMRClient) this.mCurrentContext.getJSModule(HMRClient.class)).setup("android", url.getPath().substring(1), url.getHost(), url.getPort() != -1 ? url.getPort() : url.getDefaultPort(), this.mDevSettings.isHotModuleReplacementEnabled());
                } catch (MalformedURLException e) {
                    showNewJavaError(e.getMessage(), e);
                }
            }
            reloadSettings();
        }
    }

    public void reloadSettings() {
        if (UiThreadUtil.isOnUiThread()) {
            reload();
        } else {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerBase.this.reload();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public ReactContext getCurrentContext() {
        return this.mCurrentContext;
    }

    /* access modifiers changed from: protected */
    public String getJSAppBundleName() {
        return this.mJSAppBundleName;
    }

    /* access modifiers changed from: protected */
    public Context getApplicationContext() {
        return this.mApplicationContext;
    }

    /* access modifiers changed from: protected */
    public DevServerHelper getDevServerHelper() {
        return this.mDevServerHelper;
    }

    /* access modifiers changed from: protected */
    public ReactInstanceDevHelper getReactInstanceDevHelper() {
        return this.mReactInstanceDevHelper;
    }

    private void showDevLoadingViewForUrl(String str) {
        this.mDevLoadingViewController.showForUrl(str);
        this.mDevLoadingViewVisible = true;
    }

    /* access modifiers changed from: protected */
    public void showDevLoadingViewForRemoteJSEnabled() {
        this.mDevLoadingViewController.showForRemoteJSEnabled();
        this.mDevLoadingViewVisible = true;
    }

    /* access modifiers changed from: protected */
    public void hideDevLoadingView() {
        this.mDevLoadingViewController.hide();
        this.mDevLoadingViewVisible = false;
    }

    public void fetchSplitBundleAndCreateBundleLoader(String str, final CallbackWithBundleLoader callbackWithBundleLoader) {
        final String devServerSplitBundleURL = this.mDevServerHelper.getDevServerSplitBundleURL(str);
        final File file = new File(this.mJSSplitBundlesDir, str.replaceAll("/", "_") + ".jsbundle");
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                DevSupportManagerBase.this.showSplitBundleDevLoadingView(devServerSplitBundleURL);
                DevSupportManagerBase.this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
                    public void onSuccess() {
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            public void run() {
                                DevSupportManagerBase.this.hideSplitBundleDevLoadingView();
                            }
                        });
                        ReactContext access$800 = DevSupportManagerBase.this.mCurrentContext;
                        if (access$800 != null && access$800.hasActiveReactInstance()) {
                            callbackWithBundleLoader.onSuccess(JSBundleLoader.createCachedSplitBundleFromNetworkLoader(devServerSplitBundleURL, file.getAbsolutePath()));
                        }
                    }

                    public void onProgress(String str, Integer num, Integer num2) {
                        DevSupportManagerBase.this.mDevLoadingViewController.updateProgress(str, num, num2);
                    }

                    public void onFailure(Exception exc) {
                        UiThreadUtil.runOnUiThread(new Runnable() {
                            public void run() {
                                DevSupportManagerBase.this.hideSplitBundleDevLoadingView();
                            }
                        });
                        callbackWithBundleLoader.onError(devServerSplitBundleURL, exc);
                    }
                }, file, devServerSplitBundleURL, (BundleDownloader.BundleInfo) null);
            }
        });
    }

    /* access modifiers changed from: private */
    public void showSplitBundleDevLoadingView(String str) {
        showDevLoadingViewForUrl(str);
        this.mPendingJSSplitBundleRequests++;
    }

    /* access modifiers changed from: private */
    public void hideSplitBundleDevLoadingView() {
        int i = this.mPendingJSSplitBundleRequests - 1;
        this.mPendingJSSplitBundleRequests = i;
        if (i == 0) {
            hideDevLoadingView();
        }
    }

    public void isPackagerRunning(final PackagerStatusCallback packagerStatusCallback) {
        AnonymousClass19 r0 = new Runnable() {
            public void run() {
                DevSupportManagerBase.this.mDevServerHelper.isPackagerRunning(packagerStatusCallback);
            }
        };
        DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer = this.mPackagerLocationCustomizer;
        if (packagerLocationCustomizer != null) {
            packagerLocationCustomizer.run(r0);
        } else {
            r0.run();
        }
    }

    public File downloadBundleResourceFromUrlSync(String str, File file) {
        return this.mDevServerHelper.downloadBundleResourceFromUrlSync(str, file);
    }

    public String getLastErrorTitle() {
        return this.mLastErrorTitle;
    }

    public StackFrame[] getLastErrorStack() {
        return this.mLastErrorStack;
    }

    public int getLastErrorCookie() {
        return this.mLastErrorCookie;
    }

    public ErrorType getLastErrorType() {
        return this.mLastErrorType;
    }

    /* access modifiers changed from: private */
    public void handleCaptureHeap(final Responder responder) {
        JSCHeapCapture jSCHeapCapture;
        ReactContext reactContext = this.mCurrentContext;
        if (reactContext != null && (jSCHeapCapture = (JSCHeapCapture) reactContext.getNativeModule(JSCHeapCapture.class)) != null) {
            jSCHeapCapture.captureHeap(this.mApplicationContext.getCacheDir().getPath(), new JSCHeapCapture.CaptureCallback() {
                public void onSuccess(File file) {
                    responder.respond(file.toString());
                }

                public void onFailure(JSCHeapCapture.CaptureException captureException) {
                    responder.error(captureException.toString());
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void updateLastErrorInfo(String str, StackFrame[] stackFrameArr, int i, ErrorType errorType) {
        this.mLastErrorTitle = str;
        this.mLastErrorStack = stackFrameArr;
        this.mLastErrorCookie = i;
        this.mLastErrorType = errorType;
    }

    public void reloadJSFromServer(String str) {
        reloadJSFromServer(str, new BundleLoadCallback() {
            public void onSuccess() {
                UiThreadUtil.runOnUiThread(new Runnable() {
                    public void run() {
                        DevSupportManagerBase.this.mReactInstanceDevHelper.onJSBundleLoadedFromServer();
                    }
                });
            }
        });
    }

    public void reloadJSFromServer(String str, final BundleLoadCallback bundleLoadCallback) {
        ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_START);
        showDevLoadingViewForUrl(str);
        final BundleDownloader.BundleInfo bundleInfo = new BundleDownloader.BundleInfo();
        this.mDevServerHelper.downloadBundleFromURL(new DevBundleDownloadListener() {
            public void onSuccess() {
                DevSupportManagerBase.this.hideDevLoadingView();
                synchronized (DevSupportManagerBase.this) {
                    DevSupportManagerBase.this.mBundleStatus.isLastDownloadSucess = true;
                    DevSupportManagerBase.this.mBundleStatus.updateTimestamp = System.currentTimeMillis();
                }
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onSuccess();
                }
                ReactMarker.logMarker(ReactMarkerConstants.DOWNLOAD_END, bundleInfo.toJSONString());
                bundleLoadCallback.onSuccess();
            }

            public void onProgress(String str, Integer num, Integer num2) {
                DevSupportManagerBase.this.mDevLoadingViewController.updateProgress(str, num, num2);
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onProgress(str, num, num2);
                }
            }

            public void onFailure(Exception exc) {
                DevSupportManagerBase.this.hideDevLoadingView();
                synchronized (DevSupportManagerBase.this) {
                    DevSupportManagerBase.this.mBundleStatus.isLastDownloadSucess = false;
                }
                if (DevSupportManagerBase.this.mBundleDownloadListener != null) {
                    DevSupportManagerBase.this.mBundleDownloadListener.onFailure(exc);
                }
                FLog.e(ReactConstants.TAG, "Unable to download JS bundle", (Throwable) exc);
                DevSupportManagerBase.this.reportBundleLoadingFailure(exc);
            }
        }, this.mJSBundleDownloadedFile, str, bundleInfo);
    }

    /* access modifiers changed from: private */
    public void reportBundleLoadingFailure(final Exception exc) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            public void run() {
                Exception exc = exc;
                if (exc instanceof DebugServerException) {
                    DevSupportManagerBase.this.showNewJavaError(((DebugServerException) exc).getMessage(), exc);
                    return;
                }
                DevSupportManagerBase devSupportManagerBase = DevSupportManagerBase.this;
                devSupportManagerBase.showNewJavaError(devSupportManagerBase.mApplicationContext.getString(R.string.catalyst_reload_error), exc);
            }
        });
    }

    public void startInspector() {
        if (this.mIsDevSupportEnabled) {
            this.mDevServerHelper.openInspectorConnection();
        }
    }

    public void stopInspector() {
        this.mDevServerHelper.closeInspectorConnection();
    }

    public void setHotModuleReplacementEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setHotModuleReplacementEnabled(z);
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
        }
    }

    public void setRemoteJSDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setRemoteJSDebugEnabled(z);
                    DevSupportManagerBase.this.handleReloadJS();
                }
            });
        }
    }

    public void setFpsDebugEnabled(final boolean z) {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setFpsDebugEnabled(z);
                }
            });
        }
    }

    public void toggleElementInspector() {
        if (this.mIsDevSupportEnabled) {
            UiThreadUtil.runOnUiThread(new Runnable() {
                public void run() {
                    DevSupportManagerBase.this.mDevSettings.setElementInspectorEnabled(!DevSupportManagerBase.this.mDevSettings.isElementInspectorEnabled());
                    DevSupportManagerBase.this.mReactInstanceDevHelper.toggleElementInspector();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public void reload() {
        UiThreadUtil.assertOnUiThread();
        if (this.mIsDevSupportEnabled) {
            DebugOverlayController debugOverlayController = this.mDebugOverlayController;
            if (debugOverlayController != null) {
                debugOverlayController.setFpsDebugViewVisible(this.mDevSettings.isFpsDebugEnabled());
            }
            if (!this.mIsShakeDetectorStarted) {
                this.mShakeDetector.start((SensorManager) this.mApplicationContext.getSystemService("sensor"));
                this.mIsShakeDetectorStarted = true;
            }
            if (!this.mIsReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction(getReloadAppAction(this.mApplicationContext));
                compatRegisterReceiver(this.mApplicationContext, this.mReloadAppBroadcastReceiver, intentFilter, true);
                this.mIsReceiverRegistered = true;
            }
            if (this.mDevLoadingViewVisible) {
                this.mDevLoadingViewController.showMessage("Reloading...");
            }
            this.mDevServerHelper.openPackagerConnection(getClass().getSimpleName(), new DevServerHelper.PackagerCommandListener() {
                public void onPackagerConnected() {
                }

                public void onPackagerDisconnected() {
                }

                public void onPackagerReloadCommand() {
                    DevSupportManagerBase.this.mDevServerHelper.disableDebugger();
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            DevSupportManagerBase.this.handleReloadJS();
                        }
                    });
                }

                public void onPackagerDevMenuCommand() {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            DevSupportManagerBase.this.showDevOptionsDialog();
                        }
                    });
                }

                public void onCaptureHeapCommand(final Responder responder) {
                    UiThreadUtil.runOnUiThread(new Runnable() {
                        public void run() {
                            DevSupportManagerBase.this.handleCaptureHeap(responder);
                        }
                    });
                }

                public Map<String, RequestHandler> customCommandHandlers() {
                    return DevSupportManagerBase.this.mCustomPackagerCommandHandlers;
                }
            });
            return;
        }
        DebugOverlayController debugOverlayController2 = this.mDebugOverlayController;
        if (debugOverlayController2 != null) {
            debugOverlayController2.setFpsDebugViewVisible(false);
        }
        if (this.mIsShakeDetectorStarted) {
            this.mShakeDetector.stop();
            this.mIsShakeDetectorStarted = false;
        }
        if (this.mIsReceiverRegistered) {
            this.mApplicationContext.unregisterReceiver(this.mReloadAppBroadcastReceiver);
            this.mIsReceiverRegistered = false;
        }
        hideRedboxDialog();
        hideDevOptionsDialog();
        this.mDevLoadingViewController.hide();
        this.mDevServerHelper.closePackagerConnection();
    }

    /* access modifiers changed from: private */
    public static String getReloadAppAction(Context context) {
        return context.getPackageName() + RELOAD_APP_ACTION_SUFFIX;
    }

    public void setPackagerLocationCustomizer(DevSupportManager.PackagerLocationCustomizer packagerLocationCustomizer) {
        this.mPackagerLocationCustomizer = packagerLocationCustomizer;
    }

    public Activity getCurrentActivity() {
        return this.mReactInstanceDevHelper.getCurrentActivity();
    }

    public SurfaceDelegate createSurfaceDelegate(String str) {
        SurfaceDelegateFactory surfaceDelegateFactory = this.mSurfaceDelegateFactory;
        if (surfaceDelegateFactory == null) {
            return null;
        }
        return surfaceDelegateFactory.createSurfaceDelegate(str);
    }

    private void compatRegisterReceiver(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, boolean z) {
        if (Build.VERSION.SDK_INT < 34 || context.getApplicationInfo().targetSdkVersion < 34) {
            context.registerReceiver(broadcastReceiver, intentFilter);
        } else {
            context.registerReceiver(broadcastReceiver, intentFilter, z ? 2 : 4);
        }
    }
}
