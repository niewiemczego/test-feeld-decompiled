package androidx.webkit.internal;

import android.webkit.WebView;
import android.webkit.WebViewRenderProcess;
import android.webkit.WebViewRenderProcessClient;

public class WebViewRenderProcessClientFrameworkAdapter extends WebViewRenderProcessClient {
    private androidx.webkit.WebViewRenderProcessClient mWebViewRenderProcessClient;

    public WebViewRenderProcessClientFrameworkAdapter(androidx.webkit.WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mWebViewRenderProcessClient = webViewRenderProcessClient;
    }

    public void onRenderProcessUnresponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.mWebViewRenderProcessClient.onRenderProcessUnresponsive(webView, WebViewRenderProcessImpl.forFrameworkObject(webViewRenderProcess));
    }

    public void onRenderProcessResponsive(WebView webView, WebViewRenderProcess webViewRenderProcess) {
        this.mWebViewRenderProcessClient.onRenderProcessResponsive(webView, WebViewRenderProcessImpl.forFrameworkObject(webViewRenderProcess));
    }

    public androidx.webkit.WebViewRenderProcessClient getFrameworkRenderProcessClient() {
        return this.mWebViewRenderProcessClient;
    }
}
