package okhttp3.internal;

import java.util.concurrent.ThreadFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Util$$ExternalSyntheticLambda0 implements ThreadFactory {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ Util$$ExternalSyntheticLambda0(String str, boolean z) {
        this.f$0 = str;
        this.f$1 = z;
    }

    public final Thread newThread(Runnable runnable) {
        return Util.m2720threadFactory$lambda1(this.f$0, this.f$1, runnable);
    }
}
