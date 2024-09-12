package org.apache.commons.lang3.concurrent;

import androidx.lifecycle.LifecycleKt$$ExternalSyntheticBackportWithForwarding0;
import java.util.concurrent.atomic.AtomicReference;

public abstract class AtomicInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<T> reference = new AtomicReference<>();

    /* access modifiers changed from: protected */
    public abstract T initialize() throws ConcurrentException;

    public T get() throws ConcurrentException {
        T t = this.reference.get();
        if (t != null) {
            return t;
        }
        T initialize = initialize();
        return !LifecycleKt$$ExternalSyntheticBackportWithForwarding0.m(this.reference, (Object) null, initialize) ? this.reference.get() : initialize;
    }
}
