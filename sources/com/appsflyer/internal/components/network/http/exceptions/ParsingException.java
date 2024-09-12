package com.appsflyer.internal.components.network.http.exceptions;

import com.appsflyer.internal.AFc1aSDK;
import java.io.IOException;

public class ParsingException extends IOException {
    private final AFc1aSDK<String> AFInAppEventType;

    public ParsingException(String str, Throwable th, AFc1aSDK<String> aFc1aSDK) {
        super(str, th);
        this.AFInAppEventType = aFc1aSDK;
    }

    public AFc1aSDK<String> getRawResponse() {
        return this.AFInAppEventType;
    }
}
