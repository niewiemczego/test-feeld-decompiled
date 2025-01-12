package com.launchdarkly.sdk.internal.events;

import com.launchdarkly.sdk.LDValueType;

public enum DiagnosticConfigProperty {
    ALL_ATTRIBUTES_PRIVATE("allAttributesPrivate", LDValueType.BOOLEAN),
    CONNECT_TIMEOUT_MILLIS("connectTimeoutMillis", LDValueType.NUMBER),
    CUSTOM_BASE_URI("customBaseURI", LDValueType.BOOLEAN),
    CUSTOM_EVENTS_URI("customEventsURI", LDValueType.BOOLEAN),
    CUSTOM_STREAM_URI("customStreamURI", LDValueType.BOOLEAN),
    DATA_STORE_TYPE("dataStoreType", LDValueType.STRING),
    DIAGNOSTIC_RECORDING_INTERVAL_MILLIS("diagnosticRecordingIntervalMillis", LDValueType.NUMBER),
    EVENTS_CAPACITY("eventsCapacity", LDValueType.NUMBER),
    EVENTS_FLUSH_INTERVAL_MILLIS("eventsFlushIntervalMillis", LDValueType.NUMBER),
    POLLING_INTERVAL_MILLIS("pollingIntervalMillis", LDValueType.NUMBER),
    RECONNECT_TIME_MILLIS("reconnectTimeMillis", LDValueType.NUMBER),
    SAMPLING_INTERVAL("samplingInterval", LDValueType.NUMBER),
    SOCKET_TIMEOUT_MILLIS("socketTimeoutMillis", LDValueType.NUMBER),
    START_WAIT_MILLIS("startWaitMillis", LDValueType.NUMBER),
    STREAMING_DISABLED("streamingDisabled", LDValueType.BOOLEAN),
    USER_KEYS_CAPACITY("userKeysCapacity", LDValueType.NUMBER),
    USER_KEYS_FLUSH_INTERVAL_MILLIS("userKeysFlushIntervalMillis", LDValueType.NUMBER),
    USING_PROXY("usingProxy", LDValueType.BOOLEAN),
    USING_PROXY_AUTHENTICATOR("usingProxyAuthenticator", LDValueType.BOOLEAN),
    USING_RELAY_DAEMON("usingRelayDaemon", LDValueType.BOOLEAN),
    BACKGROUND_POLLING_INTERVAL_MILLIS("backgroundPollingIntervalMillis", LDValueType.NUMBER),
    BACKGROUND_POLLING_DISABLED("backgroundPollingDisabled", LDValueType.BOOLEAN),
    EVALUATION_REASONS_REQUESTED("evaluationReasonsRequested", LDValueType.BOOLEAN),
    MAX_CACHED_USERS("maxCachedUsers", LDValueType.NUMBER),
    MOBILE_KEY_COUNT("mobileKeyCount", LDValueType.NUMBER),
    USE_REPORT("useReport", LDValueType.BOOLEAN);
    
    public final String name;
    public final LDValueType type;

    private DiagnosticConfigProperty(String str, LDValueType lDValueType) {
        this.name = str;
        this.type = lDValueType;
    }
}
