package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;

public class WebMessageAdapter implements WebMessageBoundaryInterface {
    private WebMessageCompat mWebMessageCompat;

    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public WebMessageAdapter(WebMessageCompat webMessageCompat) {
        this.mWebMessageCompat = webMessageCompat;
    }

    public String getData() {
        return this.mWebMessageCompat.getData();
    }

    public InvocationHandler[] getPorts() {
        WebMessagePortCompat[] ports = this.mWebMessageCompat.getPorts();
        if (ports == null) {
            return null;
        }
        InvocationHandler[] invocationHandlerArr = new InvocationHandler[ports.length];
        for (int i = 0; i < ports.length; i++) {
            invocationHandlerArr[i] = ports[i].getInvocationHandler();
        }
        return invocationHandlerArr;
    }

    public static WebMessageCompat webMessageCompatFromBoundaryInterface(WebMessageBoundaryInterface webMessageBoundaryInterface) {
        return new WebMessageCompat(webMessageBoundaryInterface.getData(), toWebMessagePortCompats(webMessageBoundaryInterface.getPorts()));
    }

    private static WebMessagePortCompat[] toWebMessagePortCompats(InvocationHandler[] invocationHandlerArr) {
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[invocationHandlerArr.length];
        for (int i = 0; i < invocationHandlerArr.length; i++) {
            webMessagePortCompatArr[i] = new WebMessagePortImpl(invocationHandlerArr[i]);
        }
        return webMessagePortCompatArr;
    }
}
