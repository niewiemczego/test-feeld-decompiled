package com.launchdarkly.reactnative;

import android.app.Application;
import android.net.Uri;
import androidx.arch.core.util.Function;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.facebook.appevents.UserDataStore;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableType;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.Gson;
import com.launchdarkly.reactnative.utils.LDUtil;
import com.launchdarkly.sdk.EvaluationDetail;
import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDUser;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.ObjectBuilder;
import com.launchdarkly.sdk.UserAttribute;
import com.launchdarkly.sdk.android.Components;
import com.launchdarkly.sdk.android.ConnectionInformation;
import com.launchdarkly.sdk.android.FeatureFlagChangeListener;
import com.launchdarkly.sdk.android.LDAllFlagsListener;
import com.launchdarkly.sdk.android.LDClient;
import com.launchdarkly.sdk.android.LDConfig;
import com.launchdarkly.sdk.android.LDFailure;
import com.launchdarkly.sdk.android.LDStatusListener;
import com.launchdarkly.sdk.android.integrations.ApplicationInfoBuilder;
import com.launchdarkly.sdk.android.integrations.EventProcessorBuilder;
import com.launchdarkly.sdk.android.integrations.HttpConfigurationBuilder;
import com.launchdarkly.sdk.android.integrations.PollingDataSourceBuilder;
import com.launchdarkly.sdk.android.integrations.ServiceEndpointsBuilder;
import com.launchdarkly.sdk.android.integrations.StreamingDataSourceBuilder;
import io.sentry.clientreport.DiscardedEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import timber.log.Timber;

public class LaunchdarklyReactNativeClientModule extends ReactContextBaseJavaModule {
    private static final String ALL_FLAGS_PREFIX = "LaunchDarkly-All-Flags-";
    private static final String CONNECTION_MODE_PREFIX = "LaunchDarkly-Connection-Mode-";
    private static final String ERROR_CLOSE = "E_CLOSE";
    private static final String ERROR_IDENTIFY = "E_IDENTIFY";
    private static final String ERROR_INIT = "E_INITIALIZE";
    private static final String ERROR_UNKNOWN = "E_UNKNOWN";
    private static final String FLAG_PREFIX = "LaunchDarkly-Flag-";
    private static boolean debugLoggingStarted = false;
    /* access modifiers changed from: private */
    public static final Gson gson = new Gson();
    private final Map<String, LDAllFlagsListener> allFlagsListeners = new HashMap();
    private final Map<String, LDStatusListener> connectionModeListeners = new HashMap();
    private final Map<String, FeatureFlagChangeListener> listeners = new HashMap();

    interface ConvertFromReadable<T> {
        T getFromMap(ReadableMap readableMap, String str);
    }

    interface EvalCall<T> {
        T call(LDClient lDClient, String str, T t);
    }

    interface EvalDetailCall<T> {
        EvaluationDetail<T> call(LDClient lDClient, String str, T t);
    }

    static /* synthetic */ LDValue lambda$jsonVariation$0(LDValue lDValue) {
        return lDValue;
    }

    static /* synthetic */ LDValue lambda$jsonVariationDetail$1(LDValue lDValue) {
        return lDValue;
    }

    @ReactMethod
    public void addListener(String str) {
    }

    public String getName() {
        return "LaunchdarklyReactNativeClient";
    }

    @ReactMethod
    public void removeListeners(Integer num) {
    }

    public LaunchdarklyReactNativeClientModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getConstants() {
        HashMap hashMap = new HashMap();
        hashMap.put("FLAG_PREFIX", FLAG_PREFIX);
        hashMap.put("ALL_FLAGS_PREFIX", ALL_FLAGS_PREFIX);
        hashMap.put("CONNECTION_MODE_PREFIX", CONNECTION_MODE_PREFIX);
        return hashMap;
    }

    @ReactMethod
    public void configure(ReadableMap readableMap, ReadableMap readableMap2, boolean z, Promise promise) {
        internalConfigure(readableMap, readableMap2, (Integer) null, z, promise);
    }

    @ReactMethod
    public void configureWithTimeout(ReadableMap readableMap, ReadableMap readableMap2, Integer num, boolean z, Promise promise) {
        internalConfigure(readableMap, readableMap2, num, z, promise);
    }

    private void internalConfigure(ReadableMap readableMap, ReadableMap readableMap2, Integer num, boolean z, Promise promise) {
        if (!debugLoggingStarted && LDUtil.validateConfig("debugMode", readableMap, ReadableType.Boolean) && readableMap.getBoolean("debugMode")) {
            Timber.plant((Timber.Tree) new Timber.DebugTree());
            debugLoggingStarted = true;
        }
        final Application application = (Application) getReactApplicationContext().getApplicationContext();
        if (application != null) {
            final ReadableMap readableMap3 = readableMap;
            final boolean z2 = z;
            final Integer num2 = num;
            final ReadableMap readableMap4 = readableMap2;
            final Promise promise2 = promise;
            new Thread(new Runnable() {
                public void run() {
                    LDConfig build = LaunchdarklyReactNativeClientModule.this.buildConfiguration(readableMap3).build();
                    boolean z = !z2;
                    try {
                        if (num2 != null) {
                            if (z) {
                                LDClient.init(application, build, LaunchdarklyReactNativeClientModule.this.configureLegacyUser(readableMap4), num2.intValue());
                            } else {
                                LDClient.init(application, build, LDUtil.configureContext(readableMap4), num2.intValue());
                            }
                        } else if (z) {
                            LDClient.init(application, build, LaunchdarklyReactNativeClientModule.this.configureLegacyUser(readableMap4)).get();
                        } else {
                            LDClient.init(application, build, LDUtil.configureContext(readableMap4)).get();
                        }
                    } catch (Exception e) {
                        Timber.e(e, "Exception during Client initialization", new Object[0]);
                    }
                    promise2.resolve((Object) null);
                }
            }).start();
            return;
        }
        Timber.e("Couldn't initialize the LaunchDarkly module because the application was null", new Object[0]);
        promise.reject(ERROR_INIT, "Couldn't acquire ReactApplicationContext");
    }

    private void configureDataSource(ReadableMap readableMap, LDConfig.Builder builder) {
        if (LDUtil.validateConfig("stream", readableMap, ReadableType.Boolean) ? readableMap.getBoolean("stream") : true) {
            StreamingDataSourceBuilder streamingDataSource = Components.streamingDataSource();
            if (LDUtil.validateConfig("backgroundPollingInterval", readableMap, ReadableType.Number)) {
                streamingDataSource.backgroundPollIntervalMillis(readableMap.getInt("backgroundPollingInterval"));
            }
            builder.dataSource(streamingDataSource);
            return;
        }
        PollingDataSourceBuilder pollingDataSource = Components.pollingDataSource();
        if (LDUtil.validateConfig("backgroundPollingInterval", readableMap, ReadableType.Number)) {
            pollingDataSource.backgroundPollIntervalMillis(readableMap.getInt("backgroundPollingInterval"));
        }
        if (LDUtil.validateConfig("pollingInterval", readableMap, ReadableType.Number)) {
            pollingDataSource.pollIntervalMillis(readableMap.getInt("pollingInterval"));
        }
        builder.dataSource(pollingDataSource);
    }

    private void configureEvents(ReadableMap readableMap, LDConfig.Builder builder) {
        EventProcessorBuilder sendEvents = Components.sendEvents();
        if (LDUtil.validateConfig("allAttributesPrivate", readableMap, ReadableType.Boolean)) {
            sendEvents.allAttributesPrivate(readableMap.getBoolean("allAttributesPrivate"));
        }
        if (LDUtil.validateConfig("diagnosticRecordingInterval", readableMap, ReadableType.Number)) {
            sendEvents.diagnosticRecordingIntervalMillis(readableMap.getInt("diagnosticRecordingInterval"));
        }
        if (LDUtil.validateConfig("eventCapacity", readableMap, ReadableType.Number)) {
            sendEvents.capacity(readableMap.getInt("eventCapacity"));
        }
        if (LDUtil.validateConfig("flushInterval", readableMap, ReadableType.Number)) {
            sendEvents.flushIntervalMillis(readableMap.getInt("flushInterval"));
        }
        sendEvents.privateAttributes(LDUtil.getPrivateAttributesArray(readableMap));
        builder.events(sendEvents);
    }

    private void configureHttp(ReadableMap readableMap, LDConfig.Builder builder) {
        HttpConfigurationBuilder httpConfiguration = Components.httpConfiguration();
        if (LDUtil.validateConfig("connectionTimeout", readableMap, ReadableType.Boolean)) {
            httpConfiguration.connectTimeoutMillis(readableMap.getInt("connectionTimeout"));
        }
        if (LDUtil.validateConfig("useReport", readableMap, ReadableType.Boolean)) {
            httpConfiguration.useReport(readableMap.getBoolean("useReport"));
        }
        httpConfiguration.wrapper(LDUtil.validateConfig("wrapperName", readableMap, ReadableType.String) ? readableMap.getString("wrapperName") : "react-native-client-sdk", LDUtil.validateConfig("wrapperVersion", readableMap, ReadableType.String) ? readableMap.getString("wrapperVersion") : "7.0.0");
        builder.http(httpConfiguration);
    }

    private void configureEndpoints(ReadableMap readableMap, LDConfig.Builder builder) {
        ServiceEndpointsBuilder serviceEndpoints = Components.serviceEndpoints();
        if (LDUtil.validateConfig("streamUrl", readableMap, ReadableType.String)) {
            serviceEndpoints.streaming(readableMap.getString("streamUrl"));
        }
        if (LDUtil.validateConfig("pollUrl", readableMap, ReadableType.String)) {
            serviceEndpoints.polling(readableMap.getString("pollUrl"));
        }
        if (LDUtil.validateConfig("eventsUrl", readableMap, ReadableType.String)) {
            serviceEndpoints.events(readableMap.getString("eventsUrl"));
        }
        builder.serviceEndpoints(serviceEndpoints);
    }

    private void configureApplicationInfo(ReadableMap readableMap, LDConfig.Builder builder) {
        if (LDUtil.validateConfig(MimeTypes.BASE_TYPE_APPLICATION, readableMap, ReadableType.Map)) {
            ReadableMap map = readableMap.getMap(MimeTypes.BASE_TYPE_APPLICATION);
            ApplicationInfoBuilder applicationInfo = Components.applicationInfo();
            if (LDUtil.validateConfig("id", map, ReadableType.String)) {
                applicationInfo.applicationId(map.getString("id"));
            }
            if (LDUtil.validateConfig("version", map, ReadableType.String)) {
                applicationInfo.applicationVersion(map.getString("version"));
            }
            builder.applicationInfo(applicationInfo);
        }
    }

    /* access modifiers changed from: private */
    public LDConfig.Builder buildConfiguration(ReadableMap readableMap) {
        LDConfig.Builder builder = new LDConfig.Builder();
        builder.generateAnonymousKeys(true);
        for (ConfigMapping loadFromMap : ConfigMapping.values()) {
            loadFromMap.loadFromMap(readableMap, builder);
        }
        configureDataSource(readableMap, builder);
        configureEvents(readableMap, builder);
        configureHttp(readableMap, builder);
        configureEndpoints(readableMap, builder);
        configureApplicationInfo(readableMap, builder);
        return builder;
    }

    /* access modifiers changed from: private */
    public LDUser configureLegacyUser(ReadableMap readableMap) {
        LDUser.Builder builder = new LDUser.Builder((!readableMap.hasKey("key") || readableMap.getType("key") != ReadableType.String) ? null : readableMap.getString("key"));
        HashSet hashSet = new HashSet();
        if (readableMap.hasKey("privateAttributeNames") && readableMap.getType("privateAttributeNames") == ReadableType.Array) {
            ReadableArray array = readableMap.getArray("privateAttributeNames");
            for (int i = 0; i < array.size(); i++) {
                if (array.getType(i) == ReadableType.String) {
                    hashSet.add(array.getString(i));
                }
            }
        }
        for (UserConfigMapping loadFromMap : UserConfigMapping.values()) {
            loadFromMap.loadFromMap(readableMap, builder, hashSet);
        }
        if (readableMap.hasKey(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM) && readableMap.getType(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM) == ReadableType.Map) {
            LDValue lDValue = LDUtil.toLDValue(readableMap.getMap(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM));
            for (String next : lDValue.keys()) {
                if (hashSet.contains(next)) {
                    builder.privateCustom(next, lDValue.get(next));
                } else {
                    builder.custom(next, lDValue.get(next));
                }
            }
        }
        return builder.build();
    }

    @ReactMethod
    public void boolVariation(String str, boolean z, String str2, Promise promise) {
        variation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda2(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda9(), str, Boolean.valueOf(z), str2, promise);
    }

    @ReactMethod
    public void numberVariation(String str, double d, String str2, Promise promise) {
        variation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda0(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda4(), str, Double.valueOf(d), str2, promise);
    }

    @ReactMethod
    public void stringVariation(String str, String str2, String str3, Promise promise) {
        variation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda3(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda11(), str, str2, str3, promise);
    }

    @ReactMethod
    public void jsonVariation(String str, Dynamic dynamic, String str2, Promise promise) {
        variation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda5(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda6(), str, LDUtil.toLDValue(dynamic), str2, promise);
    }

    private <T> void variation(EvalCall<T> evalCall, Function<T, LDValue> function, String str, T t, String str2, Promise promise) {
        try {
            promise.resolve(LDUtil.ldValueToBridge(function.apply(evalCall.call(LDClient.getForMobileKey(str2), str, t))));
        } catch (Exception unused) {
            promise.resolve(LDUtil.ldValueToBridge(function.apply(t)));
        }
    }

    @ReactMethod
    public void boolVariationDetail(String str, boolean z, String str2, Promise promise) {
        detailVariation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda8(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda9(), str, Boolean.valueOf(z), str2, promise);
    }

    @ReactMethod
    public void numberVariationDetail(String str, double d, String str2, Promise promise) {
        detailVariation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda7(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda4(), str, Double.valueOf(d), str2, promise);
    }

    @ReactMethod
    public void stringVariationDetail(String str, String str2, String str3, Promise promise) {
        detailVariation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda10(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda11(), str, str2, str3, promise);
    }

    @ReactMethod
    public void jsonVariationDetail(String str, Dynamic dynamic, String str2, Promise promise) {
        detailVariation(new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda12(), new LaunchdarklyReactNativeClientModule$$ExternalSyntheticLambda1(), str, LDUtil.toLDValue(dynamic), str2, promise);
    }

    private <T> void detailVariation(EvalDetailCall<T> evalDetailCall, Function<T, LDValue> function, String str, T t, String str2, Promise promise) {
        try {
            EvaluationDetail<T> call = evalDetailCall.call(LDClient.getForMobileKey(str2), str, t);
            ObjectBuilder objectBuilderFromDetail = objectBuilderFromDetail(call);
            objectBuilderFromDetail.put("value", function.apply(call.getValue()));
            promise.resolve(LDUtil.ldValueToBridge(objectBuilderFromDetail.build()));
        } catch (Exception unused) {
            ObjectBuilder buildObject = LDValue.buildObject();
            buildObject.put("kind", EvaluationReason.Kind.ERROR.name());
            buildObject.put("errorKind", EvaluationReason.ErrorKind.EXCEPTION.name());
            buildObject.put("value", function.apply(t));
            promise.resolve(LDUtil.ldValueToBridge(buildObject.build()));
        }
    }

    private ObjectBuilder objectBuilderFromDetail(EvaluationDetail<?> evaluationDetail) {
        ObjectBuilder buildObject = LDValue.buildObject();
        if (!evaluationDetail.isDefaultValue()) {
            buildObject.put("variationIndex", evaluationDetail.getVariationIndex());
        } else {
            buildObject.put("variationIndex", LDValue.ofNull());
        }
        EvaluationReason reason = evaluationDetail.getReason();
        if (reason == null) {
            buildObject.put(DiscardedEvent.JsonKeys.REASON, LDValue.ofNull());
            return buildObject;
        }
        ObjectBuilder buildObject2 = LDValue.buildObject();
        buildObject2.put("kind", reason.getKind().name());
        int i = AnonymousClass7.$SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind[reason.getKind().ordinal()];
        if (i == 1) {
            buildObject2.put("ruleIndex", reason.getRuleIndex());
            buildObject2.put("ruleId", reason.getRuleId());
            if (reason.isInExperiment()) {
                buildObject2.put("inExperiment", true);
            }
        } else if (i == 2) {
            buildObject2.put("prerequisiteKey", reason.getPrerequisiteKey());
        } else if (i == 3) {
            buildObject2.put("errorKind", reason.getErrorKind().name());
        } else if (i == 4 && reason.isInExperiment()) {
            buildObject2.put("inExperiment", true);
        }
        buildObject.put(DiscardedEvent.JsonKeys.REASON, buildObject2.build());
        return buildObject;
    }

    /* renamed from: com.launchdarkly.reactnative.LaunchdarklyReactNativeClientModule$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
        static final /* synthetic */ int[] $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.launchdarkly.sdk.EvaluationReason$Kind[] r0 = com.launchdarkly.sdk.EvaluationReason.Kind.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind = r0
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.RULE_MATCH     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x001d }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.PREREQUISITE_FAILED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.ERROR     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$launchdarkly$sdk$EvaluationReason$Kind     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.launchdarkly.sdk.EvaluationReason$Kind r1 = com.launchdarkly.sdk.EvaluationReason.Kind.FALLTHROUGH     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.launchdarkly.reactnative.LaunchdarklyReactNativeClientModule.AnonymousClass7.<clinit>():void");
        }
    }

    @ReactMethod
    public void allFlags(String str, Promise promise) {
        ObjectBuilder buildObject = LDValue.buildObject();
        try {
            for (Map.Entry next : LDClient.getForMobileKey(str).allFlags().entrySet()) {
                buildObject.put((String) next.getKey(), (LDValue) next.getValue());
            }
            promise.resolve(LDUtil.ldValueToBridge(buildObject.build()));
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in allFlags", new Object[0]);
            promise.resolve(LDUtil.ldValueToBridge(buildObject.build()));
        }
    }

    @ReactMethod
    public void trackData(String str, Dynamic dynamic, String str2) {
        trackSafe(str2, str, LDUtil.toLDValue(dynamic), (Double) null);
    }

    @ReactMethod
    public void trackMetricValue(String str, Dynamic dynamic, double d, String str2) {
        trackSafe(str2, str, LDUtil.toLDValue(dynamic), Double.valueOf(d));
    }

    private void trackSafe(String str, String str2, LDValue lDValue, Double d) {
        try {
            LDClient forMobileKey = LDClient.getForMobileKey(str);
            if (d != null) {
                forMobileKey.trackMetric(str2, lDValue, d.doubleValue());
            } else {
                forMobileKey.trackData(str2, lDValue);
            }
        } catch (Exception e) {
            Timber.w(e);
        }
    }

    @ReactMethod
    public void setOffline(Promise promise) {
        try {
            LDClient.get().setOffline();
            promise.resolve(true);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in setOffline", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void isOffline(Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(LDClient.get().isOffline()));
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in isOffline", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void setOnline(Promise promise) {
        try {
            LDClient.get().setOnline();
            promise.resolve(true);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in setOnline", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void isInitialized(String str, Promise promise) {
        try {
            promise.resolve(Boolean.valueOf(LDClient.getForMobileKey(str).isInitialized()));
        } catch (Exception e) {
            promise.reject(ERROR_UNKNOWN, (Throwable) e);
        }
    }

    @ReactMethod
    public void flush() {
        try {
            LDClient.get().flush();
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in flush", new Object[0]);
        }
    }

    @ReactMethod
    public void close(Promise promise) {
        try {
            LDClient.get().close();
            promise.resolve(true);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in close", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void identify(ReadableMap readableMap, boolean z, final Promise promise) {
        if (z) {
            final LDContext configureContext = LDUtil.configureContext(readableMap);
            new Thread(new Runnable() {
                public void run() {
                    try {
                        LDClient.get().identify(configureContext).get();
                    } catch (Exception e) {
                        Timber.w(e, "Warning: exception caught in identify", new Object[0]);
                    }
                    promise.resolve((Object) null);
                }
            }).start();
            return;
        }
        final LDUser configureLegacyUser = configureLegacyUser(readableMap);
        new Thread(new Runnable() {
            public void run() {
                try {
                    LDClient.get().identify(configureLegacyUser).get();
                } catch (Exception e) {
                    Timber.w(e, "Warning: exception caught in identify", new Object[0]);
                }
                promise.resolve((Object) null);
            }
        }).start();
    }

    @ReactMethod
    public void getConnectionMode(String str, Promise promise) {
        try {
            promise.resolve(LDClient.getForMobileKey(str).getConnectionInformation().getConnectionMode().name());
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in getConnectionMode", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    @ReactMethod
    public void getLastSuccessfulConnection(String str, Promise promise) {
        try {
            Long lastSuccessfulConnection = LDClient.getForMobileKey(str).getConnectionInformation().getLastSuccessfulConnection();
            if (lastSuccessfulConnection != null) {
                promise.resolve(Double.valueOf(lastSuccessfulConnection.doubleValue()));
            } else {
                promise.resolve((Object) null);
            }
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in getLastSuccessfulConnection", new Object[0]);
            promise.resolve(0);
        }
    }

    @ReactMethod
    public void getLastFailedConnection(String str, Promise promise) {
        try {
            Long lastFailedConnection = LDClient.getForMobileKey(str).getConnectionInformation().getLastFailedConnection();
            if (lastFailedConnection != null) {
                promise.resolve(Double.valueOf(lastFailedConnection.doubleValue()));
            } else {
                promise.resolve((Object) null);
            }
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in getLastFailedConnection", new Object[0]);
            promise.resolve(0);
        }
    }

    @ReactMethod
    public void getLastFailure(String str, Promise promise) {
        try {
            promise.resolve(LDClient.getForMobileKey(str).getConnectionInformation().getLastFailure().getFailureType().name());
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in getLastSuccessfulConnection", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    private String envConcat(String str, String str2) {
        return str.concat(";").concat(str2);
    }

    @ReactMethod
    public void registerFeatureFlagListener(String str, String str2) {
        final String envConcat = envConcat(str2, str);
        AnonymousClass4 r1 = new FeatureFlagChangeListener() {
            public void onFeatureFlagChange(String str) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("flagKey", str);
                createMap.putString("listenerId", envConcat);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) LaunchdarklyReactNativeClientModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(LaunchdarklyReactNativeClientModule.FLAG_PREFIX, createMap);
            }
        };
        try {
            LDClient.getForMobileKey(str2).registerFeatureFlagListener(str, r1);
            this.listeners.put(str, r1);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in registerFeatureFlagListener", new Object[0]);
        }
    }

    @ReactMethod
    public void unregisterFeatureFlagListener(String str, String str2) {
        String envConcat = envConcat(str2, str);
        try {
            if (this.listeners.containsKey(envConcat)) {
                LDClient.getForMobileKey(str2).unregisterFeatureFlagListener(str, this.listeners.get(envConcat));
                this.listeners.remove(envConcat);
            }
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in unregisterFeatureFlagListener", new Object[0]);
        }
    }

    @ReactMethod
    public void registerCurrentConnectionModeListener(String str, String str2) {
        final String envConcat = envConcat(str2, str);
        AnonymousClass5 r0 = new LDStatusListener() {
            public void onInternalFailure(LDFailure lDFailure) {
            }

            public void onConnectionModeChanged(ConnectionInformation connectionInformation) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("connectionMode", LaunchdarklyReactNativeClientModule.gson.toJson((Object) connectionInformation));
                createMap.putString("listenerId", envConcat);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) LaunchdarklyReactNativeClientModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(LaunchdarklyReactNativeClientModule.CONNECTION_MODE_PREFIX, createMap);
            }
        };
        try {
            LDClient.getForMobileKey(str2).registerStatusListener(r0);
            this.connectionModeListeners.put(envConcat, r0);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in registerCurrentConnectionModeListener", new Object[0]);
        }
    }

    @ReactMethod
    public void unregisterCurrentConnectionModeListener(String str, String str2) {
        try {
            String envConcat = envConcat(str2, str);
            if (this.connectionModeListeners.containsKey(envConcat)) {
                LDClient.getForMobileKey(str2).unregisterStatusListener(this.connectionModeListeners.get(envConcat));
                this.connectionModeListeners.remove(envConcat);
            }
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in unregisterCurrentConnectionModeListener", new Object[0]);
        }
    }

    @ReactMethod
    public void registerAllFlagsListener(String str, String str2) {
        final String envConcat = envConcat(str2, str);
        AnonymousClass6 r0 = new LDAllFlagsListener() {
            public void onChange(List<String> list) {
                WritableMap createMap = Arguments.createMap();
                createMap.putArray("flagKeys", Arguments.fromList(list));
                createMap.putString("listenerId", envConcat);
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) LaunchdarklyReactNativeClientModule.this.getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(LaunchdarklyReactNativeClientModule.ALL_FLAGS_PREFIX, createMap);
            }
        };
        try {
            LDClient.getForMobileKey(str2).registerAllFlagsListener(r0);
            this.allFlagsListeners.put(envConcat, r0);
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in registerAllFlagsListener", new Object[0]);
        }
    }

    @ReactMethod
    public void unregisterAllFlagsListener(String str, String str2) {
        try {
            String envConcat = envConcat(str2, str);
            if (this.allFlagsListeners.containsKey(envConcat)) {
                LDClient.getForMobileKey(str2).unregisterAllFlagsListener(this.allFlagsListeners.get(envConcat));
                this.allFlagsListeners.remove(envConcat);
            }
        } catch (Exception e) {
            Timber.w(e, "Warning: exception caught in unregisterAllFlagsListener", new Object[0]);
        }
    }

    enum ConfigMapping {
        CONFIG_MOBILE_KEY("mobileKey", ConfigEntryType.String),
        CONFIG_DISABLE_BACKGROUND_UPDATING("disableBackgroundUpdating", ConfigEntryType.Boolean),
        CONFIG_OFFLINE("offline", ConfigEntryType.Boolean),
        CONFIG_EVALUATION_REASONS("evaluationReasons", ConfigEntryType.Boolean),
        CONFIG_MAX_CACHED_USERS("maxCachedContexts", ConfigEntryType.Integer),
        CONFIG_DIAGNOSTIC_OPT_OUT("diagnosticOptOut", ConfigEntryType.Boolean),
        CONFIG_SECONDARY_MOBILE_KEYS("secondaryMobileKeys", ConfigEntryType.Map);
        
        final String key;
        private final Method setter;
        final ConfigEntryType type;

        private ConfigMapping(String str, ConfigEntryType configEntryType) {
            this(r7, r8, str, configEntryType, str);
        }

        private ConfigMapping(String str, ConfigEntryType configEntryType, String str2) {
            this.key = str;
            this.type = configEntryType;
            this.setter = LDUtil.findSetter(LDConfig.Builder.class, str2);
        }

        /* access modifiers changed from: package-private */
        public void loadFromMap(ReadableMap readableMap, LDConfig.Builder builder) {
            if (readableMap.hasKey(this.key) && readableMap.getType(this.key).equals(this.type.getReadableType())) {
                try {
                    this.setter.invoke(builder, new Object[]{this.type.getFromMap(readableMap, this.key)});
                } catch (IllegalAccessException | InvocationTargetException e) {
                    Timber.w(e);
                }
            }
        }
    }

    enum UserConfigMapping {
        USER_ANONYMOUS("anonymous", ConfigEntryType.Boolean, "anonymous", (ConfigEntryType) null),
        USER_IP("ip", ConfigEntryType.String, "ip", "privateIp"),
        USER_EMAIL("email", ConfigEntryType.String, "email", "privateEmail"),
        USER_FIRST_NAME("firstName", ConfigEntryType.String, "firstName", "privateFirstName"),
        USER_LAST_NAME("lastName", ConfigEntryType.String, "lastName", "privateLastName"),
        USER_NAME("name", ConfigEntryType.String, "name", "privateName"),
        USER_AVATAR("avatar", ConfigEntryType.String, "avatar", "privateAvatar"),
        USER_COUNTRY(UserDataStore.COUNTRY, ConfigEntryType.String, UserDataStore.COUNTRY, "privateCountry");
        
        final String key;
        private final Method privateSetter;
        private final Method setter;
        final ConfigEntryType type;

        private UserConfigMapping(String str, ConfigEntryType configEntryType, String str2, String str3) {
            this.key = str;
            this.type = configEntryType;
            this.setter = LDUtil.findSetter(LDUser.Builder.class, str2);
            this.privateSetter = LDUtil.findSetter(LDUser.Builder.class, str3);
        }

        /* access modifiers changed from: package-private */
        public void loadFromMap(ReadableMap readableMap, LDUser.Builder builder, Set<String> set) {
            Method method;
            if (readableMap.hasKey(this.key) && readableMap.getType(this.key).equals(this.type.getReadableType())) {
                try {
                    if (!set.contains(this.key) || (method = this.privateSetter) == null) {
                        this.setter.invoke(builder, new Object[]{this.type.getFromMap(readableMap, this.key)});
                        return;
                    }
                    method.invoke(builder, new Object[]{this.type.getFromMap(readableMap, this.key)});
                } catch (IllegalAccessException | InvocationTargetException e) {
                    Timber.w(e);
                }
            }
        }
    }

    enum ConfigEntryType implements ConvertFromReadable {
        String(ReadableType.String) {
            public String getFromMap(ReadableMap readableMap, String str) {
                return readableMap.getString(str);
            }
        },
        Uri(ReadableType.String) {
            public Uri getFromMap(ReadableMap readableMap, String str) {
                return Uri.parse(readableMap.getString(str));
            }
        },
        Integer(ReadableType.Number) {
            public Integer getFromMap(ReadableMap readableMap, String str) {
                return Integer.valueOf(readableMap.getInt(str));
            }
        },
        Boolean(ReadableType.Boolean) {
            public Boolean getFromMap(ReadableMap readableMap, String str) {
                return Boolean.valueOf(readableMap.getBoolean(str));
            }
        },
        Map(ReadableType.Map) {
            public Map getFromMap(ReadableMap readableMap, String str) {
                return readableMap.getMap(str).toHashMap();
            }
        },
        UserAttributes(ReadableType.Array) {
            public UserAttribute[] getFromMap(ReadableMap readableMap, String str) {
                ReadableArray array = readableMap.getArray(str);
                HashSet hashSet = new HashSet();
                for (int i = 0; i < array.size(); i++) {
                    if (array.getType(i).equals(ReadableType.String)) {
                        hashSet.add(UserAttribute.forName(array.getString(i)));
                    }
                }
                return (UserAttribute[]) hashSet.toArray(new UserAttribute[0]);
            }
        };
        
        private final ReadableType base;

        private ConfigEntryType(ReadableType readableType) {
            this.base = readableType;
        }

        /* access modifiers changed from: package-private */
        public ReadableType getReadableType() {
            return this.base;
        }
    }
}
