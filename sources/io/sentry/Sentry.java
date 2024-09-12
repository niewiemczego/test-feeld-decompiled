package io.sentry;

import com.google.android.gms.common.Scopes;
import io.sentry.backpressure.BackpressureMonitor;
import io.sentry.cache.EnvelopeCache;
import io.sentry.config.PropertiesProviderFactory;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.debugmeta.ResourcesDebugMetaLoader;
import io.sentry.internal.modules.CompositeModulesLoader;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.ManifestModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.modules.ResourcesModulesLoader;
import io.sentry.metrics.MetricsApi;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.User;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.util.DebugMetaPropertiesApplier;
import io.sentry.util.FileUtils;
import io.sentry.util.Platform;
import io.sentry.util.thread.MainThreadChecker;
import io.sentry.util.thread.NoOpMainThreadChecker;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;

public final class Sentry {
    public static final String APP_START_PROFILING_CONFIG_FILE_NAME = "app_start_profiling_config";
    private static final boolean GLOBAL_HUB_DEFAULT_MODE = false;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final long classCreationTimestamp = System.currentTimeMillis();
    private static final ThreadLocal<IHub> currentHub = new ThreadLocal<>();
    private static volatile boolean globalHubMode = false;
    private static volatile IHub mainHub = NoOpHub.getInstance();

    public interface OptionsConfiguration<T extends SentryOptions> {
        void configure(T t);
    }

    private Sentry() {
    }

    public static IHub getCurrentHub() {
        if (globalHubMode) {
            return mainHub;
        }
        ThreadLocal<IHub> threadLocal = currentHub;
        IHub iHub = threadLocal.get();
        if (iHub != null && !(iHub instanceof NoOpHub)) {
            return iHub;
        }
        IHub clone = mainHub.clone();
        threadLocal.set(clone);
        return clone;
    }

    public static IHub cloneMainHub() {
        if (globalHubMode) {
            return mainHub;
        }
        return mainHub.clone();
    }

    public static void setCurrentHub(IHub iHub) {
        currentHub.set(iHub);
    }

    public static boolean isEnabled() {
        return getCurrentHub().isEnabled();
    }

    public static void init() {
        init((OptionsConfiguration<SentryOptions>) new Sentry$$ExternalSyntheticLambda0(), false);
    }

    public static void init(String str) {
        init((OptionsConfiguration<SentryOptions>) new Sentry$$ExternalSyntheticLambda1(str));
    }

    public static <T extends SentryOptions> void init(OptionsContainer<T> optionsContainer, OptionsConfiguration<T> optionsConfiguration) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        init(optionsContainer, optionsConfiguration, false);
    }

    public static <T extends SentryOptions> void init(OptionsContainer<T> optionsContainer, OptionsConfiguration<T> optionsConfiguration, boolean z) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        SentryOptions sentryOptions = (SentryOptions) optionsContainer.createInstance();
        applyOptionsConfiguration(optionsConfiguration, sentryOptions);
        init(sentryOptions, z);
    }

    public static void init(OptionsConfiguration<SentryOptions> optionsConfiguration) {
        init(optionsConfiguration, false);
    }

    public static void init(OptionsConfiguration<SentryOptions> optionsConfiguration, boolean z) {
        SentryOptions sentryOptions = new SentryOptions();
        applyOptionsConfiguration(optionsConfiguration, sentryOptions);
        init(sentryOptions, z);
    }

    private static <T extends SentryOptions> void applyOptionsConfiguration(OptionsConfiguration<T> optionsConfiguration, T t) {
        try {
            optionsConfiguration.configure(t);
        } catch (Throwable th) {
            t.getLogger().log(SentryLevel.ERROR, "Error in the 'OptionsConfiguration.configure' callback.", th);
        }
    }

    public static void init(SentryOptions sentryOptions) {
        init(sentryOptions, false);
    }

    private static synchronized void init(SentryOptions sentryOptions, boolean z) {
        synchronized (Sentry.class) {
            if (isEnabled()) {
                sentryOptions.getLogger().log(SentryLevel.WARNING, "Sentry has been already initialized. Previous configuration will be overwritten.", new Object[0]);
            }
            if (initConfigurations(sentryOptions)) {
                sentryOptions.getLogger().log(SentryLevel.INFO, "GlobalHubMode: '%s'", String.valueOf(z));
                globalHubMode = z;
                IHub currentHub2 = getCurrentHub();
                mainHub = new Hub(sentryOptions);
                currentHub.set(mainHub);
                currentHub2.close(true);
                if (sentryOptions.getExecutorService().isClosed()) {
                    sentryOptions.setExecutorService(new SentryExecutorService());
                }
                for (Integration register : sentryOptions.getIntegrations()) {
                    register.register(HubAdapter.getInstance(), sentryOptions);
                }
                notifyOptionsObservers(sentryOptions);
                finalizePreviousSession(sentryOptions, HubAdapter.getInstance());
                handleAppStartProfilingConfig(sentryOptions, sentryOptions.getExecutorService());
            }
        }
    }

    private static void handleAppStartProfilingConfig(SentryOptions sentryOptions, ISentryExecutorService iSentryExecutorService) {
        try {
            iSentryExecutorService.submit((Runnable) new Sentry$$ExternalSyntheticLambda2(sentryOptions));
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. App start profiling config will not be changed. Did you call Sentry.close()?", th);
        }
    }

    static /* synthetic */ void lambda$handleAppStartProfilingConfig$2(SentryOptions sentryOptions) {
        BufferedWriter bufferedWriter;
        String cacheDirPathWithoutDsn = sentryOptions.getCacheDirPathWithoutDsn();
        if (cacheDirPathWithoutDsn != null) {
            File file = new File(cacheDirPathWithoutDsn, APP_START_PROFILING_CONFIG_FILE_NAME);
            try {
                FileUtils.deleteRecursively(file);
                if (sentryOptions.isEnableAppStartProfiling()) {
                    if (!sentryOptions.isTracingEnabled()) {
                        sentryOptions.getLogger().log(SentryLevel.INFO, "Tracing is disabled and app start profiling will not start.", new Object[0]);
                        return;
                    } else if (file.createNewFile()) {
                        SentryAppStartProfilingOptions sentryAppStartProfilingOptions = new SentryAppStartProfilingOptions(sentryOptions, sampleAppStartProfiling(sentryOptions));
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        try {
                            bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, UTF_8));
                            sentryOptions.getSerializer().serialize(sentryAppStartProfilingOptions, (Writer) bufferedWriter);
                            bufferedWriter.close();
                            fileOutputStream.close();
                            return;
                        } catch (Throwable th) {
                            fileOutputStream.close();
                            throw th;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th2) {
                sentryOptions.getLogger().log(SentryLevel.ERROR, "Unable to create app start profiling config file. ", th2);
                return;
            }
        } else {
            return;
        }
        throw th;
    }

    private static TracesSamplingDecision sampleAppStartProfiling(SentryOptions sentryOptions) {
        TransactionContext transactionContext = new TransactionContext("app.launch", Scopes.PROFILE);
        transactionContext.setForNextAppStart(true);
        return new TracesSampler(sentryOptions).sample(new SamplingContext(transactionContext, (CustomSamplingContext) null));
    }

    private static void finalizePreviousSession(SentryOptions sentryOptions, IHub iHub) {
        try {
            sentryOptions.getExecutorService().submit((Runnable) new PreviousSessionFinalizer(sentryOptions, iHub));
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to finalize previous session.", th);
        }
    }

    private static void notifyOptionsObservers(SentryOptions sentryOptions) {
        try {
            sentryOptions.getExecutorService().submit((Runnable) new Sentry$$ExternalSyntheticLambda4(sentryOptions));
        } catch (Throwable th) {
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "Failed to notify options observers.", th);
        }
    }

    static /* synthetic */ void lambda$notifyOptionsObservers$3(SentryOptions sentryOptions) {
        for (IOptionsObserver next : sentryOptions.getOptionsObservers()) {
            next.setRelease(sentryOptions.getRelease());
            next.setProguardUuid(sentryOptions.getProguardUuid());
            next.setSdkVersion(sentryOptions.getSdkVersion());
            next.setDist(sentryOptions.getDist());
            next.setEnvironment(sentryOptions.getEnvironment());
            next.setTags(sentryOptions.getTags());
        }
    }

    private static boolean initConfigurations(SentryOptions sentryOptions) {
        if (sentryOptions.isEnableExternalConfiguration()) {
            sentryOptions.merge(ExternalOptions.from(PropertiesProviderFactory.create(), sentryOptions.getLogger()));
        }
        String dsn = sentryOptions.getDsn();
        if (!sentryOptions.isEnabled() || (dsn != null && dsn.isEmpty())) {
            close();
            return false;
        } else if (dsn != null) {
            new Dsn(dsn);
            ILogger logger = sentryOptions.getLogger();
            if (sentryOptions.isDebug() && (logger instanceof NoOpLogger)) {
                sentryOptions.setLogger(new SystemOutLogger());
                logger = sentryOptions.getLogger();
            }
            logger.log(SentryLevel.INFO, "Initializing SDK with DSN: '%s'", sentryOptions.getDsn());
            String outboxPath = sentryOptions.getOutboxPath();
            if (outboxPath != null) {
                new File(outboxPath).mkdirs();
            } else {
                logger.log(SentryLevel.INFO, "No outbox dir path is defined in options.", new Object[0]);
            }
            String cacheDirPath = sentryOptions.getCacheDirPath();
            if (cacheDirPath != null) {
                new File(cacheDirPath).mkdirs();
                if (sentryOptions.getEnvelopeDiskCache() instanceof NoOpEnvelopeCache) {
                    sentryOptions.setEnvelopeDiskCache(EnvelopeCache.create(sentryOptions));
                }
            }
            String profilingTracesDirPath = sentryOptions.getProfilingTracesDirPath();
            if (sentryOptions.isProfilingEnabled() && profilingTracesDirPath != null) {
                File file = new File(profilingTracesDirPath);
                file.mkdirs();
                try {
                    sentryOptions.getExecutorService().submit((Runnable) new Sentry$$ExternalSyntheticLambda3(file));
                } catch (RejectedExecutionException e) {
                    sentryOptions.getLogger().log(SentryLevel.ERROR, "Failed to call the executor. Old profiles will not be deleted. Did you call Sentry.close()?", (Throwable) e);
                }
            }
            IModulesLoader modulesLoader = sentryOptions.getModulesLoader();
            if (!sentryOptions.isSendModules()) {
                sentryOptions.setModulesLoader(NoOpModulesLoader.getInstance());
            } else if (modulesLoader instanceof NoOpModulesLoader) {
                sentryOptions.setModulesLoader(new CompositeModulesLoader(Arrays.asList(new IModulesLoader[]{new ManifestModulesLoader(sentryOptions.getLogger()), new ResourcesModulesLoader(sentryOptions.getLogger())}), sentryOptions.getLogger()));
            }
            if (sentryOptions.getDebugMetaLoader() instanceof NoOpDebugMetaLoader) {
                sentryOptions.setDebugMetaLoader(new ResourcesDebugMetaLoader(sentryOptions.getLogger()));
            }
            DebugMetaPropertiesApplier.applyToOptions(sentryOptions, sentryOptions.getDebugMetaLoader().loadDebugMeta());
            if (sentryOptions.getMainThreadChecker() instanceof NoOpMainThreadChecker) {
                sentryOptions.setMainThreadChecker(MainThreadChecker.getInstance());
            }
            if (sentryOptions.getPerformanceCollectors().isEmpty()) {
                sentryOptions.addPerformanceCollector(new JavaMemoryCollector());
            }
            if (sentryOptions.isEnableBackpressureHandling() && Platform.isJvm()) {
                sentryOptions.setBackpressureMonitor(new BackpressureMonitor(sentryOptions, HubAdapter.getInstance()));
                sentryOptions.getBackpressureMonitor().start();
            }
            return true;
        } else {
            throw new IllegalArgumentException("DSN is required. Use empty string or set enabled to false in SentryOptions to disable SDK.");
        }
    }

    static /* synthetic */ void lambda$initConfigurations$4(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.lastModified() < classCreationTimestamp - TimeUnit.MINUTES.toMillis(5)) {
                    FileUtils.deleteRecursively(file2);
                }
            }
        }
    }

    public static synchronized void close() {
        synchronized (Sentry.class) {
            IHub currentHub2 = getCurrentHub();
            mainHub = NoOpHub.getInstance();
            currentHub.remove();
            currentHub2.close(false);
        }
    }

    public static SentryId captureEvent(SentryEvent sentryEvent) {
        return getCurrentHub().captureEvent(sentryEvent);
    }

    public static SentryId captureEvent(SentryEvent sentryEvent, ScopeCallback scopeCallback) {
        return getCurrentHub().captureEvent(sentryEvent, scopeCallback);
    }

    public static SentryId captureEvent(SentryEvent sentryEvent, Hint hint) {
        return getCurrentHub().captureEvent(sentryEvent, hint);
    }

    public static SentryId captureEvent(SentryEvent sentryEvent, Hint hint, ScopeCallback scopeCallback) {
        return getCurrentHub().captureEvent(sentryEvent, hint, scopeCallback);
    }

    public static SentryId captureMessage(String str) {
        return getCurrentHub().captureMessage(str);
    }

    public static SentryId captureMessage(String str, ScopeCallback scopeCallback) {
        return getCurrentHub().captureMessage(str, scopeCallback);
    }

    public static SentryId captureMessage(String str, SentryLevel sentryLevel) {
        return getCurrentHub().captureMessage(str, sentryLevel);
    }

    public static SentryId captureMessage(String str, SentryLevel sentryLevel, ScopeCallback scopeCallback) {
        return getCurrentHub().captureMessage(str, sentryLevel, scopeCallback);
    }

    public static SentryId captureException(Throwable th) {
        return getCurrentHub().captureException(th);
    }

    public static SentryId captureException(Throwable th, ScopeCallback scopeCallback) {
        return getCurrentHub().captureException(th, scopeCallback);
    }

    public static SentryId captureException(Throwable th, Hint hint) {
        return getCurrentHub().captureException(th, hint);
    }

    public static SentryId captureException(Throwable th, Hint hint, ScopeCallback scopeCallback) {
        return getCurrentHub().captureException(th, hint, scopeCallback);
    }

    public static void captureUserFeedback(UserFeedback userFeedback) {
        getCurrentHub().captureUserFeedback(userFeedback);
    }

    public static void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
        getCurrentHub().addBreadcrumb(breadcrumb, hint);
    }

    public static void addBreadcrumb(Breadcrumb breadcrumb) {
        getCurrentHub().addBreadcrumb(breadcrumb);
    }

    public static void addBreadcrumb(String str) {
        getCurrentHub().addBreadcrumb(str);
    }

    public static void addBreadcrumb(String str, String str2) {
        getCurrentHub().addBreadcrumb(str, str2);
    }

    public static void setLevel(SentryLevel sentryLevel) {
        getCurrentHub().setLevel(sentryLevel);
    }

    public static void setTransaction(String str) {
        getCurrentHub().setTransaction(str);
    }

    public static void setUser(User user) {
        getCurrentHub().setUser(user);
    }

    public static void setFingerprint(List<String> list) {
        getCurrentHub().setFingerprint(list);
    }

    public static void clearBreadcrumbs() {
        getCurrentHub().clearBreadcrumbs();
    }

    public static void setTag(String str, String str2) {
        getCurrentHub().setTag(str, str2);
    }

    public static void removeTag(String str) {
        getCurrentHub().removeTag(str);
    }

    public static void setExtra(String str, String str2) {
        getCurrentHub().setExtra(str, str2);
    }

    public static void removeExtra(String str) {
        getCurrentHub().removeExtra(str);
    }

    public static SentryId getLastEventId() {
        return getCurrentHub().getLastEventId();
    }

    public static void pushScope() {
        if (!globalHubMode) {
            getCurrentHub().pushScope();
        }
    }

    public static void popScope() {
        if (!globalHubMode) {
            getCurrentHub().popScope();
        }
    }

    public static void withScope(ScopeCallback scopeCallback) {
        getCurrentHub().withScope(scopeCallback);
    }

    public static void configureScope(ScopeCallback scopeCallback) {
        getCurrentHub().configureScope(scopeCallback);
    }

    public static void bindClient(ISentryClient iSentryClient) {
        getCurrentHub().bindClient(iSentryClient);
    }

    public static boolean isHealthy() {
        return getCurrentHub().isHealthy();
    }

    public static void flush(long j) {
        getCurrentHub().flush(j);
    }

    public static void startSession() {
        getCurrentHub().startSession();
    }

    public static void endSession() {
        getCurrentHub().endSession();
    }

    public static ITransaction startTransaction(String str, String str2) {
        return getCurrentHub().startTransaction(str, str2);
    }

    public static ITransaction startTransaction(String str, String str2, TransactionOptions transactionOptions) {
        return getCurrentHub().startTransaction(str, str2, transactionOptions);
    }

    public static ITransaction startTransaction(String str, String str2, String str3, TransactionOptions transactionOptions) {
        ITransaction startTransaction = getCurrentHub().startTransaction(str, str2, transactionOptions);
        startTransaction.setDescription(str3);
        return startTransaction;
    }

    public static ITransaction startTransaction(TransactionContext transactionContext) {
        return getCurrentHub().startTransaction(transactionContext);
    }

    public static ITransaction startTransaction(TransactionContext transactionContext, TransactionOptions transactionOptions) {
        return getCurrentHub().startTransaction(transactionContext, transactionOptions);
    }

    @Deprecated
    public static SentryTraceHeader traceHeaders() {
        return getCurrentHub().traceHeaders();
    }

    public static ISpan getSpan() {
        if (!globalHubMode || !Platform.isAndroid()) {
            return getCurrentHub().getSpan();
        }
        return getCurrentHub().getTransaction();
    }

    public static Boolean isCrashedLastRun() {
        return getCurrentHub().isCrashedLastRun();
    }

    public static void reportFullyDisplayed() {
        getCurrentHub().reportFullyDisplayed();
    }

    @Deprecated
    public static void reportFullDisplayed() {
        reportFullyDisplayed();
    }

    public static MetricsApi metrics() {
        return getCurrentHub().metrics();
    }

    public static TransactionContext continueTrace(String str, List<String> list) {
        return getCurrentHub().continueTrace(str, list);
    }

    public static SentryTraceHeader getTraceparent() {
        return getCurrentHub().getTraceparent();
    }

    public static BaggageHeader getBaggage() {
        return getCurrentHub().getBaggage();
    }

    public static SentryId captureCheckIn(CheckIn checkIn) {
        return getCurrentHub().captureCheckIn(checkIn);
    }
}
