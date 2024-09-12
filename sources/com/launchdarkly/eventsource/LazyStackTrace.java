package com.launchdarkly.eventsource;

import java.io.PrintWriter;
import java.io.StringWriter;

final class LazyStackTrace {
    private final Throwable throwable;

    LazyStackTrace(Throwable th) {
        this.throwable = th;
    }

    public String toString() {
        StringWriter stringWriter = new StringWriter();
        this.throwable.printStackTrace(new PrintWriter(stringWriter));
        return stringWriter.toString();
    }
}
