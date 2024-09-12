package com.facebook.react.devsupport;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Inspector;
import io.sentry.protocol.App;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class InspectorPackagerConnection {
    private static final String TAG = "InspectorPackagerConnection";
    private BundleStatusProvider mBundleStatusProvider;
    private final Connection mConnection;
    /* access modifiers changed from: private */
    public final Map<String, Inspector.LocalConnection> mInspectorConnections = new HashMap();
    private final String mPackageName;

    public interface BundleStatusProvider {
        BundleStatus getBundleStatus();
    }

    public InspectorPackagerConnection(String str, String str2, BundleStatusProvider bundleStatusProvider) {
        this.mConnection = new Connection(str);
        this.mPackageName = str2;
        this.mBundleStatusProvider = bundleStatusProvider;
    }

    public void connect() {
        this.mConnection.connect();
    }

    public void closeQuietly() {
        this.mConnection.close();
    }

    public void sendEventToAllConnections(String str) {
        for (Map.Entry<String, Inspector.LocalConnection> value : this.mInspectorConnections.entrySet()) {
            ((Inspector.LocalConnection) value.getValue()).sendMessage(str);
        }
    }

    /* access modifiers changed from: package-private */
    public void handleProxyMessage(JSONObject jSONObject) throws JSONException, IOException {
        String string = jSONObject.getString("event");
        string.hashCode();
        char c = 65535;
        switch (string.hashCode()) {
            case 530405532:
                if (string.equals("disconnect")) {
                    c = 0;
                    break;
                }
                break;
            case 951351530:
                if (string.equals("connect")) {
                    c = 1;
                    break;
                }
                break;
            case 1328613653:
                if (string.equals("wrappedEvent")) {
                    c = 2;
                    break;
                }
                break;
            case 1962251790:
                if (string.equals("getPages")) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                handleDisconnect(jSONObject.getJSONObject("payload"));
                return;
            case 1:
                handleConnect(jSONObject.getJSONObject("payload"));
                return;
            case 2:
                handleWrappedEvent(jSONObject.getJSONObject("payload"));
                return;
            case 3:
                sendEvent("getPages", getPages());
                return;
            default:
                throw new IllegalArgumentException("Unknown event: " + string);
        }
    }

    /* access modifiers changed from: package-private */
    public void closeAllConnections() {
        for (Map.Entry<String, Inspector.LocalConnection> value : this.mInspectorConnections.entrySet()) {
            ((Inspector.LocalConnection) value.getValue()).disconnect();
        }
        this.mInspectorConnections.clear();
    }

    private void handleConnect(JSONObject jSONObject) throws JSONException {
        final String string = jSONObject.getString("pageId");
        if (this.mInspectorConnections.remove(string) == null) {
            try {
                this.mInspectorConnections.put(string, Inspector.connect(Integer.parseInt(string), new Inspector.RemoteConnection() {
                    public void onMessage(String str) {
                        try {
                            InspectorPackagerConnection.this.sendWrappedEvent(string, str);
                        } catch (JSONException e) {
                            FLog.w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", (Throwable) e);
                        }
                    }

                    public void onDisconnect() {
                        try {
                            InspectorPackagerConnection.this.mInspectorConnections.remove(string);
                            InspectorPackagerConnection inspectorPackagerConnection = InspectorPackagerConnection.this;
                            inspectorPackagerConnection.sendEvent("disconnect", inspectorPackagerConnection.makePageIdPayload(string));
                        } catch (JSONException e) {
                            FLog.w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", (Throwable) e);
                        }
                    }
                }));
            } catch (Exception e) {
                FLog.w(TAG, "Failed to open page: " + string, (Throwable) e);
                sendEvent("disconnect", makePageIdPayload(string));
            }
        } else {
            throw new IllegalStateException("Already connected: " + string);
        }
    }

    private void handleDisconnect(JSONObject jSONObject) throws JSONException {
        Inspector.LocalConnection remove = this.mInspectorConnections.remove(jSONObject.getString("pageId"));
        if (remove != null) {
            remove.disconnect();
        }
    }

    private void handleWrappedEvent(JSONObject jSONObject) throws JSONException {
        String string = jSONObject.getString("pageId");
        String string2 = jSONObject.getString("wrappedEvent");
        Inspector.LocalConnection localConnection = this.mInspectorConnections.get(string);
        if (localConnection == null) {
            FLog.w(TAG, "PageID " + string + " is disconnected. Dropping event: " + string2);
        } else {
            localConnection.sendMessage(string2);
        }
    }

    private JSONArray getPages() throws JSONException {
        List<Inspector.Page> pages = Inspector.getPages();
        JSONArray jSONArray = new JSONArray();
        BundleStatus bundleStatus = this.mBundleStatusProvider.getBundleStatus();
        for (Inspector.Page next : pages) {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", (Object) String.valueOf(next.getId()));
            jSONObject.put("title", (Object) next.getTitle());
            jSONObject.put(App.TYPE, (Object) this.mPackageName);
            jSONObject.put("vm", (Object) next.getVM());
            jSONObject.put("isLastBundleDownloadSuccess", (Object) bundleStatus.isLastDownloadSucess);
            jSONObject.put("bundleUpdateTimestamp", bundleStatus.updateTimestamp);
            jSONArray.put((Object) jSONObject);
        }
        return jSONArray;
    }

    /* access modifiers changed from: private */
    public void sendWrappedEvent(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", (Object) str);
        jSONObject.put("wrappedEvent", (Object) str2);
        sendEvent("wrappedEvent", jSONObject);
    }

    /* access modifiers changed from: private */
    public void sendEvent(String str, Object obj) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("event", (Object) str);
        jSONObject.put("payload", obj);
        this.mConnection.send(jSONObject);
    }

    /* access modifiers changed from: private */
    public JSONObject makePageIdPayload(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("pageId", (Object) str);
        return jSONObject;
    }

    private class Connection extends WebSocketListener {
        private static final int RECONNECT_DELAY_MS = 2000;
        /* access modifiers changed from: private */
        public boolean mClosed;
        private final Handler mHandler = new Handler(Looper.getMainLooper());
        private OkHttpClient mHttpClient;
        private boolean mSuppressConnectionErrors;
        private final String mUrl;
        private WebSocket mWebSocket;

        public Connection(String str) {
            this.mUrl = str;
        }

        public void onOpen(WebSocket webSocket, Response response) {
            this.mWebSocket = webSocket;
        }

        public void onFailure(WebSocket webSocket, Throwable th, Response response) {
            if (this.mWebSocket != null) {
                abort("Websocket exception", th);
            }
            if (!this.mClosed) {
                reconnect();
            }
        }

        public void onMessage(WebSocket webSocket, String str) {
            try {
                InspectorPackagerConnection.this.handleProxyMessage(new JSONObject(str));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        public void onClosed(WebSocket webSocket, int i, String str) {
            this.mWebSocket = null;
            InspectorPackagerConnection.this.closeAllConnections();
            if (!this.mClosed) {
                reconnect();
            }
        }

        public void connect() {
            if (!this.mClosed) {
                if (this.mHttpClient == null) {
                    this.mHttpClient = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(10, TimeUnit.SECONDS).readTimeout(0, TimeUnit.MINUTES).build();
                }
                this.mHttpClient.newWebSocket(new Request.Builder().url(this.mUrl).build(), this);
                return;
            }
            throw new IllegalStateException("Can't connect closed client");
        }

        private void reconnect() {
            if (!this.mClosed) {
                if (!this.mSuppressConnectionErrors) {
                    FLog.w(InspectorPackagerConnection.TAG, "Couldn't connect to packager, will silently retry");
                    this.mSuppressConnectionErrors = true;
                }
                this.mHandler.postDelayed(new Runnable() {
                    public void run() {
                        if (!Connection.this.mClosed) {
                            Connection.this.connect();
                        }
                    }
                }, 2000);
                return;
            }
            throw new IllegalStateException("Can't reconnect closed client");
        }

        public void close() {
            this.mClosed = true;
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.mWebSocket = null;
            }
        }

        public void send(final JSONObject jSONObject) {
            new AsyncTask<WebSocket, Void, Void>() {
                /* access modifiers changed from: protected */
                public Void doInBackground(WebSocket... webSocketArr) {
                    if (!(webSocketArr == null || webSocketArr.length == 0)) {
                        try {
                            webSocketArr[0].send(jSONObject.toString());
                        } catch (Exception e) {
                            FLog.w(InspectorPackagerConnection.TAG, "Couldn't send event to packager", (Throwable) e);
                        }
                    }
                    return null;
                }
            }.execute(new WebSocket[]{this.mWebSocket});
        }

        private void abort(String str, Throwable th) {
            FLog.e(InspectorPackagerConnection.TAG, "Error occurred, shutting down websocket connection: " + str, th);
            InspectorPackagerConnection.this.closeAllConnections();
            closeWebSocketQuietly();
        }

        private void closeWebSocketQuietly() {
            WebSocket webSocket = this.mWebSocket;
            if (webSocket != null) {
                try {
                    webSocket.close(1000, "End of session");
                } catch (Exception unused) {
                }
                this.mWebSocket = null;
            }
        }
    }

    public static class BundleStatus {
        public Boolean isLastDownloadSucess;
        public long updateTimestamp;

        public BundleStatus(Boolean bool, long j) {
            this.isLastDownloadSucess = bool;
            this.updateTimestamp = j;
        }

        public BundleStatus() {
            this(false, -1);
        }
    }
}
