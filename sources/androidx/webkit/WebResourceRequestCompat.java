package androidx.webkit;

import android.webkit.WebResourceRequest;
import androidx.webkit.internal.WebResourceRequestAdapter;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;

public class WebResourceRequestCompat {
    private WebResourceRequestCompat() {
    }

    public static boolean isRedirect(WebResourceRequest webResourceRequest) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_RESOURCE_REQUEST_IS_REDIRECT;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return webResourceRequest.isRedirect();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getAdapter(webResourceRequest).isRedirect();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    private static WebResourceRequestAdapter getAdapter(WebResourceRequest webResourceRequest) {
        return WebViewGlueCommunicator.getCompatConverter().convertWebResourceRequest(webResourceRequest);
    }
}
