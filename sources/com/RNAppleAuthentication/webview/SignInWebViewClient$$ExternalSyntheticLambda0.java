package com.RNAppleAuthentication.webview;

import android.webkit.WebView;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SignInWebViewClient$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ WebView f$0;
    public final /* synthetic */ SignInWebViewClient f$1;

    public /* synthetic */ SignInWebViewClient$$ExternalSyntheticLambda0(WebView webView, SignInWebViewClient signInWebViewClient) {
        this.f$0 = webView;
        this.f$1 = signInWebViewClient;
    }

    public final void run() {
        SignInWebViewClient.m89shouldInterceptRequest$lambda0(this.f$0, this.f$1);
    }
}
