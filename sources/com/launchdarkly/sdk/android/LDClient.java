package com.launchdarkly.sdk.android;

import android.app.Application;
import com.facebook.hermes.intl.Constants;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.logging.LogValues;
import com.launchdarkly.sdk.EvaluationDetail;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.android.ComponentsImpl;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.android.PersistentDataStoreWrapper;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;
import java.io.Closeable;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class LDClient implements LDClientInterface, Closeable {
    private static volatile ContextDecorator contextDecorator;
    static Object initLock = new Object();
    static volatile Map<String, LDClient> instances;
    private static volatile LDLogger sharedLogger;
    private static volatile PlatformState sharedPlatformState;
    private static volatile TaskExecutor sharedTaskExecutor;
    private final LDConfig config;
    private final ConnectivityManager connectivityManager;
    private final ContextDataManager contextDataManager;
    private final EventProcessor eventProcessor;
    private final LDLogger logger;

    public String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ed, code lost:
        r0 = new java.util.concurrent.atomic.AtomicInteger(r17.getMobileKeys().size());
        r2 = new com.launchdarkly.sdk.android.LDClient.AnonymousClass1();
        r0 = instances.values().iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010d, code lost:
        if (r0.hasNext() == false) goto L_0x0123;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x010f, code lost:
        r3 = r0.next();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x011b, code lost:
        if (r3.connectivityManager.startUp(r2) == false) goto L_0x0109;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x011d, code lost:
        r3.eventProcessor.recordIdentifyEvent(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0123, code lost:
        return r11;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.concurrent.Future<com.launchdarkly.sdk.android.LDClient> init(android.app.Application r16, com.launchdarkly.sdk.android.LDConfig r17, com.launchdarkly.sdk.LDContext r18) {
        /*
            r0 = r16
            r1 = r18
            if (r0 != 0) goto L_0x0013
            com.launchdarkly.sdk.android.LDFailedFuture r0 = new com.launchdarkly.sdk.android.LDFailedFuture
            com.launchdarkly.sdk.android.LaunchDarklyException r1 = new com.launchdarkly.sdk.android.LaunchDarklyException
            java.lang.String r2 = "Client initialization requires a valid application"
            r1.<init>(r2)
            r0.<init>(r1)
            return r0
        L_0x0013:
            if (r17 != 0) goto L_0x0022
            com.launchdarkly.sdk.android.LDFailedFuture r0 = new com.launchdarkly.sdk.android.LDFailedFuture
            com.launchdarkly.sdk.android.LaunchDarklyException r1 = new com.launchdarkly.sdk.android.LaunchDarklyException
            java.lang.String r2 = "Client initialization requires a valid configuration"
            r1.<init>(r2)
            r0.<init>(r1)
            return r0
        L_0x0022:
            if (r1 == 0) goto L_0x0127
            boolean r2 = r18.isValid()
            if (r2 != 0) goto L_0x002c
            goto L_0x0127
        L_0x002c:
            com.launchdarkly.logging.LDLogger r2 = initSharedLogger(r17)
            com.launchdarkly.sdk.android.LDAwaitFuture r11 = new com.launchdarkly.sdk.android.LDAwaitFuture
            r11.<init>()
            java.lang.Object r12 = initLock
            monitor-enter(r12)
            java.util.Map<java.lang.String, com.launchdarkly.sdk.android.LDClient> r3 = instances     // Catch:{ all -> 0x0124 }
            if (r3 == 0) goto L_0x0052
            java.lang.String r0 = "LDClient.init() was called more than once! returning primary instance."
            r2.warn(r0)     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.LDSuccessFuture r0 = new com.launchdarkly.sdk.android.LDSuccessFuture     // Catch:{ all -> 0x0124 }
            java.util.Map<java.lang.String, com.launchdarkly.sdk.android.LDClient> r1 = instances     // Catch:{ all -> 0x0124 }
            java.lang.String r2 = "default"
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.LDClient r1 = (com.launchdarkly.sdk.android.LDClient) r1     // Catch:{ all -> 0x0124 }
            r0.<init>(r1)     // Catch:{ all -> 0x0124 }
            monitor-exit(r12)     // Catch:{ all -> 0x0124 }
            return r0
        L_0x0052:
            com.launchdarkly.sdk.android.AndroidTaskExecutor r3 = new com.launchdarkly.sdk.android.AndroidTaskExecutor     // Catch:{ all -> 0x0124 }
            r3.<init>(r0, r2)     // Catch:{ all -> 0x0124 }
            sharedTaskExecutor = r3     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.AndroidPlatformState r3 = new com.launchdarkly.sdk.android.AndroidPlatformState     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.TaskExecutor r4 = sharedTaskExecutor     // Catch:{ all -> 0x0124 }
            r3.<init>(r0, r4, r2)     // Catch:{ all -> 0x0124 }
            sharedPlatformState = r3     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.subsystems.PersistentDataStore r3 = r17.getPersistentDataStore()     // Catch:{ all -> 0x0124 }
            if (r3 != 0) goto L_0x006e
            com.launchdarkly.sdk.android.SharedPreferencesPersistentDataStore r3 = new com.launchdarkly.sdk.android.SharedPreferencesPersistentDataStore     // Catch:{ all -> 0x0124 }
            r3.<init>(r0, r2)     // Catch:{ all -> 0x0124 }
            goto L_0x0072
        L_0x006e:
            com.launchdarkly.sdk.android.subsystems.PersistentDataStore r3 = r17.getPersistentDataStore()     // Catch:{ all -> 0x0124 }
        L_0x0072:
            com.launchdarkly.sdk.android.PersistentDataStoreWrapper r0 = new com.launchdarkly.sdk.android.PersistentDataStoreWrapper     // Catch:{ all -> 0x0124 }
            r0.<init>(r3, r2)     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.ContextDecorator r4 = new com.launchdarkly.sdk.android.ContextDecorator     // Catch:{ all -> 0x0124 }
            boolean r5 = r17.isGenerateAnonymousKeys()     // Catch:{ all -> 0x0124 }
            r4.<init>(r0, r5)     // Catch:{ all -> 0x0124 }
            contextDecorator = r4     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.Migration.migrateWhenNeeded(r3, r2)     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.ContextDecorator r3 = contextDecorator     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.LDContext r1 = r3.decorateContext(r1, r2)     // Catch:{ all -> 0x0124 }
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ all -> 0x0124 }
            r2.<init>()     // Catch:{ all -> 0x0124 }
            r3 = 0
            java.util.Map r4 = r17.getMobileKeys()     // Catch:{ all -> 0x0124 }
            java.util.Set r4 = r4.entrySet()     // Catch:{ all -> 0x0124 }
            java.util.Iterator r13 = r4.iterator()     // Catch:{ all -> 0x0124 }
            r14 = r3
        L_0x009e:
            boolean r3 = r13.hasNext()     // Catch:{ all -> 0x0124 }
            if (r3 == 0) goto L_0x00ea
            java.lang.Object r3 = r13.next()     // Catch:{ all -> 0x0124 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0124 }
            java.lang.Object r4 = r3.getKey()     // Catch:{ all -> 0x0124 }
            r15 = r4
            java.lang.String r15 = (java.lang.String) r15     // Catch:{ all -> 0x0124 }
            java.lang.Object r3 = r3.getValue()     // Catch:{ all -> 0x0124 }
            r10 = r3
            java.lang.String r10 = (java.lang.String) r10     // Catch:{ all -> 0x0124 }
            com.launchdarkly.sdk.android.LDClient r9 = new com.launchdarkly.sdk.android.LDClient     // Catch:{ LaunchDarklyException -> 0x00e4 }
            com.launchdarkly.sdk.android.PlatformState r4 = sharedPlatformState     // Catch:{ LaunchDarklyException -> 0x00e4 }
            com.launchdarkly.sdk.android.TaskExecutor r5 = sharedTaskExecutor     // Catch:{ LaunchDarklyException -> 0x00e4 }
            com.launchdarkly.sdk.android.PersistentDataStoreWrapper$PerEnvironmentData r6 = r0.perEnvironmentData(r10)     // Catch:{ LaunchDarklyException -> 0x00e4 }
            r3 = r9
            r7 = r1
            r8 = r17
            r16 = r0
            r0 = r9
            r9 = r10
            r18 = r13
            r13 = r10
            r10 = r15
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ LaunchDarklyException -> 0x00e4 }
            r2.put(r15, r0)     // Catch:{ LaunchDarklyException -> 0x00e4 }
            java.lang.String r3 = r17.getMobileKey()     // Catch:{ LaunchDarklyException -> 0x00e4 }
            boolean r3 = r13.equals(r3)     // Catch:{ LaunchDarklyException -> 0x00e4 }
            if (r3 == 0) goto L_0x00df
            r14 = r0
        L_0x00df:
            r0 = r16
            r13 = r18
            goto L_0x009e
        L_0x00e4:
            r0 = move-exception
            r11.setException(r0)     // Catch:{ all -> 0x0124 }
            monitor-exit(r12)     // Catch:{ all -> 0x0124 }
            return r11
        L_0x00ea:
            instances = r2     // Catch:{ all -> 0x0124 }
            monitor-exit(r12)     // Catch:{ all -> 0x0124 }
            java.util.concurrent.atomic.AtomicInteger r0 = new java.util.concurrent.atomic.AtomicInteger
            java.util.Map r2 = r17.getMobileKeys()
            int r2 = r2.size()
            r0.<init>(r2)
            com.launchdarkly.sdk.android.LDClient$1 r2 = new com.launchdarkly.sdk.android.LDClient$1
            r2.<init>(r0, r11, r14)
            java.util.Map<java.lang.String, com.launchdarkly.sdk.android.LDClient> r0 = instances
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0109:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0123
            java.lang.Object r3 = r0.next()
            com.launchdarkly.sdk.android.LDClient r3 = (com.launchdarkly.sdk.android.LDClient) r3
            com.launchdarkly.sdk.android.ConnectivityManager r4 = r3.connectivityManager
            boolean r4 = r4.startUp(r2)
            if (r4 == 0) goto L_0x0109
            com.launchdarkly.sdk.android.subsystems.EventProcessor r3 = r3.eventProcessor
            r3.recordIdentifyEvent(r1)
            goto L_0x0109
        L_0x0123:
            return r11
        L_0x0124:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0124 }
            throw r0
        L_0x0127:
            com.launchdarkly.sdk.android.LDFailedFuture r0 = new com.launchdarkly.sdk.android.LDFailedFuture
            com.launchdarkly.sdk.android.LaunchDarklyException r2 = new com.launchdarkly.sdk.android.LaunchDarklyException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Client initialization requires a valid evaluation context ("
            java.lang.StringBuilder r3 = r3.append(r4)
            if (r1 != 0) goto L_0x013b
            java.lang.String r1 = "was null"
            goto L_0x0152
        L_0x013b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r1 = r18.getError()
            java.lang.StringBuilder r1 = r4.append(r1)
            java.lang.String r4 = ")"
            java.lang.StringBuilder r1 = r1.append(r4)
            java.lang.String r1 = r1.toString()
        L_0x0152:
            java.lang.StringBuilder r1 = r3.append(r1)
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            r0.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.LDClient.init(android.app.Application, com.launchdarkly.sdk.android.LDConfig, com.launchdarkly.sdk.LDContext):java.util.concurrent.Future");
    }

    public static Future<LDClient> init(Application application, LDConfig lDConfig, LDUser lDUser) {
        return init(application, lDConfig, LDContext.fromUser(lDUser));
    }

    public static LDClient init(Application application, LDConfig lDConfig, LDContext lDContext, int i) {
        initSharedLogger(lDConfig);
        getSharedLogger().info("Initializing Client and waiting up to {} for initialization to complete", (Object) Integer.valueOf(i));
        try {
            return init(application, lDConfig, lDContext).get((long) i, TimeUnit.SECONDS);
        } catch (InterruptedException | ExecutionException e) {
            getSharedLogger().error("Exception during Client initialization: {}", LogValues.exceptionSummary(e));
            getSharedLogger().debug(LogValues.exceptionTrace(e));
            return instances.get(Constants.COLLATION_DEFAULT);
        } catch (TimeoutException unused) {
            getSharedLogger().warn("Client did not successfully initialize within {} seconds. It could be taking longer than expected to start up", (Object) Integer.valueOf(i));
            return instances.get(Constants.COLLATION_DEFAULT);
        }
    }

    public static LDClient init(Application application, LDConfig lDConfig, LDUser lDUser, int i) {
        return init(application, lDConfig, LDContext.fromUser(lDUser), i);
    }

    public static LDClient get() throws LaunchDarklyException {
        if (instances != null) {
            return instances.get(Constants.COLLATION_DEFAULT);
        }
        getSharedLogger().error("LDClient.get() was called before init()!");
        throw new LaunchDarklyException("LDClient.get() was called before init()!");
    }

    public static LDClient getForMobileKey(String str) throws LaunchDarklyException {
        Map<String, LDClient> map = instances;
        if (map == null) {
            getSharedLogger().error("LDClient.getForMobileKey() was called before init()!");
            throw new LaunchDarklyException("LDClient.getForMobileKey() was called before init()!");
        } else if (map.containsKey(str)) {
            return map.get(str);
        } else {
            throw new LaunchDarklyException("LDClient.getForMobileKey() called with invalid keyName");
        }
    }

    protected LDClient(PlatformState platformState, TaskExecutor taskExecutor, PersistentDataStoreWrapper.PerEnvironmentData perEnvironmentData, LDContext lDContext, LDConfig lDConfig, String str, String str2) throws LaunchDarklyException {
        LDConfig lDConfig2 = lDConfig;
        LDLogger withAdapter = LDLogger.withAdapter(lDConfig.getLogAdapter(), lDConfig.getLoggerName());
        this.logger = withAdapter;
        withAdapter.info("Creating LaunchDarkly client. Version: {}", (Object) BuildConfig.VERSION_NAME);
        this.config = lDConfig2;
        if (str != null) {
            ClientContextImpl fromConfig = ClientContextImpl.fromConfig(lDConfig, str, str2, lDConfig2.dataSource instanceof ComponentsImpl.DataSourceRequiresFeatureFetcher ? new HttpFeatureFlagFetcher(ClientContextImpl.fromConfig(lDConfig, str, str2, (FeatureFetcher) null, lDContext, withAdapter, platformState, taskExecutor)) : null, lDContext, withAdapter, platformState, taskExecutor);
            ContextDataManager contextDataManager2 = new ContextDataManager(fromConfig, perEnvironmentData, lDConfig.getMaxCachedContexts());
            this.contextDataManager = contextDataManager2;
            EventProcessor build = lDConfig2.events.build(fromConfig);
            this.eventProcessor = build;
            this.connectivityManager = new ConnectivityManager(fromConfig, lDConfig2.dataSource, build, contextDataManager2, perEnvironmentData);
            return;
        }
        throw new LaunchDarklyException("Mobile key cannot be null");
    }

    public void trackMetric(String str, LDValue lDValue, double d) {
        trackInternal(str, lDValue, Double.valueOf(d));
    }

    public void trackData(String str, LDValue lDValue) {
        trackInternal(str, lDValue, (Double) null);
    }

    public void track(String str) {
        trackInternal(str, (LDValue) null, (Double) null);
    }

    private void trackInternal(String str, LDValue lDValue, Double d) {
        this.eventProcessor.recordCustomEvent(this.contextDataManager.getCurrentContext(), str, lDValue, d);
    }

    public Future<Void> identify(LDContext lDContext) {
        if (lDContext == null) {
            return new LDFailedFuture(new LaunchDarklyException("Context cannot be null"));
        }
        if (lDContext.isValid()) {
            return identifyInstances(contextDecorator.decorateContext(lDContext, getSharedLogger()));
        }
        this.logger.warn("identify() was called with an invalid context: {}", (Object) lDContext.getError());
        return new LDFailedFuture(new LaunchDarklyException("Invalid context: " + lDContext.getError()));
    }

    public Future<Void> identify(LDUser lDUser) {
        return identify(LDContext.fromUser(lDUser));
    }

    private Map<String, LDClient> getInstancesIfTheyIncludeThisClient() {
        Map<String, LDClient> map = instances;
        if (map != null) {
            for (LDClient lDClient : map.values()) {
                if (lDClient == this) {
                    return map;
                }
            }
        }
        return Collections.emptyMap();
    }

    private void identifyInternal(LDContext lDContext, Callback<Void> callback) {
        this.contextDataManager.setCurrentContext(lDContext);
        this.connectivityManager.setEvaluationContext(lDContext, callback);
        this.eventProcessor.recordIdentifyEvent(lDContext);
    }

    private Future<Void> identifyInstances(LDContext lDContext) {
        final LDAwaitFuture lDAwaitFuture = new LDAwaitFuture();
        Map<String, LDClient> instancesIfTheyIncludeThisClient = getInstancesIfTheyIncludeThisClient();
        final AtomicInteger atomicInteger = new AtomicInteger(instancesIfTheyIncludeThisClient.size());
        AnonymousClass2 r3 = new Callback<Void>() {
            public void onSuccess(Void voidR) {
                if (atomicInteger.decrementAndGet() == 0) {
                    lDAwaitFuture.set(null);
                }
            }

            public void onError(Throwable th) {
                lDAwaitFuture.setException(th);
            }
        };
        for (LDClient identifyInternal : instancesIfTheyIncludeThisClient.values()) {
            identifyInternal.identifyInternal(lDContext, r3);
        }
        return lDAwaitFuture;
    }

    public Map<String, LDValue> allFlags() {
        EnvironmentData allNonDeleted = this.contextDataManager.getAllNonDeleted();
        HashMap hashMap = new HashMap();
        for (DataModel.Flag next : allNonDeleted.values()) {
            hashMap.put(next.getKey(), next.getValue());
        }
        return hashMap;
    }

    public boolean boolVariation(String str, boolean z) {
        return variationDetailInternal(str, LDValue.of(z), true, false).getValue().booleanValue();
    }

    public EvaluationDetail<Boolean> boolVariationDetail(String str, boolean z) {
        return convertDetailType(variationDetailInternal(str, LDValue.of(z), true, true), LDValue.Convert.Boolean);
    }

    public int intVariation(String str, int i) {
        return variationDetailInternal(str, LDValue.of(i), true, false).getValue().intValue();
    }

    public EvaluationDetail<Integer> intVariationDetail(String str, int i) {
        return convertDetailType(variationDetailInternal(str, LDValue.of(i), true, true), LDValue.Convert.Integer);
    }

    public double doubleVariation(String str, double d) {
        return variationDetailInternal(str, LDValue.of(d), true, false).getValue().doubleValue();
    }

    public EvaluationDetail<Double> doubleVariationDetail(String str, double d) {
        return convertDetailType(variationDetailInternal(str, LDValue.of(d), true, true), LDValue.Convert.Double);
    }

    public String stringVariation(String str, String str2) {
        return variationDetailInternal(str, LDValue.of(str2), true, false).getValue().stringValue();
    }

    public EvaluationDetail<String> stringVariationDetail(String str, String str2) {
        return convertDetailType(variationDetailInternal(str, LDValue.of(str2), true, true), LDValue.Convert.String);
    }

    public LDValue jsonValueVariation(String str, LDValue lDValue) {
        return variationDetailInternal(str, LDValue.normalize(lDValue), false, false).getValue();
    }

    public EvaluationDetail<LDValue> jsonValueVariationDetail(String str, LDValue lDValue) {
        return variationDetailInternal(str, LDValue.normalize(lDValue), false, true);
    }

    private <T> EvaluationDetail<T> convertDetailType(EvaluationDetail<LDValue> evaluationDetail, LDValue.Converter<T> converter) {
        return EvaluationDetail.fromValue(converter.toType(evaluationDetail.getValue()), evaluationDetail.getVariationIndex(), evaluationDetail.getReason());
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00c6  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00d6  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.launchdarkly.sdk.EvaluationDetail<com.launchdarkly.sdk.LDValue> variationDetailInternal(java.lang.String r19, com.launchdarkly.sdk.LDValue r20, boolean r21, boolean r22) {
        /*
            r18 = this;
            r0 = r18
            r11 = r19
            r12 = r20
            com.launchdarkly.sdk.android.ContextDataManager r1 = r0.contextDataManager
            com.launchdarkly.sdk.android.DataModel$Flag r1 = r1.getNonDeletedFlag(r11)
            r15 = 0
            r10 = 3
            r9 = -1
            if (r1 != 0) goto L_0x0042
            com.launchdarkly.logging.LDLogger r1 = r0.logger
            java.lang.String r2 = "Unknown feature flag \"{}\"; returning default value"
            r1.info((java.lang.String) r2, (java.lang.Object) r11)
            com.launchdarkly.sdk.android.subsystems.EventProcessor r1 = r0.eventProcessor
            com.launchdarkly.sdk.android.ContextDataManager r2 = r0.contextDataManager
            com.launchdarkly.sdk.LDContext r2 = r2.getCurrentContext()
            r4 = -1
            r5 = -1
            r7 = 0
            r16 = 0
            r17 = 0
            r3 = r19
            r6 = r20
            r8 = r20
            r13 = r9
            r9 = r16
            r14 = r10
            r10 = r17
            r1.recordEvaluationEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            com.launchdarkly.sdk.EvaluationReason$ErrorKind r1 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.FLAG_NOT_FOUND
            com.launchdarkly.sdk.EvaluationReason r1 = com.launchdarkly.sdk.EvaluationReason.error(r1)
            com.launchdarkly.sdk.EvaluationDetail r1 = com.launchdarkly.sdk.EvaluationDetail.fromValue(r12, r13, r1)
            goto L_0x00ef
        L_0x0042:
            r13 = r9
            r14 = r10
            com.launchdarkly.sdk.LDValue r2 = r1.getValue()
            java.lang.Integer r3 = r1.getVariation()
            if (r3 != 0) goto L_0x0050
            r9 = r13
            goto L_0x0058
        L_0x0050:
            java.lang.Integer r3 = r1.getVariation()
            int r9 = r3.intValue()
        L_0x0058:
            boolean r3 = r2.isNull()
            if (r3 == 0) goto L_0x0071
            com.launchdarkly.logging.LDLogger r2 = r0.logger
            java.lang.String r3 = "Feature flag \"{}\" retrieved with no value; returning default value"
            r2.warn((java.lang.String) r3, (java.lang.Object) r11)
            com.launchdarkly.sdk.EvaluationReason r2 = r1.getReason()
            com.launchdarkly.sdk.EvaluationDetail r2 = com.launchdarkly.sdk.EvaluationDetail.fromValue(r12, r9, r2)
        L_0x006d:
            r17 = r2
            r6 = r12
            goto L_0x00b2
        L_0x0071:
            if (r21 == 0) goto L_0x00a7
            boolean r3 = r20.isNull()
            if (r3 != 0) goto L_0x00a7
            com.launchdarkly.sdk.LDValueType r3 = r2.getType()
            com.launchdarkly.sdk.LDValueType r4 = r20.getType()
            if (r3 == r4) goto L_0x00a7
            com.launchdarkly.logging.LDLogger r3 = r0.logger
            java.lang.Object[] r4 = new java.lang.Object[r14]
            r4[r15] = r11
            com.launchdarkly.sdk.LDValueType r2 = r2.getType()
            r5 = 1
            r4[r5] = r2
            com.launchdarkly.sdk.LDValueType r2 = r20.getType()
            r5 = 2
            r4[r5] = r2
            java.lang.String r2 = "Feature flag \"{}\" with type {} retrieved as {}; returning default value"
            r3.warn((java.lang.String) r2, (java.lang.Object[]) r4)
            com.launchdarkly.sdk.EvaluationReason$ErrorKind r2 = com.launchdarkly.sdk.EvaluationReason.ErrorKind.WRONG_TYPE
            com.launchdarkly.sdk.EvaluationReason r2 = com.launchdarkly.sdk.EvaluationReason.error(r2)
            com.launchdarkly.sdk.EvaluationDetail r2 = com.launchdarkly.sdk.EvaluationDetail.fromValue(r12, r13, r2)
            goto L_0x006d
        L_0x00a7:
            com.launchdarkly.sdk.EvaluationReason r3 = r1.getReason()
            com.launchdarkly.sdk.EvaluationDetail r3 = com.launchdarkly.sdk.EvaluationDetail.fromValue(r2, r9, r3)
            r6 = r2
            r17 = r3
        L_0x00b2:
            com.launchdarkly.sdk.android.subsystems.EventProcessor r2 = r0.eventProcessor
            com.launchdarkly.sdk.android.ContextDataManager r3 = r0.contextDataManager
            com.launchdarkly.sdk.LDContext r3 = r3.getCurrentContext()
            int r4 = r1.getVersionForEvents()
            java.lang.Integer r5 = r1.getVariation()
            if (r5 != 0) goto L_0x00c6
            r5 = r13
            goto L_0x00ce
        L_0x00c6:
            java.lang.Integer r5 = r1.getVariation()
            int r5 = r5.intValue()
        L_0x00ce:
            boolean r7 = r1.isTrackReason()
            r7 = r7 | r22
            if (r7 == 0) goto L_0x00db
            com.launchdarkly.sdk.EvaluationReason r7 = r17.getReason()
            goto L_0x00dc
        L_0x00db:
            r7 = 0
        L_0x00dc:
            boolean r9 = r1.isTrackEvents()
            java.lang.Long r10 = r1.getDebugEventsUntilDate()
            r1 = r2
            r2 = r3
            r3 = r19
            r8 = r20
            r1.recordEvaluationEvent(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            r1 = r17
        L_0x00ef:
            com.launchdarkly.logging.LDLogger r2 = r0.logger
            java.lang.Object[] r3 = new java.lang.Object[r14]
            r3[r15] = r1
            r4 = 1
            r3[r4] = r11
            com.launchdarkly.sdk.android.ContextDataManager r4 = r0.contextDataManager
            com.launchdarkly.sdk.LDContext r4 = r4.getCurrentContext()
            java.lang.String r4 = r4.getKey()
            r5 = 2
            r3[r5] = r4
            java.lang.String r4 = "returning variation: {} flagKey: {} context key: {}"
            r2.debug((java.lang.String) r4, (java.lang.Object[]) r3)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.sdk.android.LDClient.variationDetailInternal(java.lang.String, com.launchdarkly.sdk.LDValue, boolean, boolean):com.launchdarkly.sdk.EvaluationDetail");
    }

    public void close() throws IOException {
        closeInstances();
        synchronized (initLock) {
            if (sharedTaskExecutor != null) {
                sharedTaskExecutor.close();
            }
            sharedTaskExecutor = null;
            if (sharedPlatformState != null) {
                sharedPlatformState.close();
            }
            sharedPlatformState = null;
        }
    }

    private void closeInternal() {
        this.connectivityManager.shutDown();
        try {
            this.eventProcessor.close();
        } catch (IOException e) {
            LDUtil.logExceptionAtWarnLevel(this.logger, e, "Unexpected exception from closing event processor", new Object[0]);
        }
    }

    private void closeInstances() {
        Collection<LDClient> values;
        synchronized (initLock) {
            values = getInstancesIfTheyIncludeThisClient().values();
            instances = null;
        }
        for (LDClient closeInternal : values) {
            closeInternal.closeInternal();
        }
        sharedLogger = null;
    }

    public void flush() {
        for (LDClient flushInternal : getInstancesIfTheyIncludeThisClient().values()) {
            flushInternal.flushInternal();
        }
    }

    private void flushInternal() {
        this.eventProcessor.flush();
    }

    /* access modifiers changed from: package-private */
    public void blockingFlush() {
        this.eventProcessor.blockingFlush();
    }

    public boolean isInitialized() {
        return this.connectivityManager.isForcedOffline() || this.connectivityManager.isInitialized();
    }

    public boolean isOffline() {
        return this.connectivityManager.isForcedOffline();
    }

    public void setOffline() {
        for (LDClient offlineInternal : getInstancesIfTheyIncludeThisClient().values()) {
            offlineInternal.setOfflineInternal();
        }
    }

    private void setOfflineInternal() {
        this.connectivityManager.setForceOffline(true);
    }

    public void setOnline() {
        for (LDClient onlineStatusInternal : getInstancesIfTheyIncludeThisClient().values()) {
            onlineStatusInternal.setOnlineStatusInternal();
        }
    }

    private void setOnlineStatusInternal() {
        this.connectivityManager.setForceOffline(false);
    }

    public void registerFeatureFlagListener(String str, FeatureFlagChangeListener featureFlagChangeListener) {
        this.contextDataManager.registerListener(str, featureFlagChangeListener);
    }

    public void unregisterFeatureFlagListener(String str, FeatureFlagChangeListener featureFlagChangeListener) {
        this.contextDataManager.unregisterListener(str, featureFlagChangeListener);
    }

    public boolean isDisableBackgroundPolling() {
        return this.config.isDisableBackgroundPolling();
    }

    public ConnectionInformation getConnectionInformation() {
        return this.connectivityManager.getConnectionInformation();
    }

    public void registerStatusListener(LDStatusListener lDStatusListener) {
        this.connectivityManager.registerStatusListener(lDStatusListener);
    }

    public void unregisterStatusListener(LDStatusListener lDStatusListener) {
        this.connectivityManager.unregisterStatusListener(lDStatusListener);
    }

    public void registerAllFlagsListener(LDAllFlagsListener lDAllFlagsListener) {
        this.contextDataManager.registerAllFlagsListener(lDAllFlagsListener);
    }

    public void unregisterAllFlagsListener(LDAllFlagsListener lDAllFlagsListener) {
        this.contextDataManager.unregisterAllFlagsListener(lDAllFlagsListener);
    }

    private static LDLogger initSharedLogger(LDConfig lDConfig) {
        LDLogger lDLogger;
        synchronized (initLock) {
            if (sharedLogger == null) {
                sharedLogger = LDLogger.withAdapter(lDConfig.getLogAdapter(), lDConfig.getLoggerName());
            }
            lDLogger = sharedLogger;
        }
        return lDLogger;
    }

    static LDLogger getSharedLogger() {
        LDLogger lDLogger = sharedLogger;
        if (lDLogger != null) {
            return lDLogger;
        }
        return LDLogger.none();
    }
}
