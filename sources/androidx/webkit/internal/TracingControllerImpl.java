package androidx.webkit.internal;

import android.webkit.TracingConfig;
import androidx.webkit.TracingConfig;
import androidx.webkit.TracingController;
import java.io.OutputStream;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

public class TracingControllerImpl extends TracingController {
    private TracingControllerBoundaryInterface mBoundaryInterface;
    private android.webkit.TracingController mFrameworksImpl;

    public TracingControllerImpl() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            this.mFrameworksImpl = android.webkit.TracingController.getInstance();
            this.mBoundaryInterface = null;
        } else if (webViewFeatureInternal.isSupportedByWebView()) {
            this.mFrameworksImpl = null;
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        } else {
            throw WebViewFeatureInternal.getUnsupportedOperationException();
        }
    }

    private android.webkit.TracingController getFrameworksImpl() {
        if (this.mFrameworksImpl == null) {
            this.mFrameworksImpl = android.webkit.TracingController.getInstance();
        }
        return this.mFrameworksImpl;
    }

    private TracingControllerBoundaryInterface getBoundaryInterface() {
        if (this.mBoundaryInterface == null) {
            this.mBoundaryInterface = WebViewGlueCommunicator.getFactory().getTracingController();
        }
        return this.mBoundaryInterface;
    }

    public boolean isTracing() {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return getFrameworksImpl().isTracing();
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getBoundaryInterface().isTracing();
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public void start(TracingConfig tracingConfig) {
        if (tracingConfig != null) {
            WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
            if (webViewFeatureInternal.isSupportedByFramework()) {
                getFrameworksImpl().start(new TracingConfig.Builder().addCategories(new int[]{tracingConfig.getPredefinedCategories()}).addCategories(tracingConfig.getCustomIncludedCategories()).setTracingMode(tracingConfig.getTracingMode()).build());
            } else if (webViewFeatureInternal.isSupportedByWebView()) {
                getBoundaryInterface().start(tracingConfig.getPredefinedCategories(), tracingConfig.getCustomIncludedCategories(), tracingConfig.getTracingMode());
            } else {
                throw WebViewFeatureInternal.getUnsupportedOperationException();
            }
        } else {
            throw new IllegalArgumentException("Tracing config must be non null");
        }
    }

    public boolean stop(OutputStream outputStream, Executor executor) {
        WebViewFeatureInternal webViewFeatureInternal = WebViewFeatureInternal.TRACING_CONTROLLER_BASIC_USAGE;
        if (webViewFeatureInternal.isSupportedByFramework()) {
            return getFrameworksImpl().stop(outputStream, executor);
        }
        if (webViewFeatureInternal.isSupportedByWebView()) {
            return getBoundaryInterface().stop(outputStream, executor);
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }
}
