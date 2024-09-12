package com.facebook.react.devsupport;

import android.content.Context;
import android.os.AsyncTask;
import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.facebook.common.logging.FLog;
import com.facebook.hermes.intl.Constants;
import com.facebook.infer.annotation.Assertions;
import com.facebook.internal.ServerProtocol;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.devsupport.BundleDownloader;
import com.facebook.react.devsupport.InspectorPackagerConnection;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.devsupport.interfaces.StackFrame;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.FileIoHandler;
import com.facebook.react.packagerconnection.JSPackagerClient;
import com.facebook.react.packagerconnection.NotificationOnlyHandler;
import com.facebook.react.packagerconnection.ReconnectingWebSocket;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.packagerconnection.RequestOnlyHandler;
import com.facebook.react.packagerconnection.Responder;
import com.facebook.react.util.RNLog;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DevServerHelper {
    private static final String DEBUGGER_MSG_DISABLE = "{ \"id\":1,\"method\":\"Debugger.disable\" }";
    private static final int HTTP_CONNECT_TIMEOUT_MS = 5000;
    public static final String RELOAD_APP_EXTRA_JS_PROXY = "jsproxy";
    private final BundleDownloader mBundleDownloader;
    /* access modifiers changed from: private */
    public InspectorPackagerConnection.BundleStatusProvider mBundlerStatusProvider;
    private final OkHttpClient mClient;
    /* access modifiers changed from: private */
    public InspectorPackagerConnection mInspectorPackagerConnection;
    /* access modifiers changed from: private */
    public final String mPackageName;
    /* access modifiers changed from: private */
    public JSPackagerClient mPackagerClient;
    private final PackagerStatusCheck mPackagerStatusCheck;
    /* access modifiers changed from: private */
    public final DevInternalSettings mSettings;

    public interface OnServerContentChangeListener {
        void onServerContentChanged();
    }

    public interface PackagerCommandListener {
        Map<String, RequestHandler> customCommandHandlers();

        void onCaptureHeapCommand(Responder responder);

        void onPackagerConnected();

        void onPackagerDevMenuCommand();

        void onPackagerDisconnected();

        void onPackagerReloadCommand();
    }

    public interface PackagerCustomCommandProvider {
    }

    public interface SymbolicationListener {
        void onSymbolicationComplete(Iterable<StackFrame> iterable);
    }

    private enum BundleType {
        BUNDLE("bundle"),
        MAP(AdaptyImmutableMapTypeAdapterFactory.MAP);
        
        private final String mTypeID;

        private BundleType(String str) {
            this.mTypeID = str;
        }

        public String typeID() {
            return this.mTypeID;
        }
    }

    public DevServerHelper(DevInternalSettings devInternalSettings, String str, InspectorPackagerConnection.BundleStatusProvider bundleStatusProvider) {
        this.mSettings = devInternalSettings;
        this.mBundlerStatusProvider = bundleStatusProvider;
        OkHttpClient build = new OkHttpClient.Builder().connectTimeout(5000, TimeUnit.MILLISECONDS).readTimeout(0, TimeUnit.MILLISECONDS).writeTimeout(0, TimeUnit.MILLISECONDS).build();
        this.mClient = build;
        this.mBundleDownloader = new BundleDownloader(build);
        this.mPackagerStatusCheck = new PackagerStatusCheck(build);
        this.mPackageName = str;
    }

    public void openPackagerConnection(final String str, final PackagerCommandListener packagerCommandListener) {
        if (this.mPackagerClient != null) {
            FLog.w(ReactConstants.TAG, "Packager connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("reload", new NotificationOnlyHandler() {
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerReloadCommand();
                        }
                    });
                    hashMap.put("devMenu", new NotificationOnlyHandler() {
                        public void onNotification(Object obj) {
                            packagerCommandListener.onPackagerDevMenuCommand();
                        }
                    });
                    hashMap.put("captureHeap", new RequestOnlyHandler() {
                        public void onRequest(Object obj, Responder responder) {
                            packagerCommandListener.onCaptureHeapCommand(responder);
                        }
                    });
                    Map<String, RequestHandler> customCommandHandlers = packagerCommandListener.customCommandHandlers();
                    if (customCommandHandlers != null) {
                        hashMap.putAll(customCommandHandlers);
                    }
                    hashMap.putAll(new FileIoHandler().handlers());
                    JSPackagerClient unused = DevServerHelper.this.mPackagerClient = new JSPackagerClient(str, DevServerHelper.this.mSettings.getPackagerConnectionSettings(), hashMap, new ReconnectingWebSocket.ConnectionCallback() {
                        public void onConnected() {
                            packagerCommandListener.onPackagerConnected();
                        }

                        public void onDisconnected() {
                            packagerCommandListener.onPackagerDisconnected();
                        }
                    });
                    DevServerHelper.this.mPackagerClient.init();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void closePackagerConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mPackagerClient != null) {
                    DevServerHelper.this.mPackagerClient.close();
                    JSPackagerClient unused = DevServerHelper.this.mPackagerClient = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void openInspectorConnection() {
        if (this.mInspectorPackagerConnection != null) {
            FLog.w(ReactConstants.TAG, "Inspector connection already open, nooping.");
        } else {
            new AsyncTask<Void, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(Void... voidArr) {
                    InspectorPackagerConnection unused = DevServerHelper.this.mInspectorPackagerConnection = new InspectorPackagerConnection(DevServerHelper.this.getInspectorDeviceUrl(), DevServerHelper.this.mPackageName, DevServerHelper.this.mBundlerStatusProvider);
                    DevServerHelper.this.mInspectorPackagerConnection.connect();
                    return null;
                }
            }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        }
    }

    public void disableDebugger() {
        InspectorPackagerConnection inspectorPackagerConnection = this.mInspectorPackagerConnection;
        if (inspectorPackagerConnection != null) {
            inspectorPackagerConnection.sendEventToAllConnections(DEBUGGER_MSG_DISABLE);
        }
    }

    public void closeInspectorConnection() {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                if (DevServerHelper.this.mInspectorPackagerConnection != null) {
                    DevServerHelper.this.mInspectorPackagerConnection.closeQuietly();
                    InspectorPackagerConnection unused = DevServerHelper.this.mInspectorPackagerConnection = null;
                }
                return null;
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void openUrl(final ReactContext reactContext, final String str, final String str2) {
        new AsyncTask<Void, String, Boolean>() {
            /* access modifiers changed from: protected */
            public Boolean doInBackground(Void... voidArr) {
                return Boolean.valueOf(doSync());
            }

            public boolean doSync() {
                try {
                    String access$600 = DevServerHelper.this.getOpenUrlEndpoint(reactContext);
                    new OkHttpClient().newCall(new Request.Builder().url(access$600).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("url", (Object) str).toString())).build()).execute();
                    return true;
                } catch (IOException | JSONException e) {
                    FLog.e(ReactConstants.TAG, "Failed to open URL" + str, e);
                    return false;
                }
            }

            /* access modifiers changed from: protected */
            public void onPostExecute(Boolean bool) {
                if (!bool.booleanValue()) {
                    RNLog.w(reactContext, str2);
                }
            }
        }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void symbolicateStackTrace(Iterable<StackFrame> iterable, final SymbolicationListener symbolicationListener) {
        try {
            String createSymbolicateURL = createSymbolicateURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
            JSONArray jSONArray = new JSONArray();
            for (StackFrame json : iterable) {
                jSONArray.put((Object) json.toJSON());
            }
            ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createSymbolicateURL).post(RequestBody.create(MediaType.parse("application/json"), new JSONObject().put("stack", (Object) jSONArray).toString())).build()))).enqueue(new Callback() {
                public void onFailure(Call call, IOException iOException) {
                    FLog.w(ReactConstants.TAG, "Got IOException when attempting symbolicate stack trace: " + iOException.getMessage());
                    symbolicationListener.onSymbolicationComplete((Iterable<StackFrame>) null);
                }

                public void onResponse(Call call, Response response) throws IOException {
                    try {
                        symbolicationListener.onSymbolicationComplete(Arrays.asList(StackTraceHelper.convertJsStackTrace(new JSONObject(response.body().string()).getJSONArray("stack"))));
                    } catch (JSONException unused) {
                        symbolicationListener.onSymbolicationComplete((Iterable<StackFrame>) null);
                    }
                }
            });
        } catch (JSONException e) {
            FLog.w(ReactConstants.TAG, "Got JSONException when attempting symbolicate stack trace: " + e.getMessage());
        }
    }

    public void openStackFrameCall(StackFrame stackFrame) {
        ((Call) Assertions.assertNotNull(this.mClient.newCall(new Request.Builder().url(createOpenStackFrameURL(this.mSettings.getPackagerConnectionSettings().getDebugServerHost())).post(RequestBody.create(MediaType.parse("application/json"), stackFrame.toJSON().toString())).build()))).enqueue(new Callback() {
            public void onResponse(Call call, Response response) throws IOException {
            }

            public void onFailure(Call call, IOException iOException) {
                FLog.w(ReactConstants.TAG, "Got IOException when attempting to open stack frame: " + iOException.getMessage());
            }
        });
    }

    public String getWebsocketProxyURL() {
        return String.format(Locale.US, "ws://%s/debugger-proxy?role=client", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    /* access modifiers changed from: private */
    public String getInspectorDeviceUrl() {
        return String.format(Locale.US, "http://%s/inspector/device?name=%s&app=%s", new Object[]{this.mSettings.getPackagerConnectionSettings().getInspectorServerHost(), AndroidInfoHelpers.getFriendlyDeviceName(), this.mPackageName});
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo);
    }

    /* access modifiers changed from: private */
    public String getOpenUrlEndpoint(Context context) {
        return String.format(Locale.US, "http://%s/open-url", new Object[]{AndroidInfoHelpers.getServerHost(context)});
    }

    public void downloadBundleFromURL(DevBundleDownloadListener devBundleDownloadListener, File file, String str, BundleDownloader.BundleInfo bundleInfo, Request.Builder builder) {
        this.mBundleDownloader.downloadBundleFromURL(devBundleDownloadListener, file, str, bundleInfo, builder);
    }

    private String getHostForJSProxy() {
        String str = (String) Assertions.assertNotNull(this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
        int lastIndexOf = str.lastIndexOf(58);
        if (lastIndexOf > -1) {
            return AndroidInfoHelpers.DEVICE_LOCALHOST + str.substring(lastIndexOf);
        }
        return AndroidInfoHelpers.DEVICE_LOCALHOST;
    }

    private boolean getDevMode() {
        return this.mSettings.isJSDevModeEnabled();
    }

    private boolean getJSMinifyMode() {
        return this.mSettings.isJSMinifyEnabled();
    }

    private String createBundleURL(String str, BundleType bundleType, String str2) {
        return createBundleURL(str, bundleType, str2, false, true);
    }

    private String createSplitBundleURL(String str, String str2) {
        return createBundleURL(str, BundleType.BUNDLE, str2, true, false);
    }

    private String createBundleURL(String str, BundleType bundleType, String str2, boolean z, boolean z2) {
        Locale locale = Locale.US;
        Object[] objArr = new Object[9];
        objArr[0] = str2;
        objArr[1] = str;
        objArr[2] = bundleType.typeID();
        objArr[3] = Boolean.valueOf(getDevMode());
        objArr[4] = Boolean.valueOf(getJSMinifyMode());
        objArr[5] = this.mPackageName;
        String str3 = ServerProtocol.DIALOG_RETURN_SCOPES_TRUE;
        objArr[6] = z ? str3 : Constants.CASEFIRST_FALSE;
        if (!z2) {
            str3 = Constants.CASEFIRST_FALSE;
        }
        objArr[7] = str3;
        objArr[8] = "";
        return String.format(locale, "http://%s/%s.%s?platform=android&dev=%s&minify=%s&app=%s&modulesOnly=%s&runModule=%s%s", objArr);
    }

    private String createBundleURL(String str, BundleType bundleType) {
        return createBundleURL(str, bundleType, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    private static String createResourceURL(String str, String str2) {
        return String.format(Locale.US, "http://%s/%s", new Object[]{str, str2});
    }

    private static String createSymbolicateURL(String str) {
        return String.format(Locale.US, "http://%s/symbolicate", new Object[]{str});
    }

    private static String createOpenStackFrameURL(String str) {
        return String.format(Locale.US, "http://%s/open-stack-frame", new Object[]{str});
    }

    public String getDevServerBundleURL(String str) {
        return createBundleURL(str, BundleType.BUNDLE, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public String getDevServerSplitBundleURL(String str) {
        return createSplitBundleURL(str, this.mSettings.getPackagerConnectionSettings().getDebugServerHost());
    }

    public void isPackagerRunning(PackagerStatusCallback packagerStatusCallback) {
        String debugServerHost = this.mSettings.getPackagerConnectionSettings().getDebugServerHost();
        if (debugServerHost == null) {
            FLog.w(ReactConstants.TAG, "No packager host configured.");
            packagerStatusCallback.onPackagerStatusFetched(false);
            return;
        }
        this.mPackagerStatusCheck.run(debugServerHost, packagerStatusCallback);
    }

    private String createLaunchJSDevtoolsCommandUrl() {
        return String.format(Locale.US, "http://%s/launch-js-devtools", new Object[]{this.mSettings.getPackagerConnectionSettings().getDebugServerHost()});
    }

    public void launchJSDevtools() {
        this.mClient.newCall(new Request.Builder().url(createLaunchJSDevtoolsCommandUrl()).build()).enqueue(new Callback() {
            public void onFailure(Call call, IOException iOException) {
            }

            public void onResponse(Call call, Response response) throws IOException {
            }
        });
    }

    public String getSourceMapUrl(String str) {
        return createBundleURL(str, BundleType.MAP);
    }

    public String getSourceUrl(String str) {
        return createBundleURL(str, BundleType.BUNDLE);
    }

    public String getJSBundleURLForRemoteDebugging(String str) {
        return createBundleURL(str, BundleType.BUNDLE, getHostForJSProxy());
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0056 A[SYNTHETIC, Splitter:B:25:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.io.File downloadBundleResourceFromUrlSync(java.lang.String r5, java.io.File r6) {
        /*
            r4 = this;
            com.facebook.react.devsupport.DevInternalSettings r0 = r4.mSettings
            com.facebook.react.packagerconnection.PackagerConnectionSettings r0 = r0.getPackagerConnectionSettings()
            java.lang.String r0 = r0.getDebugServerHost()
            java.lang.String r0 = createResourceURL(r0, r5)
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            okhttp3.Request$Builder r0 = r1.url((java.lang.String) r0)
            okhttp3.Request r0 = r0.build()
            r1 = 0
            okhttp3.OkHttpClient r2 = r4.mClient     // Catch:{ Exception -> 0x0066 }
            okhttp3.Call r0 = r2.newCall(r0)     // Catch:{ Exception -> 0x0066 }
            okhttp3.Response r0 = r0.execute()     // Catch:{ Exception -> 0x0066 }
            boolean r2 = r0.isSuccessful()     // Catch:{ all -> 0x005a }
            if (r2 != 0) goto L_0x0032
            if (r0 == 0) goto L_0x0031
            r0.close()     // Catch:{ Exception -> 0x0066 }
        L_0x0031:
            return r1
        L_0x0032:
            okio.Sink r2 = okio.Okio.sink((java.io.File) r6)     // Catch:{ all -> 0x0052 }
            okhttp3.ResponseBody r3 = r0.body()     // Catch:{ all -> 0x0050 }
            okio.BufferedSource r3 = r3.source()     // Catch:{ all -> 0x0050 }
            okio.BufferedSource r3 = okio.Okio.buffer((okio.Source) r3)     // Catch:{ all -> 0x0050 }
            r3.readAll(r2)     // Catch:{ all -> 0x0050 }
            if (r2 == 0) goto L_0x004a
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x004a:
            if (r0 == 0) goto L_0x004f
            r0.close()     // Catch:{ Exception -> 0x0066 }
        L_0x004f:
            return r6
        L_0x0050:
            r3 = move-exception
            goto L_0x0054
        L_0x0052:
            r3 = move-exception
            r2 = r1
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.close()     // Catch:{ all -> 0x005a }
        L_0x0059:
            throw r3     // Catch:{ all -> 0x005a }
        L_0x005a:
            r2 = move-exception
            if (r0 == 0) goto L_0x0065
            r0.close()     // Catch:{ all -> 0x0061 }
            goto L_0x0065
        L_0x0061:
            r0 = move-exception
            r2.addSuppressed(r0)     // Catch:{ Exception -> 0x0066 }
        L_0x0065:
            throw r2     // Catch:{ Exception -> 0x0066 }
        L_0x0066:
            r0 = move-exception
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r5
            r5 = 1
            java.lang.String r6 = r6.getAbsolutePath()
            r2[r5] = r6
            r5 = 2
            r2[r5] = r0
            java.lang.String r5 = "ReactNative"
            java.lang.String r6 = "Failed to fetch resource synchronously - resourcePath: \"%s\", outputFile: \"%s\""
            com.facebook.common.logging.FLog.e((java.lang.String) r5, (java.lang.String) r6, (java.lang.Object[]) r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.DevServerHelper.downloadBundleResourceFromUrlSync(java.lang.String, java.io.File):java.io.File");
    }
}
