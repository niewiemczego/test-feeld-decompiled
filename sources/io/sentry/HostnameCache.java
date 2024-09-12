package io.sentry;

import io.sentry.util.Objects;
import java.net.InetAddress;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;

final class HostnameCache {
    private static final long GET_HOSTNAME_TIMEOUT = TimeUnit.SECONDS.toMillis(1);
    private static final long HOSTNAME_CACHE_DURATION = TimeUnit.HOURS.toMillis(5);
    private static HostnameCache INSTANCE;
    private final long cacheDuration;
    private final ExecutorService executorService;
    private volatile long expirationTimestamp;
    private final Callable<InetAddress> getLocalhost;
    private volatile String hostname;
    private final AtomicBoolean updateRunning;

    static HostnameCache getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new HostnameCache();
        }
        return INSTANCE;
    }

    private HostnameCache() {
        this(HOSTNAME_CACHE_DURATION);
    }

    HostnameCache(long j) {
        this(j, new HostnameCache$$ExternalSyntheticLambda0());
    }

    HostnameCache(long j, Callable<InetAddress> callable) {
        this.updateRunning = new AtomicBoolean(false);
        this.executorService = Executors.newSingleThreadExecutor(new HostnameCacheThreadFactory());
        this.cacheDuration = j;
        this.getLocalhost = (Callable) Objects.requireNonNull(callable, "getLocalhost is required");
        updateCache();
    }

    /* access modifiers changed from: package-private */
    public void close() {
        this.executorService.shutdown();
    }

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.executorService.isShutdown();
    }

    /* access modifiers changed from: package-private */
    public String getHostname() {
        if (this.expirationTimestamp < System.currentTimeMillis() && this.updateRunning.compareAndSet(false, true)) {
            updateCache();
        }
        return this.hostname;
    }

    private void updateCache() {
        try {
            this.executorService.submit(new HostnameCache$$ExternalSyntheticLambda1(this)).get(GET_HOSTNAME_TIMEOUT, TimeUnit.MILLISECONDS);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            handleCacheUpdateFailure();
        } catch (RuntimeException | ExecutionException | TimeoutException unused2) {
            handleCacheUpdateFailure();
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateCache$1$io-sentry-HostnameCache  reason: not valid java name */
    public /* synthetic */ Void m871lambda$updateCache$1$iosentryHostnameCache() throws Exception {
        try {
            this.hostname = this.getLocalhost.call().getCanonicalHostName();
            this.expirationTimestamp = System.currentTimeMillis() + this.cacheDuration;
            this.updateRunning.set(false);
            return null;
        } catch (Throwable th) {
            this.updateRunning.set(false);
            throw th;
        }
    }

    private void handleCacheUpdateFailure() {
        this.expirationTimestamp = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(1);
    }

    private static final class HostnameCacheThreadFactory implements ThreadFactory {
        private int cnt;

        private HostnameCacheThreadFactory() {
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder append = new StringBuilder().append("SentryHostnameCache-");
            int i = this.cnt;
            this.cnt = i + 1;
            Thread thread = new Thread(runnable, append.append(i).toString());
            thread.setDaemon(true);
            return thread;
        }
    }
}
