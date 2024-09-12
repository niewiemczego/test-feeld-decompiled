package com.launchdarkly.eventsource;

public class UnsuccessfulResponseException extends Exception {
    private final int code;

    public UnsuccessfulResponseException(int i) {
        super("Unsuccessful response code received from stream: " + i);
        this.code = i;
    }

    public int getCode() {
        return this.code;
    }
}
