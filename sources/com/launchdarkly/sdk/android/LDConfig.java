package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogAdapter;
import com.launchdarkly.logging.LDLogLevel;
import com.launchdarkly.logging.Logs;
import com.launchdarkly.sdk.android.integrations.ApplicationInfoBuilder;
import com.launchdarkly.sdk.android.integrations.ServiceEndpointsBuilder;
import com.launchdarkly.sdk.android.interfaces.ServiceEndpoints;
import com.launchdarkly.sdk.android.subsystems.ApplicationInfo;
import com.launchdarkly.sdk.android.subsystems.ComponentConfigurer;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.EventProcessor;
import com.launchdarkly.sdk.android.subsystems.HttpConfiguration;
import com.launchdarkly.sdk.android.subsystems.PersistentDataStore;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import okhttp3.MediaType;

public class LDConfig {
    public static final int DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS = 3600000;
    static final int DEFAULT_CONNECTION_TIMEOUT_MILLIS = 10000;
    static final String DEFAULT_LOGGER_NAME = "LaunchDarklySdk";
    static final LDLogLevel DEFAULT_LOG_LEVEL = LDLogLevel.INFO;
    static final int DEFAULT_MAX_CACHED_CONTEXTS = 5;
    static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    public static final int MIN_BACKGROUND_POLL_INTERVAL_MILLIS = 900000;
    static final String primaryEnvironmentName = "default";
    final ApplicationInfo applicationInfo;
    final ComponentConfigurer<DataSource> dataSource;
    private final boolean diagnosticOptOut;
    private final boolean disableBackgroundUpdating;
    private final boolean evaluationReasons;
    final ComponentConfigurer<EventProcessor> events;
    private final boolean generateAnonymousKeys;
    final ComponentConfigurer<HttpConfiguration> http;
    private final LDLogAdapter logAdapter;
    private final String loggerName;
    private final int maxCachedContexts;
    private final Map<String, String> mobileKeys;
    private final boolean offline;
    private final PersistentDataStore persistentDataStore;
    final ServiceEndpoints serviceEndpoints;

    LDConfig(Map<String, String> map, ServiceEndpoints serviceEndpoints2, ApplicationInfo applicationInfo2, ComponentConfigurer<DataSource> componentConfigurer, ComponentConfigurer<EventProcessor> componentConfigurer2, ComponentConfigurer<HttpConfiguration> componentConfigurer3, boolean z, boolean z2, boolean z3, boolean z4, int i, boolean z5, PersistentDataStore persistentDataStore2, LDLogAdapter lDLogAdapter, String str) {
        this.mobileKeys = map;
        this.serviceEndpoints = serviceEndpoints2;
        this.applicationInfo = applicationInfo2;
        this.dataSource = componentConfigurer;
        this.events = componentConfigurer2;
        this.http = componentConfigurer3;
        this.offline = z;
        this.disableBackgroundUpdating = z2;
        this.evaluationReasons = z3;
        this.diagnosticOptOut = z4;
        this.maxCachedContexts = i;
        this.generateAnonymousKeys = z5;
        this.persistentDataStore = persistentDataStore2;
        this.logAdapter = lDLogAdapter;
        this.loggerName = str;
    }

    public String getMobileKey() {
        return this.mobileKeys.get("default");
    }

    public Map<String, String> getMobileKeys() {
        return this.mobileKeys;
    }

    public boolean isOffline() {
        return this.offline;
    }

    public boolean isDisableBackgroundPolling() {
        return this.disableBackgroundUpdating;
    }

    public boolean isEvaluationReasons() {
        return this.evaluationReasons;
    }

    /* access modifiers changed from: package-private */
    public boolean getDiagnosticOptOut() {
        return this.diagnosticOptOut;
    }

    /* access modifiers changed from: package-private */
    public int getMaxCachedContexts() {
        return this.maxCachedContexts;
    }

    public boolean isGenerateAnonymousKeys() {
        return this.generateAnonymousKeys;
    }

    /* access modifiers changed from: package-private */
    public PersistentDataStore getPersistentDataStore() {
        return this.persistentDataStore;
    }

    /* access modifiers changed from: package-private */
    public LDLogAdapter getLogAdapter() {
        return this.logAdapter;
    }

    /* access modifiers changed from: package-private */
    public String getLoggerName() {
        return this.loggerName;
    }

    public static class Builder {
        private ApplicationInfoBuilder applicationInfoBuilder = null;
        private ComponentConfigurer<DataSource> dataSource = null;
        private boolean diagnosticOptOut = false;
        private boolean disableBackgroundUpdating = false;
        private boolean evaluationReasons = false;
        private ComponentConfigurer<EventProcessor> events = null;
        private boolean generateAnonymousKeys;
        private ComponentConfigurer<HttpConfiguration> http = null;
        private LDLogAdapter logAdapter = defaultLogAdapter();
        private LDLogLevel logLevel = null;
        private String loggerName = LDConfig.DEFAULT_LOGGER_NAME;
        private int maxCachedContexts = 5;
        private String mobileKey;
        private boolean offline = false;
        private PersistentDataStore persistentDataStore;
        private Map<String, String> secondaryMobileKeys;
        private ServiceEndpointsBuilder serviceEndpointsBuilder;

        public Builder mobileKey(String str) {
            Map<String, String> map = this.secondaryMobileKeys;
            if (map == null || !map.containsValue(str)) {
                this.mobileKey = str;
                return this;
            }
            throw new IllegalArgumentException("The primary environment key cannot be in the secondary mobile keys.");
        }

        public Builder secondaryMobileKeys(Map<String, String> map) {
            if (map == null) {
                this.secondaryMobileKeys = null;
                return this;
            }
            Map<String, String> unmodifiableMap = Collections.unmodifiableMap(map);
            if (!unmodifiableMap.containsKey("default")) {
                HashSet hashSet = new HashSet(unmodifiableMap.values());
                String str = this.mobileKey;
                if (str != null && hashSet.contains(str)) {
                    throw new IllegalArgumentException("The primary environment key cannot be in the secondary mobile keys.");
                } else if (unmodifiableMap.values().size() == hashSet.size()) {
                    this.secondaryMobileKeys = unmodifiableMap;
                    return this;
                } else {
                    throw new IllegalArgumentException("A key can only be used once.");
                }
            } else {
                throw new IllegalArgumentException("The primary environment name is not a valid key.");
            }
        }

        public Builder serviceEndpoints(ServiceEndpointsBuilder serviceEndpointsBuilder2) {
            this.serviceEndpointsBuilder = serviceEndpointsBuilder2;
            return this;
        }

        public Builder applicationInfo(ApplicationInfoBuilder applicationInfoBuilder2) {
            this.applicationInfoBuilder = applicationInfoBuilder2;
            return this;
        }

        public Builder dataSource(ComponentConfigurer<DataSource> componentConfigurer) {
            this.dataSource = componentConfigurer;
            return this;
        }

        public Builder events(ComponentConfigurer<EventProcessor> componentConfigurer) {
            this.events = componentConfigurer;
            return this;
        }

        public Builder http(ComponentConfigurer<HttpConfiguration> componentConfigurer) {
            this.http = componentConfigurer;
            return this;
        }

        public Builder disableBackgroundUpdating(boolean z) {
            this.disableBackgroundUpdating = z;
            return this;
        }

        public Builder offline(boolean z) {
            this.offline = z;
            return this;
        }

        public Builder evaluationReasons(boolean z) {
            this.evaluationReasons = z;
            return this;
        }

        public Builder diagnosticOptOut(boolean z) {
            this.diagnosticOptOut = z;
            return this;
        }

        public Builder maxCachedContexts(int i) {
            this.maxCachedContexts = i;
            return this;
        }

        public Builder generateAnonymousKeys(boolean z) {
            this.generateAnonymousKeys = z;
            return this;
        }

        /* access modifiers changed from: package-private */
        public Builder persistentDataStore(PersistentDataStore persistentDataStore2) {
            this.persistentDataStore = persistentDataStore2;
            return this;
        }

        public Builder logAdapter(LDLogAdapter lDLogAdapter) {
            if (lDLogAdapter == null) {
                lDLogAdapter = defaultLogAdapter();
            }
            this.logAdapter = lDLogAdapter;
            return this;
        }

        public Builder logLevel(LDLogLevel lDLogLevel) {
            this.logLevel = lDLogLevel;
            return this;
        }

        public Builder loggerName(String str) {
            if (str == null) {
                str = LDConfig.DEFAULT_LOGGER_NAME;
            }
            this.loggerName = str;
            return this;
        }

        private static LDLogAdapter defaultLogAdapter() {
            return LDTimberLogging.adapter();
        }

        public LDConfig build() {
            HashMap hashMap;
            ApplicationInfo applicationInfo;
            LDLogAdapter lDLogAdapter = this.logAdapter;
            LDLogLevel lDLogLevel = this.logLevel;
            if (lDLogLevel == null) {
                lDLogLevel = LDConfig.DEFAULT_LOG_LEVEL;
            }
            LDLogAdapter level = Logs.level(lDLogAdapter, lDLogLevel);
            if (this.secondaryMobileKeys == null) {
                hashMap = new HashMap();
            } else {
                hashMap = new HashMap(this.secondaryMobileKeys);
            }
            HashMap hashMap2 = hashMap;
            hashMap2.put("default", this.mobileKey);
            ServiceEndpointsBuilder serviceEndpointsBuilder2 = this.serviceEndpointsBuilder;
            if (serviceEndpointsBuilder2 == null) {
                serviceEndpointsBuilder2 = Components.serviceEndpoints();
            }
            ServiceEndpoints createServiceEndpoints = serviceEndpointsBuilder2.createServiceEndpoints();
            ApplicationInfoBuilder applicationInfoBuilder2 = this.applicationInfoBuilder;
            if (applicationInfoBuilder2 == null) {
                applicationInfo = Components.applicationInfo().createApplicationInfo();
            } else {
                applicationInfo = applicationInfoBuilder2.createApplicationInfo();
            }
            ApplicationInfo applicationInfo2 = applicationInfo;
            ComponentConfigurer componentConfigurer = this.dataSource;
            if (componentConfigurer == null) {
                componentConfigurer = Components.streamingDataSource();
            }
            ComponentConfigurer componentConfigurer2 = componentConfigurer;
            ComponentConfigurer componentConfigurer3 = this.events;
            if (componentConfigurer3 == null) {
                componentConfigurer3 = Components.sendEvents();
            }
            ComponentConfigurer componentConfigurer4 = componentConfigurer3;
            ComponentConfigurer componentConfigurer5 = this.http;
            if (componentConfigurer5 == null) {
                componentConfigurer5 = Components.httpConfiguration();
            }
            return new LDConfig(hashMap2, createServiceEndpoints, applicationInfo2, componentConfigurer2, componentConfigurer4, componentConfigurer5, this.offline, this.disableBackgroundUpdating, this.evaluationReasons, this.diagnosticOptOut, this.maxCachedContexts, this.generateAnonymousKeys, this.persistentDataStore, level, this.loggerName);
        }
    }
}
