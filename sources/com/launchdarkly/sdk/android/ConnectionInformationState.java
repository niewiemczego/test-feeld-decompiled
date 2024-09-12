package com.launchdarkly.sdk.android;

import com.launchdarkly.sdk.android.ConnectionInformation;

class ConnectionInformationState implements ConnectionInformation {
    private ConnectionInformation.ConnectionMode connectionMode;
    private Long lastFailedConnection;
    private LDFailure lastFailure;
    private Long lastSuccessfulConnection;

    ConnectionInformationState() {
    }

    public ConnectionInformation.ConnectionMode getConnectionMode() {
        return this.connectionMode;
    }

    /* access modifiers changed from: package-private */
    public void setConnectionMode(ConnectionInformation.ConnectionMode connectionMode2) {
        this.connectionMode = connectionMode2;
    }

    public LDFailure getLastFailure() {
        return this.lastFailure;
    }

    /* access modifiers changed from: package-private */
    public void setLastFailure(LDFailure lDFailure) {
        this.lastFailure = lDFailure;
    }

    public Long getLastSuccessfulConnection() {
        return this.lastSuccessfulConnection;
    }

    /* access modifiers changed from: package-private */
    public void setLastSuccessfulConnection(Long l) {
        this.lastSuccessfulConnection = l;
    }

    public Long getLastFailedConnection() {
        return this.lastFailedConnection;
    }

    /* access modifiers changed from: package-private */
    public void setLastFailedConnection(Long l) {
        this.lastFailedConnection = l;
    }
}
