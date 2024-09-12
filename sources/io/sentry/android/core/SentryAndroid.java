package io.sentry.android.core;

import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.IHub;
import io.sentry.ILogger;
import io.sentry.Integration;
import io.sentry.OptionsContainer;
import io.sentry.Sentry;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.android.core.internal.util.BreadcrumbFactory;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.android.core.performance.TimeSpan;
import io.sentry.android.fragment.FragmentLifecycleIntegration;
import io.sentry.android.timber.SentryTimberIntegration;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public final class SentryAndroid {
    private static final String FRAGMENT_CLASS_NAME = "androidx.fragment.app.FragmentManager$FragmentLifecycleCallbacks";
    static final String SENTRY_FRAGMENT_INTEGRATION_CLASS_NAME = "io.sentry.android.fragment.FragmentLifecycleIntegration";
    static final String SENTRY_TIMBER_INTEGRATION_CLASS_NAME = "io.sentry.android.timber.SentryTimberIntegration";
    private static final String TIMBER_CLASS_NAME = "timber.log.Timber";
    private static final long sdkInitMillis = SystemClock.uptimeMillis();

    static /* synthetic */ void lambda$init$0(SentryAndroidOptions sentryAndroidOptions) {
    }

    private SentryAndroid() {
    }

    public static void init(Context context) {
        init(context, (ILogger) new AndroidLogger());
    }

    public static void init(Context context, ILogger iLogger) {
        init(context, iLogger, new SentryAndroid$$ExternalSyntheticLambda1());
    }

    public static void init(Context context, Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        init(context, new AndroidLogger(), optionsConfiguration);
    }

    public static synchronized void init(Context context, ILogger iLogger, Sentry.OptionsConfiguration<SentryAndroidOptions> optionsConfiguration) {
        synchronized (SentryAndroid.class) {
            try {
                Sentry.init(OptionsContainer.create(SentryAndroidOptions.class), new SentryAndroid$$ExternalSyntheticLambda0(iLogger, context, optionsConfiguration), true);
                IHub currentHub = Sentry.getCurrentHub();
                if (currentHub.getOptions().isEnableAutoSessionTracking() && ContextUtils.isForegroundImportance()) {
                    currentHub.addBreadcrumb(BreadcrumbFactory.forSession("session.start"));
                    currentHub.startSession();
                }
            } catch (IllegalAccessException e) {
                iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e);
            } catch (InstantiationException e2) {
                iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e2);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e2);
            } catch (NoSuchMethodException e3) {
                iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e3);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e3);
            } catch (InvocationTargetException e4) {
                iLogger.log(SentryLevel.FATAL, "Fatal error during SentryAndroid.init(...)", (Throwable) e4);
                throw new RuntimeException("Failed to initialize Sentry's SDK", e4);
            }
        }
    }

    static /* synthetic */ void lambda$init$1(ILogger iLogger, Context context, Sentry.OptionsConfiguration optionsConfiguration, SentryAndroidOptions sentryAndroidOptions) {
        LoadClass loadClass = new LoadClass();
        boolean isClassAvailable = loadClass.isClassAvailable(TIMBER_CLASS_NAME, (SentryOptions) sentryAndroidOptions);
        boolean z = true;
        boolean z2 = loadClass.isClassAvailable(FRAGMENT_CLASS_NAME, (SentryOptions) sentryAndroidOptions) && loadClass.isClassAvailable(SENTRY_FRAGMENT_INTEGRATION_CLASS_NAME, (SentryOptions) sentryAndroidOptions);
        if (!isClassAvailable || !loadClass.isClassAvailable(SENTRY_TIMBER_INTEGRATION_CLASS_NAME, (SentryOptions) sentryAndroidOptions)) {
            z = false;
        }
        BuildInfoProvider buildInfoProvider = new BuildInfoProvider(iLogger);
        LoadClass loadClass2 = new LoadClass();
        ActivityFramesTracker activityFramesTracker = new ActivityFramesTracker(loadClass2, sentryAndroidOptions);
        AndroidOptionsInitializer.loadDefaultAndMetadataOptions(sentryAndroidOptions, context, iLogger, buildInfoProvider);
        AndroidOptionsInitializer.installDefaultIntegrations(context, sentryAndroidOptions, buildInfoProvider, loadClass2, activityFramesTracker, z2, z);
        optionsConfiguration.configure(sentryAndroidOptions);
        AppStartMetrics instance = AppStartMetrics.getInstance();
        if (sentryAndroidOptions.isEnablePerformanceV2() && buildInfoProvider.getSdkInfoVersion() >= 24) {
            TimeSpan appStartTimeSpan = instance.getAppStartTimeSpan();
            if (appStartTimeSpan.hasNotStarted()) {
                appStartTimeSpan.setStartedAt(Process.getStartUptimeMillis());
            }
        }
        TimeSpan sdkInitTimeSpan = instance.getSdkInitTimeSpan();
        if (sdkInitTimeSpan.hasNotStarted()) {
            sdkInitTimeSpan.setStartedAt(sdkInitMillis);
        }
        AndroidOptionsInitializer.initializeIntegrationsAndProcessors(sentryAndroidOptions, context, buildInfoProvider, loadClass2, activityFramesTracker);
        deduplicateIntegrations(sentryAndroidOptions, z2, z);
    }

    private static void deduplicateIntegrations(SentryOptions sentryOptions, boolean z, boolean z2) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (Integration next : sentryOptions.getIntegrations()) {
            if (z && (next instanceof FragmentLifecycleIntegration)) {
                arrayList2.add(next);
            }
            if (z2 && (next instanceof SentryTimberIntegration)) {
                arrayList.add(next);
            }
        }
        if (arrayList2.size() > 1) {
            for (int i = 0; i < arrayList2.size() - 1; i++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList2.get(i));
            }
        }
        if (arrayList.size() > 1) {
            for (int i2 = 0; i2 < arrayList.size() - 1; i2++) {
                sentryOptions.getIntegrations().remove((Integration) arrayList.get(i2));
            }
        }
    }
}
