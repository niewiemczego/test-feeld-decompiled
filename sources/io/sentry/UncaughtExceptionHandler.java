package io.sentry;

import java.lang.Thread;

interface UncaughtExceptionHandler {
    Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler();

    void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler);

    public static final class Adapter implements UncaughtExceptionHandler {
        private static final Adapter INSTANCE = new Adapter();

        static UncaughtExceptionHandler getInstance() {
            return INSTANCE;
        }

        private Adapter() {
        }

        public Thread.UncaughtExceptionHandler getDefaultUncaughtExceptionHandler() {
            return Thread.getDefaultUncaughtExceptionHandler();
        }

        public void setDefaultUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
    }
}
