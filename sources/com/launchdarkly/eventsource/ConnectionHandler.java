package com.launchdarkly.eventsource;

interface ConnectionHandler {
    void setLastEventId(String str);

    void setReconnectTimeMillis(long j);
}
