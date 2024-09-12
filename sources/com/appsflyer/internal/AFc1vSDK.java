package com.appsflyer.internal;

import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public interface AFc1vSDK {
    AFb1bSDK AFInAppEventParameterName();

    ExecutorService AFInAppEventType();

    AFc1kSDK AFKeystoreWrapper();

    AFe1fSDK AFLogger();

    AFb1zSDK AFLogger$LogLevel();

    AFb1sSDK AFVersionDeclaration();

    AFc1zSDK AppsFlyer2dXConversionCallback();

    AFd1pSDK afDebugLog();

    AFc1xSDK afErrorLog();

    AFc1wSDK afErrorLogForExcManagerOnly();

    PurchaseHandler afInfoLog();

    AFb1rSDK afRDLog();

    AFe1kSDK afWarnLog();

    AFf1kSDK getLevel();

    AFf1rSDK init();

    AFa1tSDK onAppOpenAttributionNative();

    AFc1nSDK onDeepLinkingNative();

    AFd1xSDK onInstallConversionDataLoadedNative();

    AFa1hSDK onInstallConversionFailureNative();

    AFb1gSDK onResponseNative();

    ScheduledExecutorService values();
}
