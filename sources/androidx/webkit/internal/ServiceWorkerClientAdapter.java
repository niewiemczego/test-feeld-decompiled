package androidx.webkit.internal;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import androidx.webkit.ServiceWorkerClientCompat;
import org.chromium.support_lib_boundary.ServiceWorkerClientBoundaryInterface;

public class ServiceWorkerClientAdapter implements ServiceWorkerClientBoundaryInterface {
    private final ServiceWorkerClientCompat mClient;

    public ServiceWorkerClientAdapter(ServiceWorkerClientCompat serviceWorkerClientCompat) {
        this.mClient = serviceWorkerClientCompat;
    }

    public WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest) {
        return this.mClient.shouldInterceptRequest(webResourceRequest);
    }

    public String[] getSupportedFeatures() {
        return new String[]{"SERVICE_WORKER_SHOULD_INTERCEPT_REQUEST"};
    }
}
