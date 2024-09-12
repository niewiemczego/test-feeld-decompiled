package com.launchdarkly.sdk.internal.events;

import java.io.Closeable;
import java.net.URI;
import java.util.Date;

public interface EventSender extends Closeable {
    Result sendAnalyticsEvents(byte[] bArr, int i, URI uri);

    Result sendDiagnosticEvent(byte[] bArr, URI uri);

    public static final class Result {
        private boolean mustShutDown;
        private boolean success;
        private Date timeFromServer;

        public Result(boolean z, boolean z2, Date date) {
            this.success = z;
            this.mustShutDown = z2;
            this.timeFromServer = date;
        }

        public boolean isSuccess() {
            return this.success;
        }

        public boolean isMustShutDown() {
            return this.mustShutDown;
        }

        public Date getTimeFromServer() {
            return this.timeFromServer;
        }
    }
}
