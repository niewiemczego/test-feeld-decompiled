package com.launchdarkly.sdk.android;

import com.launchdarkly.logging.LDLogger;
import java.net.URI;

abstract class StandardEndpoints {
    static final String ANALYTICS_EVENTS_REQUEST_PATH = "/mobile/events/bulk";
    static final URI DEFAULT_EVENTS_BASE_URI = URI.create("https://mobile.launchdarkly.com");
    static final URI DEFAULT_POLLING_BASE_URI = URI.create("https://clientsdk.launchdarkly.com");
    static final URI DEFAULT_STREAMING_BASE_URI = URI.create("https://clientstream.launchdarkly.com");
    static final String DIAGNOSTIC_EVENTS_REQUEST_PATH = "/mobile/events/diagnostic";
    static final String POLLING_REQUEST_GET_BASE_PATH = "/msdk/evalx/contexts";
    static final String POLLING_REQUEST_REPORT_BASE_PATH = "/msdk/evalx/context";
    static final String STREAMING_REQUEST_BASE_PATH = "/meval";

    private StandardEndpoints() {
    }

    static URI selectBaseUri(URI uri, URI uri2, String str, LDLogger lDLogger) {
        if (uri != null) {
            return uri;
        }
        lDLogger.warn("You have set custom ServiceEndpoints without specifying the {} base URI; connections may not work properly", (Object) str);
        return uri2;
    }

    static boolean isCustomBaseUri(URI uri, URI uri2) {
        return uri != null && !uri.equals(uri2);
    }
}
