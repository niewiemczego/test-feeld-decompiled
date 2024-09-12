package com.launchdarkly.logging;

import java.io.PrintWriter;
import java.io.StringWriter;

public abstract class LogValues {

    public interface StringProvider {
        String get();
    }

    public static Object exceptionSummary(Throwable th) {
        return th;
    }

    private LogValues() {
    }

    public static Object defer(StringProvider stringProvider) {
        return new DeferImpl(stringProvider);
    }

    public static Object exceptionTrace(final Throwable th) {
        if (th == null) {
            return null;
        }
        return defer(new StringProvider() {
            public String get() {
                StringWriter stringWriter = new StringWriter();
                th.printStackTrace(new PrintWriter(stringWriter));
                return stringWriter.toString();
            }
        });
    }

    private static final class DeferImpl {
        private final StringProvider stringProvider;

        DeferImpl(StringProvider stringProvider2) {
            this.stringProvider = stringProvider2;
        }

        public String toString() {
            return this.stringProvider.get();
        }
    }
}
