package com.reactnativecommunity.webview;

import android.app.Activity;
import android.net.Uri;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.PermissionAwareActivity;
import com.facebook.react.modules.core.PermissionListener;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.TouchesHelper;
import com.reactnativecommunity.webview.RNCWebView;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopOpenWindowEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RNCWebChromeClient extends WebChromeClient implements LifecycleEventListener {
    protected static final int COMMON_PERMISSION_REQUEST = 3;
    protected static final FrameLayout.LayoutParams FULLSCREEN_LAYOUT_PARAMS = new FrameLayout.LayoutParams(-1, -1, 17);
    protected static final int FULLSCREEN_SYSTEM_UI_VISIBILITY = 7942;
    protected GeolocationPermissions.Callback geolocationPermissionCallback;
    protected String geolocationPermissionOrigin;
    protected List<String> grantedPermissions;
    protected boolean mAllowsProtectedMedia = false;
    protected WebChromeClient.CustomViewCallback mCustomViewCallback;
    protected boolean mHasOnOpenWindowEvent = false;
    protected View mVideoView;
    protected RNCWebView mWebView;
    protected List<String> pendingPermissions = new ArrayList();
    protected PermissionRequest permissionRequest;
    protected boolean permissionsRequestShown = false;
    protected RNCWebView.ProgressChangedFilter progressChangedFilter = null;
    private PermissionListener webviewPermissionsListener = new RNCWebChromeClient$$ExternalSyntheticLambda0(this);

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        return true;
    }

    public void onHostDestroy() {
    }

    public void onHostPause() {
    }

    public RNCWebChromeClient(RNCWebView rNCWebView) {
        this.mWebView = rNCWebView;
    }

    public boolean onCreateWindow(final WebView webView, boolean z, boolean z2, Message message) {
        WebView webView2 = new WebView(webView.getContext());
        if (this.mHasOnOpenWindowEvent) {
            webView2.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                    WritableMap createMap = Arguments.createMap();
                    createMap.putString("targetUrl", str);
                    WebView webView2 = webView;
                    ((RNCWebView) webView2).dispatchEvent(webView2, new TopOpenWindowEvent(webView.getId(), createMap));
                    return true;
                }
            });
        }
        ((WebView.WebViewTransport) message.obj).setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public void onProgressChanged(WebView webView, int i) {
        super.onProgressChanged(webView, i);
        String url = webView.getUrl();
        if (!this.progressChangedFilter.isWaitingForCommandLoadUrl()) {
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble(TouchesHelper.TARGET_KEY, (double) webView.getId());
            createMap.putString("title", webView.getTitle());
            createMap.putString("url", url);
            createMap.putBoolean("canGoBack", webView.canGoBack());
            createMap.putBoolean("canGoForward", webView.canGoForward());
            createMap.putDouble(NotificationCompat.CATEGORY_PROGRESS, (double) (((float) i) / 100.0f));
            int id = webView.getId();
            UIManagerHelper.getEventDispatcherForReactTag(this.mWebView.getThemedReactContext(), id).dispatchEvent(new TopLoadingProgressEvent(id, createMap));
        }
    }

    public void onPermissionRequest(PermissionRequest permissionRequest2) {
        this.grantedPermissions = new ArrayList();
        ArrayList arrayList = new ArrayList();
        String[] resources = permissionRequest2.getResources();
        int length = resources.length;
        int i = 0;
        while (true) {
            String str = null;
            if (i >= length) {
                break;
            }
            String str2 = resources[i];
            if (str2.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                str = "android.permission.RECORD_AUDIO";
            } else if (str2.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                str = "android.permission.CAMERA";
            } else if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (this.mAllowsProtectedMedia) {
                    this.grantedPermissions.add(str2);
                } else {
                    str = "android.webkit.resource.PROTECTED_MEDIA_ID";
                }
            }
            if (str != null) {
                if (ContextCompat.checkSelfPermission(this.mWebView.getThemedReactContext(), str) == 0) {
                    this.grantedPermissions.add(str2);
                } else {
                    arrayList.add(str);
                }
            }
            i++;
        }
        if (arrayList.isEmpty()) {
            permissionRequest2.grant((String[]) this.grantedPermissions.toArray(new String[0]));
            this.grantedPermissions = null;
            return;
        }
        this.permissionRequest = permissionRequest2;
        requestPermissions(arrayList);
    }

    public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        if (ContextCompat.checkSelfPermission(this.mWebView.getThemedReactContext(), "android.permission.ACCESS_FINE_LOCATION") != 0) {
            this.geolocationPermissionCallback = callback;
            this.geolocationPermissionOrigin = str;
            requestPermissions(Collections.singletonList("android.permission.ACCESS_FINE_LOCATION"));
            return;
        }
        callback.invoke(str, true, false);
    }

    private PermissionAwareActivity getPermissionAwareActivity() {
        Activity currentActivity = this.mWebView.getThemedReactContext().getCurrentActivity();
        if (currentActivity == null) {
            throw new IllegalStateException("Tried to use permissions API while not attached to an Activity.");
        } else if (currentActivity instanceof PermissionAwareActivity) {
            return (PermissionAwareActivity) currentActivity;
        } else {
            throw new IllegalStateException("Tried to use permissions API but the host Activity doesn't implement PermissionAwareActivity.");
        }
    }

    private synchronized void requestPermissions(List<String> list) {
        if (this.permissionsRequestShown) {
            this.pendingPermissions.addAll(list);
            return;
        }
        PermissionAwareActivity permissionAwareActivity = getPermissionAwareActivity();
        this.permissionsRequestShown = true;
        permissionAwareActivity.requestPermissions((String[]) list.toArray(new String[0]), 3, this.webviewPermissionsListener);
        this.pendingPermissions.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-reactnativecommunity-webview-RNCWebChromeClient  reason: not valid java name */
    public /* synthetic */ boolean m619lambda$new$0$comreactnativecommunitywebviewRNCWebChromeClient(int i, String[] strArr, int[] iArr) {
        PermissionRequest permissionRequest2;
        List<String> list;
        List<String> list2;
        List<String> list3;
        List<String> list4;
        GeolocationPermissions.Callback callback;
        String str;
        this.permissionsRequestShown = false;
        boolean z = false;
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str2 = strArr[i2];
            boolean z2 = iArr[i2] == 0;
            if (!(!str2.equals("android.permission.ACCESS_FINE_LOCATION") || (callback = this.geolocationPermissionCallback) == null || (str = this.geolocationPermissionOrigin) == null)) {
                if (z2) {
                    callback.invoke(str, true, false);
                } else {
                    callback.invoke(str, false, false);
                }
                this.geolocationPermissionCallback = null;
                this.geolocationPermissionOrigin = null;
            }
            if (str2.equals("android.permission.RECORD_AUDIO")) {
                if (z2 && (list4 = this.grantedPermissions) != null) {
                    list4.add("android.webkit.resource.AUDIO_CAPTURE");
                }
                z = true;
            }
            if (str2.equals("android.permission.CAMERA")) {
                if (z2 && (list3 = this.grantedPermissions) != null) {
                    list3.add("android.webkit.resource.VIDEO_CAPTURE");
                }
                z = true;
            }
            if (str2.equals("android.webkit.resource.PROTECTED_MEDIA_ID")) {
                if (z2 && (list2 = this.grantedPermissions) != null) {
                    list2.add("android.webkit.resource.PROTECTED_MEDIA_ID");
                }
                z = true;
            }
        }
        if (!(!z || (permissionRequest2 = this.permissionRequest) == null || (list = this.grantedPermissions) == null)) {
            permissionRequest2.grant((String[]) list.toArray(new String[0]));
            this.permissionRequest = null;
            this.grantedPermissions = null;
        }
        if (this.pendingPermissions.isEmpty()) {
            return true;
        }
        requestPermissions(this.pendingPermissions);
        return false;
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, str);
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, "");
    }

    /* access modifiers changed from: protected */
    public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
        ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, str);
    }

    public boolean onShowFileChooser(WebView webView, ValueCallback<Uri[]> valueCallback, WebChromeClient.FileChooserParams fileChooserParams) {
        String[] acceptTypes = fileChooserParams.getAcceptTypes();
        boolean z = true;
        if (fileChooserParams.getMode() != 1) {
            z = false;
        }
        return ((RNCWebViewModule) this.mWebView.getThemedReactContext().getNativeModule(RNCWebViewModule.class)).startPhotoPickerIntent(valueCallback, acceptTypes, z, fileChooserParams.isCaptureEnabled());
    }

    public void onHostResume() {
        View view = this.mVideoView;
        if (view != null && view.getSystemUiVisibility() != FULLSCREEN_SYSTEM_UI_VISIBILITY) {
            this.mVideoView.setSystemUiVisibility(FULLSCREEN_SYSTEM_UI_VISIBILITY);
        }
    }

    /* access modifiers changed from: protected */
    public ViewGroup getRootView() {
        return (ViewGroup) this.mWebView.getThemedReactContext().getCurrentActivity().findViewById(16908290);
    }

    public void setProgressChangedFilter(RNCWebView.ProgressChangedFilter progressChangedFilter2) {
        this.progressChangedFilter = progressChangedFilter2;
    }

    public void setAllowsProtectedMedia(boolean z) {
        this.mAllowsProtectedMedia = z;
    }

    public void setHasOnOpenWindowEvent(boolean z) {
        this.mHasOnOpenWindowEvent = z;
    }
}
