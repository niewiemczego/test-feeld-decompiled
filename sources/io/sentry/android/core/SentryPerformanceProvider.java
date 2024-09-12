package io.sentry.android.core;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import io.sentry.ILogger;
import io.sentry.ITransactionProfiler;
import io.sentry.JsonSerializer;
import io.sentry.NoOpLogger;
import io.sentry.Sentry;
import io.sentry.SentryAppStartProfilingOptions;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.TracesSamplingDecision;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.ActivityLifecycleCallbacksAdapter;
import io.sentry.android.core.performance.ActivityLifecycleTimeSpan;
import io.sentry.android.core.performance.AppStartMetrics;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public final class SentryPerformanceProvider extends EmptySecureContentProvider {
    private static final long sdkInitMillis = SystemClock.uptimeMillis();
    private Application.ActivityLifecycleCallbacks activityCallback;

    /* renamed from: app  reason: collision with root package name */
    private Application f33app;
    private final BuildInfoProvider buildInfoProvider;
    private final ILogger logger;

    public String getType(Uri uri) {
        return null;
    }

    SentryPerformanceProvider(ILogger iLogger, BuildInfoProvider buildInfoProvider2) {
        this.logger = iLogger;
        this.buildInfoProvider = buildInfoProvider2;
    }

    public SentryPerformanceProvider() {
        AndroidLogger androidLogger = new AndroidLogger();
        this.logger = androidLogger;
        this.buildInfoProvider = new BuildInfoProvider(androidLogger);
    }

    public boolean onCreate() {
        AppStartMetrics instance = AppStartMetrics.getInstance();
        onAppLaunched(getContext(), instance);
        launchAppStartProfiler(instance);
        return true;
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (!SentryPerformanceProvider.class.getName().equals(providerInfo.authority)) {
            super.attachInfo(context, providerInfo);
            return;
        }
        throw new IllegalStateException("An applicationId is required to fulfill the manifest placeholder.");
    }

    public void shutdown() {
        synchronized (AppStartMetrics.getInstance()) {
            ITransactionProfiler appStartProfiler = AppStartMetrics.getInstance().getAppStartProfiler();
            if (appStartProfiler != null) {
                appStartProfiler.close();
            }
        }
    }

    private void launchAppStartProfiler(AppStartMetrics appStartMetrics) {
        BufferedReader bufferedReader;
        Throwable th;
        AppStartMetrics appStartMetrics2 = appStartMetrics;
        Context context = getContext();
        if (context == null) {
            this.logger.log(SentryLevel.FATAL, "App. Context from ContentProvider is null", new Object[0]);
            return;
        } else if (this.buildInfoProvider.getSdkInfoVersion() >= 21) {
            File file = new File(AndroidOptionsInitializer.getCacheDir(context), Sentry.APP_START_PROFILING_CONFIG_FILE_NAME);
            if (file.exists() && file.canRead()) {
                try {
                    bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
                    SentryAppStartProfilingOptions sentryAppStartProfilingOptions = (SentryAppStartProfilingOptions) new JsonSerializer(SentryOptions.empty()).deserialize(bufferedReader, SentryAppStartProfilingOptions.class);
                    if (sentryAppStartProfilingOptions == null) {
                        this.logger.log(SentryLevel.WARNING, "Unable to deserialize the SentryAppStartProfilingOptions. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    } else if (!sentryAppStartProfilingOptions.isProfilingEnabled()) {
                        this.logger.log(SentryLevel.INFO, "Profiling is not enabled. App start profiling will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    } else {
                        TracesSamplingDecision tracesSamplingDecision = new TracesSamplingDecision(Boolean.valueOf(sentryAppStartProfilingOptions.isTraceSampled()), sentryAppStartProfilingOptions.getTraceSampleRate(), Boolean.valueOf(sentryAppStartProfilingOptions.isProfileSampled()), sentryAppStartProfilingOptions.getProfileSampleRate());
                        appStartMetrics2.setAppStartSamplingDecision(tracesSamplingDecision);
                        if (tracesSamplingDecision.getProfileSampled().booleanValue()) {
                            if (tracesSamplingDecision.getSampled().booleanValue()) {
                                this.logger.log(SentryLevel.DEBUG, "App start profiling started.", new Object[0]);
                                AndroidTransactionProfiler androidTransactionProfiler = new AndroidTransactionProfiler(context.getApplicationContext(), this.buildInfoProvider, new SentryFrameMetricsCollector(context.getApplicationContext(), this.logger, this.buildInfoProvider), this.logger, sentryAppStartProfilingOptions.getProfilingTracesDirPath(), sentryAppStartProfilingOptions.isProfilingEnabled(), sentryAppStartProfilingOptions.getProfilingTracesHz(), new SentryExecutorService());
                                appStartMetrics2.setAppStartProfiler(androidTransactionProfiler);
                                androidTransactionProfiler.start();
                                bufferedReader.close();
                                return;
                            }
                        }
                        this.logger.log(SentryLevel.DEBUG, "App start profiling was not sampled. It will not start.", new Object[0]);
                        bufferedReader.close();
                        return;
                    }
                } catch (FileNotFoundException e) {
                    this.logger.log(SentryLevel.ERROR, "App start profiling config file not found. ", (Throwable) e);
                    return;
                } catch (Throwable th2) {
                    this.logger.log(SentryLevel.ERROR, "Error reading app start profiling config file. ", th2);
                    return;
                }
            } else {
                return;
            }
        } else {
            return;
        }
        throw th;
    }

    private void onAppLaunched(Context context, final AppStartMetrics appStartMetrics) {
        appStartMetrics.getSdkInitTimeSpan().setStartedAt(sdkInitMillis);
        if (this.buildInfoProvider.getSdkInfoVersion() >= 24) {
            if (context instanceof Application) {
                this.f33app = (Application) context;
            }
            if (this.f33app != null) {
                appStartMetrics.getAppStartTimeSpan().setStartedAt(Process.getStartUptimeMillis());
                final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
                AnonymousClass1 r0 = new ActivityLifecycleCallbacksAdapter() {
                    final WeakHashMap<Activity, ActivityLifecycleTimeSpan> activityLifecycleMap = new WeakHashMap<>();

                    public void onActivityPreCreated(Activity activity, Bundle bundle) {
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (!appStartMetrics.getAppStartTimeSpan().hasStopped()) {
                            ActivityLifecycleTimeSpan activityLifecycleTimeSpan = new ActivityLifecycleTimeSpan();
                            activityLifecycleTimeSpan.getOnCreate().setStartedAt(uptimeMillis);
                            this.activityLifecycleMap.put(activity, activityLifecycleTimeSpan);
                        }
                    }

                    public void onActivityCreated(Activity activity, Bundle bundle) {
                        AppStartMetrics.AppStartType appStartType;
                        if (appStartMetrics.getAppStartType() == AppStartMetrics.AppStartType.UNKNOWN) {
                            AppStartMetrics appStartMetrics = appStartMetrics;
                            if (bundle == null) {
                                appStartType = AppStartMetrics.AppStartType.COLD;
                            } else {
                                appStartType = AppStartMetrics.AppStartType.WARM;
                            }
                            appStartMetrics.setAppStartType(appStartType);
                        }
                    }

                    public void onActivityPostCreated(Activity activity, Bundle bundle) {
                        ActivityLifecycleTimeSpan activityLifecycleTimeSpan;
                        if (!appStartMetrics.getAppStartTimeSpan().hasStopped() && (activityLifecycleTimeSpan = this.activityLifecycleMap.get(activity)) != null) {
                            activityLifecycleTimeSpan.getOnCreate().stop();
                            activityLifecycleTimeSpan.getOnCreate().setDescription(activity.getClass().getName() + ".onCreate");
                        }
                    }

                    public void onActivityPreStarted(Activity activity) {
                        ActivityLifecycleTimeSpan activityLifecycleTimeSpan;
                        long uptimeMillis = SystemClock.uptimeMillis();
                        if (!appStartMetrics.getAppStartTimeSpan().hasStopped() && (activityLifecycleTimeSpan = this.activityLifecycleMap.get(activity)) != null) {
                            activityLifecycleTimeSpan.getOnStart().setStartedAt(uptimeMillis);
                        }
                    }

                    public void onActivityStarted(Activity activity) {
                        if (!atomicBoolean.get()) {
                            FirstDrawDoneListener.registerForNextDraw(activity, (Runnable) new SentryPerformanceProvider$1$$ExternalSyntheticLambda0(this, atomicBoolean), new BuildInfoProvider(NoOpLogger.getInstance()));
                        }
                    }

                    /* access modifiers changed from: package-private */
                    /* renamed from: lambda$onActivityStarted$0$io-sentry-android-core-SentryPerformanceProvider$1  reason: not valid java name */
                    public /* synthetic */ void m903lambda$onActivityStarted$0$iosentryandroidcoreSentryPerformanceProvider$1(AtomicBoolean atomicBoolean) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            SentryPerformanceProvider.this.onAppStartDone();
                        }
                    }

                    public void onActivityPostStarted(Activity activity) {
                        ActivityLifecycleTimeSpan remove = this.activityLifecycleMap.remove(activity);
                        if (!appStartMetrics.getAppStartTimeSpan().hasStopped() && remove != null) {
                            remove.getOnStart().stop();
                            remove.getOnStart().setDescription(activity.getClass().getName() + ".onStart");
                            appStartMetrics.addActivityLifecycleTimeSpans(remove);
                        }
                    }

                    public void onActivityDestroyed(Activity activity) {
                        this.activityLifecycleMap.remove(activity);
                    }
                };
                this.activityCallback = r0;
                this.f33app.registerActivityLifecycleCallbacks(r0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public synchronized void onAppStartDone() {
        Application.ActivityLifecycleCallbacks activityLifecycleCallbacks;
        AppStartMetrics instance = AppStartMetrics.getInstance();
        instance.getSdkInitTimeSpan().stop();
        instance.getAppStartTimeSpan().stop();
        Application application = this.f33app;
        if (!(application == null || (activityLifecycleCallbacks = this.activityCallback) == null)) {
            application.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    /* access modifiers changed from: package-private */
    public Application.ActivityLifecycleCallbacks getActivityCallback() {
        return this.activityCallback;
    }
}
