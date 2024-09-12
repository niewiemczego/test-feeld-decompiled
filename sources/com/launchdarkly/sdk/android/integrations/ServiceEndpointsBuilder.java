package com.launchdarkly.sdk.android.integrations;

import com.launchdarkly.sdk.android.interfaces.ServiceEndpoints;
import java.net.URI;

public abstract class ServiceEndpointsBuilder {
    protected URI eventsBaseUri;
    protected URI pollingBaseUri;
    protected URI streamingBaseUri;

    public abstract ServiceEndpoints createServiceEndpoints();

    public ServiceEndpointsBuilder events(URI uri) {
        this.eventsBaseUri = uri;
        return this;
    }

    public ServiceEndpointsBuilder events(String str) {
        return events(str == null ? null : URI.create(str));
    }

    public ServiceEndpointsBuilder polling(URI uri) {
        this.pollingBaseUri = uri;
        return this;
    }

    public ServiceEndpointsBuilder polling(String str) {
        return polling(str == null ? null : URI.create(str));
    }

    public ServiceEndpointsBuilder relayProxy(URI uri) {
        this.eventsBaseUri = uri;
        this.pollingBaseUri = uri;
        this.streamingBaseUri = uri;
        return this;
    }

    public ServiceEndpointsBuilder relayProxy(String str) {
        return relayProxy(str == null ? null : URI.create(str));
    }

    public ServiceEndpointsBuilder streaming(URI uri) {
        this.streamingBaseUri = uri;
        return this;
    }

    public ServiceEndpointsBuilder streaming(String str) {
        return streaming(str == null ? null : URI.create(str));
    }
}
