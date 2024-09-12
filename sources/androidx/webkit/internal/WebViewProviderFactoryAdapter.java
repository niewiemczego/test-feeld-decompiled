package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.ProxyControllerBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {
    WebViewProviderFactoryBoundaryInterface mImpl;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.mImpl = webViewProviderFactoryBoundaryInterface;
    }

    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewProviderBoundaryInterface.class, this.mImpl.createWebView(webView));
    }

    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebkitToCompatConverterBoundaryInterface.class, this.mImpl.getWebkitToCompatConverter());
    }

    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(StaticsBoundaryInterface.class, this.mImpl.getStatics());
    }

    public String[] getWebViewFeatures() {
        return this.mImpl.getSupportedFeatures();
    }

    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        return (ServiceWorkerControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ServiceWorkerControllerBoundaryInterface.class, this.mImpl.getServiceWorkerController());
    }

    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(TracingControllerBoundaryInterface.class, this.mImpl.getTracingController());
    }

    public ProxyControllerBoundaryInterface getProxyController() {
        return (ProxyControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(ProxyControllerBoundaryInterface.class, this.mImpl.getProxyController());
    }
}
