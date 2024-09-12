package io.sentry.cache;

import io.sentry.Breadcrumb;
import io.sentry.JsonDeserializer;
import io.sentry.ScopeObserverAdapter;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.SpanContext;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.Map;

public final class PersistingScopeObserver extends ScopeObserverAdapter {
    public static final String BREADCRUMBS_FILENAME = "breadcrumbs.json";
    public static final String CONTEXTS_FILENAME = "contexts.json";
    public static final String EXTRAS_FILENAME = "extras.json";
    public static final String FINGERPRINT_FILENAME = "fingerprint.json";
    public static final String LEVEL_FILENAME = "level.json";
    public static final String REQUEST_FILENAME = "request.json";
    public static final String SCOPE_CACHE = ".scope-cache";
    public static final String TAGS_FILENAME = "tags.json";
    public static final String TRACE_FILENAME = "trace.json";
    public static final String TRANSACTION_FILENAME = "transaction.json";
    public static final String USER_FILENAME = "user.json";
    private final SentryOptions options;

    public PersistingScopeObserver(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public void setUser(User user) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda9(this, user));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setUser$0$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m924lambda$setUser$0$iosentrycachePersistingScopeObserver(User user) {
        if (user == null) {
            delete(USER_FILENAME);
        } else {
            store(user, USER_FILENAME);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setBreadcrumbs$1$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m915lambda$setBreadcrumbs$1$iosentrycachePersistingScopeObserver(Collection collection) {
        store(collection, BREADCRUMBS_FILENAME);
    }

    public void setBreadcrumbs(Collection<Breadcrumb> collection) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda10(this, collection));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setTags$2$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m921lambda$setTags$2$iosentrycachePersistingScopeObserver(Map map) {
        store(map, "tags.json");
    }

    public void setTags(Map<String, String> map) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda3(this, map));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setExtras$3$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m917lambda$setExtras$3$iosentrycachePersistingScopeObserver(Map map) {
        store(map, EXTRAS_FILENAME);
    }

    public void setExtras(Map<String, Object> map) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda2(this, map));
    }

    public void setRequest(Request request) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda6(this, request));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setRequest$4$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m920lambda$setRequest$4$iosentrycachePersistingScopeObserver(Request request) {
        if (request == null) {
            delete(REQUEST_FILENAME);
        } else {
            store(request, REQUEST_FILENAME);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setFingerprint$5$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m918lambda$setFingerprint$5$iosentrycachePersistingScopeObserver(Collection collection) {
        store(collection, FINGERPRINT_FILENAME);
    }

    public void setFingerprint(Collection<String> collection) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda5(this, collection));
    }

    public void setLevel(SentryLevel sentryLevel) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda0(this, sentryLevel));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setLevel$6$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m919lambda$setLevel$6$iosentrycachePersistingScopeObserver(SentryLevel sentryLevel) {
        if (sentryLevel == null) {
            delete(LEVEL_FILENAME);
        } else {
            store(sentryLevel, LEVEL_FILENAME);
        }
    }

    public void setTransaction(String str) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda1(this, str));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setTransaction$7$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m923lambda$setTransaction$7$iosentrycachePersistingScopeObserver(String str) {
        if (str == null) {
            delete(TRANSACTION_FILENAME);
        } else {
            store(str, TRANSACTION_FILENAME);
        }
    }

    public void setTrace(SpanContext spanContext) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda7(this, spanContext));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setTrace$8$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m922lambda$setTrace$8$iosentrycachePersistingScopeObserver(SpanContext spanContext) {
        if (spanContext == null) {
            delete(TRACE_FILENAME);
        } else {
            store(spanContext, TRACE_FILENAME);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$setContexts$9$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m916lambda$setContexts$9$iosentrycachePersistingScopeObserver(Contexts contexts) {
        store(contexts, CONTEXTS_FILENAME);
    }

    public void setContexts(Contexts contexts) {
        serializeToDisk(new PersistingScopeObserver$$ExternalSyntheticLambda8(this, contexts));
    }

    private void serializeToDisk(Runnable runnable) {
        try {
            this.options.getExecutorService().submit((Runnable) new PersistingScopeObserver$$ExternalSyntheticLambda4(this, runnable));
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Serialization task could not be scheduled", th);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$serializeToDisk$10$io-sentry-cache-PersistingScopeObserver  reason: not valid java name */
    public /* synthetic */ void m914lambda$serializeToDisk$10$iosentrycachePersistingScopeObserver(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "Serialization task failed", th);
        }
    }

    private <T> void store(T t, String str) {
        CacheUtils.store(this.options, t, SCOPE_CACHE, str);
    }

    private void delete(String str) {
        CacheUtils.delete(this.options, SCOPE_CACHE, str);
    }

    public static <T> T read(SentryOptions sentryOptions, String str, Class<T> cls) {
        return read(sentryOptions, str, cls, (JsonDeserializer) null);
    }

    /* JADX WARNING: type inference failed for: r4v0, types: [io.sentry.JsonDeserializer, io.sentry.JsonDeserializer<R>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static <T, R> T read(io.sentry.SentryOptions r1, java.lang.String r2, java.lang.Class<T> r3, io.sentry.JsonDeserializer<R> r4) {
        /*
            java.lang.String r0 = ".scope-cache"
            java.lang.Object r1 = io.sentry.cache.CacheUtils.read(r1, r0, r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.cache.PersistingScopeObserver.read(io.sentry.SentryOptions, java.lang.String, java.lang.Class, io.sentry.JsonDeserializer):java.lang.Object");
    }
}
