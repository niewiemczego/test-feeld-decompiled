package com.launchdarkly.sdk.json;

public class SerializationException extends Exception {
    public SerializationException(Throwable th) {
        super(th);
    }

    public SerializationException(String str) {
        super(str);
    }
}
