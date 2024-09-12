package com.appsflyer.internal;

import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.attribution.AppsFlyerRequestListener;
import com.appsflyer.internal.components.network.http.exceptions.ParsingException;
import com.appsflyer.share.LinkGenerator;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public final class AFd1kSDK extends AFd1iSDK<String> {
    private final LinkGenerator.ResponseListener AFLogger$LogLevel;
    private final UUID AFVersionDeclaration;
    private final Map<String, String> afErrorLogForExcManagerOnly;
    private final AFb1bSDK afRDLog;
    private final String afWarnLog;
    private final String getLevel;

    public final long AFInAppEventParameterName() {
        return 3000;
    }

    /* access modifiers changed from: protected */
    public final AppsFlyerRequestListener AFLogger() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final boolean afDebugLog() {
        return false;
    }

    /* access modifiers changed from: protected */
    public final boolean afErrorLogForExcManagerOnly() {
        return false;
    }

    public AFd1kSDK(AFc1vSDK aFc1vSDK, UUID uuid, String str, Map<String, String> map, String str2, LinkGenerator.ResponseListener responseListener) {
        super(AFd1sSDK.ONELINK, new AFd1sSDK[]{AFd1sSDK.RC_CDN}, aFc1vSDK, uuid.toString());
        this.afRDLog = aFc1vSDK.AFInAppEventParameterName();
        this.AFVersionDeclaration = uuid;
        this.getLevel = str;
        this.afErrorLogForExcManagerOnly = new HashMap(map);
        this.AFLogger$LogLevel = responseListener;
        this.afWarnLog = str2;
    }

    public final void AFKeystoreWrapper() {
        super.AFKeystoreWrapper();
        LinkGenerator.ResponseListener responseListener = this.AFLogger$LogLevel;
        if (responseListener == null) {
            return;
        }
        if (this.AFInAppEventType != AFd1tSDK.SUCCESS || this.afInfoLog == null) {
            Throwable afRDLog2 = afRDLog();
            if (!(afRDLog2 instanceof ParsingException)) {
                responseListener.onResponse(AFLogger$LogLevel());
            } else if (((ParsingException) afRDLog2).getRawResponse().isSuccessful()) {
                responseListener.onResponseError("Can't parse one link data");
            } else {
                responseListener.onResponse(AFLogger$LogLevel());
            }
        } else {
            responseListener.onResponse((String) this.afInfoLog.getBody());
        }
    }

    /* access modifiers changed from: protected */
    public final AFc1mSDK<String> AFInAppEventParameterName(String str) {
        return this.afDebugLog.values(this.getLevel, this.afErrorLogForExcManagerOnly, this.afWarnLog, this.AFVersionDeclaration, str);
    }

    private String AFLogger$LogLevel() {
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.ONELINK_DOMAIN);
        String packageName = this.afRDLog.values.AFKeystoreWrapper.getPackageName();
        LinkGenerator addParameters = new LinkGenerator("af_app_invites").setBaseURL(this.getLevel, string, packageName).addParameter("af_siteid", packageName).addParameters(this.afErrorLogForExcManagerOnly);
        AFb1xSDK.AFInAppEventType();
        String valueOf = AFb1xSDK.valueOf();
        if (valueOf != null) {
            addParameters.setReferrerCustomerId(valueOf);
        }
        return addParameters.generateLink();
    }
}
