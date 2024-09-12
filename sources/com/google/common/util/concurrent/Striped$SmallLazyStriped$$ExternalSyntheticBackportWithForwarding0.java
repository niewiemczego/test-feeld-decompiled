package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class Striped$SmallLazyStriped$$ExternalSyntheticBackportWithForwarding0 {
    public static /* synthetic */ boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}