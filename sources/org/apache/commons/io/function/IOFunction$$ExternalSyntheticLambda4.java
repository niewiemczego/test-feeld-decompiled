package org.apache.commons.io.function;

import java.util.function.Consumer;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda4 implements IOConsumer {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Consumer f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda4(IOFunction iOFunction, Consumer consumer) {
        this.f$0 = iOFunction;
        this.f$1 = consumer;
    }

    public final void accept(Object obj) {
        this.f$1.accept(this.f$0.apply(obj));
    }
}
