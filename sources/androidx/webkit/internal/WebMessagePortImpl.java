package androidx.webkit.internal;

import android.os.Handler;
import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class WebMessagePortImpl extends WebMessagePortCompat {
    private WebMessagePortBoundaryInterface mBoundaryInterface;
    private WebMessagePort mFrameworksImpl;

    public WebMessagePortImpl(WebMessagePort webMessagePort) {
        this.mFrameworksImpl = webMessagePort;
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, invocationHandler);
    }

    private WebMessagePort getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    private WebMessagePortBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertWebMessagePort(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    public void postMessage(WebMessageCompat webMessageCompat) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_MESSAGE_PORT_POST_MESSAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().postMessage(compatToFrameworkMessage(webMessageCompat));
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().postMessage(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageAdapter(webMessageCompat)));
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void close() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_MESSAGE_PORT_CLOSE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().close();
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().close();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setWebMessageCallback(final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
                public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                    webMessageCallbackCompat.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
                }
            });
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)));
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void setWebMessageCallback(Handler handler, final WebMessagePortCompat.WebMessageCallbackCompat webMessageCallbackCompat) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.CREATE_WEB_MESSAGE_CHANNEL;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().setWebMessageCallback(new WebMessagePort.WebMessageCallback() {
                public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
                    webMessageCallbackCompat.onMessage(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.frameworkMessageToCompat(webMessage));
                }
            }, handler);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().setWebMessageCallback(BoundaryInterfaceReflectionUtil.createInvocationHandlerFor(new WebMessageCallbackAdapter(webMessageCallbackCompat)), handler);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public WebMessagePort getFrameworkPort() {
        return getFrameworksImpl();
    }

    public InvocationHandler getInvocationHandler() {
        return Proxy.getInvocationHandler(getBoundaryInterface());
    }

    public static WebMessagePortCompat[] portsToCompat(WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i = 0; i < webMessagePortArr.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(webMessagePortArr[i]);
        }
        return webMessagePortCompatArr;
    }

    public static WebMessagePort[] compatToPorts(WebMessagePortCompat[] webMessagePortCompatArr) {
        if (webMessagePortCompatArr == null) {
            return null;
        }
        int length = webMessagePortCompatArr.length;
        WebMessagePort[] webMessagePortArr = new WebMessagePort[length];
        for (int i = 0; i < length; i++) {
            webMessagePortArr[i] = webMessagePortCompatArr[i].getFrameworkPort();
        }
        return webMessagePortArr;
    }

    public static WebMessage compatToFrameworkMessage(WebMessageCompat webMessageCompat) {
        return new WebMessage(webMessageCompat.getData(), compatToPorts(webMessageCompat.getPorts()));
    }

    public static WebMessageCompat frameworkMessageToCompat(WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), portsToCompat(webMessage.getPorts()));
    }
}
