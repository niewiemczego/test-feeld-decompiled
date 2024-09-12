package com.reactnativecommunity.webview;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import androidx.core.view.ViewCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, d2 = {"com/reactnativecommunity/webview/RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1", "Lcom/reactnativecommunity/webview/RNCWebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "onHideCustomView", "", "onShowCustomView", "view", "Landroid/view/View;", "callback", "Landroid/webkit/WebChromeClient$CustomViewCallback;", "react-native-webview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNCWebViewManagerImpl.kt */
public final class RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1 extends RNCWebChromeClient {
    final /* synthetic */ Activity $activity;
    final /* synthetic */ int $initialRequestedOrientation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RNCWebViewManagerImpl$setupWebChromeClient$webChromeClient$1(RNCWebView rNCWebView, Activity activity, int i) {
        super(rNCWebView);
        this.$activity = activity;
        this.$initialRequestedOrientation = i;
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }

    public void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(customViewCallback, "callback");
        if (this.mVideoView != null) {
            customViewCallback.onCustomViewHidden();
            return;
        }
        this.mVideoView = view;
        this.mCustomViewCallback = customViewCallback;
        this.$activity.setRequestedOrientation(-1);
        this.mVideoView.setSystemUiVisibility(7942);
        this.$activity.getWindow().setFlags(512, 512);
        this.mVideoView.setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
        ViewGroup rootView = getRootView();
        rootView.addView(this.mVideoView, RNCWebChromeClient.FULLSCREEN_LAYOUT_PARAMS);
        if (rootView.getRootView() != this.mWebView.getRootView()) {
            this.mWebView.getRootView().setVisibility(8);
        } else {
            this.mWebView.setVisibility(8);
        }
        this.mWebView.getThemedReactContext().addLifecycleEventListener(this);
    }

    public void onHideCustomView() {
        if (this.mVideoView != null) {
            ViewGroup rootView = getRootView();
            if (rootView.getRootView() != this.mWebView.getRootView()) {
                this.mWebView.getRootView().setVisibility(0);
            } else {
                this.mWebView.setVisibility(0);
            }
            this.$activity.getWindow().clearFlags(512);
            rootView.removeView(this.mVideoView);
            this.mCustomViewCallback.onCustomViewHidden();
            this.mVideoView = null;
            this.mCustomViewCallback = null;
            this.$activity.setRequestedOrientation(this.$initialRequestedOrientation);
            this.mWebView.getThemedReactContext().removeLifecycleEventListener(this);
        }
    }
}
