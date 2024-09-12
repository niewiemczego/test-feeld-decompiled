package com.adapty.internal.utils;

import android.content.Context;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8F@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/utils/UserAgentRetriever;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "<set-?>", "", "userAgent", "getUserAgent", "()Ljava/lang/String;", "retrieveUserAgent", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: UserAgentRetriever.kt */
public final class UserAgentRetriever {
    /* access modifiers changed from: private */
    public final Context appContext;
    /* access modifiers changed from: private */
    public final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    /* access modifiers changed from: private */
    public volatile String userAgent;

    public UserAgentRetriever(Context context) {
        Intrinsics.checkNotNullParameter(context, "appContext");
        this.appContext = context;
        retrieveUserAgent();
    }

    public final String getUserAgent() {
        try {
            this.lock.readLock().lock();
            return this.userAgent;
        } finally {
            this.lock.readLock().unlock();
        }
    }

    private final void retrieveUserAgent() {
        ThreadsKt.thread$default(false, false, (ClassLoader) null, (String) null, 0, new UserAgentRetriever$retrieveUserAgent$1(this), 31, (Object) null);
    }
}
