package com.launchdarkly.sdk.android.interfaces;

import java.net.URI;

public final class ServiceEndpoints {
    private final URI eventsBaseUri;
    private final URI pollingBaseUri;
    private final URI streamingBaseUri;

    public ServiceEndpoints(URI uri, URI uri2, URI uri3) {
        this.streamingBaseUri = uri;
        this.pollingBaseUri = uri2;
        this.eventsBaseUri = uri3;
    }

    public URI getStreamingBaseUri() {
        return this.streamingBaseUri;
    }

    public URI getPollingBaseUri() {
        return this.pollingBaseUri;
    }

    public URI getEventsBaseUri() {
        return this.eventsBaseUri;
    }
}
