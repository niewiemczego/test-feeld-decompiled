package androidx.webkit.internal;

import androidx.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebViewRenderProcessImpl extends WebViewRenderProcess {
    private static WeakHashMap<android.webkit.WebViewRenderProcess, WebViewRenderProcessImpl> sFrameworkMap = new WeakHashMap<>();
    private WebViewRendererBoundaryInterface mBoundaryInterface;
    private WeakReference<android.webkit.WebViewRenderProcess> mFrameworkObject;

    public WebViewRenderProcessImpl(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.mBoundaryInterface = webViewRendererBoundaryInterface;
    }

    public WebViewRenderProcessImpl(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        this.mFrameworkObject = new WeakReference<>(webViewRenderProcess);
    }

    public static WebViewRenderProcessImpl forInvocationHandler(InvocationHandler invocationHandler) {
        final WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebViewRendererBoundaryInterface.class, invocationHandler);
        return (WebViewRenderProcessImpl) webViewRendererBoundaryInterface.getOrCreatePeer(new Callable<Object>() {
            public Object call() {
                return new WebViewRenderProcessImpl(WebViewRendererBoundaryInterface.this);
            }
        });
    }

    public static WebViewRenderProcessImpl forFrameworkObject(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        WebViewRenderProcessImpl webViewRenderProcessImpl = sFrameworkMap.get(webViewRenderProcess);
        if (webViewRenderProcessImpl != null) {
            return webViewRenderProcessImpl;
        }
        WebViewRenderProcessImpl webViewRenderProcessImpl2 = new WebViewRenderProcessImpl(webViewRenderProcess);
        sFrameworkMap.put(webViewRenderProcess, webViewRenderProcessImpl2);
        return webViewRenderProcessImpl2;
    }

    public boolean terminate() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_VIEW_RENDERER_TERMINATE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            android.webkit.WebViewRenderProcess webViewRenderProcess = (android.webkit.WebViewRenderProcess) this.mFrameworkObject.get();
            if (webViewRenderProcess != null) {
                return webViewRenderProcess.terminate();
            }
            return false;
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            return this.mBoundaryInterface.terminate();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
