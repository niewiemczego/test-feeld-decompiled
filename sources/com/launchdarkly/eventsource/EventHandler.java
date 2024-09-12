package com.launchdarkly.eventsource;

public interface EventHandler {
    void onClosed() throws Exception;

    void onComment(String str) throws Exception;

    void onError(Throwable th);

    void onMessage(String str, MessageEvent messageEvent) throws Exception;

    void onOpen() throws Exception;
}
