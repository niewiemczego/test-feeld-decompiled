package com.appsflyer;

import com.appsflyer.internal.AFc1gSDK;
import java.util.concurrent.ExecutorService;

@Deprecated
public final class CreateOneLinkHttpTask {
    public final AFc1gSDK AFInAppEventParameterName;
    public final ExecutorService valueOf;

    @Deprecated
    public interface ResponseListener {
        void onResponse(String str);

        void onResponseError(String str);
    }

    public CreateOneLinkHttpTask() {
    }

    public CreateOneLinkHttpTask(AFc1gSDK aFc1gSDK, ExecutorService executorService) {
        this.AFInAppEventParameterName = aFc1gSDK;
        this.valueOf = executorService;
    }
}
