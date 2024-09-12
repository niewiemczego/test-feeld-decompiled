package io.sentry;

import io.sentry.util.IntegrationUtils;
import io.sentry.util.Objects;
import java.io.Closeable;
import java.io.IOException;

public final class ShutdownHookIntegration implements Integration, Closeable {
    private final Runtime runtime;
    private Thread thread;

    public ShutdownHookIntegration(Runtime runtime2) {
        this.runtime = (Runtime) Objects.requireNonNull(runtime2, "Runtime is required");
    }

    public ShutdownHookIntegration() {
        this(Runtime.getRuntime());
    }

    public void register(IHub iHub, SentryOptions sentryOptions) {
        Objects.requireNonNull(iHub, "Hub is required");
        Objects.requireNonNull(sentryOptions, "SentryOptions is required");
        if (sentryOptions.isEnableShutdownHook()) {
            Thread thread2 = new Thread(new ShutdownHookIntegration$$ExternalSyntheticLambda0(iHub, sentryOptions));
            this.thread = thread2;
            this.runtime.addShutdownHook(thread2);
            sentryOptions.getLogger().log(SentryLevel.DEBUG, "ShutdownHookIntegration installed.", new Object[0]);
            IntegrationUtils.addIntegrationToSdkVersion(getClass());
            return;
        }
        sentryOptions.getLogger().log(SentryLevel.INFO, "enableShutdownHook is disabled.", new Object[0]);
    }

    public void close() throws IOException {
        Thread thread2 = this.thread;
        if (thread2 != null) {
            try {
                this.runtime.removeShutdownHook(thread2);
            } catch (IllegalStateException e) {
                String message = e.getMessage();
                if (message == null || !message.equals("Shutdown in progress")) {
                    throw e;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Thread getHook() {
        return this.thread;
    }
}
