package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f$0;
    public final /* synthetic */ Callback f$1;
    public final /* synthetic */ Response f$2;

    public /* synthetic */ DefaultCallAdapterFactory$ExecutorCallbackCall$1$$ExternalSyntheticLambda0(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r1, Callback callback, Response response) {
        this.f$0 = r1;
        this.f$1 = callback;
        this.f$2 = response;
    }

    public final void run() {
        this.f$0.m2746lambda$onResponse$0$retrofit2DefaultCallAdapterFactory$ExecutorCallbackCall$1(this.f$1, this.f$2);
    }
}
