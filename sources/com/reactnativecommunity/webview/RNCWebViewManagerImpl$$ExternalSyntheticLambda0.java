package com.reactnativecommunity.webview;

import android.webkit.DownloadListener;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class RNCWebViewManagerImpl$$ExternalSyntheticLambda0 implements DownloadListener {
    public final /* synthetic */ RNCWebView f$0;
    public final /* synthetic */ RNCWebViewManagerImpl f$1;

    public /* synthetic */ RNCWebViewManagerImpl$$ExternalSyntheticLambda0(RNCWebView rNCWebView, RNCWebViewManagerImpl rNCWebViewManagerImpl) {
        this.f$0 = rNCWebView;
        this.f$1 = rNCWebViewManagerImpl;
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        RNCWebViewManagerImpl.m621createViewInstance$lambda1(this.f$0, this.f$1, str, str2, str3, str4, j);
    }
}
