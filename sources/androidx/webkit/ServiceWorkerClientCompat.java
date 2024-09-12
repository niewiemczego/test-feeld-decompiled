package androidx.webkit;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;

public abstract class ServiceWorkerClientCompat {
    public abstract WebResourceResponse shouldInterceptRequest(WebResourceRequest webResourceRequest);
}
