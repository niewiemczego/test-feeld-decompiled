package com.facebook.bolts;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/facebook/bolts/CancellationToken;", "", "tokenSource", "Lcom/facebook/bolts/CancellationTokenSource;", "(Lcom/facebook/bolts/CancellationTokenSource;)V", "isCancellationRequested", "", "()Z", "register", "Lcom/facebook/bolts/CancellationTokenRegistration;", "action", "Ljava/lang/Runnable;", "throwIfCancellationRequested", "", "toString", "", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CancellationToken.kt */
public final class CancellationToken {
    private final CancellationTokenSource tokenSource;

    public CancellationToken(CancellationTokenSource cancellationTokenSource) {
        Intrinsics.checkNotNullParameter(cancellationTokenSource, "tokenSource");
        this.tokenSource = cancellationTokenSource;
    }

    public final boolean isCancellationRequested() {
        return this.tokenSource.isCancellationRequested();
    }

    public final CancellationTokenRegistration register(Runnable runnable) {
        return this.tokenSource.register$facebook_bolts_release(runnable);
    }

    public final void throwIfCancellationRequested() throws CancellationException {
        this.tokenSource.throwIfCancellationRequested$facebook_bolts_release();
    }

    public String toString() {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%s@%s[cancellationRequested=%s]", Arrays.copyOf(new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(this.tokenSource.isCancellationRequested())}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(locale, format, *args)");
        return format;
    }
}
