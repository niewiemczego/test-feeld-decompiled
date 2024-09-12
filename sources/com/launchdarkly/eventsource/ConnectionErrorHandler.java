package com.launchdarkly.eventsource;

public interface ConnectionErrorHandler {
    public static final ConnectionErrorHandler DEFAULT = new ConnectionErrorHandler() {
        public Action onConnectionError(Throwable th) {
            return Action.PROCEED;
        }
    };

    public enum Action {
        PROCEED,
        SHUTDOWN
    }

    Action onConnectionError(Throwable th);
}
