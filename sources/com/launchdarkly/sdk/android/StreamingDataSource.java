package com.launchdarkly.sdk.android;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import com.launchdarkly.eventsource.MessageEvent;
import com.launchdarkly.eventsource.UnsuccessfulResponseException;
import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.DataModel;
import com.launchdarkly.sdk.android.LDFailure;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.android.subsystems.DataSource;
import com.launchdarkly.sdk.android.subsystems.DataSourceUpdateSink;
import com.launchdarkly.sdk.internal.GsonHelpers;
import com.launchdarkly.sdk.internal.events.DiagnosticStore;
import com.launchdarkly.sdk.internal.http.HttpHelpers;
import com.launchdarkly.sdk.internal.http.HttpProperties;
import com.launchdarkly.sdk.json.JsonSerialization;
import com.launchdarkly.sdk.json.SerializationException;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

final class StreamingDataSource implements DataSource {
    private static final String DELETE = "delete";
    private static final long MAX_RECONNECT_TIME_MS = 3600000;
    private static final String METHOD_REPORT = "REPORT";
    private static final String PATCH = "patch";
    private static final String PING = "ping";
    private static final String PUT = "put";
    private static final long READ_TIMEOUT_MS = 300000;
    /* access modifiers changed from: private */
    public boolean connection401Error = false;
    /* access modifiers changed from: private */
    public final LDContext currentContext;
    /* access modifiers changed from: private */
    public final DataSourceUpdateSink dataSourceUpdateSink;
    /* access modifiers changed from: private */
    public final DiagnosticStore diagnosticStore;
    private EventSource es;
    private final boolean evaluationReasons;
    /* access modifiers changed from: private */
    public long eventSourceStarted;
    private final ExecutorService executor;
    private final FeatureFetcher fetcher;
    /* access modifiers changed from: private */
    public final HttpProperties httpProperties;
    final int initialReconnectDelayMillis;
    /* access modifiers changed from: private */
    public final LDLogger logger;
    /* access modifiers changed from: private */
    public volatile boolean running = false;
    private final boolean streamEvenInBackground;
    private final URI streamUri;
    private final boolean useReport;

    StreamingDataSource(ClientContext clientContext, LDContext lDContext, DataSourceUpdateSink dataSourceUpdateSink2, FeatureFetcher featureFetcher, int i, boolean z) {
        this.currentContext = lDContext;
        this.dataSourceUpdateSink = dataSourceUpdateSink2;
        this.fetcher = featureFetcher;
        this.streamUri = clientContext.getServiceEndpoints().getStreamingBaseUri();
        this.httpProperties = LDUtil.makeHttpProperties(clientContext);
        this.evaluationReasons = clientContext.isEvaluationReasons();
        this.useReport = clientContext.getHttp().isUseReport();
        this.initialReconnectDelayMillis = i;
        this.streamEvenInBackground = z;
        this.diagnosticStore = ClientContextImpl.get(clientContext).getDiagnosticStore();
        this.logger = clientContext.getBaseLogger();
        this.executor = new BackgroundThreadExecutor().newFixedThreadPool(2);
    }

    public void start(final Callback<Boolean> callback) {
        if (!this.running && !this.connection401Error) {
            this.logger.debug("Starting.");
            EventSource.Builder builder = new EventSource.Builder((EventHandler) new EventHandler() {
                public void onComment(String str) {
                }

                public void onOpen() {
                    StreamingDataSource.this.logger.info("Started LaunchDarkly EventStream");
                    if (StreamingDataSource.this.diagnosticStore != null) {
                        StreamingDataSource.this.diagnosticStore.recordStreamInit(StreamingDataSource.this.eventSourceStarted, (long) ((int) (System.currentTimeMillis() - StreamingDataSource.this.eventSourceStarted)), false);
                    }
                }

                public void onClosed() {
                    StreamingDataSource.this.logger.info("Closed LaunchDarkly EventStream");
                }

                public void onMessage(String str, MessageEvent messageEvent) {
                    String data = messageEvent.getData();
                    StreamingDataSource.this.logger.debug("onMessage: {}: {}", str, data);
                    StreamingDataSource.this.handle(str, data, callback);
                }

                public void onError(Throwable th) {
                    LDLogger access$000 = StreamingDataSource.this.logger;
                    StreamingDataSource streamingDataSource = StreamingDataSource.this;
                    LDUtil.logExceptionAtErrorLevel(access$000, th, "Encountered EventStream error connecting to URI: {}", streamingDataSource.getUri(streamingDataSource.currentContext));
                    if (th instanceof UnsuccessfulResponseException) {
                        if (StreamingDataSource.this.diagnosticStore != null) {
                            StreamingDataSource.this.diagnosticStore.recordStreamInit(StreamingDataSource.this.eventSourceStarted, (long) ((int) (System.currentTimeMillis() - StreamingDataSource.this.eventSourceStarted)), true);
                        }
                        int code = ((UnsuccessfulResponseException) th).getCode();
                        if (code < 400 || code >= 500) {
                            long unused = StreamingDataSource.this.eventSourceStarted = System.currentTimeMillis();
                            callback.onError(new LDInvalidResponseCodeFailure("Unexpected Response Code From Stream Connection", th, code, true));
                            return;
                        }
                        StreamingDataSource.this.logger.error("Encountered non-retriable error: {}. Aborting connection to stream. Verify correct Mobile Key and Stream URI", (Object) Integer.valueOf(code));
                        boolean unused2 = StreamingDataSource.this.running = false;
                        callback.onError(new LDInvalidResponseCodeFailure("Unexpected Response Code From Stream Connection", th, code, false));
                        if (code == 401) {
                            boolean unused3 = StreamingDataSource.this.connection401Error = true;
                            StreamingDataSource.this.dataSourceUpdateSink.shutDown();
                        }
                        StreamingDataSource.this.stop((Callback<Void>) null);
                        return;
                    }
                    callback.onError(new LDFailure("Network error in stream connection", th, LDFailure.FailureType.NETWORK_FAILURE));
                }
            }, getUri(this.currentContext));
            builder.reconnectTime((long) this.initialReconnectDelayMillis, TimeUnit.MILLISECONDS);
            builder.clientBuilderActions(new EventSource.Builder.ClientConfigurer() {
                public void configure(OkHttpClient.Builder builder) {
                    StreamingDataSource.this.httpProperties.applyToHttpClientBuilder(builder);
                    builder.readTimeout(300000, TimeUnit.MILLISECONDS);
                }
            });
            builder.requestTransformer(new StreamingDataSource$$ExternalSyntheticLambda1(this));
            if (this.useReport) {
                builder.method(METHOD_REPORT);
                builder.body(getRequestBody(this.currentContext));
            }
            builder.maxReconnectTime(3600000, TimeUnit.MILLISECONDS);
            this.eventSourceStarted = System.currentTimeMillis();
            EventSource build = builder.build();
            this.es = build;
            build.start();
            this.running = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$start$0$com-launchdarkly-sdk-android-StreamingDataSource  reason: not valid java name */
    public /* synthetic */ Request m452lambda$start$0$comlaunchdarklysdkandroidStreamingDataSource(Request request) {
        return request.newBuilder().headers(request.headers().newBuilder().addAll(this.httpProperties.toHeadersBuilder().build()).build()).build();
    }

    private RequestBody getRequestBody(LDContext lDContext) {
        this.logger.debug("Attempting to report user in stream");
        return RequestBody.create(JsonSerialization.serialize(lDContext), LDConfig.JSON);
    }

    /* access modifiers changed from: private */
    public URI getUri(LDContext lDContext) {
        URI concatenateUriPath = HttpHelpers.concatenateUriPath(this.streamUri, "/meval");
        if (!this.useReport && lDContext != null) {
            concatenateUriPath = HttpHelpers.concatenateUriPath(concatenateUriPath, LDUtil.base64Url(lDContext));
        }
        return this.evaluationReasons ? URI.create(concatenateUriPath.toString() + "?withReasons=true") : concatenateUriPath;
    }

    /* access modifiers changed from: package-private */
    public void handle(String str, String str2, Callback<Boolean> callback) {
        String lowerCase = str.toLowerCase();
        lowerCase.hashCode();
        char c = 65535;
        switch (lowerCase.hashCode()) {
            case -1335458389:
                if (lowerCase.equals(DELETE)) {
                    c = 0;
                    break;
                }
                break;
            case 111375:
                if (lowerCase.equals(PUT)) {
                    c = 1;
                    break;
                }
                break;
            case 3441010:
                if (lowerCase.equals(PING)) {
                    c = 2;
                    break;
                }
                break;
            case 106438728:
                if (lowerCase.equals(PATCH)) {
                    c = 3;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                applyDelete(str2, callback);
                return;
            case 1:
                try {
                    this.dataSourceUpdateSink.init(EnvironmentData.fromJson(str2).getAll());
                    callback.onSuccess(true);
                    return;
                } catch (Exception e) {
                    this.logger.debug("Received invalid JSON flag data: {}", (Object) str2);
                    callback.onError(new LDFailure("Invalid JSON received from flags endpoint", e, LDFailure.FailureType.INVALID_RESPONSE_BODY));
                    return;
                }
            case 2:
                ConnectivityManager.fetchAndSetData(this.fetcher, this.currentContext, this.dataSourceUpdateSink, callback, this.logger);
                return;
            case 3:
                applyPatch(str2, callback);
                return;
            default:
                this.logger.debug("Found an unknown stream protocol: {}", (Object) str);
                callback.onError(new LDFailure("Unknown Stream Element Type", (Throwable) null, LDFailure.FailureType.UNEXPECTED_STREAM_ELEMENT_TYPE));
                return;
        }
    }

    public void stop(Callback<Void> callback) {
        this.logger.debug("Stopping.");
        this.executor.execute(new StreamingDataSource$$ExternalSyntheticLambda0(this, callback));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$stop$1$com-launchdarkly-sdk-android-StreamingDataSource  reason: not valid java name */
    public /* synthetic */ void m453lambda$stop$1$comlaunchdarklysdkandroidStreamingDataSource(Callback callback) {
        stopSync();
        if (callback != null) {
            callback.onSuccess(null);
        }
    }

    public boolean needsRefresh(boolean z, LDContext lDContext) {
        return !lDContext.equals(this.currentContext) || (z && !this.streamEvenInBackground);
    }

    private synchronized void stopSync() {
        EventSource eventSource = this.es;
        if (eventSource != null) {
            eventSource.close();
        }
        this.running = false;
        this.es = null;
        this.logger.debug("Stopped.");
    }

    private void applyPatch(String str, Callback<Boolean> callback) {
        try {
            DataModel.Flag fromJson = DataModel.Flag.fromJson(str);
            if (fromJson != null) {
                this.dataSourceUpdateSink.upsert(fromJson);
                callback.onSuccess(null);
            }
        } catch (SerializationException unused) {
            this.logger.debug("Invalid PATCH payload: {}", (Object) str);
            callback.onError(new LDFailure("Invalid PATCH payload", LDFailure.FailureType.INVALID_RESPONSE_BODY));
        }
    }

    private void applyDelete(String str, Callback<Boolean> callback) {
        try {
            DeleteMessage deleteMessage = (DeleteMessage) GsonHelpers.gsonInstance().fromJson(str, DeleteMessage.class);
            if (deleteMessage != null) {
                this.dataSourceUpdateSink.upsert(DataModel.Flag.deletedItemPlaceholder(deleteMessage.key, deleteMessage.version));
                callback.onSuccess(null);
            }
        } catch (Exception unused) {
            this.logger.debug("Invalid DELETE payload: {}", (Object) str);
            callback.onError(new LDFailure("Invalid DELETE payload", LDFailure.FailureType.INVALID_RESPONSE_BODY));
        }
    }

    private static final class DeleteMessage {
        /* access modifiers changed from: private */
        public final String key;
        /* access modifiers changed from: private */
        public final int version;

        DeleteMessage(String str, int i) {
            this.key = str;
            this.version = i;
        }
    }
}
