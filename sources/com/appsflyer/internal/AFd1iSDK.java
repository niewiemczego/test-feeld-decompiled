package com.appsflyer.internal;

import com.appsflyer.AFLogger;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.attribution.RequestError;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import java.io.IOException;

public abstract class AFd1iSDK<Result> extends AFd1qSDK<AFc1aSDK<Result>> {
    public final AFe1kSDK AFLogger;
    protected final AFc1kSDK afDebugLog;
    protected final AFb1sSDK afErrorLog;
    public AFc1aSDK<Result> afInfoLog;
    private AFb1zSDK afRDLog;
    private String afWarnLog;

    public long AFInAppEventParameterName() {
        return 60000;
    }

    /* access modifiers changed from: protected */
    public abstract AFc1mSDK<Result> AFInAppEventParameterName(String str);

    /* access modifiers changed from: protected */
    public abstract AppsFlyerRequestListener AFLogger();

    /* access modifiers changed from: protected */
    public abstract boolean afDebugLog();

    /* access modifiers changed from: protected */
    public boolean afErrorLogForExcManagerOnly() {
        return true;
    }

    private AFd1iSDK(AFd1sSDK aFd1sSDK, AFd1sSDK[] aFd1sSDKArr, AFc1kSDK aFc1kSDK, AFe1kSDK aFe1kSDK, AFb1sSDK aFb1sSDK, AFb1zSDK aFb1zSDK, String str) {
        super(aFd1sSDK, aFd1sSDKArr, str);
        this.afDebugLog = aFc1kSDK;
        this.AFLogger = aFe1kSDK;
        this.afErrorLog = aFb1sSDK;
        this.afRDLog = aFb1zSDK;
    }

    public AFd1iSDK(AFd1sSDK aFd1sSDK, AFd1sSDK[] aFd1sSDKArr, AFc1vSDK aFc1vSDK, String str) {
        this(aFd1sSDK, aFd1sSDKArr, aFc1vSDK.AFKeystoreWrapper(), aFc1vSDK.afWarnLog(), aFc1vSDK.AFVersionDeclaration(), aFc1vSDK.AFLogger$LogLevel(), str);
    }

    public AFd1iSDK(AFd1sSDK aFd1sSDK, AFd1sSDK[] aFd1sSDKArr, AFc1vSDK aFc1vSDK, String str, String str2) {
        this(aFd1sSDK, aFd1sSDKArr, aFc1vSDK.AFKeystoreWrapper(), aFc1vSDK.afWarnLog(), aFc1vSDK.AFVersionDeclaration(), aFc1vSDK.AFLogger$LogLevel(), str);
        this.afWarnLog = str2;
    }

    public final void valueOf() {
        String str;
        super.valueOf();
        if (afDebugLog() && (str = this.AFLogger.AFInAppEventType) != null && !str.trim().isEmpty()) {
            valueOf(AFInAppEventParameterName(str).valueOf);
        }
    }

    public AFd1tSDK AFInAppEventType() throws Exception {
        if (!afErrorLogForExcManagerOnly() || !this.AFLogger.valueOf()) {
            String str = this.AFLogger.AFInAppEventType;
            if (str == null || str.trim().isEmpty()) {
                AppsFlyerRequestListener AFLogger2 = AFLogger();
                if (AFLogger2 != null) {
                    AFLogger2.onError(RequestError.NO_DEV_KEY, AFb1aSDK.values);
                }
                throw new AFd1oSDK();
            }
            AFc1mSDK AFInAppEventParameterName = AFInAppEventParameterName(str);
            if (afDebugLog()) {
                valueOf(AFInAppEventParameterName.valueOf);
            }
            AFc1aSDK<Result> AFKeystoreWrapper = AFInAppEventParameterName.AFKeystoreWrapper();
            this.afInfoLog = AFKeystoreWrapper;
            this.afErrorLog.values(AFInAppEventParameterName.valueOf.values(), AFKeystoreWrapper.getStatusCode(), AFKeystoreWrapper.getBody().toString());
            AppsFlyerRequestListener AFLogger3 = AFLogger();
            if (AFLogger3 != null) {
                if (AFKeystoreWrapper.isSuccessful()) {
                    AFLogger3.onSuccess();
                } else {
                    AFLogger3.onError(RequestError.RESPONSE_CODE_FAILURE, new StringBuilder().append(AFb1aSDK.AFKeystoreWrapper).append(" ").append(AFKeystoreWrapper.getStatusCode()).toString());
                }
            }
            if (AFKeystoreWrapper.isSuccessful()) {
                return AFd1tSDK.SUCCESS;
            }
            return AFd1tSDK.FAILURE;
        }
        AppsFlyerRequestListener AFLogger4 = AFLogger();
        if (AFLogger4 != null) {
            AFLogger4.onError(RequestError.STOP_TRACKING, AFb1aSDK.valueOf);
        }
        throw new AFd1nSDK();
    }

    public boolean values() {
        if (afRDLog() instanceof AFd1nSDK) {
            return false;
        }
        if (this.AFInAppEventType == AFd1tSDK.TIMEOUT) {
            return true;
        }
        Throwable afRDLog2 = afRDLog();
        if (!(afRDLog2 instanceof IOException) || (afRDLog2 instanceof ParsingException)) {
            return false;
        }
        return true;
    }

    public final void valueOf(Throwable th) {
        AFLogger.afErrorLog("Error while sending request to server: ".concat(String.valueOf(th)), th, true);
        AppsFlyerRequestListener AFLogger2 = AFLogger();
        if (AFLogger2 != null) {
            String message = th.getMessage();
            int i = RequestError.NETWORK_FAILURE;
            if (message == null) {
                message = "";
            }
            AFLogger2.onError(i, message);
        }
    }

    private void valueOf(AFc1rSDK aFc1rSDK) {
        String str = this.afWarnLog;
        this.afWarnLog = this.afRDLog.AFKeystoreWrapper(new AFa1oSDK(aFc1rSDK.values(), aFc1rSDK.AFInAppEventType(), "6.10.3", this.values));
        if (str != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }

    public void AFKeystoreWrapper() {
        String str;
        if (this.AFInAppEventType == AFd1tSDK.SUCCESS) {
            String str2 = this.afWarnLog;
            if (str2 != null) {
                this.afRDLog.AFKeystoreWrapper(str2);
            }
        } else if (!values() && (str = this.afWarnLog) != null) {
            this.afRDLog.AFKeystoreWrapper(str);
        }
    }
}
