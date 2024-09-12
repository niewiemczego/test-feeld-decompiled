package io.sentry;

import io.sentry.transport.ITransport;
import io.sentry.transport.NoOpTransport;

public final class NoOpTransportFactory implements ITransportFactory {
    private static final NoOpTransportFactory instance = new NoOpTransportFactory();

    public static NoOpTransportFactory getInstance() {
        return instance;
    }

    private NoOpTransportFactory() {
    }

    public ITransport create(SentryOptions sentryOptions, RequestDetails requestDetails) {
        return NoOpTransport.getInstance();
    }
}
