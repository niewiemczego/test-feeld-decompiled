package com.launchdarkly.sdk.internal.events;

public interface EventProcessor {
    void flushAsync();

    void flushBlocking();

    void sendEvent(Event event);

    void setInBackground(boolean z);

    void setOffline(boolean z);
}
