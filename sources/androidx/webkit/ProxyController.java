package androidx.webkit;

import androidx.webkit.internal.ProxyControllerImpl;
import java.util.concurrent.Executor;

public abstract class ProxyController {
    public abstract void clearProxyOverride(Executor executor, Runnable runnable);

    public abstract void setProxyOverride(ProxyConfig proxyConfig, Executor executor, Runnable runnable);

    public static ProxyController getInstance() {
        if (WebViewFeature.isFeatureSupported(WebViewFeature.PROXY_OVERRIDE)) {
            return LAZY_HOLDER.INSTANCE;
        }
        throw new UnsupportedOperationException("Proxy override not supported");
    }

    private static class LAZY_HOLDER {
        static final ProxyController INSTANCE = new ProxyControllerImpl();

        private LAZY_HOLDER() {
        }
    }
}
