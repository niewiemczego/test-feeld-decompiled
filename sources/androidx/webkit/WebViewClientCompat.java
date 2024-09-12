package androidx.webkit;

import android.os.Build;
import android.webkit.SafeBrowsingResponse;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.webkit.internal.SafeBrowsingResponseImpl;
import androidx.webkit.internal.WebResourceErrorImpl;
import androidx.webkit.internal.WebViewFeatureInternal;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebViewClientBoundaryInterface;

public class WebViewClientCompat extends WebViewClient implements WebViewClientBoundaryInterface {
    private static final String[] sSupportedFeatures = {"VISUAL_STATE_CALLBACK", "RECEIVE_WEB_RESOURCE_ERROR", "RECEIVE_HTTP_ERROR", "SHOULD_OVERRIDE_WITH_REDIRECTS", "SAFE_BROWSING_HIT"};

    @Retention(RetentionPolicy.SOURCE)
    public @interface SafeBrowsingThreat {
    }

    public void onPageCommitVisible(WebView webView, String str) {
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
    }

    public final String[] getSupportedFeatures() {
        return sSupportedFeatures;
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, InvocationHandler invocationHandler) {
        onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(invocationHandler));
    }

    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (Build.VERSION.SDK_INT >= 23) {
            onReceivedError(webView, webResourceRequest, (WebResourceErrorCompat) new WebResourceErrorImpl(webResourceError));
        }
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceErrorCompat webResourceErrorCompat) {
        if (Build.VERSION.SDK_INT >= 21 && WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_CODE") && WebViewFeature.isFeatureSupported("WEB_RESOURCE_ERROR_GET_DESCRIPTION") && webResourceRequest.isForMainFrame()) {
            onReceivedError(webView, webResourceErrorCompat.getErrorCode(), webResourceErrorCompat.getDescription().toString(), webResourceRequest.getUrl().toString());
        }
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, InvocationHandler invocationHandler) {
        onSafeBrowsingHit(webView, webResourceRequest, i, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(invocationHandler));
    }

    public final void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponse safeBrowsingResponse) {
        onSafeBrowsingHit(webView, webResourceRequest, i, (SafeBrowsingResponseCompat) new SafeBrowsingResponseImpl(safeBrowsingResponse));
    }

    public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i, SafeBrowsingResponseCompat safeBrowsingResponseCompat) {
        if (WebViewFeature.isFeatureSupported("SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL")) {
            safeBrowsingResponseCompat.showInterstitial(true);
            return;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
    }
}
