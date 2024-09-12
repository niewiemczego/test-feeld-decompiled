package com.google.common.base;

import java.lang.ref.WeakReference;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public abstract class FinalizableWeakReference<T> extends WeakReference<T> implements FinalizableReference {
    protected FinalizableWeakReference(@CheckForNull T t, FinalizableReferenceQueue finalizableReferenceQueue) {
        super(t, finalizableReferenceQueue.queue);
        finalizableReferenceQueue.cleanUp();
    }
}
