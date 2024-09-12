package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.CreateOneLinkHttpTask;
import com.appsflyer.PurchaseHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public final class AFc1uSDK implements AFc1vSDK {
    private ExecutorService AFInAppEventParameterName;
    public AFb1gSDK AFInAppEventType;
    public final AFc1wSDK AFKeystoreWrapper = new AFc1wSDK();
    private AFb1rSDK AFLogger;
    private AFd1pSDK AFLogger$LogLevel;
    private AFf1kSDK AFVersionDeclaration;
    private AFf1rSDK AppsFlyer2dXConversionCallback;
    private AFb1bSDK afDebugLog;
    private ScheduledExecutorService afErrorLog;
    private AFe1kSDK afErrorLogForExcManagerOnly;
    private CreateOneLinkHttpTask afInfoLog;
    private PurchaseHandler afRDLog;
    private AFe1fSDK afWarnLog;
    private AFb1sSDK getLevel;
    private AFc1zSDK init;
    private AFb1zSDK onAppOpenAttributionNative;
    private AFa1hSDK onConversionDataSuccess;
    private AFa1tSDK onDeepLinkingNative;
    private AFd1xSDK onInstallConversionDataLoadedNative;
    private AFc1pSDK onInstallConversionFailureNative;
    private ExecutorService valueOf;
    private final int values = ((int) TimeUnit.SECONDS.toMillis(30));

    public final AFc1kSDK AFKeystoreWrapper() {
        return new AFc1kSDK(onConversionDataSuccess(), AFInAppEventParameterName(), AppsFlyerProperties.getInstance(), onInstallConversionDataLoadedNative());
    }

    private synchronized CreateOneLinkHttpTask onConversionDataSuccess() {
        if (this.afInfoLog == null) {
            this.afInfoLog = new CreateOneLinkHttpTask(new AFc1gSDK(this.values), AFInAppEventType());
        }
        return this.afInfoLog;
    }

    public final synchronized ExecutorService AFInAppEventType() {
        if (this.valueOf == null) {
            this.valueOf = Executors.newCachedThreadPool();
        }
        return this.valueOf;
    }

    public final synchronized ExecutorService valueOf() {
        if (this.AFInAppEventParameterName == null) {
            this.AFInAppEventParameterName = Executors.newSingleThreadExecutor();
        }
        return this.AFInAppEventParameterName;
    }

    public final synchronized ScheduledExecutorService values() {
        if (this.afErrorLog == null) {
            this.afErrorLog = Executors.newScheduledThreadPool(2);
        }
        return this.afErrorLog;
    }

    public final synchronized AFb1bSDK AFInAppEventParameterName() {
        if (this.afDebugLog == null) {
            AFc1wSDK afErrorLogForExcManagerOnly2 = afErrorLogForExcManagerOnly();
            Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
            if (context != null) {
                this.afDebugLog = new AFb1bSDK(afErrorLogForExcManagerOnly2, new AFc1ySDK(AFb1xSDK.valueOf(context)));
            } else {
                throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
            }
        }
        return this.afDebugLog;
    }

    public final AFc1xSDK afErrorLog() {
        Context context = this.AFKeystoreWrapper.AFKeystoreWrapper;
        if (context != null) {
            return new AFc1ySDK(AFb1xSDK.valueOf(context));
        }
        throw new IllegalStateException("Context must be set via setContext method before calling this dependency.");
    }

    public final synchronized PurchaseHandler afInfoLog() {
        if (this.afRDLog == null) {
            this.afRDLog = new PurchaseHandler(this);
        }
        return this.afRDLog;
    }

    public final synchronized AFb1rSDK afRDLog() {
        if (this.AFLogger == null) {
            AFe1tSDK aFe1tSDK = new AFe1tSDK(afErrorLog());
            this.AFLogger = new AFb1rSDK(new AFe1uSDK(), AFInAppEventParameterName(), afWarnLog(), aFe1tSDK, new AFc1kSDK(onConversionDataSuccess(), AFInAppEventParameterName(), AppsFlyerProperties.getInstance(), onInstallConversionDataLoadedNative()), new AFe1rSDK(AFInAppEventParameterName(), aFe1tSDK), afDebugLog());
        }
        return this.AFLogger;
    }

    public final synchronized AFe1fSDK AFLogger() {
        if (this.afWarnLog == null) {
            this.afWarnLog = new AFe1fSDK(afErrorLog());
        }
        return this.afWarnLog;
    }

    public final synchronized AFd1pSDK afDebugLog() {
        if (this.AFLogger$LogLevel == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 300, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>() {
                /* access modifiers changed from: private */
                /* renamed from: valueOf */
                public boolean offer(Runnable runnable) {
                    if (isEmpty()) {
                        return super.offer(runnable);
                    }
                    return false;
                }
            }, new AFa1xSDK());
            threadPoolExecutor.setRejectedExecutionHandler(new AFc1uSDK$$ExternalSyntheticLambda0());
            this.AFLogger$LogLevel = new AFd1pSDK(threadPoolExecutor);
        }
        return this.AFLogger$LogLevel;
    }

    public final synchronized AFb1sSDK AFVersionDeclaration() {
        if (this.getLevel == null) {
            this.getLevel = new AFb1vSDK();
        }
        return this.getLevel;
    }

    public final synchronized AFf1kSDK getLevel() {
        if (this.AFVersionDeclaration == null) {
            this.AFVersionDeclaration = new AFf1kSDK();
        }
        return this.AFVersionDeclaration;
    }

    public final synchronized AFe1kSDK afWarnLog() {
        if (this.afErrorLogForExcManagerOnly == null) {
            this.afErrorLogForExcManagerOnly = new AFe1kSDK(afErrorLogForExcManagerOnly(), new AFe1sSDK());
        }
        return this.afErrorLogForExcManagerOnly;
    }

    public final synchronized AFc1wSDK afErrorLogForExcManagerOnly() {
        return this.AFKeystoreWrapper;
    }

    public final synchronized AFb1zSDK AFLogger$LogLevel() {
        if (this.onAppOpenAttributionNative == null) {
            this.onAppOpenAttributionNative = new AFc1lSDK(afErrorLogForExcManagerOnly());
        }
        return this.onAppOpenAttributionNative;
    }

    /* access modifiers changed from: private */
    /* renamed from: onAttributionFailureNative */
    public synchronized AFc1pSDK onDeepLinkingNative() {
        if (this.onInstallConversionFailureNative == null) {
            this.onInstallConversionFailureNative = new AFc1pSDK(this);
        }
        return this.onInstallConversionFailureNative;
    }

    public final synchronized AFd1xSDK onInstallConversionDataLoadedNative() {
        if (this.onInstallConversionDataLoadedNative == null) {
            this.onInstallConversionDataLoadedNative = new AFd1xSDK(AFInAppEventParameterName(), afErrorLog());
        }
        return this.onInstallConversionDataLoadedNative;
    }

    public final AFf1rSDK init() {
        if (this.AppsFlyer2dXConversionCallback == null) {
            this.AppsFlyer2dXConversionCallback = new AFf1qSDK();
        }
        return this.AppsFlyer2dXConversionCallback;
    }

    public final synchronized AFa1tSDK onAppOpenAttributionNative() {
        if (this.onDeepLinkingNative == null) {
            this.onDeepLinkingNative = new AFa1tSDK();
        }
        return this.onDeepLinkingNative;
    }

    public final AFc1zSDK AppsFlyer2dXConversionCallback() {
        if (this.init == null) {
            this.init = new AFa1wSDK();
        }
        return this.init;
    }

    public final AFa1hSDK onInstallConversionFailureNative() {
        if (this.onConversionDataSuccess == null) {
            this.onConversionDataSuccess = new AFa1hSDK();
        }
        return this.onConversionDataSuccess;
    }

    public final AFb1gSDK onResponseNative() {
        if (this.AFInAppEventType == null) {
            this.AFInAppEventType = new AFb1dSDK(valueOf(), onAppOpenAttributionNative());
        }
        return this.AFInAppEventType;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void valueOf(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        try {
            threadPoolExecutor.getQueue().put(runnable);
        } catch (InterruptedException e) {
            AFLogger.afErrorLogForExcManagerOnly("could not create executor for queue", e);
            Thread.currentThread().interrupt();
        }
    }

    static class AFa1xSDK implements ThreadFactory {
        private static final AtomicInteger AFInAppEventParameterName = new AtomicInteger();
        private final AtomicInteger values = new AtomicInteger();

        public AFa1xSDK() {
            AFInAppEventParameterName.incrementAndGet();
        }

        public final Thread newThread(Runnable runnable) {
            int i = AFInAppEventParameterName.get();
            return new Thread(runnable, new StringBuilder("queue-").append(i).append("-").append(this.values.incrementAndGet()).toString());
        }
    }
}
