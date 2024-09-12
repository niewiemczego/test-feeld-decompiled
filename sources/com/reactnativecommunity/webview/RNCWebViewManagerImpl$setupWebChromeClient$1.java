package com.reactnativecommunity.webview;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/reactnativecommunity/webview/RNCWebViewManagerImpl$setupWebChromeClient$1", "Lcom/reactnativecommunity/webview/RNCWebChromeClient;", "getDefaultVideoPoster", "Landroid/graphics/Bitmap;", "react-native-webview_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: RNCWebViewManagerImpl.kt */
public final class RNCWebViewManagerImpl$setupWebChromeClient$1 extends RNCWebChromeClient {
    RNCWebViewManagerImpl$setupWebChromeClient$1(RNCWebView rNCWebView) {
        super(rNCWebView);
    }

    public Bitmap getDefaultVideoPoster() {
        return Bitmap.createBitmap(50, 50, Bitmap.Config.ARGB_8888);
    }
}
