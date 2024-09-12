package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ Throwable f$2;

    public /* synthetic */ DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda1(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Throwable th) {
        this.f$0 = r1;
        this.f$1 = callback;
        this.f$2 = th;
    }

    public final void run() {
        this.f$0.m2745lambda$onFailure$1$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
    }
}
