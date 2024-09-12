package io.sentry.transport;

public final class CurrentDateProvider implements ICurrentDateProvider {
    private static final ICurrentDateProvider instance = new CurrentDateProvider();

    public static ICurrentDateProvider getInstance() {
        return instance;
    }

    private CurrentDateProvider() {
    }

    public final long getCurrentTimeMillis() {
        return System.currentTimeMillis();
    }
}
