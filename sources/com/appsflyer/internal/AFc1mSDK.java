package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;

public final class AFc1mSDK<ResponseBody> {
    private final ExecutorService AFInAppEventParameterName;
    private final AtomicBoolean AFInAppEventType = new AtomicBoolean(false);
    private final AFd1ySDK<ResponseBody> AFKeystoreWrapper;
    public final AFc1rSDK valueOf;
    private final AFc1gSDK values;

    public AFc1mSDK(AFc1rSDK aFc1rSDK, ExecutorService executorService, AFc1gSDK aFc1gSDK, AFd1ySDK<ResponseBody> aFd1ySDK) {
        this.valueOf = aFc1rSDK;
        this.AFInAppEventParameterName = executorService;
        this.values = aFc1gSDK;
        this.AFKeystoreWrapper = aFd1ySDK;
    }

    public final AFc1aSDK<ResponseBody> AFKeystoreWrapper() throws IOException {
        if (!this.AFInAppEventType.getAndSet(true)) {
            AFc1aSDK<String> AFInAppEventParameterName2 = this.values.AFInAppEventParameterName(this.valueOf);
            try {
                return new AFc1aSDK(this.AFKeystoreWrapper.AFInAppEventType(AFInAppEventParameterName2.getBody()), AFInAppEventParameterName2.values, AFInAppEventParameterName2.valueOf, AFInAppEventParameterName2.AFKeystoreWrapper, AFInAppEventParameterName2.AFInAppEventParameterName);
            } catch (JSONException e) {
                AFLogger.afErrorLogForExcManagerOnly("could not parse raw response - execute", e);
                throw new ParsingException(e.getMessage(), e, AFInAppEventParameterName2);
            }
        } else {
            throw new IllegalStateException("Http call is already executed");
        }
    }
}
