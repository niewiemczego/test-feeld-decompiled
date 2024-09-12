package com.reactnativecommunity.webview;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.views.scroll.ScrollEventType;
import com.reactnativecommunity.webview.events.TopCustomMenuSelectionEvent;
import com.reactnativecommunity.webview.events.TopHttpErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingErrorEvent;
import com.reactnativecommunity.webview.events.TopLoadingFinishEvent;
import com.reactnativecommunity.webview.events.TopLoadingProgressEvent;
import com.reactnativecommunity.webview.events.TopLoadingStartEvent;
import com.reactnativecommunity.webview.events.TopMessageEvent;
import com.reactnativecommunity.webview.events.TopOpenWindowEvent;
import com.reactnativecommunity.webview.events.TopRenderProcessGoneEvent;
import com.reactnativecommunity.webview.events.TopShouldStartLoadWithRequestEvent;
import java.util.Map;

public class RNCWebViewManager extends SimpleViewManager<RNCWebView> {
    private final RNCWebViewManagerImpl mRNCWebViewManagerImpl = new RNCWebViewManagerImpl();

    public String getName() {
        return "RNCWebView";
    }

    public RNCWebView createViewInstance(ThemedReactContext themedReactContext) {
        return this.mRNCWebViewManagerImpl.createViewInstance(themedReactContext);
    }

    public RNCWebView createViewInstance(ThemedReactContext themedReactContext, RNCWebView rNCWebView) {
        return this.mRNCWebViewManagerImpl.createViewInstance(themedReactContext, rNCWebView);
    }

    @ReactProp(name = "allowFileAccess")
    public void setAllowFileAccess(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowFileAccess(rNCWebView, z);
    }

    @ReactProp(name = "allowFileAccessFromFileURLs")
    public void setAllowFileAccessFromFileURLs(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowFileAccessFromFileURLs(rNCWebView, z);
    }

    @ReactProp(name = "allowUniversalAccessFromFileURLs")
    public void setAllowUniversalAccessFromFileURLs(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowUniversalAccessFromFileURLs(rNCWebView, z);
    }

    @ReactProp(name = "allowsFullscreenVideo")
    public void setAllowsFullscreenVideo(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowsFullscreenVideo(rNCWebView, z);
    }

    @ReactProp(name = "allowsProtectedMedia")
    public void setAllowsProtectedMedia(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setAllowsProtectedMedia(rNCWebView, z);
    }

    @ReactProp(name = "androidLayerType")
    public void setAndroidLayerType(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setAndroidLayerType(rNCWebView, str);
    }

    @ReactProp(name = "applicationNameForUserAgent")
    public void setApplicationNameForUserAgent(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setApplicationNameForUserAgent(rNCWebView, str);
    }

    @ReactProp(name = "basicAuthCredential")
    public void setBasicAuthCredential(RNCWebView rNCWebView, ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.setBasicAuthCredential(rNCWebView, readableMap);
    }

    @ReactProp(name = "cacheEnabled")
    public void setCacheEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setCacheEnabled(rNCWebView, z);
    }

    @ReactProp(name = "cacheMode")
    public void setCacheMode(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setCacheMode(rNCWebView, str);
    }

    @ReactProp(name = "domStorageEnabled")
    public void setDomStorageEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setDomStorageEnabled(rNCWebView, z);
    }

    @ReactProp(name = "downloadingMessage")
    public void setDownloadingMessage(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setDownloadingMessage(str);
    }

    @ReactProp(name = "forceDarkOn")
    public void setForceDarkOn(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setForceDarkOn(rNCWebView, z);
    }

    @ReactProp(name = "geolocationEnabled")
    public void setGeolocationEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setGeolocationEnabled(rNCWebView, z);
    }

    @ReactProp(name = "hasOnScroll")
    public void setHasOnScroll(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setHasOnScroll(rNCWebView, z);
    }

    @ReactProp(name = "incognito")
    public void setIncognito(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setIncognito(rNCWebView, z);
    }

    @ReactProp(name = "injectedJavaScript")
    public void setInjectedJavaScript(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScript(rNCWebView, str);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoaded")
    public void setInjectedJavaScriptBeforeContentLoaded(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptBeforeContentLoaded(rNCWebView, str);
    }

    @ReactProp(name = "injectedJavaScriptForMainFrameOnly")
    public void setInjectedJavaScriptForMainFrameOnly(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptForMainFrameOnly(rNCWebView, z);
    }

    @ReactProp(name = "injectedJavaScriptBeforeContentLoadedForMainFrameOnly")
    public void setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setInjectedJavaScriptBeforeContentLoadedForMainFrameOnly(rNCWebView, z);
    }

    @ReactProp(name = "javaScriptCanOpenWindowsAutomatically")
    public void setJavaScriptCanOpenWindowsAutomatically(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setJavaScriptCanOpenWindowsAutomatically(rNCWebView, z);
    }

    @ReactProp(name = "javaScriptEnabled")
    public void setJavaScriptEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setJavaScriptEnabled(rNCWebView, z);
    }

    @ReactProp(name = "lackPermissionToDownloadMessage")
    public void setLackPermissionToDownloadMessage(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setLackPermissionToDownloadMessage(str);
    }

    @ReactProp(name = "hasOnOpenWindowEvent")
    public void setHasOnOpenWindowEvent(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setHasOnOpenWindowEvent(rNCWebView, z);
    }

    @ReactProp(name = "mediaPlaybackRequiresUserAction")
    public void setMediaPlaybackRequiresUserAction(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setMediaPlaybackRequiresUserAction(rNCWebView, z);
    }

    @ReactProp(name = "messagingEnabled")
    public void setMessagingEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setMessagingEnabled(rNCWebView, z);
    }

    @ReactProp(name = "menuItems")
    public void setMenuCustomItems(RNCWebView rNCWebView, ReadableArray readableArray) {
        this.mRNCWebViewManagerImpl.setMenuCustomItems(rNCWebView, readableArray);
    }

    @ReactProp(name = "messagingModuleName")
    public void setMessagingModuleName(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setMessagingModuleName(rNCWebView, str);
    }

    @ReactProp(name = "minimumFontSize")
    public void setMinimumFontSize(RNCWebView rNCWebView, int i) {
        this.mRNCWebViewManagerImpl.setMinimumFontSize(rNCWebView, i);
    }

    @ReactProp(name = "mixedContentMode")
    public void setMixedContentMode(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setMixedContentMode(rNCWebView, str);
    }

    @ReactProp(name = "nestedScrollEnabled")
    public void setNestedScrollEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setNestedScrollEnabled(rNCWebView, z);
    }

    @ReactProp(name = "overScrollMode")
    public void setOverScrollMode(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setOverScrollMode(rNCWebView, str);
    }

    @ReactProp(name = "saveFormDataDisabled")
    public void setSaveFormDataDisabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setSaveFormDataDisabled(rNCWebView, z);
    }

    @ReactProp(name = "scalesPageToFit")
    public void setScalesPageToFit(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setScalesPageToFit(rNCWebView, z);
    }

    @ReactProp(name = "setBuiltInZoomControls")
    public void setSetBuiltInZoomControls(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setSetBuiltInZoomControls(rNCWebView, z);
    }

    @ReactProp(name = "setDisplayZoomControls")
    public void setSetDisplayZoomControls(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setSetDisplayZoomControls(rNCWebView, z);
    }

    @ReactProp(name = "setSupportMultipleWindows")
    public void setSetSupportMultipleWindows(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setSetSupportMultipleWindows(rNCWebView, z);
    }

    @ReactProp(name = "showsHorizontalScrollIndicator")
    public void setShowsHorizontalScrollIndicator(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setShowsHorizontalScrollIndicator(rNCWebView, z);
    }

    @ReactProp(name = "showsVerticalScrollIndicator")
    public void setShowsVerticalScrollIndicator(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setShowsVerticalScrollIndicator(rNCWebView, z);
    }

    @ReactProp(name = "source")
    public void setSource(RNCWebView rNCWebView, ReadableMap readableMap) {
        this.mRNCWebViewManagerImpl.setSource(rNCWebView, readableMap, false);
    }

    @ReactProp(name = "textZoom")
    public void setTextZoom(RNCWebView rNCWebView, int i) {
        this.mRNCWebViewManagerImpl.setTextZoom(rNCWebView, i);
    }

    @ReactProp(name = "thirdPartyCookiesEnabled")
    public void setThirdPartyCookiesEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setThirdPartyCookiesEnabled(rNCWebView, z);
    }

    @ReactProp(name = "webviewDebuggingEnabled")
    public void setWebviewDebuggingEnabled(RNCWebView rNCWebView, boolean z) {
        this.mRNCWebViewManagerImpl.setWebviewDebuggingEnabled(rNCWebView, z);
    }

    @ReactProp(name = "userAgent")
    public void setUserAgent(RNCWebView rNCWebView, String str) {
        this.mRNCWebViewManagerImpl.setUserAgent(rNCWebView, str);
    }

    /* access modifiers changed from: protected */
    public void addEventEmitters(ThemedReactContext themedReactContext, RNCWebView rNCWebView) {
        rNCWebView.setWebViewClient(new RNCWebViewClient());
    }

    public Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        Map<String, Object> exportedCustomDirectEventTypeConstants = super.getExportedCustomDirectEventTypeConstants();
        if (exportedCustomDirectEventTypeConstants == null) {
            exportedCustomDirectEventTypeConstants = MapBuilder.newHashMap();
        }
        exportedCustomDirectEventTypeConstants.put(TopLoadingStartEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingStart"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingFinishEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingFinish"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingError"));
        exportedCustomDirectEventTypeConstants.put(TopMessageEvent.EVENT_NAME, MapBuilder.of("registrationName", "onMessage"));
        exportedCustomDirectEventTypeConstants.put(TopLoadingProgressEvent.EVENT_NAME, MapBuilder.of("registrationName", "onLoadingProgress"));
        exportedCustomDirectEventTypeConstants.put(TopShouldStartLoadWithRequestEvent.EVENT_NAME, MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
        exportedCustomDirectEventTypeConstants.put(ScrollEventType.getJSEventName(ScrollEventType.SCROLL), MapBuilder.of("registrationName", "onScroll"));
        exportedCustomDirectEventTypeConstants.put(TopHttpErrorEvent.EVENT_NAME, MapBuilder.of("registrationName", "onHttpError"));
        exportedCustomDirectEventTypeConstants.put(TopRenderProcessGoneEvent.EVENT_NAME, MapBuilder.of("registrationName", "onRenderProcessGone"));
        exportedCustomDirectEventTypeConstants.put(TopCustomMenuSelectionEvent.EVENT_NAME, MapBuilder.of("registrationName", "onCustomMenuSelection"));
        exportedCustomDirectEventTypeConstants.put(TopOpenWindowEvent.EVENT_NAME, MapBuilder.of("registrationName", "onOpenWindow"));
        return exportedCustomDirectEventTypeConstants;
    }

    public Map<String, Integer> getCommandsMap() {
        return this.mRNCWebViewManagerImpl.getCommandsMap();
    }

    public void receiveCommand(RNCWebView rNCWebView, String str, ReadableArray readableArray) {
        this.mRNCWebViewManagerImpl.receiveCommand(rNCWebView, str, readableArray);
        super.receiveCommand(rNCWebView, str, readableArray);
    }

    public void onDropViewInstance(RNCWebView rNCWebView) {
        this.mRNCWebViewManagerImpl.onDropViewInstance(rNCWebView);
        super.onDropViewInstance(rNCWebView);
    }
}
