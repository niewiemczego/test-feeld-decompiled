package com.launchdarkly.sdk.android;

public interface ConnectionInformation {
    ConnectionMode getConnectionMode();

    Long getLastFailedConnection();

    LDFailure getLastFailure();

    Long getLastSuccessfulConnection();

    public enum ConnectionMode {
        STREAMING(true),
        POLLING(true),
        BACKGROUND_POLLING(true),
        BACKGROUND_DISABLED(false),
        OFFLINE(false),
        SET_OFFLINE(false),
        SHUTDOWN(false);
        
        private boolean connectionActive;

        private ConnectionMode(boolean z) {
            this.connectionActive = z;
        }

        /* access modifiers changed from: package-private */
        public boolean isConnectionActive() {
            return this.connectionActive;
        }
    }
}
