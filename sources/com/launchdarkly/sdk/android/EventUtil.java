package com.launchdarkly.sdk.android;

import android.os.Build;
import com.amplitude.reactnative.AndroidContextProvider;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.ObjectBuilder;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DiagnosticDescription;
import com.launchdarkly.sdk.internal.events.DiagnosticStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

abstract class EventUtil {
    EventUtil() {
    }

    static ScheduledExecutorService makeEventsTaskExecutor() {
        return Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            final AtomicLong count = new AtomicLong(0);

            public Thread newThread(Runnable runnable) {
                Thread newThread = Executors.defaultThreadFactory().newThread(runnable);
                newThread.setName(String.format(Locale.ROOT, "LaunchDarkly-DefaultEventProcessor-%d", new Object[]{Long.valueOf(this.count.getAndIncrement())}));
                newThread.setDaemon(true);
                return newThread;
            }
        });
    }

    static DiagnosticStore.SdkDiagnosticParams makeDiagnosticParams(ClientContext clientContext) {
        LDConfig config = clientContext.getConfig();
        String mobileKey = clientContext.getMobileKey();
        ObjectBuilder put = LDValue.buildObject().put("customBaseURI", !StandardEndpoints.DEFAULT_POLLING_BASE_URI.equals(config.serviceEndpoints.getPollingBaseUri())).put("customEventsURI", !StandardEndpoints.DEFAULT_EVENTS_BASE_URI.equals(config.serviceEndpoints.getEventsBaseUri())).put("customStreamURI", !StandardEndpoints.DEFAULT_STREAMING_BASE_URI.equals(config.serviceEndpoints.getStreamingBaseUri())).put("backgroundPollingDisabled", config.isDisableBackgroundPolling()).put("evaluationReasonsRequested", config.isEvaluationReasons()).put("mobileKeyCount", config.getMobileKeys().size()).put("maxCachedUsers", config.getMaxCachedContexts());
        mergeComponentProperties(put, config.dataSource);
        mergeComponentProperties(put, config.events);
        mergeComponentProperties(put, config.http);
        HashMap hashMap = new HashMap();
        for (Map.Entry next : LDUtil.makeHttpProperties(clientContext).getDefaultHeaders()) {
            hashMap.put((String) next.getKey(), (String) next.getValue());
        }
        return new DiagnosticStore.SdkDiagnosticParams(mobileKey, "android-client-sdk", BuildConfig.VERSION_NAME, AndroidContextProvider.PLATFORM, LDValue.buildObject().put("androidSDKVersion", Build.VERSION.SDK_INT).build(), hashMap, Collections.singletonList(put.build()));
    }

    private static void mergeComponentProperties(ObjectBuilder objectBuilder, ComponentConfigurer<?> componentConfigurer) {
        if (componentConfigurer instanceof DiagnosticDescription) {
            LDValue describeConfiguration = ((DiagnosticDescription) componentConfigurer).describeConfiguration((ClientContext) null);
            for (String next : describeConfiguration.keys()) {
                objectBuilder.put(next, describeConfiguration.get(next));
            }
        }
    }
}
