package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.ServiceWorkerWebSettings;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebResourceRequestBoundaryInterface;
import org.chromium.support_lib_boundary.WebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebkitToCompatConverter {
    private final WebkitToCompatConverterBoundaryInterface mImpl;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.mImpl = webkitToCompatConverterBoundaryInterface;
    }

    public WebSettingsAdapter convertSettings(WebSettings webSettings) {
        return new WebSettingsAdapter((WebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebSettingsBoundaryInterface.class, this.mImpl.convertSettings(webSettings)));
    }

    public WebResourceRequestAdapter convertWebResourceRequest(WebResourceRequest webResourceRequest) {
        return new WebResourceRequestAdapter((WebResourceRequestBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebResourceRequestBoundaryInterface.class, this.mImpl.convertWebResourceRequest(webResourceRequest)));
    }

    public InvocationHandler convertServiceWorkerSettings(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        return this.mImpl.convertServiceWorkerSettings((Object) serviceWorkerWebSettings);
    }

    public ServiceWorkerWebSettings convertServiceWorkerSettings(InvocationHandler invocationHandler) {
        return (ServiceWorkerWebSettings) this.mImpl.convertServiceWorkerSettings(invocationHandler);
    }

    public InvocationHandler convertWebResourceError(WebResourceError webResourceError) {
        return this.mImpl.convertWebResourceError((Object) webResourceError);
    }

    public WebResourceError convertWebResourceError(InvocationHandler invocationHandler) {
        return (WebResourceError) this.mImpl.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler convertSafeBrowsingResponse(SafeBrowsingResponse safeBrowsingResponse) {
        return this.mImpl.convertSafeBrowsingResponse((Object) safeBrowsingResponse);
    }

    public SafeBrowsingResponse convertSafeBrowsingResponse(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.mImpl.convertSafeBrowsingResponse(invocationHandler);
    }

    public InvocationHandler convertWebMessagePort(WebMessagePort webMessagePort) {
        return this.mImpl.convertWebMessagePort((Object) webMessagePort);
    }

    public WebMessagePort convertWebMessagePort(InvocationHandler invocationHandler) {
        return (WebMessagePort) this.mImpl.convertWebMessagePort(invocationHandler);
    }
}
