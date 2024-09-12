package io.sentry.react;

import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseIntArray;
import androidx.core.app.FrameMetricsAggregator;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import app.notifee.core.event.LogEvent;
import com.facebook.hermes.instrumentation.HermesSamplingProfiler;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.gms.common.Scopes;
import com.reactnativecommunity.clipboard.ClipboardModule;
import io.sentry.Breadcrumb;
import io.sentry.DateUtils;
import io.sentry.Hint;
import io.sentry.HubAdapter;
import io.sentry.ILogger;
import io.sentry.IScope;
import io.sentry.ISentryExecutorService;
import io.sentry.Integration;
import io.sentry.ProfilingTraceData;
import io.sentry.Sentry;
import io.sentry.SentryBaseEvent;
import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.SentryEvent;
import io.sentry.SentryExecutorService;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.UncaughtExceptionHandlerIntegration;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.AndroidProfiler;
import io.sentry.android.core.AnrIntegration;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.CurrentActivityHolder;
import io.sentry.android.core.InternalSentrySdk;
import io.sentry.android.core.NdkIntegration;
import io.sentry.android.core.SentryAndroid;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.ViewHierarchyEventProcessor;
import io.sentry.android.core.internal.debugmeta.AssetsDebugMetaLoader;
import io.sentry.android.core.internal.util.ScreenshotUtils;
import io.sentry.android.core.internal.util.SentryFrameMetricsCollector;
import io.sentry.android.core.performance.AppStartMetrics;
import io.sentry.protocol.OperatingSystem;
import io.sentry.protocol.SdkVersion;
import io.sentry.protocol.SentryException;
import io.sentry.protocol.SentryPackage;
import io.sentry.protocol.User;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.util.DebugMetaPropertiesApplier;
import io.sentry.util.FileUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.vendor.Base64;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class RNSentryModuleImpl {
    private static final String ANDROID_SDK_NAME = "sentry.java.android.react-native";
    private static final int FROZEN_FRAME_THRESHOLD = 700;
    public static final String NAME = "RNSentry";
    private static final String NATIVE_SDK_NAME = "sentry.native.android.react-native";
    private static final int SCREENSHOT_TIMEOUT_SECONDS = 2;
    private static final int SLOW_FRAME_THRESHOLD = 16;
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    private static final BuildInfoProvider buildInfo;
    private static boolean didFetchAppStart = false;
    private static final ILogger logger;
    private static final String modulesPath = "modules.json";
    private AndroidProfiler androidProfiler = null;
    private boolean androidXAvailable;
    private String cacheDirPath = null;
    private final Runnable emitNewFrameEvent;
    private ISentryExecutorService executorService = null;
    private FrameMetricsAggregator frameMetricsAggregator = null;
    private boolean isProguardDebugMetaLoaded = false;
    private long maxTraceFileSize = CacheDataSink.DEFAULT_FRAGMENT_SIZE;
    private final PackageInfo packageInfo;
    private int profilingTracesHz = 101;
    private String proguardUuid = null;
    private final ReactApplicationContext reactApplicationContext;

    static {
        AndroidLogger androidLogger = new AndroidLogger(NAME);
        logger = androidLogger;
        buildInfo = new BuildInfoProvider(androidLogger);
    }

    public RNSentryModuleImpl(ReactApplicationContext reactApplicationContext2) {
        this.packageInfo = getPackageInfo(reactApplicationContext2);
        this.reactApplicationContext = reactApplicationContext2;
        this.emitNewFrameEvent = createEmitNewFrameEvent();
    }

    private ReactApplicationContext getReactApplicationContext() {
        return this.reactApplicationContext;
    }

    private Activity getCurrentActivity() {
        return this.reactApplicationContext.getCurrentActivity();
    }

    private Runnable createEmitNewFrameEvent() {
        return new RNSentryModuleImpl$$ExternalSyntheticLambda1(this, new SentryAndroidDateProvider());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$createEmitNewFrameEvent$0$io-sentry-react-RNSentryModuleImpl  reason: not valid java name */
    public /* synthetic */ void m932lambda$createEmitNewFrameEvent$0$iosentryreactRNSentryModuleImpl(SentryDateProvider sentryDateProvider) {
        SentryDate now = sentryDateProvider.now();
        WritableMap createMap = Arguments.createMap();
        createMap.putDouble("newFrameTimestampInSeconds", ((double) now.nanoTimestamp()) / 1.0E9d);
        ((DeviceEventManagerModule.RCTDeviceEventEmitter) getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("rn_sentry_new_frame", createMap);
    }

    private void initFragmentInitialFrameTracking() {
        FragmentManager supportFragmentManager;
        RNSentryReactFragmentLifecycleTracer rNSentryReactFragmentLifecycleTracer = new RNSentryReactFragmentLifecycleTracer(buildInfo, this.emitNewFrameEvent, logger);
        FragmentActivity fragmentActivity = (FragmentActivity) getCurrentActivity();
        if (fragmentActivity != null && (supportFragmentManager = fragmentActivity.getSupportFragmentManager()) != null) {
            supportFragmentManager.registerFragmentLifecycleCallbacks(rNSentryReactFragmentLifecycleTracer, true);
        }
    }

    public void initNativeReactNavigationNewFrameTracking(Promise promise) {
        initFragmentInitialFrameTracking();
    }

    public void initNativeSdk(ReadableMap readableMap, Promise promise) {
        SentryAndroid.init((Context) getReactApplicationContext(), (Sentry.OptionsConfiguration<SentryAndroidOptions>) new RNSentryModuleImpl$$ExternalSyntheticLambda0(this, readableMap));
        promise.resolve(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initNativeSdk$2$io-sentry-react-RNSentryModuleImpl  reason: not valid java name */
    public /* synthetic */ void m934lambda$initNativeSdk$2$iosentryreactRNSentryModuleImpl(ReadableMap readableMap, SentryAndroidOptions sentryAndroidOptions) {
        SdkVersion sdkVersion = sentryAndroidOptions.getSdkVersion();
        if (sdkVersion == null) {
            sdkVersion = new SdkVersion(ANDROID_SDK_NAME, "7.8.0");
        } else {
            sdkVersion.setName(ANDROID_SDK_NAME);
        }
        sentryAndroidOptions.setSentryClientName(sdkVersion.getName() + "/" + sdkVersion.getVersion());
        sentryAndroidOptions.setNativeSdkName(NATIVE_SDK_NAME);
        sentryAndroidOptions.setSdkVersion(sdkVersion);
        if (readableMap.hasKey(LogEvent.LEVEL_DEBUG) && readableMap.getBoolean(LogEvent.LEVEL_DEBUG)) {
            sentryAndroidOptions.setDebug(true);
        }
        if (!readableMap.hasKey("dsn") || readableMap.getString("dsn") == null) {
            sentryAndroidOptions.setDsn("");
        } else {
            String string = readableMap.getString("dsn");
            logger.log(SentryLevel.INFO, String.format("Starting with DSN: '%s'", new Object[]{string}), new Object[0]);
            sentryAndroidOptions.setDsn(string);
        }
        if (readableMap.hasKey("sendClientReports")) {
            sentryAndroidOptions.setSendClientReports(readableMap.getBoolean("sendClientReports"));
        }
        if (readableMap.hasKey("maxBreadcrumbs")) {
            sentryAndroidOptions.setMaxBreadcrumbs(readableMap.getInt("maxBreadcrumbs"));
        }
        if (readableMap.hasKey("maxCacheItems")) {
            sentryAndroidOptions.setMaxCacheItems(readableMap.getInt("maxCacheItems"));
        }
        if (readableMap.hasKey("environment") && readableMap.getString("environment") != null) {
            sentryAndroidOptions.setEnvironment(readableMap.getString("environment"));
        }
        if (readableMap.hasKey("release") && readableMap.getString("release") != null) {
            sentryAndroidOptions.setRelease(readableMap.getString("release"));
        }
        if (readableMap.hasKey(SentryBaseEvent.JsonKeys.DIST) && readableMap.getString(SentryBaseEvent.JsonKeys.DIST) != null) {
            sentryAndroidOptions.setDist(readableMap.getString(SentryBaseEvent.JsonKeys.DIST));
        }
        if (readableMap.hasKey("enableAutoSessionTracking")) {
            sentryAndroidOptions.setEnableAutoSessionTracking(readableMap.getBoolean("enableAutoSessionTracking"));
        }
        if (readableMap.hasKey("sessionTrackingIntervalMillis")) {
            sentryAndroidOptions.setSessionTrackingIntervalMillis((long) readableMap.getInt("sessionTrackingIntervalMillis"));
        }
        if (readableMap.hasKey("shutdownTimeout")) {
            sentryAndroidOptions.setShutdownTimeoutMillis((long) readableMap.getInt("shutdownTimeout"));
        }
        if (readableMap.hasKey("enableNdkScopeSync")) {
            sentryAndroidOptions.setEnableScopeSync(readableMap.getBoolean("enableNdkScopeSync"));
        }
        if (readableMap.hasKey("attachStacktrace")) {
            sentryAndroidOptions.setAttachStacktrace(readableMap.getBoolean("attachStacktrace"));
        }
        if (readableMap.hasKey("attachThreads")) {
            sentryAndroidOptions.setAttachThreads(readableMap.getBoolean("attachThreads"));
        }
        if (readableMap.hasKey("attachScreenshot")) {
            sentryAndroidOptions.setAttachScreenshot(readableMap.getBoolean("attachScreenshot"));
        }
        if (readableMap.hasKey("attachViewHierarchy")) {
            sentryAndroidOptions.setAttachViewHierarchy(readableMap.getBoolean("attachViewHierarchy"));
        }
        if (readableMap.hasKey("sendDefaultPii")) {
            sentryAndroidOptions.setSendDefaultPii(readableMap.getBoolean("sendDefaultPii"));
        }
        if (readableMap.hasKey("maxQueueSize")) {
            sentryAndroidOptions.setMaxQueueSize(readableMap.getInt("maxQueueSize"));
        }
        if (readableMap.hasKey("enableNdk")) {
            sentryAndroidOptions.setEnableNdk(readableMap.getBoolean("enableNdk"));
        }
        sentryAndroidOptions.setBeforeSend(new RNSentryModuleImpl$$ExternalSyntheticLambda8(this, sentryAndroidOptions));
        if (readableMap.hasKey("enableNativeCrashHandling") && !readableMap.getBoolean("enableNativeCrashHandling")) {
            List<Integration> integrations = sentryAndroidOptions.getIntegrations();
            for (Integration next : integrations) {
                if ((next instanceof UncaughtExceptionHandlerIntegration) || (next instanceof AnrIntegration) || (next instanceof NdkIntegration)) {
                    integrations.remove(next);
                }
            }
        }
        logger.log(SentryLevel.INFO, String.format("Native Integrations '%s'", new Object[]{sentryAndroidOptions.getIntegrations()}), new Object[0]);
        CurrentActivityHolder instance = CurrentActivityHolder.getInstance();
        Activity currentActivity = getCurrentActivity();
        if (currentActivity != null) {
            instance.setActivity(currentActivity);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$initNativeSdk$1$io-sentry-react-RNSentryModuleImpl  reason: not valid java name */
    public /* synthetic */ SentryEvent m933lambda$initNativeSdk$1$iosentryreactRNSentryModuleImpl(SentryAndroidOptions sentryAndroidOptions, SentryEvent sentryEvent, Hint hint) {
        try {
            SentryException sentryException = sentryEvent.getExceptions().get(0);
            if (sentryException != null && sentryException.getType().contains("JavascriptException")) {
                return null;
            }
        } catch (Throwable unused) {
        }
        setEventOriginTag(sentryEvent);
        addPackages(sentryEvent, sentryAndroidOptions.getSdkVersion());
        return sentryEvent;
    }

    public void crash() {
        throw new RuntimeException("TEST - Sentry Client Crash (only works in release mode)");
    }

    public void addListener(String str) {
        logger.log(SentryLevel.ERROR, "addListener of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    public void removeListeners(double d) {
        logger.log(SentryLevel.ERROR, "removeListeners of NativeEventEmitter can't be used on Android!", new Object[0]);
    }

    public void fetchModules(Promise promise) {
        BufferedInputStream bufferedInputStream;
        try {
            bufferedInputStream = new BufferedInputStream(getReactApplicationContext().getResources().getAssets().open(modulesPath));
            byte[] bArr = new byte[bufferedInputStream.available()];
            bufferedInputStream.read(bArr);
            bufferedInputStream.close();
            promise.resolve(new String(bArr, UTF_8));
            bufferedInputStream.close();
            return;
        } catch (FileNotFoundException unused) {
            promise.resolve((Object) null);
            return;
        } catch (Throwable unused2) {
            logger.log(SentryLevel.WARNING, "Fetching JS Modules failed.", new Object[0]);
            promise.resolve((Object) null);
            return;
        }
        throw th;
    }

    public void fetchNativeRelease(Promise promise) {
        WritableMap createMap = Arguments.createMap();
        createMap.putString("id", this.packageInfo.packageName);
        createMap.putString("version", this.packageInfo.versionName);
        createMap.putString(OperatingSystem.JsonKeys.BUILD, String.valueOf(this.packageInfo.versionCode));
        promise.resolve(createMap);
    }

    public void fetchNativeAppStart(Promise promise) {
        AppStartMetrics instance = AppStartMetrics.getInstance();
        SentryDate startTimestamp = instance.getAppStartTimeSpan().getStartTimestamp();
        boolean z = instance.getAppStartType() == AppStartMetrics.AppStartType.COLD;
        if (startTimestamp == null) {
            logger.log(SentryLevel.WARNING, "App start won't be sent due to missing appStartTime.", new Object[0]);
            promise.resolve((Object) null);
        } else {
            double nanosToMillis = DateUtils.nanosToMillis((double) startTimestamp.nanoTimestamp());
            WritableMap createMap = Arguments.createMap();
            createMap.putDouble("appStartTime", nanosToMillis);
            createMap.putBoolean("isColdStart", z);
            createMap.putBoolean("didFetchAppStart", didFetchAppStart);
            promise.resolve(createMap);
        }
        didFetchAppStart = true;
    }

    public void fetchNativeFrames(Promise promise) {
        int i;
        int i2;
        int i3;
        SparseIntArray sparseIntArray;
        if (!isFrameMetricsAggregatorAvailable()) {
            promise.resolve((Object) null);
            return;
        }
        try {
            SparseIntArray[] metrics = this.frameMetricsAggregator.getMetrics();
            if (metrics == null || (sparseIntArray = metrics[0]) == null) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                i3 = 0;
                i2 = 0;
                i = 0;
                for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                    int keyAt = sparseIntArray.keyAt(i4);
                    int valueAt = sparseIntArray.valueAt(i4);
                    i3 += valueAt;
                    if (keyAt > 700) {
                        i += valueAt;
                    } else if (keyAt > 16) {
                        i2 += valueAt;
                    }
                }
            }
            if (i3 == 0 && i2 == 0 && i == 0) {
                promise.resolve((Object) null);
                return;
            }
            WritableMap createMap = Arguments.createMap();
            createMap.putInt("totalFrames", i3);
            createMap.putInt("slowFrames", i2);
            createMap.putInt("frozenFrames", i);
            promise.resolve(createMap);
        } catch (Throwable unused) {
            logger.log(SentryLevel.WARNING, "Error fetching native frames.", new Object[0]);
            promise.resolve((Object) null);
        }
    }

    public void captureEnvelope(String str, ReadableMap readableMap, Promise promise) {
        try {
            InternalSentrySdk.captureEnvelope(Base64.decode(str, 0));
        } catch (Throwable unused) {
            logger.log(SentryLevel.ERROR, "Error while capturing envelope", new Object[0]);
            promise.resolve(false);
        }
        promise.resolve(true);
    }

    public void captureScreenshot(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        if (currentActivity == null) {
            logger.log(SentryLevel.WARNING, "CurrentActivity is null, can't capture screenshot.", new Object[0]);
            promise.resolve((Object) null);
            return;
        }
        byte[] takeScreenshotOnUiThread = takeScreenshotOnUiThread(currentActivity);
        if (takeScreenshotOnUiThread == null) {
            logger.log(SentryLevel.WARNING, "Screenshot is null, screen was not captured.", new Object[0]);
            promise.resolve((Object) null);
            return;
        }
        WritableNativeArray writableNativeArray = new WritableNativeArray();
        for (byte pushInt : takeScreenshotOnUiThread) {
            writableNativeArray.pushInt(pushInt);
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("contentType", ClipboardModule.MIMETYPE_PNG);
        writableNativeMap.putArray("data", writableNativeArray);
        writableNativeMap.putString("filename", "screenshot.png");
        WritableNativeArray writableNativeArray2 = new WritableNativeArray();
        writableNativeArray2.pushMap(writableNativeMap);
        promise.resolve(writableNativeArray2);
    }

    private static byte[] takeScreenshotOnUiThread(Activity activity) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        byte[][] bArr = {new byte[0]};
        RNSentryModuleImpl$$ExternalSyntheticLambda6 rNSentryModuleImpl$$ExternalSyntheticLambda6 = new RNSentryModuleImpl$$ExternalSyntheticLambda6(bArr, activity, countDownLatch);
        if (UiThreadUtil.isOnUiThread()) {
            rNSentryModuleImpl$$ExternalSyntheticLambda6.run();
        } else {
            UiThreadUtil.runOnUiThread(rNSentryModuleImpl$$ExternalSyntheticLambda6);
        }
        try {
            countDownLatch.await(2, TimeUnit.SECONDS);
            return bArr[0];
        } catch (InterruptedException unused) {
            logger.log(SentryLevel.ERROR, "Screenshot process was interrupted.", new Object[0]);
            return null;
        }
    }

    static /* synthetic */ void lambda$takeScreenshotOnUiThread$3(byte[][] bArr, Activity activity, CountDownLatch countDownLatch) {
        bArr[0] = ScreenshotUtils.takeScreenshot(activity, logger, buildInfo);
        countDownLatch.countDown();
    }

    public void fetchViewHierarchy(Promise promise) {
        Activity currentActivity = getCurrentActivity();
        ILogger iLogger = logger;
        ViewHierarchy snapshotViewHierarchy = ViewHierarchyEventProcessor.snapshotViewHierarchy(currentActivity, iLogger);
        if (snapshotViewHierarchy == null) {
            iLogger.log(SentryLevel.ERROR, "Could not get ViewHierarchy.", new Object[0]);
            promise.resolve((Object) null);
            return;
        }
        byte[] bytesFrom = JsonSerializationUtils.bytesFrom(HubAdapter.getInstance().getOptions().getSerializer(), iLogger, snapshotViewHierarchy);
        if (bytesFrom == null) {
            iLogger.log(SentryLevel.ERROR, "Could not serialize ViewHierarchy.", new Object[0]);
            promise.resolve((Object) null);
        } else if (bytesFrom.length < 1) {
            iLogger.log(SentryLevel.ERROR, "Got empty bytes array after serializing ViewHierarchy.", new Object[0]);
            promise.resolve((Object) null);
        } else {
            WritableNativeArray writableNativeArray = new WritableNativeArray();
            for (byte pushInt : bytesFrom) {
                writableNativeArray.pushInt(pushInt);
            }
            promise.resolve(writableNativeArray);
        }
    }

    private static PackageInfo getPackageInfo(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException unused) {
            logger.log(SentryLevel.WARNING, "Error getting package info.", new Object[0]);
            return null;
        }
    }

    public void setUser(ReadableMap readableMap, ReadableMap readableMap2) {
        Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda9(readableMap, readableMap2));
    }

    static /* synthetic */ void lambda$setUser$4(ReadableMap readableMap, ReadableMap readableMap2, IScope iScope) {
        if (readableMap == null && readableMap2 == null) {
            iScope.setUser((User) null);
            return;
        }
        User user = new User();
        if (readableMap != null) {
            if (readableMap.hasKey("email")) {
                user.setEmail(readableMap.getString("email"));
            }
            if (readableMap.hasKey("id")) {
                user.setId(readableMap.getString("id"));
            }
            if (readableMap.hasKey("username")) {
                user.setUsername(readableMap.getString("username"));
            }
            if (readableMap.hasKey("ip_address")) {
                user.setIpAddress(readableMap.getString("ip_address"));
            }
            if (readableMap.hasKey("segment")) {
                user.setSegment(readableMap.getString("segment"));
            }
        }
        if (readableMap2 != null) {
            HashMap hashMap = new HashMap();
            ReadableMapKeySetIterator keySetIterator = readableMap2.keySetIterator();
            while (keySetIterator.hasNextKey()) {
                String nextKey = keySetIterator.nextKey();
                String string = readableMap2.getString(nextKey);
                if (string != null) {
                    hashMap.put(nextKey, string);
                }
            }
            user.setData(hashMap);
        }
        iScope.setUser(user);
    }

    public void addBreadcrumb(ReadableMap readableMap) {
        Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda4(readableMap));
    }

    static /* synthetic */ void lambda$addBreadcrumb$5(ReadableMap readableMap, IScope iScope) {
        Breadcrumb breadcrumb = new Breadcrumb();
        if (readableMap.hasKey("message")) {
            breadcrumb.setMessage(readableMap.getString("message"));
        }
        if (readableMap.hasKey("type")) {
            breadcrumb.setType(readableMap.getString("type"));
        }
        if (readableMap.hasKey("category")) {
            breadcrumb.setCategory(readableMap.getString("category"));
        }
        if (readableMap.hasKey("level")) {
            String string = readableMap.getString("level");
            char c = 65535;
            switch (string.hashCode()) {
                case 3237038:
                    if (string.equals(LogEvent.LEVEL_INFO)) {
                        c = 4;
                        break;
                    }
                    break;
                case 95458899:
                    if (string.equals(LogEvent.LEVEL_DEBUG)) {
                        c = 2;
                        break;
                    }
                    break;
                case 96784904:
                    if (string.equals("error")) {
                        c = 3;
                        break;
                    }
                    break;
                case 97203460:
                    if (string.equals("fatal")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1124446108:
                    if (string.equals("warning")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                breadcrumb.setLevel(SentryLevel.FATAL);
            } else if (c == 1) {
                breadcrumb.setLevel(SentryLevel.WARNING);
            } else if (c == 2) {
                breadcrumb.setLevel(SentryLevel.DEBUG);
            } else if (c != 3) {
                breadcrumb.setLevel(SentryLevel.INFO);
            } else {
                breadcrumb.setLevel(SentryLevel.ERROR);
            }
        }
        if (readableMap.hasKey("data")) {
            for (Map.Entry next : readableMap.getMap("data").toHashMap().entrySet()) {
                if (next.getValue() != null) {
                    breadcrumb.setData((String) next.getKey(), next.getValue());
                }
            }
        }
        iScope.addBreadcrumb(breadcrumb);
    }

    public void clearBreadcrumbs() {
        Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda5());
    }

    public void setExtra(String str, String str2) {
        Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda7(str, str2));
    }

    public void setContext(String str, ReadableMap readableMap) {
        if (str != null && readableMap != null) {
            Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda3(readableMap, str));
        }
    }

    public void setTag(String str, String str2) {
        Sentry.configureScope(new RNSentryModuleImpl$$ExternalSyntheticLambda2(str, str2));
    }

    public void closeNativeSdk(Promise promise) {
        Sentry.close();
        disableNativeFramesTracking();
        promise.resolve(true);
    }

    public void enableNativeFramesTracking() {
        boolean checkAndroidXAvailability = checkAndroidXAvailability();
        this.androidXAvailable = checkAndroidXAvailability;
        if (checkAndroidXAvailability) {
            this.frameMetricsAggregator = new FrameMetricsAggregator();
            Activity currentActivity = getCurrentActivity();
            FrameMetricsAggregator frameMetricsAggregator2 = this.frameMetricsAggregator;
            if (frameMetricsAggregator2 == null || currentActivity == null) {
                logger.log(SentryLevel.INFO, "currentActivity isn't available.", new Object[0]);
                return;
            }
            try {
                frameMetricsAggregator2.add(currentActivity);
                logger.log(SentryLevel.INFO, "FrameMetricsAggregator installed.", new Object[0]);
            } catch (Throwable unused) {
                logger.log(SentryLevel.ERROR, "Error adding Activity to frameMetricsAggregator.", new Object[0]);
            }
        } else {
            logger.log(SentryLevel.WARNING, "androidx.core' isn't available as a dependency.", new Object[0]);
        }
    }

    public void disableNativeFramesTracking() {
        if (isFrameMetricsAggregatorAvailable()) {
            this.frameMetricsAggregator.stop();
            this.frameMetricsAggregator = null;
        }
    }

    private String getProfilingTracesDirPath() {
        if (this.cacheDirPath == null) {
            this.cacheDirPath = new File(getReactApplicationContext().getCacheDir(), "sentry/react").getAbsolutePath();
        }
        File file = new File(this.cacheDirPath, "profiling_trace");
        file.mkdirs();
        return file.getAbsolutePath();
    }

    private void initializeAndroidProfiler() {
        if (this.executorService == null) {
            this.executorService = new SentryExecutorService();
        }
        String profilingTracesDirPath = getProfilingTracesDirPath();
        int micros = ((int) TimeUnit.SECONDS.toMicros(1)) / this.profilingTracesHz;
        ReactApplicationContext reactApplicationContext2 = this.reactApplicationContext;
        ILogger iLogger = logger;
        BuildInfoProvider buildInfoProvider = buildInfo;
        this.androidProfiler = new AndroidProfiler(profilingTracesDirPath, micros, new SentryFrameMetricsCollector((Context) reactApplicationContext2, iLogger, buildInfoProvider), this.executorService, iLogger, buildInfoProvider);
    }

    public WritableMap startProfiling() {
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        if (this.androidProfiler == null) {
            initializeAndroidProfiler();
        }
        try {
            HermesSamplingProfiler.enable();
            this.androidProfiler.start();
            writableNativeMap.putBoolean(Session.JsonKeys.STARTED, true);
        } catch (Throwable th) {
            writableNativeMap.putBoolean(Session.JsonKeys.STARTED, false);
            writableNativeMap.putString("error", th.toString());
        }
        return writableNativeMap;
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [java.util.List, java.io.File] */
    public WritableMap stopProfiling() {
        boolean isDebug = HubAdapter.getInstance().getOptions().isDebug();
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        ? r3 = 0;
        try {
            AndroidProfiler.ProfileEndData endAndCollect = this.androidProfiler.endAndCollect(false, r3);
            HermesSamplingProfiler.disable();
            File createTempFile = File.createTempFile("sampling-profiler-trace", ".cpuprofile", this.reactApplicationContext.getCacheDir());
            if (isDebug) {
                logger.log(SentryLevel.INFO, "Profile saved to: " + createTempFile.getAbsolutePath(), new Object[0]);
            }
            HermesSamplingProfiler.dumpSampledTraceToFile(createTempFile.getPath());
            writableNativeMap.putString(Scopes.PROFILE, readStringFromFile(createTempFile));
            WritableNativeMap writableNativeMap2 = new WritableNativeMap();
            writableNativeMap2.putString(ProfilingTraceData.JsonKeys.SAMPLED_PROFILE, Base64.encodeToString(FileUtils.readBytesFromFile(endAndCollect.traceFile.getPath(), this.maxTraceFileSize), 3));
            writableNativeMap2.putInt(ProfilingTraceData.JsonKeys.ANDROID_API_LEVEL, buildInfo.getSdkInfoVersion());
            writableNativeMap2.putString(ProfilingTraceData.JsonKeys.BUILD_ID, getProguardUuid());
            writableNativeMap.putMap("androidProfile", writableNativeMap2);
            if (createTempFile != null) {
                try {
                    if (!createTempFile.delete()) {
                        logger.log(SentryLevel.WARNING, "Profile not deleted from:" + createTempFile.getAbsolutePath(), new Object[0]);
                    }
                } catch (Throwable unused) {
                    logger.log(SentryLevel.WARNING, "Profile not deleted from:" + createTempFile.getAbsolutePath(), new Object[0]);
                }
            }
        } catch (Throwable unused2) {
            logger.log(SentryLevel.WARNING, "Profile not deleted from:" + r3.getAbsolutePath(), new Object[0]);
        }
        return writableNativeMap;
    }

    private String getProguardUuid() {
        if (this.isProguardDebugMetaLoaded) {
            return this.proguardUuid;
        }
        this.isProguardDebugMetaLoaded = true;
        List<Properties> loadDebugMeta = new AssetsDebugMetaLoader(getReactApplicationContext(), logger).loadDebugMeta();
        if (loadDebugMeta == null) {
            return null;
        }
        for (Properties proguardUuid2 : loadDebugMeta) {
            String proguardUuid3 = DebugMetaPropertiesApplier.getProguardUuid(proguardUuid2);
            this.proguardUuid = proguardUuid3;
            if (proguardUuid3 != null) {
                logger.log(SentryLevel.INFO, "Proguard uuid found: " + this.proguardUuid, new Object[0]);
                return this.proguardUuid;
            }
        }
        logger.log(SentryLevel.WARNING, "No proguard uuid found in debug meta properties file!", new Object[0]);
        return null;
    }

    private String readStringFromFile(File file) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        try {
            StringBuilder sb = new StringBuilder();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine != null) {
                    sb.append(readLine);
                    sb.append(10);
                } else {
                    String sb2 = sb.toString();
                    bufferedReader.close();
                    return sb2;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void fetchNativeDeviceContexts(Promise promise) {
        SentryOptions options = HubAdapter.getInstance().getOptions();
        if (!(options instanceof SentryAndroidOptions)) {
            promise.resolve((Object) null);
            return;
        }
        Context applicationContext = getReactApplicationContext().getApplicationContext();
        if (applicationContext == null) {
            promise.resolve((Object) null);
            return;
        }
        promise.resolve(RNSentryMapConverter.convertToWritable(InternalSentrySdk.serializeScope(applicationContext, (SentryAndroidOptions) options, InternalSentrySdk.getCurrentScope())));
    }

    public void fetchNativeSdkInfo(Promise promise) {
        SdkVersion sdkVersion = HubAdapter.getInstance().getOptions().getSdkVersion();
        if (sdkVersion == null) {
            promise.resolve((Object) null);
            return;
        }
        WritableNativeMap writableNativeMap = new WritableNativeMap();
        writableNativeMap.putString("name", sdkVersion.getName());
        writableNativeMap.putString("version", sdkVersion.getVersion());
        promise.resolve(writableNativeMap);
    }

    public String fetchNativePackageName() {
        return this.packageInfo.packageName;
    }

    private void setEventOriginTag(SentryEvent sentryEvent) {
        SdkVersion sdk = sentryEvent.getSdk();
        if (sdk != null) {
            String name = sdk.getName();
            name.hashCode();
            if (name.equals(ANDROID_SDK_NAME)) {
                setEventEnvironmentTag(sentryEvent, SentryBaseEvent.DEFAULT_PLATFORM);
            } else if (name.equals(NATIVE_SDK_NAME)) {
                setEventEnvironmentTag(sentryEvent, "native");
            }
        }
    }

    private void setEventEnvironmentTag(SentryEvent sentryEvent, String str) {
        sentryEvent.setTag("event.origin", "android");
        sentryEvent.setTag("event.environment", str);
    }

    private void addPackages(SentryEvent sentryEvent, SdkVersion sdkVersion) {
        SdkVersion sdk = sentryEvent.getSdk();
        if (sdk != null && sdk.getName().equals("sentry.javascript.react-native") && sdkVersion != null) {
            List<SentryPackage> packages = sdkVersion.getPackages();
            if (packages != null) {
                for (SentryPackage next : packages) {
                    sdk.addPackage(next.getName(), next.getVersion());
                }
            }
            List<String> integrations = sdkVersion.getIntegrations();
            if (integrations != null) {
                for (String addIntegration : integrations) {
                    sdk.addIntegration(addIntegration);
                }
            }
            sentryEvent.setSdk(sdk);
        }
    }

    private boolean checkAndroidXAvailability() {
        try {
            Class.forName("androidx.core.app.FrameMetricsAggregator");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    private boolean isFrameMetricsAggregatorAvailable() {
        return this.androidXAvailable && this.frameMetricsAggregator != null;
    }
}
