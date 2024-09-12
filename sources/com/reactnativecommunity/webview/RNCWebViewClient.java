package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.reactnativecommunity.webview.RNCWebView;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;

public class RNCWebViewClient extends WebViewClient {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    protected static final int SHOULD_OVERRIDE_URL_LOADING_TIMEOUT = 250;
    private static String TAG = "RNCWebViewClient";
    protected RNCBasicAuthCredential basicAuthCredential = null;
    protected String ignoreErrFailedForThisURL = null;
    protected boolean mLastLoadFailed = false;
    protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;

    public void setIgnoreErrFailedForThisURL(String str) {
        this.ignoreErrFailedForThisURL = str;
    }

    public void setBasicAuthCredential(RNCBasicAuthCredential rNCBasicAuthCredential) {
        this.basicAuthCredential = rNCBasicAuthCredential;
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (!this.mLastLoadFailed) {
            ((RNCWebView) webView).callInjectedJavaScript();
            emitFinishEvent(webView, str);
        }
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        super.doUpdateVisitedHistory(webView, str, z);
        ((RNCWebView) webView).dispatchEvent(webView, new TopLoadingStartEvent(webView.getId(), createWebViewEvent(webView, str)));
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.mLastLoadFailed = false;
        ((RNCWebView) webView).callInjectedJavaScriptBeforeContentLoaded();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0077, code lost:
        if (r1.get() != com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x007a, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x007b, code lost:
        com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock.removeLock(java.lang.Double.valueOf(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0084, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean shouldOverrideUrlLoading(android.webkit.WebView r11, java.lang.String r12) {
        /*
            r10 = this;
            r0 = r11
            com.reactnativecommunity.webview.RNCWebView r0 = (com.reactnativecommunity.webview.RNCWebView) r0
            android.content.Context r1 = r11.getContext()
            com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
            com.facebook.react.bridge.JavaScriptContextHolder r1 = r1.getJavaScriptContextHolder()
            long r1 = r1.get()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 1
            r3 = 0
            if (r1 != 0) goto L_0x001b
            r1 = r2
            goto L_0x001c
        L_0x001b:
            r1 = r3
        L_0x001c:
            if (r1 != 0) goto L_0x009a
            com.facebook.react.bridge.CatalystInstance r1 = r0.mCatalystInstance
            if (r1 == 0) goto L_0x009a
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r1 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            androidx.core.util.Pair r1 = r1.getNewLock()
            F r4 = r1.first
            java.lang.Double r4 = (java.lang.Double) r4
            double r4 = r4.doubleValue()
            S r1 = r1.second
            java.util.concurrent.atomic.AtomicReference r1 = (java.util.concurrent.atomic.AtomicReference) r1
            com.facebook.react.bridge.WritableMap r11 = r10.createWebViewEvent(r11, r12)
            java.lang.String r12 = "lockIdentifier"
            r11.putDouble(r12, r4)
            java.lang.String r12 = "onShouldStartLoadWithRequest"
            r0.sendDirectMessage(r12, r11)
            monitor-enter(r1)     // Catch:{ InterruptedException -> 0x0088 }
            long r11 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0085 }
        L_0x0047:
            java.lang.Object r0 = r1.get()     // Catch:{ all -> 0x0085 }
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r6 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.UNDECIDED     // Catch:{ all -> 0x0085 }
            if (r0 != r6) goto L_0x0070
            long r6 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0085 }
            long r6 = r6 - r11
            r8 = 250(0xfa, double:1.235E-321)
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x006c
            java.lang.String r11 = TAG     // Catch:{ all -> 0x0085 }
            java.lang.String r12 = "Did not receive response to shouldOverrideUrlLoading in time, defaulting to allow loading."
            com.facebook.common.logging.FLog.w((java.lang.String) r11, (java.lang.String) r12)     // Catch:{ all -> 0x0085 }
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock     // Catch:{ all -> 0x0085 }
            java.lang.Double r12 = java.lang.Double.valueOf(r4)     // Catch:{ all -> 0x0085 }
            r11.removeLock(r12)     // Catch:{ all -> 0x0085 }
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            return r3
        L_0x006c:
            r1.wait(r8)     // Catch:{ all -> 0x0085 }
            goto L_0x0047
        L_0x0070:
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            java.lang.Object r11 = r1.get()
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock$ShouldOverrideCallbackState r12 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.ShouldOverrideUrlLoadingLock.ShouldOverrideCallbackState.SHOULD_OVERRIDE
            if (r11 != r12) goto L_0x007a
            goto L_0x007b
        L_0x007a:
            r2 = r3
        L_0x007b:
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            java.lang.Double r12 = java.lang.Double.valueOf(r4)
            r11.removeLock(r12)
            return r2
        L_0x0085:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0085 }
            throw r11     // Catch:{ InterruptedException -> 0x0088 }
        L_0x0088:
            r11 = move-exception
            java.lang.String r12 = TAG
            java.lang.String r0 = "shouldOverrideUrlLoading was interrupted while waiting for result."
            com.facebook.common.logging.FLog.e((java.lang.String) r12, (java.lang.String) r0, (java.lang.Throwable) r11)
            com.reactnativecommunity.webview.RNCWebViewModuleImpl$ShouldOverrideUrlLoadingLock r11 = com.reactnativecommunity.webview.RNCWebViewModuleImpl.shouldOverrideUrlLoadingLock
            java.lang.Double r12 = java.lang.Double.valueOf(r4)
            r11.removeLock(r12)
            return r3
        L_0x009a:
            java.lang.String r0 = TAG
            java.lang.String r1 = "Couldn't use blocking synchronous call for onShouldStartLoadWithRequest due to debugging or missing Catalyst instance, falling back to old event-and-load."
            com.facebook.common.logging.FLog.w((java.lang.String) r0, (java.lang.String) r1)
            com.reactnativecommunity.webview.RNCWebView$ProgressChangedFilter r0 = r10.progressChangedFilter
            r0.setWaitingForCommandLoadUrl(r2)
            int r0 = r11.getId()
            android.content.Context r1 = r11.getContext()
            com.facebook.react.bridge.ReactContext r1 = (com.facebook.react.bridge.ReactContext) r1
            com.facebook.react.uimanager.events.EventDispatcher r1 = com.facebook.react.uimanager.UIManagerHelper.getEventDispatcherForReactTag(r1, r0)
            com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent r3 = new com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent
            com.facebook.react.bridge.WritableMap r11 = r10.createWebViewEvent(r11, r12)
            r3.<init>(r0, r11)
            r1.dispatchEvent(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.reactnativecommunity.webview.RNCWebViewClient.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }

    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        RNCBasicAuthCredential rNCBasicAuthCredential = this.basicAuthCredential;
        if (rNCBasicAuthCredential != null) {
            httpAuthHandler.proceed(rNCBasicAuthCredential.username, this.basicAuthCredential.password);
        } else {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        String url = webView.getUrl();
        String url2 = sslError.getUrl();
        sslErrorHandler.cancel();
        if (!url.equalsIgnoreCase(url2)) {
            Log.w(TAG, "Resource blocked from loading due to SSL error. Blocked URL: " + url2);
            return;
        }
        int primaryError = sslError.getPrimaryError();
        onReceivedError(webView, primaryError, "SSL error: " + (primaryError != 0 ? primaryError != 1 ? primaryError != 2 ? primaryError != 3 ? primaryError != 4 ? primaryError != 5 ? "Unknown SSL Error" : "A generic error occurred" : "The date of the certificate is invalid" : "The certificate authority is not trusted" : "Hostname mismatch" : "The certificate has expired" : "The certificate is not yet valid"), url2);
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        String str3 = this.ignoreErrFailedForThisURL;
        if (str3 == null || !str2.equals(str3) || i != -1 || !str.equals("net::ERR_FAILED")) {
            super.onReceivedError(webView, i, str, str2);
            this.mLastLoadFailed = true;
            emitFinishEvent(webView, str2);
            WritableMap createWebViewEvent = createWebViewEvent(webView, str2);
            createWebViewEvent.putDouble("code", (double) i);
            createWebViewEvent.putString("description", str);
            UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), webView.getId()).dispatchEvent(new TopLoadingErrorEvent(webView.getId(), createWebViewEvent));
            return;
        }
        setIgnoreErrFailedForThisURL((String) null);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        if (webResourceRequest.isForMainFrame()) {
            WritableMap createWebViewEvent = createWebViewEvent(webView, webResourceRequest.getUrl().toString());
            createWebViewEvent.putInt("statusCode", webResourceResponse.getStatusCode());
            createWebViewEvent.putString("description", webResourceResponse.getReasonPhrase());
            UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), webView.getId()).dispatchEvent(new TopHttpErrorEvent(webView.getId(), createWebViewEvent));
        }
    }

    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        if (Build.VERSION.SDK_INT < 26) {
            return false;
        }
        super.onRenderProcessGone(webView, renderProcessGoneDetail);
        if (renderProcessGoneDetail.didCrash()) {
            Log.e(TAG, "The WebView rendering process crashed.");
        } else {
            Log.w(TAG, "The WebView rendering process was killed by the system.");
        }
        if (webView == null) {
            return true;
        }
        WritableMap createWebViewEvent = createWebViewEvent(webView, webView.getUrl());
        createWebViewEvent.putBoolean("didCrash", renderProcessGoneDetail.didCrash());
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), webView.getId()).dispatchEvent(new TopRenderProcessGoneEvent(webView.getId(), createWebViewEvent));
        return true;
    }

    /* access modifiers changed from: protected */
    public void emitFinishEvent(WebView webView, String str) {
        UIManagerHelper.getEventDispatcherForReactTag((ReactContext) webView.getContext(), webView.getId()).dispatchEvent(new TopLoadingFinishEvent(webView.getId(), createWebViewEvent(webView, str)));
    }

    /* access modifiers changed from: protected */
    public WritableMap createWebViewEvent(WebView webView, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble(TouchesHelper.TARGET_KEY, (double) webView.getId());
        createMap.putString("url", str);
        createMap.putBoolean("loading", !this.mLastLoadFailed && webView.getProgress() != 100);
        createMap.putString("title", webView.getTitle());
        createMap.putBoolean("canGoBack", webView.canGoBack());
        createMap.putBoolean("canGoForward", webView.canGoForward());
        return createMap;
    }

    public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter2) {
        this.progressChangedFilter = progressChangedFilter2;
    }
}
