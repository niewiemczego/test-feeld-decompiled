package com.facebook.react.devsupport;

import android.content.Context;
import android.widget.Toast;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.R;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JavaJSExecutor;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.common.SurfaceDelegateFactory;
import com.facebook.react.common.futures.SimpleSettableFuture;
import com.facebook.react.devsupport.DevSupportManagerBase;
import com.facebook.react.devsupport.WebsocketJavaScriptExecutor;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevOptionHandler;
import com.facebook.react.devsupport.interfaces.DevSplitBundleCallback;
import com.facebook.react.devsupport.interfaces.RedBoxHandler;
import com.facebook.react.packagerconnection.RequestHandler;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BridgeDevSupportManager extends DevSupportManagerBase {
    private boolean mIsSamplingProfilerEnabled = false;

    /* access modifiers changed from: protected */
    public String getUniqueTag() {
        return "Bridge";
    }

    public BridgeDevSupportManager(Context context, ReactInstanceDevHelper reactInstanceDevHelper, String str, boolean z, RedBoxHandler redBoxHandler, DevBundleDownloadListener devBundleDownloadListener, int i, Map<String, RequestHandler> map, SurfaceDelegateFactory surfaceDelegateFactory) {
        super(context, reactInstanceDevHelper, str, z, redBoxHandler, devBundleDownloadListener, i, map, surfaceDelegateFactory);
        String str2;
        if (getDevSettings().isStartSamplingProfilerOnInit()) {
            if (!this.mIsSamplingProfilerEnabled) {
                toggleJSSamplingProfiler();
            } else {
                Toast.makeText(context, "JS Sampling Profiler was already running, so did not start the sampling profiler", 1).show();
            }
        }
        addCustomDevOption(this.mIsSamplingProfilerEnabled ? "Disable Sampling Profiler" : "Enable Sampling Profiler", new DevOptionHandler() {
            public void onOptionSelected() {
                BridgeDevSupportManager.this.toggleJSSamplingProfiler();
            }
        });
        if (!getDevSettings().isDeviceDebugEnabled()) {
            if (getDevSettings().isRemoteJSDebugEnabled()) {
                str2 = context.getString(R.string.catalyst_debug_stop);
            } else {
                str2 = context.getString(R.string.catalyst_debug);
            }
            addCustomDevOption(str2, new DevOptionHandler() {
                public void onOptionSelected() {
                    BridgeDevSupportManager.this.getDevSettings().setRemoteJSDebugEnabled(!BridgeDevSupportManager.this.getDevSettings().isRemoteJSDebugEnabled());
                    BridgeDevSupportManager.this.handleReloadJS();
                }
            });
        }
    }

    public void loadSplitBundleFromServer(final String str, final DevSplitBundleCallback devSplitBundleCallback) {
        fetchSplitBundleAndCreateBundleLoader(str, new DevSupportManagerBase.CallbackWithBundleLoader() {
            public void onSuccess(JSBundleLoader jSBundleLoader) {
                jSBundleLoader.loadScript(BridgeDevSupportManager.this.getCurrentContext().getCatalystInstance());
                ((HMRClient) BridgeDevSupportManager.this.getCurrentContext().getJSModule(HMRClient.class)).registerBundle(BridgeDevSupportManager.this.getDevServerHelper().getDevServerSplitBundleURL(str));
                devSplitBundleCallback.onSuccess();
            }

            public void onError(String str, Throwable th) {
                devSplitBundleCallback.onError(str, th);
            }
        });
    }

    /* access modifiers changed from: private */
    public WebsocketJavaScriptExecutor.JSExecutorConnectCallback getExecutorConnectCallback(final SimpleSettableFuture<Boolean> simpleSettableFuture) {
        return new WebsocketJavaScriptExecutor.JSExecutorConnectCallback() {
            public void onSuccess() {
                simpleSettableFuture.set(true);
                BridgeDevSupportManager.this.hideDevLoadingView();
            }

            public void onFailure(Throwable th) {
                BridgeDevSupportManager.this.hideDevLoadingView();
                FLog.e(ReactConstants.TAG, "Failed to connect to debugger!", th);
                simpleSettableFuture.setException(new IOException(BridgeDevSupportManager.this.getApplicationContext().getString(R.string.catalyst_debug_error), th));
            }
        };
    }

    private void reloadJSInProxyMode() {
        getDevServerHelper().launchJSDevtools();
        getReactInstanceDevHelper().onReloadWithJSDebugger(new JavaJSExecutor.Factory() {
            public JavaJSExecutor create() throws Exception {
                WebsocketJavaScriptExecutor websocketJavaScriptExecutor = new WebsocketJavaScriptExecutor();
                SimpleSettableFuture simpleSettableFuture = new SimpleSettableFuture();
                websocketJavaScriptExecutor.connect(BridgeDevSupportManager.this.getDevServerHelper().getWebsocketProxyURL(), BridgeDevSupportManager.this.getExecutorConnectCallback(simpleSettableFuture));
                try {
                    simpleSettableFuture.get(90, TimeUnit.SECONDS);
                    return websocketJavaScriptExecutor;
                } catch (ExecutionException e) {
                    throw ((Exception) e.getCause());
                } catch (InterruptedException | TimeoutException e2) {
                    throw new RuntimeException(e2);
                }
            }
        });
    }

    public void handleReloadJS() {
        UiThreadUtil.assertOnUiThread();
        ReactMarker.logMarker(ReactMarkerConstants.RELOAD, getDevSettings().getPackagerConnectionSettings().getDebugServerHost());
        hideRedboxDialog();
        if (getDevSettings().isRemoteJSDebugEnabled()) {
            PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Proxy");
            showDevLoadingViewForRemoteJSEnabled();
            reloadJSInProxyMode();
            return;
        }
        PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from Server");
        reloadJSFromServer(getDevServerHelper().getDevServerBundleURL((String) Assertions.assertNotNull(getJSAppBundleName())));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0022, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        android.widget.Toast.makeText(getApplicationContext(), r0.toString() + " does not support Sampling Profiler", 1).show();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0047, code lost:
        r7.mIsSamplingProfilerEnabled = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0049, code lost:
        throw r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x0082 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toggleJSSamplingProfiler() {
        /*
            r7 = this;
            com.facebook.react.devsupport.ReactInstanceDevHelper r0 = r7.getReactInstanceDevHelper()
            com.facebook.react.bridge.JavaScriptExecutorFactory r0 = r0.getJavaScriptExecutorFactory()
            boolean r1 = r7.mIsSamplingProfilerEnabled
            r2 = 0
            r3 = 1
            if (r1 != 0) goto L_0x004a
            r0.startSamplingProfiler()     // Catch:{ UnsupportedOperationException -> 0x0024 }
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ UnsupportedOperationException -> 0x0024 }
            java.lang.String r4 = "Starting Sampling Profiler"
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r4, r2)     // Catch:{ UnsupportedOperationException -> 0x0024 }
            r1.show()     // Catch:{ UnsupportedOperationException -> 0x0024 }
        L_0x001e:
            r7.mIsSamplingProfilerEnabled = r3
            goto L_0x00ae
        L_0x0022:
            r0 = move-exception
            goto L_0x0047
        L_0x0024:
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0022 }
            r2.<init>()     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0022 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0022 }
            java.lang.String r2 = " does not support Sampling Profiler"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0022 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0022 }
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)     // Catch:{ all -> 0x0022 }
            r0.show()     // Catch:{ all -> 0x0022 }
            goto L_0x001e
        L_0x0047:
            r7.mIsSamplingProfilerEnabled = r3
            throw r0
        L_0x004a:
            java.lang.String r1 = "sampling-profiler-trace"
            java.lang.String r4 = ".cpuprofile"
            android.content.Context r5 = r7.getApplicationContext()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.io.File r5 = r5.getCacheDir()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.io.File r1 = java.io.File.createTempFile(r1, r4, r5)     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.lang.String r1 = r1.getPath()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            r0.stopSamplingProfiler(r1)     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            android.content.Context r4 = r7.getApplicationContext()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            r5.<init>()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.lang.String r6 = "Saved results from Profiler to "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.lang.StringBuilder r1 = r5.append(r1)     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            java.lang.String r1 = r1.toString()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            android.widget.Toast r1 = android.widget.Toast.makeText(r4, r1, r3)     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            r1.show()     // Catch:{ IOException -> 0x00a5, UnsupportedOperationException -> 0x0082 }
            goto L_0x00ac
        L_0x0080:
            r0 = move-exception
            goto L_0x00af
        L_0x0082:
            android.content.Context r1 = r7.getApplicationContext()     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0080 }
            r4.<init>()     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0080 }
            java.lang.StringBuilder r0 = r4.append(r0)     // Catch:{ all -> 0x0080 }
            java.lang.String r4 = "does not support Sampling Profiler"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch:{ all -> 0x0080 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0080 }
            android.widget.Toast r0 = android.widget.Toast.makeText(r1, r0, r3)     // Catch:{ all -> 0x0080 }
            r0.show()     // Catch:{ all -> 0x0080 }
            goto L_0x00ac
        L_0x00a5:
            java.lang.String r0 = "ReactNative"
            java.lang.String r1 = "Could not create temporary file for saving results from Sampling Profiler"
            com.facebook.common.logging.FLog.e((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x0080 }
        L_0x00ac:
            r7.mIsSamplingProfilerEnabled = r2
        L_0x00ae:
            return
        L_0x00af:
            r7.mIsSamplingProfilerEnabled = r2
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.BridgeDevSupportManager.toggleJSSamplingProfiler():void");
    }
}
