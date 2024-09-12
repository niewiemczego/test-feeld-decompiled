package com.appsflyer.internal;

public enum AFd1sSDK {
    RC_CDN(1),
    LOAD_CACHE(2),
    CACHED_EVENT(2),
    CONVERSION(2),
    ONELINK(2),
    DLSDK(2),
    RESOLVE_ESP(2),
    ATTR(2),
    GCDSDK(3),
    REGISTER(4),
    LAUNCH(4),
    INAPP(4),
    PURCHASE_VALIDATE(4),
    SDK_SERVICES(4),
    STATS(4),
    IMPRESSIONS(4),
    MONITORSDK(4),
    ARS_VALIDATE(4),
    ADREVENUE(4);
    
    public final int onInstallConversionDataLoadedNative;

    private AFd1sSDK(int i) {
        this.onInstallConversionDataLoadedNative = i;
    }
}
