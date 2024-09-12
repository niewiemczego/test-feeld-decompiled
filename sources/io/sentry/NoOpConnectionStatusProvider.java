package io.sentry;

import io.sentry.IConnectionStatusProvider;

public final class NoOpConnectionStatusProvider implements IConnectionStatusProvider {
    public boolean addConnectionStatusObserver(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
        return false;
    }

    public String getConnectionType() {
        return null;
    }

    public void removeConnectionStatusObserver(IConnectionStatusProvider.IConnectionStatusObserver iConnectionStatusObserver) {
    }

    public IConnectionStatusProvider.ConnectionStatus getConnectionStatus() {
        return IConnectionStatusProvider.ConnectionStatus.UNKNOWN;
    }
}
