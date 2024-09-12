package com.appsflyer.deeplink;

import com.appsflyer.AFLogger;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class DeepLinkResult {
    private final DeepLink deepLink;
    private final Error error;
    private final Status status;

    public enum Error {
        TIMEOUT,
        NETWORK,
        HTTP_STATUS_CODE,
        UNEXPECTED,
        DEVELOPER_ERROR
    }

    public enum Status {
        FOUND,
        NOT_FOUND,
        ERROR
    }

    public DeepLinkResult(DeepLink deepLink2, Error error2) {
        this.deepLink = deepLink2;
        this.error = error2;
        if (error2 != null) {
            this.status = Status.ERROR;
        } else if (deepLink2 != null) {
            this.status = Status.FOUND;
        } else {
            this.status = Status.NOT_FOUND;
        }
    }

    public Error getError() {
        return this.error;
    }

    public DeepLink getDeepLink() {
        return this.deepLink;
    }

    public Status getStatus() {
        return this.status;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SDKConstants.PARAM_DEEP_LINK, (Object) this.deepLink);
            jSONObject.put("error", (Object) this.error);
            jSONObject.put("status", (Object) this.status);
        } catch (JSONException e) {
            AFLogger.afErrorLogForExcManagerOnly("error while creating deep link json", e);
        }
        return jSONObject.toString();
    }
}
