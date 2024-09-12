package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Deprecated
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    public ComputationException(@CheckForNull Throwable th) {
        super(th);
    }
}
