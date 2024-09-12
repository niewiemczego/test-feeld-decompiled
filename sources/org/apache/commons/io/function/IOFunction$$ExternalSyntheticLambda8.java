package org.apache.commons.io.function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda8 implements IOConsumer {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOConsumer f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda8(IOFunction iOFunction, IOConsumer iOConsumer) {
        this.f$0 = iOFunction;
        this.f$1 = iOConsumer;
    }

    public final void accept(Object obj) {
        this.f$1.accept(this.f$0.apply(obj));
    }
}
