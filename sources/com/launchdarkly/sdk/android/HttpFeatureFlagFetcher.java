package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.android.LDFailure;
import com.launchdarkly.sdk.android.subsystems.Callback;
import com.launchdarkly.sdk.android.subsystems.ClientContext;
import com.launchdarkly.sdk.internal.http.HttpHelpers;
import com.launchdarkly.sdk.internal.http.HttpProperties;
import com.launchdarkly.sdk.json.JsonSerialization;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.concurrent.TimeUnit;
import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.ConnectionPool;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

class HttpFeatureFlagFetcher implements FeatureFetcher {
    private static final int MAX_CACHE_SIZE_BYTES = 500000;
    /* access modifiers changed from: private */
    public final OkHttpClient client;
    private final boolean evaluationReasons;
    private final HttpProperties httpProperties;
    /* access modifiers changed from: private */
    public final LDLogger logger;
    private final URI pollUri;
    private final boolean useReport;

    HttpFeatureFlagFetcher(ClientContext clientContext) {
        this.pollUri = clientContext.getServiceEndpoints().getPollingBaseUri();
        this.evaluationReasons = clientContext.isEvaluationReasons();
        this.useReport = clientContext.getHttp().isUseReport();
        HttpProperties makeHttpProperties = LDUtil.makeHttpProperties(clientContext);
        this.httpProperties = makeHttpProperties;
        LDLogger baseLogger = clientContext.getBaseLogger();
        this.logger = baseLogger;
        File file = new File(ClientContextImpl.get(clientContext).getPlatformState().getCacheDir(), "com.launchdarkly.http-cache");
        baseLogger.debug("Using cache at: {}", (Object) file.getAbsolutePath());
        this.client = makeHttpProperties.toHttpClientBuilder().cache(new Cache(file, 500000)).connectionPool(new ConnectionPool(0, 1, TimeUnit.MILLISECONDS)).retryOnConnectionFailure(true).build();
    }

    public synchronized void fetch(LDContext lDContext, final Callback<String> callback) {
        final Request request;
        if (lDContext != null) {
            try {
                if (this.useReport) {
                    request = getReportRequest(lDContext);
                } else {
                    request = getDefaultRequest(lDContext);
                }
                this.logger.debug("Polling for flag data: {}", (Object) request.url());
                this.client.newCall(request).enqueue(new okhttp3.Callback() {
                    public void onFailure(Call call, IOException iOException) {
                        LDUtil.logExceptionAtErrorLevel(HttpFeatureFlagFetcher.this.logger, iOException, "Exception when fetching flags", new Object[0]);
                        callback.onError(new LDFailure("Exception while fetching flags", iOException, LDFailure.FailureType.NETWORK_FAILURE));
                    }

                    public void onResponse(Call call, Response response) {
                        String str = "";
                        try {
                            ResponseBody body = response.body();
                            if (body != null) {
                                str = body.string();
                            }
                            if (!response.isSuccessful()) {
                                if (response.code() == 400) {
                                    HttpFeatureFlagFetcher.this.logger.error("Received 400 response when fetching flag values. Please check recommended ProGuard settings");
                                }
                                callback.onError(new LDInvalidResponseCodeFailure("Unexpected response when retrieving Feature Flags: " + response + " using url: " + request.url() + " with body: " + str, response.code(), true));
                                if (response != null) {
                                    response.close();
                                    return;
                                }
                                return;
                            }
                            HttpFeatureFlagFetcher.this.logger.debug(str);
                            HttpFeatureFlagFetcher.this.logger.debug("Cache hit count: {} Cache network Count: {}", Integer.valueOf(HttpFeatureFlagFetcher.this.client.cache().hitCount()), Integer.valueOf(HttpFeatureFlagFetcher.this.client.cache().networkCount()));
                            HttpFeatureFlagFetcher.this.logger.debug("Cache response: {}", (Object) response.cacheResponse());
                            HttpFeatureFlagFetcher.this.logger.debug("Network response: {}", (Object) response.networkResponse());
                            callback.onSuccess(str);
                            if (response == null) {
                                return;
                            }
                            response.close();
                        } catch (Exception e) {
                            LDUtil.logExceptionAtErrorLevel(HttpFeatureFlagFetcher.this.logger, e, "Exception when handling response for url: {} with body: {}", request.url(), str);
                            callback.onError(new LDFailure("Exception while handling flag fetch response", e, LDFailure.FailureType.INVALID_RESPONSE_BODY));
                            if (response == null) {
                            }
                        } catch (Throwable th) {
                            if (response != null) {
                                response.close();
                            }
                            throw th;
                        }
                    }
                });
            } catch (IOException e) {
                LDUtil.logExceptionAtErrorLevel(this.logger, e, "Unexpected error in constructing request", new Object[0]);
                callback.onError(new LDFailure("Exception while fetching flags", e, LDFailure.FailureType.UNKNOWN_ERROR));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void close() {
        HttpProperties.shutdownHttpClient(this.client);
    }

    private Request getDefaultRequest(LDContext lDContext) throws IOException {
        URI concatenateUriPath = HttpHelpers.concatenateUriPath(HttpHelpers.concatenateUriPath(this.pollUri, "/msdk/evalx/contexts"), LDUtil.base64Url(lDContext));
        if (this.evaluationReasons) {
            concatenateUriPath = URI.create(concatenateUriPath.toString() + "?withReasons=true");
        }
        this.logger.debug("Attempting to fetch Feature flags using uri: {}", (Object) concatenateUriPath);
        return new Request.Builder().url(concatenateUriPath.toURL()).headers(this.httpProperties.toHeadersBuilder().build()).build();
    }

    private Request getReportRequest(LDContext lDContext) throws IOException {
        URI concatenateUriPath = HttpHelpers.concatenateUriPath(this.pollUri, "/msdk/evalx/context");
        if (this.evaluationReasons) {
            concatenateUriPath = URI.create(concatenateUriPath.toString() + "?withReasons=true");
        }
        this.logger.debug("Attempting to report user using uri: {}", (Object) concatenateUriPath);
        return new Request.Builder().url(concatenateUriPath.toURL()).headers(this.httpProperties.toHeadersBuilder().build()).method("REPORT", RequestBody.create(JsonSerialization.serialize(lDContext), LDConfig.JSON)).build();
    }
}
