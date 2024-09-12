package com.adapty.internal.utils;

import android.webkit.WebSettings;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
/* compiled from: UserAgentRetriever.kt */
final class UserAgentRetriever$retrieveUserAgent$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ UserAgentRetriever this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserAgentRetriever$retrieveUserAgent$1(UserAgentRetriever userAgentRetriever) {
        super(0);
        this.this$0 = userAgentRetriever;
    }

    public final void invoke() {
        try {
            this.this$0.lock.writeLock().lock();
            UserAgentRetriever userAgentRetriever = this.this$0;
            userAgentRetriever.userAgent = WebSettings.getDefaultUserAgent(userAgentRetriever.appContext);
        } catch (Exception unused) {
        } catch (Throwable th) {
            this.this$0.lock.writeLock().unlock();
            throw th;
        }
        this.this$0.lock.writeLock().unlock();
    }
}
