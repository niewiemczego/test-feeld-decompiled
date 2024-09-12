package org.apache.commons.io.function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda2 implements IOFunction {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ IOFunction f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda2(IOFunction iOFunction, IOFunction iOFunction2) {
        this.f$0 = iOFunction;
        this.f$1 = iOFunction2;
    }

    public final Object apply(Object obj) {
        return this.f$1.apply(this.f$0.apply(obj));
    }
}
