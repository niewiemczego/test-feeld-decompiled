package io.invertase.firebase.common;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ReactNativeFirebaseEventEmitter f$0;

    public /* synthetic */ ReactNativeFirebaseEventEmitter$$ExternalSyntheticLambda0(ReactNativeFirebaseEventEmitter reactNativeFirebaseEventEmitter) {
        this.f$0 = reactNativeFirebaseEventEmitter;
    }

    public final void run() {
        this.f$0.sendQueuedEvents();
    }
}
