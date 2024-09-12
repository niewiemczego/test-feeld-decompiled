package androidx.browser.trusted;

import android.net.Uri;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class TrustedWebActivityServiceConnectionPool$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ TrustedWebActivityServiceConnectionPool f$0;
    public final /* synthetic */ Uri f$1;

    public /* synthetic */ TrustedWebActivityServiceConnectionPool$$ExternalSyntheticLambda0(TrustedWebActivityServiceConnectionPool trustedWebActivityServiceConnectionPool, Uri uri) {
        this.f$0 = trustedWebActivityServiceConnectionPool;
        this.f$1 = uri;
    }

    public final void run() {
        this.f$0.m10lambda$connect$0$androidxbrowsertrustedTrustedWebActivityServiceConnectionPool(this.f$1);
    }
}
