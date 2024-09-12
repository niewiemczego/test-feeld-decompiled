package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {
    private SafeBrowsingResponseBoundaryInterface mBoundaryInterface;
    private SafeBrowsingResponse mFrameworksImpl;

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        this.mFrameworksImpl = safeBrowsingResponse;
    }

    private SafeBrowsingResponse getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(Proxy.getInvocationHandler(this.mBoundaryInterface));
        }
        return this.mFrameworksImpl;
    }

    private SafeBrowsingResponseBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.castToSuppLibClass(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.getCompatConverter().convertSafeBrowsingResponse(this.mFrameworksImpl));
        }
        return this.mBoundaryInterface;
    }

    public void showInterstitial(boolean z) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_SHOW_INTERSTITIAL;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().showInterstitial(z);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().showInterstitial(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void proceed(boolean z) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_PROCEED;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().proceed(z);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().proceed(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    public void backToSafety(boolean z) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.SAFE_BROWSING_RESPONSE_BACK_TO_SAFETY;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            getFrameworksImpl().backToSafety(z);
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            getBoundaryInterface().backToSafety(z);
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }
}
