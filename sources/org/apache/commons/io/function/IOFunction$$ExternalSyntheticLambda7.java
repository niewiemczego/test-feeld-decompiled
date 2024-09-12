package org.apache.commons.io.function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda7 implements IOSupplier {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOSupplier f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda7(IOFunction iOFunction, IOSupplier iOSupplier) {
        this.f$0 = iOFunction;
        this.f$1 = iOSupplier;
    }

    public final Object get() {
        return this.f$0.apply(this.f$1.get());
    }
}
