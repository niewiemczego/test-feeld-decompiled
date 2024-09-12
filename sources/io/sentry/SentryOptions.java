package io.sentry;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import io.sentry.backpressure.IBackpressureMonitor;
import io.sentry.backpressure.NoOpBackpressureMonitor;
import io.sentry.cache.IEnvelopeCache;
import io.sentry.clientreport.ClientReportRecorder;
import io.sentry.clientreport.IClientReportRecorder;
import io.sentry.clientreport.NoOpClientReportRecorder;
import io.sentry.internal.debugmeta.IDebugMetaLoader;
import io.sentry.internal.debugmeta.NoOpDebugMetaLoader;
import io.sentry.internal.gestures.GestureTargetLocator;
import io.sentry.internal.modules.IModulesLoader;
import io.sentry.internal.modules.NoOpModulesLoader;
import io.sentry.internal.viewhierarchy.ViewHierarchyExporter;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransportGate;
import io.sentry.transport.NoOpEnvelopeCache;
import io.sentry.transport.NoOpTransportGate;
import io.sentry.util.Platform;
import io.sentry.util.SampleRateUtils;
import io.sentry.util.StringUtils;
import io.sentry.util.thread.IMainThreadChecker;
import io.sentry.util.thread.NoOpMainThreadChecker;
import java.io.File;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.net.ssl.SSLSocketFactory;
import zendesk.android.internal.network.NetworkModule;

public class SentryOptions {
    static final SentryLevel DEFAULT_DIAGNOSTIC_LEVEL = SentryLevel.DEBUG;
    private static final String DEFAULT_ENVIRONMENT = "production";
    public static final String DEFAULT_PROPAGATION_TARGETS = ".*";
    private boolean attachServerName;
    private boolean attachStacktrace;
    private boolean attachThreads;
    private IBackpressureMonitor backpressureMonitor;
    private BeforeBreadcrumbCallback beforeBreadcrumb;
    private BeforeEmitMetricCallback beforeEmitMetricCallback;
    private BeforeEnvelopeCallback beforeEnvelopeCallback;
    private BeforeSendCallback beforeSend;
    private BeforeSendTransactionCallback beforeSendTransaction;
    private final Set<String> bundleIds;
    private String cacheDirPath;
    IClientReportRecorder clientReportRecorder;
    private IConnectionStatusProvider connectionStatusProvider;
    private int connectionTimeoutMillis;
    private final List<String> contextTags;
    private Cron cron;
    private SentryDateProvider dateProvider;
    private boolean debug;
    private IDebugMetaLoader debugMetaLoader;
    private final List<String> defaultTracePropagationTargets;
    private SentryLevel diagnosticLevel;
    private String dist;
    private String distinctId;
    private String dsn;
    private String dsnHash;
    private boolean enableAppStartProfiling;
    private boolean enableAutoSessionTracking;
    private boolean enableBackpressureHandling;
    private boolean enableDeduplication;
    private boolean enableDefaultTagsForMetrics;
    private boolean enableExternalConfiguration;
    private boolean enableMetrics;
    private boolean enablePrettySerializationOutput;
    private boolean enableScopePersistence;
    private boolean enableShutdownHook;
    private boolean enableSpanLocalMetricAggregation;
    private boolean enableSpotlight;
    private boolean enableTimeToFullDisplayTracing;
    private Boolean enableTracing;
    private boolean enableUncaughtExceptionHandler;
    private boolean enableUserInteractionBreadcrumbs;
    private boolean enableUserInteractionTracing;
    private boolean enabled;
    private IEnvelopeCache envelopeDiskCache;
    private IEnvelopeReader envelopeReader;
    private String environment;
    private final List<EventProcessor> eventProcessors;
    private ISentryExecutorService executorService;
    private long flushTimeoutMillis;
    private final FullyDisplayedReporter fullyDisplayedReporter;
    private final List<GestureTargetLocator> gestureTargetLocators;
    private Long idleTimeout;
    private List<String> ignoredCheckIns;
    private final Set<Class<? extends Throwable>> ignoredExceptionsForType;
    private final List<String> inAppExcludes;
    private final List<String> inAppIncludes;
    private Instrumenter instrumenter;
    private final List<Integration> integrations;
    private ILogger logger;
    private IMainThreadChecker mainThreadChecker;
    private long maxAttachmentSize;
    private int maxBreadcrumbs;
    private int maxCacheItems;
    private int maxDepth;
    private int maxQueueSize;
    private RequestSize maxRequestBodySize;
    private int maxSpans;
    private long maxTraceFileSize;
    private IModulesLoader modulesLoader;
    private final List<IScopeObserver> observers;
    private final List<IOptionsObserver> optionsObservers;
    private final List<IPerformanceCollector> performanceCollectors;
    private boolean printUncaughtStackTrace;
    private Double profilesSampleRate;
    private ProfilesSamplerCallback profilesSampler;
    private int profilingTracesHz;
    private String proguardUuid;
    private Proxy proxy;
    private int readTimeoutMillis;
    private String release;
    private Double sampleRate;
    private SdkVersion sdkVersion;
    private boolean sendClientReports;
    private boolean sendDefaultPii;
    private boolean sendModules;
    private String sentryClientName;
    private ISerializer serializer;
    private String serverName;
    private long sessionFlushTimeoutMillis;
    private long sessionTrackingIntervalMillis;
    private long shutdownTimeoutMillis;
    private String spotlightConnectionUrl;
    private SSLSocketFactory sslSocketFactory;
    private final Map<String, String> tags;
    private boolean traceOptionsRequests;
    private List<String> tracePropagationTargets;
    private boolean traceSampling;
    private Double tracesSampleRate;
    private TracesSamplerCallback tracesSampler;
    private TransactionPerformanceCollector transactionPerformanceCollector;
    private ITransactionProfiler transactionProfiler;
    private ITransportFactory transportFactory;
    private ITransportGate transportGate;
    private final List<ViewHierarchyExporter> viewHierarchyExporters;

    public interface BeforeBreadcrumbCallback {
        Breadcrumb execute(Breadcrumb breadcrumb, Hint hint);
    }

    public interface BeforeEmitMetricCallback {
        boolean execute(String str, Map<String, String> map);
    }

    public interface BeforeEnvelopeCallback {
        void execute(SentryEnvelope sentryEnvelope, Hint hint);
    }

    public interface BeforeSendCallback {
        SentryEvent execute(SentryEvent sentryEvent, Hint hint);
    }

    public interface BeforeSendTransactionCallback {
        SentryTransaction execute(SentryTransaction sentryTransaction, Hint hint);
    }

    public interface ProfilesSamplerCallback {
        Double sample(SamplingContext samplingContext);
    }

    public enum RequestSize {
        NONE,
        SMALL,
        MEDIUM,
        ALWAYS
    }

    public interface TracesSamplerCallback {
        Double sample(SamplingContext samplingContext);
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public void addIntegration(Integration integration) {
        this.integrations.add(integration);
    }

    public List<Integration> getIntegrations() {
        return this.integrations;
    }

    public String getDsn() {
        return this.dsn;
    }

    public void setDsn(String str) {
        this.dsn = str;
        this.dsnHash = StringUtils.calculateStringHash(str, this.logger);
    }

    public boolean isDebug() {
        return this.debug;
    }

    public void setDebug(boolean z) {
        this.debug = z;
    }

    public ILogger getLogger() {
        return this.logger;
    }

    public void setLogger(ILogger iLogger) {
        this.logger = iLogger == null ? NoOpLogger.getInstance() : new DiagnosticLogger(this, iLogger);
    }

    public SentryLevel getDiagnosticLevel() {
        return this.diagnosticLevel;
    }

    public void setDiagnosticLevel(SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            sentryLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        }
        this.diagnosticLevel = sentryLevel;
    }

    public ISerializer getSerializer() {
        return this.serializer;
    }

    public void setSerializer(ISerializer iSerializer) {
        if (iSerializer == null) {
            iSerializer = NoOpSerializer.getInstance();
        }
        this.serializer = iSerializer;
    }

    public int getMaxDepth() {
        return this.maxDepth;
    }

    public void setMaxDepth(int i) {
        this.maxDepth = i;
    }

    public IEnvelopeReader getEnvelopeReader() {
        return this.envelopeReader;
    }

    public void setEnvelopeReader(IEnvelopeReader iEnvelopeReader) {
        if (iEnvelopeReader == null) {
            iEnvelopeReader = NoOpEnvelopeReader.getInstance();
        }
        this.envelopeReader = iEnvelopeReader;
    }

    @Deprecated
    public long getShutdownTimeout() {
        return this.shutdownTimeoutMillis;
    }

    public long getShutdownTimeoutMillis() {
        return this.shutdownTimeoutMillis;
    }

    @Deprecated
    public void setShutdownTimeout(long j) {
        this.shutdownTimeoutMillis = j;
    }

    public void setShutdownTimeoutMillis(long j) {
        this.shutdownTimeoutMillis = j;
    }

    public String getSentryClientName() {
        return this.sentryClientName;
    }

    public void setSentryClientName(String str) {
        this.sentryClientName = str;
    }

    public BeforeSendCallback getBeforeSend() {
        return this.beforeSend;
    }

    public void setBeforeSend(BeforeSendCallback beforeSendCallback) {
        this.beforeSend = beforeSendCallback;
    }

    public BeforeSendTransactionCallback getBeforeSendTransaction() {
        return this.beforeSendTransaction;
    }

    public void setBeforeSendTransaction(BeforeSendTransactionCallback beforeSendTransactionCallback) {
        this.beforeSendTransaction = beforeSendTransactionCallback;
    }

    public BeforeBreadcrumbCallback getBeforeBreadcrumb() {
        return this.beforeBreadcrumb;
    }

    public void setBeforeBreadcrumb(BeforeBreadcrumbCallback beforeBreadcrumbCallback) {
        this.beforeBreadcrumb = beforeBreadcrumbCallback;
    }

    public String getCacheDirPath() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.dsnHash != null ? new File(this.cacheDirPath, this.dsnHash).getAbsolutePath() : this.cacheDirPath;
    }

    /* access modifiers changed from: package-private */
    public String getCacheDirPathWithoutDsn() {
        String str = this.cacheDirPath;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return this.cacheDirPath;
    }

    public String getOutboxPath() {
        String cacheDirPath2 = getCacheDirPath();
        if (cacheDirPath2 == null) {
            return null;
        }
        return new File(cacheDirPath2, "outbox").getAbsolutePath();
    }

    public void setCacheDirPath(String str) {
        this.cacheDirPath = str;
    }

    public int getMaxBreadcrumbs() {
        return this.maxBreadcrumbs;
    }

    public void setMaxBreadcrumbs(int i) {
        this.maxBreadcrumbs = i;
    }

    public String getRelease() {
        return this.release;
    }

    public void setRelease(String str) {
        this.release = str;
    }

    public String getEnvironment() {
        String str = this.environment;
        return str != null ? str : DEFAULT_ENVIRONMENT;
    }

    public void setEnvironment(String str) {
        this.environment = str;
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    public void setProxy(Proxy proxy2) {
        this.proxy = proxy2;
    }

    public Double getSampleRate() {
        return this.sampleRate;
    }

    public void setSampleRate(Double d) {
        if (SampleRateUtils.isValidSampleRate(d)) {
            this.sampleRate = d;
            return;
        }
        throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values >= 0.0 and <= 1.0.");
    }

    public Boolean getEnableTracing() {
        return this.enableTracing;
    }

    public void setEnableTracing(Boolean bool) {
        this.enableTracing = bool;
    }

    public Double getTracesSampleRate() {
        return this.tracesSampleRate;
    }

    public void setTracesSampleRate(Double d) {
        if (SampleRateUtils.isValidTracesSampleRate(d)) {
            this.tracesSampleRate = d;
            return;
        }
        throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public TracesSamplerCallback getTracesSampler() {
        return this.tracesSampler;
    }

    public void setTracesSampler(TracesSamplerCallback tracesSamplerCallback) {
        this.tracesSampler = tracesSamplerCallback;
    }

    public List<String> getInAppExcludes() {
        return this.inAppExcludes;
    }

    public void addInAppExclude(String str) {
        this.inAppExcludes.add(str);
    }

    public List<String> getInAppIncludes() {
        return this.inAppIncludes;
    }

    public void addInAppInclude(String str) {
        this.inAppIncludes.add(str);
    }

    public ITransportFactory getTransportFactory() {
        return this.transportFactory;
    }

    public void setTransportFactory(ITransportFactory iTransportFactory) {
        if (iTransportFactory == null) {
            iTransportFactory = NoOpTransportFactory.getInstance();
        }
        this.transportFactory = iTransportFactory;
    }

    public String getDist() {
        return this.dist;
    }

    public void setDist(String str) {
        this.dist = str;
    }

    public ITransportGate getTransportGate() {
        return this.transportGate;
    }

    public void setTransportGate(ITransportGate iTransportGate) {
        if (iTransportGate == null) {
            iTransportGate = NoOpTransportGate.getInstance();
        }
        this.transportGate = iTransportGate;
    }

    public boolean isAttachStacktrace() {
        return this.attachStacktrace;
    }

    public void setAttachStacktrace(boolean z) {
        this.attachStacktrace = z;
    }

    public boolean isAttachThreads() {
        return this.attachThreads;
    }

    public void setAttachThreads(boolean z) {
        this.attachThreads = z;
    }

    public boolean isEnableAutoSessionTracking() {
        return this.enableAutoSessionTracking;
    }

    public void setEnableAutoSessionTracking(boolean z) {
        this.enableAutoSessionTracking = z;
    }

    public String getServerName() {
        return this.serverName;
    }

    public void setServerName(String str) {
        this.serverName = str;
    }

    public boolean isAttachServerName() {
        return this.attachServerName;
    }

    public void setAttachServerName(boolean z) {
        this.attachServerName = z;
    }

    public long getSessionTrackingIntervalMillis() {
        return this.sessionTrackingIntervalMillis;
    }

    public void setSessionTrackingIntervalMillis(long j) {
        this.sessionTrackingIntervalMillis = j;
    }

    public String getDistinctId() {
        return this.distinctId;
    }

    public void setDistinctId(String str) {
        this.distinctId = str;
    }

    public long getFlushTimeoutMillis() {
        return this.flushTimeoutMillis;
    }

    public void setFlushTimeoutMillis(long j) {
        this.flushTimeoutMillis = j;
    }

    public boolean isEnableUncaughtExceptionHandler() {
        return this.enableUncaughtExceptionHandler;
    }

    public void setEnableUncaughtExceptionHandler(boolean z) {
        this.enableUncaughtExceptionHandler = z;
    }

    public boolean isPrintUncaughtStackTrace() {
        return this.printUncaughtStackTrace;
    }

    public void setPrintUncaughtStackTrace(boolean z) {
        this.printUncaughtStackTrace = z;
    }

    public ISentryExecutorService getExecutorService() {
        return this.executorService;
    }

    public void setExecutorService(ISentryExecutorService iSentryExecutorService) {
        if (iSentryExecutorService != null) {
            this.executorService = iSentryExecutorService;
        }
    }

    public int getConnectionTimeoutMillis() {
        return this.connectionTimeoutMillis;
    }

    public void setConnectionTimeoutMillis(int i) {
        this.connectionTimeoutMillis = i;
    }

    public int getReadTimeoutMillis() {
        return this.readTimeoutMillis;
    }

    public void setReadTimeoutMillis(int i) {
        this.readTimeoutMillis = i;
    }

    public IEnvelopeCache getEnvelopeDiskCache() {
        return this.envelopeDiskCache;
    }

    public void setEnvelopeDiskCache(IEnvelopeCache iEnvelopeCache) {
        if (iEnvelopeCache == null) {
            iEnvelopeCache = NoOpEnvelopeCache.getInstance();
        }
        this.envelopeDiskCache = iEnvelopeCache;
    }

    public int getMaxQueueSize() {
        return this.maxQueueSize;
    }

    public void setMaxQueueSize(int i) {
        if (i > 0) {
            this.maxQueueSize = i;
        }
    }

    public SdkVersion getSdkVersion() {
        return this.sdkVersion;
    }

    public SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public void setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
    }

    public void setSdkVersion(SdkVersion sdkVersion2) {
        this.sdkVersion = sdkVersion2;
    }

    public boolean isSendDefaultPii() {
        return this.sendDefaultPii;
    }

    public void setSendDefaultPii(boolean z) {
        this.sendDefaultPii = z;
    }

    public void addScopeObserver(IScopeObserver iScopeObserver) {
        this.observers.add(iScopeObserver);
    }

    public List<IScopeObserver> getScopeObservers() {
        return this.observers;
    }

    public void addOptionsObserver(IOptionsObserver iOptionsObserver) {
        this.optionsObservers.add(iOptionsObserver);
    }

    public List<IOptionsObserver> getOptionsObservers() {
        return this.optionsObservers;
    }

    public boolean isEnableExternalConfiguration() {
        return this.enableExternalConfiguration;
    }

    public void setEnableExternalConfiguration(boolean z) {
        this.enableExternalConfiguration = z;
    }

    public Map<String, String> getTags() {
        return this.tags;
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
    }

    public long getMaxAttachmentSize() {
        return this.maxAttachmentSize;
    }

    public void setMaxAttachmentSize(long j) {
        this.maxAttachmentSize = j;
    }

    public boolean isEnableDeduplication() {
        return this.enableDeduplication;
    }

    public void setEnableDeduplication(boolean z) {
        this.enableDeduplication = z;
    }

    public boolean isTracingEnabled() {
        Boolean bool = this.enableTracing;
        if (bool != null) {
            return bool.booleanValue();
        }
        return (getTracesSampleRate() == null && getTracesSampler() == null) ? false : true;
    }

    public Set<Class<? extends Throwable>> getIgnoredExceptionsForType() {
        return this.ignoredExceptionsForType;
    }

    public void addIgnoredExceptionForType(Class<? extends Throwable> cls) {
        this.ignoredExceptionsForType.add(cls);
    }

    /* access modifiers changed from: package-private */
    public boolean containsIgnoredExceptionForType(Throwable th) {
        return this.ignoredExceptionsForType.contains(th.getClass());
    }

    public int getMaxSpans() {
        return this.maxSpans;
    }

    public void setMaxSpans(int i) {
        this.maxSpans = i;
    }

    public boolean isEnableShutdownHook() {
        return this.enableShutdownHook;
    }

    public void setEnableShutdownHook(boolean z) {
        this.enableShutdownHook = z;
    }

    public int getMaxCacheItems() {
        return this.maxCacheItems;
    }

    public void setMaxCacheItems(int i) {
        this.maxCacheItems = i;
    }

    public RequestSize getMaxRequestBodySize() {
        return this.maxRequestBodySize;
    }

    public void setMaxRequestBodySize(RequestSize requestSize) {
        this.maxRequestBodySize = requestSize;
    }

    public boolean isTraceSampling() {
        return this.traceSampling;
    }

    @Deprecated
    public void setTraceSampling(boolean z) {
        this.traceSampling = z;
    }

    public long getMaxTraceFileSize() {
        return this.maxTraceFileSize;
    }

    public void setMaxTraceFileSize(long j) {
        this.maxTraceFileSize = j;
    }

    public ITransactionProfiler getTransactionProfiler() {
        return this.transactionProfiler;
    }

    public void setTransactionProfiler(ITransactionProfiler iTransactionProfiler) {
        if (this.transactionProfiler == NoOpTransactionProfiler.getInstance() && iTransactionProfiler != null) {
            this.transactionProfiler = iTransactionProfiler;
        }
    }

    public boolean isProfilingEnabled() {
        return (getProfilesSampleRate() != null && getProfilesSampleRate().doubleValue() > 0.0d) || getProfilesSampler() != null;
    }

    @Deprecated
    public void setProfilingEnabled(boolean z) {
        if (getProfilesSampleRate() == null) {
            setProfilesSampleRate(z ? Double.valueOf(1.0d) : null);
        }
    }

    public ProfilesSamplerCallback getProfilesSampler() {
        return this.profilesSampler;
    }

    public void setProfilesSampler(ProfilesSamplerCallback profilesSamplerCallback) {
        this.profilesSampler = profilesSamplerCallback;
    }

    public Double getProfilesSampleRate() {
        return this.profilesSampleRate;
    }

    public void setProfilesSampleRate(Double d) {
        if (SampleRateUtils.isValidProfilesSampleRate(d)) {
            this.profilesSampleRate = d;
            return;
        }
        throw new IllegalArgumentException("The value " + d + " is not valid. Use null to disable or values between 0.0 and 1.0.");
    }

    public String getProfilingTracesDirPath() {
        String cacheDirPath2 = getCacheDirPath();
        if (cacheDirPath2 == null) {
            return null;
        }
        return new File(cacheDirPath2, "profiling_traces").getAbsolutePath();
    }

    @Deprecated
    public List<String> getTracingOrigins() {
        return getTracePropagationTargets();
    }

    @Deprecated
    public void addTracingOrigin(String str) {
        if (this.tracePropagationTargets == null) {
            this.tracePropagationTargets = new CopyOnWriteArrayList();
        }
        if (!str.isEmpty()) {
            this.tracePropagationTargets.add(str);
        }
    }

    @Deprecated
    public void setTracingOrigins(List<String> list) {
        setTracePropagationTargets(list);
    }

    public List<String> getTracePropagationTargets() {
        List<String> list = this.tracePropagationTargets;
        return list == null ? this.defaultTracePropagationTargets : list;
    }

    public void setTracePropagationTargets(List<String> list) {
        if (list == null) {
            this.tracePropagationTargets = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.isEmpty()) {
                arrayList.add(next);
            }
        }
        this.tracePropagationTargets = arrayList;
    }

    public String getProguardUuid() {
        return this.proguardUuid;
    }

    public void setProguardUuid(String str) {
        this.proguardUuid = str;
    }

    public void addBundleId(String str) {
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                this.bundleIds.add(trim);
            }
        }
    }

    public Set<String> getBundleIds() {
        return this.bundleIds;
    }

    public List<String> getContextTags() {
        return this.contextTags;
    }

    public void addContextTag(String str) {
        this.contextTags.add(str);
    }

    public Long getIdleTimeout() {
        return this.idleTimeout;
    }

    public void setIdleTimeout(Long l) {
        this.idleTimeout = l;
    }

    public boolean isSendClientReports() {
        return this.sendClientReports;
    }

    public void setSendClientReports(boolean z) {
        this.sendClientReports = z;
        if (z) {
            this.clientReportRecorder = new ClientReportRecorder(this);
        } else {
            this.clientReportRecorder = new NoOpClientReportRecorder();
        }
    }

    public boolean isEnableUserInteractionTracing() {
        return this.enableUserInteractionTracing;
    }

    public void setEnableUserInteractionTracing(boolean z) {
        this.enableUserInteractionTracing = z;
    }

    public boolean isEnableUserInteractionBreadcrumbs() {
        return this.enableUserInteractionBreadcrumbs;
    }

    public void setEnableUserInteractionBreadcrumbs(boolean z) {
        this.enableUserInteractionBreadcrumbs = z;
    }

    public void setInstrumenter(Instrumenter instrumenter2) {
        this.instrumenter = instrumenter2;
    }

    public Instrumenter getInstrumenter() {
        return this.instrumenter;
    }

    public IClientReportRecorder getClientReportRecorder() {
        return this.clientReportRecorder;
    }

    public IModulesLoader getModulesLoader() {
        return this.modulesLoader;
    }

    public void setModulesLoader(IModulesLoader iModulesLoader) {
        if (iModulesLoader == null) {
            iModulesLoader = NoOpModulesLoader.getInstance();
        }
        this.modulesLoader = iModulesLoader;
    }

    public IDebugMetaLoader getDebugMetaLoader() {
        return this.debugMetaLoader;
    }

    public void setDebugMetaLoader(IDebugMetaLoader iDebugMetaLoader) {
        if (iDebugMetaLoader == null) {
            iDebugMetaLoader = NoOpDebugMetaLoader.getInstance();
        }
        this.debugMetaLoader = iDebugMetaLoader;
    }

    public List<GestureTargetLocator> getGestureTargetLocators() {
        return this.gestureTargetLocators;
    }

    public void setGestureTargetLocators(List<GestureTargetLocator> list) {
        this.gestureTargetLocators.clear();
        this.gestureTargetLocators.addAll(list);
    }

    public final List<ViewHierarchyExporter> getViewHierarchyExporters() {
        return this.viewHierarchyExporters;
    }

    public void setViewHierarchyExporters(List<ViewHierarchyExporter> list) {
        this.viewHierarchyExporters.clear();
        this.viewHierarchyExporters.addAll(list);
    }

    public IMainThreadChecker getMainThreadChecker() {
        return this.mainThreadChecker;
    }

    public void setMainThreadChecker(IMainThreadChecker iMainThreadChecker) {
        this.mainThreadChecker = iMainThreadChecker;
    }

    public TransactionPerformanceCollector getTransactionPerformanceCollector() {
        return this.transactionPerformanceCollector;
    }

    public void setTransactionPerformanceCollector(TransactionPerformanceCollector transactionPerformanceCollector2) {
        this.transactionPerformanceCollector = transactionPerformanceCollector2;
    }

    public boolean isEnableTimeToFullDisplayTracing() {
        return this.enableTimeToFullDisplayTracing;
    }

    public void setEnableTimeToFullDisplayTracing(boolean z) {
        this.enableTimeToFullDisplayTracing = z;
    }

    public FullyDisplayedReporter getFullyDisplayedReporter() {
        return this.fullyDisplayedReporter;
    }

    public boolean isTraceOptionsRequests() {
        return this.traceOptionsRequests;
    }

    public void setTraceOptionsRequests(boolean z) {
        this.traceOptionsRequests = z;
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean z) {
        this.enabled = z;
    }

    public boolean isEnablePrettySerializationOutput() {
        return this.enablePrettySerializationOutput;
    }

    public boolean isSendModules() {
        return this.sendModules;
    }

    public void setEnablePrettySerializationOutput(boolean z) {
        this.enablePrettySerializationOutput = z;
    }

    public boolean isEnableAppStartProfiling() {
        return isProfilingEnabled() && this.enableAppStartProfiling;
    }

    public void setEnableAppStartProfiling(boolean z) {
        this.enableAppStartProfiling = z;
    }

    public void setSendModules(boolean z) {
        this.sendModules = z;
    }

    public void setIgnoredCheckIns(List<String> list) {
        if (list == null) {
            this.ignoredCheckIns = null;
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!next.isEmpty()) {
                arrayList.add(next);
            }
        }
        this.ignoredCheckIns = arrayList;
    }

    public List<String> getIgnoredCheckIns() {
        return this.ignoredCheckIns;
    }

    public SentryDateProvider getDateProvider() {
        return this.dateProvider;
    }

    public void setDateProvider(SentryDateProvider sentryDateProvider) {
        this.dateProvider = sentryDateProvider;
    }

    public void addPerformanceCollector(IPerformanceCollector iPerformanceCollector) {
        this.performanceCollectors.add(iPerformanceCollector);
    }

    public List<IPerformanceCollector> getPerformanceCollectors() {
        return this.performanceCollectors;
    }

    public IConnectionStatusProvider getConnectionStatusProvider() {
        return this.connectionStatusProvider;
    }

    public void setConnectionStatusProvider(IConnectionStatusProvider iConnectionStatusProvider) {
        this.connectionStatusProvider = iConnectionStatusProvider;
    }

    public IBackpressureMonitor getBackpressureMonitor() {
        return this.backpressureMonitor;
    }

    public void setBackpressureMonitor(IBackpressureMonitor iBackpressureMonitor) {
        this.backpressureMonitor = iBackpressureMonitor;
    }

    public void setEnableBackpressureHandling(boolean z) {
        this.enableBackpressureHandling = z;
    }

    public int getProfilingTracesHz() {
        return this.profilingTracesHz;
    }

    public void setProfilingTracesHz(int i) {
        this.profilingTracesHz = i;
    }

    public boolean isEnableBackpressureHandling() {
        return this.enableBackpressureHandling;
    }

    public long getSessionFlushTimeoutMillis() {
        return this.sessionFlushTimeoutMillis;
    }

    public void setSessionFlushTimeoutMillis(long j) {
        this.sessionFlushTimeoutMillis = j;
    }

    public BeforeEnvelopeCallback getBeforeEnvelopeCallback() {
        return this.beforeEnvelopeCallback;
    }

    public void setBeforeEnvelopeCallback(BeforeEnvelopeCallback beforeEnvelopeCallback2) {
        this.beforeEnvelopeCallback = beforeEnvelopeCallback2;
    }

    public String getSpotlightConnectionUrl() {
        return this.spotlightConnectionUrl;
    }

    public void setSpotlightConnectionUrl(String str) {
        this.spotlightConnectionUrl = str;
    }

    public boolean isEnableSpotlight() {
        return this.enableSpotlight;
    }

    public void setEnableSpotlight(boolean z) {
        this.enableSpotlight = z;
    }

    public boolean isEnableScopePersistence() {
        return this.enableScopePersistence;
    }

    public void setEnableScopePersistence(boolean z) {
        this.enableScopePersistence = z;
    }

    public boolean isEnableMetrics() {
        return this.enableMetrics;
    }

    public void setEnableMetrics(boolean z) {
        this.enableMetrics = z;
    }

    public boolean isEnableSpanLocalMetricAggregation() {
        return isEnableMetrics() && this.enableSpanLocalMetricAggregation;
    }

    public void setEnableSpanLocalMetricAggregation(boolean z) {
        this.enableSpanLocalMetricAggregation = z;
    }

    public boolean isEnableDefaultTagsForMetrics() {
        return isEnableMetrics() && this.enableDefaultTagsForMetrics;
    }

    public void setEnableDefaultTagsForMetrics(boolean z) {
        this.enableDefaultTagsForMetrics = z;
    }

    public BeforeEmitMetricCallback getBeforeEmitMetricCallback() {
        return this.beforeEmitMetricCallback;
    }

    public void setBeforeEmitMetricCallback(BeforeEmitMetricCallback beforeEmitMetricCallback2) {
        this.beforeEmitMetricCallback = beforeEmitMetricCallback2;
    }

    public Cron getCron() {
        return this.cron;
    }

    public void setCron(Cron cron2) {
        this.cron = cron2;
    }

    public static SentryOptions empty() {
        return new SentryOptions(true);
    }

    public SentryOptions() {
        this(false);
    }

    private SentryOptions(boolean z) {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.eventProcessors = copyOnWriteArrayList;
        this.ignoredExceptionsForType = new CopyOnWriteArraySet();
        CopyOnWriteArrayList copyOnWriteArrayList2 = new CopyOnWriteArrayList();
        this.integrations = copyOnWriteArrayList2;
        this.bundleIds = new CopyOnWriteArraySet();
        this.shutdownTimeoutMillis = 2000;
        this.flushTimeoutMillis = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        this.sessionFlushTimeoutMillis = C.DEFAULT_SEEK_FORWARD_INCREMENT_MS;
        this.logger = NoOpLogger.getInstance();
        this.diagnosticLevel = DEFAULT_DIAGNOSTIC_LEVEL;
        this.envelopeReader = new EnvelopeReader(new JsonSerializer(this));
        this.serializer = new JsonSerializer(this);
        this.maxDepth = 100;
        this.maxCacheItems = 30;
        this.maxQueueSize = 30;
        this.maxBreadcrumbs = 100;
        this.inAppExcludes = new CopyOnWriteArrayList();
        this.inAppIncludes = new CopyOnWriteArrayList();
        this.transportFactory = NoOpTransportFactory.getInstance();
        this.transportGate = NoOpTransportGate.getInstance();
        this.attachStacktrace = true;
        this.enableAutoSessionTracking = true;
        this.sessionTrackingIntervalMillis = 30000;
        this.attachServerName = true;
        this.enableUncaughtExceptionHandler = true;
        this.printUncaughtStackTrace = false;
        this.executorService = NoOpSentryExecutorService.getInstance();
        this.connectionTimeoutMillis = 5000;
        this.readTimeoutMillis = 5000;
        this.envelopeDiskCache = NoOpEnvelopeCache.getInstance();
        this.sendDefaultPii = false;
        this.observers = new CopyOnWriteArrayList();
        this.optionsObservers = new CopyOnWriteArrayList();
        this.tags = new ConcurrentHashMap();
        this.maxAttachmentSize = NetworkModule.CACHE_SIZE;
        this.enableDeduplication = true;
        this.maxSpans = 1000;
        this.enableShutdownHook = true;
        this.maxRequestBodySize = RequestSize.NONE;
        this.traceSampling = true;
        this.maxTraceFileSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
        this.transactionProfiler = NoOpTransactionProfiler.getInstance();
        this.tracePropagationTargets = null;
        this.defaultTracePropagationTargets = Collections.singletonList(DEFAULT_PROPAGATION_TARGETS);
        this.idleTimeout = 3000L;
        this.contextTags = new CopyOnWriteArrayList();
        this.sendClientReports = true;
        this.clientReportRecorder = new ClientReportRecorder(this);
        this.modulesLoader = NoOpModulesLoader.getInstance();
        this.debugMetaLoader = NoOpDebugMetaLoader.getInstance();
        this.enableUserInteractionTracing = false;
        this.enableUserInteractionBreadcrumbs = true;
        this.instrumenter = Instrumenter.SENTRY;
        this.gestureTargetLocators = new ArrayList();
        this.viewHierarchyExporters = new ArrayList();
        this.mainThreadChecker = NoOpMainThreadChecker.getInstance();
        this.traceOptionsRequests = true;
        this.dateProvider = new SentryAutoDateProvider();
        this.performanceCollectors = new ArrayList();
        this.transactionPerformanceCollector = NoOpTransactionPerformanceCollector.getInstance();
        this.enableTimeToFullDisplayTracing = false;
        this.fullyDisplayedReporter = FullyDisplayedReporter.getInstance();
        this.connectionStatusProvider = new NoOpConnectionStatusProvider();
        this.enabled = true;
        this.enablePrettySerializationOutput = true;
        this.sendModules = true;
        this.enableSpotlight = false;
        this.enableScopePersistence = true;
        this.ignoredCheckIns = null;
        this.backpressureMonitor = NoOpBackpressureMonitor.getInstance();
        this.enableBackpressureHandling = true;
        this.enableAppStartProfiling = false;
        this.enableMetrics = false;
        this.enableDefaultTagsForMetrics = true;
        this.enableSpanLocalMetricAggregation = true;
        this.beforeEmitMetricCallback = null;
        this.profilingTracesHz = 101;
        this.cron = null;
        if (!z) {
            this.executorService = new SentryExecutorService();
            copyOnWriteArrayList2.add(new UncaughtExceptionHandlerIntegration());
            copyOnWriteArrayList2.add(new ShutdownHookIntegration());
            copyOnWriteArrayList2.add(new SpotlightIntegration());
            copyOnWriteArrayList.add(new MainEventProcessor(this));
            copyOnWriteArrayList.add(new DuplicateEventDetectionEventProcessor(this));
            if (Platform.isJvm()) {
                copyOnWriteArrayList.add(new SentryRuntimeEventProcessor());
            }
            setSentryClientName("sentry.java/7.8.0");
            setSdkVersion(createSdkVersion());
            addPackageInfo();
        }
    }

    public void merge(ExternalOptions externalOptions) {
        if (externalOptions.getDsn() != null) {
            setDsn(externalOptions.getDsn());
        }
        if (externalOptions.getEnvironment() != null) {
            setEnvironment(externalOptions.getEnvironment());
        }
        if (externalOptions.getRelease() != null) {
            setRelease(externalOptions.getRelease());
        }
        if (externalOptions.getDist() != null) {
            setDist(externalOptions.getDist());
        }
        if (externalOptions.getServerName() != null) {
            setServerName(externalOptions.getServerName());
        }
        if (externalOptions.getProxy() != null) {
            setProxy(externalOptions.getProxy());
        }
        if (externalOptions.getEnableUncaughtExceptionHandler() != null) {
            setEnableUncaughtExceptionHandler(externalOptions.getEnableUncaughtExceptionHandler().booleanValue());
        }
        if (externalOptions.getPrintUncaughtStackTrace() != null) {
            setPrintUncaughtStackTrace(externalOptions.getPrintUncaughtStackTrace().booleanValue());
        }
        if (externalOptions.getEnableTracing() != null) {
            setEnableTracing(externalOptions.getEnableTracing());
        }
        if (externalOptions.getTracesSampleRate() != null) {
            setTracesSampleRate(externalOptions.getTracesSampleRate());
        }
        if (externalOptions.getProfilesSampleRate() != null) {
            setProfilesSampleRate(externalOptions.getProfilesSampleRate());
        }
        if (externalOptions.getDebug() != null) {
            setDebug(externalOptions.getDebug().booleanValue());
        }
        if (externalOptions.getEnableDeduplication() != null) {
            setEnableDeduplication(externalOptions.getEnableDeduplication().booleanValue());
        }
        if (externalOptions.getSendClientReports() != null) {
            setSendClientReports(externalOptions.getSendClientReports().booleanValue());
        }
        for (Map.Entry entry : new HashMap(externalOptions.getTags()).entrySet()) {
            this.tags.put((String) entry.getKey(), (String) entry.getValue());
        }
        for (String addInAppInclude : new ArrayList(externalOptions.getInAppIncludes())) {
            addInAppInclude(addInAppInclude);
        }
        for (String addInAppExclude : new ArrayList(externalOptions.getInAppExcludes())) {
            addInAppExclude(addInAppExclude);
        }
        Iterator it = new HashSet(externalOptions.getIgnoredExceptionsForType()).iterator();
        while (it.hasNext()) {
            addIgnoredExceptionForType((Class) it.next());
        }
        if (externalOptions.getTracePropagationTargets() != null) {
            setTracePropagationTargets(new ArrayList(externalOptions.getTracePropagationTargets()));
        }
        for (String addContextTag : new ArrayList(externalOptions.getContextTags())) {
            addContextTag(addContextTag);
        }
        if (externalOptions.getProguardUuid() != null) {
            setProguardUuid(externalOptions.getProguardUuid());
        }
        if (externalOptions.getIdleTimeout() != null) {
            setIdleTimeout(externalOptions.getIdleTimeout());
        }
        for (String addBundleId : externalOptions.getBundleIds()) {
            addBundleId(addBundleId);
        }
        if (externalOptions.isEnabled() != null) {
            setEnabled(externalOptions.isEnabled().booleanValue());
        }
        if (externalOptions.isEnablePrettySerializationOutput() != null) {
            setEnablePrettySerializationOutput(externalOptions.isEnablePrettySerializationOutput().booleanValue());
        }
        if (externalOptions.isSendModules() != null) {
            setSendModules(externalOptions.isSendModules().booleanValue());
        }
        if (externalOptions.getIgnoredCheckIns() != null) {
            setIgnoredCheckIns(new ArrayList(externalOptions.getIgnoredCheckIns()));
        }
        if (externalOptions.isEnableBackpressureHandling() != null) {
            setEnableBackpressureHandling(externalOptions.isEnableBackpressureHandling().booleanValue());
        }
        if (externalOptions.getCron() == null) {
            return;
        }
        if (getCron() == null) {
            setCron(externalOptions.getCron());
            return;
        }
        if (externalOptions.getCron().getDefaultCheckinMargin() != null) {
            getCron().setDefaultCheckinMargin(externalOptions.getCron().getDefaultCheckinMargin());
        }
        if (externalOptions.getCron().getDefaultMaxRuntime() != null) {
            getCron().setDefaultMaxRuntime(externalOptions.getCron().getDefaultMaxRuntime());
        }
        if (externalOptions.getCron().getDefaultTimezone() != null) {
            getCron().setDefaultTimezone(externalOptions.getCron().getDefaultTimezone());
        }
        if (externalOptions.getCron().getDefaultFailureIssueThreshold() != null) {
            getCron().setDefaultFailureIssueThreshold(externalOptions.getCron().getDefaultFailureIssueThreshold());
        }
        if (externalOptions.getCron().getDefaultRecoveryThreshold() != null) {
            getCron().setDefaultRecoveryThreshold(externalOptions.getCron().getDefaultRecoveryThreshold());
        }
    }

    private SdkVersion createSdkVersion() {
        SdkVersion sdkVersion2 = new SdkVersion(BuildConfig.SENTRY_JAVA_SDK_NAME, "7.8.0");
        sdkVersion2.setVersion("7.8.0");
        return sdkVersion2;
    }

    private void addPackageInfo() {
        SentryIntegrationPackageStorage.getInstance().addPackage("maven:io.sentry:sentry", "7.8.0");
    }

    public static final class Proxy {
        private String host;
        private String pass;
        private String port;
        private Proxy.Type type;
        private String user;

        public Proxy() {
            this((String) null, (String) null, (Proxy.Type) null, (String) null, (String) null);
        }

        public Proxy(String str, String str2) {
            this(str, str2, (Proxy.Type) null, (String) null, (String) null);
        }

        public Proxy(String str, String str2, Proxy.Type type2) {
            this(str, str2, type2, (String) null, (String) null);
        }

        public Proxy(String str, String str2, String str3, String str4) {
            this(str, str2, (Proxy.Type) null, str3, str4);
        }

        public Proxy(String str, String str2, Proxy.Type type2, String str3, String str4) {
            this.host = str;
            this.port = str2;
            this.type = type2;
            this.user = str3;
            this.pass = str4;
        }

        public String getHost() {
            return this.host;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public String getPort() {
            return this.port;
        }

        public void setPort(String str) {
            this.port = str;
        }

        public String getUser() {
            return this.user;
        }

        public void setUser(String str) {
            this.user = str;
        }

        public String getPass() {
            return this.pass;
        }

        public void setPass(String str) {
            this.pass = str;
        }

        public Proxy.Type getType() {
            return this.type;
        }

        public void setType(Proxy.Type type2) {
            this.type = type2;
        }
    }

    public static final class Cron {
        private Long defaultCheckinMargin;
        private Long defaultFailureIssueThreshold;
        private Long defaultMaxRuntime;
        private Long defaultRecoveryThreshold;
        private String defaultTimezone;

        public Long getDefaultCheckinMargin() {
            return this.defaultCheckinMargin;
        }

        public void setDefaultCheckinMargin(Long l) {
            this.defaultCheckinMargin = l;
        }

        public Long getDefaultMaxRuntime() {
            return this.defaultMaxRuntime;
        }

        public void setDefaultMaxRuntime(Long l) {
            this.defaultMaxRuntime = l;
        }

        public String getDefaultTimezone() {
            return this.defaultTimezone;
        }

        public void setDefaultTimezone(String str) {
            this.defaultTimezone = str;
        }

        public Long getDefaultFailureIssueThreshold() {
            return this.defaultFailureIssueThreshold;
        }

        public void setDefaultFailureIssueThreshold(Long l) {
            this.defaultFailureIssueThreshold = l;
        }

        public Long getDefaultRecoveryThreshold() {
            return this.defaultRecoveryThreshold;
        }

        public void setDefaultRecoveryThreshold(Long l) {
            this.defaultRecoveryThreshold = l;
        }
    }
}
