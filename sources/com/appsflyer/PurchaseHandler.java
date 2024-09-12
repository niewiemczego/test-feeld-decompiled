package com.appsflyer;

import com.appsflyer.internal.AFb1bSDK;
import com.appsflyer.internal.AFb1ySDK;
import com.appsflyer.internal.AFc1vSDK;
import com.appsflyer.internal.AFd1pSDK;
import com.appsflyer.internal.components.network.http.ResponseNetwork;
import java.util.Map;

public final class PurchaseHandler {
    private final AFb1bSDK AFKeystoreWrapper;
    public final AFc1vSDK valueOf;
    public final AFd1pSDK values;

    public interface PurchaseValidationCallback {
        void onFailure(Throwable th);

        void onResponse(ResponseNetwork<String> responseNetwork);
    }

    public PurchaseHandler(AFc1vSDK aFc1vSDK) {
        this.valueOf = aFc1vSDK;
        this.AFKeystoreWrapper = aFc1vSDK.AFInAppEventParameterName();
        this.values = aFc1vSDK.afDebugLog();
    }

    public final boolean AFKeystoreWrapper(Map<String, Object> map, PurchaseValidationCallback purchaseValidationCallback, String... strArr) {
        boolean AFKeystoreWrapper2 = AFb1ySDK.AFKeystoreWrapper(map, strArr, this.AFKeystoreWrapper);
        if (!AFKeystoreWrapper2 && purchaseValidationCallback != null) {
            purchaseValidationCallback.onFailure(new IllegalArgumentException("Invalid Request Data"));
        }
        return AFKeystoreWrapper2;
    }
}
