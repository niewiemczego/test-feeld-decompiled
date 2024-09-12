package io.sentry.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.sentry.DateUtils;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.IpAddressUtils;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.ContextUtils;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.protocol.App;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SentryThread;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.User;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

final class DefaultAndroidEventProcessor implements EventProcessor {
    private final BuildInfoProvider buildInfoProvider;
    final Context context;
    private final Future<DeviceInfoUtil> deviceInfoUtil;
    private final SentryAndroidOptions options;

    public DefaultAndroidEventProcessor(Context context2, BuildInfoProvider buildInfoProvider2, SentryAndroidOptions sentryAndroidOptions) {
        this.context = (Context) Objects.requireNonNull(context2, "The application context is required.");
        this.buildInfoProvider = (BuildInfoProvider) Objects.requireNonNull(buildInfoProvider2, "The BuildInfoProvider is required.");
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryAndroidOptions, "The options object is required.");
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        this.deviceInfoUtil = newSingleThreadExecutor.submit(new DefaultAndroidEventProcessor$$ExternalSyntheticLambda0(context2, sentryAndroidOptions));
        newSingleThreadExecutor.shutdown();
    }

    public SentryEvent process(SentryEvent sentryEvent, Hint hint) {
        boolean shouldApplyScopeData = shouldApplyScopeData(sentryEvent, hint);
        if (shouldApplyScopeData) {
            processNonCachedEvent(sentryEvent, hint);
            setThreads(sentryEvent, hint);
        }
        setCommons(sentryEvent, true, shouldApplyScopeData);
        fixExceptionOrder(sentryEvent);
        return sentryEvent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void fixExceptionOrder(io.sentry.SentryEvent r4) {
        /*
            java.util.List r4 = r4.getExceptions()
            r0 = 1
            if (r4 == 0) goto L_0x004d
            int r1 = r4.size()
            if (r1 <= r0) goto L_0x004d
            int r1 = r4.size()
            int r1 = r1 - r0
            java.lang.Object r1 = r4.get(r1)
            io.sentry.protocol.SentryException r1 = (io.sentry.protocol.SentryException) r1
            java.lang.String r2 = r1.getModule()
            java.lang.String r3 = "java.lang"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x004d
            io.sentry.protocol.SentryStackTrace r1 = r1.getStacktrace()
            if (r1 == 0) goto L_0x004d
            java.util.List r1 = r1.getFrames()
            if (r1 == 0) goto L_0x004d
            java.util.Iterator r1 = r1.iterator()
        L_0x0034:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004d
            java.lang.Object r2 = r1.next()
            io.sentry.protocol.SentryStackFrame r2 = (io.sentry.protocol.SentryStackFrame) r2
            java.lang.String r2 = r2.getModule()
            java.lang.String r3 = "com.android.internal.os.RuntimeInit$MethodAndArgsCaller"
            boolean r2 = r3.equals(r2)
            if (r2 == 0) goto L_0x0034
            goto L_0x004e
        L_0x004d:
            r0 = 0
        L_0x004e:
            if (r0 == 0) goto L_0x0053
            java.util.Collections.reverse(r4)
        L_0x0053:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.android.core.DefaultAndroidEventProcessor.fixExceptionOrder(io.sentry.SentryEvent):void");
    }

    private void setCommons(SentryBaseEvent sentryBaseEvent, boolean z, boolean z2) {
        mergeUser(sentryBaseEvent);
        setDevice(sentryBaseEvent, z, z2);
        setSideLoadedInfo(sentryBaseEvent);
    }

    private boolean shouldApplyScopeData(SentryBaseEvent sentryBaseEvent, Hint hint) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Event was cached so not applying data relevant to the current app execution/version: %s", sentryBaseEvent.getEventId());
        return false;
    }

    private void mergeUser(SentryBaseEvent sentryBaseEvent) {
        User user = sentryBaseEvent.getUser();
        if (user == null) {
            user = new User();
            sentryBaseEvent.setUser(user);
        }
        if (user.getId() == null) {
            user.setId(Installation.id(this.context));
        }
        if (user.getIpAddress() == null) {
            user.setIpAddress(IpAddressUtils.DEFAULT_IP_ADDRESS);
        }
    }

    private void setDevice(SentryBaseEvent sentryBaseEvent, boolean z, boolean z2) {
        if (sentryBaseEvent.getContexts().getDevice() == null) {
            try {
                sentryBaseEvent.getContexts().setDevice(this.deviceInfoUtil.get().collectDeviceInformation(z, z2));
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "Failed to retrieve device info", th);
            }
            mergeOS(sentryBaseEvent);
        }
    }

    private void mergeOS(SentryBaseEvent sentryBaseEvent) {
        OperatingSystem operatingSystem = sentryBaseEvent.getContexts().getOperatingSystem();
        try {
            sentryBaseEvent.getContexts().setOperatingSystem(this.deviceInfoUtil.get().getOperatingSystem());
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to retrieve os system", th);
        }
        if (operatingSystem != null) {
            String name = operatingSystem.getName();
            sentryBaseEvent.getContexts().put((name == null || name.isEmpty()) ? "os_1" : "os_" + name.trim().toLowerCase(Locale.ROOT), operatingSystem);
        }
    }

    private void processNonCachedEvent(SentryBaseEvent sentryBaseEvent, Hint hint) {
        App app2 = sentryBaseEvent.getContexts().getApp();
        if (app2 == null) {
            app2 = new App();
        }
        setAppExtras(app2, hint);
        setPackageInfo(sentryBaseEvent, app2);
        sentryBaseEvent.getContexts().setApp(app2);
    }

    private void setThreads(SentryEvent sentryEvent, Hint hint) {
        if (sentryEvent.getThreads() != null) {
            boolean isFromHybridSdk = HintUtils.isFromHybridSdk(hint);
            for (SentryThread next : sentryEvent.getThreads()) {
                boolean isMainThread = AndroidMainThreadChecker.getInstance().isMainThread(next);
                if (next.isCurrent() == null) {
                    next.setCurrent(Boolean.valueOf(isMainThread));
                }
                if (!isFromHybridSdk && next.isMain() == null) {
                    next.setMain(Boolean.valueOf(isMainThread));
                }
            }
        }
    }

    private void setPackageInfo(SentryBaseEvent sentryBaseEvent, App app2) {
        PackageInfo packageInfo = ContextUtils.getPackageInfo(this.context, 4096, this.options.getLogger(), this.buildInfoProvider);
        if (packageInfo != null) {
            setDist(sentryBaseEvent, ContextUtils.getVersionCode(packageInfo, this.buildInfoProvider));
            ContextUtils.setAppPackageInfo(packageInfo, this.buildInfoProvider, app2);
        }
    }

    private void setDist(SentryBaseEvent sentryBaseEvent, String str) {
        if (sentryBaseEvent.getDist() == null) {
            sentryBaseEvent.setDist(str);
        }
    }

    private void setAppExtras(App app2, Hint hint) {
        Boolean isInBackground;
        app2.setAppName(ContextUtils.getApplicationName(this.context, this.options.getLogger()));
        TimeSpan appStartTimeSpanWithFallback = AppStartMetrics.getInstance().getAppStartTimeSpanWithFallback(this.options);
        if (appStartTimeSpanWithFallback.hasStarted()) {
            app2.setAppStartTime(DateUtils.toUtilDate(appStartTimeSpanWithFallback.getStartTimestamp()));
        }
        if (!HintUtils.isFromHybridSdk(hint) && app2.getInForeground() == null && (isInBackground = AppState.getInstance().isInBackground()) != null) {
            app2.setInForeground(Boolean.valueOf(!isInBackground.booleanValue()));
        }
    }

    public User getDefaultUser(Context context2) {
        User user = new User();
        user.setId(Installation.id(context2));
        return user;
    }

    private void setSideLoadedInfo(SentryBaseEvent sentryBaseEvent) {
        try {
            ContextUtils.SideLoadedInfo sideLoadedInfo = this.deviceInfoUtil.get().getSideLoadedInfo();
            if (sideLoadedInfo != null) {
                for (Map.Entry next : sideLoadedInfo.asTags().entrySet()) {
                    sentryBaseEvent.setTag((String) next.getKey(), (String) next.getValue());
                }
            }
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Error getting side loaded info.", th);
        }
    }

    public SentryTransaction process(SentryTransaction sentryTransaction, Hint hint) {
        boolean shouldApplyScopeData = shouldApplyScopeData(sentryTransaction, hint);
        if (shouldApplyScopeData) {
            processNonCachedEvent(sentryTransaction, hint);
        }
        setCommons(sentryTransaction, false, shouldApplyScopeData);
        return sentryTransaction;
    }
}
