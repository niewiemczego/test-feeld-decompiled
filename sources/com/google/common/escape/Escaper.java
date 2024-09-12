package com.google.common.escape;

import com.google.common.base.Function;
import com.google.errorprone.annotations.DoNotMock;

@ElementTypesAreNonnullByDefault
@DoNotMock("Use Escapers.nullEscaper() or another methods from the *Escapers classes")
public abstract class Escaper {
    private final Function<String, String> asFunction = new Escaper$$ExternalSyntheticLambda0(this);

    public abstract String escape(String str);

    protected Escaper() {
    }

    public final Function<String, String> asFunction() {
        return this.asFunction;
    }
}
