package org.apache.commons.io.function;

import java.util.function.Function;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class IOFunction$$ExternalSyntheticLambda6 implements IOFunction {
    public final /* synthetic */ IOFunction f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ IOFunction$$ExternalSyntheticLambda6(IOFunction iOFunction, Function function) {
        this.f$0 = iOFunction;
        this.f$1 = function;
    }

    public final Object apply(Object obj) {
        return this.f$0.apply(this.f$1.apply(obj));
    }
}
