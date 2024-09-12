package org.apache.commons.io.function;

import java.util.function.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda0 implements IOSupplier {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Supplier f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda0(IOFunction iOFunction, Supplier supplier) {
        this.f$0 = iOFunction;
        this.f$1 = supplier;
    }

    public final Object get() {
        return this.f$0.apply(this.f$1.get());
    }
}
