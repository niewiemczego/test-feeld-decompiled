package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewProviderAdapter {
    WebViewProviderBoundaryInterface mImpl;

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.mImpl = webViewProviderBoundaryInterface;
    }

    public void insertVisualStateCallback(long j, WebViewCompat.VisualStateCallback visualStateCallback) {
        this.mImpl.insertVisualStateCallback(j, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new VisualStateCallbackAdapter(visualStateCallback)));
    }

    public WebMessagePortCompat[] createWebMessageChannel() {
        InvocationHandler[] createWebMessageChannel = this.mImpl.createWebMessageChannel();
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[createWebMessageChannel.length];
        for (int i = 0; i < createWebMessageChannel.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(createWebMessageChannel[i]);
        }
        return webMessagePortCompatArr;
    }

    public void postWebMessage(WebMessageCompat webMessageCompat, Uri uri) {
        this.mImpl.postMessageToMainFrame(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)), uri);
    }

    public void addWebMessageListener(String str, String[] strArr, WebViewCompat.WebMessageListener webMessageListener) {
        this.mImpl.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageListenerAdapter(webMessageListener)));
    }

    public ScriptReferenceImpl addDocumentStartJavaScript(String str, String[] strArr) {
        return ScriptReferenceImpl.toScriptReferenceCompat(this.mImpl.addDocumentStartJavaScript(str, strArr));
    }

    public void removeWebMessageListener(String str) {
        this.mImpl.removeWebMessageListener(str);
    }

    public WebViewClient getWebViewClient() {
        return this.mImpl.getWebViewClient();
    }

    public WebChromeClient getWebChromeClient() {
        return this.mImpl.getWebChromeClient();
    }

    public WebViewRenderProcess getWebViewRenderProcess() {
        return WebViewRenderProcessImpl.forInvocationHandler(this.mImpl.getWebViewRenderer());
    }

    public WebViewRenderProcessClient getWebViewRenderProcessClient() {
        InvocationHandler webViewRendererClient = this.mImpl.getWebViewRendererClient();
        if (webViewRendererClient == null) {
            return null;
        }
        return ((WebViewRenderProcessClientAdapter) BoundaryInterfaceReflectionUtil.getDelegateFromInvocationHandler(webViewRendererClient)).getWebViewRenderProcessClient();
    }

    public void setWebViewRenderProcessClient(Executor executor, WebViewRenderProcessClient webViewRenderProcessClient) {
        this.mImpl.setWebViewRendererClient(webViewRenderProcessClient != null ? BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebViewRenderProcessClientAdapter(executor, webViewRenderProcessClient)) : null);
    }
}
