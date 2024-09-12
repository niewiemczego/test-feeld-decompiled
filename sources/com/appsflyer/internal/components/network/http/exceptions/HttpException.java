package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFc1eSDK;
import java.io.IOException;

public class HttpException extends IOException {
    private final AFc1eSDK valueOf;

    public HttpException(Throwable th, AFc1eSDK aFc1eSDK) {
        super(th.getMessage(), th);
        this.valueOf = aFc1eSDK;
    }

    public AFc1eSDK getMetrics() {
        return this.valueOf;
    }
}
