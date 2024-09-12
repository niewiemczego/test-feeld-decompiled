package com.reactnativecommunity.webview;

import android.app.Activity;
import android.app.DownloadManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.util.Log;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;
import com.braze.ui.actions.brazeactions.steps.StepData;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.ThemedReactContext;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b0\u0018\u0000 }2\u00020\u0001:\u0001}B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u000e\u00101\u001a\u00020.2\u0006\u0010/\u001a\u000200J\u0016\u00101\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00102\u001a\u00020.J\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0018\u000104J\n\u00105\u001a\u0004\u0018\u00010\u0004H\u0002J\n\u00106\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u00107\u001a\u0002082\u0006\u00102\u001a\u00020.J\u001e\u00109\u001a\u0002082\u0006\u00102\u001a\u00020.2\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020<J\u0016\u0010=\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010?\u001a\u00020$J\u0016\u0010@\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010B\u001a\u0002082\u0006\u0010>\u001a\u00020C2\u0006\u0010D\u001a\u00020$J\u0016\u0010E\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010F\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0018\u0010H\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010I\u001a\u0004\u0018\u00010\u0004J\u0018\u0010J\u001a\u0002082\u0006\u0010>\u001a\u00020C2\b\u0010K\u001a\u0004\u0018\u00010\u0004J\u0018\u0010L\u001a\u0002082\u0006\u0010>\u001a\u00020C2\b\u0010M\u001a\u0004\u0018\u00010NJ\u0016\u0010O\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0018\u0010P\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010Q\u001a\u0004\u0018\u00010\u0004J\u0016\u0010R\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0010\u0010S\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u0016\u0010T\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0016\u0010U\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010V\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010W\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010X\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0018\u0010Y\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010Z\u001a\u0004\u0018\u00010\u0004J\u0018\u0010[\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\\\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010]\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010^\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010_\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0010\u0010`\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u0016\u0010a\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010b\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020<J\u0016\u0010c\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0018\u0010d\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010A\u001a\u0004\u0018\u00010\u0004J\u0016\u0010e\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0006J\u0018\u0010f\u001a\u0002082\u0006\u0010>\u001a\u00020C2\b\u0010g\u001a\u0004\u0018\u00010\u0004J\u0016\u0010h\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0018\u0010i\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010j\u001a\u0004\u0018\u00010\u0004J\u0016\u0010k\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010l\u001a\u00020$J\u0016\u0010m\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010n\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010o\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010p\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010q\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\u0016\u0010r\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020$J\"\u0010s\u001a\u0002082\u0006\u0010>\u001a\u00020.2\b\u0010t\u001a\u0004\u0018\u00010N2\b\b\u0002\u0010u\u001a\u00020$J\u0016\u0010v\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010A\u001a\u00020\u0006J\u0016\u0010w\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0018\u0010x\u001a\u0002082\u0006\u0010>\u001a\u00020C2\b\u0010y\u001a\u0004\u0018\u00010\u0004J\u0010\u0010z\u001a\u0002082\u0006\u0010>\u001a\u00020CH\u0002J\u0016\u0010{\u001a\u0002082\u0006\u0010>\u001a\u00020.2\u0006\u0010G\u001a\u00020$J\u0010\u0010|\u001a\u0002082\u0006\u00102\u001a\u00020.H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0014\u0010\u000b\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u0014\u0010\r\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0014\u0010\u000f\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u0014\u0010\u0011\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0014\u0010\u0013\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u0014\u0010\u0015\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u0014\u0010\u0017\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u0014\u0010\u0019\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u0014\u0010\u001b\u001a\u00020\u0006XD¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u000e\u0010\u001d\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u000e¢\u0006\u0002\n\u0000¨\u0006~"}, d2 = {"Lcom/reactnativecommunity/webview/RNCWebViewManagerImpl;", "", "()V", "BLANK_URL", "", "COMMAND_CLEAR_CACHE", "", "getCOMMAND_CLEAR_CACHE", "()I", "COMMAND_CLEAR_FORM_DATA", "getCOMMAND_CLEAR_FORM_DATA", "COMMAND_CLEAR_HISTORY", "getCOMMAND_CLEAR_HISTORY", "COMMAND_FOCUS", "getCOMMAND_FOCUS", "COMMAND_GO_BACK", "getCOMMAND_GO_BACK", "COMMAND_GO_FORWARD", "getCOMMAND_GO_FORWARD", "COMMAND_INJECT_JAVASCRIPT", "getCOMMAND_INJECT_JAVASCRIPT", "COMMAND_LOAD_URL", "getCOMMAND_LOAD_URL", "COMMAND_POST_MESSAGE", "getCOMMAND_POST_MESSAGE", "COMMAND_RELOAD", "getCOMMAND_RELOAD", "COMMAND_STOP_LOADING", "getCOMMAND_STOP_LOADING", "DEFAULT_DOWNLOADING_MESSAGE", "DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE", "HTML_ENCODING", "HTML_MIME_TYPE", "HTTP_METHOD_POST", "TAG", "mAllowsFullscreenVideo", "", "mAllowsProtectedMedia", "mDownloadingMessage", "mHasOnOpenWindowEvent", "mLackPermissionToDownloadMessage", "mUserAgent", "mUserAgentWithApplicationName", "mWebViewConfig", "Lcom/reactnativecommunity/webview/RNCWebViewConfig;", "createRNCWebViewInstance", "Lcom/reactnativecommunity/webview/RNCWebView;", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "createViewInstance", "webView", "getCommandsMap", "", "getDownloadingMessageOrDefault", "getLackPermissionToDownloadMessageOrDefault", "onDropViewInstance", "", "receiveCommand", "commandId", "args", "Lcom/facebook/react/bridge/ReadableArray;", "setAllowFileAccess", "view", "allowFileAccess", "setAllowFileAccessFromFileURLs", "value", "setAllowUniversalAccessFromFileURLs", "Landroid/webkit/WebView;", "allow", "setAllowsFullscreenVideo", "setAllowsProtectedMedia", "enabled", "setAndroidLayerType", "layerTypeString", "setApplicationNameForUserAgent", "applicationName", "setBasicAuthCredential", "credential", "Lcom/facebook/react/bridge/ReadableMap;", "setCacheEnabled", "setCacheMode", "cacheModeString", "setDomStorageEnabled", "setDownloadingMessage", "setForceDarkOn", "setGeolocationEnabled", "setHasOnOpenWindowEvent", "setHasOnScroll", "setIncognito", "setInjectedJavaScript", "injectedJavaScript", "setInjectedJavaScriptBeforeContentLoaded", "setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly", "setInjectedJavaScriptForMainFrameOnly", "setJavaScriptCanOpenWindowsAutomatically", "setJavaScriptEnabled", "setLackPermissionToDownloadMessage", "setMediaPlaybackRequiresUserAction", "setMenuCustomItems", "setMessagingEnabled", "setMessagingModuleName", "setMinimumFontSize", "setMixedContentMode", "mixedContentMode", "setNestedScrollEnabled", "setOverScrollMode", "overScrollModeString", "setSaveFormDataDisabled", "disabled", "setScalesPageToFit", "setSetBuiltInZoomControls", "setSetDisplayZoomControls", "setSetSupportMultipleWindows", "setShowsHorizontalScrollIndicator", "setShowsVerticalScrollIndicator", "setSource", "source", "newArch", "setTextZoom", "setThirdPartyCookiesEnabled", "setUserAgent", "userAgent", "setUserAgentString", "setWebviewDebuggingEnabled", "setupWebChromeClient", "Companion", "react-native-webview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNCWebViewManagerImpl.kt */
public final class RNCWebViewManagerImpl {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "RNCWebView";
    private final String BLANK_URL = "about:blank";
    private final int COMMAND_CLEAR_CACHE = 1001;
    private final int COMMAND_CLEAR_FORM_DATA = 1000;
    private final int COMMAND_CLEAR_HISTORY = 1002;
    private final int COMMAND_FOCUS = 8;
    private final int COMMAND_GO_BACK = 1;
    private final int COMMAND_GO_FORWARD = 2;
    private final int COMMAND_INJECT_JAVASCRIPT = 6;
    private final int COMMAND_LOAD_URL = 7;
    private final int COMMAND_POST_MESSAGE = 5;
    private final int COMMAND_RELOAD = 3;
    private final int COMMAND_STOP_LOADING = 4;
    private final String DEFAULT_DOWNLOADING_MESSAGE = "Downloading";
    private final String DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE = "Cannot download files as permission was denied. Please provide permission to write to storage, in order to download files.";
    private final String HTML_ENCODING = "UTF-8";
    private final String HTML_MIME_TYPE = "text/html";
    private final String HTTP_METHOD_POST = ShareTarget.METHOD_POST;
    private final String TAG = "RNCWebViewManagerImpl";
    private boolean mAllowsFullscreenVideo;
    private boolean mAllowsProtectedMedia;
    private String mDownloadingMessage;
    private boolean mHasOnOpenWindowEvent;
    private String mLackPermissionToDownloadMessage;
    private String mUserAgent;
    private String mUserAgentWithApplicationName;
    private RNCWebViewConfig mWebViewConfig = new RNCWebViewManagerImpl$$ExternalSyntheticLambda1();

    /* access modifiers changed from: private */
    /* renamed from: mWebViewConfig$lambda-0  reason: not valid java name */
    public static final void m622mWebViewConfig$lambda0(WebView webView) {
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/reactnativecommunity/webview/RNCWebViewManagerImpl$Companion;", "", "()V", "NAME", "", "react-native-webview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNCWebViewManagerImpl.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final RNCWebView createRNCWebViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new RNCWebView(themedReactContext);
    }

    public final RNCWebView createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return createViewInstance(themedReactContext, createRNCWebViewInstance(themedReactContext));
    }

    public final RNCWebView createViewInstance(ThemedReactContext themedReactContext, RNCWebView rNCWebView) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        Intrinsics.checkNotNullParameter(rNCWebView, "webView");
        setupWebChromeClient(rNCWebView);
        themedReactContext.addLifecycleEventListener(rNCWebView);
        WebView webView = rNCWebView;
        this.mWebViewConfig.configWebView(webView);
        WebSettings settings = rNCWebView.getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "webView.settings");
        settings.setBuiltInZoomControls(true);
        settings.setDisplayZoomControls(false);
        settings.setDomStorageEnabled(true);
        settings.setSupportMultipleWindows(true);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setAllowFileAccessFromFileURLs(false);
        setAllowUniversalAccessFromFileURLs(webView, false);
        setMixedContentMode(webView, "never");
        rNCWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        rNCWebView.setDownloadListener(new RNCWebViewManagerImpl$$ExternalSyntheticLambda0(rNCWebView, this));
        return rNCWebView;
    }

    /* access modifiers changed from: private */
    /* renamed from: createViewInstance$lambda-1  reason: not valid java name */
    public static final void m621createViewInstance$lambda1(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl, String str, String str2, String str3, String str4, long j) {
        Intrinsics.checkNotNullParameter(rNCWebView, "$webView");
        Intrinsics.checkNotNullParameter(rNCWebViewManagerImpl, "this$0");
        rNCWebView.setIgnoreErrFailedForThisURL(str);
        RNCWebViewModule rNCWebViewModule = (RNCWebViewModule) rNCWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class);
        if (rNCWebViewModule != null) {
            try {
                DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
                String guessFileName = URLUtil.guessFileName(str, str3, str4);
                Intrinsics.checkNotNullExpressionValue(guessFileName, "fileName");
                String replace = RNCWebViewManagerImplKt.getInvalidCharRegex().replace((CharSequence) guessFileName, "_");
                String str5 = "Downloading " + replace;
                try {
                    URL url = new URL(str);
                    request.addRequestHeader("Cookie", CookieManager.getInstance().getCookie(url.getProtocol() + "://" + url.getHost()));
                } catch (MalformedURLException e) {
                    Log.w(rNCWebViewManagerImpl.TAG, "Error getting cookie for DownloadManager", e);
                }
                request.addRequestHeader("User-Agent", str2);
                request.setTitle(replace);
                request.setDescription(str5);
                request.allowScanningByMediaScanner();
                request.setNotificationVisibility(1);
                request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, replace);
                rNCWebViewModule.setDownloadRequest(request);
                if (rNCWebViewModule.grantFileDownloaderPermissions(rNCWebViewManagerImpl.getDownloadingMessageOrDefault(), rNCWebViewManagerImpl.getLackPermissionToDownloadMessageOrDefault())) {
                    rNCWebViewModule.downloadFile(rNCWebViewManagerImpl.getDownloadingMessageOrDefault());
                }
            } catch (IllegalArgumentException e2) {
                Log.w(rNCWebViewManagerImpl.TAG, "Unsupported URI, aborting download", e2);
            }
        }
    }

    private final void setupWebChromeClient(RNCWebView rNCWebView) {
        Activity currentActivity = rNCWebView.getThemedReactContext().getCurrentActivity();
        if (!this.mAllowsFullscreenVideo || currentActivity == null) {
            RNCWebChromeClient rNCWebChromeClient = (RNCWebChromeClient) rNCWebView.getWebChromeClient();
            if (rNCWebChromeClient != null) {
                rNCWebChromeClient.onHideCustomView();
            }
            RNCWebChromeClient rNCWebViewManagerImpl$setupWebChromeClient$1 = new RNCWebViewManagerImpl$setupWebChromeClient$1(rNCWebView);
            RNCWebViewManagerImpl$setupWebChromeClient$1 rNCWebViewManagerImpl$setupWebChromeClient$12 = (RNCWebViewManagerImpl$setupWebChromeClient$1) rNCWebViewManagerImpl$setupWebChromeClient$1;
            rNCWebViewManagerImpl$setupWebChromeClient$12.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
            rNCWebViewManagerImpl$setupWebChromeClient$12.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
            rNCWebView.setWebChromeClient(rNCWebViewManagerImpl$setupWebChromeClient$1);
            return;
        }
        RNCWebChromeClient rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1 = new RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1(rNCWebView, currentActivity, currentActivity.getRequestedOrientation());
        rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1.setAllowsProtectedMedia(this.mAllowsProtectedMedia);
        rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1.setHasOnOpenWindowEvent(this.mHasOnOpenWindowEvent);
        rNCWebView.setWebChromeClient(rNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1);
    }

    public final void setUserAgent(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        this.mUserAgent = str;
        setUserAgentString(webView);
    }

    public final void setApplicationNameForUserAgent(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        if (str != null) {
            this.mUserAgentWithApplicationName = WebSettings.getDefaultUserAgent(webView.getContext()) + ' ' + str;
        } else {
            this.mUserAgentWithApplicationName = null;
        }
        setUserAgentString(webView);
    }

    private final void setUserAgentString(WebView webView) {
        if (this.mUserAgent != null) {
            webView.getSettings().setUserAgentString(this.mUserAgent);
        } else if (this.mUserAgentWithApplicationName != null) {
            webView.getSettings().setUserAgentString(this.mUserAgentWithApplicationName);
        } else {
            webView.getSettings().setUserAgentString(WebSettings.getDefaultUserAgent(webView.getContext()));
        }
    }

    public final void setBasicAuthCredential(WebView webView, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        ((RNCWebView) webView).setBasicAuthCredential((readableMap == null || !readableMap.hasKey("username") || !readableMap.hasKey("password")) ? null : new RNCBasicAuthCredential(readableMap.getString("username"), readableMap.getString("password")));
    }

    public final void onDropViewInstance(RNCWebView rNCWebView) {
        Intrinsics.checkNotNullParameter(rNCWebView, "webView");
        rNCWebView.getThemedReactContext().removeLifecycleEventListener(rNCWebView);
        rNCWebView.cleanupCallbacksAndDestroy();
        rNCWebView.mWebChromeClient = null;
    }

    public final int getCOMMAND_GO_BACK() {
        return this.COMMAND_GO_BACK;
    }

    public final int getCOMMAND_GO_FORWARD() {
        return this.COMMAND_GO_FORWARD;
    }

    public final int getCOMMAND_RELOAD() {
        return this.COMMAND_RELOAD;
    }

    public final int getCOMMAND_STOP_LOADING() {
        return this.COMMAND_STOP_LOADING;
    }

    public final int getCOMMAND_POST_MESSAGE() {
        return this.COMMAND_POST_MESSAGE;
    }

    public final int getCOMMAND_INJECT_JAVASCRIPT() {
        return this.COMMAND_INJECT_JAVASCRIPT;
    }

    public final int getCOMMAND_LOAD_URL() {
        return this.COMMAND_LOAD_URL;
    }

    public final int getCOMMAND_FOCUS() {
        return this.COMMAND_FOCUS;
    }

    public final int getCOMMAND_CLEAR_FORM_DATA() {
        return this.COMMAND_CLEAR_FORM_DATA;
    }

    public final int getCOMMAND_CLEAR_CACHE() {
        return this.COMMAND_CLEAR_CACHE;
    }

    public final int getCOMMAND_CLEAR_HISTORY() {
        return this.COMMAND_CLEAR_HISTORY;
    }

    public final Map<String, Integer> getCommandsMap() {
        return MapBuilder.builder().put("goBack", Integer.valueOf(this.COMMAND_GO_BACK)).put("goForward", Integer.valueOf(this.COMMAND_GO_FORWARD)).put("reload", Integer.valueOf(this.COMMAND_RELOAD)).put("stopLoading", Integer.valueOf(this.COMMAND_STOP_LOADING)).put("postMessage", Integer.valueOf(this.COMMAND_POST_MESSAGE)).put("injectJavaScript", Integer.valueOf(this.COMMAND_INJECT_JAVASCRIPT)).put("loadUrl", Integer.valueOf(this.COMMAND_LOAD_URL)).put("requestFocus", Integer.valueOf(this.COMMAND_FOCUS)).put("clearFormData", Integer.valueOf(this.COMMAND_CLEAR_FORM_DATA)).put("clearCache", Integer.valueOf(this.COMMAND_CLEAR_CACHE)).put("clearHistory", Integer.valueOf(this.COMMAND_CLEAR_HISTORY)).build();
    }

    public final void receiveCommand(RNCWebView rNCWebView, String str, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(rNCWebView, "webView");
        Intrinsics.checkNotNullParameter(str, "commandId");
        Intrinsics.checkNotNullParameter(readableArray, StepData.ARGS);
        switch (str.hashCode()) {
            case -1241591313:
                if (str.equals("goBack")) {
                    rNCWebView.goBack();
                    return;
                }
                return;
            case -948122918:
                if (str.equals("stopLoading")) {
                    rNCWebView.stopLoading();
                    return;
                }
                return;
            case -934641255:
                if (str.equals("reload")) {
                    rNCWebView.reload();
                    return;
                }
                return;
            case -759238347:
                if (str.equals("clearCache")) {
                    rNCWebView.clearCache(readableArray.getBoolean(0));
                    return;
                }
                return;
            case -318289731:
                if (str.equals("goForward")) {
                    rNCWebView.goForward();
                    return;
                }
                return;
            case -265032709:
                if (str.equals("clearFormData")) {
                    rNCWebView.clearFormData();
                    return;
                }
                return;
            case 336631465:
                if (str.equals("loadUrl")) {
                    rNCWebView.progressChangedFilter.setWaitingForCommandLoadUrl(false);
                    rNCWebView.loadUrl(readableArray.getString(0));
                    return;
                }
                return;
            case 903120263:
                if (str.equals("clearHistory")) {
                    rNCWebView.clearHistory();
                    return;
                }
                return;
            case 1280029577:
                if (str.equals("requestFocus")) {
                    rNCWebView.requestFocus();
                    return;
                }
                return;
            case 1490029383:
                if (str.equals("postMessage")) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("data", (Object) readableArray.getString(0));
                        rNCWebView.evaluateJavascriptWithFallback("(function () {var event;var data = " + jSONObject + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
                        return;
                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    return;
                }
            case 2104576510:
                if (str.equals("injectJavaScript")) {
                    rNCWebView.evaluateJavascriptWithFallback(readableArray.getString(0));
                    return;
                }
                return;
            default:
                return;
        }
    }

    public final void setMixedContentMode(WebView webView, String str) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        if (str == null || Intrinsics.areEqual((Object) "never", (Object) str)) {
            webView.getSettings().setMixedContentMode(1);
        } else if (Intrinsics.areEqual((Object) "always", (Object) str)) {
            webView.getSettings().setMixedContentMode(0);
        } else if (Intrinsics.areEqual((Object) "compatibility", (Object) str)) {
            webView.getSettings().setMixedContentMode(2);
        }
    }

    public final void setAllowUniversalAccessFromFileURLs(WebView webView, boolean z) {
        Intrinsics.checkNotNullParameter(webView, ViewHierarchyConstants.VIEW_KEY);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(z);
    }

    private final String getDownloadingMessageOrDefault() {
        String str = this.mDownloadingMessage;
        return str == null ? this.DEFAULT_DOWNLOADING_MESSAGE : str;
    }

    private final String getLackPermissionToDownloadMessageOrDefault() {
        String str = this.mLackPermissionToDownloadMessage;
        return str == null ? this.DEFAULT_LACK_PERMISSION_TO_DOWNLOAD_MESSAGE : str;
    }

    public static /* synthetic */ void setSource$default(RNCWebViewManagerImpl rNCWebViewManagerImpl, RNCWebView rNCWebView, ReadableMap readableMap, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        rNCWebViewManagerImpl.setSource(rNCWebView, readableMap, z);
    }

    public final void setSource(RNCWebView rNCWebView, ReadableMap readableMap, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        if (readableMap != null) {
            String str = "";
            if (readableMap.hasKey("html")) {
                String string = readableMap.getString("html");
                if (readableMap.hasKey("baseUrl")) {
                    str = readableMap.getString("baseUrl");
                }
                Intrinsics.checkNotNull(string);
                rNCWebView.loadDataWithBaseURL(str, string, this.HTML_MIME_TYPE, this.HTML_ENCODING, (String) null);
                return;
            } else if (readableMap.hasKey("uri")) {
                String string2 = readableMap.getString("uri");
                String url = rNCWebView.getUrl();
                if (url != null && Intrinsics.areEqual((Object) url, (Object) string2)) {
                    return;
                }
                if (!readableMap.hasKey("method") || !StringsKt.equals(readableMap.getString("method"), this.HTTP_METHOD_POST, true)) {
                    HashMap hashMap = new HashMap();
                    if (readableMap.hasKey("headers")) {
                        if (z) {
                            ReadableArray array = readableMap.getArray("headers");
                            Intrinsics.checkNotNull(array);
                            Iterator<Object> it = array.toArrayList().iterator();
                            while (it.hasNext()) {
                                Object next = it.next();
                                Intrinsics.checkNotNull(next, "null cannot be cast to non-null type java.util.HashMap<kotlin.String, kotlin.String>");
                                HashMap hashMap2 = (HashMap) next;
                                String str2 = (String) hashMap2.get("name");
                                if (str2 == null) {
                                    str2 = str;
                                }
                                String str3 = (String) hashMap2.get("value");
                                if (str3 == null) {
                                    str3 = str;
                                }
                                Locale locale = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
                                String lowerCase = str2.toLowerCase(locale);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
                                if (Intrinsics.areEqual((Object) "user-agent", (Object) lowerCase)) {
                                    rNCWebView.getSettings().setUserAgentString(str3);
                                } else {
                                    hashMap.put(str2, str3);
                                }
                            }
                        } else {
                            ReadableMap map = readableMap.getMap("headers");
                            Intrinsics.checkNotNull(map);
                            ReadableMapKeySetIterator keySetIterator = map.keySetIterator();
                            Intrinsics.checkNotNullExpressionValue(keySetIterator, "headers!!.keySetIterator()");
                            while (keySetIterator.hasNextKey()) {
                                String nextKey = keySetIterator.nextKey();
                                Intrinsics.checkNotNullExpressionValue(nextKey, "key");
                                Locale locale2 = Locale.ENGLISH;
                                Intrinsics.checkNotNullExpressionValue(locale2, ViewHierarchyConstants.ENGLISH);
                                String lowerCase2 = nextKey.toLowerCase(locale2);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(locale)");
                                if (Intrinsics.areEqual((Object) "user-agent", (Object) lowerCase2)) {
                                    rNCWebView.getSettings().setUserAgentString(map.getString(nextKey));
                                } else {
                                    hashMap.put(nextKey, map.getString(nextKey));
                                }
                            }
                        }
                    }
                    Intrinsics.checkNotNull(string2);
                    rNCWebView.loadUrl(string2, hashMap);
                    return;
                }
                byte[] bArr = null;
                if (readableMap.hasKey("body")) {
                    String string3 = readableMap.getString("body");
                    try {
                        Intrinsics.checkNotNull(string3);
                        Charset forName = Charset.forName("UTF-8");
                        Intrinsics.checkNotNullExpressionValue(forName, "forName(charsetName)");
                        bArr = string3.getBytes(forName);
                        Intrinsics.checkNotNullExpressionValue(bArr, "this as java.lang.String).getBytes(charset)");
                    } catch (UnsupportedEncodingException unused) {
                        Intrinsics.checkNotNull(string3);
                        byte[] bytes = string3.getBytes(Charsets.UTF_8);
                        Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
                        bArr = bytes;
                    }
                }
                if (bArr == null) {
                    bArr = new byte[0];
                }
                Intrinsics.checkNotNull(string2);
                rNCWebView.postUrl(string2, bArr);
                return;
            }
        }
        rNCWebView.loadUrl(this.BLANK_URL);
    }

    public final void setMessagingModuleName(RNCWebView rNCWebView, String str) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.messagingModuleName = str;
    }

    public final void setCacheEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setCacheMode(z ? -1 : 2);
    }

    public final void setIncognito(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        if (z) {
            CookieManager.getInstance().removeAllCookies((ValueCallback) null);
            rNCWebView.getSettings().setCacheMode(2);
            rNCWebView.clearHistory();
            rNCWebView.clearCache(true);
            rNCWebView.clearFormData();
            rNCWebView.getSettings().setSavePassword(false);
            rNCWebView.getSettings().setSaveFormData(false);
        }
    }

    public final void setInjectedJavaScript(RNCWebView rNCWebView, String str) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.injectedJS = str;
    }

    public final void setInjectedJavaScriptBeforeContentLoaded(RNCWebView rNCWebView, String str) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.injectedJSBeforeContentLoaded = str;
    }

    public final void setInjectedJavaScriptForMainFrameOnly(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.injectedJavaScriptForMainFrameOnly = z;
    }

    public final void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.injectedJavaScriptBeforeContentLoadedForMainFrameOnly = z;
    }

    public final void setJavaScriptCanOpenWindowsAutomatically(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setJavaScriptCanOpenWindowsAutomatically(z);
    }

    public final void setShowsVerticalScrollIndicator(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.setVerticalScrollBarEnabled(z);
    }

    public final void setShowsHorizontalScrollIndicator(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.setHorizontalScrollBarEnabled(z);
    }

    public final void setMessagingEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.setMessagingEnabled(z);
    }

    public final void setMediaPlaybackRequiresUserAction(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setMediaPlaybackRequiresUserGesture(z);
    }

    public final void setHasOnScroll(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.setHasScrollEvent(z);
    }

    public final void setJavaScriptEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setJavaScriptEnabled(z);
    }

    public final void setAllowFileAccess(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setAllowFileAccess(z);
    }

    public final void setAllowFileAccessFromFileURLs(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setAllowFileAccessFromFileURLs(z);
    }

    public final void setAllowsFullscreenVideo(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        this.mAllowsFullscreenVideo = z;
        setupWebChromeClient(rNCWebView);
    }

    public final void setAndroidLayerType(RNCWebView rNCWebView, String str) {
        int i;
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        if (Intrinsics.areEqual((Object) str, (Object) "hardware")) {
            i = 2;
        } else {
            i = Intrinsics.areEqual((Object) str, (Object) "software") ? 1 : 0;
        }
        rNCWebView.setLayerType(i, (Paint) null);
    }

    public final void setCacheMode(RNCWebView rNCWebView, String str) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        WebSettings settings = rNCWebView.getSettings();
        int i = -1;
        if (str != null) {
            switch (str.hashCode()) {
                case -2059164003:
                    if (str.equals("LOAD_NO_CACHE")) {
                        i = 2;
                        break;
                    }
                    break;
                case -1215135800:
                    boolean equals = str.equals("LOAD_DEFAULT");
                    break;
                case -873877826:
                    if (str.equals("LOAD_CACHE_ELSE_NETWORK")) {
                        i = 1;
                        break;
                    }
                    break;
                case 1548620642:
                    if (str.equals("LOAD_CACHE_ONLY")) {
                        i = 3;
                        break;
                    }
                    break;
            }
        }
        settings.setCacheMode(i);
    }

    public final void setDomStorageEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setDomStorageEnabled(z);
    }

    public final void setDownloadingMessage(String str) {
        this.mDownloadingMessage = str;
    }

    public final void setForceDarkOn(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        if (Build.VERSION.SDK_INT > 28) {
            if (WebViewFeature.isFeatureSupported("FORCE_DARK")) {
                WebSettingsCompat.setForceDark(rNCWebView.getSettings(), z ? 2 : 0);
            }
            if (z && WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
                WebSettingsCompat.setForceDarkStrategy(rNCWebView.getSettings(), 2);
            }
        }
    }

    public final void setGeolocationEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setGeolocationEnabled(z);
    }

    public final void setLackPermissionToDownloadMessage(String str) {
        this.mLackPermissionToDownloadMessage = str;
    }

    public final void setHasOnOpenWindowEvent(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        this.mHasOnOpenWindowEvent = z;
        setupWebChromeClient(rNCWebView);
    }

    public final void setMinimumFontSize(RNCWebView rNCWebView, int i) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setMinimumFontSize(i);
    }

    public final void setAllowsProtectedMedia(RNCWebView rNCWebView, boolean z) {
        WebChromeClient webChromeClient;
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        this.mAllowsProtectedMedia = z;
        if (Build.VERSION.SDK_INT >= 26 && (webChromeClient = rNCWebView.getWebChromeClient()) != null && (webChromeClient instanceof RNCWebChromeClient)) {
            ((RNCWebChromeClient) webChromeClient).setAllowsProtectedMedia(z);
        }
    }

    public final void setMenuCustomItems(RNCWebView rNCWebView, ReadableArray readableArray) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(readableArray, "value");
        ArrayList<Object> arrayList = readableArray.toArrayList();
        Intrinsics.checkNotNull(arrayList, "null cannot be cast to non-null type kotlin.collections.List<kotlin.collections.Map<kotlin.String, kotlin.String>>");
        rNCWebView.setMenuCustomItems(arrayList);
    }

    public final void setNestedScrollEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.nestedScrollEnabled = z;
    }

    public final void setOverScrollMode(RNCWebView rNCWebView, String str) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        int i = 0;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode == -1414557169) {
                boolean equals = str.equals("always");
            } else if (hashCode != 104712844) {
                if (hashCode == 951530617 && str.equals("content")) {
                    i = 1;
                }
            } else if (str.equals("never")) {
                i = 2;
            }
        }
        rNCWebView.setOverScrollMode(i);
    }

    public final void setSaveFormDataDisabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setSaveFormData(!z);
    }

    public final void setScalesPageToFit(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setLoadWithOverviewMode(z);
        rNCWebView.getSettings().setUseWideViewPort(z);
    }

    public final void setSetBuiltInZoomControls(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setBuiltInZoomControls(z);
    }

    public final void setSetDisplayZoomControls(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setDisplayZoomControls(z);
    }

    public final void setSetSupportMultipleWindows(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setSupportMultipleWindows(z);
    }

    public final void setTextZoom(RNCWebView rNCWebView, int i) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        rNCWebView.getSettings().setTextZoom(i);
    }

    public final void setThirdPartyCookiesEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        CookieManager.getInstance().setAcceptThirdPartyCookies(rNCWebView, z);
    }

    public final void setWebviewDebuggingEnabled(RNCWebView rNCWebView, boolean z) {
        Intrinsics.checkNotNullParameter(rNCWebView, ViewHierarchyConstants.VIEW_KEY);
        RNCWebView.setWebContentsDebuggingEnabled(z);
    }
}
