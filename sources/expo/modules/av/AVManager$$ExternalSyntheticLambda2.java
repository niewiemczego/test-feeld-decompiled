package expo.modules.av;

import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AVManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ AVManager f$0;
    public final /* synthetic */ Integer f$1;
    public final /* synthetic */ Promise f$2;
    public final /* synthetic */ ReadableArguments f$3;

    public /* synthetic */ AVManager$$ExternalSyntheticLambda2(AVManager aVManager, Integer num, Promise promise, ReadableArguments readableArguments) {
        this.f$0 = aVManager;
        this.f$1 = num;
        this.f$2 = promise;
        this.f$3 = readableArguments;
    }

    public final void run() {
        this.f$0.m707lambda$setStatusForSound$3$expomodulesavAVManager(this.f$1, this.f$2, this.f$3);
    }
}
